package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import org.junit.Ignore;
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

  /**
   * Test {@link TimePickerNode#getText()}.
   * <p>
   * Method under test: {@link TimePickerNode#getText()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetText() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new TimePickerNode("Label", "127.0.0.1", "Placeholder")).getText();
  }
}
