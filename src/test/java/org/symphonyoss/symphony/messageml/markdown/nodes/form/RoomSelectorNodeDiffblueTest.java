package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RoomSelectorNodeDiffblueTest {
  @InjectMocks private RoomSelectorNode roomSelectorNode;

  /**
   * Test {@link RoomSelectorNode#RoomSelectorNode(String, String, String)}.
   *
   * <p>Method under test: {@link RoomSelectorNode#RoomSelectorNode(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RoomSelectorNode.<init>(String, String, String)"})
  public void testNewRoomSelectorNode() {
    // Arrange and Act
    RoomSelectorNode actualRoomSelectorNode =
        new RoomSelectorNode("Placeholder", "Label", "127.0.0.1");

    // Assert
    assertNull(actualRoomSelectorNode.getParent());
    assertNull(actualRoomSelectorNode.getFirstChild());
    assertNull(actualRoomSelectorNode.getLastChild());
    assertNull(actualRoomSelectorNode.getNext());
    assertNull(actualRoomSelectorNode.getPrevious());
  }

  /**
   * Test {@link RoomSelectorNode#getText()}.
   *
   * <p>Method under test: {@link RoomSelectorNode#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String RoomSelectorNode.getText()"})
  public void testGetText() {
    // Arrange, Act and Assert
    assertEquals("", roomSelectorNode.getText());
  }
}
