package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.IDataProvider;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class MentionDiffblueTest {
  /**
   * Test {@link Mention#Mention(Element, int, Long, IDataProvider)}.
   * <p>
   * Method under test: {@link Mention#Mention(Element, int, Long, IDataProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Mention.<init>(Element, int, Long, IDataProvider)"})
  public void testNewMention() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Mention actualMention = new Mention(parent, 1, 1L, new NoOpDataProvider());

    // Assert
    Element parent2 = actualMention.getParent();
    assertTrue(parent2 instanceof Bold);
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
    assertSame(parent, parent2);
  }

  /**
   * Test {@link Mention#Mention(Element, int, IDataProvider)}.
   * <p>
   * Method under test: {@link Mention#Mention(Element, int, IDataProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Mention.<init>(Element, int, IDataProvider)"})
  public void testNewMention2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Mention actualMention = new Mention(parent, 1, new NoOpDataProvider());

    // Assert
    Element parent2 = actualMention.getParent();
    assertTrue(parent2 instanceof Bold);
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
    assertSame(parent, parent2);
  }

  /**
   * Test {@link Mention#Mention(Element, String, Long, IDataProvider)}.
   * <p>
   * Method under test: {@link Mention#Mention(Element, String, Long, IDataProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Mention.<init>(Element, String, Long, IDataProvider)"})
  public void testNewMention3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Mention actualMention = new Mention(parent, "Presentation Ml Tag", 1L, new NoOpDataProvider());

    // Assert
    Element parent2 = actualMention.getParent();
    assertTrue(parent2 instanceof Bold);
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
    assertSame(parent, parent2);
  }

  /**
   * Test {@link Mention#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Mention#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Mention.asPresentationML(XmlPrintStream, MessageMLContext)"})
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
   * Test {@link Mention#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Mention#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Mention.asPresentationML(XmlPrintStream, MessageMLContext)"})
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
   * Test {@link Mention#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Mention#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Mention.asPresentationML(XmlPrintStream, MessageMLContext)"})
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
   * Test {@link Mention#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Mention#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Mention.asPresentationML(XmlPrintStream, MessageMLContext)"})
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
   * Test {@link Mention#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Mention#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Mention.asPresentationML(XmlPrintStream, MessageMLContext)"})
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
   * Test {@link Mention#asMarkdown()}.
   * <ul>
   *   <li>Then return {@link Text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Mention#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Mention.asMarkdown()"})
  public void testAsMarkdown_thenReturnText() throws InvalidInputException {
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
   * Test {@link Mention#asMarkdown()}.
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Mention#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Mention.asMarkdown()"})
  public void testAsMarkdown_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> (new Mention(parent, 1, new NoOpDataProvider())).asMarkdown());
  }

  /**
   * Test {@link Mention#asEntityJson(ObjectNode)}.
   * <p>
   * Method under test: {@link Mention#asEntityJson(ObjectNode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ObjectNode Mention.asEntityJson(ObjectNode)"})
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
   * Test {@link Mention#toString()}.
   * <ul>
   *   <li>Then return {@code Mention(1)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Mention#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Mention.toString()"})
  public void testToString_thenReturnMention1() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act and Assert
    assertEquals("Mention(1)", (new Mention(parent, 1, 1L, new NoOpDataProvider())).toString());
  }

  /**
   * Test {@link Mention#toString()}.
   * <ul>
   *   <li>Then return {@code Mention(NULL)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Mention#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Mention.toString()"})
  public void testToString_thenReturnMentionNull() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act and Assert
    assertEquals("Mention(NULL)", (new Mention(parent, 1, new NoOpDataProvider())).toString());
  }

  /**
   * Test {@link Mention#validate()}.
   * <ul>
   *   <li>Then calls {@link NoOpDataProvider#getUserPresentation(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Mention#validate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Mention.validate()"})
  public void testValidate_thenCallsGetUserPresentation() throws InvalidInputException {
    // Arrange
    NoOpDataProvider dataProvider = mock(NoOpDataProvider.class);
    when(dataProvider.getUserPresentation(Mockito.<Long>any()))
        .thenThrow(new InvalidInputException("An error occurred"));

    // Act
    (new Mention(new Bold(new BulletList(null)), 1, 1L, dataProvider)).validate();

    // Assert
    verify(dataProvider).getUserPresentation(eq(1L));
  }

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Mention.getEntityIdPrefix()", "String Mention.getEntitySubType()",
      "String Mention.getEntityType()", "String Mention.getEntityVersion()",
      "org.symphonyoss.symphony.messageml.util.IUserPresentation Mention.getUserPresentation()"})
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
   * Test {@link Mention#getEntityValue()}.
   * <ul>
   *   <li>Then return {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Mention#getEntityValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Mention.getEntityValue()"})
  public void testGetEntityValue_thenReturn1() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act and Assert
    assertEquals("1", (new Mention(parent, 1, 1L, new NoOpDataProvider())).getEntityValue());
  }

  /**
   * Test {@link Mention#getEntityValue()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Mention#getEntityValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Mention.getEntityValue()"})
  public void testGetEntityValue_thenReturnNull() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act and Assert
    assertNull((new Mention(parent, 1, new NoOpDataProvider())).getEntityValue());
  }

  /**
   * Test {@link Mention#updateBiContext(BiContext)}.
   * <p>
   * Method under test: {@link Mention#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Mention.updateBiContext(BiContext)"})
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Mention mention = new Mention(parent, 1, new NoOpDataProvider());

    BiContext context = new BiContext();
    context.addItemWithValue("mentions", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    mention.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    BiItem getResult2 = items.get(3);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey(Element.STYLE_ATTR));
    assertEquals(Element.STYLE_ATTR, getResult.getName());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertEquals(Mention.ENTITY_TYPE, attributes2.get("entity_type"));
  }

  /**
   * Test {@link Mention#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Given {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Mention#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Mention.updateBiContext(BiContext)"})
  public void testUpdateBiContext_givenItemValue() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Mention mention = new Mention(parent, 1, new NoOpDataProvider());

    BiContext context = new BiContext();
    context.addItemWithValue("mentions", "Item Value");
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    mention.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    BiItem getResult2 = items.get(3);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey(Element.STYLE_ATTR));
    assertEquals(Element.STYLE_ATTR, getResult.getName());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertEquals(Mention.ENTITY_TYPE, attributes2.get("entity_type"));
  }

  /**
   * Test {@link Mention#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Mention#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Mention.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Mention mention = new Mention(parent, 1, new NoOpDataProvider());

    BiContext context = new BiContext();
    context.addItem(new BiItem("mentions", Element.STYLE_ATTR));

    // Act
    mention.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes.containsKey(Element.STYLE_ATTR));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
    assertEquals(Mention.ENTITY_TYPE, attributes2.get("entity_type"));
  }

  /**
   * Test {@link Mention#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Mention#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Mention.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsThree() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Mention mention = new Mention(parent, 1, new NoOpDataProvider());

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    mention.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(1);
    assertEquals("mentions", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    BiItem getResult2 = items.get(2);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertEquals(Mention.ENTITY_TYPE, attributes2.get("entity_type"));
  }

  /**
   * Test {@link Mention#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is {@code mentions}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Mention#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Mention.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsMentions() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Mention mention = new Mention(parent, 1, new NoOpDataProvider());

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    mention.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(2);
    assertEquals("mentions", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Mention#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is {@code mentions}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Mention#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Mention.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsMentions() {
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
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    BiItem getResult2 = items.get(1);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertEquals(Mention.ENTITY_TYPE, attributes2.get("entity_type"));
  }
}
