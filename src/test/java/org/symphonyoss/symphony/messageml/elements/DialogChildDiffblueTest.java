package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   * Test Body {@link Body#Body(Element, FormatEnum)}.
   *
   * <p>Method under test: {@link Body#Body(Element, FormatEnum)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Footer#Footer(Element, FormatEnum)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Title#Title(Element, FormatEnum)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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

  /**
   * Test {@link DialogChild#validate()}.
   *
   * <ul>
   *   <li>Given {@link BulletList#BulletList(Element)} with parent is {@code null}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link DialogChild#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DialogChild.validate()"})
  public void testValidate_givenBulletListWithParentIsNull_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> new Body(parent, FormatEnum.MESSAGEML).validate());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Body body = new Body(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    body.addChild(new Bold(parent3));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(44L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Body body = new Body(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setPrintOffsets(true);

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(33L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Body body = new Body(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoIndent(true);

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(33L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML4() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Body body = new Body(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(31L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML5() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Body body = new Body(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    body.addChild(new Checkbox(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(77L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML6() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Body body = new Body(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    body.addChild(new Button(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(68L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML7() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Body body = new Body(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    body.addChild(new CardBody(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(65L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML8() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent2));
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);

    Body body = new Body(parent4, FormatEnum.MESSAGEML);
    body.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(57L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML9() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Body body = new Body(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    body.addChild(new CashTag(parent4, 1));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(97L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML10() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Body body = new Body(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    body.addChild(new Checkbox(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(72L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML11() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new Checkbox(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Body body = new Body(parent5, FormatEnum.MESSAGEML);
    body.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(90L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML12() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new Button(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Body body = new Body(parent5, FormatEnum.MESSAGEML);
    body.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(81L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML13() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CardBody(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Body body = new Body(parent5, FormatEnum.MESSAGEML);
    body.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(78L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML14() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CashTag(parent3, 1));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Body body = new Body(parent5, FormatEnum.MESSAGEML);
    body.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(110L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <ul>
   *   <li>When {@link XmlPrintStream#XmlPrintStream(OutputStream)} with outputStream is {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link DialogChild#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DialogChild.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML_whenXmlPrintStreamWithOutputStreamIsByteArrayOutputStream() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Body body = new Body(parent2, FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    body.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(33L, out.getOffset());
  }

  /**
   * Test {@link DialogChild#asMarkdown()}.
   *
   * <p>Method under test: {@link DialogChild#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node DialogChild.asMarkdown()"})
  public void testAsMarkdown() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new Body(parent2, FormatEnum.MESSAGEML).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof Paragraph);
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }
}
