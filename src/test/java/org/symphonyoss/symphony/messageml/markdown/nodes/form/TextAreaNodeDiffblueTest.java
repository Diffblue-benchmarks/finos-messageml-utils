package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TextAreaNodeDiffblueTest {
  /**
   * Test {@link TextAreaNode#TextAreaNode(String, String, String, String)}.
   * <p>
   * Method under test: {@link TextAreaNode#TextAreaNode(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TextAreaNode.<init>(String, String, String, String)"})
  public void testNewTextAreaNode() {
    // Arrange and Act
    TextAreaNode actualTextAreaNode = new TextAreaNode("Placeholder", "42", "Label", "127.0.0.1");

    // Assert
    assertNull(actualTextAreaNode.getParent());
    assertNull(actualTextAreaNode.getFirstChild());
    assertNull(actualTextAreaNode.getLastChild());
    assertNull(actualTextAreaNode.getNext());
    assertNull(actualTextAreaNode.getPrevious());
  }
}
