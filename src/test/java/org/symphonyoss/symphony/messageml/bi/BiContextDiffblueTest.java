package org.symphonyoss.symphony.messageml.bi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;

public class BiContextDiffblueTest {
  /**
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
   * Method under test: {@link BiContext#addItem(BiItem)}
   */
  @Test
  public void testAddItem2() {
    // Arrange
    BiContext biContext = new BiContext();

    HashMap<String, Object> attributes = new HashMap<>();
    attributes.computeIfPresent("foo", mock(BiFunction.class));
    BiItem item = new BiItem("Name", attributes);

    // Act
    biContext.addItem(item);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(1, items.size());
    assertSame(item, items.get(0));
  }

  /**
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
   * Method under test: {@link BiContext#updateItemCount(String)}
   */
  @Test
  public void testUpdateItemCount() {
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
    assertTrue(attributes.containsKey("count"));
  }

  /**
   * Method under test: {@link BiContext#updateItemCount(String)}
   */
  @Test
  public void testUpdateItemCount2() {
    // Arrange
    BiContext biContext = new BiContext();
    BiItem item = new BiItem("Name", "Attribute");

    biContext.addItem(item);

    // Act
    biContext.updateItemCount("Item Name");

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
  }

  /**
   * Method under test: {@link BiContext#updateItemCount(String)}
   */
  @Test
  public void testUpdateItemCount3() {
    // Arrange
    BiContext biContext = new BiContext();
    BiItem item = new BiItem("Name", "Name");

    biContext.addItem(item);
    BiItem item2 = new BiItem("Name", "Attribute");

    biContext.addItem(item2);

    // Act
    biContext.updateItemCount("Item Name");

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item2, items.get(1));
    assertSame(item, items.get(0));
  }

  /**
   * Method under test: {@link BiContext#updateItemCount(String)}
   */
  @Test
  public void testUpdateItemCount4() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItemWithValue("Item Name", "Item Value");
    BiItem item = new BiItem("Name", "Attribute");

    biContext.addItem(item);

    // Act
    biContext.updateItemCount("Item Name");

    // Assert that nothing has changed
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(0);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
  }

  /**
   * Method under test: {@link BiContext#updateItemCount(String)}
   */
  @Test
  public void testUpdateItemCount5() {
    // Arrange
    BiContext biContext = new BiContext();
    BiItem item = new BiItem("Item Name", "Attribute");

    biContext.addItem(item);

    // Act
    biContext.updateItemCount("Item Name");

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(1, items.size());
    assertSame(item, items.get(0));
  }

  /**
   * Method under test: {@link BiContext#updateItemCount(String)}
   */
  @Test
  public void testUpdateItemCount6() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItemWithValue("Item Name", new BiItem("Item Name", new HashMap<>()));
    BiItem item = new BiItem("Name", "Attribute");

    biContext.addItem(item);

    // Act
    biContext.updateItemCount("Item Name");

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(0);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
  }

  /**
   * Method under test: {@link BiContext#updateItemCount(String)}
   */
  @Test
  public void testUpdateItemCount7() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
    attributes.computeIfPresent("Item Name", mock(BiFunction.class));
    BiItem biItem = new BiItem("Item Name", attributes);

    BiContext biContext = new BiContext();
    biContext.addItemWithValue("Item Name", biItem);
    BiItem item = new BiItem("Name", "Attribute");

    biContext.addItem(item);

    // Act
    biContext.updateItemCount("Item Name");

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(0);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey("count"));
    assertSame(item, items.get(1));
  }

  /**
   * Method under test: {@link BiContext#updateItemCount(String, String)}
   */
  @Test
  public void testUpdateItemCount8() {
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
    assertTrue(attributes.containsKey("Attribute Name"));
  }

  /**
   * Method under test: {@link BiContext#updateItemCount(String, String)}
   */
  @Test
  public void testUpdateItemCount9() {
    // Arrange
    BiContext biContext = new BiContext();
    BiItem item = new BiItem("Name", "Attribute");

    biContext.addItem(item);

    // Act
    biContext.updateItemCount("Item Name", "Attribute Name");

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("Attribute Name"));
    assertSame(item, items.get(0));
  }

  /**
   * Method under test: {@link BiContext#updateItemCount(String, String)}
   */
  @Test
  public void testUpdateItemCount10() {
    // Arrange
    BiContext biContext = new BiContext();
    BiItem item = new BiItem("Name", "Name");

    biContext.addItem(item);
    BiItem item2 = new BiItem("Name", "Attribute");

    biContext.addItem(item2);

    // Act
    biContext.updateItemCount("Item Name", "Attribute Name");

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("Attribute Name"));
    assertSame(item2, items.get(1));
    assertSame(item, items.get(0));
  }

  /**
   * Method under test: {@link BiContext#updateItemCount(String, String)}
   */
  @Test
  public void testUpdateItemCount11() {
    // Arrange
    BiContext biContext = new BiContext();
    BiItem item = new BiItem("Item Name", "Attribute");

    biContext.addItem(item);

    // Act
    biContext.updateItemCount("Item Name", "Attribute Name");

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(1, items.size());
    assertSame(item, items.get(0));
  }

  /**
   * Method under test: {@link BiContext#updateItemCount(String, Map)}
   */
  @Test
  public void testUpdateItemCount12() {
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
   * Method under test: {@link BiContext#updateItemCount(String, Map)}
   */
  @Test
  public void testUpdateItemCount13() {
    // Arrange
    BiContext biContext = new BiContext();
    BiItem item = new BiItem("Name", "Attribute");

    biContext.addItem(item);
    HashMap<String, Object> attributes = new HashMap<>();

    // Act
    biContext.updateItemCount("Item Name", attributes);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("Item Name", getResult.getName());
    assertSame(attributes, getResult.getAttributes());
    assertSame(item, items.get(0));
  }

  /**
   * Method under test: {@link BiContext#updateItemCount(String, Map)}
   */
  @Test
  public void testUpdateItemCount14() {
    // Arrange
    BiContext biContext = new BiContext();
    BiItem item = new BiItem("Name", "Name");

    biContext.addItem(item);
    BiItem item2 = new BiItem("Name", "Attribute");

    biContext.addItem(item2);
    HashMap<String, Object> attributes = new HashMap<>();

    // Act
    biContext.updateItemCount("Item Name", attributes);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("Item Name", getResult.getName());
    assertSame(attributes, getResult.getAttributes());
    assertSame(item2, items.get(1));
    assertSame(item, items.get(0));
  }

  /**
   * Method under test: {@link BiContext#updateItemCount(String, Map)}
   */
  @Test
  public void testUpdateItemCount15() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItemWithValue("Item Name", "Item Value");
    BiItem item = new BiItem("Name", "Attribute");

    biContext.addItem(item);

    // Act
    biContext.updateItemCount("Item Name", new HashMap<>());

    // Assert that nothing has changed
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(0);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
  }

  /**
   * Method under test: {@link BiContext#updateItemCount(String, Map)}
   */
  @Test
  public void testUpdateItemCount16() {
    // Arrange
    BiContext biContext = new BiContext();
    BiItem item = new BiItem("Item Name", "Item Name");

    biContext.addItem(item);
    biContext.addItemWithValue("Item Name", "Item Value");
    BiItem item2 = new BiItem("Name", "Attribute");

    biContext.addItem(item2);

    HashMap<String, Object> attributes = new HashMap<>();
    attributes.put("Item Name", "42");

    // Act
    biContext.updateItemCount("Item Name", attributes);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(1);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(item2, items.get(2));
  }

  /**
   * Method under test: {@link BiContext#updateItemCount(String, Map)}
   */
  @Test
  public void testUpdateItemCount17() {
    // Arrange
    BiContext biContext = new BiContext();
    BiItem item = new BiItem("Item Name", "Attribute");

    biContext.addItem(item);
    biContext.addItemWithValue("Item Name", "Item Value");
    BiItem item2 = new BiItem("Name", "Attribute");

    biContext.addItem(item2);

    HashMap<String, Object> attributes = new HashMap<>();
    attributes.put("Item Name", "42");

    // Act
    biContext.updateItemCount("Item Name", attributes);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(1);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(item2, items.get(2));
  }

  /**
   * Method under test: {@link BiContext#updateItemWithMaxValue(String, Integer)}
   */
  @Test
  public void testUpdateItemWithMaxValue() {
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
    assertTrue(attributes.containsKey("count"));
  }

  /**
   * Method under test: {@link BiContext#updateItemWithMaxValue(String, Integer)}
   */
  @Test
  public void testUpdateItemWithMaxValue2() {
    // Arrange
    BiContext biContext = new BiContext();
    BiItem item = new BiItem("Name", "Attribute");

    biContext.addItem(item);

    // Act
    biContext.updateItemWithMaxValue("Item Name", 42);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
  }

  /**
   * Method under test: {@link BiContext#updateItemWithMaxValue(String, Integer)}
   */
  @Test
  public void testUpdateItemWithMaxValue3() {
    // Arrange
    BiContext biContext = new BiContext();
    BiItem item = new BiItem("Name", "Name");

    biContext.addItem(item);
    BiItem item2 = new BiItem("Name", "Attribute");

    biContext.addItem(item2);

    // Act
    biContext.updateItemWithMaxValue("Item Name", 42);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item2, items.get(1));
    assertSame(item, items.get(0));
  }

  /**
   * Method under test: {@link BiContext#updateItemWithMaxValue(String, Integer)}
   */
  @Test
  public void testUpdateItemWithMaxValue4() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItemWithValue("Item Name", "Item Value");
    BiItem item = new BiItem("Name", "Attribute");

    biContext.addItem(item);

    // Act
    biContext.updateItemWithMaxValue("Item Name", 42);

    // Assert that nothing has changed
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(0);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
  }

  /**
   * Method under test: {@link BiContext#updateItemWithMaxValue(String, Integer)}
   */
  @Test
  public void testUpdateItemWithMaxValue5() {
    // Arrange
    BiContext biContext = new BiContext();
    BiItem item = new BiItem("Item Name", "Attribute");

    biContext.addItem(item);

    // Act
    biContext.updateItemWithMaxValue("Item Name", 42);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(1, items.size());
    assertSame(item, items.get(0));
  }

  /**
   * Method under test: {@link BiContext#updateItemWithMaxValue(String, Integer)}
   */
  @Test
  public void testUpdateItemWithMaxValue6() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItemWithValue("Item Name", 42);
    BiItem item = new BiItem("Name", "Attribute");

    biContext.addItem(item);

    // Act
    biContext.updateItemWithMaxValue("Item Name", 42);

    // Assert that nothing has changed
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(0);
    assertEquals("Item Name", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
  }

  /**
   * Method under test: {@link BiContext#isAttributeSet(String, String)}
   */
  @Test
  public void testIsAttributeSet() {
    // Arrange, Act and Assert
    assertFalse((new BiContext()).isAttributeSet("Item Name", "Attribute Name"));
  }

  /**
   * Method under test: {@link BiContext#isAttributeSet(String, String)}
   */
  @Test
  public void testIsAttributeSet2() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("Name", "Attribute"));

    // Act and Assert
    assertFalse(biContext.isAttributeSet("Item Name", "Attribute Name"));
  }

  /**
   * Method under test: {@link BiContext#isAttributeSet(String, String)}
   */
  @Test
  public void testIsAttributeSet3() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("Name", "Name"));
    biContext.addItem(new BiItem("Name", "Attribute"));

    // Act and Assert
    assertFalse(biContext.isAttributeSet("Item Name", "Attribute Name"));
  }

  /**
   * Method under test: {@link BiContext#isAttributeSet(String, String)}
   */
  @Test
  public void testIsAttributeSet4() {
    // Arrange
    BiContext biContext = new BiContext();
    biContext.addItemWithValue("Item Name", "Item Value");
    biContext.addItem(new BiItem("Name", "Attribute"));

    // Act and Assert
    assertFalse(biContext.isAttributeSet("Item Name", "Attribute Name"));
  }

  /**
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
}
