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
import org.symphonyoss.symphony.messageml.markdown.nodes.TableRowNode;

public class TableRowDiffblueTest {
  /**
   * Method under test: {@link TableRow#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new TableRow(new Bold(new BulletList(mock(Element.class))))).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof TableRowNode);
    assertEquals("\n", ((TableRowNode) actualAsMarkdownResult).getDelimiter());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Method under test: {@link TableRow#TableRow(Element)}
   */
  @Test
  public void testNewTableRow() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    TableRow actualTableRow = new TableRow(parent);

    // Assert
    assertEquals(0, actualTableRow.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualTableRow.getFormat());
    assertTrue(actualTableRow.getChildren().isEmpty());
    assertTrue(actualTableRow.getAttributes().isEmpty());
    assertEquals(TableRow.MESSAGEML_TAG, actualTableRow.getMessageMLTag());
    assertEquals(TableRow.MESSAGEML_TAG, actualTableRow.getPresentationMLTag());
    assertSame(parent, actualTableRow.getParent());
  }

  /**
   * Method under test: {@link TableRow#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Row", (new TableRow(new Bold(new BulletList(null)))).toString());
  }

  /**
   * Method under test: {@link TableRow#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TableRow tableRow = new TableRow(parent);
    BiContext context = new BiContext();

    // Act
    tableRow.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("table_columns_max", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(tableRow.getChildren().isEmpty());
    assertTrue(attributes.containsKey("count"));
    assertSame(parent, tableRow.getParent());
  }

  /**
   * Method under test: {@link TableRow#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    TableRow tableRow = new TableRow(parent);
    Bold child = new Bold(new BulletList(mock(Element.class)));
    tableRow.addChild(child);
    BiContext context = new BiContext();

    // Act
    tableRow.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("table_columns_max", getResult.getName());
    List<Element> children = tableRow.getChildren();
    assertEquals(1, children.size());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(child, children.get(0));
    assertSame(parent, tableRow.getParent());
  }

  /**
   * Method under test: {@link TableRow#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TableRow tableRow = new TableRow(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    tableRow.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("table_columns_max", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(tableRow.getChildren().isEmpty());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(parent, tableRow.getParent());
  }

  /**
   * Method under test: {@link TableRow#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext4() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TableRow tableRow = new TableRow(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    tableRow.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("table_columns_max", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(tableRow.getChildren().isEmpty());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(item2, items.get(1));
    assertSame(parent, tableRow.getParent());
  }

  /**
   * Method under test: {@link TableRow#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext5() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TableRow tableRow = new TableRow(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem("table_columns_max", Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    tableRow.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    assertTrue(tableRow.getChildren().isEmpty());
    assertSame(item, items.get(0));
    assertSame(parent, tableRow.getParent());
  }

  /**
   * Method under test: {@link TableRow#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext6() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    TableRow tableRow = new TableRow(parent);

    BiContext context = new BiContext();
    context.addItemWithValue("table_columns_max", "Item Value");
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    tableRow.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("table_columns_max", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(tableRow.getChildren().isEmpty());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, tableRow.getParent());
  }
}
