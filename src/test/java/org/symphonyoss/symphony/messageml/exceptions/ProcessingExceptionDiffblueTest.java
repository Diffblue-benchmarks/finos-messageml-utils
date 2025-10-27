package org.symphonyoss.symphony.messageml.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ProcessingExceptionDiffblueTest {
  /**
   * Method under test: {@link ProcessingException#ProcessingException(String)}
   */
  @Test
  public void testNewProcessingException() {
    // Arrange and Act
    ProcessingException actualProcessingException = new ProcessingException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualProcessingException.getMessage());
    assertNull(actualProcessingException.getCause());
    assertEquals(0, actualProcessingException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ProcessingException#ProcessingException(String, Throwable)}
   */
  @Test
  public void testNewProcessingException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ProcessingException actualProcessingException = new ProcessingException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualProcessingException.getMessage());
    assertEquals(0, actualProcessingException.getSuppressed().length);
    assertSame(cause, actualProcessingException.getCause());
  }
}
