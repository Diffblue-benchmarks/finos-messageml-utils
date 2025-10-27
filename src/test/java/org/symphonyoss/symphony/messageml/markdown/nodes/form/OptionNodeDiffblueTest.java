package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class OptionNodeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OptionNode}
   *   <li>{@link OptionNode#getClosingDelimiter()}
   *   <li>{@link OptionNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OptionNode actualOptionNode = new OptionNode();
    String actualClosingDelimiter = actualOptionNode.getClosingDelimiter();

    // Assert
    assertEquals("-", actualOptionNode.getOpeningDelimiter());
    assertEquals("\n", actualClosingDelimiter);
    assertNull(actualOptionNode.getText());
    assertNull(actualOptionNode.getParent());
    assertNull(actualOptionNode.getFirstChild());
    assertNull(actualOptionNode.getLastChild());
    assertNull(actualOptionNode.getNext());
    assertNull(actualOptionNode.getPrevious());
  }
}
