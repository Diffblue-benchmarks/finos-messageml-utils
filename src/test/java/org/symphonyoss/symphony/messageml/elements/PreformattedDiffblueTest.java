package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import org.commonmark.node.Node;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.PreformattedNode;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class PreformattedDiffblueTest {
  /**
   * Test {@link Preformatted#Preformatted(Element)}.
   * <p>
   * Method under test: {@link Preformatted#Preformatted(Element)}
   */
  @Test
  public void testNewPreformatted() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Preformatted actualPreformatted = new Preformatted(parent);

    // Assert
    assertEquals(0, actualPreformatted.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualPreformatted.getFormat());
    assertTrue(actualPreformatted.getChildren().isEmpty());
    assertTrue(actualPreformatted.getAttributes().isEmpty());
    assertEquals(Preformatted.MESSAGEML_TAG, actualPreformatted.getMessageMLTag());
    assertEquals(Preformatted.MESSAGEML_TAG, actualPreformatted.getPresentationMLTag());
    assertSame(parent, actualPreformatted.getParent());
  }

  /**
   * Test {@link Preformatted#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Preformatted#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    Preformatted preformatted = new Preformatted(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    preformatted.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(13L, out.getOffset());
  }

  /**
   * Test {@link Preformatted#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Preformatted#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    Preformatted preformatted = new Preformatted(new Bold(new BulletList(mock(Element.class))));
    preformatted.addChild(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    preformatted.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(24L, out.getOffset());
  }

  /**
   * Test {@link Preformatted#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Preformatted#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    Preformatted preformatted = new Preformatted(new Bold(new BulletList(mock(Element.class))));
    preformatted.addChild(new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    preformatted.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(57L, out.getOffset());
  }

  /**
   * Test {@link Preformatted#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Preformatted#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    Preformatted preformatted = new Preformatted(new Bold(new BulletList(mock(Element.class))));
    preformatted.addChild(new Button(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    preformatted.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(48L, out.getOffset());
  }

  /**
   * Test {@link Preformatted#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Preformatted#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() {
    // Arrange
    Preformatted preformatted = new Preformatted(new Bold(new BulletList(mock(Element.class))));
    preformatted.addChild(new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    preformatted.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(45L, out.getOffset());
  }

  /**
   * Test {@link Preformatted#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Preformatted#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML6() {
    // Arrange
    Preformatted preformatted = new Preformatted(new Bold(new BulletList(mock(Element.class))));
    preformatted.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    preformatted.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(77L, out.getOffset());
  }

  /**
   * Test {@link Preformatted#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Preformatted#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML7() {
    // Arrange
    Preformatted preformatted = new Preformatted(new Bold(new BulletList(mock(Element.class))));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    preformatted.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(11L, out.getOffset());
  }

  /**
   * Test {@link Preformatted#asMarkdown()}.
   * <p>
   * Method under test: {@link Preformatted#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() throws InvalidInputException {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Preformatted(new Bold(new BulletList(mock(Element.class))))).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof PreformattedNode);
    assertEquals("\n", ((PreformattedNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals("\n", ((PreformattedNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link Preformatted#validate()}.
   * <ul>
   *   <li>Given {@link Preformatted#Preformatted(Element)} with parent is
   * {@link Bold#Bold(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Preformatted#validate()}
   */
  @Test
  public void testValidate_givenPreformattedWithParentIsBold() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new Preformatted(new Bold(new BulletList(mock(Element.class))))).validate();
  }

  /**
   * Test {@link Preformatted#validate()}.
   * <ul>
   *   <li>Given {@link Preformatted#Preformatted(Element)} with parent is
   * {@link Bold#Bold(Element)} addChild {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Preformatted#validate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate_givenPreformattedWithParentIsBoldAddChildNull() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertContentModel(Element.java:701)
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertPhrasingContent(Element.java:673)
    //       at org.symphonyoss.symphony.messageml.elements.Preformatted.validate(Preformatted.java:58)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Preformatted preformatted = new Preformatted(new Bold(new BulletList(mock(Element.class))));
    preformatted.addChild(null);

    // Act
    preformatted.validate();
  }

  /**
   * Test {@link Preformatted#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} {@link BiItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Preformatted#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountBiItem() {
    // Arrange
    Preformatted preformatted = new Preformatted(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    BiItem biItem = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItemWithValue("pres", biItem);
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    preformatted.updateBiContext(context);

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
   * Test {@link Preformatted#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} is {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Preformatted#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountIsItemValue() {
    // Arrange
    Preformatted preformatted = new Preformatted(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItemWithValue("pres", "Item Value");
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    preformatted.updateBiContext(context);

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
   * Test {@link Preformatted#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Preformatted#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    Preformatted preformatted = new Preformatted(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItem(new BiItem("pres", Element.STYLE_ATTR));

    // Act
    preformatted.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    assertTrue(attributes.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link Preformatted#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Preformatted#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsSizeIsTwo() {
    // Arrange
    Preformatted preformatted = new Preformatted(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    preformatted.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("pres", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Preformatted#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is
   * {@code pres}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Preformatted#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsPres() {
    // Arrange
    Preformatted preformatted = new Preformatted(new Bold(new BulletList(mock(Element.class))));

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    preformatted.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("pres", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Preformatted#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is
   * {@code pres}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Preformatted#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsPres() {
    // Arrange
    Preformatted preformatted = new Preformatted(new Bold(new BulletList(mock(Element.class))));
    BiContext context = new BiContext();

    // Act
    preformatted.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("pres", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }
}
