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
   * Method under test:
   * {@link TextField#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll() throws InvalidInputException, ProcessingException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TextField textField = new TextField(parent, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(new BiContext());

    // Act
    textField.buildAll(parser, new IIOMetadataNode("foo"));

    // Assert
    verify(parser).getBiContext();
    assertEquals(0, textField.size());
    Map<String, String> otherAttributes = textField.getOtherAttributes();
    assertEquals(2, otherAttributes.size());
    assertTrue(textField.getChildren().isEmpty());
    assertTrue(otherAttributes.containsKey("name"));
    assertTrue(otherAttributes.containsKey(Entity.TYPE_FIELD));
    assertSame(parent, textField.getParent());
  }

  /**
   * Method under test:
   * {@link TextField#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll2() throws InvalidInputException, ProcessingException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    TextField textField = new TextField(parent, FormatEnum.MESSAGEML);
    Bold child = new Bold(new BulletList(mock(Element.class)));
    textField.addChild(child);
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(new BiContext());

    // Act
    textField.buildAll(parser, new IIOMetadataNode("foo"));

    // Assert
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
    assertSame(parent, textField.getParent());
  }

  /**
   * Method under test:
   * {@link TextField#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll3() throws InvalidInputException, ProcessingException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TextField textField = new TextField(parent, FormatEnum.MESSAGEML);
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
    assertSame(parent, textField.getParent());
  }

  /**
   * Method under test:
   * {@link TextField#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll4() throws InvalidInputException, ProcessingException {
    // Arrange
    TextField textField = new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.PRESENTATIONML);
    MessageMLParser parser = mock(MessageMLParser.class);

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode(MessageML.MESSAGEML_TAG));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> textField.buildAll(parser, element));
  }

  /**
   * Method under test:
   * {@link TextField#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll5() throws InvalidInputException, ProcessingException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TextField textField = new TextField(parent, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any())).thenReturn(null);
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode(MessageML.MESSAGEML_TAG));

    // Act
    textField.buildAll(parser, element);

    // Assert
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
    verify(parser).getBiContext();
    assertEquals(0, textField.size());
    Map<String, String> otherAttributes = textField.getOtherAttributes();
    assertEquals(2, otherAttributes.size());
    assertTrue(textField.getChildren().isEmpty());
    assertTrue(otherAttributes.containsKey("name"));
    assertTrue(otherAttributes.containsKey(Entity.TYPE_FIELD));
    assertSame(parent, textField.getParent());
  }

  /**
   * Method under test: {@link TextField#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
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
   * Method under test: {@link TextField#asMarkdown()}
   */
  @Test
  public void testAsMarkdown2() {
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
   * Method under test: {@link TextField#asMarkdown()}
   */
  @Test
  public void testAsMarkdown3() {
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
   * Method under test: {@link TextField#asMarkdown()}
   */
  @Test
  public void testAsMarkdown4() {
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
   * Method under test: {@link TextField#getOtherAttributes()}
   */
  @Test
  public void testGetOtherAttributes() {
    // Arrange and Act
    Map<String, String> actualOtherAttributes = (new TextField(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML)).getOtherAttributes();

    // Assert
    assertEquals(2, actualOtherAttributes.size());
    assertNull(actualOtherAttributes.get("name"));
    assertEquals(TextField.PRESENTATIONML_INPUT_TYPE, actualOtherAttributes.get(Entity.TYPE_FIELD));
  }

  /**
   * Method under test: {@link TextField#getOtherAttributes()}
   */
  @Test
  public void testGetOtherAttributes2() {
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
   * Method under test: {@link TextField#getOtherAttributes()}
   */
  @Test
  public void testGetOtherAttributes3() {
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
   * Method under test: {@link TextField#getOtherAttributes()}
   */
  @Test
  public void testGetOtherAttributes4() {
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
   * Method under test: {@link TextField#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TextField textField = new TextField(parent, FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    textField.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    assertTrue(textField.getChildren().isEmpty());
    BiItem getResult = items.get(0);
    assertTrue(getResult.getAttributes().isEmpty());
    assertTrue(textField.getAttributes().isEmpty());
    assertTrue(textField.getRegexAttrForPresentationML().isEmpty());
    assertEquals(TextField.ELEMENT_ID, getResult.getName());
    assertSame(parent, textField.getParent());
  }

  /**
   * Method under test: {@link TextField#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    TextField textField = new TextField(parent, FormatEnum.MESSAGEML);
    Bold child = new Bold(new BulletList(mock(Element.class)));
    textField.addChild(child);
    BiContext context = new BiContext();

    // Act
    textField.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    List<Element> children = textField.getChildren();
    assertEquals(1, children.size());
    BiItem getResult = items.get(0);
    assertTrue(getResult.getAttributes().isEmpty());
    assertTrue(textField.getAttributes().isEmpty());
    assertTrue(textField.getRegexAttrForPresentationML().isEmpty());
    assertEquals(TextField.ELEMENT_ID, getResult.getName());
    assertSame(child, children.get(0));
    assertSame(parent, textField.getParent());
  }

  /**
   * Method under test: {@link TextField#areNestedElementsAllowed()}
   */
  @Test
  public void testAreNestedElementsAllowed() {
    // Arrange, Act and Assert
    assertFalse((new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .areNestedElementsAllowed());
  }

  /**
   * Method under test: {@link TextField#hasElementInitialValue()}
   */
  @Test
  public void testHasElementInitialValue() {
    // Arrange, Act and Assert
    assertFalse(
        (new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).hasElementInitialValue());
  }

  /**
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
   * Method under test: {@link TextField#getAttributeValue(String)}
   */
  @Test
  public void testGetAttributeValue() {
    // Arrange, Act and Assert
    assertNull((new TextField(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .getAttributeValue("Attribute Name"));
  }

  /**
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
}
