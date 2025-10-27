package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class SelectNodeDiffblueTest {
  /**
   * Method under test: {@link SelectNode#getText()}
   */
  @Test
  public void testGetText() {
    // Arrange, Act and Assert
    assertEquals("Label", (new SelectNode("Placeholder", "Label", "127.0.0.1")).getText());
    assertEquals("", (new SelectNode("Placeholder", "", "127.0.0.1")).getText());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SelectNode#SelectNode(String, String, String)}
   *   <li>{@link SelectNode#getClosingDelimiter()}
   *   <li>{@link SelectNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SelectNode actualSelectNode = new SelectNode("Placeholder", "Label", "127.0.0.1");
    String actualClosingDelimiter = actualSelectNode.getClosingDelimiter();

    // Assert
    assertEquals(" ", actualSelectNode.getOpeningDelimiter());
    assertEquals(" \n", actualClosingDelimiter);
    assertEquals("Label", actualSelectNode.getText());
    assertNull(actualSelectNode.getParent());
    assertNull(actualSelectNode.getFirstChild());
    assertNull(actualSelectNode.getLastChild());
    assertNull(actualSelectNode.getNext());
    assertNull(actualSelectNode.getPrevious());
  }
}
