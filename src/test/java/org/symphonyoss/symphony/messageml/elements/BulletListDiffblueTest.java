package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

public class BulletListDiffblueTest {
  /**
   * Method under test: {@link BulletList#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new BulletList(new Bold(mock(Element.class)))).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof org.commonmark.node.BulletList);
    assertEquals('-', ((org.commonmark.node.BulletList) actualAsMarkdownResult).getBulletMarker());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertFalse(((org.commonmark.node.BulletList) actualAsMarkdownResult).isTight());
  }

  /**
   * Method under test: {@link BulletList#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(mock(Element.class));
    BulletList bulletList = new BulletList(parent);
    BiContext context = new BiContext();

    // Act
    bulletList.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("lists", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(parent, bulletList.getParent());
  }

  /**
   * Method under test: {@link BulletList#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(mock(Element.class));
    BulletList bulletList = new BulletList(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    bulletList.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("lists", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(parent, bulletList.getParent());
  }

  /**
   * Method under test: {@link BulletList#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() {
    // Arrange
    Bold parent = new Bold(mock(Element.class));
    BulletList bulletList = new BulletList(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    bulletList.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("lists", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(item2, items.get(1));
    assertSame(parent, bulletList.getParent());
  }

  /**
   * Method under test: {@link BulletList#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext4() {
    // Arrange
    Bold parent = new Bold(mock(Element.class));
    BulletList bulletList = new BulletList(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem("lists", Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    bulletList.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    assertSame(item, items.get(0));
    assertSame(parent, bulletList.getParent());
  }

  /**
   * Method under test: {@link BulletList#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext5() {
    // Arrange
    Bold parent = new Bold(mock(Element.class));
    BulletList bulletList = new BulletList(parent);

    BiContext context = new BiContext();
    context.addItemWithValue("lists", "Item Value");
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    bulletList.updateBiContext(context);

    // Assert that nothing has changed
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("lists", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, bulletList.getParent());
  }

  /**
   * Method under test: {@link BulletList#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext6() {
    // Arrange
    Bold parent = new Bold(mock(Element.class));
    BulletList bulletList = new BulletList(parent);

    BiContext context = new BiContext();
    context.addItemWithValue("lists", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    bulletList.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("lists", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, bulletList.getParent());
  }

  /**
   * Method under test: {@link BulletList#BulletList(Element)}
   */
  @Test
  public void testNewBulletList() {
    // Arrange
    Bold parent = new Bold(new Code(mock(Element.class), "en"));

    // Act
    BulletList actualBulletList = new BulletList(parent);

    // Assert
    assertEquals(0, actualBulletList.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualBulletList.getFormat());
    assertTrue(actualBulletList.getChildren().isEmpty());
    assertTrue(actualBulletList.getAttributes().isEmpty());
    assertEquals(BulletList.MESSAGEML_TAG, actualBulletList.getMessageMLTag());
    assertEquals(BulletList.MESSAGEML_TAG, actualBulletList.getPresentationMLTag());
    assertSame(parent, actualBulletList.getParent());
  }
}
