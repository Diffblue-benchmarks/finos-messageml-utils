package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.DatePickerNode;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;
import org.w3c.dom.Node;

public class DatePickerDiffblueTest {
  /**
   * Test {@link DatePicker#DatePicker(Element, FormatEnum)}.
   *
   * <p>Method under test: {@link DatePicker#DatePicker(Element, FormatEnum)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatePicker.<init>(Element, FormatEnum)"})
  public void testNewDatePicker() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    DatePicker actualDatePicker = new DatePicker(parent, FormatEnum.MESSAGEML);

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualDatePicker.getFormat());
    assertTrue(actualDatePicker.getChildren().isEmpty());
    assertTrue(actualDatePicker.getAttributes().isEmpty());
    assertEquals(DatePicker.MESSAGEML_TAG, actualDatePicker.getMessageMLTag());
    assertEquals(DatePicker.MESSAGEML_TAG, actualDatePicker.getPresentationMLTag());
    assertSame(parent, actualDatePicker.getParent());
  }

  /**
   * Test {@link DatePicker#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>Given {@link DatePicker#DatePicker(Element, FormatEnum)} with parent is {@link
   *       Bold#Bold(Element)} and format is {@link FormatEnum#PRESENTATIONML}.
   * </ul>
   *
   * <p>Method under test: {@link DatePicker#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatePicker.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_givenDatePickerWithParentIsBoldAndFormatIsPresentationml()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DatePicker datePicker = new DatePicker(parent2, FormatEnum.PRESENTATIONML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> datePicker.buildAttribute(parser, new IIOMetadataNode("disabled-date")));
  }

  /**
   * Test {@link DatePicker#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code data-disabled-date}.
   * </ul>
   *
   * <p>Method under test: {@link DatePicker#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatePicker.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithDataDisabledDate()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DatePicker datePicker = new DatePicker(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> datePicker.buildAttribute(parser, new IIOMetadataNode("data-disabled-date")));
  }

  /**
   * Test {@link DatePicker#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code data-format}.
   * </ul>
   *
   * <p>Method under test: {@link DatePicker#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatePicker.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithDataFormat() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DatePicker datePicker = new DatePicker(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> datePicker.buildAttribute(parser, new IIOMetadataNode("data-format")));
  }

  /**
   * Test {@link DatePicker#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code data-highlighted-date}.
   * </ul>
   *
   * <p>Method under test: {@link DatePicker#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatePicker.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithDataHighlightedDate()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DatePicker datePicker = new DatePicker(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> datePicker.buildAttribute(parser, new IIOMetadataNode("data-highlighted-date")));
  }

  /**
   * Test {@link DatePicker#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@link Element#ID_ATTR}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link DatePicker#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatePicker.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithId_attr_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DatePicker datePicker = new DatePicker(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> datePicker.buildAttribute(parser, new IIOMetadataNode(Element.ID_ATTR)));
  }

  /**
   * Test {@link DatePicker#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@link Entity#TYPE_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link DatePicker#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatePicker.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithType_field() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DatePicker datePicker = new DatePicker(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> datePicker.buildAttribute(parser, new IIOMetadataNode(Entity.TYPE_FIELD)));
  }

  /**
   * Test {@link DatePicker#validate()}.
   *
   * <ul>
   *   <li>Given {@link BulletList#BulletList(Element)} with parent is {@code null}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link DatePicker#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatePicker.validate()"})
  public void testValidate_givenBulletListWithParentIsNull_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> new DatePicker(parent, FormatEnum.MESSAGEML).validate());
  }

  /**
   * Test {@link DatePicker#validate()}.
   *
   * <ul>
   *   <li>Given {@link Checkbox} {@link Checkbox#getParent()} return {@link Bold#Bold(Element)}
   *       with parent is {@link BulletList#BulletList(Element)}.
   * </ul>
   *
   * <p>Method under test: {@link DatePicker#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatePicker.validate()"})
  public void testValidate_givenCheckboxGetParentReturnBoldWithParentIsBulletList()
      throws InvalidInputException {
    // Arrange
    Checkbox parent = mock(Checkbox.class);
    when(parent.getParent()).thenReturn(new Bold(new BulletList(null)));
    BulletList parent2 = new BulletList(parent);
    Bold parent3 = new Bold(parent2);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> new DatePicker(parent3, FormatEnum.MESSAGEML).validate());
    verify(parent, atLeast(1)).getParent();
  }

  /**
   * Test {@link DatePicker#validate()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DatePicker#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatePicker.validate()"})
  public void testValidate_thenThrowIllegalArgumentException() throws InvalidInputException {
    // Arrange
    Checkbox parent = mock(Checkbox.class);
    when(parent.getParent()).thenThrow(new IllegalArgumentException());
    BulletList parent2 = new BulletList(parent);
    Bold parent3 = new Bold(parent2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new DatePicker(parent3, FormatEnum.MESSAGEML).validate());
    verify(parent).getParent();
  }

  /**
   * Test {@link DatePicker#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DatePicker#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatePicker.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DatePicker datePicker = new DatePicker(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setPrintOffsets(true);

    // Act
    datePicker.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(35L, out.getOffset());
  }

  /**
   * Test {@link DatePicker#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DatePicker#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatePicker.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DatePicker datePicker = new DatePicker(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoIndent(true);

    // Act
    datePicker.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(35L, out.getOffset());
  }

  /**
   * Test {@link DatePicker#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link DatePicker#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatePicker.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DatePicker datePicker = new DatePicker(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    datePicker.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(32L, out.getOffset());
  }

  /**
   * Test {@link DatePicker#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <ul>
   *   <li>When {@link XmlPrintStream#XmlPrintStream(OutputStream)} with outputStream is {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link DatePicker#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatePicker.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML_whenXmlPrintStreamWithOutputStreamIsByteArrayOutputStream() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DatePicker datePicker = new DatePicker(parent2, FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    datePicker.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(35L, out.getOffset());
  }

  /**
   * Test {@link DatePicker#asMarkdown()}.
   *
   * <p>Method under test: {@link DatePicker#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.commonmark.node.Node DatePicker.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    org.commonmark.node.Node actualAsMarkdownResult =
        new DatePicker(parent2, FormatEnum.MESSAGEML).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof DatePickerNode);
    assertEquals("", ((DatePickerNode) actualAsMarkdownResult).getText());
    assertEquals("(Date Picker", ((DatePickerNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals(")", ((DatePickerNode) actualAsMarkdownResult).getClosingDelimiter());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link DatePicker#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>When {@link BiContext} (default constructor).
   *   <li>Then {@link BiContext} (default constructor) Items size is one.
   * </ul>
   *
   * <p>Method under test: {@link DatePicker#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatePicker.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsSizeIsOne() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    DatePicker datePicker = new DatePicker(parent2, FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    datePicker.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("dateselector", getResult.getName());
    assertTrue(getResult.getAttributes().isEmpty());
  }
}
