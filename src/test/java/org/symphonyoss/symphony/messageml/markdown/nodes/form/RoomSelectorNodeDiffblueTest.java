package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import org.junit.Ignore;
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

  /**
   * Test {@link RoomSelectorNode#getText()}.
   * <p>
   * Method under test: {@link RoomSelectorNode#getText()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetText() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new RoomSelectorNode("Placeholder", "Label", "127.0.0.1")).getText();
  }
}
