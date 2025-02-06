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
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class OrderedListDiffblueTest {
  /**
   * Test {@link OrderedList#OrderedList(Element)}.
   * <p>
   * Method under test: {@link OrderedList#OrderedList(Element)}
   */
  @Test
  public void testNewOrderedList() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    OrderedList actualOrderedList = new OrderedList(parent);

    // Assert
    assertEquals(0, actualOrderedList.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualOrderedList.getFormat());
    assertTrue(actualOrderedList.getChildren().isEmpty());
    assertTrue(actualOrderedList.getAttributes().isEmpty());
    assertEquals(OrderedList.MESSAGEML_TAG, actualOrderedList.getMessageMLTag());
    assertEquals(OrderedList.MESSAGEML_TAG, actualOrderedList.getPresentationMLTag());
    assertSame(parent, actualOrderedList.getParent());
  }

  /**
   * Test {@link OrderedList#asMarkdown()}.
   * <p>
   * Method under test: {@link OrderedList#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new OrderedList(new Bold(new BulletList(mock(Element.class))))).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof org.commonmark.node.OrderedList);
    assertEquals('.', ((org.commonmark.node.OrderedList) actualAsMarkdownResult).getDelimiter());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertEquals(1, ((org.commonmark.node.OrderedList) actualAsMarkdownResult).getStartNumber());
    assertFalse(((org.commonmark.node.OrderedList) actualAsMarkdownResult).isTight());
  }

  /**
   * Test {@link OrderedList#validate()}.
   * <ul>
   *   <li>Given {@link OrderedList#OrderedList(Element)} with parent is
   * {@link Bold#Bold(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedList#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate_givenOrderedListWithParentIsBold() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: The "ol" element must have at least one child that is any of the following elements: [listitem].
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertContainsChildOfType(Element.java:792)
    //       at org.symphonyoss.symphony.messageml.elements.OrderedList.validate(OrderedList.java:52)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new OrderedList(new Bold(new BulletList(mock(Element.class))))).validate();
  }

  /**
   * Test {@link OrderedList#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} {@link BiItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedList#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountBiItem() {
    // Arrange
    OrderedList orderedList = new OrderedList(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    BiItem biItem = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItemWithValue("lists", biItem);
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    orderedList.updateBiContext(context);

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
   * Test {@link OrderedList#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} is {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedList#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountIsItemValue() {
    // Arrange
    OrderedList orderedList = new OrderedList(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItemWithValue("lists", "Item Value");
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    orderedList.updateBiContext(context);

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
   * Test {@link OrderedList#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedList#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    OrderedList orderedList = new OrderedList(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItem(new BiItem("lists", Element.STYLE_ATTR));

    // Act
    orderedList.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    assertTrue(attributes.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link OrderedList#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedList#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsSizeIsTwo() {
    // Arrange
    OrderedList orderedList = new OrderedList(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    orderedList.updateBiContext(context);

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
   * Test {@link OrderedList#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is
   * {@code lists}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedList#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsLists() {
    // Arrange
    OrderedList orderedList = new OrderedList(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    orderedList.updateBiContext(context);

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
   * Test {@link OrderedList#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is
   * {@code lists}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedList#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsLists() {
    // Arrange
    OrderedList orderedList = new OrderedList(new Bold(new BulletList(mock(Element.class))));
    BiContext context = new BiContext();

    // Act
    orderedList.updateBiContext(context);

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
