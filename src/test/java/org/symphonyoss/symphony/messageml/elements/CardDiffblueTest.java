package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class CardDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Card#Card(Element, FormatEnum)}
   *   <li>{@link Card#getPresentationMLTag()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    Card actualCard = new Card(parent, FormatEnum.MESSAGEML);
    String actualPresentationMLTag = actualCard.getPresentationMLTag();

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualCard.getFormat());
    assertTrue(actualCard.getChildren().isEmpty());
    assertTrue(actualCard.getAttributes().isEmpty());
    assertEquals(Card.MESSAGEML_TAG, actualCard.getMessageMLTag());
    assertEquals(Div.MESSAGEML_TAG, actualPresentationMLTag);
    assertSame(parent, actualCard.getParent());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    Card card = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(26L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    Card card = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    card.addChild(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(37L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    Card card = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    card.addChild(new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(70L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    Card card = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    card.addChild(new Button(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(61L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() {
    // Arrange
    Card card = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    card.addChild(new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(54L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML6() {
    // Arrange
    Card card = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    card.addChild(new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(58L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML7() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    Card card = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    card.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(50L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML8() {
    // Arrange
    Card card = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    card.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(90L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML9() {
    // Arrange
    Card card = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(26L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML10() {
    // Arrange
    Card card = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(26L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML11() {
    // Arrange
    Card card = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(24L, out.getOffset());
  }

  /**
   * Test {@link Card#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} {@link BiItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Card#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountBiItem() {
    // Arrange
    Card card = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    BiItem biItem = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItemWithValue("cards", biItem);
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    card.updateBiContext(context);

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
   * Test {@link Card#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} is {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Card#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountIsItemValue() {
    // Arrange
    Card card = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItemWithValue("cards", "Item Value");
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    card.updateBiContext(context);

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
   * Test {@link Card#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Card#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    Card card = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItem(new BiItem("cards", Element.STYLE_ATTR));

    // Act
    card.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    assertTrue(attributes.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link Card#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Card#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsSizeIsTwo() {
    // Arrange
    Card card = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    card.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("cards", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Card#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is
   * {@code cards}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Card#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsCards() {
    // Arrange
    Card card = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    card.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("cards", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Card#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is
   * {@code cards}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Card#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsCards() {
    // Arrange
    Card card = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    card.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("cards", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }
}
