package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RegexElementDiffblueTest {
  /**
   * Test {@link RegexElement#getRegexAttrForPresentationML()}.
   * <p>
   * Method under test: {@link RegexElement#getRegexAttrForPresentationML()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Map RegexElement.getRegexAttrForPresentationML()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Map RegexElement.getOtherAttributes()"})
  public void testGetOtherAttributes() {
    // Arrange, Act and Assert
    assertTrue((new TextArea(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).getOtherAttributes()
        .isEmpty());
  }
}
