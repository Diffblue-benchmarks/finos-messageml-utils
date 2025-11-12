package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class MinMaxLengthElementDiffblueTest {
  /**
   * Test {@link MinMaxLengthElement#validateMinAndMaxLengths()}.
   *
   * <p>Method under test: {@link MinMaxLengthElement#validateMinAndMaxLengths()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MinMaxLengthElement.validateMinAndMaxLengths()"})
  public void testValidateMinAndMaxLengths() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    new TextArea(parent, FormatEnum.MESSAGEML).validateMinAndMaxLengths();
  }

  /**
   * Test {@link MinMaxLengthElement#validateInitialValueIfFound(Integer, Integer)}.
   *
   * <p>Method under test: {@link MinMaxLengthElement#validateInitialValueIfFound(Integer, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MinMaxLengthElement.validateInitialValueIfFound(Integer, Integer)"})
  public void testValidateInitialValueIfFound() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    new TextArea(parent, FormatEnum.MESSAGEML).validateInitialValueIfFound(3, 3);
  }

  /**
   * Test {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer, Integer)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer MinMaxLengthElement.getDefaultValueIfCurrentIsNull(Integer, Integer)"
  })
  public void testGetDefaultValueIfCurrentIsNull_whenFortyTwo_thenReturnIntValueIsFortyTwo() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertEquals(
        42,
        new TextArea(parent2, FormatEnum.MESSAGEML)
            .getDefaultValueIfCurrentIsNull(42, 42)
            .intValue());
  }

  /**
   * Test {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer, Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer MinMaxLengthElement.getDefaultValueIfCurrentIsNull(Integer, Integer)"
  })
  public void testGetDefaultValueIfCurrentIsNull_whenNull_thenReturnIntValueIsFortyTwo() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertEquals(
        42,
        new TextArea(parent2, FormatEnum.MESSAGEML)
            .getDefaultValueIfCurrentIsNull(null, 42)
            .intValue());
  }

  /**
   * Test {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer, Integer)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer MinMaxLengthElement.getDefaultValueIfCurrentIsNull(Integer, Integer)"
  })
  public void testGetDefaultValueIfCurrentIsNull_whenOne_thenReturnIntValueIsOne() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertEquals(
        1,
        new TextArea(parent2, FormatEnum.MESSAGEML)
            .getDefaultValueIfCurrentIsNull(1, 42)
            .intValue());
  }

  /**
   * Test {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer, Integer)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return intValue is three.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer MinMaxLengthElement.getDefaultValueIfCurrentIsNull(Integer, Integer)"
  })
  public void testGetDefaultValueIfCurrentIsNull_whenThree_thenReturnIntValueIsThree() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertEquals(
        3,
        new TextArea(parent2, FormatEnum.MESSAGEML)
            .getDefaultValueIfCurrentIsNull(3, 42)
            .intValue());
  }

  /**
   * Test {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer, Integer)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer MinMaxLengthElement.getDefaultValueIfCurrentIsNull(Integer, Integer)"
  })
  public void testGetDefaultValueIfCurrentIsNull_whenZero_thenReturnIntValueIsZero() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertEquals(
        0,
        new TextArea(parent2, FormatEnum.MESSAGEML)
            .getDefaultValueIfCurrentIsNull(0, 42)
            .intValue());
  }

  /**
   * Test {@link MinMaxLengthElement#isMinAndMaxLengthCombinationValid(Integer, Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#isMinAndMaxLengthCombinationValid(Integer,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MinMaxLengthElement.isMinAndMaxLengthCombinationValid(Integer, Integer)"
  })
  public void testIsMinAndMaxLengthCombinationValid_whenNull_thenReturnFalse() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertFalse(
        new TextArea(parent2, FormatEnum.MESSAGEML).isMinAndMaxLengthCombinationValid(3, null));
  }

  /**
   * Test {@link MinMaxLengthElement#isMinAndMaxLengthCombinationValid(Integer, Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#isMinAndMaxLengthCombinationValid(Integer,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MinMaxLengthElement.isMinAndMaxLengthCombinationValid(Integer, Integer)"
  })
  public void testIsMinAndMaxLengthCombinationValid_whenNull_thenReturnFalse2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertFalse(
        new TextArea(parent2, FormatEnum.MESSAGEML).isMinAndMaxLengthCombinationValid(null, 3));
  }

  /**
   * Test {@link MinMaxLengthElement#isMinAndMaxLengthCombinationValid(Integer, Integer)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#isMinAndMaxLengthCombinationValid(Integer,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MinMaxLengthElement.isMinAndMaxLengthCombinationValid(Integer, Integer)"
  })
  public void testIsMinAndMaxLengthCombinationValid_whenOne_thenReturnTrue() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertTrue(new TextArea(parent2, FormatEnum.MESSAGEML).isMinAndMaxLengthCombinationValid(3, 1));
  }

  /**
   * Test {@link MinMaxLengthElement#isMinAndMaxLengthCombinationValid(Integer, Integer)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#isMinAndMaxLengthCombinationValid(Integer,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MinMaxLengthElement.isMinAndMaxLengthCombinationValid(Integer, Integer)"
  })
  public void testIsMinAndMaxLengthCombinationValid_whenThree_thenReturnFalse() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertFalse(
        new TextArea(parent2, FormatEnum.MESSAGEML).isMinAndMaxLengthCombinationValid(3, 3));
  }

  /**
   * Test {@link MinMaxLengthElement#isTextBiggerThanMaxLength(Integer, String)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#isTextBiggerThanMaxLength(Integer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MinMaxLengthElement.isTextBiggerThanMaxLength(Integer, String)"})
  public void testIsTextBiggerThanMaxLength_whenFour_thenReturnFalse() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertFalse(new TextArea(parent2, FormatEnum.MESSAGEML).isTextBiggerThanMaxLength(4, "Text"));
  }

  /**
   * Test {@link MinMaxLengthElement#isTextBiggerThanMaxLength(Integer, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#isTextBiggerThanMaxLength(Integer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MinMaxLengthElement.isTextBiggerThanMaxLength(Integer, String)"})
  public void testIsTextBiggerThanMaxLength_whenNull_thenReturnFalse() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertFalse(
        new TextArea(parent2, FormatEnum.MESSAGEML).isTextBiggerThanMaxLength(null, "Text"));
  }

  /**
   * Test {@link MinMaxLengthElement#isTextBiggerThanMaxLength(Integer, String)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#isTextBiggerThanMaxLength(Integer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MinMaxLengthElement.isTextBiggerThanMaxLength(Integer, String)"})
  public void testIsTextBiggerThanMaxLength_whenThree_thenReturnFalse() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertFalse(new TextArea(parent2, FormatEnum.MESSAGEML).isTextBiggerThanMaxLength(3, null));
  }

  /**
   * Test {@link MinMaxLengthElement#isTextBiggerThanMaxLength(Integer, String)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#isTextBiggerThanMaxLength(Integer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MinMaxLengthElement.isTextBiggerThanMaxLength(Integer, String)"})
  public void testIsTextBiggerThanMaxLength_whenThree_thenReturnTrue() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertTrue(new TextArea(parent2, FormatEnum.MESSAGEML).isTextBiggerThanMaxLength(3, "Text"));
  }

  /**
   * Test {@link MinMaxLengthElement#isTextSmallerThanMinLength(Integer, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#isTextSmallerThanMinLength(Integer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MinMaxLengthElement.isTextSmallerThanMinLength(Integer, String)"})
  public void testIsTextSmallerThanMinLength_when42_thenReturnTrue() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertTrue(new TextArea(parent2, FormatEnum.MESSAGEML).isTextSmallerThanMinLength(3, "42"));
  }

  /**
   * Test {@link MinMaxLengthElement#isTextSmallerThanMinLength(Integer, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#isTextSmallerThanMinLength(Integer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MinMaxLengthElement.isTextSmallerThanMinLength(Integer, String)"})
  public void testIsTextSmallerThanMinLength_whenNull_thenReturnFalse() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertFalse(new TextArea(parent2, FormatEnum.MESSAGEML).isTextSmallerThanMinLength(3, null));
  }

  /**
   * Test {@link MinMaxLengthElement#isTextSmallerThanMinLength(Integer, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#isTextSmallerThanMinLength(Integer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MinMaxLengthElement.isTextSmallerThanMinLength(Integer, String)"})
  public void testIsTextSmallerThanMinLength_whenNull_thenReturnFalse2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertFalse(
        new TextArea(parent2, FormatEnum.MESSAGEML).isTextSmallerThanMinLength(null, "Text"));
  }

  /**
   * Test {@link MinMaxLengthElement#isTextSmallerThanMinLength(Integer, String)}.
   *
   * <ul>
   *   <li>When {@code Text}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#isTextSmallerThanMinLength(Integer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MinMaxLengthElement.isTextSmallerThanMinLength(Integer, String)"})
  public void testIsTextSmallerThanMinLength_whenText_thenReturnFalse() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertFalse(new TextArea(parent2, FormatEnum.MESSAGEML).isTextSmallerThanMinLength(3, "Text"));
  }

  /**
   * Test {@link MinMaxLengthElement#getAttributeAsInteger(String)}.
   *
   * <p>Method under test: {@link MinMaxLengthElement#getAttributeAsInteger(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer MinMaxLengthElement.getAttributeAsInteger(String)"})
  public void testGetAttributeAsInteger() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertNull(new TextArea(parent2, FormatEnum.MESSAGEML).getAttributeAsInteger("Attribute Name"));
  }

  /**
   * Test {@link MinMaxLengthElement#isLengthOutOfRange(Integer)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#isLengthOutOfRange(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MinMaxLengthElement.isLengthOutOfRange(Integer)"})
  public void testIsLengthOutOfRange_whenMinusOne_thenReturnTrue() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertTrue(new TextArea(parent2, FormatEnum.MESSAGEML).isLengthOutOfRange(-1));
  }

  /**
   * Test {@link MinMaxLengthElement#isLengthOutOfRange(Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#isLengthOutOfRange(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MinMaxLengthElement.isLengthOutOfRange(Integer)"})
  public void testIsLengthOutOfRange_whenNull_thenReturnFalse() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertFalse(new TextArea(parent2, FormatEnum.MESSAGEML).isLengthOutOfRange(null));
  }

  /**
   * Test {@link MinMaxLengthElement#isLengthOutOfRange(Integer)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MinMaxLengthElement#isLengthOutOfRange(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MinMaxLengthElement.isLengthOutOfRange(Integer)"})
  public void testIsLengthOutOfRange_whenThree_thenReturnFalse() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertFalse(new TextArea(parent2, FormatEnum.MESSAGEML).isLengthOutOfRange(3));
  }

  /**
   * Test {@link MinMaxLengthElement#getLengthErrorMessage(String)}.
   *
   * <p>Method under test: {@link MinMaxLengthElement#getLengthErrorMessage(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MinMaxLengthElement.getLengthErrorMessage(String)"})
  public void testGetLengthErrorMessage() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertEquals(
        "The attribute \"Attribute Name\" must be between 0 and 10000",
        new TextArea(parent2, FormatEnum.MESSAGEML).getLengthErrorMessage("Attribute Name"));
  }
}
