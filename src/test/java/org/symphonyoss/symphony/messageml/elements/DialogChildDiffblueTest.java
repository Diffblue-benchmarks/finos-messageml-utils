package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayOutputStream;
import org.commonmark.node.Node;
import org.commonmark.node.Paragraph;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.elements.DialogChild.Body;
import org.symphonyoss.symphony.messageml.elements.DialogChild.Footer;
import org.symphonyoss.symphony.messageml.elements.DialogChild.Title;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class DialogChildDiffblueTest {
  /**
   * Test Body {@link Body#Body(Element, FormatEnum)}.
   * <p>
   * Method under test: {@link DialogChild.Body#Body(Element, FormatEnum)}
   */
  @Test
  public void testBodyNewBody() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    DialogChild.Body actualBody = new DialogChild.Body(parent, FormatEnum.MESSAGEML);

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualBody.getFormat());
    assertTrue(actualBody.getChildren().isEmpty());
    assertTrue(actualBody.getAttributes().isEmpty());
    assertEquals(DialogChild.Body.MESSAGEML_TAG, actualBody.getMessageMLTag());
    assertEquals(DialogChild.Body.MESSAGEML_TAG, actualBody.getPresentationMLTag());
    assertSame(parent, actualBody.getParent());
  }

  /**
   * Test Footer {@link Footer#Footer(Element, FormatEnum)}.
   * <p>
   * Method under test: {@link DialogChild.Footer#Footer(Element, FormatEnum)}
   */
  @Test
  public void testFooterNewFooter() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    DialogChild.Footer actualFooter = new DialogChild.Footer(parent, FormatEnum.MESSAGEML);

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualFooter.getFormat());
    assertTrue(actualFooter.getChildren().isEmpty());
    assertTrue(actualFooter.getAttributes().isEmpty());
    assertEquals(DialogChild.Footer.MESSAGEML_TAG, actualFooter.getMessageMLTag());
    assertEquals(DialogChild.Footer.MESSAGEML_TAG, actualFooter.getPresentationMLTag());
    assertSame(parent, actualFooter.getParent());
  }

  /**
   * Test Title {@link Title#Title(Element, FormatEnum)}.
   * <p>
   * Method under test: {@link DialogChild.Title#Title(Element, FormatEnum)}
   */
  @Test
  public void testTitleNewTitle() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    DialogChild.Title actualTitle = new DialogChild.Title(parent, FormatEnum.MESSAGEML);

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualTitle.getFormat());
    assertTrue(actualTitle.getChildren().isEmpty());
    assertTrue(actualTitle.getAttributes().isEmpty());
    assertEquals(DialogChild.Title.MESSAGEML_TAG, actualTitle.getMessageMLTag());
    assertEquals(DialogChild.Title.MESSAGEML_TAG, actualTitle.getPresentationMLTag());
    assertSame(parent, actualTitle.getParent());
  }

  /**
   * Test {@link DialogChild#validate()}.
   * <ul>
   *   <li>Given {@link BulletList#BulletList(Element)} with parent is
   * {@link Element}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DialogChild#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate_givenBulletListWithParentIsElement() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Element "body" can only be a child of the following elements: [dialog]
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertParent(Element.java:741)
    //       at org.symphonyoss.symphony.messageml.elements.DialogChild.validate(DialogChild.java:64)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new DialogChild.Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).validate();
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    DialogChild.Body body = new DialogChild.Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(33L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    DialogChild.Body body = new DialogChild.Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
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
   * Method under test:
   * {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    DialogChild.Body body = new DialogChild.Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
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
   * Method under test:
   * {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    DialogChild.Body body = new DialogChild.Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
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
   * Method under test:
   * {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() {
    // Arrange
    DialogChild.Body body = new DialogChild.Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
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
   * Method under test:
   * {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML6() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    DialogChild.Body body = new DialogChild.Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
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
   * Method under test:
   * {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML7() {
    // Arrange
    DialogChild.Body body = new DialogChild.Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
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
   * Method under test:
   * {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML8() {
    // Arrange
    DialogChild.Body body = new DialogChild.Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

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
   * Method under test:
   * {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML9() {
    // Arrange
    DialogChild.Body body = new DialogChild.Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

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
   * Method under test:
   * {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML10() {
    // Arrange
    DialogChild.Body body = new DialogChild.Body(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

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
  public void testAsMarkdown() throws InvalidInputException {
    // Arrange and Act
    Node actualAsMarkdownResult = (new DialogChild.Body(new Bold(new BulletList(mock(Element.class))),
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
