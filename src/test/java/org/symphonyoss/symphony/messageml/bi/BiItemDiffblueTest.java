package org.symphonyoss.symphony.messageml.bi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;

public class BiItemDiffblueTest {
  /**
   * Method under test: {@link BiItem#increaseAttributeCount(String)}
   */
  @Test
  public void testIncreaseAttributeCount() {
    // Arrange
    BiItem biItem = new BiItem("Name", "Attribute");

    // Act
    biItem.increaseAttributeCount("Attribute Name");

    // Assert
    Map<String, Object> attributes = biItem.getAttributes();
    assertEquals(2, attributes.size());
    assertTrue(attributes.containsKey("Attribute Name"));
    assertTrue(attributes.containsKey("Attribute"));
  }

  /**
   * Method under test: {@link BiItem#increaseAttributeCount(String)}
   */
  @Test
  public void testIncreaseAttributeCount2() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
    attributes.computeIfPresent("foo", mock(BiFunction.class));
    BiItem biItem = new BiItem("Name", attributes);

    // Act
    biItem.increaseAttributeCount("Attribute Name");

    // Assert
    Map<String, Object> attributes2 = biItem.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey("Attribute Name"));
    assertSame(attributes, attributes2);
  }

  /**
   * Method under test: {@link BiItem#increaseAttributeCount(String)}
   */
  @Test
  public void testIncreaseAttributeCount3() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
    attributes.put("42", "42");
    attributes.computeIfPresent("foo", mock(BiFunction.class));
    BiItem biItem = new BiItem("Name", attributes);

    // Act
    biItem.increaseAttributeCount("42");

    // Assert that nothing has changed
    Map<String, Object> attributes2 = biItem.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey("42"));
    assertSame(attributes, attributes2);
  }

  /**
   * Method under test: {@link BiItem#increaseAttributeCount(String)}
   */
  @Test
  public void testIncreaseAttributeCount4() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();
    attributes.put("42", "");
    attributes.computeIfPresent("foo", mock(BiFunction.class));
    BiItem biItem = new BiItem("Name", attributes);

    // Act
    biItem.increaseAttributeCount("42");

    // Assert
    Map<String, Object> attributes2 = biItem.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey("42"));
    assertSame(attributes, attributes2);
  }

  /**
   * Method under test: {@link BiItem#setMaxAttribute(String, Integer)}
   */
  @Test
  public void testSetMaxAttribute() {
    // Arrange
    BiItem biItem = new BiItem("Name", "Attribute");

    // Act
    biItem.setMaxAttribute("Attribute Name", 42);

    // Assert
    Map<String, Object> attributes = biItem.getAttributes();
    assertEquals(2, attributes.size());
    assertTrue(attributes.containsKey("Attribute Name"));
    assertTrue(attributes.containsKey("Attribute"));
  }

  /**
   * Method under test: {@link BiItem#setMaxAttribute(String, Integer)}
   */
  @Test
  public void testSetMaxAttribute2() {
    // Arrange
    BiItem biItem = new BiItem("Name", "Attribute");

    // Act
    biItem.setMaxAttribute("Attribute Name", 0);

    // Assert that nothing has changed
    Map<String, Object> attributes = biItem.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("Attribute"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BiItem#equals(Object)}
   *   <li>{@link BiItem#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BiItem biItem = new BiItem("Name", "Attribute");
    BiItem biItem2 = new BiItem("Name", "Attribute");

    // Act and Assert
    assertEquals(biItem, biItem2);
    int expectedHashCodeResult = biItem.hashCode();
    assertEquals(expectedHashCodeResult, biItem2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BiItem#equals(Object)}
   *   <li>{@link BiItem#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BiItem biItem = new BiItem("Name", "Attribute");

    // Act and Assert
    assertEquals(biItem, biItem);
    int expectedHashCodeResult = biItem.hashCode();
    assertEquals(expectedHashCodeResult, biItem.hashCode());
  }

  /**
   * Method under test: {@link BiItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BiItem biItem = new BiItem(null, "Attribute");

    // Act and Assert
    assertNotEquals(biItem, new BiItem("Name", "Attribute"));
  }

  /**
   * Method under test: {@link BiItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BiItem biItem = new BiItem("Name", (String) null);

    // Act and Assert
    assertNotEquals(biItem, new BiItem("Name", "Attribute"));
  }

  /**
   * Method under test: {@link BiItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BiItem("Name", "Attribute"), null);
  }

  /**
   * Method under test: {@link BiItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BiItem("Name", "Attribute"), "Different type to BiItem");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BiItem#BiItem(String, Map)}
   *   <li>{@link BiItem#getAttributes()}
   *   <li>{@link BiItem#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    HashMap<String, Object> attributes = new HashMap<>();

    // Act
    BiItem actualBiItem = new BiItem("Name", attributes);
    Map<String, Object> actualAttributes = actualBiItem.getAttributes();

    // Assert
    assertEquals("Name", actualBiItem.getName());
    assertTrue(actualAttributes.isEmpty());
    assertSame(attributes, actualAttributes);
  }

  /**
   * Method under test: {@link BiItem#BiItem(String, String)}
   */
  @Test
  public void testNewBiItem() {
    // Arrange and Act
    BiItem actualBiItem = new BiItem("Name", "Attribute");

    // Assert
    assertEquals("Name", actualBiItem.getName());
    Map<String, Object> attributes = actualBiItem.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("Attribute"));
  }
}
