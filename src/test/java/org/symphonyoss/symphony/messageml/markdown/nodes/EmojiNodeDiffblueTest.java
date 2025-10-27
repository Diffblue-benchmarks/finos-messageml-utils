package org.symphonyoss.symphony.messageml.markdown.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import org.commonmark.node.Document;
import org.commonmark.node.Visitor;
import org.commonmark.renderer.html.CoreHtmlNodeRenderer;
import org.commonmark.renderer.html.HtmlNodeRendererContext;
import org.commonmark.renderer.html.HtmlWriter;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.markdown.MarkdownRenderer;
import org.symphonyoss.symphony.messageml.util.IndentedPrintStream;

public class EmojiNodeDiffblueTest {
  /**
   * Method under test: {@link EmojiNode#accept(Visitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    EmojiNode emojiNode = new EmojiNode();
    HtmlNodeRendererContext context = mock(HtmlNodeRendererContext.class);
    when(context.getWriter()).thenReturn(new HtmlWriter(new IndentedPrintStream(new ByteArrayOutputStream(1))));

    // Act
    emojiNode.accept(new CoreHtmlNodeRenderer(context));

    // Assert that nothing has changed
    verify(context).getWriter();
  }

  /**
   * Method under test: {@link EmojiNode#accept(Visitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    EmojiNode emojiNode = new EmojiNode("Shortcode");
    MarkdownRenderer visitor = new MarkdownRenderer(new Document());

    // Act
    emojiNode.accept(visitor);

    // Assert
    assertEquals(":Shortcode:", visitor.getText());
  }

  /**
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

    // Assert that nothing has changed
    assertEquals(":", actualClosingDelimiter);
    assertEquals(":", actualOpeningDelimiter);
    assertEquals("Name", actualAnnotation);
    assertEquals("Shortcode", emojiNode.getShortcode());
  }

  /**
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
}
