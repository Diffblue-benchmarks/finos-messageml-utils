package org.symphonyoss.symphony.messageml.markdown;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.Iterator;
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
import org.symphonyoss.symphony.messageml.markdown.MarkdownRenderer.TrackingWriter;
import org.symphonyoss.symphony.messageml.markdown.nodes.EmojiNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.KeywordNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.PreformattedNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableCellNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableRowNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.TagNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.ButtonNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.CheckboxNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.DatePickerNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.DialogNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.OptionNode;

public class MarkdownRendererDiffblueTest {
  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   * <ul>
   *   <li>Given {@link DialogNode} (default constructor) appendChild
   * {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer_givenDialogNodeAppendChildTableCellNode() {
    // Arrange
    DialogNode child = new DialogNode();
    child.appendChild(new TableCellNode());

    Document document = new Document();
    document.appendChild(child);

    // Act and Assert
    assertEquals("---\n**Dialog**\n   \n---\n", (new MarkdownRenderer(document)).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   * <ul>
   *   <li>Given {@link DialogNode} (default constructor) appendChild
   * {@link TableRowNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer_givenDialogNodeAppendChildTableRowNode() {
    // Arrange
    DialogNode child = new DialogNode();
    child.appendChild(new TableRowNode());

    Document document = new Document();
    document.appendChild(child);

    // Act and Assert
    assertEquals("---\n**Dialog**\n\n---\n", (new MarkdownRenderer(document)).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   * <ul>
   *   <li>Given {@link FencedCodeBlock} (default constructor) appendChild
   * {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer_givenFencedCodeBlockAppendChildEmojiNode() {
    // Arrange
    FencedCodeBlock child = new FencedCodeBlock();
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act and Assert
    assertEquals("", (new MarkdownRenderer(document)).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   * <ul>
   *   <li>Given {@link FencedCodeBlock} (default constructor) Info is space.</li>
   *   <li>Then return Text is space lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer_givenFencedCodeBlockInfoIsSpace_thenReturnTextIsSpaceLf() {
    // Arrange
    FencedCodeBlock child = new FencedCodeBlock();
    child.setInfo(" ");
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act and Assert
    assertEquals(" \n", (new MarkdownRenderer(document)).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).</li>
   *   <li>Then return Text is lf lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer_givenPreformattedNode_thenReturnTextIsLfLf() {
    // Arrange
    Document document = new Document();
    document.appendChild(new PreformattedNode());

    // Act and Assert
    assertEquals("\n\n", (new MarkdownRenderer(document)).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).</li>
   *   <li>When {@link Document} (default constructor) appendChild
   * {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer_givenTableCellNode_whenDocumentAppendChildTableCellNode() {
    // Arrange
    Document document = new Document();
    document.appendChild(new TableCellNode());

    // Act and Assert
    assertEquals("", (new MarkdownRenderer(document)).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   * <ul>
   *   <li>Given {@link TableRowNode} (default constructor).</li>
   *   <li>When {@link Document} (default constructor) appendChild
   * {@link TableRowNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer_givenTableRowNode_whenDocumentAppendChildTableRowNode() {
    // Arrange
    Document document = new Document();
    document.appendChild(new TableRowNode());

    // Act and Assert
    assertEquals("", (new MarkdownRenderer(document)).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   * <ul>
   *   <li>Then return Text is {@code (Button::(:)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer_thenReturnTextIsButton() {
    // Arrange
    EmojiNode child = new EmojiNode();
    child.setShortcode("(");

    ButtonNode child2 = new ButtonNode();
    child2.appendChild(child);

    Document document = new Document();
    document.appendChild(child2);

    // Act and Assert
    assertEquals("(Button::(:)", (new MarkdownRenderer(document)).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   * <ul>
   *   <li>Then return Text is {@code Delimiter Delimiter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer_thenReturnTextIsDelimiterDelimiter() {
    // Arrange
    Emphasis child = new Emphasis("Delimiter");
    child.appendChild(new HardLineBreak());

    Document document = new Document();
    document.appendChild(child);

    // Act and Assert
    assertEquals("Delimiter\nDelimiter", (new MarkdownRenderer(document)).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   * <ul>
   *   <li>Then return Text is {@code Delimiter:Shortcode:Delimiter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer_thenReturnTextIsDelimiterShortcodeDelimiter() {
    // Arrange
    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    Emphasis child2 = new Emphasis("Delimiter");
    child2.appendChild(child);

    Document document = new Document();
    document.appendChild(child2);

    // Act and Assert
    assertEquals("Delimiter:Shortcode:Delimiter", (new MarkdownRenderer(document)).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   * <ul>
   *   <li>Then return Text is {@code --- **Dialog** :--- **Dialog** : ---}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer_thenReturnTextIsDialogDialog() {
    // Arrange
    EmojiNode node = new EmojiNode();
    node.setShortcode("---\n**Dialog**\n");

    DialogNode child = new DialogNode();
    child.appendChild(node);

    Document document = new Document();
    document.appendChild(child);

    // Act and Assert
    assertEquals("---\n**Dialog**\n:---\n**Dialog**\n:\n---\n", (new MarkdownRenderer(document)).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   * <ul>
   *   <li>Then return Text is lf space space space lf lf space space space lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer_thenReturnTextIsLfSpaceSpaceSpaceLfLfSpaceSpaceSpaceLf() {
    // Arrange
    Document document = new Document();
    document.appendChild(new TableNode());

    // Act and Assert
    assertEquals("\n   \n\n   \n", (new MarkdownRenderer(document)).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   * <ul>
   *   <li>Then return Text is null null null null null null.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer_thenReturnTextIsNullNullNullNullNullNull() {
    // Arrange
    FencedCodeBlock child = new FencedCodeBlock();
    child.setFenceLength(3);
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act and Assert
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000", (new MarkdownRenderer(document)).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   * <ul>
   *   <li>Then return Text is {@code :Shortcode:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer_thenReturnTextIsShortcode() {
    // Arrange
    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    Document document = new Document();
    document.appendChild(child);

    // Act and Assert
    assertEquals(":Shortcode:", (new MarkdownRenderer(document)).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   * <ul>
   *   <li>Then return Text is {@code :Shortcode:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer_thenReturnTextIsShortcode2() {
    // Arrange
    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    BulletList child2 = new BulletList();
    child2.appendChild(child);

    Document document = new Document();
    document.appendChild(child2);

    // Act and Assert
    assertEquals(":Shortcode:\n", (new MarkdownRenderer(document)).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   * <ul>
   *   <li>Then return Text is space space.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer_thenReturnTextIsSpaceSpace() {
    // Arrange
    CheckboxNode child = new CheckboxNode();
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act and Assert
    assertEquals("  ", (new MarkdownRenderer(document)).getText());
  }

  /**
   * Test {@link MarkdownRenderer#MarkdownRenderer(Document)}.
   * <ul>
   *   <li>When {@link Document} (default constructor).</li>
   *   <li>Then return Text is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer_whenDocument_thenReturnTextIsEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new MarkdownRenderer(new Document())).getText());
  }

  /**
   * Test TrackingWriter {@link TrackingWriter#doubleLine()}.
   * <p>
   * Method under test: {@link MarkdownRenderer.TrackingWriter#doubleLine()}
   */
  @Test
  public void testTrackingWriterDoubleLine() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());
    MarkdownRenderer.TrackingWriter trackingWriter = markdownRenderer.new TrackingWriter(new StringBuilder("foo"));

    // Act
    trackingWriter.doubleLine();

    // Assert
    assertEquals("foo\n\n", trackingWriter.out.toString());
    assertEquals('\n', trackingWriter.getLastChar());
    assertEquals(5, trackingWriter.length());
  }

  /**
   * Test TrackingWriter {@link TrackingWriter#doubleLine()}.
   * <p>
   * Method under test: {@link MarkdownRenderer.TrackingWriter#doubleLine()}
   */
  @Test
  public void testTrackingWriterDoubleLine2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());
    MarkdownRenderer.TrackingWriter trackingWriter = markdownRenderer.new TrackingWriter(new StringBuilder("\n\n"));

    // Act
    trackingWriter.doubleLine();

    // Assert that nothing has changed
    assertEquals("\n\n", trackingWriter.out.toString());
    assertEquals('\n', trackingWriter.getLastChar());
    assertEquals(2, trackingWriter.length());
  }

  /**
   * Test TrackingWriter {@link TrackingWriter#doubleLine()}.
   * <p>
   * Method under test: {@link MarkdownRenderer.TrackingWriter#doubleLine()}
   */
  @Test
  public void testTrackingWriterDoubleLine3() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());
    MarkdownRenderer.TrackingWriter trackingWriter = markdownRenderer.new TrackingWriter(new StringBuilder(""));

    // Act
    trackingWriter.doubleLine();

    // Assert that nothing has changed
    assertEquals("", trackingWriter.out.toString());
    assertEquals('\u0000', trackingWriter.getLastChar());
    assertEquals(0, trackingWriter.length());
  }

  /**
   * Test TrackingWriter {@link TrackingWriter#getLastChar()}.
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with empty string.</li>
   *   <li>Then return null.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer.TrackingWriter#getLastChar()}
   */
  @Test
  public void testTrackingWriterGetLastChar_givenStringBuilderWithEmptyString_thenReturnNull() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act and Assert
    assertEquals('\u0000', (markdownRenderer.new TrackingWriter(new StringBuilder(""))).getLastChar());
  }

  /**
   * Test TrackingWriter {@link TrackingWriter#getLastChar()}.
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code foo}.</li>
   *   <li>Then return {@code o}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer.TrackingWriter#getLastChar()}
   */
  @Test
  public void testTrackingWriterGetLastChar_givenStringBuilderWithFoo_thenReturnO() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act and Assert
    assertEquals('o', (markdownRenderer.new TrackingWriter(new StringBuilder("foo"))).getLastChar());
  }

  /**
   * Test TrackingWriter getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MarkdownRenderer.TrackingWriter#TrackingWriter(MarkdownRenderer, StringBuilder)}
   *   <li>{@link MarkdownRenderer.TrackingWriter#toString()}
   * </ul>
   */
  @Test
  public void testTrackingWriterGettersAndSetters() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    MarkdownRenderer.TrackingWriter actualTrackingWriter = markdownRenderer.new TrackingWriter(
        new StringBuilder("foo"));
    String actualToStringResult = actualTrackingWriter.toString();

    // Assert
    assertEquals("foo", actualTrackingWriter.out.toString());
    assertEquals("foo", actualToStringResult);
  }

  /**
   * Test TrackingWriter {@link TrackingWriter#length()}.
   * <ul>
   *   <li>Given {@link StringBuilder#StringBuilder(String)} with {@code foo}.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer.TrackingWriter#length()}
   */
  @Test
  public void testTrackingWriterLength_givenStringBuilderWithFoo_thenReturnThree() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act and Assert
    assertEquals(3, (markdownRenderer.new TrackingWriter(new StringBuilder("foo"))).length());
  }

  /**
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisitWithBulletList() {
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
   * Test {@link MarkdownRenderer#visit(BulletList)} with {@code BulletList}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisitWithBulletList2() {
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisitWithBulletList3() {
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisitWithBulletList4() {
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisitWithBulletList5() {
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisitWithBulletList6() {
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisitWithBulletList7() {
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
   * <ul>
   *   <li>Given {@link FencedCodeBlock} (default constructor) appendChild
   * {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link TableRowNode} (default constructor).</li>
   *   <li>When {@link BulletList} (default constructor) appendChild
   * {@link TableRowNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
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
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is {@code (Button::(:)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
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
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is lf lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
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
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is space lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link BulletList} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link BulletList} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisitWithBulletList_whenBulletList2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new BulletList());

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisitWithCustomBlock4() {
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisitWithCustomBlock5() {
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisitWithCustomBlock6() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new CheckboxNode(" * "));

    // Assert
    assertEquals("  *  ", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisitWithCustomBlock7() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new CheckboxNode("\\_"));

    // Assert
    assertEquals(" \\\\_ ", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisitWithCustomBlock8() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new DatePickerNode(" * ", " * ", "Placeholder"));

    // Assert
    assertEquals("(Date Picker:[ \\* ][ \\* ][Placeholder])", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisitWithCustomBlock9() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new DatePickerNode(" * ", "_", "Placeholder"));

    // Assert
    assertEquals("(Date Picker:[ \\* ][\\_][Placeholder])", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisitWithCustomBlock10() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new DatePickerNode(" * ", "-", "Placeholder"));

    // Assert
    assertEquals("(Date Picker:[ \\* ][\\-][Placeholder])", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisitWithCustomBlock11() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new DatePickerNode(" * ", " * ", "_"));

    // Assert
    assertEquals("(Date Picker:[ \\* ][ \\* ][\\_])", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisitWithCustomBlock12() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new DatePickerNode(" * ", " * ", "-"));

    // Assert
    assertEquals("(Date Picker:[ \\* ][ \\* ][\\-])", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link TableRowNode} (default constructor).</li>
   *   <li>When {@link DialogNode} (default constructor) appendChild
   * {@link TableRowNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
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
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is {@code (Button:)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
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
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is {@code Label}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisitWithCustomBlock_thenMarkdownRendererWithDocumentIsDocumentTextIsLabel() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new CheckboxNode("Label"));

    // Assert
    assertEquals(" Label ", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is lf lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link CheckboxNode#CheckboxNode()} appendChild
   * {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link CheckboxNode#CheckboxNode(String)} with label is space.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisitWithCustomBlock_whenCheckboxNodeWithLabelIsSpace() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new CheckboxNode(" "));

    // Assert
    assertEquals("  ", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   * <ul>
   *   <li>When {@link DialogNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisitWithCustomBlock_whenDialogNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new DialogNode());

    // Assert
    assertEquals("---\n**Dialog**\n---\n", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomBlock)} with {@code CustomBlock}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link TableRowNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomNode)}
   */
  @Test
  public void testVisitWithCustomNode() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    EmojiNode node = new EmojiNode();
    node.setShortcode("Shortcode");

    // Act
    markdownRenderer.visit(node);

    // Assert
    assertEquals(":Shortcode:", markdownRenderer.getText());
    ObjectNode json = markdownRenderer.getJson();
    assertEquals("{ }", json.toPrettyString());
    assertFalse(json.iterator().hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomNode)} with {@code CustomNode}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomNode)}
   */
  @Test
  public void testVisitWithCustomNode2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit((CustomNode) null);

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
    ObjectNode json = markdownRenderer.getJson();
    assertEquals("{ }", json.toPrettyString());
    assertFalse(json.iterator().hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomNode)} with {@code CustomNode}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomNode)}
   */
  @Test
  public void testVisitWithCustomNode3() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new KeywordNode("indexStart", "Text"));

    // Assert
    ObjectNode json = markdownRenderer.getJson();
    Iterator<JsonNode> iteratorResult = json.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    assertTrue(nextResult2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult2 = nextResult2.iterator();
    assertTrue(iteratorResult2.next() instanceof TextNode);
    assertEquals("[ {\n" + "  \"id\" : \"indexStartText\",\n" + "  \"text\" : \"indexStartText\",\n"
        + "  \"indexStart\" : 0,\n" + "  \"indexEnd\" : 14,\n" + "  \"type\" : \"KEYWORD\"\n" + "} ]",
        nextResult.toPrettyString());
    assertEquals("indexStartText", markdownRenderer.getText());
    assertEquals("{\n" + "  \"hashtags\" : [ {\n" + "    \"id\" : \"indexStartText\",\n"
        + "    \"text\" : \"indexStartText\",\n" + "    \"indexStart\" : 0,\n" + "    \"indexEnd\" : 14,\n"
        + "    \"type\" : \"KEYWORD\"\n" + "  } ]\n" + "}", json.toPrettyString());
    assertEquals("{\n" + "  \"id\" : \"indexStartText\",\n" + "  \"text\" : \"indexStartText\",\n"
        + "  \"indexStart\" : 0,\n" + "  \"indexEnd\" : 14,\n" + "  \"type\" : \"KEYWORD\"\n" + "}",
        nextResult2.toPrettyString());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(iteratorResult2.hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomNode)} with {@code CustomNode}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomNode)}
   */
  @Test
  public void testVisitWithCustomNode4() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new TagNode("Prefix", "Text", MissingNode.getInstance()));

    // Assert
    ObjectNode json = markdownRenderer.getJson();
    Iterator<JsonNode> iteratorResult = json.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "[ {\n" + "  \"id\" : \"PrefixText\",\n" + "  \"text\" : \"PrefixText\",\n" + "  \"indexStart\" : 0,\n"
            + "  \"indexEnd\" : 10,\n" + "  \"type\" : \"KEYWORD\",\n" + "  \"data\" : null\n" + "} ]",
        nextResult.toPrettyString());
    assertEquals("{\n" + "  \"hashtags\" : [ {\n" + "    \"id\" : \"PrefixText\",\n"
        + "    \"text\" : \"PrefixText\",\n" + "    \"indexStart\" : 0,\n" + "    \"indexEnd\" : 10,\n"
        + "    \"type\" : \"KEYWORD\",\n" + "    \"data\" : null\n" + "  } ]\n" + "}", json.toPrettyString());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomNode)} with {@code CustomNode}.
   * <ul>
   *   <li>When {@link KeywordNode#KeywordNode(String, String)} with {@code Prefix}
   * and {@code Text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomNode)}
   */
  @Test
  public void testVisitWithCustomNode_whenKeywordNodeWithPrefixAndText() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new KeywordNode("Prefix", "Text"));

    // Assert
    ObjectNode json = markdownRenderer.getJson();
    Iterator<JsonNode> iteratorResult = json.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    assertTrue(nextResult2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult2 = nextResult2.iterator();
    JsonNode nextResult3 = iteratorResult2.next();
    assertTrue(nextResult3 instanceof TextNode);
    assertEquals("[ {\n" + "  \"id\" : \"PrefixText\",\n" + "  \"text\" : \"PrefixText\",\n" + "  \"indexStart\" : 0,\n"
        + "  \"indexEnd\" : 10,\n" + "  \"type\" : \"KEYWORD\"\n" + "} ]", nextResult.toPrettyString());
    assertEquals("\"PrefixText\"", nextResult3.toPrettyString());
    assertEquals("{\n" + "  \"hashtags\" : [ {\n" + "    \"id\" : \"PrefixText\",\n"
        + "    \"text\" : \"PrefixText\",\n" + "    \"indexStart\" : 0,\n" + "    \"indexEnd\" : 10,\n"
        + "    \"type\" : \"KEYWORD\"\n" + "  } ]\n" + "}", json.toPrettyString());
    assertEquals("{\n" + "  \"id\" : \"PrefixText\",\n" + "  \"text\" : \"PrefixText\",\n" + "  \"indexStart\" : 0,\n"
        + "  \"indexEnd\" : 10,\n" + "  \"type\" : \"KEYWORD\"\n" + "}", nextResult2.toPrettyString());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(iteratorResult2.hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(CustomNode)} with {@code CustomNode}.
   * <ul>
   *   <li>When {@link TagNode#TagNode(String, String, JsonNode)} with
   * {@code Prefix} and {@code Text} and data is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(CustomNode)}
   */
  @Test
  public void testVisitWithCustomNode_whenTagNodeWithPrefixAndTextAndDataIsNull() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new TagNode("Prefix", "Text", null));

    // Assert
    ObjectNode json = markdownRenderer.getJson();
    Iterator<JsonNode> iteratorResult = json.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    assertTrue(nextResult2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult2 = nextResult2.iterator();
    JsonNode nextResult3 = iteratorResult2.next();
    assertTrue(nextResult3 instanceof TextNode);
    assertEquals("[ {\n" + "  \"id\" : \"PrefixText\",\n" + "  \"text\" : \"PrefixText\",\n" + "  \"indexStart\" : 0,\n"
        + "  \"indexEnd\" : 10,\n" + "  \"type\" : \"KEYWORD\"\n" + "} ]", nextResult.toPrettyString());
    assertEquals("\"PrefixText\"", nextResult3.toPrettyString());
    assertEquals("{\n" + "  \"hashtags\" : [ {\n" + "    \"id\" : \"PrefixText\",\n"
        + "    \"text\" : \"PrefixText\",\n" + "    \"indexStart\" : 0,\n" + "    \"indexEnd\" : 10,\n"
        + "    \"type\" : \"KEYWORD\"\n" + "  } ]\n" + "}", json.toPrettyString());
    assertEquals("{\n" + "  \"id\" : \"PrefixText\",\n" + "  \"text\" : \"PrefixText\",\n" + "  \"indexStart\" : 0,\n"
        + "  \"indexEnd\" : 10,\n" + "  \"type\" : \"KEYWORD\"\n" + "}", nextResult2.toPrettyString());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(iteratorResult2.hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link FencedCodeBlock} (default constructor) appendChild
   * {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).</li>
   *   <li>When {@link Document} (default constructor) appendChild
   * {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link TableRowNode} (default constructor).</li>
   *   <li>When {@link Document} (default constructor) appendChild
   * {@link TableRowNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
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
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is {@code (Button::(:)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
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
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is lf lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
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
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is {@code :Shortcode:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  public void testVisitWithDocument_thenMarkdownRendererWithDocumentIsDocumentTextIsShortcode() {
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
   * Test {@link MarkdownRenderer#visit(Document)} with {@code Document}.
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is {@code :Shortcode:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  public void testVisitWithDocument_thenMarkdownRendererWithDocumentIsDocumentTextIsShortcode2() {
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
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is space lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
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
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is space space.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link Document} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  public void testVisitWithDocument_whenDocument() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Document());

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Emphasis)} with {@code Emphasis}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Emphasis)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Emphasis)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Emphasis)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link Code#Code(String)} with {@code Literal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Emphasis)}
   */
  @Test
  public void testVisitWithEmphasis_givenCodeWithLiteral() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    Emphasis em = new Emphasis("Delimiter");
    em.appendChild(new Code("Literal"));

    // Act
    markdownRenderer.visit(em);

    // Assert
    assertEquals("DelimiterDelimiter", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Emphasis)} with {@code Emphasis}.
   * <ul>
   *   <li>When {@link Emphasis#Emphasis(String)} with {@code Delimiter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Emphasis)}
   */
  @Test
  public void testVisitWithEmphasis_whenEmphasisWithDelimiter() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Emphasis("Delimiter"));

    // Assert
    assertEquals("DelimiterDelimiter", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(FencedCodeBlock)} with
   * {@code FencedCodeBlock}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(FencedCodeBlock)}
   */
  @Test
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
   * Test {@link MarkdownRenderer#visit(FencedCodeBlock)} with
   * {@code FencedCodeBlock}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(FencedCodeBlock)}
   */
  @Test
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
   * Test {@link MarkdownRenderer#visit(FencedCodeBlock)} with
   * {@code FencedCodeBlock}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(FencedCodeBlock)}
   */
  @Test
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
   * Test {@link MarkdownRenderer#visit(FencedCodeBlock)} with
   * {@code FencedCodeBlock}.
   * <ul>
   *   <li>When {@link FencedCodeBlock} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(FencedCodeBlock)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Link)}
   */
  @Test
  public void testVisitWithLink() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Link("", "Dr"));

    // Assert
    ObjectNode json = markdownRenderer.getJson();
    Iterator<JsonNode> iteratorResult = json.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    assertTrue(nextResult2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult2 = nextResult2.iterator();
    JsonNode nextResult3 = iteratorResult2.next();
    assertTrue(nextResult3 instanceof TextNode);
    assertEquals("[ Dr ]()", markdownRenderer.getText());
    assertEquals("[ {\n" + "  \"id\" : \"\",\n" + "  \"type\" : \"URL\",\n" + "  \"indexEnd\" : 8,\n"
        + "  \"indexStart\" : 0,\n" + "  \"text\" : \"Dr\",\n" + "  \"expandedUrl\" : \"\"\n" + "} ]",
        nextResult.toPrettyString());
    assertEquals("\"\"", nextResult3.toPrettyString());
    assertEquals("{\n" + "  \"id\" : \"\",\n" + "  \"type\" : \"URL\",\n" + "  \"indexEnd\" : 8,\n"
        + "  \"indexStart\" : 0,\n" + "  \"text\" : \"Dr\",\n" + "  \"expandedUrl\" : \"\"\n" + "}",
        nextResult2.toPrettyString());
    assertEquals("{\n" + "  \"urls\" : [ {\n" + "    \"id\" : \"\",\n" + "    \"type\" : \"URL\",\n"
        + "    \"indexEnd\" : 8,\n" + "    \"indexStart\" : 0,\n" + "    \"text\" : \"Dr\",\n"
        + "    \"expandedUrl\" : \"\"\n" + "  } ]\n" + "}", json.toPrettyString());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(iteratorResult2.hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Link)} with {@code Link}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Link)}
   */
  @Test
  public void testVisitWithLink2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Link("Destination", ""));

    // Assert
    ObjectNode json = markdownRenderer.getJson();
    Iterator<JsonNode> iteratorResult = json.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    assertTrue(nextResult2 instanceof ObjectNode);
    assertEquals("[ Destination ](Destination)", markdownRenderer.getText());
    assertEquals("[ {\n" + "  \"id\" : \"Destination\",\n" + "  \"type\" : \"URL\",\n" + "  \"indexEnd\" : 28,\n"
        + "  \"indexStart\" : 0,\n" + "  \"text\" : \"Destination\",\n" + "  \"expandedUrl\" : \"Destination\"\n"
        + "} ]", nextResult.toPrettyString());
    assertEquals("{\n" + "  \"id\" : \"Destination\",\n" + "  \"type\" : \"URL\",\n" + "  \"indexEnd\" : 28,\n"
        + "  \"indexStart\" : 0,\n" + "  \"text\" : \"Destination\",\n" + "  \"expandedUrl\" : \"Destination\"\n" + "}",
        nextResult2.toPrettyString());
    assertEquals("{\n" + "  \"urls\" : [ {\n" + "    \"id\" : \"Destination\",\n" + "    \"type\" : \"URL\",\n"
        + "    \"indexEnd\" : 28,\n" + "    \"indexStart\" : 0,\n" + "    \"text\" : \"Destination\",\n"
        + "    \"expandedUrl\" : \"Destination\"\n" + "  } ]\n" + "}", json.toPrettyString());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Link)} with {@code Link}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Link)}
   */
  @Test
  public void testVisitWithLink3() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Link());

    // Assert
    ObjectNode json = markdownRenderer.getJson();
    Iterator<JsonNode> iteratorResult = json.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    Iterator<JsonNode> iteratorResult2 = nextResult2.iterator();
    assertTrue(iteratorResult2.next() instanceof NullNode);
    assertTrue(nextResult2 instanceof ObjectNode);
    assertEquals("[ null ](null)", markdownRenderer.getText());
    assertEquals(
        "[ {\n" + "  \"id\" : null,\n" + "  \"type\" : \"URL\",\n" + "  \"indexEnd\" : 14,\n"
            + "  \"indexStart\" : 0,\n" + "  \"text\" : null,\n" + "  \"expandedUrl\" : null\n" + "} ]",
        nextResult.toPrettyString());
    assertEquals("{\n" + "  \"id\" : null,\n" + "  \"type\" : \"URL\",\n" + "  \"indexEnd\" : 14,\n"
        + "  \"indexStart\" : 0,\n" + "  \"text\" : null,\n" + "  \"expandedUrl\" : null\n" + "}",
        nextResult2.toPrettyString());
    assertEquals(
        "{\n" + "  \"urls\" : [ {\n" + "    \"id\" : null,\n" + "    \"type\" : \"URL\",\n" + "    \"indexEnd\" : 14,\n"
            + "    \"indexStart\" : 0,\n" + "    \"text\" : null,\n" + "    \"expandedUrl\" : null\n" + "  } ]\n" + "}",
        json.toPrettyString());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(iteratorResult2.hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Link)} with {@code Link}.
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is
   * {@code [ Dr ](Destination)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Link)}
   */
  @Test
  public void testVisitWithLink_thenMarkdownRendererWithDocumentIsDocumentTextIsDrDestination() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Link("Destination", "Dr"));

    // Assert
    ObjectNode json = markdownRenderer.getJson();
    Iterator<JsonNode> iteratorResult = json.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = nextResult.elements();
    JsonNode nextResult2 = elementsResult.next();
    assertTrue(nextResult2 instanceof ObjectNode);
    assertEquals("[ Dr ](Destination)", markdownRenderer.getText());
    assertEquals(
        "[ {\n" + "  \"id\" : \"Destination\",\n" + "  \"type\" : \"URL\",\n" + "  \"indexEnd\" : 19,\n"
            + "  \"indexStart\" : 0,\n" + "  \"text\" : \"Dr\",\n" + "  \"expandedUrl\" : \"Destination\"\n" + "} ]",
        nextResult.toPrettyString());
    assertEquals(
        "{\n" + "  \"id\" : \"Destination\",\n" + "  \"type\" : \"URL\",\n" + "  \"indexEnd\" : 19,\n"
            + "  \"indexStart\" : 0,\n" + "  \"text\" : \"Dr\",\n" + "  \"expandedUrl\" : \"Destination\"\n" + "}",
        nextResult2.toPrettyString());
    assertEquals("{\n" + "  \"urls\" : [ {\n" + "    \"id\" : \"Destination\",\n" + "    \"type\" : \"URL\",\n"
        + "    \"indexEnd\" : 19,\n" + "    \"indexStart\" : 0,\n" + "    \"text\" : \"Dr\",\n"
        + "    \"expandedUrl\" : \"Destination\"\n" + "  } ]\n" + "}", json.toPrettyString());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link BulletList} (default constructor) appendChild
   * {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link Document} (default constructor) appendChild
   * {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link FencedCodeBlock} (default constructor) appendChild
   * {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link TableRowNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
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
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is {@code (Button::(:)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
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
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is lf lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
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
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is space lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link OrderedList} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link OrderedList} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  public void testVisitWithOrderedList_whenOrderedList2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new OrderedList());

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(OrderedList)} with {@code OrderedList}.
   * <ul>
   *   <li>When {@link OrderedList} (default constructor) appendChild
   * {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link BulletList} (default constructor) appendChild
   * {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link Document} (default constructor) appendChild
   * {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link FencedCodeBlock} (default constructor) appendChild
   * {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).</li>
   *   <li>When {@link Paragraph} (default constructor) appendChild
   * {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link TableRowNode} (default constructor).</li>
   *   <li>When {@link Paragraph} (default constructor) appendChild
   * {@link TableRowNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
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
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is {@code (Button::(:)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
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
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is lf lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
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
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is space lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link Paragraph} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link Paragraph} (default constructor) appendChild
   * {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
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
   * Test {@link MarkdownRenderer#visit(StrongEmphasis)} with
   * {@code StrongEmphasis}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(StrongEmphasis)}
   */
  @Test
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
   * Test {@link MarkdownRenderer#visit(StrongEmphasis)} with
   * {@code StrongEmphasis}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(StrongEmphasis)}
   */
  @Test
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
   * Test {@link MarkdownRenderer#visit(StrongEmphasis)} with
   * {@code StrongEmphasis}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(StrongEmphasis)}
   */
  @Test
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
   * Test {@link MarkdownRenderer#visit(StrongEmphasis)} with
   * {@code StrongEmphasis}.
   * <ul>
   *   <li>Given {@link Code#Code(String)} with {@code Literal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(StrongEmphasis)}
   */
  @Test
  public void testVisitWithStrongEmphasis_givenCodeWithLiteral() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    StrongEmphasis b = new StrongEmphasis("Delimiter");
    b.appendChild(new Code("Literal"));

    // Act
    markdownRenderer.visit(b);

    // Assert
    assertEquals("DelimiterDelimiter", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(StrongEmphasis)} with
   * {@code StrongEmphasis}.
   * <ul>
   *   <li>When {@link StrongEmphasis#StrongEmphasis(String)} with
   * {@code Delimiter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(StrongEmphasis)}
   */
  @Test
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
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  public void testVisitWithText() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text("\\_"));

    // Assert
    assertEquals("\\\\_", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Text)} with {@code Text}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  public void testVisitWithText2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text(" *  * "));

    // Assert
    assertEquals(" \\*  \\* ", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Text)} with {@code Text}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  public void testVisitWithText3() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text(" * _"));

    // Assert
    assertEquals(" \\* \\_", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Text)} with {@code Text}.
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  public void testVisitWithText4() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text(" * -"));

    // Assert
    assertEquals(" \\* \\-", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Text)} with {@code Text}.
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is {@code *}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
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
   * <ul>
   *   <li>Then {@link MarkdownRenderer#MarkdownRenderer(Document)} with document is
   * {@link Document} (default constructor) Text is {@code Literal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  public void testVisitWithText_thenMarkdownRendererWithDocumentIsDocumentTextIsLiteral() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text("Literal"));

    // Assert
    assertEquals("Literal", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Text)} with {@code Text}.
   * <ul>
   *   <li>When {@link Text#Text()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  public void testVisitWithText_whenText() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text());

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#visit(Text)} with {@code Text}.
   * <ul>
   *   <li>When {@link Text#Text(String)} with literal is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  public void testVisitWithText_whenTextWithLiteralIsEmptyString() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text(""));

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Test {@link MarkdownRenderer#addEscapeCharacter(String)}.
   * <ul>
   *   <li>Then return {@code \\_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#addEscapeCharacter(String)}
   */
  @Test
  public void testAddEscapeCharacter_thenReturnBackslashBackslashUnderscore() {
    // Arrange, Act and Assert
    assertEquals("\\\\_", MarkdownRenderer.addEscapeCharacter("\\_"));
  }

  /**
   * Test {@link MarkdownRenderer#addEscapeCharacter(String)}.
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#addEscapeCharacter(String)}
   */
  @Test
  public void testAddEscapeCharacter_thenReturnNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertEquals("Not all who wander are lost", MarkdownRenderer.addEscapeCharacter("Not all who wander are lost"));
  }

  /**
   * Test {@link MarkdownRenderer#addEscapeCharacter(String)}.
   * <ul>
   *   <li>When {@code *}.</li>
   *   <li>Then return {@code *}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#addEscapeCharacter(String)}
   */
  @Test
  public void testAddEscapeCharacter_whenAsterisk_thenReturnAsterisk() {
    // Arrange, Act and Assert
    assertEquals(" * ", MarkdownRenderer.addEscapeCharacter(" * "));
  }

  /**
   * Test {@link MarkdownRenderer#addEscapeCharacter(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#addEscapeCharacter(String)}
   */
  @Test
  public void testAddEscapeCharacter_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", MarkdownRenderer.addEscapeCharacter(""));
  }

  /**
   * Test {@link MarkdownRenderer#addEscapeCharacter(String)}.
   * <ul>
   *   <li>When {@code ^\s*([_*\-+`])\1*\s*$}.</li>
   *   <li>Then return {@code ^\s\*([\_\*\\-\+\`])\1\*\s\*$}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownRenderer#addEscapeCharacter(String)}
   */
  @Test
  public void testAddEscapeCharacter_whenS1S_thenReturnS1S() {
    // Arrange, Act and Assert
    assertEquals("^\\s\\*([\\_\\*\\\\-\\+\\`])\\1\\*\\s\\*$",
        MarkdownRenderer.addEscapeCharacter("^\\s*([_*\\-+`])\\1*\\s*$"));
  }

  /**
   * Test {@link MarkdownRenderer#getText()}.
   * <p>
   * Method under test: {@link MarkdownRenderer#getText()}
   */
  @Test
  public void testGetText() {
    // Arrange, Act and Assert
    assertEquals("", (new MarkdownRenderer(new Document())).getText());
  }

  /**
   * Test {@link MarkdownRenderer#getJson()}.
   * <p>
   * Method under test: {@link MarkdownRenderer#getJson()}
   */
  @Test
  public void testGetJson() {
    // Arrange and Act
    ObjectNode actualJson = (new MarkdownRenderer(new Document())).getJson();

    // Assert
    assertTrue(actualJson.traverse() instanceof TreeTraversingParser);
    assertEquals("{ }", actualJson.toPrettyString());
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
