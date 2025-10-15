package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SelectNodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SelectNode#SelectNode(String, String, String)}
   *   <li>{@link SelectNode#getClosingDelimiter()}
   *   <li>{@link SelectNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SelectNode.<init>(String, String, String)",
    "String SelectNode.getClosingDelimiter()",
    "String SelectNode.getOpeningDelimiter()"
  })
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

  /**
   * Test {@link SelectNode#getText()}.
   *
   * <ul>
   *   <li>Given {@link SelectNode#SelectNode(String, String, String)} with {@code Placeholder} and
   *       label is {@code null} and tooltip is {@code 127.0.0.1}.
   * </ul>
   *
   * <p>Method under test: {@link SelectNode#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SelectNode.getText()"})
  public void testGetText_givenSelectNodeWithPlaceholderAndLabelIsNullAndTooltipIs127001() {
    // Arrange
    SelectNode selectNode = new SelectNode("Placeholder", null, "127.0.0.1");

    // Act and Assert
    assertEquals("", selectNode.getText());
  }

  /**
   * Test {@link SelectNode#getText()}.
   *
   * <ul>
   *   <li>Given {@link SelectNode#SelectNode(String, String, String)} with {@code Placeholder} and
   *       label is space and tooltip is {@code 127.0.0.1}.
   * </ul>
   *
   * <p>Method under test: {@link SelectNode#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SelectNode.getText()"})
  public void testGetText_givenSelectNodeWithPlaceholderAndLabelIsSpaceAndTooltipIs127001() {
    // Arrange
    SelectNode selectNode = new SelectNode("Placeholder", " ", "127.0.0.1");

    // Act and Assert
    assertEquals("", selectNode.getText());
  }

  /**
   * Test {@link SelectNode#getText()}.
   *
   * <ul>
   *   <li>Then return {@code Label}.
   * </ul>
   *
   * <p>Method under test: {@link SelectNode#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SelectNode.getText()"})
  public void testGetText_thenReturnLabel() {
    // Arrange
    SelectNode selectNode = new SelectNode("Placeholder", "Label", "127.0.0.1");

    // Act and Assert
    assertEquals("Label", selectNode.getText());
  }
}
