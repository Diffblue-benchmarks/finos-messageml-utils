package org.symphonyoss.symphony.messageml.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class XMLAttributeDiffblueTest {
  /**
   * Test {@link XMLAttribute#of(String, Format)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMLAttribute#of(String, XMLAttribute.Format)}
   */
  @Test
  public void testOf_whenNull() {
    // Arrange and Act
    XMLAttribute actualOfResult = XMLAttribute.of("Name", null);

    // Assert
    assertEquals("Name", actualOfResult.toString());
    assertEquals(XMLAttribute.Format.STANDARD, actualOfResult.getFormat());
  }

  /**
   * Test {@link XMLAttribute#of(String, Format)}.
   * <ul>
   *   <li>When {@code STANDARD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMLAttribute#of(String, XMLAttribute.Format)}
   */
  @Test
  public void testOf_whenStandard() {
    // Arrange and Act
    XMLAttribute actualOfResult = XMLAttribute.of("Name", XMLAttribute.Format.STANDARD);

    // Assert
    assertEquals("Name", actualOfResult.toString());
    assertEquals(XMLAttribute.Format.STANDARD, actualOfResult.getFormat());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link XMLAttribute#getFormat()}
   *   <li>{@link XMLAttribute#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    XMLAttribute ofResult = XMLAttribute.of("Name", XMLAttribute.Format.STANDARD);

    // Act
    XMLAttribute.Format actualFormat = ofResult.getFormat();

    // Assert
    assertEquals("Name", ofResult.toString());
    assertEquals(XMLAttribute.Format.STANDARD, actualFormat);
  }
}
