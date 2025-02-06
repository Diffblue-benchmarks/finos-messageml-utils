package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
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

public class CardBodyDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CardBody#CardBody(Element, FormatEnum)}
   *   <li>{@link CardBody#getPresentationMLTag()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    CardBody actualCardBody = new CardBody(parent, FormatEnum.MESSAGEML);
    String actualPresentationMLTag = actualCardBody.getPresentationMLTag();

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualCardBody.getFormat());
    assertTrue(actualCardBody.getChildren().isEmpty());
    assertTrue(actualCardBody.getAttributes().isEmpty());
    assertEquals(CardBody.MESSAGEML_TAG, actualCardBody.getMessageMLTag());
    assertEquals(Div.MESSAGEML_TAG, actualPresentationMLTag);
    assertSame(parent, actualCardBody.getParent());
  }

  /**
   * Test {@link CardBody#buildAttribute(MessageMLParser, Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CardBody#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Attribute "foo" is not allowed in "body"
    //       at org.symphonyoss.symphony.messageml.elements.Element.throwInvalidInputException(Element.java:1071)
    //       at org.symphonyoss.symphony.messageml.elements.CardBody.buildAttribute(CardBody.java:46)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    CardBody cardBody = new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    cardBody.buildAttribute(parser, new IIOMetadataNode("foo"));
  }
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAttribute_whenIIOMetadataNodeWithFooMANUAL() throws InvalidInputException {
    // Arrange
    CardBody cardBody = new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    assertThrows(InvalidInputException.class, () -> cardBody.buildAttribute(parser, new IIOMetadataNode("foo")));
  }
  /**
   * Test {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    CardBody cardBody = new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(30L, out.getOffset());
  }

  /**
   * Test {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    CardBody cardBody = new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    cardBody.addChild(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(41L, out.getOffset());
  }

  /**
   * Test {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    CardBody cardBody = new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    cardBody.addChild(new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(74L, out.getOffset());
  }

  /**
   * Test {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    CardBody cardBody = new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    cardBody.addChild(new Button(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(65L, out.getOffset());
  }

  /**
   * Test {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() {
    // Arrange
    CardBody cardBody = new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    cardBody.addChild(new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(62L, out.getOffset());
  }

  /**
   * Test {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML6() {
    // Arrange
    CardBody cardBody = new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    cardBody.addChild(new CardHeader(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(64L, out.getOffset());
  }

  /**
   * Test {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML7() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    CardBody cardBody = new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    cardBody.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(54L, out.getOffset());
  }

  /**
   * Test {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML8() {
    // Arrange
    CardBody cardBody = new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    cardBody.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(94L, out.getOffset());
  }

  /**
   * Test {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML9() {
    // Arrange
    CardBody cardBody = new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    cardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(30L, out.getOffset());
  }

  /**
   * Test {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML10() {
    // Arrange
    CardBody cardBody = new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    cardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(30L, out.getOffset());
  }

  /**
   * Test {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link CardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML11() {
    // Arrange
    CardBody cardBody = new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    cardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(28L, out.getOffset());
  }

  /**
   * Test {@link CardBody#asMarkdown()}.
   * <p>
   * Method under test: {@link CardBody#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
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
   * Test {@link CardBody#validate()}.
   * <ul>
   *   <li>Given {@link CardBody#CardBody(Element, FormatEnum)} with parent is
   * {@link Bold#Bold(Element)} and format is {@code MESSAGEML}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CardBody#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate_givenCardBodyWithParentIsBoldAndFormatIsMessageml() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Element "body" can only be a child of the following elements: [card]
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertParent(Element.java:741)
    //       at org.symphonyoss.symphony.messageml.elements.CardBody.validate(CardBody.java:69)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).validate();
  }

  /**
   * Test {@link CardBody#validate()}.
   * <ul>
   *   <li>Given {@link Card#Card(Element, FormatEnum)} with parent is
   * {@link Bold#Bold(Element)} and format is {@code MESSAGEML}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CardBody#validate()}
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
    (new CardBody(parent, FormatEnum.MESSAGEML)).validate();
  }
}
