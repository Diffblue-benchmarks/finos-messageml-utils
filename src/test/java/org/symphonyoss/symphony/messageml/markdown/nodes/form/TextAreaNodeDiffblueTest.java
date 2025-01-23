package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class TextAreaNodeDiffblueTest {
  /**
   * Test {@link TextAreaNode#TextAreaNode(String, String, String, String)}.
   * <p>
   * Method under test:
   * {@link TextAreaNode#TextAreaNode(String, String, String, String)}
   */
  @Test
  public void testNewTextAreaNode() {
    // Arrange and Act
    TextAreaNode actualTextAreaNode = new TextAreaNode("Placeholder", "42", "Label", "127.0.0.1");

    // Assert
    assertNull(actualTextAreaNode.getParent());
    assertNull(actualTextAreaNode.getFirstChild());
    assertNull(actualTextAreaNode.getLastChild());
    assertNull(actualTextAreaNode.getNext());
    assertNull(actualTextAreaNode.getPrevious());
  }
}
