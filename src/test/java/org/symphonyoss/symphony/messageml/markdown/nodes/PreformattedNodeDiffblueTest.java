package org.symphonyoss.symphony.messageml.markdown.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class PreformattedNodeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PreformattedNode}
   *   <li>{@link PreformattedNode#getClosingDelimiter()}
   *   <li>{@link PreformattedNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
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
