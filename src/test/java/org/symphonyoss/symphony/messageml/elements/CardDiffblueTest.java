package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;
import org.w3c.dom.Node;

public class CardDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Card#Card(Element, FormatEnum)}
   *   <li>{@link Card#getPresentationMLTag()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.<init>(Element, FormatEnum)", "String Card.getPresentationMLTag()"})
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
   * Test {@link Card#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>Given {@link Card#Card(Element, FormatEnum)} with parent is {@link Bold#Bold(Element)}
   *       and format is {@code PRESENTATIONML}.
   * </ul>
   *
   * <p>Method under test: {@link Card#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_givenCardWithParentIsBoldAndFormatIsPresentationml()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Card card = new Card(parent2, FormatEnum.PRESENTATIONML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> card.buildAttribute(parser, new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link Card#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Card#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Card card = new Card(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> card.buildAttribute(parser, new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Card card = new Card(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    card.addChild(new Bold(parent3));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(37L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Card card = new Card(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setPrintOffsets(true);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(26L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Card card = new Card(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoIndent(true);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(26L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML4() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Card card = new Card(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(24L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML5() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Card card = new Card(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    card.addChild(new Checkbox(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(70L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML6() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Card card = new Card(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    card.addChild(new Button(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(61L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML7() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Card card = new Card(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    card.addChild(new Card(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(54L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML8() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Card card = new Card(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    card.addChild(new CardBody(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(58L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML9() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent2));
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);

    Card card = new Card(parent4, FormatEnum.MESSAGEML);
    card.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(50L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML10() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Card card = new Card(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    card.addChild(new CashTag(parent4, 1));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(90L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML11() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Card card = new Card(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    card.addChild(new Checkbox(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(65L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML12() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new Checkbox(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Card card = new Card(parent5, FormatEnum.MESSAGEML);
    card.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(83L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML13() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new Button(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Card card = new Card(parent5, FormatEnum.MESSAGEML);
    card.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(74L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML14() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new Card(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Card card = new Card(parent5, FormatEnum.MESSAGEML);
    card.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(67L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML15() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CardBody(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Card card = new Card(parent5, FormatEnum.MESSAGEML);
    card.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(71L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML16() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CashTag(parent3, 1));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Card card = new Card(parent5, FormatEnum.MESSAGEML);
    card.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(103L, out.getOffset());
  }

  /**
   * Test {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <ul>
   *   <li>When {@link XmlPrintStream#XmlPrintStream(OutputStream)} with outputStream is {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link Card#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML_whenXmlPrintStreamWithOutputStreamIsByteArrayOutputStream() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Card card = new Card(parent2, FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    card.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(26L, out.getOffset());
  }

  /**
   * Test {@link Card#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes {@code count} {@link
   *       BiItem}.
   * </ul>
   *
   * <p>Method under test: {@link Card#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountBiItem() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Card card = new Card(parent2, FormatEnum.MESSAGEML);

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes {@code count} is
   *       {@code Item Value}.
   * </ul>
   *
   * <p>Method under test: {@link Card#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountIsItemValue() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Card card = new Card(parent2, FormatEnum.MESSAGEML);

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size is two.
   * </ul>
   *
   * <p>Method under test: {@link Card#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Card card = new Card(parent2, FormatEnum.MESSAGEML);

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.
   * </ul>
   *
   * <p>Method under test: {@link Card#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsTwo() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Card card = new Card(parent2, FormatEnum.MESSAGEML);

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is {@code cards}.
   * </ul>
   *
   * <p>Method under test: {@link Card#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsCards() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Card card = new Card(parent2, FormatEnum.MESSAGEML);

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
   *
   * <ul>
   *   <li>When {@link BiContext} (default constructor).
   *   <li>Then {@link BiContext} (default constructor) Items first Name is {@code cards}.
   * </ul>
   *
   * <p>Method under test: {@link Card#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Card.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsCards() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Card card = new Card(parent2, FormatEnum.MESSAGEML);
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
