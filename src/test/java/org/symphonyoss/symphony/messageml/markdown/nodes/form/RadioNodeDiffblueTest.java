package org.symphonyoss.symphony.messageml.markdown.nodes.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RadioNodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Text is empty string.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RadioNode#RadioNode()}
   *   <li>{@link RadioNode#getClosingDelimiter()}
   *   <li>{@link RadioNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RadioNode.<init>()",
    "void RadioNode.<init>(String)",
    "String RadioNode.getClosingDelimiter()",
    "String RadioNode.getOpeningDelimiter()"
  })
  public void testGettersAndSetters_thenReturnTextIsEmptyString() {
    // Arrange and Act
    RadioNode actualRadioNode = new RadioNode();
    String actualClosingDelimiter = actualRadioNode.getClosingDelimiter();

    // Assert
    assertEquals(" ", actualClosingDelimiter);
    assertEquals(" ", actualRadioNode.getOpeningDelimiter());
    assertEquals("", actualRadioNode.getText());
    assertNull(actualRadioNode.getParent());
    assertNull(actualRadioNode.getFirstChild());
    assertNull(actualRadioNode.getLastChild());
    assertNull(actualRadioNode.getNext());
    assertNull(actualRadioNode.getPrevious());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Label}.
   *   <li>Then return Text is {@code Label}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RadioNode#RadioNode(String)}
   *   <li>{@link RadioNode#getClosingDelimiter()}
   *   <li>{@link RadioNode#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RadioNode.<init>()",
    "void RadioNode.<init>(String)",
    "String RadioNode.getClosingDelimiter()",
    "String RadioNode.getOpeningDelimiter()"
  })
  public void testGettersAndSetters_whenLabel_thenReturnTextIsLabel() {
    // Arrange and Act
    RadioNode actualRadioNode = new RadioNode("Label");
    String actualClosingDelimiter = actualRadioNode.getClosingDelimiter();

    // Assert
    assertEquals(" ", actualClosingDelimiter);
    assertEquals(" ", actualRadioNode.getOpeningDelimiter());
    assertEquals("Label", actualRadioNode.getText());
    assertNull(actualRadioNode.getParent());
    assertNull(actualRadioNode.getFirstChild());
    assertNull(actualRadioNode.getLastChild());
    assertNull(actualRadioNode.getNext());
    assertNull(actualRadioNode.getPrevious());
  }

  /**
   * Test {@link RadioNode#getText()}.
   *
   * <ul>
   *   <li>Given {@link RadioNode#RadioNode(String)} with label is {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link RadioNode#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String RadioNode.getText()"})
  public void testGetText_givenRadioNodeWithLabelIsNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new RadioNode(null).getText());
  }

  /**
   * Test {@link RadioNode#getText()}.
   *
   * <ul>
   *   <li>Given {@link RadioNode#RadioNode(String)} with label is space.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link RadioNode#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String RadioNode.getText()"})
  public void testGetText_givenRadioNodeWithLabelIsSpace_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new RadioNode(" ").getText());
  }

  /**
   * Test {@link RadioNode#getText()}.
   *
   * <ul>
   *   <li>Given {@link RadioNode#RadioNode(String)} with {@code Label}.
   *   <li>Then return {@code Label}.
   * </ul>
   *
   * <p>Method under test: {@link RadioNode#getText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String RadioNode.getText()"})
  public void testGetText_givenRadioNodeWithLabel_thenReturnLabel() {
    // Arrange, Act and Assert
    assertEquals("Label", new RadioNode("Label").getText());
  }
}
