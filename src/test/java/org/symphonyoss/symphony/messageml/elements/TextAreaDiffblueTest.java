package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import org.commonmark.node.Node;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.TextAreaNode;

public class TextAreaDiffblueTest {
  /**
   * Method under test: {@link TextArea#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
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
   * Method under test: {@link TextArea#asMarkdown()}
   */
  @Test
  public void testAsMarkdown2() {
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
   * Method under test: {@link TextArea#asMarkdown()}
   */
  @Test
  public void testAsMarkdown3() {
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
   * Method under test: {@link TextArea#asMarkdown()}
   */
  @Test
  public void testAsMarkdown4() {
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
   * Method under test: {@link TextArea#hasElementInitialValue()}
   */
  @Test
  public void testHasElementInitialValue() {
    // Arrange, Act and Assert
    assertFalse(
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).hasElementInitialValue());
  }

  /**
   * Method under test: {@link TextArea#hasElementInitialValue()}
   */
  @Test
  public void testHasElementInitialValue2() {
    // Arrange
    TextArea textArea = new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    textArea.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertFalse(textArea.hasElementInitialValue());
  }

  /**
   * Method under test: {@link TextArea#getAttributeValue(String)}
   */
  @Test
  public void testGetAttributeValue() {
    // Arrange, Act and Assert
    assertNull((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .getAttributeValue("Attribute Name"));
  }

  /**
   * Method under test: {@link TextArea#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TextArea textArea = new TextArea(parent, FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    textArea.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    assertTrue(textArea.getChildren().isEmpty());
    BiItem getResult = items.get(0);
    assertTrue(getResult.getAttributes().isEmpty());
    assertTrue(textArea.getAttributes().isEmpty());
    assertTrue(textArea.getOtherAttributes().isEmpty());
    assertTrue(textArea.getRegexAttrForPresentationML().isEmpty());
    assertEquals(TextArea.MESSAGEML_TAG, getResult.getName());
    assertSame(parent, textArea.getParent());
  }

  /**
   * Method under test: {@link TextArea#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    TextArea textArea = new TextArea(parent, FormatEnum.MESSAGEML);
    Bold child = new Bold(new BulletList(mock(Element.class)));
    textArea.addChild(child);
    BiContext context = new BiContext();

    // Act
    textArea.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    List<Element> children = textArea.getChildren();
    assertEquals(1, children.size());
    BiItem getResult = items.get(0);
    assertTrue(getResult.getAttributes().isEmpty());
    assertTrue(textArea.getAttributes().isEmpty());
    assertTrue(textArea.getOtherAttributes().isEmpty());
    assertTrue(textArea.getRegexAttrForPresentationML().isEmpty());
    assertEquals(TextArea.MESSAGEML_TAG, getResult.getName());
    assertSame(child, children.get(0));
    assertSame(parent, textArea.getParent());
  }

  /**
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
}
