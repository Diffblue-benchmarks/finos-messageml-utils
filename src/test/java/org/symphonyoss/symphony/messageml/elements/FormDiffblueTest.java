package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.FormNode;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class FormDiffblueTest {
  /**
   * Test {@link Form#Form(Element, FormatEnum)}.
   *
   * <p>Method under test: {@link Form#Form(Element, FormatEnum)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.<init>(Element, FormatEnum)"})
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

  /**
   * Test {@link Form#hasIdAttribute()}.
   *
   * <p>Method under test: {@link Form#hasIdAttribute()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean Form.hasIdAttribute()"})
  public void testHasIdAttribute() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertTrue(new Form(parent2, FormatEnum.MESSAGEML).hasIdAttribute());
  }

  /**
   * Test {@link Form#validate()}.
   *
   * <p>Method under test: {@link Form#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.validate()"})
  public void testValidate() throws InvalidInputException {
    // Arrange
    Checkbox parent = mock(Checkbox.class);
    when(parent.getParent()).thenReturn(new Bold(new BulletList(null)));
    BulletList parent2 = new BulletList(parent);
    Bold parent3 = new Bold(parent2);

    Form form = new Form(parent3, FormatEnum.MESSAGEML);
    form.addChild(new Bold(new BulletList(null)));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> form.validate());
    verify(parent, atLeast(1)).getParent();
  }

  /**
   * Test {@link Form#validate()}.
   *
   * <p>Method under test: {@link Form#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.validate()"})
  public void testValidate2() throws InvalidInputException {
    // Arrange
    Checkbox parent = mock(Checkbox.class);
    when(parent.getParent()).thenReturn(new Bold(new BulletList(null)));
    BulletList parent2 = new BulletList(parent);
    Bold parent3 = new Bold(parent2);

    Form form = new Form(parent3, FormatEnum.MESSAGEML);
    Bold parent4 = new Bold(new BulletList(null));
    form.addChild(new Checkbox(parent4, FormatEnum.MESSAGEML));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> form.validate());
    verify(parent, atLeast(1)).getParent();
  }

  /**
   * Test {@link Form#validate()}.
   *
   * <ul>
   *   <li>Given {@link Checkbox} {@link Checkbox#getChildren()} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then calls {@link Checkbox#getChildren()}.
   * </ul>
   *
   * <p>Method under test: {@link Form#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.validate()"})
  public void testValidate_givenCheckboxGetChildrenReturnArrayList_thenCallsGetChildren()
      throws InvalidInputException {
    // Arrange
    Checkbox parent = mock(Checkbox.class);
    when(parent.getParent()).thenReturn(new Bold(new BulletList(null)));
    BulletList parent2 = new BulletList(parent);
    Bold parent3 = new Bold(parent2);

    Checkbox child = mock(Checkbox.class);
    when(child.getChildren()).thenReturn(new ArrayList<>());

    Form form = new Form(parent3, FormatEnum.MESSAGEML);
    form.addChild(child);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> form.validate());
    verify(child, atLeast(1)).getChildren();
    verify(parent, atLeast(1)).getParent();
  }

  /**
   * Test {@link Form#validate()}.
   *
   * <ul>
   *   <li>Given {@link Form#Form(Element, FormatEnum)} with parent is {@link Bold#Bold(Element)}
   *       and format is {@code MESSAGEML}.
   * </ul>
   *
   * <p>Method under test: {@link Form#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.validate()"})
  public void testValidate_givenFormWithParentIsBoldAndFormatIsMessageml()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> new Form(parent, FormatEnum.MESSAGEML).validate());
  }

  /**
   * Test {@link Form#validate()}.
   *
   * <ul>
   *   <li>Given {@link Form#Form(Element, FormatEnum)} with parent is {@link Bold#Bold(Element)}
   *       and format is {@code MESSAGEML}.
   *   <li>Then calls {@link Checkbox#getParent()}.
   * </ul>
   *
   * <p>Method under test: {@link Form#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.validate()"})
  public void testValidate_givenFormWithParentIsBoldAndFormatIsMessageml_thenCallsGetParent()
      throws InvalidInputException {
    // Arrange
    Checkbox parent = mock(Checkbox.class);
    when(parent.getParent()).thenReturn(new Bold(new BulletList(null)));
    BulletList parent2 = new BulletList(parent);
    Bold parent3 = new Bold(parent2);

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> new Form(parent3, FormatEnum.MESSAGEML).validate());
    verify(parent, atLeast(1)).getParent();
  }

  /**
   * Test {@link Form#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Form#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Form form = new Form(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> form.buildAttribute(parser, new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link Form#asMarkdown()}.
   *
   * <p>Method under test: {@link Form#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Form.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new Form(parent2, FormatEnum.MESSAGEML).asMarkdown();

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
   * Test {@link Form#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>When {@link BiContext} (default constructor).
   *   <li>Then {@link BiContext} (default constructor) Items size is one.
   * </ul>
   *
   * <p>Method under test: {@link Form#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsSizeIsOne() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Form form = new Form(parent2, FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    form.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertTrue(getResult.getAttributes().isEmpty());
    assertEquals(Form.MESSAGEML_TAG, getResult.getName());
  }

  /**
   * Test {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Form form = new Form(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    form.addChild(new Bold(parent3));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(26L, out.getOffset());
  }

  /**
   * Test {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Form form = new Form(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setPrintOffsets(true);

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(15L, out.getOffset());
  }

  /**
   * Test {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Form form = new Form(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoIndent(true);

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(15L, out.getOffset());
  }

  /**
   * Test {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML4() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Form form = new Form(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(13L, out.getOffset());
  }

  /**
   * Test {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML5() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Form form = new Form(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    form.addChild(new Checkbox(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(59L, out.getOffset());
  }

  /**
   * Test {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML6() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Form form = new Form(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    form.addChild(new Button(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(50L, out.getOffset());
  }

  /**
   * Test {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML7() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Form form = new Form(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    form.addChild(new CardBody(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(47L, out.getOffset());
  }

  /**
   * Test {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML8() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent2));
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);

    Form form = new Form(parent4, FormatEnum.MESSAGEML);
    form.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(39L, out.getOffset());
  }

  /**
   * Test {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML9() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Form form = new Form(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    form.addChild(new CashTag(parent4, 1));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(79L, out.getOffset());
  }

  /**
   * Test {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML10() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Form form = new Form(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    form.addChild(new Checkbox(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(54L, out.getOffset());
  }

  /**
   * Test {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML11() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new Checkbox(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Form form = new Form(parent5, FormatEnum.MESSAGEML);
    form.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(72L, out.getOffset());
  }

  /**
   * Test {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML12() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new Button(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Form form = new Form(parent5, FormatEnum.MESSAGEML);
    form.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(63L, out.getOffset());
  }

  /**
   * Test {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML13() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CardBody(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Form form = new Form(parent5, FormatEnum.MESSAGEML);
    form.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(60L, out.getOffset());
  }

  /**
   * Test {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML14() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CashTag(parent3, 1));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Form form = new Form(parent5, FormatEnum.MESSAGEML);
    form.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(92L, out.getOffset());
  }

  /**
   * Test {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <ul>
   *   <li>When {@link XmlPrintStream#XmlPrintStream(OutputStream)} with outputStream is {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link Form#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Form.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML_whenXmlPrintStreamWithOutputStreamIsByteArrayOutputStream() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Form form = new Form(parent2, FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    form.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(15L, out.getOffset());
  }
}
