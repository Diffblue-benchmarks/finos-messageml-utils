package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SchemaValidationExceptionDiffblueTest {
  /**
   * Test {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext, String,
   * Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SchemaValidationException#SchemaValidationException(IEntityJsonContext, String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SchemaValidationException.<init>(IEntityJsonContext)",
    "void SchemaValidationException.<init>(IEntityJsonContext, String)",
    "void SchemaValidationException.<init>(IEntityJsonContext, String, Throwable)",
    "void SchemaValidationException.<init>(IEntityJsonContext, String, Throwable, boolean, boolean)",
    "void SchemaValidationException.<init>(IEntityJsonContext, Throwable)"
  })
  public void testNewSchemaValidationException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    SchemaValidationException actualSchemaValidationException =
        new SchemaValidationException(context, "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualSchemaValidationException.getMessage());
    assertEquals(0, actualSchemaValidationException.getSuppressed().length);
    assertSame(cause, actualSchemaValidationException.getCause());
    assertSame(context, actualSchemaValidationException.getContext());
  }

  /**
   * Test {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext,
   * Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SchemaValidationException#SchemaValidationException(IEntityJsonContext, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SchemaValidationException.<init>(IEntityJsonContext)",
    "void SchemaValidationException.<init>(IEntityJsonContext, String)",
    "void SchemaValidationException.<init>(IEntityJsonContext, String, Throwable)",
    "void SchemaValidationException.<init>(IEntityJsonContext, String, Throwable, boolean, boolean)",
    "void SchemaValidationException.<init>(IEntityJsonContext, Throwable)"
  })
  public void testNewSchemaValidationException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    SchemaValidationException actualSchemaValidationException =
        new SchemaValidationException(context, cause);

    // Assert
    assertEquals("java.lang.Throwable", actualSchemaValidationException.getMessage());
    assertEquals(0, actualSchemaValidationException.getSuppressed().length);
    assertSame(cause, actualSchemaValidationException.getCause());
    assertSame(context, actualSchemaValidationException.getContext());
  }

  /**
   * Test {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext, String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SchemaValidationException#SchemaValidationException(IEntityJsonContext, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SchemaValidationException.<init>(IEntityJsonContext)",
    "void SchemaValidationException.<init>(IEntityJsonContext, String)",
    "void SchemaValidationException.<init>(IEntityJsonContext, String, Throwable)",
    "void SchemaValidationException.<init>(IEntityJsonContext, String, Throwable, boolean, boolean)",
    "void SchemaValidationException.<init>(IEntityJsonContext, Throwable)"
  })
  public void testNewSchemaValidationException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);

    // Act
    SchemaValidationException actualSchemaValidationException =
        new SchemaValidationException(context, "An error occurred");

    // Assert
    assertEquals("An error occurred", actualSchemaValidationException.getMessage());
    assertNull(actualSchemaValidationException.getCause());
    assertEquals(0, actualSchemaValidationException.getSuppressed().length);
    assertSame(context, actualSchemaValidationException.getContext());
  }

  /**
   * Test {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext)}.
   *
   * <ul>
   *   <li>When {@link IEntityJsonContext}.
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SchemaValidationException#SchemaValidationException(IEntityJsonContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SchemaValidationException.<init>(IEntityJsonContext)",
    "void SchemaValidationException.<init>(IEntityJsonContext, String)",
    "void SchemaValidationException.<init>(IEntityJsonContext, String, Throwable)",
    "void SchemaValidationException.<init>(IEntityJsonContext, String, Throwable, boolean, boolean)",
    "void SchemaValidationException.<init>(IEntityJsonContext, Throwable)"
  })
  public void testNewSchemaValidationException_whenIEntityJsonContext_thenReturnMessageIsNull() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);

    // Act
    SchemaValidationException actualSchemaValidationException =
        new SchemaValidationException(context);

    // Assert
    assertNull(actualSchemaValidationException.getMessage());
    assertNull(actualSchemaValidationException.getCause());
    assertEquals(0, actualSchemaValidationException.getSuppressed().length);
    assertSame(context, actualSchemaValidationException.getContext());
  }

  /**
   * Test {@link SchemaValidationException#SchemaValidationException(IEntityJsonContext, String,
   * Throwable, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SchemaValidationException#SchemaValidationException(IEntityJsonContext, String, Throwable,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SchemaValidationException.<init>(IEntityJsonContext)",
    "void SchemaValidationException.<init>(IEntityJsonContext, String)",
    "void SchemaValidationException.<init>(IEntityJsonContext, String, Throwable)",
    "void SchemaValidationException.<init>(IEntityJsonContext, String, Throwable, boolean, boolean)",
    "void SchemaValidationException.<init>(IEntityJsonContext, Throwable)"
  })
  public void testNewSchemaValidationException_whenTrue_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    SchemaValidationException actualSchemaValidationException =
        new SchemaValidationException(context, "An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualSchemaValidationException.getMessage());
    assertEquals(0, actualSchemaValidationException.getSuppressed().length);
    assertSame(cause, actualSchemaValidationException.getCause());
    assertSame(context, actualSchemaValidationException.getContext());
  }
}
