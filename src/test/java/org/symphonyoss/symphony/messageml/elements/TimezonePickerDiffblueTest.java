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
import java.time.DateTimeException;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.TimezonePickerNode;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;
import org.w3c.dom.Node;

public class TimezonePickerDiffblueTest {
  /**
   * Test {@link TimezonePicker#TimezonePicker(Element, FormatEnum)}.
   *
   * <p>Method under test: {@link TimezonePicker#TimezonePicker(Element, FormatEnum)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePicker.<init>(Element, FormatEnum)"})
  public void testNewTimezonePicker() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    TimezonePicker actualTimezonePicker = new TimezonePicker(parent, FormatEnum.MESSAGEML);

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualTimezonePicker.getFormat());
    assertTrue(actualTimezonePicker.getChildren().isEmpty());
    assertTrue(actualTimezonePicker.getAttributes().isEmpty());
    assertEquals(TimezonePicker.MESSAGEML_TAG, actualTimezonePicker.getMessageMLTag());
    assertEquals(TimezonePicker.MESSAGEML_TAG, actualTimezonePicker.getPresentationMLTag());
    assertSame(parent, actualTimezonePicker.getParent());
  }

  /**
   * Test {@link TimezonePicker#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>Given {@link TimezonePicker#TimezonePicker(Element, FormatEnum)} with parent is {@link
   *       Bold#Bold(Element)} and format is {@link FormatEnum#PRESENTATIONML}.
   * </ul>
   *
   * <p>Method under test: {@link TimezonePicker#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePicker.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_givenTimezonePickerWithParentIsBoldAndFormatIsPresentationml()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TimezonePicker timezonePicker = new TimezonePicker(parent2, FormatEnum.PRESENTATIONML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> timezonePicker.buildAttribute(parser, new IIOMetadataNode("disabled-timezone")));
  }

  /**
   * Test {@link TimezonePicker#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code data-disabled-timezone}.
   * </ul>
   *
   * <p>Method under test: {@link TimezonePicker#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePicker.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithDataDisabledTimezone()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TimezonePicker timezonePicker = new TimezonePicker(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> timezonePicker.buildAttribute(parser, new IIOMetadataNode("data-disabled-timezone")));
  }

  /**
   * Test {@link TimezonePicker#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code data-name}.
   * </ul>
   *
   * <p>Method under test: {@link TimezonePicker#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePicker.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithDataName() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TimezonePicker timezonePicker = new TimezonePicker(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> timezonePicker.buildAttribute(parser, new IIOMetadataNode("data-name")));
  }

  /**
   * Test {@link TimezonePicker#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code data-placeholder}.
   * </ul>
   *
   * <p>Method under test: {@link TimezonePicker#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePicker.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithDataPlaceholder()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TimezonePicker timezonePicker = new TimezonePicker(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> timezonePicker.buildAttribute(parser, new IIOMetadataNode("data-placeholder")));
  }

  /**
   * Test {@link TimezonePicker#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code data-required}.
   * </ul>
   *
   * <p>Method under test: {@link TimezonePicker#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePicker.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithDataRequired()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TimezonePicker timezonePicker = new TimezonePicker(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> timezonePicker.buildAttribute(parser, new IIOMetadataNode("data-required")));
  }

  /**
   * Test {@link TimezonePicker#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code data-value}.
   * </ul>
   *
   * <p>Method under test: {@link TimezonePicker#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePicker.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithDataValue() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TimezonePicker timezonePicker = new TimezonePicker(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> timezonePicker.buildAttribute(parser, new IIOMetadataNode("data-value")));
  }

  /**
   * Test {@link TimezonePicker#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@link Element#ID_ATTR}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link TimezonePicker#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePicker.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithId_attr_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TimezonePicker timezonePicker = new TimezonePicker(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> timezonePicker.buildAttribute(parser, new IIOMetadataNode(Element.ID_ATTR)));
  }

  /**
   * Test {@link TimezonePicker#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code Node Name}.
   * </ul>
   *
   * <p>Method under test: {@link TimezonePicker#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePicker.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithNodeName() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TimezonePicker timezonePicker = new TimezonePicker(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> timezonePicker.buildAttribute(parser, new IIOMetadataNode("Node Name")));
  }

  /**
   * Test {@link TimezonePicker#validate()}.
   *
   * <ul>
   *   <li>Given {@link BulletList#BulletList(Element)} with parent is {@code null}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link TimezonePicker#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePicker.validate()"})
  public void testValidate_givenBulletListWithParentIsNull_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> new TimezonePicker(parent, FormatEnum.MESSAGEML).validate());
  }

  /**
   * Test {@link TimezonePicker#validate()}.
   *
   * <ul>
   *   <li>Given {@link Checkbox} {@link Checkbox#getParent()} return {@link Bold#Bold(Element)}
   *       with parent is {@link BulletList#BulletList(Element)}.
   * </ul>
   *
   * <p>Method under test: {@link TimezonePicker#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePicker.validate()"})
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
        () -> new TimezonePicker(parent3, FormatEnum.MESSAGEML).validate());
    verify(parent, atLeast(1)).getParent();
  }

  /**
   * Test {@link TimezonePicker#validate()}.
   *
   * <ul>
   *   <li>Then throw {@link DateTimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TimezonePicker#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePicker.validate()"})
  public void testValidate_thenThrowDateTimeException() throws InvalidInputException {
    // Arrange
    Checkbox parent = mock(Checkbox.class);
    when(parent.getParent()).thenThrow(new DateTimeException("An error occurred"));
    BulletList parent2 = new BulletList(parent);
    Bold parent3 = new Bold(parent2);

    // Act and Assert
    assertThrows(
        DateTimeException.class,
        () -> new TimezonePicker(parent3, FormatEnum.MESSAGEML).validate());
    verify(parent).getParent();
  }

  /**
   * Test {@link TimezonePicker#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link TimezonePicker#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePicker.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TimezonePicker timezonePicker = new TimezonePicker(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setPrintOffsets(true);

    // Act
    timezonePicker.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(37L, out.getOffset());
  }

  /**
   * Test {@link TimezonePicker#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link TimezonePicker#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePicker.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TimezonePicker timezonePicker = new TimezonePicker(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoIndent(true);

    // Act
    timezonePicker.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(37L, out.getOffset());
  }

  /**
   * Test {@link TimezonePicker#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link TimezonePicker#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePicker.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TimezonePicker timezonePicker = new TimezonePicker(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    timezonePicker.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(35L, out.getOffset());
  }

  /**
   * Test {@link TimezonePicker#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <ul>
   *   <li>When {@link XmlPrintStream#XmlPrintStream(OutputStream)} with outputStream is {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link TimezonePicker#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePicker.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML_whenXmlPrintStreamWithOutputStreamIsByteArrayOutputStream() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TimezonePicker timezonePicker = new TimezonePicker(parent2, FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    timezonePicker.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(37L, out.getOffset());
  }

  /**
   * Test {@link TimezonePicker#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>When {@link BiContext} (default constructor).
   *   <li>Then {@link BiContext} (default constructor) Items size is one.
   * </ul>
   *
   * <p>Method under test: {@link TimezonePicker#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimezonePicker.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsSizeIsOne() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    TimezonePicker timezonePicker = new TimezonePicker(parent2, FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    timezonePicker.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("timezonepicker", getResult.getName());
    assertTrue(getResult.getAttributes().isEmpty());
  }

  /**
   * Test {@link TimezonePicker#asMarkdown()}.
   *
   * <ul>
   *   <li>Given {@link TimezonePicker#TimezonePicker(Element, FormatEnum)} with parent is {@link
   *       Bold#Bold(Element)} and format is {@code MESSAGEML}.
   * </ul>
   *
   * <p>Method under test: {@link TimezonePicker#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.commonmark.node.Node TimezonePicker.asMarkdown()"})
  public void testAsMarkdown_givenTimezonePickerWithParentIsBoldAndFormatIsMessageml() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    org.commonmark.node.Node actualAsMarkdownResult =
        new TimezonePicker(parent2, FormatEnum.MESSAGEML).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof TimezonePickerNode);
    assertEquals("", ((TimezonePickerNode) actualAsMarkdownResult).getText());
    assertEquals(
        "(Timezone Picker", ((TimezonePickerNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals(")", ((TimezonePickerNode) actualAsMarkdownResult).getClosingDelimiter());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link TimezonePicker#asMarkdown()}.
   *
   * <ul>
   *   <li>Given {@link TimezonePicker#TimezonePicker(Element, FormatEnum)} with parent is {@link
   *       Bold#Bold(Element)} and format is {@code PRESENTATIONML}.
   * </ul>
   *
   * <p>Method under test: {@link TimezonePicker#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.commonmark.node.Node TimezonePicker.asMarkdown()"})
  public void testAsMarkdown_givenTimezonePickerWithParentIsBoldAndFormatIsPresentationml() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    org.commonmark.node.Node actualAsMarkdownResult =
        new TimezonePicker(parent2, FormatEnum.PRESENTATIONML).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof TimezonePickerNode);
    assertEquals("", ((TimezonePickerNode) actualAsMarkdownResult).getText());
    assertEquals(
        "(Timezone Picker", ((TimezonePickerNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals(")", ((TimezonePickerNode) actualAsMarkdownResult).getClosingDelimiter());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }
}
