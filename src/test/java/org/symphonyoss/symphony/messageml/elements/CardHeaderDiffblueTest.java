package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import javax.imageio.metadata.IIOMetadataNode;

import org.commonmark.node.Node;
import org.commonmark.node.Paragraph;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.exceptions.ProcessingException;
import org.symphonyoss.symphony.messageml.util.DataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class CardHeaderDiffblueTest {
  /**
   * Test {@link CardHeader#buildAttribute(MessageMLParser, Node)}.
   * <ul>
   *   <li>Given makeElement.</li>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CardHeader#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAttribute_givenMakeElement_whenIIOMetadataNodeWithFoo()
      throws IOException, InvalidInputException, ProcessingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: object is not an instance of declaring class
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Element makeElementResult = ElementFactory.makeElement();
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    makeElementResult.buildAttribute(parser, new IIOMetadataNode("foo"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CardHeader#CardHeader(Element, FormatEnum)}
   *   <li>{@link CardHeader#getPresentationMLTag()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() throws IOException, InvalidInputException, ProcessingException {
    // Arrange
    Element parent = ElementFactory.makeElement();

    // Act
    CardHeader actualCardHeader = new CardHeader(parent, FormatEnum.MESSAGEML);
    String actualPresentationMLTag = actualCardHeader.getPresentationMLTag();

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualCardHeader.getFormat());
    assertTrue(actualCardHeader.getChildren().isEmpty());
    assertTrue(actualCardHeader.getAttributes().isEmpty());
    assertEquals(CardHeader.MESSAGEML_TAG, actualCardHeader.getMessageMLTag());
    assertEquals(Div.MESSAGEML_TAG, actualPresentationMLTag);
    assertSame(parent, actualCardHeader.getParent());
  }

  /**
   * Test {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() throws IOException, InvalidInputException, ProcessingException {
    // Arrange
    CardHeader cardHeader = new CardHeader(ElementFactory.makeElement(), FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new DataProvider()));

    // Assert
    assertEquals(32L, out.getOffset());
  }

  /**
   * Test {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() throws IOException, InvalidInputException, ProcessingException {
    // Arrange
    CardHeader cardHeader = new CardHeader(ElementFactory.makeElement(), FormatEnum.MESSAGEML);
    cardHeader.addChild(ElementFactory.makeElement());
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new DataProvider()));

    // Assert
    assertEquals(223L, out.getOffset());
  }

  /**
   * Test {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() throws IOException, InvalidInputException, ProcessingException {
    // Arrange
    CardHeader cardHeader = new CardHeader(ElementFactory.makeElement(), FormatEnum.MESSAGEML);
    cardHeader.addChild(new Bold(ElementFactory.makeElement()));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new DataProvider()));

    // Assert
    assertEquals(43L, out.getOffset());
  }

  /**
   * Test {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() throws IOException, InvalidInputException, ProcessingException {
    // Arrange
    CardHeader cardHeader = new CardHeader(ElementFactory.makeElement(), FormatEnum.MESSAGEML);
    cardHeader.addChild(new Code(ElementFactory.makeElement(), "en"));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new DataProvider()));

    // Assert
    assertEquals(68L, out.getOffset());
  }

  /**
   * Test {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() throws IOException, InvalidInputException, ProcessingException {
    // Arrange
    CardHeader cardHeader = new CardHeader(ElementFactory.makeElement(), FormatEnum.MESSAGEML);
    cardHeader.addChild(new Button(ElementFactory.makeElement(), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new DataProvider()));

    // Assert
    List<Element> children = cardHeader.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    org.slf4j.Logger logger = ((Button) getResult).logger;
    assertTrue(logger instanceof ch.qos.logback.classic.Logger);
    ExecutorService executorService = ((ch.qos.logback.classic.Logger) logger).getLoggerContext().getExecutorService();
    assertTrue(executorService instanceof ScheduledThreadPoolExecutor);
    assertTrue(getResult instanceof Button);
    assertEquals(67L, out.getOffset());
    assertTrue(executorService.isShutdown());
  }

  /**
   * Test {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML6() throws IOException, InvalidInputException, ProcessingException {
    // Arrange
    CardHeader cardHeader = new CardHeader(ElementFactory.makeElement(), FormatEnum.MESSAGEML);
    cardHeader.addChild(new CardBody(ElementFactory.makeElement(), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new DataProvider()));

    // Assert
    assertEquals(64L, out.getOffset());
  }

  /**
   * Test {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML7() throws IOException, InvalidInputException, ProcessingException {
    // Arrange
    CardHeader cardHeader = new CardHeader(ElementFactory.makeElement(), FormatEnum.MESSAGEML);
    cardHeader.addChild(new CardHeader(ElementFactory.makeElement(), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new DataProvider()));

    // Assert
    assertEquals(66L, out.getOffset());
  }

  /**
   * Test {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML8() throws IOException, InvalidInputException, ProcessingException {
    // Arrange
    Element child = ElementFactory.makeElement();
    child.addChild(ElementFactory.makeElement());

    CardHeader cardHeader = new CardHeader(ElementFactory.makeElement(), FormatEnum.MESSAGEML);
    cardHeader.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new DataProvider()));

    // Assert
    assertEquals(425L, out.getOffset());
  }

  /**
   * Test {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML9() throws IOException, InvalidInputException, ProcessingException {
    // Arrange
    CardHeader cardHeader = new CardHeader(ElementFactory.makeElement(), FormatEnum.MESSAGEML);
    cardHeader.addChild(new CashTag(ElementFactory.makeElement(), 1));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new DataProvider()));

    // Assert
    assertEquals(96L, out.getOffset());
  }

  /**
   * Test {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML10() throws IOException, InvalidInputException, ProcessingException {
    // Arrange
    Bold child = new Bold(ElementFactory.makeElement());
    child.addChild(ElementFactory.makeElement());

    CardHeader cardHeader = new CardHeader(ElementFactory.makeElement(), FormatEnum.MESSAGEML);
    cardHeader.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new DataProvider()));

    // Assert
    assertEquals(245L, out.getOffset());
  }

  /**
   * Test {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML11() throws IOException, InvalidInputException, ProcessingException {
    // Arrange
    CardHeader cardHeader = new CardHeader(ElementFactory.makeElement(), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new DataProvider()));

    // Assert
    assertEquals(32L, out.getOffset());
  }

  /**
   * Test {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML12() throws IOException, InvalidInputException, ProcessingException {
    // Arrange
    CardHeader cardHeader = new CardHeader(ElementFactory.makeElement(), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new DataProvider()));

    // Assert
    assertEquals(32L, out.getOffset());
  }

  /**
   * Test {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML13() throws IOException, InvalidInputException, ProcessingException {
    // Arrange
    CardHeader cardHeader = new CardHeader(ElementFactory.makeElement(), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new DataProvider()));

    // Assert
    assertEquals(30L, out.getOffset());
  }

  /**
   * Test {@link CardHeader#asMarkdown()}.
   * <ul>
   *   <li>Then return {@link Paragraph}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CardHeader#asMarkdown()}
   */
  @Test
  public void testAsMarkdown_thenReturnParagraph() throws IOException, InvalidInputException, ProcessingException {
    // Arrange and Act
    Node actualAsMarkdownResult = (new CardHeader(ElementFactory.makeElement(), FormatEnum.MESSAGEML)).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof Paragraph);
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link CardHeader#validate()}.
   * <ul>
   *   <li>Given {@link Card#Card(Element, FormatEnum)} with parent is makeElement
   * and format is {@code MESSAGEML}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CardHeader#validate()}
   */
  @Test
  public void testValidate_givenCardWithParentIsMakeElementAndFormatIsMessageml()
      throws IOException, InvalidInputException, ProcessingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Card parent = new Card(ElementFactory.makeElement(), FormatEnum.MESSAGEML);
    parent.putOneIfPresent(new HashMap<>(), "Element \"%s\" can only be a child of the following elements: [%s]",
        "Element \"%s\" can only be a child of the following elements: [%s]");

    // Act
    (new CardHeader(parent, FormatEnum.MESSAGEML)).validate();
  }

  /**
   * Test {@link CardHeader#validate()}.
   * <ul>
   *   <li>Given makeElement.</li>
   * </ul>
   * <p>
   * Method under test: {@link CardHeader#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate_givenMakeElement() throws IOException, InvalidInputException, ProcessingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: object is not an instance of declaring class
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    ElementFactory.makeElement().validate();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CardHeader#CardHeader(Element, FormatEnum)}
   *   <li>{@link CardHeader#getPresentationMLTag()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    CardHeader actualCardHeader = new CardHeader(parent, FormatEnum.MESSAGEML);
    String actualPresentationMLTag = actualCardHeader.getPresentationMLTag();

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualCardHeader.getFormat());
    assertTrue(actualCardHeader.getChildren().isEmpty());
    assertTrue(actualCardHeader.getAttributes().isEmpty());
    assertEquals(CardHeader.MESSAGEML_TAG, actualCardHeader.getMessageMLTag());
    assertEquals(Div.MESSAGEML_TAG, actualPresentationMLTag);
    assertSame(parent, actualCardHeader.getParent());
  }
}
