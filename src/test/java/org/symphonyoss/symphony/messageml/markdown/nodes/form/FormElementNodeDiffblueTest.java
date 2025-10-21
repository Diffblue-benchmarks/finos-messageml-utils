package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FormElementNodeDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Text is empty string.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FormElementNode#FormElementNode(String)}
   *   <li>{@link FormElementNode#getClosingDelimiter()}
   *   <li>{@link FormElementNode#getText()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormElementNode.<init>()", "void FormElementNode.<init>(String)",
      "void FormElementNode.<init>(String, String)", "String FormElementNode.getClosingDelimiter()",
      "String FormElementNode.getText()"})
  public void testGettersAndSetters_thenReturnTextIsEmptyString() {
    // Arrange and Act
    FormElementNode actualFormElementNode = new FormElementNode("Tag Representation On Markdown");
    String actualClosingDelimiter = actualFormElementNode.getClosingDelimiter();

    // Assert
    assertEquals("", actualFormElementNode.getText());
    assertEquals(")", actualClosingDelimiter);
    assertNull(actualFormElementNode.getParent());
    assertNull(actualFormElementNode.getFirstChild());
    assertNull(actualFormElementNode.getLastChild());
    assertNull(actualFormElementNode.getNext());
    assertNull(actualFormElementNode.getPrevious());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Text is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FormElementNode#FormElementNode()}
   *   <li>{@link FormElementNode#getClosingDelimiter()}
   *   <li>{@link FormElementNode#getText()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormElementNode.<init>()", "void FormElementNode.<init>(String)",
      "void FormElementNode.<init>(String, String)", "String FormElementNode.getClosingDelimiter()",
      "String FormElementNode.getText()"})
  public void testGettersAndSetters_thenReturnTextIsNull() {
    // Arrange and Act
    FormElementNode actualFormElementNode = new FormElementNode();
    String actualClosingDelimiter = actualFormElementNode.getClosingDelimiter();

    // Assert
    assertEquals(")", actualClosingDelimiter);
    assertNull(actualFormElementNode.getText());
    assertNull(actualFormElementNode.getParent());
    assertNull(actualFormElementNode.getFirstChild());
    assertNull(actualFormElementNode.getLastChild());
    assertNull(actualFormElementNode.getNext());
    assertNull(actualFormElementNode.getPrevious());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Text}.</li>
   *   <li>Then return {@code Text}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FormElementNode#FormElementNode(String, String)}
   *   <li>{@link FormElementNode#getClosingDelimiter()}
   *   <li>{@link FormElementNode#getText()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormElementNode.<init>()", "void FormElementNode.<init>(String)",
      "void FormElementNode.<init>(String, String)", "String FormElementNode.getClosingDelimiter()",
      "String FormElementNode.getText()"})
  public void testGettersAndSetters_whenText_thenReturnText() {
    // Arrange and Act
    FormElementNode actualFormElementNode = new FormElementNode("Tag Representation On Markdown", "Text");
    String actualClosingDelimiter = actualFormElementNode.getClosingDelimiter();

    // Assert
    assertEquals(")", actualClosingDelimiter);
    assertEquals("Text", actualFormElementNode.getText());
    assertNull(actualFormElementNode.getParent());
    assertNull(actualFormElementNode.getFirstChild());
    assertNull(actualFormElementNode.getLastChild());
    assertNull(actualFormElementNode.getNext());
    assertNull(actualFormElementNode.getPrevious());
  }

  /**
   * Test {@link FormElementNode#getOpeningDelimiter()}.
   * <p>
   * Method under test: {@link FormElementNode#getOpeningDelimiter()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormElementNode.getOpeningDelimiter()"})
  public void testGetOpeningDelimiter() {
    // Arrange, Act and Assert
    assertEquals("(Tag Representation On Markdown",
        (new FormElementNode("Tag Representation On Markdown")).getOpeningDelimiter());
  }
}
