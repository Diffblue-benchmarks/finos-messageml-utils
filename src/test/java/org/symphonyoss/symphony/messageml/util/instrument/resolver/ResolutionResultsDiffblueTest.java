package org.symphonyoss.symphony.messageml.util.instrument.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ResolutionResultsDiffblueTest {
  /**
   * Test {@link ResolutionResults#equals(Object)}, and
   * {@link ResolutionResults#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResolutionResults#equals(Object)}
   *   <li>{@link ResolutionResults#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ResolutionResults resolutionResults = new ResolutionResults();
    resolutionResults.setInstruments(new HashMap<>());

    ResolutionResults resolutionResults2 = new ResolutionResults();
    resolutionResults2.setInstruments(new HashMap<>());

    // Act and Assert
    assertEquals(resolutionResults, resolutionResults2);
    int expectedHashCodeResult = resolutionResults.hashCode();
    assertEquals(expectedHashCodeResult, resolutionResults2.hashCode());
  }

  /**
   * Test {@link ResolutionResults#equals(Object)}, and
   * {@link ResolutionResults#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResolutionResults#equals(Object)}
   *   <li>{@link ResolutionResults#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ResolutionResults resolutionResults = new ResolutionResults();
    resolutionResults.setInstruments(new HashMap<>());

    // Act and Assert
    assertEquals(resolutionResults, resolutionResults);
    int expectedHashCodeResult = resolutionResults.hashCode();
    assertEquals(expectedHashCodeResult, resolutionResults.hashCode());
  }

  /**
   * Test {@link ResolutionResults#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResolutionResults#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Instrument instrument = new Instrument();
    instrument.setBbgCompId("42");
    instrument.setBbgCompTicker("Bbg Comp Ticker");
    instrument.setBbgMarketSector(MarketSector.EQUITY);
    instrument.setCfi("Cfi");
    instrument.setCountryCode("GB");
    instrument.setCountryName("GB");
    instrument.setCurrency("GBP");
    instrument.setDisplayName("Display Name");
    instrument.setEdiExchangeCode("Edi Exchange Code");
    instrument.setEdiInstrumentId("42");
    instrument.setExchangeName("Exchange Name");
    instrument.setFigi("Figi");
    instrument.setFigiTicker("Figi Ticker");
    instrument.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrument.setInstrumentTypeCode("Instrument Type Code");
    instrument.setInstrumentTypeName("Instrument Type Name");
    instrument.setIsin("Isin");
    instrument.setKind(InstrumentKind.EQUITY);
    instrument.setLei("Lei");
    instrument.setLocalCode("Local Code");
    instrument.setMainInstrument(true);
    instrument.setOperationalMic("Operational Mic");
    instrument.setPrimaryExchange(true);
    instrument.setProviderId(ProviderId.EDI);
    instrument.setRic("Ric");
    instrument.setRootBbgCompTicker("Root Bbg Comp Ticker");
    instrument.setSedol("Sedol");
    instrument.setUniqueId("42");
    instrument.setUsCode("Us Code");
    instrument.setWkn("Wkn");

    ResolutionResult resolutionResult = new ResolutionResult();
    resolutionResult.setInstrument(instrument);
    resolutionResult.setReturnCode(1);

    HashMap<String, ResolutionResult> instruments = new HashMap<>();
    instruments.put("foo", resolutionResult);

    ResolutionResults resolutionResults = new ResolutionResults();
    resolutionResults.setInstruments(instruments);

    ResolutionResults resolutionResults2 = new ResolutionResults();
    resolutionResults2.setInstruments(new HashMap<>());

    // Act and Assert
    assertNotEquals(resolutionResults, resolutionResults2);
  }

  /**
   * Test {@link ResolutionResults#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResolutionResults#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ResolutionResults resolutionResults = new ResolutionResults();
    resolutionResults.setInstruments(new HashMap<>());

    // Act and Assert
    assertNotEquals(resolutionResults, null);
  }

  /**
   * Test {@link ResolutionResults#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResolutionResults#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ResolutionResults resolutionResults = new ResolutionResults();
    resolutionResults.setInstruments(new HashMap<>());

    // Act and Assert
    assertNotEquals(resolutionResults, "Different type to ResolutionResults");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ResolutionResults}
   *   <li>{@link ResolutionResults#setInstruments(Map)}
   *   <li>{@link ResolutionResults#toString()}
   *   <li>{@link ResolutionResults#getInstruments()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ResolutionResults actualResolutionResults = new ResolutionResults();
    HashMap<String, ResolutionResult> instruments = new HashMap<>();
    actualResolutionResults.setInstruments(instruments);
    String actualToStringResult = actualResolutionResults.toString();
    Map<String, ResolutionResult> actualInstruments = actualResolutionResults.getInstruments();

    // Assert
    assertEquals("ResolutionResults(instruments={})", actualToStringResult);
    assertTrue(actualInstruments.isEmpty());
    assertSame(instruments, actualInstruments);
  }
}
