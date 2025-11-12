package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TextField.<init>(Element, FormatEnum)",
    "String TextField.getElementId()",
    "String TextField.getElementType()",
    "Integer TextField.getMaxValueAllowed()",
    "Integer TextField.getMinValueAllowed()",
    "String TextField.getPresentationMLTag()"
  })
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
   * Test {@link TextField#validate()}.
   *
   * <p>Method under test: {@link TextField#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextField.validate()"})
  public void testValidate() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> new TextField(parent, FormatEnum.MESSAGEML).validate());
  }

  /**
   * Test {@link TextField#validate()}.
   *
   * <ul>
   *   <li>Then calls {@link Checkbox#getParent()}.
   * </ul>
   *
   * <p>Method under test: {@link TextField#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextField.validate()"})
  public void testValidate_thenCallsGetParent() throws InvalidInputException {
    // Arrange
    Checkbox parent = mock(Checkbox.class);
    when(parent.getParent()).thenReturn(new Bold(new BulletList(null)));
    BulletList parent2 = new BulletList(parent);
    Bold parent3 = new Bold(parent2);

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> new TextField(parent3, FormatEnum.MESSAGEML).validate());
    verify(parent, atLeast(1)).getParent();
  }

  /**
   * Test {@link TextField#buildAll(MessageMLParser, Element)}.
   *
   * <p>Method under test: {@link TextField#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextField.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll() throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextField textField = new TextField(parent2, FormatEnum.PRESENTATIONML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    textField.buildAll(parser, new IIOMetadataNode());

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
   *
   * <p>Method under test: {@link TextField#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextField.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll2() throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    TextField textField = new TextField(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold child = new Bold(parent3);
    textField.addChild(child);

    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(new BiContext());

    // Act
    textField.buildAll(parser, new IIOMetadataNode());

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
   *
   * <ul>
   *   <li>Given {@link Code#Code(Element, String)} with parent is {@link Element} and language is
   *       {@code en}.
   *   <li>Then calls {@link MessageMLParser#clearBiContext()}.
   * </ul>
   *
   * <p>Method under test: {@link TextField#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextField.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll_givenCodeWithParentIsElementAndLanguageIsEn_thenCallsClearBiContext()
      throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextField textField = new TextField(parent2, FormatEnum.MESSAGEML);

    MessageMLParser parser = mock(MessageMLParser.class);
    doNothing().when(parser).clearBiContext();
    Code parent3 = new Code(mock(Element.class), "en");
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any()))
        .thenReturn(new BulletList(new Bold(parent3)));
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode();
    element.appendChild(new IIOMetadataNode());

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> textField.buildAll(parser, element));
    verify(parser).clearBiContext();
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
    verify(parser).getBiContext();
  }

  /**
   * Test {@link TextField#buildAll(MessageMLParser, Element)}.
   *
   * <ul>
   *   <li>Given {@link InvalidInputException#InvalidInputException(String)} with message is {@code
   *       An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link TextField#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextField.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll_givenInvalidInputExceptionWithMessageIsAnErrorOccurred()
      throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextField textField = new TextField(parent2, FormatEnum.MESSAGEML);

    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any()))
        .thenThrow(new InvalidInputException("An error occurred"));

    IIOMetadataNode element = new IIOMetadataNode();
    element.appendChild(new IIOMetadataNode());

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> textField.buildAll(parser, element));
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
  }

  /**
   * Test {@link TextField#buildAll(MessageMLParser, Element)}.
   *
   * <ul>
   *   <li>Given {@link TextField#TextField(Element, FormatEnum)} with parent is {@link
   *       Bold#Bold(Element)} and messageFormat is {@code PRESENTATIONML}.
   * </ul>
   *
   * <p>Method under test: {@link TextField#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextField.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll_givenTextFieldWithParentIsBoldAndMessageFormatIsPresentationml()
      throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextField textField = new TextField(parent2, FormatEnum.PRESENTATIONML);
    MessageMLParser parser = mock(MessageMLParser.class);

    IIOMetadataNode element = new IIOMetadataNode();
    element.appendChild(new IIOMetadataNode());

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> textField.buildAll(parser, element));
  }

  /**
   * Test {@link TextField#buildAll(MessageMLParser, Element)}.
   *
   * <ul>
   *   <li>Then {@link TextField#TextField(Element, FormatEnum)} with parent is {@link
   *       Bold#Bold(Element)} and messageFormat is {@code MESSAGEML} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link TextField#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextField.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll_thenTextFieldWithParentIsBoldAndMessageFormatIsMessagemlSizeIsZero()
      throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextField textField = new TextField(parent2, FormatEnum.MESSAGEML);

    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(new BiContext());

    // Act
    textField.buildAll(parser, new IIOMetadataNode());

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
   *
   * <ul>
   *   <li>When {@link MessageMLParser} {@link MessageMLParser#createElement(Element, Element)}
   *       return {@link Bold#Bold(Element)} with parent is {@link BulletList#BulletList(Element)}.
   * </ul>
   *
   * <p>Method under test: {@link TextField#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextField.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll_whenMessageMLParserCreateElementReturnBoldWithParentIsBulletList()
      throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextField textField = new TextField(parent2, FormatEnum.MESSAGEML);

    MessageMLParser parser = mock(MessageMLParser.class);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold bold = new Bold(parent3);
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any()))
        .thenReturn(bold);
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode();
    element.appendChild(new IIOMetadataNode());

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
   * Test {@link TextField#asMarkdown()}.
   *
   * <p>Method under test: {@link TextField#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node TextField.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    TextField textField = new TextField(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    textField.addChild(new CashTag(parent4, 1));

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
   * Test {@link TextField#asMarkdown()}.
   *
   * <p>Method under test: {@link TextField#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node TextField.asMarkdown()"})
  public void testAsMarkdown2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CashTag(parent3, 1));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    TextField textField = new TextField(parent5, FormatEnum.MESSAGEML);
    textField.addChild(child);

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
   * Test {@link TextField#asMarkdown()}.
   *
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is {@link BulletList#BulletList(Element)}
   *       addChild {@link Bold#Bold(Element)} with parent is {@link
   *       BulletList#BulletList(Element)}.
   * </ul>
   *
   * <p>Method under test: {@link TextField#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node TextField.asMarkdown()"})
  public void testAsMarkdown_givenBoldWithParentIsBulletListAddChildBoldWithParentIsBulletList() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent2));
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);

    TextField textField = new TextField(parent4, FormatEnum.MESSAGEML);
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
   *
   * <ul>
   *   <li>Then return Text is {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link TextField#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node TextField.asMarkdown()"})
  public void testAsMarkdown_thenReturnTextIsColon() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    TextField textField = new TextField(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    textField.addChild(new Bold(parent3));

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
   *
   * <ul>
   *   <li>Then return Text is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TextField#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node TextField.asMarkdown()"})
  public void testAsMarkdown_thenReturnTextIsEmptyString() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new TextField(parent2, FormatEnum.MESSAGEML).asMarkdown();

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
   * Test {@link TextField#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@link Element#ID_ATTR}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link TextField#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextField.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithId_attr_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextField textField = new TextField(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> textField.buildAttribute(parser, new IIOMetadataNode(Element.ID_ATTR)));
  }

  /**
   * Test {@link TextField#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code Node Name}.
   * </ul>
   *
   * <p>Method under test: {@link TextField#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextField.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithNodeName() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextField textField = new TextField(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> textField.buildAttribute(parser, new IIOMetadataNode("Node Name")));
  }

  /**
   * Test {@link TextField#getOtherAttributes()}.
   *
   * <p>Method under test: {@link TextField#getOtherAttributes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TextField.getOtherAttributes()"})
  public void testGetOtherAttributes() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Bold child = new Bold(parent2);
    BulletList parent3 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent3));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Bold child2 = new Bold(parent5);
    child2.addChild(child);
    BulletList parent6 = new BulletList(mock(Element.class));
    Bold parent7 = new Bold(parent6);

    CashTag child3 = new CashTag(parent7, 1);
    child3.addChild(child2);
    BulletList parent8 = new BulletList(mock(Element.class));
    Bold parent9 = new Bold(parent8);

    TextField textField = new TextField(parent9, FormatEnum.MESSAGEML);
    textField.addChild(child3);

    // Act
    Map<String, String> actualOtherAttributes = textField.getOtherAttributes();

    // Assert
    assertEquals(3, actualOtherAttributes.size());
    assertEquals("$null", actualOtherAttributes.get(Entity.VALUE_FIELD));
    assertNull(actualOtherAttributes.get("name"));
    assertEquals(TextField.PRESENTATIONML_INPUT_TYPE, actualOtherAttributes.get(Entity.TYPE_FIELD));
  }

  /**
   * Test {@link TextField#getOtherAttributes()}.
   *
   * <p>Method under test: {@link TextField#getOtherAttributes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TextField.getOtherAttributes()"})
  public void testGetOtherAttributes2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Bold child = new Bold(parent2);
    BulletList parent3 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent3));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    CashTag child2 = new CashTag(parent5, 1);
    child2.addChild(child);
    BulletList parent6 = new BulletList(mock(Element.class));
    Bold parent7 = new Bold(parent6);

    Bold child3 = new Bold(parent7);
    child3.addChild(child2);
    BulletList parent8 = new BulletList(mock(Element.class));
    Bold parent9 = new Bold(parent8);

    TextField textField = new TextField(parent9, FormatEnum.MESSAGEML);
    textField.addChild(child3);

    // Act
    Map<String, String> actualOtherAttributes = textField.getOtherAttributes();

    // Assert
    assertEquals(3, actualOtherAttributes.size());
    assertEquals("$null", actualOtherAttributes.get(Entity.VALUE_FIELD));
    assertNull(actualOtherAttributes.get("name"));
    assertEquals(TextField.PRESENTATIONML_INPUT_TYPE, actualOtherAttributes.get(Entity.TYPE_FIELD));
  }

  /**
   * Test {@link TextField#getOtherAttributes()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link TextField#getOtherAttributes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TextField.getOtherAttributes()"})
  public void testGetOtherAttributes_thenReturnSizeIsTwo() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Map<String, String> actualOtherAttributes =
        new TextField(parent2, FormatEnum.MESSAGEML).getOtherAttributes();

    // Assert
    assertEquals(2, actualOtherAttributes.size());
    assertNull(actualOtherAttributes.get("name"));
    assertEquals(TextField.PRESENTATIONML_INPUT_TYPE, actualOtherAttributes.get(Entity.TYPE_FIELD));
  }

  /**
   * Test {@link TextField#getOtherAttributes()}.
   *
   * <ul>
   *   <li>Then return {@link Entity#VALUE_FIELD} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TextField#getOtherAttributes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TextField.getOtherAttributes()"})
  public void testGetOtherAttributes_thenReturnValue_fieldIsEmptyString() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Bold child = new Bold(parent2);
    BulletList parent3 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent3));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Bold child2 = new Bold(parent5);
    child2.addChild(child);
    BulletList parent6 = new BulletList(mock(Element.class));
    Bold parent7 = new Bold(parent6);

    Bold child3 = new Bold(parent7);
    child3.addChild(child2);
    BulletList parent8 = new BulletList(mock(Element.class));
    Bold parent9 = new Bold(parent8);

    TextField textField = new TextField(parent9, FormatEnum.MESSAGEML);
    textField.addChild(child3);

    // Act
    Map<String, String> actualOtherAttributes = textField.getOtherAttributes();

    // Assert
    assertEquals(3, actualOtherAttributes.size());
    assertEquals("", actualOtherAttributes.get(Entity.VALUE_FIELD));
    assertNull(actualOtherAttributes.get("name"));
    assertEquals(TextField.PRESENTATIONML_INPUT_TYPE, actualOtherAttributes.get(Entity.TYPE_FIELD));
  }

  /**
   * Test {@link TextField#updateBiContext(BiContext)}.
   *
   * <p>Method under test: {@link TextField#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextField.updateBiContext(BiContext)"})
  public void testUpdateBiContext() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    TextField textField = new TextField(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    textField.addChild(new Bold(parent3));
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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is one.
   * </ul>
   *
   * <p>Method under test: {@link TextField#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextField.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsOne() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextField textField = new TextField(parent2, FormatEnum.MESSAGEML);
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
   *
   * <p>Method under test: {@link TextField#areNestedElementsAllowed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TextField.areNestedElementsAllowed()"})
  public void testAreNestedElementsAllowed() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertFalse(new TextField(parent2, FormatEnum.MESSAGEML).areNestedElementsAllowed());
  }

  /**
   * Test {@link TextField#hasElementInitialValue()}.
   *
   * <p>Method under test: {@link TextField#hasElementInitialValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TextField.hasElementInitialValue()"})
  public void testHasElementInitialValue() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertFalse(new TextField(parent2, FormatEnum.MESSAGEML).hasElementInitialValue());
  }

  /**
   * Test {@link TextField#hasElementInitialValue()}.
   *
   * <p>Method under test: {@link TextField#hasElementInitialValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TextField.hasElementInitialValue()"})
  public void testHasElementInitialValue2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    TextField textField = new TextField(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    textField.addChild(new Bold(parent3));

    // Act and Assert
    assertFalse(textField.hasElementInitialValue());
  }

  /**
   * Test {@link TextField#getAttributeValue(String)}.
   *
   * <p>Method under test: {@link TextField#getAttributeValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TextField.getAttributeValue(String)"})
  public void testGetAttributeValue() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertNull(new TextField(parent2, FormatEnum.MESSAGEML).getAttributeValue("Attribute Name"));
  }
}
