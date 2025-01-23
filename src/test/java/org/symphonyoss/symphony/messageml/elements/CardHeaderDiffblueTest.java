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

public class CardHeaderDiffblueTest {
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
    assertEquals(67L, out.getOffset());
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
}
