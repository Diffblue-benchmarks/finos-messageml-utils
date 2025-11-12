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

public class NoSchemaExceptionDiffblueTest {
  /**
   * Test {@link NoSchemaException#NoSchemaException(IEntityJsonContext, String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NoSchemaException#NoSchemaException(IEntityJsonContext, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NoSchemaException.<init>(IEntityJsonContext)",
    "void NoSchemaException.<init>(IEntityJsonContext, String)",
    "void NoSchemaException.<init>(IEntityJsonContext, String, Throwable)",
    "void NoSchemaException.<init>(IEntityJsonContext, String, Throwable, boolean, boolean)",
    "void NoSchemaException.<init>(IEntityJsonContext, Throwable)"
  })
  public void testNewNoSchemaException_whenAnErrorOccurred_thenReturnCauseIsNull() {
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
   * Test {@link NoSchemaException#NoSchemaException(IEntityJsonContext, String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link NoSchemaException#NoSchemaException(IEntityJsonContext, String,
   * Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NoSchemaException.<init>(IEntityJsonContext)",
    "void NoSchemaException.<init>(IEntityJsonContext, String)",
    "void NoSchemaException.<init>(IEntityJsonContext, String, Throwable)",
    "void NoSchemaException.<init>(IEntityJsonContext, String, Throwable, boolean, boolean)",
    "void NoSchemaException.<init>(IEntityJsonContext, Throwable)"
  })
  public void testNewNoSchemaException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    NoSchemaException actualNoSchemaException =
        new NoSchemaException(context, "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualNoSchemaException.getMessage());
    assertEquals(0, actualNoSchemaException.getSuppressed().length);
    assertSame(cause, actualNoSchemaException.getCause());
    assertSame(context, actualNoSchemaException.getContext());
  }

  /**
   * Test {@link NoSchemaException#NoSchemaException(IEntityJsonContext)}.
   *
   * <ul>
   *   <li>When {@link IEntityJsonContext}.
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NoSchemaException#NoSchemaException(IEntityJsonContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NoSchemaException.<init>(IEntityJsonContext)",
    "void NoSchemaException.<init>(IEntityJsonContext, String)",
    "void NoSchemaException.<init>(IEntityJsonContext, String, Throwable)",
    "void NoSchemaException.<init>(IEntityJsonContext, String, Throwable, boolean, boolean)",
    "void NoSchemaException.<init>(IEntityJsonContext, Throwable)"
  })
  public void testNewNoSchemaException_whenIEntityJsonContext_thenReturnMessageIsNull() {
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
   * Test {@link NoSchemaException#NoSchemaException(IEntityJsonContext, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link NoSchemaException#NoSchemaException(IEntityJsonContext,
   * Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NoSchemaException.<init>(IEntityJsonContext)",
    "void NoSchemaException.<init>(IEntityJsonContext, String)",
    "void NoSchemaException.<init>(IEntityJsonContext, String, Throwable)",
    "void NoSchemaException.<init>(IEntityJsonContext, String, Throwable, boolean, boolean)",
    "void NoSchemaException.<init>(IEntityJsonContext, Throwable)"
  })
  public void testNewNoSchemaException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
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

  /**
   * Test {@link NoSchemaException#NoSchemaException(IEntityJsonContext, String, Throwable, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link NoSchemaException#NoSchemaException(IEntityJsonContext, String,
   * Throwable, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NoSchemaException.<init>(IEntityJsonContext)",
    "void NoSchemaException.<init>(IEntityJsonContext, String)",
    "void NoSchemaException.<init>(IEntityJsonContext, String, Throwable)",
    "void NoSchemaException.<init>(IEntityJsonContext, String, Throwable, boolean, boolean)",
    "void NoSchemaException.<init>(IEntityJsonContext, Throwable)"
  })
  public void testNewNoSchemaException_whenTrue_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    Throwable cause = new Throwable();

    // Act
    NoSchemaException actualNoSchemaException =
        new NoSchemaException(context, "An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualNoSchemaException.getMessage());
    assertEquals(0, actualNoSchemaException.getSuppressed().length);
    assertSame(cause, actualNoSchemaException.getCause());
    assertSame(context, actualNoSchemaException.getContext());
  }
}
