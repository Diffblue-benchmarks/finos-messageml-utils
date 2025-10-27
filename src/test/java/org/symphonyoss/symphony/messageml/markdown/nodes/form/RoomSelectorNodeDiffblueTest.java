package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.commonmark.node.BlockQuote;
import org.junit.Test;

public class RoomSelectorNodeDiffblueTest {
  /**
   * Method under test: {@link RoomSelectorNode#getText()}
   */
  @Test
  public void testGetText() {
    // Arrange
    BlockQuote child = mock(BlockQuote.class);
    doNothing().when(child).unlink();

    RoomSelectorNode roomSelectorNode = new RoomSelectorNode("Placeholder", "Label", "127.0.0.1");
    roomSelectorNode.appendChild(child);

    // Act
    roomSelectorNode.getText();

    // Assert
    verify(child).unlink();
  }

  /**
   * Method under test:
   * {@link RoomSelectorNode#RoomSelectorNode(String, String, String)}
   */
  @Test
  public void testNewRoomSelectorNode() {
    // Arrange and Act
    RoomSelectorNode actualRoomSelectorNode = new RoomSelectorNode("Placeholder", "Label", "127.0.0.1");

    // Assert
    assertNull(actualRoomSelectorNode.getParent());
    assertNull(actualRoomSelectorNode.getFirstChild());
    assertNull(actualRoomSelectorNode.getLastChild());
    assertNull(actualRoomSelectorNode.getNext());
    assertNull(actualRoomSelectorNode.getPrevious());
  }
}
