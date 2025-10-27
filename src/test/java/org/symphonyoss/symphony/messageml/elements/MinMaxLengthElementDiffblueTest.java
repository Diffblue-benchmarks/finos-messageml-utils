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
   * Method under test:
   * {@link MinMaxLengthElement#getDefaultValueIfCurrentIsNull(Integer, Integer)}
   */
  @Test
  public void testGetDefaultValueIfCurrentIsNull() {
    // Arrange, Act and Assert
    assertEquals(42,
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
            .getDefaultValueIfCurrentIsNull(42, 42)
            .intValue());
    assertEquals(42,
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
            .getDefaultValueIfCurrentIsNull(null, 42)
            .intValue());
    assertEquals(3,
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
            .getDefaultValueIfCurrentIsNull(3, 42)
            .intValue());
    assertEquals(1,
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
            .getDefaultValueIfCurrentIsNull(1, 42)
            .intValue());
    assertEquals(0,
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
            .getDefaultValueIfCurrentIsNull(0, 42)
            .intValue());
  }

  /**
   * Method under test:
   * {@link MinMaxLengthElement#isMinAndMaxLengthCombinationValid(Integer, Integer)}
   */
  @Test
  public void testIsMinAndMaxLengthCombinationValid() {
    // Arrange, Act and Assert
    assertFalse((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isMinAndMaxLengthCombinationValid(3, 3));
    assertFalse((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isMinAndMaxLengthCombinationValid(null, null));
    assertFalse((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isMinAndMaxLengthCombinationValid(3, null));
    assertTrue((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isMinAndMaxLengthCombinationValid(3, 1));
  }

  /**
   * Method under test:
   * {@link MinMaxLengthElement#isTextBiggerThanMaxLength(Integer, String)}
   */
  @Test
  public void testIsTextBiggerThanMaxLength() {
    // Arrange, Act and Assert
    assertTrue((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isTextBiggerThanMaxLength(3, "Text"));
    assertFalse((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isTextBiggerThanMaxLength(null, null));
    assertFalse((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isTextBiggerThanMaxLength(null, "Text"));
    assertFalse((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isTextBiggerThanMaxLength(4, "Text"));
  }

  /**
   * Method under test:
   * {@link MinMaxLengthElement#isTextSmallerThanMinLength(Integer, String)}
   */
  @Test
  public void testIsTextSmallerThanMinLength() {
    // Arrange, Act and Assert
    assertFalse((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isTextSmallerThanMinLength(3, "Text"));
    assertFalse((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isTextSmallerThanMinLength(null, null));
    assertFalse((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isTextSmallerThanMinLength(null, "Text"));
    assertTrue((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .isTextSmallerThanMinLength(3, "42"));
  }

  /**
   * Method under test: {@link MinMaxLengthElement#getAttributeAsInteger(String)}
   */
  @Test
  public void testGetAttributeAsInteger() throws InvalidInputException {
    // Arrange, Act and Assert
    assertNull((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .getAttributeAsInteger("Attribute Name"));
  }

  /**
   * Method under test: {@link MinMaxLengthElement#isLengthOutOfRange(Integer)}
   */
  @Test
  public void testIsLengthOutOfRange() {
    // Arrange, Act and Assert
    assertFalse(
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).isLengthOutOfRange(3));
    assertFalse(
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).isLengthOutOfRange(null));
    assertTrue(
        (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).isLengthOutOfRange(-1));
  }

  /**
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
