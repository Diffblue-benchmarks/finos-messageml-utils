package org.symphonyoss.symphony.messageml.bi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class BiContextDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BiContext}
   *   <li>{@link BiContext#getItems()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new BiContext()).getItems().isEmpty());
  }

  /**
   * Test {@link BiContext#addItem(BiItem)}.
   * <p>
   * Method under test: {@link BiContext#addItem(BiItem)}
   */
  @Test
  public void testAddItem() {
    // Arrange
    BiContext biContext = new BiContext();
    BiItem item = new BiItem("Name", "Attribute");

    // Act
    biContext.addItem(item);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(1, items.size());
    assertSame(item, items.get(0));
  }

  /**
   * Test {@link BiContext#addItemWithValue(String, Object)}.
   * <p>
   * Method under test: {@link BiContext#addItemWithValue(String, Object)}
   */
  @Test
  public void testAddItemWithValue() {
    // Arrange
    BiContext biContext = new BiContext();

    // Act
    biContext.addItemWithValue("Item Name", "Item Value");

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("Item Value", attributes.get("count"));
  }

  /**
   * Test {@link BiContext#updateItemCount(String)} with {@code itemName}.
   * <p>
   * Method under test: {@link BiContext#updateItemCount(String)}
   */
  @Test
  public void testUpdateItemCountWithItemName() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItemWithValue("Item Name", "Item Value");
    biContext.addItem(new BiItem("Name", "Attribute"));

    // Act
    biContext.updateItemCount("Item Name");

    // Assert that nothing has changed
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("Item Value", attributes.get("count"));
  }

  /**
   * Test {@link BiContext#updateItemCount(String, String)} with {@code itemName},
   * {@code attributeName}.
   * <p>
   * Method under test: {@link BiContext#updateItemCount(String, String)}
   */
  @Test
  public void testUpdateItemCountWithItemNameAttributeName() {
    // Arrange
    BiContext biContext = new BiContext();

    // Act
    biContext.updateItemCount("Item Name", "Attribute Name");

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("Attribute Name")).intValue());
  }

  /**
   * Test {@link BiContext#updateItemCount(String, String)} with {@code itemName},
   * {@code attributeName}.
   * <p>
   * Method under test: {@link BiContext#updateItemCount(String, String)}
   */
  @Test
  public void testUpdateItemCountWithItemNameAttributeName2() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("Item Name", "Attribute"));

    // Act
    biContext.updateItemCount("Item Name", "Attribute Name");

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(1, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(1, ((Integer) attributes.get("Attribute Name")).intValue());
    assertTrue(attributes.containsKey("Attribute"));
  }

  /**
   * Test {@link BiContext#updateItemCount(String, String)} with {@code itemName},
   * {@code attributeName}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#updateItemCount(String, String)}
   */
  @Test
  public void testUpdateItemCountWithItemNameAttributeName_thenBiContextItemsSizeIsThree() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("Name", "Name"));
    biContext.addItem(new BiItem("Name", "Attribute"));

    // Act
    biContext.updateItemCount("Item Name", "Attribute Name");

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("Attribute Name")).intValue());
  }

  /**
   * Test {@link BiContext#updateItemCount(String, String)} with {@code itemName},
   * {@code attributeName}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#updateItemCount(String, String)}
   */
  @Test
  public void testUpdateItemCountWithItemNameAttributeName_thenBiContextItemsSizeIsTwo() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("Name", "Attribute"));

    // Act
    biContext.updateItemCount("Item Name", "Attribute Name");

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("Attribute Name")).intValue());
  }

  /**
   * Test {@link BiContext#updateItemCount(String, Map)} with {@code itemName},
   * {@code attributes}.
   * <p>
   * Method under test: {@link BiContext#updateItemCount(String, Map)}
   */
  @Test
  public void testUpdateItemCountWithItemNameAttributes() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("Item Name", "Item Name"));
    biContext.addItemWithValue("Item Name", "Item Value");
    biContext.addItem(new BiItem("Name", "Attribute"));

    HashMap<String, Object> attributes = new HashMap<>();
    attributes.put("Item Name", "42");

    // Act
    biContext.updateItemCount("Item Name", attributes);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    Map<String, Object> attributes2 = items.get(0).getAttributes();
    assertEquals(1, attributes2.size());
    assertEquals(2, ((Integer) attributes2.get("Item Name")).intValue());
  }

  /**
   * Test {@link BiContext#updateItemCount(String, Map)} with {@code itemName},
   * {@code attributes}.
   * <p>
   * Method under test: {@link BiContext#updateItemCount(String, Map)}
   */
  @Test
  public void testUpdateItemCountWithItemNameAttributes2() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("Item Name", "Attribute"));
    biContext.addItemWithValue("Item Name", "Item Value");
    biContext.addItem(new BiItem("Name", "Attribute"));

    HashMap<String, Object> attributes = new HashMap<>();
    attributes.put("Item Name", "42");

    // Act
    biContext.updateItemCount("Item Name", attributes);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    Map<String, Object> attributes2 = items.get(0).getAttributes();
    assertEquals(2, attributes2.size());
    assertEquals("42", attributes2.get("Item Name"));
    assertTrue(attributes2.containsKey("Attribute"));
  }

  /**
   * Test {@link BiContext#updateItemCount(String, Map)} with {@code itemName},
   * {@code attributes}.
   * <p>
   * Method under test: {@link BiContext#updateItemCount(String, Map)}
   */
  @Test
  public void testUpdateItemCountWithItemNameAttributes3() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("Item Name", "Item Name"));
    biContext.addItemWithValue("Item Name", "Item Value");
    biContext.addItem(new BiItem("Name", "Attribute"));

    HashMap<String, Object> attributes = new HashMap<>();
    attributes.put("42", "42");
    attributes.put("Item Name", "42");

    // Act
    biContext.updateItemCount("Item Name", attributes);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    Map<String, Object> attributes2 = items.get(0).getAttributes();
    assertEquals(2, attributes2.size());
    assertEquals("42", attributes2.get("42"));
    assertEquals(2, ((Integer) attributes2.get("Item Name")).intValue());
  }

  /**
   * Test {@link BiContext#updateItemCount(String, Map)} with {@code itemName},
   * {@code attributes}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items second Name is
   * {@code Item Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#updateItemCount(String, Map)}
   */
  @Test
  public void testUpdateItemCountWithItemNameAttributes_thenBiContextItemsSecondNameIsItemName() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("Name", "Attribute"));
    HashMap<String, Object> attributes = new HashMap<>();

    // Act
    biContext.updateItemCount("Item Name", attributes);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes2 = items.get(0).getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey("Attribute"));
    assertSame(attributes, getResult.getAttributes());
  }

  /**
   * Test {@link BiContext#updateItemCount(String, Map)} with {@code itemName},
   * {@code attributes}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items second Name is
   * {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#updateItemCount(String, Map)}
   */
  @Test
  public void testUpdateItemCountWithItemNameAttributes_thenBiContextItemsSecondNameIsName() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItemWithValue("Item Name", "Item Value");
    biContext.addItem(new BiItem("Name", "Attribute"));

    // Act
    biContext.updateItemCount("Item Name", new HashMap<>());

    // Assert that nothing has changed
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(0);
    assertEquals("Item Name", getResult.getName());
    BiItem getResult2 = items.get(1);
    assertEquals("Name", getResult2.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey("count"));
    assertTrue(attributes2.containsKey("Attribute"));
  }

  /**
   * Test {@link BiContext#updateItemCount(String, Map)} with {@code itemName},
   * {@code attributes}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#updateItemCount(String, Map)}
   */
  @Test
  public void testUpdateItemCountWithItemNameAttributes_thenBiContextItemsSizeIsOne() {
    // Arrange
    BiContext biContext = new BiContext();
    HashMap<String, Object> attributes = new HashMap<>();

    // Act
    biContext.updateItemCount("Item Name", attributes);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("Item Name", getResult.getName());
    assertSame(attributes, getResult.getAttributes());
  }

  /**
   * Test {@link BiContext#updateItemCount(String, Map)} with {@code itemName},
   * {@code attributes}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is
   * {@code Item Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#updateItemCount(String, Map)}
   */
  @Test
  public void testUpdateItemCountWithItemNameAttributes_thenBiContextItemsThirdNameIsItemName() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("Name", "Name"));
    biContext.addItem(new BiItem("Name", "Attribute"));
    HashMap<String, Object> attributes = new HashMap<>();

    // Act
    biContext.updateItemCount("Item Name", attributes);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes2 = items.get(0).getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey("Name"));
    assertSame(attributes, getResult.getAttributes());
  }

  /**
   * Test {@link BiContext#updateItemCount(String)} with {@code itemName}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} {@link BiItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#updateItemCount(String)}
   */
  @Test
  public void testUpdateItemCountWithItemName_thenBiContextItemsFirstAttributesCountBiItem() {
    // Arrange
    BiContext biContext = new BiContext();
    BiItem biItem = new BiItem("Item Name", new HashMap<>());

    biContext.addItemWithValue("Item Name", biItem);
    biContext.addItem(new BiItem("Name", "Attribute"));

    // Act
    biContext.updateItemCount("Item Name");

    // Assert that nothing has changed
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(1, attributes.size());
    Object getResult = attributes.get("count");
    assertTrue(getResult instanceof BiItem);
    assertSame(biItem, getResult);
  }

  /**
   * Test {@link BiContext#updateItemCount(String)} with {@code itemName}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#updateItemCount(String)}
   */
  @Test
  public void testUpdateItemCountWithItemName_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("Item Name", "Attribute"));

    // Act
    biContext.updateItemCount("Item Name");

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(1, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    assertTrue(attributes.containsKey("Attribute"));
  }

  /**
   * Test {@link BiContext#updateItemCount(String)} with {@code itemName}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is
   * {@code Item Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#updateItemCount(String)}
   */
  @Test
  public void testUpdateItemCountWithItemName_thenBiContextItemsFirstNameIsItemName() {
    // Arrange
    BiContext biContext = new BiContext();

    // Act
    biContext.updateItemCount("Item Name");

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link BiContext#updateItemCount(String)} with {@code itemName}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items second Name is
   * {@code Item Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#updateItemCount(String)}
   */
  @Test
  public void testUpdateItemCountWithItemName_thenBiContextItemsSecondNameIsItemName() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("Name", "Attribute"));

    // Act
    biContext.updateItemCount("Item Name");

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link BiContext#updateItemCount(String)} with {@code itemName}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#updateItemCount(String)}
   */
  @Test
  public void testUpdateItemCountWithItemName_thenBiContextItemsSizeIsThree() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("Name", "Name"));
    biContext.addItem(new BiItem("Name", "Attribute"));

    // Act
    biContext.updateItemCount("Item Name");

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link BiContext#updateItemWithMaxValue(String, Integer)}.
   * <ul>
   *   <li>Given {@link BiContext} (default constructor) addItemWithValue
   * {@code Item Name} and forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#updateItemWithMaxValue(String, Integer)}
   */
  @Test
  public void testUpdateItemWithMaxValue_givenBiContextAddItemWithValueItemNameAndFortyTwo() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItemWithValue("Item Name", 42);
    biContext.addItem(new BiItem("Name", "Attribute"));

    // Act
    biContext.updateItemWithMaxValue("Item Name", 42);

    // Assert that nothing has changed
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(42, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link BiContext#updateItemWithMaxValue(String, Integer)}.
   * <ul>
   *   <li>Given {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is
   * {@code Item Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#updateItemWithMaxValue(String, Integer)}
   */
  @Test
  public void testUpdateItemWithMaxValue_givenBiContext_thenBiContextItemsFirstNameIsItemName() {
    // Arrange
    BiContext biContext = new BiContext();

    // Act
    biContext.updateItemWithMaxValue("Item Name", 42);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(42, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link BiContext#updateItemWithMaxValue(String, Integer)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} is {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#updateItemWithMaxValue(String, Integer)}
   */
  @Test
  public void testUpdateItemWithMaxValue_thenBiContextItemsFirstAttributesCountIsItemValue() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItemWithValue("Item Name", "Item Value");
    biContext.addItem(new BiItem("Name", "Attribute"));

    // Act
    biContext.updateItemWithMaxValue("Item Name", 42);

    // Assert that nothing has changed
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("Item Value", attributes.get("count"));
  }

  /**
   * Test {@link BiContext#updateItemWithMaxValue(String, Integer)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#updateItemWithMaxValue(String, Integer)}
   */
  @Test
  public void testUpdateItemWithMaxValue_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("Item Name", "Attribute"));

    // Act
    biContext.updateItemWithMaxValue("Item Name", 42);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(1, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(42, ((Integer) attributes.get("count")).intValue());
    assertTrue(attributes.containsKey("Attribute"));
  }

  /**
   * Test {@link BiContext#updateItemWithMaxValue(String, Integer)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items second Name is
   * {@code Item Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#updateItemWithMaxValue(String, Integer)}
   */
  @Test
  public void testUpdateItemWithMaxValue_thenBiContextItemsSecondNameIsItemName() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("Name", "Attribute"));

    // Act
    biContext.updateItemWithMaxValue("Item Name", 42);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(42, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link BiContext#updateItemWithMaxValue(String, Integer)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#updateItemWithMaxValue(String, Integer)}
   */
  @Test
  public void testUpdateItemWithMaxValue_thenBiContextItemsSizeIsThree() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("Name", "Name"));
    biContext.addItem(new BiItem("Name", "Attribute"));

    // Act
    biContext.updateItemWithMaxValue("Item Name", 42);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(42, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link BiContext#isAttributeSet(String, String)}.
   * <ul>
   *   <li>Given {@link BiContext} (default constructor) addItem
   * {@link BiItem#BiItem(String, String)} with {@code Name} and attribute is
   * {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#isAttributeSet(String, String)}
   */
  @Test
  public void testIsAttributeSet_givenBiContextAddItemBiItemWithNameAndAttributeIsName() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("Name", "Name"));
    biContext.addItem(new BiItem("Name", "Attribute"));

    // Act and Assert
    assertFalse(biContext.isAttributeSet("Item Name", "Attribute Name"));
  }

  /**
   * Test {@link BiContext#isAttributeSet(String, String)}.
   * <ul>
   *   <li>Given {@link BiContext} (default constructor) addItemWithValue
   * {@code Item Name} and {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#isAttributeSet(String, String)}
   */
  @Test
  public void testIsAttributeSet_givenBiContextAddItemWithValueItemNameAndItemValue() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItemWithValue("Item Name", "Item Value");
    biContext.addItem(new BiItem("Name", "Attribute"));

    // Act and Assert
    assertFalse(biContext.isAttributeSet("Item Name", "Attribute Name"));
  }

  /**
   * Test {@link BiContext#isAttributeSet(String, String)}.
   * <ul>
   *   <li>Given {@link BiContext} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#isAttributeSet(String, String)}
   */
  @Test
  public void testIsAttributeSet_givenBiContext_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BiContext()).isAttributeSet("Item Name", "Attribute Name"));
  }

  /**
   * Test {@link BiContext#isAttributeSet(String, String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiContext#isAttributeSet(String, String)}
   */
  @Test
  public void testIsAttributeSet_thenReturnFalse() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("Name", "Attribute"));

    // Act and Assert
    assertFalse(biContext.isAttributeSet("Item Name", "Attribute Name"));
  }
}
