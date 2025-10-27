package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import java.util.Map;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Node;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;

public class LineBreakDiffblueTest {
  /**
   * Method under test: {@link LineBreak#asText()}
   */
  @Test
  public void testAsText() {
    // Arrange, Act and Assert
    assertEquals("\n", (new LineBreak(new Bold(new BulletList(mock(Element.class))))).asText());
  }

  /**
   * Method under test: {@link LineBreak#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new LineBreak(new Bold(new BulletList(mock(Element.class))))).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof HardLineBreak);
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Method under test: {@link LineBreak#areNestedElementsAllowed()}
   */
  @Test
  public void testAreNestedElementsAllowed() {
    // Arrange, Act and Assert
    assertFalse((new LineBreak(new Bold(new BulletList(mock(Element.class))))).areNestedElementsAllowed());
  }

  /**
   * Method under test: {@link LineBreak#LineBreak(Element)}
   */
  @Test
  public void testNewLineBreak() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    LineBreak actualLineBreak = new LineBreak(parent);

    // Assert
    assertEquals(0, actualLineBreak.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualLineBreak.getFormat());
    assertTrue(actualLineBreak.getChildren().isEmpty());
    assertTrue(actualLineBreak.getAttributes().isEmpty());
    assertEquals(LineBreak.MESSAGEML_TAG, actualLineBreak.getMessageMLTag());
    assertEquals(LineBreak.MESSAGEML_TAG, actualLineBreak.getPresentationMLTag());
    assertSame(parent, actualLineBreak.getParent());
  }

  /**
   * Method under test: {@link LineBreak#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("\n", (new LineBreak(new Bold(new BulletList(null)))).toString());
  }

  /**
   * Method under test: {@link LineBreak#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    LineBreak lineBreak = new LineBreak(parent);
    BiContext context = new BiContext();

    // Act
    lineBreak.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("linebreaks", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(parent, lineBreak.getParent());
  }

  /**
   * Method under test: {@link LineBreak#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    LineBreak lineBreak = new LineBreak(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    lineBreak.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("linebreaks", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(parent, lineBreak.getParent());
  }

  /**
   * Method under test: {@link LineBreak#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    LineBreak lineBreak = new LineBreak(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    lineBreak.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("linebreaks", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(item2, items.get(1));
    assertSame(parent, lineBreak.getParent());
  }

  /**
   * Method under test: {@link LineBreak#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext4() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    LineBreak lineBreak = new LineBreak(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem("linebreaks", Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    lineBreak.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    assertSame(item, items.get(0));
    assertSame(parent, lineBreak.getParent());
  }

  /**
   * Method under test: {@link LineBreak#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext5() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    LineBreak lineBreak = new LineBreak(parent);

    BiContext context = new BiContext();
    context.addItemWithValue("linebreaks", "Item Value");
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    lineBreak.updateBiContext(context);

    // Assert that nothing has changed
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("linebreaks", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, lineBreak.getParent());
  }

  /**
   * Method under test: {@link LineBreak#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext6() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    LineBreak lineBreak = new LineBreak(parent);

    BiContext context = new BiContext();
    context.addItemWithValue("linebreaks", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    lineBreak.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("linebreaks", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, lineBreak.getParent());
  }
}
