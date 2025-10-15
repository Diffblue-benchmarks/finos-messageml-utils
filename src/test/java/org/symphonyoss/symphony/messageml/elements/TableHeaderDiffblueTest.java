package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

@RunWith(MockitoJUnitRunner.class)
public class TableHeaderDiffblueTest {
  @InjectMocks private TableHeader tableHeader;

  /**
   * Test {@link TableHeader#TableHeader(Element)}.
   *
   * <p>Method under test: {@link TableHeader#TableHeader(Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableHeader.<init>(Element)"})
  public void testNewTableHeader() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    TableHeader actualTableHeader = new TableHeader(parent2);

    // Assert
    assertEquals(0, actualTableHeader.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualTableHeader.getFormat());
    assertTrue(actualTableHeader.getChildren().isEmpty());
    assertTrue(actualTableHeader.getAttributes().isEmpty());
    assertEquals(TableHeader.MESSAGEML_TAG, actualTableHeader.getMessageMLTag());
    assertEquals(TableHeader.MESSAGEML_TAG, actualTableHeader.getPresentationMLTag());
    assertSame(parent2, actualTableHeader.getParent());
  }

  /**
   * Test {@link TableHeader#toString()}.
   *
   * <p>Method under test: {@link TableHeader#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TableHeader.toString()"})
  public void testToString() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertEquals("Header", new TableHeader(parent).toString());
  }

  /**
   * Test {@link TableHeader#validate()}.
   *
   * <ul>
   *   <li>Given {@link BulletList#BulletList(Element)} with parent is {@code null}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link TableHeader#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableHeader.validate()"})
  public void testValidate_givenBulletListWithParentIsNull_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    TableHeader tableHeader = new TableHeader(parent);
    tableHeader.addChild(new Bold(new BulletList(null)));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> tableHeader.validate());
  }

  /**
   * Test {@link TableHeader#validate()}.
   *
   * <ul>
   *   <li>Given {@link TableHeader}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TableHeader#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableHeader.validate()"})
  public void testValidate_givenTableHeader_thenDoesNotThrow() throws InvalidInputException {
    // Arrange, Act and Assert
    tableHeader.validate();
  }

  /**
   * Test {@link TableHeader#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes {@code count} {@link
   *       BiItem}.
   * </ul>
   *
   * <p>Method under test: {@link TableHeader#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableHeader.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountBiItem() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TableHeader tableHeader = new TableHeader(parent2);

    BiContext context = new BiContext();
    BiItem biItem = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);
    context.addItemWithValue("table_headers", biItem);
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    tableHeader.updateBiContext(context);

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
   * Test {@link TableHeader#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes {@code count} is
   *       {@code Item Value}.
   * </ul>
   *
   * <p>Method under test: {@link TableHeader#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableHeader.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountIsItemValue() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TableHeader tableHeader = new TableHeader(parent2);

    BiContext context = new BiContext();
    context.addItemWithValue("table_headers", "Item Value");
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    tableHeader.updateBiContext(context);

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
   * Test {@link TableHeader#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size is two.
   * </ul>
   *
   * <p>Method under test: {@link TableHeader#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableHeader.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TableHeader tableHeader = new TableHeader(parent2);

    BiContext context = new BiContext();
    context.addItem(new BiItem("table_headers", Element.STYLE_ATTR));

    // Act
    tableHeader.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    assertTrue(attributes.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link TableHeader#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.
   * </ul>
   *
   * <p>Method under test: {@link TableHeader#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableHeader.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsTwo() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TableHeader tableHeader = new TableHeader(parent2);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    tableHeader.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("table_headers", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link TableHeader#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is {@code table_headers}.
   * </ul>
   *
   * <p>Method under test: {@link TableHeader#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableHeader.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsTableHeaders() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TableHeader tableHeader = new TableHeader(parent2);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    tableHeader.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("table_headers", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link TableHeader#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>When {@link BiContext} (default constructor).
   *   <li>Then {@link BiContext} (default constructor) Items first Name is {@code table_headers}.
   * </ul>
   *
   * <p>Method under test: {@link TableHeader#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableHeader.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsTableHeaders() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TableHeader tableHeader = new TableHeader(parent2);
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
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }
}
