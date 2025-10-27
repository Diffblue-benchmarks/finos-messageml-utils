package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import org.commonmark.node.Node;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;
import org.w3c.dom.DOMException;
import org.w3c.dom.Text;

public class TextNodeDiffblueTest {
  /**
   * Method under test:
   * {@link TextNode#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    TextNode textNode = new TextNode(new Bold(new BulletList(mock(Element.class))), "Text");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    textNode.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(5L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link TextNode#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    TextNode textNode = new TextNode(new Code(new Bold(new BulletList(mock(Element.class))), "en"), "Text");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    textNode.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(5L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link TextNode#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() throws DOMException {
    // Arrange
    Text node = mock(Text.class);
    when(node.getTextContent()).thenReturn("Not all who wander are lost");
    TextNode textNode = new TextNode(new Bold(new BulletList(mock(Element.class))), node);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.append(Element.CLASS_ATTR);

    // Act
    textNode.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    verify(node).getTextContent();
    assertEquals(33L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link TextNode#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() throws DOMException {
    // Arrange
    Text node = mock(Text.class);
    when(node.getTextContent()).thenReturn("Not all who wander are lost");
    TextNode textNode = new TextNode(new Bold(new BulletList(mock(Element.class))), node);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);
    out.append(Element.CLASS_ATTR);

    // Act
    textNode.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    verify(node).getTextContent();
    assertEquals(32L, out.getOffset());
  }

  /**
   * Method under test: {@link TextNode#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new TextNode(new Bold(new BulletList(mock(Element.class))), "Text")).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof org.commonmark.node.Text);
    assertEquals("Text", ((org.commonmark.node.Text) actualAsMarkdownResult).getLiteral());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Method under test: {@link TextNode#buildText(Text)}
   */
  @Test
  public void testBuildText() throws DOMException {
    // Arrange
    TextNode textNode = new TextNode(new Bold(new BulletList(mock(Element.class))), "Text");
    Text node = mock(Text.class);
    when(node.getTextContent()).thenReturn("Not all who wander are lost");

    // Act
    textNode.buildText(node);

    // Assert
    verify(node).getTextContent();
    assertEquals("Not all who wander are lost", textNode.getText());
  }

  /**
   * Method under test: {@link TextNode#asText()}
   */
  @Test
  public void testAsText() {
    // Arrange, Act and Assert
    assertEquals("Text", (new TextNode(new Bold(new BulletList(mock(Element.class))), "Text")).asText());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TextNode#TextNode(Element, String)}
   *   <li>{@link TextNode#setText(String)}
   *   <li>{@link TextNode#toString()}
   *   <li>{@link TextNode#getText()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    TextNode actualTextNode = new TextNode(parent, "Text");
    actualTextNode.setText("Text");
    String actualToStringResult = actualTextNode.toString();

    // Assert that nothing has changed
    assertEquals("Text", actualTextNode.getText());
    assertEquals("Text(Text)", actualToStringResult);
    assertEquals(FormatEnum.PRESENTATIONML, actualTextNode.getFormat());
    assertTrue(actualTextNode.getChildren().isEmpty());
    assertTrue(actualTextNode.getAttributes().isEmpty());
    assertSame(parent, actualTextNode.getParent());
  }

  /**
   * Method under test: {@link TextNode#TextNode(Element, Text)}
   */
  @Test
  public void testNewTextNode() throws DOMException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Text node = mock(Text.class);
    when(node.getTextContent()).thenReturn("Not all who wander are lost");

    // Act
    TextNode actualTextNode = new TextNode(parent, node);

    // Assert
    verify(node).getTextContent();
    assertEquals("Not all who wander are lost", actualTextNode.getText());
    assertNull(actualTextNode.getMessageMLTag());
    assertNull(actualTextNode.getPresentationMLTag());
    assertEquals(0, actualTextNode.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualTextNode.getFormat());
    assertTrue(actualTextNode.getChildren().isEmpty());
    assertTrue(actualTextNode.getAttributes().isEmpty());
    assertSame(parent, actualTextNode.getParent());
  }
}
