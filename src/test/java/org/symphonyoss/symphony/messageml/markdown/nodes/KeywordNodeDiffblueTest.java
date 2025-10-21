package org.symphonyoss.symphony.messageml.markdown.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KeywordNodeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KeywordNode#KeywordNode(String, String)}
   *   <li>{@link KeywordNode#getPrefix()}
   *   <li>{@link KeywordNode#getText()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KeywordNode.<init>(String, String)", "String KeywordNode.getPrefix()",
      "String KeywordNode.getText()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    KeywordNode actualKeywordNode = new KeywordNode("Prefix", "Text");
    String actualPrefix = actualKeywordNode.getPrefix();

    // Assert
    assertEquals("Prefix", actualPrefix);
    assertEquals("Text", actualKeywordNode.getText());
    assertNull(actualKeywordNode.getFirstChild());
    assertNull(actualKeywordNode.getLastChild());
    assertNull(actualKeywordNode.getNext());
    assertNull(actualKeywordNode.getParent());
    assertNull(actualKeywordNode.getPrevious());
  }
}
