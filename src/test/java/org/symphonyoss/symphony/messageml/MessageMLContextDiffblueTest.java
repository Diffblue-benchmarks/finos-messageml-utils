package org.symphonyoss.symphony.messageml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.List;
import org.junit.Test;
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
   * <p>
   * Method under test: {@link MessageMLContext#MessageMLContext(IDataProvider)}
   */
  @Test
  public void testNewMessageMLContext() {
    // Arrange, Act and Assert
    assertTrue((new MessageMLContext(new NoOpDataProvider())).getBiContext().getItems().isEmpty());
  }

  /**
   * Test {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}.
   * <p>
   * Method under test:
   * {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}
   */
  @Test
  public void testParseMarkdown() throws IllegalStateException, InvalidInputException, ProcessingException {
    // Arrange
    MessageMLContext messageMLContext = new MessageMLContext(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();

    // Act
    messageMLContext.parseMarkdown("Not all who wander are lost", entities, MissingNode.getInstance());

    // Assert
    List<Element> children = messageMLContext.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof TextNode);
    assertEquals("<div data-format=\"PresentationML\" data-version=\"2.0\">Not all who wander are lost</div>",
        messageMLContext.getPresentationML());
    assertEquals("Not all who wander are lost", messageMLContext.getMarkdown());
    assertEquals("Not all who wander are lost", messageMLContext.getText());
    assertEquals("Not all who wander are lost", ((TextNode) getResult).getText());
  }

  /**
   * Test {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}.
   * <p>
   * Method under test:
   * {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}
   */
  @Test
  public void testParseMarkdown2() throws IllegalStateException, InvalidInputException {
    // Arrange
    MessageMLContext messageMLContext = new MessageMLContext(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();

    // Act
    messageMLContext.parseMarkdown(" * ", entities, MissingNode.getInstance());

    // Assert
    List<Element> children = messageMLContext.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof BulletList);
    List<Element> children2 = getResult.getChildren();
    assertEquals(1, children2.size());
    assertTrue(children2.get(0) instanceof ListItem);
    assertEquals("- \n", messageMLContext.getMarkdown());
    assertEquals("<div data-format=\"PresentationML\" data-version=\"2.0\"><ul><li></li></ul></div>",
        messageMLContext.getPresentationML());
    assertEquals("ul", getResult.getMessageMLTag());
    assertEquals("ul", getResult.getPresentationMLTag());
    assertEquals(1, getResult.size());
  }

  /**
   * Test {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}.
   * <p>
   * Method under test:
   * {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}
   */
  @Test
  public void testParseMarkdown3() throws IllegalStateException, InvalidInputException, ProcessingException {
    // Arrange
    MessageMLContext messageMLContext = new MessageMLContext(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();

    // Act
    messageMLContext.parseMarkdown("_", entities, MissingNode.getInstance());

    // Assert
    List<Element> children = messageMLContext.getMessageML().getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof TextNode);
    assertEquals("<div data-format=\"PresentationML\" data-version=\"2.0\">_</div>",
        messageMLContext.getPresentationML());
    assertEquals("_", messageMLContext.getMarkdown());
    assertEquals("_", messageMLContext.getText());
    assertEquals("_", ((TextNode) getResult).getText());
  }

  /**
   * Test {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}.
   * <p>
   * Method under test:
   * {@link MessageMLContext#parseMarkdown(String, JsonNode, JsonNode)}
   */
  @Test
  public void testParseMarkdown4() throws IllegalStateException, InvalidInputException {
    // Arrange
    MessageMLContext messageMLContext = new MessageMLContext(new NoOpDataProvider());
    MissingNode entities = MissingNode.getInstance();

    // Act
    messageMLContext.parseMarkdown("", entities, MissingNode.getInstance());

    // Assert
    assertEquals("", messageMLContext.getMarkdown());
    assertEquals("<div data-format=\"PresentationML\" data-version=\"2.0\"></div>",
        messageMLContext.getPresentationML());
    MessageML messageML = messageMLContext.getMessageML();
    assertEquals(0, messageML.size());
    assertTrue(messageML.getChildren().isEmpty());
  }

  /**
   * Test {@link MessageMLContext#getMessageML()}.
   * <p>
   * Method under test: {@link MessageMLContext#getMessageML()}
   */
  @Test
  public void testGetMessageML() throws IllegalStateException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new MessageMLContext(new NoOpDataProvider())).getMessageML());
  }

  /**
   * Test {@link MessageMLContext#getPresentationML()}.
   * <p>
   * Method under test: {@link MessageMLContext#getPresentationML()}
   */
  @Test
  public void testGetPresentationML() throws IllegalStateException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new MessageMLContext(new NoOpDataProvider())).getPresentationML());
  }

  /**
   * Test {@link MessageMLContext#getEntityJson()}.
   * <p>
   * Method under test: {@link MessageMLContext#getEntityJson()}
   */
  @Test
  public void testGetEntityJson() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new MessageMLContext(new NoOpDataProvider())).getEntityJson());
  }

  /**
   * Test {@link MessageMLContext#getMarkdown()}.
   * <p>
   * Method under test: {@link MessageMLContext#getMarkdown()}
   */
  @Test
  public void testGetMarkdown() throws IllegalStateException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new MessageMLContext(new NoOpDataProvider())).getMarkdown());
  }

  /**
   * Test {@link MessageMLContext#getEntities()}.
   * <p>
   * Method under test: {@link MessageMLContext#getEntities()}
   */
  @Test
  public void testGetEntities() throws IllegalStateException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new MessageMLContext(new NoOpDataProvider())).getEntities());
  }

  /**
   * Test {@link MessageMLContext#getText()}.
   * <p>
   * Method under test: {@link MessageMLContext#getText()}
   */
  @Test
  public void testGetText() throws IllegalStateException, InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new MessageMLContext(new NoOpDataProvider())).getText());
  }

  /**
   * Test {@link MessageMLContext#getText(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link MessageMLContext#getText(boolean)}
   */
  @Test
  public void testGetTextWithBoolean() throws IllegalStateException, InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new MessageMLContext(new NoOpDataProvider())).getText(true));
  }

  /**
   * Test {@link MessageMLContext#getBiContext()}.
   * <p>
   * Method under test: {@link MessageMLContext#getBiContext()}
   */
  @Test
  public void testGetBiContext() {
    // Arrange, Act and Assert
    assertTrue((new MessageMLContext(new NoOpDataProvider())).getBiContext().getItems().isEmpty());
  }
}
