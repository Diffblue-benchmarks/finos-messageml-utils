package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.exceptions.ProcessingException;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class GroupedElementDiffblueTest {
  /**
   * Test {@link GroupedElement#buildAll(MessageMLParser, Element)}.
   *
   * <p>Method under test: {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupedElement.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll() throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Checkbox checkbox = new Checkbox(parent2, FormatEnum.MESSAGEML);

    MessageMLParser parser = mock(MessageMLParser.class);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold bold = new Bold(parent3);
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any()))
        .thenReturn(bold);
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode();
    element.appendChild(new IIOMetadataNode());

    // Act
    checkbox.buildAll(parser, element);

    // Assert
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
    verify(parser, atLeast(1)).getBiContext();
    List<Element> children = checkbox.getChildren();
    assertEquals(1, children.size());
    assertEquals(1, checkbox.size());
    assertSame(bold, children.get(0));
  }

  /**
   * Test {@link GroupedElement#buildAll(MessageMLParser, Element)}.
   *
   * <ul>
   *   <li>Given {@link Checkbox#Checkbox(Element, FormatEnum)} with parent is {@link
   *       Bold#Bold(Element)} and messageFormat is {@code PRESENTATIONML}.
   * </ul>
   *
   * <p>Method under test: {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupedElement.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll_givenCheckboxWithParentIsBoldAndMessageFormatIsPresentationml()
      throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Checkbox checkbox = new Checkbox(parent2, FormatEnum.PRESENTATIONML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class, () -> checkbox.buildAll(parser, new IIOMetadataNode()));
  }

  /**
   * Test {@link GroupedElement#buildAll(MessageMLParser, Element)}.
   *
   * <ul>
   *   <li>Given {@link Checkbox#Checkbox(Element, FormatEnum)} with parent is {@link
   *       Bold#Bold(Element)} and messageFormat is {@code PRESENTATIONML}.
   * </ul>
   *
   * <p>Method under test: {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupedElement.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll_givenCheckboxWithParentIsBoldAndMessageFormatIsPresentationml2()
      throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Checkbox checkbox = new Checkbox(parent2, FormatEnum.PRESENTATIONML);
    MessageMLParser parser = mock(MessageMLParser.class);

    IIOMetadataNode element = new IIOMetadataNode();
    element.appendChild(new IIOMetadataNode());

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> checkbox.buildAll(parser, element));
  }

  /**
   * Test {@link GroupedElement#buildAll(MessageMLParser, Element)}.
   *
   * <ul>
   *   <li>Given {@link Code#Code(Element, String)} with parent is {@link Element} and language is
   *       {@code en}.
   *   <li>Then calls {@link MessageMLParser#clearBiContext()}.
   * </ul>
   *
   * <p>Method under test: {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupedElement.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll_givenCodeWithParentIsElementAndLanguageIsEn_thenCallsClearBiContext()
      throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Checkbox checkbox = new Checkbox(parent2, FormatEnum.MESSAGEML);

    MessageMLParser parser = mock(MessageMLParser.class);
    doNothing().when(parser).clearBiContext();
    Code parent3 = new Code(mock(Element.class), "en");
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any()))
        .thenReturn(new BulletList(new Bold(parent3)));
    when(parser.getBiContext()).thenReturn(new BiContext());

    IIOMetadataNode element = new IIOMetadataNode();
    element.appendChild(new IIOMetadataNode());

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> checkbox.buildAll(parser, element));
    verify(parser).clearBiContext();
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
    verify(parser).getBiContext();
  }

  /**
   * Test {@link GroupedElement#buildAll(MessageMLParser, Element)}.
   *
   * <ul>
   *   <li>Given {@link InvalidInputException#InvalidInputException(String)} with message is {@code
   *       An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupedElement.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll_givenInvalidInputExceptionWithMessageIsAnErrorOccurred()
      throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Checkbox checkbox = new Checkbox(parent2, FormatEnum.MESSAGEML);

    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.createElement(Mockito.<org.w3c.dom.Element>any(), Mockito.<Element>any()))
        .thenThrow(new InvalidInputException("An error occurred"));

    IIOMetadataNode element = new IIOMetadataNode();
    element.appendChild(new IIOMetadataNode());

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> checkbox.buildAll(parser, element));
    verify(parser).createElement(isA(org.w3c.dom.Element.class), isA(Element.class));
  }

  /**
   * Test {@link GroupedElement#buildAll(MessageMLParser, Element)}.
   *
   * <ul>
   *   <li>Then {@link Checkbox#Checkbox(Element, FormatEnum)} with parent is {@link
   *       Bold#Bold(Element)} and messageFormat is {@code MESSAGEML} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupedElement.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll_thenCheckboxWithParentIsBoldAndMessageFormatIsMessagemlSizeIsZero()
      throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Checkbox checkbox = new Checkbox(parent2, FormatEnum.MESSAGEML);

    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(new BiContext());

    // Act
    checkbox.buildAll(parser, new IIOMetadataNode());

    // Assert that nothing has changed
    verify(parser).getBiContext();
    assertEquals(0, checkbox.size());
    assertTrue(checkbox.getChildren().isEmpty());
  }

  /**
   * Test {@link GroupedElement#buildAll(MessageMLParser, Element)}.
   *
   * <ul>
   *   <li>Then {@link Checkbox#Checkbox(Element, FormatEnum)} with parent is {@link
   *       Bold#Bold(Element)} and messageFormat is {@code MESSAGEML} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupedElement.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll_thenCheckboxWithParentIsBoldAndMessageFormatIsMessagemlSizeIsZero2()
      throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Checkbox checkbox = new Checkbox(parent2, FormatEnum.MESSAGEML);

    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem(MessageML.MESSAGEML_TAG, MessageML.MESSAGEML_TAG));

    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(biContext);

    // Act
    checkbox.buildAll(parser, new IIOMetadataNode());

    // Assert that nothing has changed
    verify(parser).getBiContext();
    assertEquals(0, checkbox.size());
    assertTrue(checkbox.getChildren().isEmpty());
  }

  /**
   * Test {@link GroupedElement#buildAll(MessageMLParser, Element)}.
   *
   * <ul>
   *   <li>Then {@link Checkbox#Checkbox(Element, FormatEnum)} with parent is {@link
   *       Bold#Bold(Element)} and messageFormat is {@code MESSAGEML} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link GroupedElement#buildAll(MessageMLParser, org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupedElement.buildAll(MessageMLParser, org.w3c.dom.Element)"})
  public void testBuildAll_thenCheckboxWithParentIsBoldAndMessageFormatIsMessagemlSizeIsZero3()
      throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Checkbox checkbox = new Checkbox(parent2, FormatEnum.MESSAGEML);

    BiContext biContext = new BiContext();
    biContext.addItem(new BiItem(MessageML.MESSAGEML_TAG, MessageML.MESSAGEML_TAG));
    biContext.addItem(new BiItem(MessageML.MESSAGEML_TAG, MessageML.MESSAGEML_TAG));

    MessageMLParser parser = mock(MessageMLParser.class);
    when(parser.getBiContext()).thenReturn(biContext);

    // Act
    checkbox.buildAll(parser, new IIOMetadataNode());

    // Assert that nothing has changed
    verify(parser).getBiContext();
    assertEquals(0, checkbox.size());
    assertTrue(checkbox.getChildren().isEmpty());
  }

  /**
   * Test {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupedElement.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Checkbox checkbox = new Checkbox(parent2, FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    checkbox.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(42L, out.getOffset());
  }

  /**
   * Test {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupedElement.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Checkbox checkbox = new Checkbox(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setPrintOffsets(true);

    // Act
    checkbox.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(42L, out.getOffset());
  }

  /**
   * Test {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupedElement.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Checkbox checkbox = new Checkbox(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoIndent(true);

    // Act
    checkbox.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(42L, out.getOffset());
  }

  /**
   * Test {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link GroupedElement#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupedElement.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML4() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Checkbox checkbox = new Checkbox(parent2, FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    checkbox.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(40L, out.getOffset());
  }

  /**
   * Test {@link GroupedElement#buildElementFromGroupDiv(MessageMLParser, Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupedElement#buildElementFromGroupDiv(MessageMLParser,
   * org.w3c.dom.Element)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GroupedElement.buildElementFromGroupDiv(MessageMLParser, org.w3c.dom.Element)"
  })
  public void testBuildElementFromGroupDiv_whenIIOMetadataNode_thenThrowInvalidInputException()
      throws InvalidInputException, ProcessingException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Checkbox checkbox = new Checkbox(parent2, FormatEnum.MESSAGEML);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> checkbox.buildElementFromGroupDiv(parser, new IIOMetadataNode()));
  }

  /**
   * Test {@link GroupedElement#buildGroupedElementInputAttributes(String)}.
   *
   * <p>Method under test: {@link GroupedElement#buildGroupedElementInputAttributes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map GroupedElement.buildGroupedElementInputAttributes(String)"})
  public void testBuildGroupedElementInputAttributes() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Map<String, String> actualBuildGroupedElementInputAttributesResult =
        new Checkbox(parent2, FormatEnum.MESSAGEML).buildGroupedElementInputAttributes("42");

    // Assert
    assertEquals(3, actualBuildGroupedElementInputAttributesResult.size());
    assertEquals("on", actualBuildGroupedElementInputAttributesResult.get(Entity.VALUE_FIELD));
    assertNull(actualBuildGroupedElementInputAttributesResult.get("name"));
    assertEquals(
        Checkbox.MESSAGEML_TAG,
        actualBuildGroupedElementInputAttributesResult.get(Entity.TYPE_FIELD));
  }
}
