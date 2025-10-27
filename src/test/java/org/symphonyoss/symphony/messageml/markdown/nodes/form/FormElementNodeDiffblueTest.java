package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class FormElementNodeDiffblueTest {
  /**
   * Method under test: {@link FormElementNode#getOpeningDelimiter()}
   */
  @Test
  public void testGetOpeningDelimiter() {
    // Arrange, Act and Assert
    assertEquals("(Tag Representation On Markdown",
        (new FormElementNode("Tag Representation On Markdown")).getOpeningDelimiter());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FormElementNode#FormElementNode()}
   *   <li>{@link FormElementNode#getClosingDelimiter()}
   *   <li>{@link FormElementNode#getText()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FormElementNode actualFormElementNode = new FormElementNode();
    String actualClosingDelimiter = actualFormElementNode.getClosingDelimiter();

    // Assert
    assertEquals(")", actualClosingDelimiter);
    assertNull(actualFormElementNode.getText());
    assertNull(actualFormElementNode.getParent());
    assertNull(actualFormElementNode.getFirstChild());
    assertNull(actualFormElementNode.getLastChild());
    assertNull(actualFormElementNode.getNext());
    assertNull(actualFormElementNode.getPrevious());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FormElementNode#FormElementNode(String)}
   *   <li>{@link FormElementNode#getClosingDelimiter()}
   *   <li>{@link FormElementNode#getText()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    FormElementNode actualFormElementNode = new FormElementNode("Tag Representation On Markdown");
    String actualClosingDelimiter = actualFormElementNode.getClosingDelimiter();

    // Assert
    assertEquals("", actualFormElementNode.getText());
    assertEquals(")", actualClosingDelimiter);
    assertNull(actualFormElementNode.getParent());
    assertNull(actualFormElementNode.getFirstChild());
    assertNull(actualFormElementNode.getLastChild());
    assertNull(actualFormElementNode.getNext());
    assertNull(actualFormElementNode.getPrevious());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FormElementNode#FormElementNode(String, String)}
   *   <li>{@link FormElementNode#getClosingDelimiter()}
   *   <li>{@link FormElementNode#getText()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters3() {
    // Arrange and Act
    FormElementNode actualFormElementNode = new FormElementNode("Tag Representation On Markdown", "Text");
    String actualClosingDelimiter = actualFormElementNode.getClosingDelimiter();

    // Assert
    assertEquals(")", actualClosingDelimiter);
    assertEquals("Text", actualFormElementNode.getText());
    assertNull(actualFormElementNode.getParent());
    assertNull(actualFormElementNode.getFirstChild());
    assertNull(actualFormElementNode.getLastChild());
    assertNull(actualFormElementNode.getNext());
    assertNull(actualFormElementNode.getPrevious());
  }
}
