package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CheckboxNodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Text is empty string.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckboxNode#CheckboxNode()}
   *   <li>{@link CheckboxNode#getClosingDelimiter()}
   *   <li>{@link CheckboxNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CheckboxNode.<init>()",
    "void CheckboxNode.<init>(String)",
    "String CheckboxNode.getClosingDelimiter()",
    "String CheckboxNode.getOpeningDelimiter()"
  })
  public void testGettersAndSetters_thenReturnTextIsEmptyString() {
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
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Label}.
   *   <li>Then return Text is {@code Label}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckboxNode#CheckboxNode(String)}
   *   <li>{@link CheckboxNode#getClosingDelimiter()}
   *   <li>{@link CheckboxNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CheckboxNode.<init>()",
    "void CheckboxNode.<init>(String)",
    "String CheckboxNode.getClosingDelimiter()",
    "String CheckboxNode.getOpeningDelimiter()"
  })
  public void testGettersAndSetters_whenLabel_thenReturnTextIsLabel() {
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

  /**
   * Test {@link CheckboxNode#getText()}.
   *
   * <ul>
   *   <li>Given {@link CheckboxNode#CheckboxNode(String)} with label is {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CheckboxNode#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CheckboxNode.getText()"})
  public void testGetText_givenCheckboxNodeWithLabelIsNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new CheckboxNode(null).getText());
  }

  /**
   * Test {@link CheckboxNode#getText()}.
   *
   * <ul>
   *   <li>Given {@link CheckboxNode#CheckboxNode(String)} with label is space.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CheckboxNode#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CheckboxNode.getText()"})
  public void testGetText_givenCheckboxNodeWithLabelIsSpace_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new CheckboxNode(" ").getText());
  }

  /**
   * Test {@link CheckboxNode#getText()}.
   *
   * <ul>
   *   <li>Given {@link CheckboxNode#CheckboxNode(String)} with {@code Label}.
   *   <li>Then return {@code Label}.
   * </ul>
   *
   * <p>Method under test: {@link CheckboxNode#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CheckboxNode.getText()"})
  public void testGetText_givenCheckboxNodeWithLabel_thenReturnLabel() {
    // Arrange, Act and Assert
    assertEquals("Label", new CheckboxNode("Label").getText());
  }
}
