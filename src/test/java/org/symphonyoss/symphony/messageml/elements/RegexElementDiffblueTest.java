package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class RegexElementDiffblueTest {
  /**
   * Test {@link RegexElement#validateRegex()}.
   * <p>
   * Method under test: {@link RegexElement#validateRegex()}
   */
  @Test
  public void testValidateRegex() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).validateRegex();
  }

  /**
   * Test {@link RegexElement#getRegexAttrForPresentationML()}.
   * <p>
   * Method under test: {@link RegexElement#getRegexAttrForPresentationML()}
   */
  @Test
  public void testGetRegexAttrForPresentationML() {
    // Arrange, Act and Assert
    assertTrue((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .getRegexAttrForPresentationML()
        .isEmpty());
  }

  /**
   * Test {@link RegexElement#getOtherAttributes()}.
   * <p>
   * Method under test: {@link RegexElement#getOtherAttributes()}
   */
  @Test
  public void testGetOtherAttributes() {
    // Arrange, Act and Assert
    assertTrue((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).getOtherAttributes()
        .isEmpty());
  }
}
