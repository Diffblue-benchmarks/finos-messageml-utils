package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.SelectNode;

public class SelectDiffblueTest {
  /**
   * Test {@link Select#Select(Element)}.
   *
   * <p>Method under test: {@link Select#Select(Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Select.<init>(Element)"})
  public void testNewSelect() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Select actualSelect = new Select(parent2);

    // Assert
    Element parent3 = actualSelect.getParent();
    assertTrue(parent3 instanceof Bold);
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
    assertSame(parent2, parent3);
  }

  /**
   * Test {@link Select#asMarkdown()}.
   *
   * <p>Method under test: {@link Select#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Select.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new Select(parent2).asMarkdown();

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
   * Test {@link Select#validate()}.
   *
   * <p>Method under test: {@link Select#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Select.validate()"})
  public void testValidate() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> new Select(parent).validate());
  }

  /**
   * Test {@link Select#validate()}.
   *
   * <ul>
   *   <li>Then calls {@link Checkbox#getParent()}.
   * </ul>
   *
   * <p>Method under test: {@link Select#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Select.validate()"})
  public void testValidate_thenCallsGetParent() throws InvalidInputException {
    // Arrange
    Checkbox parent = mock(Checkbox.class);
    when(parent.getParent()).thenReturn(new Bold(new BulletList(null)));
    BulletList parent2 = new BulletList(parent);
    Bold parent3 = new Bold(parent2);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> new Select(parent3).validate());
    verify(parent, atLeast(1)).getParent();
  }

  /**
   * Test {@link Select#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Select#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Select.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Select select = new Select(parent2);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> select.buildAttribute(parser, new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link Select#getElementId()}.
   *
   * <p>Method under test: {@link Select#getElementId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Select.getElementId()"})
  public void testGetElementId() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertEquals(Select.ELEMENT_ID, new Select(parent).getElementId());
  }

  /**
   * Test {@link Select#updateBiContext(BiContext)}.
   *
   * <p>Method under test: {@link Select#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Select.updateBiContext(BiContext)"})
  public void testUpdateBiContext() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Select select = new Select(parent2);
    BulletList parent3 = new BulletList(mock(Element.class));
    select.addChild(new Bold(parent3));
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
   *
   * <p>Method under test: {@link Select#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Select.updateBiContext(BiContext)"})
  public void testUpdateBiContext2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Select select = new Select(parent2);
    BulletList parent3 = new BulletList(mock(Element.class));
    select.addChild(new Bold(parent3));
    BulletList parent4 = new BulletList(mock(Element.class));
    select.addChild(new Bold(parent4));
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
   *
   * <ul>
   *   <li>Given {@link Select#Select(Element)} with parent is {@link Bold#Bold(Element)}.
   *   <li>Then {@link BiContext} (default constructor) Items size is one.
   * </ul>
   *
   * <p>Method under test: {@link Select#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Select.updateBiContext(BiContext)"})
  public void testUpdateBiContext_givenSelectWithParentIsBold_thenBiContextItemsSizeIsOne() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Select select = new Select(parent2);
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
