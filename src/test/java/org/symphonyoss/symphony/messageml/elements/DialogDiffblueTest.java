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
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.DialogNode;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class DialogDiffblueTest {
  /**
   * Test {@link Dialog#Dialog(Element, FormatEnum)}.
   * <p>
   * Method under test: {@link Dialog#Dialog(Element, FormatEnum)}
   */
  @Test
  public void testNewDialog() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    Dialog actualDialog = new Dialog(parent, FormatEnum.MESSAGEML);

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualDialog.getFormat());
    assertTrue(actualDialog.getChildren().isEmpty());
    assertTrue(actualDialog.getAttributes().isEmpty());
    assertEquals(Dialog.MESSAGEML_TAG, actualDialog.getMessageMLTag());
    assertEquals(Dialog.MESSAGEML_TAG, actualDialog.getPresentationMLTag());
    assertSame(parent, actualDialog.getParent());
  }

  /**
   * Test {@link Dialog#hasIdAttribute()}.
   * <p>
   * Method under test: {@link Dialog#hasIdAttribute()}
   */
  @Test
  public void testHasIdAttribute() {
    // Arrange, Act and Assert
    assertTrue((new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML)).hasIdAttribute());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    Dialog dialog = new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(27L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    Dialog dialog = new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.PRESENTATIONML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(19L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    Dialog dialog = new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    dialog.addChild(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(38L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    Dialog dialog = new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    dialog.addChild(new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(71L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() {
    // Arrange
    Dialog dialog = new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    dialog.addChild(new Button(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(62L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML6() {
    // Arrange
    Dialog dialog = new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    dialog.addChild(new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(55L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML7() {
    // Arrange
    Dialog dialog = new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    dialog.addChild(new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(59L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML8() {
    // Arrange
    Bold child = new Bold(new BulletList(mock(Element.class)));
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    Dialog dialog = new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    dialog.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(51L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML9() {
    // Arrange
    Dialog dialog = new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    dialog.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(91L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML10() {
    // Arrange
    Dialog dialog = new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(27L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML11() {
    // Arrange
    Dialog dialog = new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(27L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML12() {
    // Arrange
    Dialog dialog = new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(25L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asMarkdown()}.
   * <p>
   * Method under test: {@link Dialog#asMarkdown()}
   */
  @Test
  public void testAsMarkdown() throws InvalidInputException {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof DialogNode);
    assertEquals("", ((DialogNode) actualAsMarkdownResult).getText());
    assertEquals("---\n", ((DialogNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals("---\n**Dialog**\n", ((DialogNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link Dialog#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} {@link BiItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dialog#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountBiItem() {
    // Arrange
    Dialog dialog = new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    BiItem biItem = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItemWithValue("popups", biItem);
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    dialog.updateBiContext(context);

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
   * Test {@link Dialog#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes
   * {@code count} is {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dialog#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountIsItemValue() {
    // Arrange
    Dialog dialog = new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItemWithValue("popups", "Item Value");
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    dialog.updateBiContext(context);

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
   * Test {@link Dialog#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dialog#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    Dialog dialog = new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItem(new BiItem("popups", Element.STYLE_ATTR));

    // Act
    dialog.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    assertTrue(attributes.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link Dialog#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dialog#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsSizeIsTwo() {
    // Arrange
    Dialog dialog = new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    dialog.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("popups", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Dialog#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is
   * {@code popups}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dialog#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsPopups() {
    // Arrange
    Dialog dialog = new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    dialog.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("popups", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Dialog#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is
   * {@code popups}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dialog#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsPopups() {
    // Arrange
    Dialog dialog = new Dialog(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    dialog.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("popups", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }
}
