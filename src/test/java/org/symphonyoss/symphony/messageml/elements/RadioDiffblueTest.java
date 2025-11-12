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
import org.symphonyoss.symphony.messageml.markdown.nodes.form.RadioNode;

public class RadioDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Radio#Radio(Element, FormatEnum)}
   *   <li>{@link Radio#getElementId()}
   *   <li>{@link Radio#getPresentationMLDivClass()}
   *   <li>{@link Radio#getPresentationMLInputType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Radio.<init>(Element, FormatEnum)",
    "String Radio.getElementId()",
    "String Radio.getPresentationMLDivClass()",
    "String Radio.getPresentationMLInputType()"
  })
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
   *
   * <p>Method under test: {@link Radio#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Radio.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Bold child = new Bold(parent2);
    BulletList parent3 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent3));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Bold child2 = new Bold(parent5);
    child2.addChild(child);
    BulletList parent6 = new BulletList(mock(Element.class));
    Bold parent7 = new Bold(parent6);

    CashTag child3 = new CashTag(parent7, 1);
    child3.addChild(child2);
    BulletList parent8 = new BulletList(mock(Element.class));
    Bold parent9 = new Bold(parent8);

    Radio radio = new Radio(parent9, FormatEnum.MESSAGEML);
    radio.addChild(child3);

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
   * Test {@link Radio#asMarkdown()}.
   *
   * <p>Method under test: {@link Radio#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Radio.asMarkdown()"})
  public void testAsMarkdown2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Bold child = new Bold(parent2);
    BulletList parent3 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent3));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    CashTag child2 = new CashTag(parent5, 1);
    child2.addChild(child);
    BulletList parent6 = new BulletList(mock(Element.class));
    Bold parent7 = new Bold(parent6);

    Bold child3 = new Bold(parent7);
    child3.addChild(child2);
    BulletList parent8 = new BulletList(mock(Element.class));
    Bold parent9 = new Bold(parent8);

    Radio radio = new Radio(parent9, FormatEnum.MESSAGEML);
    radio.addChild(child3);

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
   * Test {@link Radio#asMarkdown()}.
   *
   * <ul>
   *   <li>Given {@link Radio#Radio(Element, FormatEnum)} with parent is {@link Bold#Bold(Element)}
   *       and messageFormat is {@code MESSAGEML}.
   * </ul>
   *
   * <p>Method under test: {@link Radio#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Radio.asMarkdown()"})
  public void testAsMarkdown_givenRadioWithParentIsBoldAndMessageFormatIsMessageml() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new Radio(parent2, FormatEnum.MESSAGEML).asMarkdown();

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
   *
   * <ul>
   *   <li>Then return Text is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Radio#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Radio.asMarkdown()"})
  public void testAsMarkdown_thenReturnTextIsEmptyString() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Bold child = new Bold(parent2);
    BulletList parent3 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent3));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Bold child2 = new Bold(parent5);
    child2.addChild(child);
    BulletList parent6 = new BulletList(mock(Element.class));
    Bold parent7 = new Bold(parent6);

    Bold child3 = new Bold(parent7);
    child3.addChild(child2);
    BulletList parent8 = new BulletList(mock(Element.class));
    Bold parent9 = new Bold(parent8);

    Radio radio = new Radio(parent9, FormatEnum.MESSAGEML);
    radio.addChild(child3);

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
   * Test {@link Radio#validate()}.
   *
   * <p>Method under test: {@link Radio#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Radio.validate()"})
  public void testValidate() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> new Radio(parent, FormatEnum.MESSAGEML).validate());
  }

  /**
   * Test {@link Radio#validate()}.
   *
   * <ul>
   *   <li>Then calls {@link Checkbox#getParent()}.
   * </ul>
   *
   * <p>Method under test: {@link Radio#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Radio.validate()"})
  public void testValidate_thenCallsGetParent() throws InvalidInputException {
    // Arrange
    Checkbox parent = mock(Checkbox.class);
    when(parent.getParent()).thenReturn(new Bold(new BulletList(null)));
    BulletList parent2 = new BulletList(parent);
    Bold parent3 = new Bold(parent2);

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> new Radio(parent3, FormatEnum.MESSAGEML).validate());
    verify(parent, atLeast(1)).getParent();
  }

  /**
   * Test {@link Radio#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@link Element#ID_ATTR}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Radio#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Radio.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithId_attr_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Radio radio = new Radio(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> radio.buildAttribute(parser, new IIOMetadataNode(Element.ID_ATTR)));
  }

  /**
   * Test {@link Radio#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code Node Name}.
   * </ul>
   *
   * <p>Method under test: {@link Radio#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Radio.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithNodeName() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Radio radio = new Radio(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> radio.buildAttribute(parser, new IIOMetadataNode("Node Name")));
  }

  /**
   * Test {@link Radio#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size is two.
   * </ul>
   *
   * <p>Method under test: {@link Radio#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Radio.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Radio radio = new Radio(parent2, FormatEnum.MESSAGEML);

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is three.
   * </ul>
   *
   * <p>Method under test: {@link Radio#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Radio.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsThree() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Radio radio = new Radio(parent2, FormatEnum.MESSAGEML);

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.
   * </ul>
   *
   * <p>Method under test: {@link Radio#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Radio.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsTwo() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Radio radio = new Radio(parent2, FormatEnum.MESSAGEML);

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
   *
   * <ul>
   *   <li>When {@link BiContext} (default constructor).
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size is one.
   * </ul>
   *
   * <p>Method under test: {@link Radio#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Radio.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstAttributesSizeIsOne() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Radio radio = new Radio(parent2, FormatEnum.MESSAGEML);
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
