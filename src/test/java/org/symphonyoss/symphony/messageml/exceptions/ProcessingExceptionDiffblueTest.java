package org.symphonyoss.symphony.messageml.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProcessingExceptionDiffblueTest {
  /**
   * Test {@link ProcessingException#ProcessingException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessingException#ProcessingException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProcessingException.<init>(String)",
    "void ProcessingException.<init>(String, Throwable)"
  })
  public void testNewProcessingException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    ProcessingException actualProcessingException = new ProcessingException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualProcessingException.getMessage());
    assertNull(actualProcessingException.getCause());
    assertEquals(0, actualProcessingException.getSuppressed().length);
  }

  /**
   * Test {@link ProcessingException#ProcessingException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessingException#ProcessingException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProcessingException.<init>(String)",
    "void ProcessingException.<init>(String, Throwable)"
  })
  public void testNewProcessingException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ProcessingException actualProcessingException =
        new ProcessingException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualProcessingException.getMessage());
    assertEquals(0, actualProcessingException.getSuppressed().length);
    assertSame(cause, actualProcessingException.getCause());
  }
}
