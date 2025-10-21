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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.form.TimePickerNode;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class TimePickerDiffblueTest {
  /**
   * Test {@link TimePicker#TimePicker(Element, FormatEnum)}.
   * <p>
   * Method under test: {@link TimePicker#TimePicker(Element, FormatEnum)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TimePicker.<init>(Element, FormatEnum)"})
  public void testNewTimePicker() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act
    TimePicker actualTimePicker = new TimePicker(parent, FormatEnum.MESSAGEML);

    // Assert
    assertEquals(FormatEnum.MESSAGEML, actualTimePicker.getFormat());
    assertTrue(actualTimePicker.getChildren().isEmpty());
    assertTrue(actualTimePicker.getAttributes().isEmpty());
    assertEquals(TimePicker.MESSAGEML_TAG, actualTimePicker.getMessageMLTag());
    assertEquals(TimePicker.MESSAGEML_TAG, actualTimePicker.getPresentationMLTag());
    assertSame(parent, actualTimePicker.getParent());
  }

  /**
   * Test {@link TimePicker#validate()}.
   * <p>
   * Method under test: {@link TimePicker#validate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TimePicker.validate()"})
  public void testValidate() throws InvalidInputException {
    // Arrange
    Element parent = mock(Element.class);
    when(parent.getParent()).thenThrow(new NumberFormatException(LabelableElement.LABEL));
    Element parent2 = mock(Element.class);
    when(parent2.getParent()).thenReturn(new Bold(new BulletList(parent)));
    Element parent3 = mock(Element.class);
    when(parent3.getParent()).thenReturn(new Bold(new BulletList(parent2)));
    Element parent4 = mock(Element.class);
    when(parent4.getParent()).thenReturn(new Bold(new BulletList(parent3)));
    Element parent5 = mock(Element.class);
    when(parent5.getParent()).thenReturn(new Bold(new BulletList(parent4)));
    Element parent6 = mock(Element.class);
    when(parent6.getParent()).thenReturn(new Bold(new BulletList(parent5)));
    Element parent7 = mock(Element.class);
    when(parent7.getParent()).thenReturn(new Bold(new BulletList(parent6)));
    Element parent8 = mock(Element.class);
    when(parent8.getParent()).thenReturn(new Bold(new BulletList(parent7)));
    Element parent9 = mock(Element.class);
    when(parent9.getParent()).thenReturn(new Bold(new BulletList(parent8)));
    Element parent10 = mock(Element.class);
    when(parent10.getParent()).thenReturn(new Bold(new BulletList(parent9)));
    Element parent11 = mock(Element.class);
    when(parent11.getParent()).thenReturn(new Bold(new BulletList(parent10)));
    Element parent12 = mock(Element.class);
    when(parent12.getParent()).thenReturn(new Bold(new BulletList(parent11)));
    Element parent13 = mock(Element.class);
    when(parent13.getParent()).thenReturn(new Bold(new BulletList(parent12)));
    Element parent14 = mock(Element.class);
    when(parent14.getParent()).thenReturn(new Bold(new BulletList(parent13)));
    Element parent15 = mock(Element.class);
    when(parent15.getParent()).thenReturn(new Bold(new BulletList(parent14)));
    Element parent16 = mock(Element.class);
    when(parent16.getParent()).thenReturn(new Bold(new BulletList(parent15)));
    Element parent17 = mock(Element.class);
    when(parent17.getParent()).thenReturn(new Bold(new BulletList(parent16)));
    Element parent18 = mock(Element.class);
    when(parent18.getParent()).thenReturn(new Bold(new BulletList(parent17)));
    Element parent19 = mock(Element.class);
    when(parent19.getParent()).thenReturn(new Bold(new BulletList(parent18)));
    Element parent20 = mock(Element.class);
    when(parent20.getParent()).thenReturn(new Bold(new BulletList(parent19)));
    Element parent21 = mock(Element.class);
    when(parent21.getParent()).thenReturn(new Bold(new BulletList(parent20)));
    Element parent22 = mock(Element.class);
    when(parent22.getParent()).thenReturn(new Bold(new BulletList(parent21)));
    Element parent23 = mock(Element.class);
    when(parent23.getParent()).thenReturn(new Bold(new BulletList(parent22)));
    Element parent24 = mock(Element.class);
    when(parent24.getParent()).thenReturn(new Bold(new BulletList(parent23)));
    Element parent25 = mock(Element.class);
    when(parent25.getParent()).thenReturn(new Bold(new BulletList(parent24)));
    Element parent26 = mock(Element.class);
    when(parent26.getParent()).thenReturn(new Bold(new BulletList(parent25)));
    Element parent27 = mock(Element.class);
    when(parent27.getParent()).thenReturn(new Bold(new BulletList(parent26)));
    Element parent28 = mock(Element.class);
    when(parent28.getParent()).thenReturn(new Bold(new BulletList(parent27)));
    Element parent29 = mock(Element.class);
    when(parent29.getParent()).thenReturn(new Bold(new BulletList(parent28)));
    Element parent30 = mock(Element.class);
    when(parent30.getParent()).thenReturn(new Bold(new BulletList(parent29)));
    Element parent31 = mock(Element.class);
    when(parent31.getParent()).thenReturn(new Bold(new BulletList(parent30)));
    Element parent32 = mock(Element.class);
    when(parent32.getParent()).thenReturn(new Bold(new BulletList(parent31)));
    Element parent33 = mock(Element.class);
    when(parent33.getParent()).thenReturn(new Bold(new BulletList(parent32)));
    Element parent34 = mock(Element.class);
    when(parent34.getParent()).thenReturn(new Bold(new BulletList(parent33)));
    Element parent35 = mock(Element.class);
    when(parent35.getParent()).thenReturn(new Bold(new BulletList(parent34)));
    Element parent36 = mock(Element.class);
    when(parent36.getParent()).thenReturn(new Bold(new BulletList(parent35)));
    Element parent37 = mock(Element.class);
    when(parent37.getParent()).thenReturn(new Bold(new BulletList(parent36)));
    Element parent38 = mock(Element.class);
    when(parent38.getParent()).thenReturn(new Bold(new BulletList(parent37)));
    Element parent39 = mock(Element.class);
    when(parent39.getParent()).thenReturn(new Bold(new BulletList(parent38)));
    Element parent40 = mock(Element.class);
    when(parent40.getParent()).thenReturn(new Bold(new BulletList(parent39)));
    Element parent41 = mock(Element.class);
    when(parent41.getParent()).thenReturn(new Bold(new BulletList(parent40)));
    Element parent42 = mock(Element.class);
    when(parent42.getParent()).thenReturn(new Bold(new BulletList(parent41)));
    Element parent43 = mock(Element.class);
    when(parent43.getParent()).thenReturn(new Bold(new BulletList(parent42)));
    Element parent44 = mock(Element.class);
    when(parent44.getParent()).thenReturn(new Bold(new BulletList(parent43)));
    Element parent45 = mock(Element.class);
    when(parent45.getParent()).thenReturn(new Bold(new BulletList(parent44)));
    Element parent46 = mock(Element.class);
    when(parent46.getParent()).thenReturn(new Bold(new BulletList(parent45)));
    Element parent47 = mock(Element.class);
    when(parent47.getParent()).thenReturn(new Bold(new BulletList(parent46)));
    Element parent48 = mock(Element.class);
    when(parent48.getParent()).thenReturn(new Bold(new BulletList(parent47)));
    Element parent49 = mock(Element.class);
    when(parent49.getParent()).thenReturn(new Bold(new BulletList(parent48)));
    Element parent50 = mock(Element.class);
    when(parent50.getParent()).thenReturn(new Bold(new BulletList(parent49)));
    Element parent51 = mock(Element.class);
    when(parent51.getParent()).thenReturn(new Bold(new BulletList(parent50)));
    Element parent52 = mock(Element.class);
    when(parent52.getParent()).thenReturn(new Bold(new BulletList(parent51)));
    Element parent53 = mock(Element.class);
    when(parent53.getParent()).thenReturn(new Bold(new BulletList(parent52)));
    Element parent54 = mock(Element.class);
    when(parent54.getParent()).thenReturn(new Bold(new BulletList(parent53)));
    Element parent55 = mock(Element.class);
    when(parent55.getParent()).thenReturn(new Bold(new BulletList(parent54)));
    Element parent56 = mock(Element.class);
    when(parent56.getParent()).thenReturn(new Bold(new BulletList(parent55)));
    Element parent57 = mock(Element.class);
    when(parent57.getParent()).thenReturn(new Bold(new BulletList(parent56)));
    Element parent58 = mock(Element.class);
    when(parent58.getParent()).thenReturn(new Bold(new BulletList(parent57)));
    Element parent59 = mock(Element.class);
    when(parent59.getParent()).thenReturn(new Bold(new BulletList(parent58)));
    Element parent60 = mock(Element.class);
    when(parent60.getParent()).thenReturn(new Bold(new BulletList(parent59)));
    Element parent61 = mock(Element.class);
    when(parent61.getParent()).thenReturn(new Bold(new BulletList(parent60)));
    Element parent62 = mock(Element.class);
    when(parent62.getParent()).thenReturn(new Bold(new BulletList(parent61)));
    Element parent63 = mock(Element.class);
    when(parent63.getParent()).thenReturn(new Bold(new BulletList(parent62)));
    Element parent64 = mock(Element.class);
    when(parent64.getParent()).thenReturn(new Bold(new BulletList(parent63)));
    Element parent65 = mock(Element.class);
    when(parent65.getParent()).thenReturn(new Bold(new BulletList(parent64)));
    Element parent66 = mock(Element.class);
    when(parent66.getParent()).thenReturn(new Bold(new BulletList(parent65)));
    Element parent67 = mock(Element.class);
    when(parent67.getParent()).thenReturn(new Bold(new BulletList(parent66)));
    Element parent68 = mock(Element.class);
    when(parent68.getParent()).thenReturn(new Bold(new BulletList(parent67)));
    Element parent69 = mock(Element.class);
    when(parent69.getParent()).thenReturn(new Bold(new BulletList(parent68)));
    Element parent70 = mock(Element.class);
    when(parent70.getParent()).thenReturn(new Bold(new BulletList(parent69)));
    Element parent71 = mock(Element.class);
    when(parent71.getParent()).thenReturn(new Bold(new BulletList(parent70)));
    Element parent72 = mock(Element.class);
    when(parent72.getParent()).thenReturn(new Bold(new BulletList(parent71)));
    Element parent73 = mock(Element.class);
    when(parent73.getParent()).thenReturn(new Bold(new BulletList(parent72)));
    Element parent74 = mock(Element.class);
    when(parent74.getParent()).thenReturn(new Bold(new BulletList(parent73)));
    Element parent75 = mock(Element.class);
    when(parent75.getParent()).thenReturn(new Bold(new BulletList(parent74)));
    Element parent76 = mock(Element.class);
    when(parent76.getParent()).thenReturn(new Bold(new BulletList(parent75)));
    Element parent77 = mock(Element.class);
    when(parent77.getParent()).thenReturn(new Bold(new BulletList(parent76)));
    Element parent78 = mock(Element.class);
    when(parent78.getParent()).thenReturn(new Bold(new BulletList(parent77)));
    Element parent79 = mock(Element.class);
    when(parent79.getParent()).thenReturn(new Bold(new BulletList(parent78)));
    Element parent80 = mock(Element.class);
    when(parent80.getParent()).thenReturn(new Bold(new BulletList(parent79)));
    Element parent81 = mock(Element.class);
    when(parent81.getParent()).thenReturn(new Bold(new BulletList(parent80)));
    Element parent82 = mock(Element.class);
    when(parent82.getParent()).thenReturn(new Bold(new BulletList(parent81)));
    Element parent83 = mock(Element.class);
    when(parent83.getParent()).thenReturn(new Bold(new BulletList(parent82)));
    Element parent84 = mock(Element.class);
    when(parent84.getParent()).thenReturn(new Bold(new BulletList(parent83)));
    Element parent85 = mock(Element.class);
    when(parent85.getParent()).thenReturn(new Bold(new BulletList(parent84)));
    Element parent86 = mock(Element.class);
    when(parent86.getParent()).thenReturn(new Bold(new BulletList(parent85)));
    Element parent87 = mock(Element.class);
    when(parent87.getParent()).thenReturn(new Bold(new BulletList(parent86)));
    Element parent88 = mock(Element.class);
    when(parent88.getParent()).thenReturn(new Bold(new BulletList(parent87)));
    Element parent89 = mock(Element.class);
    when(parent89.getParent()).thenReturn(new Bold(new BulletList(parent88)));
    Element parent90 = mock(Element.class);
    when(parent90.getParent()).thenReturn(new Bold(new BulletList(parent89)));
    Element parent91 = mock(Element.class);
    when(parent91.getParent()).thenReturn(new Bold(new BulletList(parent90)));
    Element parent92 = mock(Element.class);
    when(parent92.getParent()).thenReturn(new Bold(new BulletList(parent91)));
    Element parent93 = mock(Element.class);
    when(parent93.getParent()).thenReturn(new Bold(new BulletList(parent92)));
    Element parent94 = mock(Element.class);
    when(parent94.getParent()).thenReturn(new Bold(new BulletList(parent93)));
    Element parent95 = mock(Element.class);
    when(parent95.getParent()).thenReturn(new Bold(new BulletList(parent94)));
    Element parent96 = mock(Element.class);
    when(parent96.getParent()).thenReturn(new Bold(new BulletList(parent95)));
    Element parent97 = mock(Element.class);
    when(parent97.getParent()).thenReturn(new Bold(new BulletList(parent96)));
    Element parent98 = mock(Element.class);
    when(parent98.getParent()).thenReturn(new Bold(new BulletList(parent97)));
    Element parent99 = mock(Element.class);
    when(parent99.getParent()).thenReturn(new Bold(new BulletList(parent98)));

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> (new TimePicker(new Bold(new BulletList(parent99)), FormatEnum.MESSAGEML)).validate());
    verify(parent).getParent();
    verify(parent99, atLeast(1)).getParent();
    verify(parent98, atLeast(1)).getParent();
    verify(parent97, atLeast(1)).getParent();
    verify(parent96, atLeast(1)).getParent();
    verify(parent95, atLeast(1)).getParent();
    verify(parent94, atLeast(1)).getParent();
    verify(parent93, atLeast(1)).getParent();
    verify(parent92, atLeast(1)).getParent();
    verify(parent91, atLeast(1)).getParent();
    verify(parent90, atLeast(1)).getParent();
    verify(parent89, atLeast(1)).getParent();
    verify(parent88, atLeast(1)).getParent();
    verify(parent87, atLeast(1)).getParent();
    verify(parent86, atLeast(1)).getParent();
    verify(parent85, atLeast(1)).getParent();
    verify(parent84, atLeast(1)).getParent();
    verify(parent83, atLeast(1)).getParent();
    verify(parent82, atLeast(1)).getParent();
    verify(parent81, atLeast(1)).getParent();
    verify(parent80, atLeast(1)).getParent();
    verify(parent79, atLeast(1)).getParent();
    verify(parent78, atLeast(1)).getParent();
    verify(parent77, atLeast(1)).getParent();
    verify(parent76, atLeast(1)).getParent();
    verify(parent75, atLeast(1)).getParent();
    verify(parent74, atLeast(1)).getParent();
    verify(parent73, atLeast(1)).getParent();
    verify(parent72, atLeast(1)).getParent();
    verify(parent71, atLeast(1)).getParent();
    verify(parent70, atLeast(1)).getParent();
    verify(parent69, atLeast(1)).getParent();
    verify(parent68, atLeast(1)).getParent();
    verify(parent67, atLeast(1)).getParent();
    verify(parent66, atLeast(1)).getParent();
    verify(parent65, atLeast(1)).getParent();
    verify(parent64, atLeast(1)).getParent();
    verify(parent63, atLeast(1)).getParent();
    verify(parent62, atLeast(1)).getParent();
    verify(parent61, atLeast(1)).getParent();
    verify(parent60, atLeast(1)).getParent();
    verify(parent59, atLeast(1)).getParent();
    verify(parent58, atLeast(1)).getParent();
    verify(parent57, atLeast(1)).getParent();
    verify(parent56, atLeast(1)).getParent();
    verify(parent55, atLeast(1)).getParent();
    verify(parent54, atLeast(1)).getParent();
    verify(parent53, atLeast(1)).getParent();
    verify(parent52, atLeast(1)).getParent();
    verify(parent51, atLeast(1)).getParent();
    verify(parent50, atLeast(1)).getParent();
    verify(parent49, atLeast(1)).getParent();
    verify(parent48, atLeast(1)).getParent();
    verify(parent47, atLeast(1)).getParent();
    verify(parent46, atLeast(1)).getParent();
    verify(parent45, atLeast(1)).getParent();
    verify(parent44, atLeast(1)).getParent();
    verify(parent43, atLeast(1)).getParent();
    verify(parent42, atLeast(1)).getParent();
    verify(parent41, atLeast(1)).getParent();
    verify(parent40, atLeast(1)).getParent();
    verify(parent39, atLeast(1)).getParent();
    verify(parent38, atLeast(1)).getParent();
    verify(parent37, atLeast(1)).getParent();
    verify(parent36, atLeast(1)).getParent();
    verify(parent35, atLeast(1)).getParent();
    verify(parent34, atLeast(1)).getParent();
    verify(parent33, atLeast(1)).getParent();
    verify(parent32, atLeast(1)).getParent();
    verify(parent31, atLeast(1)).getParent();
    verify(parent30, atLeast(1)).getParent();
    verify(parent29, atLeast(1)).getParent();
    verify(parent28, atLeast(1)).getParent();
    verify(parent27, atLeast(1)).getParent();
    verify(parent26, atLeast(1)).getParent();
    verify(parent25, atLeast(1)).getParent();
    verify(parent24, atLeast(1)).getParent();
    verify(parent23, atLeast(1)).getParent();
    verify(parent22, atLeast(1)).getParent();
    verify(parent21, atLeast(1)).getParent();
    verify(parent20, atLeast(1)).getParent();
    verify(parent19, atLeast(1)).getParent();
    verify(parent18, atLeast(1)).getParent();
    verify(parent17, atLeast(1)).getParent();
    verify(parent16, atLeast(1)).getParent();
    verify(parent15, atLeast(1)).getParent();
    verify(parent14, atLeast(1)).getParent();
    verify(parent13, atLeast(1)).getParent();
    verify(parent12, atLeast(1)).getParent();
    verify(parent11, atLeast(1)).getParent();
    verify(parent10, atLeast(1)).getParent();
    verify(parent9, atLeast(1)).getParent();
    verify(parent8, atLeast(1)).getParent();
    verify(parent7, atLeast(1)).getParent();
    verify(parent6, atLeast(1)).getParent();
    verify(parent5, atLeast(1)).getParent();
    verify(parent4, atLeast(1)).getParent();
    verify(parent3, atLeast(1)).getParent();
    verify(parent2, atLeast(1)).getParent();
  }

  /**
   * Test {@link TimePicker#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link TimePicker#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TimePicker.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() {
    // Arrange
    TimePicker timePicker = new TimePicker(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    timePicker.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(27L, out.getOffset());
  }

  /**
   * Test {@link TimePicker#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link TimePicker#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TimePicker.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() {
    // Arrange
    TimePicker timePicker = new TimePicker(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    timePicker.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(27L, out.getOffset());
  }

  /**
   * Test {@link TimePicker#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link TimePicker#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TimePicker.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() {
    // Arrange
    TimePicker timePicker = new TimePicker(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    timePicker.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(25L, out.getOffset());
  }

  /**
   * Test {@link TimePicker#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <ul>
   *   <li>When {@link XmlPrintStream#XmlPrintStream(OutputStream)} with outputStream is {@link ByteArrayOutputStream#ByteArrayOutputStream(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimePicker#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TimePicker.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML_whenXmlPrintStreamWithOutputStreamIsByteArrayOutputStream() {
    // Arrange
    TimePicker timePicker = new TimePicker(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    timePicker.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(27L, out.getOffset());
  }

  /**
   * Test {@link TimePicker#asMarkdown()}.
   * <p>
   * Method under test: {@link TimePicker#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node TimePicker.asMarkdown()"})
  public void testAsMarkdown() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new TimePicker(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML))
        .asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof TimePickerNode);
    assertEquals("", ((TimePickerNode) actualAsMarkdownResult).getText());
    assertEquals("(Time Picker", ((TimePickerNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertEquals(")", ((TimePickerNode) actualAsMarkdownResult).getClosingDelimiter());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link TimePicker#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimePicker#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TimePicker.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsSizeIsOne() {
    // Arrange
    TimePicker timePicker = new TimePicker(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    timePicker.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("timepicker", getResult.getName());
    assertTrue(getResult.getAttributes().isEmpty());
  }
}
