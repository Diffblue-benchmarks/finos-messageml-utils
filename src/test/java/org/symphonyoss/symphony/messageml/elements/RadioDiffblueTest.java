package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.RadioNode;

public class RadioDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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

  /**
   * Test {@link Radio#asMarkdown()}.
   * <p>
   * Method under test: {@link Radio#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
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
   * Test {@link Radio#asMarkdown()}.
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is
   * {@link BulletList#BulletList(Element)} addChild {@link Bold#Bold(Element)}
   * with parent is {@link BulletList#BulletList(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Radio#asMarkdown()}
   */
  @Test
  public void testAsMarkdown_givenBoldWithParentIsBulletListAddChildBoldWithParentIsBulletList() {
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
   * Test {@link Radio#asMarkdown()}.
   * <ul>
   *   <li>Given {@link Radio#Radio(Element, FormatEnum)} with parent is
   * {@link Bold#Bold(Element)} and messageFormat is {@code MESSAGEML}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Radio#asMarkdown()}
   */
  @Test
  public void testAsMarkdown_givenRadioWithParentIsBoldAndMessageFormatIsMessageml() {
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
   * Test {@link Radio#asMarkdown()}.
   * <ul>
   *   <li>Then return Text is {@code $null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Radio#asMarkdown()}
   */
  @Test
  public void testAsMarkdown_thenReturnTextIsNull() {
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
   * Test {@link Radio#validate()}.
   * <p>
   * Method under test: {@link Radio#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Element "radio" can only be a inner child of the following elements: [form]
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertParentAtAnyLevel(Element.java:758)
    //       at org.symphonyoss.symphony.messageml.elements.FormElement.validate(FormElement.java:24)
    //       at org.symphonyoss.symphony.messageml.elements.Radio.validate(Radio.java:63)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new Radio(new Bold(new BulletList(null)), FormatEnum.MESSAGEML)).validate();
  }

  /**
   * Test {@link Radio#buildAttribute(MessageMLParser, Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Radio#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Attribute "foo" is not allowed in "radio"
    //       at org.symphonyoss.symphony.messageml.elements.Element.throwInvalidInputException(Element.java:1071)
    //       at org.symphonyoss.symphony.messageml.elements.Radio.buildAttribute(Radio.java:104)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Radio radio = new Radio(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    radio.buildAttribute(parser, new IIOMetadataNode("foo"));
  }

  /**
   * Test {@link Radio#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Radio#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    Radio radio = new Radio(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Radio.MESSAGEML_TAG, LabelableElement.LABEL));

    // Act
    radio.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(1, ((Integer) attributes.get("options_count")).intValue());
    assertTrue(attributes.containsKey(LabelableElement.LABEL));
  }

  /**
   * Test {@link Radio#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Radio#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsSizeIsThree() {
    // Arrange
    Radio radio = new Radio(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItem(new BiItem(LabelableElement.LABEL, LabelableElement.LABEL));
    context.addItem(new BiItem(LabelableElement.LABEL, LabelableElement.LABEL));

    // Act
    radio.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("options_count")).intValue());
    assertEquals(Radio.MESSAGEML_TAG, getResult.getName());
  }

  /**
   * Test {@link Radio#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Radio#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsSizeIsTwo() {
    // Arrange
    Radio radio = new Radio(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItem(new BiItem(LabelableElement.LABEL, LabelableElement.LABEL));

    // Act
    radio.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("options_count")).intValue());
    assertEquals(Radio.MESSAGEML_TAG, getResult.getName());
  }

  /**
   * Test {@link Radio#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Radio#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstAttributesSizeIsOne() {
    // Arrange
    Radio radio = new Radio(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    radio.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("options_count")).intValue());
    assertEquals(Radio.MESSAGEML_TAG, getResult.getName());
  }
}
