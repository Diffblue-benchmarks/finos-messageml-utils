package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;

public class SpanDiffblueTest {
  /**
   * Method under test: {@link Span#asEntityJson(ObjectNode)}
   */
  @Test
  public void testAsEntityJson() {
    // Arrange
    Span span = new Span(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertNull(span.asEntityJson(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))));
  }

  /**
   * Method under test: {@link Span#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Span span = new Span(parent);
    BiContext context = new BiContext();

    // Act
    span.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("spans", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(parent, span.getParent());
  }

  /**
   * Method under test: {@link Span#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Span span = new Span(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    span.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("spans", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(parent, span.getParent());
  }

  /**
   * Method under test: {@link Span#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Span span = new Span(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    span.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("spans", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(item2, items.get(1));
    assertSame(parent, span.getParent());
  }

  /**
   * Method under test: {@link Span#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext4() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Span span = new Span(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem("spans", Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    span.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    assertSame(item, items.get(0));
    assertSame(parent, span.getParent());
  }

  /**
   * Method under test: {@link Span#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext5() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Span span = new Span(parent);

    BiContext context = new BiContext();
    context.addItemWithValue("spans", "Item Value");
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    span.updateBiContext(context);

    // Assert that nothing has changed
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("spans", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, span.getParent());
  }

  /**
   * Method under test: {@link Span#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext6() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Span span = new Span(parent);

    BiContext context = new BiContext();
    context.addItemWithValue("spans", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    span.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("spans", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, span.getParent());
  }

  /**
   * Method under test: {@link Span#Span(Element)}
   */
  @Test
  public void testNewSpan() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Span actualSpan = new Span(parent);

    // Assert
    assertEquals(0, actualSpan.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualSpan.getFormat());
    assertTrue(actualSpan.getChildren().isEmpty());
    assertTrue(actualSpan.getAttributes().isEmpty());
    assertEquals(Span.MESSAGEML_TAG, actualSpan.getMessageMLTag());
    assertEquals(Span.MESSAGEML_TAG, actualSpan.getPresentationMLTag());
    assertSame(parent, actualSpan.getParent());
  }
}
