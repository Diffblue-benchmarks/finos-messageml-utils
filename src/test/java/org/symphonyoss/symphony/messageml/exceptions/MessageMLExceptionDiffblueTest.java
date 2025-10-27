package org.symphonyoss.symphony.messageml.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class MessageMLExceptionDiffblueTest {
  /**
   * Method under test: {@link MessageMLException#MessageMLException(String)}
   */
  @Test
  public void testNewMessageMLException() {
    // Arrange and Act
    MessageMLException actualMessageMLException = new MessageMLException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualMessageMLException.getMessage());
    assertNull(actualMessageMLException.getCause());
    assertEquals(0, actualMessageMLException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link MessageMLException#MessageMLException(String, Throwable)}
   */
  @Test
  public void testNewMessageMLException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    MessageMLException actualMessageMLException = new MessageMLException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualMessageMLException.getMessage());
    assertEquals(0, actualMessageMLException.getSuppressed().length);
    assertSame(cause, actualMessageMLException.getCause());
  }
}
