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
public class PersonSelectorNodeDiffblueTest {
  @InjectMocks private PersonSelectorNode personSelectorNode;

  /**
   * Test {@link PersonSelectorNode#PersonSelectorNode(String, String, String)}.
   *
   * <p>Method under test: {@link PersonSelectorNode#PersonSelectorNode(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersonSelectorNode.<init>(String, String, String)"})
  public void testNewPersonSelectorNode() {
    // Arrange and Act
    PersonSelectorNode actualPersonSelectorNode =
        new PersonSelectorNode("Placeholder", "Label", "127.0.0.1");

    // Assert
    assertNull(actualPersonSelectorNode.getParent());
    assertNull(actualPersonSelectorNode.getFirstChild());
    assertNull(actualPersonSelectorNode.getLastChild());
    assertNull(actualPersonSelectorNode.getNext());
    assertNull(actualPersonSelectorNode.getPrevious());
  }

  /**
   * Test {@link PersonSelectorNode#getText()}.
   *
   * <p>Method under test: {@link PersonSelectorNode#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PersonSelectorNode.getText()"})
  public void testGetText() {
    // Arrange, Act and Assert
    assertEquals("", personSelectorNode.getText());
  }
}
