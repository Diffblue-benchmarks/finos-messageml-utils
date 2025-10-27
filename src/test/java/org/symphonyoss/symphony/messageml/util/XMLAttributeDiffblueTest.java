package org.symphonyoss.symphony.messageml.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class XMLAttributeDiffblueTest {
  /**
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

  /**
   * Method under test: {@link XMLAttribute#of(String, XMLAttribute.Format)}
   */
  @Test
  public void testOf() {
    // Arrange and Act
    XMLAttribute actualOfResult = XMLAttribute.of("Name", XMLAttribute.Format.STANDARD);

    // Assert
    assertEquals("Name", actualOfResult.toString());
    assertEquals(XMLAttribute.Format.STANDARD, actualOfResult.getFormat());
  }

  /**
   * Method under test: {@link XMLAttribute#of(String, XMLAttribute.Format)}
   */
  @Test
  public void testOf2() {
    // Arrange and Act
    XMLAttribute actualOfResult = XMLAttribute.of("Name", null);

    // Assert
    assertEquals("Name", actualOfResult.toString());
    assertEquals(XMLAttribute.Format.STANDARD, actualOfResult.getFormat());
  }
}
