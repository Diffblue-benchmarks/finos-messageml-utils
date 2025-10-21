package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.CheckboxNode;

public class CheckboxDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Checkbox#Checkbox(Element, FormatEnum)}
   *   <li>{@link Checkbox#getElementId()}
   *   <li>{@link Checkbox#getPresentationMLDivClass()}
   *   <li>{@link Checkbox#getPresentationMLInputType()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Checkbox.<init>(Element, FormatEnum)", "String Checkbox.getElementId()",
      "String Checkbox.getPresentationMLDivClass()", "String Checkbox.getPresentationMLInputType()"})
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    Checkbox actualCheckbox = new Checkbox(parent, FormatEnum.MESSAGEML);
    String actualElementId = actualCheckbox.getElementId();
    String actualPresentationMLDivClass = actualCheckbox.getPresentationMLDivClass();
    String actualPresentationMLInputType = actualCheckbox.getPresentationMLInputType();

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualCheckbox.getFormat());
    assertTrue(actualCheckbox.getChildren().isEmpty());
    assertTrue(actualCheckbox.getAttributes().isEmpty());
    assertEquals(Checkbox.MESSAGEML_TAG, actualElementId);
    assertEquals(Checkbox.MESSAGEML_TAG, actualPresentationMLInputType);
    assertEquals(Checkbox.MESSAGEML_TAG, actualCheckbox.getMessageMLTag());
    assertEquals(Checkbox.MESSAGEML_TAG, actualCheckbox.getPresentationMLTag());
    assertEquals(Checkbox.PRESENTATIONML_DIV_CLASS, actualPresentationMLDivClass);
    assertSame(parent, actualCheckbox.getParent());
  }

  /**
   * Test {@link Checkbox#validate()}.
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checkbox#validate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Checkbox.validate()"})
  public void testValidate_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange
    Element parent = mock(Element.class);
    when(parent.getParent()).thenReturn(new Bold(new BulletList(null)));

    // Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new Checkbox(new Bold(new BulletList(parent)), FormatEnum.MESSAGEML)).validate());
    verify(parent, atLeast(1)).getParent();
  }

  /**
   * Test {@link Checkbox#asMarkdown()}.
   * <p>
   * Method under test: {@link Checkbox#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Checkbox.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    checkbox.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act
    Node actualAsMarkdownResult = checkbox.asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof CheckboxNode);
    assertEquals(" ", ((CheckboxNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals(" ", ((CheckboxNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals("", ((CheckboxNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link Checkbox#asMarkdown()}.
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is {@link BulletList#BulletList(Element)} addChild {@link Bold#Bold(Element)} with parent is {@link BulletList#BulletList(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checkbox#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Checkbox.asMarkdown()"})
  public void testAsMarkdown_givenBoldWithParentIsBulletListAddChildBoldWithParentIsBulletList() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    checkbox.addChild(child);

    // Act
    Node actualAsMarkdownResult = checkbox.asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof CheckboxNode);
    assertEquals(" ", ((CheckboxNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals(" ", ((CheckboxNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals("", ((CheckboxNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link Checkbox#asMarkdown()}.
   * <ul>
   *   <li>Given {@link Checkbox#Checkbox(Element, FormatEnum)} with parent is {@link Bold#Bold(Element)} and messageFormat is {@code MESSAGEML}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checkbox#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Checkbox.asMarkdown()"})
  public void testAsMarkdown_givenCheckboxWithParentIsBoldAndMessageFormatIsMessageml() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof CheckboxNode);
    assertEquals(" ", ((CheckboxNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals(" ", ((CheckboxNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals("", ((CheckboxNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link Checkbox#asMarkdown()}.
   * <ul>
   *   <li>Then return Text is {@code $null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checkbox#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Checkbox.asMarkdown()"})
  public void testAsMarkdown_thenReturnTextIsNull() {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    checkbox.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));

    // Act
    Node actualAsMarkdownResult = checkbox.asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof CheckboxNode);
    assertEquals(" ", ((CheckboxNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals(" ", ((CheckboxNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals("$null", ((CheckboxNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link Checkbox#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checkbox#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Checkbox.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Checkbox.MESSAGEML_TAG, LabelableElement.LABEL));

    // Act
    checkbox.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(1, ((Integer) attributes.get("options_count")).intValue());
    assertTrue(attributes.containsKey(LabelableElement.LABEL));
  }

  /**
   * Test {@link Checkbox#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checkbox#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Checkbox.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsThree() {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItem(new BiItem(LabelableElement.LABEL, LabelableElement.LABEL));
    context.addItem(new BiItem(LabelableElement.LABEL, LabelableElement.LABEL));

    // Act
    checkbox.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("options_count")).intValue());
    assertEquals(Checkbox.MESSAGEML_TAG, getResult.getName());
  }

  /**
   * Test {@link Checkbox#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checkbox#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Checkbox.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsTwo() {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItem(new BiItem(LabelableElement.LABEL, LabelableElement.LABEL));

    // Act
    checkbox.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("options_count")).intValue());
    assertEquals(Checkbox.MESSAGEML_TAG, getResult.getName());
  }

  /**
   * Test {@link Checkbox#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Checkbox#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Checkbox.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstAttributesSizeIsOne() {
    // Arrange
    Checkbox checkbox = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    checkbox.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("options_count")).intValue());
    assertEquals(Checkbox.MESSAGEML_TAG, getResult.getName());
  }
}
