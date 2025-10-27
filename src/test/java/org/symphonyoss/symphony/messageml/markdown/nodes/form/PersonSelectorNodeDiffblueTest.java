package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.commonmark.node.BlockQuote;
import org.junit.Test;

public class PersonSelectorNodeDiffblueTest {
  /**
   * Method under test: {@link PersonSelectorNode#getText()}
   */
  @Test
  public void testGetText() {
    // Arrange
    BlockQuote child = mock(BlockQuote.class);
    doNothing().when(child).unlink();

    PersonSelectorNode personSelectorNode = new PersonSelectorNode("Placeholder", "Label", "127.0.0.1");
    personSelectorNode.appendChild(child);

    // Act
    personSelectorNode.getText();

    // Assert
    verify(child).unlink();
  }

  /**
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
