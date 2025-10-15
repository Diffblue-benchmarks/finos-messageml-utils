package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Document;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Node;
import org.commonmark.node.StrongEmphasis;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.KeywordNode;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.CheckboxNode;
import org.symphonyoss.symphony.messageml.util.IDataProvider;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class MessageMLDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MessageML#MessageML(FormatEnum, String)}
   *   <li>{@link MessageML#setChime(boolean)}
   *   <li>{@link MessageML#getPresentationMLTag()}
   *   <li>{@link MessageML#isChime()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MessageML.<init>(FormatEnum, String)",
    "String MessageML.getPresentationMLTag()",
    "boolean MessageML.isChime()",
    "void MessageML.setChime(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    MessageML actualMessageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    actualMessageML.setChime(true);
    String actualPresentationMLTag = actualMessageML.getPresentationMLTag();
    boolean actualIsChimeResult = actualMessageML.isChime();

    // Assert
    assertNull(actualMessageML.getParent());
    assertEquals(FormatEnum.MESSAGEML, actualMessageML.getFormat());
    assertTrue(actualMessageML.getChildren().isEmpty());
    assertTrue(actualMessageML.getAttributes().isEmpty());
    assertTrue(actualIsChimeResult);
    assertEquals(MessageML.MESSAGEML_TAG, actualMessageML.getMessageMLTag());
    assertEquals(MessageML.PRESENTATIONML_TAG, actualPresentationMLTag);
  }

  /**
   * Test {@link MessageML#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> messageML.buildAttribute(parser, new IIOMetadataNode("data-format")));
  }

  /**
   * Test {@link MessageML#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code xmlns}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithXmlns_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.PRESENTATIONML, "1.0.2");
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> messageML.buildAttribute(parser, new IIOMetadataNode("xmlns")));
  }

  /**
   * Test {@link MessageML#asMarkdown()}.
   *
   * <p>Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Document MessageML.asMarkdown()"})
  public void testAsMarkdown() throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    messageML.addChild(new Card(parent2, FormatEnum.MESSAGEML));

    // Act
    Document actualAsMarkdownResult = messageML.asMarkdown();

    // Assert
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link MessageML#asMarkdown()}.
   *
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is {@link Element}.
   *   <li>Then FirstChild return {@link FencedCodeBlock}.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Document MessageML.asMarkdown()"})
  public void testAsMarkdown_givenBoldWithParentIsElement_thenFirstChildReturnFencedCodeBlock()
      throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    Bold parent = new Bold(mock(Element.class));
    messageML.addChild(new Code(parent, "en"));

    // Act and Assert
    Node firstChild = messageML.asMarkdown().getFirstChild();
    assertTrue(firstChild instanceof FencedCodeBlock);
    assertEquals("en", ((FencedCodeBlock) firstChild).getInfo());
    assertNull(((FencedCodeBlock) firstChild).getLiteral());
    assertEquals(0, ((FencedCodeBlock) firstChild).getFenceIndent());
    assertEquals(3, ((FencedCodeBlock) firstChild).getFenceLength());
    assertEquals(Code.MARKDOWN_DELIMITER_CHAR, ((FencedCodeBlock) firstChild).getFenceChar());
  }

  /**
   * Test {@link MessageML#asMarkdown()}.
   *
   * <ul>
   *   <li>Given {@link Code#Code(Element, String)} with parent is {@link Element} and language is
   *       {@code en}.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Document MessageML.asMarkdown()"})
  public void testAsMarkdown_givenCodeWithParentIsElementAndLanguageIsEn()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    Code parent2 = new Code(mock(Element.class), "en");
    child.addChild(new BulletList(new Bold(parent2)));
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);

    Checkbox child2 = new Checkbox(parent4, FormatEnum.MESSAGEML);
    child2.addChild(child);

    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(child2);

    // Act and Assert
    Node firstChild = messageML.asMarkdown().getFirstChild();
    Node firstChild2 = firstChild.getFirstChild();
    assertTrue(firstChild2 instanceof StrongEmphasis);
    assertTrue(firstChild instanceof CheckboxNode);
    assertEquals("**", ((StrongEmphasis) firstChild2).getClosingDelimiter());
    assertEquals("**", ((StrongEmphasis) firstChild2).getOpeningDelimiter());
    assertNull(firstChild2.getFirstChild());
    assertNull(firstChild2.getLastChild());
    assertNull(firstChild2.getNext());
    assertNull(firstChild2.getPrevious());
  }

  /**
   * Test {@link MessageML#asMarkdown()}.
   *
   * <ul>
   *   <li>Given {@link MessageML#MessageML(FormatEnum, String)} with format is {@code MESSAGEML}
   *       and version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Document MessageML.asMarkdown()"})
  public void testAsMarkdown_givenMessageMLWithFormatIsMessagemlAndVersionIs102()
      throws InvalidInputException {
    // Arrange and Act
    Document actualAsMarkdownResult = new MessageML(FormatEnum.MESSAGEML, "1.0.2").asMarkdown();

    // Assert
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link MessageML#asMarkdown()}.
   *
   * <ul>
   *   <li>Then FirstChild FirstChild FirstChild return {@link KeywordNode}.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Document MessageML.asMarkdown()"})
  public void testAsMarkdown_thenFirstChildFirstChildFirstChildReturnKeywordNode()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CashTag(parent3, 1));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Checkbox child2 = new Checkbox(parent5, FormatEnum.MESSAGEML);
    child2.addChild(child);

    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(child2);

    // Act and Assert
    Node firstChild = messageML.asMarkdown().getFirstChild();
    Node firstChild2 = firstChild.getFirstChild();
    assertTrue(firstChild2 instanceof StrongEmphasis);
    Node firstChild3 = firstChild2.getFirstChild();
    assertTrue(firstChild3 instanceof KeywordNode);
    assertTrue(firstChild instanceof CheckboxNode);
    assertEquals("$null", ((CheckboxNode) firstChild).getText());
    assertNull(((KeywordNode) firstChild3).getText());
    assertEquals(CashTag.PREFIX, ((KeywordNode) firstChild3).getPrefix());
  }

  /**
   * Test {@link MessageML#asMarkdown()}.
   *
   * <ul>
   *   <li>Then FirstChild FirstChild FirstChild return {@link StrongEmphasis}.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Document MessageML.asMarkdown()"})
  public void testAsMarkdown_thenFirstChildFirstChildFirstChildReturnStrongEmphasis()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent2));
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);

    Checkbox child2 = new Checkbox(parent4, FormatEnum.MESSAGEML);
    child2.addChild(child);

    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(child2);

    // Act and Assert
    Node firstChild = messageML.asMarkdown().getFirstChild();
    Node firstChild2 = firstChild.getFirstChild();
    Node firstChild3 = firstChild2.getFirstChild();
    assertTrue(firstChild3 instanceof StrongEmphasis);
    assertTrue(firstChild2 instanceof StrongEmphasis);
    assertTrue(firstChild instanceof CheckboxNode);
    assertEquals("**", ((StrongEmphasis) firstChild3).getClosingDelimiter());
    assertEquals("**", ((StrongEmphasis) firstChild3).getOpeningDelimiter());
    assertNull(firstChild3.getFirstChild());
    assertNull(firstChild3.getLastChild());
    assertNull(firstChild3.getNext());
    assertNull(firstChild3.getPrevious());
  }

  /**
   * Test {@link MessageML#asMarkdown()}.
   *
   * <ul>
   *   <li>Then FirstChild return {@link StrongEmphasis}.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Document MessageML.asMarkdown()"})
  public void testAsMarkdown_thenFirstChildReturnStrongEmphasis() throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    BulletList parent = new BulletList(mock(Element.class));
    messageML.addChild(new Bold(parent));

    // Act
    Document actualAsMarkdownResult = messageML.asMarkdown();

    // Assert
    Node firstChild = actualAsMarkdownResult.getFirstChild();
    assertTrue(firstChild instanceof StrongEmphasis);
    assertEquals("**", ((StrongEmphasis) firstChild).getClosingDelimiter());
    assertEquals("**", ((StrongEmphasis) firstChild).getOpeningDelimiter());
    assertSame(actualAsMarkdownResult, firstChild.getParent());
  }

  /**
   * Test {@link MessageML#asMarkdown()}.
   *
   * <ul>
   *   <li>Then return FirstChild ClosingDelimiter is space.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Document MessageML.asMarkdown()"})
  public void testAsMarkdown_thenReturnFirstChildClosingDelimiterIsSpace()
      throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    messageML.addChild(new Checkbox(parent2, FormatEnum.MESSAGEML));

    // Act and Assert
    Node firstChild = messageML.asMarkdown().getFirstChild();
    assertTrue(firstChild instanceof CheckboxNode);
    assertEquals(" ", ((CheckboxNode) firstChild).getClosingDelimiter());
    assertEquals(" ", ((CheckboxNode) firstChild).getOpeningDelimiter());
    assertNull(firstChild.getFirstChild());
    assertNull(firstChild.getLastChild());
  }

  /**
   * Test {@link MessageML#asMarkdown()}.
   *
   * <ul>
   *   <li>Then return FirstChild FirstChild ClosingDelimiter is {@code **}.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Document MessageML.asMarkdown()"})
  public void testAsMarkdown_thenReturnFirstChildFirstChildClosingDelimiterIsAsteriskAsterisk()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Checkbox child = new Checkbox(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent3));

    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(child);

    // Act and Assert
    Node firstChild = messageML.asMarkdown().getFirstChild();
    Node firstChild2 = firstChild.getFirstChild();
    assertTrue(firstChild2 instanceof StrongEmphasis);
    assertTrue(firstChild instanceof CheckboxNode);
    assertEquals("**", ((StrongEmphasis) firstChild2).getClosingDelimiter());
    assertEquals("**", ((StrongEmphasis) firstChild2).getOpeningDelimiter());
    assertNull(firstChild2.getFirstChild());
    assertNull(firstChild2.getLastChild());
    assertNull(firstChild2.getNext());
    assertNull(firstChild2.getPrevious());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(65L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    BulletList parent = new BulletList(mock(Element.class));
    messageML.addChild(new Bold(parent));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(76L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "=\"");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(67L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML4() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, ">");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(64L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML5() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setPrintOffsets(true);

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(65L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML6() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoIndent(true);

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(64L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML7() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(62L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML8() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    BulletList parent = new BulletList(mock(Element.class));
    messageML.addChild(new Bold(parent));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(70L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML9() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    messageML.addChild(new Checkbox(parent2, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(104L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML10() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    messageML.addChild(new Button(parent2, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(94L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML11() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    messageML.addChild(new CardBody(parent2, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(91L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML12() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent2));

    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(77L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML13() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    messageML.addChild(new CashTag(parent2, 1));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(124L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML14() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new Checkbox(parent3, FormatEnum.MESSAGEML));

    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(113L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML15() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new Button(parent3, FormatEnum.MESSAGEML));

    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(101L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML16() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CardBody(parent3, FormatEnum.MESSAGEML));

    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(98L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML17() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CashTag(parent3, 1));

    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(133L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <ul>
   *   <li>Given {@link MessageML#MessageML(FormatEnum, String)} with format is {@code MESSAGEML}
   *       and version is {@code <}.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML_givenMessageMLWithFormatIsMessagemlAndVersionIsLessThanSign() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "<");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(64L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asEntityJson(ObjectNode)}.
   *
   * <p>Method under test: {@link MessageML#asEntityJson(ObjectNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode MessageML.asEntityJson(ObjectNode)"})
  public void testAsEntityJson() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode parent = new ObjectNode(nc);

    // Act
    ObjectNode actualAsEntityJsonResult = messageML.asEntityJson(parent);

    // Assert
    assertEquals("{ }", parent.toPrettyString());
    assertEquals(0, parent.size());
    assertFalse(parent.iterator().hasNext());
    assertTrue(parent.isEmpty());
    assertSame(parent, actualAsEntityJsonResult);
  }

  /**
   * Test {@link MessageML#asEntityJson(ObjectNode)}.
   *
   * <p>Method under test: {@link MessageML#asEntityJson(ObjectNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode MessageML.asEntityJson(ObjectNode)"})
  public void testAsEntityJson2() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    BulletList parent = new BulletList(mock(Element.class));
    messageML.addChild(new Bold(parent));
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode parent2 = new ObjectNode(nc);

    // Act
    ObjectNode actualAsEntityJsonResult = messageML.asEntityJson(parent2);

    // Assert
    assertEquals("{ }", parent2.toPrettyString());
    assertEquals(0, parent2.size());
    assertFalse(parent2.iterator().hasNext());
    assertTrue(parent2.isEmpty());
    assertSame(parent2, actualAsEntityJsonResult);
  }

  /**
   * Test {@link MessageML#asEntityJson(ObjectNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then traverse return {@link TreeTraversingParser}.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#asEntityJson(ObjectNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode MessageML.asEntityJson(ObjectNode)"})
  public void testAsEntityJson_whenNull_thenTraverseReturnTreeTraversingParser() {
    // Arrange and Act
    ObjectNode actualAsEntityJsonResult =
        new MessageML(FormatEnum.MESSAGEML, "1.0.2").asEntityJson(null);

    // Assert
    assertTrue(actualAsEntityJsonResult.traverse() instanceof TreeTraversingParser);
    assertEquals("{ }", actualAsEntityJsonResult.toPrettyString());
    assertEquals(0, actualAsEntityJsonResult.size());
    assertFalse(actualAsEntityJsonResult.iterator().hasNext());
    assertTrue(actualAsEntityJsonResult.isEmpty());
  }

  /**
   * Test {@link MessageML#validate()}.
   *
   * <ul>
   *   <li>Given {@link Bold} {@link Bold#getChildren()} return {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link Bold#getChildren()}.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.validate()"})
  public void testValidate_givenBoldGetChildrenReturnArrayList_thenCallsGetChildren()
      throws InvalidInputException {
    // Arrange
    Bold child = mock(Bold.class);
    when(child.getChildren()).thenReturn(new ArrayList<>());

    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(child);

    // Act
    messageML.validate();

    // Assert
    verify(child).getChildren();
  }

  /**
   * Test {@link MessageML#validate()}.
   *
   * <ul>
   *   <li>Given {@link BulletList#BulletList(Element)} with parent is {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.validate()"})
  public void testValidate_givenBulletListWithParentIsNull_thenDoesNotThrow()
      throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(new Bold(new BulletList(null)));

    // Act and Assert
    messageML.validate();
  }

  /**
   * Test {@link MessageML#validate()}.
   *
   * <ul>
   *   <li>Given {@link MessageML#MessageML(FormatEnum, String)} with format is {@code MESSAGEML}
   *       and version is {@code 1.0.2} Chime is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.validate()"})
  public void testValidate_givenMessageMLWithFormatIsMessagemlAndVersionIs102ChimeIsTrue()
      throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.setChime(true);
    messageML.addChild(new Bold(new BulletList(null)));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> messageML.validate());
  }

  /**
   * Test {@link MessageML#validate()}.
   *
   * <ul>
   *   <li>Given {@link MessageML#MessageML(FormatEnum, String)} with format is {@code MESSAGEML}
   *       and version is {@code 1.0.2} Chime is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.validate()"})
  public void testValidate_givenMessageMLWithFormatIsMessagemlAndVersionIs102ChimeIsTrue2()
      throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.setChime(true);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> messageML.validate());
  }

  /**
   * Test {@link MessageML#validate()}.
   *
   * <ul>
   *   <li>Given {@link MessageML#MessageML(FormatEnum, String)} with format is {@code MESSAGEML}
   *       and version is {@code 1.0.2}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.validate()"})
  public void testValidate_givenMessageMLWithFormatIsMessagemlAndVersionIs102_thenDoesNotThrow()
      throws InvalidInputException {
    // Arrange, Act and Assert
    new MessageML(FormatEnum.MESSAGEML, "1.0.2").validate();
  }

  /**
   * Test {@link MessageML#validate()}.
   *
   * <ul>
   *   <li>Given {@link MessageML#MessageML(FormatEnum, String)} with format is {@code
   *       PRESENTATIONML} and version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.validate()"})
  public void testValidate_givenMessageMLWithFormatIsPresentationmlAndVersionIs102()
      throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> new MessageML(FormatEnum.PRESENTATIONML, "1.0.2").validate());
  }

  /**
   * Test {@link MessageML#enhanceFinancialTags(MessageML, IDataProvider)}.
   *
   * <ul>
   *   <li>Given {@link Bold} {@link Bold#getChildren()} return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#enhanceFinancialTags(MessageML, IDataProvider)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.enhanceFinancialTags(MessageML, IDataProvider)"})
  public void testEnhanceFinancialTags_givenBoldGetChildrenReturnArrayList()
      throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");

    Bold child = mock(Bold.class);
    when(child.getChildren()).thenReturn(new ArrayList<>());

    MessageML result = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    result.addChild(child);

    // Act
    messageML.enhanceFinancialTags(result, new NoOpDataProvider());

    // Assert
    verify(child).getChildren();
  }

  /**
   * Test {@link MessageML#enhanceFinancialTags(MessageML, IDataProvider)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MessageML#enhanceFinancialTags(MessageML, IDataProvider)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageML.enhanceFinancialTags(MessageML, IDataProvider)"})
  public void testEnhanceFinancialTags_thenThrowIllegalArgumentException()
      throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");

    Bold child = mock(Bold.class);
    when(child.getChildren()).thenThrow(new IllegalArgumentException());

    MessageML result = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    result.addChild(child);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> messageML.enhanceFinancialTags(result, new NoOpDataProvider()));
    verify(child).getChildren();
  }
}
