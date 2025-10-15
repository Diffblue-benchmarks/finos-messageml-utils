package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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
import org.symphonyoss.symphony.messageml.markdown.nodes.form.DialogNode;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;
import org.w3c.dom.Node;

public class DialogDiffblueTest {
  /**
   * Test {@link Dialog#Dialog(Element, FormatEnum)}.
   *
   * <p>Method under test: {@link Dialog#Dialog(Element, FormatEnum)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.<init>(Element, FormatEnum)"})
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
   *
   * <p>Method under test: {@link Dialog#hasIdAttribute()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean Dialog.hasIdAttribute()"})
  public void testHasIdAttribute() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertTrue(new Dialog(parent2, FormatEnum.MESSAGEML).hasIdAttribute());
  }

  /**
   * Test {@link Dialog#buildAttribute(MessageMLParser, Node)}.
   *
   * <p>Method under test: {@link Dialog#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    dialog.buildAttribute(parser, new IIOMetadataNode("data-open"));

    // Assert
    Map<String, String> attributes = dialog.getAttributes();
    assertEquals(1, attributes.size());
    assertNull(attributes.get("open"));
  }

  /**
   * Test {@link Dialog#buildAttribute(MessageMLParser, Node)}.
   *
   * <p>Method under test: {@link Dialog#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute2() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    dialog.buildAttribute(parser, new IIOMetadataNode(Element.ID_ATTR));

    // Assert
    Map<String, String> attributes = dialog.getAttributes();
    assertEquals(1, attributes.size());
    assertNull(attributes.get(Element.ID_ATTR));
  }

  /**
   * Test {@link Dialog#buildAttribute(MessageMLParser, Node)}.
   *
   * <p>Method under test: {@link Dialog#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute3() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.PRESENTATIONML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    dialog.buildAttribute(parser, new IIOMetadataNode("open"));

    // Assert
    Map<String, String> attributes = dialog.getAttributes();
    assertEquals(1, attributes.size());
    assertNull(attributes.get("open"));
  }

  /**
   * Test {@link Dialog#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code data-width}.
   * </ul>
   *
   * <p>Method under test: {@link Dialog#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithDataWidth() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    dialog.buildAttribute(parser, new IIOMetadataNode("data-width"));

    // Assert
    Map<String, String> attributes = dialog.getAttributes();
    assertEquals(1, attributes.size());
    assertNull(attributes.get(Dialog.WIDTH_ATTR));
  }

  /**
   * Test {@link Dialog#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Dialog#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> dialog.buildAttribute(parser, new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link Dialog#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code open}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Dialog#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithOpen_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> dialog.buildAttribute(parser, new IIOMetadataNode("open")));
  }

  /**
   * Test {@link Dialog#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@link
   *       ExpandableCard#PRESENTATIONML_STATE_ATTR}.
   * </ul>
   *
   * <p>Method under test: {@link Dialog#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithPresentationml_state_attr()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    dialog.buildAttribute(parser, new IIOMetadataNode(ExpandableCard.PRESENTATIONML_STATE_ATTR));

    // Assert
    Map<String, String> attributes = dialog.getAttributes();
    assertEquals(1, attributes.size());
    assertNull(attributes.get(Dialog.STATE_ATTR));
  }

  /**
   * Test {@link Dialog#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@link Dialog#STATE_ATTR}.
   * </ul>
   *
   * <p>Method under test: {@link Dialog#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithState_attr() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    dialog.buildAttribute(parser, new IIOMetadataNode(Dialog.STATE_ATTR));

    // Assert
    Map<String, String> attributes = dialog.getAttributes();
    assertEquals(1, attributes.size());
    assertNull(attributes.get(Dialog.STATE_ATTR));
  }

  /**
   * Test {@link Dialog#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@link Dialog#WIDTH_ATTR}.
   * </ul>
   *
   * <p>Method under test: {@link Dialog#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithWidth_attr() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    dialog.buildAttribute(parser, new IIOMetadataNode(Dialog.WIDTH_ATTR));

    // Assert
    Map<String, String> attributes = dialog.getAttributes();
    assertEquals(1, attributes.size());
    assertNull(attributes.get(Dialog.WIDTH_ATTR));
  }

  /**
   * Test {@link Dialog#validate()}.
   *
   * <p>Method under test: {@link Dialog#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.validate()"})
  public void testValidate() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> new Dialog(parent, FormatEnum.MESSAGEML).validate());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(27L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.PRESENTATIONML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(19L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    dialog.addChild(new Bold(parent3));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(38L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML4() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    dialog.addChild(new Checkbox(parent4, FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(71L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML5() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    dialog.addChild(new Button(parent4, FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(62L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML6() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    dialog.addChild(new Card(parent4, FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(55L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML7() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    dialog.addChild(new CardBody(parent4, FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(59L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML8() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent2));
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);

    Dialog dialog = new Dialog(parent4, FormatEnum.MESSAGEML);
    dialog.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(51L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML9() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    dialog.addChild(new CashTag(parent4, 1));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(91L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML10() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setPrintOffsets(true);

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(27L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML11() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoIndent(true);

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(27L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML12() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(25L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML13() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new Checkbox(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Dialog dialog = new Dialog(parent5, FormatEnum.MESSAGEML);
    dialog.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(84L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML14() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new Button(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Dialog dialog = new Dialog(parent5, FormatEnum.MESSAGEML);
    dialog.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(75L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML15() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new Card(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Dialog dialog = new Dialog(parent5, FormatEnum.MESSAGEML);
    dialog.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(68L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML16() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CardBody(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Dialog dialog = new Dialog(parent5, FormatEnum.MESSAGEML);
    dialog.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(72L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML17() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CashTag(parent3, 1));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Dialog dialog = new Dialog(parent5, FormatEnum.MESSAGEML);
    dialog.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(104L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Dialog#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML18() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    dialog.addChild(new Checkbox(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    dialog.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(66L, out.getOffset());
  }

  /**
   * Test {@link Dialog#asMarkdown()}.
   *
   * <p>Method under test: {@link Dialog#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.commonmark.node.Node Dialog.asMarkdown()"})
  public void testAsMarkdown() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    org.commonmark.node.Node actualAsMarkdownResult =
        new Dialog(parent2, FormatEnum.MESSAGEML).asMarkdown();

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes {@code count} {@link
   *       BiItem}.
   * </ul>
   *
   * <p>Method under test: {@link Dialog#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountBiItem() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes {@code count} is
   *       {@code Item Value}.
   * </ul>
   *
   * <p>Method under test: {@link Dialog#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountIsItemValue() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size is two.
   * </ul>
   *
   * <p>Method under test: {@link Dialog#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.
   * </ul>
   *
   * <p>Method under test: {@link Dialog#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsTwo() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);

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
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is {@code popups}.
   * </ul>
   *
   * <p>Method under test: {@link Dialog#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsPopups() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);

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
   *
   * <ul>
   *   <li>When {@link BiContext} (default constructor).
   *   <li>Then {@link BiContext} (default constructor) Items first Name is {@code popups}.
   * </ul>
   *
   * <p>Method under test: {@link Dialog#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dialog.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsPopups() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Dialog dialog = new Dialog(parent2, FormatEnum.MESSAGEML);
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
