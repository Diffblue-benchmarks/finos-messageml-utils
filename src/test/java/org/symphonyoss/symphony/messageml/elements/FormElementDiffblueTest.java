package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class FormElementDiffblueTest {
  /**
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
}
