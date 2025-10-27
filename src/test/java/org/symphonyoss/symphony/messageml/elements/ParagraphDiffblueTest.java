package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import java.util.Map;
import org.commonmark.node.Node;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;

public class ParagraphDiffblueTest {
  /**
   * Method under test: {@link Paragraph#asText()}
   */
  @Test
  public void testAsText() {
    // Arrange, Act and Assert
    assertEquals("\n", (new Paragraph(new Bold(new BulletList(mock(Element.class))))).asText());
  }

  /**
   * Method under test: {@link Paragraph#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Paragraph(new Bold(new BulletList(mock(Element.class))))).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof org.commonmark.node.Paragraph);
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Method under test: {@link Paragraph#Paragraph(Element)}
   */
  @Test
  public void testNewParagraph() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Paragraph actualParagraph = new Paragraph(parent);

    // Assert
    assertEquals(0, actualParagraph.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualParagraph.getFormat());
    assertTrue(actualParagraph.getChildren().isEmpty());
    assertTrue(actualParagraph.getAttributes().isEmpty());
    assertEquals(Paragraph.MESSAGEML_TAG, actualParagraph.getMessageMLTag());
    assertEquals(Paragraph.MESSAGEML_TAG, actualParagraph.getPresentationMLTag());
    assertSame(parent, actualParagraph.getParent());
  }

  /**
   * Method under test: {@link Paragraph#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("\n\n", (new Paragraph(new Bold(new BulletList(null)))).toString());
  }

  /**
   * Method under test: {@link Paragraph#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Paragraph paragraph = new Paragraph(parent);
    BiContext context = new BiContext();

    // Act
    paragraph.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("paragraphs", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(parent, paragraph.getParent());
  }

  /**
   * Method under test: {@link Paragraph#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Paragraph paragraph = new Paragraph(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    paragraph.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("paragraphs", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(parent, paragraph.getParent());
  }

  /**
   * Method under test: {@link Paragraph#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Paragraph paragraph = new Paragraph(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    paragraph.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("paragraphs", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(item2, items.get(1));
    assertSame(parent, paragraph.getParent());
  }

  /**
   * Method under test: {@link Paragraph#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext4() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Paragraph paragraph = new Paragraph(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem("paragraphs", Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    paragraph.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    assertSame(item, items.get(0));
    assertSame(parent, paragraph.getParent());
  }

  /**
   * Method under test: {@link Paragraph#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext5() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Paragraph paragraph = new Paragraph(parent);

    BiContext context = new BiContext();
    context.addItemWithValue("paragraphs", "Item Value");
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    paragraph.updateBiContext(context);

    // Assert that nothing has changed
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("paragraphs", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, paragraph.getParent());
  }

  /**
   * Method under test: {@link Paragraph#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext6() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Paragraph paragraph = new Paragraph(parent);

    BiContext context = new BiContext();
    context.addItemWithValue("paragraphs", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    paragraph.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("paragraphs", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, paragraph.getParent());
  }
}
