package org.symphonyoss.symphony.messageml.markdown.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PreformattedNodeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PreformattedNode}
   *   <li>{@link PreformattedNode#getClosingDelimiter()}
   *   <li>{@link PreformattedNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PreformattedNode.<init>()", "String PreformattedNode.getClosingDelimiter()",
      "String PreformattedNode.getOpeningDelimiter()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    PreformattedNode actualPreformattedNode = new PreformattedNode();
    String actualClosingDelimiter = actualPreformattedNode.getClosingDelimiter();

    // Assert
    assertEquals("\n", actualClosingDelimiter);
    assertEquals("\n", actualPreformattedNode.getOpeningDelimiter());
    assertNull(actualPreformattedNode.getParent());
    assertNull(actualPreformattedNode.getFirstChild());
    assertNull(actualPreformattedNode.getLastChild());
    assertNull(actualPreformattedNode.getNext());
    assertNull(actualPreformattedNode.getPrevious());
  }
}
