package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class ChimeDiffblueTest {
  /**
   * Test {@link Chime#Chime(Element, FormatEnum)}.
   * <ul>
   *   <li>Then Parent return {@link MessageML}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Chime#Chime(Element, FormatEnum)}
   */
  @Test
  public void testNewChime_thenParentReturnMessageML() throws InvalidInputException {
    // Arrange
    MessageML parent = new MessageML(FormatEnum.MESSAGEML, "1.0.2");

    // Act
    Chime actualChime = new Chime(parent, FormatEnum.MESSAGEML);

    // Assert
    Element parent2 = actualChime.getParent();
    assertTrue(parent2 instanceof MessageML);
    assertEquals(0, actualChime.size());
    assertEquals(FormatEnum.MESSAGEML, actualChime.getFormat());
    assertTrue(actualChime.getChildren().isEmpty());
    assertTrue(actualChime.getAttributes().isEmpty());
    assertTrue(parent.isChime());
    assertEquals(Chime.MESSAGEML_TAG, actualChime.getMessageMLTag());
    assertEquals(Chime.PRESENTATIONML_TAG, actualChime.getPresentationMLTag());
    assertSame(parent, parent2);
  }

  /**
   * Test {@link Chime#Chime(Element, FormatEnum)}.
   * <ul>
   *   <li>When {@link BulletList#BulletList(Element)} with parent is
   * {@link Element}.</li>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Chime#Chime(Element, FormatEnum)}
   */
  @Test
  public void testNewChime_whenBulletListWithParentIsElement_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> new Chime(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));

  }

  /**
   * Test {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    chime.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(85L, out.getOffset());
  }

  /**
   * Test {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    chime.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(85L, out.getOffset());
  }

  /**
   * Test {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    chime.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(84L, out.getOffset());
  }

  /**
   * Test {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    chime.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(83L, out.getOffset());
  }

  /**
   * Test {@link Chime#asText()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Chime#asText()}
   */
  @Test
  public void testAsText_thenReturnEmptyString() throws InvalidInputException {
    // Arrange, Act and Assert
    assertEquals("", (new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML)).asText());
  }

  /**
   * Test {@link Chime#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} {@link BiItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Chime#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountBiItem() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    BiItem biItem = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItemWithValue("chimes", biItem);
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    chime.updateBiContext(context);

    // Assert that nothing has changed
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(1, attributes.size());
    Object getResult = attributes.get("count");
    assertTrue(getResult instanceof BiItem);
    Map<String, Object> attributes2 = items.get(1).getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
    assertSame(biItem, getResult);
  }

  /**
   * Test {@link Chime#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} is {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Chime#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountIsItemValue() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItemWithValue("chimes", "Item Value");
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    chime.updateBiContext(context);

    // Assert that nothing has changed
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("Item Value", attributes.get("count"));
    Map<String, Object> attributes2 = items.get(1).getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link Chime#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Chime#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItem(new BiItem("chimes", Element.STYLE_ATTR));

    // Act
    chime.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    assertTrue(attributes.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link Chime#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items second Name is
   * {@code chimes}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Chime#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsSecondNameIsChimes() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    chime.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("chimes", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Chime#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Chime#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsSizeIsThree() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    chime.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("chimes", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Chime#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is
   * {@code chimes}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Chime#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsChimes() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    chime.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("chimes", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }
}
