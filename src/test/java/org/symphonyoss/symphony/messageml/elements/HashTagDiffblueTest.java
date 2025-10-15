package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.KeywordNode;

public class HashTagDiffblueTest {
  /**
   * Test {@link HashTag#HashTag(Element, int)}.
   *
   * <p>Method under test: {@link HashTag#HashTag(Element, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.<init>(Element, int)"})
  public void testNewHashTag() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    HashTag actualHashTag = new HashTag(parent2, 1);

    // Assert
    Element parent3 = actualHashTag.getParent();
    assertTrue(parent3 instanceof Bold);
    assertEquals("1.0", actualHashTag.getEntityVersion());
    assertEquals("keyword", actualHashTag.getEntityIdPrefix());
    assertEquals("keyword1", actualHashTag.entityId);
    assertEquals("org.symphonyoss.taxonomy.hashtag", actualHashTag.getEntitySubType());
    assertNull(actualHashTag.getTag());
    assertNull(actualHashTag.getEntityValue());
    assertEquals(0, actualHashTag.size());
    assertEquals(FormatEnum.MESSAGEML, actualHashTag.getFormat());
    assertTrue(actualHashTag.getChildren().isEmpty());
    assertTrue(actualHashTag.getAttributes().isEmpty());
    assertEquals(HashTag.ENTITY_TYPE, actualHashTag.getEntityType());
    assertEquals(HashTag.HASHTAG_PATTERN, actualHashTag.getTagPattern());
    assertEquals(HashTag.MESSAGEML_TAG, actualHashTag.getMessageMLTag());
    assertEquals(Span.MESSAGEML_TAG, actualHashTag.getPresentationMLTag());
    assertSame(parent2, parent3);
  }

  /**
   * Test {@link HashTag#HashTag(Element, int, String)}.
   *
   * <p>Method under test: {@link HashTag#HashTag(Element, int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.<init>(Element, int, String)"})
  public void testNewHashTag2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    HashTag actualHashTag = new HashTag(parent2, 1, "42");

    // Assert
    Element parent3 = actualHashTag.getParent();
    assertTrue(parent3 instanceof Bold);
    assertEquals("1.0", actualHashTag.getEntityVersion());
    assertEquals("42", actualHashTag.getTag());
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
    assertSame(parent2, parent3);
  }

  /**
   * Test {@link HashTag#HashTag(Element, String, String)}.
   *
   * <p>Method under test: {@link HashTag#HashTag(Element, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.<init>(Element, String, String)"})
  public void testNewHashTag3() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    HashTag actualHashTag = new HashTag(parent2, "Presentation Ml Tag", "42");

    // Assert
    Element parent3 = actualHashTag.getParent();
    assertTrue(parent3 instanceof Bold);
    assertEquals("1.0", actualHashTag.getEntityVersion());
    assertEquals("42", actualHashTag.getTag());
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
    assertSame(parent2, parent3);
  }

  /**
   * Test {@link HashTag#validate()}.
   *
   * <p>Method under test: {@link HashTag#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.validate()"})
  public void testValidate() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    new HashTag(parent, 1, HashTag.HASHTAG_PATTERN).validate();
  }

  /**
   * Test {@link HashTag#validate()}.
   *
   * <p>Method under test: {@link HashTag#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.validate()"})
  public void testValidate2() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    new HashTag(parent, 1, HashTag.MESSAGEML_TAG).validate();
  }

  /**
   * Test {@link HashTag#validate()}.
   *
   * <p>Method under test: {@link HashTag#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.validate()"})
  public void testValidate3() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    new HashTag(parent, 1, Span.MESSAGEML_TAG).validate();
  }

  /**
   * Test {@link HashTag#validate()}.
   *
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is {@code null}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link HashTag#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.validate()"})
  public void testValidate_givenBoldWithParentIsNull_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    HashTag hashTag = new HashTag(new Bold(null), "UUU", "42");

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> hashTag.validate());
  }

  /**
   * Test {@link HashTag#validate()}.
   *
   * <ul>
   *   <li>Given {@link HashTag#HashTag(Element, int, String)} with parent is {@link
   *       Bold#Bold(Element)} and entityIndex is one and {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link HashTag#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.validate()"})
  public void testValidate_givenHashTagWithParentIsBoldAndEntityIndexIsOneAndValue()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    new HashTag(parent, 1, "Value").validate();
  }

  /**
   * Test {@link HashTag#validate()}.
   *
   * <ul>
   *   <li>Given {@link HashTag#HashTag(Element, int, String)} with parent is {@link
   *       Bold#Bold(Element)} and entityIndex is one and value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link HashTag#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.validate()"})
  public void testValidate_givenHashTagWithParentIsBoldAndEntityIndexIsOneAndValueIs42()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    new HashTag(parent, 1, "42").validate();
  }

  /**
   * Test {@link HashTag#validate()}.
   *
   * <ul>
   *   <li>Given {@link HashTag#HashTag(Element, int, String)} with parent is {@link
   *       Bold#Bold(Element)} and entityIndex is one and value is {@link HashTag#PREFIX}.
   * </ul>
   *
   * <p>Method under test: {@link HashTag#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.validate()"})
  public void testValidate_givenHashTagWithParentIsBoldAndEntityIndexIsOneAndValueIsPrefix()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> new HashTag(parent, 1, HashTag.PREFIX).validate());
  }

  /**
   * Test {@link HashTag#validate()}.
   *
   * <ul>
   *   <li>Given {@link HashTag#HashTag(Element, int, String)} with parent is {@link
   *       Bold#Bold(Element)} and entityIndex is one and value is {@code UUU}.
   * </ul>
   *
   * <p>Method under test: {@link HashTag#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.validate()"})
  public void testValidate_givenHashTagWithParentIsBoldAndEntityIndexIsOneAndValueIsUuu()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    new HashTag(parent, 1, "UUU").validate();
  }

  /**
   * Test {@link HashTag#asText()}.
   *
   * <p>Method under test: {@link HashTag#asText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String HashTag.asText()"})
  public void testAsText() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertEquals("#null", new HashTag(parent2, 1).asText());
  }

  /**
   * Test {@link HashTag#asMarkdown()}.
   *
   * <p>Method under test: {@link HashTag#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node HashTag.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new HashTag(parent2, 1).asMarkdown();

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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HashTag#toString()}
   *   <li>{@link HashTag#getEntitySubType()}
   *   <li>{@link HashTag#getEntityType()}
   *   <li>{@link HashTag#getEntityVersion()}
   *   <li>{@link HashTag#getTagPattern()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String HashTag.getEntitySubType()",
    "String HashTag.getEntityType()",
    "String HashTag.getEntityVersion()",
    "String HashTag.getTagPattern()",
    "String HashTag.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    HashTag hashTag = new HashTag(parent, 1);

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
   *
   * <p>Method under test: {@link HashTag#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.updateBiContext(BiContext)"})
  public void testUpdateBiContext() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    HashTag hashTag = new HashTag(parent2, 1);

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
   *
   * <ul>
   *   <li>Given {@code Item Value}.
   * </ul>
   *
   * <p>Method under test: {@link HashTag#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.updateBiContext(BiContext)"})
  public void testUpdateBiContext_givenItemValue() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    HashTag hashTag = new HashTag(parent2, 1);

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size is two.
   * </ul>
   *
   * <p>Method under test: {@link HashTag#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    HashTag hashTag = new HashTag(parent2, 1);

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is three.
   * </ul>
   *
   * <p>Method under test: {@link HashTag#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsThree() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    HashTag hashTag = new HashTag(parent2, 1);

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is {@code hashtags}.
   * </ul>
   *
   * <p>Method under test: {@link HashTag#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsHashtags() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    HashTag hashTag = new HashTag(parent2, 1);

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
   *
   * <ul>
   *   <li>When {@link BiContext} (default constructor).
   *   <li>Then {@link BiContext} (default constructor) Items first Name is {@code hashtags}.
   * </ul>
   *
   * <p>Method under test: {@link HashTag#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashTag.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsHashtags() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    HashTag hashTag = new HashTag(parent2, 1);
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
