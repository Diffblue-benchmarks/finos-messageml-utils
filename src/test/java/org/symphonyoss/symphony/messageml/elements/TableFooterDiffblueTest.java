package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;

public class TableFooterDiffblueTest {
  /**
   * Method under test: {@link TableFooter#TableFooter(Element)}
   */
  @Test
  public void testNewTableFooter() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    TableFooter actualTableFooter = new TableFooter(parent);

    // Assert
    assertEquals(0, actualTableFooter.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualTableFooter.getFormat());
    assertTrue(actualTableFooter.getChildren().isEmpty());
    assertTrue(actualTableFooter.getAttributes().isEmpty());
    assertEquals(TableFooter.MESSAGEML_TAG, actualTableFooter.getMessageMLTag());
    assertEquals(TableFooter.MESSAGEML_TAG, actualTableFooter.getPresentationMLTag());
    assertSame(parent, actualTableFooter.getParent());
  }

  /**
   * Method under test: {@link TableFooter#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Footer", (new TableFooter(new Bold(new BulletList(null)))).toString());
  }

  /**
   * Method under test: {@link TableFooter#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TableFooter tableFooter = new TableFooter(parent);
    BiContext context = new BiContext();

    // Act
    tableFooter.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("table_footers", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(parent, tableFooter.getParent());
  }

  /**
   * Method under test: {@link TableFooter#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TableFooter tableFooter = new TableFooter(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    tableFooter.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("table_footers", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(parent, tableFooter.getParent());
  }

  /**
   * Method under test: {@link TableFooter#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TableFooter tableFooter = new TableFooter(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    tableFooter.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("table_footers", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(item2, items.get(1));
    assertSame(parent, tableFooter.getParent());
  }

  /**
   * Method under test: {@link TableFooter#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext4() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TableFooter tableFooter = new TableFooter(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem("table_footers", Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    tableFooter.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    assertSame(item, items.get(0));
    assertSame(parent, tableFooter.getParent());
  }

  /**
   * Method under test: {@link TableFooter#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext5() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TableFooter tableFooter = new TableFooter(parent);

    BiContext context = new BiContext();
    context.addItemWithValue("table_footers", "Item Value");
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    tableFooter.updateBiContext(context);

    // Assert that nothing has changed
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("table_footers", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, tableFooter.getParent());
  }

  /**
   * Method under test: {@link TableFooter#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext6() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TableFooter tableFooter = new TableFooter(parent);

    BiContext context = new BiContext();
    context.addItemWithValue("table_footers", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    tableFooter.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("table_footers", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, tableFooter.getParent());
  }
}
