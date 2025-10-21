package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ButtonNodeDiffblueTest {
  /**
   * Test new {@link ButtonNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ButtonNode}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ButtonNode.<init>()"})
  public void testNewButtonNode() {
    // Arrange and Act
    ButtonNode actualButtonNode = new ButtonNode();

    // Assert
    assertEquals("", actualButtonNode.getText());
    assertNull(actualButtonNode.getParent());
    assertNull(actualButtonNode.getFirstChild());
    assertNull(actualButtonNode.getLastChild());
    assertNull(actualButtonNode.getNext());
    assertNull(actualButtonNode.getPrevious());
  }
}
