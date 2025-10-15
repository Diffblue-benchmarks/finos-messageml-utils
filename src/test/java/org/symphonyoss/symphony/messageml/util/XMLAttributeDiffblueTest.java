package org.symphonyoss.symphony.messageml.util;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.util.XMLAttribute.Format;

public class XMLAttributeDiffblueTest {
  /**
   * Test {@link XMLAttribute#of(String, Format)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMLAttribute#of(String, Format)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"XMLAttribute XMLAttribute.of(String, Format)"})
  public void testOf_whenNull() {
    // Arrange and Act
    XMLAttribute actualOfResult = XMLAttribute.of("Name", null);

    // Assert
    assertEquals("Name", actualOfResult.toString());
    assertEquals(Format.STANDARD, actualOfResult.getFormat());
  }

  /**
   * Test {@link XMLAttribute#of(String, Format)}.
   *
   * <ul>
   *   <li>When {@code STANDARD}.
   * </ul>
   *
   * <p>Method under test: {@link XMLAttribute#of(String, Format)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"XMLAttribute XMLAttribute.of(String, Format)"})
  public void testOf_whenStandard() {
    // Arrange and Act
    XMLAttribute actualOfResult = XMLAttribute.of("Name", Format.STANDARD);

    // Assert
    assertEquals("Name", actualOfResult.toString());
    assertEquals(Format.STANDARD, actualOfResult.getFormat());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link XMLAttribute#getFormat()}
   *   <li>{@link XMLAttribute#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Format XMLAttribute.getFormat()", "String XMLAttribute.toString()"})
  public void testGettersAndSetters() {
    // Arrange
    XMLAttribute ofResult = XMLAttribute.of("Name", Format.STANDARD);

    // Act
    Format actualFormat = ofResult.getFormat();

    // Assert
    assertEquals("Name", ofResult.toString());
    assertEquals(Format.STANDARD, actualFormat);
  }
}
