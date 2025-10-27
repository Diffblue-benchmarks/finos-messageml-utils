package org.symphonyoss.symphony.messageml.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class EmojiShortcodeToUnicodeDiffblueTest {
  /**
   * Method under test: {@link EmojiShortcodeToUnicode#getUnicode(String)}
   */
  @Test
  public void testGetUnicode() {
    // Arrange, Act and Assert
    assertNull(EmojiShortcodeToUnicode.getUnicode("Shortcode"));
  }

  /**
   * Method under test:
   * {@link EmojiShortcodeToUnicode#hasUnicodeRepresentation(String)}
   */
  @Test
  public void testHasUnicodeRepresentation() {
    // Arrange, Act and Assert
    assertFalse(EmojiShortcodeToUnicode.hasUnicodeRepresentation("Shortcode"));
  }
}
