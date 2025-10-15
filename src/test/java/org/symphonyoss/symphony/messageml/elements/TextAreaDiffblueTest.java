package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.TextAreaNode;

public class TextAreaDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TextArea#TextArea(Element, FormatEnum)}
   *   <li>{@link TextArea#getElementId()}
   *   <li>{@link TextArea#getElementType()}
   *   <li>{@link TextArea#getMaxValueAllowed()}
   *   <li>{@link TextArea#getMinValueAllowed()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TextArea.<init>(Element, FormatEnum)",
    "String TextArea.getElementId()",
    "String TextArea.getElementType()",
    "Integer TextArea.getMaxValueAllowed()",
    "Integer TextArea.getMinValueAllowed()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    TextArea actualTextArea = new TextArea(parent, FormatEnum.MESSAGEML);
    String actualElementId = actualTextArea.getElementId();
    String actualElementType = actualTextArea.getElementType();
    Integer actualMaxValueAllowed = actualTextArea.getMaxValueAllowed();

    // Assert
    assertEquals(0, actualTextArea.getMinValueAllowed().intValue());
    assertEquals(10000, actualMaxValueAllowed.intValue());
    assertEquals(FormatEnum.MESSAGEML, actualTextArea.getFormat());
    assertTrue(actualTextArea.getChildren().isEmpty());
    assertTrue(actualTextArea.getAttributes().isEmpty());
    assertEquals(TextArea.MESSAGEML_TAG, actualTextArea.getMessageMLTag());
    assertEquals(TextArea.MESSAGEML_TAG, actualTextArea.getPresentationMLTag());
    assertEquals(TextArea.MESSAGEML_TAG, actualElementId);
    assertEquals(TextArea.MESSAGEML_TAG, actualElementType);
    assertSame(parent, actualTextArea.getParent());
  }

  /**
   * Test {@link TextArea#validate()}.
   *
   * <p>Method under test: {@link TextArea#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextArea.validate()"})
  public void testValidate() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> new TextArea(parent, FormatEnum.MESSAGEML).validate());
  }

  /**
   * Test {@link TextArea#validate()}.
   *
   * <ul>
   *   <li>Then calls {@link Checkbox#getParent()}.
   * </ul>
   *
   * <p>Method under test: {@link TextArea#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextArea.validate()"})
  public void testValidate_thenCallsGetParent() throws InvalidInputException {
    // Arrange
    Checkbox parent = mock(Checkbox.class);
    when(parent.getParent()).thenReturn(new Bold(new BulletList(null)));
    BulletList parent2 = new BulletList(parent);
    Bold parent3 = new Bold(parent2);

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> new TextArea(parent3, FormatEnum.MESSAGEML).validate());
    verify(parent, atLeast(1)).getParent();
  }

  /**
   * Test {@link TextArea#buildAttribute(MessageMLParser, Node)}.
   *
   * <p>Method under test: {@link TextArea#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextArea.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextArea textArea = new TextArea(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () ->
            textArea.buildAttribute(
                parser,
                new IIOMetadataNode(RegexElement.PRESENTATIONML_PATTERN_ERROR_MESSAGE_ATTR)));
  }

  /**
   * Test {@link TextArea#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link TextArea#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextArea.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextArea textArea = new TextArea(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> textArea.buildAttribute(parser, new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link TextArea#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@link Element#ID_ATTR}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link TextArea#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextArea.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithId_attr_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextArea textArea = new TextArea(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> textArea.buildAttribute(parser, new IIOMetadataNode(Element.ID_ATTR)));
  }

  /**
   * Test {@link TextArea#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@link
   *       RegexElement#PATTERN_ERROR_MESSAGE_ATTR}.
   * </ul>
   *
   * <p>Method under test: {@link TextArea#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextArea.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithPattern_error_message_attr()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextArea textArea = new TextArea(parent2, FormatEnum.PRESENTATIONML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () ->
            textArea.buildAttribute(
                parser, new IIOMetadataNode(RegexElement.PATTERN_ERROR_MESSAGE_ATTR)));
  }

  /**
   * Test {@link TextArea#asMarkdown()}.
   *
   * <p>Method under test: {@link TextArea#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node TextArea.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    TextArea textArea = new TextArea(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    textArea.addChild(new CashTag(parent4, 1));

    // Act
    Node actualAsMarkdownResult = textArea.asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof TextAreaNode);
    assertEquals("(Text Area", ((TextAreaNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals(")", ((TextAreaNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals(":$null", ((TextAreaNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link TextArea#asMarkdown()}.
   *
   * <p>Method under test: {@link TextArea#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node TextArea.asMarkdown()"})
  public void testAsMarkdown2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CashTag(parent3, 1));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    TextArea textArea = new TextArea(parent5, FormatEnum.MESSAGEML);
    textArea.addChild(child);

    // Act
    Node actualAsMarkdownResult = textArea.asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof TextAreaNode);
    assertEquals("(Text Area", ((TextAreaNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals(")", ((TextAreaNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals(":$null", ((TextAreaNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link TextArea#asMarkdown()}.
   *
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is {@link BulletList#BulletList(Element)}
   *       addChild {@link Bold#Bold(Element)} with parent is {@link
   *       BulletList#BulletList(Element)}.
   * </ul>
   *
   * <p>Method under test: {@link TextArea#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node TextArea.asMarkdown()"})
  public void testAsMarkdown_givenBoldWithParentIsBulletListAddChildBoldWithParentIsBulletList() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent2));
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);

    TextArea textArea = new TextArea(parent4, FormatEnum.MESSAGEML);
    textArea.addChild(child);

    // Act
    Node actualAsMarkdownResult = textArea.asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof TextAreaNode);
    assertEquals("(Text Area", ((TextAreaNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals(")", ((TextAreaNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals(":", ((TextAreaNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link TextArea#asMarkdown()}.
   *
   * <ul>
   *   <li>Then return Text is {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link TextArea#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node TextArea.asMarkdown()"})
  public void testAsMarkdown_thenReturnTextIsColon() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    TextArea textArea = new TextArea(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    textArea.addChild(new Bold(parent3));

    // Act
    Node actualAsMarkdownResult = textArea.asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof TextAreaNode);
    assertEquals("(Text Area", ((TextAreaNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals(")", ((TextAreaNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals(":", ((TextAreaNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link TextArea#asMarkdown()}.
   *
   * <ul>
   *   <li>Then return Text is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TextArea#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node TextArea.asMarkdown()"})
  public void testAsMarkdown_thenReturnTextIsEmptyString() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new TextArea(parent2, FormatEnum.MESSAGEML).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof TextAreaNode);
    assertEquals("", ((TextAreaNode) actualAsMarkdownResult).getText());
    assertEquals("(Text Area", ((TextAreaNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals(")", ((TextAreaNode) actualAsMarkdownResult).getClosingDelimiter());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link TextArea#hasElementInitialValue()}.
   *
   * <p>Method under test: {@link TextArea#hasElementInitialValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TextArea.hasElementInitialValue()"})
  public void testHasElementInitialValue() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    TextArea textArea = new TextArea(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    textArea.addChild(new Bold(parent3));

    // Act and Assert
    assertFalse(textArea.hasElementInitialValue());
  }

  /**
   * Test {@link TextArea#hasElementInitialValue()}.
   *
   * <ul>
   *   <li>Given {@link TextArea#TextArea(Element, FormatEnum)} with parent is {@link
   *       Bold#Bold(Element)} and format is {@code MESSAGEML}.
   * </ul>
   *
   * <p>Method under test: {@link TextArea#hasElementInitialValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TextArea.hasElementInitialValue()"})
  public void testHasElementInitialValue_givenTextAreaWithParentIsBoldAndFormatIsMessageml() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertFalse(new TextArea(parent2, FormatEnum.MESSAGEML).hasElementInitialValue());
  }

  /**
   * Test {@link TextArea#getAttributeValue(String)}.
   *
   * <p>Method under test: {@link TextArea#getAttributeValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TextArea.getAttributeValue(String)"})
  public void testGetAttributeValue() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertNull(new TextArea(parent2, FormatEnum.MESSAGEML).getAttributeValue("Attribute Name"));
  }

  /**
   * Test {@link TextArea#updateBiContext(BiContext)}.
   *
   * <p>Method under test: {@link TextArea#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextArea.updateBiContext(BiContext)"})
  public void testUpdateBiContext() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    TextArea textArea = new TextArea(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    textArea.addChild(new Bold(parent3));
    BiContext context = new BiContext();

    // Act
    textArea.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertTrue(getResult.getAttributes().isEmpty());
    assertEquals(TextArea.MESSAGEML_TAG, getResult.getName());
  }

  /**
   * Test {@link TextArea#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is one.
   * </ul>
   *
   * <p>Method under test: {@link TextArea#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextArea.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsOne() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextArea textArea = new TextArea(parent2, FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    textArea.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertTrue(getResult.getAttributes().isEmpty());
    assertEquals(TextArea.MESSAGEML_TAG, getResult.getName());
  }
}
