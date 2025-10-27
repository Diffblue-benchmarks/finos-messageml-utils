package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.commonmark.node.BlockQuote;
import org.junit.Test;

public class DatePickerNodeDiffblueTest {
  /**
   * Method under test: {@link DatePickerNode#getText()}
   */
  @Test
  public void testGetText() {
    // Arrange
    BlockQuote child = mock(BlockQuote.class);
    doNothing().when(child).unlink();

    DatePickerNode datePickerNode = new DatePickerNode("Label", "127.0.0.1", "Placeholder");
    datePickerNode.appendChild(child);

    // Act
    datePickerNode.getText();

    // Assert
    verify(child).unlink();
  }

  /**
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
