package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class FormElementDiffblueTest {
  /**
   * Test {@link FormElement#FormElement(Element, String, FormatEnum)}.
   * <p>
   * Method under test:
   * {@link FormElement#FormElement(Element, String, FormatEnum)}
   */
  @Test
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
   * <p>
   * Method under test: {@link FormElement#FormElement(Element, String)}
   */
  @Test
  public void testNewFormElement2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    FormElement actualFormElement = new FormElement(parent, "Message MLTag");

    // Assert
    assertEquals("Message MLTag", actualFormElement.getMessageMLTag());
    assertEquals("Message MLTag", actualFormElement.getPresentationMLTag());
    assertEquals(0, actualFormElement.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualFormElement.getFormat());
    assertTrue(actualFormElement.getChildren().isEmpty());
    assertTrue(actualFormElement.getAttributes().isEmpty());
    assertSame(parent, actualFormElement.getParent());
  }

  /**
   * Test {@link FormElement#validate()}.
   * <ul>
   *   <li>Given {@link FormElement#FormElement(Element, String)} with parent is
   * {@link Bold#Bold(Element)} and {@code Message MLTag}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormElement#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate_givenFormElementWithParentIsBoldAndMessageMLTag() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Element "Message MLTag" can only be a inner child of the following elements: [form]
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertParentAtAnyLevel(Element.java:758)
    //       at org.symphonyoss.symphony.messageml.elements.FormElement.validate(FormElement.java:24)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new FormElement(new Bold(new BulletList(null)), "Message MLTag")).validate();
  }
}
