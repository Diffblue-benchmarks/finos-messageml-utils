package org.symphonyoss.symphony.messageml.bi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BiFieldsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BiFields#getDefaultValue()}
   *   <li>{@link BiFields#getType()}
   *   <li>{@link BiFields#getValue()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BiFields.getDefaultValue()",
    "BiEventType BiFields.getType()",
    "String BiFields.getValue()"
  })
  public void testGettersAndSetters() {
    // Arrange
    BiFields valueOfResult = BiFields.valueOf("FORM");

    // Act
    String actualDefaultValue = valueOfResult.getDefaultValue();
    BiEventType actualType = valueOfResult.getType();

    // Assert
    assertEquals("form", valueOfResult.getValue());
    assertNull(actualDefaultValue);
    assertEquals(BiEventType.MESSAGEML_ELEMENT_SENT, actualType);
  }
}
