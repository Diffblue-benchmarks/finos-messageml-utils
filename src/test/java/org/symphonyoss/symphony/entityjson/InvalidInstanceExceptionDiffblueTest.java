package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class InvalidInstanceExceptionDiffblueTest {
  /**
   * Test
   * {@link InvalidInstanceException#InvalidInstanceException(IEntityJsonContext, String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InvalidInstanceException#InvalidInstanceException(IEntityJsonContext, String, Throwable)}
   */
  @Test
  public void testNewInvalidInstanceException_thenReturnMessageIsAnErrorOccurred() {
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
   * Test
   * {@link InvalidInstanceException#InvalidInstanceException(IEntityJsonContext, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InvalidInstanceException#InvalidInstanceException(IEntityJsonContext, Throwable)}
   */
  @Test
  public void testNewInvalidInstanceException_thenReturnMessageIsJavaLangThrowable() {
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

  /**
   * Test
   * {@link InvalidInstanceException#InvalidInstanceException(IEntityJsonContext, String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InvalidInstanceException#InvalidInstanceException(IEntityJsonContext, String)}
   */
  @Test
  public void testNewInvalidInstanceException_whenAnErrorOccurred_thenReturnCauseIsNull() {
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
   * Test
   * {@link InvalidInstanceException#InvalidInstanceException(IEntityJsonContext)}.
   * <ul>
   *   <li>When {@link IEntityJsonContext}.</li>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InvalidInstanceException#InvalidInstanceException(IEntityJsonContext)}
   */
  @Test
  public void testNewInvalidInstanceException_whenIEntityJsonContext_thenReturnMessageIsNull() {
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
   * Test
   * {@link InvalidInstanceException#InvalidInstanceException(IEntityJsonContext, String, Throwable, boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InvalidInstanceException#InvalidInstanceException(IEntityJsonContext, String, Throwable, boolean, boolean)}
   */
  @Test
  public void testNewInvalidInstanceException_whenTrue_thenReturnMessageIsAnErrorOccurred() {
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
}
