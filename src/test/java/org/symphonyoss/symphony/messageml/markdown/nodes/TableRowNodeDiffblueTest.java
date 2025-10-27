package org.symphonyoss.symphony.messageml.markdown.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class TableRowNodeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TableRowNode}
   *   <li>{@link TableRowNode#getDelimiter()}
   * </ul>
   */
  @Test
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
