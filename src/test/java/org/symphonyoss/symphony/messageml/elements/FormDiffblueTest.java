package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.commonmark.node.Node;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.FormNode;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class FormDiffblueTest {
  /**
   * Method under test: {@link Form#hasIdAttribute()}
   */
  @Test
  public void testHasIdAttribute() {
    // Arrange, Act and Assert
    assertTrue((new Form(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).hasIdAttribute());
  }

  /**
   * Method under test: {@link Form#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Form(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof FormNode);
    assertEquals("", ((FormNode) actualAsMarkdownResult).getText());
    assertEquals("\n   \n", ((FormNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals("\n   \n", ((FormNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Method under test: {@link Form#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Form form = new Form(parent, FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    form.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertTrue(getResult.getAttributes().isEmpty());
    assertTrue(form.getAttributes().isEmpty());
    assertEquals(Form.MESSAGEML_TAG, getResult.getName());
    assertSame(parent, form.getParent());
  }

  /**
   * Method under test:
   * {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    Form form = new Form(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(15L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    Form form = new Form(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    form.addChild(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(26L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    Form form = new Form(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    form.addChild(new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(59L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    Form form = new Form(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    form.addChild(new Button(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(50L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() {
    // Arrange
    Form form = new Form(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    form.addChild(new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(47L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML6() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    Form form = new Form(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    form.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(39L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML7() {
    // Arrange
    Form form = new Form(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    form.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(79L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML8() {
    // Arrange
    Form form = new Form(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(15L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML9() {
    // Arrange
    Form form = new Form(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(15L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML10() {
    // Arrange
    Form form = new Form(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(13L, out.getOffset());
  }

  /**
   * Method under test: {@link Form#Form(Element, FormatEnum)}
   */
  @Test
  public void testNewForm() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    Form actualForm = new Form(parent, FormatEnum.MESSAGEML);

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualForm.getFormat());
    assertTrue(actualForm.getChildren().isEmpty());
    assertTrue(actualForm.getAttributes().isEmpty());
    assertEquals(Form.MESSAGEML_TAG, actualForm.getMessageMLTag());
    assertEquals(Form.MESSAGEML_TAG, actualForm.getPresentationMLTag());
    assertSame(parent, actualForm.getParent());
  }
}
