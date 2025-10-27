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
import org.commonmark.node.Node;
import org.commonmark.node.Paragraph;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;

public class DivDiffblueTest {
  /**
   * Method under test: {@link Div#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Div(new Bold(new BulletList(mock(Element.class))))).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof Paragraph);
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Method under test: {@link Div#asEntityJson(ObjectNode)}
   */
  @Test
  public void testAsEntityJson() {
    // Arrange
    Div div = new Div(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertNull(div.asEntityJson(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))));
  }

  /**
   * Method under test: {@link Div#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Div div = new Div(parent);
    BiContext context = new BiContext();

    // Act
    div.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("divs", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(parent, div.getParent());
  }

  /**
   * Method under test: {@link Div#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Div div = new Div(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    div.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("divs", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(parent, div.getParent());
  }

  /**
   * Method under test: {@link Div#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Div div = new Div(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    div.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("divs", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(item2, items.get(1));
    assertSame(parent, div.getParent());
  }

  /**
   * Method under test: {@link Div#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext4() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Div div = new Div(parent);

    BiContext context = new BiContext();
    BiItem item = new BiItem("divs", Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    div.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    assertSame(item, items.get(0));
    assertSame(parent, div.getParent());
  }

  /**
   * Method under test: {@link Div#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext5() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Div div = new Div(parent);

    BiContext context = new BiContext();
    context.addItemWithValue("divs", "Item Value");
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    div.updateBiContext(context);

    // Assert that nothing has changed
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("divs", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, div.getParent());
  }

  /**
   * Method under test: {@link Div#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext6() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Div div = new Div(parent);

    BiContext context = new BiContext();
    context.addItemWithValue("divs", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    div.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(0);
    assertEquals("divs", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(item2, items.get(2));
    assertSame(parent, div.getParent());
  }

  /**
   * Method under test: {@link Div#Div(Element)}
   */
  @Test
  public void testNewDiv() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Div actualDiv = new Div(parent);

    // Assert
    assertEquals(0, actualDiv.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualDiv.getFormat());
    assertTrue(actualDiv.getChildren().isEmpty());
    assertTrue(actualDiv.getAttributes().isEmpty());
    assertEquals(Div.MESSAGEML_TAG, actualDiv.getMessageMLTag());
    assertEquals(Div.MESSAGEML_TAG, actualDiv.getPresentationMLTag());
    assertSame(parent, actualDiv.getParent());
  }
}
