package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class StylesDiffblueTest {
  /**
   * Method under test: {@link Styles#validate(String)}
   */
  @Test
  public void testValidate() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class, () -> Styles.validate("Style Attribute"));
    assertThrows(InvalidInputException.class, () -> Styles.validate(";(?!base64,)"));
    assertThrows(InvalidInputException.class, () -> Styles.validate(":"));
  }
}
