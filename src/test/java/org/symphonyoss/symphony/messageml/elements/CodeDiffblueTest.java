package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Node;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class CodeDiffblueTest {
  /**
   * Method under test:
   * {@link Code#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    Code code = new Code(new Bold(new BulletList(mock(Element.class))), "en");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    code.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(34L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Code#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    Code code = new Code(new Bold(new BulletList(mock(Element.class))), "<");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    code.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(36L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Code#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    Code code = new Code(new Bold(new BulletList(mock(Element.class))), "=\"");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    code.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(39L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Code#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    Code code = new Code(new Bold(new BulletList(mock(Element.class))), ">");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    code.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(36L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Code#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() {
    // Arrange
    Code code = new Code(new Bold(new BulletList(mock(Element.class))), null);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    code.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(15L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Code#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML6() {
    // Arrange
    Code code = new Code(new Bold(new BulletList(mock(Element.class))), "en");
    code.addChild(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    code.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(45L, out.getOffset());
  }

  /**
   * Method under test: {@link Code#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Code(new Bold(new BulletList(mock(Element.class))), "en")).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof FencedCodeBlock);
    assertEquals("en", ((FencedCodeBlock) actualAsMarkdownResult).getInfo());
    assertNull(((FencedCodeBlock) actualAsMarkdownResult).getLiteral());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertEquals(0, ((FencedCodeBlock) actualAsMarkdownResult).getFenceIndent());
    assertEquals(3, ((FencedCodeBlock) actualAsMarkdownResult).getFenceLength());
    assertEquals(Code.MARKDOWN_DELIMITER_CHAR, ((FencedCodeBlock) actualAsMarkdownResult).getFenceChar());
  }

  /**
   * Method under test: {@link Code#asMarkdown()}
   */
  @Test
  public void testAsMarkdown2() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Code(new Bold(new BulletList(mock(Element.class))), null)).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof FencedCodeBlock);
    assertNull(((FencedCodeBlock) actualAsMarkdownResult).getInfo());
    assertNull(((FencedCodeBlock) actualAsMarkdownResult).getLiteral());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertEquals(0, ((FencedCodeBlock) actualAsMarkdownResult).getFenceIndent());
    assertEquals(3, ((FencedCodeBlock) actualAsMarkdownResult).getFenceLength());
    assertEquals(Code.MARKDOWN_DELIMITER_CHAR, ((FencedCodeBlock) actualAsMarkdownResult).getFenceChar());
  }

  /**
   * Method under test: {@link Code#getPresentationMLTag()}
   */
  @Test
  public void testGetPresentationMLTag() {
    // Arrange, Act and Assert
    assertEquals(Code.MESSAGEML_TAG,
        (new Code(new Bold(new BulletList(mock(Element.class))), "en")).getPresentationMLTag());
  }

  /**
   * Method under test: {@link Code#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Code code = new Code(parent, "en");
    BiContext context = new BiContext();

    // Act
    code.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("codes", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(parent, code.getParent());
  }

  /**
   * Method under test: {@link Code#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Code code = new Code(parent, "en");

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    code.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("codes", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(parent, code.getParent());
  }

  /**
   * Method under test: {@link Code#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Code code = new Code(parent, "en");

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    code.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("codes", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(item2, items.get(1));
    assertSame(parent, code.getParent());
  }

  /**
   * Method under test: {@link Code#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext4() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Code code = new Code(parent, "en");

    BiContext context = new BiContext();
    BiItem item = new BiItem("codes", Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    code.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    assertSame(item, items.get(0));
    assertSame(parent, code.getParent());
  }

  /**
   * Method under test: {@link Code#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext5() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Code code = new Code(parent, "en");

    BiContext context = new BiContext();
    context.addItemWithValue("codes", "Item Value");
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    code.updateBiContext(context);

    // Assert that nothing has changed
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("codes", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, code.getParent());
  }

  /**
   * Method under test: {@link Code#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext6() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Code code = new Code(parent, "en");

    BiContext context = new BiContext();
    context.addItemWithValue("codes", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    code.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("codes", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, code.getParent());
  }

  /**
   * Method under test: {@link Code#Code(Element)}
   */
  @Test
  public void testNewCode() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Code actualCode = new Code(parent);

    // Assert
    assertEquals(0, actualCode.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualCode.getFormat());
    assertTrue(actualCode.getChildren().isEmpty());
    assertTrue(actualCode.getAttributes().isEmpty());
    assertEquals(Code.MESSAGEML_TAG, actualCode.getPresentationMLTag());
    assertEquals(Code.MESSAGEML_TAG, actualCode.getMessageMLTag());
    assertSame(parent, actualCode.getParent());
  }

  /**
   * Method under test: {@link Code#Code(Element, String)}
   */
  @Test
  public void testNewCode2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Code actualCode = new Code(parent, "en");

    // Assert
    Map<String, String> attributes = actualCode.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("en", attributes.get("data-language"));
    assertEquals(0, actualCode.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualCode.getFormat());
    assertTrue(actualCode.getChildren().isEmpty());
    assertEquals(Code.MESSAGEML_TAG, actualCode.getPresentationMLTag());
    assertEquals(Code.MESSAGEML_TAG, actualCode.getMessageMLTag());
    assertSame(parent, actualCode.getParent());
  }
}
