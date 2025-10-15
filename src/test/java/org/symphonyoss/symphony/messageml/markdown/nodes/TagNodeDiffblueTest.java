package org.symphonyoss.symphony.messageml.markdown.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TagNodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TagNode#TagNode(String, String, JsonNode)}
   *   <li>{@link TagNode#getData()}
   *   <li>{@link TagNode#getPrefix()}
   *   <li>{@link TagNode#getText()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TagNode.<init>(String, String, JsonNode)",
    "JsonNode TagNode.getData()",
    "String TagNode.getPrefix()",
    "String TagNode.getText()"
  })
  public void testGettersAndSetters() {
    // Arrange
    DoubleNode data = DoubleNode.valueOf(10.0d);

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
