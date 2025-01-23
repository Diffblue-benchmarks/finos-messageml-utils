package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class TimePickerNodeDiffblueTest {
  /**
   * Test {@link TimePickerNode#TimePickerNode(String, String, String)}.
   * <p>
   * Method under test:
   * {@link TimePickerNode#TimePickerNode(String, String, String)}
   */
  @Test
  public void testNewTimePickerNode() {
    // Arrange and Act
    TimePickerNode actualTimePickerNode = new TimePickerNode("Label", "127.0.0.1", "Placeholder");

    // Assert
    assertNull(actualTimePickerNode.getParent());
    assertNull(actualTimePickerNode.getFirstChild());
    assertNull(actualTimePickerNode.getLastChild());
    assertNull(actualTimePickerNode.getNext());
    assertNull(actualTimePickerNode.getPrevious());
  }
}
