package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayOutputStream;
import org.commonmark.node.Node;
import org.commonmark.node.Paragraph;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class ExpandableCardHeaderDiffblueTest {
  /**
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
}
