package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class InvalidInstanceExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link InvalidInstanceException#InvalidInstanceException(IEntityJsonContext)}
   */
  @Test
  public void testNewInvalidInstanceException() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);

    // Act
    InvalidInstanceException actualInvalidInstanceException = new InvalidInstanceException(context);

    // Assert
    assertNull(actualInvalidInstanceException.getMessage());
    assertNull(actualInvalidInstanceException.getCause());
    assertEquals(0, actualInvalidInstanceException.getSuppressed().length);
    assertSame(context, actualInvalidInstanceException.getContext());
  }

  /**
   * Method under test:
   * {@link InvalidInstanceException#InvalidInstanceException(IEntityJsonContext, String)}
   */
  @Test
  public void testNewInvalidInstanceException2() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);

    // Act
    InvalidInstanceException actualInvalidInstanceException = new InvalidInstanceException(context,
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualInvalidInstanceException.getMessage());
    assertNull(actualInvalidInstanceException.getCause());
    assertEquals(0, actualInvalidInstanceException.getSuppressed().length);
    assertSame(context, actualInvalidInstanceException.getContext());
  }

  /**
   * Method under test:
   * {@link InvalidInstanceException#InvalidInstanceException(IEntityJsonContext, String, Throwable)}
   */
  @Test
  public void testNewInvalidInstanceException3() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    InvalidInstanceException actualInvalidInstanceException = new InvalidInstanceException(context, "An error occurred",
        cause);

    // Assert
    assertEquals("An error occurred", actualInvalidInstanceException.getMessage());
    assertEquals(0, actualInvalidInstanceException.getSuppressed().length);
    assertSame(cause, actualInvalidInstanceException.getCause());
    assertSame(context, actualInvalidInstanceException.getContext());
  }

  /**
   * Method under test:
   * {@link InvalidInstanceException#InvalidInstanceException(IEntityJsonContext, String, Throwable, boolean, boolean)}
   */
  @Test
  public void testNewInvalidInstanceException4() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    InvalidInstanceException actualInvalidInstanceException = new InvalidInstanceException(context, "An error occurred",
        cause, true, true);

    // Assert
    assertEquals("An error occurred", actualInvalidInstanceException.getMessage());
    assertEquals(0, actualInvalidInstanceException.getSuppressed().length);
    assertSame(cause, actualInvalidInstanceException.getCause());
    assertSame(context, actualInvalidInstanceException.getContext());
  }

  /**
   * Method under test:
   * {@link InvalidInstanceException#InvalidInstanceException(IEntityJsonContext, Throwable)}
   */
  @Test
  public void testNewInvalidInstanceException5() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    InvalidInstanceException actualInvalidInstanceException = new InvalidInstanceException(context, cause);

    // Assert
    assertEquals("java.lang.Throwable", actualInvalidInstanceException.getMessage());
    assertEquals(0, actualInvalidInstanceException.getSuppressed().length);
    assertSame(cause, actualInvalidInstanceException.getCause());
    assertSame(context, actualInvalidInstanceException.getContext());
  }
}
