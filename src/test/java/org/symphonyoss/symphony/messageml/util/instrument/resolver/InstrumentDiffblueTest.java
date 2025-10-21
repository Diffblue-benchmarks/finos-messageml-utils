package org.symphonyoss.symphony.messageml.util.instrument.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InstrumentDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Instrument}
   *   <li>{@link Instrument#setBbgCompId(String)}
   *   <li>{@link Instrument#setBbgCompTicker(String)}
   *   <li>{@link Instrument#setBbgMarketSector(MarketSector)}
   *   <li>{@link Instrument#setCfi(String)}
   *   <li>{@link Instrument#setCountryCode(String)}
   *   <li>{@link Instrument#setCountryName(String)}
   *   <li>{@link Instrument#setCurrency(String)}
   *   <li>{@link Instrument#setDisplayName(String)}
   *   <li>{@link Instrument#setEdiExchangeCode(String)}
   *   <li>{@link Instrument#setEdiInstrumentId(String)}
   *   <li>{@link Instrument#setExchangeName(String)}
   *   <li>{@link Instrument#setFigi(String)}
   *   <li>{@link Instrument#setFigiTicker(String)}
   *   <li>{@link Instrument#setFullBbgCompTicker(String)}
   *   <li>{@link Instrument#setInstrumentTypeCode(String)}
   *   <li>{@link Instrument#setInstrumentTypeName(String)}
   *   <li>{@link Instrument#setIsin(String)}
   *   <li>{@link Instrument#setKind(InstrumentKind)}
   *   <li>{@link Instrument#setLei(String)}
   *   <li>{@link Instrument#setLocalCode(String)}
   *   <li>{@link Instrument#setMainInstrument(Boolean)}
   *   <li>{@link Instrument#setOperationalMic(String)}
   *   <li>{@link Instrument#setPrimaryExchange(Boolean)}
   *   <li>{@link Instrument#setProviderId(ProviderId)}
   *   <li>{@link Instrument#setRic(String)}
   *   <li>{@link Instrument#setRootBbgCompTicker(String)}
   *   <li>{@link Instrument#setSedol(String)}
   *   <li>{@link Instrument#setUniqueId(String)}
   *   <li>{@link Instrument#setUsCode(String)}
   *   <li>{@link Instrument#setWkn(String)}
   *   <li>{@link Instrument#getBbgCompId()}
   *   <li>{@link Instrument#getBbgCompTicker()}
   *   <li>{@link Instrument#getBbgMarketSector()}
   *   <li>{@link Instrument#getCfi()}
   *   <li>{@link Instrument#getCountryCode()}
   *   <li>{@link Instrument#getCountryName()}
   *   <li>{@link Instrument#getCurrency()}
   *   <li>{@link Instrument#getDisplayName()}
   *   <li>{@link Instrument#getEdiExchangeCode()}
   *   <li>{@link Instrument#getEdiInstrumentId()}
   *   <li>{@link Instrument#getExchangeName()}
   *   <li>{@link Instrument#getFigi()}
   *   <li>{@link Instrument#getFigiTicker()}
   *   <li>{@link Instrument#getFullBbgCompTicker()}
   *   <li>{@link Instrument#getInstrumentTypeCode()}
   *   <li>{@link Instrument#getInstrumentTypeName()}
   *   <li>{@link Instrument#getIsin()}
   *   <li>{@link Instrument#getKind()}
   *   <li>{@link Instrument#getLei()}
   *   <li>{@link Instrument#getLocalCode()}
   *   <li>{@link Instrument#getMainInstrument()}
   *   <li>{@link Instrument#getOperationalMic()}
   *   <li>{@link Instrument#getPrimaryExchange()}
   *   <li>{@link Instrument#getProviderId()}
   *   <li>{@link Instrument#getRic()}
   *   <li>{@link Instrument#getRootBbgCompTicker()}
   *   <li>{@link Instrument#getSedol()}
   *   <li>{@link Instrument#getUniqueId()}
   *   <li>{@link Instrument#getUsCode()}
   *   <li>{@link Instrument#getWkn()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Instrument.<init>()", "String Instrument.getBbgCompId()",
      "String Instrument.getBbgCompTicker()", "MarketSector Instrument.getBbgMarketSector()",
      "String Instrument.getCfi()", "String Instrument.getCountryCode()", "String Instrument.getCountryName()",
      "String Instrument.getCurrency()", "String Instrument.getDisplayName()", "String Instrument.getEdiExchangeCode()",
      "String Instrument.getEdiInstrumentId()", "String Instrument.getExchangeName()", "String Instrument.getFigi()",
      "String Instrument.getFigiTicker()", "String Instrument.getFullBbgCompTicker()",
      "String Instrument.getInstrumentTypeCode()", "String Instrument.getInstrumentTypeName()",
      "String Instrument.getIsin()", "InstrumentKind Instrument.getKind()", "String Instrument.getLei()",
      "String Instrument.getLocalCode()", "Boolean Instrument.getMainInstrument()",
      "String Instrument.getOperationalMic()", "Boolean Instrument.getPrimaryExchange()",
      "ProviderId Instrument.getProviderId()", "String Instrument.getRic()", "String Instrument.getRootBbgCompTicker()",
      "String Instrument.getSedol()", "String Instrument.getUniqueId()", "String Instrument.getUsCode()",
      "String Instrument.getWkn()", "void Instrument.setBbgCompId(String)", "void Instrument.setBbgCompTicker(String)",
      "void Instrument.setBbgMarketSector(MarketSector)", "void Instrument.setCfi(String)",
      "void Instrument.setCountryCode(String)", "void Instrument.setCountryName(String)",
      "void Instrument.setCurrency(String)", "void Instrument.setDisplayName(String)",
      "void Instrument.setEdiExchangeCode(String)", "void Instrument.setEdiInstrumentId(String)",
      "void Instrument.setExchangeName(String)", "void Instrument.setFigi(String)",
      "void Instrument.setFigiTicker(String)", "void Instrument.setFullBbgCompTicker(String)",
      "void Instrument.setInstrumentTypeCode(String)", "void Instrument.setInstrumentTypeName(String)",
      "void Instrument.setIsin(String)", "void Instrument.setKind(InstrumentKind)", "void Instrument.setLei(String)",
      "void Instrument.setLocalCode(String)", "void Instrument.setMainInstrument(Boolean)",
      "void Instrument.setOperationalMic(String)", "void Instrument.setPrimaryExchange(Boolean)",
      "void Instrument.setProviderId(ProviderId)", "void Instrument.setRic(String)",
      "void Instrument.setRootBbgCompTicker(String)", "void Instrument.setSedol(String)",
      "void Instrument.setUniqueId(String)", "void Instrument.setUsCode(String)", "void Instrument.setWkn(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    Instrument actualInstrument = new Instrument();
    actualInstrument.setBbgCompId("42");
    actualInstrument.setBbgCompTicker("Bbg Comp Ticker");
    actualInstrument.setBbgMarketSector(MarketSector.EQUITY);
    actualInstrument.setCfi("Cfi");
    actualInstrument.setCountryCode("GB");
    actualInstrument.setCountryName("GB");
    actualInstrument.setCurrency("GBP");
    actualInstrument.setDisplayName("Display Name");
    actualInstrument.setEdiExchangeCode("Edi Exchange Code");
    actualInstrument.setEdiInstrumentId("42");
    actualInstrument.setExchangeName("Exchange Name");
    actualInstrument.setFigi("Figi");
    actualInstrument.setFigiTicker("Figi Ticker");
    actualInstrument.setFullBbgCompTicker("Full Bbg Comp Ticker");
    actualInstrument.setInstrumentTypeCode("Instrument Type Code");
    actualInstrument.setInstrumentTypeName("Instrument Type Name");
    actualInstrument.setIsin("Isin");
    actualInstrument.setKind(InstrumentKind.EQUITY);
    actualInstrument.setLei("Lei");
    actualInstrument.setLocalCode("Local Code");
    actualInstrument.setMainInstrument(true);
    actualInstrument.setOperationalMic("Operational Mic");
    actualInstrument.setPrimaryExchange(true);
    actualInstrument.setProviderId(ProviderId.EDI);
    actualInstrument.setRic("Ric");
    actualInstrument.setRootBbgCompTicker("Root Bbg Comp Ticker");
    actualInstrument.setSedol("Sedol");
    actualInstrument.setUniqueId("42");
    actualInstrument.setUsCode("Us Code");
    actualInstrument.setWkn("Wkn");
    String actualBbgCompId = actualInstrument.getBbgCompId();
    String actualBbgCompTicker = actualInstrument.getBbgCompTicker();
    MarketSector actualBbgMarketSector = actualInstrument.getBbgMarketSector();
    String actualCfi = actualInstrument.getCfi();
    String actualCountryCode = actualInstrument.getCountryCode();
    String actualCountryName = actualInstrument.getCountryName();
    String actualCurrency = actualInstrument.getCurrency();
    String actualDisplayName = actualInstrument.getDisplayName();
    String actualEdiExchangeCode = actualInstrument.getEdiExchangeCode();
    String actualEdiInstrumentId = actualInstrument.getEdiInstrumentId();
    String actualExchangeName = actualInstrument.getExchangeName();
    String actualFigi = actualInstrument.getFigi();
    String actualFigiTicker = actualInstrument.getFigiTicker();
    String actualFullBbgCompTicker = actualInstrument.getFullBbgCompTicker();
    String actualInstrumentTypeCode = actualInstrument.getInstrumentTypeCode();
    String actualInstrumentTypeName = actualInstrument.getInstrumentTypeName();
    String actualIsin = actualInstrument.getIsin();
    InstrumentKind actualKind = actualInstrument.getKind();
    String actualLei = actualInstrument.getLei();
    String actualLocalCode = actualInstrument.getLocalCode();
    Boolean actualMainInstrument = actualInstrument.getMainInstrument();
    String actualOperationalMic = actualInstrument.getOperationalMic();
    Boolean actualPrimaryExchange = actualInstrument.getPrimaryExchange();
    ProviderId actualProviderId = actualInstrument.getProviderId();
    String actualRic = actualInstrument.getRic();
    String actualRootBbgCompTicker = actualInstrument.getRootBbgCompTicker();
    String actualSedol = actualInstrument.getSedol();
    String actualUniqueId = actualInstrument.getUniqueId();
    String actualUsCode = actualInstrument.getUsCode();

    // Assert
    assertEquals("42", actualBbgCompId);
    assertEquals("42", actualEdiInstrumentId);
    assertEquals("42", actualUniqueId);
    assertEquals("Bbg Comp Ticker", actualBbgCompTicker);
    assertEquals("Cfi", actualCfi);
    assertEquals("Display Name", actualDisplayName);
    assertEquals("Edi Exchange Code", actualEdiExchangeCode);
    assertEquals("Exchange Name", actualExchangeName);
    assertEquals("Figi Ticker", actualFigiTicker);
    assertEquals("Figi", actualFigi);
    assertEquals("Full Bbg Comp Ticker", actualFullBbgCompTicker);
    assertEquals("GB", actualCountryCode);
    assertEquals("GB", actualCountryName);
    assertEquals("GBP", actualCurrency);
    assertEquals("Instrument Type Code", actualInstrumentTypeCode);
    assertEquals("Instrument Type Name", actualInstrumentTypeName);
    assertEquals("Isin", actualIsin);
    assertEquals("Lei", actualLei);
    assertEquals("Local Code", actualLocalCode);
    assertEquals("Operational Mic", actualOperationalMic);
    assertEquals("Ric", actualRic);
    assertEquals("Root Bbg Comp Ticker", actualRootBbgCompTicker);
    assertEquals("Sedol", actualSedol);
    assertEquals("Us Code", actualUsCode);
    assertEquals("Wkn", actualInstrument.getWkn());
    assertEquals(InstrumentKind.EQUITY, actualKind);
    assertEquals(MarketSector.EQUITY, actualBbgMarketSector);
    assertEquals(ProviderId.EDI, actualProviderId);
    assertTrue(actualMainInstrument);
    assertTrue(actualPrimaryExchange);
  }
}
