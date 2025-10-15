package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OptionNodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OptionNode}
   *   <li>{@link OptionNode#getClosingDelimiter()}
   *   <li>{@link OptionNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OptionNode.<init>()",
    "String OptionNode.getClosingDelimiter()",
    "String OptionNode.getOpeningDelimiter()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OptionNode actualOptionNode = new OptionNode();
    String actualClosingDelimiter = actualOptionNode.getClosingDelimiter();

    // Assert
    assertEquals("-", actualOptionNode.getOpeningDelimiter());
    assertEquals("\n", actualClosingDelimiter);
    assertNull(actualOptionNode.getText());
    assertNull(actualOptionNode.getParent());
    assertNull(actualOptionNode.getFirstChild());
    assertNull(actualOptionNode.getLastChild());
    assertNull(actualOptionNode.getNext());
    assertNull(actualOptionNode.getPrevious());
  }
}
