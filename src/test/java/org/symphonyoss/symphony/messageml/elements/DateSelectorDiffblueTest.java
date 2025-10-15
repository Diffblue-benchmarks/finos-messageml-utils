package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.exceptions.ProcessingException;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.DateSelectorNode;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class DateSelectorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DateSelector#DateSelector(Element, FormatEnum)}
   *   <li>{@link DateSelector#getPresentationMLTag()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DateSelector.<init>(Element, FormatEnum)",
    "String DateSelector.getPresentationMLTag()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    DateSelector actualDateSelector = new DateSelector(parent, FormatEnum.MESSAGEML);
    String actualPresentationMLTag = actualDateSelector.getPresentationMLTag();

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualDateSelector.getFormat());
    assertTrue(actualDateSelector.getChildren().isEmpty());
    assertTrue(actualDateSelector.getAttributes().isEmpty());
    assertEquals(DateSelector.MESSAGEML_TAG, actualDateSelector.getMessageMLTag());
    assertEquals(Div.MESSAGEML_TAG, actualPresentationMLTag);
    assertSame(parent, actualDateSelector.getParent());
  }

  /**
   * Test {@link DateSelector#buildAll(MessageMLParser, Element)}.
   *
   * <p>Method under test: {@link DateSelector#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateSelector.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll() throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DateSelector dateSelector = new DateSelector(parent2, FormatEnum.MESSAGEML);

    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(new BiContext());

    // Act
    dateSelector.buildAll(parser, new IIOMetadataNode());

    // Assert that nothing has changed
    verify(parser).getBiContext();
    assertEquals(0, dateSelector.size());
    assertTrue(dateSelector.getChildren().isEmpty());
  }

  /**
   * Test {@link DateSelector#buildAll(MessageMLParser, Element)}.
   *
   * <p>Method under test: {@link DateSelector#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateSelector.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll2() throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DateSelector dateSelector = new DateSelector(parent2, FormatEnum.MESSAGEML);

    MessageMLParser parser = mock(MessageMLParser.class);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold bold = new Bold(parent3);
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any()))
        .thenReturn(bold);
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode();
    element.appendChild(new IIOMetadataNode());

    // Act
    dateSelector.buildAll(parser, element);

    // Assert
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
    verify(parser, atLeast(1)).getBiContext();
    List<Element> children = dateSelector.getChildren();
    assertEquals(1, children.size());
    assertEquals(1, dateSelector.size());
    assertSame(bold, children.get(0));
  }

  /**
   * Test {@link DateSelector#buildAll(MessageMLParser, Element)}.
   *
   * <ul>
   *   <li>Given {@link Code#Code(Element, String)} with parent is {@link Element} and language is
   *       {@code en}.
   *   <li>Then calls {@link MessageMLParser#clearBiContext()}.
   * </ul>
   *
   * <p>Method under test: {@link DateSelector#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateSelector.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll_givenCodeWithParentIsElementAndLanguageIsEn_thenCallsClearBiContext()
      throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DateSelector dateSelector = new DateSelector(parent2, FormatEnum.MESSAGEML);

    MessageMLParser parser = mock(MessageMLParser.class);
    doNothing().when(parser).clearBiContext();
    Code parent3 = new Code(mock(Element.class), "en");
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any()))
        .thenReturn(new BulletList(new Bold(parent3)));
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode();
    element.appendChild(new IIOMetadataNode());

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> dateSelector.buildAll(parser, element));
    verify(parser).clearBiContext();
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
    verify(parser).getBiContext();
  }

  /**
   * Test {@link DateSelector#buildAll(MessageMLParser, Element)}.
   *
   * <ul>
   *   <li>Given {@link InvalidInputException#InvalidInputException(String)} with message is {@code
   *       An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link DateSelector#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateSelector.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll_givenInvalidInputExceptionWithMessageIsAnErrorOccurred()
      throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DateSelector dateSelector = new DateSelector(parent2, FormatEnum.MESSAGEML);

    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any()))
        .thenThrow(new InvalidInputException("An error occurred"));

    IIOMetadataNode element = new IIOMetadataNode();
    element.appendChild(new IIOMetadataNode());

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> dateSelector.buildAll(parser, element));
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
  }

  /**
   * Test {@link DateSelector#validate()}.
   *
   * <p>Method under test: {@link DateSelector#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateSelector.validate()"})
  public void testValidate() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> new DateSelector(parent, FormatEnum.MESSAGEML).validate());
  }

  /**
   * Test {@link DateSelector#validate()}.
   *
   * <ul>
   *   <li>Then calls {@link Checkbox#getParent()}.
   * </ul>
   *
   * <p>Method under test: {@link DateSelector#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateSelector.validate()"})
  public void testValidate_thenCallsGetParent() throws InvalidInputException {
    // Arrange
    Checkbox parent = mock(Checkbox.class);
    when(parent.getParent()).thenReturn(new Bold(new BulletList(null)));
    BulletList parent2 = new BulletList(parent);
    Bold parent3 = new Bold(parent2);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> new DateSelector(parent3, FormatEnum.MESSAGEML).validate());
    verify(parent, atLeast(1)).getParent();
  }

  /**
   * Test {@link DateSelector#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DateSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateSelector.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DateSelector dateSelector = new DateSelector(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setPrintOffsets(true);

    // Act
    dateSelector.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(46L, out.getOffset());
  }

  /**
   * Test {@link DateSelector#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DateSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateSelector.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DateSelector dateSelector = new DateSelector(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoIndent(true);

    // Act
    dateSelector.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(46L, out.getOffset());
  }

  /**
   * Test {@link DateSelector#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DateSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateSelector.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DateSelector dateSelector = new DateSelector(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    dateSelector.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(43L, out.getOffset());
  }

  /**
   * Test {@link DateSelector#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <ul>
   *   <li>When {@link XmlPrintStream#XmlPrintStream(OutputStream)} with outputStream is {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link DateSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateSelector.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML_whenXmlPrintStreamWithOutputStreamIsByteArrayOutputStream() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DateSelector dateSelector = new DateSelector(parent2, FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    dateSelector.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(46L, out.getOffset());
  }

  /**
   * Test {@link DateSelector#asMarkdown()}.
   *
   * <p>Method under test: {@link DateSelector#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node DateSelector.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new DateSelector(parent2, FormatEnum.MESSAGEML).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof DateSelectorNode);
    assertEquals("", ((DateSelectorNode) actualAsMarkdownResult).getText());
    assertEquals(
        "(Date Selector", ((DateSelectorNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals(")", ((DateSelectorNode) actualAsMarkdownResult).getClosingDelimiter());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link DateSelector#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link DateSelector#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateSelector.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DateSelector dateSelector = new DateSelector(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> dateSelector.buildAttribute(parser, new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link DateSelector#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>When {@link BiContext} (default constructor).
   *   <li>Then {@link BiContext} (default constructor) Items size is one.
   * </ul>
   *
   * <p>Method under test: {@link DateSelector#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateSelector.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsSizeIsOne() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DateSelector dateSelector = new DateSelector(parent2, FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    dateSelector.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("dateselector", getResult.getName());
    assertTrue(getResult.getAttributes().isEmpty());
  }
}
