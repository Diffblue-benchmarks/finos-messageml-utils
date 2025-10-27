package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class RegexElementDiffblueTest {
  /**
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
   * Method under test: {@link RegexElement#getOtherAttributes()}
   */
  @Test
  public void testGetOtherAttributes() {
    // Arrange, Act and Assert
    assertTrue((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).getOtherAttributes()
        .isEmpty());
  }
}
