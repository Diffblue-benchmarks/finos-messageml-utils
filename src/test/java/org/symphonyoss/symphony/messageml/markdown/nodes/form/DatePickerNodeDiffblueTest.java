package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class DatePickerNodeDiffblueTest {
  /**
   * Test {@link DatePickerNode#DatePickerNode(String, String, String)}.
   * <p>
   * Method under test:
   * {@link DatePickerNode#DatePickerNode(String, String, String)}
   */
  @Test
  public void testNewDatePickerNode() {
    // Arrange and Act
    DatePickerNode actualDatePickerNode = new DatePickerNode("Label", "127.0.0.1", "Placeholder");

    // Assert
    assertNull(actualDatePickerNode.getParent());
    assertNull(actualDatePickerNode.getFirstChild());
    assertNull(actualDatePickerNode.getLastChild());
    assertNull(actualDatePickerNode.getNext());
    assertNull(actualDatePickerNode.getPrevious());
  }
}
