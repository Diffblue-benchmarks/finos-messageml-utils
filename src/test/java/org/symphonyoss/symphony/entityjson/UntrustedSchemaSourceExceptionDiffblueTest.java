package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class UntrustedSchemaSourceExceptionDiffblueTest {
  /**
   * Test
   * {@link UntrustedSchemaSourceException#UntrustedSchemaSourceException(IEntityJsonContext, String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UntrustedSchemaSourceException#UntrustedSchemaSourceException(IEntityJsonContext, String, Throwable)}
   */
  @Test
  public void testNewUntrustedSchemaSourceException_thenReturnMessageIsAnErrorOccurred() {
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
   * Test
   * {@link UntrustedSchemaSourceException#UntrustedSchemaSourceException(IEntityJsonContext, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UntrustedSchemaSourceException#UntrustedSchemaSourceException(IEntityJsonContext, Throwable)}
   */
  @Test
  public void testNewUntrustedSchemaSourceException_thenReturnMessageIsJavaLangThrowable() {
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

  /**
   * Test
   * {@link UntrustedSchemaSourceException#UntrustedSchemaSourceException(IEntityJsonContext)}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UntrustedSchemaSourceException#UntrustedSchemaSourceException(IEntityJsonContext)}
   */
  @Test
  public void testNewUntrustedSchemaSourceException_thenReturnMessageIsNull() {
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
   * Test
   * {@link UntrustedSchemaSourceException#UntrustedSchemaSourceException(IEntityJsonContext, String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UntrustedSchemaSourceException#UntrustedSchemaSourceException(IEntityJsonContext, String)}
   */
  @Test
  public void testNewUntrustedSchemaSourceException_whenAnErrorOccurred_thenReturnCauseIsNull() {
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
   * Test
   * {@link UntrustedSchemaSourceException#UntrustedSchemaSourceException(IEntityJsonContext, String, Throwable, boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UntrustedSchemaSourceException#UntrustedSchemaSourceException(IEntityJsonContext, String, Throwable, boolean, boolean)}
   */
  @Test
  public void testNewUntrustedSchemaSourceException_whenTrue() {
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
}
