package org.symphonyoss.symphony.messageml.markdown.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.commonmark.node.Document;
import org.commonmark.node.Visitor;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.markdown.MarkdownRenderer;

public class EmojiNodeDiffblueTest {
  /**
   * Test {@link EmojiNode#EmojiNode()}.
   * <p>
   * Method under test: {@link EmojiNode#EmojiNode()}
   */
  @Test
  public void testNewEmojiNode() {
    // Arrange and Act
    EmojiNode actualEmojiNode = new EmojiNode();

    // Assert
    assertEquals(":", actualEmojiNode.getClosingDelimiter());
    assertEquals(":", actualEmojiNode.getOpeningDelimiter());
    assertNull(actualEmojiNode.getAnnotation());
    assertNull(actualEmojiNode.getShortcode());
    assertNull(actualEmojiNode.getFirstChild());
    assertNull(actualEmojiNode.getLastChild());
    assertNull(actualEmojiNode.getNext());
    assertNull(actualEmojiNode.getParent());
    assertNull(actualEmojiNode.getPrevious());
  }

  /**
   * Test {@link EmojiNode#EmojiNode(String)}.
   * <p>
   * Method under test: {@link EmojiNode#EmojiNode(String)}
   */
  @Test
  public void testNewEmojiNode2() {
    // Arrange and Act
    EmojiNode actualEmojiNode = new EmojiNode("Shortcode");

    // Assert
    assertEquals(":", actualEmojiNode.getClosingDelimiter());
    assertEquals(":", actualEmojiNode.getOpeningDelimiter());
    assertEquals("Shortcode", actualEmojiNode.getAnnotation());
    assertEquals("Shortcode", actualEmojiNode.getShortcode());
    assertNull(actualEmojiNode.getFirstChild());
    assertNull(actualEmojiNode.getLastChild());
    assertNull(actualEmojiNode.getNext());
    assertNull(actualEmojiNode.getParent());
    assertNull(actualEmojiNode.getPrevious());
  }

  /**
   * Test {@link EmojiNode#accept(Visitor)}.
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is {@code :Shortcode:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmojiNode#accept(Visitor)}
   */
  @Test
  public void testAccept_thenMarkdownRendererWithDocumentIsDocumentTextIsShortcode() {
    // Arrange
    EmojiNode emojiNode = new EmojiNode();
    emojiNode.setShortcode("Shortcode");
    MarkdownRenderer visitor = new MarkdownRenderer(new Document());

    // Act
    emojiNode.accept(visitor);

    // Assert
    assertEquals(":Shortcode:", visitor.getText());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmojiNode#setAnnotation(String)}
   *   <li>{@link EmojiNode#setShortcode(String)}
   *   <li>{@link EmojiNode#getAnnotation()}
   *   <li>{@link EmojiNode#getClosingDelimiter()}
   *   <li>{@link EmojiNode#getOpeningDelimiter()}
   *   <li>{@link EmojiNode#getShortcode()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    EmojiNode emojiNode = new EmojiNode();

    // Act
    emojiNode.setAnnotation("Name");
    emojiNode.setShortcode("Shortcode");
    String actualAnnotation = emojiNode.getAnnotation();
    String actualClosingDelimiter = emojiNode.getClosingDelimiter();
    String actualOpeningDelimiter = emojiNode.getOpeningDelimiter();

    // Assert
    assertEquals(":", actualClosingDelimiter);
    assertEquals(":", actualOpeningDelimiter);
    assertEquals("Name", actualAnnotation);
    assertEquals("Shortcode", emojiNode.getShortcode());
  }
}
