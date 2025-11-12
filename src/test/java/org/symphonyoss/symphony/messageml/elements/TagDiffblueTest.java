package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.MessageMLParser;
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
   *
   * <p>Method under test: {@link Tag#Tag(Element, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.<init>(Element, int)"})
  public void testNewTag() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Tag actualTag = new Tag(parent2, 1);

    // Assert
    Element parent3 = actualTag.getParent();
    assertTrue(parent3 instanceof Bold);
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
    assertSame(parent2, parent3);
  }

  /**
   * Test {@link Tag#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Tag tag = new Tag(parent2, 1);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> tag.buildAttribute(parser, new IIOMetadataNode("Node Name")));
  }

  /**
   * Test {@link Tag#validate()}.
   *
   * <p>Method under test: {@link Tag#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.validate()"})
  public void testValidate() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    new Tag(parent, 1).validate();
  }

  /**
   * Test {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Tag tag = new Tag(parent2, 1);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    tag.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(58L, out.getOffset());
  }

  /**
   * Test {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() {
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
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Tag tag = new Tag(parent2, 1);
    tag.setInstrument(instrument);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    tag.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(74L, out.getOffset());
  }

  /**
   * Test {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Tag tag = new Tag(parent2, 1);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setPrintOffsets(true);

    // Act
    tag.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(58L, out.getOffset());
  }

  /**
   * Test {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML4() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Tag tag = new Tag(parent2, 1);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoIndent(true);

    // Act
    tag.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(57L, out.getOffset());
  }

  /**
   * Test {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML5() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Tag tag = new Tag(parent2, 1);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    tag.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(56L, out.getOffset());
  }

  /**
   * Test {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML6() {
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
    instrument.setRootBbgCompTicker("=\"");
    instrument.setSedol("Sedol");
    instrument.setUniqueId("42");
    instrument.setUsCode("Us Code");
    instrument.setWkn("Wkn");
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Tag tag = new Tag(parent2, 1);
    tag.setInstrument(instrument);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    tag.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(61L, out.getOffset());
  }

  /**
   * Test {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <ul>
   *   <li>Given {@link Instrument} (default constructor) RootBbgCompTicker is {@code >}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML_givenInstrumentRootBbgCompTickerIsGreaterThanSign() {
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
    instrument.setRootBbgCompTicker(">");
    instrument.setSedol("Sedol");
    instrument.setUniqueId("42");
    instrument.setUsCode("Us Code");
    instrument.setWkn("Wkn");
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Tag tag = new Tag(parent2, 1);
    tag.setInstrument(instrument);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    tag.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(58L, out.getOffset());
  }

  /**
   * Test {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <ul>
   *   <li>Given {@link Instrument} (default constructor) RootBbgCompTicker is {@code <}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML_givenInstrumentRootBbgCompTickerIsLessThanSign() {
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
    instrument.setRootBbgCompTicker("<");
    instrument.setSedol("Sedol");
    instrument.setUniqueId("42");
    instrument.setUsCode("Us Code");
    instrument.setWkn("Wkn");
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Tag tag = new Tag(parent2, 1);
    tag.setInstrument(instrument);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    tag.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(58L, out.getOffset());
  }

  /**
   * Test {@link Tag#asMarkdown()}.
   *
   * <ul>
   *   <li>Given {@link Instrument} (default constructor) BbgCompId is {@code 42}.
   *   <li>Then return Text is {@link Tag#PREFIX}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Tag.asMarkdown()"})
  public void testAsMarkdown_givenInstrumentBbgCompIdIs42_thenReturnTextIsPrefix()
      throws InvalidInputException {
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
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Tag tag = new Tag(parent2, 1);
    tag.setInstrument(instrument);

    // Act
    Node actualAsMarkdownResult = tag.asMarkdown();

    // Assert
    assertTrue(((TagNode) actualAsMarkdownResult).getData() instanceof ObjectNode);
    assertTrue(actualAsMarkdownResult instanceof TagNode);
    assertEquals(Tag.PREFIX, ((TagNode) actualAsMarkdownResult).getText());
  }

  /**
   * Test {@link Tag#asMarkdown()}.
   *
   * <ul>
   *   <li>Given {@link Instrument} (default constructor) BbgCompId is empty string.
   *   <li>Then return Text is {@link Tag#PREFIX}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Tag.asMarkdown()"})
  public void testAsMarkdown_givenInstrumentBbgCompIdIsEmptyString_thenReturnTextIsPrefix()
      throws InvalidInputException {
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
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Tag tag = new Tag(parent2, 1);
    tag.setInstrument(instrument);

    // Act
    Node actualAsMarkdownResult = tag.asMarkdown();

    // Assert
    assertTrue(((TagNode) actualAsMarkdownResult).getData() instanceof ObjectNode);
    assertTrue(actualAsMarkdownResult instanceof TagNode);
    assertEquals(Tag.PREFIX, ((TagNode) actualAsMarkdownResult).getText());
  }

  /**
   * Test {@link Tag#asMarkdown()}.
   *
   * <ul>
   *   <li>Given {@link Instrument} (default constructor) BbgCompId is {@code null}.
   *   <li>Then return Text is {@link Tag#PREFIX}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Tag.asMarkdown()"})
  public void testAsMarkdown_givenInstrumentBbgCompIdIsNull_thenReturnTextIsPrefix()
      throws InvalidInputException {
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
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Tag tag = new Tag(parent2, 1);
    tag.setInstrument(instrument);

    // Act
    Node actualAsMarkdownResult = tag.asMarkdown();

    // Assert
    assertTrue(((TagNode) actualAsMarkdownResult).getData() instanceof ObjectNode);
    assertTrue(actualAsMarkdownResult instanceof TagNode);
    assertEquals(Tag.PREFIX, ((TagNode) actualAsMarkdownResult).getText());
  }

  /**
   * Test {@link Tag#asMarkdown()}.
   *
   * <ul>
   *   <li>Given {@link Instrument} (default constructor) Cfi is {@code null}.
   *   <li>Then return Text is {@link Tag#PREFIX}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Tag.asMarkdown()"})
  public void testAsMarkdown_givenInstrumentCfiIsNull_thenReturnTextIsPrefix()
      throws InvalidInputException {
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
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Tag tag = new Tag(parent2, 1);
    tag.setInstrument(instrument);

    // Act
    Node actualAsMarkdownResult = tag.asMarkdown();

    // Assert
    assertTrue(((TagNode) actualAsMarkdownResult).getData() instanceof ObjectNode);
    assertTrue(actualAsMarkdownResult instanceof TagNode);
    assertEquals(Tag.PREFIX, ((TagNode) actualAsMarkdownResult).getText());
  }

  /**
   * Test {@link Tag#asMarkdown()}.
   *
   * <ul>
   *   <li>Given {@link Instrument} (default constructor) MainInstrument is {@code false}.
   *   <li>Then return Text is {@link Tag#PREFIX}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Tag.asMarkdown()"})
  public void testAsMarkdown_givenInstrumentMainInstrumentIsFalse_thenReturnTextIsPrefix()
      throws InvalidInputException {
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
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Tag tag = new Tag(parent2, 1);
    tag.setInstrument(instrument);

    // Act
    Node actualAsMarkdownResult = tag.asMarkdown();

    // Assert
    assertTrue(((TagNode) actualAsMarkdownResult).getData() instanceof ObjectNode);
    assertTrue(actualAsMarkdownResult instanceof TagNode);
    assertEquals(Tag.PREFIX, ((TagNode) actualAsMarkdownResult).getText());
  }

  /**
   * Test {@link Tag#asMarkdown()}.
   *
   * <ul>
   *   <li>Given {@link Tag#Tag(Element, int)} with parent is {@link Bold#Bold(Element)} and
   *       entityIndex is one.
   *   <li>Then return Data is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Tag.asMarkdown()"})
  public void testAsMarkdown_givenTagWithParentIsBoldAndEntityIndexIsOne_thenReturnDataIsNull()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new Tag(parent2, 1).asMarkdown();

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
   *
   * <ul>
   *   <li>Then Data iterator next return {@link TextNode}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Tag.asMarkdown()"})
  public void testAsMarkdown_thenDataIteratorNextReturnTextNode() throws InvalidInputException {
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
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Tag tag = new Tag(parent2, 1);
    tag.setInstrument(instrument);

    // Act
    Node actualAsMarkdownResult = tag.asMarkdown();

    // Assert
    JsonNode data = ((TagNode) actualAsMarkdownResult).getData();
    assertTrue(data instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = data.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(actualAsMarkdownResult instanceof TagNode);
    assertEquals("Root Bbg Comp Ticker", ((TagNode) actualAsMarkdownResult).getText());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test {@link Tag#asEntityJson(ObjectNode)}.
   *
   * <ul>
   *   <li>Then return {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is
   *       withExactBigDecimals {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#asEntityJson(ObjectNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode Tag.asEntityJson(ObjectNode)"})
  public void testAsEntityJson_thenReturnObjectNodeWithNcIsWithExactBigDecimalsTrue() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    Tag tag = new Tag(parent, 1);

    ObjectNode parent2 = mock(ObjectNode.class);
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode objectNode = new ObjectNode(nc);
    when(parent2.path(Mockito.<String>any())).thenReturn(objectNode);

    // Act
    ObjectNode actualAsEntityJsonResult = tag.asEntityJson(parent2);

    // Assert
    verify(parent2).path("tag1");
    assertSame(objectNode, actualAsEntityJsonResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Tag#setInstrument(Instrument)}
   *   <li>{@link Tag#getEntityIdPrefix()}
   *   <li>{@link Tag#getEntitySubType()}
   *   <li>{@link Tag#getEntityType()}
   *   <li>{@link Tag#getTagAttributes()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String Tag.getEntityIdPrefix()",
    "String Tag.getEntitySubType()",
    "String Tag.getEntityType()",
    "TagAttributes Tag.getTagAttributes()",
    "void Tag.setInstrument(Instrument)"
  })
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    Tag tag = new Tag(parent, 1);

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
   *
   * <ul>
   *   <li>Given {@link Instrument} (default constructor) BbgCompId is {@code 42}.
   *   <li>Then return {@code Root Bbg Comp Ticker}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#getEntityValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tag.getEntityValue()"})
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
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Tag tag = new Tag(parent2, 1);
    tag.setInstrument(instrument);

    // Act and Assert
    assertEquals("Root Bbg Comp Ticker", tag.getEntityValue());
  }

  /**
   * Test {@link Tag#getEntityValue()}.
   *
   * <ul>
   *   <li>Given {@link Tag#Tag(Element, int)} with parent is {@link Bold#Bold(Element)} and
   *       entityIndex is one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#getEntityValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tag.getEntityValue()"})
  public void testGetEntityValue_givenTagWithParentIsBoldAndEntityIndexIsOne_thenReturnNull() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertNull(new Tag(parent2, 1).getEntityValue());
  }

  /**
   * Test {@link Tag#getEntityVersion()}.
   *
   * <ul>
   *   <li>Given {@link Instrument} (default constructor) BbgCompId is {@code 42}.
   *   <li>Then return {@link MessageML#MESSAGEML_VERSION}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#getEntityVersion()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tag.getEntityVersion()"})
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
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Tag tag = new Tag(parent2, 1);
    tag.setInstrument(instrument);

    // Act and Assert
    assertEquals(MessageML.MESSAGEML_VERSION, tag.getEntityVersion());
  }

  /**
   * Test {@link Tag#getEntityVersion()}.
   *
   * <ul>
   *   <li>Given {@link Tag#Tag(Element, int)} with parent is {@link Bold#Bold(Element)} and
   *       entityIndex is one.
   *   <li>Then return {@code 1.0}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#getEntityVersion()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tag.getEntityVersion()"})
  public void testGetEntityVersion_givenTagWithParentIsBoldAndEntityIndexIsOne_thenReturn10() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertEquals("1.0", new Tag(parent2, 1).getEntityVersion());
  }

  /**
   * Test {@link Tag#asText()}.
   *
   * <ul>
   *   <li>Given {@link Instrument} (default constructor) BbgCompId is {@code 42}.
   *   <li>Then return {@code $Root Bbg Comp Ticker}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#asText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tag.asText()"})
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
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Tag tag = new Tag(parent2, 1);
    tag.setInstrument(instrument);

    // Act and Assert
    assertEquals("$Root Bbg Comp Ticker", tag.asText());
  }

  /**
   * Test {@link Tag#asText()}.
   *
   * <ul>
   *   <li>Given {@link Tag#Tag(Element, int)} with parent is {@link Bold#Bold(Element)} and
   *       entityIndex is one.
   *   <li>Then return {@code $null}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#asText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Tag.asText()"})
  public void testAsText_givenTagWithParentIsBoldAndEntityIndexIsOne_thenReturnNull() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertEquals("$null", new Tag(parent2, 1).asText());
  }

  /**
   * Test {@link Tag#validateFallBackTicker()}.
   *
   * <ul>
   *   <li>Given {@link Instrument} (default constructor) BbgCompId is {@code 42}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Tag#validateFallBackTicker()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.validateFallBackTicker()"})
  public void testValidateFallBackTicker_givenInstrumentBbgCompIdIs42_thenDoesNotThrow()
      throws InvalidInputException {
    // Arrange
    Instrument instrument = new Instrument();
    instrument.setBbgCompId("42");
    instrument.setBbgCompTicker("No instrument found , \"fallback-ticker\" attribute is required");
    instrument.setBbgMarketSector(MarketSector.EQUITY);
    instrument.setCfi("No instrument found , \"fallback-ticker\" attribute is required");
    instrument.setCountryCode("GB");
    instrument.setCountryName("GB");
    instrument.setCurrency("GBP");
    instrument.setDisplayName("No instrument found , \"fallback-ticker\" attribute is required");
    instrument.setEdiExchangeCode(
        "No instrument found , \"fallback-ticker\" attribute is required");
    instrument.setEdiInstrumentId("42");
    instrument.setExchangeName("No instrument found , \"fallback-ticker\" attribute is required");
    instrument.setFigi("No instrument found , \"fallback-ticker\" attribute is required");
    instrument.setFigiTicker("No instrument found , \"fallback-ticker\" attribute is required");
    instrument.setFullBbgCompTicker(
        "No instrument found , \"fallback-ticker\" attribute is required");
    instrument.setInstrumentTypeCode(
        "No instrument found , \"fallback-ticker\" attribute is required");
    instrument.setInstrumentTypeName(
        "No instrument found , \"fallback-ticker\" attribute is required");
    instrument.setIsin("No instrument found , \"fallback-ticker\" attribute is required");
    instrument.setKind(InstrumentKind.EQUITY);
    instrument.setLei("No instrument found , \"fallback-ticker\" attribute is required");
    instrument.setLocalCode("No instrument found , \"fallback-ticker\" attribute is required");
    instrument.setMainInstrument(true);
    instrument.setOperationalMic("No instrument found , \"fallback-ticker\" attribute is required");
    instrument.setPrimaryExchange(true);
    instrument.setProviderId(ProviderId.EDI);
    instrument.setRic("No instrument found , \"fallback-ticker\" attribute is required");
    instrument.setRootBbgCompTicker(
        "No instrument found , \"fallback-ticker\" attribute is required");
    instrument.setSedol("No instrument found , \"fallback-ticker\" attribute is required");
    instrument.setUniqueId("42");
    instrument.setUsCode("No instrument found , \"fallback-ticker\" attribute is required");
    instrument.setWkn("No instrument found , \"fallback-ticker\" attribute is required");
    Bold parent = new Bold(new BulletList(null));

    Tag tag = new Tag(parent, 1);
    tag.setInstrument(instrument);

    // Act and Assert
    tag.validateFallBackTicker();
  }

  /**
   * Test {@link Tag#validateFallBackTicker()}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#validateFallBackTicker()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.validateFallBackTicker()"})
  public void testValidateFallBackTicker_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> new Tag(parent, 1).validateFallBackTicker());
  }

  /**
   * Test {@link Tag#updateBiContext(BiContext)}.
   *
   * <p>Method under test: {@link Tag#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.updateBiContext(BiContext)"})
  public void testUpdateBiContext() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Tag tag = new Tag(parent2, 1);

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
   *
   * <ul>
   *   <li>Given {@code Item Value}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.updateBiContext(BiContext)"})
  public void testUpdateBiContext_givenItemValue() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Tag tag = new Tag(parent2, 1);

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size is two.
   * </ul>
   *
   * <p>Method under test: {@link Tag#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Tag tag = new Tag(parent2, 1);

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is three.
   * </ul>
   *
   * <p>Method under test: {@link Tag#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsThree() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Tag tag = new Tag(parent2, 1);

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is {@code hashtags}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsHashtags() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Tag tag = new Tag(parent2, 1);

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
   *
   * <ul>
   *   <li>When {@link BiContext} (default constructor).
   *   <li>Then {@link BiContext} (default constructor) Items first Name is {@code hashtags}.
   * </ul>
   *
   * <p>Method under test: {@link Tag#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Tag.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsHashtags() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Tag tag = new Tag(parent2, 1);
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
