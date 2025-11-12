package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PlaceholderLabelTooltipNodeDiffblueTest {
  /**
   * Test {@link PlaceholderLabelTooltipNode#generateMarkdownPlaceholderLabelAndTooltip(String,
   * String, String)}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * PlaceholderLabelTooltipNode#generateMarkdownPlaceholderLabelAndTooltip(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PlaceholderLabelTooltipNode.generateMarkdownPlaceholderLabelAndTooltip(String, String, String)"
  })
  public void testGenerateMarkdownPlaceholderLabelAndTooltip_thenReturnEmptyString() {
    // Arrange
    PersonSelectorNode personSelectorNode =
        new PersonSelectorNode("Placeholder", "Label", "127.0.0.1");

    // Act and Assert
    assertEquals(
        "", personSelectorNode.generateMarkdownPlaceholderLabelAndTooltip(null, null, null));
  }

  /**
   * Test {@link PlaceholderLabelTooltipNode#generateMarkdownPlaceholderLabelAndTooltip(String,
   * String, String)}.
   *
   * <ul>
   *   <li>Then return {@code :[Placeholder][Label]}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PlaceholderLabelTooltipNode#generateMarkdownPlaceholderLabelAndTooltip(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PlaceholderLabelTooltipNode.generateMarkdownPlaceholderLabelAndTooltip(String, String, String)"
  })
  public void testGenerateMarkdownPlaceholderLabelAndTooltip_thenReturnPlaceholderLabel() {
    // Arrange
    PersonSelectorNode personSelectorNode =
        new PersonSelectorNode("Placeholder", "Label", "127.0.0.1");

    // Act and Assert
    assertEquals(
        ":[Placeholder][Label]",
        personSelectorNode.generateMarkdownPlaceholderLabelAndTooltip(
            "Placeholder", "Label", null));
  }
}
