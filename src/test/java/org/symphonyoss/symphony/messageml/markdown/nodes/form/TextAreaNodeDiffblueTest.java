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
public class TextAreaNodeDiffblueTest {
  @InjectMocks private TextAreaNode textAreaNode;

  /**
   * Test {@link TextAreaNode#TextAreaNode(String, String, String, String)}.
   *
   * <p>Method under test: {@link TextAreaNode#TextAreaNode(String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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

  /**
   * Test {@link TextAreaNode#getText()}.
   *
   * <p>Method under test: {@link TextAreaNode#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TextAreaNode.getText()"})
  public void testGetText() {
    // Arrange, Act and Assert
    assertEquals("", textAreaNode.getText());
  }
}
