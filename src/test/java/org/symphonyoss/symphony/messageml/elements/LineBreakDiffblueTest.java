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
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Node;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class LineBreakDiffblueTest {
  /**
   * Test {@link LineBreak#LineBreak(Element)}.
   * <p>
   * Method under test: {@link LineBreak#LineBreak(Element)}
   */
  @Test
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
   * Test {@link LineBreak#buildAttribute(MessageMLParser, Node)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LineBreak#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Attribute "foo" is not allowed in "br"
    //       at org.symphonyoss.symphony.messageml.elements.Element.throwInvalidInputException(Element.java:1071)
    //       at org.symphonyoss.symphony.messageml.elements.LineBreak.buildAttribute(LineBreak.java:42)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    LineBreak lineBreak = new LineBreak(new Bold(new BulletList(mock(Element.class))));
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    lineBreak.buildAttribute(parser, new IIOMetadataNode("foo"));
  }

  /**
   * Test {@link LineBreak#asText()}.
   * <p>
   * Method under test: {@link LineBreak#asText()}
   */
  @Test
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
   * Test {@link LineBreak#validate()}.
   * <ul>
   *   <li>Given {@link LineBreak#LineBreak(Element)} with parent is
   * {@link Bold#Bold(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LineBreak#validate()}
   */
  @Test
  public void testValidate_givenLineBreakWithParentIsBold() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new LineBreak(new Bold(new BulletList(mock(Element.class))))).validate();
  }

  /**
   * Test {@link LineBreak#validate()}.
   * <ul>
   *   <li>Given {@link LineBreak#LineBreak(Element)} with parent is
   * {@link Bold#Bold(Element)} addChild {@link Bold#Bold(Element)} with parent is
   * {@link BulletList#BulletList(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LineBreak#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate_givenLineBreakWithParentIsBoldAddChildBoldWithParentIsBulletList()
      throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Element "br" may not have child elements or text content
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertNoContent(Element.java:645)
    //       at org.symphonyoss.symphony.messageml.elements.LineBreak.validate(LineBreak.java:57)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    LineBreak lineBreak = new LineBreak(new Bold(new BulletList(mock(Element.class))));
    lineBreak.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act
    lineBreak.validate();
  }

  /**
   * Test {@link LineBreak#areNestedElementsAllowed()}.
   * <p>
   * Method under test: {@link LineBreak#areNestedElementsAllowed()}
   */
  @Test
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
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("\n", (new LineBreak(new Bold(new BulletList(null)))).toString());
  }

  /**
   * Test {@link LineBreak#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} {@link BiItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LineBreak#updateBiContext(BiContext)}
   */
  @Test
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
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} is {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LineBreak#updateBiContext(BiContext)}
   */
  @Test
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
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link LineBreak#updateBiContext(BiContext)}
   */
  @Test
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
   *   <li>Then {@link BiContext} (default constructor) Items third Name is
   * {@code linebreaks}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LineBreak#updateBiContext(BiContext)}
   */
  @Test
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
   *   <li>Then {@link BiContext} (default constructor) Items first Name is
   * {@code linebreaks}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LineBreak#updateBiContext(BiContext)}
   */
  @Test
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
