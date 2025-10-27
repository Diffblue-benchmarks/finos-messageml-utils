package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class SchemaValidationExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext)}
   */
  @Test
  public void testNewSchemaValidationException() {
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
   * Method under test:
   * {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext, String)}
   */
  @Test
  public void testNewSchemaValidationException2() {
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
   * Method under test:
   * {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext, String, Throwable)}
   */
  @Test
  public void testNewSchemaValidationException3() {
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
   * Method under test:
   * {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext, String, Throwable, boolean, boolean)}
   */
  @Test
  public void testNewSchemaValidationException4() {
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

  /**
   * Method under test:
   * {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext, Throwable)}
   */
  @Test
  public void testNewSchemaValidationException5() {
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
}
