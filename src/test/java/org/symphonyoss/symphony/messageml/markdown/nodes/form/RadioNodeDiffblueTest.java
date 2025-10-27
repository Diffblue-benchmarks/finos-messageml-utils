package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class RadioNodeDiffblueTest {
  /**
   * Method under test: {@link RadioNode#getText()}
   */
  @Test
  public void testGetText() {
    // Arrange, Act and Assert
    assertEquals("Label", (new RadioNode("Label")).getText());
    assertEquals("", (new RadioNode("")).getText());
    assertEquals("", (new RadioNode()).getText());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RadioNode#RadioNode()}
   *   <li>{@link RadioNode#getClosingDelimiter()}
   *   <li>{@link RadioNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RadioNode actualRadioNode = new RadioNode();
    String actualClosingDelimiter = actualRadioNode.getClosingDelimiter();

    // Assert
    assertEquals(" ", actualClosingDelimiter);
    assertEquals(" ", actualRadioNode.getOpeningDelimiter());
    assertEquals("", actualRadioNode.getText());
    assertNull(actualRadioNode.getParent());
    assertNull(actualRadioNode.getFirstChild());
    assertNull(actualRadioNode.getLastChild());
    assertNull(actualRadioNode.getNext());
    assertNull(actualRadioNode.getPrevious());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RadioNode#RadioNode(String)}
   *   <li>{@link RadioNode#getClosingDelimiter()}
   *   <li>{@link RadioNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    RadioNode actualRadioNode = new RadioNode("Label");
    String actualClosingDelimiter = actualRadioNode.getClosingDelimiter();

    // Assert
    assertEquals(" ", actualClosingDelimiter);
    assertEquals(" ", actualRadioNode.getOpeningDelimiter());
    assertEquals("Label", actualRadioNode.getText());
    assertNull(actualRadioNode.getParent());
    assertNull(actualRadioNode.getFirstChild());
    assertNull(actualRadioNode.getLastChild());
    assertNull(actualRadioNode.getNext());
    assertNull(actualRadioNode.getPrevious());
  }
}
