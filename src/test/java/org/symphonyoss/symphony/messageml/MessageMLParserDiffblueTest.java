package org.symphonyoss.symphony.messageml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLParser.SplittableData;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.elements.Bold;
import org.symphonyoss.symphony.messageml.elements.BulletList;
import org.symphonyoss.symphony.messageml.elements.Button;
import org.symphonyoss.symphony.messageml.elements.Card;
import org.symphonyoss.symphony.messageml.elements.CardBody;
import org.symphonyoss.symphony.messageml.elements.CardHeader;
import org.symphonyoss.symphony.messageml.elements.CashTag;
import org.symphonyoss.symphony.messageml.elements.Checkbox;
import org.symphonyoss.symphony.messageml.elements.Code;
import org.symphonyoss.symphony.messageml.elements.DatePicker;
import org.symphonyoss.symphony.messageml.elements.DateSelector;
import org.symphonyoss.symphony.messageml.elements.Dialog;
import org.symphonyoss.symphony.messageml.elements.DialogChild;
import org.symphonyoss.symphony.messageml.elements.DialogChild.Body;
import org.symphonyoss.symphony.messageml.elements.DialogChild.Footer;
import org.symphonyoss.symphony.messageml.elements.DialogChild.Title;
import org.symphonyoss.symphony.messageml.elements.Div;
import org.symphonyoss.symphony.messageml.elements.Element;
import org.symphonyoss.symphony.messageml.elements.Emoji;
import org.symphonyoss.symphony.messageml.elements.ExpandableCard;
import org.symphonyoss.symphony.messageml.elements.Form;
import org.symphonyoss.symphony.messageml.elements.FormatEnum;
import org.symphonyoss.symphony.messageml.elements.HashTag;
import org.symphonyoss.symphony.messageml.elements.Header;
import org.symphonyoss.symphony.messageml.elements.HorizontalRule;
import org.symphonyoss.symphony.messageml.elements.Image;
import org.symphonyoss.symphony.messageml.elements.Italic;
import org.symphonyoss.symphony.messageml.elements.LineBreak;
import org.symphonyoss.symphony.messageml.elements.Link;
import org.symphonyoss.symphony.messageml.elements.ListItem;
import org.symphonyoss.symphony.messageml.elements.Mention;
import org.symphonyoss.symphony.messageml.elements.Option;
import org.symphonyoss.symphony.messageml.elements.OrderedList;
import org.symphonyoss.symphony.messageml.elements.Paragraph;
import org.symphonyoss.symphony.messageml.elements.PersonSelector;
import org.symphonyoss.symphony.messageml.elements.Preformatted;
import org.symphonyoss.symphony.messageml.elements.Radio;
import org.symphonyoss.symphony.messageml.elements.RoomSelector;
import org.symphonyoss.symphony.messageml.elements.Select;
import org.symphonyoss.symphony.messageml.elements.Span;
import org.symphonyoss.symphony.messageml.elements.SplittableElement;
import org.symphonyoss.symphony.messageml.elements.Table;
import org.symphonyoss.symphony.messageml.elements.TableBody;
import org.symphonyoss.symphony.messageml.elements.TableCell;
import org.symphonyoss.symphony.messageml.elements.TableFooter;
import org.symphonyoss.symphony.messageml.elements.TableHeader;
import org.symphonyoss.symphony.messageml.elements.TableHeaderCell;
import org.symphonyoss.symphony.messageml.elements.TableRow;
import org.symphonyoss.symphony.messageml.elements.TextArea;
import org.symphonyoss.symphony.messageml.elements.TextField;
import org.symphonyoss.symphony.messageml.elements.TimePicker;
import org.symphonyoss.symphony.messageml.elements.TimezonePicker;
import org.symphonyoss.symphony.messageml.elements.UIAction;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.exceptions.ProcessingException;
import org.symphonyoss.symphony.messageml.util.IDataProvider;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;

