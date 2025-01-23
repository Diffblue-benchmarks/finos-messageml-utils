package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class SchemaValidationExceptionDiffblueTest {
  /**
   * Test
   * {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext, String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext, String, Throwable)}
   */
  @Test
  public void testNewSchemaValidationException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    SchemaValidationException actualSchemaValidationException = new SchemaValidationException(context,
        "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualSchemaValidationException.getMessage());
    assertEquals(0, actualSchemaValidationException.getSuppressed().length);
    assertSame(cause, actualSchemaValidationException.getCause());
    assertSame(context, actualSchemaValidationException.getContext());
  }

  /**
   * Test
   * {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext, Throwable)}
   */
  @Test
  public void testNewSchemaValidationException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    SchemaValidationException actualSchemaValidationException = new SchemaValidationException(context, cause);

    // Assert
    assertEquals("java.lang.Throwable", actualSchemaValidationException.getMessage());
    assertEquals(0, actualSchemaValidationException.getSuppressed().length);
    assertSame(cause, actualSchemaValidationException.getCause());
    assertSame(context, actualSchemaValidationException.getContext());
  }

  /**
   * Test
   * {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext, String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext, String)}
   */
  @Test
  public void testNewSchemaValidationException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);

    // Act
    SchemaValidationException actualSchemaValidationException = new SchemaValidationException(context,
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualSchemaValidationException.getMessage());
    assertNull(actualSchemaValidationException.getCause());
    assertEquals(0, actualSchemaValidationException.getSuppressed().length);
    assertSame(context, actualSchemaValidationException.getContext());
  }

  /**
   * Test
   * {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext)}.
   * <ul>
   *   <li>When {@link IEntityJsonContext}.</li>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext)}
   */
  @Test
  public void testNewSchemaValidationException_whenIEntityJsonContext_thenReturnMessageIsNull() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);

    // Act
    SchemaValidationException actualSchemaValidationException = new SchemaValidationException(context);

    // Assert
    assertNull(actualSchemaValidationException.getMessage());
    assertNull(actualSchemaValidationException.getCause());
    assertEquals(0, actualSchemaValidationException.getSuppressed().length);
    assertSame(context, actualSchemaValidationException.getContext());
  }

  /**
   * Test
   * {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext, String, Throwable, boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext, String, Throwable, boolean, boolean)}
   */
  @Test
  public void testNewSchemaValidationException_whenTrue_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    SchemaValidationException actualSchemaValidationException = new SchemaValidationException(context,
        "An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualSchemaValidationException.getMessage());
    assertEquals(0, actualSchemaValidationException.getSuppressed().length);
    assertSame(cause, actualSchemaValidationException.getCause());
    assertSame(context, actualSchemaValidationException.getContext());
  }
}
