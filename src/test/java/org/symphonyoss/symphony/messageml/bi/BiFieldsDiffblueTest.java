package org.symphonyoss.symphony.messageml.bi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class BiFieldsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BiFields#getDefaultValue()}
   *   <li>{@link BiFields#getType()}
   *   <li>{@link BiFields#getValue()}
   * </ul>
   */
  @Test
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
