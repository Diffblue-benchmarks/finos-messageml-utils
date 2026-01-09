package org.symphonyoss.symphony.messageml.util.instrument.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MarketSectorDiffblueTest {
  /**
   * Test {@link MarketSector#fromValue(String)}.
   *
   * <ul>
   *   <li>When {@code Equity}.
   *   <li>Then return {@code EQUITY}.
   * </ul>
   *
   * <p>Method under test: {@link MarketSector#fromValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MarketSector MarketSector.fromValue(String)"})
  public void testFromValue_whenEquity_thenReturnEquity() {
    // Arrange, Act and Assert
    assertEquals(MarketSector.EQUITY, MarketSector.fromValue("Equity"));
  }

  /**
   * Test {@link MarketSector#fromValue(String)}.
   *
   * <ul>
   *   <li>When {@code Text}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketSector#fromValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MarketSector MarketSector.fromValue(String)"})
  public void testFromValue_whenText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(MarketSector.fromValue("Text"));
  }

  /**
   * Test {@link MarketSector#toValues()}.
   *
   * <p>Method under test: {@link MarketSector#toValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List MarketSector.toValues()"})
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
