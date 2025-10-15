package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.markdown.nodes.EmojiNode;

public class DialogNodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DialogNode}
   *   <li>{@link DialogNode#getClosingDelimiter()}
   *   <li>{@link DialogNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DialogNode.<init>()",
    "String DialogNode.getClosingDelimiter()",
    "String DialogNode.getOpeningDelimiter()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DialogNode actualDialogNode = new DialogNode();
    String actualClosingDelimiter = actualDialogNode.getClosingDelimiter();
    String actualOpeningDelimiter = actualDialogNode.getOpeningDelimiter();

    // Assert
    assertEquals("", actualDialogNode.getText());
    assertEquals("---\n", actualClosingDelimiter);
    assertEquals("---\n**Dialog**\n", actualOpeningDelimiter);
    assertNull(actualDialogNode.getParent());
    assertNull(actualDialogNode.getFirstChild());
    assertNull(actualDialogNode.getLastChild());
    assertNull(actualDialogNode.getNext());
    assertNull(actualDialogNode.getPrevious());
  }

  /**
   * Test {@link DialogNode#appendChild(Node)}.
   *
   * <ul>
   *   <li>When {@link EmojiNode#EmojiNode()}.
   *   <li>Then {@link EmojiNode#EmojiNode()} Next {@link HardLineBreak}.
   * </ul>
   *
   * <p>Method under test: {@link DialogNode#appendChild(Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DialogNode.appendChild(Node)"})
  public void testAppendChild_whenEmojiNode_thenEmojiNodeNextHardLineBreak() {
    // Arrange
    DialogNode dialogNode = new DialogNode();
    EmojiNode node = new EmojiNode();

    // Act
    dialogNode.appendChild(node);

    // Assert
    Node next = node.getNext();
    assertTrue(next instanceof HardLineBreak);
    assertNull(next.getFirstChild());
    assertNull(next.getLastChild());
    assertNull(next.getNext());
    assertSame(node, dialogNode.getFirstChild());
    assertSame(node, next.getPrevious());
    assertSame(dialogNode, node.getParent());
    assertSame(dialogNode, next.getParent());
  }
}
