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
   * Method under test: {@link MessageMLParser#parse(String, String, String)}
   */
  @Test
  public void testParse() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class, () -> (new MessageMLParser(new NoOpDataProvider()))
        .parse("Not all who wander are lost", "Entity Json", "1.0.2"));
    assertThrows(InvalidInputException.class,
        () -> (new MessageMLParser(new NoOpDataProvider())).parse("", "Entity Json", "1.0.2"));
    assertThrows(InvalidInputException.class,
        () -> (new MessageMLParser(new NoOpDataProvider())).parse("Not all who wander are lost", "\"", "1.0.2"));
    assertThrows(InvalidInputException.class,
        () -> (new MessageMLParser(new NoOpDataProvider())).parse("Not all who wander are lost", "42", "1.0.2"));
    assertThrows(InvalidInputException.class,
        () -> (new MessageMLParser(new NoOpDataProvider())).parse("Not all who wander are lost", "", "1.0.2"));
  }

  /**
   * Method under test: {@link MessageMLParser#parseDocument(String)}
   */
  @Test
  public void testParseDocument() throws InvalidInputException, ProcessingException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new MessageMLParser(new NoOpDataProvider())).parseDocument("Message ML"));
    assertThrows(InvalidInputException.class, () -> (new MessageMLParser(new NoOpDataProvider()))
        .parseDocument("http://apache.org/xml/features/nonvalidating/load-external-dtd"));
    assertThrows(InvalidInputException.class, () -> (new MessageMLParser(new NoOpDataProvider())).parseDocument("\""));
  }

  /**
   * Method under test:
   * {@link MessageMLParser#createElement(org.w3c.dom.Element, org.symphonyoss.symphony.messageml.elements.Element)}
   */
  @Test
  public void testCreateElement() throws InvalidInputException {
    // Arrange
    MessageMLParser messageMLParser = new MessageMLParser(new NoOpDataProvider());
    IIOMetadataNode element = new IIOMetadataNode("foo");

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> messageMLParser.createElement(element,
        new Bold(new BulletList(mock(org.symphonyoss.symphony.messageml.elements.Element.class)))));
  }

  /**
   * Method under test:
   * {@link MessageMLParser#createElement(org.w3c.dom.Element, org.symphonyoss.symphony.messageml.elements.Element)}
   */
  @Test
  public void testCreateElement2() throws InvalidInputException {
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
   * Method under test: {@link MessageMLParser.SplittableData#getAllAttributes()}
   */
  @Test
  public void testSplittableDataGetAllAttributes() {
    // Arrange, Act and Assert
    assertTrue((new MessageMLParser.SplittableData()).getAllAttributes().isEmpty());
  }

  /**
   * Method under test: {@link MessageMLParser.SplittableData#getAllValues()}
   */
  @Test
  public void testSplittableDataGetAllValues() {
    // Arrange, Act and Assert
    assertTrue((new MessageMLParser.SplittableData()).getAllValues().isEmpty());
  }

  /**
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
