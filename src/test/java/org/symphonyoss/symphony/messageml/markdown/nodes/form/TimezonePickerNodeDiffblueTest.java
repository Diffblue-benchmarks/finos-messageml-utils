package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TimezonePickerNodeDiffblueTest {
  /**
   * Test {@link TimezonePickerNode#TimezonePickerNode(String, String, String)}.
   *
   * <p>Method under test: {@link TimezonePickerNode#TimezonePickerNode(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePickerNode.<init>(String, String, String)"})
  public void testNewTimezonePickerNode() {
    // Arrange and Act
    TimezonePickerNode actualTimezonePickerNode =
        new TimezonePickerNode("Label", "127.0.0.1", "Placeholder");

    // Assert
    assertNull(actualTimezonePickerNode.getParent());
    assertNull(actualTimezonePickerNode.getFirstChild());
    assertNull(actualTimezonePickerNode.getLastChild());
    assertNull(actualTimezonePickerNode.getNext());
    assertNull(actualTimezonePickerNode.getPrevious());
  }
}
