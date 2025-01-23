package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class DateSelectorNodeDiffblueTest {
  /**
   * Test {@link DateSelectorNode#DateSelectorNode(String)}.
   * <p>
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

  /**
   * Test {@link DateSelectorNode#getText()}.
   * <ul>
   *   <li>Given {@link DateSelectorNode#DateSelectorNode(String)} with placeholder
   * is {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateSelectorNode#getText()}
   */
  @Test
  public void testGetText_givenDateSelectorNodeWithPlaceholderIsNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new DateSelectorNode(null)).getText());
  }

  /**
   * Test {@link DateSelectorNode#getText()}.
   * <ul>
   *   <li>Given {@link DateSelectorNode#DateSelectorNode(String)} with
   * {@code Placeholder}.</li>
   *   <li>Then return {@code :[Placeholder]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateSelectorNode#getText()}
   */
  @Test
  public void testGetText_givenDateSelectorNodeWithPlaceholder_thenReturnPlaceholder() {
    // Arrange, Act and Assert
    assertEquals(":[Placeholder]", (new DateSelectorNode("Placeholder")).getText());
  }
}
