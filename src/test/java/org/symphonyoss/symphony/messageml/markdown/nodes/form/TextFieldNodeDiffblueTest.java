package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TextFieldNodeDiffblueTest {
  @InjectMocks private TextFieldNode textFieldNode;

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

  /**
   * Test {@link TextFieldNode#getText()}.
   *
   * <p>Method under test: {@link TextFieldNode#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TextFieldNode.getText()"})
  public void testGetText() {
    // Arrange, Act and Assert
    assertEquals("", textFieldNode.getText());
  }
}
