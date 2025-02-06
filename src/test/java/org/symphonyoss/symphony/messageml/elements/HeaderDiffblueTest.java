package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import java.util.Map;
import org.commonmark.node.Node;
import org.commonmark.node.StrongEmphasis;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;

public class HeaderDiffblueTest {
  /**
   * Test {@link Header#Header(Element, String)}.
   * <p>
   * Method under test: {@link Header#Header(Element, String)}
   */
  @Test
  public void testNewHeader() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Header actualHeader = new Header(parent, "Tag");

    // Assert
    assertEquals("Tag", actualHeader.getMessageMLTag());
    assertEquals("Tag", actualHeader.getPresentationMLTag());
    assertEquals(0, actualHeader.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualHeader.getFormat());
    assertTrue(actualHeader.getChildren().isEmpty());
    assertTrue(actualHeader.getAttributes().isEmpty());
    assertSame(parent, actualHeader.getParent());
  }

  /**
   * Test {@link Header#asMarkdown()}.
   * <p>
   * Method under test: {@link Header#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Header(new Bold(new BulletList(mock(Element.class))), "Tag")).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof StrongEmphasis);
    assertEquals("**", ((StrongEmphasis) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals("**", ((StrongEmphasis) actualAsMarkdownResult).getOpeningDelimiter());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link Header#isHeaderElement(String)}.
   * <ul>
   *   <li>When {@code h1}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Header#isHeaderElement(String)}
   */
  @Test
  public void testIsHeaderElement_whenH1_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Header.isHeaderElement("h1"));
  }

  /**
   * Test {@link Header#isHeaderElement(String)}.
   * <ul>
   *   <li>When {@code Tag}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Header#isHeaderElement(String)}
   */
  @Test
  public void testIsHeaderElement_whenTag_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Header.isHeaderElement("Tag"));
  }

  /**
   * Test {@link Header#validate()}.
   * <ul>
   *   <li>Given {@link Header#Header(Element, String)} with parent is
   * {@link Bold#Bold(Element)} and {@code Tag}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Header#validate()}
   */
  @Test
  public void testValidate_givenHeaderWithParentIsBoldAndTag() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new Header(new Bold(new BulletList(mock(Element.class))), "Tag")).validate();
  }

  /**
   * Test {@link Header#validate()}.
   * <ul>
   *   <li>Given {@link Header#Header(Element, String)} with parent is
   * {@link Bold#Bold(Element)} and {@code Tag} addChild {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Header#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate_givenHeaderWithParentIsBoldAndTagAddChildNull() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertContentModel(Element.java:701)
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertPhrasingContent(Element.java:673)
    //       at org.symphonyoss.symphony.messageml.elements.Header.validate(Header.java:56)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Header header = new Header(new Bold(new BulletList(mock(Element.class))), "Tag");
    header.addChild(null);

    // Act
    header.validate();
  }

  /**
   * Test {@link Header#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} {@link BiItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Header#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountBiItem() {
    // Arrange
    Header header = new Header(new Bold(new BulletList(mock(Element.class))), "Tag");

    BiContext context = new BiContext();
    BiItem biItem = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItemWithValue("headers", biItem);
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    header.updateBiContext(context);

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
   * Test {@link Header#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} is {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Header#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountIsItemValue() {
    // Arrange
    Header header = new Header(new Bold(new BulletList(mock(Element.class))), "Tag");

    BiContext context = new BiContext();
    context.addItemWithValue("headers", "Item Value");
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    header.updateBiContext(context);

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
   * Test {@link Header#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Header#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    Header header = new Header(new Bold(new BulletList(mock(Element.class))), "Tag");

    BiContext context = new BiContext();
    context.addItem(new BiItem("headers", Element.STYLE_ATTR));

    // Act
    header.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    assertTrue(attributes.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link Header#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Header#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsSizeIsTwo() {
    // Arrange
    Header header = new Header(new Bold(new BulletList(mock(Element.class))), "Tag");

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    header.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("headers", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Header#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is
   * {@code headers}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Header#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsHeaders() {
    // Arrange
    Header header = new Header(new Bold(new BulletList(mock(Element.class))), "Tag");

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    header.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("headers", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Header#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is
   * {@code headers}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Header#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsHeaders() {
    // Arrange
    Header header = new Header(new Bold(new BulletList(mock(Element.class))), "Tag");
    BiContext context = new BiContext();

    // Act
    header.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("headers", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }
}
