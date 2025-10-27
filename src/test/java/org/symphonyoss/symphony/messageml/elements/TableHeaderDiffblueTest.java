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

public class TableHeaderDiffblueTest {
  /**
   * Method under test: {@link TableHeader#TableHeader(Element)}
   */
  @Test
  public void testNewTableHeader() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    TableHeader actualTableHeader = new TableHeader(parent);

    // Assert
    assertEquals(0, actualTableHeader.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualTableHeader.getFormat());
    assertTrue(actualTableHeader.getChildren().isEmpty());
    assertTrue(actualTableHeader.getAttributes().isEmpty());
    assertEquals(TableHeader.MESSAGEML_TAG, actualTableHeader.getMessageMLTag());
    assertEquals(TableHeader.MESSAGEML_TAG, actualTableHeader.getPresentationMLTag());
    assertSame(parent, actualTableHeader.getParent());
  }

  /**
   * Method under test: {@link TableHeader#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Header", (new TableHeader(new Bold(new BulletList(null)))).toString());
  }

  /**
   * Method under test: {@link TableHeader#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TableHeader tableHeader = new TableHeader(parent);
    BiContext context = new BiContext();

    // Act
    tableHeader.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("table_headers", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(parent, tableHeader.getParent());
  }

  /**
   * Method under test: {@link TableHeader#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TableHeader tableHeader = new TableHeader(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    tableHeader.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("table_headers", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(parent, tableHeader.getParent());
  }

  /**
   * Method under test: {@link TableHeader#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TableHeader tableHeader = new TableHeader(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    tableHeader.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("table_headers", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(item2, items.get(1));
    assertSame(parent, tableHeader.getParent());
  }

  /**
   * Method under test: {@link TableHeader#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext4() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TableHeader tableHeader = new TableHeader(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem("table_headers", Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    tableHeader.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    assertSame(item, items.get(0));
    assertSame(parent, tableHeader.getParent());
  }

  /**
   * Method under test: {@link TableHeader#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext5() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TableHeader tableHeader = new TableHeader(parent);

    BiContext context = new BiContext();
    context.addItemWithValue("table_headers", "Item Value");
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    tableHeader.updateBiContext(context);

    // Assert that nothing has changed
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("table_headers", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, tableHeader.getParent());
  }

  /**
   * Method under test: {@link TableHeader#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext6() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TableHeader tableHeader = new TableHeader(parent);

    BiContext context = new BiContext();
    context.addItemWithValue("table_headers", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    tableHeader.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("table_headers", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, tableHeader.getParent());
  }
}
