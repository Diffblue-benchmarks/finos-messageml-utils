package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Node;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.markdown.nodes.EmojiNode;

public class DialogNodeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DialogNode}
   *   <li>{@link DialogNode#getClosingDelimiter()}
   *   <li>{@link DialogNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When {@link EmojiNode#EmojiNode()}.</li>
   *   <li>Then {@link EmojiNode#EmojiNode()} Next {@link HardLineBreak}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DialogNode#appendChild(Node)}
   */
  @Test
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
