package org.symphonyoss.symphony.messageml.markdown.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.Test;

public class TagNodeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TagNode#TagNode(String, String, JsonNode)}
   *   <li>{@link TagNode#getData()}
   *   <li>{@link TagNode#getPrefix()}
   *   <li>{@link TagNode#getText()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    MissingNode data = MissingNode.getInstance();

    // Act
    TagNode actualTagNode = new TagNode("Prefix", "Text", data);
    JsonNode actualData = actualTagNode.getData();
    String actualPrefix = actualTagNode.getPrefix();

    // Assert
    assertEquals("Prefix", actualPrefix);
    assertEquals("Text", actualTagNode.getText());
    assertNull(actualTagNode.getFirstChild());
    assertNull(actualTagNode.getLastChild());
    assertNull(actualTagNode.getNext());
    assertNull(actualTagNode.getParent());
    assertNull(actualTagNode.getPrevious());
    assertSame(data, actualData);
  }
}
