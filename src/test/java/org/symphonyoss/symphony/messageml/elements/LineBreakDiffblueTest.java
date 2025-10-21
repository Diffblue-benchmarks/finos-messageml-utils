package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;

public class LineBreakDiffblueTest {
  /**
   * Test {@link LineBreak#LineBreak(Element)}.
   * <p>
   * Method under test: {@link LineBreak#LineBreak(Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LineBreak.<init>(Element)"})
  public void testNewLineBreak() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    LineBreak actualLineBreak = new LineBreak(parent);

    // Assert
    assertEquals(0, actualLineBreak.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualLineBreak.getFormat());
    assertTrue(actualLineBreak.getChildren().isEmpty());
    assertTrue(actualLineBreak.getAttributes().isEmpty());
    assertEquals(LineBreak.MESSAGEML_TAG, actualLineBreak.getMessageMLTag());
    assertEquals(LineBreak.MESSAGEML_TAG, actualLineBreak.getPresentationMLTag());
    assertSame(parent, actualLineBreak.getParent());
  }

  /**
   * Test {@link LineBreak#asText()}.
   * <p>
   * Method under test: {@link LineBreak#asText()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LineBreak.asText()"})
  public void testAsText() {
    // Arrange, Act and Assert
    assertEquals("\n", (new LineBreak(new Bold(new BulletList(mock(Element.class))))).asText());
  }

  /**
   * Test {@link LineBreak#asMarkdown()}.
   * <p>
   * Method under test: {@link LineBreak#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node LineBreak.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new LineBreak(new Bold(new BulletList(mock(Element.class))))).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof HardLineBreak);
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link LineBreak#areNestedElementsAllowed()}.
   * <p>
   * Method under test: {@link LineBreak#areNestedElementsAllowed()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LineBreak.areNestedElementsAllowed()"})
  public void testAreNestedElementsAllowed() {
    // Arrange, Act and Assert
    assertFalse((new LineBreak(new Bold(new BulletList(mock(Element.class))))).areNestedElementsAllowed());
  }

  /**
   * Test {@link LineBreak#toString()}.
   * <p>
   * Method under test: {@link LineBreak#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String LineBreak.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("\n", (new LineBreak(new Bold(new BulletList(null)))).toString());
  }

  /**
   * Test {@link LineBreak#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes {@code count} {@link BiItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LineBreak#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LineBreak.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountBiItem() {
    // Arrange
    LineBreak lineBreak = new LineBreak(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    BiItem biItem = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItemWithValue("linebreaks", biItem);
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    lineBreak.updateBiContext(context);

    // Assert that nothing has changed
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(1, attributes.size());
    Object getResult = attributes.get("count");
    assertTrue(getResult instanceof BiItem);
    Map<String, Object> attributes2 = items.get(1).getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
    assertEquals(attributes2, items.get(2).getAttributes());
    assertSame(biItem, getResult);
  }

  /**
   * Test {@link LineBreak#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes {@code count} is {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LineBreak#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LineBreak.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountIsItemValue() {
    // Arrange
    LineBreak lineBreak = new LineBreak(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItemWithValue("linebreaks", "Item Value");
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    lineBreak.updateBiContext(context);

    // Assert that nothing has changed
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("Item Value", attributes.get("count"));
    Map<String, Object> attributes2 = items.get(1).getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link LineBreak#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link LineBreak#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LineBreak.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    LineBreak lineBreak = new LineBreak(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItem(new BiItem("linebreaks", Element.STYLE_ATTR));

    // Act
    lineBreak.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    assertTrue(attributes.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link LineBreak#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link LineBreak#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LineBreak.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsTwo() {
    // Arrange
    LineBreak lineBreak = new LineBreak(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    lineBreak.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("linebreaks", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link LineBreak#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is {@code linebreaks}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LineBreak#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LineBreak.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsLinebreaks() {
    // Arrange
    LineBreak lineBreak = new LineBreak(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    lineBreak.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("linebreaks", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link LineBreak#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is {@code linebreaks}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LineBreak#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LineBreak.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsLinebreaks() {
    // Arrange
    LineBreak lineBreak = new LineBreak(new Bold(new BulletList(mock(Element.class))));
    BiContext context = new BiContext();

    // Act
    lineBreak.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("linebreaks", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }
}
