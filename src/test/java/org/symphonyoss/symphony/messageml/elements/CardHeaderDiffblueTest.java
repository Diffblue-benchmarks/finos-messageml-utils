package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayOutputStream;
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
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class CardHeaderDiffblueTest {
  /**
   * Test {@link CardHeader#buildAttribute(MessageMLParser, Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CardHeader#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Attribute "foo" is not allowed in "header"
    //       at org.symphonyoss.symphony.messageml.elements.Element.throwInvalidInputException(Element.java:1071)
    //       at org.symphonyoss.symphony.messageml.elements.CardHeader.buildAttribute(CardHeader.java:47)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    CardHeader cardHeader = new CardHeader(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    cardHeader.buildAttribute(parser, new IIOMetadataNode("foo"));
  }

  /**
   * Test {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    CardHeader cardHeader = new CardHeader(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

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
  public void testAsPresentationML2() {
    // Arrange
    CardHeader cardHeader = new CardHeader(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    cardHeader.addChild(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

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
  public void testAsPresentationML3() {
    // Arrange
    CardHeader cardHeader = new CardHeader(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    cardHeader.addChild(new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(76L, out.getOffset());
  }

  /**
   * Test {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    CardHeader cardHeader = new CardHeader(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    cardHeader.addChild(new Button(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

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
  public void testAsPresentationML5() {
    // Arrange
    CardHeader cardHeader = new CardHeader(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    cardHeader.addChild(new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

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
  public void testAsPresentationML6() {
    // Arrange
    CardHeader cardHeader = new CardHeader(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    cardHeader.addChild(new CardHeader(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

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
  public void testAsPresentationML7() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    CardHeader cardHeader = new CardHeader(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    cardHeader.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(56L, out.getOffset());
  }

  /**
   * Test {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML8() {
    // Arrange
    CardHeader cardHeader = new CardHeader(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    cardHeader.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

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
  public void testAsPresentationML9() {
    // Arrange
    CardHeader cardHeader = new CardHeader(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

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
  public void testAsPresentationML10() {
    // Arrange
    CardHeader cardHeader = new CardHeader(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

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
  public void testAsPresentationML11() {
    // Arrange
    CardHeader cardHeader = new CardHeader(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    cardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(30L, out.getOffset());
  }

  /**
   * Test {@link CardHeader#asMarkdown()}.
   * <p>
   * Method under test: {@link CardHeader#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new CardHeader(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .asMarkdown();

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
   *   <li>Given {@link CardHeader#CardHeader(Element, FormatEnum)} with parent is
   * {@link Bold#Bold(Element)} and format is {@code MESSAGEML}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CardHeader#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate_givenCardHeaderWithParentIsBoldAndFormatIsMessageml() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Element "header" can only be a child of the following elements: [card]
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertParent(Element.java:741)
    //       at org.symphonyoss.symphony.messageml.elements.CardHeader.validate(CardHeader.java:70)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new CardHeader(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).validate();
  }

  /**
   * Test {@link CardHeader#validate()}.
   * <ul>
   *   <li>Given {@link Card#Card(Element, FormatEnum)} with parent is
   * {@link Bold#Bold(Element)} and format is {@code MESSAGEML}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CardHeader#validate()}
   */
  @Test
  public void testValidate_givenCardWithParentIsBoldAndFormatIsMessageml() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Card parent = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    parent.putOneIfPresent(new HashMap<>(), "Element \"%s\" can only be a child of the following elements: [%s]",
        "Element \"%s\" can only be a child of the following elements: [%s]");

    // Act
    (new CardHeader(parent, FormatEnum.MESSAGEML)).validate();
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
