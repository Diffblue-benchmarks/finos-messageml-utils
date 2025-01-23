package org.symphonyoss.symphony.messageml.markdown.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class TableCellNodeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TableCellNode}
   *   <li>{@link TableCellNode#getDelimiter()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TableCellNode actualTableCellNode = new TableCellNode();

    // Assert
    assertEquals("   ", actualTableCellNode.getDelimiter());
    assertNull(actualTableCellNode.getParent());
    assertNull(actualTableCellNode.getFirstChild());
    assertNull(actualTableCellNode.getLastChild());
    assertNull(actualTableCellNode.getNext());
    assertNull(actualTableCellNode.getPrevious());
  }
}
