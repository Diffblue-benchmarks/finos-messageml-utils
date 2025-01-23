package org.symphonyoss.symphony.messageml.util.instrument.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class InstrumentResolutionDiffblueTest {
  /**
   * Test {@link InstrumentResolution#equals(Object)}, and
   * {@link InstrumentResolution#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InstrumentResolution#equals(Object)}
   *   <li>{@link InstrumentResolution#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertEquals(instrumentResolution, instrumentResolution2);
    int expectedHashCodeResult = instrumentResolution.hashCode();
    assertEquals(expectedHashCodeResult, instrumentResolution2.hashCode());
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}, and
   * {@link InstrumentResolution#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InstrumentResolution#equals(Object)}
   *   <li>{@link InstrumentResolution#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    // Act and Assert
    assertEquals(instrumentResolution, instrumentResolution);
    int expectedHashCodeResult = instrumentResolution.hashCode();
    assertEquals(expectedHashCodeResult, instrumentResolution.hashCode());
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("42");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker(null);
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(null);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.COMDTY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GBR");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode(null);
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("42");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi(null);
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("42");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker(null);
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("42");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker(null);
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(null);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.INDEX);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("42");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin(null);
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("42");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode(null);
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("42");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic(null);
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("Bbg Comp Ticker");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId(null);
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("42");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing(null);
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("Bbg Comp Ticker");
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId(null);
    instrumentResolution.setUsCode("Us Code");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("42");

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode(null);

    InstrumentResolution instrumentResolution2 = new InstrumentResolution();
    instrumentResolution2.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution2.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution2.setCountryCode("GB");
    instrumentResolution2.setFigi("Figi");
    instrumentResolution2.setFigiTicker("Figi Ticker");
    instrumentResolution2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution2.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution2.setIsin("Isin");
    instrumentResolution2.setLocalCode("Local Code");
    instrumentResolution2.setOperationalMic("Operational Mic");
    instrumentResolution2.setResolutionId("42");
    instrumentResolution2.setReturnMainListing("Return Main Listing");
    instrumentResolution2.setUniqueId("42");
    instrumentResolution2.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, instrumentResolution2);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, null);
  }

  /**
   * Test {@link InstrumentResolution#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstrumentResolution#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    InstrumentResolution instrumentResolution = new InstrumentResolution();
    instrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    instrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    instrumentResolution.setCountryCode("GB");
    instrumentResolution.setFigi("Figi");
    instrumentResolution.setFigiTicker("Figi Ticker");
    instrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    instrumentResolution.setIsin("Isin");
    instrumentResolution.setLocalCode("Local Code");
    instrumentResolution.setOperationalMic("Operational Mic");
    instrumentResolution.setResolutionId("42");
    instrumentResolution.setReturnMainListing("Return Main Listing");
    instrumentResolution.setUniqueId("42");
    instrumentResolution.setUsCode("Us Code");

    // Act and Assert
    assertNotEquals(instrumentResolution, "Different type to InstrumentResolution");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link InstrumentResolution}
   *   <li>{@link InstrumentResolution#setBbgCompTicker(String)}
   *   <li>{@link InstrumentResolution#setBbgMarketSector(MarketSector)}
   *   <li>{@link InstrumentResolution#setCountryCode(String)}
   *   <li>{@link InstrumentResolution#setFigi(String)}
   *   <li>{@link InstrumentResolution#setFigiTicker(String)}
   *   <li>{@link InstrumentResolution#setFullBbgCompTicker(String)}
   *   <li>{@link InstrumentResolution#setInstrumentClass(InstrumentKind)}
   *   <li>{@link InstrumentResolution#setIsin(String)}
   *   <li>{@link InstrumentResolution#setLocalCode(String)}
   *   <li>{@link InstrumentResolution#setOperationalMic(String)}
   *   <li>{@link InstrumentResolution#setResolutionId(String)}
   *   <li>{@link InstrumentResolution#setReturnMainListing(String)}
   *   <li>{@link InstrumentResolution#setUniqueId(String)}
   *   <li>{@link InstrumentResolution#setUsCode(String)}
   *   <li>{@link InstrumentResolution#toString()}
   *   <li>{@link InstrumentResolution#getBbgCompTicker()}
   *   <li>{@link InstrumentResolution#getBbgMarketSector()}
   *   <li>{@link InstrumentResolution#getCountryCode()}
   *   <li>{@link InstrumentResolution#getFigi()}
   *   <li>{@link InstrumentResolution#getFigiTicker()}
   *   <li>{@link InstrumentResolution#getFullBbgCompTicker()}
   *   <li>{@link InstrumentResolution#getInstrumentClass()}
   *   <li>{@link InstrumentResolution#getIsin()}
   *   <li>{@link InstrumentResolution#getLocalCode()}
   *   <li>{@link InstrumentResolution#getOperationalMic()}
   *   <li>{@link InstrumentResolution#getResolutionId()}
   *   <li>{@link InstrumentResolution#getReturnMainListing()}
   *   <li>{@link InstrumentResolution#getUniqueId()}
   *   <li>{@link InstrumentResolution#getUsCode()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    InstrumentResolution actualInstrumentResolution = new InstrumentResolution();
    actualInstrumentResolution.setBbgCompTicker("Bbg Comp Ticker");
    actualInstrumentResolution.setBbgMarketSector(MarketSector.EQUITY);
    actualInstrumentResolution.setCountryCode("GB");
    actualInstrumentResolution.setFigi("Figi");
    actualInstrumentResolution.setFigiTicker("Figi Ticker");
    actualInstrumentResolution.setFullBbgCompTicker("Full Bbg Comp Ticker");
    actualInstrumentResolution.setInstrumentClass(InstrumentKind.EQUITY);
    actualInstrumentResolution.setIsin("Isin");
    actualInstrumentResolution.setLocalCode("Local Code");
    actualInstrumentResolution.setOperationalMic("Operational Mic");
    actualInstrumentResolution.setResolutionId("42");
    actualInstrumentResolution.setReturnMainListing("Return Main Listing");
    actualInstrumentResolution.setUniqueId("42");
    actualInstrumentResolution.setUsCode("Us Code");
    String actualToStringResult = actualInstrumentResolution.toString();
    String actualBbgCompTicker = actualInstrumentResolution.getBbgCompTicker();
    MarketSector actualBbgMarketSector = actualInstrumentResolution.getBbgMarketSector();
    String actualCountryCode = actualInstrumentResolution.getCountryCode();
    String actualFigi = actualInstrumentResolution.getFigi();
    String actualFigiTicker = actualInstrumentResolution.getFigiTicker();
    String actualFullBbgCompTicker = actualInstrumentResolution.getFullBbgCompTicker();
    InstrumentKind actualInstrumentClass = actualInstrumentResolution.getInstrumentClass();
    String actualIsin = actualInstrumentResolution.getIsin();
    String actualLocalCode = actualInstrumentResolution.getLocalCode();
    String actualOperationalMic = actualInstrumentResolution.getOperationalMic();
    String actualResolutionId = actualInstrumentResolution.getResolutionId();
    String actualReturnMainListing = actualInstrumentResolution.getReturnMainListing();
    String actualUniqueId = actualInstrumentResolution.getUniqueId();

    // Assert
    assertEquals("42", actualResolutionId);
    assertEquals("42", actualUniqueId);
    assertEquals("Bbg Comp Ticker", actualBbgCompTicker);
    assertEquals("Figi Ticker", actualFigiTicker);
    assertEquals("Figi", actualFigi);
    assertEquals("Full Bbg Comp Ticker", actualFullBbgCompTicker);
    assertEquals("GB", actualCountryCode);
    assertEquals(
        "InstrumentResolution(resolutionId=42, bbgCompTicker=Bbg Comp Ticker, figi=Figi, figiTicker=Figi Ticker,"
            + " uniqueId=42, isin=Isin, usCode=Us Code, fullBbgCompTicker=Full Bbg Comp Ticker, localCode=Local Code,"
            + " operationalMic=Operational Mic, instrumentClass=EQUITY, countryCode=GB, returnMainListing=Return Main"
            + " Listing, bbgMarketSector=EQUITY)",
        actualToStringResult);
    assertEquals("Isin", actualIsin);
    assertEquals("Local Code", actualLocalCode);
    assertEquals("Operational Mic", actualOperationalMic);
    assertEquals("Return Main Listing", actualReturnMainListing);
    assertEquals("Us Code", actualInstrumentResolution.getUsCode());
    assertEquals(InstrumentKind.EQUITY, actualInstrumentClass);
    assertEquals(MarketSector.EQUITY, actualBbgMarketSector);
  }
}
