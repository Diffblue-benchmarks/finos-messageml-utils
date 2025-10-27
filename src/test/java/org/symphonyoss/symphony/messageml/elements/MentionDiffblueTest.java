package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.IDataProvider;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class MentionDiffblueTest {
  /**
   * Method under test:
   * {@link Mention#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Mention mention = new Mention(parent, 1, new NoOpDataProvider());
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    mention.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert that nothing has changed
    assertEquals(0L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Mention#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Mention mention = new Mention(parent, 1, 1L, new NoOpDataProvider());
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    mention.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(58L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Mention#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Mention mention = new Mention(parent, 1, 1L, new NoOpDataProvider());

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    mention.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(58L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Mention#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Mention mention = new Mention(parent, 1, 1L, new NoOpDataProvider());

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    mention.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(57L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Mention#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Mention mention = new Mention(parent, 1, 1L, new NoOpDataProvider());

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    mention.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(56L, out.getOffset());
  }

  /**
   * Method under test: {@link Mention#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> (new Mention(parent, 1, new NoOpDataProvider())).asMarkdown());
  }

  /**
   * Method under test: {@link Mention#asMarkdown()}
   */
  @Test
  public void testAsMarkdown2() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Node actualAsMarkdownResult = (new Mention(parent, 1, 1L, new NoOpDataProvider())).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof Text);
    assertEquals("1", ((Text) actualAsMarkdownResult).getLiteral());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Method under test: {@link Mention#asEntityJson(ObjectNode)}
   */
  @Test
  public void testAsEntityJson() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Mention mention = new Mention(parent, 1, new NoOpDataProvider());
    ObjectNode parent2 = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    ObjectNode actualAsEntityJsonResult = mention.asEntityJson(parent2);

    // Assert
    assertEquals("{ }", parent2.toPrettyString());
    assertNull(actualAsEntityJsonResult);
    assertEquals(0, parent2.size());
    assertFalse(parent2.iterator().hasNext());
    assertTrue(parent2.isEmpty());
  }

  /**
   * Method under test: {@link Mention#toString()}
   */
  @Test
  public void testToString() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act and Assert
    assertEquals("Mention(NULL)", (new Mention(parent, 1, new NoOpDataProvider())).toString());
  }

  /**
   * Method under test: {@link Mention#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act and Assert
    assertEquals("Mention(1)", (new Mention(parent, 1, 1L, new NoOpDataProvider())).toString());
  }

  /**
   * Method under test: {@link Mention#getEntityValue()}
   */
  @Test
  public void testGetEntityValue() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act and Assert
    assertNull((new Mention(parent, 1, new NoOpDataProvider())).getEntityValue());
  }

  /**
   * Method under test: {@link Mention#getEntityValue()}
   */
  @Test
  public void testGetEntityValue2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act and Assert
    assertEquals("1", (new Mention(parent, 1, 1L, new NoOpDataProvider())).getEntityValue());
  }

  /**
   * Method under test: {@link Mention#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Mention mention = new Mention(parent, 1, new NoOpDataProvider());
    BiContext context = new BiContext();

    // Act
    mention.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(0);
    assertEquals("mentions", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    BiItem getResult2 = items.get(1);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertEquals(Mention.ENTITY_TYPE, attributes2.get("entity_type"));
    assertSame(parent, mention.getParent());
  }

  /**
   * Method under test: {@link Mention#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Mention mention = new Mention(parent, 1, new NoOpDataProvider());

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    mention.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(1);
    assertEquals("mentions", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    BiItem getResult2 = items.get(2);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertEquals(Mention.ENTITY_TYPE, attributes2.get("entity_type"));
    assertSame(item, items.get(0));
    assertSame(parent, mention.getParent());
  }

  /**
   * Method under test: {@link Mention#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Mention mention = new Mention(parent, 1, new NoOpDataProvider());

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    mention.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(2);
    assertEquals("mentions", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    BiItem getResult2 = items.get(3);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertEquals(Mention.ENTITY_TYPE, attributes2.get("entity_type"));
    assertSame(item, items.get(0));
    assertSame(item2, items.get(1));
    assertSame(parent, mention.getParent());
  }

  /**
   * Method under test: {@link Mention#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext4() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Mention mention = new Mention(parent, 1, new NoOpDataProvider());

    BiContext context = new BiContext();
    BiItem item = new BiItem("mentions", Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    mention.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
    assertEquals(Mention.ENTITY_TYPE, attributes.get("entity_type"));
    assertSame(item, items.get(0));
    assertSame(parent, mention.getParent());
  }

  /**
   * Method under test: {@link Mention#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext5() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Mention mention = new Mention(parent, 1, new NoOpDataProvider());

    BiContext context = new BiContext();
    context.addItemWithValue("mentions", "Item Value");
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    mention.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(0);
    assertEquals("mentions", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    BiItem getResult2 = items.get(3);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertEquals(Mention.ENTITY_TYPE, attributes2.get("entity_type"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, mention.getParent());
  }

  /**
   * Method under test: {@link Mention#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext6() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Mention mention = new Mention(parent, 1, new NoOpDataProvider());

    BiContext context = new BiContext();
    context.addItemWithValue("mentions", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    mention.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(0);
    assertEquals("mentions", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    BiItem getResult2 = items.get(3);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertEquals(Mention.ENTITY_TYPE, attributes2.get("entity_type"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, mention.getParent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Mention#getEntityIdPrefix()}
   *   <li>{@link Mention#getEntitySubType()}
   *   <li>{@link Mention#getEntityType()}
   *   <li>{@link Mention#getEntityVersion()}
   *   <li>{@link Mention#getUserPresentation()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    Mention mention = new Mention(parent, 1, new NoOpDataProvider());

    // Act
    String actualEntityIdPrefix = mention.getEntityIdPrefix();
    String actualEntitySubType = mention.getEntitySubType();
    String actualEntityType = mention.getEntityType();
    String actualEntityVersion = mention.getEntityVersion();

    // Assert
    assertEquals("1.0", actualEntityVersion);
    assertEquals("com.symphony.user.userId", actualEntitySubType);
    assertNull(mention.getUserPresentation());
    assertEquals(Mention.ENTITY_TYPE, actualEntityType);
    assertEquals(Mention.MESSAGEML_TAG, actualEntityIdPrefix);
  }

  /**
   * Method under test: {@link Mention#Mention(Element, int, Long, IDataProvider)}
   */
  @Test
  public void testNewMention() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Mention actualMention = new Mention(parent, 1, 1L, new NoOpDataProvider());

    // Assert
    assertEquals("1", actualMention.getEntityValue());
    assertEquals("1.0", actualMention.getEntityVersion());
    assertEquals("com.symphony.user.userId", actualMention.getEntitySubType());
    assertEquals("mention1", actualMention.entityId);
    assertNull(actualMention.getUserPresentation());
    assertEquals(0, actualMention.size());
    assertEquals(FormatEnum.MESSAGEML, actualMention.getFormat());
    assertTrue(actualMention.getChildren().isEmpty());
    assertTrue(actualMention.getAttributes().isEmpty());
    assertEquals(Mention.ENTITY_TYPE, actualMention.getEntityType());
    assertEquals(Mention.MESSAGEML_TAG, actualMention.getMessageMLTag());
    assertEquals(Mention.MESSAGEML_TAG, actualMention.getEntityIdPrefix());
    assertEquals(Span.MESSAGEML_TAG, actualMention.getPresentationMLTag());
    assertSame(parent, actualMention.getParent());
  }

  /**
   * Method under test: {@link Mention#Mention(Element, int, IDataProvider)}
   */
  @Test
  public void testNewMention2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Mention actualMention = new Mention(parent, 1, new NoOpDataProvider());

    // Assert
    assertEquals("1.0", actualMention.getEntityVersion());
    assertEquals("com.symphony.user.userId", actualMention.getEntitySubType());
    assertEquals("mention1", actualMention.entityId);
    assertNull(actualMention.getEntityValue());
    assertNull(actualMention.getUserPresentation());
    assertEquals(0, actualMention.size());
    assertEquals(FormatEnum.MESSAGEML, actualMention.getFormat());
    assertTrue(actualMention.getChildren().isEmpty());
    assertTrue(actualMention.getAttributes().isEmpty());
    assertEquals(Mention.ENTITY_TYPE, actualMention.getEntityType());
    assertEquals(Mention.MESSAGEML_TAG, actualMention.getMessageMLTag());
    assertEquals(Mention.MESSAGEML_TAG, actualMention.getEntityIdPrefix());
    assertEquals(Span.MESSAGEML_TAG, actualMention.getPresentationMLTag());
    assertSame(parent, actualMention.getParent());
  }

  /**
   * Method under test:
   * {@link Mention#Mention(Element, String, Long, IDataProvider)}
   */
  @Test
  public void testNewMention3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Mention actualMention = new Mention(parent, "Presentation Ml Tag", 1L, new NoOpDataProvider());

    // Assert
    assertEquals("1", actualMention.getEntityValue());
    assertEquals("1.0", actualMention.getEntityVersion());
    assertEquals("Presentation Ml Tag", actualMention.getPresentationMLTag());
    assertEquals("com.symphony.user.userId", actualMention.getEntitySubType());
    assertEquals("mention0", actualMention.entityId);
    assertNull(actualMention.getUserPresentation());
    assertEquals(0, actualMention.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualMention.getFormat());
    assertTrue(actualMention.getChildren().isEmpty());
    assertTrue(actualMention.getAttributes().isEmpty());
    assertEquals(Mention.ENTITY_TYPE, actualMention.getEntityType());
    assertEquals(Mention.MESSAGEML_TAG, actualMention.getMessageMLTag());
    assertEquals(Mention.MESSAGEML_TAG, actualMention.getEntityIdPrefix());
    assertSame(parent, actualMention.getParent());
  }
}
