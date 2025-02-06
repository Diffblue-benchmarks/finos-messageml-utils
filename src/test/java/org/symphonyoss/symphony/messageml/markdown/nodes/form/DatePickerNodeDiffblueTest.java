package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import org.junit.Ignore;
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

  /**
   * Test {@link DatePickerNode#getText()}.
   * <p>
   * Method under test: {@link DatePickerNode#getText()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetText() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new DatePickerNode("Label", "127.0.0.1", "Placeholder")).getText();
  }
}
