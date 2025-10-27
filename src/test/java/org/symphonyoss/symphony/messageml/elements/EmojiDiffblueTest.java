package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.EmojiNode;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class EmojiDiffblueTest {
  /**
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(63L, out.getOffset());
    assertTrue(emoji.getChildren().isEmpty());
  }

  /**
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    Bold child = new Bold(new BulletList(mock(Element.class)));
    emoji.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = emoji.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof Bold);
    assertEquals(67L, out.getOffset());
    assertSame(child, getResult);
  }

  /**
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    Checkbox child = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    emoji.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = emoji.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof Checkbox);
    assertEquals(100L, out.getOffset());
    assertSame(child, getResult);
  }

  /**
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    Button child = new Button(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    emoji.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = emoji.getChildren();
    assertEquals(1, children.size());
    assertEquals(91L, out.getOffset());
    assertSame(child, children.get(0));
  }

  /**
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    CardBody child = new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    emoji.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = emoji.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof CardBody);
    assertEquals(88L, out.getOffset());
    assertSame(child, getResult);
  }

  /**
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML6() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    emoji.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = emoji.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof Bold);
    assertEquals(80L, out.getOffset());
    assertSame(child, getResult);
  }

  /**
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML7() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    CashTag child = new CashTag(new Bold(new BulletList(mock(Element.class))), 1);

    emoji.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = emoji.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof CashTag);
    assertEquals(120L, out.getOffset());
    assertSame(child, getResult);
  }

  /**
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML8() {
    // Arrange
    Checkbox child = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    emoji.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = emoji.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof Checkbox);
    assertSame(child, getResult);
  }

  /**
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML9() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(63L, out.getOffset());
    assertTrue(emoji.getChildren().isEmpty());
  }

  /**
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML10() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(61L, out.getOffset());
    assertTrue(emoji.getChildren().isEmpty());
  }

  /**
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML11() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(60L, out.getOffset());
    assertTrue(emoji.getChildren().isEmpty());
  }

  /**
   * Method under test: {@link Emoji#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() throws InvalidInputException {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Emoji(new Bold(new BulletList(mock(Element.class))), 1)).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof EmojiNode);
    assertEquals(":", ((EmojiNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals(":", ((EmojiNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertNull(((EmojiNode) actualAsMarkdownResult).getAnnotation());
    assertNull(((EmojiNode) actualAsMarkdownResult).getShortcode());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Method under test: {@link Emoji#asText()}
   */
  @Test
  public void testAsText() {
    // Arrange, Act and Assert
    assertEquals(":null:", (new Emoji(new Bold(new BulletList(mock(Element.class))), 1)).asText());
  }

  /**
   * Method under test: {@link Emoji#asText()}
   */
  @Test
  public void testAsText2() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    emoji.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertEquals("", emoji.asText());
  }

  /**
   * Method under test: {@link Emoji#asText()}
   */
  @Test
  public void testAsText3() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    emoji.addChild(child);

    // Act and Assert
    assertEquals("", emoji.asText());
  }

  /**
   * Method under test: {@link Emoji#asText()}
   */
  @Test
  public void testAsText4() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    emoji.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));

    // Act and Assert
    assertEquals("$null", emoji.asText());
  }

  /**
   * Method under test: {@link Emoji#validate()}
   */
  @Test
  public void testValidate() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new Emoji(new Bold(new BulletList(mock(Element.class))), 1)).validate());
    assertThrows(InvalidInputException.class, () -> (new Emoji(new Bold(new BulletList(mock(Element.class))),
        "Either the attribute \"shortcode\" or \"annotation\" are required", 1)).validate());
  }

  /**
   * Method under test: {@link Emoji#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  public void testBuildAttribute() throws InvalidInputException {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> emoji.buildAttribute(parser, new IIOMetadataNode("foo")));
  }

  /**
   * Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Emoji emoji = new Emoji(parent, 1);
    BiContext context = new BiContext();

    // Act
    emoji.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("com.symphony.emoji", attributes.get("entity_type"));
    BiItem getResult2 = items.get(0);
    assertEquals("emojis", getResult2.getName());
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
    assertSame(parent, emoji.getParent());
  }

  /**
   * Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(new BulletList(new Bold(new BulletList(mock(Element.class)))));
    Emoji emoji = new Emoji(parent, 1);
    BiContext context = new BiContext();

    // Act
    emoji.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("com.symphony.emoji", attributes.get("entity_type"));
    BiItem getResult2 = items.get(0);
    assertEquals("emojis", getResult2.getName());
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
    assertSame(parent, emoji.getParent());
  }

  /**
   * Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Emoji emoji = new Emoji(parent, 1);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    emoji.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("com.symphony.emoji", attributes.get("entity_type"));
    BiItem getResult2 = items.get(1);
    assertEquals("emojis", getResult2.getName());
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
    assertSame(item, items.get(0));
    assertSame(parent, emoji.getParent());
  }

  /**
   * Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext4() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Emoji emoji = new Emoji(parent, 1);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    emoji.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(3);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("com.symphony.emoji", attributes.get("entity_type"));
    BiItem getResult2 = items.get(2);
    assertEquals("emojis", getResult2.getName());
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
    assertSame(item, items.get(0));
    assertSame(item2, items.get(1));
    assertSame(parent, emoji.getParent());
  }

  /**
   * Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext5() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Emoji emoji = new Emoji(parent, 1);

    BiContext context = new BiContext();
    BiItem item = new BiItem("emojis", Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    emoji.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("com.symphony.emoji", attributes.get("entity_type"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
    assertSame(item, items.get(0));
    assertSame(parent, emoji.getParent());
  }

  /**
   * Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext6() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Emoji emoji = new Emoji(parent, 1);

    BiContext context = new BiContext();
    context.addItemWithValue("emojis", "Item Value");
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    emoji.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(3);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("com.symphony.emoji", attributes.get("entity_type"));
    BiItem getResult2 = items.get(0);
    assertEquals("emojis", getResult2.getName());
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, emoji.getParent());
  }

  /**
   * Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext7() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Emoji emoji = new Emoji(parent, 1);

    BiContext context = new BiContext();
    context.addItemWithValue("emojis", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    emoji.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(3);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("com.symphony.emoji", attributes.get("entity_type"));
    BiItem getResult2 = items.get(0);
    assertEquals("emojis", getResult2.getName());
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, emoji.getParent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Emoji#toString()}
   *   <li>{@link Emoji#getAnnotation()}
   *   <li>{@link Emoji#getEntityIdPrefix()}
   *   <li>{@link Emoji#getEntitySubType()}
   *   <li>{@link Emoji#getEntityType()}
   *   <li>{@link Emoji#getEntityValue()}
   *   <li>{@link Emoji#getEntityVersion()}
   *   <li>{@link Emoji#getFamily()}
   *   <li>{@link Emoji#getShortCode()}
   *   <li>{@link Emoji#getSize()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(null)), 1);

    // Act
    String actualToStringResult = emoji.toString();
    String actualAnnotation = emoji.getAnnotation();
    String actualEntityIdPrefix = emoji.getEntityIdPrefix();
    String actualEntitySubType = emoji.getEntitySubType();
    String actualEntityType = emoji.getEntityType();
    String actualEntityValue = emoji.getEntityValue();
    String actualEntityVersion = emoji.getEntityVersion();
    String actualFamily = emoji.getFamily();
    String actualShortCode = emoji.getShortCode();

    // Assert
    assertEquals("1.0", actualEntityVersion);
    assertEquals("Emoji(null)", actualToStringResult);
    assertEquals("com.symphony.emoji", actualEntityType);
    assertEquals("normal", emoji.getSize());
    assertNull(actualAnnotation);
    assertNull(actualEntitySubType);
    assertNull(actualEntityValue);
    assertNull(actualFamily);
    assertNull(actualShortCode);
    assertEquals(Emoji.MESSAGEML_TAG, actualEntityIdPrefix);
  }

  /**
   * Method under test: {@link Emoji#Emoji(Element, int)}
   */
  @Test
  public void testNewEmoji() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Emoji actualEmoji = new Emoji(parent, 1);

    // Assert
    assertEquals("1.0", actualEmoji.getEntityVersion());
    assertEquals("com.symphony.emoji", actualEmoji.getEntityType());
    assertEquals("emoji1", actualEmoji.entityId);
    assertEquals("normal", actualEmoji.getSize());
    assertNull(actualEmoji.getAnnotation());
    assertNull(actualEmoji.getEntitySubType());
    assertNull(actualEmoji.getEntityValue());
    assertNull(actualEmoji.getFamily());
    assertNull(actualEmoji.getShortCode());
    assertEquals(0, actualEmoji.size());
    assertEquals(FormatEnum.MESSAGEML, actualEmoji.getFormat());
    assertTrue(actualEmoji.getChildren().isEmpty());
    assertTrue(actualEmoji.getAttributes().isEmpty());
    assertEquals(Emoji.MESSAGEML_TAG, actualEmoji.getMessageMLTag());
    assertEquals(Emoji.MESSAGEML_TAG, actualEmoji.getEntityIdPrefix());
    assertEquals(Span.MESSAGEML_TAG, actualEmoji.getPresentationMLTag());
    assertSame(parent, actualEmoji.getParent());
  }

  /**
   * Method under test: {@link Emoji#Emoji(Element, String, int)}
   */
  @Test
  public void testNewEmoji2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Emoji actualEmoji = new Emoji(parent, "Shortcode", 1);

    // Assert
    assertEquals("1.0", actualEmoji.getEntityVersion());
    assertEquals("Shortcode", actualEmoji.getAnnotation());
    assertEquals("Shortcode", actualEmoji.getEntityValue());
    assertEquals("Shortcode", actualEmoji.getShortCode());
    assertEquals("com.symphony.emoji", actualEmoji.getEntityType());
    assertEquals("emoji1", actualEmoji.entityId);
    assertEquals("normal", actualEmoji.getSize());
    assertNull(actualEmoji.getEntitySubType());
    assertNull(actualEmoji.getFamily());
    assertEquals(0, actualEmoji.size());
    assertEquals(FormatEnum.MESSAGEML, actualEmoji.getFormat());
    assertTrue(actualEmoji.getChildren().isEmpty());
    assertTrue(actualEmoji.getAttributes().isEmpty());
    assertEquals(Emoji.MESSAGEML_TAG, actualEmoji.getMessageMLTag());
    assertEquals(Emoji.MESSAGEML_TAG, actualEmoji.getEntityIdPrefix());
    assertEquals(Span.MESSAGEML_TAG, actualEmoji.getPresentationMLTag());
    assertSame(parent, actualEmoji.getParent());
  }
}
