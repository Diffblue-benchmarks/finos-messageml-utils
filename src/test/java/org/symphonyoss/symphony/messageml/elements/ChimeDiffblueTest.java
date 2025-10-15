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

public class ChimeDiffblueTest {
  /**
   * Test {@link Chime#Chime(Element, FormatEnum)}.
   *
   * <ul>
   *   <li>Then Parent return {@link MessageML}.
   * </ul>
   *
   * <p>Method under test: {@link Chime#Chime(Element, FormatEnum)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chime.<init>(Element, FormatEnum)"})
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
   *
   * <ul>
   *   <li>When {@link BulletList#BulletList(Element)} with parent is {@link Element}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Chime#Chime(Element, FormatEnum)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chime.<init>(Element, FormatEnum)"})
  public void testNewChime_whenBulletListWithParentIsElement_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> new Chime(parent2, FormatEnum.MESSAGEML));
  }

  /**
   * Test {@link Chime#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Chime#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chime.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> chime.buildAttribute(parser, new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chime.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    chime.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(85L, out.getOffset());
  }

  /**
   * Test {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chime.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setPrintOffsets(true);

    // Act
    chime.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(85L, out.getOffset());
  }

  /**
   * Test {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chime.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoIndent(true);

    // Act
    chime.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(84L, out.getOffset());
  }

  /**
   * Test {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chime.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML4() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    chime.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(83L, out.getOffset());
  }

  /**
   * Test {@link Chime#asText()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link Chime#asText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Chime.asText()"})
  public void testAsText_thenReturnEmptyString() throws InvalidInputException {
    // Arrange, Act and Assert
    assertEquals(
        "", new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML).asText());
  }

  /**
   * Test {@link Chime#validate()}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Chime#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chime.validate()"})
  public void testValidate_thenDoesNotThrow() throws InvalidInputException {
    // Arrange, Act and Assert
    new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML).validate();
  }

  /**
   * Test {@link Chime#validate()}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Chime#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chime.validate()"})
  public void testValidate_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);
    chime.addChild(new Bold(new BulletList(null)));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> chime.validate());
  }

  /**
   * Test {@link Chime#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes {@code count} {@link
   *       BiItem}.
   * </ul>
   *
   * <p>Method under test: {@link Chime#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chime.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountBiItem()
      throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    BiItem biItem = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);
    context.addItemWithValue("chimes", biItem);
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    chime.updateBiContext(context);

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
   * Test {@link Chime#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes {@code count} is
   *       {@code Item Value}.
   * </ul>
   *
   * <p>Method under test: {@link Chime#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chime.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountIsItemValue()
      throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItemWithValue("chimes", "Item Value");
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    chime.updateBiContext(context);

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
   * Test {@link Chime#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size is two.
   * </ul>
   *
   * <p>Method under test: {@link Chime#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chime.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo()
      throws InvalidInputException {
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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.
   * </ul>
   *
   * <p>Method under test: {@link Chime#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chime.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsTwo() throws InvalidInputException {
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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is {@code chimes}.
   * </ul>
   *
   * <p>Method under test: {@link Chime#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chime.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsChimes()
      throws InvalidInputException {
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
   *
   * <ul>
   *   <li>When {@link BiContext} (default constructor).
   *   <li>Then {@link BiContext} (default constructor) Items first Name is {@code chimes}.
   * </ul>
   *
   * <p>Method under test: {@link Chime#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Chime.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsChimes()
      throws InvalidInputException {
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
