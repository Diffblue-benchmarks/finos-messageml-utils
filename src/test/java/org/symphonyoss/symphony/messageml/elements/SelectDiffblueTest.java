package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import org.symphonyoss.symphony.messageml.markdown.nodes.form.SelectNode;

public class SelectDiffblueTest {
  /**
   * Method under test: {@link Select#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Select(new Bold(new BulletList(mock(Element.class))))).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof SelectNode);
    assertEquals(" ", ((SelectNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals(" \n", ((SelectNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals("", ((SelectNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Method under test: {@link Select#getElementId()}
   */
  @Test
  public void testGetElementId() {
    // Arrange, Act and Assert
    assertEquals(Select.ELEMENT_ID, (new Select(new Bold(new BulletList(null)))).getElementId());
  }

  /**
   * Method under test: {@link Select#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Select select = new Select(parent);
    BiContext context = new BiContext();

    // Act
    select.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("dropdownmenu", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(2, attributes.size());
    assertTrue(select.getChildren().isEmpty());
    assertTrue(attributes.containsKey("default"));
    assertTrue(attributes.containsKey("options_count"));
    assertSame(parent, select.getParent());
  }

  /**
   * Method under test: {@link Select#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Select select = new Select(parent);
    Bold child = new Bold(new BulletList(mock(Element.class)));
    select.addChild(child);
    BiContext context = new BiContext();

    // Act
    select.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("dropdownmenu", getResult.getName());
    List<Element> children = select.getChildren();
    assertEquals(1, children.size());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(2, attributes.size());
    assertTrue(attributes.containsKey("default"));
    assertTrue(attributes.containsKey("options_count"));
    assertSame(child, children.get(0));
    assertSame(parent, select.getParent());
  }

  /**
   * Method under test: {@link Select#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    Select select = new Select(parent);
    Bold child = new Bold(new BulletList(mock(Element.class)));
    select.addChild(child);
    Bold child2 = new Bold(new BulletList(mock(Element.class)));
    select.addChild(child2);
    BiContext context = new BiContext();

    // Act
    select.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("dropdownmenu", getResult.getName());
    List<Element> children = select.getChildren();
    assertEquals(2, children.size());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(2, attributes.size());
    assertTrue(attributes.containsKey("default"));
    assertTrue(attributes.containsKey("options_count"));
    assertSame(child, children.get(0));
    assertSame(child2, children.get(1));
    assertSame(parent, select.getParent());
  }

  /**
   * Method under test: {@link Select#Select(Element)}
   */
  @Test
  public void testNewSelect() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Select actualSelect = new Select(parent);

    // Assert
    assertEquals(0, actualSelect.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualSelect.getFormat());
    assertFalse(actualSelect.isLabel());
    assertFalse(actualSelect.isSplittable());
    assertFalse(actualSelect.isTooltip());
    assertTrue(actualSelect.getChildren().isEmpty());
    assertTrue(actualSelect.getAttributes().isEmpty());
    assertEquals(LabelableElement.LABEL, actualSelect.getPresentationMLLabelTag());
    assertEquals(Select.ELEMENT_ID, actualSelect.getElementId());
    assertEquals(Select.MESSAGEML_TAG, actualSelect.getMessageMLTag());
    assertEquals(Select.MESSAGEML_TAG, actualSelect.getPresentationMLTag());
    assertEquals(Span.MESSAGEML_TAG, actualSelect.getPresentationMLTooltipTag());
    assertSame(parent, actualSelect.getParent());
  }
}
