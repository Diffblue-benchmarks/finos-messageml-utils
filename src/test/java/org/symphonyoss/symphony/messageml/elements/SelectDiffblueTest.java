package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import org.symphonyoss.symphony.messageml.markdown.nodes.form.SelectNode;

public class SelectDiffblueTest {
  /**
   * Test {@link Select#Select(Element)}.
   * <p>
   * Method under test: {@link Select#Select(Element)}
   */
  @Test
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
   * Test {@link Select#validate()}.
   * <p>
   * Method under test: {@link Select#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Element "select" can only be a inner child of the following elements: [form]
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertParentAtAnyLevel(Element.java:758)
    //       at org.symphonyoss.symphony.messageml.elements.FormElement.validate(FormElement.java:24)
    //       at org.symphonyoss.symphony.messageml.elements.Select.validate(Select.java:80)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new Select(new Bold(new BulletList(null)))).validate();
  }

  /**
   * Test {@link Select#buildAttribute(MessageMLParser, Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Select#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Attribute "foo" is not allowed in "select"
    //       at org.symphonyoss.symphony.messageml.elements.Element.throwInvalidInputException(Element.java:1071)
    //       at org.symphonyoss.symphony.messageml.elements.Select.buildAttribute(Select.java:169)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Select select = new Select(new Bold(new BulletList(mock(Element.class))));
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    select.buildAttribute(parser, new IIOMetadataNode("foo"));
  }

  /**
   * Test {@link Select#getElementId()}.
   * <p>
   * Method under test: {@link Select#getElementId()}
   */
  @Test
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
   *   <li>Given {@link Select#Select(Element)} with parent is
   * {@link Bold#Bold(Element)}.</li>
   *   <li>Then {@link BiContext} (default constructor) Items size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Select#updateBiContext(BiContext)}
   */
  @Test
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
