package org.symphonyoss.symphony.messageml.markdown;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.Iterator;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.CustomBlock;
import org.commonmark.node.CustomNode;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Link;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.symphonyoss.symphony.messageml.markdown.MarkdownRenderer.TrackingWriter;
import org.symphonyoss.symphony.messageml.markdown.nodes.EmojiNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.KeywordNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.MentionNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.PreformattedNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableCellNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableRowNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.TagNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.ButtonNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.CheckboxNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.DateSelectorNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.DialogNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.OptionNode;

@RunWith(MockitoJUnitRunner.class)
public class MarkdownRendererDiffblueTest {
  @Mock private Document document;

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_givenBlockQuoteAppendChildEmojiNode() {
    // Arrange
    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    BlockQuote child2 = new BlockQuote();
    child2.appendChild(child);

    Document document = new Document();
    document.appendChild(child2);

    // Act and Assert
    assertEquals(":Shortcode:", new MarkdownRenderer(document).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>Given {@link BulletList} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_givenBulletListAppendChildEmojiNode() {
    // Arrange
    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    BulletList child2 = new BulletList();
    child2.appendChild(child);

    Document document = new Document();
    document.appendChild(child2);

    // Act and Assert
    assertEquals(":Shortcode:\n", new MarkdownRenderer(document).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>Given {@link DialogNode} (default constructor) appendChild {@link TableCellNode} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_givenDialogNodeAppendChildTableCellNode() {
    // Arrange
    DialogNode child = new DialogNode();
    child.appendChild(new TableCellNode());

    Document document = new Document();
    document.appendChild(child);

    // Act and Assert
    assertEquals("---\n**Dialog**\n   \n---\n", new MarkdownRenderer(document).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>Given {@link DialogNode} (default constructor) appendChild {@link TableRowNode} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_givenDialogNodeAppendChildTableRowNode() {
    // Arrange
    DialogNode child = new DialogNode();
    child.appendChild(new TableRowNode());

    Document document = new Document();
    document.appendChild(child);

    // Act and Assert
    assertEquals("---\n**Dialog**\n\n---\n", new MarkdownRenderer(document).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>Given {@link Document} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_givenDocumentAppendChildEmojiNode() {
    // Arrange
    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    Document child2 = new Document();
    child2.appendChild(child);

    Document document = new Document();
    document.appendChild(child2);

    // Act and Assert
    assertEquals(":Shortcode:", new MarkdownRenderer(document).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>Given {@link FencedCodeBlock} (default constructor) appendChild {@link
   *       EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_givenFencedCodeBlockAppendChildEmojiNode() {
    // Arrange
    FencedCodeBlock child = new FencedCodeBlock();
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act and Assert
    assertEquals("", new MarkdownRenderer(document).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>Given {@link FencedCodeBlock} (default constructor) Info is space.
   *   <li>Then return Text is space lf.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_givenFencedCodeBlockInfoIsSpace_thenReturnTextIsSpaceLf() {
    // Arrange
    FencedCodeBlock child = new FencedCodeBlock();
    child.setInfo(" ");
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act and Assert
    assertEquals(" \n", new MarkdownRenderer(document).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).
   *   <li>Then return Text is lf lf.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_givenPreformattedNode_thenReturnTextIsLfLf() {
    // Arrange
    Document document = new Document();
    document.appendChild(new PreformattedNode());

    // Act and Assert
    assertEquals("\n\n", new MarkdownRenderer(document).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).
   *   <li>When {@link Document} (default constructor) appendChild {@link TableCellNode} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_givenTableCellNode_whenDocumentAppendChildTableCellNode() {
    // Arrange
    Document document = new Document();
    document.appendChild(new TableCellNode());

    // Act and Assert
    assertEquals("", new MarkdownRenderer(document).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>Given {@link TableRowNode} (default constructor).
   *   <li>When {@link Document} (default constructor) appendChild {@link TableRowNode} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_givenTableRowNode_whenDocumentAppendChildTableRowNode() {
    // Arrange
    Document document = new Document();
    document.appendChild(new TableRowNode());

    // Act and Assert
    assertEquals("", new MarkdownRenderer(document).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>Then calls {@link Document#getFirstChild()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_thenCallsGetFirstChild() {
    // Arrange
    EmojiNode emojiNode = new EmojiNode();
    emojiNode.setShortcode("Shortcode");
    when(document.getFirstChild()).thenReturn(emojiNode);

    // Act
    MarkdownRenderer actualMarkdownRenderer = new MarkdownRenderer(document);

    // Assert
    verify(document).getFirstChild();
    assertEquals(":Shortcode:", actualMarkdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>Then return Text is {@code (Button::(:)}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_thenReturnTextIsButton() {
    // Arrange
    EmojiNode child = new EmojiNode();
    child.setShortcode("(");

    ButtonNode child2 = new ButtonNode();
    child2.appendChild(child);

    Document document = new Document();
    document.appendChild(child2);

    // Act and Assert
    assertEquals("(Button::(:)", new MarkdownRenderer(document).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>Then return Text is {@code Delimiter Delimiter}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_thenReturnTextIsDelimiterDelimiter() {
    // Arrange
    Emphasis child = new Emphasis("Delimiter");
    child.appendChild(new HardLineBreak());

    Document document = new Document();
    document.appendChild(child);

    // Act and Assert
    assertEquals("Delimiter\nDelimiter", new MarkdownRenderer(document).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>Then return Text is {@code Delimiter:Shortcode:Delimiter}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_thenReturnTextIsDelimiterShortcodeDelimiter() {
    // Arrange
    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    Emphasis child2 = new Emphasis("Delimiter");
    child2.appendChild(child);

    Document document = new Document();
    document.appendChild(child2);

    // Act and Assert
    assertEquals("Delimiter:Shortcode:Delimiter", new MarkdownRenderer(document).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>Then return Text is {@code --- **Dialog** :--- **Dialog** : ---}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_thenReturnTextIsDialogDialog() {
    // Arrange
    EmojiNode node = new EmojiNode();
    node.setShortcode("---\n**Dialog**\n");

    DialogNode child = new DialogNode();
    child.appendChild(node);

    Document document = new Document();
    document.appendChild(child);

    // Act and Assert
    assertEquals(
        "---\n**Dialog**\n:---\n**Dialog**\n:\n---\n", new MarkdownRenderer(document).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>Then return Text is lf space space space lf lf space space space lf.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_thenReturnTextIsLfSpaceSpaceSpaceLfLfSpaceSpaceSpaceLf() {
    // Arrange
    Document document = new Document();
    document.appendChild(new TableNode());

    // Act and Assert
    assertEquals("\n   \n\n   \n", new MarkdownRenderer(document).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>Then return Text is null null null null null null.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_thenReturnTextIsNullNullNullNullNullNull() {
    // Arrange
    FencedCodeBlock child = new FencedCodeBlock();
    child.setFenceLength(3);
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act and Assert
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000", new MarkdownRenderer(document).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>Then return Text is space space.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_thenReturnTextIsSpaceSpace() {
    // Arrange
    CheckboxNode child = new CheckboxNode();
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act and Assert
    assertEquals("  ", new MarkdownRenderer(document).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>When {@link Document} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_whenDocumentAppendChildEmojiNode() {
    // Arrange
    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    Document document = new Document();
    document.appendChild(child);

    // Act and Assert
    assertEquals(":Shortcode:", new MarkdownRenderer(document).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   *
   * <ul>
   *   <li>When {@link Document} (default constructor).
   *   <li>Then return Text is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.<init>(Document)"})
  public void testNewMarkdownRenderer_whenDocument_thenReturnTextIsEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new MarkdownRenderer(new Document()).getText());
  }

  /**
   * Test TrackingWriter {@link TrackingWriter#doubleLine()}.
   *
   * <p>Method under test: {@link TrackingWriter#doubleLine()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrackingWriter.doubleLine()"})
  public void testTrackingWriterDoubleLine() {
    // Arrange
    StringBuilder out = new StringBuilder("Str");
    out.appendCodePoint(0);
    TrackingWriter trackingWriter = new MarkdownRenderer(new Document()).new TrackingWriter(out);

    // Act
    trackingWriter.doubleLine();

    // Assert that nothing has changed
    assertEquals("Str\u0000", trackingWriter.out.toString());
    assertEquals('\u0000', trackingWriter.getLastChar());
    assertEquals(4, trackingWriter.length());
  }

  /**
   * Test TrackingWriter {@link TrackingWriter#doubleLine()}.
   *
   * <p>Method under test: {@link TrackingWriter#doubleLine()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrackingWriter.doubleLine()"})
  public void testTrackingWriterDoubleLine2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());
    TrackingWriter trackingWriter = markdownRenderer.new TrackingWriter(new StringBuilder(""));

    // Act
    trackingWriter.doubleLine();

    // Assert that nothing has changed
    assertEquals("", trackingWriter.out.toString());
    assertEquals('\u0000', trackingWriter.getLastChar());
    assertEquals(0, trackingWriter.length());
  }

  /**
   * Test TrackingWriter {@link TrackingWriter#doubleLine()}.
   *
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code Str}.
   * </ul>
   *
   * <p>Method under test: {@link TrackingWriter#doubleLine()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrackingWriter.doubleLine()"})
  public void testTrackingWriterDoubleLine_givenStringBuilderWithStr() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());
    TrackingWriter trackingWriter = markdownRenderer.new TrackingWriter(new StringBuilder("Str"));

    // Act
    trackingWriter.doubleLine();

    // Assert
    assertEquals("Str\n\n", trackingWriter.out.toString());
    assertEquals('\n', trackingWriter.getLastChar());
    assertEquals(5, trackingWriter.length());
  }

  /**
   * Test TrackingWriter {@link TrackingWriter#doubleLine()}.
   *
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code Str} append lf lf.
   * </ul>
   *
   * <p>Method under test: {@link TrackingWriter#doubleLine()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrackingWriter.doubleLine()"})
  public void testTrackingWriterDoubleLine_givenStringBuilderWithStrAppendLfLf() {
    // Arrange
    StringBuilder out = new StringBuilder("Str");
    out.append("\n\n");
    TrackingWriter trackingWriter = new MarkdownRenderer(new Document()).new TrackingWriter(out);

    // Act
    trackingWriter.doubleLine();

    // Assert that nothing has changed
    assertEquals("Str\n\n", trackingWriter.out.toString());
    assertEquals('\n', trackingWriter.getLastChar());
    assertEquals(5, trackingWriter.length());
  }

  /**
   * Test TrackingWriter {@link TrackingWriter#getLastChar()}.
   *
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with empty string.
   *   <li>Then return null.
   * </ul>
   *
   * <p>Method under test: {@link TrackingWriter#getLastChar()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"char TrackingWriter.getLastChar()"})
  public void testTrackingWriterGetLastChar_givenStringBuilderWithEmptyString_thenReturnNull() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act and Assert
    assertEquals(
        '\u0000', markdownRenderer.new TrackingWriter(new StringBuilder("")).getLastChar());
  }

  /**
   * Test TrackingWriter {@link TrackingWriter#getLastChar()}.
   *
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code Str}.
   *   <li>Then return {@code r}.
   * </ul>
   *
   * <p>Method under test: {@link TrackingWriter#getLastChar()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"char TrackingWriter.getLastChar()"})
  public void testTrackingWriterGetLastChar_givenStringBuilderWithStr_thenReturnR() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act and Assert
    assertEquals('r', markdownRenderer.new TrackingWriter(new StringBuilder("Str")).getLastChar());
  }

  /**
   * Test TrackingWriter getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TrackingWriter#TrackingWriter(MarkdownRenderer, StringBuilder)}
   *   <li>{@link TrackingWriter#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TrackingWriter.<init>(MarkdownRenderer, StringBuilder)",
    "String TrackingWriter.toString()"
  })
  public void testTrackingWriterGettersAndSetters() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    TrackingWriter actualTrackingWriter =
        markdownRenderer.new TrackingWriter(new StringBuilder("Str"));
    String actualToStringResult = actualTrackingWriter.toString();

    // Assert
    assertEquals("Str", actualTrackingWriter.out.toString());
    assertEquals("Str", actualToStringResult);
  }

  /**
   * Test TrackingWriter {@link TrackingWriter#length()}.
   *
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code Str}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link TrackingWriter#length()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int TrackingWriter.length()"})
  public void testTrackingWriterLength_givenStringBuilderWithStr_thenReturnThree() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act and Assert
    assertEquals(3, markdownRenderer.new TrackingWriter(new StringBuilder("Str")).length());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    BulletList ul = new BulletList();
    ul.appendChild(new TableNode());

    // Act
    markdownRenderer.visit(ul);

    // Assert
    assertEquals("\n   \n\n   \n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    CheckboxNode child = new CheckboxNode();
    child.appendChild(new EmojiNode());

    BulletList ul = new BulletList();
    ul.appendChild(child);

    // Act
    markdownRenderer.visit(ul);

    // Assert
    assertEquals("  \n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList3() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    Emphasis child2 = new Emphasis("Delimiter");
    child2.appendChild(child);

    BulletList ul = new BulletList();
    ul.appendChild(child2);

    // Act
    markdownRenderer.visit(ul);

    // Assert
    assertEquals("Delimiter:Shortcode:Delimiter\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList4() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    Emphasis child = new Emphasis("Delimiter");
    child.appendChild(new HardLineBreak());

    BulletList ul = new BulletList();
    ul.appendChild(child);

    // Act
    markdownRenderer.visit(ul);

    // Assert
    assertEquals("Delimiter\nDelimiter\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList5() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock child = new FencedCodeBlock();
    child.setFenceLength(3);
    child.appendChild(new EmojiNode());

    BulletList ul = new BulletList();
    ul.appendChild(child);

    // Act
    markdownRenderer.visit(ul);

    // Assert
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList6() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode node = new EmojiNode();
    node.setShortcode("---\n**Dialog**\n");

    DialogNode child = new DialogNode();
    child.appendChild(node);

    BulletList ul = new BulletList();
    ul.appendChild(child);

    // Act
    markdownRenderer.visit(ul);

    // Assert
    assertEquals("---\n**Dialog**\n:---\n**Dialog**\n:\n---\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList_givenBlockQuoteAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    BlockQuote child2 = new BlockQuote();
    child2.appendChild(child);

    BulletList ul = new BulletList();
    ul.appendChild(child2);

    // Act
    markdownRenderer.visit(ul);

    // Assert
    assertEquals(":Shortcode:\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <ul>
   *   <li>Given {@link BulletList} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList_givenBulletListAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    BulletList child2 = new BulletList();
    child2.appendChild(child);

    BulletList ul = new BulletList();
    ul.appendChild(child2);

    // Act
    markdownRenderer.visit(ul);

    // Assert
    assertEquals(":Shortcode:\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <ul>
   *   <li>Given {@link DialogNode} (default constructor) appendChild {@link TableCellNode} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList_givenDialogNodeAppendChildTableCellNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    DialogNode child = new DialogNode();
    child.appendChild(new TableCellNode());

    BulletList ul = new BulletList();
    ul.appendChild(child);

    // Act
    markdownRenderer.visit(ul);

    // Assert
    assertEquals("---\n**Dialog**\n   \n---\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <ul>
   *   <li>Given {@link DialogNode} (default constructor) appendChild {@link TableRowNode} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList_givenDialogNodeAppendChildTableRowNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    DialogNode child = new DialogNode();
    child.appendChild(new TableRowNode());

    BulletList ul = new BulletList();
    ul.appendChild(child);

    // Act
    markdownRenderer.visit(ul);

    // Assert
    assertEquals("---\n**Dialog**\n\n---\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <ul>
   *   <li>Given {@link Document} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList_givenDocumentAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    Document child2 = new Document();
    child2.appendChild(child);

    BulletList ul = new BulletList();
    ul.appendChild(child2);

    // Act
    markdownRenderer.visit(ul);

    // Assert
    assertEquals(":Shortcode:\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <ul>
   *   <li>Given {@link FencedCodeBlock} (default constructor) appendChild {@link
   *       EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList_givenFencedCodeBlockAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock child = new FencedCodeBlock();
    child.appendChild(new EmojiNode());

    BulletList ul = new BulletList();
    ul.appendChild(child);

    // Act
    markdownRenderer.visit(ul);

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList_givenTableCellNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    BulletList ul = new BulletList();
    ul.appendChild(new TableCellNode());

    // Act
    markdownRenderer.visit(ul);

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <ul>
   *   <li>Given {@link TableRowNode} (default constructor).
   *   <li>When {@link BulletList} (default constructor) appendChild {@link TableRowNode} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList_givenTableRowNode_whenBulletListAppendChildTableRowNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    BulletList ul = new BulletList();
    ul.appendChild(new TableRowNode());

    // Act
    markdownRenderer.visit(ul);

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is {@code (Button::(:)}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList_thenMarkdownRendererWithDocumentIsDocumentTextIsButton() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("(");

    ButtonNode child2 = new ButtonNode();
    child2.appendChild(child);

    BulletList ul = new BulletList();
    ul.appendChild(child2);

    // Act
    markdownRenderer.visit(ul);

    // Assert
    assertEquals("(Button::(:)\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is lf lf.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList_thenMarkdownRendererWithDocumentIsDocumentTextIsLfLf() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    BulletList ul = new BulletList();
    ul.appendChild(new PreformattedNode());

    // Act
    markdownRenderer.visit(ul);

    // Assert
    assertEquals("\n\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is space lf.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList_thenMarkdownRendererWithDocumentIsDocumentTextIsSpaceLf() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock child = new FencedCodeBlock();
    child.setInfo(" ");
    child.appendChild(new EmojiNode());

    BulletList ul = new BulletList();
    ul.appendChild(child);

    // Act
    markdownRenderer.visit(ul);

    // Assert
    assertEquals(" \n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <ul>
   *   <li>When {@link BulletList} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList_whenBulletList() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new BulletList());

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   *
   * <ul>
   *   <li>When {@link BulletList} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(BulletList)"})
  public void testVisitWithBulletList_whenBulletListAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    BulletList ul = new BulletList();
    ul.appendChild(child);

    // Act
    markdownRenderer.visit(ul);

    // Assert
    assertEquals(":Shortcode:\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomBlock)"})
  public void testVisitWithCustomBlock() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new TableNode());

    // Assert
    assertEquals("\n   \n\n   \n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomBlock)"})
  public void testVisitWithCustomBlock2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("\n");

    PreformattedNode node = new PreformattedNode();
    node.appendChild(child);

    // Act
    markdownRenderer.visit(node);

    // Assert
    assertEquals("\n:\n:\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomBlock)"})
  public void testVisitWithCustomBlock3() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    PreformattedNode node = new PreformattedNode();
    node.appendChild(new PreformattedNode());

    // Act
    markdownRenderer.visit(node);

    // Assert
    assertEquals("\n\n\n\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomBlock)"})
  public void testVisitWithCustomBlock4() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    CheckboxNode node = new CheckboxNode(" * ");
    node.appendChild(new EmojiNode());

    // Act
    markdownRenderer.visit(node);

    // Assert
    assertEquals("  *  ", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomBlock)"})
  public void testVisitWithCustomBlock5() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    DateSelectorNode node = new DateSelectorNode(" * ");
    node.appendChild(new EmojiNode());

    // Act
    markdownRenderer.visit(node);

    // Assert
    assertEquals("(Date Selector:[ \\* ])", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomBlock)"})
  public void testVisitWithCustomBlock6() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode node = new EmojiNode();
    node.setShortcode("---\n**Dialog**\n");

    DialogNode node2 = new DialogNode();
    node2.appendChild(node);

    // Act
    markdownRenderer.visit(node2);

    // Assert
    assertEquals("---\n**Dialog**\n:---\n**Dialog**\n:\n---\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomBlock)"})
  public void testVisitWithCustomBlock7() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("-");

    OptionNode node = new OptionNode();
    node.appendChild(child);

    // Act
    markdownRenderer.visit(node);

    // Assert
    assertEquals("-:-:\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomBlock)"})
  public void testVisitWithCustomBlock_givenTableCellNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    DialogNode node = new DialogNode();
    node.appendChild(new TableCellNode());

    // Act
    markdownRenderer.visit(node);

    // Assert
    assertEquals("---\n**Dialog**\n   \n---\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <ul>
   *   <li>Given {@link TableRowNode} (default constructor).
   *   <li>When {@link DialogNode} (default constructor) appendChild {@link TableRowNode} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomBlock)"})
  public void testVisitWithCustomBlock_givenTableRowNode_whenDialogNodeAppendChildTableRowNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    DialogNode node = new DialogNode();
    node.appendChild(new TableRowNode());

    // Act
    markdownRenderer.visit(node);

    // Assert
    assertEquals("---\n**Dialog**\n\n---\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is {@code (Button:)}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomBlock)"})
  public void testVisitWithCustomBlock_thenMarkdownRendererWithDocumentIsDocumentTextIsButton() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new ButtonNode());

    // Assert
    assertEquals("(Button:)", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is lf lf.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomBlock)"})
  public void testVisitWithCustomBlock_thenMarkdownRendererWithDocumentIsDocumentTextIsLfLf() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new PreformattedNode());

    // Assert
    assertEquals("\n\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <ul>
   *   <li>When {@link CheckboxNode#CheckboxNode()} appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomBlock)"})
  public void testVisitWithCustomBlock_whenCheckboxNodeAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    CheckboxNode node = new CheckboxNode();
    node.appendChild(new EmojiNode());

    // Act
    markdownRenderer.visit(node);

    // Assert
    assertEquals("  ", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <ul>
   *   <li>When {@link CheckboxNode#CheckboxNode(String)} with label is space appendChild {@link
   *       EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomBlock)"})
  public void testVisitWithCustomBlock_whenCheckboxNodeWithLabelIsSpaceAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    CheckboxNode node = new CheckboxNode(" ");
    node.appendChild(new EmojiNode());

    // Act
    markdownRenderer.visit(node);

    // Assert
    assertEquals("  ", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomBlock)"})
  public void testVisitWithCustomBlock_whenNull() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit((CustomBlock) null);

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <ul>
   *   <li>When {@link TableCellNode} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomBlock)"})
  public void testVisitWithCustomBlock_whenTableCellNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new TableCellNode());

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <ul>
   *   <li>When {@link TableRowNode} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomBlock)"})
  public void testVisitWithCustomBlock_whenTableRowNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new TableRowNode());

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomNode)} with {@code CustomNode}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomNode)"})
  public void testVisitWithCustomNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode node = new EmojiNode();
    node.setShortcode("Shortcode");

    // Act
    markdownRenderer.visit(node);

    // Assert
    assertEquals(":Shortcode:", markdownRenderer.getText());
    assertFalse(markdownRenderer.getJson().iterator().hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomNode)} with {@code CustomNode}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomNode)"})
  public void testVisitWithCustomNode2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit((CustomNode) null);

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
    assertFalse(markdownRenderer.getJson().iterator().hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomNode)} with {@code CustomNode}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomNode)"})
  public void testVisitWithCustomNode3() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new KeywordNode("indexStart", "Text"));

    // Assert
    Iterator<JsonNode> iteratorResult = markdownRenderer.getJson().iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    assertTrue(nextResult2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult2 = nextResult2.iterator();
    assertTrue(iteratorResult2.next() instanceof TextNode);
    assertTrue(iteratorResult2.next() instanceof TextNode);
    assertEquals("indexStartText", markdownRenderer.getText());
    assertEquals(5, nextResult2.size());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(iteratorResult2.hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomNode)} with {@code CustomNode}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomNode)"})
  public void testVisitWithCustomNode4() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());
    MentionNode node = new MentionNode(1L, "id", "id", "jane.doe@example.org");

    // Act
    markdownRenderer.visit(node);

    // Assert
    Iterator<JsonNode> iteratorResult = markdownRenderer.getJson().iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    Iterator<JsonNode> iteratorResult2 = nextResult2.iterator();
    assertTrue(iteratorResult2.next() instanceof LongNode);
    assertTrue(nextResult2 instanceof ObjectNode);
    assertTrue(iteratorResult2.next() instanceof TextNode);
    assertEquals("@id", markdownRenderer.getText());
    assertEquals(8, nextResult2.size());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(iteratorResult2.hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomNode)} with {@code CustomNode}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomNode)"})
  public void testVisitWithCustomNode5() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());
    TagNode node = new TagNode("Prefix", "Text", DoubleNode.valueOf(10.0d));

    // Act
    markdownRenderer.visit(node);

    // Assert
    Iterator<JsonNode> iteratorResult = markdownRenderer.getJson().iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    assertTrue(nextResult2 instanceof ObjectNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertEquals(6, nextResult2.size());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomNode)} with {@code CustomNode}.
   *
   * <ul>
   *   <li>When {@link KeywordNode#KeywordNode(String, String)} with {@code Prefix} and {@code
   *       Text}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomNode)"})
  public void testVisitWithCustomNode_whenKeywordNodeWithPrefixAndText() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new KeywordNode("Prefix", "Text"));

    // Assert
    Iterator<JsonNode> iteratorResult = markdownRenderer.getJson().iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    assertTrue(nextResult2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult2 = nextResult2.iterator();
    assertTrue(iteratorResult2.next() instanceof TextNode);
    assertTrue(iteratorResult2.next() instanceof TextNode);
    assertEquals("PrefixText", markdownRenderer.getText());
    assertEquals(5, nextResult2.size());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(iteratorResult2.hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomNode)} with {@code CustomNode}.
   *
   * <ul>
   *   <li>When {@link TagNode#TagNode(String, String, JsonNode)} with {@code Prefix} and {@code
   *       Text} and data is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(CustomNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(CustomNode)"})
  public void testVisitWithCustomNode_whenTagNodeWithPrefixAndTextAndDataIsNull() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());
    TagNode node = new TagNode("Prefix", "Text", null);

    // Act
    markdownRenderer.visit(node);

    // Assert
    Iterator<JsonNode> iteratorResult = markdownRenderer.getJson().iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    assertTrue(nextResult2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult2 = nextResult2.iterator();
    assertTrue(iteratorResult2.next() instanceof TextNode);
    assertTrue(iteratorResult2.next() instanceof TextNode);
    assertEquals("PrefixText", markdownRenderer.getText());
    assertEquals(5, nextResult2.size());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(iteratorResult2.hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    Document document = new Document();
    document.appendChild(new TableNode());

    // Act
    markdownRenderer.visit(document);

    // Assert
    assertEquals("\n   \n\n   \n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    Emphasis child2 = new Emphasis("Delimiter");
    child2.appendChild(child);

    Document document = new Document();
    document.appendChild(child2);

    // Act
    markdownRenderer.visit(document);

    // Assert
    assertEquals("Delimiter:Shortcode:Delimiter", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument3() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    Emphasis child = new Emphasis("Delimiter");
    child.appendChild(new HardLineBreak());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownRenderer.visit(document);

    // Assert
    assertEquals("Delimiter\nDelimiter", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument4() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock child = new FencedCodeBlock();
    child.setFenceLength(3);
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownRenderer.visit(document);

    // Assert
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument5() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode node = new EmojiNode();
    node.setShortcode("---\n**Dialog**\n");

    DialogNode child = new DialogNode();
    child.appendChild(node);

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownRenderer.visit(document);

    // Assert
    assertEquals("---\n**Dialog**\n:---\n**Dialog**\n:\n---\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument_givenBlockQuoteAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    BlockQuote child2 = new BlockQuote();
    child2.appendChild(child);

    Document document = new Document();
    document.appendChild(child2);

    // Act
    markdownRenderer.visit(document);

    // Assert
    assertEquals(":Shortcode:", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>Given {@link BulletList} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument_givenBulletListAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    BulletList child2 = new BulletList();
    child2.appendChild(child);

    Document document = new Document();
    document.appendChild(child2);

    // Act
    markdownRenderer.visit(document);

    // Assert
    assertEquals(":Shortcode:\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>Given {@link DialogNode} (default constructor) appendChild {@link TableCellNode} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument_givenDialogNodeAppendChildTableCellNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    DialogNode child = new DialogNode();
    child.appendChild(new TableCellNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownRenderer.visit(document);

    // Assert
    assertEquals("---\n**Dialog**\n   \n---\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>Given {@link DialogNode} (default constructor) appendChild {@link TableRowNode} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument_givenDialogNodeAppendChildTableRowNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    DialogNode child = new DialogNode();
    child.appendChild(new TableRowNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownRenderer.visit(document);

    // Assert
    assertEquals("---\n**Dialog**\n\n---\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>Given {@link Document} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument_givenDocumentAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    Document child2 = new Document();
    child2.appendChild(child);

    Document document = new Document();
    document.appendChild(child2);

    // Act
    markdownRenderer.visit(document);

    // Assert
    assertEquals(":Shortcode:", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>Given {@link FencedCodeBlock} (default constructor) appendChild {@link
   *       EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument_givenFencedCodeBlockAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock child = new FencedCodeBlock();
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownRenderer.visit(document);

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).
   *   <li>When {@link Document} (default constructor) appendChild {@link TableCellNode} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument_givenTableCellNode_whenDocumentAppendChildTableCellNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    Document document = new Document();
    document.appendChild(new TableCellNode());

    // Act
    markdownRenderer.visit(document);

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>Given {@link TableRowNode} (default constructor).
   *   <li>When {@link Document} (default constructor) appendChild {@link TableRowNode} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument_givenTableRowNode_whenDocumentAppendChildTableRowNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    Document document = new Document();
    document.appendChild(new TableRowNode());

    // Act
    markdownRenderer.visit(document);

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is {@code (Button::(:)}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument_thenMarkdownRendererWithDocumentIsDocumentTextIsButton() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("(");

    ButtonNode child2 = new ButtonNode();
    child2.appendChild(child);

    Document document = new Document();
    document.appendChild(child2);

    // Act
    markdownRenderer.visit(document);

    // Assert
    assertEquals("(Button::(:)", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is lf lf.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument_thenMarkdownRendererWithDocumentIsDocumentTextIsLfLf() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    Document document = new Document();
    document.appendChild(new PreformattedNode());

    // Act
    markdownRenderer.visit(document);

    // Assert
    assertEquals("\n\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is space lf.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument_thenMarkdownRendererWithDocumentIsDocumentTextIsSpaceLf() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock child = new FencedCodeBlock();
    child.setInfo(" ");
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownRenderer.visit(document);

    // Assert
    assertEquals(" \n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is space space.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument_thenMarkdownRendererWithDocumentIsDocumentTextIsSpaceSpace() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    CheckboxNode child = new CheckboxNode();
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownRenderer.visit(document);

    // Assert
    assertEquals("  ", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>When {@link Document} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument_whenDocument() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Document());

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>When {@link Document} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Document)"})
  public void testVisitWithDocument_whenDocumentAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownRenderer.visit(document);

    // Assert
    assertEquals(":Shortcode:", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Emphasis)} with {@code Emphasis}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Emphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Emphasis)"})
  public void testVisitWithEmphasis() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    Emphasis em = new Emphasis("Delimiter");
    em.appendChild(child);

    // Act
    markdownRenderer.visit(em);

    // Assert
    assertEquals("Delimiter:Shortcode:Delimiter", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Emphasis)} with {@code Emphasis}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Emphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Emphasis)"})
  public void testVisitWithEmphasis2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    Emphasis em = new Emphasis("Delimiter");
    em.appendChild(new Emphasis("Delimiter"));

    // Act
    markdownRenderer.visit(em);

    // Assert
    assertEquals("DelimiterDelimiterDelimiterDelimiter", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Emphasis)} with {@code Emphasis}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Emphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Emphasis)"})
  public void testVisitWithEmphasis3() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    Emphasis em = new Emphasis("Delimiter");
    em.appendChild(new HardLineBreak());

    // Act
    markdownRenderer.visit(em);

    // Assert
    assertEquals("Delimiter\nDelimiter", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Emphasis)} with {@code Emphasis}.
   *
   * <ul>
   *   <li>Given {@link Code#Code()}.
   *   <li>When {@link Emphasis#Emphasis(String)} with {@code Delimiter} appendChild {@link
   *       Code#Code()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Emphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Emphasis)"})
  public void testVisitWithEmphasis_givenCode_whenEmphasisWithDelimiterAppendChildCode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    Emphasis em = new Emphasis("Delimiter");
    em.appendChild(new Code());

    // Act
    markdownRenderer.visit(em);

    // Assert
    assertEquals("DelimiterDelimiter", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Emphasis)} with {@code Emphasis}.
   *
   * <ul>
   *   <li>When {@link Emphasis#Emphasis(String)} with {@code Delimiter}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Emphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Emphasis)"})
  public void testVisitWithEmphasis_whenEmphasisWithDelimiter() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Emphasis("Delimiter"));

    // Assert
    assertEquals("DelimiterDelimiter", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(FencedCodeBlock)} with {@code FencedCodeBlock}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(FencedCodeBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(FencedCodeBlock)"})
  public void testVisitWithFencedCodeBlock() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock code = new FencedCodeBlock();
    code.appendChild(new EmojiNode());

    // Act
    markdownRenderer.visit(code);

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(FencedCodeBlock)} with {@code FencedCodeBlock}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(FencedCodeBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(FencedCodeBlock)"})
  public void testVisitWithFencedCodeBlock2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock code = new FencedCodeBlock();
    code.setFenceLength(3);
    code.appendChild(new EmojiNode());

    // Act
    markdownRenderer.visit(code);

    // Assert
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(FencedCodeBlock)} with {@code FencedCodeBlock}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(FencedCodeBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(FencedCodeBlock)"})
  public void testVisitWithFencedCodeBlock3() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock code = new FencedCodeBlock();
    code.setInfo(" ");
    code.appendChild(new EmojiNode());

    // Act
    markdownRenderer.visit(code);

    // Assert
    assertEquals(" \n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(FencedCodeBlock)} with {@code FencedCodeBlock}.
   *
   * <ul>
   *   <li>When {@link FencedCodeBlock} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(FencedCodeBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(FencedCodeBlock)"})
  public void testVisitWithFencedCodeBlock_whenFencedCodeBlock() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new FencedCodeBlock());

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Link)} with {@code Link}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Link)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Link)"})
  public void testVisitWithLink() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Link());

    // Assert
    Iterator<JsonNode> iteratorResult = markdownRenderer.getJson().iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    Iterator<JsonNode> iteratorResult2 = nextResult2.iterator();
    JsonNode nextResult3 = iteratorResult2.next();
    assertTrue(nextResult3 instanceof NullNode);
    assertTrue(nextResult2 instanceof ObjectNode);
    assertEquals("[ null ](null)", markdownRenderer.getText());
    assertEquals(JsonNodeType.NULL, nextResult3.getNodeType());
    assertFalse(nextResult3.isTextual());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult3.isNull());
    assertTrue(iteratorResult2.hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Link)} with {@code Link}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Link)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Link)"})
  public void testVisitWithLink2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Link("Destination", " "));

    // Assert
    Iterator<JsonNode> iteratorResult = markdownRenderer.getJson().iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    assertTrue(nextResult2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult2 = nextResult2.iterator();
    JsonNode nextResult3 = iteratorResult2.next();
    assertTrue(nextResult3 instanceof TextNode);
    assertEquals("[ Destination ](Destination)", markdownRenderer.getText());
    assertEquals(JsonNodeType.STRING, nextResult3.getNodeType());
    assertFalse(nextResult3.isNull());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult3.isTextual());
    assertTrue(iteratorResult2.hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Link)} with {@code Link}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Link)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Link)"})
  public void testVisitWithLink3() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Link("", " "));

    // Assert
    Iterator<JsonNode> iteratorResult = markdownRenderer.getJson().iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    assertTrue(nextResult2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult2 = nextResult2.iterator();
    JsonNode nextResult3 = iteratorResult2.next();
    assertTrue(nextResult3 instanceof TextNode);
    assertEquals("[  ]()", markdownRenderer.getText());
    assertEquals(JsonNodeType.STRING, nextResult3.getNodeType());
    assertFalse(nextResult3.isNull());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult3.isTextual());
    assertTrue(iteratorResult2.hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Link)} with {@code Link}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is {@code [ Dr ](Destination)}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Link)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Link)"})
  public void testVisitWithLink_thenMarkdownRendererWithDocumentIsDocumentTextIsDrDestination() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Link("Destination", "Dr"));

    // Assert
    Iterator<JsonNode> iteratorResult = markdownRenderer.getJson().iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    assertTrue(nextResult2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult2 = nextResult2.iterator();
    JsonNode nextResult3 = iteratorResult2.next();
    assertTrue(nextResult3 instanceof TextNode);
    assertEquals("[ Dr ](Destination)", markdownRenderer.getText());
    assertEquals(JsonNodeType.STRING, nextResult3.getNodeType());
    assertFalse(nextResult3.isNull());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult3.isTextual());
    assertTrue(iteratorResult2.hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    OrderedList ol = new OrderedList();
    ol.appendChild(new TableNode());

    // Act
    markdownRenderer.visit(ol);

    // Assert
    assertEquals("\n   \n\n   \n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    CheckboxNode child = new CheckboxNode();
    child.appendChild(new EmojiNode());

    OrderedList ol = new OrderedList();
    ol.appendChild(child);

    // Act
    markdownRenderer.visit(ol);

    // Assert
    assertEquals("  \n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList3() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    Emphasis child2 = new Emphasis("Delimiter");
    child2.appendChild(child);

    OrderedList ol = new OrderedList();
    ol.appendChild(child2);

    // Act
    markdownRenderer.visit(ol);

    // Assert
    assertEquals("Delimiter:Shortcode:Delimiter\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList4() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    Emphasis child = new Emphasis("Delimiter");
    child.appendChild(new HardLineBreak());

    OrderedList ol = new OrderedList();
    ol.appendChild(child);

    // Act
    markdownRenderer.visit(ol);

    // Assert
    assertEquals("Delimiter\nDelimiter\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList5() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock child = new FencedCodeBlock();
    child.setFenceLength(3);
    child.appendChild(new EmojiNode());

    OrderedList ol = new OrderedList();
    ol.appendChild(child);

    // Act
    markdownRenderer.visit(ol);

    // Assert
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList6() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode node = new EmojiNode();
    node.setShortcode("---\n**Dialog**\n");

    DialogNode child = new DialogNode();
    child.appendChild(node);

    OrderedList ol = new OrderedList();
    ol.appendChild(child);

    // Act
    markdownRenderer.visit(ol);

    // Assert
    assertEquals("---\n**Dialog**\n:---\n**Dialog**\n:\n---\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenBlockQuoteAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    BlockQuote child2 = new BlockQuote();
    child2.appendChild(child);

    OrderedList ol = new OrderedList();
    ol.appendChild(child2);

    // Act
    markdownRenderer.visit(ol);

    // Assert
    assertEquals(":Shortcode:\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <ul>
   *   <li>Given {@link BulletList} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenBulletListAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    BulletList child2 = new BulletList();
    child2.appendChild(child);

    OrderedList ol = new OrderedList();
    ol.appendChild(child2);

    // Act
    markdownRenderer.visit(ol);

    // Assert
    assertEquals(":Shortcode:\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <ul>
   *   <li>Given {@link DialogNode} (default constructor) appendChild {@link TableCellNode} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenDialogNodeAppendChildTableCellNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    DialogNode child = new DialogNode();
    child.appendChild(new TableCellNode());

    OrderedList ol = new OrderedList();
    ol.appendChild(child);

    // Act
    markdownRenderer.visit(ol);

    // Assert
    assertEquals("---\n**Dialog**\n   \n---\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <ul>
   *   <li>Given {@link DialogNode} (default constructor) appendChild {@link TableRowNode} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenDialogNodeAppendChildTableRowNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    DialogNode child = new DialogNode();
    child.appendChild(new TableRowNode());

    OrderedList ol = new OrderedList();
    ol.appendChild(child);

    // Act
    markdownRenderer.visit(ol);

    // Assert
    assertEquals("---\n**Dialog**\n\n---\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <ul>
   *   <li>Given {@link Document} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenDocumentAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    Document child2 = new Document();
    child2.appendChild(child);

    OrderedList ol = new OrderedList();
    ol.appendChild(child2);

    // Act
    markdownRenderer.visit(ol);

    // Assert
    assertEquals(":Shortcode:\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <ul>
   *   <li>Given {@link FencedCodeBlock} (default constructor) appendChild {@link
   *       EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenFencedCodeBlockAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock child = new FencedCodeBlock();
    child.appendChild(new EmojiNode());

    OrderedList ol = new OrderedList();
    ol.appendChild(child);

    // Act
    markdownRenderer.visit(ol);

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenTableCellNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    OrderedList ol = new OrderedList();
    ol.appendChild(new TableCellNode());

    // Act
    markdownRenderer.visit(ol);

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <ul>
   *   <li>Given {@link TableRowNode} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenTableRowNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    OrderedList ol = new OrderedList();
    ol.appendChild(new TableRowNode());

    // Act
    markdownRenderer.visit(ol);

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is {@code (Button::(:)}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList_thenMarkdownRendererWithDocumentIsDocumentTextIsButton() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("(");

    ButtonNode child2 = new ButtonNode();
    child2.appendChild(child);

    OrderedList ol = new OrderedList();
    ol.appendChild(child2);

    // Act
    markdownRenderer.visit(ol);

    // Assert
    assertEquals("(Button::(:)\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is lf lf.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList_thenMarkdownRendererWithDocumentIsDocumentTextIsLfLf() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    OrderedList ol = new OrderedList();
    ol.appendChild(new PreformattedNode());

    // Act
    markdownRenderer.visit(ol);

    // Assert
    assertEquals("\n\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is space lf.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList_thenMarkdownRendererWithDocumentIsDocumentTextIsSpaceLf() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock child = new FencedCodeBlock();
    child.setInfo(" ");
    child.appendChild(new EmojiNode());

    OrderedList ol = new OrderedList();
    ol.appendChild(child);

    // Act
    markdownRenderer.visit(ol);

    // Assert
    assertEquals(" \n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <ul>
   *   <li>When {@link OrderedList} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList_whenOrderedList() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new OrderedList());

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   *
   * <ul>
   *   <li>When {@link OrderedList} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(OrderedList)"})
  public void testVisitWithOrderedList_whenOrderedListAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    OrderedList ol = new OrderedList();
    ol.appendChild(child);

    // Act
    markdownRenderer.visit(ol);

    // Assert
    assertEquals(":Shortcode:\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(new TableNode());

    // Act
    markdownRenderer.visit(paragraph);

    // Assert
    assertEquals("\n   \n\n   \n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    CheckboxNode child = new CheckboxNode();
    child.appendChild(new EmojiNode());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child);

    // Act
    markdownRenderer.visit(paragraph);

    // Assert
    assertEquals("  \n\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph3() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    Emphasis child2 = new Emphasis("Delimiter");
    child2.appendChild(child);

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child2);

    // Act
    markdownRenderer.visit(paragraph);

    // Assert
    assertEquals("Delimiter:Shortcode:Delimiter\n\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph4() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    Emphasis child = new Emphasis("Delimiter");
    child.appendChild(new HardLineBreak());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child);

    // Act
    markdownRenderer.visit(paragraph);

    // Assert
    assertEquals("Delimiter\nDelimiter\n\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph5() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock child = new FencedCodeBlock();
    child.setFenceLength(3);
    child.appendChild(new EmojiNode());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child);

    // Act
    markdownRenderer.visit(paragraph);

    // Assert
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph6() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode node = new EmojiNode();
    node.setShortcode("---\n**Dialog**\n");

    DialogNode child = new DialogNode();
    child.appendChild(node);

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child);

    // Act
    markdownRenderer.visit(paragraph);

    // Assert
    assertEquals("---\n**Dialog**\n:---\n**Dialog**\n:\n---\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph_givenBlockQuoteAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    BlockQuote child2 = new BlockQuote();
    child2.appendChild(child);

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child2);

    // Act
    markdownRenderer.visit(paragraph);

    // Assert
    assertEquals(":Shortcode:\n\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <ul>
   *   <li>Given {@link BulletList} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph_givenBulletListAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    BulletList child2 = new BulletList();
    child2.appendChild(child);

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child2);

    // Act
    markdownRenderer.visit(paragraph);

    // Assert
    assertEquals(":Shortcode:\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <ul>
   *   <li>Given {@link DialogNode} (default constructor) appendChild {@link TableCellNode} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph_givenDialogNodeAppendChildTableCellNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    DialogNode child = new DialogNode();
    child.appendChild(new TableCellNode());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child);

    // Act
    markdownRenderer.visit(paragraph);

    // Assert
    assertEquals("---\n**Dialog**\n   \n---\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <ul>
   *   <li>Given {@link DialogNode} (default constructor) appendChild {@link TableRowNode} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph_givenDialogNodeAppendChildTableRowNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    DialogNode child = new DialogNode();
    child.appendChild(new TableRowNode());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child);

    // Act
    markdownRenderer.visit(paragraph);

    // Assert
    assertEquals("---\n**Dialog**\n\n---\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <ul>
   *   <li>Given {@link Document} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph_givenDocumentAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    Document child2 = new Document();
    child2.appendChild(child);

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child2);

    // Act
    markdownRenderer.visit(paragraph);

    // Assert
    assertEquals(":Shortcode:\n\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <ul>
   *   <li>Given {@link FencedCodeBlock} (default constructor) appendChild {@link
   *       EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph_givenFencedCodeBlockAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock child = new FencedCodeBlock();
    child.appendChild(new EmojiNode());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child);

    // Act
    markdownRenderer.visit(paragraph);

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).
   *   <li>When {@link Paragraph} (default constructor) appendChild {@link TableCellNode} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph_givenTableCellNode_whenParagraphAppendChildTableCellNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(new TableCellNode());

    // Act
    markdownRenderer.visit(paragraph);

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <ul>
   *   <li>Given {@link TableRowNode} (default constructor).
   *   <li>When {@link Paragraph} (default constructor) appendChild {@link TableRowNode} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph_givenTableRowNode_whenParagraphAppendChildTableRowNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(new TableRowNode());

    // Act
    markdownRenderer.visit(paragraph);

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is {@code (Button::(:)}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph_thenMarkdownRendererWithDocumentIsDocumentTextIsButton() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("(");

    ButtonNode child2 = new ButtonNode();
    child2.appendChild(child);

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child2);

    // Act
    markdownRenderer.visit(paragraph);

    // Assert
    assertEquals("(Button::(:)\n\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is lf lf.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph_thenMarkdownRendererWithDocumentIsDocumentTextIsLfLf() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(new PreformattedNode());

    // Act
    markdownRenderer.visit(paragraph);

    // Assert
    assertEquals("\n\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is space lf.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph_thenMarkdownRendererWithDocumentIsDocumentTextIsSpaceLf() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock child = new FencedCodeBlock();
    child.setInfo(" ");
    child.appendChild(new EmojiNode());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child);

    // Act
    markdownRenderer.visit(paragraph);

    // Assert
    assertEquals(" \n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <ul>
   *   <li>When {@link Paragraph} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph_whenParagraph() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Paragraph());

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Paragraph)} with {@code Paragraph}.
   *
   * <ul>
   *   <li>When {@link Paragraph} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Paragraph)"})
  public void testVisitWithParagraph_whenParagraphAppendChildEmojiNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child);

    // Act
    markdownRenderer.visit(paragraph);

    // Assert
    assertEquals(":Shortcode:\n\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(StrongEmphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    StrongEmphasis b = new StrongEmphasis("Delimiter");
    b.appendChild(child);

    // Act
    markdownRenderer.visit(b);

    // Assert
    assertEquals("Delimiter:Shortcode:Delimiter", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(StrongEmphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    StrongEmphasis b = new StrongEmphasis("Delimiter");
    b.appendChild(new Emphasis("Delimiter"));

    // Act
    markdownRenderer.visit(b);

    // Assert
    assertEquals("DelimiterDelimiterDelimiterDelimiter", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(StrongEmphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis3() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    StrongEmphasis b = new StrongEmphasis("Delimiter");
    b.appendChild(new HardLineBreak());

    // Act
    markdownRenderer.visit(b);

    // Assert
    assertEquals("Delimiter\nDelimiter", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   *
   * <ul>
   *   <li>Given {@link Code#Code()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(StrongEmphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis_givenCode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    StrongEmphasis b = new StrongEmphasis("Delimiter");
    b.appendChild(new Code());

    // Act
    markdownRenderer.visit(b);

    // Assert
    assertEquals("DelimiterDelimiter", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   *
   * <ul>
   *   <li>When {@link StrongEmphasis#StrongEmphasis(String)} with {@code Delimiter}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(StrongEmphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis_whenStrongEmphasisWithDelimiter() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new StrongEmphasis("Delimiter"));

    // Assert
    assertEquals("DelimiterDelimiter", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Text)} with {@code Text}.
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Text)"})
  public void testVisitWithText() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text(" *  * "));

    // Assert
    assertEquals(" \\*  \\* ", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Text)} with {@code Text}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Text)"})
  public void testVisitWithText_thenMarkdownRendererWithDocumentIsDocumentTextIsAsterisk() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text(" * "));

    // Assert
    assertEquals(" * ", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Text)} with {@code Text}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Text)"})
  public void testVisitWithText_thenMarkdownRendererWithDocumentIsDocumentTextIsEmptyString() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text());

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Text)} with {@code Text}.
   *
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is {@link
   *       Document} (default constructor) Text is {@code Literal}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownRenderer.visit(Text)"})
  public void testVisitWithText_thenMarkdownRendererWithDocumentIsDocumentTextIsLiteral() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text("Literal"));

    // Assert
    assertEquals("Literal", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#addEscapeCharacter(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\_}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#addEscapeCharacter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MarkdownRenderer.addEscapeCharacter(String)"})
  public void testAddEscapeCharacter_thenReturnBackslashBackslashUnderscore() {
    // Arrange, Act and Assert
    assertEquals("\\\\_", MarkdownRenderer.addEscapeCharacter("\\_"));
  }

  /**
   * Test {@link MarkdownRenderer#addEscapeCharacter(String)}.
   *
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#addEscapeCharacter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MarkdownRenderer.addEscapeCharacter(String)"})
  public void testAddEscapeCharacter_thenReturnNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost",
        MarkdownRenderer.addEscapeCharacter("Not all who wander are lost"));
  }

  /**
   * Test {@link MarkdownRenderer#addEscapeCharacter(String)}.
   *
   * <ul>
   *   <li>When {@code *}.
   *   <li>Then return {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#addEscapeCharacter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MarkdownRenderer.addEscapeCharacter(String)"})
  public void testAddEscapeCharacter_whenAsterisk_thenReturnAsterisk() {
    // Arrange, Act and Assert
    assertEquals(" * ", MarkdownRenderer.addEscapeCharacter(" * "));
  }

  /**
   * Test {@link MarkdownRenderer#addEscapeCharacter(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#addEscapeCharacter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MarkdownRenderer.addEscapeCharacter(String)"})
  public void testAddEscapeCharacter_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", MarkdownRenderer.addEscapeCharacter(""));
  }

  /**
   * Test {@link MarkdownRenderer#addEscapeCharacter(String)}.
   *
   * <ul>
   *   <li>When {@code ^\s*([_*\-+`])\1*\s*$}.
   *   <li>Then return {@code ^\s\*([\_\*\\-\+\`])\1\*\s\*$}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownRenderer#addEscapeCharacter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MarkdownRenderer.addEscapeCharacter(String)"})
  public void testAddEscapeCharacter_whenS1S_thenReturnS1S() {
    // Arrange, Act and Assert
    assertEquals(
        "^\\s\\*([\\_\\*\\\\-\\+\\`])\\1\\*\\s\\*$",
        MarkdownRenderer.addEscapeCharacter("^\\s*([_*\\-+`])\\1*\\s*$"));
  }

  /**
   * Test {@link MarkdownRenderer#getText()}.
   *
   * <p>Method under test: {@link MarkdownRenderer#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MarkdownRenderer.getText()"})
  public void testGetText() {
    // Arrange, Act and Assert
    assertEquals("", new MarkdownRenderer(new Document()).getText());
  }

  /**
   * Test {@link MarkdownRenderer#getJson()}.
   *
   * <p>Method under test: {@link MarkdownRenderer#getJson()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode MarkdownRenderer.getJson()"})
  public void testGetJson() {
    // Arrange and Act
    ObjectNode actualJson = new MarkdownRenderer(new Document()).getJson();

    // Assert
    assertTrue(actualJson.traverse() instanceof TreeTraversingParser);
    assertEquals(0, actualJson.size());
    assertEquals(JsonNodeType.OBJECT, actualJson.getNodeType());
    assertFalse(actualJson.isArray());
    assertFalse(actualJson.isBigDecimal());
    assertFalse(actualJson.isBigInteger());
    assertFalse(actualJson.isBinary());
    assertFalse(actualJson.isBoolean());
    assertFalse(actualJson.isDouble());
    assertFalse(actualJson.isFloat());
    assertFalse(actualJson.isFloatingPointNumber());
    assertFalse(actualJson.isInt());
    assertFalse(actualJson.isIntegralNumber());
    assertFalse(actualJson.isLong());
    assertFalse(actualJson.isMissingNode());
    assertFalse(actualJson.isNull());
    assertFalse(actualJson.isNumber());
    assertFalse(actualJson.isPojo());
    assertFalse(actualJson.isShort());
    assertFalse(actualJson.isTextual());
    assertFalse(actualJson.isValueNode());
    assertFalse(actualJson.iterator().hasNext());
    assertTrue(actualJson.isContainerNode());
    assertTrue(actualJson.isEmpty());
    assertTrue(actualJson.isObject());
  }
}
