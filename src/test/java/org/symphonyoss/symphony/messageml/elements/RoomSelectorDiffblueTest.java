package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
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
import org.symphonyoss.symphony.messageml.markdown.nodes.form.RoomSelectorNode;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class RoomSelectorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RoomSelector#RoomSelector(Element, FormatEnum)}
   *   <li>{@link RoomSelector#getElementId()}
   *   <li>{@link RoomSelector#getPresentationMLTag()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    RoomSelector actualRoomSelector = new RoomSelector(parent, FormatEnum.MESSAGEML);
    String actualElementId = actualRoomSelector.getElementId();
    String actualPresentationMLTag = actualRoomSelector.getPresentationMLTag();

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualRoomSelector.getFormat());
    assertTrue(actualRoomSelector.getChildren().isEmpty());
    assertTrue(actualRoomSelector.getAttributes().isEmpty());
    assertEquals(Div.MESSAGEML_TAG, actualPresentationMLTag);
    assertEquals(RoomSelector.MESSAGEML_TAG, actualRoomSelector.getMessageMLTag());
    assertEquals(RoomSelector.MESSAGEML_TAG, actualElementId);
    assertSame(parent, actualRoomSelector.getParent());
  }

  /**
   * Test {@link RoomSelector#buildAll(MessageMLParser, Element)}.
   * <p>
   * Method under test:
   * {@link RoomSelector#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll() throws InvalidInputException, ProcessingException {
    // Arrange
    RoomSelector roomSelector = new RoomSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(new BiContext());

    // Act
    roomSelector.buildAll(parser, new IIOMetadataNode("foo"));

    // Assert that nothing has changed
    verify(parser).getBiContext();
    assertEquals(0, roomSelector.size());
    assertTrue(roomSelector.getChildren().isEmpty());
  }

  /**
   * Test {@link RoomSelector#buildAll(MessageMLParser, Element)}.
   * <p>
   * Method under test:
   * {@link RoomSelector#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll2() throws InvalidInputException, ProcessingException {
    // Arrange
    RoomSelector roomSelector = new RoomSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any())).thenReturn(bold);
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode(MessageML.MESSAGEML_TAG));

    // Act
    roomSelector.buildAll(parser, element);

    // Assert
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
    verify(parser, atLeast(1)).getBiContext();
    List<Element> children = roomSelector.getChildren();
    assertEquals(1, children.size());
    assertEquals(1, roomSelector.size());
    assertSame(bold, children.get(0));
  }

  /**
   * Test {@link RoomSelector#buildAll(MessageMLParser, Element)}.
   * <ul>
   *   <li>When {@link MessageMLParser}
   * {@link MessageMLParser#createElement(Element, Element)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RoomSelector#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll_whenMessageMLParserCreateElementReturnNull()
      throws InvalidInputException, ProcessingException {
    // Arrange
    RoomSelector roomSelector = new RoomSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any())).thenReturn(null);
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode(MessageML.MESSAGEML_TAG));

    // Act
    roomSelector.buildAll(parser, element);

    // Assert that nothing has changed
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
    verify(parser).getBiContext();
    assertEquals(0, roomSelector.size());
    assertTrue(roomSelector.getChildren().isEmpty());
  }

  /**
   * Test {@link RoomSelector#validate()}.
   * <p>
   * Method under test: {@link RoomSelector#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Element "room-selector" can only be a inner child of the following elements: [form]
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertParentAtAnyLevel(Element.java:758)
    //       at org.symphonyoss.symphony.messageml.elements.FormElement.validate(FormElement.java:24)
    //       at org.symphonyoss.symphony.messageml.elements.RoomSelector.validate(RoomSelector.java:78)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new RoomSelector(new Bold(new BulletList(null)), FormatEnum.MESSAGEML)).validate();
  }

  /**
   * Test {@link RoomSelector#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link RoomSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    RoomSelector roomSelector = new RoomSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    roomSelector.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(46L, out.getOffset());
  }

  /**
   * Test {@link RoomSelector#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link RoomSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    RoomSelector roomSelector = new RoomSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    roomSelector.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(46L, out.getOffset());
  }

  /**
   * Test {@link RoomSelector#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link RoomSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    RoomSelector roomSelector = new RoomSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    roomSelector.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(43L, out.getOffset());
  }

  /**
   * Test {@link RoomSelector#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <ul>
   *   <li>When {@link XmlPrintStream#XmlPrintStream(OutputStream)} with
   * outputStream is
   * {@link ByteArrayOutputStream#ByteArrayOutputStream(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RoomSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML_whenXmlPrintStreamWithOutputStreamIsByteArrayOutputStream() {
    // Arrange
    RoomSelector roomSelector = new RoomSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    roomSelector.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(46L, out.getOffset());
  }

  /**
   * Test {@link RoomSelector#asMarkdown()}.
   * <p>
   * Method under test: {@link RoomSelector#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new RoomSelector(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML)).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof RoomSelectorNode);
    assertEquals("", ((RoomSelectorNode) actualAsMarkdownResult).getText());
    assertEquals("(Room Selector", ((RoomSelectorNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals(")", ((RoomSelectorNode) actualAsMarkdownResult).getClosingDelimiter());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link RoomSelector#buildAttribute(MessageMLParser, Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoomSelector#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Attribute "foo" is not allowed in "room-selector"
    //       at org.symphonyoss.symphony.messageml.elements.Element.throwInvalidInputException(Element.java:1071)
    //       at org.symphonyoss.symphony.messageml.elements.RoomSelector.buildAttribute(RoomSelector.java:152)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    RoomSelector roomSelector = new RoomSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    roomSelector.buildAttribute(parser, new IIOMetadataNode("foo"));
  }

  /**
   * Test {@link RoomSelector#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoomSelector#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsSizeIsOne() {
    // Arrange
    RoomSelector roomSelector = new RoomSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    roomSelector.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("roomselector", getResult.getName());
    assertTrue(getResult.getAttributes().isEmpty());
  }
}
