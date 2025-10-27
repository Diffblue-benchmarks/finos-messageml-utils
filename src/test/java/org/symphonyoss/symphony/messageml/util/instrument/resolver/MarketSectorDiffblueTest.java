package org.symphonyoss.symphony.messageml.util.instrument.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.List;
import org.junit.Test;

public class MarketSectorDiffblueTest {
  /**
   * Method under test: {@link MarketSector#fromValue(String)}
   */
  @Test
  public void testFromValue() {
    // Arrange, Act and Assert
    assertNull(MarketSector.fromValue("Text"));
    assertEquals(MarketSector.EQUITY, MarketSector.fromValue("Equity"));
  }

  /**
   * Method under test: {@link MarketSector#getValue()}
   */
  @Test
  public void testGetValue() {
    // Arrange, Act and Assert
    assertEquals("Equity", MarketSector.valueOf("EQUITY").getValue());
  }

  /**
   * Method under test: {@link MarketSector#toValues()}
   */
  @Test
  public void testToValues() {
    // Arrange and Act
    List<String> actualToValuesResult = MarketSector.toValues();

    // Assert
    assertEquals(10, actualToValuesResult.size());
    assertEquals("Comdty", actualToValuesResult.get(1));
    assertEquals("Corp", actualToValuesResult.get(2));
    assertEquals("Curncy", actualToValuesResult.get(3));
    assertEquals("Equity", actualToValuesResult.get(0));
    assertEquals("Govt", actualToValuesResult.get(4));
    assertEquals("Index", actualToValuesResult.get(5));
    assertEquals("Mmkt", actualToValuesResult.get(6));
    assertEquals("Mtge", actualToValuesResult.get(7));
    assertEquals("Muni", actualToValuesResult.get(8));
    assertEquals("Pfd", actualToValuesResult.get(9));
  }
}
