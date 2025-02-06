package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayOutputStream;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;
import org.w3c.dom.Node;

public class ExpandableCardDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExpandableCard#ExpandableCard(Element, FormatEnum)}
   *   <li>{@link ExpandableCard#getPresentationMLTag()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    ExpandableCard actualExpandableCard = new ExpandableCard(parent, FormatEnum.MESSAGEML);
    String actualPresentationMLTag = actualExpandableCard.getPresentationMLTag();

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualExpandableCard.getFormat());
    assertTrue(actualExpandableCard.getChildren().isEmpty());
    assertTrue(actualExpandableCard.getAttributes().isEmpty());
    assertEquals(Div.MESSAGEML_TAG, actualPresentationMLTag);
    assertEquals(ExpandableCard.MESSAGEML_TAG, actualExpandableCard.getMessageMLTag());
    assertSame(parent, actualExpandableCard.getParent());
  }

  /**
   * Test {@link ExpandableCard#buildAttribute(MessageMLParser, Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ExpandableCard#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Attribute "foo" is not allowed in "expandable-card"
    //       at org.symphonyoss.symphony.messageml.elements.Element.throwInvalidInputException(Element.java:1071)
    //       at org.symphonyoss.symphony.messageml.elements.Element.buildAttribute(Element.java:256)
    //       at org.symphonyoss.symphony.messageml.elements.ExpandableCard.buildAttribute(ExpandableCard.java:63)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    ExpandableCard expandableCard = new ExpandableCard(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    expandableCard.buildAttribute(parser, new IIOMetadataNode("foo"));
  }

  /**
   * Test
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    ExpandableCard expandableCard = new ExpandableCard(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCard.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(37L, out.getOffset());
  }

  /**
   * Test
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    ExpandableCard expandableCard = new ExpandableCard(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    expandableCard.addChild(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCard.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(48L, out.getOffset());
  }

  /**
   * Test
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    ExpandableCard expandableCard = new ExpandableCard(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    expandableCard.addChild(new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCard.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(81L, out.getOffset());
  }

  /**
   * Test
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    ExpandableCard expandableCard = new ExpandableCard(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    expandableCard.addChild(new Button(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCard.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(72L, out.getOffset());
  }

  /**
   * Test
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() {
    // Arrange
    ExpandableCard expandableCard = new ExpandableCard(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    expandableCard.addChild(new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCard.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(69L, out.getOffset());
  }

  /**
   * Test
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML6() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    ExpandableCard expandableCard = new ExpandableCard(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    expandableCard.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCard.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(61L, out.getOffset());
  }

  /**
   * Test
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML7() {
    // Arrange
    ExpandableCard expandableCard = new ExpandableCard(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    expandableCard.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCard.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(101L, out.getOffset());
  }

  /**
   * Test
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML8() {
    // Arrange
    ExpandableCard expandableCard = new ExpandableCard(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    expandableCard.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(37L, out.getOffset());
  }

  /**
   * Test
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML9() {
    // Arrange
    ExpandableCard expandableCard = new ExpandableCard(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    expandableCard.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(37L, out.getOffset());
  }

  /**
   * Test
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link ExpandableCard#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML10() {
    // Arrange
    ExpandableCard expandableCard = new ExpandableCard(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    expandableCard.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(35L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCard#validate()}.
   * <p>
   * Method under test: {@link ExpandableCard#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: The attribute "state" is required
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertAttributeNotBlank(Element.java:619)
    //       at org.symphonyoss.symphony.messageml.elements.ExpandableCard.validate(ExpandableCard.java:98)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new ExpandableCard(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).validate();
  }

  /**
   * Test {@link ExpandableCard#updateBiContext(BiContext)}.
   * <p>
   * Method under test: {@link ExpandableCard#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    ExpandableCard expandableCard = new ExpandableCard(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);

    // Act
    expandableCard.updateBiContext(new BiContext());
  }
}
