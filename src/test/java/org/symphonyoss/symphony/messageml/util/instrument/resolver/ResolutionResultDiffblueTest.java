package org.symphonyoss.symphony.messageml.util.instrument.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ResolutionResultDiffblueTest {
  /**
   * Test {@link ResolutionResult#equals(Object)}, and {@link ResolutionResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResolutionResult#equals(Object)}
   *   <li>{@link ResolutionResult#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ResolutionResult.equals(Object)", "int ResolutionResult.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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

    // Act and Assert
    assertEquals(resolutionResult, resolutionResult);
    int expectedHashCodeResult = resolutionResult.hashCode();
    assertEquals(expectedHashCodeResult, resolutionResult.hashCode());
  }

  /**
   * Test {@link ResolutionResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResolutionResult#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ResolutionResult.equals(Object)", "int ResolutionResult.hashCode()"})
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

    Instrument instrument2 = new Instrument();
    instrument2.setBbgCompId("42");
    instrument2.setBbgCompTicker("Bbg Comp Ticker");
    instrument2.setBbgMarketSector(MarketSector.EQUITY);
    instrument2.setCfi("Cfi");
    instrument2.setCountryCode("GB");
    instrument2.setCountryName("GB");
    instrument2.setCurrency("GBP");
    instrument2.setDisplayName("Display Name");
    instrument2.setEdiExchangeCode("Edi Exchange Code");
    instrument2.setEdiInstrumentId("42");
    instrument2.setExchangeName("Exchange Name");
    instrument2.setFigi("Figi");
    instrument2.setFigiTicker("Figi Ticker");
    instrument2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrument2.setInstrumentTypeCode("Instrument Type Code");
    instrument2.setInstrumentTypeName("Instrument Type Name");
    instrument2.setIsin("Isin");
    instrument2.setKind(InstrumentKind.EQUITY);
    instrument2.setLei("Lei");
    instrument2.setLocalCode("Local Code");
    instrument2.setMainInstrument(true);
    instrument2.setOperationalMic("Operational Mic");
    instrument2.setPrimaryExchange(true);
    instrument2.setProviderId(ProviderId.EDI);
    instrument2.setRic("Ric");
    instrument2.setRootBbgCompTicker("Root Bbg Comp Ticker");
    instrument2.setSedol("Sedol");
    instrument2.setUniqueId("42");
    instrument2.setUsCode("Us Code");
    instrument2.setWkn("Wkn");

    ResolutionResult resolutionResult2 = new ResolutionResult();
    resolutionResult2.setInstrument(instrument2);
    resolutionResult2.setReturnCode(1);

    // Act and Assert
    assertNotEquals(resolutionResult, resolutionResult2);
  }

  /**
   * Test {@link ResolutionResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResolutionResult#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ResolutionResult.equals(Object)", "int ResolutionResult.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
    resolutionResult.setReturnCode(3);

    Instrument instrument2 = new Instrument();
    instrument2.setBbgCompId("42");
    instrument2.setBbgCompTicker("Bbg Comp Ticker");
    instrument2.setBbgMarketSector(MarketSector.EQUITY);
    instrument2.setCfi("Cfi");
    instrument2.setCountryCode("GB");
    instrument2.setCountryName("GB");
    instrument2.setCurrency("GBP");
    instrument2.setDisplayName("Display Name");
    instrument2.setEdiExchangeCode("Edi Exchange Code");
    instrument2.setEdiInstrumentId("42");
    instrument2.setExchangeName("Exchange Name");
    instrument2.setFigi("Figi");
    instrument2.setFigiTicker("Figi Ticker");
    instrument2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrument2.setInstrumentTypeCode("Instrument Type Code");
    instrument2.setInstrumentTypeName("Instrument Type Name");
    instrument2.setIsin("Isin");
    instrument2.setKind(InstrumentKind.EQUITY);
    instrument2.setLei("Lei");
    instrument2.setLocalCode("Local Code");
    instrument2.setMainInstrument(true);
    instrument2.setOperationalMic("Operational Mic");
    instrument2.setPrimaryExchange(true);
    instrument2.setProviderId(ProviderId.EDI);
    instrument2.setRic("Ric");
    instrument2.setRootBbgCompTicker("Root Bbg Comp Ticker");
    instrument2.setSedol("Sedol");
    instrument2.setUniqueId("42");
    instrument2.setUsCode("Us Code");
    instrument2.setWkn("Wkn");

    ResolutionResult resolutionResult2 = new ResolutionResult();
    resolutionResult2.setInstrument(instrument2);
    resolutionResult2.setReturnCode(1);

    // Act and Assert
    assertNotEquals(resolutionResult, resolutionResult2);
  }

  /**
   * Test {@link ResolutionResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResolutionResult#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ResolutionResult.equals(Object)", "int ResolutionResult.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
    resolutionResult.setReturnCode(null);

    Instrument instrument2 = new Instrument();
    instrument2.setBbgCompId("42");
    instrument2.setBbgCompTicker("Bbg Comp Ticker");
    instrument2.setBbgMarketSector(MarketSector.EQUITY);
    instrument2.setCfi("Cfi");
    instrument2.setCountryCode("GB");
    instrument2.setCountryName("GB");
    instrument2.setCurrency("GBP");
    instrument2.setDisplayName("Display Name");
    instrument2.setEdiExchangeCode("Edi Exchange Code");
    instrument2.setEdiInstrumentId("42");
    instrument2.setExchangeName("Exchange Name");
    instrument2.setFigi("Figi");
    instrument2.setFigiTicker("Figi Ticker");
    instrument2.setFullBbgCompTicker("Full Bbg Comp Ticker");
    instrument2.setInstrumentTypeCode("Instrument Type Code");
    instrument2.setInstrumentTypeName("Instrument Type Name");
    instrument2.setIsin("Isin");
    instrument2.setKind(InstrumentKind.EQUITY);
    instrument2.setLei("Lei");
    instrument2.setLocalCode("Local Code");
    instrument2.setMainInstrument(true);
    instrument2.setOperationalMic("Operational Mic");
    instrument2.setPrimaryExchange(true);
    instrument2.setProviderId(ProviderId.EDI);
    instrument2.setRic("Ric");
    instrument2.setRootBbgCompTicker("Root Bbg Comp Ticker");
    instrument2.setSedol("Sedol");
    instrument2.setUniqueId("42");
    instrument2.setUsCode("Us Code");
    instrument2.setWkn("Wkn");

    ResolutionResult resolutionResult2 = new ResolutionResult();
    resolutionResult2.setInstrument(instrument2);
    resolutionResult2.setReturnCode(1);

    // Act and Assert
    assertNotEquals(resolutionResult, resolutionResult2);
  }

  /**
   * Test {@link ResolutionResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResolutionResult#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ResolutionResult.equals(Object)", "int ResolutionResult.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(resolutionResult, null);
  }

  /**
   * Test {@link ResolutionResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResolutionResult#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ResolutionResult.equals(Object)", "int ResolutionResult.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(resolutionResult, "Different type to ResolutionResult");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ResolutionResult}
   *   <li>{@link ResolutionResult#setInstrument(Instrument)}
   *   <li>{@link ResolutionResult#setReturnCode(Integer)}
   *   <li>{@link ResolutionResult#toString()}
   *   <li>{@link ResolutionResult#getInstrument()}
   *   <li>{@link ResolutionResult#getReturnCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResolutionResult.<init>()", "Instrument ResolutionResult.getInstrument()",
      "Integer ResolutionResult.getReturnCode()", "void ResolutionResult.setInstrument(Instrument)",
      "void ResolutionResult.setReturnCode(Integer)", "java.lang.String ResolutionResult.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    ResolutionResult actualResolutionResult = new ResolutionResult();
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
    actualResolutionResult.setInstrument(instrument);
    actualResolutionResult.setReturnCode(1);
    actualResolutionResult.toString();
    Instrument actualInstrument = actualResolutionResult.getInstrument();

    // Assert
    assertEquals(1, actualResolutionResult.getReturnCode().intValue());
    assertSame(instrument, actualInstrument);
  }
}
