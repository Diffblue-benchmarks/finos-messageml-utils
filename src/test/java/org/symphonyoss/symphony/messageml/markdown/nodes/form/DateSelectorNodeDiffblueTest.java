package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DateSelectorNodeDiffblueTest {
  /**
   * Test {@link DateSelectorNode#DateSelectorNode(String)}.
   *
   * <p>Method under test: {@link DateSelectorNode#DateSelectorNode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateSelectorNode.<init>(String)"})
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
   *
   * <ul>
   *   <li>Given {@link DateSelectorNode#DateSelectorNode(String)} with placeholder is {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link DateSelectorNode#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DateSelectorNode.getText()"})
  public void testGetText_givenDateSelectorNodeWithPlaceholderIsNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new DateSelectorNode(null).getText());
  }

  /**
   * Test {@link DateSelectorNode#getText()}.
   *
   * <ul>
   *   <li>Given {@link DateSelectorNode#DateSelectorNode(String)} with {@code Placeholder}.
   *   <li>Then return {@code :[Placeholder]}.
   * </ul>
   *
   * <p>Method under test: {@link DateSelectorNode#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DateSelectorNode.getText()"})
  public void testGetText_givenDateSelectorNodeWithPlaceholder_thenReturnPlaceholder() {
    // Arrange, Act and Assert
    assertEquals(":[Placeholder]", new DateSelectorNode("Placeholder").getText());
  }
}
