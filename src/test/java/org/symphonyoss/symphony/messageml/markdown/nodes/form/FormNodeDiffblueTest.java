package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FormNodeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FormNode}
   *   <li>{@link FormNode#getClosingDelimiter()}
   *   <li>{@link FormNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormNode.<init>()", "String FormNode.getClosingDelimiter()",
      "String FormNode.getOpeningDelimiter()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    FormNode actualFormNode = new FormNode();
    String actualClosingDelimiter = actualFormNode.getClosingDelimiter();
    String actualOpeningDelimiter = actualFormNode.getOpeningDelimiter();

    // Assert
    assertEquals("", actualFormNode.getText());
    assertEquals("\n   \n", actualClosingDelimiter);
    assertEquals("\n   \n", actualOpeningDelimiter);
    assertNull(actualFormNode.getParent());
    assertNull(actualFormNode.getFirstChild());
    assertNull(actualFormNode.getLastChild());
    assertNull(actualFormNode.getNext());
    assertNull(actualFormNode.getPrevious());
  }
}
