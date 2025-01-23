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
   * Test {@link BulletList#BulletList(Element)}.
   * <p>
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

  /**
   * Test {@link BulletList#asMarkdown()}.
   * <p>
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
   * Test {@link BulletList#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} {@link BiItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulletList#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountBiItem() {
    // Arrange
    BulletList bulletList = new BulletList(new Bold(mock(Element.class)));

    BiContext context = new BiContext();
    BiItem biItem = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItemWithValue("lists", biItem);
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    bulletList.updateBiContext(context);

    // Assert that nothing has changed
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(1, attributes.size());
    Object getResult = attributes.get("count");
    assertTrue(getResult instanceof BiItem);
    Map<String, Object> attributes2 = items.get(1).getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
    assertEquals(attributes2, items.get(2).getAttributes());
    assertSame(biItem, getResult);
  }

  /**
   * Test {@link BulletList#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} is {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulletList#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountIsItemValue() {
    // Arrange
    BulletList bulletList = new BulletList(new Bold(mock(Element.class)));

    BiContext context = new BiContext();
    context.addItemWithValue("lists", "Item Value");
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    bulletList.updateBiContext(context);

    // Assert that nothing has changed
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("Item Value", attributes.get("count"));
    Map<String, Object> attributes2 = items.get(1).getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link BulletList#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulletList#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    BulletList bulletList = new BulletList(new Bold(mock(Element.class)));

    BiContext context = new BiContext();
    context.addItem(new BiItem("lists", Element.STYLE_ATTR));

    // Act
    bulletList.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    assertTrue(attributes.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link BulletList#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulletList#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsSizeIsTwo() {
    // Arrange
    BulletList bulletList = new BulletList(new Bold(mock(Element.class)));

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    bulletList.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("lists", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link BulletList#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is
   * {@code lists}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulletList#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsLists() {
    // Arrange
    BulletList bulletList = new BulletList(new Bold(mock(Element.class)));

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    bulletList.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("lists", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link BulletList#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is
   * {@code lists}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulletList#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsLists() {
    // Arrange
    BulletList bulletList = new BulletList(new Bold(mock(Element.class)));
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
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }
}
