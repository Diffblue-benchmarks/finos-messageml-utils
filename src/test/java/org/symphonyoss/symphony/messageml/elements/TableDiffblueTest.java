package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableNode;

public class TableDiffblueTest {
  /**
   * Test {@link Table#Table(Element)}.
   * <p>
   * Method under test: {@link Table#Table(Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Table.<init>(Element)"})
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
   * Test {@link Table#asMarkdown()}.
   * <p>
   * Method under test: {@link Table#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Table.asMarkdown()"})
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
   * Test {@link Table#toString()}.
   * <p>
   * Method under test: {@link Table#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Table.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Table", (new Table(new Bold(new BulletList(null)))).toString());
  }

  /**
   * Test {@link Table#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Given {@code table_rows_max}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Table#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Table.updateBiContext(BiContext)"})
  public void testUpdateBiContext_givenTableRowsMax() {
    // Arrange
    Table table = new Table(new Bold(new BulletList(mock(Element.class))));
    table.addChild(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItemWithValue("table_rows_max", "Item Value");

    // Act
    table.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("Item Value", attributes.get("count"));
    BiItem getResult = items.get(1);
    assertEquals("tables", getResult.getName());
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertEquals(1, ((Integer) attributes2.get("count")).intValue());
  }

  /**
   * Test {@link Table#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes {@code count} {@link BiItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Table#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Table.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountBiItem() {
    // Arrange
    Table table = new Table(new Bold(new BulletList(mock(Element.class))));
    table.addChild(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    BiItem biItem = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItemWithValue("tables", biItem);

    // Act
    table.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(1, attributes.size());
    Object getResult = attributes.get("count");
    assertTrue(getResult instanceof BiItem);
    BiItem getResult2 = items.get(1);
    assertEquals("table_rows_max", getResult2.getName());
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertEquals(0, ((Integer) attributes2.get("count")).intValue());
    assertSame(biItem, getResult);
  }

  /**
   * Test {@link Table#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Table#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Table.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    Table table = new Table(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItem(new BiItem("tables", Element.STYLE_ATTR));

    // Act
    table.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("table_rows_max", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(0, ((Integer) attributes.get("count")).intValue());
    Map<String, Object> attributes2 = items.get(0).getAttributes();
    assertEquals(2, attributes2.size());
    assertEquals(1, ((Integer) attributes2.get("count")).intValue());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link Table#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is {@code table_rows_max}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Table#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Table.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstNameIsTableRowsMax() {
    // Arrange
    Table table = new Table(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItem(new BiItem("table_rows_max", Element.STYLE_ATTR));

    // Act
    table.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(0);
    assertEquals("table_rows_max", getResult.getName());
    BiItem getResult2 = items.get(1);
    assertEquals("tables", getResult2.getName());
    Map<String, Object> attributes = getResult2.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link Table#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Table#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Table.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsThree() {
    // Arrange
    Table table = new Table(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    table.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("table_rows_max", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(0, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Table#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor) addItemWithValue {@code tables} and {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Table#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Table.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContextAddItemWithValueTablesAndItemValue() {
    // Arrange
    Table table = new Table(new Bold(new BulletList(mock(Element.class))));
    table.addChild(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItemWithValue("tables", "Item Value");

    // Act
    table.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("Item Value", attributes.get("count"));
    BiItem getResult = items.get(1);
    assertEquals("table_rows_max", getResult.getName());
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertEquals(0, ((Integer) attributes2.get("count")).intValue());
  }

  /**
   * Test {@link Table#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is {@code tables}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Table#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Table.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsTables() {
    // Arrange
    Table table = new Table(new Bold(new BulletList(mock(Element.class))));
    BiContext context = new BiContext();

    // Act
    table.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(0);
    assertEquals("tables", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Table#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is {@code tables}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Table#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Table.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsTables2() {
    // Arrange
    Table table = new Table(new Bold(new BulletList(mock(Element.class))));
    table.addChild(new Bold(new BulletList(mock(Element.class))));
    BiContext context = new BiContext();

    // Act
    table.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(0);
    assertEquals("tables", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }
}
