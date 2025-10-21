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
import org.symphonyoss.symphony.messageml.elements.DialogChild.Body;
import org.symphonyoss.symphony.messageml.elements.DialogChild.Footer;
import org.symphonyoss.symphony.messageml.elements.DialogChild.Title;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class DialogChildDiffblueTest {
  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() {
    // Arrange
    Body body = new Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(33L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() {
    // Arrange
    Body body = new Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    body.addChild(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(44L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() {
    // Arrange
    Body body = new Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    body.addChild(new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(77L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML4() {
    // Arrange
    Body body = new Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    body.addChild(new Button(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(68L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML5() {
    // Arrange
    Body body = new Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    body.addChild(new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(65L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML6() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    Body body = new Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    body.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(57L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML7() {
    // Arrange
    Body body = new Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    body.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(97L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML8() {
    // Arrange
    Body body = new Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(33L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML9() {
    // Arrange
    Body body = new Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(33L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML10() {
    // Arrange
    Body body = new Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(31L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asMarkdown()}.
   * <p>
   * Method under test: {@link DialogChild#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node DialogChild.asMarkdown()"})
  public void testAsMarkdown() throws InvalidInputException {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
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
   * Test Body {@link Body#Body(Element, FormatEnum)}.
   * <p>
   * Method under test: {@link Body#Body(Element, FormatEnum)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Body.<init>(Element, FormatEnum)"})
  public void testBodyNewBody() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    Body actualBody = new Body(parent, FormatEnum.MESSAGEML);

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualBody.getFormat());
    assertTrue(actualBody.getChildren().isEmpty());
    assertTrue(actualBody.getAttributes().isEmpty());
    assertEquals(Body.MESSAGEML_TAG, actualBody.getMessageMLTag());
    assertEquals(Body.MESSAGEML_TAG, actualBody.getPresentationMLTag());
    assertSame(parent, actualBody.getParent());
  }

  /**
   * Test Footer {@link Footer#Footer(Element, FormatEnum)}.
   * <p>
   * Method under test: {@link Footer#Footer(Element, FormatEnum)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Footer.<init>(Element, FormatEnum)"})
  public void testFooterNewFooter() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    Footer actualFooter = new Footer(parent, FormatEnum.MESSAGEML);

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualFooter.getFormat());
    assertTrue(actualFooter.getChildren().isEmpty());
    assertTrue(actualFooter.getAttributes().isEmpty());
    assertEquals(Footer.MESSAGEML_TAG, actualFooter.getMessageMLTag());
    assertEquals(Footer.MESSAGEML_TAG, actualFooter.getPresentationMLTag());
    assertSame(parent, actualFooter.getParent());
  }

  /**
   * Test Title {@link Title#Title(Element, FormatEnum)}.
   * <p>
   * Method under test: {@link Title#Title(Element, FormatEnum)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Title.<init>(Element, FormatEnum)"})
  public void testTitleNewTitle() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    Title actualTitle = new Title(parent, FormatEnum.MESSAGEML);

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualTitle.getFormat());
    assertTrue(actualTitle.getChildren().isEmpty());
    assertTrue(actualTitle.getAttributes().isEmpty());
    assertEquals(Title.MESSAGEML_TAG, actualTitle.getMessageMLTag());
    assertEquals(Title.MESSAGEML_TAG, actualTitle.getPresentationMLTag());
    assertSame(parent, actualTitle.getParent());
  }
}
