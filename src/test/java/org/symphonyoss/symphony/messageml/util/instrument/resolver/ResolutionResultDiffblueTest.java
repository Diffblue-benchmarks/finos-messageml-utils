package org.symphonyoss.symphony.messageml.util.instrument.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.mockito.Mockito;

public class ResolutionResultDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ResolutionResult#equals(Object)}
   *   <li>{@link ResolutionResult#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link ResolutionResult#equals(Object)}
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
   * Method under test: {@link ResolutionResult#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Instrument instrument = mock(Instrument.class);
    doNothing().when(instrument).setBbgCompId(Mockito.<String>any());
    doNothing().when(instrument).setBbgCompTicker(Mockito.<String>any());
    doNothing().when(instrument).setBbgMarketSector(Mockito.<MarketSector>any());
    doNothing().when(instrument).setCfi(Mockito.<String>any());
    doNothing().when(instrument).setCountryCode(Mockito.<String>any());
    doNothing().when(instrument).setCountryName(Mockito.<String>any());
    doNothing().when(instrument).setCurrency(Mockito.<String>any());
    doNothing().when(instrument).setDisplayName(Mockito.<String>any());
    doNothing().when(instrument).setEdiExchangeCode(Mockito.<String>any());
    doNothing().when(instrument).setEdiInstrumentId(Mockito.<String>any());
    doNothing().when(instrument).setExchangeName(Mockito.<String>any());
    doNothing().when(instrument).setFigi(Mockito.<String>any());
    doNothing().when(instrument).setFigiTicker(Mockito.<String>any());
    doNothing().when(instrument).setFullBbgCompTicker(Mockito.<String>any());
    doNothing().when(instrument).setInstrumentTypeCode(Mockito.<String>any());
    doNothing().when(instrument).setInstrumentTypeName(Mockito.<String>any());
    doNothing().when(instrument).setIsin(Mockito.<String>any());
    doNothing().when(instrument).setKind(Mockito.<InstrumentKind>any());
    doNothing().when(instrument).setLei(Mockito.<String>any());
    doNothing().when(instrument).setLocalCode(Mockito.<String>any());
    doNothing().when(instrument).setMainInstrument(Mockito.<Boolean>any());
    doNothing().when(instrument).setOperationalMic(Mockito.<String>any());
    doNothing().when(instrument).setPrimaryExchange(Mockito.<Boolean>any());
    doNothing().when(instrument).setProviderId(Mockito.<ProviderId>any());
    doNothing().when(instrument).setRic(Mockito.<String>any());
    doNothing().when(instrument).setRootBbgCompTicker(Mockito.<String>any());
    doNothing().when(instrument).setSedol(Mockito.<String>any());
    doNothing().when(instrument).setUniqueId(Mockito.<String>any());
    doNothing().when(instrument).setUsCode(Mockito.<String>any());
    doNothing().when(instrument).setWkn(Mockito.<String>any());
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
   * Method under test: {@link ResolutionResult#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Instrument instrument = mock(Instrument.class);
    doNothing().when(instrument).setBbgCompId(Mockito.<String>any());
    doNothing().when(instrument).setBbgCompTicker(Mockito.<String>any());
    doNothing().when(instrument).setBbgMarketSector(Mockito.<MarketSector>any());
    doNothing().when(instrument).setCfi(Mockito.<String>any());
    doNothing().when(instrument).setCountryCode(Mockito.<String>any());
    doNothing().when(instrument).setCountryName(Mockito.<String>any());
    doNothing().when(instrument).setCurrency(Mockito.<String>any());
    doNothing().when(instrument).setDisplayName(Mockito.<String>any());
    doNothing().when(instrument).setEdiExchangeCode(Mockito.<String>any());
    doNothing().when(instrument).setEdiInstrumentId(Mockito.<String>any());
    doNothing().when(instrument).setExchangeName(Mockito.<String>any());
    doNothing().when(instrument).setFigi(Mockito.<String>any());
    doNothing().when(instrument).setFigiTicker(Mockito.<String>any());
    doNothing().when(instrument).setFullBbgCompTicker(Mockito.<String>any());
    doNothing().when(instrument).setInstrumentTypeCode(Mockito.<String>any());
    doNothing().when(instrument).setInstrumentTypeName(Mockito.<String>any());
    doNothing().when(instrument).setIsin(Mockito.<String>any());
    doNothing().when(instrument).setKind(Mockito.<InstrumentKind>any());
    doNothing().when(instrument).setLei(Mockito.<String>any());
    doNothing().when(instrument).setLocalCode(Mockito.<String>any());
    doNothing().when(instrument).setMainInstrument(Mockito.<Boolean>any());
    doNothing().when(instrument).setOperationalMic(Mockito.<String>any());
    doNothing().when(instrument).setPrimaryExchange(Mockito.<Boolean>any());
    doNothing().when(instrument).setProviderId(Mockito.<ProviderId>any());
    doNothing().when(instrument).setRic(Mockito.<String>any());
    doNothing().when(instrument).setRootBbgCompTicker(Mockito.<String>any());
    doNothing().when(instrument).setSedol(Mockito.<String>any());
    doNothing().when(instrument).setUniqueId(Mockito.<String>any());
    doNothing().when(instrument).setUsCode(Mockito.<String>any());
    doNothing().when(instrument).setWkn(Mockito.<String>any());
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
   * Method under test: {@link ResolutionResult#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Instrument instrument = mock(Instrument.class);
    doNothing().when(instrument).setBbgCompId(Mockito.<String>any());
    doNothing().when(instrument).setBbgCompTicker(Mockito.<String>any());
    doNothing().when(instrument).setBbgMarketSector(Mockito.<MarketSector>any());
    doNothing().when(instrument).setCfi(Mockito.<String>any());
    doNothing().when(instrument).setCountryCode(Mockito.<String>any());
    doNothing().when(instrument).setCountryName(Mockito.<String>any());
    doNothing().when(instrument).setCurrency(Mockito.<String>any());
    doNothing().when(instrument).setDisplayName(Mockito.<String>any());
    doNothing().when(instrument).setEdiExchangeCode(Mockito.<String>any());
    doNothing().when(instrument).setEdiInstrumentId(Mockito.<String>any());
    doNothing().when(instrument).setExchangeName(Mockito.<String>any());
    doNothing().when(instrument).setFigi(Mockito.<String>any());
    doNothing().when(instrument).setFigiTicker(Mockito.<String>any());
    doNothing().when(instrument).setFullBbgCompTicker(Mockito.<String>any());
    doNothing().when(instrument).setInstrumentTypeCode(Mockito.<String>any());
    doNothing().when(instrument).setInstrumentTypeName(Mockito.<String>any());
    doNothing().when(instrument).setIsin(Mockito.<String>any());
    doNothing().when(instrument).setKind(Mockito.<InstrumentKind>any());
    doNothing().when(instrument).setLei(Mockito.<String>any());
    doNothing().when(instrument).setLocalCode(Mockito.<String>any());
    doNothing().when(instrument).setMainInstrument(Mockito.<Boolean>any());
    doNothing().when(instrument).setOperationalMic(Mockito.<String>any());
    doNothing().when(instrument).setPrimaryExchange(Mockito.<Boolean>any());
    doNothing().when(instrument).setProviderId(Mockito.<ProviderId>any());
    doNothing().when(instrument).setRic(Mockito.<String>any());
    doNothing().when(instrument).setRootBbgCompTicker(Mockito.<String>any());
    doNothing().when(instrument).setSedol(Mockito.<String>any());
    doNothing().when(instrument).setUniqueId(Mockito.<String>any());
    doNothing().when(instrument).setUsCode(Mockito.<String>any());
    doNothing().when(instrument).setWkn(Mockito.<String>any());
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
   * Method under test: {@link ResolutionResult#equals(Object)}
   */
  @Test
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
   * Method under test: {@link ResolutionResult#equals(Object)}
   */
  @Test
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

    // Assert that nothing has changed
    assertEquals(1, actualResolutionResult.getReturnCode().intValue());
    assertSame(instrument, actualInstrument);
  }
}
