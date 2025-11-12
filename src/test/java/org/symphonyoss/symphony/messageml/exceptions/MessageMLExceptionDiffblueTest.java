package org.symphonyoss.symphony.messageml.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MessageMLExceptionDiffblueTest {
  /**
   * Test {@link MessageMLException#MessageMLException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLException#MessageMLException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MessageMLException.<init>(String)",
    "void MessageMLException.<init>(String, Throwable)"
  })
  public void testNewMessageMLException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    MessageMLException actualMessageMLException = new MessageMLException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualMessageMLException.getMessage());
    assertNull(actualMessageMLException.getCause());
    assertEquals(0, actualMessageMLException.getSuppressed().length);
  }

  /**
   * Test {@link MessageMLException#MessageMLException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLException#MessageMLException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MessageMLException.<init>(String)",
    "void MessageMLException.<init>(String, Throwable)"
  })
  public void testNewMessageMLException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    MessageMLException actualMessageMLException =
        new MessageMLException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualMessageMLException.getMessage());
    assertEquals(0, actualMessageMLException.getSuppressed().length);
    assertSame(cause, actualMessageMLException.getCause());
  }
}
