package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.commonmark.node.Node;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.TagNode;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.TagAttributes;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;
import org.symphonyoss.symphony.messageml.util.instrument.resolver.Instrument;
import org.symphonyoss.symphony.messageml.util.instrument.resolver.InstrumentKind;
import org.symphonyoss.symphony.messageml.util.instrument.resolver.MarketSector;
import org.symphonyoss.symphony.messageml.util.instrument.resolver.ProviderId;

public class TagDiffblueTest {
  /**
   * Test {@link Tag#Tag(Element, int)}.
   * <p>
   * Method under test: {@link Tag#Tag(Element, int)}
   */
  @Test
  public void testNewTag() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Tag actualTag = new Tag(parent, 1);

    // Assert
    Element parent2 = actualTag.getParent();
    assertTrue(parent2 instanceof Bold);
    assertEquals("1.0", actualTag.getEntityVersion());
    assertEquals("org.symphonyoss.fin.security.id.ticker", actualTag.getEntitySubType());
    assertEquals("tag1", actualTag.entityId);
    assertNull(actualTag.getEntityValue());
    assertEquals(0, actualTag.size());
    assertEquals(FormatEnum.MESSAGEML, actualTag.getFormat());
    assertTrue(actualTag.getChildren().isEmpty());
    assertTrue(actualTag.getAttributes().isEmpty());
    assertEquals(Span.MESSAGEML_TAG, actualTag.getPresentationMLTag());
    assertEquals(Tag.ENTITY_TYPE, actualTag.getEntityType());
    assertEquals(Tag.MESSAGEML_TAG, actualTag.getMessageMLTag());
    assertEquals(Tag.MESSAGEML_TAG, actualTag.getEntityIdPrefix());
    assertSame(parent, parent2);
  }

  /**
   * Test {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    Tag tag = new Tag(new Bold(new BulletList(mock(Element.class))), 1);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    tag.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(58L, out.getOffset());
  }

  /**
   * Test {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    Instrument instrument = new Instrument();
    instrument.setBbgCompId("42");
    instrument.setBbgCompTicker(Tag.PREFIX);
    instrument.setBbgMarketSector(MarketSector.EQUITY);
    instrument.setCfi(Tag.PREFIX);
    instrument.setCountryCode("GB");
    instrument.setCountryName("GB");
    instrument.setCurrency("GBP");
    instrument.setDisplayName(Tag.PREFIX);
    instrument.setEdiExchangeCode(Tag.PREFIX);
    instrument.setEdiInstrumentId("42");
    instrument.setExchangeName(Tag.PREFIX);
    instrument.setFigi(Tag.PREFIX);
    instrument.setFigiTicker(Tag.PREFIX);
    instrument.setFullBbgCompTicker(Tag.PREFIX);
    instrument.setInstrumentTypeCode(Tag.PREFIX);
    instrument.setInstrumentTypeName(Tag.PREFIX);
    instrument.setIsin(Tag.PREFIX);
    instrument.setKind(InstrumentKind.EQUITY);
    instrument.setLei(Tag.PREFIX);
    instrument.setLocalCode(Tag.PREFIX);
    instrument.setMainInstrument(true);
    instrument.setOperationalMic(Tag.PREFIX);
    instrument.setPrimaryExchange(true);
    instrument.setProviderId(ProviderId.EDI);
    instrument.setRic(Tag.PREFIX);
    instrument.setRootBbgCompTicker(Tag.PREFIX);
    instrument.setSedol(Tag.PREFIX);
    instrument.setUniqueId("42");
    instrument.setUsCode(Tag.PREFIX);
    instrument.setWkn(Tag.PREFIX);

    Tag tag = new Tag(new Bold(new BulletList(mock(Element.class))), 1);
    tag.setInstrument(instrument);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    tag.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(55L, out.getOffset());
  }

  /**
   * Test {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    Tag tag = new Tag(new Bold(new BulletList(mock(Element.class))), 1);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    tag.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(58L, out.getOffset());
  }

  /**
   * Test {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    Tag tag = new Tag(new Bold(new BulletList(mock(Element.class))), 1);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    tag.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(57L, out.getOffset());
  }

  /**
   * Test {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() {
    // Arrange
    Tag tag = new Tag(new Bold(new BulletList(mock(Element.class))), 1);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    tag.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(56L, out.getOffset());
  }

  /**
   * Test {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML6() {
    // Arrange
    Instrument instrument = new Instrument();
    instrument.setBbgCompId("42");
    instrument.setBbgCompTicker(Tag.PREFIX);
    instrument.setBbgMarketSector(MarketSector.EQUITY);
    instrument.setCfi(Tag.PREFIX);
    instrument.setCountryCode("GB");
    instrument.setCountryName("GB");
    instrument.setCurrency("GBP");
    instrument.setDisplayName(Tag.PREFIX);
    instrument.setEdiExchangeCode(Tag.PREFIX);
    instrument.setEdiInstrumentId("42");
    instrument.setExchangeName(Tag.PREFIX);
    instrument.setFigi(Tag.PREFIX);
    instrument.setFigiTicker(Tag.PREFIX);
    instrument.setFullBbgCompTicker(Tag.PREFIX);
    instrument.setInstrumentTypeCode(Tag.PREFIX);
    instrument.setInstrumentTypeName(Tag.PREFIX);
    instrument.setIsin(Tag.PREFIX);
    instrument.setKind(InstrumentKind.EQUITY);
    instrument.setLei(Tag.PREFIX);
    instrument.setLocalCode(Tag.PREFIX);
    instrument.setMainInstrument(true);
    instrument.setOperationalMic(Tag.PREFIX);
    instrument.setPrimaryExchange(true);
    instrument.setProviderId(ProviderId.EDI);
    instrument.setRic(Tag.PREFIX);
    instrument.setRootBbgCompTicker("=\"");
    instrument.setSedol(Tag.PREFIX);
    instrument.setUniqueId("42");
    instrument.setUsCode(Tag.PREFIX);
    instrument.setWkn(Tag.PREFIX);

    Tag tag = new Tag(new Bold(new BulletList(mock(Element.class))), 1);
    tag.setInstrument(instrument);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    tag.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(61L, out.getOffset());
  }

  /**
   * Test {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <ul>
   *   <li>Given {@link Instrument} (default constructor) RootBbgCompTicker is
   * {@code >}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML_givenInstrumentRootBbgCompTickerIsGreaterThanSign() {
    // Arrange
    Instrument instrument = new Instrument();
    instrument.setBbgCompId("42");
    instrument.setBbgCompTicker(Tag.PREFIX);
    instrument.setBbgMarketSector(MarketSector.EQUITY);
    instrument.setCfi(Tag.PREFIX);
    instrument.setCountryCode("GB");
    instrument.setCountryName("GB");
    instrument.setCurrency("GBP");
    instrument.setDisplayName(Tag.PREFIX);
    instrument.setEdiExchangeCode(Tag.PREFIX);
    instrument.setEdiInstrumentId("42");
    instrument.setExchangeName(Tag.PREFIX);
    instrument.setFigi(Tag.PREFIX);
    instrument.setFigiTicker(Tag.PREFIX);
    instrument.setFullBbgCompTicker(Tag.PREFIX);
    instrument.setInstrumentTypeCode(Tag.PREFIX);
    instrument.setInstrumentTypeName(Tag.PREFIX);
    instrument.setIsin(Tag.PREFIX);
    instrument.setKind(InstrumentKind.EQUITY);
    instrument.setLei(Tag.PREFIX);
    instrument.setLocalCode(Tag.PREFIX);
    instrument.setMainInstrument(true);
    instrument.setOperationalMic(Tag.PREFIX);
    instrument.setPrimaryExchange(true);
    instrument.setProviderId(ProviderId.EDI);
    instrument.setRic(Tag.PREFIX);
    instrument.setRootBbgCompTicker(">");
    instrument.setSedol(Tag.PREFIX);
    instrument.setUniqueId("42");
    instrument.setUsCode(Tag.PREFIX);
    instrument.setWkn(Tag.PREFIX);

    Tag tag = new Tag(new Bold(new BulletList(mock(Element.class))), 1);
    tag.setInstrument(instrument);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    tag.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(58L, out.getOffset());
  }

  /**
   * Test {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <ul>
   *   <li>Given {@link Instrument} (default constructor) RootBbgCompTicker is
   * {@code <}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML_givenInstrumentRootBbgCompTickerIsLessThanSign() {
    // Arrange
    Instrument instrument = new Instrument();
    instrument.setBbgCompId("42");
    instrument.setBbgCompTicker(Tag.PREFIX);
    instrument.setBbgMarketSector(MarketSector.EQUITY);
    instrument.setCfi(Tag.PREFIX);
    instrument.setCountryCode("GB");
    instrument.setCountryName("GB");
    instrument.setCurrency("GBP");
    instrument.setDisplayName(Tag.PREFIX);
    instrument.setEdiExchangeCode(Tag.PREFIX);
    instrument.setEdiInstrumentId("42");
    instrument.setExchangeName(Tag.PREFIX);
    instrument.setFigi(Tag.PREFIX);
    instrument.setFigiTicker(Tag.PREFIX);
    instrument.setFullBbgCompTicker(Tag.PREFIX);
    instrument.setInstrumentTypeCode(Tag.PREFIX);
    instrument.setInstrumentTypeName(Tag.PREFIX);
    instrument.setIsin(Tag.PREFIX);
    instrument.setKind(InstrumentKind.EQUITY);
    instrument.setLei(Tag.PREFIX);
    instrument.setLocalCode(Tag.PREFIX);
    instrument.setMainInstrument(true);
    instrument.setOperationalMic(Tag.PREFIX);
    instrument.setPrimaryExchange(true);
    instrument.setProviderId(ProviderId.EDI);
    instrument.setRic(Tag.PREFIX);
    instrument.setRootBbgCompTicker("<");
    instrument.setSedol(Tag.PREFIX);
    instrument.setUniqueId("42");
    instrument.setUsCode(Tag.PREFIX);
    instrument.setWkn(Tag.PREFIX);

    Tag tag = new Tag(new Bold(new BulletList(mock(Element.class))), 1);
    tag.setInstrument(instrument);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    tag.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(58L, out.getOffset());
  }

  /**
   * Test {@link Tag#asMarkdown()}.
   * <ul>
   *   <li>Given {@link Tag#Tag(Element, int)} with parent is
   * {@link Bold#Bold(Element)} and entityIndex is one.</li>
   *   <li>Then return Data is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#asMarkdown()}
   */
  @Test
  public void testAsMarkdown_givenTagWithParentIsBoldAndEntityIndexIsOne_thenReturnDataIsNull()
      throws InvalidInputException {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Tag(new Bold(new BulletList(mock(Element.class))), 1)).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof TagNode);
    assertNull(((TagNode) actualAsMarkdownResult).getData());
    assertNull(((TagNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertEquals(Tag.PREFIX, ((TagNode) actualAsMarkdownResult).getPrefix());
  }

  /**
   * Test {@link Tag#asMarkdown()}.
   * <ul>
   *   <li>Then return Text is {@code Root Bbg Comp Ticker}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#asMarkdown()}
   */
  @Test
  public void testAsMarkdown_thenReturnTextIsRootBbgCompTicker() throws InvalidInputException {
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

    Tag tag = new Tag(new Bold(new BulletList(mock(Element.class))), 1);
    tag.setInstrument(instrument);

    // Act
    Node actualAsMarkdownResult = tag.asMarkdown();

    // Assert
    JsonNode data = ((TagNode) actualAsMarkdownResult).getData();
    assertTrue(data instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = data.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(actualAsMarkdownResult instanceof TagNode);
    assertEquals("Root Bbg Comp Ticker", ((TagNode) actualAsMarkdownResult).getText());
    assertEquals("{\n" + "  \"uniqueId\" : \"42\",\n" + "  \"rootBbgCompTicker\" : \"Root Bbg Comp Ticker\",\n"
        + "  \"fullBbgCompTicker\" : \"Full Bbg Comp Ticker\",\n" + "  \"bbgCompTicker\" : \"Bbg Comp Ticker\",\n"
        + "  \"figi\" : \"Figi\",\n" + "  \"figiTicker\" : \"Figi Ticker\",\n" + "  \"localCode\" : \"Local Code\",\n"
        + "  \"instrumentTypeCode\" : \"Instrument Type Code\",\n"
        + "  \"instrumentTypeName\" : \"Instrument Type Name\",\n" + "  \"displayName\" : \"Display Name\",\n"
        + "  \"currency\" : \"GBP\",\n" + "  \"kind\" : \"EQUITY\",\n" + "  \"providerId\" : \"EDI\",\n"
        + "  \"isin\" : \"Isin\",\n" + "  \"ric\" : \"Ric\",\n" + "  \"wkn\" : \"Wkn\",\n"
        + "  \"ediInstrumentId\" : \"42\",\n" + "  \"bbgMarketSector\" : \"EQUITY\",\n"
        + "  \"countryCode\" : \"GB\",\n" + "  \"mainInstrument\" : true,\n" + "  \"bbgCompId\" : \"42\",\n"
        + "  \"usCode\" : \"Us Code\",\n" + "  \"sedol\" : \"Sedol\",\n" + "  \"cfi\" : \"Cfi\",\n"
        + "  \"lei\" : \"Lei\",\n" + "  \"countryName\" : \"GB\",\n" + "  \"exchangeName\" : \"Exchange Name\",\n"
        + "  \"ediExchangeCode\" : \"Edi Exchange Code\",\n" + "  \"primaryExchange\" : true,\n"
        + "  \"operationalMic\" : \"Operational Mic\"\n" + "}", data.toPrettyString());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Tag#setInstrument(Instrument)}
   *   <li>{@link Tag#getEntityIdPrefix()}
   *   <li>{@link Tag#getEntitySubType()}
   *   <li>{@link Tag#getEntityType()}
   *   <li>{@link Tag#getTagAttributes()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Tag tag = new Tag(new Bold(new BulletList(null)), 1);

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

    // Act
    tag.setInstrument(instrument);
    String actualEntityIdPrefix = tag.getEntityIdPrefix();
    String actualEntitySubType = tag.getEntitySubType();
    String actualEntityType = tag.getEntityType();
    TagAttributes actualTagAttributes = tag.getTagAttributes();

    // Assert
    assertEquals("org.symphonyoss.fin.security.id.ticker", actualEntitySubType);
    assertNull(actualTagAttributes.getBbgcompticker());
    assertNull(actualTagAttributes.getBbgmarketsector());
    assertNull(actualTagAttributes.getCountrycode());
    assertNull(actualTagAttributes.getFallbackTicker());
    assertNull(actualTagAttributes.getFigi());
    assertNull(actualTagAttributes.getFigiTicker());
    assertNull(actualTagAttributes.getFullBbgCompTicker());
    assertNull(actualTagAttributes.getInstrumentclass());
    assertNull(actualTagAttributes.getIsin());
    assertNull(actualTagAttributes.getLocalcode());
    assertNull(actualTagAttributes.getOperationalMic());
    assertNull(actualTagAttributes.getReturnMainListing());
    assertNull(actualTagAttributes.getUniqueId());
    assertNull(actualTagAttributes.getUscode());
    assertEquals(Tag.ENTITY_TYPE, actualEntityType);
    assertEquals(Tag.MESSAGEML_TAG, actualEntityIdPrefix);
  }

  /**
   * Test {@link Tag#getEntityValue()}.
   * <ul>
   *   <li>Given {@link Instrument} (default constructor) BbgCompId is
   * {@code 42}.</li>
   *   <li>Then return {@code Root Bbg Comp Ticker}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#getEntityValue()}
   */
  @Test
  public void testGetEntityValue_givenInstrumentBbgCompIdIs42_thenReturnRootBbgCompTicker() {
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

    Tag tag = new Tag(new Bold(new BulletList(mock(Element.class))), 1);
    tag.setInstrument(instrument);

    // Act and Assert
    assertEquals("Root Bbg Comp Ticker", tag.getEntityValue());
  }

  /**
   * Test {@link Tag#getEntityValue()}.
   * <ul>
   *   <li>Given {@link Tag#Tag(Element, int)} with parent is
   * {@link Bold#Bold(Element)} and entityIndex is one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#getEntityValue()}
   */
  @Test
  public void testGetEntityValue_givenTagWithParentIsBoldAndEntityIndexIsOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Tag(new Bold(new BulletList(mock(Element.class))), 1)).getEntityValue());
  }

  /**
   * Test {@link Tag#getEntityVersion()}.
   * <ul>
   *   <li>Given {@link Instrument} (default constructor) BbgCompId is
   * {@code 42}.</li>
   *   <li>Then return {@link MessageML#MESSAGEML_VERSION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#getEntityVersion()}
   */
  @Test
  public void testGetEntityVersion_givenInstrumentBbgCompIdIs42_thenReturnMessageml_version() {
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

    Tag tag = new Tag(new Bold(new BulletList(mock(Element.class))), 1);
    tag.setInstrument(instrument);

    // Act and Assert
    assertEquals(MessageML.MESSAGEML_VERSION, tag.getEntityVersion());
  }

  /**
   * Test {@link Tag#getEntityVersion()}.
   * <ul>
   *   <li>Given {@link Tag#Tag(Element, int)} with parent is
   * {@link Bold#Bold(Element)} and entityIndex is one.</li>
   *   <li>Then return {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#getEntityVersion()}
   */
  @Test
  public void testGetEntityVersion_givenTagWithParentIsBoldAndEntityIndexIsOne_thenReturn10() {
    // Arrange, Act and Assert
    assertEquals("1.0", (new Tag(new Bold(new BulletList(mock(Element.class))), 1)).getEntityVersion());
  }

  /**
   * Test {@link Tag#asText()}.
   * <ul>
   *   <li>Given {@link Instrument} (default constructor) BbgCompId is
   * {@code 42}.</li>
   *   <li>Then return {@code $Root Bbg Comp Ticker}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#asText()}
   */
  @Test
  public void testAsText_givenInstrumentBbgCompIdIs42_thenReturnRootBbgCompTicker() {
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

    Tag tag = new Tag(new Bold(new BulletList(mock(Element.class))), 1);
    tag.setInstrument(instrument);

    // Act and Assert
    assertEquals("$Root Bbg Comp Ticker", tag.asText());
  }

  /**
   * Test {@link Tag#asText()}.
   * <ul>
   *   <li>Given {@link Tag#Tag(Element, int)} with parent is
   * {@link Bold#Bold(Element)} and entityIndex is one.</li>
   *   <li>Then return {@code $null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#asText()}
   */
  @Test
  public void testAsText_givenTagWithParentIsBoldAndEntityIndexIsOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("$null", (new Tag(new Bold(new BulletList(mock(Element.class))), 1)).asText());
  }

  /**
   * Test {@link Tag#validateFallBackTicker()}.
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#validateFallBackTicker()}
   */
  @Test
  public void testValidateFallBackTicker_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new Tag(new Bold(new BulletList(mock(Element.class))), 1)).validateFallBackTicker());
  }

  /**
   * Test {@link Tag#updateBiContext(BiContext)}.
   * <p>
   * Method under test: {@link Tag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Tag tag = new Tag(new Bold(new BulletList(mock(Element.class))), 1);

    BiContext context = new BiContext();
    context.addItemWithValue("hashtags", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    tag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    BiItem getResult2 = items.get(3);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey(Element.STYLE_ATTR));
    assertEquals(Element.STYLE_ATTR, getResult.getName());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertEquals(Tag.ENTITY_TYPE, attributes2.get("entity_type"));
  }

  /**
   * Test {@link Tag#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Given {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_givenItemValue() {
    // Arrange
    Tag tag = new Tag(new Bold(new BulletList(mock(Element.class))), 1);

    BiContext context = new BiContext();
    context.addItemWithValue("hashtags", "Item Value");
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    tag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    BiItem getResult2 = items.get(3);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey(Element.STYLE_ATTR));
    assertEquals(Element.STYLE_ATTR, getResult.getName());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertEquals(Tag.ENTITY_TYPE, attributes2.get("entity_type"));
  }

  /**
   * Test {@link Tag#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    Tag tag = new Tag(new Bold(new BulletList(mock(Element.class))), 1);

    BiContext context = new BiContext();
    context.addItem(new BiItem("hashtags", Element.STYLE_ATTR));

    // Act
    tag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey(Element.STYLE_ATTR));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
    assertEquals(Tag.ENTITY_TYPE, attributes2.get("entity_type"));
  }

  /**
   * Test {@link Tag#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsSizeIsThree() {
    // Arrange
    Tag tag = new Tag(new Bold(new BulletList(mock(Element.class))), 1);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    tag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(1);
    assertEquals("hashtags", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    BiItem getResult2 = items.get(2);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertEquals(Tag.ENTITY_TYPE, attributes2.get("entity_type"));
  }

  /**
   * Test {@link Tag#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is
   * {@code hashtags}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsHashtags() {
    // Arrange
    Tag tag = new Tag(new Bold(new BulletList(mock(Element.class))), 1);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    tag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(2);
    assertEquals("hashtags", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Tag#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is
   * {@code hashtags}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsHashtags() {
    // Arrange
    Tag tag = new Tag(new Bold(new BulletList(mock(Element.class))), 1);
    BiContext context = new BiContext();

    // Act
    tag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(0);
    assertEquals("hashtags", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    BiItem getResult2 = items.get(1);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertEquals(Tag.ENTITY_TYPE, attributes2.get("entity_type"));
  }
}
