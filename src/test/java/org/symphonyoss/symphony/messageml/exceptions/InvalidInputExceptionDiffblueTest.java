package org.symphonyoss.symphony.messageml.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class InvalidInputExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link InvalidInputException#InvalidInputException(String)}
   */
  @Test
  public void testNewInvalidInputException() {
    // Arrange and Act
    InvalidInputException actualInvalidInputException = new InvalidInputException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualInvalidInputException.getMessage());
    assertNull(actualInvalidInputException.getCause());
    assertEquals(0, actualInvalidInputException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link InvalidInputException#InvalidInputException(String, Throwable)}
   */
  @Test
  public void testNewInvalidInputException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    InvalidInputException actualInvalidInputException = new InvalidInputException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualInvalidInputException.getMessage());
    assertEquals(0, actualInvalidInputException.getSuppressed().length);
    assertSame(cause, actualInvalidInputException.getCause());
  }

  /**
   * Method under test:
   * {@link InvalidInputException#InvalidInputException(String, Object[])}
   */
  @Test
  public void testNewInvalidInputException3() {
    // Arrange and Act
    InvalidInputException actualInvalidInputException = new InvalidInputException("An error occurred", "Args");

    // Assert
    assertEquals("An error occurred", actualInvalidInputException.getLocalizedMessage());
    assertEquals("An error occurred", actualInvalidInputException.getMessage());
    assertNull(actualInvalidInputException.getCause());
    assertEquals(0, actualInvalidInputException.getSuppressed().length);
  }
}
