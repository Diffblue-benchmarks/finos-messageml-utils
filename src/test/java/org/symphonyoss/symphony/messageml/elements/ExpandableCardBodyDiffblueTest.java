package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import org.commonmark.node.Node;
import org.commonmark.node.Paragraph;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class ExpandableCardBodyDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExpandableCardBody#ExpandableCardBody(Element, FormatEnum)}
   *   <li>{@link ExpandableCardBody#getPresentationMLTag()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExpandableCardBody.<init>(Element, FormatEnum)",
      "String ExpandableCardBody.getPresentationMLTag()"})
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    ExpandableCardBody actualExpandableCardBody = new ExpandableCardBody(parent, FormatEnum.MESSAGEML);
    String actualPresentationMLTag = actualExpandableCardBody.getPresentationMLTag();

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualExpandableCardBody.getFormat());
    assertTrue(actualExpandableCardBody.getChildren().isEmpty());
    assertTrue(actualExpandableCardBody.getAttributes().isEmpty());
    assertEquals(Div.MESSAGEML_TAG, actualPresentationMLTag);
    assertEquals(ExpandableCardBody.MESSAGEML_TAG, actualExpandableCardBody.getMessageMLTag());
    assertSame(parent, actualExpandableCardBody.getParent());
  }

  /**
   * Test {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExpandableCardBody.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() {
    // Arrange
    ExpandableCardBody expandableCardBody = new ExpandableCardBody(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(40L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExpandableCardBody.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() {
    // Arrange
    ExpandableCardBody expandableCardBody = new ExpandableCardBody(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    expandableCardBody.addChild(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(51L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExpandableCardBody.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() {
    // Arrange
    ExpandableCardBody expandableCardBody = new ExpandableCardBody(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    expandableCardBody.addChild(new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(84L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExpandableCardBody.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML4() {
    // Arrange
    ExpandableCardBody expandableCardBody = new ExpandableCardBody(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    expandableCardBody.addChild(new Button(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(75L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExpandableCardBody.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML5() {
    // Arrange
    ExpandableCardBody expandableCardBody = new ExpandableCardBody(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    expandableCardBody.addChild(new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(72L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExpandableCardBody.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML6() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    ExpandableCardBody expandableCardBody = new ExpandableCardBody(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    expandableCardBody.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(64L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExpandableCardBody.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML7() {
    // Arrange
    ExpandableCardBody expandableCardBody = new ExpandableCardBody(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    expandableCardBody.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    expandableCardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(104L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExpandableCardBody.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML8() {
    // Arrange
    ExpandableCardBody expandableCardBody = new ExpandableCardBody(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    expandableCardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(40L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExpandableCardBody.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML9() {
    // Arrange
    ExpandableCardBody expandableCardBody = new ExpandableCardBody(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    expandableCardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(40L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link ExpandableCardBody#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExpandableCardBody.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML10() {
    // Arrange
    ExpandableCardBody expandableCardBody = new ExpandableCardBody(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    expandableCardBody.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(38L, out.getOffset());
  }

  /**
   * Test {@link ExpandableCardBody#asMarkdown()}.
   * <p>
   * Method under test: {@link ExpandableCardBody#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node ExpandableCardBody.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new ExpandableCardBody(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML)).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof Paragraph);
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }
}
