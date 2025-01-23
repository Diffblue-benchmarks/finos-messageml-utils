package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class RadioNodeDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Text is empty string.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RadioNode#RadioNode()}
   *   <li>{@link RadioNode#getClosingDelimiter()}
   *   <li>{@link RadioNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_thenReturnTextIsEmptyString() {
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Label}.</li>
   *   <li>Then return Text is {@code Label}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RadioNode#RadioNode(String)}
   *   <li>{@link RadioNode#getClosingDelimiter()}
   *   <li>{@link RadioNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenLabel_thenReturnTextIsLabel() {
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

  /**
   * Test {@link RadioNode#getText()}.
   * <ul>
   *   <li>Given {@link RadioNode#RadioNode(String)} with label is empty
   * string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RadioNode#getText()}
   */
  @Test
  public void testGetText_givenRadioNodeWithLabelIsEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new RadioNode("")).getText());
  }

  /**
   * Test {@link RadioNode#getText()}.
   * <ul>
   *   <li>Given {@link RadioNode#RadioNode(String)} with {@code Label}.</li>
   *   <li>Then return {@code Label}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RadioNode#getText()}
   */
  @Test
  public void testGetText_givenRadioNodeWithLabel_thenReturnLabel() {
    // Arrange, Act and Assert
    assertEquals("Label", (new RadioNode("Label")).getText());
  }

  /**
   * Test {@link RadioNode#getText()}.
   * <ul>
   *   <li>Given {@link RadioNode#RadioNode()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RadioNode#getText()}
   */
  @Test
  public void testGetText_givenRadioNode_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new RadioNode()).getText());
  }
}
