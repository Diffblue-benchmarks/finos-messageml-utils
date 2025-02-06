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
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.CheckboxNode;
import org.symphonyoss.symphony.messageml.util.IDataProvider;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class MessageMLDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MessageML#MessageML(FormatEnum, String)}
   *   <li>{@link MessageML#setChime(boolean)}
   *   <li>{@link MessageML#getPresentationMLTag()}
   *   <li>{@link MessageML#isChime()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageML#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Attribute "foo" is not allowed in "messageML"
    //       at org.symphonyoss.symphony.messageml.elements.Element.throwInvalidInputException(Element.java:1071)
    //       at org.symphonyoss.symphony.messageml.elements.Element.buildAttribute(Element.java:256)
    //       at org.symphonyoss.symphony.messageml.elements.MessageML.buildAttribute(MessageML.java:99)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    messageML.buildAttribute(parser, new IIOMetadataNode("foo"));
  }

  /**
   * Test {@link MessageML#asMarkdown()}.
   * <p>
   * Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));

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
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is {@link Element}.</li>
   *   <li>Then FirstChild return {@link FencedCodeBlock}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  public void testAsMarkdown_givenBoldWithParentIsElement_thenFirstChildReturnFencedCodeBlock()
      throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(new Code(new Bold(mock(Element.class)), "en"));

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
   * <ul>
   *   <li>Given {@link MessageML#MessageML(FormatEnum, String)} with format is
   * {@code MESSAGEML} and version is {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  public void testAsMarkdown_givenMessageMLWithFormatIsMessagemlAndVersionIs102() throws InvalidInputException {
    // Arrange and Act
    Document actualAsMarkdownResult = (new MessageML(FormatEnum.MESSAGEML, "1.0.2")).asMarkdown();

    // Assert
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link MessageML#asMarkdown()}.
   * <ul>
   *   <li>Then FirstChild return {@link CheckboxNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  public void testAsMarkdown_thenFirstChildReturnCheckboxNode() throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));

    // Act and Assert
    Node firstChild = messageML.asMarkdown().getFirstChild();
    assertTrue(firstChild instanceof CheckboxNode);
    assertEquals(" ", ((CheckboxNode) firstChild).getClosingDelimiter());
    assertEquals(" ", ((CheckboxNode) firstChild).getOpeningDelimiter());
    assertEquals("", ((CheckboxNode) firstChild).getText());
  }

  /**
   * Test {@link MessageML#asMarkdown()}.
   * <ul>
   *   <li>Then FirstChild return {@link StrongEmphasis}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  public void testAsMarkdown_thenFirstChildReturnStrongEmphasis() throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(new Bold(new BulletList(mock(Element.class))));

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
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(65L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "=\"");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(67L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, ">");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(64L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(76L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(109L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML6() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(new Button(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(100L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML7() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(97L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML8() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(89L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML9() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(129L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML10() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(65L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML11() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(64L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML12() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(62L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <ul>
   *   <li>Given {@link MessageML#MessageML(FormatEnum, String)} with format is
   * {@code MESSAGEML} and version is {@code <}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML_givenMessageMLWithFormatIsMessagemlAndVersionIsLessThanSign() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "<");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(64L, out.getOffset());
  }

  /**
   * Test {@link MessageML#asEntityJson(ObjectNode)}.
   * <p>
   * Method under test: {@link MessageML#asEntityJson(ObjectNode)}
   */
  @Test
  public void testAsEntityJson() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    ObjectNode parent = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

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
   * <p>
   * Method under test: {@link MessageML#asEntityJson(ObjectNode)}
   */
  @Test
  public void testAsEntityJson2() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(new Bold(new BulletList(mock(Element.class))));
    ObjectNode parent = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then traverse return {@link TreeTraversingParser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageML#asEntityJson(ObjectNode)}
   */
  @Test
  public void testAsEntityJson_whenNull_thenTraverseReturnTreeTraversingParser() {
    // Arrange and Act
    ObjectNode actualAsEntityJsonResult = (new MessageML(FormatEnum.MESSAGEML, "1.0.2")).asEntityJson(null);

    // Assert
    assertTrue(actualAsEntityJsonResult.traverse() instanceof TreeTraversingParser);
    assertEquals("{ }", actualAsEntityJsonResult.toPrettyString());
    assertEquals(0, actualAsEntityJsonResult.size());
    assertFalse(actualAsEntityJsonResult.iterator().hasNext());
    assertTrue(actualAsEntityJsonResult.isEmpty());
  }

  /**
   * Test {@link MessageML#validate()}.
   * <ul>
   *   <li>Given {@link MessageML#MessageML(FormatEnum, String)} with format is
   * {@code MESSAGEML} and version is {@code 1.0.2} Chime is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageML#validate()}
   */
  @Test
  public void testValidate_givenMessageMLWithFormatIsMessagemlAndVersionIs102ChimeIsTrue()
      throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.setChime(true);
    messageML.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> messageML.validate());
  }

  /**
   * Test {@link MessageML#validate()}.
   * <ul>
   *   <li>Given {@link MessageML#MessageML(FormatEnum, String)} with format is
   * {@code MESSAGEML} and version is {@code 1.0.2} Chime is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageML#validate()}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link MessageML#MessageML(FormatEnum, String)} with format is
   * {@code PRESENTATIONML} and version is {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageML#validate()}
   */
  @Test
  public void testValidate_givenMessageMLWithFormatIsPresentationmlAndVersionIs102() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class, () -> (new MessageML(FormatEnum.PRESENTATIONML, "1.0.2")).validate());
  }

  /**
   * Test {@link MessageML#enhanceFinancialTags(MessageML, IDataProvider)}.
   * <ul>
   *   <li>Then calls {@link Element#getChildren()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessageML#enhanceFinancialTags(MessageML, IDataProvider)}
   */
  @Test
  public void testEnhanceFinancialTags_thenCallsGetChildren() throws InvalidInputException {
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
}
