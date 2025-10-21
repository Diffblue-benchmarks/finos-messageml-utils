package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CheckboxNodeDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Text is empty string.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CheckboxNode#CheckboxNode()}
   *   <li>{@link CheckboxNode#getClosingDelimiter()}
   *   <li>{@link CheckboxNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CheckboxNode.<init>()", "void CheckboxNode.<init>(String)",
      "String CheckboxNode.getClosingDelimiter()", "String CheckboxNode.getOpeningDelimiter()"})
  public void testGettersAndSetters_thenReturnTextIsEmptyString() {
    // Arrange and Act
    CheckboxNode actualCheckboxNode = new CheckboxNode();
    String actualClosingDelimiter = actualCheckboxNode.getClosingDelimiter();

    // Assert
    assertEquals(" ", actualClosingDelimiter);
    assertEquals(" ", actualCheckboxNode.getOpeningDelimiter());
    assertEquals("", actualCheckboxNode.getText());
    assertNull(actualCheckboxNode.getParent());
    assertNull(actualCheckboxNode.getFirstChild());
    assertNull(actualCheckboxNode.getLastChild());
    assertNull(actualCheckboxNode.getNext());
    assertNull(actualCheckboxNode.getPrevious());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Label}.</li>
   *   <li>Then return Text is {@code Label}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CheckboxNode#CheckboxNode(String)}
   *   <li>{@link CheckboxNode#getClosingDelimiter()}
   *   <li>{@link CheckboxNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CheckboxNode.<init>()", "void CheckboxNode.<init>(String)",
      "String CheckboxNode.getClosingDelimiter()", "String CheckboxNode.getOpeningDelimiter()"})
  public void testGettersAndSetters_whenLabel_thenReturnTextIsLabel() {
    // Arrange and Act
    CheckboxNode actualCheckboxNode = new CheckboxNode("Label");
    String actualClosingDelimiter = actualCheckboxNode.getClosingDelimiter();

    // Assert
    assertEquals(" ", actualClosingDelimiter);
    assertEquals(" ", actualCheckboxNode.getOpeningDelimiter());
    assertEquals("Label", actualCheckboxNode.getText());
    assertNull(actualCheckboxNode.getParent());
    assertNull(actualCheckboxNode.getFirstChild());
    assertNull(actualCheckboxNode.getLastChild());
    assertNull(actualCheckboxNode.getNext());
    assertNull(actualCheckboxNode.getPrevious());
  }

  /**
   * Test {@link CheckboxNode#getText()}.
   * <ul>
   *   <li>Given {@link CheckboxNode#CheckboxNode(String)} with label is empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckboxNode#getText()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CheckboxNode.getText()"})
  public void testGetText_givenCheckboxNodeWithLabelIsEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new CheckboxNode("")).getText());
  }

  /**
   * Test {@link CheckboxNode#getText()}.
   * <ul>
   *   <li>Given {@link CheckboxNode#CheckboxNode(String)} with {@code Label}.</li>
   *   <li>Then return {@code Label}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckboxNode#getText()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CheckboxNode.getText()"})
  public void testGetText_givenCheckboxNodeWithLabel_thenReturnLabel() {
    // Arrange, Act and Assert
    assertEquals("Label", (new CheckboxNode("Label")).getText());
  }

  /**
   * Test {@link CheckboxNode#getText()}.
   * <ul>
   *   <li>Given {@link CheckboxNode#CheckboxNode()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckboxNode#getText()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CheckboxNode.getText()"})
  public void testGetText_givenCheckboxNode_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new CheckboxNode()).getText());
  }
}
