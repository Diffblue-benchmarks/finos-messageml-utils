package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.TextAreaNode;

public class TextAreaDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TextArea#TextArea(Element, FormatEnum)}
   *   <li>{@link TextArea#getElementId()}
   *   <li>{@link TextArea#getElementType()}
   *   <li>{@link TextArea#getMaxValueAllowed()}
   *   <li>{@link TextArea#getMinValueAllowed()}
   * </ul>
   */
  @Test
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
   * <p>
   * Method under test: {@link TextArea#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Element "textarea" can only be a inner child of the following elements: [form]
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertParentAtAnyLevel(Element.java:758)
    //       at org.symphonyoss.symphony.messageml.elements.FormElement.validate(FormElement.java:24)
    //       at org.symphonyoss.symphony.messageml.elements.TextArea.validate(TextArea.java:43)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new TextArea(new Bold(new BulletList(null)), FormatEnum.MESSAGEML)).validate();
  }

  /**
   * Test {@link TextArea#buildAttribute(MessageMLParser, Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextArea#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Attribute "foo" is not allowed in "textarea"
    //       at org.symphonyoss.symphony.messageml.elements.Element.throwInvalidInputException(Element.java:1071)
    //       at org.symphonyoss.symphony.messageml.elements.TextArea.buildAttribute(TextArea.java:112)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TextArea textArea = new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    textArea.buildAttribute(parser, new IIOMetadataNode("foo"));
  }

  /**
   * Test {@link TextArea#asMarkdown()}.
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is
   * {@link BulletList#BulletList(Element)} addChild {@link Bold#Bold(Element)}
   * with parent is {@link BulletList#BulletList(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextArea#asMarkdown()}
   */
  @Test
  public void testAsMarkdown_givenBoldWithParentIsBulletListAddChildBoldWithParentIsBulletList() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    TextArea textArea = new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
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
   * <ul>
   *   <li>Then return Text is {@code :}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextArea#asMarkdown()}
   */
  @Test
  public void testAsMarkdown_thenReturnTextIsColon() {
    // Arrange
    TextArea textArea = new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    textArea.addChild(new Bold(new BulletList(mock(Element.class))));

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
   * <ul>
   *   <li>Then return Text is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextArea#asMarkdown()}
   */
  @Test
  public void testAsMarkdown_thenReturnTextIsEmptyString() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .asMarkdown();

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
   * Test {@link TextArea#asMarkdown()}.
   * <ul>
   *   <li>Then return Text is {@code :$null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextArea#asMarkdown()}
   */
  @Test
  public void testAsMarkdown_thenReturnTextIsNull() {
    // Arrange
    TextArea textArea = new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    textArea.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));

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
   * Test {@link TextArea#hasElementInitialValue()}.
   * <p>
   * Method under test: {@link TextArea#hasElementInitialValue()}
   */
  @Test
  public void testHasElementInitialValue() {
    // Arrange
    TextArea textArea = new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    textArea.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertFalse(textArea.hasElementInitialValue());
  }

  /**
   * Test {@link TextArea#hasElementInitialValue()}.
   * <ul>
   *   <li>Given {@link TextArea#TextArea(Element, FormatEnum)} with parent is
   * {@link Bold#Bold(Element)} and format is {@code MESSAGEML}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextArea#hasElementInitialValue()}
   */
  @Test
  public void testHasElementInitialValue_givenTextAreaWithParentIsBoldAndFormatIsMessageml() {
    // Arrange, Act and Assert
    assertFalse(
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).hasElementInitialValue());
  }

  /**
   * Test {@link TextArea#getElementInitialValue()}.
   * <p>
   * Method under test: {@link TextArea#getElementInitialValue()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetElementInitialValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
    //       at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
    //       at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
    //       at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
    //       at java.base/java.util.Objects.checkIndex(Objects.java:374)
    //       at java.base/java.util.ArrayList.get(ArrayList.java:459)
    //       at org.symphonyoss.symphony.messageml.elements.Element.getChild(Element.java:940)
    //       at org.symphonyoss.symphony.messageml.elements.TextArea.getElementInitialValue(TextArea.java:139)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).getElementInitialValue();
  }

  /**
   * Test {@link TextArea#getAttributeValue(String)}.
   * <p>
   * Method under test: {@link TextArea#getAttributeValue(String)}
   */
  @Test
  public void testGetAttributeValue() {
    // Arrange, Act and Assert
    assertNull((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .getAttributeValue("Attribute Name"));
  }

  /**
   * Test {@link TextArea#updateBiContext(BiContext)}.
   * <p>
   * Method under test: {@link TextArea#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    TextArea textArea = new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    textArea.addChild(new Bold(new BulletList(mock(Element.class))));
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
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextArea#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsSizeIsOne() {
    // Arrange
    TextArea textArea = new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
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
