package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class UntrustedSchemaSourceExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link UntrustedSchemaSourceException#UntrustedSchemaSourceException(IEntityJsonContext)}
   */
  @Test
  public void testNewUntrustedSchemaSourceException() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);

    // Act
    UntrustedSchemaSourceException actualUntrustedSchemaSourceException = new UntrustedSchemaSourceException(context);

    // Assert
    assertNull(actualUntrustedSchemaSourceException.getMessage());
    assertNull(actualUntrustedSchemaSourceException.getCause());
    assertEquals(0, actualUntrustedSchemaSourceException.getSuppressed().length);
    assertSame(context, actualUntrustedSchemaSourceException.getContext());
  }

  /**
   * Method under test:
   * {@link UntrustedSchemaSourceException#UntrustedSchemaSourceException(IEntityJsonContext, String)}
   */
  @Test
  public void testNewUntrustedSchemaSourceException2() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);

    // Act
    UntrustedSchemaSourceException actualUntrustedSchemaSourceException = new UntrustedSchemaSourceException(context,
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualUntrustedSchemaSourceException.getMessage());
    assertNull(actualUntrustedSchemaSourceException.getCause());
    assertEquals(0, actualUntrustedSchemaSourceException.getSuppressed().length);
    assertSame(context, actualUntrustedSchemaSourceException.getContext());
  }

  /**
   * Method under test:
   * {@link UntrustedSchemaSourceException#UntrustedSchemaSourceException(IEntityJsonContext, String, Throwable)}
   */
  @Test
  public void testNewUntrustedSchemaSourceException3() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    UntrustedSchemaSourceException actualUntrustedSchemaSourceException = new UntrustedSchemaSourceException(context,
        "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualUntrustedSchemaSourceException.getMessage());
    assertEquals(0, actualUntrustedSchemaSourceException.getSuppressed().length);
    assertSame(cause, actualUntrustedSchemaSourceException.getCause());
    assertSame(context, actualUntrustedSchemaSourceException.getContext());
  }

  /**
   * Method under test:
   * {@link UntrustedSchemaSourceException#UntrustedSchemaSourceException(IEntityJsonContext, String, Throwable, boolean, boolean)}
   */
  @Test
  public void testNewUntrustedSchemaSourceException4() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    UntrustedSchemaSourceException actualUntrustedSchemaSourceException = new UntrustedSchemaSourceException(context,
        "An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualUntrustedSchemaSourceException.getMessage());
    assertEquals(0, actualUntrustedSchemaSourceException.getSuppressed().length);
    assertSame(cause, actualUntrustedSchemaSourceException.getCause());
    assertSame(context, actualUntrustedSchemaSourceException.getContext());
  }

  /**
   * Method under test:
   * {@link UntrustedSchemaSourceException#UntrustedSchemaSourceException(IEntityJsonContext, Throwable)}
   */
  @Test
  public void testNewUntrustedSchemaSourceException5() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    UntrustedSchemaSourceException actualUntrustedSchemaSourceException = new UntrustedSchemaSourceException(context,
        cause);

    // Assert
    assertEquals("java.lang.Throwable", actualUntrustedSchemaSourceException.getMessage());
    assertEquals(0, actualUntrustedSchemaSourceException.getSuppressed().length);
    assertSame(cause, actualUntrustedSchemaSourceException.getCause());
    assertSame(context, actualUntrustedSchemaSourceException.getContext());
  }
}
