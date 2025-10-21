package org.symphonyoss.symphony.messageml.util;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TagAttributesDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TagAttributes}
   *   <li>{@link TagAttributes#setBbgcompticker(String)}
   *   <li>{@link TagAttributes#setBbgmarketsector(String)}
   *   <li>{@link TagAttributes#setCountrycode(String)}
   *   <li>{@link TagAttributes#setFallbackTicker(String)}
   *   <li>{@link TagAttributes#setFigi(String)}
   *   <li>{@link TagAttributes#setFigiTicker(String)}
   *   <li>{@link TagAttributes#setFullBbgCompTicker(String)}
   *   <li>{@link TagAttributes#setInstrumentclass(String)}
   *   <li>{@link TagAttributes#setIsin(String)}
   *   <li>{@link TagAttributes#setLocalcode(String)}
   *   <li>{@link TagAttributes#setOperationalMic(String)}
   *   <li>{@link TagAttributes#setReturnMainListing(String)}
   *   <li>{@link TagAttributes#setUniqueId(String)}
   *   <li>{@link TagAttributes#setUscode(String)}
   *   <li>{@link TagAttributes#getBbgcompticker()}
   *   <li>{@link TagAttributes#getBbgmarketsector()}
   *   <li>{@link TagAttributes#getCountrycode()}
   *   <li>{@link TagAttributes#getFallbackTicker()}
   *   <li>{@link TagAttributes#getFigi()}
   *   <li>{@link TagAttributes#getFigiTicker()}
   *   <li>{@link TagAttributes#getFullBbgCompTicker()}
   *   <li>{@link TagAttributes#getInstrumentclass()}
   *   <li>{@link TagAttributes#getIsin()}
   *   <li>{@link TagAttributes#getLocalcode()}
   *   <li>{@link TagAttributes#getOperationalMic()}
   *   <li>{@link TagAttributes#getReturnMainListing()}
   *   <li>{@link TagAttributes#getUniqueId()}
   *   <li>{@link TagAttributes#getUscode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TagAttributes.<init>()", "String TagAttributes.getBbgcompticker()",
      "String TagAttributes.getBbgmarketsector()", "String TagAttributes.getCountrycode()",
      "String TagAttributes.getFallbackTicker()", "String TagAttributes.getFigi()",
      "String TagAttributes.getFigiTicker()", "String TagAttributes.getFullBbgCompTicker()",
      "String TagAttributes.getInstrumentclass()", "String TagAttributes.getIsin()",
      "String TagAttributes.getLocalcode()", "String TagAttributes.getOperationalMic()",
      "String TagAttributes.getReturnMainListing()", "String TagAttributes.getUniqueId()",
      "String TagAttributes.getUscode()", "void TagAttributes.setBbgcompticker(String)",
      "void TagAttributes.setBbgmarketsector(String)", "void TagAttributes.setCountrycode(String)",
      "void TagAttributes.setFallbackTicker(String)", "void TagAttributes.setFigi(String)",
      "void TagAttributes.setFigiTicker(String)", "void TagAttributes.setFullBbgCompTicker(String)",
      "void TagAttributes.setInstrumentclass(String)", "void TagAttributes.setIsin(String)",
      "void TagAttributes.setLocalcode(String)", "void TagAttributes.setOperationalMic(String)",
      "void TagAttributes.setReturnMainListing(String)", "void TagAttributes.setUniqueId(String)",
      "void TagAttributes.setUscode(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    TagAttributes actualTagAttributes = new TagAttributes();
    actualTagAttributes.setBbgcompticker("Bbgcompticker");
    actualTagAttributes.setBbgmarketsector("Bbgmarketsector");
    actualTagAttributes.setCountrycode("GB");
    actualTagAttributes.setFallbackTicker("Fallback Ticker");
    actualTagAttributes.setFigi("Figi");
    actualTagAttributes.setFigiTicker("Figi Ticker");
    actualTagAttributes.setFullBbgCompTicker("Full Bbg Comp Ticker");
    actualTagAttributes.setInstrumentclass("Instrumentclass");
    actualTagAttributes.setIsin("Isin");
    actualTagAttributes.setLocalcode("Localcode");
    actualTagAttributes.setOperationalMic("Operational Mic");
    actualTagAttributes.setReturnMainListing("Return Main Listing");
    actualTagAttributes.setUniqueId("42");
    actualTagAttributes.setUscode("Uscode");
    String actualBbgcompticker = actualTagAttributes.getBbgcompticker();
    String actualBbgmarketsector = actualTagAttributes.getBbgmarketsector();
    String actualCountrycode = actualTagAttributes.getCountrycode();
    String actualFallbackTicker = actualTagAttributes.getFallbackTicker();
    String actualFigi = actualTagAttributes.getFigi();
    String actualFigiTicker = actualTagAttributes.getFigiTicker();
    String actualFullBbgCompTicker = actualTagAttributes.getFullBbgCompTicker();
    String actualInstrumentclass = actualTagAttributes.getInstrumentclass();
    String actualIsin = actualTagAttributes.getIsin();
    String actualLocalcode = actualTagAttributes.getLocalcode();
    String actualOperationalMic = actualTagAttributes.getOperationalMic();
    String actualReturnMainListing = actualTagAttributes.getReturnMainListing();
    String actualUniqueId = actualTagAttributes.getUniqueId();

    // Assert
    assertEquals("42", actualUniqueId);
    assertEquals("Bbgcompticker", actualBbgcompticker);
    assertEquals("Bbgmarketsector", actualBbgmarketsector);
    assertEquals("Fallback Ticker", actualFallbackTicker);
    assertEquals("Figi Ticker", actualFigiTicker);
    assertEquals("Figi", actualFigi);
    assertEquals("Full Bbg Comp Ticker", actualFullBbgCompTicker);
    assertEquals("GB", actualCountrycode);
    assertEquals("Instrumentclass", actualInstrumentclass);
    assertEquals("Isin", actualIsin);
    assertEquals("Localcode", actualLocalcode);
    assertEquals("Operational Mic", actualOperationalMic);
    assertEquals("Return Main Listing", actualReturnMainListing);
    assertEquals("Uscode", actualTagAttributes.getUscode());
  }
}
