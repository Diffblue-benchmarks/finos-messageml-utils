package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TextFieldNodeDiffblueTest {
  /**
   * Test {@link TextFieldNode#TextFieldNode(String, String, String, String)}.
   *
   * <p>Method under test: {@link TextFieldNode#TextFieldNode(String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextFieldNode.<init>(String, String, String, String)"})
  public void testNewTextFieldNode() {
    // Arrange and Act
    TextFieldNode actualTextFieldNode =
        new TextFieldNode("Placeholder", "42", "Label", "127.0.0.1");

    // Assert
    assertNull(actualTextFieldNode.getParent());
    assertNull(actualTextFieldNode.getFirstChild());
    assertNull(actualTextFieldNode.getLastChild());
    assertNull(actualTextFieldNode.getNext());
    assertNull(actualTextFieldNode.getPrevious());
  }
}
