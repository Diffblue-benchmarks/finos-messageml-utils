package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import org.junit.Ignore;
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

  /**
   * Test {@link TextFieldNode#getText()}.
   * <p>
   * Method under test: {@link TextFieldNode#getText()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetText() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new TextFieldNode("Placeholder", "42", "Label", "127.0.0.1")).getText();
  }
}
