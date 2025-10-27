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
   * Method under test:
   * {@link RoomSelector#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll() throws InvalidInputException, ProcessingException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    RoomSelector roomSelector = new RoomSelector(parent, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(new BiContext());

    // Act
    roomSelector.buildAll(parser, new IIOMetadataNode("foo"));

    // Assert
    verify(parser).getBiContext();
    assertEquals(0, roomSelector.size());
    assertTrue(roomSelector.getChildren().isEmpty());
    assertSame(parent, roomSelector.getParent());
  }

  /**
   * Method under test:
   * {@link RoomSelector#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll2() throws InvalidInputException, ProcessingException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    RoomSelector roomSelector = new RoomSelector(parent, FormatEnum.MESSAGEML);
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
    assertSame(parent, roomSelector.getParent());
  }

  /**
   * Method under test:
   * {@link RoomSelector#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll3() throws InvalidInputException, ProcessingException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    RoomSelector roomSelector = new RoomSelector(parent, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any())).thenReturn(null);
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode(MessageML.MESSAGEML_TAG));

    // Act
    roomSelector.buildAll(parser, element);

    // Assert
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
    verify(parser).getBiContext();
    assertEquals(0, roomSelector.size());
    assertTrue(roomSelector.getChildren().isEmpty());
    assertSame(parent, roomSelector.getParent());
  }

  /**
   * Method under test:
   * {@link RoomSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    RoomSelector roomSelector = new RoomSelector(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    roomSelector.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(46L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link RoomSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
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
   * Method under test:
   * {@link RoomSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
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
   * Method under test:
   * {@link RoomSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
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
   * Method under test: {@link RoomSelector#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    RoomSelector roomSelector = new RoomSelector(parent, FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    roomSelector.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("roomselector", getResult.getName());
    assertTrue(getResult.getAttributes().isEmpty());
    assertTrue(roomSelector.getAttributes().isEmpty());
    assertSame(parent, roomSelector.getParent());
  }

  /**
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
}
