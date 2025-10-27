package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class NoSchemaExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link NoSchemaException#NoSchemaException(IEntityJsonContext)}
   */
  @Test
  public void testNewNoSchemaException() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);

    // Act
    NoSchemaException actualNoSchemaException = new NoSchemaException(context);

    // Assert
    assertNull(actualNoSchemaException.getMessage());
    assertNull(actualNoSchemaException.getCause());
    assertEquals(0, actualNoSchemaException.getSuppressed().length);
    assertSame(context, actualNoSchemaException.getContext());
  }

  /**
   * Method under test:
   * {@link NoSchemaException#NoSchemaException(IEntityJsonContext, String)}
   */
  @Test
  public void testNewNoSchemaException2() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);

    // Act
    NoSchemaException actualNoSchemaException = new NoSchemaException(context, "An error occurred");

    // Assert
    assertEquals("An error occurred", actualNoSchemaException.getMessage());
    assertNull(actualNoSchemaException.getCause());
    assertEquals(0, actualNoSchemaException.getSuppressed().length);
    assertSame(context, actualNoSchemaException.getContext());
  }

  /**
   * Method under test:
   * {@link NoSchemaException#NoSchemaException(IEntityJsonContext, String, Throwable)}
   */
  @Test
  public void testNewNoSchemaException3() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    NoSchemaException actualNoSchemaException = new NoSchemaException(context, "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualNoSchemaException.getMessage());
    assertEquals(0, actualNoSchemaException.getSuppressed().length);
    assertSame(cause, actualNoSchemaException.getCause());
    assertSame(context, actualNoSchemaException.getContext());
  }

  /**
   * Method under test:
   * {@link NoSchemaException#NoSchemaException(IEntityJsonContext, String, Throwable, boolean, boolean)}
   */
  @Test
  public void testNewNoSchemaException4() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    NoSchemaException actualNoSchemaException = new NoSchemaException(context, "An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualNoSchemaException.getMessage());
    assertEquals(0, actualNoSchemaException.getSuppressed().length);
    assertSame(cause, actualNoSchemaException.getCause());
    assertSame(context, actualNoSchemaException.getContext());
  }

  /**
   * Method under test:
   * {@link NoSchemaException#NoSchemaException(IEntityJsonContext, Throwable)}
   */
  @Test
  public void testNewNoSchemaException5() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    NoSchemaException actualNoSchemaException = new NoSchemaException(context, cause);

    // Assert
    assertEquals("java.lang.Throwable", actualNoSchemaException.getMessage());
    assertEquals(0, actualNoSchemaException.getSuppressed().length);
    assertSame(cause, actualNoSchemaException.getCause());
    assertSame(context, actualNoSchemaException.getContext());
  }
}
