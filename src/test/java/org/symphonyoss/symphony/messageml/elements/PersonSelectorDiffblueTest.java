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
import org.symphonyoss.symphony.messageml.markdown.nodes.form.PersonSelectorNode;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class PersonSelectorDiffblueTest {
  /**
   * Method under test:
   * {@link PersonSelector#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll() throws InvalidInputException, ProcessingException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    PersonSelector personSelector = new PersonSelector(parent, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(new BiContext());

    // Act
    personSelector.buildAll(parser, new IIOMetadataNode("foo"));

    // Assert
    verify(parser).getBiContext();
    assertEquals(0, personSelector.size());
    assertTrue(personSelector.getChildren().isEmpty());
    assertSame(parent, personSelector.getParent());
  }

  /**
   * Method under test:
   * {@link PersonSelector#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll2() throws InvalidInputException, ProcessingException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    PersonSelector personSelector = new PersonSelector(parent, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any())).thenReturn(bold);
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode(MessageML.MESSAGEML_TAG));

    // Act
    personSelector.buildAll(parser, element);

    // Assert
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
    verify(parser, atLeast(1)).getBiContext();
    List<Element> children = personSelector.getChildren();
    assertEquals(1, children.size());
    assertEquals(1, personSelector.size());
    assertSame(bold, children.get(0));
    assertSame(parent, personSelector.getParent());
  }

  /**
   * Method under test:
   * {@link PersonSelector#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  public void testBuildAll3() throws InvalidInputException, ProcessingException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    PersonSelector personSelector = new PersonSelector(parent, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any())).thenReturn(null);
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode("foo");
    element.appendChild(new IIOMetadataNode(MessageML.MESSAGEML_TAG));

    // Act
    personSelector.buildAll(parser, element);

    // Assert
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
    verify(parser).getBiContext();
    assertEquals(0, personSelector.size());
    assertTrue(personSelector.getChildren().isEmpty());
    assertSame(parent, personSelector.getParent());
  }

  /**
   * Method under test:
   * {@link PersonSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    PersonSelector personSelector = new PersonSelector(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    personSelector.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(48L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link PersonSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    PersonSelector personSelector = new PersonSelector(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    personSelector.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(48L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link PersonSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    PersonSelector personSelector = new PersonSelector(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    personSelector.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(48L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link PersonSelector#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    PersonSelector personSelector = new PersonSelector(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    personSelector.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(45L, out.getOffset());
  }

  /**
   * Method under test: {@link PersonSelector#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new PersonSelector(new Bold(new BulletList(mock(Element.class))),
        FormatEnum.MESSAGEML)).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof PersonSelectorNode);
    assertEquals("", ((PersonSelectorNode) actualAsMarkdownResult).getText());
    assertEquals("(Person Selector", ((PersonSelectorNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals(")", ((PersonSelectorNode) actualAsMarkdownResult).getClosingDelimiter());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Method under test: {@link PersonSelector#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    PersonSelector personSelector = new PersonSelector(parent, FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    personSelector.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("personselector", getResult.getName());
    assertTrue(getResult.getAttributes().isEmpty());
    assertTrue(personSelector.getAttributes().isEmpty());
    assertSame(parent, personSelector.getParent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PersonSelector#PersonSelector(Element, FormatEnum)}
   *   <li>{@link PersonSelector#getElementId()}
   *   <li>{@link PersonSelector#getPresentationMLTag()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    PersonSelector actualPersonSelector = new PersonSelector(parent, FormatEnum.MESSAGEML);
    String actualElementId = actualPersonSelector.getElementId();
    String actualPresentationMLTag = actualPersonSelector.getPresentationMLTag();

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualPersonSelector.getFormat());
    assertTrue(actualPersonSelector.getChildren().isEmpty());
    assertTrue(actualPersonSelector.getAttributes().isEmpty());
    assertEquals(Div.MESSAGEML_TAG, actualPresentationMLTag);
    assertEquals(PersonSelector.MESSAGEML_TAG, actualPersonSelector.getMessageMLTag());
    assertEquals(PersonSelector.MESSAGEML_TAG, actualElementId);
    assertSame(parent, actualPersonSelector.getParent());
  }
}
