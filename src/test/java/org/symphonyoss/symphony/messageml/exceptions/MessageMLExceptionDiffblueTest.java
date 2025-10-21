package org.symphonyoss.symphony.messageml.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MessageMLExceptionDiffblueTest {
  /**
   * Test {@link MessageMLException#MessageMLException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLException#MessageMLException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MessageMLException.<init>(String)", "void MessageMLException.<init>(String, Throwable)"})
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
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLException#MessageMLException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MessageMLException.<init>(String)", "void MessageMLException.<init>(String, Throwable)"})
  public void testNewMessageMLException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    MessageMLException actualMessageMLException = new MessageMLException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualMessageMLException.getMessage());
    assertEquals(0, actualMessageMLException.getSuppressed().length);
    assertSame(cause, actualMessageMLException.getCause());
  }
}
