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
import org.symphonyoss.symphony.messageml.markdown.nodes.form.RadioNode;

public class RadioDiffblueTest {
  /**
   * Method under test: {@link Radio#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Radio(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof RadioNode);
    assertEquals(" ", ((RadioNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals(" ", ((RadioNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals("", ((RadioNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Method under test: {@link Radio#asMarkdown()}
   */
  @Test
  public void testAsMarkdown2() {
    // Arrange
    Radio radio = new Radio(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    radio.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act
    Node actualAsMarkdownResult = radio.asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof RadioNode);
    assertEquals(" ", ((RadioNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals(" ", ((RadioNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals("", ((RadioNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Method under test: {@link Radio#asMarkdown()}
   */
  @Test
  public void testAsMarkdown3() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    Radio radio = new Radio(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    radio.addChild(child);

    // Act
    Node actualAsMarkdownResult = radio.asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof RadioNode);
    assertEquals(" ", ((RadioNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals(" ", ((RadioNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals("", ((RadioNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Method under test: {@link Radio#asMarkdown()}
   */
  @Test
  public void testAsMarkdown4() {
    // Arrange
    Radio radio = new Radio(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    radio.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));

    // Act
    Node actualAsMarkdownResult = radio.asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof RadioNode);
    assertEquals(" ", ((RadioNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals(" ", ((RadioNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals("$null", ((RadioNode) actualAsMarkdownResult).getText());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Method under test: {@link Radio#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Radio radio = new Radio(parent, FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    radio.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("options_count"));
    assertEquals(Radio.MESSAGEML_TAG, getResult.getName());
    assertSame(parent, radio.getParent());
  }

  /**
   * Method under test: {@link Radio#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Radio radio = new Radio(parent, FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    BiItem item = new BiItem(LabelableElement.LABEL, LabelableElement.LABEL);

    context.addItem(item);

    // Act
    radio.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("options_count"));
    assertEquals(Radio.MESSAGEML_TAG, getResult.getName());
    assertSame(item, items.get(0));
    assertSame(parent, radio.getParent());
  }

  /**
   * Method under test: {@link Radio#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Radio radio = new Radio(parent, FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    BiItem item = new BiItem(LabelableElement.LABEL, LabelableElement.LABEL);

    context.addItem(item);
    BiItem item2 = new BiItem(LabelableElement.LABEL, LabelableElement.LABEL);

    context.addItem(item2);

    // Act
    radio.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("options_count"));
    assertEquals(Radio.MESSAGEML_TAG, getResult.getName());
    assertSame(item, items.get(0));
    assertSame(item2, items.get(1));
    assertSame(parent, radio.getParent());
  }

  /**
   * Method under test: {@link Radio#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext4() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));
    Radio radio = new Radio(parent, FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Radio.MESSAGEML_TAG, LabelableElement.LABEL);

    context.addItem(item);

    // Act
    radio.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    assertSame(item, items.get(0));
    assertSame(parent, radio.getParent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Radio#Radio(Element, FormatEnum)}
   *   <li>{@link Radio#getElementId()}
   *   <li>{@link Radio#getPresentationMLDivClass()}
   *   <li>{@link Radio#getPresentationMLInputType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    Radio actualRadio = new Radio(parent, FormatEnum.MESSAGEML);
    String actualElementId = actualRadio.getElementId();
    String actualPresentationMLDivClass = actualRadio.getPresentationMLDivClass();
    String actualPresentationMLInputType = actualRadio.getPresentationMLInputType();

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualRadio.getFormat());
    assertTrue(actualRadio.getChildren().isEmpty());
    assertTrue(actualRadio.getAttributes().isEmpty());
    assertEquals(Radio.MESSAGEML_TAG, actualRadio.getMessageMLTag());
    assertEquals(Radio.MESSAGEML_TAG, actualRadio.getPresentationMLTag());
    assertEquals(Radio.MESSAGEML_TAG, actualElementId);
    assertEquals(Radio.MESSAGEML_TAG, actualPresentationMLInputType);
    assertEquals(Radio.PRESENTATIONML_DIV_CLASS, actualPresentationMLDivClass);
    assertSame(parent, actualRadio.getParent());
  }
}
