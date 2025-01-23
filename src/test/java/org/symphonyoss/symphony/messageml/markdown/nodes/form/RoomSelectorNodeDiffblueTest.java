package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class RoomSelectorNodeDiffblueTest {
  /**
   * Test {@link RoomSelectorNode#RoomSelectorNode(String, String, String)}.
   * <p>
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
