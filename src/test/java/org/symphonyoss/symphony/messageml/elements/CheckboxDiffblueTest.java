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
import java.util.List;
import java.util.Map;
import org.commonmark.node.Node;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.CheckboxNode;

public class CheckboxDiffblueTest {
  /**
   * Method under test: {@link Checkbox#validate()}
   */
  @Test
  public void testValidate() throws InvalidInputException {
    // Arrange
    Element parent = mock(Element.class);
    when(parent.getParent()).thenReturn(new Bold(new BulletList(null)));

    // Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new Checkbox(new Bold(new BulletList(parent)), FormatEnum.MESSAGEML)).validate());
    verify(parent, atLeast(1)).getParent();
  }

  /**
   * Method under test: {@link Checkbox#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
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
   * Method under test: {@link Checkbox#asMarkdown()}
   */
  @Test
  public void testAsMarkdown2() {
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
   * Method under test: {@link Checkbox#asMarkdown()}
   */
  @Test
  public void testAsMarkdown3() {
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
   * Method under test: {@link Checkbox#asMarkdown()}
   */
  @Test
  public void testAsMarkdown4() {
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
   * Method under test: {@link Checkbox#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Checkbox checkbox = new Checkbox(parent, FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    checkbox.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("options_count"));
    assertEquals(Checkbox.MESSAGEML_TAG, getResult.getName());
    assertSame(parent, checkbox.getParent());
  }

  /**
   * Method under test: {@link Checkbox#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Checkbox checkbox = new Checkbox(parent, FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    BiItem item = new BiItem(LabelableElement.LABEL, LabelableElement.LABEL);

    context.addItem(item);

    // Act
    checkbox.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("options_count"));
    assertEquals(Checkbox.MESSAGEML_TAG, getResult.getName());
    assertSame(item, items.get(0));
    assertSame(parent, checkbox.getParent());
  }

  /**
   * Method under test: {@link Checkbox#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Checkbox checkbox = new Checkbox(parent, FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    BiItem item = new BiItem(LabelableElement.LABEL, LabelableElement.LABEL);

    context.addItem(item);
    BiItem item2 = new BiItem(LabelableElement.LABEL, LabelableElement.LABEL);

    context.addItem(item2);

    // Act
    checkbox.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("options_count"));
    assertEquals(Checkbox.MESSAGEML_TAG, getResult.getName());
    assertSame(item, items.get(0));
    assertSame(item2, items.get(1));
    assertSame(parent, checkbox.getParent());
  }

  /**
   * Method under test: {@link Checkbox#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext4() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Checkbox checkbox = new Checkbox(parent, FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Checkbox.MESSAGEML_TAG, LabelableElement.LABEL);

    context.addItem(item);

    // Act
    checkbox.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    assertSame(item, items.get(0));
    assertSame(parent, checkbox.getParent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Checkbox#Checkbox(Element, FormatEnum)}
   *   <li>{@link Checkbox#getElementId()}
   *   <li>{@link Checkbox#getPresentationMLDivClass()}
   *   <li>{@link Checkbox#getPresentationMLInputType()}
   * </ul>
   */
  @Test
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
}
