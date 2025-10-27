package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ButtonNodeDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link ButtonNode}
   */
  @Test
  public void testNewButtonNode() {
    // Arrange and Act
    ButtonNode actualButtonNode = new ButtonNode();

    // Assert
    assertEquals("", actualButtonNode.getText());
    assertNull(actualButtonNode.getParent());
    assertNull(actualButtonNode.getFirstChild());
    assertNull(actualButtonNode.getLastChild());
    assertNull(actualButtonNode.getNext());
    assertNull(actualButtonNode.getPrevious());
  }
}
