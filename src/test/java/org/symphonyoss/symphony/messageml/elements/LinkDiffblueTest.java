package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.IDataProvider;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class LinkDiffblueTest {
  /**
   * Test {@link Link#Link(Element, IDataProvider)}.
   * <p>
   * Method under test: {@link Link#Link(Element, IDataProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Link.<init>(Element, IDataProvider)"})
  public void testNewLink() throws InvalidInputException {
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

  /**
   * Test {@link Link#Link(Element, String, IDataProvider)}.
   * <ul>
   *   <li>When {@code Href}.</li>
   *   <li>Then return Uri toString is {@code Href}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Link#Link(Element, String, IDataProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Link.<init>(Element, String, IDataProvider)"})
  public void testNewLink_whenHref_thenReturnUriToStringIsHref() throws InvalidInputException {
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
   * Test {@link Link#Link(Element, String, IDataProvider)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Uri is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Link#Link(Element, String, IDataProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Link.<init>(Element, String, IDataProvider)"})
  public void testNewLink_whenNull_thenReturnUriIsNull() throws InvalidInputException {
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
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
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
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Link link = new Link(parent, new NoOpDataProvider());
    link.addChild(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(20L, out.getOffset());
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Link link = new Link(parent, new NoOpDataProvider());
    link.addChild(new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(53L, out.getOffset());
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML4() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Link link = new Link(parent, new NoOpDataProvider());
    link.addChild(new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(41L, out.getOffset());
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML5() throws InvalidInputException {
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
    assertEquals(33L, out.getOffset());
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML6() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Link link = new Link(parent, new NoOpDataProvider());
    link.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(73L, out.getOffset());
  }

  /**
   * Test {@link Link#asMarkdown()}.
   * <p>
   * Method under test: {@link Link#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Link.asMarkdown()"})
  public void testAsMarkdown() throws InvalidInputException {
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
   * Test {@link Link#asMarkdown()}.
   * <ul>
   *   <li>Then return Title is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Link#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Link.asMarkdown()"})
  public void testAsMarkdown_thenReturnTitleIsEmptyString() throws InvalidInputException {
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
   * Test {@link Link#asMarkdown()}.
   * <ul>
   *   <li>Then return Title is {@code $null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Link#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Link.asMarkdown()"})
  public void testAsMarkdown_thenReturnTitleIsNull() throws InvalidInputException {
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
   * Test {@link Link#validate()}.
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Link#validate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Link.validate()"})
  public void testValidate_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> (new Link(parent, new NoOpDataProvider())).validate());
  }

  /**
   * Test {@link Link#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes {@code count} {@link BiItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Link#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Link.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountBiItem() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Link link = new Link(parent, new NoOpDataProvider());

    BiContext biContext = new BiContext();
    BiItem biItem = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    biContext.addItemWithValue("links", biItem);
    biContext.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    biContext.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    link.updateBiContext(biContext);

    // Assert that nothing has changed
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(1, attributes.size());
    Object getResult = attributes.get("count");
    assertTrue(getResult instanceof BiItem);
    Map<String, Object> attributes2 = items.get(1).getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
    assertEquals(attributes2, items.get(2).getAttributes());
    assertSame(biItem, getResult);
  }

  /**
   * Test {@link Link#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes {@code count} is {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Link#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Link.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountIsItemValue() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Link link = new Link(parent, new NoOpDataProvider());

    BiContext biContext = new BiContext();
    biContext.addItemWithValue("links", "Item Value");
    biContext.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    biContext.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    link.updateBiContext(biContext);

    // Assert that nothing has changed
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("Item Value", attributes.get("count"));
    Map<String, Object> attributes2 = items.get(1).getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link Link#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Link#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Link.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Link link = new Link(parent, new NoOpDataProvider());

    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem("links", Element.STYLE_ATTR));

    // Act
    link.updateBiContext(biContext);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(1, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    assertTrue(attributes.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link Link#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Link#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Link.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsTwo() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Link link = new Link(parent, new NoOpDataProvider());

    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    link.updateBiContext(biContext);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("links", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Link#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is {@code links}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Link#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Link.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsLinks() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Link link = new Link(parent, new NoOpDataProvider());

    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    biContext.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    link.updateBiContext(biContext);

    // Assert
    List<BiItem> items = biContext.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("links", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Link#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is {@code links}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Link#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Link.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsLinks() throws InvalidInputException {
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
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Link#setUri(URI)}
   *   <li>{@link Link#getUri()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URI Link.getUri()", "void Link.setUri(URI)"})
  public void testGettersAndSetters() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    Link link = new Link(parent, new NoOpDataProvider());
    URI url = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    link.setUri(url);
    URI actualUri = link.getUri();

    // Assert
    String expectedToStringResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toString();
    assertEquals(expectedToStringResult, actualUri.toString());
    assertSame(url, actualUri);
  }
}
