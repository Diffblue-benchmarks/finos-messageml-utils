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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * Test {@link GroupedElement#buildAll(MessageMLParser, Element)}.
   * <p>
   * Method under test: {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GroupedElement.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll() throws InvalidInputException, ProcessingException {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem(MessageML.MESSAGEML_TAG, MessageML.MESSAGEML_TAG));
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(biContext);

    // Act
    checkbox.buildAll(parser, new IIOMetadataNode("foo"));

    // Assert that nothing has changed
    verify(parser).getBiContext();
    assertEquals(0, checkbox.size());
    assertTrue(checkbox.getChildren().isEmpty());
  }

  /**
   * Test {@link GroupedElement#buildAll(MessageMLParser, Element)}.
   * <p>
   * Method under test: {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GroupedElement.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll2() throws InvalidInputException, ProcessingException {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem(MessageML.MESSAGEML_TAG, MessageML.MESSAGEML_TAG));
    biContext.addItem(new BiItem(MessageML.MESSAGEML_TAG, MessageML.MESSAGEML_TAG));
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(biContext);

    // Act
    checkbox.buildAll(parser, new IIOMetadataNode("foo"));

    // Assert that nothing has changed
    verify(parser).getBiContext();
    assertEquals(0, checkbox.size());
    assertTrue(checkbox.getChildren().isEmpty());
  }

  /**
   * Test {@link GroupedElement#buildAll(MessageMLParser, Element)}.
   * <p>
   * Method under test: {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GroupedElement.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll3() throws InvalidInputException, ProcessingException {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
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
  }

  /**
   * Test {@link GroupedElement#buildAll(MessageMLParser, Element)}.
   * <ul>
   *   <li>Then {@link Checkbox#Checkbox(Element, FormatEnum)} with parent is {@link Bold#Bold(Element)} and messageFormat is {@code MESSAGEML} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GroupedElement.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll_thenCheckboxWithParentIsBoldAndMessageFormatIsMessagemlSizeIsZero()
      throws InvalidInputException, ProcessingException {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(new BiContext());

    // Act
    checkbox.buildAll(parser, new IIOMetadataNode("foo"));

    // Assert that nothing has changed
    verify(parser).getBiContext();
    assertEquals(0, checkbox.size());
    assertTrue(checkbox.getChildren().isEmpty());
  }

  /**
   * Test {@link GroupedElement#buildAll(MessageMLParser, Element)}.
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GroupedElement.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll_thenThrowInvalidInputException() throws InvalidInputException, ProcessingException {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.PRESENTATIONML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> checkbox.buildAll(parser, new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link GroupedElement#buildAll(MessageMLParser, Element)}.
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GroupedElement.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll_thenThrowInvalidInputException2() throws InvalidInputException, ProcessingException {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.PRESENTATIONML);
    MessageMLParser parser = mock(MessageMLParser.class);

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode(MessageML.MESSAGEML_TAG));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> checkbox.buildAll(parser, element));
  }

  /**
   * Test {@link GroupedElement#buildAll(MessageMLParser, Element)}.
   * <ul>
   *   <li>When {@link MessageMLParser} {@link MessageMLParser#createElement(Element, Element)} return {@code null}.</li>
   *   <li>Then calls {@link MessageMLParser#createElement(Element, Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GroupedElement.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll_whenMessageMLParserCreateElementReturnNull_thenCallsCreateElement()
      throws InvalidInputException, ProcessingException {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any())).thenReturn(null);
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode(MessageML.MESSAGEML_TAG));

    // Act
    checkbox.buildAll(parser, element);

    // Assert that nothing has changed
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
    verify(parser).getBiContext();
    assertEquals(0, checkbox.size());
    assertTrue(checkbox.getChildren().isEmpty());
  }

  /**
   * Test {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GroupedElement.asPresentationML(XmlPrintStream, MessageMLContext)"})
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
   * Test {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GroupedElement.asPresentationML(XmlPrintStream, MessageMLContext)"})
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
   * Test {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GroupedElement.asPresentationML(XmlPrintStream, MessageMLContext)"})
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
   * Test {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GroupedElement.asPresentationML(XmlPrintStream, MessageMLContext)"})
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
   * Test {@link GroupedElement#buildElementFromGroupDiv(MessageMLParser, Element)}.
   * <p>
   * Method under test: {@link GroupedElement#buildElementFromGroupDiv(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GroupedElement.buildElementFromGroupDiv(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildElementFromGroupDiv() throws InvalidInputException, ProcessingException {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode("Invalid PresentationML for the \"%s\" element"));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> checkbox.buildElementFromGroupDiv(parser, element));
  }

  /**
   * Test {@link GroupedElement#buildElementFromGroupDiv(MessageMLParser, Element)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupedElement#buildElementFromGroupDiv(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GroupedElement.buildElementFromGroupDiv(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildElementFromGroupDiv_givenIIOMetadataNodeWithEmptyString()
      throws InvalidInputException, ProcessingException {
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
   * Test {@link GroupedElement#buildElementFromGroupDiv(MessageMLParser, Element)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupedElement#buildElementFromGroupDiv(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GroupedElement.buildElementFromGroupDiv(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildElementFromGroupDiv_givenIIOMetadataNodeWithFoo()
      throws InvalidInputException, ProcessingException {
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
   * Test {@link GroupedElement#buildElementFromGroupDiv(MessageMLParser, Element)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupedElement#buildElementFromGroupDiv(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GroupedElement.buildElementFromGroupDiv(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildElementFromGroupDiv_whenIIOMetadataNodeWithFoo()
      throws InvalidInputException, ProcessingException {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(InvalidInputException.class,
        () -> checkbox.buildElementFromGroupDiv(parser, new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link GroupedElement#buildElementAttrFromInputTag(MessageMLParser, Node)}.
   * <p>
   * Method under test: {@link GroupedElement#buildElementAttrFromInputTag(MessageMLParser, Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GroupedElement.buildElementAttrFromInputTag(MessageMLParser, Node)"})
  public void testBuildElementAttrFromInputTag() throws InvalidInputException, DOMException {
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
   * Test {@link GroupedElement#buildElementAttrFromInputTag(MessageMLParser, Node)}.
   * <ul>
   *   <li>Then calls {@link NamedNodeMap#getLength()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupedElement#buildElementAttrFromInputTag(MessageMLParser, Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GroupedElement.buildElementAttrFromInputTag(MessageMLParser, Node)"})
  public void testBuildElementAttrFromInputTag_thenCallsGetLength() throws InvalidInputException, DOMException {
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
   * Test {@link GroupedElement#buildGroupedElementInputAttributes(String)}.
   * <p>
   * Method under test: {@link GroupedElement#buildGroupedElementInputAttributes(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map GroupedElement.buildGroupedElementInputAttributes(String)"})
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
