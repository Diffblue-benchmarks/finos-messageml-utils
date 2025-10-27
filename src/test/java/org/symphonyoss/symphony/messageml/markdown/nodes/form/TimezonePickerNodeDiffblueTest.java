package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.commonmark.node.BlockQuote;
import org.junit.Test;

public class TimezonePickerNodeDiffblueTest {
  /**
   * Method under test: {@link TimezonePickerNode#getText()}
   */
  @Test
  public void testGetText() {
    // Arrange
    BlockQuote child = mock(BlockQuote.class);
    doNothing().when(child).unlink();

    TimezonePickerNode timezonePickerNode = new TimezonePickerNode("Label", "127.0.0.1", "Placeholder");
    timezonePickerNode.appendChild(child);

    // Act
    timezonePickerNode.getText();

    // Assert
    verify(child).unlink();
  }

  /**
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
