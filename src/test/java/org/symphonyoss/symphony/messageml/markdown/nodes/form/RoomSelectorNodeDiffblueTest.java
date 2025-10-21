package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RoomSelectorNodeDiffblueTest {
  /**
   * Test {@link RoomSelectorNode#RoomSelectorNode(String, String, String)}.
   * <p>
   * Method under test: {@link RoomSelectorNode#RoomSelectorNode(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RoomSelectorNode.<init>(String, String, String)"})
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
