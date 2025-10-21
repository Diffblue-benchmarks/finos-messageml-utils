package org.symphonyoss.symphony.messageml.util;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.instrument.resolver.InstrumentKind;
import org.symphonyoss.symphony.messageml.util.instrument.resolver.InstrumentResolution;
import org.symphonyoss.symphony.messageml.util.instrument.resolver.MarketSector;

public class NoOpDataProviderDiffblueTest {
  /**
   * Test {@link NoOpDataProvider#getFinTagPresentation(List)}.
   * <p>
   * Method under test: {@link NoOpDataProvider#getFinTagPresentation(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.symphonyoss.symphony.messageml.util.instrument.resolver.ResolutionResults NoOpDataProvider.getFinTagPresentation(List)"})
  public void testGetFinTagPresentation() throws InvalidInputException {
    // Arrange
    NoOpDataProvider noOpDataProvider = new NoOpDataProvider();

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
    instrumentResolution2
        .setBbgCompTicker("org.symphonyoss.symphony.messageml.util.instrument.resolver.InstrumentResolution");
    instrumentResolution2.setBbgMarketSector(MarketSector.COMDTY);
    instrumentResolution2.setCountryCode("GBR");
    instrumentResolution2.setFigi("org.symphonyoss.symphony.messageml.util.instrument.resolver.InstrumentResolution");
    instrumentResolution2
        .setFigiTicker("org.symphonyoss.symphony.messageml.util.instrument.resolver.InstrumentResolution");
    instrumentResolution2
        .setFullBbgCompTicker("org.symphonyoss.symphony.messageml.util.instrument.resolver.InstrumentResolution");
    instrumentResolution2.setInstrumentClass(InstrumentKind.INDEX);
    instrumentResolution2.setIsin("org.symphonyoss.symphony.messageml.util.instrument.resolver.InstrumentResolution");
    instrumentResolution2
        .setLocalCode("org.symphonyoss.symphony.messageml.util.instrument.resolver.InstrumentResolution");
    instrumentResolution2
        .setOperationalMic("org.symphonyoss.symphony.messageml.util.instrument.resolver.InstrumentResolution");
    instrumentResolution2.setResolutionId("Resolution Id");
    instrumentResolution2
        .setReturnMainListing("org.symphonyoss.symphony.messageml.util.instrument.resolver.InstrumentResolution");
    instrumentResolution2.setUniqueId("Unique Id");
    instrumentResolution2.setUsCode("org.symphonyoss.symphony.messageml.util.instrument.resolver.InstrumentResolution");

    ArrayList<InstrumentResolution> uid = new ArrayList<>();
    uid.add(instrumentResolution2);
    uid.add(instrumentResolution);

    // Act and Assert
    assertNull(noOpDataProvider.getFinTagPresentation(uid));
  }

  /**
   * Test {@link NoOpDataProvider#getFinTagPresentation(List)}.
   * <ul>
   *   <li>Given {@link InstrumentResolution} (default constructor) BbgCompTicker is {@code Bbg Comp Ticker}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoOpDataProvider#getFinTagPresentation(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.symphonyoss.symphony.messageml.util.instrument.resolver.ResolutionResults NoOpDataProvider.getFinTagPresentation(List)"})
  public void testGetFinTagPresentation_givenInstrumentResolutionBbgCompTickerIsBbgCompTicker()
      throws InvalidInputException {
    // Arrange
    NoOpDataProvider noOpDataProvider = new NoOpDataProvider();

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

    ArrayList<InstrumentResolution> uid = new ArrayList<>();
    uid.add(instrumentResolution);

    // Act and Assert
    assertNull(noOpDataProvider.getFinTagPresentation(uid));
  }

  /**
   * Test {@link NoOpDataProvider#getFinTagPresentation(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoOpDataProvider#getFinTagPresentation(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.symphonyoss.symphony.messageml.util.instrument.resolver.ResolutionResults NoOpDataProvider.getFinTagPresentation(List)"})
  public void testGetFinTagPresentation_whenArrayList() throws InvalidInputException {
    // Arrange
    NoOpDataProvider noOpDataProvider = new NoOpDataProvider();

    // Act and Assert
    assertNull(noOpDataProvider.getFinTagPresentation(new ArrayList<>()));
  }
}
