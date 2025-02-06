package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import java.util.Map;
import org.commonmark.node.Node;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableRowNode;

public class TableRowDiffblueTest {
  /**
   * Test {@link TableRow#TableRow(Element)}.
   * <p>
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
   * Test {@link TableRow#asMarkdown()}.
   * <p>
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
   * Test {@link TableRow#toString()}.
   * <p>
   * Method under test: {@link TableRow#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Row", (new TableRow(new Bold(new BulletList(null)))).toString());
  }

  /**
   * Test {@link TableRow#validate()}.
   * <ul>
   *   <li>Given {@link TableRow#TableRow(Element)} with parent is
   * {@link Bold#Bold(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableRow#validate()}
   */
  @Test
  public void testValidate_givenTableRowWithParentIsBold() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new TableRow(new Bold(new BulletList(mock(Element.class))))).validate();
  }

  /**
   * Test {@link TableRow#validate()}.
   * <ul>
   *   <li>Given {@link TableRow#TableRow(Element)} with parent is
   * {@link Bold#Bold(Element)} addChild {@link Bold#Bold(Element)} with parent is
   * {@link BulletList#BulletList(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableRow#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate_givenTableRowWithParentIsBoldAddChildBoldWithParentIsBulletList()
      throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Element "b" is not allowed in "tr"
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertContentModel(Element.java:709)
    //       at org.symphonyoss.symphony.messageml.elements.TableRow.validate(TableRow.java:53)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TableRow tableRow = new TableRow(new Bold(new BulletList(mock(Element.class))));
    tableRow.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act
    tableRow.validate();
  }

  /**
   * Test {@link TableRow#updateBiContext(BiContext)}.
   * <p>
   * Method under test: {@link TableRow#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    TableRow tableRow = new TableRow(new Bold(new BulletList(mock(Element.class))));
    tableRow.addChild(new Bold(new BulletList(mock(Element.class))));
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
    assertEquals(0, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link TableRow#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * containsKey {@link Element#STYLE_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableRow#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesContainsKeyStyle_attr() {
    // Arrange
    TableRow tableRow = new TableRow(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItem(new BiItem("table_columns_max", Element.STYLE_ATTR));

    // Act
    tableRow.updateBiContext(context);

    // Assert that nothing has changed
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("table_columns_max", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link TableRow#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableRow#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountIntValueIsZero() {
    // Arrange
    TableRow tableRow = new TableRow(new Bold(new BulletList(mock(Element.class))));
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
    assertEquals(0, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link TableRow#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} is {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableRow#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountIsItemValue() {
    // Arrange
    TableRow tableRow = new TableRow(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItemWithValue("table_columns_max", "Item Value");
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    tableRow.updateBiContext(context);

    // Assert that nothing has changed
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("Item Value", attributes.get("count"));
    assertEquals("table_columns_max", getResult.getName());
    Map<String, Object> attributes2 = items.get(1).getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link TableRow#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableRow#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsSizeIsTwo() {
    // Arrange
    TableRow tableRow = new TableRow(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    tableRow.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("table_columns_max", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(0, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link TableRow#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is
   * {@code table_columns_max}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableRow#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsTableColumnsMax() {
    // Arrange
    TableRow tableRow = new TableRow(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    tableRow.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("table_columns_max", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(0, ((Integer) attributes.get("count")).intValue());
  }
}
