package org.symphonyoss.symphony.messageml.markdown;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.List;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Link;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.Visitor;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.symphonyoss.symphony.messageml.elements.Element;
import org.symphonyoss.symphony.messageml.elements.FormatEnum;
import org.symphonyoss.symphony.messageml.elements.MessageML;
import org.symphonyoss.symphony.messageml.elements.TextNode;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.EmojiNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.PreformattedNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableCellNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableRowNode;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;

public class MarkdownParserDiffblueTest {
  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList_givenBlockQuoteAppendChildEmojiNode_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());

    BlockQuote blockQuote = new BlockQuote();
    blockQuote.appendChild(new EmojiNode());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(blockQuote);
    BulletList ul = mock(BulletList.class);
    when(ul.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ul);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ul).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList_givenEmojiNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    BulletList ul = mock(BulletList.class);
    when(ul.getFirstChild()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(ul);

    // Assert
    verify(ul).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BlockQuote} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList_givenNodeGetNextReturnBlockQuote_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BlockQuote());
    BulletList ul = mock(BulletList.class);
    when(ul.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ul);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ul).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BulletList} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList_givenNodeGetNextReturnBulletList_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BulletList());
    BulletList ul = mock(BulletList.class);
    when(ul.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ul);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ul).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Code#Code(String)} with {@code Literal}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList_givenNodeGetNextReturnCodeWithLiteral_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Code("Literal"));
    BulletList ul = mock(BulletList.class);
    when(ul.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ul);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ul).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Document} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList_givenNodeGetNextReturnDocument_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Document());
    BulletList ul = mock(BulletList.class);
    when(ul.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ul);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ul).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Emphasis#Emphasis(String)} with {@code Delimiter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList_givenNodeGetNextReturnEmphasisWithDelimiter() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Emphasis("Delimiter"));
    BulletList ul = mock(BulletList.class);
    when(ul.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ul);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ul).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link HardLineBreak} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList_givenNodeGetNextReturnHardLineBreak_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new HardLineBreak());
    BulletList ul = mock(BulletList.class);
    when(ul.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ul);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ul).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@code null}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList_givenNodeGetNextReturnNull_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(null);
    BulletList ul = mock(BulletList.class);
    when(ul.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ul);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ul).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList_givenNodeGetNextReturnTableNode_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableNode());
    BulletList ul = mock(BulletList.class);
    when(ul.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ul);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ul).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableRowNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList_givenNodeGetNextReturnTableRowNode_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableRowNode());
    BulletList ul = mock(BulletList.class);
    when(ul.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ul);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ul).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList_givenPreformattedNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    BulletList ul = mock(BulletList.class);
    when(ul.getFirstChild()).thenReturn(new PreformattedNode());

    // Act
    markdownParser.visit(ul);

    // Assert
    verify(ul).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList_givenTableCellNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    BulletList ul = mock(BulletList.class);
    when(ul.getFirstChild()).thenReturn(new TableCellNode());

    // Act
    markdownParser.visit(ul);

    // Assert
    verify(ul).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(Code)} with {@code Code}.
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Code)"})
  public void testVisitWithCode_givenBlockQuoteAppendChildEmojiNode_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());

    BlockQuote blockQuote = new BlockQuote();
    blockQuote.appendChild(new EmojiNode());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(blockQuote);
    Code code = mock(Code.class);
    when(code.getFirstChild()).thenReturn(node);
    when(code.getLiteral()).thenReturn("Literal");

    // Act
    markdownParser.visit(code);

    // Assert
    verify(code).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(code).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Code)} with {@code Code}.
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.</li>
   *   <li>When {@link Code} {@link Node#getFirstChild()} return {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Code)"})
  public void testVisitWithCode_givenEmojiNode_whenCodeGetFirstChildReturnEmojiNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Code code = mock(Code.class);
    when(code.getFirstChild()).thenReturn(new EmojiNode());
    when(code.getLiteral()).thenReturn("Literal");

    // Act
    markdownParser.visit(code);

    // Assert
    verify(code).getLiteral();
    verify(code).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(Code)} with {@code Code}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BlockQuote} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Code)"})
  public void testVisitWithCode_givenNodeGetNextReturnBlockQuote_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BlockQuote());
    Code code = mock(Code.class);
    when(code.getFirstChild()).thenReturn(node);
    when(code.getLiteral()).thenReturn("Literal");

    // Act
    markdownParser.visit(code);

    // Assert
    verify(code).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(code).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Code)} with {@code Code}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BulletList} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Code)"})
  public void testVisitWithCode_givenNodeGetNextReturnBulletList_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BulletList());
    Code code = mock(Code.class);
    when(code.getFirstChild()).thenReturn(node);
    when(code.getLiteral()).thenReturn("Literal");

    // Act
    markdownParser.visit(code);

    // Assert
    verify(code).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(code).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Code)} with {@code Code}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Code#Code(String)} with {@code Literal}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Code)"})
  public void testVisitWithCode_givenNodeGetNextReturnCodeWithLiteral_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Code("Literal"));
    Code code = mock(Code.class);
    when(code.getFirstChild()).thenReturn(node);
    when(code.getLiteral()).thenReturn("Literal");

    // Act
    markdownParser.visit(code);

    // Assert
    verify(code).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(code).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Code)} with {@code Code}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Document} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Code)"})
  public void testVisitWithCode_givenNodeGetNextReturnDocument_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Document());
    Code code = mock(Code.class);
    when(code.getFirstChild()).thenReturn(node);
    when(code.getLiteral()).thenReturn("Literal");

    // Act
    markdownParser.visit(code);

    // Assert
    verify(code).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(code).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Code)} with {@code Code}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Emphasis#Emphasis(String)} with {@code Delimiter}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Code)"})
  public void testVisitWithCode_givenNodeGetNextReturnEmphasisWithDelimiter_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Emphasis("Delimiter"));
    Code code = mock(Code.class);
    when(code.getFirstChild()).thenReturn(node);
    when(code.getLiteral()).thenReturn("Literal");

    // Act
    markdownParser.visit(code);

    // Assert
    verify(code).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(code).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Code)} with {@code Code}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link HardLineBreak} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Code)"})
  public void testVisitWithCode_givenNodeGetNextReturnHardLineBreak_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new HardLineBreak());
    Code code = mock(Code.class);
    when(code.getFirstChild()).thenReturn(node);
    when(code.getLiteral()).thenReturn("Literal");

    // Act
    markdownParser.visit(code);

    // Assert
    verify(code).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(code).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Code)} with {@code Code}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@code null}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Code)"})
  public void testVisitWithCode_givenNodeGetNextReturnNull_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(null);
    Code code = mock(Code.class);
    when(code.getFirstChild()).thenReturn(node);
    when(code.getLiteral()).thenReturn("Literal");

    // Act
    markdownParser.visit(code);

    // Assert
    verify(code).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(code).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Code)} with {@code Code}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Code)"})
  public void testVisitWithCode_givenNodeGetNextReturnTableNode_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableNode());
    Code code = mock(Code.class);
    when(code.getFirstChild()).thenReturn(node);
    when(code.getLiteral()).thenReturn("Literal");

    // Act
    markdownParser.visit(code);

    // Assert
    verify(code).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(code).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Code)} with {@code Code}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableRowNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Code)"})
  public void testVisitWithCode_givenNodeGetNextReturnTableRowNode_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableRowNode());
    Code code = mock(Code.class);
    when(code.getFirstChild()).thenReturn(node);
    when(code.getLiteral()).thenReturn("Literal");

    // Act
    markdownParser.visit(code);

    // Assert
    verify(code).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(code).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Code)} with {@code Code}.
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Code)"})
  public void testVisitWithCode_givenPreformattedNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Code code = mock(Code.class);
    when(code.getFirstChild()).thenReturn(new PreformattedNode());
    when(code.getLiteral()).thenReturn("Literal");

    // Act
    markdownParser.visit(code);

    // Assert
    verify(code).getLiteral();
    verify(code).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(Code)} with {@code Code}.
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).</li>
   *   <li>When {@link Code} {@link Node#getFirstChild()} return {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Code)"})
  public void testVisitWithCode_givenTableCellNode_whenCodeGetFirstChildReturnTableCellNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Code code = mock(Code.class);
    when(code.getFirstChild()).thenReturn(new TableCellNode());
    when(code.getLiteral()).thenReturn("Literal");

    // Act
    markdownParser.visit(code);

    // Assert
    verify(code).getLiteral();
    verify(code).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenBlockQuoteAppendChildEmojiNode_thenCallsAccept() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    BlockQuote blockQuote = new BlockQuote();
    blockQuote.appendChild(new EmojiNode());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(blockQuote);
    Document document = mock(Document.class);
    when(document.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(document);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(document).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.</li>
   *   <li>When {@link Document} {@link Node#getFirstChild()} return {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenEmojiNode_whenDocumentGetFirstChildReturnEmojiNode() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    Document document = mock(Document.class);
    when(document.getFirstChild()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(document);

    // Assert
    verify(document).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   * <ul>
   *   <li>Given {@link FencedCodeBlock} (default constructor) Literal is {@code 2.0}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenFencedCodeBlockLiteralIs20_thenCallsAccept() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    FencedCodeBlock fencedCodeBlock = new FencedCodeBlock();
    fencedCodeBlock.setLiteral("2.0");
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(fencedCodeBlock);
    Document document = mock(Document.class);
    when(document.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(document);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(document).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   * <ul>
   *   <li>Given {@link FencedCodeBlock} (default constructor) Literal is {@code 2.0}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenFencedCodeBlockLiteralIs20_thenCallsAccept2() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    FencedCodeBlock fencedCodeBlock = new FencedCodeBlock();
    fencedCodeBlock.setLiteral("2.0");
    fencedCodeBlock.setFenceLength(3);
    fencedCodeBlock.setFenceChar('`');
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(fencedCodeBlock);
    Document document = mock(Document.class);
    when(document.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(document);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(document).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BlockQuote} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenNodeGetNextReturnBlockQuote_thenCallsAccept() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BlockQuote());
    Document document = mock(Document.class);
    when(document.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(document);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(document).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BulletList} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenNodeGetNextReturnBulletList_thenCallsAccept() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BulletList());
    Document document = mock(Document.class);
    when(document.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(document);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(document).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Code#Code(String)} with {@code Literal}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenNodeGetNextReturnCodeWithLiteral_thenCallsAccept() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Code("Literal"));
    Document document = mock(Document.class);
    when(document.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(document);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(document).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Document} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenNodeGetNextReturnDocument_thenCallsAccept() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Document());
    Document document = mock(Document.class);
    when(document.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(document);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(document).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Emphasis#Emphasis(String)} with {@code Delimiter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenNodeGetNextReturnEmphasisWithDelimiter() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Emphasis("Delimiter"));
    Document document = mock(Document.class);
    when(document.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(document);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(document).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link HardLineBreak} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenNodeGetNextReturnHardLineBreak_thenCallsAccept() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new HardLineBreak());
    Document document = mock(Document.class);
    when(document.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(document);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(document).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@code null}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenNodeGetNextReturnNull_thenCallsAccept() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(null);
    Document document = mock(Document.class);
    when(document.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(document);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(document).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenNodeGetNextReturnTableNode_thenCallsAccept() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableNode());
    Document document = mock(Document.class);
    when(document.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(document);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(document).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableRowNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenNodeGetNextReturnTableRowNode_thenCallsAccept() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableRowNode());
    Document document = mock(Document.class);
    when(document.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(document);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(document).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenPreformattedNode() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    Document document = mock(Document.class);
    when(document.getFirstChild()).thenReturn(new PreformattedNode());

    // Act
    markdownParser.visit(document);

    // Assert
    verify(document).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenTableCellNode() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    Document document = mock(Document.class);
    when(document.getFirstChild()).thenReturn(new TableCellNode());

    // Act
    markdownParser.visit(document);

    // Assert
    verify(document).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(Emphasis)} with {@code Emphasis}.
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Emphasis)"})
  public void testVisitWithEmphasis_givenBlockQuoteAppendChildEmojiNode_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());

    BlockQuote blockQuote = new BlockQuote();
    blockQuote.appendChild(new EmojiNode());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(blockQuote);
    Emphasis em = mock(Emphasis.class);
    when(em.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(em);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(em).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Emphasis)} with {@code Emphasis}.
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.</li>
   *   <li>When {@link Emphasis} {@link Node#getFirstChild()} return {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Emphasis)"})
  public void testVisitWithEmphasis_givenEmojiNode_whenEmphasisGetFirstChildReturnEmojiNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Emphasis em = mock(Emphasis.class);
    when(em.getFirstChild()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(em);

    // Assert
    verify(em).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(Emphasis)} with {@code Emphasis}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BlockQuote} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Emphasis)"})
  public void testVisitWithEmphasis_givenNodeGetNextReturnBlockQuote_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BlockQuote());
    Emphasis em = mock(Emphasis.class);
    when(em.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(em);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(em).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Emphasis)} with {@code Emphasis}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BulletList} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Emphasis)"})
  public void testVisitWithEmphasis_givenNodeGetNextReturnBulletList_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BulletList());
    Emphasis em = mock(Emphasis.class);
    when(em.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(em);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(em).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Emphasis)} with {@code Emphasis}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Code#Code(String)} with {@code Literal}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Emphasis)"})
  public void testVisitWithEmphasis_givenNodeGetNextReturnCodeWithLiteral_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Code("Literal"));
    Emphasis em = mock(Emphasis.class);
    when(em.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(em);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(em).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Emphasis)} with {@code Emphasis}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Document} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Emphasis)"})
  public void testVisitWithEmphasis_givenNodeGetNextReturnDocument_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Document());
    Emphasis em = mock(Emphasis.class);
    when(em.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(em);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(em).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Emphasis)} with {@code Emphasis}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Emphasis#Emphasis(String)} with {@code Delimiter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Emphasis)"})
  public void testVisitWithEmphasis_givenNodeGetNextReturnEmphasisWithDelimiter() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Emphasis("Delimiter"));
    Emphasis em = mock(Emphasis.class);
    when(em.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(em);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(em).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Emphasis)} with {@code Emphasis}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link HardLineBreak} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Emphasis)"})
  public void testVisitWithEmphasis_givenNodeGetNextReturnHardLineBreak_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new HardLineBreak());
    Emphasis em = mock(Emphasis.class);
    when(em.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(em);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(em).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Emphasis)} with {@code Emphasis}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@code null}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Emphasis)"})
  public void testVisitWithEmphasis_givenNodeGetNextReturnNull_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(null);
    Emphasis em = mock(Emphasis.class);
    when(em.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(em);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(em).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Emphasis)} with {@code Emphasis}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Emphasis)"})
  public void testVisitWithEmphasis_givenNodeGetNextReturnTableNode_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableNode());
    Emphasis em = mock(Emphasis.class);
    when(em.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(em);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(em).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Emphasis)} with {@code Emphasis}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableRowNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Emphasis)"})
  public void testVisitWithEmphasis_givenNodeGetNextReturnTableRowNode_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableRowNode());
    Emphasis em = mock(Emphasis.class);
    when(em.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(em);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(em).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Emphasis)} with {@code Emphasis}.
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Emphasis)"})
  public void testVisitWithEmphasis_givenPreformattedNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Emphasis em = mock(Emphasis.class);
    when(em.getFirstChild()).thenReturn(new PreformattedNode());

    // Act
    markdownParser.visit(em);

    // Assert
    verify(em).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(Emphasis)} with {@code Emphasis}.
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Emphasis)"})
  public void testVisitWithEmphasis_givenTableCellNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Emphasis em = mock(Emphasis.class);
    when(em.getFirstChild()).thenReturn(new TableCellNode());

    // Act
    markdownParser.visit(em);

    // Assert
    verify(em).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(HardLineBreak)} with {@code HardLineBreak}.
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HardLineBreak)"})
  public void testVisitWithHardLineBreak_givenBlockQuoteAppendChildEmojiNode_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());

    BlockQuote blockQuote = new BlockQuote();
    blockQuote.appendChild(new EmojiNode());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(blockQuote);
    HardLineBreak hardLineBreak = mock(HardLineBreak.class);
    when(hardLineBreak.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(hardLineBreak);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(hardLineBreak).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HardLineBreak)} with {@code HardLineBreak}.
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HardLineBreak)"})
  public void testVisitWithHardLineBreak_givenEmojiNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    HardLineBreak hardLineBreak = mock(HardLineBreak.class);
    when(hardLineBreak.getFirstChild()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(hardLineBreak);

    // Assert
    verify(hardLineBreak).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(HardLineBreak)} with {@code HardLineBreak}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BlockQuote} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HardLineBreak)"})
  public void testVisitWithHardLineBreak_givenNodeGetNextReturnBlockQuote_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BlockQuote());
    HardLineBreak hardLineBreak = mock(HardLineBreak.class);
    when(hardLineBreak.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(hardLineBreak);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(hardLineBreak).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HardLineBreak)} with {@code HardLineBreak}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BulletList} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HardLineBreak)"})
  public void testVisitWithHardLineBreak_givenNodeGetNextReturnBulletList_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BulletList());
    HardLineBreak hardLineBreak = mock(HardLineBreak.class);
    when(hardLineBreak.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(hardLineBreak);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(hardLineBreak).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HardLineBreak)} with {@code HardLineBreak}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Code#Code(String)} with {@code Literal}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HardLineBreak)"})
  public void testVisitWithHardLineBreak_givenNodeGetNextReturnCodeWithLiteral_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Code("Literal"));
    HardLineBreak hardLineBreak = mock(HardLineBreak.class);
    when(hardLineBreak.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(hardLineBreak);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(hardLineBreak).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HardLineBreak)} with {@code HardLineBreak}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Document} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HardLineBreak)"})
  public void testVisitWithHardLineBreak_givenNodeGetNextReturnDocument_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Document());
    HardLineBreak hardLineBreak = mock(HardLineBreak.class);
    when(hardLineBreak.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(hardLineBreak);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(hardLineBreak).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HardLineBreak)} with {@code HardLineBreak}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Emphasis#Emphasis(String)} with {@code Delimiter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HardLineBreak)"})
  public void testVisitWithHardLineBreak_givenNodeGetNextReturnEmphasisWithDelimiter() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Emphasis("Delimiter"));
    HardLineBreak hardLineBreak = mock(HardLineBreak.class);
    when(hardLineBreak.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(hardLineBreak);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(hardLineBreak).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HardLineBreak)} with {@code HardLineBreak}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link HardLineBreak} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HardLineBreak)"})
  public void testVisitWithHardLineBreak_givenNodeGetNextReturnHardLineBreak_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new HardLineBreak());
    HardLineBreak hardLineBreak = mock(HardLineBreak.class);
    when(hardLineBreak.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(hardLineBreak);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(hardLineBreak).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HardLineBreak)} with {@code HardLineBreak}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@code null}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HardLineBreak)"})
  public void testVisitWithHardLineBreak_givenNodeGetNextReturnNull_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(null);
    HardLineBreak hardLineBreak = mock(HardLineBreak.class);
    when(hardLineBreak.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(hardLineBreak);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(hardLineBreak).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HardLineBreak)} with {@code HardLineBreak}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HardLineBreak)"})
  public void testVisitWithHardLineBreak_givenNodeGetNextReturnTableNode_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableNode());
    HardLineBreak hardLineBreak = mock(HardLineBreak.class);
    when(hardLineBreak.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(hardLineBreak);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(hardLineBreak).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HardLineBreak)} with {@code HardLineBreak}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableRowNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HardLineBreak)"})
  public void testVisitWithHardLineBreak_givenNodeGetNextReturnTableRowNode_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableRowNode());
    HardLineBreak hardLineBreak = mock(HardLineBreak.class);
    when(hardLineBreak.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(hardLineBreak);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(hardLineBreak).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HardLineBreak)} with {@code HardLineBreak}.
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HardLineBreak)"})
  public void testVisitWithHardLineBreak_givenPreformattedNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    HardLineBreak hardLineBreak = mock(HardLineBreak.class);
    when(hardLineBreak.getFirstChild()).thenReturn(new PreformattedNode());

    // Act
    markdownParser.visit(hardLineBreak);

    // Assert
    verify(hardLineBreak).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(HardLineBreak)} with {@code HardLineBreak}.
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HardLineBreak)"})
  public void testVisitWithHardLineBreak_givenTableCellNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    HardLineBreak hardLineBreak = mock(HardLineBreak.class);
    when(hardLineBreak.getFirstChild()).thenReturn(new TableCellNode());

    // Act
    markdownParser.visit(hardLineBreak);

    // Assert
    verify(hardLineBreak).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(HtmlInline)} with {@code HtmlInline}.
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HtmlInline)"})
  public void testVisitWithHtmlInline_givenBlockQuoteAppendChildEmojiNode_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());

    BlockQuote blockQuote = new BlockQuote();
    blockQuote.appendChild(new EmojiNode());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(blockQuote);
    HtmlInline tag = mock(HtmlInline.class);
    when(tag.getLiteral()).thenReturn("Literal");
    when(tag.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(tag);

    // Assert
    verify(tag).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(tag).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HtmlInline)} with {@code HtmlInline}.
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HtmlInline)"})
  public void testVisitWithHtmlInline_givenEmojiNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    HtmlInline tag = mock(HtmlInline.class);
    when(tag.getLiteral()).thenReturn("Literal");
    when(tag.getFirstChild()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(tag);

    // Assert
    verify(tag).getLiteral();
    verify(tag).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(HtmlInline)} with {@code HtmlInline}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BlockQuote} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HtmlInline)"})
  public void testVisitWithHtmlInline_givenNodeGetNextReturnBlockQuote_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BlockQuote());
    HtmlInline tag = mock(HtmlInline.class);
    when(tag.getLiteral()).thenReturn("Literal");
    when(tag.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(tag);

    // Assert
    verify(tag).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(tag).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HtmlInline)} with {@code HtmlInline}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BulletList} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HtmlInline)"})
  public void testVisitWithHtmlInline_givenNodeGetNextReturnBulletList_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BulletList());
    HtmlInline tag = mock(HtmlInline.class);
    when(tag.getLiteral()).thenReturn("Literal");
    when(tag.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(tag);

    // Assert
    verify(tag).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(tag).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HtmlInline)} with {@code HtmlInline}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Code#Code(String)} with {@code Literal}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HtmlInline)"})
  public void testVisitWithHtmlInline_givenNodeGetNextReturnCodeWithLiteral_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Code("Literal"));
    HtmlInline tag = mock(HtmlInline.class);
    when(tag.getLiteral()).thenReturn("Literal");
    when(tag.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(tag);

    // Assert
    verify(tag).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(tag).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HtmlInline)} with {@code HtmlInline}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Document} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HtmlInline)"})
  public void testVisitWithHtmlInline_givenNodeGetNextReturnDocument_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Document());
    HtmlInline tag = mock(HtmlInline.class);
    when(tag.getLiteral()).thenReturn("Literal");
    when(tag.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(tag);

    // Assert
    verify(tag).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(tag).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HtmlInline)} with {@code HtmlInline}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Emphasis#Emphasis(String)} with {@code Delimiter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HtmlInline)"})
  public void testVisitWithHtmlInline_givenNodeGetNextReturnEmphasisWithDelimiter() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Emphasis("Delimiter"));
    HtmlInline tag = mock(HtmlInline.class);
    when(tag.getLiteral()).thenReturn("Literal");
    when(tag.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(tag);

    // Assert
    verify(tag).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(tag).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HtmlInline)} with {@code HtmlInline}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link HardLineBreak} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HtmlInline)"})
  public void testVisitWithHtmlInline_givenNodeGetNextReturnHardLineBreak_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new HardLineBreak());
    HtmlInline tag = mock(HtmlInline.class);
    when(tag.getLiteral()).thenReturn("Literal");
    when(tag.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(tag);

    // Assert
    verify(tag).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(tag).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HtmlInline)} with {@code HtmlInline}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@code null}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HtmlInline)"})
  public void testVisitWithHtmlInline_givenNodeGetNextReturnNull_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(null);
    HtmlInline tag = mock(HtmlInline.class);
    when(tag.getLiteral()).thenReturn("Literal");
    when(tag.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(tag);

    // Assert
    verify(tag).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(tag).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HtmlInline)} with {@code HtmlInline}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HtmlInline)"})
  public void testVisitWithHtmlInline_givenNodeGetNextReturnTableNode_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableNode());
    HtmlInline tag = mock(HtmlInline.class);
    when(tag.getLiteral()).thenReturn("Literal");
    when(tag.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(tag);

    // Assert
    verify(tag).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(tag).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HtmlInline)} with {@code HtmlInline}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableRowNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HtmlInline)"})
  public void testVisitWithHtmlInline_givenNodeGetNextReturnTableRowNode_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableRowNode());
    HtmlInline tag = mock(HtmlInline.class);
    when(tag.getLiteral()).thenReturn("Literal");
    when(tag.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(tag);

    // Assert
    verify(tag).getLiteral();
    verify(node).accept(isA(Visitor.class));
    verify(tag).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(HtmlInline)} with {@code HtmlInline}.
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HtmlInline)"})
  public void testVisitWithHtmlInline_givenPreformattedNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    HtmlInline tag = mock(HtmlInline.class);
    when(tag.getLiteral()).thenReturn("Literal");
    when(tag.getFirstChild()).thenReturn(new PreformattedNode());

    // Act
    markdownParser.visit(tag);

    // Assert
    verify(tag).getLiteral();
    verify(tag).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(HtmlInline)} with {@code HtmlInline}.
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(HtmlInline)"})
  public void testVisitWithHtmlInline_givenTableCellNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    HtmlInline tag = mock(HtmlInline.class);
    when(tag.getLiteral()).thenReturn("Literal");
    when(tag.getFirstChild()).thenReturn(new TableCellNode());

    // Act
    markdownParser.visit(tag);

    // Assert
    verify(tag).getLiteral();
    verify(tag).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink_givenBlockQuoteAppendChildEmojiNode_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());

    BlockQuote blockQuote = new BlockQuote();
    blockQuote.appendChild(new EmojiNode());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(blockQuote);
    Link a = mock(Link.class);
    when(a.getDestination()).thenReturn("Destination");
    when(a.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(a);

    // Assert
    verify(a, atLeast(1)).getDestination();
    verify(node).accept(isA(Visitor.class));
    verify(a).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.</li>
   *   <li>When {@link Link} {@link Node#getFirstChild()} return {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink_givenEmojiNode_whenLinkGetFirstChildReturnEmojiNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Link a = mock(Link.class);
    when(a.getDestination()).thenReturn("Destination");
    when(a.getFirstChild()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(a);

    // Assert
    verify(a, atLeast(1)).getDestination();
    verify(a).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BlockQuote} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink_givenNodeGetNextReturnBlockQuote_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BlockQuote());
    Link a = mock(Link.class);
    when(a.getDestination()).thenReturn("Destination");
    when(a.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(a);

    // Assert
    verify(a, atLeast(1)).getDestination();
    verify(node).accept(isA(Visitor.class));
    verify(a).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BulletList} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink_givenNodeGetNextReturnBulletList_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BulletList());
    Link a = mock(Link.class);
    when(a.getDestination()).thenReturn("Destination");
    when(a.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(a);

    // Assert
    verify(a, atLeast(1)).getDestination();
    verify(node).accept(isA(Visitor.class));
    verify(a).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Code#Code(String)} with {@code Literal}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink_givenNodeGetNextReturnCodeWithLiteral_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Code("Literal"));
    Link a = mock(Link.class);
    when(a.getDestination()).thenReturn("Destination");
    when(a.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(a);

    // Assert
    verify(a, atLeast(1)).getDestination();
    verify(node).accept(isA(Visitor.class));
    verify(a).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Document} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink_givenNodeGetNextReturnDocument_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Document());
    Link a = mock(Link.class);
    when(a.getDestination()).thenReturn("Destination");
    when(a.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(a);

    // Assert
    verify(a, atLeast(1)).getDestination();
    verify(node).accept(isA(Visitor.class));
    verify(a).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Emphasis#Emphasis(String)} with {@code Delimiter}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink_givenNodeGetNextReturnEmphasisWithDelimiter_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Emphasis("Delimiter"));
    Link a = mock(Link.class);
    when(a.getDestination()).thenReturn("Destination");
    when(a.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(a);

    // Assert
    verify(a, atLeast(1)).getDestination();
    verify(node).accept(isA(Visitor.class));
    verify(a).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link HardLineBreak} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink_givenNodeGetNextReturnHardLineBreak_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new HardLineBreak());
    Link a = mock(Link.class);
    when(a.getDestination()).thenReturn("Destination");
    when(a.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(a);

    // Assert
    verify(a, atLeast(1)).getDestination();
    verify(node).accept(isA(Visitor.class));
    verify(a).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@code null}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink_givenNodeGetNextReturnNull_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(null);
    Link a = mock(Link.class);
    when(a.getDestination()).thenReturn("Destination");
    when(a.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(a);

    // Assert
    verify(a, atLeast(1)).getDestination();
    verify(node).accept(isA(Visitor.class));
    verify(a).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink_givenNodeGetNextReturnTableNode_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableNode());
    Link a = mock(Link.class);
    when(a.getDestination()).thenReturn("Destination");
    when(a.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(a);

    // Assert
    verify(a, atLeast(1)).getDestination();
    verify(node).accept(isA(Visitor.class));
    verify(a).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableRowNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink_givenNodeGetNextReturnTableRowNode_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableRowNode());
    Link a = mock(Link.class);
    when(a.getDestination()).thenReturn("Destination");
    when(a.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(a);

    // Assert
    verify(a, atLeast(1)).getDestination();
    verify(node).accept(isA(Visitor.class));
    verify(a).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink_givenPreformattedNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Link a = mock(Link.class);
    when(a.getDestination()).thenReturn("Destination");
    when(a.getFirstChild()).thenReturn(new PreformattedNode());

    // Act
    markdownParser.visit(a);

    // Assert
    verify(a, atLeast(1)).getDestination();
    verify(a).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).</li>
   *   <li>When {@link Link} {@link Node#getFirstChild()} return {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink_givenTableCellNode_whenLinkGetFirstChildReturnTableCellNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Link a = mock(Link.class);
    when(a.getDestination()).thenReturn("Destination");
    when(a.getFirstChild()).thenReturn(new TableCellNode());

    // Act
    markdownParser.visit(a);

    // Assert
    verify(a, atLeast(1)).getDestination();
    verify(a).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem_givenBlockQuoteAppendChildEmojiNode_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());

    BlockQuote blockQuote = new BlockQuote();
    blockQuote.appendChild(new EmojiNode());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(blockQuote);
    ListItem li = mock(ListItem.class);
    when(li.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(li);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(li).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.</li>
   *   <li>When {@link ListItem} {@link Node#getFirstChild()} return {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem_givenEmojiNode_whenListItemGetFirstChildReturnEmojiNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    ListItem li = mock(ListItem.class);
    when(li.getFirstChild()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(li);

    // Assert
    verify(li).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BlockQuote} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem_givenNodeGetNextReturnBlockQuote_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BlockQuote());
    ListItem li = mock(ListItem.class);
    when(li.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(li);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(li).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BulletList} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem_givenNodeGetNextReturnBulletList_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BulletList());
    ListItem li = mock(ListItem.class);
    when(li.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(li);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(li).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Code#Code(String)} with {@code Literal}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem_givenNodeGetNextReturnCodeWithLiteral_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Code("Literal"));
    ListItem li = mock(ListItem.class);
    when(li.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(li);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(li).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Document} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem_givenNodeGetNextReturnDocument_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Document());
    ListItem li = mock(ListItem.class);
    when(li.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(li);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(li).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Emphasis#Emphasis(String)} with {@code Delimiter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem_givenNodeGetNextReturnEmphasisWithDelimiter() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Emphasis("Delimiter"));
    ListItem li = mock(ListItem.class);
    when(li.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(li);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(li).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link HardLineBreak} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem_givenNodeGetNextReturnHardLineBreak_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new HardLineBreak());
    ListItem li = mock(ListItem.class);
    when(li.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(li);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(li).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@code null}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem_givenNodeGetNextReturnNull_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(null);
    ListItem li = mock(ListItem.class);
    when(li.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(li);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(li).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem_givenNodeGetNextReturnTableNode_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableNode());
    ListItem li = mock(ListItem.class);
    when(li.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(li);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(li).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableRowNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem_givenNodeGetNextReturnTableRowNode_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableRowNode());
    ListItem li = mock(ListItem.class);
    when(li.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(li);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(li).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem_givenPreformattedNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    ListItem li = mock(ListItem.class);
    when(li.getFirstChild()).thenReturn(new PreformattedNode());

    // Act
    markdownParser.visit(li);

    // Assert
    verify(li).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem_givenTableCellNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    ListItem li = mock(ListItem.class);
    when(li.getFirstChild()).thenReturn(new TableCellNode());

    // Act
    markdownParser.visit(li);

    // Assert
    verify(li).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenBlockQuoteAppendChildEmojiNode_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());

    BlockQuote blockQuote = new BlockQuote();
    blockQuote.appendChild(new EmojiNode());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(blockQuote);
    OrderedList ol = mock(OrderedList.class);
    when(ol.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ol);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ol).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenEmojiNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    OrderedList ol = mock(OrderedList.class);
    when(ol.getFirstChild()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(ol);

    // Assert
    verify(ol).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BlockQuote} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenNodeGetNextReturnBlockQuote_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BlockQuote());
    OrderedList ol = mock(OrderedList.class);
    when(ol.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ol);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ol).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BulletList} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenNodeGetNextReturnBulletList_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BulletList());
    OrderedList ol = mock(OrderedList.class);
    when(ol.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ol);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ol).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Code#Code(String)} with {@code Literal}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenNodeGetNextReturnCodeWithLiteral_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Code("Literal"));
    OrderedList ol = mock(OrderedList.class);
    when(ol.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ol);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ol).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Document} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenNodeGetNextReturnDocument_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Document());
    OrderedList ol = mock(OrderedList.class);
    when(ol.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ol);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ol).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Emphasis#Emphasis(String)} with {@code Delimiter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenNodeGetNextReturnEmphasisWithDelimiter() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Emphasis("Delimiter"));
    OrderedList ol = mock(OrderedList.class);
    when(ol.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ol);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ol).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link HardLineBreak} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenNodeGetNextReturnHardLineBreak_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new HardLineBreak());
    OrderedList ol = mock(OrderedList.class);
    when(ol.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ol);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ol).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@code null}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenNodeGetNextReturnNull_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(null);
    OrderedList ol = mock(OrderedList.class);
    when(ol.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ol);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ol).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenNodeGetNextReturnTableNode_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableNode());
    OrderedList ol = mock(OrderedList.class);
    when(ol.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ol);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ol).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableRowNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenNodeGetNextReturnTableRowNode_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableRowNode());
    OrderedList ol = mock(OrderedList.class);
    when(ol.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(ol);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(ol).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenPreformattedNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    OrderedList ol = mock(OrderedList.class);
    when(ol.getFirstChild()).thenReturn(new PreformattedNode());

    // Act
    markdownParser.visit(ol);

    // Assert
    verify(ol).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenTableCellNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    OrderedList ol = mock(OrderedList.class);
    when(ol.getFirstChild()).thenReturn(new TableCellNode());

    // Act
    markdownParser.visit(ol);

    // Assert
    verify(ol).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph_givenBlockQuoteAppendChildEmojiNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());

    BlockQuote blockQuote = new BlockQuote();
    blockQuote.appendChild(new EmojiNode());
    Paragraph paragraph = mock(Paragraph.class);
    when(paragraph.getFirstChild()).thenReturn(blockQuote);
    when(paragraph.getPrevious()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(paragraph);

    // Assert
    verify(paragraph).getFirstChild();
    verify(paragraph).getPrevious();
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   * <ul>
   *   <li>Given {@link BulletList} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph_givenBulletListAppendChildEmojiNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());

    BulletList bulletList = new BulletList();
    bulletList.appendChild(new EmojiNode());
    Paragraph paragraph = mock(Paragraph.class);
    when(paragraph.getFirstChild()).thenReturn(bulletList);
    when(paragraph.getPrevious()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(paragraph);

    // Assert
    verify(paragraph).getFirstChild();
    verify(paragraph).getPrevious();
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   * <ul>
   *   <li>Given {@link Code#Code(String)} with {@code Literal} appendChild {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph_givenCodeWithLiteralAppendChildEmojiNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());

    Code code = new Code("Literal");
    code.appendChild(new EmojiNode());
    Paragraph paragraph = mock(Paragraph.class);
    when(paragraph.getFirstChild()).thenReturn(code);
    when(paragraph.getPrevious()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(paragraph);

    // Assert
    verify(paragraph).getFirstChild();
    verify(paragraph).getPrevious();
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   * <ul>
   *   <li>Given {@link Document} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph_givenDocumentAppendChildEmojiNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());

    Document document = new Document();
    document.appendChild(new EmojiNode());
    Paragraph paragraph = mock(Paragraph.class);
    when(paragraph.getFirstChild()).thenReturn(document);
    when(paragraph.getPrevious()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(paragraph);

    // Assert
    verify(paragraph).getFirstChild();
    verify(paragraph).getPrevious();
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   * <ul>
   *   <li>Given {@link Emphasis#Emphasis(String)} with {@code Delimiter} appendChild {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph_givenEmphasisWithDelimiterAppendChildEmojiNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());

    Emphasis emphasis = new Emphasis("Delimiter");
    emphasis.appendChild(new EmojiNode());
    Paragraph paragraph = mock(Paragraph.class);
    when(paragraph.getFirstChild()).thenReturn(emphasis);
    when(paragraph.getPrevious()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(paragraph);

    // Assert
    verify(paragraph).getFirstChild();
    verify(paragraph).getPrevious();
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   * <ul>
   *   <li>Given {@link FencedCodeBlock} (default constructor) Literal is {@code br}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph_givenFencedCodeBlockLiteralIsBr() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());

    FencedCodeBlock fencedCodeBlock = new FencedCodeBlock();
    fencedCodeBlock.setLiteral("br");
    fencedCodeBlock.appendChild(new EmojiNode());
    Paragraph paragraph = mock(Paragraph.class);
    when(paragraph.getFirstChild()).thenReturn(fencedCodeBlock);
    when(paragraph.getPrevious()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(paragraph);

    // Assert
    verify(paragraph).getFirstChild();
    verify(paragraph).getPrevious();
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Paragraph} {@link Node#getFirstChild()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph_givenNull_whenParagraphGetFirstChildReturnNull() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Paragraph paragraph = mock(Paragraph.class);
    when(paragraph.getFirstChild()).thenReturn(null);
    when(paragraph.getPrevious()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(paragraph);

    // Assert
    verify(paragraph).getFirstChild();
    verify(paragraph).getPrevious();
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph_givenPreformattedNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Paragraph paragraph = mock(Paragraph.class);
    when(paragraph.getFirstChild()).thenReturn(new PreformattedNode());
    when(paragraph.getPrevious()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(paragraph);

    // Assert
    verify(paragraph).getFirstChild();
    verify(paragraph).getPrevious();
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph_givenTableCellNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Paragraph paragraph = mock(Paragraph.class);
    when(paragraph.getFirstChild()).thenReturn(new TableCellNode());
    when(paragraph.getPrevious()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(paragraph);

    // Assert
    verify(paragraph).getFirstChild();
    verify(paragraph).getPrevious();
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   * <ul>
   *   <li>Given {@link TableNode} (default constructor).</li>
   *   <li>When {@link Paragraph} {@link Node#getFirstChild()} return {@link TableNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph_givenTableNode_whenParagraphGetFirstChildReturnTableNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Paragraph paragraph = mock(Paragraph.class);
    when(paragraph.getFirstChild()).thenReturn(new TableNode());
    when(paragraph.getPrevious()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(paragraph);

    // Assert
    verify(paragraph).getFirstChild();
    verify(paragraph).getPrevious();
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   * <ul>
   *   <li>Given {@link TableRowNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph_givenTableRowNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Paragraph paragraph = mock(Paragraph.class);
    when(paragraph.getFirstChild()).thenReturn(new TableRowNode());
    when(paragraph.getPrevious()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(paragraph);

    // Assert
    verify(paragraph).getFirstChild();
    verify(paragraph).getPrevious();
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   * <ul>
   *   <li>When {@link Paragraph} {@link Node#getFirstChild()} return {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph_whenParagraphGetFirstChildReturnEmojiNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Paragraph paragraph = mock(Paragraph.class);
    when(paragraph.getFirstChild()).thenReturn(new EmojiNode());
    when(paragraph.getPrevious()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(paragraph);

    // Assert
    verify(paragraph).getFirstChild();
    verify(paragraph).getPrevious();
  }

  /**
   * Test {@link MarkdownParser#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis_givenBlockQuoteAppendChildEmojiNode_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());

    BlockQuote blockQuote = new BlockQuote();
    blockQuote.appendChild(new EmojiNode());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(blockQuote);
    StrongEmphasis b = mock(StrongEmphasis.class);
    when(b.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(b);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(b).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis_givenEmojiNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    StrongEmphasis b = mock(StrongEmphasis.class);
    when(b.getFirstChild()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(b);

    // Assert
    verify(b).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BlockQuote} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis_givenNodeGetNextReturnBlockQuote_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BlockQuote());
    StrongEmphasis b = mock(StrongEmphasis.class);
    when(b.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(b);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(b).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BulletList} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis_givenNodeGetNextReturnBulletList_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BulletList());
    StrongEmphasis b = mock(StrongEmphasis.class);
    when(b.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(b);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(b).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Code#Code(String)} with {@code Literal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis_givenNodeGetNextReturnCodeWithLiteral() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Code("Literal"));
    StrongEmphasis b = mock(StrongEmphasis.class);
    when(b.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(b);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(b).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Document} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis_givenNodeGetNextReturnDocument_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Document());
    StrongEmphasis b = mock(StrongEmphasis.class);
    when(b.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(b);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(b).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Emphasis#Emphasis(String)} with {@code Delimiter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis_givenNodeGetNextReturnEmphasisWithDelimiter() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Emphasis("Delimiter"));
    StrongEmphasis b = mock(StrongEmphasis.class);
    when(b.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(b);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(b).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link HardLineBreak} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis_givenNodeGetNextReturnHardLineBreak_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new HardLineBreak());
    StrongEmphasis b = mock(StrongEmphasis.class);
    when(b.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(b);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(b).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@code null}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis_givenNodeGetNextReturnNull_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(null);
    StrongEmphasis b = mock(StrongEmphasis.class);
    when(b.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(b);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(b).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis_givenNodeGetNextReturnTableNode_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableNode());
    StrongEmphasis b = mock(StrongEmphasis.class);
    when(b.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(b);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(b).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableRowNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis_givenNodeGetNextReturnTableRowNode_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableRowNode());
    StrongEmphasis b = mock(StrongEmphasis.class);
    when(b.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(b);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(b).getFirstChild();
    verify(node).getNext();
  }

  /**
   * Test {@link MarkdownParser#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis_givenPreformattedNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    StrongEmphasis b = mock(StrongEmphasis.class);
    when(b.getFirstChild()).thenReturn(new PreformattedNode());

    // Act
    markdownParser.visit(b);

    // Assert
    verify(b).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis_givenTableCellNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    StrongEmphasis b = mock(StrongEmphasis.class);
    when(b.getFirstChild()).thenReturn(new TableCellNode());

    // Act
    markdownParser.visit(b);

    // Assert
    verify(b).getFirstChild();
  }

  /**
   * Test {@link MarkdownParser#visit(Text)} with {@code Text}.
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Text)"})
  public void testVisitWithText_givenBlockQuoteAppendChildEmojiNode_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());

    BlockQuote blockQuote = new BlockQuote();
    blockQuote.appendChild(new EmojiNode());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(blockQuote);
    Text text = mock(Text.class);
    when(text.getLiteral()).thenReturn("Literal");
    when(text.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(text);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(text).getFirstChild();
    verify(node).getNext();
    verify(text).getLiteral();
  }

  /**
   * Test {@link MarkdownParser#visit(Text)} with {@code Text}.
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.</li>
   *   <li>When {@link Text} {@link Node#getFirstChild()} return {@link EmojiNode#EmojiNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Text)"})
  public void testVisitWithText_givenEmojiNode_whenTextGetFirstChildReturnEmojiNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Text text = mock(Text.class);
    when(text.getLiteral()).thenReturn("Literal");
    when(text.getFirstChild()).thenReturn(new EmojiNode());

    // Act
    markdownParser.visit(text);

    // Assert
    verify(text).getFirstChild();
    verify(text).getLiteral();
  }

  /**
   * Test {@link MarkdownParser#visit(Text)} with {@code Text}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BlockQuote} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Text)"})
  public void testVisitWithText_givenNodeGetNextReturnBlockQuote_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BlockQuote());
    Text text = mock(Text.class);
    when(text.getLiteral()).thenReturn("Literal");
    when(text.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(text);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(text).getFirstChild();
    verify(node).getNext();
    verify(text).getLiteral();
  }

  /**
   * Test {@link MarkdownParser#visit(Text)} with {@code Text}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link BulletList} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Text)"})
  public void testVisitWithText_givenNodeGetNextReturnBulletList_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new BulletList());
    Text text = mock(Text.class);
    when(text.getLiteral()).thenReturn("Literal");
    when(text.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(text);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(text).getFirstChild();
    verify(node).getNext();
    verify(text).getLiteral();
  }

  /**
   * Test {@link MarkdownParser#visit(Text)} with {@code Text}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Code#Code(String)} with {@code Literal}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Text)"})
  public void testVisitWithText_givenNodeGetNextReturnCodeWithLiteral_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Code("Literal"));
    Text text = mock(Text.class);
    when(text.getLiteral()).thenReturn("Literal");
    when(text.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(text);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(text).getFirstChild();
    verify(node).getNext();
    verify(text).getLiteral();
  }

  /**
   * Test {@link MarkdownParser#visit(Text)} with {@code Text}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Document} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Text)"})
  public void testVisitWithText_givenNodeGetNextReturnDocument_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Document());
    Text text = mock(Text.class);
    when(text.getLiteral()).thenReturn("Literal");
    when(text.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(text);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(text).getFirstChild();
    verify(node).getNext();
    verify(text).getLiteral();
  }

  /**
   * Test {@link MarkdownParser#visit(Text)} with {@code Text}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link Emphasis#Emphasis(String)} with {@code Delimiter}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Text)"})
  public void testVisitWithText_givenNodeGetNextReturnEmphasisWithDelimiter_thenCallsAccept()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new Emphasis("Delimiter"));
    Text text = mock(Text.class);
    when(text.getLiteral()).thenReturn("Literal");
    when(text.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(text);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(text).getFirstChild();
    verify(node).getNext();
    verify(text).getLiteral();
  }

  /**
   * Test {@link MarkdownParser#visit(Text)} with {@code Text}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link HardLineBreak} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Text)"})
  public void testVisitWithText_givenNodeGetNextReturnHardLineBreak_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new HardLineBreak());
    Text text = mock(Text.class);
    when(text.getLiteral()).thenReturn("Literal");
    when(text.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(text);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(text).getFirstChild();
    verify(node).getNext();
    verify(text).getLiteral();
  }

  /**
   * Test {@link MarkdownParser#visit(Text)} with {@code Text}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@code null}.</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Text)"})
  public void testVisitWithText_givenNodeGetNextReturnNull_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(null);
    Text text = mock(Text.class);
    when(text.getLiteral()).thenReturn("Literal");
    when(text.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(text);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(text).getFirstChild();
    verify(node).getNext();
    verify(text).getLiteral();
  }

  /**
   * Test {@link MarkdownParser#visit(Text)} with {@code Text}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Text)"})
  public void testVisitWithText_givenNodeGetNextReturnTableNode_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableNode());
    Text text = mock(Text.class);
    when(text.getLiteral()).thenReturn("Literal");
    when(text.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(text);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(text).getFirstChild();
    verify(node).getNext();
    verify(text).getLiteral();
  }

  /**
   * Test {@link MarkdownParser#visit(Text)} with {@code Text}.
   * <ul>
   *   <li>Given {@link Node} {@link Node#getNext()} return {@link TableRowNode} (default constructor).</li>
   *   <li>Then calls {@link Node#accept(Visitor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Text)"})
  public void testVisitWithText_givenNodeGetNextReturnTableRowNode_thenCallsAccept() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Node node = mock(Node.class);
    doNothing().when(node).accept(Mockito.<Visitor>any());
    when(node.getNext()).thenReturn(new TableRowNode());
    Text text = mock(Text.class);
    when(text.getLiteral()).thenReturn("Literal");
    when(text.getFirstChild()).thenReturn(node);

    // Act
    markdownParser.visit(text);

    // Assert
    verify(node).accept(isA(Visitor.class));
    verify(text).getFirstChild();
    verify(node).getNext();
    verify(text).getLiteral();
  }

  /**
   * Test {@link MarkdownParser#visit(Text)} with {@code Text}.
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Text)"})
  public void testVisitWithText_givenPreformattedNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Text text = mock(Text.class);
    when(text.getLiteral()).thenReturn("Literal");
    when(text.getFirstChild()).thenReturn(new PreformattedNode());

    // Act
    markdownParser.visit(text);

    // Assert
    verify(text).getFirstChild();
    verify(text).getLiteral();
  }

  /**
   * Test {@link MarkdownParser#visit(Text)} with {@code Text}.
   * <ul>
   *   <li>Given {@link TableCellNode} (default constructor).</li>
   *   <li>When {@link Text} {@link Node#getFirstChild()} return {@link TableCellNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarkdownParser.visit(Text)"})
  public void testVisitWithText_givenTableCellNode_whenTextGetFirstChildReturnTableCellNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();
    markdownParser.parse("Not all who wander are lost", entities, MissingNode.getInstance());
    Text text = mock(Text.class);
    when(text.getLiteral()).thenReturn("Literal");
    when(text.getFirstChild()).thenReturn(new TableCellNode());

    // Act
    markdownParser.visit(text);

    // Assert
    verify(text).getFirstChild();
    verify(text).getLiteral();
  }

  /**
   * Test {@link MarkdownParser#parse(String, JsonNode, JsonNode)}.
   * <ul>
   *   <li>Then return Children first Text is {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#parse(String, JsonNode, JsonNode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MessageML MarkdownParser.parse(String, JsonNode, JsonNode)"})
  public void testParse_thenReturnChildrenFirstTextIsNotAllWhoWanderAreLost() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();

    // Act
    MessageML actualParseResult = markdownParser.parse("Not all who wander are lost", entities,
        MissingNode.getInstance());

    // Assert
    List<Element> children = actualParseResult.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof TextNode);
    assertEquals("Not all who wander are lost", ((TextNode) getResult).getText());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(1, actualParseResult.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(actualParseResult, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#parse(String, JsonNode, JsonNode)}.
   * <ul>
   *   <li>Then return Children first Text is {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#parse(String, JsonNode, JsonNode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MessageML MarkdownParser.parse(String, JsonNode, JsonNode)"})
  public void testParse_thenReturnChildrenFirstTextIsNotAllWhoWanderAreLost2() throws InvalidInputException {
    // Arrange and Act
    MessageML actualParseResult = (new MarkdownParser(new NoOpDataProvider())).parse("Not all who wander are lost",
        null, null);

    // Assert
    List<Element> children = actualParseResult.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof TextNode);
    assertEquals("Not all who wander are lost", ((TextNode) getResult).getText());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(1, actualParseResult.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(actualParseResult, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#parse(String, JsonNode, JsonNode)}.
   * <ul>
   *   <li>When {@code 2.0}.</li>
   *   <li>Then return Children first Text is {@code 2.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#parse(String, JsonNode, JsonNode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MessageML MarkdownParser.parse(String, JsonNode, JsonNode)"})
  public void testParse_when20_thenReturnChildrenFirstTextIs20() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();

    // Act
    MessageML actualParseResult = markdownParser.parse("2.0", entities, MissingNode.getInstance());

    // Assert
    List<Element> children = actualParseResult.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof TextNode);
    assertEquals("2.0", ((TextNode) getResult).getText());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(1, actualParseResult.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(actualParseResult, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#parse(String, JsonNode, JsonNode)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return PresentationMLTag is {@code div}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkdownParser#parse(String, JsonNode, JsonNode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MessageML MarkdownParser.parse(String, JsonNode, JsonNode)"})
  public void testParse_whenEmptyString_thenReturnPresentationMLTagIsDiv() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();

    // Act
    MessageML actualParseResult = markdownParser.parse("", entities, MissingNode.getInstance());

    // Assert
    assertEquals("div", actualParseResult.getPresentationMLTag());
    assertEquals("messageML", actualParseResult.getMessageMLTag());
    assertNull(actualParseResult.getParent());
    assertEquals(0, actualParseResult.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualParseResult.getFormat());
    assertFalse(actualParseResult.isChime());
    assertTrue(actualParseResult.getChildren().isEmpty());
    assertTrue(actualParseResult.getAttributes().isEmpty());
  }
}
