package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class CodeDiffblueTest {
  /**
   * Test {@link Code#Code(Element)}.
   * <p>
   * Method under test: {@link Code#Code(Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Code.<init>(Element)"})
  public void testNewCode() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Code actualCode = new Code(parent);

    // Assert
    assertEquals(0, actualCode.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualCode.getFormat());
    assertTrue(actualCode.getChildren().isEmpty());
    assertTrue(actualCode.getAttributes().isEmpty());
    assertEquals(Code.MESSAGEML_TAG, actualCode.getPresentationMLTag());
    assertEquals(Code.MESSAGEML_TAG, actualCode.getMessageMLTag());
    assertSame(parent, actualCode.getParent());
  }

  /**
   * Test {@link Code#Code(Element, String)}.
   * <p>
   * Method under test: {@link Code#Code(Element, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Code.<init>(Element, String)"})
  public void testNewCode2() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    Code actualCode = new Code(parent, "en");

    // Assert
    Map<String, String> attributes = actualCode.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("en", attributes.get("data-language"));
    assertEquals(0, actualCode.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualCode.getFormat());
    assertTrue(actualCode.getChildren().isEmpty());
    assertEquals(Code.MESSAGEML_TAG, actualCode.getPresentationMLTag());
    assertEquals(Code.MESSAGEML_TAG, actualCode.getMessageMLTag());
    assertSame(parent, actualCode.getParent());
  }

  /**
   * Test {@link Code#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Code#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Code.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() {
    // Arrange
    Code code = new Code(new Bold(new BulletList(mock(Element.class))), "en");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    code.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(34L, out.getOffset());
  }

  /**
   * Test {@link Code#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Code#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Code.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() {
    // Arrange
    Code code = new Code(new Bold(new BulletList(mock(Element.class))), "=\"");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    code.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(39L, out.getOffset());
  }

  /**
   * Test {@link Code#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Code#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Code.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() {
    // Arrange
    Code code = new Code(new Bold(new BulletList(mock(Element.class))), null);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    code.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(15L, out.getOffset());
  }

  /**
   * Test {@link Code#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Code#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Code.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML4() {
    // Arrange
    Code code = new Code(new Bold(new BulletList(mock(Element.class))), "en");
    code.addChild(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    code.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(45L, out.getOffset());
  }

  /**
   * Test {@link Code#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <ul>
   *   <li>Given {@link Code#Code(Element, String)} with parent is {@link Bold#Bold(Element)} and language is {@code >}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Code#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Code.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML_givenCodeWithParentIsBoldAndLanguageIsGreaterThanSign() {
    // Arrange
    Code code = new Code(new Bold(new BulletList(mock(Element.class))), ">");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    code.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(36L, out.getOffset());
  }

  /**
   * Test {@link Code#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <ul>
   *   <li>Given {@link Code#Code(Element, String)} with parent is {@link Bold#Bold(Element)} and language is {@code <}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Code#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Code.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML_givenCodeWithParentIsBoldAndLanguageIsLessThanSign() {
    // Arrange
    Code code = new Code(new Bold(new BulletList(mock(Element.class))), "<");
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    code.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(36L, out.getOffset());
  }

  /**
   * Test {@link Code#asMarkdown()}.
   * <ul>
   *   <li>Given {@link Code#Code(Element, String)} with parent is {@link Bold#Bold(Element)} and language is {@code en}.</li>
   *   <li>Then return Info is {@code en}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Code#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Code.asMarkdown()"})
  public void testAsMarkdown_givenCodeWithParentIsBoldAndLanguageIsEn_thenReturnInfoIsEn() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Code(new Bold(new BulletList(mock(Element.class))), "en")).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof FencedCodeBlock);
    assertEquals("en", ((FencedCodeBlock) actualAsMarkdownResult).getInfo());
    assertNull(((FencedCodeBlock) actualAsMarkdownResult).getLiteral());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertEquals(0, ((FencedCodeBlock) actualAsMarkdownResult).getFenceIndent());
    assertEquals(3, ((FencedCodeBlock) actualAsMarkdownResult).getFenceLength());
    assertEquals(Code.MARKDOWN_DELIMITER_CHAR, ((FencedCodeBlock) actualAsMarkdownResult).getFenceChar());
  }

  /**
   * Test {@link Code#asMarkdown()}.
   * <ul>
   *   <li>Given {@link Code#Code(Element, String)} with parent is {@link Bold#Bold(Element)} and language is {@code null}.</li>
   *   <li>Then return Info is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Code#asMarkdown()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Code.asMarkdown()"})
  public void testAsMarkdown_givenCodeWithParentIsBoldAndLanguageIsNull_thenReturnInfoIsNull() {
    // Arrange and Act
    Node actualAsMarkdownResult = (new Code(new Bold(new BulletList(mock(Element.class))), null)).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof FencedCodeBlock);
    assertNull(((FencedCodeBlock) actualAsMarkdownResult).getInfo());
    assertNull(((FencedCodeBlock) actualAsMarkdownResult).getLiteral());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getPrevious());
    assertEquals(0, ((FencedCodeBlock) actualAsMarkdownResult).getFenceIndent());
    assertEquals(3, ((FencedCodeBlock) actualAsMarkdownResult).getFenceLength());
    assertEquals(Code.MARKDOWN_DELIMITER_CHAR, ((FencedCodeBlock) actualAsMarkdownResult).getFenceChar());
  }

  /**
   * Test {@link Code#getPresentationMLTag()}.
   * <p>
   * Method under test: {@link Code#getPresentationMLTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Code.getPresentationMLTag()"})
  public void testGetPresentationMLTag() {
    // Arrange, Act and Assert
    assertEquals(Code.MESSAGEML_TAG,
        (new Code(new Bold(new BulletList(mock(Element.class))), "en")).getPresentationMLTag());
  }

  /**
   * Test {@link Code#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes {@code count} {@link BiItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Code#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Code.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountBiItem() {
    // Arrange
    Code code = new Code(new Bold(new BulletList(mock(Element.class))), "en");

    BiContext context = new BiContext();
    BiItem biItem = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItemWithValue("codes", biItem);
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    code.updateBiContext(context);

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
   * Test {@link Code#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes {@code count} is {@code Item Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Code#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Code.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesCountIsItemValue() {
    // Arrange
    Code code = new Code(new Bold(new BulletList(mock(Element.class))), "en");

    BiContext context = new BiContext();
    context.addItemWithValue("codes", "Item Value");
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    code.updateBiContext(context);

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
   * Test {@link Code#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Code#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Code.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    Code code = new Code(new Bold(new BulletList(mock(Element.class))), "en");

    BiContext context = new BiContext();
    context.addItem(new BiItem("codes", Element.STYLE_ATTR));

    // Act
    code.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    Map<String, Object> attributes = items.get(0).getAttributes();
    assertEquals(2, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
    assertTrue(attributes.containsKey(Element.STYLE_ATTR));
  }

  /**
   * Test {@link Code#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Code#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Code.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsTwo() {
    // Arrange
    Code code = new Code(new Bold(new BulletList(mock(Element.class))), "en");

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    code.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("codes", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Code#updateBiContext(BiContext)}.
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is {@code codes}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Code#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Code.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsCodes() {
    // Arrange
    Code code = new Code(new Bold(new BulletList(mock(Element.class))), "en");

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    code.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("codes", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Code#updateBiContext(BiContext)}.
   * <ul>
   *   <li>When {@link BiContext} (default constructor).</li>
   *   <li>Then {@link BiContext} (default constructor) Items first Name is {@code codes}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Code#updateBiContext(BiContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Code.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsCodes() {
    // Arrange
    Code code = new Code(new Bold(new BulletList(mock(Element.class))), "en");
    BiContext context = new BiContext();

    // Act
    code.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("codes", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }
}
