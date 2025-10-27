package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class InvalidSchemaExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link InvalidSchemaException#InvalidSchemaException(IEntityJsonContext)}
   */
  @Test
  public void testNewInvalidSchemaException() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);

    // Act
    InvalidSchemaException actualInvalidSchemaException = new InvalidSchemaException(context);

    // Assert
    assertNull(actualInvalidSchemaException.getMessage());
    assertNull(actualInvalidSchemaException.getCause());
    assertEquals(0, actualInvalidSchemaException.getSuppressed().length);
    assertSame(context, actualInvalidSchemaException.getContext());
  }

  /**
   * Method under test:
   * {@link InvalidSchemaException#InvalidSchemaException(IEntityJsonContext, String)}
   */
  @Test
  public void testNewInvalidSchemaException2() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);

    // Act
    InvalidSchemaException actualInvalidSchemaException = new InvalidSchemaException(context, "An error occurred");

    // Assert
    assertEquals("An error occurred", actualInvalidSchemaException.getMessage());
    assertNull(actualInvalidSchemaException.getCause());
    assertEquals(0, actualInvalidSchemaException.getSuppressed().length);
    assertSame(context, actualInvalidSchemaException.getContext());
  }

  /**
   * Method under test:
   * {@link InvalidSchemaException#InvalidSchemaException(IEntityJsonContext, String, Throwable)}
   */
  @Test
  public void testNewInvalidSchemaException3() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    InvalidSchemaException actualInvalidSchemaException = new InvalidSchemaException(context, "An error occurred",
        cause);

    // Assert
    assertEquals("An error occurred", actualInvalidSchemaException.getMessage());
    assertEquals(0, actualInvalidSchemaException.getSuppressed().length);
    assertSame(cause, actualInvalidSchemaException.getCause());
    assertSame(context, actualInvalidSchemaException.getContext());
  }

  /**
   * Method under test:
   * {@link InvalidSchemaException#InvalidSchemaException(IEntityJsonContext, String, Throwable, boolean, boolean)}
   */
  @Test
  public void testNewInvalidSchemaException4() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    InvalidSchemaException actualInvalidSchemaException = new InvalidSchemaException(context, "An error occurred",
        cause, true, true);

    // Assert
    assertEquals("An error occurred", actualInvalidSchemaException.getMessage());
    assertEquals(0, actualInvalidSchemaException.getSuppressed().length);
    assertSame(cause, actualInvalidSchemaException.getCause());
    assertSame(context, actualInvalidSchemaException.getContext());
  }

  /**
   * Method under test:
   * {@link InvalidSchemaException#InvalidSchemaException(IEntityJsonContext, Throwable)}
   */
  @Test
  public void testNewInvalidSchemaException5() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    InvalidSchemaException actualInvalidSchemaException = new InvalidSchemaException(context, cause);

    // Assert
    assertEquals("java.lang.Throwable", actualInvalidSchemaException.getMessage());
    assertEquals(0, actualInvalidSchemaException.getSuppressed().length);
    assertSame(cause, actualInvalidSchemaException.getCause());
    assertSame(context, actualInvalidSchemaException.getContext());
  }
}
