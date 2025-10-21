package org.symphonyoss.symphony.messageml.bi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BiItemDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BiItem#BiItem(String, Map)}
   *   <li>{@link BiItem#getAttributes()}
   *   <li>{@link BiItem#getName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BiItem.<init>(String, Map)", "Map BiItem.getAttributes()", "String BiItem.getName()"})
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
   * Test {@link BiItem#BiItem(String, String)}.
   * <p>
   * Method under test: {@link BiItem#BiItem(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BiItem.<init>(String, String)"})
  public void testNewBiItem() {
    // Arrange and Act
    BiItem actualBiItem = new BiItem("Name", "Attribute");

    // Assert
    assertEquals("Name", actualBiItem.getName());
    Map<String, Object> attributes = actualBiItem.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("Attribute")).intValue());
  }

  /**
   * Test {@link BiItem#increaseAttributeCount(String)}.
   * <p>
   * Method under test: {@link BiItem#increaseAttributeCount(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BiItem.increaseAttributeCount(String)"})
  public void testIncreaseAttributeCount() {
    // Arrange
    BiItem biItem = new BiItem("Name", "Attribute");

    // Act
    biItem.increaseAttributeCount("Attribute Name");

    // Assert
    Map<String, Object> attributes = biItem.getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(1, ((Integer) attributes.get("Attribute Name")).intValue());
    assertTrue(attributes.containsKey("Attribute"));
  }

  /**
   * Test {@link BiItem#setMaxAttribute(String, Integer)}.
   * <ul>
   *   <li>Then {@link BiItem#BiItem(String, String)} with {@code Name} and {@code Attribute} Attributes size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiItem#setMaxAttribute(String, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BiItem.setMaxAttribute(String, Integer)"})
  public void testSetMaxAttribute_thenBiItemWithNameAndAttributeAttributesSizeIsTwo() {
    // Arrange
    BiItem biItem = new BiItem("Name", "Attribute");

    // Act
    biItem.setMaxAttribute("Attribute Name", 42);

    // Assert
    Map<String, Object> attributes = biItem.getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(42, ((Integer) attributes.get("Attribute Name")).intValue());
    assertTrue(attributes.containsKey("Attribute"));
  }

  /**
   * Test {@link BiItem#setMaxAttribute(String, Integer)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then {@link BiItem#BiItem(String, String)} with {@code Name} and {@code Attribute} Attributes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiItem#setMaxAttribute(String, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BiItem.setMaxAttribute(String, Integer)"})
  public void testSetMaxAttribute_whenZero_thenBiItemWithNameAndAttributeAttributesSizeIsOne() {
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
   * Test {@link BiItem#equals(Object)}, and {@link BiItem#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BiItem#equals(Object)}
   *   <li>{@link BiItem#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BiItem.equals(Object)", "int BiItem.hashCode()"})
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
   * Test {@link BiItem#equals(Object)}, and {@link BiItem#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BiItem#equals(Object)}
   *   <li>{@link BiItem#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BiItem.equals(Object)", "int BiItem.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BiItem biItem = new BiItem("Name", "Attribute");

    // Act and Assert
    assertEquals(biItem, biItem);
    int expectedHashCodeResult = biItem.hashCode();
    assertEquals(expectedHashCodeResult, biItem.hashCode());
  }

  /**
   * Test {@link BiItem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiItem#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BiItem.equals(Object)", "int BiItem.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BiItem biItem = new BiItem(null, "Attribute");

    // Act and Assert
    assertNotEquals(biItem, new BiItem("Name", "Attribute"));
  }

  /**
   * Test {@link BiItem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiItem#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BiItem.equals(Object)", "int BiItem.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BiItem biItem = new BiItem("Name", (String) null);

    // Act and Assert
    assertNotEquals(biItem, new BiItem("Name", "Attribute"));
  }

  /**
   * Test {@link BiItem#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiItem#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BiItem.equals(Object)", "int BiItem.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BiItem("Name", "Attribute"), null);
  }

  /**
   * Test {@link BiItem#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BiItem#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BiItem.equals(Object)", "int BiItem.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BiItem("Name", "Attribute"), "Different type to BiItem");
  }
}
