package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class TimezonePickerNodeDiffblueTest {
  /**
   * Test {@link TimezonePickerNode#TimezonePickerNode(String, String, String)}.
   * <p>
   * Method under test:
   * {@link TimezonePickerNode#TimezonePickerNode(String, String, String)}
   */
  @Test
  public void testNewTimezonePickerNode() {
    // Arrange and Act
    TimezonePickerNode actualTimezonePickerNode = new TimezonePickerNode("Label", "127.0.0.1", "Placeholder");

    // Assert
    assertNull(actualTimezonePickerNode.getParent());
    assertNull(actualTimezonePickerNode.getFirstChild());
    assertNull(actualTimezonePickerNode.getLastChild());
    assertNull(actualTimezonePickerNode.getNext());
    assertNull(actualTimezonePickerNode.getPrevious());
  }
}
