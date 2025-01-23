package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class StylesDiffblueTest {
  /**
   * Test {@link Styles#validate(String)}.
   * <ul>
   *   <li>When {@code ;(?!base64,)}.</li>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Styles#validate(String)}
   */
  @Test
  public void testValidate_whenBase64_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class, () -> Styles.validate(";(?!base64,)"));
  }

  /**
   * Test {@link Styles#validate(String)}.
   * <ul>
   *   <li>When {@code :}.</li>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Styles#validate(String)}
   */
  @Test
  public void testValidate_whenColon_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class, () -> Styles.validate(":"));
  }

  /**
   * Test {@link Styles#validate(String)}.
   * <ul>
   *   <li>When {@code Style Attribute}.</li>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Styles#validate(String)}
   */
  @Test
  public void testValidate_whenStyleAttribute_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class, () -> Styles.validate("Style Attribute"));
  }
}
