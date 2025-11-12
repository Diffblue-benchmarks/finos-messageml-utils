package org.symphonyoss.symphony.messageml.markdown.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TableRowNodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TableRowNode}
   *   <li>{@link TableRowNode#getDelimiter()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableRowNode.<init>()", "java.lang.String TableRowNode.getDelimiter()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    TableRowNode actualTableRowNode = new TableRowNode();

    // Assert
    assertEquals("\n", actualTableRowNode.getDelimiter());
    assertNull(actualTableRowNode.getParent());
    assertNull(actualTableRowNode.getFirstChild());
    assertNull(actualTableRowNode.getLastChild());
    assertNull(actualTableRowNode.getNext());
    assertNull(actualTableRowNode.getPrevious());
  }
}
