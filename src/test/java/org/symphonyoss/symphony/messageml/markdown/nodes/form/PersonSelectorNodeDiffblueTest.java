package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
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
}
