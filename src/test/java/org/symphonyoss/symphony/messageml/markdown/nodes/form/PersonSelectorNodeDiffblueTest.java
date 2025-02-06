package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import org.junit.Ignore;
import org.junit.Test;

public class PersonSelectorNodeDiffblueTest {
  /**
   * Test {@link PersonSelectorNode#PersonSelectorNode(String, String, String)}.
   * <p>
   * Method under test:
   * {@link PersonSelectorNode#PersonSelectorNode(String, String, String)}
   */
  @Test
  public void testNewPersonSelectorNode() {
    // Arrange and Act
    PersonSelectorNode actualPersonSelectorNode = new PersonSelectorNode("Placeholder", "Label", "127.0.0.1");

    // Assert
    assertNull(actualPersonSelectorNode.getParent());
    assertNull(actualPersonSelectorNode.getFirstChild());
    assertNull(actualPersonSelectorNode.getLastChild());
    assertNull(actualPersonSelectorNode.getNext());
    assertNull(actualPersonSelectorNode.getPrevious());
  }

  /**
   * Test {@link PersonSelectorNode#getText()}.
   * <p>
   * Method under test: {@link PersonSelectorNode#getText()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetText() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new PersonSelectorNode("Placeholder", "Label", "127.0.0.1")).getText();
  }
}
