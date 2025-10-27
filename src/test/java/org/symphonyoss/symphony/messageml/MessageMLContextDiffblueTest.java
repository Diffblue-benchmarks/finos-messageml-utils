package org.symphonyoss.symphony.messageml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.List;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.elements.BulletList;
import org.symphonyoss.symphony.messageml.elements.Element;
import org.symphonyoss.symphony.messageml.elements.FormatEnum;
import org.symphonyoss.symphony.messageml.elements.ListItem;
import org.symphonyoss.symphony.messageml.elements.MessageML;
import org.symphonyoss.symphony.messageml.elements.TextNode;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.exceptions.ProcessingException;
import org.symphonyoss.symphony.messageml.util.IDataProvider;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;

public class MessageMLContextDiffblueTest {
  /**
   * Method under test:
   * {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}
   */
  @Test
  public void testParseMarkdown()
      throws IOException, IllegalStateException, InvalidInputException, ProcessingException {
    // Arrange
    MessageMLContext messageMLContext = new MessageMLContext(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();

    // Act
    messageMLContext.parseMarkdown("Not all who wander are lost", entities, MissingNode.getInstance());

    // Assert
    JsonNode entities2 = messageMLContext.getEntities();
    assertTrue(entities2 instanceof ObjectNode);
    JsonParser traverseResult = entities2.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    MessageML messageML = messageMLContext.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof TextNode);
    assertEquals("<div data-format=\"PresentationML\" data-version=\"2.0\">Not all who wander are lost</div>",
        messageMLContext.getPresentationML());
    assertEquals("Not all who wander are lost", messageMLContext.getMarkdown());
    assertEquals("Not all who wander are lost", messageMLContext.getText());
    assertEquals("Not all who wander are lost", ((TextNode) getResult).getText());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("div", messageML.getPresentationMLTag());
    assertEquals("messageML", messageML.getMessageMLTag());
    assertEquals("{ }", entities2.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertNull(messageML.getParent());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, entities2.size());
    assertEquals(0, getResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, messageML.size());
    assertEquals(JsonNodeType.OBJECT, entities2.getNodeType());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertEquals(FormatEnum.PRESENTATIONML, messageML.getFormat());
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
    assertFalse(entities2.isArray());
    assertFalse(entities2.isBigDecimal());
    assertFalse(entities2.isBigInteger());
    assertFalse(entities2.isBinary());
    assertFalse(entities2.isBoolean());
    assertFalse(entities2.isDouble());
    assertFalse(entities2.isFloat());
    assertFalse(entities2.isFloatingPointNumber());
    assertFalse(entities2.isInt());
    assertFalse(entities2.isIntegralNumber());
    assertFalse(entities2.isLong());
    assertFalse(entities2.isMissingNode());
    assertFalse(entities2.isNull());
    assertFalse(entities2.isNumber());
    assertFalse(entities2.isPojo());
    assertFalse(entities2.isShort());
    assertFalse(entities2.isTextual());
    assertFalse(entities2.isValueNode());
    assertFalse(entities2.iterator().hasNext());
    assertFalse(messageML.isChime());
    assertTrue(entities2.isContainerNode());
    assertTrue(entities2.isEmpty());
    assertTrue(entities2.isObject());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertTrue(messageML.getAttributes().isEmpty());
    assertEquals(entities2, messageMLContext.getEntityJson());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Method under test:
   * {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}
   */
  @Test
  public void testParseMarkdown2()
      throws IOException, IllegalStateException, InvalidInputException, ProcessingException {
    // Arrange
    MessageMLContext messageMLContext = new MessageMLContext(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();

    // Act
    messageMLContext.parseMarkdown(" * ", entities, MissingNode.getInstance());

    // Assert
    JsonNode entities2 = messageMLContext.getEntities();
    assertTrue(entities2 instanceof ObjectNode);
    JsonParser traverseResult = entities2.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    MessageML messageML = messageMLContext.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof BulletList);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    Element getResult2 = children2.get(0);
    assertTrue(getResult2 instanceof ListItem);
    assertEquals("", messageMLContext.getText());
    assertEquals("- \n", messageMLContext.getMarkdown());
    assertEquals("<div data-format=\"PresentationML\" data-version=\"2.0\"><ul><li></li></ul></div>",
        messageMLContext.getPresentationML());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("div", messageML.getPresentationMLTag());
    assertEquals("li", getResult2.getMessageMLTag());
    assertEquals("li", getResult2.getPresentationMLTag());
    assertEquals("messageML", messageML.getMessageMLTag());
    assertEquals("ul", getResult.getMessageMLTag());
    assertEquals("ul", getResult.getPresentationMLTag());
    assertEquals("{ }", entities2.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(messageML.getParent());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, entities2.size());
    assertEquals(0, getResult2.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, getResult.size());
    assertEquals(1, messageML.size());
    assertEquals(JsonNodeType.OBJECT, entities2.getNodeType());
    assertEquals(FormatEnum.PRESENTATIONML, getResult2.getFormat());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertEquals(FormatEnum.PRESENTATIONML, messageML.getFormat());
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
    assertFalse(entities2.isArray());
    assertFalse(entities2.isBigDecimal());
    assertFalse(entities2.isBigInteger());
    assertFalse(entities2.isBinary());
    assertFalse(entities2.isBoolean());
    assertFalse(entities2.isDouble());
    assertFalse(entities2.isFloat());
    assertFalse(entities2.isFloatingPointNumber());
    assertFalse(entities2.isInt());
    assertFalse(entities2.isIntegralNumber());
    assertFalse(entities2.isLong());
    assertFalse(entities2.isMissingNode());
    assertFalse(entities2.isNull());
    assertFalse(entities2.isNumber());
    assertFalse(entities2.isPojo());
    assertFalse(entities2.isShort());
    assertFalse(entities2.isTextual());
    assertFalse(entities2.isValueNode());
    assertFalse(entities2.iterator().hasNext());
    assertFalse(messageML.isChime());
    assertTrue(entities2.isContainerNode());
    assertTrue(entities2.isEmpty());
    assertTrue(entities2.isObject());
    assertTrue(getResult2.getChildren().isEmpty());
    assertTrue(getResult2.getAttributes().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertTrue(messageML.getAttributes().isEmpty());
    assertEquals(entities2, messageMLContext.getEntityJson());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Method under test:
   * {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}
   */
  @Test
  public void testParseMarkdown3()
      throws IOException, IllegalStateException, InvalidInputException, ProcessingException {
    // Arrange
    MessageMLContext messageMLContext = new MessageMLContext(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();

    // Act
    messageMLContext.parseMarkdown("_", entities, MissingNode.getInstance());

    // Assert
    JsonNode entities2 = messageMLContext.getEntities();
    assertTrue(entities2 instanceof ObjectNode);
    JsonParser traverseResult = entities2.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    MessageML messageML = messageMLContext.getMessageML();
    List<Element> children = messageML.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof TextNode);
    assertEquals("<div data-format=\"PresentationML\" data-version=\"2.0\">_</div>",
        messageMLContext.getPresentationML());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("_", messageMLContext.getMarkdown());
    assertEquals("_", messageMLContext.getText());
    assertEquals("_", ((TextNode) getResult).getText());
    assertEquals("div", messageML.getPresentationMLTag());
    assertEquals("messageML", messageML.getMessageMLTag());
    assertEquals("{ }", entities2.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(getResult.getMessageMLTag());
    assertNull(getResult.getPresentationMLTag());
    assertNull(messageML.getParent());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, entities2.size());
    assertEquals(0, getResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, messageML.size());
    assertEquals(JsonNodeType.OBJECT, entities2.getNodeType());
    assertEquals(FormatEnum.PRESENTATIONML, getResult.getFormat());
    assertEquals(FormatEnum.PRESENTATIONML, messageML.getFormat());
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
    assertFalse(entities2.isArray());
    assertFalse(entities2.isBigDecimal());
    assertFalse(entities2.isBigInteger());
    assertFalse(entities2.isBinary());
    assertFalse(entities2.isBoolean());
    assertFalse(entities2.isDouble());
    assertFalse(entities2.isFloat());
    assertFalse(entities2.isFloatingPointNumber());
    assertFalse(entities2.isInt());
    assertFalse(entities2.isIntegralNumber());
    assertFalse(entities2.isLong());
    assertFalse(entities2.isMissingNode());
    assertFalse(entities2.isNull());
    assertFalse(entities2.isNumber());
    assertFalse(entities2.isPojo());
    assertFalse(entities2.isShort());
    assertFalse(entities2.isTextual());
    assertFalse(entities2.isValueNode());
    assertFalse(entities2.iterator().hasNext());
    assertFalse(messageML.isChime());
    assertTrue(entities2.isContainerNode());
    assertTrue(entities2.isEmpty());
    assertTrue(entities2.isObject());
    assertTrue(getResult.getChildren().isEmpty());
    assertTrue(getResult.getAttributes().isEmpty());
    assertTrue(messageML.getAttributes().isEmpty());
    assertEquals(entities2, messageMLContext.getEntityJson());
    assertSame(messageML, getResult.getParent());
  }

  /**
   * Method under test:
   * {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}
   */
  @Test
  public void testParseMarkdown4()
      throws IOException, IllegalStateException, InvalidInputException, ProcessingException {
    // Arrange
    MessageMLContext messageMLContext = new MessageMLContext(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();

    // Act
    messageMLContext.parseMarkdown("", entities, MissingNode.getInstance());

    // Assert
    JsonNode entities2 = messageMLContext.getEntities();
    assertTrue(entities2 instanceof ObjectNode);
    JsonParser traverseResult = entities2.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("", messageMLContext.getMarkdown());
    assertEquals("", messageMLContext.getText());
    assertEquals("<div data-format=\"PresentationML\" data-version=\"2.0\"></div>",
        messageMLContext.getPresentationML());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    MessageML messageML = messageMLContext.getMessageML();
    assertEquals("div", messageML.getPresentationMLTag());
    assertEquals("messageML", messageML.getMessageMLTag());
    assertEquals("{ }", entities2.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(messageML.getParent());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, entities2.size());
    assertEquals(0, messageML.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(JsonNodeType.OBJECT, entities2.getNodeType());
    assertEquals(FormatEnum.PRESENTATIONML, messageML.getFormat());
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
    assertFalse(entities2.isArray());
    assertFalse(entities2.isBigDecimal());
    assertFalse(entities2.isBigInteger());
    assertFalse(entities2.isBinary());
    assertFalse(entities2.isBoolean());
    assertFalse(entities2.isDouble());
    assertFalse(entities2.isFloat());
    assertFalse(entities2.isFloatingPointNumber());
    assertFalse(entities2.isInt());
    assertFalse(entities2.isIntegralNumber());
    assertFalse(entities2.isLong());
    assertFalse(entities2.isMissingNode());
    assertFalse(entities2.isNull());
    assertFalse(entities2.isNumber());
    assertFalse(entities2.isPojo());
    assertFalse(entities2.isShort());
    assertFalse(entities2.isTextual());
    assertFalse(entities2.isValueNode());
    assertFalse(entities2.iterator().hasNext());
    assertFalse(messageML.isChime());
    assertTrue(entities2.isContainerNode());
    assertTrue(entities2.isEmpty());
    assertTrue(entities2.isObject());
    assertTrue(messageML.getChildren().isEmpty());
    assertTrue(messageML.getAttributes().isEmpty());
    assertEquals(entities2, messageMLContext.getEntityJson());
  }

  /**
   * Method under test: {@link MessageMLContext#getMessageML()}
   */
  @Test
  public void testGetMessageML() throws IllegalStateException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new MessageMLContext(new NoOpDataProvider())).getMessageML());
  }

  /**
   * Method under test: {@link MessageMLContext#getPresentationML()}
   */
  @Test
  public void testGetPresentationML() throws IllegalStateException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new MessageMLContext(new NoOpDataProvider())).getPresentationML());
  }

  /**
   * Method under test: {@link MessageMLContext#getEntityJson()}
   */
  @Test
  public void testGetEntityJson() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new MessageMLContext(new NoOpDataProvider())).getEntityJson());
  }

  /**
   * Method under test: {@link MessageMLContext#getMarkdown()}
   */
  @Test
  public void testGetMarkdown() throws IllegalStateException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new MessageMLContext(new NoOpDataProvider())).getMarkdown());
  }

  /**
   * Method under test: {@link MessageMLContext#getEntities()}
   */
  @Test
  public void testGetEntities() throws IllegalStateException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new MessageMLContext(new NoOpDataProvider())).getEntities());
  }

  /**
   * Method under test: {@link MessageMLContext#getText()}
   */
  @Test
  public void testGetText() throws IllegalStateException, InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new MessageMLContext(new NoOpDataProvider())).getText());
    assertThrows(IllegalStateException.class, () -> (new MessageMLContext(new NoOpDataProvider())).getText(true));
  }

  /**
   * Method under test: {@link MessageMLContext#getBiContext()}
   */
  @Test
  public void testGetBiContext() {
    // Arrange, Act and Assert
    assertTrue((new MessageMLContext(new NoOpDataProvider())).getBiContext().getItems().isEmpty());
  }

  /**
   * Method under test: {@link MessageMLContext#MessageMLContext(IDataProvider)}
   */
  @Test
  public void testNewMessageMLContext() {
    // Arrange, Act and Assert
    assertTrue((new MessageMLContext(new NoOpDataProvider())).getBiContext().getItems().isEmpty());
  }
}
