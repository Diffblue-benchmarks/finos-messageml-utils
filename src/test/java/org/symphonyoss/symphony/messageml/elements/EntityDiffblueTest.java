package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class EntityDiffblueTest {
  /**
   * Test {@link Entity#validate()}.
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is {@link Element}.</li>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#validate()}
   */
  @Test
  public void testValidate_givenBoldWithParentIsElement_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new CashTag(new Bold(mock(Element.class)), "The attribute \"tag\" is required", "42")).validate());
  }

  /**
   * Test {@link Entity#getEntityId(int)}.
   * <p>
   * Method under test: {@link Entity#getEntityId(int)}
   */
  @Test
  public void testGetEntityId() {
    // Arrange, Act and Assert
    assertEquals("keyword1", (new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).getEntityId(1));
  }

  /**
   * Test {@link Entity#getPresentationMLTag()}.
   * <p>
   * Method under test: {@link Entity#getPresentationMLTag()}
   */
  @Test
  public void testGetPresentationMLTag() {
    // Arrange, Act and Assert
    assertEquals(Span.MESSAGEML_TAG,
        (new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).getPresentationMLTag());
  }
}
