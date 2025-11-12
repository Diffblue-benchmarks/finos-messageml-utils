package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
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
import org.symphonyoss.symphony.messageml.util.IDataProvider;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class LinkDiffblueTest {
  /**
   * Test {@link Link#Link(Element, IDataProvider)}.
   *
   * <p>Method under test: {@link Link#Link(Element, IDataProvider)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.<init>(Element, IDataProvider)"})
  public void testNewLink() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Link actualLink = new Link(parent2, new NoOpDataProvider());

    // Assert
    assertNull(actualLink.getUri());
    assertEquals(0, actualLink.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualLink.getFormat());
    assertTrue(actualLink.getChildren().isEmpty());
    assertTrue(actualLink.getAttributes().isEmpty());
    assertEquals(Link.MESSAGEML_TAG, actualLink.getMessageMLTag());
    assertEquals(Link.MESSAGEML_TAG, actualLink.getPresentationMLTag());
    assertSame(parent2, actualLink.getParent());
  }

  /**
   * Test {@link Link#Link(Element, String, IDataProvider)}.
   *
   * <ul>
   *   <li>When {@code Href}.
   *   <li>Then return Uri toString is {@code Href}.
   * </ul>
   *
   * <p>Method under test: {@link Link#Link(Element, String, IDataProvider)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.<init>(Element, String, IDataProvider)"})
  public void testNewLink_whenHref_thenReturnUriToStringIsHref() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Link actualLink = new Link(parent2, "Href", new NoOpDataProvider());

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
    assertSame(parent2, actualLink.getParent());
  }

  /**
   * Test {@link Link#Link(Element, String, IDataProvider)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Uri is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Link#Link(Element, String, IDataProvider)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.<init>(Element, String, IDataProvider)"})
  public void testNewLink_whenNull_thenReturnUriIsNull() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Link actualLink = new Link(parent2, null, new NoOpDataProvider());

    // Assert
    assertNull(actualLink.getUri());
    assertEquals(0, actualLink.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualLink.getFormat());
    assertTrue(actualLink.getChildren().isEmpty());
    assertTrue(actualLink.getAttributes().isEmpty());
    assertEquals(Link.MESSAGEML_TAG, actualLink.getMessageMLTag());
    assertEquals(Link.MESSAGEML_TAG, actualLink.getPresentationMLTag());
    assertSame(parent2, actualLink.getParent());
  }

  /**
   * Test {@link Link#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@link Element#ID_ATTR}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Link#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithId_attr_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Link link = new Link(parent2, new NoOpDataProvider());
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> link.buildAttribute(parser, new IIOMetadataNode(Element.ID_ATTR)));
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Link link = new Link(parent2, new NoOpDataProvider());
    BulletList parent3 = new BulletList(mock(Element.class));
    link.addChild(new Bold(parent3));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(20L, out.getOffset());
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Link link = new Link(parent2, new NoOpDataProvider());
    link.setUri(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(30L, out.getOffset());
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Link link = new Link(parent2, new NoOpDataProvider());
    link.setUri(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setPrintOffsets(true);

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(30L, out.getOffset());
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML4() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Link link = new Link(parent2, new NoOpDataProvider());
    link.setUri(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoIndent(true);

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(29L, out.getOffset());
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML5() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Link link = new Link(parent2, new NoOpDataProvider());
    link.setUri(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(27L, out.getOffset());
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML6() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Link link = new Link(parent2, new NoOpDataProvider());
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    link.addChild(new Checkbox(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(53L, out.getOffset());
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML7() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Link link = new Link(parent2, new NoOpDataProvider());
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    link.addChild(new Button(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(44L, out.getOffset());
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML8() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Link link = new Link(parent2, new NoOpDataProvider());
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    link.addChild(new CardBody(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(41L, out.getOffset());
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML9() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent2));
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);

    Link link = new Link(parent4, new NoOpDataProvider());
    link.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(33L, out.getOffset());
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML10() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Link link = new Link(parent2, new NoOpDataProvider());
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    link.addChild(new CashTag(parent4, 1));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(73L, out.getOffset());
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML11() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Link link = new Link(parent2, new NoOpDataProvider());
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    link.addChild(new Checkbox(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(48L, out.getOffset());
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML12() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new Checkbox(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Link link = new Link(parent5, new NoOpDataProvider());
    link.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(66L, out.getOffset());
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML13() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new Button(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Link link = new Link(parent5, new NoOpDataProvider());
    link.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(57L, out.getOffset());
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML14() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CardBody(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Link link = new Link(parent5, new NoOpDataProvider());
    link.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(54L, out.getOffset());
  }

  /**
   * Test {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Link#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML15() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CashTag(parent3, 1));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Link link = new Link(parent5, new NoOpDataProvider());
    link.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    link.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(86L, out.getOffset());
  }

  /**
   * Test {@link Link#asMarkdown()}.
   *
   * <p>Method under test: {@link Link#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Link.asMarkdown()"})
  public void testAsMarkdown() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Link link = new Link(parent2, new NoOpDataProvider());
    BulletList parent3 = new BulletList(mock(Element.class));
    link.addChild(new Bold(parent3));
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
    assertEquals(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toString(),
        ((org.commonmark.node.Link) actualAsMarkdownResult).getDestination());
  }

  /**
   * Test {@link Link#asMarkdown()}.
   *
   * <ul>
   *   <li>Then return Title is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Link#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Link.asMarkdown()"})
  public void testAsMarkdown_thenReturnTitleIsEmptyString() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Link link = new Link(parent2, new NoOpDataProvider());
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
    assertEquals(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toString(),
        ((org.commonmark.node.Link) actualAsMarkdownResult).getDestination());
  }

  /**
   * Test {@link Link#asMarkdown()}.
   *
   * <ul>
   *   <li>Then return Title is {@code $null}.
   * </ul>
   *
   * <p>Method under test: {@link Link#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Link.asMarkdown()"})
  public void testAsMarkdown_thenReturnTitleIsNull() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Link link = new Link(parent2, new NoOpDataProvider());
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    link.addChild(new CashTag(parent4, 1));
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
    assertEquals(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toString(),
        ((org.commonmark.node.Link) actualAsMarkdownResult).getDestination());
  }

  /**
   * Test {@link Link#validate()}.
   *
   * <ul>
   *   <li>Given {@link Link#Link(Element, IDataProvider)} with parent is {@link Bold#Bold(Element)}
   *       and dataProvider is {@link NoOpDataProvider} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Link#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.validate()"})
  public void testValidate_givenLinkWithParentIsBoldAndDataProviderIsNoOpDataProvider()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    Link link = new Link(parent, new NoOpDataProvider());

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> link.validate());
  }

  /**
   * Test {@link Link#validate()}.
   *
   * <ul>
   *   <li>Then calls {@link NoOpDataProvider#validateURI(URI)}.
   * </ul>
   *
   * <p>Method under test: {@link Link#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.validate()"})
  public void testValidate_thenCallsValidateURI()
      throws InvalidInputException, ProcessingException {
    // Arrange
    NoOpDataProvider dataProvider = mock(NoOpDataProvider.class);
    doThrow(new ProcessingException("An error occurred"))
        .when(dataProvider)
        .validateURI(Mockito.<URI>any());
    Bold parent = new Bold(new BulletList(null));

    Link link = new Link(parent, dataProvider);
    link.setUri(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> link.validate());
    verify(dataProvider).validateURI(isA(URI.class));
  }

  /**
   * Test {@link Link#validate()}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Link#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.validate()"})
  public void testValidate_thenDoesNotThrow() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    Link link = new Link(parent, new NoOpDataProvider());
    link.setUri(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    // Act and Assert
    link.validate();
  }

  /**
   * Test {@link Link#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes {@code count} {@link
   *       BiItem}.
   * </ul>
   *
   * <p>Method under test: {@link Link#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountBiItem()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Link link = new Link(parent2, new NoOpDataProvider());

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes {@code count} is
   *       {@code Item Value}.
   * </ul>
   *
   * <p>Method under test: {@link Link#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountIsItemValue()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Link link = new Link(parent2, new NoOpDataProvider());

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size is two.
   * </ul>
   *
   * <p>Method under test: {@link Link#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Link link = new Link(parent2, new NoOpDataProvider());

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.
   * </ul>
   *
   * <p>Method under test: {@link Link#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsTwo() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Link link = new Link(parent2, new NoOpDataProvider());

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is {@code links}.
   * </ul>
   *
   * <p>Method under test: {@link Link#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsLinks()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Link link = new Link(parent2, new NoOpDataProvider());

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
   *
   * <ul>
   *   <li>When {@link BiContext} (default constructor).
   *   <li>Then {@link BiContext} (default constructor) Items first Name is {@code links}.
   * </ul>
   *
   * <p>Method under test: {@link Link#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Link.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsLinks()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Link link = new Link(parent2, new NoOpDataProvider());
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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Link#setUri(URI)}
   *   <li>{@link Link#getUri()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertEquals(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toString(),
        actualUri.toString());
    assertSame(url, actualUri);
  }
}
