package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import org.junit.Ignore;
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

  /**
   * Test {@link TimezonePickerNode#getText()}.
   * <p>
   * Method under test: {@link TimezonePickerNode#getText()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetText() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new TimezonePickerNode("Label", "127.0.0.1", "Placeholder")).getText();
  }
}
