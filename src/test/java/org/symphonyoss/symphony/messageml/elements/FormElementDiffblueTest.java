package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class FormElementDiffblueTest {
  /**
   * Test {@link FormElement#FormElement(Element, String, FormatEnum)}.
   *
   * <p>Method under test: {@link FormElement#FormElement(Element, String, FormatEnum)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormElement.<init>(Element, String, FormatEnum)"})
  public void testNewFormElement() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    FormElement actualFormElement = new FormElement(parent, "Message MLTag", FormatEnum.MESSAGEML);

    // Assert
    assertEquals("Message MLTag", actualFormElement.getMessageMLTag());
    assertEquals("Message MLTag", actualFormElement.getPresentationMLTag());
    assertEquals(FormatEnum.MESSAGEML, actualFormElement.getFormat());
    assertTrue(actualFormElement.getChildren().isEmpty());
    assertTrue(actualFormElement.getAttributes().isEmpty());
    assertSame(parent, actualFormElement.getParent());
  }

  /**
   * Test {@link FormElement#FormElement(Element, String)}.
   *
   * <p>Method under test: {@link FormElement#FormElement(Element, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormElement.<init>(Element, String)"})
  public void testNewFormElement2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    FormElement actualFormElement = new FormElement(parent2, "Message MLTag");

    // Assert
    assertEquals("Message MLTag", actualFormElement.getMessageMLTag());
    assertEquals("Message MLTag", actualFormElement.getPresentationMLTag());
    assertEquals(0, actualFormElement.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualFormElement.getFormat());
    assertTrue(actualFormElement.getChildren().isEmpty());
    assertTrue(actualFormElement.getAttributes().isEmpty());
    assertSame(parent2, actualFormElement.getParent());
  }

  /**
   * Test {@link FormElement#validate()}.
   *
   * <ul>
   *   <li>Given {@link Checkbox#Checkbox(Element, FormatEnum)} with parent is {@link
   *       Bold#Bold(Element)} and messageFormat is {@code MESSAGEML}.
   * </ul>
   *
   * <p>Method under test: {@link FormElement#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormElement.validate()"})
  public void testValidate_givenCheckboxWithParentIsBoldAndMessageFormatIsMessageml()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> new Checkbox(parent, FormatEnum.MESSAGEML).validate());
  }

  /**
   * Test {@link FormElement#validate()}.
   *
   * <ul>
   *   <li>Given {@link FormElement#FormElement(Element, String)} with parent is {@link
   *       Bold#Bold(Element)} and {@code Message MLTag}.
   * </ul>
   *
   * <p>Method under test: {@link FormElement#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormElement.validate()"})
  public void testValidate_givenFormElementWithParentIsBoldAndMessageMLTag()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> new FormElement(parent, "Message MLTag").validate());
  }

  /**
   * Test {@link FormElement#validate()}.
   *
   * <ul>
   *   <li>Given {@link TextArea#TextArea(Element, FormatEnum)} with parent is {@link
   *       Bold#Bold(Element)} and format is {@link FormatEnum#MESSAGEML}.
   * </ul>
   *
   * <p>Method under test: {@link FormElement#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormElement.validate()"})
  public void testValidate_givenTextAreaWithParentIsBoldAndFormatIsMessageml()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> new TextArea(parent, FormatEnum.MESSAGEML).validate());
  }

  /**
   * Test {@link FormElement#validate()}.
   *
   * <ul>
   *   <li>Then calls {@link Checkbox#getParent()}.
   * </ul>
   *
   * <p>Method under test: {@link FormElement#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormElement.validate()"})
  public void testValidate_thenCallsGetParent() throws InvalidInputException {
    // Arrange
    Checkbox parent = mock(Checkbox.class);
    when(parent.getParent()).thenReturn(new Bold(new BulletList(null)));
    BulletList parent2 = new BulletList(parent);
    Bold parent3 = new Bold(parent2);

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> new FormElement(parent3, "Message MLTag").validate());
    verify(parent, atLeast(1)).getParent();
  }
}
