package org.symphonyoss.symphony.messageml.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InvalidInputExceptionDiffblueTest {
  /**
   * Test {@link InvalidInputException#InvalidInputException(String, Object[])}.
   * <p>
   * Method under test: {@link InvalidInputException#InvalidInputException(String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InvalidInputException.<init>(String, Object[])"})
  public void testNewInvalidInputException() {
    // Arrange and Act
    InvalidInputException actualInvalidInputException = new InvalidInputException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualInvalidInputException.getLocalizedMessage());
    assertEquals("An error occurred", actualInvalidInputException.getMessage());
    assertNull(actualInvalidInputException.getCause());
    assertEquals(0, actualInvalidInputException.getSuppressed().length);
  }

  /**
   * Test {@link InvalidInputException#InvalidInputException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InvalidInputException#InvalidInputException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InvalidInputException.<init>(String)",
      "void InvalidInputException.<init>(String, Throwable)"})
  public void testNewInvalidInputException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    InvalidInputException actualInvalidInputException = new InvalidInputException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualInvalidInputException.getMessage());
    assertNull(actualInvalidInputException.getCause());
    assertEquals(0, actualInvalidInputException.getSuppressed().length);
  }

  /**
   * Test {@link InvalidInputException#InvalidInputException(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InvalidInputException#InvalidInputException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InvalidInputException.<init>(String)",
      "void InvalidInputException.<init>(String, Throwable)"})
  public void testNewInvalidInputException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    InvalidInputException actualInvalidInputException = new InvalidInputException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualInvalidInputException.getMessage());
    assertEquals(0, actualInvalidInputException.getSuppressed().length);
    assertSame(cause, actualInvalidInputException.getCause());
  }
}
