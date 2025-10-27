package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.commonmark.node.BlockQuote;
import org.junit.Test;

public class TimePickerNodeDiffblueTest {
  /**
   * Method under test: {@link TimePickerNode#getText()}
   */
  @Test
  public void testGetText() {
    // Arrange
    BlockQuote child = mock(BlockQuote.class);
    doNothing().when(child).unlink();

    TimePickerNode timePickerNode = new TimePickerNode("Label", "127.0.0.1", "Placeholder");
    timePickerNode.appendChild(child);

    // Act
    timePickerNode.getText();

    // Assert
    verify(child).unlink();
  }

  /**
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
