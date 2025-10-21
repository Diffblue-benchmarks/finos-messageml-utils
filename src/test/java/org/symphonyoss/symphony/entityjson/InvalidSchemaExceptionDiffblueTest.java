package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InvalidSchemaExceptionDiffblueTest {
  /**
   * Test {@link InvalidSchemaException#InvalidSchemaException(IEntityJsonContext, String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InvalidSchemaException#InvalidSchemaException(IEntityJsonContext, String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InvalidSchemaException.<init>(IEntityJsonContext)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, String)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, String, Throwable)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, String, Throwable, boolean, boolean)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, Throwable)"})
  public void testNewInvalidSchemaException_thenReturnMessageIsAnErrorOccurred() {
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
   * Test {@link InvalidSchemaException#InvalidSchemaException(IEntityJsonContext, String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InvalidSchemaException#InvalidSchemaException(IEntityJsonContext, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InvalidSchemaException.<init>(IEntityJsonContext)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, String)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, String, Throwable)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, String, Throwable, boolean, boolean)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, Throwable)"})
  public void testNewInvalidSchemaException_whenAnErrorOccurred_thenReturnCauseIsNull() {
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
   * Test {@link InvalidSchemaException#InvalidSchemaException(IEntityJsonContext)}.
   * <ul>
   *   <li>When {@link IEntityJsonContext}.</li>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InvalidSchemaException#InvalidSchemaException(IEntityJsonContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InvalidSchemaException.<init>(IEntityJsonContext)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, String)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, String, Throwable)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, String, Throwable, boolean, boolean)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, Throwable)"})
  public void testNewInvalidSchemaException_whenIEntityJsonContext_thenReturnMessageIsNull() {
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
   * Test {@link InvalidSchemaException#InvalidSchemaException(IEntityJsonContext, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InvalidSchemaException#InvalidSchemaException(IEntityJsonContext, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InvalidSchemaException.<init>(IEntityJsonContext)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, String)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, String, Throwable)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, String, Throwable, boolean, boolean)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, Throwable)"})
  public void testNewInvalidSchemaException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
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

  /**
   * Test {@link InvalidSchemaException#InvalidSchemaException(IEntityJsonContext, String, Throwable, boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InvalidSchemaException#InvalidSchemaException(IEntityJsonContext, String, Throwable, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InvalidSchemaException.<init>(IEntityJsonContext)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, String)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, String, Throwable)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, String, Throwable, boolean, boolean)",
      "void InvalidSchemaException.<init>(IEntityJsonContext, Throwable)"})
  public void testNewInvalidSchemaException_whenTrue_thenReturnMessageIsAnErrorOccurred() {
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
}
