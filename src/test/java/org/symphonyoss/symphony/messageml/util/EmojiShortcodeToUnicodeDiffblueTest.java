package org.symphonyoss.symphony.messageml.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EmojiShortcodeToUnicodeDiffblueTest {
  /**
   * Test {@link EmojiShortcodeToUnicode#getUnicode(String)}.
   *
   * <p>Method under test: {@link EmojiShortcodeToUnicode#getUnicode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EmojiShortcodeToUnicode.getUnicode(String)"})
  public void testGetUnicode() {
    // Arrange, Act and Assert
    assertNull(EmojiShortcodeToUnicode.getUnicode("Shortcode"));
  }

  /**
   * Test {@link EmojiShortcodeToUnicode#hasUnicodeRepresentation(String)}.
   *
   * <p>Method under test: {@link EmojiShortcodeToUnicode#hasUnicodeRepresentation(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean EmojiShortcodeToUnicode.hasUnicodeRepresentation(String)"})
  public void testHasUnicodeRepresentation() {
    // Arrange, Act and Assert
    assertFalse(EmojiShortcodeToUnicode.hasUnicodeRepresentation("Shortcode"));
  }
}
