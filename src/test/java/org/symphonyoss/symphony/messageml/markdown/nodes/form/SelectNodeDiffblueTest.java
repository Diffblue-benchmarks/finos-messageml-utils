package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SelectNodeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SelectNode#SelectNode(String, String, String)}
   *   <li>{@link SelectNode#getClosingDelimiter()}
   *   <li>{@link SelectNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SelectNode.<init>(String, String, String)", "String SelectNode.getClosingDelimiter()",
      "String SelectNode.getOpeningDelimiter()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    SelectNode actualSelectNode = new SelectNode("Placeholder", "Label", "127.0.0.1");
    String actualClosingDelimiter = actualSelectNode.getClosingDelimiter();

    // Assert
    assertEquals(" ", actualSelectNode.getOpeningDelimiter());
    assertEquals(" \n", actualClosingDelimiter);
    assertEquals("Label", actualSelectNode.getText());
    assertNull(actualSelectNode.getParent());
    assertNull(actualSelectNode.getFirstChild());
    assertNull(actualSelectNode.getLastChild());
    assertNull(actualSelectNode.getNext());
    assertNull(actualSelectNode.getPrevious());
  }

  /**
   * Test {@link SelectNode#getText()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SelectNode#getText()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SelectNode.getText()"})
  public void testGetText_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new SelectNode("Placeholder", "", "127.0.0.1")).getText());
  }

  /**
   * Test {@link SelectNode#getText()}.
   * <ul>
   *   <li>Then return {@code Label}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SelectNode#getText()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SelectNode.getText()"})
  public void testGetText_thenReturnLabel() {
    // Arrange, Act and Assert
    assertEquals("Label", (new SelectNode("Placeholder", "Label", "127.0.0.1")).getText());
  }
}
