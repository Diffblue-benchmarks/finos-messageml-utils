package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class TextFieldNodeDiffblueTest {
  /**
   * Test {@link TextFieldNode#TextFieldNode(String, String, String, String)}.
   * <p>
   * Method under test:
   * {@link TextFieldNode#TextFieldNode(String, String, String, String)}
   */
  @Test
  public void testNewTextFieldNode() {
    // Arrange and Act
    TextFieldNode actualTextFieldNode = new TextFieldNode("Placeholder", "42", "Label", "127.0.0.1");

    // Assert
    assertNull(actualTextFieldNode.getParent());
    assertNull(actualTextFieldNode.getFirstChild());
    assertNull(actualTextFieldNode.getLastChild());
    assertNull(actualTextFieldNode.getNext());
    assertNull(actualTextFieldNode.getPrevious());
  }
}
