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
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.SelectNode;

public class SelectDiffblueTest {
  /**
   * Test {@link Select#Select(Element)}.
   * <p>
   * Method under test: {@link Select#Select(Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Select.<init>(Element)"})
  public void testNewSelect() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Select actualSelect = new Select(parent);

    // Assert
    Element parent2 = actualSelect.getParent();
    assertTrue(parent2 instanceof Bold);
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
    assertSame(parent, parent2);
  }

  /**
   * Test {@link Select#asMarkdown()}.
   * <p>
   * Method under test: {@link Select#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Select.asMarkdown()"})
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
   * Test {@link Select#getElementId()}.
   * <p>
   * Method under test: {@link Select#getElementId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Select.getElementId()"})
  public void testGetElementId() {
    // Arrange, Act and Assert
    assertEquals(Select.ELEMENT_ID, (new Select(new Bold(new BulletList(null)))).getElementId());
  }

  /**
   * Test {@link Select#updateBiContext(BiContext)}.
   * <p>
   * Method under test: {@link Select#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Select.updateBiContext(BiContext)"})
  public void testUpdateBiContext() {
    // Arrange
    Select select = new Select(new Bold(new BulletList(mock(Element.class))));
    select.addChild(new Bold(new BulletList(mock(Element.class))));
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
    assertEquals(0, ((Integer) attributes.get("default")).intValue());
    assertEquals(0, ((Integer) attributes.get("options_count")).intValue());
  }

  /**
   * Test {@link Select#updateBiContext(BiContext)}.
   * <p>
   * Method under test: {@link Select#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Select.updateBiContext(BiContext)"})
  public void testUpdateBiContext2() {
    // Arrange
    Select select = new Select(new Bold(new BulletList(mock(Element.class))));
    select.addChild(new Bold(new BulletList(mock(Element.class))));
    select.addChild(new Bold(new BulletList(mock(Element.class))));
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
    assertEquals(0, ((Integer) attributes.get("default")).intValue());
    assertEquals(0, ((Integer) attributes.get("options_count")).intValue());
  }

  /**
   * Test {@link Select#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Given {@link Select#Select(Element)} with parent is {@link Bold#Bold(Element)}.</li>
   *   <li>Then {@link BiContext} (default constructor) Items size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Select#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Select.updateBiContext(BiContext)"})
  public void testUpdateBiContext_givenSelectWithParentIsBold_thenBiContextItemsSizeIsOne() {
    // Arrange
    Select select = new Select(new Bold(new BulletList(mock(Element.class))));
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
    assertEquals(0, ((Integer) attributes.get("default")).intValue());
    assertEquals(0, ((Integer) attributes.get("options_count")).intValue());
  }
}
