package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import org.commonmark.node.Node;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.IDataProvider;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class LinkDiffblueTest {
  /**
   * Method under test:
   * {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Link link = new Link(parent, new NoOpDataProvider());
    link.setUri(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(30L, out.getOffset());
    assertTrue(link.getChildren().isEmpty());
  }

  /**
   * Method under test:
   * {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Link link = new Link(parent, new NoOpDataProvider());
    Bold child = new Bold(new BulletList(mock(Element.class)));
    link.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = link.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof Bold);
    assertEquals(20L, out.getOffset());
    assertSame(child, getResult);
  }

  /**
   * Method under test:
   * {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Link link = new Link(parent, new NoOpDataProvider());
    Checkbox child = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    link.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = link.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof Checkbox);
    assertEquals(53L, out.getOffset());
    assertSame(child, getResult);
  }

  /**
   * Method under test:
   * {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Link link = new Link(parent, new NoOpDataProvider());
    Button child = new Button(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    link.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = link.getChildren();
    assertEquals(1, children.size());
    assertEquals(44L, out.getOffset());
    assertSame(child, children.get(0));
  }

  /**
   * Method under test:
   * {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Link link = new Link(parent, new NoOpDataProvider());
    CardBody child = new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    link.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = link.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof CardBody);
    assertEquals(41L, out.getOffset());
    assertSame(child, getResult);
  }

  /**
   * Method under test:
   * {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML6() throws InvalidInputException {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Link link = new Link(parent, new NoOpDataProvider());
    link.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = link.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof Bold);
    assertEquals(33L, out.getOffset());
    assertSame(child, getResult);
  }

  /**
   * Method under test:
   * {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML7() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Link link = new Link(parent, new NoOpDataProvider());
    CashTag child = new CashTag(new Bold(new BulletList(mock(Element.class))), 1);

    link.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = link.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof CashTag);
    assertEquals(73L, out.getOffset());
    assertSame(child, getResult);
  }

  /**
   * Method under test:
   * {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML8() throws InvalidInputException {
    // Arrange
    Checkbox child = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    child.addChild(new Bold(new BulletList(mock(Element.class))));
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Link link = new Link(parent, new NoOpDataProvider());
    link.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = link.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof Checkbox);
    assertSame(child, getResult);
  }

  /**
   * Method under test: {@link Link#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Link link = new Link(parent, new NoOpDataProvider());
    link.setUri(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    // Act
    Node actualAsMarkdownResult = link.asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof org.commonmark.node.Link);
    assertEquals("", ((org.commonmark.node.Link) actualAsMarkdownResult).getTitle());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
    String expectedDestination = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toString();
    assertEquals(expectedDestination, ((org.commonmark.node.Link) actualAsMarkdownResult).getDestination());
  }

  /**
   * Method under test: {@link Link#asMarkdown()}
   */
  @Test
  public void testAsMarkdown2() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Link link = new Link(parent, new NoOpDataProvider());
    link.addChild(new Bold(new BulletList(mock(Element.class))));
    link.setUri(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    // Act
    Node actualAsMarkdownResult = link.asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof org.commonmark.node.Link);
    assertEquals("", ((org.commonmark.node.Link) actualAsMarkdownResult).getTitle());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
    String expectedDestination = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toString();
    assertEquals(expectedDestination, ((org.commonmark.node.Link) actualAsMarkdownResult).getDestination());
  }

  /**
   * Method under test: {@link Link#asMarkdown()}
   */
  @Test
  public void testAsMarkdown3() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Link link = new Link(parent, new NoOpDataProvider());
    link.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));
    link.setUri(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    // Act
    Node actualAsMarkdownResult = link.asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof org.commonmark.node.Link);
    assertEquals("$null", ((org.commonmark.node.Link) actualAsMarkdownResult).getTitle());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
    String expectedDestination = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toString();
    assertEquals(expectedDestination, ((org.commonmark.node.Link) actualAsMarkdownResult).getDestination());
  }

  /**
   * Method under test: {@link Link#validate()}
   */
  @Test
  public void testValidate() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> (new Link(parent, new NoOpDataProvider())).validate());
  }

  /**
   * Method under test: {@link Link#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Link link = new Link(parent, new NoOpDataProvider());
    BiContext biContext = new BiContext();

    // Act
    link.updateBiContext(biContext);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("links", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(parent, link.getParent());
  }

  /**
   * Method under test: {@link Link#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Link link = new Link(parent, new NoOpDataProvider());

    BiContext biContext = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    biContext.addItem(item);

    // Act
    link.updateBiContext(biContext);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("links", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(parent, link.getParent());
  }

  /**
   * Method under test: {@link Link#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Link link = new Link(parent, new NoOpDataProvider());

    BiContext biContext = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    biContext.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    biContext.addItem(item2);

    // Act
    link.updateBiContext(biContext);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("links", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(item2, items.get(1));
    assertSame(parent, link.getParent());
  }

  /**
   * Method under test: {@link Link#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext4() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Link link = new Link(parent, new NoOpDataProvider());

    BiContext biContext = new BiContext();
    BiItem item = new BiItem("links", Element.STYLE_ATTR);

    biContext.addItem(item);

    // Act
    link.updateBiContext(biContext);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(1, items.size());
    assertSame(item, items.get(0));
    assertSame(parent, link.getParent());
  }

  /**
   * Method under test: {@link Link#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext5() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Link link = new Link(parent, new NoOpDataProvider());

    BiContext biContext = new BiContext();
    biContext.addItemWithValue("links", "Item Value");
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    biContext.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    biContext.addItem(item2);

    // Act
    link.updateBiContext(biContext);

    // Assert that nothing has changed
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("links", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, link.getParent());
  }

  /**
   * Method under test: {@link Link#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext6() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Link link = new Link(parent, new NoOpDataProvider());

    BiContext biContext = new BiContext();
    biContext.addItemWithValue("links", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    biContext.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    biContext.addItem(item2);

    // Act
    link.updateBiContext(biContext);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("links", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, link.getParent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Link#setUri(URI)}
   *   <li>{@link Link#getUri()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    Link link = new Link(parent, new NoOpDataProvider());
    URI url = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    link.setUri(url);
    URI actualUri = link.getUri();

    // Assert that nothing has changed
    String expectedToStringResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toString();
    assertEquals(expectedToStringResult, actualUri.toString());
    assertSame(url, actualUri);
  }

  /**
   * Method under test: {@link Link#Link(Element, String, IDataProvider)}
   */
  @Test
  public void testNewLink() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Link actualLink = new Link(parent, "Href", new NoOpDataProvider());

    // Assert
    assertEquals("Href", actualLink.getUri().toString());
    Map<String, String> attributes = actualLink.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("Href", attributes.get("href"));
    assertEquals(0, actualLink.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualLink.getFormat());
    assertTrue(actualLink.getChildren().isEmpty());
    assertEquals(Link.MESSAGEML_TAG, actualLink.getMessageMLTag());
    assertEquals(Link.MESSAGEML_TAG, actualLink.getPresentationMLTag());
    assertSame(parent, actualLink.getParent());
  }

  /**
   * Method under test: {@link Link#Link(Element, String, IDataProvider)}
   */
  @Test
  public void testNewLink2() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Link actualLink = new Link(parent, null, new NoOpDataProvider());

    // Assert
    assertNull(actualLink.getUri());
    assertEquals(0, actualLink.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualLink.getFormat());
    assertTrue(actualLink.getChildren().isEmpty());
    assertTrue(actualLink.getAttributes().isEmpty());
    assertEquals(Link.MESSAGEML_TAG, actualLink.getMessageMLTag());
    assertEquals(Link.MESSAGEML_TAG, actualLink.getPresentationMLTag());
    assertSame(parent, actualLink.getParent());
  }

  /**
   * Method under test: {@link Link#Link(Element, IDataProvider)}
   */
  @Test
  public void testNewLink3() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Link actualLink = new Link(parent, new NoOpDataProvider());

    // Assert
    assertNull(actualLink.getUri());
    assertEquals(0, actualLink.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualLink.getFormat());
    assertTrue(actualLink.getChildren().isEmpty());
    assertTrue(actualLink.getAttributes().isEmpty());
    assertEquals(Link.MESSAGEML_TAG, actualLink.getMessageMLTag());
    assertEquals(Link.MESSAGEML_TAG, actualLink.getPresentationMLTag());
    assertSame(parent, actualLink.getParent());
  }
}
