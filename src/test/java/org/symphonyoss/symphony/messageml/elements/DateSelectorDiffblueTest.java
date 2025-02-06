package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.junit.Ignore;
import org.junit.Test;
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
import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;

public class DateSelectorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DateSelector#DateSelector(Element, FormatEnum)}
   *   <li>{@link DateSelector#getPresentationMLTag()}
   * </ul>
   */
  @Test
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
   * <p>
   * Method under test:
   * {@link DateSelector#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll() throws InvalidInputException, ProcessingException {
    // Arrange
    DateSelector dateSelector = new DateSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(new BiContext());

    // Act
    dateSelector.buildAll(parser, new IIOMetadataNode("foo"));

    // Assert that nothing has changed
    verify(parser).getBiContext();
    assertEquals(0, dateSelector.size());
    assertTrue(dateSelector.getChildren().isEmpty());
  }

  /**
   * Test {@link DateSelector#buildAll(MessageMLParser, Element)}.
   * <p>
   * Method under test:
   * {@link DateSelector#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll2() throws InvalidInputException, ProcessingException {
    // Arrange
    DateSelector dateSelector = new DateSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any())).thenReturn(bold);
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode(MessageML.MESSAGEML_TAG));

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
   * <ul>
   *   <li>When {@link MessageMLParser}
   * {@link MessageMLParser#createElement(Element, Element)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DateSelector#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll_whenMessageMLParserCreateElementReturnNull()
      throws InvalidInputException, ProcessingException {
    // Arrange
    DateSelector dateSelector = new DateSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any())).thenReturn(null);
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode(MessageML.MESSAGEML_TAG));

    // Act
    dateSelector.buildAll(parser, element);

    // Assert that nothing has changed
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
    verify(parser).getBiContext();
    assertEquals(0, dateSelector.size());
    assertTrue(dateSelector.getChildren().isEmpty());
  }

  /**
   * Test {@link DateSelector#validate()}.
   * <p>
   * Method under test: {@link DateSelector#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Element "date-selector" can only be a inner child of the following elements: [form]
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertParentAtAnyLevel(Element.java:758)
    //       at org.symphonyoss.symphony.messageml.elements.FormElement.validate(FormElement.java:24)
    //       at org.symphonyoss.symphony.messageml.elements.DateSelector.validate(DateSelector.java:61)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new DateSelector(new Bold(new BulletList(null)), FormatEnum.MESSAGEML)).validate();
  }

  /**
   * Test {@link DateSelector#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link DateSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    DateSelector dateSelector = new DateSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    dateSelector.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(46L, out.getOffset());
  }

  /**
   * Test {@link DateSelector#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link DateSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    DateSelector dateSelector = new DateSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    dateSelector.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(46L, out.getOffset());
  }

  /**
   * Test {@link DateSelector#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link DateSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    DateSelector dateSelector = new DateSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    dateSelector.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(43L, out.getOffset());
  }

  /**
   * Test {@link DateSelector#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <ul>
   *   <li>When {@link XmlPrintStream#XmlPrintStream(OutputStream)} with
   * outputStream is
   * {@link ByteArrayOutputStream#ByteArrayOutputStream(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DateSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML_whenXmlPrintStreamWithOutputStreamIsByteArrayOutputStream() {
    // Arrange
    DateSelector dateSelector = new DateSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    dateSelector.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(46L, out.getOffset());
  }

  /**
   * Test {@link DateSelector#asMarkdown()}.
   * <p>
   * Method under test: {@link DateSelector#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new DateSelector(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML)).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof DateSelectorNode);
    assertEquals("", ((DateSelectorNode) actualAsMarkdownResult).getText());
    assertEquals("(Date Selector", ((DateSelectorNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals(")", ((DateSelectorNode) actualAsMarkdownResult).getClosingDelimiter());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link DateSelector#buildAttribute(MessageMLParser, Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateSelector#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Attribute "foo" is not allowed in "date-selector"
    //       at org.symphonyoss.symphony.messageml.elements.Element.throwInvalidInputException(Element.java:1071)
    //       at org.symphonyoss.symphony.messageml.elements.DateSelector.buildAttribute(DateSelector.java:99)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    DateSelector dateSelector = new DateSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    dateSelector.buildAttribute(parser, new IIOMetadataNode("foo"));
  }

  /**
   * Test {@link DateSelector#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateSelector#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsSizeIsOne() {
    // Arrange
    DateSelector dateSelector = new DateSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
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

  /**
   * Test {@link DateSelector#buildElementFromDiv(MessageMLParser, Element)}.
   * <ul>
   *   <li>Then calls {@link org.w3c.dom.Element#getAttribute(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DateSelector#buildElementFromDiv(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildElementFromDiv_thenCallsGetAttribute()
      throws InvalidInputException, ProcessingException, DOMException {
    // Arrange
    DateSelector dateSelector = new DateSelector(new Bold(new BulletList(null)), FormatEnum.MESSAGEML);
    NamedNodeMap namedNodeMap = mock(NamedNodeMap.class);
    when(namedNodeMap.getLength()).thenReturn(-1);
    org.w3c.dom.Element element = mock(org.w3c.dom.Element.class);
    when(element.getChildNodes()).thenReturn(new IIOMetadataNode("foo"));
    when(element.hasAttribute(Mockito.<String>any())).thenReturn(true);
    when(element.getAttribute(Mockito.<String>any())).thenReturn("Attribute");
    when(element.getAttributes()).thenReturn(namedNodeMap);
    doNothing().when(element).removeAttribute(Mockito.<String>any());
    doNothing().when(element).setAttribute(Mockito.<String>any(), Mockito.<String>any());

    // Act
    dateSelector.buildElementFromDiv(null, element);

    // Assert
    verify(element, atLeast(1)).getAttribute(Mockito.<String>any());
    verify(element, atLeast(1)).hasAttribute(Mockito.<String>any());
    verify(element, atLeast(1)).removeAttribute(Mockito.<String>any());
    verify(element, atLeast(1)).setAttribute(Mockito.<String>any(), eq("Attribute"));
    verify(namedNodeMap).getLength();
    verify(element).getAttributes();
    verify(element).getChildNodes();
  }
}
