package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlaceholderLabelTooltipNodeDiffblueTest {
  /**
   * Method under test:
   * {@link PlaceholderLabelTooltipNode#generateMarkdownPlaceholderLabelAndTooltip(String, String, String)}
   */
  @Test
  public void testGenerateMarkdownPlaceholderLabelAndTooltip() {
    // Arrange, Act and Assert
    assertEquals("", (new PersonSelectorNode("Placeholder", "Label", "127.0.0.1"))
        .generateMarkdownPlaceholderLabelAndTooltip(null, null, null));
    assertEquals(":[Label]", (new PersonSelectorNode("Placeholder", "Label", "127.0.0.1"))
        .generateMarkdownPlaceholderLabelAndTooltip(null, "Label", null));
  }
}
