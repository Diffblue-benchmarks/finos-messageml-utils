package org.symphonyoss.symphony.messageml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.elements.BulletList;
import org.symphonyoss.symphony.messageml.elements.Element;
import org.symphonyoss.symphony.messageml.elements.ListItem;
import org.symphonyoss.symphony.messageml.elements.MessageML;
import org.symphonyoss.symphony.messageml.elements.TextNode;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.exceptions.ProcessingException;
import org.symphonyoss.symphony.messageml.util.IDataProvider;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;

public class MessageMLContextDiffblueTest {
  /**
   * Test {@link MessageMLContext#MessageMLContext(IDataProvider)}.
   *
   * <p>Method under test: {@link MessageMLContext#MessageMLContext(IDataProvider)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageMLContext.<init>(IDataProvider)"})
  public void testNewMessageMLContext() {
    // Arrange, Act and Assert
    assertTrue(new MessageMLContext(new NoOpDataProvider()).getBiContext().getItems().isEmpty());
  }

  /**
   * Test {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}.
   *
   * <p>Method under test: {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageMLContext.parseMarkdown(String, JsonNode, JsonNode)"})
  public void testParseMarkdown()
      throws IllegalStateException, InvalidInputException, ProcessingException {
    // Arrange
    MessageMLContext messageMLContext = new MessageMLContext(new NoOpDataProvider());

    // Act
    messageMLContext.parseMarkdown(
        "Not all who wander are lost", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Assert
    List<Element> children = messageMLContext.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof TextNode);
    assertEquals(
        "<div data-format=\"PresentationML\" data-version=\"2.0\">Not all who wander are lost</div>",
        messageMLContext.getPresentationML());
    assertEquals("Not all who wander are lost", messageMLContext.getMarkdown());
    assertEquals("Not all who wander are lost", messageMLContext.getText());
    assertEquals("Not all who wander are lost", ((TextNode) getResult).getText());
  }

  /**
   * Test {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}.
   *
   * <p>Method under test: {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageMLContext.parseMarkdown(String, JsonNode, JsonNode)"})
  public void testParseMarkdown2()
      throws IllegalStateException, InvalidInputException, ProcessingException {
    // Arrange
    MessageMLContext messageMLContext = new MessageMLContext(new NoOpDataProvider());

    // Act
    messageMLContext.parseMarkdown("Not all who wander are lost", null, null);

    // Assert
    assertEquals(
        "<div data-format=\"PresentationML\" data-version=\"2.0\">Not all who wander are lost</div>",
        messageMLContext.getPresentationML());
    assertEquals("Not all who wander are lost", messageMLContext.getMarkdown());
    assertEquals("Not all who wander are lost", messageMLContext.getText());
  }

  /**
   * Test {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}.
   *
   * <p>Method under test: {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageMLContext.parseMarkdown(String, JsonNode, JsonNode)"})
  public void testParseMarkdown3() throws IllegalStateException, InvalidInputException {
    // Arrange
    MessageMLContext messageMLContext = new MessageMLContext(new NoOpDataProvider());

    // Act
    messageMLContext.parseMarkdown(" * ", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Assert
    List<Element> children = messageMLContext.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof BulletList);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    assertTrue(children2.get(0) instanceof ListItem);
    assertEquals("- \n", messageMLContext.getMarkdown());
    assertEquals(
        "<div data-format=\"PresentationML\" data-version=\"2.0\"><ul><li></li></ul></div>",
        messageMLContext.getPresentationML());
    assertEquals("ul", getResult.getMessageMLTag());
    assertEquals("ul", getResult.getPresentationMLTag());
    assertEquals(1, getResult.size());
  }

  /**
   * Test {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}.
   *
   * <p>Method under test: {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageMLContext.parseMarkdown(String, JsonNode, JsonNode)"})
  public void testParseMarkdown4()
      throws IllegalStateException, InvalidInputException, ProcessingException {
    // Arrange
    MessageMLContext messageMLContext = new MessageMLContext(new NoOpDataProvider());

    // Act
    messageMLContext.parseMarkdown("_", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Assert
    List<Element> children = messageMLContext.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof TextNode);
    assertEquals(
        "<div data-format=\"PresentationML\" data-version=\"2.0\">_</div>",
        messageMLContext.getPresentationML());
    assertEquals("_", messageMLContext.getMarkdown());
    assertEquals("_", messageMLContext.getText());
    assertEquals("_", ((TextNode) getResult).getText());
  }

  /**
   * Test {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}.
   *
   * <p>Method under test: {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageMLContext.parseMarkdown(String, JsonNode, JsonNode)"})
  public void testParseMarkdown5() throws IllegalStateException, InvalidInputException {
    // Arrange
    MessageMLContext messageMLContext = new MessageMLContext(new NoOpDataProvider());

    // Act
    messageMLContext.parseMarkdown("", DoubleNode.valueOf(10.0d), DoubleNode.valueOf(10.0d));

    // Assert
    JsonNode entities = messageMLContext.getEntities();
    assertTrue(entities instanceof ObjectNode);
    assertTrue(entities.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}.
   *
   * <p>Method under test: {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageMLContext.parseMarkdown(String, JsonNode, JsonNode)"})
  public void testParseMarkdown6() throws InvalidInputException {
    // Arrange
    MessageMLContext messageMLContext = new MessageMLContext(new NoOpDataProvider());

    // Act
    messageMLContext.parseMarkdown("", null, null);

    // Assert
    ObjectNode entityJson = messageMLContext.getEntityJson();
    assertTrue(entityJson.traverse() instanceof TreeTraversingParser);
    assertEquals("{ }", entityJson.toPrettyString());
    assertEquals(0, entityJson.size());
    assertEquals(JsonNodeType.OBJECT, entityJson.getNodeType());
    assertFalse(entityJson.isArray());
    assertFalse(entityJson.isBigDecimal());
    assertFalse(entityJson.isBigInteger());
    assertFalse(entityJson.isBinary());
    assertFalse(entityJson.isBoolean());
    assertFalse(entityJson.isDouble());
    assertFalse(entityJson.isFloat());
    assertFalse(entityJson.isFloatingPointNumber());
    assertFalse(entityJson.isInt());
    assertFalse(entityJson.isIntegralNumber());
    assertFalse(entityJson.isLong());
    assertFalse(entityJson.isMissingNode());
    assertFalse(entityJson.isNull());
    assertFalse(entityJson.isNumber());
    assertFalse(entityJson.isPojo());
    assertFalse(entityJson.isShort());
    assertFalse(entityJson.isTextual());
    assertFalse(entityJson.isValueNode());
    assertFalse(entityJson.iterator().hasNext());
    assertTrue(entityJson.isContainerNode());
    assertTrue(entityJson.isEmpty());
    assertTrue(entityJson.isObject());
  }

  /**
   * Test {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}.
   *
   * <p>Method under test: {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageMLContext.parseMarkdown(String, JsonNode, JsonNode)"})
  public void testParseMarkdown7() throws IllegalStateException, InvalidInputException {
    // Arrange
    MessageMLContext messageMLContext = new MessageMLContext(new NoOpDataProvider());
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode entities = new ArrayNode(nf);
    entities.addObject();

    // Act
    messageMLContext.parseMarkdown("", entities, DoubleNode.valueOf(10.0d));

    // Assert
    assertTrue(messageMLContext.getEntities() instanceof ObjectNode);
    assertEquals("", messageMLContext.getMarkdown());
    assertEquals(
        "<div data-format=\"PresentationML\" data-version=\"2.0\"></div>",
        messageMLContext.getPresentationML());
    MessageML messageML = messageMLContext.getMessageML();
    assertEquals(0, messageML.size());
    assertTrue(messageML.getChildren().isEmpty());
  }

  /**
   * Test {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}.
   *
   * <p>Method under test: {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageMLContext.parseMarkdown(String, JsonNode, JsonNode)"})
  public void testParseMarkdown8() throws IllegalStateException, InvalidInputException {
    // Arrange
    MessageMLContext messageMLContext = new MessageMLContext(new NoOpDataProvider());
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode entities = new ArrayNode(nf);
    entities.addObject();
    entities.addObject();

    // Act
    messageMLContext.parseMarkdown("", entities, DoubleNode.valueOf(10.0d));

    // Assert
    assertTrue(messageMLContext.getEntities() instanceof ObjectNode);
    assertEquals("", messageMLContext.getMarkdown());
    assertEquals(
        "<div data-format=\"PresentationML\" data-version=\"2.0\"></div>",
        messageMLContext.getPresentationML());
    MessageML messageML = messageMLContext.getMessageML();
    assertEquals(0, messageML.size());
    assertTrue(messageML.getChildren().isEmpty());
  }

  /**
   * Test {@link MessageMLContext#getMessageML()}.
   *
   * <p>Method under test: {@link MessageMLContext#getMessageML()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageML MessageMLContext.getMessageML()"})
  public void testGetMessageML() throws IllegalStateException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new MessageMLContext(new NoOpDataProvider()).getMessageML());
  }

  /**
   * Test {@link MessageMLContext#getPresentationML()}.
   *
   * <p>Method under test: {@link MessageMLContext#getPresentationML()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MessageMLContext.getPresentationML()"})
  public void testGetPresentationML() throws IllegalStateException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new MessageMLContext(new NoOpDataProvider()).getPresentationML());
  }

  /**
   * Test {@link MessageMLContext#getEntityJson()}.
   *
   * <p>Method under test: {@link MessageMLContext#getEntityJson()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode MessageMLContext.getEntityJson()"})
  public void testGetEntityJson() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new MessageMLContext(new NoOpDataProvider()).getEntityJson());
  }

  /**
   * Test {@link MessageMLContext#getMarkdown()}.
   *
   * <p>Method under test: {@link MessageMLContext#getMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MessageMLContext.getMarkdown()"})
  public void testGetMarkdown() throws IllegalStateException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new MessageMLContext(new NoOpDataProvider()).getMarkdown());
  }

  /**
   * Test {@link MessageMLContext#getEntities()}.
   *
   * <p>Method under test: {@link MessageMLContext#getEntities()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode MessageMLContext.getEntities()"})
  public void testGetEntities() throws IllegalStateException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new MessageMLContext(new NoOpDataProvider()).getEntities());
  }

  /**
   * Test {@link MessageMLContext#getText()}.
   *
   * <p>Method under test: {@link MessageMLContext#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MessageMLContext.getText()"})
  public void testGetText()
      throws IllegalStateException, InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> new MessageMLContext(new NoOpDataProvider()).getText());
  }

  /**
   * Test {@link MessageMLContext#getText(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link MessageMLContext#getText(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MessageMLContext.getText(boolean)"})
  public void testGetTextWithBoolean()
      throws IllegalStateException, InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new MessageMLContext(new NoOpDataProvider()).getText(true));
  }

  /**
   * Test {@link MessageMLContext#getBiContext()}.
   *
   * <p>Method under test: {@link MessageMLContext#getBiContext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.messageml.bi.BiContext MessageMLContext.getBiContext()"
  })
  public void testGetBiContext() {
    // Arrange, Act and Assert
    assertTrue(new MessageMLContext(new NoOpDataProvider()).getBiContext().getItems().isEmpty());
  }
}