public class MessageMLParserDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MessageMLParser#MessageMLParser(IDataProvider)}
   *   <li>{@link MessageMLParser#getBiContext()}
   *   <li>{@link MessageMLParser#getEntityJson()}
   *   <li>{@link MessageMLParser#getMessageFormat()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MessageMLParser.<init>(IDataProvider)",
    "BiContext MessageMLParser.getBiContext()",
    "ObjectNode MessageMLParser.getEntityJson()",
    "FormatEnum MessageMLParser.getMessageFormat()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    MessageMLParser actualMessageMLParser = new MessageMLParser(new NoOpDataProvider());
    BiContext actualBiContext = actualMessageMLParser.getBiContext();
    ObjectNode actualEntityJson = actualMessageMLParser.getEntityJson();

    // Assert
    assertNull(actualEntityJson);
    assertNull(actualBiContext);
    assertNull(actualMessageMLParser.getMessageFormat());
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code 2.0}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.messageml.elements.MessageML MessageMLParser.parse(String, String, String)"
  })
  public void testParse_when20() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () ->
            new MessageMLParser(new NoOpDataProvider())
                .parse("Not all who wander are lost", "2.0", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.messageml.elements.MessageML MessageMLParser.parse(String, String, String)"
  })
  public void testParse_when42() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () ->
            new MessageMLParser(new NoOpDataProvider())
                .parse("Not all who wander are lost", "42", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code body}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.messageml.elements.MessageML MessageMLParser.parse(String, String, String)"
  })
  public void testParse_whenBody() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> new MessageMLParser(new NoOpDataProvider()).parse("body", "", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   * <ul>
   *   <li>When {@code ${}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.messageml.elements.MessageML MessageMLParser.parse(String, String, String)"
  })
  public void testParse_whenDollarSignLeftCurlyBracket()
      throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> new MessageMLParser(new NoOpDataProvider()).parse("${", " ", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.messageml.elements.MessageML MessageMLParser.parse(String, String, String)"
  })
  public void testParse_whenEmptyString() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () ->
            new MessageMLParser(new NoOpDataProvider())
                .parse("Not all who wander are lost", "", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Entity Json}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.messageml.elements.MessageML MessageMLParser.parse(String, String, String)"
  })
  public void testParse_whenEntityJson() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () ->
            new MessageMLParser(new NoOpDataProvider())
                .parse("Not all who wander are lost", "Entity Json", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Entity Json}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.messageml.elements.MessageML MessageMLParser.parse(String, String, String)"
  })
  public void testParse_whenEntityJson2() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> new MessageMLParser(new NoOpDataProvider()).parse("", "Entity Json", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code http://apache.org/xml/features/nonvalidating/load-external-dtd}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.messageml.elements.MessageML MessageMLParser.parse(String, String, String)"
  })
  public void testParse_whenHttpApacheOrgXmlFeaturesNonvalidatingLoadExternalDtd()
      throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () ->
            new MessageMLParser(new NoOpDataProvider())
                .parse(
                    "http://apache.org/xml/features/nonvalidating/load-external-dtd",
                    " ",
                    "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code <@}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.messageml.elements.MessageML MessageMLParser.parse(String, String, String)"
  })
  public void testParse_whenLessThanSignCommercialAt()
      throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> new MessageMLParser(new NoOpDataProvider()).parse("<@", " ", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code <#}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.messageml.elements.MessageML MessageMLParser.parse(String, String, String)"
  })
  public void testParse_whenLessThanSignNumberSign()
      throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> new MessageMLParser(new NoOpDataProvider()).parse("<#", " ", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.messageml.elements.MessageML MessageMLParser.parse(String, String, String)"
  })
  public void testParse_whenNotAllWhoWanderAreLost()
      throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () ->
            new MessageMLParser(new NoOpDataProvider())
                .parse("Not all who wander are lost", " ", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.messageml.elements.MessageML MessageMLParser.parse(String, String, String)"
  })
  public void testParse_whenNotBlank() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> new MessageMLParser(new NoOpDataProvider()).parse(" ", "not blank", " "));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.messageml.elements.MessageML MessageMLParser.parse(String, String, String)"
  })
  public void testParse_whenNull() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> new MessageMLParser(new NoOpDataProvider()).parse(null, " ", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   * <ul>
   *   <li>When {@code #{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.messageml.elements.MessageML MessageMLParser.parse(String, String, String)"
  })
  public void testParse_whenNumberSignLeftCurlyBracket()
      throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> new MessageMLParser(new NoOpDataProvider()).parse("#{", " ", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code "}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.messageml.elements.MessageML MessageMLParser.parse(String, String, String)"
  })
  public void testParse_whenQuotationMark() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () ->
            new MessageMLParser(new NoOpDataProvider())
                .parse("Not all who wander are lost", "\"", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parseDocument(String)}.
   *
   * <ul>
   *   <li>When {@code body}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#parseDocument(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.w3c.dom.Element MessageMLParser.parseDocument(String)"})
  public void testParseDocument_whenBody() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> new MessageMLParser(new NoOpDataProvider()).parseDocument("body"));
  }

  /**
   * Test {@link MessageMLParser#parseDocument(String)}.
   *
   * <ul>
   *   <li>When {@code Invalid messageML: Invalid messageML:}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#parseDocument(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.w3c.dom.Element MessageMLParser.parseDocument(String)"})
  public void testParseDocument_whenInvalidMessageMLInvalidMessageML()
      throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () ->
            new MessageMLParser(new NoOpDataProvider())
                .parseDocument("Invalid messageML: Invalid messageML: "));
  }

  /**
   * Test {@link MessageMLParser#parseDocument(String)}.
   *
   * <ul>
   *   <li>When {@code Message ML}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#parseDocument(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.w3c.dom.Element MessageMLParser.parseDocument(String)"})
  public void testParseDocument_whenMessageMl() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> new MessageMLParser(new NoOpDataProvider()).parseDocument("Message ML"));
  }

  /**
   * Test {@link MessageMLParser#parseDocument(String)}.
   *
   * <ul>
   *   <li>When {@code "}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#parseDocument(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.w3c.dom.Element MessageMLParser.parseDocument(String)"})
  public void testParseDocument_whenQuotationMark()
      throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> new MessageMLParser(new NoOpDataProvider()).parseDocument("\""));
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link Bold#Bold(Element)} with parent is {@link Bold#Bold(Element)}.
   *   <li>Then return {@link CardBody}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenBoldWithParentIsBold_thenReturnCardBody()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("body");
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Bold parent3 = new Bold(parent2);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, parent3);

    // Assert
    assertTrue(actualCreateElementResult instanceof CardBody);
    assertEquals("div", actualCreateElementResult.getPresentationMLTag());
    assertSame(parent3, actualCreateElementResult.getParent());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code a}.
   *   <li>Then return {@link Link}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithA_thenReturnLink()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("a");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Link);
    assertEquals("a", actualCreateElementResult.getMessageMLTag());
    assertEquals("a", actualCreateElementResult.getPresentationMLTag());
    assertNull(((Link) actualCreateElementResult).getUri());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code b}.
   *   <li>Then return {@link Bold}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithB_thenReturnBold()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("b");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Bold);
    assertEquals("b", actualCreateElementResult.getMessageMLTag());
    assertEquals("b", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code body}.
   *   <li>Then return {@link DialogChild.Body}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithBody_thenReturnBody()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("body");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Body);
    assertEquals("body", actualCreateElementResult.getMessageMLTag());
    assertEquals("body", actualCreateElementResult.getPresentationMLTag());
    assertNull(actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code br}.
   *   <li>Then return {@link LineBreak}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithBr_thenReturnLineBreak()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("br");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof LineBreak);
    assertEquals("br", actualCreateElementResult.getMessageMLTag());
    assertEquals("br", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code button}.
   *   <li>Then return {@link Button}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithButton_thenReturnButton()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("button");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Button);
    Map<String, String> attributes = actualCreateElementResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("action", attributes.get("type"));
    assertEquals("button", actualCreateElementResult.getMessageMLTag());
    assertEquals("button", actualCreateElementResult.getPresentationMLTag());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code card}.
   *   <li>Then return {@link Card}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithCard_thenReturnCard()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("card");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Card);
    assertEquals("card", actualCreateElementResult.getMessageMLTag());
    assertEquals("div", actualCreateElementResult.getPresentationMLTag());
    assertNull(actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code cash}.
   *   <li>Then return {@link CashTag}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithCash_thenReturnCashTag()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("cash");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof CashTag);
    assertEquals("cash", actualCreateElementResult.getMessageMLTag());
    assertEquals("span", actualCreateElementResult.getPresentationMLTag());
    assertNull(((CashTag) actualCreateElementResult).getTag());
    assertEquals(FormatEnum.MESSAGEML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code checkbox}.
   *   <li>Then return {@link Checkbox}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithCheckbox_thenReturnCheckbox()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("checkbox");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Checkbox);
    assertEquals("checkbox", ((Checkbox) actualCreateElementResult).getElementId());
    assertEquals("checkbox", actualCreateElementResult.getMessageMLTag());
    assertEquals("checkbox", actualCreateElementResult.getPresentationMLTag());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code code}.
   *   <li>Then return {@link Code}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithCode_thenReturnCode()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("code");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Code);
    assertEquals("code", actualCreateElementResult.getMessageMLTag());
    assertEquals("code", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code date-picker}.
   *   <li>Then return {@link DatePicker}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithDatePicker_thenReturnDatePicker()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("date-picker");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof DatePicker);
    assertEquals("date-picker", actualCreateElementResult.getMessageMLTag());
    assertEquals("date-picker", actualCreateElementResult.getPresentationMLTag());
    assertEquals("date-picker", ((DatePicker) actualCreateElementResult).getElementId());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code date-selector}.
   *   <li>Then return {@link DateSelector}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithDateSelector_thenReturnDateSelector()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("date-selector");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof DateSelector);
    assertEquals("date-selector", actualCreateElementResult.getMessageMLTag());
    assertEquals("div", actualCreateElementResult.getPresentationMLTag());
    assertNull(actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code dialog}.
   *   <li>Then return {@link Dialog}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithDialog_thenReturnDialog()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("dialog");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Dialog);
    assertEquals("dialog", actualCreateElementResult.getMessageMLTag());
    assertEquals("dialog", actualCreateElementResult.getPresentationMLTag());
    assertNull(actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code div}.
   *   <li>Then return {@link Div}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithDiv_thenReturnDiv()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("div");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Div);
    assertEquals("div", actualCreateElementResult.getMessageMLTag());
    assertEquals("div", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code emoji}.
   *   <li>Then return {@link Emoji}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithEmoji_thenReturnEmoji()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("emoji");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Emoji);
    assertEquals("emoji", actualCreateElementResult.getMessageMLTag());
    assertEquals("normal", ((Emoji) actualCreateElementResult).getSize());
    assertNull(((Emoji) actualCreateElementResult).getAnnotation());
    assertNull(((Emoji) actualCreateElementResult).getFamily());
    assertNull(((Emoji) actualCreateElementResult).getShortCode());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code expandable-card}.
   *   <li>Then return {@link ExpandableCard}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithExpandableCard_thenReturnExpandableCard()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("expandable-card");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof ExpandableCard);
    assertEquals("div", actualCreateElementResult.getPresentationMLTag());
    assertEquals("expandable-card", actualCreateElementResult.getMessageMLTag());
    assertNull(actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithFoo_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("foo");
    BulletList parent = new BulletList(mock(Element.class));

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> messageMLParser.createElement(element, new Bold(parent)));
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code footer}.
   *   <li>Then return {@link DialogChild.Footer}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithFooter_thenReturnFooter()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("footer");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Footer);
    assertEquals("footer", actualCreateElementResult.getMessageMLTag());
    assertEquals("footer", actualCreateElementResult.getPresentationMLTag());
    assertNull(actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code form}.
   *   <li>Then return {@link Form}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithForm_thenReturnForm()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("form");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Form);
    assertEquals("form", actualCreateElementResult.getMessageMLTag());
    assertEquals("form", actualCreateElementResult.getPresentationMLTag());
    assertNull(actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code h1}.
   *   <li>Then return {@link Header}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithH1_thenReturnHeader()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("h1");
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, parent2);

    // Assert
    assertTrue(actualCreateElementResult instanceof Header);
    assertEquals("h1", actualCreateElementResult.getMessageMLTag());
    assertEquals("h1", actualCreateElementResult.getPresentationMLTag());
    assertSame(parent2, actualCreateElementResult.getParent());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code hash}.
   *   <li>Then return {@link HashTag}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithHash_thenReturnHashTag()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("hash");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof HashTag);
    assertEquals(
        "[\\S]*[^\\s!@#$%^&*()+=<>,./?`~:;'\"\\\\|-]+[\\S]*$",
        ((HashTag) actualCreateElementResult).getTagPattern());
    assertEquals("hash", actualCreateElementResult.getMessageMLTag());
    assertNull(((HashTag) actualCreateElementResult).getTag());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code header}.
   *   <li>Then return {@link CardHeader}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithHeader_thenReturnCardHeader()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("header");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof CardHeader);
    assertEquals("div", actualCreateElementResult.getPresentationMLTag());
    assertEquals("header", actualCreateElementResult.getMessageMLTag());
    assertNull(actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code hr}.
   *   <li>Then return {@link HorizontalRule}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithHr_thenReturnHorizontalRule()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("hr");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof HorizontalRule);
    assertEquals("hr", actualCreateElementResult.getMessageMLTag());
    assertEquals("hr", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code i}.
   *   <li>Then return {@link Italic}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithI_thenReturnItalic()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("i");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Italic);
    assertEquals("i", actualCreateElementResult.getMessageMLTag());
    assertEquals("i", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code img}.
   *   <li>Then return {@link Image}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithImg_thenReturnImage()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("img");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Image);
    assertEquals("img", actualCreateElementResult.getMessageMLTag());
    assertEquals("img", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code input}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithInput_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("input");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> messageMLParser.createElement(element, new Bold(parent2)));
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code li}.
   *   <li>Then return {@link ListItem}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithLi_thenReturnListItem()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("li");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof ListItem);
    assertEquals("li", actualCreateElementResult.getMessageMLTag());
    assertEquals("li", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code mention}.
   *   <li>Then return {@link Mention}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithMention_thenReturnMention()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("mention");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Mention);
    assertEquals("mention", actualCreateElementResult.getMessageMLTag());
    assertEquals("span", actualCreateElementResult.getPresentationMLTag());
    assertNull(((Mention) actualCreateElementResult).getUserPresentation());
    assertEquals(FormatEnum.MESSAGEML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code ol}.
   *   <li>Then return {@link OrderedList}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithOl_thenReturnOrderedList()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("ol");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof OrderedList);
    assertEquals("ol", actualCreateElementResult.getMessageMLTag());
    assertEquals("ol", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code option}.
   *   <li>Then return {@link Option}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithOption_thenReturnOption()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("option");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Option);
    assertEquals("option", actualCreateElementResult.getMessageMLTag());
    assertEquals("option", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code p}.
   *   <li>Then return {@link Paragraph}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithP_thenReturnParagraph()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("p");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Paragraph);
    assertEquals("p", actualCreateElementResult.getMessageMLTag());
    assertEquals("p", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code person-selector}.
   *   <li>Then return {@link PersonSelector}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithPersonSelector_thenReturnPersonSelector()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("person-selector");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof PersonSelector);
    assertEquals("div", actualCreateElementResult.getPresentationMLTag());
    assertEquals("person-selector", actualCreateElementResult.getMessageMLTag());
    assertEquals("person-selector", ((PersonSelector) actualCreateElementResult).getElementId());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code pre}.
   *   <li>Then return {@link Preformatted}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithPre_thenReturnPreformatted()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("pre");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Preformatted);
    assertEquals("pre", actualCreateElementResult.getMessageMLTag());
    assertEquals("pre", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code radio}.
   *   <li>Then return {@link Radio}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithRadio_thenReturnRadio()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("radio");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Radio);
    assertEquals("radio", actualCreateElementResult.getMessageMLTag());
    assertEquals("radio", actualCreateElementResult.getPresentationMLTag());
    assertEquals("radio", ((Radio) actualCreateElementResult).getElementId());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code room-selector}.
   *   <li>Then return {@link RoomSelector}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithRoomSelector_thenReturnRoomSelector()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("room-selector");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof RoomSelector);
    assertEquals("div", actualCreateElementResult.getPresentationMLTag());
    assertEquals("room-selector", actualCreateElementResult.getMessageMLTag());
    assertEquals("room-selector", ((RoomSelector) actualCreateElementResult).getElementId());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code select}.
   *   <li>Then return {@link Select}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithSelect_thenReturnSelect()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("select");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Select);
    assertEquals("dropdown", ((Select) actualCreateElementResult).getElementId());
    assertEquals("select", actualCreateElementResult.getMessageMLTag());
    assertEquals("select", actualCreateElementResult.getPresentationMLTag());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code span}.
   *   <li>Then return {@link Span}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithSpan_thenReturnSpan()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("span");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Span);
    assertEquals("span", actualCreateElementResult.getMessageMLTag());
    assertEquals("span", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code table}.
   *   <li>Then return {@link Table}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithTable_thenReturnTable()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("table");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Table);
    assertEquals("table", actualCreateElementResult.getMessageMLTag());
    assertEquals("table", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code tbody}.
   *   <li>Then return {@link TableBody}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithTbody_thenReturnTableBody()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("tbody");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof TableBody);
    assertEquals("tbody", actualCreateElementResult.getMessageMLTag());
    assertEquals("tbody", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code td}.
   *   <li>Then return {@link TableCell}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithTd_thenReturnTableCell()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("td");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof TableCell);
    assertEquals("td", actualCreateElementResult.getMessageMLTag());
    assertEquals("td", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code text-field}.
   *   <li>Then return {@link TextField}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithTextField_thenReturnTextField()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("text-field");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof TextField);
    assertEquals("input", actualCreateElementResult.getPresentationMLTag());
    Map<String, String> otherAttributes =
        ((TextField) actualCreateElementResult).getOtherAttributes();
    assertEquals(2, otherAttributes.size());
    assertEquals("text", otherAttributes.get("type"));
    assertEquals("text-field", actualCreateElementResult.getMessageMLTag());
    assertEquals("text-field", ((TextField) actualCreateElementResult).getElementType());
    assertEquals("textfield", ((TextField) actualCreateElementResult).getElementId());
    assertNull(otherAttributes.get("name"));
    assertEquals(1, ((TextField) actualCreateElementResult).getMinValueAllowed().intValue());
    assertEquals(128, ((TextField) actualCreateElementResult).getMaxValueAllowed().intValue());
    assertFalse(((TextField) actualCreateElementResult).hasElementInitialValue());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code textarea}.
   *   <li>Then return {@link TextArea}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithTextarea_thenReturnTextArea()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("textarea");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof TextArea);
    assertEquals("textarea", actualCreateElementResult.getMessageMLTag());
    assertEquals("textarea", actualCreateElementResult.getPresentationMLTag());
    assertEquals("textarea", ((TextArea) actualCreateElementResult).getElementId());
    assertEquals("textarea", ((TextArea) actualCreateElementResult).getElementType());
    assertEquals(0, ((TextArea) actualCreateElementResult).getMinValueAllowed().intValue());
    assertEquals(10000, ((TextArea) actualCreateElementResult).getMaxValueAllowed().intValue());
    assertFalse(((TextArea) actualCreateElementResult).hasElementInitialValue());
    assertTrue(((TextArea) actualCreateElementResult).getOtherAttributes().isEmpty());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code tfoot}.
   *   <li>Then return {@link TableFooter}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithTfoot_thenReturnTableFooter()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("tfoot");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof TableFooter);
    assertEquals("tfoot", actualCreateElementResult.getMessageMLTag());
    assertEquals("tfoot", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code th}.
   *   <li>Then return {@link TableHeaderCell}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithTh_thenReturnTableHeaderCell()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("th");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof TableHeaderCell);
    assertEquals("th", actualCreateElementResult.getMessageMLTag());
    assertEquals("th", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code thead}.
   *   <li>Then return {@link TableHeader}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithThead_thenReturnTableHeader()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("thead");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof TableHeader);
    assertEquals("thead", actualCreateElementResult.getMessageMLTag());
    assertEquals("thead", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code time-picker}.
   *   <li>Then return {@link TimePicker}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithTimePicker_thenReturnTimePicker()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("time-picker");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof TimePicker);
    assertEquals("time-picker", actualCreateElementResult.getMessageMLTag());
    assertEquals("time-picker", actualCreateElementResult.getPresentationMLTag());
    assertEquals("time-picker", ((TimePicker) actualCreateElementResult).getElementId());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code timezone-picker}.
   *   <li>Then return {@link TimezonePicker}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithTimezonePicker_thenReturnTimezonePicker()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("timezone-picker");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof TimezonePicker);
    assertEquals("timezone-picker", actualCreateElementResult.getMessageMLTag());
    assertEquals("timezone-picker", actualCreateElementResult.getPresentationMLTag());
    assertEquals("timezone-picker", ((TimezonePicker) actualCreateElementResult).getElementId());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code title}.
   *   <li>Then return {@link DialogChild.Title}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithTitle_thenReturnTitle()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("title");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof Title);
    assertEquals("title", actualCreateElementResult.getMessageMLTag());
    assertEquals("title", actualCreateElementResult.getPresentationMLTag());
    assertNull(actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code tr}.
   *   <li>Then return {@link TableRow}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithTr_thenReturnTableRow()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("tr");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof TableRow);
    assertEquals("tr", actualCreateElementResult.getMessageMLTag());
    assertEquals("tr", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code ui-action}.
   *   <li>Then return {@link UIAction}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithUiAction_thenReturnUIAction()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("ui-action");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof UIAction);
    Map<String, String> attributes = actualCreateElementResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("click", attributes.get("trigger"));
    assertEquals("div", actualCreateElementResult.getPresentationMLTag());
    assertEquals("ui-action", actualCreateElementResult.getMessageMLTag());
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code ul}.
   *   <li>Then return {@link BulletList}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#createElement(org.w3c.dom.Element, Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MessageMLParser.createElement(org.w3c.dom.Element, Element)"})
  public void testCreateElement_whenIIOMetadataNodeWithUl_thenReturnBulletList()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("ul");
    Bold parent = new Bold(mock(Element.class));
    Dialog parent2 = new Dialog(parent, FormatEnum.MESSAGEML);

    // Act
    Element actualCreateElementResult = messageMLParser.createElement(element, new Bold(parent2));

    // Assert
    assertTrue(actualCreateElementResult instanceof BulletList);
    assertEquals("ul", actualCreateElementResult.getMessageMLTag());
    assertEquals("ul", actualCreateElementResult.getPresentationMLTag());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
  }

  /**
   * Test {@link MessageMLParser#clearBiContext()}.
   *
   * <p>Method under test: {@link MessageMLParser#clearBiContext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageMLParser.clearBiContext()"})
  public void testClearBiContext() {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());

    // Act
    messageMLParser.clearBiContext();

    // Assert
    assertTrue(messageMLParser.getBiContext().getItems().isEmpty());
  }

  /**
   * Test SplittableData {@link SplittableData#addAttribute(Class, String, String)}.
   *
   * <p>Method under test: {@link SplittableData#addAttribute(Class, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SplittableData.addAttribute(Class, String, String)"})
  public void testSplittableDataAddAttribute() {
    // Arrange
    SplittableData splittableData = new SplittableData();
    Class<SplittableElement> splittable = SplittableElement.class;

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> splittableData.addAttribute(splittable, "Attribute Name", "42"));
  }

  /**
   * Test SplittableData {@link SplittableData#exists(Class)}.
   *
   * <p>Method under test: {@link SplittableData#exists(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SplittableData.exists(Class)"})
  public void testSplittableDataExists() {
    // Arrange
    SplittableData splittableData = new SplittableData();
    Class<SplittableElement> splittable = SplittableElement.class;

    // Act and Assert
    assertFalse(splittableData.exists(splittable));
  }

  /**
   * Test SplittableData {@link SplittableData#getAllAttributes()}.
   *
   * <p>Method under test: {@link SplittableData#getAllAttributes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SplittableData.getAllAttributes()"})
  public void testSplittableDataGetAllAttributes() {
    // Arrange, Act and Assert
    assertTrue(new SplittableData().getAllAttributes().isEmpty());
  }

  /**
   * Test SplittableData {@link SplittableData#getAllValues()}.
   *
   * <p>Method under test: {@link SplittableData#getAllValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SplittableData.getAllValues()"})
  public void testSplittableDataGetAllValues() {
    // Arrange, Act and Assert
    assertTrue(new SplittableData().getAllValues().isEmpty());
  }

  /**
   * Test SplittableData {@link SplittableData#getAttributes(Class)}.
   *
   * <p>Method under test: {@link SplittableData#getAttributes(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional SplittableData.getAttributes(Class)"})
  public void testSplittableDataGetAttributes() {
    // Arrange
    SplittableData splittableData = new SplittableData();
    Class<SplittableElement> splittable = SplittableElement.class;

    // Act and Assert
    assertFalse(splittableData.getAttributes(splittable).isPresent());
  }

  /**
   * Test SplittableData new {@link SplittableData} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SplittableData}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SplittableData.<init>()"})
  public void testSplittableDataNewSplittableData() {
    // Arrange and Act
    SplittableData actualSplittableData = new SplittableData();

    // Assert
    assertTrue(actualSplittableData.getAllAttributes().isEmpty());
    assertTrue(actualSplittableData.getAllValues().isEmpty());
  }
}
