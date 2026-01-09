package org.symphonyoss.symphony.messageml.markdown;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.List;
import java.util.Map;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.CustomBlock;
import org.commonmark.node.CustomNode;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Link;
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.elements.Bold;
import org.symphonyoss.symphony.messageml.elements.CashTag;
import org.symphonyoss.symphony.messageml.elements.Element;
import org.symphonyoss.symphony.messageml.elements.FormatEnum;
import org.symphonyoss.symphony.messageml.elements.HashTag;
import org.symphonyoss.symphony.messageml.elements.Italic;
import org.symphonyoss.symphony.messageml.elements.LineBreak;
import org.symphonyoss.symphony.messageml.elements.Mention;
import org.symphonyoss.symphony.messageml.elements.MessageML;
import org.symphonyoss.symphony.messageml.elements.Table;
import org.symphonyoss.symphony.messageml.elements.TableCell;
import org.symphonyoss.symphony.messageml.elements.TableRow;
import org.symphonyoss.symphony.messageml.elements.TextNode;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.EmojiNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.KeywordNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.MentionNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.PreformattedNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableCellNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.TableRowNode;
import org.symphonyoss.symphony.messageml.util.IDataProvider;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;

public class MarkdownParserDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MarkdownParser#MarkdownParser(IDataProvider)}
   *   <li>{@link MarkdownParser#getDataProvider()}
   *   <li>{@link MarkdownParser#getIndex()}
   *   <li>{@link MarkdownParser#getMessageML()}
   *   <li>{@link MarkdownParser#getParent()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MarkdownParser.<init>(IDataProvider)",
    "IDataProvider MarkdownParser.getDataProvider()",
    "int MarkdownParser.getIndex()",
    "MessageML MarkdownParser.getMessageML()",
    "Element MarkdownParser.getParent()"
  })
  public void testGettersAndSetters() {
    // Arrange
    NoOpDataProvider dataProvider = new NoOpDataProvider();

    // Act
    MarkdownParser actualMarkdownParser = new MarkdownParser(dataProvider);
    IDataProvider actualDataProvider = actualMarkdownParser.getDataProvider();
    int actualIndex = actualMarkdownParser.getIndex();
    MessageML actualMessageML = actualMarkdownParser.getMessageML();

    // Assert
    assertTrue(actualDataProvider instanceof NoOpDataProvider);
    assertNull(actualMarkdownParser.getParent());
    assertNull(actualMessageML);
    assertEquals(0, actualIndex);
    assertSame(dataProvider, actualDataProvider);
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    BulletList ul = new BulletList();
    ul.appendChild(new TableCellNode());

    // Act
    markdownParser.visit(ul);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.BulletList);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof TableCell);
    assertEquals("td", getResult2.getMessageMLTag());
    assertEquals("td", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList2() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    BulletList ul = new BulletList();
    ul.appendChild(new TableNode());

    // Act
    markdownParser.visit(ul);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.BulletList);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof Table);
    assertEquals("table", getResult2.getMessageMLTag());
    assertEquals("table", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList3() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    BulletList ul = new BulletList();
    ul.appendChild(new TableRowNode());

    // Act
    markdownParser.visit(ul);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.BulletList);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof TableRow);
    assertEquals("tr", getResult2.getMessageMLTag());
    assertEquals("tr", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList4() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    BulletList child = new BulletList();
    child.appendChild(new EmojiNode());

    BulletList ul = new BulletList();
    ul.appendChild(child);

    // Act
    markdownParser.visit(ul);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof org.symphonyoss.symphony.messageml.elements.BulletList);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.BulletList);
    assertEquals("ul", getResult2.getMessageMLTag());
    assertEquals("ul", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList5() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Code child = new Code("Literal");
    child.appendChild(new EmojiNode());

    BulletList ul = new BulletList();
    ul.appendChild(child);

    // Act
    markdownParser.visit(ul);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.BulletList);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children3 = getResult2.getChildren();
    assertEquals(1, children3.size());
    assertTrue(children3.get(0) instanceof TextNode);
    assertEquals("code", getResult2.getMessageMLTag());
    assertEquals("code", getResult2.getPresentationMLTag());
    assertEquals(1, getResult2.size());
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList6() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Document child = new Document();
    child.appendChild(new EmojiNode());

    BulletList ul = new BulletList();
    ul.appendChild(child);

    // Act
    markdownParser.visit(ul);

    // Assert
    Element parent = markdownParser.getParent();
    assertTrue(parent instanceof MessageML);
    assertEquals("div", parent.getPresentationMLTag());
    assertEquals("messageML", parent.getMessageMLTag());
    assertNull(parent.getParent());
    MessageML messageML = markdownParser.getMessageML();
    assertEquals(0, messageML.size());
    assertEquals(2, parent.getChildren().size());
    assertEquals(2, parent.size());
    assertEquals(FormatEnum.PRESENTATIONML, parent.getFormat());
    assertFalse(((MessageML) parent).isChime());
    assertTrue(messageML.getChildren().isEmpty());
    assertTrue(parent.getAttributes().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList7() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Emphasis child = new Emphasis();
    child.appendChild(new EmojiNode());

    BulletList ul = new BulletList();
    ul.appendChild(child);

    // Act
    markdownParser.visit(ul);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.BulletList);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof Italic);
    assertEquals("i", getResult2.getMessageMLTag());
    assertEquals("i", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList8() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    FencedCodeBlock child = new FencedCodeBlock();
    child.setLiteral("ul");
    child.appendChild(new EmojiNode());

    BulletList ul = new BulletList();
    ul.appendChild(child);

    // Act
    markdownParser.visit(ul);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.BulletList);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof TextNode);
    assertEquals("ul", ((TextNode) getResult2).getText());
    assertNull(getResult2.getMessageMLTag());
    assertNull(getResult2.getPresentationMLTag());
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList9() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    HardLineBreak child = new HardLineBreak();
    child.appendChild(new EmojiNode());

    BulletList ul = new BulletList();
    ul.appendChild(child);

    // Act
    markdownParser.visit(ul);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.BulletList);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof LineBreak);
    assertEquals("br", getResult2.getMessageMLTag());
    assertEquals("br", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   *
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList_givenBlockQuoteAppendChildEmojiNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    BlockQuote child = new BlockQuote();
    child.appendChild(new EmojiNode());

    BulletList ul = new BulletList();
    ul.appendChild(child);

    // Act
    markdownParser.visit(ul);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.BulletList);
    assertEquals("ul", getResult.getMessageMLTag());
    assertEquals("ul", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
    assertSame(messageML, markdownParser.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   *
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.
   *   <li>When {@link BulletList} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList_givenEmojiNode_whenBulletListAppendChildEmojiNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    BulletList ul = new BulletList();
    ul.appendChild(new EmojiNode());

    // Act
    markdownParser.visit(ul);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.BulletList);
    assertEquals("ul", getResult.getMessageMLTag());
    assertEquals("ul", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
    assertSame(messageML, markdownParser.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   *
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList_givenPreformattedNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    BulletList ul = new BulletList();
    ul.appendChild(new PreformattedNode());

    // Act
    markdownParser.visit(ul);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.BulletList);
    assertEquals("ul", getResult.getMessageMLTag());
    assertEquals("ul", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
    assertSame(messageML, markdownParser.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(BulletList)} with {@code BulletList}.
   *
   * <ul>
   *   <li>When {@link BulletList} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(BulletList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(BulletList)"})
  public void testVisitWithBulletList_whenBulletList() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Act
    markdownParser.visit(new BulletList());

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.BulletList);
    assertEquals("ul", getResult.getMessageMLTag());
    assertEquals("ul", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
    assertSame(messageML, markdownParser.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(Code)} with {@code Code}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Code)"})
  public void testVisitWithCode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Code code = new Code();
    code.setLiteral("Literal");

    // Act
    markdownParser.visit(code);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    assertTrue(children2.get(0) instanceof TextNode);
    assertEquals("code", getResult.getMessageMLTag());
    assertEquals("code", getResult.getPresentationMLTag());
    assertEquals(1, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(Code)} with {@code Code}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Code)"})
  public void testVisitWithCode2() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Code child = new Code("Literal");
    child.appendChild(new EmojiNode());

    Code code = new Code();
    code.appendChild(child);
    code.setLiteral("Literal");

    // Act
    markdownParser.visit(code);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    List<Element> children2 = getResult.getChildren();
    assertEquals(2, children2.size());
    Element getResult2 = children2.get(1);
    assertTrue(getResult2 instanceof org.symphonyoss.symphony.messageml.elements.Code);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children3 = getResult2.getChildren();
    assertEquals(1, children3.size());
    assertTrue(children3.get(0) instanceof TextNode);
    assertEquals("code", getResult2.getMessageMLTag());
    assertEquals("code", getResult2.getPresentationMLTag());
    assertEquals(1, getResult2.size());
  }

  /**
   * Test {@link MarkdownParser#visit(Code)} with {@code Code}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Code)"})
  public void testVisitWithCode3() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Emphasis child = new Emphasis();
    child.appendChild(new EmojiNode());

    Code code = new Code();
    code.appendChild(child);
    code.setLiteral("Literal");

    // Act
    markdownParser.visit(code);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children2 = getResult.getChildren();
    assertEquals(2, children2.size());
    Element getResult2 = children2.get(1);
    assertTrue(getResult2 instanceof Italic);
    assertEquals("i", getResult2.getMessageMLTag());
    assertEquals("i", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Code)} with {@code Code}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Code)"})
  public void testVisitWithCode4() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    HardLineBreak child = new HardLineBreak();
    child.appendChild(new EmojiNode());

    Code code = new Code();
    code.appendChild(child);
    code.setLiteral("Literal");

    // Act
    markdownParser.visit(code);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children2 = getResult.getChildren();
    assertEquals(2, children2.size());
    Element getResult2 = children2.get(1);
    assertTrue(getResult2 instanceof LineBreak);
    assertEquals("br", getResult2.getMessageMLTag());
    assertEquals("br", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Code)} with {@code Code}.
   *
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.
   *   <li>When {@link Code#Code()} appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(Code)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Code)"})
  public void testVisitWithCode_givenEmojiNode_whenCodeAppendChildEmojiNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Code code = new Code();
    code.appendChild(new EmojiNode());
    code.setLiteral("Literal");

    // Act
    markdownParser.visit(code);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    assertTrue(children2.get(0) instanceof TextNode);
    assertEquals("code", getResult.getMessageMLTag());
    assertEquals("code", getResult.getPresentationMLTag());
    assertEquals(1, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(CustomBlock)"})
  public void testVisitWithCustomBlock() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Act
    markdownParser.visit(new TableNode());

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof Table);
    assertEquals("table", getResult.getMessageMLTag());
    assertEquals("table", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(CustomBlock)"})
  public void testVisitWithCustomBlock2() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Act
    markdownParser.visit(new TableRowNode());

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof TableRow);
    assertEquals("tr", getResult.getMessageMLTag());
    assertEquals("tr", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(CustomBlock)} with {@code CustomBlock}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(CustomBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(CustomBlock)"})
  public void testVisitWithCustomBlock3() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Act
    markdownParser.visit(new TableCellNode());

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof TableCell);
    assertEquals("td", getResult.getMessageMLTag());
    assertEquals("td", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(CustomNode)} with {@code CustomNode}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(CustomNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(CustomNode)"})
  public void testVisitWithCustomNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Act
    markdownParser.visit(new KeywordNode("#", "Text"));

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof HashTag);
    assertEquals("Text", ((HashTag) getResult).getTag());
    assertEquals(
        "[\\S]*[^\\s!@#$%^&*()+=<>,./?`~:;'\"\\\\|-]+[\\S]*$",
        ((HashTag) getResult).getTagPattern());
    assertEquals("hash", getResult.getMessageMLTag());
  }

  /**
   * Test {@link MarkdownParser#visit(CustomNode)} with {@code CustomNode}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(CustomNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(CustomNode)"})
  public void testVisitWithCustomNode2() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Act
    markdownParser.visit(new KeywordNode("hash", "Text"));

    // Assert that nothing has changed
    assertEquals(1, markdownParser.getMessageML().getChildren().size());
  }

  /**
   * Test {@link MarkdownParser#visit(CustomNode)} with {@code CustomNode}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(CustomNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(CustomNode)"})
  public void testVisitWithCustomNode3() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Act
    markdownParser.visit(new KeywordNode("$", "Text"));

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof CashTag);
    assertEquals("Text", ((CashTag) getResult).getTag());
    assertEquals("cash", getResult.getMessageMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(CustomNode)} with {@code CustomNode}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(CustomNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(CustomNode)"})
  public void testVisitWithCustomNode4() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Act
    markdownParser.visit(new MentionNode(1L));

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof Mention);
    assertEquals("mention", getResult.getMessageMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(CustomNode)} with {@code CustomNode}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(CustomNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(CustomNode)"})
  public void testVisitWithCustomNode5() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Code child = new Code("Literal");
    child.appendChild(new EmojiNode());

    MentionNode node = new MentionNode(1L);
    node.appendChild(child);

    // Act
    markdownParser.visit(node);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof org.symphonyoss.symphony.messageml.elements.Code);
    assertTrue(getResult instanceof Mention);
    List<Element> children3 = getResult2.getChildren();
    assertEquals(1, children3.size());
    assertTrue(children3.get(0) instanceof TextNode);
    assertEquals("code", getResult2.getMessageMLTag());
    assertEquals("code", getResult2.getPresentationMLTag());
    assertEquals(1, getResult2.size());
  }

  /**
   * Test {@link MarkdownParser#visit(CustomNode)} with {@code CustomNode}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(CustomNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(CustomNode)"})
  public void testVisitWithCustomNode6() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Emphasis child = new Emphasis();
    child.appendChild(new EmojiNode());

    MentionNode node = new MentionNode(1L);
    node.appendChild(child);

    // Act
    markdownParser.visit(node);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof Italic);
    assertTrue(getResult instanceof Mention);
    assertEquals("i", getResult2.getMessageMLTag());
    assertEquals("i", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(CustomNode)} with {@code CustomNode}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(CustomNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(CustomNode)"})
  public void testVisitWithCustomNode7() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    HardLineBreak child = new HardLineBreak();
    child.appendChild(new EmojiNode());

    MentionNode node = new MentionNode(1L);
    node.appendChild(child);

    // Act
    markdownParser.visit(node);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof LineBreak);
    assertTrue(getResult instanceof Mention);
    assertEquals("br", getResult2.getMessageMLTag());
    assertEquals("br", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(CustomNode)} with {@code CustomNode}.
   *
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(CustomNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(CustomNode)"})
  public void testVisitWithCustomNode_givenEmojiNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    MentionNode node = new MentionNode(1L);
    node.appendChild(new EmojiNode());

    // Act
    markdownParser.visit(node);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof Mention);
    assertEquals("mention", getResult.getMessageMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    Document document = new Document();
    document.appendChild(new TableCellNode());

    // Act
    markdownParser.visit(document);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof TableCell);
    assertEquals("td", getResult.getMessageMLTag());
    assertEquals("td", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument2() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    Document document = new Document();
    document.appendChild(new TableNode());

    // Act
    markdownParser.visit(document);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof Table);
    assertEquals("table", getResult.getMessageMLTag());
    assertEquals("table", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument3() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    Document document = new Document();
    document.appendChild(new TableRowNode());

    // Act
    markdownParser.visit(document);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof TableRow);
    assertEquals("tr", getResult.getMessageMLTag());
    assertEquals("tr", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument4() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    BulletList child = new BulletList();
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownParser.visit(document);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.BulletList);
    assertEquals("ul", getResult.getMessageMLTag());
    assertEquals("ul", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument5() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    Code child = new Code("Literal");
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownParser.visit(document);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof TextNode);
    assertEquals("Literal", ((TextNode) getResult2).getText());
    assertNull(getResult2.getMessageMLTag());
    assertNull(getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult2.getFormat());
    assertTrue(getResult2.getChildren().isEmpty());
    assertTrue(getResult2.getAttributes().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument6() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    Emphasis child = new Emphasis();
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownParser.visit(document);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof Italic);
    assertEquals("i", getResult.getMessageMLTag());
    assertEquals("i", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument7() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    FencedCodeBlock child = new FencedCodeBlock();
    child.setLiteral("2.0");
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownParser.visit(document);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof TextNode);
    assertEquals("2.0", ((TextNode) getResult).getText());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument8() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    HardLineBreak child = new HardLineBreak();
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownParser.visit(document);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof LineBreak);
    assertEquals("br", getResult.getMessageMLTag());
    assertEquals("br", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument9() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    FencedCodeBlock child = new FencedCodeBlock();
    child.setLiteral("2.0");
    child.setFenceChar('`');
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownParser.visit(document);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof TextNode);
    assertEquals("2.0", ((TextNode) getResult).getText());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument10() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    FencedCodeBlock child = new FencedCodeBlock();
    child.setLiteral("2.0");
    child.setFenceLength(3);
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownParser.visit(document);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof TextNode);
    assertEquals("\u0000\u0000\u00002.0\u0000\u0000\u0000", ((TextNode) getResult).getText());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument11() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    FencedCodeBlock child = new FencedCodeBlock();
    child.setLiteral("2.0");
    child.setFenceLength(3);
    child.setFenceChar('`');
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownParser.visit(document);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    assertEquals("code", getResult.getMessageMLTag());
    assertEquals("code", getResult.getPresentationMLTag());
    Map<String, String> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertNull(attributes.get("data-language"));
    assertEquals(1, getResult.size());
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument12() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    FencedCodeBlock child = new FencedCodeBlock();
    child.setLiteral("2.0");
    child.setInfo("2.0");
    child.setFenceLength(3);
    child.setFenceChar('`');
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownParser.visit(document);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    Map<String, String> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("2.0", attributes.get("data-language"));
    assertEquals("code", getResult.getMessageMLTag());
    assertEquals("code", getResult.getPresentationMLTag());
    assertEquals(1, getResult.size());
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenBlockQuoteAppendChildEmojiNode() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    BlockQuote child = new BlockQuote();
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownParser.visit(document);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    assertEquals("div", messageML.getPresentationMLTag());
    assertEquals("messageML", messageML.getMessageMLTag());
    assertNull(messageML.getParent());
    assertEquals(0, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, messageML.getFormat());
    assertFalse(messageML.isChime());
    assertTrue(messageML.getChildren().isEmpty());
    assertTrue(messageML.getAttributes().isEmpty());
    assertSame(messageML, markdownParser.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>Given {@link Document} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenDocumentAppendChildEmojiNode() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    Document child = new Document();
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownParser.visit(document);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    assertEquals("div", messageML.getPresentationMLTag());
    assertEquals("messageML", messageML.getMessageMLTag());
    assertNull(messageML.getParent());
    assertEquals(0, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, messageML.getFormat());
    assertFalse(messageML.isChime());
    assertTrue(messageML.getChildren().isEmpty());
    assertTrue(messageML.getAttributes().isEmpty());
    assertSame(messageML, markdownParser.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.
   *   <li>When {@link Document} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenEmojiNode_whenDocumentAppendChildEmojiNode() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    Document document = new Document();
    document.appendChild(new EmojiNode());

    // Act
    markdownParser.visit(document);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    assertEquals("div", messageML.getPresentationMLTag());
    assertEquals("messageML", messageML.getMessageMLTag());
    assertNull(messageML.getParent());
    assertEquals(0, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, messageML.getFormat());
    assertFalse(messageML.isChime());
    assertTrue(messageML.getChildren().isEmpty());
    assertTrue(messageML.getAttributes().isEmpty());
    assertSame(messageML, markdownParser.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>Given {@link FencedCodeBlock} (default constructor) Info is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenFencedCodeBlockInfoIsEmptyString() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    FencedCodeBlock child = new FencedCodeBlock();
    child.setLiteral("2.0");
    child.setInfo("");
    child.setFenceLength(3);
    child.setFenceChar('`');
    child.appendChild(new EmojiNode());

    Document document = new Document();
    document.appendChild(child);

    // Act
    markdownParser.visit(document);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    assertEquals("code", getResult.getMessageMLTag());
    assertEquals("code", getResult.getPresentationMLTag());
    Map<String, String> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertNull(attributes.get("data-language"));
    assertEquals(1, getResult.size());
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_givenPreformattedNode() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    Document document = new Document();
    document.appendChild(new PreformattedNode());

    // Act
    markdownParser.visit(document);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    assertEquals("div", messageML.getPresentationMLTag());
    assertEquals("messageML", messageML.getMessageMLTag());
    assertNull(messageML.getParent());
    assertEquals(0, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, messageML.getFormat());
    assertFalse(messageML.isChime());
    assertTrue(messageML.getChildren().isEmpty());
    assertTrue(messageML.getAttributes().isEmpty());
    assertSame(messageML, markdownParser.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(Document)} with {@code Document}.
   *
   * <ul>
   *   <li>When {@link Document} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(Document)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Document)"})
  public void testVisitWithDocument_whenDocument() {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());

    // Act
    markdownParser.visit(new Document());

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    assertEquals("div", messageML.getPresentationMLTag());
    assertEquals("messageML", messageML.getMessageMLTag());
    assertNull(messageML.getParent());
    assertEquals(0, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, messageML.getFormat());
    assertFalse(messageML.isChime());
    assertTrue(messageML.getChildren().isEmpty());
    assertTrue(messageML.getAttributes().isEmpty());
    assertSame(messageML, markdownParser.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(Emphasis)} with {@code Emphasis}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Emphasis)"})
  public void testVisitWithEmphasis() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Act
    markdownParser.visit(new Emphasis());

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof Italic);
    assertEquals("i", getResult.getMessageMLTag());
    assertEquals("i", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(Emphasis)} with {@code Emphasis}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Emphasis)"})
  public void testVisitWithEmphasis2() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Code child = new Code("Literal");
    child.appendChild(new EmojiNode());

    Emphasis em = new Emphasis();
    em.appendChild(child);

    // Act
    markdownParser.visit(em);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof org.symphonyoss.symphony.messageml.elements.Code);
    assertTrue(getResult instanceof Italic);
    List<Element> children3 = getResult2.getChildren();
    assertEquals(1, children3.size());
    assertTrue(children3.get(0) instanceof TextNode);
    assertEquals("code", getResult2.getMessageMLTag());
    assertEquals("code", getResult2.getPresentationMLTag());
    assertEquals(1, getResult2.size());
  }

  /**
   * Test {@link MarkdownParser#visit(Emphasis)} with {@code Emphasis}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Emphasis)"})
  public void testVisitWithEmphasis3() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Emphasis child = new Emphasis();
    child.appendChild(new EmojiNode());

    Emphasis em = new Emphasis();
    em.appendChild(child);

    // Act
    markdownParser.visit(em);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof Italic);
    assertTrue(getResult instanceof Italic);
    assertEquals("i", getResult2.getMessageMLTag());
    assertEquals("i", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Emphasis)} with {@code Emphasis}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Emphasis)"})
  public void testVisitWithEmphasis4() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    HardLineBreak child = new HardLineBreak();
    child.appendChild(new EmojiNode());

    Emphasis em = new Emphasis();
    em.appendChild(child);

    // Act
    markdownParser.visit(em);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof Italic);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof LineBreak);
    assertEquals("br", getResult2.getMessageMLTag());
    assertEquals("br", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Emphasis)} with {@code Emphasis}.
   *
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.
   *   <li>When {@link Emphasis#Emphasis()} appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(Emphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Emphasis)"})
  public void testVisitWithEmphasis_givenEmojiNode_whenEmphasisAppendChildEmojiNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Emphasis em = new Emphasis();
    em.appendChild(new EmojiNode());

    // Act
    markdownParser.visit(em);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof Italic);
    assertEquals("i", getResult.getMessageMLTag());
    assertEquals("i", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(FencedCodeBlock)} with {@code FencedCodeBlock}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(FencedCodeBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(FencedCodeBlock)"})
  public void testVisitWithFencedCodeBlock() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    FencedCodeBlock code = new FencedCodeBlock();
    code.setLiteral("42");

    // Act
    markdownParser.visit(code);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof TextNode);
    assertEquals("42", ((TextNode) getResult).getText());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(FencedCodeBlock)} with {@code FencedCodeBlock}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(FencedCodeBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(FencedCodeBlock)"})
  public void testVisitWithFencedCodeBlock2() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    FencedCodeBlock code = new FencedCodeBlock();
    code.setFenceChar('`');
    code.setLiteral("42");

    // Act
    markdownParser.visit(code);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof TextNode);
    assertEquals("42", ((TextNode) getResult).getText());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(FencedCodeBlock)} with {@code FencedCodeBlock}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(FencedCodeBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(FencedCodeBlock)"})
  public void testVisitWithFencedCodeBlock3() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    FencedCodeBlock code = new FencedCodeBlock();
    code.setFenceLength(3);
    code.setLiteral("42");

    // Act
    markdownParser.visit(code);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof TextNode);
    assertEquals("\u0000\u0000\u000042\u0000\u0000\u0000", ((TextNode) getResult).getText());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(FencedCodeBlock)} with {@code FencedCodeBlock}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(FencedCodeBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(FencedCodeBlock)"})
  public void testVisitWithFencedCodeBlock4() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    FencedCodeBlock code = new FencedCodeBlock();
    code.setFenceLength(3);
    code.setFenceChar('`');
    code.setLiteral("42");

    // Act
    markdownParser.visit(code);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    assertTrue(children2.get(0) instanceof TextNode);
    assertEquals("code", getResult.getMessageMLTag());
    assertEquals("code", getResult.getPresentationMLTag());
    Map<String, String> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertNull(attributes.get("data-language"));
    assertEquals(1, getResult.size());
  }

  /**
   * Test {@link MarkdownParser#visit(FencedCodeBlock)} with {@code FencedCodeBlock}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(FencedCodeBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(FencedCodeBlock)"})
  public void testVisitWithFencedCodeBlock5() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    FencedCodeBlock code = new FencedCodeBlock();
    code.setInfo("code");
    code.appendChild(new EmojiNode());
    code.setFenceLength(3);
    code.setFenceChar('`');
    code.setLiteral("42");

    // Act
    markdownParser.visit(code);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    assertTrue(children2.get(0) instanceof TextNode);
    Map<String, String> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("code", attributes.get("data-language"));
    assertEquals("code", getResult.getMessageMLTag());
    assertEquals("code", getResult.getPresentationMLTag());
    assertEquals(1, getResult.size());
  }

  /**
   * Test {@link MarkdownParser#visit(FencedCodeBlock)} with {@code FencedCodeBlock}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(FencedCodeBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(FencedCodeBlock)"})
  public void testVisitWithFencedCodeBlock6() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    FencedCodeBlock code = new FencedCodeBlock();
    code.appendChild(new TableCellNode());
    code.setFenceLength(3);
    code.setFenceChar('`');
    code.setLiteral("42");

    // Act
    markdownParser.visit(code);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children2 = getResult.getChildren();
    assertEquals(2, children2.size());
    Element getResult2 = children2.get(1);
    assertTrue(getResult2 instanceof TableCell);
    assertEquals("td", getResult2.getMessageMLTag());
    assertEquals("td", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertEquals(2, getResult.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult2.getFormat());
    assertTrue(getResult2.getChildren().isEmpty());
    assertTrue(getResult2.getAttributes().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(FencedCodeBlock)} with {@code FencedCodeBlock}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(FencedCodeBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(FencedCodeBlock)"})
  public void testVisitWithFencedCodeBlock7() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    FencedCodeBlock code = new FencedCodeBlock();
    code.appendChild(new TableNode());
    code.setFenceLength(3);
    code.setFenceChar('`');
    code.setLiteral("42");

    // Act
    markdownParser.visit(code);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children2 = getResult.getChildren();
    assertEquals(2, children2.size());
    Element getResult2 = children2.get(1);
    assertTrue(getResult2 instanceof Table);
    assertEquals("table", getResult2.getMessageMLTag());
    assertEquals("table", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertEquals(2, getResult.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult2.getFormat());
    assertTrue(getResult2.getChildren().isEmpty());
    assertTrue(getResult2.getAttributes().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(FencedCodeBlock)} with {@code FencedCodeBlock}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(FencedCodeBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(FencedCodeBlock)"})
  public void testVisitWithFencedCodeBlock8() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    FencedCodeBlock code = new FencedCodeBlock();
    code.appendChild(new TableRowNode());
    code.setFenceLength(3);
    code.setFenceChar('`');
    code.setLiteral("42");

    // Act
    markdownParser.visit(code);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children2 = getResult.getChildren();
    assertEquals(2, children2.size());
    Element getResult2 = children2.get(1);
    assertTrue(getResult2 instanceof TableRow);
    assertEquals("tr", getResult2.getMessageMLTag());
    assertEquals("tr", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertEquals(2, getResult.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult2.getFormat());
    assertTrue(getResult2.getChildren().isEmpty());
    assertTrue(getResult2.getAttributes().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(FencedCodeBlock)} with {@code FencedCodeBlock}.
   *
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(FencedCodeBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(FencedCodeBlock)"})
  public void testVisitWithFencedCodeBlock_givenEmojiNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    FencedCodeBlock code = new FencedCodeBlock();
    code.appendChild(new EmojiNode());
    code.setFenceLength(3);
    code.setFenceChar('`');
    code.setLiteral("42");

    // Act
    markdownParser.visit(code);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    assertTrue(children2.get(0) instanceof TextNode);
    assertEquals("code", getResult.getMessageMLTag());
    assertEquals("code", getResult.getPresentationMLTag());
    Map<String, String> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertNull(attributes.get("data-language"));
    assertEquals(1, getResult.size());
  }

  /**
   * Test {@link MarkdownParser#visit(FencedCodeBlock)} with {@code FencedCodeBlock}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(FencedCodeBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(FencedCodeBlock)"})
  public void testVisitWithFencedCodeBlock_givenEmptyString() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    FencedCodeBlock code = new FencedCodeBlock();
    code.setInfo("");
    code.appendChild(new EmojiNode());
    code.setFenceLength(3);
    code.setFenceChar('`');
    code.setLiteral("42");

    // Act
    markdownParser.visit(code);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    assertTrue(children2.get(0) instanceof TextNode);
    assertEquals("code", getResult.getMessageMLTag());
    assertEquals("code", getResult.getPresentationMLTag());
    Map<String, String> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertNull(attributes.get("data-language"));
    assertEquals(1, getResult.size());
  }

  /**
   * Test {@link MarkdownParser#visit(FencedCodeBlock)} with {@code FencedCodeBlock}.
   *
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(FencedCodeBlock)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(FencedCodeBlock)"})
  public void testVisitWithFencedCodeBlock_givenPreformattedNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    FencedCodeBlock code = new FencedCodeBlock();
    code.appendChild(new PreformattedNode());
    code.setFenceLength(3);
    code.setFenceChar('`');
    code.setLiteral("42");

    // Act
    markdownParser.visit(code);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    assertTrue(children2.get(0) instanceof TextNode);
    assertEquals("code", getResult.getMessageMLTag());
    assertEquals("code", getResult.getPresentationMLTag());
    Map<String, String> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertNull(attributes.get("data-language"));
    assertEquals(1, getResult.size());
  }

  /**
   * Test {@link MarkdownParser#visit(HardLineBreak)} with {@code HardLineBreak}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(HardLineBreak)"})
  public void testVisitWithHardLineBreak() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Act
    markdownParser.visit(new HardLineBreak());

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof LineBreak);
    assertEquals("br", getResult.getMessageMLTag());
    assertEquals("br", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(HardLineBreak)} with {@code HardLineBreak}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(HardLineBreak)"})
  public void testVisitWithHardLineBreak2() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Code child = new Code("Literal");
    child.appendChild(new EmojiNode());

    HardLineBreak hardLineBreak = new HardLineBreak();
    hardLineBreak.appendChild(child);

    // Act
    markdownParser.visit(hardLineBreak);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(3, children.size());
    Element getResult = children.get(2);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof TextNode);
    assertEquals("Literal", ((TextNode) getResult2).getText());
    assertEquals("code", getResult.getMessageMLTag());
    assertEquals("code", getResult.getPresentationMLTag());
    assertNull(getResult2.getMessageMLTag());
    assertNull(getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertEquals(1, getResult.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult2.getFormat());
    assertTrue(getResult2.getChildren().isEmpty());
    assertTrue(getResult2.getAttributes().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(HardLineBreak)} with {@code HardLineBreak}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(HardLineBreak)"})
  public void testVisitWithHardLineBreak3() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Emphasis child = new Emphasis();
    child.appendChild(new EmojiNode());

    HardLineBreak hardLineBreak = new HardLineBreak();
    hardLineBreak.appendChild(child);

    // Act
    markdownParser.visit(hardLineBreak);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(3, children.size());
    Element getResult = children.get(2);
    assertTrue(getResult instanceof Italic);
    assertEquals("i", getResult.getMessageMLTag());
    assertEquals("i", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(HardLineBreak)} with {@code HardLineBreak}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(HardLineBreak)"})
  public void testVisitWithHardLineBreak4() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    HardLineBreak child = new HardLineBreak();
    child.appendChild(new EmojiNode());

    HardLineBreak hardLineBreak = new HardLineBreak();
    hardLineBreak.appendChild(child);

    // Act
    markdownParser.visit(hardLineBreak);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(3, children.size());
    Element getResult = children.get(2);
    assertTrue(getResult instanceof LineBreak);
    assertEquals("br", getResult.getMessageMLTag());
    assertEquals("br", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(HardLineBreak)} with {@code HardLineBreak}.
   *
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.
   *   <li>When {@link HardLineBreak} (default constructor) appendChild {@link
   *       EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(HardLineBreak)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(HardLineBreak)"})
  public void testVisitWithHardLineBreak_givenEmojiNode_whenHardLineBreakAppendChildEmojiNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    HardLineBreak hardLineBreak = new HardLineBreak();
    hardLineBreak.appendChild(new EmojiNode());

    // Act
    markdownParser.visit(hardLineBreak);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof LineBreak);
    assertEquals("br", getResult.getMessageMLTag());
    assertEquals("br", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(HtmlInline)} with {@code HtmlInline}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(HtmlInline)"})
  public void testVisitWithHtmlInline() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Act
    markdownParser.visit(new HtmlInline());

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof TextNode);
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertNull(((TextNode) getResult).getText());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(HtmlInline)} with {@code HtmlInline}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(HtmlInline)"})
  public void testVisitWithHtmlInline2() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Code child = new Code("Literal");
    child.appendChild(new EmojiNode());

    HtmlInline tag = new HtmlInline();
    tag.appendChild(child);

    // Act
    markdownParser.visit(tag);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(3, children.size());
    Element getResult = children.get(2);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof TextNode);
    assertEquals("Literal", ((TextNode) getResult2).getText());
    assertEquals("code", getResult.getMessageMLTag());
    assertEquals("code", getResult.getPresentationMLTag());
    assertNull(getResult2.getMessageMLTag());
    assertNull(getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertEquals(1, getResult.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult2.getFormat());
    assertTrue(getResult2.getChildren().isEmpty());
    assertTrue(getResult2.getAttributes().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(HtmlInline)} with {@code HtmlInline}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(HtmlInline)"})
  public void testVisitWithHtmlInline3() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Emphasis child = new Emphasis();
    child.appendChild(new EmojiNode());

    HtmlInline tag = new HtmlInline();
    tag.appendChild(child);

    // Act
    markdownParser.visit(tag);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(3, children.size());
    Element getResult = children.get(2);
    assertTrue(getResult instanceof Italic);
    assertEquals("i", getResult.getMessageMLTag());
    assertEquals("i", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(HtmlInline)} with {@code HtmlInline}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(HtmlInline)"})
  public void testVisitWithHtmlInline4() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    HardLineBreak child = new HardLineBreak();
    child.appendChild(new EmojiNode());

    HtmlInline tag = new HtmlInline();
    tag.appendChild(child);

    // Act
    markdownParser.visit(tag);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(3, children.size());
    Element getResult = children.get(2);
    assertTrue(getResult instanceof LineBreak);
    assertEquals("br", getResult.getMessageMLTag());
    assertEquals("br", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(HtmlInline)} with {@code HtmlInline}.
   *
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.
   *   <li>When {@link HtmlInline} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(HtmlInline)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(HtmlInline)"})
  public void testVisitWithHtmlInline_givenEmojiNode_whenHtmlInlineAppendChildEmojiNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    HtmlInline tag = new HtmlInline();
    tag.appendChild(new EmojiNode());

    // Act
    markdownParser.visit(tag);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof TextNode);
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertNull(((TextNode) getResult).getText());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Act
    markdownParser.visit(new Link());

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof TextNode);
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertNull(((TextNode) getResult).getText());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink2() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Link a = new Link();
    a.setDestination("a");

    // Act
    markdownParser.visit(a);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof TextNode);
    assertEquals("a", ((TextNode) getResult).getText());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink3() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Link a = new Link();
    a.setDestination("The attribute \"href\" must contain an absolute URI");

    // Act
    markdownParser.visit(a);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof TextNode);
    assertEquals(
        "The attribute \"href\" must contain an absolute URI", ((TextNode) getResult).getText());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink4() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Link a = new Link();
    a.setDestination("");

    // Act
    markdownParser.visit(a);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof TextNode);
    assertEquals("", ((TextNode) getResult).getText());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink5() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Code child = new Code("Literal");
    child.appendChild(new EmojiNode());

    Link a = new Link();
    a.appendChild(child);

    // Act
    markdownParser.visit(a);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children3 = getResult2.getChildren();
    assertEquals(1, children3.size());
    assertTrue(children3.get(0) instanceof TextNode);
    assertTrue(getResult instanceof TextNode);
    assertEquals("code", getResult2.getMessageMLTag());
    assertEquals("code", getResult2.getPresentationMLTag());
    assertEquals(1, getResult2.size());
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink6() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Emphasis child = new Emphasis();
    child.appendChild(new EmojiNode());

    Link a = new Link();
    a.appendChild(child);

    // Act
    markdownParser.visit(a);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof Italic);
    assertTrue(getResult instanceof TextNode);
    assertEquals("i", getResult2.getMessageMLTag());
    assertEquals("i", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink7() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    HardLineBreak child = new HardLineBreak();
    child.appendChild(new EmojiNode());

    Link a = new Link();
    a.appendChild(child);

    // Act
    markdownParser.visit(a);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof LineBreak);
    assertTrue(getResult instanceof TextNode);
    assertEquals("br", getResult2.getMessageMLTag());
    assertEquals("br", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Link)} with {@code Link}.
   *
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.
   *   <li>When {@link Link#Link()} appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(Link)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Link)"})
  public void testVisitWithLink_givenEmojiNode_whenLinkAppendChildEmojiNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Link a = new Link();
    a.appendChild(new EmojiNode());

    // Act
    markdownParser.visit(a);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof TextNode);
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertNull(((TextNode) getResult).getText());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    ListItem li = new ListItem();
    li.appendChild(new TableCellNode());

    // Act
    markdownParser.visit(li);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.ListItem);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof TableCell);
    assertEquals("td", getResult2.getMessageMLTag());
    assertEquals("td", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem2() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    ListItem li = new ListItem();
    li.appendChild(new TableNode());

    // Act
    markdownParser.visit(li);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.ListItem);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof Table);
    assertEquals("table", getResult2.getMessageMLTag());
    assertEquals("table", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem3() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    ListItem li = new ListItem();
    li.appendChild(new TableRowNode());

    // Act
    markdownParser.visit(li);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.ListItem);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof TableRow);
    assertEquals("tr", getResult2.getMessageMLTag());
    assertEquals("tr", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem4() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    BulletList child = new BulletList();
    child.appendChild(new EmojiNode());

    ListItem li = new ListItem();
    li.appendChild(child);

    // Act
    markdownParser.visit(li);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof org.symphonyoss.symphony.messageml.elements.BulletList);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.ListItem);
    assertEquals("ul", getResult2.getMessageMLTag());
    assertEquals("ul", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem5() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Code child = new Code("Literal");
    child.appendChild(new EmojiNode());

    ListItem li = new ListItem();
    li.appendChild(child);

    // Act
    markdownParser.visit(li);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof org.symphonyoss.symphony.messageml.elements.Code);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.ListItem);
    List<Element> children3 = getResult2.getChildren();
    assertEquals(1, children3.size());
    assertTrue(children3.get(0) instanceof TextNode);
    assertEquals("code", getResult2.getMessageMLTag());
    assertEquals("code", getResult2.getPresentationMLTag());
    assertEquals(1, getResult2.size());
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem6() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Document child = new Document();
    child.appendChild(new EmojiNode());

    ListItem li = new ListItem();
    li.appendChild(child);

    // Act
    markdownParser.visit(li);

    // Assert
    Element parent = markdownParser.getParent();
    assertTrue(parent instanceof MessageML);
    assertEquals("div", parent.getPresentationMLTag());
    assertEquals("messageML", parent.getMessageMLTag());
    assertNull(parent.getParent());
    MessageML messageML = markdownParser.getMessageML();
    assertEquals(0, messageML.size());
    assertEquals(2, parent.getChildren().size());
    assertEquals(2, parent.size());
    assertEquals(FormatEnum.PRESENTATIONML, parent.getFormat());
    assertFalse(((MessageML) parent).isChime());
    assertTrue(messageML.getChildren().isEmpty());
    assertTrue(parent.getAttributes().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem7() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Emphasis child = new Emphasis();
    child.appendChild(new EmojiNode());

    ListItem li = new ListItem();
    li.appendChild(child);

    // Act
    markdownParser.visit(li);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof Italic);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.ListItem);
    assertEquals("i", getResult2.getMessageMLTag());
    assertEquals("i", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem8() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    FencedCodeBlock child = new FencedCodeBlock();
    child.setLiteral("li");
    child.appendChild(new EmojiNode());

    ListItem li = new ListItem();
    li.appendChild(child);

    // Act
    markdownParser.visit(li);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.ListItem);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof TextNode);
    assertEquals("li", ((TextNode) getResult2).getText());
    assertNull(getResult2.getMessageMLTag());
    assertNull(getResult2.getPresentationMLTag());
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem9() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    HardLineBreak child = new HardLineBreak();
    child.appendChild(new EmojiNode());

    ListItem li = new ListItem();
    li.appendChild(child);

    // Act
    markdownParser.visit(li);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof LineBreak);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.ListItem);
    assertEquals("br", getResult2.getMessageMLTag());
    assertEquals("br", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   *
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem_givenBlockQuoteAppendChildEmojiNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    BlockQuote child = new BlockQuote();
    child.appendChild(new EmojiNode());

    ListItem li = new ListItem();
    li.appendChild(child);

    // Act
    markdownParser.visit(li);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.ListItem);
    assertEquals("li", getResult.getMessageMLTag());
    assertEquals("li", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
    assertSame(messageML, markdownParser.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   *
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.
   *   <li>When {@link ListItem} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem_givenEmojiNode_whenListItemAppendChildEmojiNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    ListItem li = new ListItem();
    li.appendChild(new EmojiNode());

    // Act
    markdownParser.visit(li);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.ListItem);
    assertEquals("li", getResult.getMessageMLTag());
    assertEquals("li", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
    assertSame(messageML, markdownParser.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   *
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem_givenPreformattedNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    ListItem li = new ListItem();
    li.appendChild(new PreformattedNode());

    // Act
    markdownParser.visit(li);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.ListItem);
    assertEquals("li", getResult.getMessageMLTag());
    assertEquals("li", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
    assertSame(messageML, markdownParser.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(ListItem)} with {@code ListItem}.
   *
   * <ul>
   *   <li>When {@link ListItem} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(ListItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(ListItem)"})
  public void testVisitWithListItem_whenListItem() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Act
    markdownParser.visit(new ListItem());

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.ListItem);
    assertEquals("li", getResult.getMessageMLTag());
    assertEquals("li", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
    assertSame(messageML, markdownParser.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    OrderedList ol = new OrderedList();
    ol.appendChild(new TableCellNode());

    // Act
    markdownParser.visit(ol);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.OrderedList);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof TableCell);
    assertEquals("td", getResult2.getMessageMLTag());
    assertEquals("td", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList2() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    OrderedList ol = new OrderedList();
    ol.appendChild(new TableNode());

    // Act
    markdownParser.visit(ol);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.OrderedList);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof Table);
    assertEquals("table", getResult2.getMessageMLTag());
    assertEquals("table", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList3() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    OrderedList ol = new OrderedList();
    ol.appendChild(new TableRowNode());

    // Act
    markdownParser.visit(ol);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.OrderedList);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof TableRow);
    assertEquals("tr", getResult2.getMessageMLTag());
    assertEquals("tr", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList4() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    BulletList child = new BulletList();
    child.appendChild(new EmojiNode());

    OrderedList ol = new OrderedList();
    ol.appendChild(child);

    // Act
    markdownParser.visit(ol);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof org.symphonyoss.symphony.messageml.elements.BulletList);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.OrderedList);
    assertEquals("ul", getResult2.getMessageMLTag());
    assertEquals("ul", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList5() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Code child = new Code("Literal");
    child.appendChild(new EmojiNode());

    OrderedList ol = new OrderedList();
    ol.appendChild(child);

    // Act
    markdownParser.visit(ol);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof org.symphonyoss.symphony.messageml.elements.Code);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.OrderedList);
    List<Element> children3 = getResult2.getChildren();
    assertEquals(1, children3.size());
    assertTrue(children3.get(0) instanceof TextNode);
    assertEquals("code", getResult2.getMessageMLTag());
    assertEquals("code", getResult2.getPresentationMLTag());
    assertEquals(1, getResult2.size());
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList6() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Document child = new Document();
    child.appendChild(new EmojiNode());

    OrderedList ol = new OrderedList();
    ol.appendChild(child);

    // Act
    markdownParser.visit(ol);

    // Assert
    Element parent = markdownParser.getParent();
    assertTrue(parent instanceof MessageML);
    assertEquals("div", parent.getPresentationMLTag());
    assertEquals("messageML", parent.getMessageMLTag());
    assertNull(parent.getParent());
    MessageML messageML = markdownParser.getMessageML();
    assertEquals(0, messageML.size());
    assertEquals(2, parent.getChildren().size());
    assertEquals(2, parent.size());
    assertEquals(FormatEnum.PRESENTATIONML, parent.getFormat());
    assertFalse(((MessageML) parent).isChime());
    assertTrue(messageML.getChildren().isEmpty());
    assertTrue(parent.getAttributes().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList7() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Emphasis child = new Emphasis();
    child.appendChild(new EmojiNode());

    OrderedList ol = new OrderedList();
    ol.appendChild(child);

    // Act
    markdownParser.visit(ol);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof Italic);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.OrderedList);
    assertEquals("i", getResult2.getMessageMLTag());
    assertEquals("i", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList8() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    FencedCodeBlock child = new FencedCodeBlock();
    child.setLiteral("ol");
    child.appendChild(new EmojiNode());

    OrderedList ol = new OrderedList();
    ol.appendChild(child);

    // Act
    markdownParser.visit(ol);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.OrderedList);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof TextNode);
    assertEquals("ol", ((TextNode) getResult2).getText());
    assertNull(getResult2.getMessageMLTag());
    assertNull(getResult2.getPresentationMLTag());
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList9() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    HardLineBreak child = new HardLineBreak();
    child.appendChild(new EmojiNode());

    OrderedList ol = new OrderedList();
    ol.appendChild(child);

    // Act
    markdownParser.visit(ol);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof LineBreak);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.OrderedList);
    assertEquals("br", getResult2.getMessageMLTag());
    assertEquals("br", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   *
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenBlockQuoteAppendChildEmojiNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    BlockQuote child = new BlockQuote();
    child.appendChild(new EmojiNode());

    OrderedList ol = new OrderedList();
    ol.appendChild(child);

    // Act
    markdownParser.visit(ol);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.OrderedList);
    assertEquals("ol", getResult.getMessageMLTag());
    assertEquals("ol", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
    assertSame(messageML, markdownParser.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   *
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.
   *   <li>When {@link OrderedList} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenEmojiNode_whenOrderedListAppendChildEmojiNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    OrderedList ol = new OrderedList();
    ol.appendChild(new EmojiNode());

    // Act
    markdownParser.visit(ol);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.OrderedList);
    assertEquals("ol", getResult.getMessageMLTag());
    assertEquals("ol", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
    assertSame(messageML, markdownParser.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   *
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList_givenPreformattedNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    OrderedList ol = new OrderedList();
    ol.appendChild(new PreformattedNode());

    // Act
    markdownParser.visit(ol);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.OrderedList);
    assertEquals("ol", getResult.getMessageMLTag());
    assertEquals("ol", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
    assertSame(messageML, markdownParser.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(OrderedList)} with {@code OrderedList}.
   *
   * <ul>
   *   <li>When {@link OrderedList} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(OrderedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(OrderedList)"})
  public void testVisitWithOrderedList_whenOrderedList() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Act
    markdownParser.visit(new OrderedList());

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.OrderedList);
    assertEquals("ol", getResult.getMessageMLTag());
    assertEquals("ol", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
    assertSame(messageML, markdownParser.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(new TableCellNode());

    // Act
    markdownParser.visit(paragraph);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof TableCell);
    assertEquals("td", getResult.getMessageMLTag());
    assertEquals("td", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph2() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(new TableNode());

    // Act
    markdownParser.visit(paragraph);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof Table);
    assertEquals("table", getResult.getMessageMLTag());
    assertEquals("table", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph3() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(new TableRowNode());

    // Act
    markdownParser.visit(paragraph);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof TableRow);
    assertEquals("tr", getResult.getMessageMLTag());
    assertEquals("tr", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph4() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    BulletList child = new BulletList();
    child.appendChild(new EmojiNode());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child);

    // Act
    markdownParser.visit(paragraph);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.BulletList);
    assertEquals("ul", getResult.getMessageMLTag());
    assertEquals("ul", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph5() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Code child = new Code("Literal");
    child.appendChild(new EmojiNode());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child);

    // Act
    markdownParser.visit(paragraph);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof TextNode);
    assertEquals("Literal", ((TextNode) getResult2).getText());
    assertEquals("code", getResult.getMessageMLTag());
    assertEquals("code", getResult.getPresentationMLTag());
    assertNull(getResult2.getMessageMLTag());
    assertNull(getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertEquals(1, getResult.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult2.getFormat());
    assertTrue(getResult2.getChildren().isEmpty());
    assertTrue(getResult2.getAttributes().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph6() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Document child = new Document();
    child.appendChild(new EmojiNode());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child);

    // Act
    markdownParser.visit(paragraph);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    assertEquals(0, messageML.size());
    assertTrue(messageML.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph7() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Emphasis child = new Emphasis();
    child.appendChild(new EmojiNode());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child);

    // Act
    markdownParser.visit(paragraph);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof Italic);
    assertEquals("i", getResult.getMessageMLTag());
    assertEquals("i", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph8() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    FencedCodeBlock child = new FencedCodeBlock();
    child.setLiteral("Literal");
    child.appendChild(new EmojiNode());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child);

    // Act
    markdownParser.visit(paragraph);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof TextNode);
    assertEquals("Literal", ((TextNode) getResult).getText());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph9() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    HardLineBreak child = new HardLineBreak();
    child.appendChild(new EmojiNode());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child);

    // Act
    markdownParser.visit(paragraph);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof LineBreak);
    assertEquals("br", getResult.getMessageMLTag());
    assertEquals("br", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph10() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    FencedCodeBlock child = new FencedCodeBlock();
    child.setLiteral("Literal");
    child.setFenceLength(3);
    child.appendChild(new EmojiNode());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child);

    // Act
    markdownParser.visit(paragraph);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof TextNode);
    assertEquals("\u0000\u0000\u0000Literal\u0000\u0000\u0000", ((TextNode) getResult).getText());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   *
   * <ul>
   *   <li>Given {@link BlockQuote} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph_givenBlockQuoteAppendChildEmojiNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    BlockQuote child = new BlockQuote();
    child.appendChild(new EmojiNode());

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(child);

    // Act
    markdownParser.visit(paragraph);

    // Assert that nothing has changed
    MessageML messageML = markdownParser.getMessageML();
    assertEquals(1, messageML.getChildren().size());
    assertEquals(1, messageML.size());
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   *
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.
   *   <li>When {@link Paragraph} (default constructor) appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph_givenEmojiNode_whenParagraphAppendChildEmojiNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(new EmojiNode());

    // Act
    markdownParser.visit(paragraph);

    // Assert that nothing has changed
    MessageML messageML = markdownParser.getMessageML();
    assertEquals(1, messageML.getChildren().size());
    assertEquals(1, messageML.size());
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   *
   * <ul>
   *   <li>Given {@link PreformattedNode} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph_givenPreformattedNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Paragraph paragraph = new Paragraph();
    paragraph.appendChild(new PreformattedNode());

    // Act
    markdownParser.visit(paragraph);

    // Assert that nothing has changed
    MessageML messageML = markdownParser.getMessageML();
    assertEquals(1, messageML.getChildren().size());
    assertEquals(1, messageML.size());
  }

  /**
   * Test {@link MarkdownParser#visit(Paragraph)} with {@code Paragraph}.
   *
   * <ul>
   *   <li>When {@link Paragraph} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(Paragraph)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Paragraph)"})
  public void testVisitWithParagraph_whenParagraph() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Act
    markdownParser.visit(new Paragraph());

    // Assert that nothing has changed
    MessageML messageML = markdownParser.getMessageML();
    assertEquals(1, messageML.getChildren().size());
    assertEquals(1, messageML.size());
  }

  /**
   * Test {@link MarkdownParser#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Act
    markdownParser.visit(new StrongEmphasis());

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof Bold);
    assertEquals("b", getResult.getMessageMLTag());
    assertEquals("b", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis2() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Code child = new Code("Literal");
    child.appendChild(new EmojiNode());

    StrongEmphasis b = new StrongEmphasis();
    b.appendChild(child);

    // Act
    markdownParser.visit(b);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof Bold);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children3 = getResult2.getChildren();
    assertEquals(1, children3.size());
    assertTrue(children3.get(0) instanceof TextNode);
    assertEquals("code", getResult2.getMessageMLTag());
    assertEquals("code", getResult2.getPresentationMLTag());
    assertEquals(1, getResult2.size());
  }

  /**
   * Test {@link MarkdownParser#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis3() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Emphasis child = new Emphasis();
    child.appendChild(new EmojiNode());

    StrongEmphasis b = new StrongEmphasis();
    b.appendChild(child);

    // Act
    markdownParser.visit(b);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof Bold);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof Italic);
    assertEquals("i", getResult2.getMessageMLTag());
    assertEquals("i", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis4() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    HardLineBreak child = new HardLineBreak();
    child.appendChild(new EmojiNode());

    StrongEmphasis b = new StrongEmphasis();
    b.appendChild(child);

    // Act
    markdownParser.visit(b);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof Bold);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof LineBreak);
    assertEquals("br", getResult2.getMessageMLTag());
    assertEquals("br", getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertTrue(getResult2.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(StrongEmphasis)} with {@code StrongEmphasis}.
   *
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(StrongEmphasis)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(StrongEmphasis)"})
  public void testVisitWithStrongEmphasis_givenEmojiNode() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    StrongEmphasis b = new StrongEmphasis();
    b.appendChild(new EmojiNode());

    // Act
    markdownParser.visit(b);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof Bold);
    assertEquals("b", getResult.getMessageMLTag());
    assertEquals("b", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(Text)} with {@code Text}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Text)"})
  public void testVisitWithText() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Act
    markdownParser.visit(new Text());

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof TextNode);
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertNull(((TextNode) getResult).getText());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#visit(Text)} with {@code Text}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Text)"})
  public void testVisitWithText2() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Code child = new Code("Literal");
    child.appendChild(new EmojiNode());

    Text text = new Text();
    text.appendChild(child);

    // Act
    markdownParser.visit(text);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(3, children.size());
    Element getResult = children.get(2);
    assertTrue(getResult instanceof org.symphonyoss.symphony.messageml.elements.Code);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof TextNode);
    assertEquals("Literal", ((TextNode) getResult2).getText());
    assertEquals("code", getResult.getMessageMLTag());
    assertEquals("code", getResult.getPresentationMLTag());
    assertNull(getResult2.getMessageMLTag());
    assertNull(getResult2.getPresentationMLTag());
    assertEquals(0, getResult2.size());
    assertEquals(1, getResult.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult2.getFormat());
    assertTrue(getResult2.getChildren().isEmpty());
    assertTrue(getResult2.getAttributes().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Text)} with {@code Text}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Text)"})
  public void testVisitWithText3() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Emphasis child = new Emphasis();
    child.appendChild(new EmojiNode());

    Text text = new Text();
    text.appendChild(child);

    // Act
    markdownParser.visit(text);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(3, children.size());
    Element getResult = children.get(2);
    assertTrue(getResult instanceof Italic);
    assertEquals("i", getResult.getMessageMLTag());
    assertEquals("i", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Text)} with {@code Text}.
   *
   * <p>Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Text)"})
  public void testVisitWithText4() throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    HardLineBreak child = new HardLineBreak();
    child.appendChild(new EmojiNode());

    Text text = new Text();
    text.appendChild(child);

    // Act
    markdownParser.visit(text);

    // Assert
    List<Element> children = markdownParser.getMessageML().getChildren();
    assertEquals(3, children.size());
    Element getResult = children.get(2);
    assertTrue(getResult instanceof LineBreak);
    assertEquals("br", getResult.getMessageMLTag());
    assertEquals("br", getResult.getPresentationMLTag());
    assertEquals(0, getResult.size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Test {@link MarkdownParser#visit(Text)} with {@code Text}.
   *
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.
   *   <li>When {@link Text#Text()} appendChild {@link EmojiNode#EmojiNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#visit(Text)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkdownParser.visit(Text)"})
  public void testVisitWithText_givenEmojiNode_whenTextAppendChildEmojiNode()
      throws InvalidInputException {
    // Arrange
    MarkdownParser markdownParser = new MarkdownParser(new NoOpDataProvider());
    markdownParser.parse(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    Text text = new Text();
    text.appendChild(new EmojiNode());

    // Act
    markdownParser.visit(text);

    // Assert
    MessageML messageML = markdownParser.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(2, children.size());
    Element getResult = children.get(1);
    assertTrue(getResult instanceof TextNode);
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertNull(((TextNode) getResult).getText());
    assertEquals(0, getResult.size());
    assertEquals(2, messageML.size());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Test {@link MarkdownParser#parse(String, JsonNode, JsonNode)}.
   *
   * <ul>
   *   <li>Then return Children first Text is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#parse(String, JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageML MarkdownParser.parse(String, JsonNode, JsonNode)"})
  public void testParse_thenReturnChildrenFirstTextIsNotAllWhoWanderAreLost()
      throws InvalidInputException {
    // Arrange and Act
    MessageML actualParseResult =
        new MarkdownParser(new NoOpDataProvider())
            .parse(
                "Not all who wander are lost",
                DoubleNode.valueOf(10.0d),
                DoubleNode.valueOf(10.0d));

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
   *
   * <ul>
   *   <li>Then return Children first Text is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#parse(String, JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageML MarkdownParser.parse(String, JsonNode, JsonNode)"})
  public void testParse_thenReturnChildrenFirstTextIsNotAllWhoWanderAreLost2()
      throws InvalidInputException {
    // Arrange and Act
    MessageML actualParseResult =
        new MarkdownParser(new NoOpDataProvider())
            .parse("Not all who wander are lost", DoubleNode.valueOf(10.0d), null);

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
   *
   * <ul>
   *   <li>Then return Children first Text is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#parse(String, JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageML MarkdownParser.parse(String, JsonNode, JsonNode)"})
  public void testParse_thenReturnChildrenFirstTextIsNotAllWhoWanderAreLost3()
      throws InvalidInputException {
    // Arrange and Act
    MessageML actualParseResult =
        new MarkdownParser(new NoOpDataProvider())
            .parse("Not all who wander are lost", null, DoubleNode.valueOf(10.0d));

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
   *
   * <ul>
   *   <li>When {@code 2.0}.
   *   <li>Then return Children first Text is {@code 2.0}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#parse(String, JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageML MarkdownParser.parse(String, JsonNode, JsonNode)"})
  public void testParse_when20_thenReturnChildrenFirstTextIs20() throws InvalidInputException {
    // Arrange and Act
    MessageML actualParseResult =
        new MarkdownParser(new NoOpDataProvider())
            .parse("2.0", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

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
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return PresentationMLTag is {@code div}.
   * </ul>
   *
   * <p>Method under test: {@link MarkdownParser#parse(String, JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageML MarkdownParser.parse(String, JsonNode, JsonNode)"})
  public void testParse_whenEmptyString_thenReturnPresentationMLTagIsDiv()
      throws InvalidInputException {
    // Arrange and Act
    MessageML actualParseResult =
        new MarkdownParser(new NoOpDataProvider())
            .parse("", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

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
