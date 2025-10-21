package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PlaceholderLabelTooltipNodeDiffblueTest {
  /**
   * Test {@link PlaceholderLabelTooltipNode#generateMarkdownPlaceholderLabelAndTooltip(String, String, String)}.
   * <ul>
   *   <li>When {@code Label}.</li>
   *   <li>Then return {@code :[Label]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlaceholderLabelTooltipNode#generateMarkdownPlaceholderLabelAndTooltip(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String PlaceholderLabelTooltipNode.generateMarkdownPlaceholderLabelAndTooltip(String, String, String)"})
  public void testGenerateMarkdownPlaceholderLabelAndTooltip_whenLabel_thenReturnLabel() {
    // Arrange, Act and Assert
    assertEquals(":[Label]", (new PersonSelectorNode("Placeholder", "Label", "127.0.0.1"))
        .generateMarkdownPlaceholderLabelAndTooltip(null, "Label", null));
  }

  /**
   * Test {@link PlaceholderLabelTooltipNode#generateMarkdownPlaceholderLabelAndTooltip(String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlaceholderLabelTooltipNode#generateMarkdownPlaceholderLabelAndTooltip(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String PlaceholderLabelTooltipNode.generateMarkdownPlaceholderLabelAndTooltip(String, String, String)"})
  public void testGenerateMarkdownPlaceholderLabelAndTooltip_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new PersonSelectorNode("Placeholder", "Label", "127.0.0.1"))
        .generateMarkdownPlaceholderLabelAndTooltip(null, null, null));
  }
}
