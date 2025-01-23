package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayOutputStream;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

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
}
