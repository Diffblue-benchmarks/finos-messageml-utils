package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import java.util.Map;
import org.commonmark.node.Node;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.markdown.nodes.KeywordNode;

public class CashTagDiffblueTest {
  /**
   * Method under test: {@link CashTag#asText()}
   */
  @Test
  public void testAsText() {
    // Arrange, Act and Assert
    assertEquals("$null", (new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).asText());
  }

  /**
   * Method under test: {@link CashTag#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).asMarkdown();

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
   * Method under test: {@link CashTag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    CashTag cashTag = new CashTag(parent, 1);
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
    assertTrue(attributes2.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertSame(parent, cashTag.getParent());
  }

  /**
   * Method under test: {@link CashTag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    CashTag cashTag = new CashTag(parent, 1);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);

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
    assertTrue(attributes2.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertSame(item, items.get(0));
    assertSame(parent, cashTag.getParent());
  }

  /**
   * Method under test: {@link CashTag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    CashTag cashTag = new CashTag(parent, 1);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    cashTag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(2);
    assertEquals("cashtags", getResult.getName());
    BiItem getResult2 = items.get(3);
    Map<String, Object> attributes = getResult2.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("org.symphonyoss.fin.security.id.ticker", attributes.get("entity_type"));
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertSame(item, items.get(0));
    assertSame(item2, items.get(1));
    assertSame(parent, cashTag.getParent());
  }

  /**
   * Method under test: {@link CashTag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext4() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    CashTag cashTag = new CashTag(parent, 1);

    BiContext context = new BiContext();
    BiItem item = new BiItem("cashtags", Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    cashTag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("org.symphonyoss.fin.security.id.ticker", attributes.get("entity_type"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
    assertSame(item, items.get(0));
    assertSame(parent, cashTag.getParent());
  }

  /**
   * Method under test: {@link CashTag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext5() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    CashTag cashTag = new CashTag(parent, 1);

    BiContext context = new BiContext();
    context.addItemWithValue("cashtags", "Item Value");
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    cashTag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(0);
    assertEquals("cashtags", getResult.getName());
    BiItem getResult2 = items.get(3);
    Map<String, Object> attributes = getResult2.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("org.symphonyoss.fin.security.id.ticker", attributes.get("entity_type"));
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, cashTag.getParent());
  }

  /**
   * Method under test: {@link CashTag#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext6() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    CashTag cashTag = new CashTag(parent, 1);

    BiContext context = new BiContext();
    context.addItemWithValue("cashtags", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    cashTag.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(0);
    assertEquals("cashtags", getResult.getName());
    BiItem getResult2 = items.get(3);
    Map<String, Object> attributes = getResult2.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("org.symphonyoss.fin.security.id.ticker", attributes.get("entity_type"));
    Map<String, Object> attributes2 = getResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey("count"));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult2.getName());
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, cashTag.getParent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CashTag#toString()}
   *   <li>{@link CashTag#getEntitySubType()}
   *   <li>{@link CashTag#getEntityType()}
   *   <li>{@link CashTag#getEntityVersion()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    CashTag cashTag = new CashTag(new Bold(new BulletList(null)), 1);

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
   * Method under test: {@link CashTag#CashTag(Element, int)}
   */
  @Test
  public void testNewCashTag() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    CashTag actualCashTag = new CashTag(parent, 1);

    // Assert
    assertEquals("1.0", actualCashTag.getEntityVersion());
    assertEquals("keyword", actualCashTag.getEntityIdPrefix());
    assertEquals("keyword1", actualCashTag.entityId);
    assertEquals("org.symphonyoss.fin.security.id.ticker", actualCashTag.getEntitySubType());
    assertNull(actualCashTag.getEntityValue());
    assertEquals(0, actualCashTag.size());
    assertEquals(FormatEnum.MESSAGEML, actualCashTag.getFormat());
    assertTrue(actualCashTag.getChildren().isEmpty());
    assertTrue(actualCashTag.getAttributes().isEmpty());
    assertEquals(CashTag.ENTITY_TYPE, actualCashTag.getEntityType());
    assertEquals(CashTag.MESSAGEML_TAG, actualCashTag.getMessageMLTag());
    assertEquals(Span.MESSAGEML_TAG, actualCashTag.getPresentationMLTag());
    assertSame(parent, actualCashTag.getParent());
  }

  /**
   * Method under test: {@link CashTag#CashTag(Element, int, String)}
   */
  @Test
  public void testNewCashTag2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    CashTag actualCashTag = new CashTag(parent, 1, "42");

    // Assert
    assertEquals("1.0", actualCashTag.getEntityVersion());
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
    assertSame(parent, actualCashTag.getParent());
  }

  /**
   * Method under test: {@link CashTag#CashTag(Element, String, String)}
   */
  @Test
  public void testNewCashTag3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    CashTag actualCashTag = new CashTag(parent, "Presentation Ml Tag", "42");

    // Assert
    assertEquals("1.0", actualCashTag.getEntityVersion());
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
    assertSame(parent, actualCashTag.getParent());
  }
}
