package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.junit.Test;
import org.mockito.Mockito;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.exceptions.ProcessingException;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.TextFieldNode;

public class TextFieldDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TextField#TextField(Element, FormatEnum)}
   *   <li>{@link TextField#getElementId()}
   *   <li>{@link TextField#getElementType()}
   *   <li>{@link TextField#getMaxValueAllowed()}
   *   <li>{@link TextField#getMinValueAllowed()}
   *   <li>{@link TextField#getPresentationMLTag()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    TextField actualTextField = new TextField(parent, FormatEnum.MESSAGEML);
    String actualElementId = actualTextField.getElementId();
    String actualElementType = actualTextField.getElementType();
    Integer actualMaxValueAllowed = actualTextField.getMaxValueAllowed();
    Integer actualMinValueAllowed = actualTextField.getMinValueAllowed();
    String actualPresentationMLTag = actualTextField.getPresentationMLTag();

    // Assert
    assertEquals(1, actualMinValueAllowed.intValue());
    assertEquals(128, actualMaxValueAllowed.intValue());
    assertEquals(FormatEnum.MESSAGEML, actualTextField.getFormat());
    assertTrue(actualTextField.getChildren().isEmpty());
    assertTrue(actualTextField.getAttributes().isEmpty());
    assertEquals(FormElement.INPUT_TAG, actualPresentationMLTag);
    assertEquals(TextField.ELEMENT_ID, actualElementId);
    assertEquals(TextField.MESSAGEML_TAG, actualTextField.getMessageMLTag());
    assertEquals(TextField.MESSAGEML_TAG, actualElementType);
    assertSame(parent, actualTextField.getParent());
  }

  /**
   * Test {@link TextField#buildAll(MessageMLParser, Element)}.
   * <p>
   * Method under test:
   * {@link TextField#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll() throws InvalidInputException, ProcessingException {
    // Arrange
    TextField textField = new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.PRESENTATIONML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    textField.buildAll(parser, new IIOMetadataNode("foo"));

    // Assert that nothing has changed
    assertEquals(0, textField.size());
    Map<String, String> otherAttributes = textField.getOtherAttributes();
    assertEquals(2, otherAttributes.size());
    assertTrue(textField.getChildren().isEmpty());
    assertTrue(otherAttributes.containsKey("name"));
    assertTrue(otherAttributes.containsKey(Entity.TYPE_FIELD));
  }

  /**
   * Test {@link TextField#buildAll(MessageMLParser, Element)}.
   * <p>
   * Method under test:
   * {@link TextField#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll2() throws InvalidInputException, ProcessingException {
    // Arrange
    TextField textField = new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    Bold child = new Bold(new BulletList(mock(Element.class)));
    textField.addChild(child);
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(new BiContext());

    // Act
    textField.buildAll(parser, new IIOMetadataNode("foo"));

    // Assert that nothing has changed
    verify(parser).getBiContext();
    Map<String, String> otherAttributes = textField.getOtherAttributes();
    assertEquals(3, otherAttributes.size());
    assertEquals("", otherAttributes.get(Entity.VALUE_FIELD));
    List<Element> children = textField.getChildren();
    assertEquals(1, children.size());
    assertEquals(1, textField.size());
    assertTrue(otherAttributes.containsKey("name"));
    assertTrue(otherAttributes.containsKey(Entity.TYPE_FIELD));
    assertSame(child, children.get(0));
  }

  /**
   * Test {@link TextField#buildAll(MessageMLParser, Element)}.
   * <ul>
   *   <li>Then {@link TextField#TextField(Element, FormatEnum)} with parent is
   * {@link Bold#Bold(Element)} and messageFormat is {@code MESSAGEML} size is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TextField#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll_thenTextFieldWithParentIsBoldAndMessageFormatIsMessagemlSizeIsZero()
      throws InvalidInputException, ProcessingException {
    // Arrange
    TextField textField = new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(new BiContext());

    // Act
    textField.buildAll(parser, new IIOMetadataNode("foo"));

    // Assert that nothing has changed
    verify(parser).getBiContext();
    assertEquals(0, textField.size());
    Map<String, String> otherAttributes = textField.getOtherAttributes();
    assertEquals(2, otherAttributes.size());
    assertTrue(textField.getChildren().isEmpty());
    assertTrue(otherAttributes.containsKey("name"));
    assertTrue(otherAttributes.containsKey(Entity.TYPE_FIELD));
  }

  /**
   * Test {@link TextField#buildAll(MessageMLParser, Element)}.
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TextField#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll_thenThrowInvalidInputException() throws InvalidInputException, ProcessingException {
    // Arrange
    TextField textField = new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.PRESENTATIONML);
    MessageMLParser parser = mock(MessageMLParser.class);

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode(MessageML.MESSAGEML_TAG));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> textField.buildAll(parser, element));
  }

  /**
   * Test {@link TextField#buildAll(MessageMLParser, Element)}.
   * <ul>
   *   <li>When {@link MessageMLParser}
   * {@link MessageMLParser#createElement(Element, Element)} return
   * {@link Bold#Bold(Element)} with parent is
   * {@link BulletList#BulletList(Element)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TextField#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll_whenMessageMLParserCreateElementReturnBoldWithParentIsBulletList()
      throws InvalidInputException, ProcessingException {
    // Arrange
    TextField textField = new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any())).thenReturn(bold);
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode(MessageML.MESSAGEML_TAG));

    // Act
    textField.buildAll(parser, element);

    // Assert
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
    verify(parser, atLeast(1)).getBiContext();
    Map<String, String> otherAttributes = textField.getOtherAttributes();
    assertEquals(3, otherAttributes.size());
    assertEquals("", otherAttributes.get(Entity.VALUE_FIELD));
    List<Element> children = textField.getChildren();
    assertEquals(1, children.size());
    assertEquals(1, textField.size());
    assertTrue(otherAttributes.containsKey("name"));
    assertTrue(otherAttributes.containsKey(Entity.TYPE_FIELD));
    assertSame(bold, children.get(0));
  }

  /**
   * Test {@link TextField#buildAll(MessageMLParser, Element)}.
   * <ul>
   *   <li>When {@link MessageMLParser}
   * {@link MessageMLParser#createElement(Element, Element)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TextField#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll_whenMessageMLParserCreateElementReturnNull()
      throws InvalidInputException, ProcessingException {
    // Arrange
    TextField textField = new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any())).thenReturn(null);
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode(MessageML.MESSAGEML_TAG));

    // Act
    textField.buildAll(parser, element);

    // Assert that nothing has changed
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
    verify(parser).getBiContext();
    assertEquals(0, textField.size());
    Map<String, String> otherAttributes = textField.getOtherAttributes();
    assertEquals(2, otherAttributes.size());
    assertTrue(textField.getChildren().isEmpty());
    assertTrue(otherAttributes.containsKey("name"));
    assertTrue(otherAttributes.containsKey(Entity.TYPE_FIELD));
  }

  /**
   * Test {@link TextField#asMarkdown()}.
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is
   * {@link BulletList#BulletList(Element)} addChild {@link Bold#Bold(Element)}
   * with parent is {@link BulletList#BulletList(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextField#asMarkdown()}
   */
  @Test
  public void testAsMarkdown_givenBoldWithParentIsBulletListAddChildBoldWithParentIsBulletList() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    TextField textField = new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    textField.addChild(child);

    // Act
    Node actualAsMarkdownResult = textField.asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof TextFieldNode);
    assertEquals("(Text Field", ((TextFieldNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals(")", ((TextFieldNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals(":", ((TextFieldNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link TextField#asMarkdown()}.
   * <ul>
   *   <li>Then return Text is {@code :}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextField#asMarkdown()}
   */
  @Test
  public void testAsMarkdown_thenReturnTextIsColon() {
    // Arrange
    TextField textField = new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    textField.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act
    Node actualAsMarkdownResult = textField.asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof TextFieldNode);
    assertEquals("(Text Field", ((TextFieldNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals(")", ((TextFieldNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals(":", ((TextFieldNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link TextField#asMarkdown()}.
   * <ul>
   *   <li>Then return Text is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextField#asMarkdown()}
   */
  @Test
  public void testAsMarkdown_thenReturnTextIsEmptyString() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof TextFieldNode);
    assertEquals("", ((TextFieldNode) actualAsMarkdownResult).getText());
    assertEquals("(Text Field", ((TextFieldNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals(")", ((TextFieldNode) actualAsMarkdownResult).getClosingDelimiter());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link TextField#asMarkdown()}.
   * <ul>
   *   <li>Then return Text is {@code :$null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextField#asMarkdown()}
   */
  @Test
  public void testAsMarkdown_thenReturnTextIsNull() {
    // Arrange
    TextField textField = new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    textField.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));

    // Act
    Node actualAsMarkdownResult = textField.asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof TextFieldNode);
    assertEquals("(Text Field", ((TextFieldNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals(")", ((TextFieldNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals(":$null", ((TextFieldNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link TextField#getOtherAttributes()}.
   * <p>
   * Method under test: {@link TextField#getOtherAttributes()}
   */
  @Test
  public void testGetOtherAttributes() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    TextField textField = new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    textField.addChild(child);

    // Act
    Map<String, String> actualOtherAttributes = textField.getOtherAttributes();

    // Assert
    assertEquals(3, actualOtherAttributes.size());
    assertEquals("", actualOtherAttributes.get(Entity.VALUE_FIELD));
    assertNull(actualOtherAttributes.get("name"));
    assertEquals(TextField.PRESENTATIONML_INPUT_TYPE, actualOtherAttributes.get(Entity.TYPE_FIELD));
  }

  /**
   * Test {@link TextField#getOtherAttributes()}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextField#getOtherAttributes()}
   */
  @Test
  public void testGetOtherAttributes_thenReturnSizeIsTwo() {
    // Arrange and Act
    Map<String, String> actualOtherAttributes = (new TextField(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML)).getOtherAttributes();

    // Assert
    assertEquals(2, actualOtherAttributes.size());
    assertNull(actualOtherAttributes.get("name"));
    assertEquals(TextField.PRESENTATIONML_INPUT_TYPE, actualOtherAttributes.get(Entity.TYPE_FIELD));
  }

  /**
   * Test {@link TextField#getOtherAttributes()}.
   * <ul>
   *   <li>Then return {@link Entity#VALUE_FIELD} is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextField#getOtherAttributes()}
   */
  @Test
  public void testGetOtherAttributes_thenReturnValue_fieldIsEmptyString() {
    // Arrange
    TextField textField = new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    textField.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act
    Map<String, String> actualOtherAttributes = textField.getOtherAttributes();

    // Assert
    assertEquals(3, actualOtherAttributes.size());
    assertEquals("", actualOtherAttributes.get(Entity.VALUE_FIELD));
    assertNull(actualOtherAttributes.get("name"));
    assertEquals(TextField.PRESENTATIONML_INPUT_TYPE, actualOtherAttributes.get(Entity.TYPE_FIELD));
  }

  /**
   * Test {@link TextField#getOtherAttributes()}.
   * <ul>
   *   <li>Then return {@link Entity#VALUE_FIELD} is {@code $null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextField#getOtherAttributes()}
   */
  @Test
  public void testGetOtherAttributes_thenReturnValue_fieldIsNull() {
    // Arrange
    TextField textField = new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    textField.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));

    // Act
    Map<String, String> actualOtherAttributes = textField.getOtherAttributes();

    // Assert
    assertEquals(3, actualOtherAttributes.size());
    assertEquals("$null", actualOtherAttributes.get(Entity.VALUE_FIELD));
    assertNull(actualOtherAttributes.get("name"));
    assertEquals(TextField.PRESENTATIONML_INPUT_TYPE, actualOtherAttributes.get(Entity.TYPE_FIELD));
  }

  /**
   * Test {@link TextField#updateBiContext(BiContext)}.
   * <p>
   * Method under test: {@link TextField#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    TextField textField = new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    textField.addChild(new Bold(new BulletList(mock(Element.class))));
    BiContext context = new BiContext();

    // Act
    textField.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertTrue(getResult.getAttributes().isEmpty());
    assertEquals(TextField.ELEMENT_ID, getResult.getName());
  }

  /**
   * Test {@link TextField#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextField#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsSizeIsOne() {
    // Arrange
    TextField textField = new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    textField.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertTrue(getResult.getAttributes().isEmpty());
    assertEquals(TextField.ELEMENT_ID, getResult.getName());
  }

  /**
   * Test {@link TextField#areNestedElementsAllowed()}.
   * <p>
   * Method under test: {@link TextField#areNestedElementsAllowed()}
   */
  @Test
  public void testAreNestedElementsAllowed() {
    // Arrange, Act and Assert
    assertFalse((new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .areNestedElementsAllowed());
  }

  /**
   * Test {@link TextField#hasElementInitialValue()}.
   * <p>
   * Method under test: {@link TextField#hasElementInitialValue()}
   */
  @Test
  public void testHasElementInitialValue() {
    // Arrange, Act and Assert
    assertFalse(
        (new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).hasElementInitialValue());
  }

  /**
   * Test {@link TextField#hasElementInitialValue()}.
   * <p>
   * Method under test: {@link TextField#hasElementInitialValue()}
   */
  @Test
  public void testHasElementInitialValue2() {
    // Arrange
    TextField textField = new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    textField.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertFalse(textField.hasElementInitialValue());
  }

  /**
   * Test {@link TextField#getAttributeValue(String)}.
   * <p>
   * Method under test: {@link TextField#getAttributeValue(String)}
   */
  @Test
  public void testGetAttributeValue() {
    // Arrange, Act and Assert
    assertNull((new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .getAttributeValue("Attribute Name"));
  }
}
