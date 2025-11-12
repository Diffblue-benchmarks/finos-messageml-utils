package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
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
import org.symphonyoss.symphony.messageml.markdown.nodes.KeywordNode;

public class CashTagDiffblueTest {
  /**
   * Test {@link CashTag#CashTag(Element, int)}.
   *
   * <p>Method under test: {@link CashTag#CashTag(Element, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CashTag.<init>(Element, int)"})
  public void testNewCashTag() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    CashTag actualCashTag = new CashTag(parent2, 1);

    // Assert
    Element parent3 = actualCashTag.getParent();
    assertTrue(parent3 instanceof Bold);
    assertEquals("1.0", actualCashTag.getEntityVersion());
    assertEquals("keyword", actualCashTag.getEntityIdPrefix());
    assertEquals("keyword1", actualCashTag.entityId);
    assertEquals("org.symphonyoss.fin.security.id.ticker", actualCashTag.getEntitySubType());
    assertNull(actualCashTag.getTag());
    assertNull(actualCashTag.getEntityValue());
    assertEquals(0, actualCashTag.size());
    assertEquals(FormatEnum.MESSAGEML, actualCashTag.getFormat());
    assertTrue(actualCashTag.getChildren().isEmpty());
    assertTrue(actualCashTag.getAttributes().isEmpty());
    assertEquals(CashTag.ENTITY_TYPE, actualCashTag.getEntityType());
    assertEquals(CashTag.MESSAGEML_TAG, actualCashTag.getMessageMLTag());
    assertEquals(Span.MESSAGEML_TAG, actualCashTag.getPresentationMLTag());
    assertSame(parent2, parent3);
  }

  /**
   * Test {@link CashTag#CashTag(Element, int, String)}.
   *
   * <p>Method under test: {@link CashTag#CashTag(Element, int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CashTag.<init>(Element, int, String)"})
  public void testNewCashTag2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    CashTag actualCashTag = new CashTag(parent2, 1, "42");

    // Assert
    Element parent3 = actualCashTag.getParent();
    assertTrue(parent3 instanceof Bold);
    assertEquals("1.0", actualCashTag.getEntityVersion());
    assertEquals("42", actualCashTag.getTag());
    assertEquals("42", actualCashTag.getEntityValue());
    assertEquals("keyword", actualCashTag.getEntityIdPrefix());
    assertEquals("keyword1", actualCashTag.entityId);
    assertEquals("org.symphonyoss.fin.security.id.ticker", actualCashTag.getEntitySubType());
    assertEquals(0, actualCashTag.size());
    assertEquals(FormatEnum.MESSAGEML, actualCashTag.getFormat());
    assertTrue(actualCashTag.getChildren().isEmpty());
    assertTrue(actualCashTag.getAttributes().isEmpty());
    assertEquals(CashTag.ENTITY_TYPE, actualCashTag.getEntityType());
    assertEquals(CashTag.MESSAGEML_TAG, actualCashTag.getMessageMLTag());
    assertEquals(Span.MESSAGEML_TAG, actualCashTag.getPresentationMLTag());
    assertSame(parent2, parent3);
  }

  /**
   * Test {@link CashTag#CashTag(Element, String, String)}.
   *
   * <p>Method under test: {@link CashTag#CashTag(Element, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CashTag.<init>(Element, String, String)"})
  public void testNewCashTag3() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    CashTag actualCashTag = new CashTag(parent2, "Presentation Ml Tag", "42");

    // Assert
    Element parent3 = actualCashTag.getParent();
    assertTrue(parent3 instanceof Bold);
    assertEquals("1.0", actualCashTag.getEntityVersion());
    assertEquals("42", actualCashTag.getTag());
    assertEquals("42", actualCashTag.getEntityValue());
    assertEquals("Presentation Ml Tag", actualCashTag.getPresentationMLTag());
    assertEquals("keyword", actualCashTag.getEntityIdPrefix());
    assertEquals("org.symphonyoss.fin.security.id.ticker", actualCashTag.getEntitySubType());
    assertNull(actualCashTag.entityId);
    assertEquals(0, actualCashTag.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualCashTag.getFormat());
    assertTrue(actualCashTag.getChildren().isEmpty());
    assertTrue(actualCashTag.getAttributes().isEmpty());
    assertEquals(CashTag.ENTITY_TYPE, actualCashTag.getEntityType());
    assertEquals(CashTag.MESSAGEML_TAG, actualCashTag.getMessageMLTag());
    assertSame(parent2, parent3);
  }

  /**
   * Test {@link CashTag#asText()}.
   *
   * <p>Method under test: {@link CashTag#asText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CashTag.asText()"})
  public void testAsText() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertEquals("$null", new CashTag(parent2, 1).asText());
  }

  /**
   * Test {@link CashTag#asMarkdown()}.
   *
   * <p>Method under test: {@link CashTag#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node CashTag.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new CashTag(parent2, 1).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof KeywordNode);
    assertNull(((KeywordNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertEquals(CashTag.PREFIX, ((KeywordNode) actualAsMarkdownResult).getPrefix());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CashTag#toString()}
   *   <li>{@link CashTag#getEntitySubType()}
   *   <li>{@link CashTag#getEntityType()}
   *   <li>{@link CashTag#getEntityVersion()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CashTag.getEntitySubType()",
    "String CashTag.getEntityType()",
    "String CashTag.getEntityVersion()",
    "String CashTag.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    CashTag cashTag = new CashTag(parent, 1);

    // Act
    String actualToStringResult = cashTag.toString();
    String actualEntitySubType = cashTag.getEntitySubType();
    String actualEntityType = cashTag.getEntityType();

    // Assert
    assertEquals("1.0", cashTag.getEntityVersion());
    assertEquals("CashTag(null)", actualToStringResult);
    assertEquals("org.symphonyoss.fin.security.id.ticker", actualEntitySubType);
    assertEquals(CashTag.ENTITY_TYPE, actualEntityType);
  }

  /**
   * Test {@link CashTag#updateBiContext(BiContext)}.
   *
   * <p>Method under test: {@link CashTag#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CashTag.updateBiContext(BiContext)"})
  public void testUpdateBiContext() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    CashTag cashTag = new CashTag(parent2, 1);

    BiContext context = new BiContext();
    context.addItemWithValue("cashtags", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    cashTag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(3);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("org.symphonyoss.fin.security.id.ticker", attributes.get("entity_type"));
    BiItem getResult2 = items.get(1);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
    assertEquals(Element.STYLE_ATTR, getResult2.getName());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
  }

  /**
   * Test {@link CashTag#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Given {@code Item Value}.
   * </ul>
   *
   * <p>Method under test: {@link CashTag#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CashTag.updateBiContext(BiContext)"})
  public void testUpdateBiContext_givenItemValue() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    CashTag cashTag = new CashTag(parent2, 1);

    BiContext context = new BiContext();
    context.addItemWithValue("cashtags", "Item Value");
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    cashTag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(3);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("org.symphonyoss.fin.security.id.ticker", attributes.get("entity_type"));
    BiItem getResult2 = items.get(1);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
    assertEquals(Element.STYLE_ATTR, getResult2.getName());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
  }

  /**
   * Test {@link CashTag#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size is two.
   * </ul>
   *
   * <p>Method under test: {@link CashTag#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CashTag.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    CashTag cashTag = new CashTag(parent2, 1);

    BiContext context = new BiContext();
    context.addItem(new BiItem("cashtags", Element.STYLE_ATTR));

    // Act
    cashTag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("org.symphonyoss.fin.security.id.ticker", attributes.get("entity_type"));
    Map<String, Object> attributes2 = items.get(0).getAttributes();
    assertEquals(2, attributes2.size());
    assertEquals(1, ((Integer) attributes2.get("count")).intValue());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
  }

  /**
   * Test {@link CashTag#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is three.
   * </ul>
   *
   * <p>Method under test: {@link CashTag#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CashTag.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsThree() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    CashTag cashTag = new CashTag(parent2, 1);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    cashTag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(1);
    assertEquals("cashtags", getResult.getName());
    BiItem getResult2 = items.get(2);
    Map<String, Object> attributes = getResult2.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("org.symphonyoss.fin.security.id.ticker", attributes.get("entity_type"));
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertEquals(1, ((Integer) attributes2.get("count")).intValue());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
  }

  /**
   * Test {@link CashTag#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is {@code cashtags}.
   * </ul>
   *
   * <p>Method under test: {@link CashTag#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CashTag.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsCashtags() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    CashTag cashTag = new CashTag(parent2, 1);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    cashTag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(2);
    assertEquals("cashtags", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link CashTag#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>When {@link BiContext} (default constructor).
   *   <li>Then {@link BiContext} (default constructor) Items first Name is {@code cashtags}.
   * </ul>
   *
   * <p>Method under test: {@link CashTag#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CashTag.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsCashtags() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    CashTag cashTag = new CashTag(parent2, 1);
    BiContext context = new BiContext();

    // Act
    cashTag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(0);
    assertEquals("cashtags", getResult.getName());
    BiItem getResult2 = items.get(1);
    Map<String, Object> attributes = getResult2.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("org.symphonyoss.fin.security.id.ticker", attributes.get("entity_type"));
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertEquals(1, ((Integer) attributes2.get("count")).intValue());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
  }
}
