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
   * Test {@link TagNode#TagNode(String, String, JsonNode)}.
   *
   * <p>Method under test: {@link TagNode#TagNode(String, String, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TagNode.<init>(String, String, JsonNode)"})
  public void testNewTagNode() {
    // Arrange
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act
    TagNode actualTagNode = new TagNode("Prefix", "Text", data);

    // Assert
    assertEquals("Prefix", actualTagNode.getPrefix());
    assertEquals("Text", actualTagNode.getText());
    assertNull(actualTagNode.getFirstChild());
    assertNull(actualTagNode.getLastChild());
    assertNull(actualTagNode.getNext());
    assertNull(actualTagNode.getParent());
    assertNull(actualTagNode.getPrevious());
    assertSame(data, actualTagNode.getData());
  }
}
