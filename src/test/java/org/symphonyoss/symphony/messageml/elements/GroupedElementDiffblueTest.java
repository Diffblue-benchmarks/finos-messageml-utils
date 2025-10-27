package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.mockito.Mockito;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.exceptions.ProcessingException;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;
import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class GroupedElementDiffblueTest {
  /**
   * Method under test:
   * {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll() throws InvalidInputException, ProcessingException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Checkbox checkbox = new Checkbox(parent, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(new BiContext());

    // Act
    checkbox.buildAll(parser, new IIOMetadataNode("foo"));

    // Assert
    verify(parser).getBiContext();
    assertEquals(0, checkbox.size());
    assertTrue(checkbox.getChildren().isEmpty());
    assertSame(parent, checkbox.getParent());
  }

  /**
   * Method under test:
   * {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll2() throws InvalidInputException, ProcessingException {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.PRESENTATIONML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> checkbox.buildAll(parser, new IIOMetadataNode("foo")));
  }

  /**
   * Method under test:
   * {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll3() throws InvalidInputException, ProcessingException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Checkbox checkbox = new Checkbox(parent, FormatEnum.MESSAGEML);

    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem(MessageML.MESSAGEML_TAG, MessageML.MESSAGEML_TAG));
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(biContext);

    // Act
    checkbox.buildAll(parser, new IIOMetadataNode("foo"));

    // Assert
    verify(parser).getBiContext();
    assertEquals(0, checkbox.size());
    assertTrue(checkbox.getChildren().isEmpty());
    assertSame(parent, checkbox.getParent());
  }

  /**
   * Method under test:
   * {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll4() throws InvalidInputException, ProcessingException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Checkbox checkbox = new Checkbox(parent, FormatEnum.MESSAGEML);

    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem(MessageML.MESSAGEML_TAG, MessageML.MESSAGEML_TAG));
    biContext.addItem(new BiItem(MessageML.MESSAGEML_TAG, MessageML.MESSAGEML_TAG));
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(biContext);

    // Act
    checkbox.buildAll(parser, new IIOMetadataNode("foo"));

    // Assert
    verify(parser).getBiContext();
    assertEquals(0, checkbox.size());
    assertTrue(checkbox.getChildren().isEmpty());
    assertSame(parent, checkbox.getParent());
  }

  /**
   * Method under test:
   * {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll5() throws InvalidInputException, ProcessingException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Checkbox checkbox = new Checkbox(parent, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any())).thenReturn(bold);
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode(MessageML.MESSAGEML_TAG));

    // Act
    checkbox.buildAll(parser, element);

    // Assert
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
    verify(parser, atLeast(1)).getBiContext();
    List<Element> children = checkbox.getChildren();
    assertEquals(1, children.size());
    assertEquals(1, checkbox.size());
    assertSame(bold, children.get(0));
    assertSame(parent, checkbox.getParent());
  }

  /**
   * Method under test:
   * {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll6() throws InvalidInputException, ProcessingException {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.PRESENTATIONML);
    MessageMLParser parser = mock(MessageMLParser.class);

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode(MessageML.MESSAGEML_TAG));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> checkbox.buildAll(parser, element));
  }

  /**
   * Method under test:
   * {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll7() throws InvalidInputException, ProcessingException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Checkbox checkbox = new Checkbox(parent, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any())).thenReturn(null);
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode(MessageML.MESSAGEML_TAG));

    // Act
    checkbox.buildAll(parser, element);

    // Assert
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
    verify(parser).getBiContext();
    assertEquals(0, checkbox.size());
    assertTrue(checkbox.getChildren().isEmpty());
    assertSame(parent, checkbox.getParent());
  }

  /**
   * Method under test:
   * {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    checkbox.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(42L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    checkbox.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(42L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    checkbox.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(42L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    checkbox.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(40L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link GroupedElement#buildElementFromGroupDiv(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildElementFromGroupDiv() throws InvalidInputException, ProcessingException {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(InvalidInputException.class,
        () -> checkbox.buildElementFromGroupDiv(parser, new IIOMetadataNode("foo")));
  }

  /**
   * Method under test:
   * {@link GroupedElement#buildElementFromGroupDiv(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildElementFromGroupDiv2() throws InvalidInputException, ProcessingException {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode("Invalid PresentationML for the \"%s\" element"));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> checkbox.buildElementFromGroupDiv(parser, element));
  }

  /**
   * Method under test:
   * {@link GroupedElement#buildElementFromGroupDiv(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildElementFromGroupDiv3() throws InvalidInputException, ProcessingException {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode("foo"));
    element.appendChild(new IIOMetadataNode("Invalid PresentationML for the \"%s\" element"));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> checkbox.buildElementFromGroupDiv(parser, element));
  }

  /**
   * Method under test:
   * {@link GroupedElement#buildElementFromGroupDiv(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildElementFromGroupDiv4() throws InvalidInputException, ProcessingException {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode(""));
    element.appendChild(new IIOMetadataNode("Invalid PresentationML for the \"%s\" element"));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> checkbox.buildElementFromGroupDiv(parser, element));
  }

  /**
   * Method under test:
   * {@link GroupedElement#buildElementAttrFromInputTag(MessageMLParser, Node)}
   */
  @Test
  public void testBuildElementAttrFromInputTag() throws InvalidInputException, DOMException {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(null)), FormatEnum.MESSAGEML);
    NamedNodeMap namedNodeMap = mock(NamedNodeMap.class);
    when(namedNodeMap.getLength()).thenReturn(-1);
    when(namedNodeMap.removeNamedItem(Mockito.<String>any())).thenReturn(new IIOMetadataNode("foo"));
    Node inputElement = mock(Node.class);
    when(inputElement.getNextSibling()).thenReturn(new IIOMetadataNode("foo"));
    when(inputElement.getPreviousSibling()).thenReturn(new IIOMetadataNode("foo"));
    when(inputElement.getAttributes()).thenReturn(namedNodeMap);

    // Act
    checkbox.buildElementAttrFromInputTag(null, inputElement);

    // Assert
    verify(namedNodeMap).getLength();
    verify(namedNodeMap).removeNamedItem(eq("type"));
    verify(inputElement).getAttributes();
    verify(inputElement).getNextSibling();
    verify(inputElement).getPreviousSibling();
  }

  /**
   * Method under test:
   * {@link GroupedElement#buildElementAttrFromInputTag(MessageMLParser, Node)}
   */
  @Test
  public void testBuildElementAttrFromInputTag2() throws InvalidInputException, DOMException {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(null)), FormatEnum.MESSAGEML);
    NamedNodeMap namedNodeMap = mock(NamedNodeMap.class);
    when(namedNodeMap.getLength()).thenReturn(-1);
    when(namedNodeMap.removeNamedItem(Mockito.<String>any())).thenReturn(new IIOMetadataNode("foo"));
    Node node = mock(Node.class);
    when(node.getNextSibling()).thenReturn(new IIOMetadataNode("foo"));
    Node inputElement = mock(Node.class);
    when(inputElement.getNextSibling()).thenReturn(node);
    when(inputElement.getPreviousSibling()).thenReturn(new IIOMetadataNode("foo"));
    when(inputElement.getAttributes()).thenReturn(namedNodeMap);

    // Act
    checkbox.buildElementAttrFromInputTag(null, inputElement);

    // Assert
    verify(namedNodeMap).getLength();
    verify(namedNodeMap).removeNamedItem(eq("type"));
    verify(inputElement).getAttributes();
    verify(inputElement).getNextSibling();
    verify(node).getNextSibling();
    verify(inputElement).getPreviousSibling();
  }

  /**
   * Method under test:
   * {@link GroupedElement#buildGroupedElementInputAttributes(String)}
   */
  @Test
  public void testBuildGroupedElementInputAttributes() {
    // Arrange and Act
    Map<String, String> actualBuildGroupedElementInputAttributesResult = (new Checkbox(
        new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).buildGroupedElementInputAttributes("42");

    // Assert
    assertEquals(3, actualBuildGroupedElementInputAttributesResult.size());
    assertEquals("on", actualBuildGroupedElementInputAttributesResult.get(Entity.VALUE_FIELD));
    assertNull(actualBuildGroupedElementInputAttributesResult.get("name"));
    assertEquals(Checkbox.MESSAGEML_TAG, actualBuildGroupedElementInputAttributesResult.get(Entity.TYPE_FIELD));
  }
}
