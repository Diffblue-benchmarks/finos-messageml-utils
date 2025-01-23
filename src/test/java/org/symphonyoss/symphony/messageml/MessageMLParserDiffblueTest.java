package org.symphonyoss.symphony.messageml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLParser.SplittableData;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.elements.Bold;
import org.symphonyoss.symphony.messageml.elements.BulletList;
import org.symphonyoss.symphony.messageml.elements.FormatEnum;
import org.symphonyoss.symphony.messageml.elements.Header;
import org.symphonyoss.symphony.messageml.elements.SplittableElement;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.exceptions.ProcessingException;
import org.symphonyoss.symphony.messageml.util.IDataProvider;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;

public class MessageMLParserDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MessageMLParser#MessageMLParser(IDataProvider)}
   *   <li>{@link MessageMLParser#getBiContext()}
   *   <li>{@link MessageMLParser#getEntityJson()}
   *   <li>{@link MessageMLParser#getMessageFormat()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When {@code 2.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  public void testParse_when20() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new MessageMLParser(new NoOpDataProvider())).parse("Not all who wander are lost", "2.0", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  public void testParse_when42() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new MessageMLParser(new NoOpDataProvider())).parse("Not all who wander are lost", "42", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   * <ul>
   *   <li>When {@code body}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  public void testParse_whenBody() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new MessageMLParser(new NoOpDataProvider())).parse("body", "", "1.0.2"));
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
  public void testParse_whenDollarSignLeftCurlyBracket() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new MessageMLParser(new NoOpDataProvider())).parse("${", "", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   * <ul>
   *   <li>When {@code Entity Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  public void testParse_whenEntityJson() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class, () -> (new MessageMLParser(new NoOpDataProvider()))
        .parse("Not all who wander are lost", "Entity Json", "1.0.2"));
    assertThrows(InvalidInputException.class,
        () -> (new MessageMLParser(new NoOpDataProvider())).parse("", "Entity Json", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   * <ul>
   *   <li>When
   * {@code http://apache.org/xml/features/nonvalidating/load-external-dtd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  public void testParse_whenHttpApacheOrgXmlFeaturesNonvalidatingLoadExternalDtd()
      throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class, () -> (new MessageMLParser(new NoOpDataProvider()))
        .parse("http://apache.org/xml/features/nonvalidating/load-external-dtd", "", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   * <ul>
   *   <li>When {@code <@}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  public void testParse_whenLessThanSignCommercialAt() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new MessageMLParser(new NoOpDataProvider())).parse("<@", "", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   * <ul>
   *   <li>When {@code <#}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  public void testParse_whenLessThanSignNumberSign() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new MessageMLParser(new NoOpDataProvider())).parse("<#", "", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  public void testParse_whenNotAllWhoWanderAreLost() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new MessageMLParser(new NoOpDataProvider())).parse("Not all who wander are lost", "", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  public void testParse_whenNull() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new MessageMLParser(new NoOpDataProvider())).parse(null, "", "1.0.2"));
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
  public void testParse_whenNumberSignLeftCurlyBracket() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new MessageMLParser(new NoOpDataProvider())).parse("#{", "", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parse(String, String, String)}.
   * <ul>
   *   <li>When {@code "}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  public void testParse_whenQuotationMark() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new MessageMLParser(new NoOpDataProvider())).parse("Not all who wander are lost", "\"", "1.0.2"));
  }

  /**
   * Test {@link MessageMLParser#parseDocument(String)}.
   * <ul>
   *   <li>When {@code body}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#parseDocument(String)}
   */
  @Test
  public void testParseDocument_whenBody() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new MessageMLParser(new NoOpDataProvider())).parseDocument("body"));
  }

  /**
   * Test {@link MessageMLParser#parseDocument(String)}.
   * <ul>
   *   <li>When
   * {@code http://apache.org/xml/features/nonvalidating/load-external-dtd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#parseDocument(String)}
   */
  @Test
  public void testParseDocument_whenHttpApacheOrgXmlFeaturesNonvalidatingLoadExternalDtd()
      throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class, () -> (new MessageMLParser(new NoOpDataProvider()))
        .parseDocument("http://apache.org/xml/features/nonvalidating/load-external-dtd"));
  }

  /**
   * Test {@link MessageMLParser#parseDocument(String)}.
   * <ul>
   *   <li>When {@code Message ML}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#parseDocument(String)}
   */
  @Test
  public void testParseDocument_whenMessageMl() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new MessageMLParser(new NoOpDataProvider())).parseDocument("Message ML"));
  }

  /**
   * Test {@link MessageMLParser#parseDocument(String)}.
   * <ul>
   *   <li>When {@code "}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#parseDocument(String)}
   */
  @Test
  public void testParseDocument_whenQuotationMark() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class, () -> (new MessageMLParser(new NoOpDataProvider())).parseDocument("\""));
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessageMLParser#createElement(org.w3c.dom.Element, org.symphonyoss.symphony.messageml.elements.Element)}
   */
  @Test
  public void testCreateElement_whenIIOMetadataNodeWithFoo_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("foo");

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> messageMLParser.createElement(element,
        new Bold(new BulletList(mock(org.symphonyoss.symphony.messageml.elements.Element.class)))));
  }

  /**
   * Test {@link MessageMLParser#createElement(Element, Element)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code h1}.</li>
   *   <li>Then return {@link Header}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MessageMLParser#createElement(org.w3c.dom.Element, org.symphonyoss.symphony.messageml.elements.Element)}
   */
  @Test
  public void testCreateElement_whenIIOMetadataNodeWithH1_thenReturnHeader() throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("h1");
    Bold parent = new Bold(new BulletList(mock(org.symphonyoss.symphony.messageml.elements.Element.class)));

    // Act
    org.symphonyoss.symphony.messageml.elements.Element actualCreateElementResult = messageMLParser
        .createElement(element, parent);

    // Assert
    assertTrue(actualCreateElementResult instanceof Header);
    assertEquals("h1", actualCreateElementResult.getMessageMLTag());
    assertEquals("h1", actualCreateElementResult.getPresentationMLTag());
    assertEquals(0, actualCreateElementResult.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualCreateElementResult.getFormat());
    assertTrue(actualCreateElementResult.getChildren().isEmpty());
    assertTrue(actualCreateElementResult.getAttributes().isEmpty());
    assertSame(parent, actualCreateElementResult.getParent());
  }

  /**
   * Test {@link MessageMLParser#clearBiContext()}.
   * <p>
   * Method under test: {@link MessageMLParser#clearBiContext()}
   */
  @Test
  public void testClearBiContext() {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());

    // Act
    messageMLParser.clearBiContext();

    // Assert
    assertTrue(messageMLParser.getBiContext().getItems().isEmpty());
  }

  /**
   * Test SplittableData
   * {@link SplittableData#addAttribute(Class, String, String)}.
   * <p>
   * Method under test:
   * {@link MessageMLParser.SplittableData#addAttribute(Class, String, String)}
   */
  @Test
  public void testSplittableDataAddAttribute() {
    // Arrange
    MessageMLParser.SplittableData splittableData = new MessageMLParser.SplittableData();
    Class<SplittableElement> splittable = SplittableElement.class;

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> splittableData.addAttribute(splittable, "Attribute Name", "42"));
  }

  /**
   * Test SplittableData {@link SplittableData#exists(Class)}.
   * <p>
   * Method under test: {@link MessageMLParser.SplittableData#exists(Class)}
   */
  @Test
  public void testSplittableDataExists() {
    // Arrange
    MessageMLParser.SplittableData splittableData = new MessageMLParser.SplittableData();
    Class<SplittableElement> splittable = SplittableElement.class;

    // Act and Assert
    assertFalse(splittableData.exists(splittable));
  }

  /**
   * Test SplittableData {@link SplittableData#getAllAttributes()}.
   * <p>
   * Method under test: {@link MessageMLParser.SplittableData#getAllAttributes()}
   */
  @Test
  public void testSplittableDataGetAllAttributes() {
    // Arrange, Act and Assert
    assertTrue((new MessageMLParser.SplittableData()).getAllAttributes().isEmpty());
  }

  /**
   * Test SplittableData {@link SplittableData#getAllValues()}.
   * <p>
   * Method under test: {@link MessageMLParser.SplittableData#getAllValues()}
   */
  @Test
  public void testSplittableDataGetAllValues() {
    // Arrange, Act and Assert
    assertTrue((new MessageMLParser.SplittableData()).getAllValues().isEmpty());
  }

  /**
   * Test SplittableData {@link SplittableData#getAttributes(Class)}.
   * <p>
   * Method under test:
   * {@link MessageMLParser.SplittableData#getAttributes(Class)}
   */
  @Test
  public void testSplittableDataGetAttributes() {
    // Arrange
    MessageMLParser.SplittableData splittableData = new MessageMLParser.SplittableData();
    Class<SplittableElement> splittable = SplittableElement.class;

    // Act and Assert
    assertFalse(splittableData.getAttributes(splittable).isPresent());
  }

  /**
   * Test SplittableData new {@link SplittableData} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link MessageMLParser.SplittableData}
   */
  @Test
  public void testSplittableDataNewSplittableData() {
    // Arrange and Act
    MessageMLParser.SplittableData actualSplittableData = new MessageMLParser.SplittableData();

    // Assert
    assertTrue(actualSplittableData.getAllAttributes().isEmpty());
    assertTrue(actualSplittableData.getAllValues().isEmpty());
  }
}
