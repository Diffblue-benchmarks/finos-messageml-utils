package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class TextNodeDiffblueTest {
  /**
   * Test {@link TextNode#TextNode(Element, String)}.
   *
   * <p>Method under test: {@link TextNode#TextNode(Element, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextNode.<init>(Element, String)"})
  public void testNewTextNode() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    TextNode actualTextNode = new TextNode(parent2, "Text");

    // Assert
    assertEquals("Text", actualTextNode.getText());
    assertNull(actualTextNode.getMessageMLTag());
    assertNull(actualTextNode.getPresentationMLTag());
    assertEquals(0, actualTextNode.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualTextNode.getFormat());
    assertTrue(actualTextNode.getChildren().isEmpty());
    assertTrue(actualTextNode.getAttributes().isEmpty());
    assertSame(parent2, actualTextNode.getParent());
  }

  /**
   * Test {@link TextNode#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link TextNode#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextNode.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextNode textNode = new TextNode(parent2, "Text");

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.append(Element.CLASS_ATTR);

    // Act
    textNode.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(10L, out.getOffset());
  }

  /**
   * Test {@link TextNode#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link TextNode#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextNode.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextNode textNode = new TextNode(parent2, "Text");

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);
    out.append(Element.CLASS_ATTR);

    // Act
    textNode.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(9L, out.getOffset());
  }

  /**
   * Test {@link TextNode#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link TextNode#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextNode.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextNode textNode = new TextNode(parent2, "Text");

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setPrintOffsets(true);

    // Act
    textNode.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(5L, out.getOffset());
  }

  /**
   * Test {@link TextNode#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link TextNode#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextNode.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML4() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextNode textNode = new TextNode(parent2, "Text");

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoIndent(true);

    // Act
    textNode.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(5L, out.getOffset());
  }

  /**
   * Test {@link TextNode#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is {@link Element}.
   * </ul>
   *
   * <p>Method under test: {@link TextNode#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextNode.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML_givenBoldWithParentIsElement() {
    // Arrange
    Bold parent = new Bold(mock(Element.class));
    Code parent2 = new Code(parent, "en");
    TextNode textNode = new TextNode(parent2, "Text");

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setRemoveNl(false);

    // Act
    textNode.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(5L, out.getOffset());
  }

  /**
   * Test {@link TextNode#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <ul>
   *   <li>Given {@link TextNode#TextNode(Element, String)} with parent is {@link Code#Code(Element,
   *       String)} and {@code Text}.
   * </ul>
   *
   * <p>Method under test: {@link TextNode#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextNode.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML_givenTextNodeWithParentIsCodeAndText() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Code parent3 = new Code(parent2, "en");
    TextNode textNode = new TextNode(parent3, "Text");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    textNode.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(5L, out.getOffset());
  }

  /**
   * Test {@link TextNode#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <ul>
   *   <li>When {@link XmlPrintStream#XmlPrintStream(OutputStream)} with outputStream is {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link TextNode#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextNode.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML_whenXmlPrintStreamWithOutputStreamIsByteArrayOutputStream() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TextNode textNode = new TextNode(parent2, "Text");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    textNode.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(5L, out.getOffset());
  }

  /**
   * Test {@link TextNode#asMarkdown()}.
   *
   * <p>Method under test: {@link TextNode#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node TextNode.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new TextNode(parent2, "Text").asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof Text);
    assertEquals("Text", ((Text) actualAsMarkdownResult).getLiteral());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TextNode#setText(String)}
   *   <li>{@link TextNode#toString()}
   *   <li>{@link TextNode#getText()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TextNode.getText()",
    "void TextNode.setText(String)",
    "String TextNode.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    TextNode textNode = new TextNode(parent, "Text");

    // Act
    textNode.setText("Text");
    String actualToStringResult = textNode.toString();

    // Assert
    assertEquals("Text", textNode.getText());
    assertEquals("Text(Text)", actualToStringResult);
  }

  /**
   * Test {@link TextNode#asText()}.
   *
   * <p>Method under test: {@link TextNode#asText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TextNode.asText()"})
  public void testAsText() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertEquals("Text", new TextNode(parent2, "Text").asText());
  }
}
