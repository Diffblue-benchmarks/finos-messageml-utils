package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class DateSelectorNodeDiffblueTest {
  /**
   * Method under test: {@link DateSelectorNode#getText()}
   */
  @Test
  public void testGetText() {
    // Arrange, Act and Assert
    assertEquals(":[Placeholder]", (new DateSelectorNode("Placeholder")).getText());
    assertEquals("", (new DateSelectorNode(null)).getText());
  }

  /**
   * Method under test: {@link DateSelectorNode#DateSelectorNode(String)}
   */
  @Test
  public void testNewDateSelectorNode() {
    // Arrange and Act
    DateSelectorNode actualDateSelectorNode = new DateSelectorNode("Placeholder");

    // Assert
    assertEquals(":[Placeholder]", actualDateSelectorNode.getText());
    assertNull(actualDateSelectorNode.getParent());
    assertNull(actualDateSelectorNode.getFirstChild());
    assertNull(actualDateSelectorNode.getLastChild());
    assertNull(actualDateSelectorNode.getNext());
    assertNull(actualDateSelectorNode.getPrevious());
  }
}
