package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.junit.Ignore;
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
   * Test {@link Emoji#Emoji(Element, int)}.
   * <p>
   * Method under test: {@link Emoji#Emoji(Element, int)}
   */
  @Test
  public void testNewEmoji() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Emoji actualEmoji = new Emoji(parent, 1);

    // Assert
    Element parent2 = actualEmoji.getParent();
    assertTrue(parent2 instanceof Bold);
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
    assertSame(parent, parent2);
  }

  /**
   * Test {@link Emoji#Emoji(Element, String, int)}.
   * <p>
   * Method under test: {@link Emoji#Emoji(Element, String, int)}
   */
  @Test
  public void testNewEmoji2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Emoji actualEmoji = new Emoji(parent, "Shortcode", 1);

    // Assert
    Element parent2 = actualEmoji.getParent();
    assertTrue(parent2 instanceof Bold);
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
    assertSame(parent, parent2);
  }

  /**
   * Test getters and setters.
   * <p>
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
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
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
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    emoji.addChild(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(67L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    emoji.addChild(new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(100L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    emoji.addChild(new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(88L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    emoji.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(80L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML6() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    emoji.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(120L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML7() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(63L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML8() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(61L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML9() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(60L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asMarkdown()}.
   * <p>
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
   * Test {@link Emoji#asText()}.
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is
   * {@link BulletList#BulletList(Element)} addChild {@link Bold#Bold(Element)}
   * with parent is {@link BulletList#BulletList(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Emoji#asText()}
   */
  @Test
  public void testAsText_givenBoldWithParentIsBulletListAddChildBoldWithParentIsBulletList() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    emoji.addChild(child);

    // Act and Assert
    assertEquals("", emoji.asText());
  }

  /**
   * Test {@link Emoji#asText()}.
   * <ul>
   *   <li>Given {@link Emoji#Emoji(Element, int)} with parent is
   * {@link Bold#Bold(Element)} and entityIndex is one.</li>
   *   <li>Then return {@code :null:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Emoji#asText()}
   */
  @Test
  public void testAsText_givenEmojiWithParentIsBoldAndEntityIndexIsOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals(":null:", (new Emoji(new Bold(new BulletList(mock(Element.class))), 1)).asText());
  }

  /**
   * Test {@link Emoji#asText()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Emoji#asText()}
   */
  @Test
  public void testAsText_thenReturnEmptyString() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    emoji.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertEquals("", emoji.asText());
  }

  /**
   * Test {@link Emoji#asText()}.
   * <ul>
   *   <li>Then return {@code $null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Emoji#asText()}
   */
  @Test
  public void testAsText_thenReturnNull() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    emoji.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));

    // Act and Assert
    assertEquals("$null", emoji.asText());
  }

  /**
   * Test {@link Emoji#asEntityJson(ObjectNode)}.
   * <ul>
   *   <li>Then iterator next return {@link ObjectNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Emoji#asEntityJson(ObjectNode)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAsEntityJson_thenIteratorNextReturnObjectNode() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);

    // Act
    ObjectNode actualAsEntityJsonResult = emoji
        .asEntityJson(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Assert
    Iterator<JsonNode> iteratorResult = actualAsEntityJsonResult.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    JsonNode nextResult3 = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertTrue(nextResult3 instanceof ObjectNode);
    assertTrue(nextResult instanceof TextNode);
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult3.traverse() instanceof TreeTraversingParser);
    assertTrue(actualAsEntityJsonResult.traverse() instanceof TreeTraversingParser);
    assertFalse(nextResult3.iterator().hasNext());
    assertFalse(actualHasNextResult);
  }

  /**
   * Test {@link Emoji#asEntityJson(ObjectNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Emoji#asEntityJson(ObjectNode)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAsEntityJson_whenNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.symphonyoss.symphony.messageml.elements.Emoji.asEntityJson(Emoji.java:121)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new Emoji(new Bold(new BulletList(mock(Element.class))), 1)).asEntityJson(null);
  }

  /**
   * Test {@link Emoji#validate()}.
   * <p>
   * Method under test: {@link Emoji#validate()}
   */
  @Test
  public void testValidate() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class, () -> (new Emoji(new Bold(new BulletList(mock(Element.class))),
        "Either the attribute \"shortcode\" or \"annotation\" are required", 1)).validate());
  }

  /**
   * Test {@link Emoji#validate()}.
   * <ul>
   *   <li>Given {@link Emoji#Emoji(Element, int)} with parent is
   * {@link Bold#Bold(Element)} and entityIndex is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Emoji#validate()}
   */
  @Test
  public void testValidate_givenEmojiWithParentIsBoldAndEntityIndexIsOne() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new Emoji(new Bold(new BulletList(mock(Element.class))), 1)).validate());
  }

  /**
   * Test {@link Emoji#buildAttribute(MessageMLParser, Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Emoji#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> emoji.buildAttribute(parser, new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link Emoji#updateBiContext(BiContext)}.
   * <p>
   * Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);

    BiContext context = new BiContext();
    context.addItemWithValue("emojis", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    emoji.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(3);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("com.symphony.emoji", attributes.get("entity_type"));
    BiItem getResult2 = items.get(1);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
    assertEquals(Element.STYLE_ATTR, getResult2.getName());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
  }

  /**
   * Test {@link Emoji#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Given {@link BulletList#BulletList(Element)} with parent is
   * {@link Bold#Bold(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_givenBulletListWithParentIsBold() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(new Bold(new BulletList(mock(Element.class))))), 1);
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
    assertEquals(1, ((Integer) attributes2.get("count")).intValue());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
  }

  /**
   * Test {@link Emoji#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Given {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_givenItemValue() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);

    BiContext context = new BiContext();
    context.addItemWithValue("emojis", "Item Value");
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    emoji.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(3);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("com.symphony.emoji", attributes.get("entity_type"));
    BiItem getResult2 = items.get(1);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
    assertEquals(Element.STYLE_ATTR, getResult2.getName());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
  }

  /**
   * Test {@link Emoji#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);

    BiContext context = new BiContext();
    context.addItem(new BiItem("emojis", Element.STYLE_ATTR));

    // Act
    emoji.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("com.symphony.emoji", attributes.get("entity_type"));
    Map<String, Object> attributes2 = items.get(0).getAttributes();
    assertEquals(2, attributes2.size());
    assertEquals(1, ((Integer) attributes2.get("count")).intValue());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
  }

  /**
   * Test {@link Emoji#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsSizeIsThree() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

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
    assertEquals(1, ((Integer) attributes2.get("count")).intValue());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
  }

  /**
   * Test {@link Emoji#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is
   * {@code emojis}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsEmojis() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    emoji.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(2);
    assertEquals("emojis", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Emoji#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is
   * {@code emojis}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsEmojis() {
    // Arrange
    Emoji emoji = new Emoji(new Bold(new BulletList(mock(Element.class))), 1);
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
    assertEquals(1, ((Integer) attributes2.get("count")).intValue());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
  }
}
