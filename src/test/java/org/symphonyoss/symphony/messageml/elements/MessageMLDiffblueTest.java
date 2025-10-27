package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.commonmark.node.Document;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Node;
import org.commonmark.node.StrongEmphasis;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.CheckboxNode;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class MessageMLDiffblueTest {
  /**
   * Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() throws InvalidInputException {
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
   * Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  public void testAsMarkdown2() throws InvalidInputException {
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
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(firstChild.getFirstChild());
    assertNull(firstChild.getLastChild());
    assertNull(firstChild.getNext());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(firstChild.getPrevious());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertSame(actualAsMarkdownResult, firstChild.getParent());
  }

  /**
   * Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  public void testAsMarkdown3() throws InvalidInputException {
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
   * Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  public void testAsMarkdown4() throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(new Code(new Bold(mock(Element.class)), "en"));

    // Act
    Document actualAsMarkdownResult = messageML.asMarkdown();

    // Assert
    Node firstChild = actualAsMarkdownResult.getFirstChild();
    assertTrue(firstChild instanceof FencedCodeBlock);
    assertEquals("en", ((FencedCodeBlock) firstChild).getInfo());
    assertNull(((FencedCodeBlock) firstChild).getLiteral());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(firstChild.getFirstChild());
    assertNull(firstChild.getLastChild());
    assertNull(firstChild.getNext());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(firstChild.getPrevious());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertEquals(0, ((FencedCodeBlock) firstChild).getFenceIndent());
    assertEquals(3, ((FencedCodeBlock) firstChild).getFenceLength());
    assertEquals(Code.MARKDOWN_DELIMITER_CHAR, ((FencedCodeBlock) firstChild).getFenceChar());
    assertSame(actualAsMarkdownResult, firstChild.getParent());
  }

  /**
   * Method under test: {@link MessageML#asMarkdown()}
   */
  @Test
  public void testAsMarkdown5() throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.addChild(new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));

    // Act
    Document actualAsMarkdownResult = messageML.asMarkdown();

    // Assert
    Node firstChild = actualAsMarkdownResult.getFirstChild();
    assertTrue(firstChild instanceof CheckboxNode);
    assertEquals(" ", ((CheckboxNode) firstChild).getClosingDelimiter());
    assertEquals(" ", ((CheckboxNode) firstChild).getOpeningDelimiter());
    assertEquals("", ((CheckboxNode) firstChild).getText());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(firstChild.getFirstChild());
    assertNull(firstChild.getLastChild());
    assertNull(firstChild.getNext());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(firstChild.getPrevious());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertSame(actualAsMarkdownResult, firstChild.getParent());
  }

  /**
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
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "<");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(64L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "=\"");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(67L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, ">");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    messageML.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(64L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() {
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
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML6() {
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
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML7() {
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
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML8() {
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
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML9() {
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
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML10() {
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
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML11() {
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
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML12() {
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
   * Method under test:
   * {@link MessageML#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML13() {
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
   * Method under test: {@link MessageML#asEntityJson(ObjectNode)}
   */
  @Test
  public void testAsEntityJson2() throws IOException {
    // Arrange and Act
    ObjectNode actualAsEntityJsonResult = (new MessageML(FormatEnum.MESSAGEML, "1.0.2")).asEntityJson(null);

    // Assert
    JsonParser traverseResult = actualAsEntityJsonResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", actualAsEntityJsonResult.toPrettyString());
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
    assertEquals(0, actualAsEntityJsonResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, actualAsEntityJsonResult.getNodeType());
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
    assertFalse(actualAsEntityJsonResult.isArray());
    assertFalse(actualAsEntityJsonResult.isBigDecimal());
    assertFalse(actualAsEntityJsonResult.isBigInteger());
    assertFalse(actualAsEntityJsonResult.isBinary());
    assertFalse(actualAsEntityJsonResult.isBoolean());
    assertFalse(actualAsEntityJsonResult.isDouble());
    assertFalse(actualAsEntityJsonResult.isFloat());
    assertFalse(actualAsEntityJsonResult.isFloatingPointNumber());
    assertFalse(actualAsEntityJsonResult.isInt());
    assertFalse(actualAsEntityJsonResult.isIntegralNumber());
    assertFalse(actualAsEntityJsonResult.isLong());
    assertFalse(actualAsEntityJsonResult.isMissingNode());
    assertFalse(actualAsEntityJsonResult.isNull());
    assertFalse(actualAsEntityJsonResult.isNumber());
    assertFalse(actualAsEntityJsonResult.isPojo());
    assertFalse(actualAsEntityJsonResult.isShort());
    assertFalse(actualAsEntityJsonResult.isTextual());
    assertFalse(actualAsEntityJsonResult.isValueNode());
    assertFalse(actualAsEntityJsonResult.iterator().hasNext());
    assertTrue(actualAsEntityJsonResult.isContainerNode());
    assertTrue(actualAsEntityJsonResult.isEmpty());
    assertTrue(actualAsEntityJsonResult.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link MessageML#asEntityJson(ObjectNode)}
   */
  @Test
  public void testAsEntityJson3() {
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
   * Method under test: {@link MessageML#validate()}
   */
  @Test
  public void testValidate() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class, () -> (new MessageML(FormatEnum.PRESENTATIONML, "1.0.2")).validate());
  }

  /**
   * Method under test: {@link MessageML#validate()}
   */
  @Test
  public void testValidate2() throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.setChime(true);
    messageML.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> messageML.validate());
  }

  /**
   * Method under test: {@link MessageML#validate()}
   */
  @Test
  public void testValidate3() throws InvalidInputException {
    // Arrange
    MessageML messageML = new MessageML(FormatEnum.MESSAGEML, "1.0.2");
    messageML.setChime(true);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> messageML.validate());
  }

  /**
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

    // Assert that nothing has changed
    assertEquals(FormatEnum.MESSAGEML, actualMessageML.getFormat());
    assertTrue(actualMessageML.getChildren().isEmpty());
    assertTrue(actualMessageML.getAttributes().isEmpty());
    assertTrue(actualIsChimeResult);
    assertEquals(MessageML.MESSAGEML_TAG, actualMessageML.getMessageMLTag());
    assertEquals(MessageML.PRESENTATIONML_TAG, actualPresentationMLTag);
  }
}
