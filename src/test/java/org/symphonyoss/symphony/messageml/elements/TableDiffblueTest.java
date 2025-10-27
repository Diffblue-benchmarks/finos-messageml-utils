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
import org.symphonyoss.symphony.messageml.markdown.nodes.TableNode;

public class TableDiffblueTest {
  /**
   * Method under test: {@link Table#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Table(new Bold(new BulletList(mock(Element.class))))).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof TableNode);
    assertEquals("\n   \n", ((TableNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals("\n   \n", ((TableNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Method under test: {@link Table#Table(Element)}
   */
  @Test
  public void testNewTable() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Table actualTable = new Table(parent);

    // Assert
    assertEquals(0, actualTable.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualTable.getFormat());
    assertTrue(actualTable.getChildren().isEmpty());
    assertTrue(actualTable.getAttributes().isEmpty());
    assertEquals(Table.MESSAGEML_TAG, actualTable.getMessageMLTag());
    assertEquals(Table.MESSAGEML_TAG, actualTable.getPresentationMLTag());
    assertSame(parent, actualTable.getParent());
  }

  /**
   * Method under test: {@link Table#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Table", (new Table(new Bold(new BulletList(null)))).toString());
  }

  /**
   * Method under test: {@link Table#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Table table = new Table(parent);
    BiContext context = new BiContext();

    // Act
    table.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("table_rows_max", getResult.getName());
    BiItem getResult2 = items.get(0);
    assertEquals("tables", getResult2.getName());
    Map<String, Object> attributes = getResult2.getAttributes();
    assertEquals(1, attributes.size());
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(table.getChildren().isEmpty());
    assertTrue(attributes.containsKey("count"));
    assertTrue(attributes2.containsKey("count"));
    assertSame(parent, table.getParent());
  }

  /**
   * Method under test: {@link Table#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Table table = new Table(parent);
    Bold child = new Bold(new BulletList(mock(Element.class)));
    table.addChild(child);
    BiContext context = new BiContext();

    // Act
    table.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("table_rows_max", getResult.getName());
    BiItem getResult2 = items.get(0);
    assertEquals("tables", getResult2.getName());
    List<Element> children = table.getChildren();
    assertEquals(1, children.size());
    Map<String, Object> attributes = getResult2.getAttributes();
    assertEquals(1, attributes.size());
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey("count"));
    assertTrue(attributes2.containsKey("count"));
    assertSame(child, children.get(0));
    assertSame(parent, table.getParent());
  }

  /**
   * Method under test: {@link Table#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Table table = new Table(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    table.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("table_rows_max", getResult.getName());
    BiItem getResult2 = items.get(1);
    assertEquals("tables", getResult2.getName());
    Map<String, Object> attributes = getResult2.getAttributes();
    assertEquals(1, attributes.size());
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(table.getChildren().isEmpty());
    assertTrue(attributes.containsKey("count"));
    assertTrue(attributes2.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(parent, table.getParent());
  }

  /**
   * Method under test: {@link Table#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext4() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Table table = new Table(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem("tables", Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    table.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("table_rows_max", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(table.getChildren().isEmpty());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(parent, table.getParent());
  }

  /**
   * Method under test: {@link Table#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext5() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Table table = new Table(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem("table_rows_max", Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    table.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("tables", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(table.getChildren().isEmpty());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(parent, table.getParent());
  }

  /**
   * Method under test: {@link Table#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext6() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Table table = new Table(parent);
    Bold child = new Bold(new BulletList(mock(Element.class)));
    table.addChild(child);

    BiContext context = new BiContext();
    context.addItemWithValue("tables", "Item Value");

    // Act
    table.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("table_rows_max", getResult.getName());
    BiItem getResult2 = items.get(0);
    assertEquals("tables", getResult2.getName());
    List<Element> children = table.getChildren();
    assertEquals(1, children.size());
    Map<String, Object> attributes = getResult2.getAttributes();
    assertEquals(1, attributes.size());
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey("count"));
    assertTrue(attributes2.containsKey("count"));
    assertSame(child, children.get(0));
    assertSame(parent, table.getParent());
  }

  /**
   * Method under test: {@link Table#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext7() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Table table = new Table(parent);
    Bold child = new Bold(new BulletList(mock(Element.class)));
    table.addChild(child);

    BiContext context = new BiContext();
    context.addItemWithValue("table_rows_max", "Item Value");

    // Act
    table.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(0);
    assertEquals("table_rows_max", getResult.getName());
    BiItem getResult2 = items.get(1);
    assertEquals("tables", getResult2.getName());
    List<Element> children = table.getChildren();
    assertEquals(1, children.size());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey("count"));
    assertTrue(attributes2.containsKey("count"));
    assertSame(child, children.get(0));
    assertSame(parent, table.getParent());
  }

  /**
   * Method under test: {@link Table#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext8() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Table table = new Table(parent);
    Bold child = new Bold(new BulletList(mock(Element.class)));
    table.addChild(child);

    BiContext context = new BiContext();
    context.addItemWithValue("tables", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    table.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("table_rows_max", getResult.getName());
    BiItem getResult2 = items.get(0);
    assertEquals("tables", getResult2.getName());
    List<Element> children = table.getChildren();
    assertEquals(1, children.size());
    Map<String, Object> attributes = getResult2.getAttributes();
    assertEquals(1, attributes.size());
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey("count"));
    assertTrue(attributes2.containsKey("count"));
    assertSame(child, children.get(0));
    assertSame(parent, table.getParent());
  }
}
