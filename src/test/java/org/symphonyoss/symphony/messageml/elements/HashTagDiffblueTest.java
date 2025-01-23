package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import java.util.Map;
import org.commonmark.node.Node;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.KeywordNode;

public class HashTagDiffblueTest {
  /**
   * Test {@link HashTag#HashTag(Element, int)}.
   * <p>
   * Method under test: {@link HashTag#HashTag(Element, int)}
   */
  @Test
  public void testNewHashTag() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    HashTag actualHashTag = new HashTag(parent, 1);

    // Assert
    Element parent2 = actualHashTag.getParent();
    assertTrue(parent2 instanceof Bold);
    assertEquals("1.0", actualHashTag.getEntityVersion());
    assertEquals("keyword", actualHashTag.getEntityIdPrefix());
    assertEquals("keyword1", actualHashTag.entityId);
    assertEquals("org.symphonyoss.taxonomy.hashtag", actualHashTag.getEntitySubType());
    assertNull(actualHashTag.getEntityValue());
    assertEquals(0, actualHashTag.size());
    assertEquals(FormatEnum.MESSAGEML, actualHashTag.getFormat());
    assertTrue(actualHashTag.getChildren().isEmpty());
    assertTrue(actualHashTag.getAttributes().isEmpty());
    assertEquals(HashTag.ENTITY_TYPE, actualHashTag.getEntityType());
    assertEquals(HashTag.HASHTAG_PATTERN, actualHashTag.getTagPattern());
    assertEquals(HashTag.MESSAGEML_TAG, actualHashTag.getMessageMLTag());
    assertEquals(Span.MESSAGEML_TAG, actualHashTag.getPresentationMLTag());
    assertSame(parent, parent2);
  }

  /**
   * Test {@link HashTag#HashTag(Element, int, String)}.
   * <p>
   * Method under test: {@link HashTag#HashTag(Element, int, String)}
   */
  @Test
  public void testNewHashTag2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    HashTag actualHashTag = new HashTag(parent, 1, "42");

    // Assert
    Element parent2 = actualHashTag.getParent();
    assertTrue(parent2 instanceof Bold);
    assertEquals("1.0", actualHashTag.getEntityVersion());
    assertEquals("42", actualHashTag.getEntityValue());
    assertEquals("keyword", actualHashTag.getEntityIdPrefix());
    assertEquals("keyword1", actualHashTag.entityId);
    assertEquals("org.symphonyoss.taxonomy.hashtag", actualHashTag.getEntitySubType());
    assertEquals(0, actualHashTag.size());
    assertEquals(FormatEnum.MESSAGEML, actualHashTag.getFormat());
    assertTrue(actualHashTag.getChildren().isEmpty());
    assertTrue(actualHashTag.getAttributes().isEmpty());
    assertEquals(HashTag.ENTITY_TYPE, actualHashTag.getEntityType());
    assertEquals(HashTag.HASHTAG_PATTERN, actualHashTag.getTagPattern());
    assertEquals(HashTag.MESSAGEML_TAG, actualHashTag.getMessageMLTag());
    assertEquals(Span.MESSAGEML_TAG, actualHashTag.getPresentationMLTag());
    assertSame(parent, parent2);
  }

  /**
   * Test {@link HashTag#HashTag(Element, String, String)}.
   * <p>
   * Method under test: {@link HashTag#HashTag(Element, String, String)}
   */
  @Test
  public void testNewHashTag3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    HashTag actualHashTag = new HashTag(parent, "Presentation Ml Tag", "42");

    // Assert
    Element parent2 = actualHashTag.getParent();
    assertTrue(parent2 instanceof Bold);
    assertEquals("1.0", actualHashTag.getEntityVersion());
    assertEquals("42", actualHashTag.getEntityValue());
    assertEquals("Presentation Ml Tag", actualHashTag.getPresentationMLTag());
    assertEquals("keyword", actualHashTag.getEntityIdPrefix());
    assertEquals("org.symphonyoss.taxonomy.hashtag", actualHashTag.getEntitySubType());
    assertNull(actualHashTag.entityId);
    assertEquals(0, actualHashTag.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualHashTag.getFormat());
    assertTrue(actualHashTag.getChildren().isEmpty());
    assertTrue(actualHashTag.getAttributes().isEmpty());
    assertEquals(HashTag.ENTITY_TYPE, actualHashTag.getEntityType());
    assertEquals(HashTag.HASHTAG_PATTERN, actualHashTag.getTagPattern());
    assertEquals(HashTag.MESSAGEML_TAG, actualHashTag.getMessageMLTag());
    assertSame(parent, parent2);
  }

  /**
   * Test {@link HashTag#validate()}.
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashTag#validate()}
   */
  @Test
  public void testValidate_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new HashTag(new Bold(new BulletList(mock(Element.class))), 1, HashTag.PREFIX)).validate());
  }

  /**
   * Test {@link HashTag#asText()}.
   * <p>
   * Method under test: {@link HashTag#asText()}
   */
  @Test
  public void testAsText() {
    // Arrange, Act and Assert
    assertEquals("#null", (new HashTag(new Bold(new BulletList(mock(Element.class))), 1)).asText());
  }

  /**
   * Test {@link HashTag#asMarkdown()}.
   * <p>
   * Method under test: {@link HashTag#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new HashTag(new Bold(new BulletList(mock(Element.class))), 1)).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof KeywordNode);
    assertNull(((KeywordNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertEquals(HashTag.PREFIX, ((KeywordNode) actualAsMarkdownResult).getPrefix());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HashTag#toString()}
   *   <li>{@link HashTag#getEntitySubType()}
   *   <li>{@link HashTag#getEntityType()}
   *   <li>{@link HashTag#getEntityVersion()}
   *   <li>{@link HashTag#getTagPattern()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    HashTag hashTag = new HashTag(new Bold(new BulletList(null)), 1);

    // Act
    String actualToStringResult = hashTag.toString();
    String actualEntitySubType = hashTag.getEntitySubType();
    String actualEntityType = hashTag.getEntityType();
    String actualEntityVersion = hashTag.getEntityVersion();

    // Assert
    assertEquals("1.0", actualEntityVersion);
    assertEquals("HashTag(null)", actualToStringResult);
    assertEquals("org.symphonyoss.taxonomy.hashtag", actualEntitySubType);
    assertEquals(HashTag.ENTITY_TYPE, actualEntityType);
    assertEquals(HashTag.HASHTAG_PATTERN, hashTag.getTagPattern());
  }

  /**
   * Test {@link HashTag#updateBiContext(BiContext)}.
   * <p>
   * Method under test: {@link HashTag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    HashTag hashTag = new HashTag(new Bold(new BulletList(mock(Element.class))), 1);

    BiContext context = new BiContext();
    context.addItemWithValue("hashtags", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    hashTag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(3);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("org.symphonyoss.taxonomy.hashtag", attributes.get("entity_type"));
    BiItem getResult2 = items.get(1);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
    assertEquals(Element.STYLE_ATTR, getResult2.getName());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
  }

  /**
   * Test {@link HashTag#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Given {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashTag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_givenItemValue() {
    // Arrange
    HashTag hashTag = new HashTag(new Bold(new BulletList(mock(Element.class))), 1);

    BiContext context = new BiContext();
    context.addItemWithValue("hashtags", "Item Value");
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    hashTag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(3);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("org.symphonyoss.taxonomy.hashtag", attributes.get("entity_type"));
    BiItem getResult2 = items.get(1);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
    assertEquals(Element.STYLE_ATTR, getResult2.getName());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
  }

  /**
   * Test {@link HashTag#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashTag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    HashTag hashTag = new HashTag(new Bold(new BulletList(mock(Element.class))), 1);

    BiContext context = new BiContext();
    context.addItem(new BiItem("hashtags", Element.STYLE_ATTR));

    // Act
    hashTag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("org.symphonyoss.taxonomy.hashtag", attributes.get("entity_type"));
    Map<String, Object> attributes2 = items.get(0).getAttributes();
    assertEquals(2, attributes2.size());
    assertEquals(1, ((Integer) attributes2.get("count")).intValue());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
  }

  /**
   * Test {@link HashTag#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashTag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsSizeIsThree() {
    // Arrange
    HashTag hashTag = new HashTag(new Bold(new BulletList(mock(Element.class))), 1);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    hashTag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(1);
    assertEquals("hashtags", getResult.getName());
    BiItem getResult2 = items.get(2);
    Map<String, Object> attributes = getResult2.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("org.symphonyoss.taxonomy.hashtag", attributes.get("entity_type"));
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertEquals(1, ((Integer) attributes2.get("count")).intValue());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
  }

  /**
   * Test {@link HashTag#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is
   * {@code hashtags}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashTag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsHashtags() {
    // Arrange
    HashTag hashTag = new HashTag(new Bold(new BulletList(mock(Element.class))), 1);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    hashTag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(2);
    assertEquals("hashtags", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link HashTag#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is
   * {@code hashtags}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashTag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsHashtags() {
    // Arrange
    HashTag hashTag = new HashTag(new Bold(new BulletList(mock(Element.class))), 1);
    BiContext context = new BiContext();

    // Act
    hashTag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(0);
    assertEquals("hashtags", getResult.getName());
    BiItem getResult2 = items.get(1);
    Map<String, Object> attributes = getResult2.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("org.symphonyoss.taxonomy.hashtag", attributes.get("entity_type"));
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertEquals(1, ((Integer) attributes2.get("count")).intValue());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
  }
}
