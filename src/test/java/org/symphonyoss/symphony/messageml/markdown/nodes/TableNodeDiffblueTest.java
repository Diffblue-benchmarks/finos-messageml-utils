package org.symphonyoss.symphony.messageml.markdown.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TableNodeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TableNode}
   *   <li>{@link TableNode#getClosingDelimiter()}
   *   <li>{@link TableNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TableNode.<init>()", "String TableNode.getClosingDelimiter()",
      "String TableNode.getOpeningDelimiter()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    TableNode actualTableNode = new TableNode();
    String actualClosingDelimiter = actualTableNode.getClosingDelimiter();

    // Assert
    assertEquals("\n   \n", actualClosingDelimiter);
    assertEquals("\n   \n", actualTableNode.getOpeningDelimiter());
    assertNull(actualTableNode.getParent());
    assertNull(actualTableNode.getFirstChild());
    assertNull(actualTableNode.getLastChild());
    assertNull(actualTableNode.getNext());
    assertNull(actualTableNode.getPrevious());
  }
}
