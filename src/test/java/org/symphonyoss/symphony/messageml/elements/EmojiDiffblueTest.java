package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import javax.imageio.metadata.IIOMetadataNode;
import org.commonmark.node.Node;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.markdown.nodes.EmojiNode;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class EmojiDiffblueTest {
  /**
   * Test {@link Emoji#Emoji(Element, int)}.
   *
   * <p>Method under test: {@link Emoji#Emoji(Element, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.<init>(Element, int)"})
  public void testNewEmoji() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Emoji actualEmoji = new Emoji(parent2, 1);

    // Assert
    Element parent3 = actualEmoji.getParent();
    assertTrue(parent3 instanceof Bold);
    assertEquals("1.0", actualEmoji.getEntityVersion());
    assertEquals("com.symphony.emoji", actualEmoji.getEntityType());
    assertEquals("emoji1", actualEmoji.entityId);
    assertEquals("normal", actualEmoji.getSize());
    assertNull(actualEmoji.getAnnotation());
    assertNull(actualEmoji.getEntitySubType());
    assertNull(actualEmoji.getEntityValue());
    assertNull(actualEmoji.getFamily());
    assertNull(actualEmoji.getShortCode());
    assertEquals(0, actualEmoji.size());
    assertEquals(FormatEnum.MESSAGEML, actualEmoji.getFormat());
    assertTrue(actualEmoji.getChildren().isEmpty());
    assertTrue(actualEmoji.getAttributes().isEmpty());
    assertEquals(Emoji.MESSAGEML_TAG, actualEmoji.getMessageMLTag());
    assertEquals(Emoji.MESSAGEML_TAG, actualEmoji.getEntityIdPrefix());
    assertEquals(Span.MESSAGEML_TAG, actualEmoji.getPresentationMLTag());
    assertSame(parent2, parent3);
  }

  /**
   * Test {@link Emoji#Emoji(Element, String, int)}.
   *
   * <p>Method under test: {@link Emoji#Emoji(Element, String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.<init>(Element, String, int)"})
  public void testNewEmoji2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Emoji actualEmoji = new Emoji(parent2, "Shortcode", 1);

    // Assert
    Element parent3 = actualEmoji.getParent();
    assertTrue(parent3 instanceof Bold);
    assertEquals("1.0", actualEmoji.getEntityVersion());
    assertEquals("Shortcode", actualEmoji.getAnnotation());
    assertEquals("Shortcode", actualEmoji.getEntityValue());
    assertEquals("Shortcode", actualEmoji.getShortCode());
    assertEquals("com.symphony.emoji", actualEmoji.getEntityType());
    assertEquals("emoji1", actualEmoji.entityId);
    assertEquals("normal", actualEmoji.getSize());
    assertNull(actualEmoji.getEntitySubType());
    assertNull(actualEmoji.getFamily());
    assertEquals(0, actualEmoji.size());
    assertEquals(FormatEnum.MESSAGEML, actualEmoji.getFormat());
    assertTrue(actualEmoji.getChildren().isEmpty());
    assertTrue(actualEmoji.getAttributes().isEmpty());
    assertEquals(Emoji.MESSAGEML_TAG, actualEmoji.getMessageMLTag());
    assertEquals(Emoji.MESSAGEML_TAG, actualEmoji.getEntityIdPrefix());
    assertEquals(Span.MESSAGEML_TAG, actualEmoji.getPresentationMLTag());
    assertSame(parent2, parent3);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Emoji#toString()}
   *   <li>{@link Emoji#getAnnotation()}
   *   <li>{@link Emoji#getEntityIdPrefix()}
   *   <li>{@link Emoji#getEntitySubType()}
   *   <li>{@link Emoji#getEntityType()}
   *   <li>{@link Emoji#getEntityValue()}
   *   <li>{@link Emoji#getEntityVersion()}
   *   <li>{@link Emoji#getFamily()}
   *   <li>{@link Emoji#getShortCode()}
   *   <li>{@link Emoji#getSize()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String Emoji.getAnnotation()",
    "String Emoji.getEntityIdPrefix()",
    "String Emoji.getEntitySubType()",
    "String Emoji.getEntityType()",
    "String Emoji.getEntityValue()",
    "String Emoji.getEntityVersion()",
    "String Emoji.getFamily()",
    "String Emoji.getShortCode()",
    "String Emoji.getSize()",
    "String Emoji.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    Emoji emoji = new Emoji(parent, 1);

    // Act
    String actualToStringResult = emoji.toString();
    String actualAnnotation = emoji.getAnnotation();
    String actualEntityIdPrefix = emoji.getEntityIdPrefix();
    String actualEntitySubType = emoji.getEntitySubType();
    String actualEntityType = emoji.getEntityType();
    String actualEntityValue = emoji.getEntityValue();
    String actualEntityVersion = emoji.getEntityVersion();
    String actualFamily = emoji.getFamily();
    String actualShortCode = emoji.getShortCode();

    // Assert
    assertEquals("1.0", actualEntityVersion);
    assertEquals("Emoji(null)", actualToStringResult);
    assertEquals("com.symphony.emoji", actualEntityType);
    assertEquals("normal", emoji.getSize());
    assertNull(actualAnnotation);
    assertNull(actualEntitySubType);
    assertNull(actualEntityValue);
    assertNull(actualFamily);
    assertNull(actualShortCode);
    assertEquals(Emoji.MESSAGEML_TAG, actualEntityIdPrefix);
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Emoji emoji = new Emoji(parent2, 1);
    BulletList parent3 = new BulletList(mock(Element.class));
    emoji.addChild(new Bold(parent3));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(false);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(67L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Emoji emoji = new Emoji(parent2, 1);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setPrintOffsets(true);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(63L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Emoji emoji = new Emoji(parent2, 1);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoIndent(true);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(61L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML4() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Emoji emoji = new Emoji(parent2, 1);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(60L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML5() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Emoji emoji = new Emoji(parent2, 1);
    BulletList parent3 = new BulletList(mock(Element.class));
    emoji.addChild(new Bold(parent3));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(61L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML6() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Emoji emoji = new Emoji(parent2, 1);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    emoji.addChild(new Checkbox(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(95L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML7() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Emoji emoji = new Emoji(parent2, 1);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    emoji.addChild(new CardBody(parent4, FormatEnum.MESSAGEML));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(82L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML8() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent2));
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);

    Emoji emoji = new Emoji(parent4, 1);
    emoji.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(68L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML9() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Emoji emoji = new Emoji(parent2, 1);
    BulletList parent3 = new BulletList(mock(Element.class));
    Bold parent4 = new Bold(parent3);
    emoji.addChild(new CashTag(parent4, 1));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(115L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML10() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new Checkbox(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Emoji emoji = new Emoji(parent5, 1);
    emoji.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(104L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML11() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new Button(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Emoji emoji = new Emoji(parent5, 1);
    emoji.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(92L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML12() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CardBody(parent3, FormatEnum.MESSAGEML));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Emoji emoji = new Emoji(parent5, 1);
    emoji.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(89L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML13() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));

    Bold child = new Bold(parent);
    BulletList parent2 = new BulletList(mock(Element.class));
    Bold parent3 = new Bold(parent2);
    child.addChild(new CashTag(parent3, 1));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Emoji emoji = new Emoji(parent5, 1);
    emoji.addChild(child);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(124L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <ul>
   *   <li>When {@link XmlPrintStream#XmlPrintStream(OutputStream)} with outputStream is {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link Emoji#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML_whenXmlPrintStreamWithOutputStreamIsByteArrayOutputStream() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Emoji emoji = new Emoji(parent2, 1);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    emoji.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(63L, out.getOffset());
  }

  /**
   * Test {@link Emoji#asMarkdown()}.
   *
   * <p>Method under test: {@link Emoji#asMarkdown()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Emoji.asMarkdown()"})
  public void testAsMarkdown() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act
    Node actualAsMarkdownResult = new Emoji(parent2, 1).asMarkdown();

    // Assert
    assertTrue(actualAsMarkdownResult instanceof EmojiNode);
    assertEquals(":", ((EmojiNode) actualAsMarkdownResult).getClosingDelimiter());
    assertEquals(":", ((EmojiNode) actualAsMarkdownResult).getOpeningDelimiter());
    assertNull(((EmojiNode) actualAsMarkdownResult).getAnnotation());
    assertNull(((EmojiNode) actualAsMarkdownResult).getShortcode());
    assertNull(actualAsMarkdownResult.getFirstChild());
    assertNull(actualAsMarkdownResult.getLastChild());
    assertNull(actualAsMarkdownResult.getNext());
    assertNull(actualAsMarkdownResult.getParent());
    assertNull(actualAsMarkdownResult.getPrevious());
  }

  /**
   * Test {@link Emoji#asText()}.
   *
   * <p>Method under test: {@link Emoji#asText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Emoji.asText()"})
  public void testAsText() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Bold child = new Bold(parent2);
    BulletList parent3 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent3));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Bold child2 = new Bold(parent5);
    child2.addChild(child);
    BulletList parent6 = new BulletList(mock(Element.class));
    Bold parent7 = new Bold(parent6);

    CashTag child3 = new CashTag(parent7, 1);
    child3.addChild(child2);
    BulletList parent8 = new BulletList(mock(Element.class));
    Bold parent9 = new Bold(parent8);

    Emoji emoji = new Emoji(parent9, 1);
    emoji.addChild(child3);

    // Act and Assert
    assertEquals("$null", emoji.asText());
  }

  /**
   * Test {@link Emoji#asText()}.
   *
   * <p>Method under test: {@link Emoji#asText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Emoji.asText()"})
  public void testAsText2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Bold child = new Bold(parent2);
    BulletList parent3 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent3));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    CashTag child2 = new CashTag(parent5, 1);
    child2.addChild(child);
    BulletList parent6 = new BulletList(mock(Element.class));
    Bold parent7 = new Bold(parent6);

    Bold child3 = new Bold(parent7);
    child3.addChild(child2);
    BulletList parent8 = new BulletList(mock(Element.class));
    Bold parent9 = new Bold(parent8);

    Emoji emoji = new Emoji(parent9, 1);
    emoji.addChild(child3);

    // Act and Assert
    assertEquals("$null", emoji.asText());
  }

  /**
   * Test {@link Emoji#asText()}.
   *
   * <ul>
   *   <li>Given {@link Emoji#Emoji(Element, int)} with parent is {@link Bold#Bold(Element)} and
   *       entityIndex is one.
   *   <li>Then return {@code :null:}.
   * </ul>
   *
   * <p>Method under test: {@link Emoji#asText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Emoji.asText()"})
  public void testAsText_givenEmojiWithParentIsBoldAndEntityIndexIsOne_thenReturnNull() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertEquals(":null:", new Emoji(parent2, 1).asText());
  }

  /**
   * Test {@link Emoji#asText()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link Emoji#asText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Emoji.asText()"})
  public void testAsText_thenReturnEmptyString() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    Bold child = new Bold(parent2);
    BulletList parent3 = new BulletList(mock(Element.class));
    child.addChild(new Bold(parent3));
    BulletList parent4 = new BulletList(mock(Element.class));
    Bold parent5 = new Bold(parent4);

    Bold child2 = new Bold(parent5);
    child2.addChild(child);
    BulletList parent6 = new BulletList(mock(Element.class));
    Bold parent7 = new Bold(parent6);

    Bold child3 = new Bold(parent7);
    child3.addChild(child2);
    BulletList parent8 = new BulletList(mock(Element.class));
    Bold parent9 = new Bold(parent8);

    Emoji emoji = new Emoji(parent9, 1);
    emoji.addChild(child3);

    // Act and Assert
    assertEquals("", emoji.asText());
  }

  /**
   * Test {@link Emoji#asEntityJson(ObjectNode)}.
   *
   * <ul>
   *   <li>Then return {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is
   *       withExactBigDecimals {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Emoji#asEntityJson(ObjectNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode Emoji.asEntityJson(ObjectNode)"})
  public void testAsEntityJson_thenReturnObjectNodeWithNcIsWithExactBigDecimalsTrue() {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    Emoji emoji = new Emoji(parent, 1);

    ObjectNode parent2 = mock(ObjectNode.class);
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode objectNode = new ObjectNode(nc);
    when(parent2.path(Mockito.<String>any())).thenReturn(objectNode);

    // Act
    ObjectNode actualAsEntityJsonResult = emoji.asEntityJson(parent2);

    // Assert
    verify(parent2).path("emoji1");
    assertSame(objectNode, actualAsEntityJsonResult);
  }

  /**
   * Test {@link Emoji#validate()}.
   *
   * <p>Method under test: {@link Emoji#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.validate()"})
  public void testValidate() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    Emoji emoji =
        new Emoji(parent, "Either the attribute \"shortcode\" or \"annotation\" are required", 1);

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> emoji.validate());
  }

  /**
   * Test {@link Emoji#validate()}.
   *
   * <p>Method under test: {@link Emoji#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.validate()"})
  public void testValidate2() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    Emoji emoji = new Emoji(parent, "", 1);

    // Act and Assert
    emoji.validate();
  }

  /**
   * Test {@link Emoji#validate()}.
   *
   * <p>Method under test: {@link Emoji#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.validate()"})
  public void testValidate3() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    Emoji emoji = new Emoji(parent, "annotation", 1);

    // Act and Assert
    emoji.validate();
  }

  /**
   * Test {@link Emoji#validate()}.
   *
   * <p>Method under test: {@link Emoji#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.validate()"})
  public void testValidate4() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    Emoji emoji = new Emoji(parent, Emoji.MESSAGEML_TAG, 1);

    // Act and Assert
    emoji.validate();
  }

  /**
   * Test {@link Emoji#validate()}.
   *
   * <p>Method under test: {@link Emoji#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.validate()"})
  public void testValidate5() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    Emoji emoji = new Emoji(parent, "U", 1);
    emoji.addChild(new Bold(new BulletList(null)));

    // Act and Assert
    emoji.validate();
  }

  /**
   * Test {@link Emoji#validate()}.
   *
   * <ul>
   *   <li>Given {@link Emoji#Emoji(Element, int)} with parent is {@link Bold#Bold(Element)} and
   *       entityIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link Emoji#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.validate()"})
  public void testValidate_givenEmojiWithParentIsBoldAndEntityIndexIsOne()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> new Emoji(parent, 1).validate());
  }

  /**
   * Test {@link Emoji#validate()}.
   *
   * <ul>
   *   <li>Given {@link Emoji#Emoji(Element, String, int)} with parent is {@link Bold#Bold(Element)}
   *       and {@code Shortcode} and entityIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link Emoji#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.validate()"})
  public void testValidate_givenEmojiWithParentIsBoldAndShortcodeAndEntityIndexIsOne()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    Emoji emoji = new Emoji(parent, "Shortcode", 1);

    // Act and Assert
    emoji.validate();
  }

  /**
   * Test {@link Emoji#validate()}.
   *
   * <ul>
   *   <li>Given {@link Emoji#Emoji(Element, String, int)} with parent is {@link Bold#Bold(Element)}
   *       and shortcode is {@code 42} and entityIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link Emoji#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.validate()"})
  public void testValidate_givenEmojiWithParentIsBoldAndShortcodeIs42AndEntityIndexIsOne()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    Emoji emoji = new Emoji(parent, "42", 1);

    // Act and Assert
    emoji.validate();
  }

  /**
   * Test {@link Emoji#validate()}.
   *
   * <ul>
   *   <li>Given {@link Emoji#Emoji(Element, String, int)} with parent is {@link Bold#Bold(Element)}
   *       and shortcode is {@code family} and entityIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link Emoji#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.validate()"})
  public void testValidate_givenEmojiWithParentIsBoldAndShortcodeIsFamilyAndEntityIndexIsOne()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    Emoji emoji = new Emoji(parent, "family", 1);

    // Act and Assert
    emoji.validate();
  }

  /**
   * Test {@link Emoji#validate()}.
   *
   * <ul>
   *   <li>Given {@link Emoji#Emoji(Element, String, int)} with parent is {@link Bold#Bold(Element)}
   *       and shortcode is {@code U} and entityIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link Emoji#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.validate()"})
  public void testValidate_givenEmojiWithParentIsBoldAndShortcodeIsUAndEntityIndexIsOne()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));
    Emoji emoji = new Emoji(parent, "U", 1);

    // Act and Assert
    emoji.validate();
  }

  /**
   * Test {@link Emoji#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Emoji#buildAttribute(MessageMLParser, org.w3c.dom.Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.buildAttribute(MessageMLParser, org.w3c.dom.Node)"})
  public void testBuildAttribute_whenIIOMetadataNodeWithFoo_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Emoji emoji = new Emoji(parent2, 1);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> emoji.buildAttribute(parser, new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link Emoji#updateBiContext(BiContext)}.
   *
   * <p>Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.updateBiContext(BiContext)"})
  public void testUpdateBiContext() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Emoji emoji = new Emoji(parent2, Element.STYLE_ATTR, 1);
    BiContext context = new BiContext();

    // Act
    emoji.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("com.symphony.emoji", attributes.get("entity_type"));
    BiItem getResult2 = items.get(0);
    assertEquals("emojis", getResult2.getName());
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertEquals(1, ((Integer) attributes2.get("count")).intValue());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
  }

  /**
   * Test {@link Emoji#updateBiContext(BiContext)}.
   *
   * <p>Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.updateBiContext(BiContext)"})
  public void testUpdateBiContext2() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Emoji emoji = new Emoji(parent2, 1);

    BiContext context = new BiContext();
    context.addItemWithValue("emojis", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    emoji.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(3);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("com.symphony.emoji", attributes.get("entity_type"));
    BiItem getResult2 = items.get(1);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
    assertEquals(Element.STYLE_ATTR, getResult2.getName());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
  }

  /**
   * Test {@link Emoji#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Given {@code Item Value}.
   * </ul>
   *
   * <p>Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.updateBiContext(BiContext)"})
  public void testUpdateBiContext_givenItemValue() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Emoji emoji = new Emoji(parent2, 1);

    BiContext context = new BiContext();
    context.addItemWithValue("emojis", "Item Value");
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    emoji.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(3);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("com.symphony.emoji", attributes.get("entity_type"));
    BiItem getResult2 = items.get(1);
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
    assertEquals(Element.STYLE_ATTR, getResult2.getName());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
  }

  /**
   * Test {@link Emoji#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items first Attributes size is two.
   * </ul>
   *
   * <p>Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsFirstAttributesSizeIsTwo() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Emoji emoji = new Emoji(parent2, 1);

    BiContext context = new BiContext();
    context.addItem(new BiItem("emojis", Element.STYLE_ATTR));

    // Act
    emoji.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("com.symphony.emoji", attributes.get("entity_type"));
    Map<String, Object> attributes2 = items.get(0).getAttributes();
    assertEquals(2, attributes2.size());
    assertEquals(1, ((Integer) attributes2.get("count")).intValue());
    assertTrue(attributes2.containsKey(Element.STYLE_ATTR));
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
  }

  /**
   * Test {@link Emoji#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items size is three.
   * </ul>
   *
   * <p>Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsSizeIsThree() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Emoji emoji = new Emoji(parent2, 1);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    emoji.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("com.symphony.emoji", attributes.get("entity_type"));
    BiItem getResult2 = items.get(1);
    assertEquals("emojis", getResult2.getName());
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertEquals(1, ((Integer) attributes2.get("count")).intValue());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
  }

  /**
   * Test {@link Emoji#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>Then {@link BiContext} (default constructor) Items third Name is {@code emojis}.
   * </ul>
   *
   * <p>Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.updateBiContext(BiContext)"})
  public void testUpdateBiContext_thenBiContextItemsThirdNameIsEmojis() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Emoji emoji = new Emoji(parent2, 1);

    BiContext context = new BiContext();
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    context.addItem(new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));

    // Act
    emoji.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(4, items.size());
    BiItem getResult = items.get(2);
    assertEquals("emojis", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals(1, ((Integer) attributes.get("count")).intValue());
  }

  /**
   * Test {@link Emoji#updateBiContext(BiContext)}.
   *
   * <ul>
   *   <li>When {@link BiContext} (default constructor).
   *   <li>Then {@link BiContext} (default constructor) Items first Name is {@code emojis}.
   * </ul>
   *
   * <p>Method under test: {@link Emoji#updateBiContext(BiContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Emoji.updateBiContext(BiContext)"})
  public void testUpdateBiContext_whenBiContext_thenBiContextItemsFirstNameIsEmojis() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    Emoji emoji = new Emoji(parent2, 1);
    BiContext context = new BiContext();

    // Act
    emoji.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertEquals("com.symphony.emoji", attributes.get("entity_type"));
    BiItem getResult2 = items.get(0);
    assertEquals("emojis", getResult2.getName());
    Map<String, Object> attributes2 = getResult2.getAttributes();
    assertEquals(1, attributes2.size());
    assertEquals(1, ((Integer) attributes2.get("count")).intValue());
    assertEquals(Entity.PRESENTATIONML_CLASS, getResult.getName());
  }
}
