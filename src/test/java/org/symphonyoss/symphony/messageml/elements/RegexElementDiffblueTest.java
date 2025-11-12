package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class RegexElementDiffblueTest {
  /**
   * Test {@link RegexElement#validateRegex()}.
   *
   * <p>Method under test: {@link RegexElement#validateRegex()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegexElement.validateRegex()"})
  public void testValidateRegex() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    new TextArea(parent, FormatEnum.MESSAGEML).validateRegex();
  }

  /**
   * Test {@link RegexElement#getRegexAttrForPresentationML()}.
   *
   * <p>Method under test: {@link RegexElement#getRegexAttrForPresentationML()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map RegexElement.getRegexAttrForPresentationML()"})
  public void testGetRegexAttrForPresentationML() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertTrue(
        new TextArea(parent2, FormatEnum.MESSAGEML).getRegexAttrForPresentationML().isEmpty());
  }

  /**
   * Test {@link RegexElement#getOtherAttributes()}.
   *
   * <p>Method under test: {@link RegexElement#getOtherAttributes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map RegexElement.getOtherAttributes()"})
  public void testGetOtherAttributes() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertTrue(new TextArea(parent2, FormatEnum.MESSAGEML).getOtherAttributes().isEmpty());
  }
}
