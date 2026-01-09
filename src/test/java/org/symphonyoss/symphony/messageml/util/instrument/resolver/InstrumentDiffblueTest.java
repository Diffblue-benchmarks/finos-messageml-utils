package org.symphonyoss.symphony.messageml.util.instrument.resolver;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InstrumentDiffblueTest {
  /**
   * Test new {@link Instrument} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Instrument}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Instrument.<init>()"})
  public void testNewInstrument() {
    // Arrange and Act
    Instrument actualInstrument = new Instrument();

    // Assert
    assertNull(actualInstrument.getMainInstrument());
    assertNull(actualInstrument.getPrimaryExchange());
    assertNull(actualInstrument.getBbgCompId());
    assertNull(actualInstrument.getBbgCompTicker());
    assertNull(actualInstrument.getCfi());
    assertNull(actualInstrument.getCountryCode());
    assertNull(actualInstrument.getCountryName());
    assertNull(actualInstrument.getCurrency());
    assertNull(actualInstrument.getDisplayName());
    assertNull(actualInstrument.getEdiExchangeCode());
    assertNull(actualInstrument.getEdiInstrumentId());
    assertNull(actualInstrument.getExchangeName());
    assertNull(actualInstrument.getFigi());
    assertNull(actualInstrument.getFigiTicker());
    assertNull(actualInstrument.getFullBbgCompTicker());
    assertNull(actualInstrument.getInstrumentTypeCode());
    assertNull(actualInstrument.getInstrumentTypeName());
    assertNull(actualInstrument.getIsin());
    assertNull(actualInstrument.getLei());
    assertNull(actualInstrument.getLocalCode());
    assertNull(actualInstrument.getOperationalMic());
    assertNull(actualInstrument.getRic());
    assertNull(actualInstrument.getRootBbgCompTicker());
    assertNull(actualInstrument.getSedol());
    assertNull(actualInstrument.getUniqueId());
    assertNull(actualInstrument.getUsCode());
    assertNull(actualInstrument.getWkn());
    assertNull(actualInstrument.getKind());
    assertNull(actualInstrument.getBbgMarketSector());
    assertNull(actualInstrument.getProviderId());
  }
}
