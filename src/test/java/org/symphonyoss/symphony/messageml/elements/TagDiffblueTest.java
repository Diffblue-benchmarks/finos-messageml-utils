package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
   * Method under test:
   * {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML7() {
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
   * Method under test:
   * {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML8() {
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
   * Method under test: {@link Tag#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() throws InvalidInputException {
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
   * Method under test: {@link Tag#asMarkdown()}
   */
  @Test
  public void testAsMarkdown2() throws IOException, InvalidInputException {
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
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    JsonNode nextResult3 = iteratorResult.next();
    assertTrue(nextResult3 instanceof TextNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = nextResult2.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonParser traverseResult3 = nextResult3.traverse();
    assertTrue(traverseResult3 instanceof TreeTraversingParser);
    JsonParser traverseResult4 = data.traverse();
    assertTrue(traverseResult4 instanceof TreeTraversingParser);
    assertTrue(actualAsMarkdownResult instanceof TagNode);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    JsonStreamContext parsingContext3 = traverseResult3.getParsingContext();
    assertEquals("ROOT", parsingContext3.getTypeDesc());
    JsonStreamContext parsingContext4 = traverseResult4.getParsingContext();
    assertEquals("ROOT", parsingContext4.getTypeDesc());
    assertEquals("Root Bbg Comp Ticker", ((TagNode) actualAsMarkdownResult).getText());
    assertEquals("\"42\"", nextResult.toPrettyString());
    assertEquals("\"Full Bbg Comp Ticker\"", nextResult3.toPrettyString());
    assertEquals("\"Root Bbg Comp Ticker\"", nextResult2.toPrettyString());
    Version versionResult = traverseResult4.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult3.getBinaryValue());
    assertNull(traverseResult4.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult3.getSchema());
    assertNull(traverseResult4.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult3.getCurrentToken());
    assertNull(traverseResult4.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult3.getLastClearedToken());
    assertNull(traverseResult4.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult3.getCodec());
    assertNull(traverseResult4.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    assertNull(traverseResult3.getNonBlockingInputFeeder());
    assertNull(traverseResult4.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult4.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult3.getCurrentValue());
    assertNull(traverseResult4.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult3.getEmbeddedObject());
    assertNull(traverseResult4.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult3.getInputSource());
    assertNull(traverseResult4.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult3.getObjectId());
    assertNull(traverseResult4.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(traverseResult3.getTypeId());
    assertNull(traverseResult4.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(parsingContext3.getCurrentValue());
    assertNull(parsingContext4.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult3.getCurrentName());
    assertNull(traverseResult4.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult3.getText());
    assertNull(traverseResult4.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(traverseResult3.getValueAsString());
    assertNull(traverseResult4.getValueAsString());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult3.getCurrentTokenId());
    assertEquals(0, traverseResult4.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult3.getFeatureMask());
    assertEquals(0, traverseResult4.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult3.getFormatFeatures());
    assertEquals(0, traverseResult4.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult3.getTextOffset());
    assertEquals(0, traverseResult4.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, traverseResult3.getValueAsInt());
    assertEquals(0, traverseResult4.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext3.getCurrentIndex());
    assertEquals(0, parsingContext4.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext3.getEntryCount());
    assertEquals(0, parsingContext4.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, parsingContext3.getNestingDepth());
    assertEquals(0, parsingContext4.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0, nextResult2.size());
    assertEquals(0, nextResult3.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult3.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult4.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, traverseResult3.getValueAsLong());
    assertEquals(0L, traverseResult4.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(30, data.size());
    assertEquals(JsonNodeType.OBJECT, data.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult2.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult3.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult3.getValueAsBoolean());
    assertFalse(traverseResult4.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult3.hasCurrentToken());
    assertFalse(traverseResult4.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult3.hasTextCharacters());
    assertFalse(traverseResult4.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult3.isClosed());
    assertFalse(traverseResult4.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult3.isExpectedNumberIntToken());
    assertFalse(traverseResult4.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult3.isExpectedStartArrayToken());
    assertFalse(traverseResult4.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult3.isExpectedStartObjectToken());
    assertFalse(traverseResult4.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(traverseResult3.isNaN());
    assertFalse(traverseResult4.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext3.hasCurrentIndex());
    assertFalse(parsingContext4.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext3.hasCurrentName());
    assertFalse(parsingContext4.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(parsingContext3.hasPathSegment());
    assertFalse(parsingContext4.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult2.isArray());
    assertFalse(nextResult3.isArray());
    assertFalse(data.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult2.isBigDecimal());
    assertFalse(nextResult3.isBigDecimal());
    assertFalse(data.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult2.isBigInteger());
    assertFalse(nextResult3.isBigInteger());
    assertFalse(data.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult2.isBinary());
    assertFalse(nextResult3.isBinary());
    assertFalse(data.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult2.isBoolean());
    assertFalse(nextResult3.isBoolean());
    assertFalse(data.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult2.isContainerNode());
    assertFalse(nextResult3.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult2.isDouble());
    assertFalse(nextResult3.isDouble());
    assertFalse(data.isDouble());
    assertFalse(data.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult2.isFloat());
    assertFalse(nextResult3.isFloat());
    assertFalse(data.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult2.isFloatingPointNumber());
    assertFalse(nextResult3.isFloatingPointNumber());
    assertFalse(data.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult2.isInt());
    assertFalse(nextResult3.isInt());
    assertFalse(data.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult2.isIntegralNumber());
    assertFalse(nextResult3.isIntegralNumber());
    assertFalse(data.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult2.isLong());
    assertFalse(nextResult3.isLong());
    assertFalse(data.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult2.isMissingNode());
    assertFalse(nextResult3.isMissingNode());
    assertFalse(data.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult2.isNull());
    assertFalse(nextResult3.isNull());
    assertFalse(data.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult2.isNumber());
    assertFalse(nextResult3.isNumber());
    assertFalse(data.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult2.isObject());
    assertFalse(nextResult3.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult2.isPojo());
    assertFalse(nextResult3.isPojo());
    assertFalse(data.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult2.isShort());
    assertFalse(nextResult3.isShort());
    assertFalse(data.isShort());
    assertFalse(data.isTextual());
    assertFalse(data.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(data.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult2.isEmpty());
    assertTrue(nextResult3.isEmpty());
    assertTrue(data.isObject());
    assertTrue(nextResult.isTextual());
    assertTrue(nextResult2.isTextual());
    assertTrue(nextResult3.isTextual());
    assertTrue(nextResult.isValueNode());
    assertTrue(nextResult2.isValueNode());
    assertTrue(nextResult3.isValueNode());
    assertTrue(iteratorResult.hasNext());
    assertEquals(Tag.PREFIX, ((TagNode) actualAsMarkdownResult).getPrefix());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult2.getCurrentLocation());
    assertSame(currentLocation, traverseResult3.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(currentLocation, traverseResult3.getTokenLocation());
    assertSame(currentLocation, traverseResult4.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(versionResult, traverseResult2.version());
    assertSame(versionResult, traverseResult3.version());
  }

  /**
   * Method under test: {@link Tag#asMarkdown()}
   */
  @Test
  public void testAsMarkdown3() throws IOException, InvalidInputException {
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

    // Act
    Node actualAsMarkdownResult = tag.asMarkdown();

    // Assert
    JsonNode data = ((TagNode) actualAsMarkdownResult).getData();
    assertTrue(data instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = data.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = nextResult2.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonParser traverseResult3 = data.traverse();
    assertTrue(traverseResult3 instanceof TreeTraversingParser);
    assertTrue(actualAsMarkdownResult instanceof TagNode);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    JsonStreamContext parsingContext3 = traverseResult3.getParsingContext();
    assertEquals("ROOT", parsingContext3.getTypeDesc());
    assertEquals("\"$\"", nextResult2.toPrettyString());
    assertEquals("\"42\"", nextResult.toPrettyString());
    Version versionResult = traverseResult3.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\n" + "  \"uniqueId\" : \"42\",\n" + "  \"rootBbgCompTicker\" : \"$\",\n"
        + "  \"fullBbgCompTicker\" : \"$\",\n" + "  \"bbgCompTicker\" : \"$\",\n" + "  \"figi\" : \"$\",\n"
        + "  \"figiTicker\" : \"$\",\n" + "  \"localCode\" : \"$\",\n" + "  \"instrumentTypeCode\" : \"$\",\n"
        + "  \"instrumentTypeName\" : \"$\",\n" + "  \"displayName\" : \"$\",\n" + "  \"currency\" : \"GBP\",\n"
        + "  \"kind\" : \"EQUITY\",\n" + "  \"providerId\" : \"EDI\",\n" + "  \"isin\" : \"$\",\n"
        + "  \"ric\" : \"$\",\n" + "  \"wkn\" : \"$\",\n" + "  \"ediInstrumentId\" : \"42\",\n"
        + "  \"bbgMarketSector\" : \"EQUITY\",\n" + "  \"countryCode\" : \"GB\",\n" + "  \"mainInstrument\" : true,\n"
        + "  \"bbgCompId\" : \"42\",\n" + "  \"usCode\" : \"$\",\n" + "  \"sedol\" : \"$\",\n" + "  \"cfi\" : \"$\",\n"
        + "  \"lei\" : \"$\",\n" + "  \"countryName\" : \"GB\",\n" + "  \"exchangeName\" : \"$\",\n"
        + "  \"ediExchangeCode\" : \"$\",\n" + "  \"primaryExchange\" : true,\n" + "  \"operationalMic\" : \"$\"\n"
        + "}", data.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult3.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult3.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult3.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult3.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult3.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    assertNull(traverseResult3.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult3.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult3.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult3.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult3.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult3.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(traverseResult3.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(parsingContext3.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult3.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult3.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(traverseResult3.getValueAsString());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult3.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult3.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult3.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult3.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, traverseResult3.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext3.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext3.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, parsingContext3.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0, nextResult2.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult3.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, traverseResult3.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(30, data.size());
    assertEquals(JsonNodeType.OBJECT, data.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult2.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult3.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult3.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult3.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult3.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult3.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult3.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult3.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(traverseResult3.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext3.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext3.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(parsingContext3.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult2.isArray());
    assertFalse(data.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult2.isBigDecimal());
    assertFalse(data.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult2.isBigInteger());
    assertFalse(data.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult2.isBinary());
    assertFalse(data.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult2.isBoolean());
    assertFalse(data.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult2.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult2.isDouble());
    assertFalse(data.isDouble());
    assertFalse(data.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult2.isFloat());
    assertFalse(data.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult2.isFloatingPointNumber());
    assertFalse(data.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult2.isInt());
    assertFalse(data.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult2.isIntegralNumber());
    assertFalse(data.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult2.isLong());
    assertFalse(data.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult2.isMissingNode());
    assertFalse(data.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult2.isNull());
    assertFalse(data.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult2.isNumber());
    assertFalse(data.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult2.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult2.isPojo());
    assertFalse(data.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult2.isShort());
    assertFalse(data.isShort());
    assertFalse(data.isTextual());
    assertFalse(data.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(data.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult2.isEmpty());
    assertTrue(data.isObject());
    assertTrue(nextResult.isTextual());
    assertTrue(nextResult2.isTextual());
    assertTrue(nextResult.isValueNode());
    assertTrue(nextResult2.isValueNode());
    assertTrue(iteratorResult.hasNext());
    assertEquals(Tag.PREFIX, ((TagNode) actualAsMarkdownResult).getPrefix());
    assertEquals(Tag.PREFIX, ((TagNode) actualAsMarkdownResult).getText());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult2.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(currentLocation, traverseResult3.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(versionResult, traverseResult2.version());
  }

  /**
   * Method under test: {@link Tag#asMarkdown()}
   */
  @Test
  public void testAsMarkdown4() throws IOException, InvalidInputException {
    // Arrange
    Instrument instrument = new Instrument();
    instrument.setBbgCompId(null);
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

    // Act
    Node actualAsMarkdownResult = tag.asMarkdown();

    // Assert
    JsonNode data = ((TagNode) actualAsMarkdownResult).getData();
    assertTrue(data instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = data.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = nextResult2.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonParser traverseResult3 = data.traverse();
    assertTrue(traverseResult3 instanceof TreeTraversingParser);
    assertTrue(actualAsMarkdownResult instanceof TagNode);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    JsonStreamContext parsingContext3 = traverseResult3.getParsingContext();
    assertEquals("ROOT", parsingContext3.getTypeDesc());
    assertEquals("\"$\"", nextResult2.toPrettyString());
    assertEquals("\"42\"", nextResult.toPrettyString());
    Version versionResult = traverseResult3.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\n" + "  \"uniqueId\" : \"42\",\n" + "  \"rootBbgCompTicker\" : \"$\",\n"
        + "  \"fullBbgCompTicker\" : \"$\",\n" + "  \"bbgCompTicker\" : \"$\",\n" + "  \"figi\" : \"$\",\n"
        + "  \"figiTicker\" : \"$\",\n" + "  \"localCode\" : \"$\",\n" + "  \"instrumentTypeCode\" : \"$\",\n"
        + "  \"instrumentTypeName\" : \"$\",\n" + "  \"displayName\" : \"$\",\n" + "  \"currency\" : \"GBP\",\n"
        + "  \"kind\" : \"EQUITY\",\n" + "  \"providerId\" : \"EDI\",\n" + "  \"isin\" : \"$\",\n"
        + "  \"ric\" : \"$\",\n" + "  \"wkn\" : \"$\",\n" + "  \"ediInstrumentId\" : \"42\",\n"
        + "  \"bbgMarketSector\" : \"EQUITY\",\n" + "  \"countryCode\" : \"GB\",\n" + "  \"mainInstrument\" : true,\n"
        + "  \"bbgCompId\" : null,\n" + "  \"usCode\" : \"$\",\n" + "  \"sedol\" : \"$\",\n" + "  \"cfi\" : \"$\",\n"
        + "  \"lei\" : \"$\",\n" + "  \"countryName\" : \"GB\",\n" + "  \"exchangeName\" : \"$\",\n"
        + "  \"ediExchangeCode\" : \"$\",\n" + "  \"primaryExchange\" : true,\n" + "  \"operationalMic\" : \"$\"\n"
        + "}", data.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult3.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult3.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult3.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult3.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult3.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    assertNull(traverseResult3.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult3.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult3.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult3.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult3.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult3.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(traverseResult3.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(parsingContext3.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult3.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult3.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(traverseResult3.getValueAsString());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult3.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult3.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult3.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult3.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, traverseResult3.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext3.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext3.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, parsingContext3.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0, nextResult2.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult3.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, traverseResult3.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(30, data.size());
    assertEquals(JsonNodeType.OBJECT, data.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult2.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult3.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult3.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult3.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult3.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult3.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult3.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult3.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(traverseResult3.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext3.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext3.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(parsingContext3.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult2.isArray());
    assertFalse(data.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult2.isBigDecimal());
    assertFalse(data.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult2.isBigInteger());
    assertFalse(data.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult2.isBinary());
    assertFalse(data.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult2.isBoolean());
    assertFalse(data.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult2.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult2.isDouble());
    assertFalse(data.isDouble());
    assertFalse(data.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult2.isFloat());
    assertFalse(data.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult2.isFloatingPointNumber());
    assertFalse(data.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult2.isInt());
    assertFalse(data.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult2.isIntegralNumber());
    assertFalse(data.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult2.isLong());
    assertFalse(data.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult2.isMissingNode());
    assertFalse(data.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult2.isNull());
    assertFalse(data.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult2.isNumber());
    assertFalse(data.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult2.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult2.isPojo());
    assertFalse(data.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult2.isShort());
    assertFalse(data.isShort());
    assertFalse(data.isTextual());
    assertFalse(data.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(data.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult2.isEmpty());
    assertTrue(data.isObject());
    assertTrue(nextResult.isTextual());
    assertTrue(nextResult2.isTextual());
    assertTrue(nextResult.isValueNode());
    assertTrue(nextResult2.isValueNode());
    assertTrue(iteratorResult.hasNext());
    assertEquals(Tag.PREFIX, ((TagNode) actualAsMarkdownResult).getPrefix());
    assertEquals(Tag.PREFIX, ((TagNode) actualAsMarkdownResult).getText());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult2.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(currentLocation, traverseResult3.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(versionResult, traverseResult2.version());
  }

  /**
   * Method under test: {@link Tag#asMarkdown()}
   */
  @Test
  public void testAsMarkdown5() throws IOException, InvalidInputException {
    // Arrange
    Instrument instrument = new Instrument();
    instrument.setBbgCompId("");
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

    // Act
    Node actualAsMarkdownResult = tag.asMarkdown();

    // Assert
    JsonNode data = ((TagNode) actualAsMarkdownResult).getData();
    assertTrue(data instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = data.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = nextResult2.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonParser traverseResult3 = data.traverse();
    assertTrue(traverseResult3 instanceof TreeTraversingParser);
    assertTrue(actualAsMarkdownResult instanceof TagNode);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    JsonStreamContext parsingContext3 = traverseResult3.getParsingContext();
    assertEquals("ROOT", parsingContext3.getTypeDesc());
    assertEquals("\"$\"", nextResult2.toPrettyString());
    assertEquals("\"42\"", nextResult.toPrettyString());
    Version versionResult = traverseResult3.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\n" + "  \"uniqueId\" : \"42\",\n" + "  \"rootBbgCompTicker\" : \"$\",\n"
        + "  \"fullBbgCompTicker\" : \"$\",\n" + "  \"bbgCompTicker\" : \"$\",\n" + "  \"figi\" : \"$\",\n"
        + "  \"figiTicker\" : \"$\",\n" + "  \"localCode\" : \"$\",\n" + "  \"instrumentTypeCode\" : \"$\",\n"
        + "  \"instrumentTypeName\" : \"$\",\n" + "  \"displayName\" : \"$\",\n" + "  \"currency\" : \"GBP\",\n"
        + "  \"kind\" : \"EQUITY\",\n" + "  \"providerId\" : \"EDI\",\n" + "  \"isin\" : \"$\",\n"
        + "  \"ric\" : \"$\",\n" + "  \"wkn\" : \"$\",\n" + "  \"ediInstrumentId\" : \"42\",\n"
        + "  \"bbgMarketSector\" : \"EQUITY\",\n" + "  \"countryCode\" : \"GB\",\n" + "  \"mainInstrument\" : true,\n"
        + "  \"bbgCompId\" : \"\",\n" + "  \"usCode\" : \"$\",\n" + "  \"sedol\" : \"$\",\n" + "  \"cfi\" : \"$\",\n"
        + "  \"lei\" : \"$\",\n" + "  \"countryName\" : \"GB\",\n" + "  \"exchangeName\" : \"$\",\n"
        + "  \"ediExchangeCode\" : \"$\",\n" + "  \"primaryExchange\" : true,\n" + "  \"operationalMic\" : \"$\"\n"
        + "}", data.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult3.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult3.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult3.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult3.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult3.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    assertNull(traverseResult3.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult3.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult3.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult3.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult3.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult3.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(traverseResult3.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(parsingContext3.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult3.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult3.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(traverseResult3.getValueAsString());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult3.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult3.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult3.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult3.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, traverseResult3.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext3.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext3.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, parsingContext3.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0, nextResult2.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult3.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, traverseResult3.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(30, data.size());
    assertEquals(JsonNodeType.OBJECT, data.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult2.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult3.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult3.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult3.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult3.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult3.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult3.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult3.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(traverseResult3.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext3.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext3.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(parsingContext3.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult2.isArray());
    assertFalse(data.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult2.isBigDecimal());
    assertFalse(data.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult2.isBigInteger());
    assertFalse(data.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult2.isBinary());
    assertFalse(data.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult2.isBoolean());
    assertFalse(data.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult2.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult2.isDouble());
    assertFalse(data.isDouble());
    assertFalse(data.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult2.isFloat());
    assertFalse(data.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult2.isFloatingPointNumber());
    assertFalse(data.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult2.isInt());
    assertFalse(data.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult2.isIntegralNumber());
    assertFalse(data.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult2.isLong());
    assertFalse(data.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult2.isMissingNode());
    assertFalse(data.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult2.isNull());
    assertFalse(data.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult2.isNumber());
    assertFalse(data.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult2.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult2.isPojo());
    assertFalse(data.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult2.isShort());
    assertFalse(data.isShort());
    assertFalse(data.isTextual());
    assertFalse(data.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(data.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult2.isEmpty());
    assertTrue(data.isObject());
    assertTrue(nextResult.isTextual());
    assertTrue(nextResult2.isTextual());
    assertTrue(nextResult.isValueNode());
    assertTrue(nextResult2.isValueNode());
    assertTrue(iteratorResult.hasNext());
    assertEquals(Tag.PREFIX, ((TagNode) actualAsMarkdownResult).getPrefix());
    assertEquals(Tag.PREFIX, ((TagNode) actualAsMarkdownResult).getText());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult2.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(currentLocation, traverseResult3.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(versionResult, traverseResult2.version());
  }

  /**
   * Method under test: {@link Tag#asMarkdown()}
   */
  @Test
  public void testAsMarkdown6() throws IOException, InvalidInputException {
    // Arrange
    Instrument instrument = new Instrument();
    instrument.setBbgCompId("42");
    instrument.setBbgCompTicker(Tag.PREFIX);
    instrument.setBbgMarketSector(MarketSector.EQUITY);
    instrument.setCfi(null);
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

    // Act
    Node actualAsMarkdownResult = tag.asMarkdown();

    // Assert
    JsonNode data = ((TagNode) actualAsMarkdownResult).getData();
    assertTrue(data instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = data.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = nextResult2.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonParser traverseResult3 = data.traverse();
    assertTrue(traverseResult3 instanceof TreeTraversingParser);
    assertTrue(actualAsMarkdownResult instanceof TagNode);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    JsonStreamContext parsingContext3 = traverseResult3.getParsingContext();
    assertEquals("ROOT", parsingContext3.getTypeDesc());
    assertEquals("\"$\"", nextResult2.toPrettyString());
    assertEquals("\"42\"", nextResult.toPrettyString());
    Version versionResult = traverseResult3.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\n" + "  \"uniqueId\" : \"42\",\n" + "  \"rootBbgCompTicker\" : \"$\",\n"
        + "  \"fullBbgCompTicker\" : \"$\",\n" + "  \"bbgCompTicker\" : \"$\",\n" + "  \"figi\" : \"$\",\n"
        + "  \"figiTicker\" : \"$\",\n" + "  \"localCode\" : \"$\",\n" + "  \"instrumentTypeCode\" : \"$\",\n"
        + "  \"instrumentTypeName\" : \"$\",\n" + "  \"displayName\" : \"$\",\n" + "  \"currency\" : \"GBP\",\n"
        + "  \"kind\" : \"EQUITY\",\n" + "  \"providerId\" : \"EDI\",\n" + "  \"isin\" : \"$\",\n"
        + "  \"ric\" : \"$\",\n" + "  \"wkn\" : \"$\",\n" + "  \"ediInstrumentId\" : \"42\",\n"
        + "  \"bbgMarketSector\" : \"EQUITY\",\n" + "  \"countryCode\" : \"GB\",\n" + "  \"mainInstrument\" : true,\n"
        + "  \"bbgCompId\" : \"42\",\n" + "  \"usCode\" : \"$\",\n" + "  \"sedol\" : \"$\",\n" + "  \"cfi\" : null,\n"
        + "  \"lei\" : \"$\",\n" + "  \"countryName\" : \"GB\",\n" + "  \"exchangeName\" : \"$\",\n"
        + "  \"ediExchangeCode\" : \"$\",\n" + "  \"primaryExchange\" : true,\n" + "  \"operationalMic\" : \"$\"\n"
        + "}", data.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult3.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult3.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult3.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult3.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult3.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    assertNull(traverseResult3.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult3.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult3.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult3.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult3.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult3.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(traverseResult3.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(parsingContext3.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult3.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult3.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(traverseResult3.getValueAsString());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult3.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult3.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult3.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult3.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, traverseResult3.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext3.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext3.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, parsingContext3.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0, nextResult2.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult3.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, traverseResult3.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(30, data.size());
    assertEquals(JsonNodeType.OBJECT, data.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult2.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult3.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult3.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult3.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult3.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult3.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult3.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult3.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(traverseResult3.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext3.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext3.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(parsingContext3.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult2.isArray());
    assertFalse(data.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult2.isBigDecimal());
    assertFalse(data.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult2.isBigInteger());
    assertFalse(data.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult2.isBinary());
    assertFalse(data.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult2.isBoolean());
    assertFalse(data.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult2.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult2.isDouble());
    assertFalse(data.isDouble());
    assertFalse(data.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult2.isFloat());
    assertFalse(data.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult2.isFloatingPointNumber());
    assertFalse(data.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult2.isInt());
    assertFalse(data.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult2.isIntegralNumber());
    assertFalse(data.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult2.isLong());
    assertFalse(data.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult2.isMissingNode());
    assertFalse(data.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult2.isNull());
    assertFalse(data.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult2.isNumber());
    assertFalse(data.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult2.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult2.isPojo());
    assertFalse(data.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult2.isShort());
    assertFalse(data.isShort());
    assertFalse(data.isTextual());
    assertFalse(data.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(data.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult2.isEmpty());
    assertTrue(data.isObject());
    assertTrue(nextResult.isTextual());
    assertTrue(nextResult2.isTextual());
    assertTrue(nextResult.isValueNode());
    assertTrue(nextResult2.isValueNode());
    assertTrue(iteratorResult.hasNext());
    assertEquals(Tag.PREFIX, ((TagNode) actualAsMarkdownResult).getPrefix());
    assertEquals(Tag.PREFIX, ((TagNode) actualAsMarkdownResult).getText());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult2.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(currentLocation, traverseResult3.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(versionResult, traverseResult2.version());
  }

  /**
   * Method under test: {@link Tag#asMarkdown()}
   */
  @Test
  public void testAsMarkdown7() throws IOException, InvalidInputException {
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
    instrument.setMainInstrument(false);
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

    // Act
    Node actualAsMarkdownResult = tag.asMarkdown();

    // Assert
    JsonNode data = ((TagNode) actualAsMarkdownResult).getData();
    assertTrue(data instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = data.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = nextResult2.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonParser traverseResult3 = data.traverse();
    assertTrue(traverseResult3 instanceof TreeTraversingParser);
    assertTrue(actualAsMarkdownResult instanceof TagNode);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    JsonStreamContext parsingContext3 = traverseResult3.getParsingContext();
    assertEquals("ROOT", parsingContext3.getTypeDesc());
    assertEquals("\"$\"", nextResult2.toPrettyString());
    assertEquals("\"42\"", nextResult.toPrettyString());
    Version versionResult = traverseResult3.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.15.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\n" + "  \"uniqueId\" : \"42\",\n" + "  \"rootBbgCompTicker\" : \"$\",\n"
        + "  \"fullBbgCompTicker\" : \"$\",\n" + "  \"bbgCompTicker\" : \"$\",\n" + "  \"figi\" : \"$\",\n"
        + "  \"figiTicker\" : \"$\",\n" + "  \"localCode\" : \"$\",\n" + "  \"instrumentTypeCode\" : \"$\",\n"
        + "  \"instrumentTypeName\" : \"$\",\n" + "  \"displayName\" : \"$\",\n" + "  \"currency\" : \"GBP\",\n"
        + "  \"kind\" : \"EQUITY\",\n" + "  \"providerId\" : \"EDI\",\n" + "  \"isin\" : \"$\",\n"
        + "  \"ric\" : \"$\",\n" + "  \"wkn\" : \"$\",\n" + "  \"ediInstrumentId\" : \"42\",\n"
        + "  \"bbgMarketSector\" : \"EQUITY\",\n" + "  \"countryCode\" : \"GB\",\n" + "  \"mainInstrument\" : false,\n"
        + "  \"bbgCompId\" : \"42\",\n" + "  \"usCode\" : \"$\",\n" + "  \"sedol\" : \"$\",\n" + "  \"cfi\" : \"$\",\n"
        + "  \"lei\" : \"$\",\n" + "  \"countryName\" : \"GB\",\n" + "  \"exchangeName\" : \"$\",\n"
        + "  \"ediExchangeCode\" : \"$\",\n" + "  \"primaryExchange\" : true,\n" + "  \"operationalMic\" : \"$\"\n"
        + "}", data.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult3.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult3.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult3.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult3.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult3.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    assertNull(traverseResult3.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult3.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult3.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult3.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult3.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult3.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(traverseResult3.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(parsingContext3.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult3.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult3.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(traverseResult3.getValueAsString());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult3.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult3.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult3.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult3.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, traverseResult3.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext3.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext3.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, parsingContext3.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0, nextResult2.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult3.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, traverseResult3.getValueAsLong());
    assertEquals(15, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(30, data.size());
    assertEquals(JsonNodeType.OBJECT, data.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult2.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult3.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult3.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult3.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult3.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult3.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult3.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult3.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(traverseResult3.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext3.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext3.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(parsingContext3.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult2.isArray());
    assertFalse(data.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult2.isBigDecimal());
    assertFalse(data.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult2.isBigInteger());
    assertFalse(data.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult2.isBinary());
    assertFalse(data.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult2.isBoolean());
    assertFalse(data.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult2.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult2.isDouble());
    assertFalse(data.isDouble());
    assertFalse(data.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult2.isFloat());
    assertFalse(data.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult2.isFloatingPointNumber());
    assertFalse(data.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult2.isInt());
    assertFalse(data.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult2.isIntegralNumber());
    assertFalse(data.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult2.isLong());
    assertFalse(data.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult2.isMissingNode());
    assertFalse(data.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult2.isNull());
    assertFalse(data.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult2.isNumber());
    assertFalse(data.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult2.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult2.isPojo());
    assertFalse(data.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult2.isShort());
    assertFalse(data.isShort());
    assertFalse(data.isTextual());
    assertFalse(data.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(data.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult2.isEmpty());
    assertTrue(data.isObject());
    assertTrue(nextResult.isTextual());
    assertTrue(nextResult2.isTextual());
    assertTrue(nextResult.isValueNode());
    assertTrue(nextResult2.isValueNode());
    assertTrue(iteratorResult.hasNext());
    assertEquals(Tag.PREFIX, ((TagNode) actualAsMarkdownResult).getPrefix());
    assertEquals(Tag.PREFIX, ((TagNode) actualAsMarkdownResult).getText());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult2.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(currentLocation, traverseResult3.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(versionResult, traverseResult2.version());
  }

  /**
   * Method under test: {@link Tag#getEntityValue()}
   */
  @Test
  public void testGetEntityValue() {
    // Arrange, Act and Assert
    assertNull((new Tag(new Bold(new BulletList(mock(Element.class))), 1)).getEntityValue());
  }

  /**
   * Method under test: {@link Tag#getEntityValue()}
   */
  @Test
  public void testGetEntityValue2() {
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
   * Method under test: {@link Tag#getEntityVersion()}
   */
  @Test
  public void testGetEntityVersion() {
    // Arrange, Act and Assert
    assertEquals("1.0", (new Tag(new Bold(new BulletList(mock(Element.class))), 1)).getEntityVersion());
  }

  /**
   * Method under test: {@link Tag#getEntityVersion()}
   */
  @Test
  public void testGetEntityVersion2() {
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
   * Method under test: {@link Tag#asText()}
   */
  @Test
  public void testAsText() {
    // Arrange, Act and Assert
    assertEquals("$null", (new Tag(new Bold(new BulletList(mock(Element.class))), 1)).asText());
  }

  /**
   * Method under test: {@link Tag#asText()}
   */
  @Test
  public void testAsText2() {
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
   * Method under test: {@link Tag#validateFallBackTicker()}
   */
  @Test
  public void testValidateFallBackTicker() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new Tag(new Bold(new BulletList(mock(Element.class))), 1)).validateFallBackTicker());
  }

  /**
   * Method under test: {@link Tag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Tag tag = new Tag(parent, 1);
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
    BiItem getResult2 = items.get(1);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertEquals(Tag.ENTITY_TYPE, attributes2.get("entity_type"));
    assertSame(parent, tag.getParent());
  }

  /**
   * Method under test: {@link Tag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Tag tag = new Tag(parent, 1);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    tag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(1);
    assertEquals("hashtags", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    BiItem getResult2 = items.get(2);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertEquals(Tag.ENTITY_TYPE, attributes2.get("entity_type"));
    assertSame(item, items.get(0));
    assertSame(parent, tag.getParent());
  }

  /**
   * Method under test: {@link Tag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Tag tag = new Tag(parent, 1);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    tag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(2);
    assertEquals("hashtags", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    BiItem getResult2 = items.get(3);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertEquals(Tag.ENTITY_TYPE, attributes2.get("entity_type"));
    assertSame(item, items.get(0));
    assertSame(item2, items.get(1));
    assertSame(parent, tag.getParent());
  }

  /**
   * Method under test: {@link Tag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext4() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Tag tag = new Tag(parent, 1);

    BiContext context = new BiContext();
    BiItem item = new BiItem("hashtags", Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    tag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
    assertEquals(Tag.ENTITY_TYPE, attributes.get("entity_type"));
    assertSame(item, items.get(0));
    assertSame(parent, tag.getParent());
  }

  /**
   * Method under test: {@link Tag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext5() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Tag tag = new Tag(parent, 1);

    BiContext context = new BiContext();
    context.addItemWithValue("hashtags", "Item Value");
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    tag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(0);
    assertEquals("hashtags", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    BiItem getResult2 = items.get(3);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertEquals(Tag.ENTITY_TYPE, attributes2.get("entity_type"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, tag.getParent());
  }

  /**
   * Method under test: {@link Tag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext6() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Tag tag = new Tag(parent, 1);

    BiContext context = new BiContext();
    context.addItemWithValue("hashtags", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    tag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(0);
    assertEquals("hashtags", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    BiItem getResult2 = items.get(3);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertEquals(Tag.ENTITY_TYPE, attributes2.get("entity_type"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, tag.getParent());
  }

  /**
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
    tag.getTagAttributes();

    // Assert that nothing has changed
    assertEquals("org.symphonyoss.fin.security.id.ticker", actualEntitySubType);
    assertEquals(Tag.ENTITY_TYPE, actualEntityType);
    assertEquals(Tag.MESSAGEML_TAG, actualEntityIdPrefix);
  }

  /**
   * Method under test: {@link Tag#Tag(Element, int)}
   */
  @Test
  public void testNewTag() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Tag actualTag = new Tag(parent, 1);

    // Assert
    assertEquals("1.0", actualTag.getEntityVersion());
    assertEquals("org.symphonyoss.fin.security.id.ticker", actualTag.getEntitySubType());
    assertEquals("tag1", actualTag.entityId);
    assertNull(actualTag.getEntityValue());
    TagAttributes tagAttributes = actualTag.getTagAttributes();
    assertNull(tagAttributes.getBbgcompticker());
    assertNull(tagAttributes.getBbgmarketsector());
    assertNull(tagAttributes.getCountrycode());
    assertNull(tagAttributes.getFallbackTicker());
    assertNull(tagAttributes.getFigi());
    assertNull(tagAttributes.getFigiTicker());
    assertNull(tagAttributes.getFullBbgCompTicker());
    assertNull(tagAttributes.getInstrumentclass());
    assertNull(tagAttributes.getIsin());
    assertNull(tagAttributes.getLocalcode());
    assertNull(tagAttributes.getOperationalMic());
    assertNull(tagAttributes.getReturnMainListing());
    assertNull(tagAttributes.getUniqueId());
    assertNull(tagAttributes.getUscode());
    assertEquals(0, actualTag.size());
    assertEquals(FormatEnum.MESSAGEML, actualTag.getFormat());
    assertTrue(actualTag.getChildren().isEmpty());
    assertTrue(actualTag.getAttributes().isEmpty());
    assertEquals(Span.MESSAGEML_TAG, actualTag.getPresentationMLTag());
    assertEquals(Tag.ENTITY_TYPE, actualTag.getEntityType());
    assertEquals(Tag.MESSAGEML_TAG, actualTag.getMessageMLTag());
    assertEquals(Tag.MESSAGEML_TAG, actualTag.getEntityIdPrefix());
    assertSame(parent, actualTag.getParent());
  }
}
