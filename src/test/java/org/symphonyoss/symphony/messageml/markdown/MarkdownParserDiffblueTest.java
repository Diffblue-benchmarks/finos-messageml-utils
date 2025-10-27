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
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  public void testVisit() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  public void testVisit2() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  public void testVisit3() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  public void testVisit4() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  public void testVisit5() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  public void testVisit6() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  public void testVisit7() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  public void testVisit8() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  public void testVisit9() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  public void testVisit10() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  public void testVisit11() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  public void testVisit12() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  public void testVisit13() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  public void testVisit14() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  public void testVisit15() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  public void testVisit16() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  public void testVisit17() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  public void testVisit18() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  public void testVisit19() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  public void testVisit20() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  public void testVisit21() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  public void testVisit22() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  public void testVisit23() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  public void testVisit24() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  public void testVisit25() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  public void testVisit26() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  public void testVisit27() {
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
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  public void testVisit28() {
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
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  public void testVisit29() {
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
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  public void testVisit30() {
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
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  public void testVisit31() {
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
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  public void testVisit32() {
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
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  public void testVisit33() {
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
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  public void testVisit34() {
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
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  public void testVisit35() {
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
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  public void testVisit36() {
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
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  public void testVisit37() {
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
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  public void testVisit38() {
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
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  public void testVisit39() {
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
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  public void testVisit40() {
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
   * Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  public void testVisit41() {
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
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  public void testVisit42() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  public void testVisit43() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  public void testVisit44() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  public void testVisit45() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  public void testVisit46() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  public void testVisit47() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  public void testVisit48() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  public void testVisit49() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  public void testVisit50() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  public void testVisit51() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  public void testVisit52() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  public void testVisit53() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  public void testVisit54() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  public void testVisit55() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  public void testVisit56() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  public void testVisit57() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  public void testVisit58() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  public void testVisit59() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  public void testVisit60() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  public void testVisit61() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  public void testVisit62() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  public void testVisit63() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  public void testVisit64() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  public void testVisit65() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  public void testVisit66() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  public void testVisit67() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  public void testVisit68() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  public void testVisit69() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  public void testVisit70() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  public void testVisit71() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  public void testVisit72() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  public void testVisit73() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  public void testVisit74() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  public void testVisit75() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  public void testVisit76() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  public void testVisit77() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  public void testVisit78() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  public void testVisit79() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  public void testVisit80() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  public void testVisit81() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  public void testVisit82() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  public void testVisit83() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  public void testVisit84() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  public void testVisit85() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  public void testVisit86() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  public void testVisit87() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  public void testVisit88() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  public void testVisit89() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  public void testVisit90() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  public void testVisit91() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  public void testVisit92() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  public void testVisit93() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  public void testVisit94() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  public void testVisit95() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  public void testVisit96() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  public void testVisit97() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  public void testVisit98() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  public void testVisit99() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  public void testVisit100() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  public void testVisit101() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  public void testVisit102() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  public void testVisit103() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  public void testVisit104() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  public void testVisit105() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  public void testVisit106() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  public void testVisit107() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  public void testVisit108() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  public void testVisit109() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  public void testVisit110() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  public void testVisit111() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  public void testVisit112() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  public void testVisit113() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  public void testVisit114() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  public void testVisit115() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  public void testVisit116() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  public void testVisit117() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  public void testVisit118() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  public void testVisit119() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  public void testVisit120() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  public void testVisit121() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  public void testVisit122() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  public void testVisit123() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  public void testVisit124() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  public void testVisit125() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  public void testVisit126() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  public void testVisit127() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  public void testVisit128() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  public void testVisit129() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  public void testVisit130() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  public void testVisit131() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  public void testVisit132() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  public void testVisit133() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  public void testVisit134() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  public void testVisit135() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  public void testVisit136() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  public void testVisit137() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  public void testVisit138() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  public void testVisit139() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  public void testVisit140() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  public void testVisit141() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  public void testVisit142() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  public void testVisit143() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  public void testVisit144() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  public void testVisit145() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  public void testVisit146() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  public void testVisit147() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  public void testVisit148() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  public void testVisit149() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  public void testVisit150() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  public void testVisit151() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  public void testVisit152() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  public void testVisit153() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  public void testVisit154() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  public void testVisit155() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  public void testVisit156() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  public void testVisit157() throws InvalidInputException {
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
   * Method under test: {@link MarkdownParser#parse(String, JsonNode, JsonNode)}
   */
  @Test
  public void testParse() throws InvalidInputException {
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
    assertEquals("div", actualParseResult.getPresentationMLTag());
    assertEquals("messageML", actualParseResult.getMessageMLTag());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertNull(actualParseResult.getParent());
    assertEquals(0, getResult.size());
    assertEquals(1, actualParseResult.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertEquals(FormatEnum.PRESENTATIONML, actualParseResult.getFormat());
    assertFalse(actualParseResult.isChime());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertTrue(actualParseResult.getAttributes().isEmpty());
    assertSame(actualParseResult, getResult.getParent());
  }

  /**
   * Method under test: {@link MarkdownParser#parse(String, JsonNode, JsonNode)}
   */
  @Test
  public void testParse2() throws InvalidInputException {
    // Arrange and Act
    MessageML actualParseResult = (new MarkdownParser(new NoOpDataProvider())).parse("Not all who wander are lost",
        null, null);

    // Assert
    List<Element> children = actualParseResult.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof TextNode);
    assertEquals("Not all who wander are lost", ((TextNode) getResult).getText());
    assertEquals("div", actualParseResult.getPresentationMLTag());
    assertEquals("messageML", actualParseResult.getMessageMLTag());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertNull(actualParseResult.getParent());
    assertEquals(0, getResult.size());
    assertEquals(1, actualParseResult.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertEquals(FormatEnum.PRESENTATIONML, actualParseResult.getFormat());
    assertFalse(actualParseResult.isChime());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertTrue(actualParseResult.getAttributes().isEmpty());
    assertSame(actualParseResult, getResult.getParent());
  }

  /**
   * Method under test: {@link MarkdownParser#parse(String, JsonNode, JsonNode)}
   */
  @Test
  public void testParse3() throws InvalidInputException {
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
    assertEquals("div", actualParseResult.getPresentationMLTag());
    assertEquals("messageML", actualParseResult.getMessageMLTag());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertNull(actualParseResult.getParent());
    assertEquals(0, getResult.size());
    assertEquals(1, actualParseResult.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertEquals(FormatEnum.PRESENTATIONML, actualParseResult.getFormat());
    assertFalse(actualParseResult.isChime());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertTrue(actualParseResult.getAttributes().isEmpty());
    assertSame(actualParseResult, getResult.getParent());
  }

  /**
   * Method under test: {@link MarkdownParser#parse(String, JsonNode, JsonNode)}
   */
  @Test
  public void testParse4() throws InvalidInputException {
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
