package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class CheckboxNodeDiffblueTest {
  /**
   * Method under test: {@link CheckboxNode#getText()}
   */
  @Test
  public void testGetText() {
    // Arrange, Act and Assert
    assertEquals("Label", (new CheckboxNode("Label")).getText());
    assertEquals("", (new CheckboxNode("")).getText());
    assertEquals("", (new CheckboxNode()).getText());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CheckboxNode#CheckboxNode()}
   *   <li>{@link CheckboxNode#getClosingDelimiter()}
   *   <li>{@link CheckboxNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CheckboxNode actualCheckboxNode = new CheckboxNode();
    String actualClosingDelimiter = actualCheckboxNode.getClosingDelimiter();

    // Assert
    assertEquals(" ", actualClosingDelimiter);
    assertEquals(" ", actualCheckboxNode.getOpeningDelimiter());
    assertEquals("", actualCheckboxNode.getText());
    assertNull(actualCheckboxNode.getParent());
    assertNull(actualCheckboxNode.getFirstChild());
    assertNull(actualCheckboxNode.getLastChild());
    assertNull(actualCheckboxNode.getNext());
    assertNull(actualCheckboxNode.getPrevious());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CheckboxNode#CheckboxNode(String)}
   *   <li>{@link CheckboxNode#getClosingDelimiter()}
   *   <li>{@link CheckboxNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    CheckboxNode actualCheckboxNode = new CheckboxNode("Label");
    String actualClosingDelimiter = actualCheckboxNode.getClosingDelimiter();

    // Assert
    assertEquals(" ", actualClosingDelimiter);
    assertEquals(" ", actualCheckboxNode.getOpeningDelimiter());
    assertEquals("Label", actualCheckboxNode.getText());
    assertNull(actualCheckboxNode.getParent());
    assertNull(actualCheckboxNode.getFirstChild());
    assertNull(actualCheckboxNode.getLastChild());
    assertNull(actualCheckboxNode.getNext());
    assertNull(actualCheckboxNode.getPrevious());
  }
}
