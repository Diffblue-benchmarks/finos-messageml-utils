package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class MinMaxLengthElementDiffblueTest {
  /**
   * Test {@link MinMaxLengthElement#validateMinAndMaxLengths()}.
   * <p>
   * Method under test: {@link MinMaxLengthElement#validateMinAndMaxLengths()}
   */
  @Test
  public void testValidateMinAndMaxLengths() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).validateMinAndMaxLengths();
  }

  /**
   * Test
   * {@link MinMaxLengthElement#validateInitialValueIfFound(Integer, Integer)}.
   * <p>
   * Method under test:
   * {@link MinMaxLengthElement#validateInitialValueIfFound(Integer, Integer)}
   */
  @Test
  public void testValidateInitialValueIfFound() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).validateInitialValueIfFound(3,
        3);
  }

  /**
   * Test
   * {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer, Integer)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer, Integer)}
   */
  @Test
  public void testGetDefaultValueIfCurrentIsNull_whenFortyTwo_thenReturnIntValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42,
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
            .getDefaultValueIfCurrentIsNull(42, 42)
            .intValue());
  }

  /**
   * Test
   * {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer, Integer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer, Integer)}
   */
  @Test
  public void testGetDefaultValueIfCurrentIsNull_whenNull_thenReturnIntValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42,
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
            .getDefaultValueIfCurrentIsNull(null, 42)
            .intValue());
  }

  /**
   * Test
   * {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer, Integer)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer, Integer)}
   */
  @Test
  public void testGetDefaultValueIfCurrentIsNull_whenOne_thenReturnIntValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1,
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
            .getDefaultValueIfCurrentIsNull(1, 42)
            .intValue());
  }

  /**
   * Test
   * {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer, Integer)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return intValue is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer, Integer)}
   */
  @Test
  public void testGetDefaultValueIfCurrentIsNull_whenThree_thenReturnIntValueIsThree() {
    // Arrange, Act and Assert
    assertEquals(3,
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
            .getDefaultValueIfCurrentIsNull(3, 42)
            .intValue());
  }

  /**
   * Test
   * {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer, Integer)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer, Integer)}
   */
  @Test
  public void testGetDefaultValueIfCurrentIsNull_whenZero_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
            .getDefaultValueIfCurrentIsNull(0, 42)
            .intValue());
  }

  /**
   * Test
   * {@link MinMaxLengthElement#isMinAndMaxLengthCombinationValid(Integer, Integer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MinMaxLengthElement#isMinAndMaxLengthCombinationValid(Integer, Integer)}
   */
  @Test
  public void testIsMinAndMaxLengthCombinationValid_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isMinAndMaxLengthCombinationValid(null, null));
    assertFalse((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isMinAndMaxLengthCombinationValid(3, null));
  }

  /**
   * Test
   * {@link MinMaxLengthElement#isMinAndMaxLengthCombinationValid(Integer, Integer)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MinMaxLengthElement#isMinAndMaxLengthCombinationValid(Integer, Integer)}
   */
  @Test
  public void testIsMinAndMaxLengthCombinationValid_whenOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isMinAndMaxLengthCombinationValid(3, 1));
  }

  /**
   * Test
   * {@link MinMaxLengthElement#isMinAndMaxLengthCombinationValid(Integer, Integer)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MinMaxLengthElement#isMinAndMaxLengthCombinationValid(Integer, Integer)}
   */
  @Test
  public void testIsMinAndMaxLengthCombinationValid_whenThree_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isMinAndMaxLengthCombinationValid(3, 3));
  }

  /**
   * Test {@link MinMaxLengthElement#isTextBiggerThanMaxLength(Integer, String)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MinMaxLengthElement#isTextBiggerThanMaxLength(Integer, String)}
   */
  @Test
  public void testIsTextBiggerThanMaxLength_whenFour_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isTextBiggerThanMaxLength(4, "Text"));
  }

  /**
   * Test {@link MinMaxLengthElement#isTextBiggerThanMaxLength(Integer, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MinMaxLengthElement#isTextBiggerThanMaxLength(Integer, String)}
   */
  @Test
  public void testIsTextBiggerThanMaxLength_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isTextBiggerThanMaxLength(null, null));
    assertFalse((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isTextBiggerThanMaxLength(null, "Text"));
  }

  /**
   * Test {@link MinMaxLengthElement#isTextBiggerThanMaxLength(Integer, String)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MinMaxLengthElement#isTextBiggerThanMaxLength(Integer, String)}
   */
  @Test
  public void testIsTextBiggerThanMaxLength_whenThree_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isTextBiggerThanMaxLength(3, "Text"));
  }

  /**
   * Test {@link MinMaxLengthElement#isTextSmallerThanMinLength(Integer, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MinMaxLengthElement#isTextSmallerThanMinLength(Integer, String)}
   */
  @Test
  public void testIsTextSmallerThanMinLength_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isTextSmallerThanMinLength(3, "42"));
  }

  /**
   * Test {@link MinMaxLengthElement#isTextSmallerThanMinLength(Integer, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MinMaxLengthElement#isTextSmallerThanMinLength(Integer, String)}
   */
  @Test
  public void testIsTextSmallerThanMinLength_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isTextSmallerThanMinLength(null, null));
    assertFalse((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isTextSmallerThanMinLength(null, "Text"));
  }

  /**
   * Test {@link MinMaxLengthElement#isTextSmallerThanMinLength(Integer, String)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MinMaxLengthElement#isTextSmallerThanMinLength(Integer, String)}
   */
  @Test
  public void testIsTextSmallerThanMinLength_whenThree_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isTextSmallerThanMinLength(3, "Text"));
  }

  /**
   * Test {@link MinMaxLengthElement#getAttributeAsInteger(String)}.
   * <p>
   * Method under test: {@link MinMaxLengthElement#getAttributeAsInteger(String)}
   */
  @Test
  public void testGetAttributeAsInteger() throws InvalidInputException {
    // Arrange, Act and Assert
    assertNull((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .getAttributeAsInteger("Attribute Name"));
  }

  /**
   * Test {@link MinMaxLengthElement#isLengthOutOfRange(Integer)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MinMaxLengthElement#isLengthOutOfRange(Integer)}
   */
  @Test
  public void testIsLengthOutOfRange_whenMinusOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).isLengthOutOfRange(-1));
  }

  /**
   * Test {@link MinMaxLengthElement#isLengthOutOfRange(Integer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MinMaxLengthElement#isLengthOutOfRange(Integer)}
   */
  @Test
  public void testIsLengthOutOfRange_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).isLengthOutOfRange(null));
  }

  /**
   * Test {@link MinMaxLengthElement#isLengthOutOfRange(Integer)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MinMaxLengthElement#isLengthOutOfRange(Integer)}
   */
  @Test
  public void testIsLengthOutOfRange_whenThree_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).isLengthOutOfRange(3));
  }

  /**
   * Test {@link MinMaxLengthElement#getLengthErrorMessage(String)}.
   * <p>
   * Method under test: {@link MinMaxLengthElement#getLengthErrorMessage(String)}
   */
  @Test
  public void testGetLengthErrorMessage() {
    // Arrange, Act and Assert
    assertEquals("The attribute \"Attribute Name\" must be between 0 and 10000",
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
            .getLengthErrorMessage("Attribute Name"));
  }
}
