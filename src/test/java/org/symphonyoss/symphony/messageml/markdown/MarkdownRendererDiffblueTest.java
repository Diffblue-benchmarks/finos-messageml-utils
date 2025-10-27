package org.symphonyoss.symphony.messageml.markdown;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.CustomBlock;
import org.commonmark.node.CustomNode;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.markdown.nodes.EmojiNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.PreformattedNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableCellNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableRowNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.ButtonNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.CheckboxNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.DatePickerNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.DialogNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.OptionNode;

public class MarkdownRendererDiffblueTest {
  /**
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
   * Method under test: {@link MarkdownRenderer.TrackingWriter#getLastChar()}
   */
  @Test
  public void testTrackingWriterGetLastChar() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act and Assert
    assertEquals('o', (markdownRenderer.new TrackingWriter(new StringBuilder("foo"))).getLastChar());
  }

  /**
   * Method under test: {@link MarkdownRenderer.TrackingWriter#getLastChar()}
   */
  @Test
  public void testTrackingWriterGetLastChar2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act and Assert
    assertEquals('\u0000', (markdownRenderer.new TrackingWriter(new StringBuilder(""))).getLastChar());
  }

  /**
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
   * Method under test: {@link MarkdownRenderer.TrackingWriter#length()}
   */
  @Test
  public void testTrackingWriterLength() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act and Assert
    assertEquals(3, (markdownRenderer.new TrackingWriter(new StringBuilder("foo"))).length());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisit() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new BulletList());

    // Assert
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisit2() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new BulletList());

    // Assert
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisit3() {
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
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisit4() {
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
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisit5() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    BulletList ul = new BulletList();
    ul.appendChild(new TableCellNode());

    // Act
    markdownRenderer.visit(ul);

    // Assert
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisit6() {
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
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisit7() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    BulletList ul = new BulletList();
    ul.appendChild(new TableRowNode());

    // Act
    markdownRenderer.visit(ul);

    // Assert
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisit8() {
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
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisit9() {
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
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisit10() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock child = new FencedCodeBlock();
    child.appendChild(new EmojiNode());

    BulletList ul = new BulletList();
    ul.appendChild(child);

    // Act
    markdownRenderer.visit(ul);

    // Assert
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisit11() {
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
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisit12() {
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
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisit13() {
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
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisit14() {
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
   * Method under test: {@link MarkdownRenderer#visit(BulletList)}
   */
  @Test
  public void testVisit15() {
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
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit16() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new PreformattedNode());

    // Assert
    assertEquals("\n\n", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit17() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new TableNode());

    // Assert
    assertEquals("\n   \n\n   \n", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit18() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new TableRowNode());

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit19() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new TableCellNode());

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit20() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit((CustomBlock) null);

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit21() {
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
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit22() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new ButtonNode());

    // Assert
    assertEquals("(Button:)", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit23() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new DialogNode());

    // Assert
    assertEquals("---\n**Dialog**\n---\n", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit24() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new CheckboxNode("Label"));

    // Assert
    assertEquals(" Label ", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit25() {
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
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit26() {
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
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit27() {
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
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit28() {
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
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit29() {
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
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit30() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new CheckboxNode(" * "));

    // Assert
    assertEquals("  *  ", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit31() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new CheckboxNode(" "));

    // Assert
    assertEquals("  ", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit32() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new CheckboxNode("\\_"));

    // Assert
    assertEquals(" \\\\_ ", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit33() {
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
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit34() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new DatePickerNode(" * ", " * ", "Placeholder"));

    // Assert
    assertEquals("(Date Picker:[ \\* ][ \\* ][Placeholder])", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit35() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new DatePickerNode(" * ", "_", "Placeholder"));

    // Assert
    assertEquals("(Date Picker:[ \\* ][\\_][Placeholder])", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit36() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new DatePickerNode(" * ", "-", "Placeholder"));

    // Assert
    assertEquals("(Date Picker:[ \\* ][\\-][Placeholder])", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit37() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new DatePickerNode(" * ", " * ", "_"));

    // Assert
    assertEquals("(Date Picker:[ \\* ][ \\* ][\\_])", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(CustomBlock)}
   */
  @Test
  public void testVisit38() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new DatePickerNode(" * ", " * ", "-"));

    // Assert
    assertEquals("(Date Picker:[ \\* ][ \\* ][\\-])", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(CustomNode)}
   */
  @Test
  public void testVisit39() {
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
    assertEquals(0, json.size());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isEmpty());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(CustomNode)}
   */
  @Test
  public void testVisit40() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit((CustomNode) null);

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
    ObjectNode json = markdownRenderer.getJson();
    assertEquals("{ }", json.toPrettyString());
    assertEquals(0, json.size());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isEmpty());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  public void testVisit41() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Document());

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  public void testVisit42() {
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
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  public void testVisit43() {
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
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  public void testVisit44() {
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
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  public void testVisit45() {
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
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  public void testVisit46() {
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
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  public void testVisit47() {
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
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  public void testVisit48() {
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
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  public void testVisit49() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock child = new FencedCodeBlock();
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownRenderer.visit(document);

    // Assert
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  public void testVisit50() {
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
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  public void testVisit51() {
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
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  public void testVisit52() {
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
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  public void testVisit53() {
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
   * Method under test: {@link MarkdownRenderer#visit(Document)}
   */
  @Test
  public void testVisit54() {
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
   * Method under test: {@link MarkdownRenderer#visit(Emphasis)}
   */
  @Test
  public void testVisit55() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Emphasis("Delimiter"));

    // Assert
    assertEquals("DelimiterDelimiter", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(Emphasis)}
   */
  @Test
  public void testVisit56() {
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
   * Method under test: {@link MarkdownRenderer#visit(Emphasis)}
   */
  @Test
  public void testVisit57() {
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
   * Method under test: {@link MarkdownRenderer#visit(Emphasis)}
   */
  @Test
  public void testVisit58() {
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
   * Method under test: {@link MarkdownRenderer#visit(Emphasis)}
   */
  @Test
  public void testVisit59() {
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
   * Method under test: {@link MarkdownRenderer#visit(FencedCodeBlock)}
   */
  @Test
  public void testVisit60() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new FencedCodeBlock());

    // Assert
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(FencedCodeBlock)}
   */
  @Test
  public void testVisit61() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock code = new FencedCodeBlock();
    code.appendChild(new EmojiNode());

    // Act
    markdownRenderer.visit(code);

    // Assert
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(FencedCodeBlock)}
   */
  @Test
  public void testVisit62() {
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
   * Method under test: {@link MarkdownRenderer#visit(FencedCodeBlock)}
   */
  @Test
  public void testVisit63() {
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
   * Method under test: {@link MarkdownRenderer#visit(HardLineBreak)}
   */
  @Test
  public void testVisit64() {
    // Arrange
    Document document = mock(Document.class);
    when(document.getFirstChild()).thenReturn(new BlockQuote());
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(document);

    // Act
    markdownRenderer.visit(new HardLineBreak());

    // Assert that nothing has changed
    verify(document).getFirstChild();
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(ListItem)}
   */
  @Test
  public void testVisit65() {
    // Arrange
    Document document = mock(Document.class);
    when(document.getFirstChild()).thenReturn(new BlockQuote());
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(document);

    // Act
    markdownRenderer.visit(new ListItem());

    // Assert that nothing has changed
    verify(document).getFirstChild();
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  public void testVisit66() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new OrderedList());

    // Assert
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  public void testVisit67() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new OrderedList());

    // Assert
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  public void testVisit68() {
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
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  public void testVisit69() {
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
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  public void testVisit70() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    OrderedList ol = new OrderedList();
    ol.appendChild(new TableCellNode());

    // Act
    markdownRenderer.visit(ol);

    // Assert
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  public void testVisit71() {
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
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  public void testVisit72() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    OrderedList ol = new OrderedList();
    ol.appendChild(new TableRowNode());

    // Act
    markdownRenderer.visit(ol);

    // Assert
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  public void testVisit73() {
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
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  public void testVisit74() {
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
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  public void testVisit75() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock child = new FencedCodeBlock();
    child.appendChild(new EmojiNode());

    OrderedList ol = new OrderedList();
    ol.appendChild(child);

    // Act
    markdownRenderer.visit(ol);

    // Assert
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  public void testVisit76() {
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
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  public void testVisit77() {
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
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  public void testVisit78() {
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
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  public void testVisit79() {
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
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  public void testVisit80() {
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
   * Method under test: {@link MarkdownRenderer#visit(OrderedList)}
   */
  @Test
  public void testVisit81() {
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
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  public void testVisit82() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Paragraph());

    // Assert that nothing has changed
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  public void testVisit83() {
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
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  public void testVisit84() {
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
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  public void testVisit85() {
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
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  public void testVisit86() {
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
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  public void testVisit87() {
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
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  public void testVisit88() {
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
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  public void testVisit89() {
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
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  public void testVisit90() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    FencedCodeBlock child = new FencedCodeBlock();
    child.appendChild(new EmojiNode());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child);

    // Act
    markdownRenderer.visit(paragraph);

    // Assert
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  public void testVisit91() {
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
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  public void testVisit92() {
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
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  public void testVisit93() {
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
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  public void testVisit94() {
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
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  public void testVisit95() {
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
   * Method under test: {@link MarkdownRenderer#visit(Paragraph)}
   */
  @Test
  public void testVisit96() {
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
   * Method under test: {@link MarkdownRenderer#visit(StrongEmphasis)}
   */
  @Test
  public void testVisit97() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new StrongEmphasis("Delimiter"));

    // Assert
    assertEquals("DelimiterDelimiter", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(StrongEmphasis)}
   */
  @Test
  public void testVisit98() {
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
   * Method under test: {@link MarkdownRenderer#visit(StrongEmphasis)}
   */
  @Test
  public void testVisit99() {
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
   * Method under test: {@link MarkdownRenderer#visit(StrongEmphasis)}
   */
  @Test
  public void testVisit100() {
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
   * Method under test: {@link MarkdownRenderer#visit(StrongEmphasis)}
   */
  @Test
  public void testVisit101() {
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
   * Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  public void testVisit102() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text("Literal"));

    // Assert
    assertEquals("Literal", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  public void testVisit103() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text(" * "));

    // Assert
    assertEquals(" * ", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  public void testVisit104() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text("\\_"));

    // Assert
    assertEquals("\\\\_", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  public void testVisit105() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text(""));

    // Assert
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  public void testVisit106() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text());

    // Assert
    assertEquals("", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  public void testVisit107() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text(" *  * "));

    // Assert
    assertEquals(" \\*  \\* ", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  public void testVisit108() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text(" * _"));

    // Assert
    assertEquals(" \\* \\_", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#visit(Text)}
   */
  @Test
  public void testVisit109() {
    // Arrange
    MarkdownRenderer markdownRenderer = new MarkdownRenderer(new Document());

    // Act
    markdownRenderer.visit(new Text(" * -"));

    // Assert
    assertEquals(" \\* \\-", markdownRenderer.getText());
  }

  /**
   * Method under test: {@link MarkdownRenderer#addEscapeCharacter(String)}
   */
  @Test
  public void testAddEscapeCharacter() {
    // Arrange, Act and Assert
    assertEquals("Not all who wander are lost", MarkdownRenderer.addEscapeCharacter("Not all who wander are lost"));
    assertEquals(" * ", MarkdownRenderer.addEscapeCharacter(" * "));
    assertEquals("\\\\_", MarkdownRenderer.addEscapeCharacter("\\_"));
    assertEquals("^\\s\\*([\\_\\*\\\\-\\+\\`])\\1\\*\\s\\*$",
        MarkdownRenderer.addEscapeCharacter("^\\s*([_*\\-+`])\\1*\\s*$"));
    assertEquals("", MarkdownRenderer.addEscapeCharacter(""));
  }

  /**
   * Method under test: {@link MarkdownRenderer#getText()}
   */
  @Test
  public void testGetText() {
    // Arrange, Act and Assert
    assertEquals("", (new MarkdownRenderer(new Document())).getText());
  }

  /**
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

  /**
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer() throws IOException {
    // Arrange and Act
    MarkdownRenderer actualMarkdownRenderer = new MarkdownRenderer(new Document());

    // Assert
    ObjectNode json = actualMarkdownRenderer.getJson();
    JsonParser traverseResult = json.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("", actualMarkdownRenderer.getText());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", json.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, json.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, json.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(json.isArray());
    assertFalse(json.isBigDecimal());
    assertFalse(json.isBigInteger());
    assertFalse(json.isBinary());
    assertFalse(json.isBoolean());
    assertFalse(json.isDouble());
    assertFalse(json.isFloat());
    assertFalse(json.isFloatingPointNumber());
    assertFalse(json.isInt());
    assertFalse(json.isIntegralNumber());
    assertFalse(json.isLong());
    assertFalse(json.isMissingNode());
    assertFalse(json.isNull());
    assertFalse(json.isNumber());
    assertFalse(json.isPojo());
    assertFalse(json.isShort());
    assertFalse(json.isTextual());
    assertFalse(json.isValueNode());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isContainerNode());
    assertTrue(json.isEmpty());
    assertTrue(json.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer2() throws IOException {
    // Arrange
    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    Document document = new Document();
    document.appendChild(child);

    // Act
    MarkdownRenderer actualMarkdownRenderer = new MarkdownRenderer(document);

    // Assert
    ObjectNode json = actualMarkdownRenderer.getJson();
    JsonParser traverseResult = json.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals(":Shortcode:", actualMarkdownRenderer.getText());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", json.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, json.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, json.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(json.isArray());
    assertFalse(json.isBigDecimal());
    assertFalse(json.isBigInteger());
    assertFalse(json.isBinary());
    assertFalse(json.isBoolean());
    assertFalse(json.isDouble());
    assertFalse(json.isFloat());
    assertFalse(json.isFloatingPointNumber());
    assertFalse(json.isInt());
    assertFalse(json.isIntegralNumber());
    assertFalse(json.isLong());
    assertFalse(json.isMissingNode());
    assertFalse(json.isNull());
    assertFalse(json.isNumber());
    assertFalse(json.isPojo());
    assertFalse(json.isShort());
    assertFalse(json.isTextual());
    assertFalse(json.isValueNode());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isContainerNode());
    assertTrue(json.isEmpty());
    assertTrue(json.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer3() throws IOException {
    // Arrange
    Document document = new Document();
    document.appendChild(new PreformattedNode());

    // Act
    MarkdownRenderer actualMarkdownRenderer = new MarkdownRenderer(document);

    // Assert
    ObjectNode json = actualMarkdownRenderer.getJson();
    JsonParser traverseResult = json.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\n\n", actualMarkdownRenderer.getText());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", json.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, json.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, json.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(json.isArray());
    assertFalse(json.isBigDecimal());
    assertFalse(json.isBigInteger());
    assertFalse(json.isBinary());
    assertFalse(json.isBoolean());
    assertFalse(json.isDouble());
    assertFalse(json.isFloat());
    assertFalse(json.isFloatingPointNumber());
    assertFalse(json.isInt());
    assertFalse(json.isIntegralNumber());
    assertFalse(json.isLong());
    assertFalse(json.isMissingNode());
    assertFalse(json.isNull());
    assertFalse(json.isNumber());
    assertFalse(json.isPojo());
    assertFalse(json.isShort());
    assertFalse(json.isTextual());
    assertFalse(json.isValueNode());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isContainerNode());
    assertTrue(json.isEmpty());
    assertTrue(json.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer4() throws IOException {
    // Arrange
    Document document = new Document();
    document.appendChild(new TableCellNode());

    // Act
    MarkdownRenderer actualMarkdownRenderer = new MarkdownRenderer(document);

    // Assert
    ObjectNode json = actualMarkdownRenderer.getJson();
    JsonParser traverseResult = json.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("", actualMarkdownRenderer.getText());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", json.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, json.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, json.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(json.isArray());
    assertFalse(json.isBigDecimal());
    assertFalse(json.isBigInteger());
    assertFalse(json.isBinary());
    assertFalse(json.isBoolean());
    assertFalse(json.isDouble());
    assertFalse(json.isFloat());
    assertFalse(json.isFloatingPointNumber());
    assertFalse(json.isInt());
    assertFalse(json.isIntegralNumber());
    assertFalse(json.isLong());
    assertFalse(json.isMissingNode());
    assertFalse(json.isNull());
    assertFalse(json.isNumber());
    assertFalse(json.isPojo());
    assertFalse(json.isShort());
    assertFalse(json.isTextual());
    assertFalse(json.isValueNode());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isContainerNode());
    assertTrue(json.isEmpty());
    assertTrue(json.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer5() throws IOException {
    // Arrange
    Document document = new Document();
    document.appendChild(new TableNode());

    // Act
    MarkdownRenderer actualMarkdownRenderer = new MarkdownRenderer(document);

    // Assert
    ObjectNode json = actualMarkdownRenderer.getJson();
    JsonParser traverseResult = json.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\n   \n\n   \n", actualMarkdownRenderer.getText());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", json.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, json.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, json.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(json.isArray());
    assertFalse(json.isBigDecimal());
    assertFalse(json.isBigInteger());
    assertFalse(json.isBinary());
    assertFalse(json.isBoolean());
    assertFalse(json.isDouble());
    assertFalse(json.isFloat());
    assertFalse(json.isFloatingPointNumber());
    assertFalse(json.isInt());
    assertFalse(json.isIntegralNumber());
    assertFalse(json.isLong());
    assertFalse(json.isMissingNode());
    assertFalse(json.isNull());
    assertFalse(json.isNumber());
    assertFalse(json.isPojo());
    assertFalse(json.isShort());
    assertFalse(json.isTextual());
    assertFalse(json.isValueNode());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isContainerNode());
    assertTrue(json.isEmpty());
    assertTrue(json.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer6() throws IOException {
    // Arrange
    Document document = new Document();
    document.appendChild(new TableRowNode());

    // Act
    MarkdownRenderer actualMarkdownRenderer = new MarkdownRenderer(document);

    // Assert
    ObjectNode json = actualMarkdownRenderer.getJson();
    JsonParser traverseResult = json.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("", actualMarkdownRenderer.getText());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", json.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, json.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, json.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(json.isArray());
    assertFalse(json.isBigDecimal());
    assertFalse(json.isBigInteger());
    assertFalse(json.isBinary());
    assertFalse(json.isBoolean());
    assertFalse(json.isDouble());
    assertFalse(json.isFloat());
    assertFalse(json.isFloatingPointNumber());
    assertFalse(json.isInt());
    assertFalse(json.isIntegralNumber());
    assertFalse(json.isLong());
    assertFalse(json.isMissingNode());
    assertFalse(json.isNull());
    assertFalse(json.isNumber());
    assertFalse(json.isPojo());
    assertFalse(json.isShort());
    assertFalse(json.isTextual());
    assertFalse(json.isValueNode());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isContainerNode());
    assertTrue(json.isEmpty());
    assertTrue(json.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer7() throws IOException {
    // Arrange
    EmojiNode child = new EmojiNode();
    child.setShortcode("(");

    ButtonNode child2 = new ButtonNode();
    child2.appendChild(child);

    Document document = new Document();
    document.appendChild(child2);

    // Act
    MarkdownRenderer actualMarkdownRenderer = new MarkdownRenderer(document);

    // Assert
    ObjectNode json = actualMarkdownRenderer.getJson();
    JsonParser traverseResult = json.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("(Button::(:)", actualMarkdownRenderer.getText());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", json.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, json.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, json.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(json.isArray());
    assertFalse(json.isBigDecimal());
    assertFalse(json.isBigInteger());
    assertFalse(json.isBinary());
    assertFalse(json.isBoolean());
    assertFalse(json.isDouble());
    assertFalse(json.isFloat());
    assertFalse(json.isFloatingPointNumber());
    assertFalse(json.isInt());
    assertFalse(json.isIntegralNumber());
    assertFalse(json.isLong());
    assertFalse(json.isMissingNode());
    assertFalse(json.isNull());
    assertFalse(json.isNumber());
    assertFalse(json.isPojo());
    assertFalse(json.isShort());
    assertFalse(json.isTextual());
    assertFalse(json.isValueNode());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isContainerNode());
    assertTrue(json.isEmpty());
    assertTrue(json.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer8() throws IOException {
    // Arrange
    CheckboxNode child = new CheckboxNode();
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    MarkdownRenderer actualMarkdownRenderer = new MarkdownRenderer(document);

    // Assert
    ObjectNode json = actualMarkdownRenderer.getJson();
    JsonParser traverseResult = json.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("  ", actualMarkdownRenderer.getText());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", json.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, json.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, json.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(json.isArray());
    assertFalse(json.isBigDecimal());
    assertFalse(json.isBigInteger());
    assertFalse(json.isBinary());
    assertFalse(json.isBoolean());
    assertFalse(json.isDouble());
    assertFalse(json.isFloat());
    assertFalse(json.isFloatingPointNumber());
    assertFalse(json.isInt());
    assertFalse(json.isIntegralNumber());
    assertFalse(json.isLong());
    assertFalse(json.isMissingNode());
    assertFalse(json.isNull());
    assertFalse(json.isNumber());
    assertFalse(json.isPojo());
    assertFalse(json.isShort());
    assertFalse(json.isTextual());
    assertFalse(json.isValueNode());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isContainerNode());
    assertTrue(json.isEmpty());
    assertTrue(json.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer9() throws IOException {
    // Arrange
    FencedCodeBlock child = new FencedCodeBlock();
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    MarkdownRenderer actualMarkdownRenderer = new MarkdownRenderer(document);

    // Assert
    ObjectNode json = actualMarkdownRenderer.getJson();
    JsonParser traverseResult = json.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("", actualMarkdownRenderer.getText());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", json.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, json.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, json.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(json.isArray());
    assertFalse(json.isBigDecimal());
    assertFalse(json.isBigInteger());
    assertFalse(json.isBinary());
    assertFalse(json.isBoolean());
    assertFalse(json.isDouble());
    assertFalse(json.isFloat());
    assertFalse(json.isFloatingPointNumber());
    assertFalse(json.isInt());
    assertFalse(json.isIntegralNumber());
    assertFalse(json.isLong());
    assertFalse(json.isMissingNode());
    assertFalse(json.isNull());
    assertFalse(json.isNumber());
    assertFalse(json.isPojo());
    assertFalse(json.isShort());
    assertFalse(json.isTextual());
    assertFalse(json.isValueNode());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isContainerNode());
    assertTrue(json.isEmpty());
    assertTrue(json.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer10() throws IOException {
    // Arrange
    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    BulletList child2 = new BulletList();
    child2.appendChild(child);

    Document document = new Document();
    document.appendChild(child2);

    // Act
    MarkdownRenderer actualMarkdownRenderer = new MarkdownRenderer(document);

    // Assert
    ObjectNode json = actualMarkdownRenderer.getJson();
    JsonParser traverseResult = json.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals(":Shortcode:\n", actualMarkdownRenderer.getText());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", json.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, json.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, json.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(json.isArray());
    assertFalse(json.isBigDecimal());
    assertFalse(json.isBigInteger());
    assertFalse(json.isBinary());
    assertFalse(json.isBoolean());
    assertFalse(json.isDouble());
    assertFalse(json.isFloat());
    assertFalse(json.isFloatingPointNumber());
    assertFalse(json.isInt());
    assertFalse(json.isIntegralNumber());
    assertFalse(json.isLong());
    assertFalse(json.isMissingNode());
    assertFalse(json.isNull());
    assertFalse(json.isNumber());
    assertFalse(json.isPojo());
    assertFalse(json.isShort());
    assertFalse(json.isTextual());
    assertFalse(json.isValueNode());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isContainerNode());
    assertTrue(json.isEmpty());
    assertTrue(json.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer11() throws IOException {
    // Arrange
    EmojiNode child = new EmojiNode();
    child.setShortcode("Shortcode");

    Emphasis child2 = new Emphasis("Delimiter");
    child2.appendChild(child);

    Document document = new Document();
    document.appendChild(child2);

    // Act
    MarkdownRenderer actualMarkdownRenderer = new MarkdownRenderer(document);

    // Assert
    ObjectNode json = actualMarkdownRenderer.getJson();
    JsonParser traverseResult = json.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("Delimiter:Shortcode:Delimiter", actualMarkdownRenderer.getText());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", json.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, json.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, json.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(json.isArray());
    assertFalse(json.isBigDecimal());
    assertFalse(json.isBigInteger());
    assertFalse(json.isBinary());
    assertFalse(json.isBoolean());
    assertFalse(json.isDouble());
    assertFalse(json.isFloat());
    assertFalse(json.isFloatingPointNumber());
    assertFalse(json.isInt());
    assertFalse(json.isIntegralNumber());
    assertFalse(json.isLong());
    assertFalse(json.isMissingNode());
    assertFalse(json.isNull());
    assertFalse(json.isNumber());
    assertFalse(json.isPojo());
    assertFalse(json.isShort());
    assertFalse(json.isTextual());
    assertFalse(json.isValueNode());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isContainerNode());
    assertTrue(json.isEmpty());
    assertTrue(json.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer12() throws IOException {
    // Arrange
    Emphasis child = new Emphasis("Delimiter");
    child.appendChild(new HardLineBreak());

    Document document = new Document();
    document.appendChild(child);

    // Act
    MarkdownRenderer actualMarkdownRenderer = new MarkdownRenderer(document);

    // Assert
    ObjectNode json = actualMarkdownRenderer.getJson();
    JsonParser traverseResult = json.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("Delimiter\nDelimiter", actualMarkdownRenderer.getText());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", json.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, json.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, json.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(json.isArray());
    assertFalse(json.isBigDecimal());
    assertFalse(json.isBigInteger());
    assertFalse(json.isBinary());
    assertFalse(json.isBoolean());
    assertFalse(json.isDouble());
    assertFalse(json.isFloat());
    assertFalse(json.isFloatingPointNumber());
    assertFalse(json.isInt());
    assertFalse(json.isIntegralNumber());
    assertFalse(json.isLong());
    assertFalse(json.isMissingNode());
    assertFalse(json.isNull());
    assertFalse(json.isNumber());
    assertFalse(json.isPojo());
    assertFalse(json.isShort());
    assertFalse(json.isTextual());
    assertFalse(json.isValueNode());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isContainerNode());
    assertTrue(json.isEmpty());
    assertTrue(json.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer13() throws IOException {
    // Arrange
    FencedCodeBlock child = new FencedCodeBlock();
    child.setFenceLength(3);
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    MarkdownRenderer actualMarkdownRenderer = new MarkdownRenderer(document);

    // Assert
    ObjectNode json = actualMarkdownRenderer.getJson();
    JsonParser traverseResult = json.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000", actualMarkdownRenderer.getText());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", json.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, json.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, json.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(json.isArray());
    assertFalse(json.isBigDecimal());
    assertFalse(json.isBigInteger());
    assertFalse(json.isBinary());
    assertFalse(json.isBoolean());
    assertFalse(json.isDouble());
    assertFalse(json.isFloat());
    assertFalse(json.isFloatingPointNumber());
    assertFalse(json.isInt());
    assertFalse(json.isIntegralNumber());
    assertFalse(json.isLong());
    assertFalse(json.isMissingNode());
    assertFalse(json.isNull());
    assertFalse(json.isNumber());
    assertFalse(json.isPojo());
    assertFalse(json.isShort());
    assertFalse(json.isTextual());
    assertFalse(json.isValueNode());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isContainerNode());
    assertTrue(json.isEmpty());
    assertTrue(json.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer14() throws IOException {
    // Arrange
    FencedCodeBlock child = new FencedCodeBlock();
    child.setInfo(" ");
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    MarkdownRenderer actualMarkdownRenderer = new MarkdownRenderer(document);

    // Assert
    ObjectNode json = actualMarkdownRenderer.getJson();
    JsonParser traverseResult = json.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals(" \n", actualMarkdownRenderer.getText());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", json.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, json.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, json.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(json.isArray());
    assertFalse(json.isBigDecimal());
    assertFalse(json.isBigInteger());
    assertFalse(json.isBinary());
    assertFalse(json.isBoolean());
    assertFalse(json.isDouble());
    assertFalse(json.isFloat());
    assertFalse(json.isFloatingPointNumber());
    assertFalse(json.isInt());
    assertFalse(json.isIntegralNumber());
    assertFalse(json.isLong());
    assertFalse(json.isMissingNode());
    assertFalse(json.isNull());
    assertFalse(json.isNumber());
    assertFalse(json.isPojo());
    assertFalse(json.isShort());
    assertFalse(json.isTextual());
    assertFalse(json.isValueNode());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isContainerNode());
    assertTrue(json.isEmpty());
    assertTrue(json.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer15() throws IOException {
    // Arrange
    EmojiNode node = new EmojiNode();
    node.setShortcode("---\n**Dialog**\n");

    DialogNode child = new DialogNode();
    child.appendChild(node);

    Document document = new Document();
    document.appendChild(child);

    // Act
    MarkdownRenderer actualMarkdownRenderer = new MarkdownRenderer(document);

    // Assert
    ObjectNode json = actualMarkdownRenderer.getJson();
    JsonParser traverseResult = json.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("---\n**Dialog**\n:---\n**Dialog**\n:\n---\n", actualMarkdownRenderer.getText());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", json.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, json.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, json.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(json.isArray());
    assertFalse(json.isBigDecimal());
    assertFalse(json.isBigInteger());
    assertFalse(json.isBinary());
    assertFalse(json.isBoolean());
    assertFalse(json.isDouble());
    assertFalse(json.isFloat());
    assertFalse(json.isFloatingPointNumber());
    assertFalse(json.isInt());
    assertFalse(json.isIntegralNumber());
    assertFalse(json.isLong());
    assertFalse(json.isMissingNode());
    assertFalse(json.isNull());
    assertFalse(json.isNumber());
    assertFalse(json.isPojo());
    assertFalse(json.isShort());
    assertFalse(json.isTextual());
    assertFalse(json.isValueNode());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isContainerNode());
    assertTrue(json.isEmpty());
    assertTrue(json.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer16() throws IOException {
    // Arrange
    DialogNode child = new DialogNode();
    child.appendChild(new TableCellNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    MarkdownRenderer actualMarkdownRenderer = new MarkdownRenderer(document);

    // Assert
    ObjectNode json = actualMarkdownRenderer.getJson();
    JsonParser traverseResult = json.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("---\n**Dialog**\n   \n---\n", actualMarkdownRenderer.getText());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", json.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, json.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, json.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(json.isArray());
    assertFalse(json.isBigDecimal());
    assertFalse(json.isBigInteger());
    assertFalse(json.isBinary());
    assertFalse(json.isBoolean());
    assertFalse(json.isDouble());
    assertFalse(json.isFloat());
    assertFalse(json.isFloatingPointNumber());
    assertFalse(json.isInt());
    assertFalse(json.isIntegralNumber());
    assertFalse(json.isLong());
    assertFalse(json.isMissingNode());
    assertFalse(json.isNull());
    assertFalse(json.isNumber());
    assertFalse(json.isPojo());
    assertFalse(json.isShort());
    assertFalse(json.isTextual());
    assertFalse(json.isValueNode());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isContainerNode());
    assertTrue(json.isEmpty());
    assertTrue(json.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link MarkdownRenderer#MarkdownRenderer(Document)}
   */
  @Test
  public void testNewMarkdownRenderer17() throws IOException {
    // Arrange
    DialogNode child = new DialogNode();
    child.appendChild(new TableRowNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    MarkdownRenderer actualMarkdownRenderer = new MarkdownRenderer(document);

    // Assert
    ObjectNode json = actualMarkdownRenderer.getJson();
    JsonParser traverseResult = json.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("---\n**Dialog**\n\n---\n", actualMarkdownRenderer.getText());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", json.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, json.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, json.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(json.isArray());
    assertFalse(json.isBigDecimal());
    assertFalse(json.isBigInteger());
    assertFalse(json.isBinary());
    assertFalse(json.isBoolean());
    assertFalse(json.isDouble());
    assertFalse(json.isFloat());
    assertFalse(json.isFloatingPointNumber());
    assertFalse(json.isInt());
    assertFalse(json.isIntegralNumber());
    assertFalse(json.isLong());
    assertFalse(json.isMissingNode());
    assertFalse(json.isNull());
    assertFalse(json.isNumber());
    assertFalse(json.isPojo());
    assertFalse(json.isShort());
    assertFalse(json.isTextual());
    assertFalse(json.isValueNode());
    assertFalse(json.iterator().hasNext());
    assertTrue(json.isContainerNode());
    assertTrue(json.isEmpty());
    assertTrue(json.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }
}
