package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayOutputStream;
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

public class ExpandableCardHeaderDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExpandableCardHeader#ExpandableCardHeader(Element, FormatEnum)}
   *   <li>{@link ExpandableCardHeader#getPresentationMLTag()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    ExpandableCardHeader actualExpandableCardHeader = new ExpandableCardHeader(parent, FormatEnum.MESSAGEML);
    String actualPresentationMLTag = actualExpandableCardHeader.getPresentationMLTag();

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualExpandableCardHeader.getFormat());
    assertTrue(actualExpandableCardHeader.getChildren().isEmpty());
    assertTrue(actualExpandableCardHeader.getAttributes().isEmpty());
    assertEquals(Div.MESSAGEML_TAG, actualPresentationMLTag);
    assertEquals(ExpandableCardHeader.MESSAGEML_TAG, actualExpandableCardHeader.getMessageMLTag());
    assertSame(parent, actualExpandableCardHeader.getParent());
  }

  /**
   * Test {@link ExpandableCardHeader#buildAttribute(MessageMLParser, Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ExpandableCardHeader#buildAttribute(MessageMLParser, Node)}
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
    //       at org.symphonyoss.symphony.messageml.elements.ExpandableCardHeader.buildAttribute(ExpandableCardHeader.java:47)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    ExpandableCardHeader expandableCardHeader = new ExpandableCardHeader(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    expandableCardHeader.buildAttribute(parser, new IIOMetadataNode("foo"));
  }

  /**
   * Test
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    ExpandableCardHeader expandableCardHeader = new ExpandableCardHeader(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(42L, out.getOffset());
  }

  /**
   * Test
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    ExpandableCardHeader expandableCardHeader = new ExpandableCardHeader(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    expandableCardHeader.addChild(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(53L, out.getOffset());
  }

  /**
   * Test
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    ExpandableCardHeader expandableCardHeader = new ExpandableCardHeader(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    expandableCardHeader.addChild(new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(86L, out.getOffset());
  }

  /**
   * Test
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    ExpandableCardHeader expandableCardHeader = new ExpandableCardHeader(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    expandableCardHeader.addChild(new Button(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(77L, out.getOffset());
  }

  /**
   * Test
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() {
    // Arrange
    ExpandableCardHeader expandableCardHeader = new ExpandableCardHeader(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    expandableCardHeader.addChild(new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(74L, out.getOffset());
  }

  /**
   * Test
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML6() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    ExpandableCardHeader expandableCardHeader = new ExpandableCardHeader(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    expandableCardHeader.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(66L, out.getOffset());
  }

  /**
   * Test
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML7() {
    // Arrange
    ExpandableCardHeader expandableCardHeader = new ExpandableCardHeader(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    expandableCardHeader.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(106L, out.getOffset());
  }

  /**
   * Test
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML8() {
    // Arrange
    ExpandableCardHeader expandableCardHeader = new ExpandableCardHeader(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(42L, out.getOffset());
  }

  /**
   * Test
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML9() {
    // Arrange
    ExpandableCardHeader expandableCardHeader = new ExpandableCardHeader(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(42L, out.getOffset());
  }

  /**
   * Test
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCardHeader#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML10() {
    // Arrange
    ExpandableCardHeader expandableCardHeader = new ExpandableCardHeader(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    expandableCardHeader.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(40L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardHeader#asMarkdown()}.
   * <p>
   * Method under test: {@link ExpandableCardHeader#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new ExpandableCardHeader(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML)).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof Paragraph);
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link ExpandableCardHeader#validate()}.
   * <p>
   * Method under test: {@link ExpandableCardHeader#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Element "header" can only be a child of the following elements: [expandablecard]
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertParent(Element.java:741)
    //       at org.symphonyoss.symphony.messageml.elements.ExpandableCardHeader.validate(ExpandableCardHeader.java:69)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new ExpandableCardHeader(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).validate();
  }
}
