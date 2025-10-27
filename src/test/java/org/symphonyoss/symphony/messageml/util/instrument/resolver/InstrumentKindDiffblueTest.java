package org.symphonyoss.symphony.messageml.util.instrument.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.List;
import org.junit.Test;

public class InstrumentKindDiffblueTest {
  /**
   * Method under test: {@link InstrumentKind#fromValue(String)}
   */
  @Test
  public void testFromValue() {
    // Arrange, Act and Assert
    assertNull(InstrumentKind.fromValue("Text"));
    assertEquals(InstrumentKind.EQUITY, InstrumentKind.fromValue("equity"));
  }

  /**
   * Method under test: {@link InstrumentKind#getValue()}
   */
  @Test
  public void testGetValue() {
    // Arrange, Act and Assert
    assertEquals("equity", InstrumentKind.valueOf("EQUITY").getValue());
  }

  /**
   * Method under test: {@link InstrumentKind#toValues()}
   */
  @Test
  public void testToValues() {
    // Arrange and Act
    List<String> actualToValuesResult = InstrumentKind.toValues();

    // Assert
    assertEquals(3, actualToValuesResult.size());
    assertEquals("equity", actualToValuesResult.get(0));
    assertEquals("fxcross", actualToValuesResult.get(2));
    assertEquals("index", actualToValuesResult.get(1));
  }
}
