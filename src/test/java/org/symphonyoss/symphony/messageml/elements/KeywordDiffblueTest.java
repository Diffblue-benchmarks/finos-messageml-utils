package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;
import org.w3c.dom.Node;

public class KeywordDiffblueTest {
  /**
   * Test {@link Keyword#buildAttribute(MessageMLParser, Node)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Keyword#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Keyword.buildAttribute(MessageMLParser, Node)"})
  public void testBuildAttribute_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    CashTag cashTag = new CashTag(parent2, 1);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act and Assert
    assertThrows(
        InvalidInputException.class,
        () -> cashTag.buildAttribute(parser, new IIOMetadataNode(Element.CLASS_ATTR)));
  }

  /**
   * Test {@link Keyword#validate()}.
   *
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is {@code null}.
   *   <li>Then throw {@link InvalidInputException}.
   * </ul>
   *
   * <p>Method under test: {@link Keyword#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Keyword.validate()"})
  public void testValidate_givenBoldWithParentIsNull_thenThrowInvalidInputException()
      throws InvalidInputException {
    // Arrange
    CashTag cashTag = new CashTag(new Bold(null), "The attribute \"tag\" is required", "42");

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> cashTag.validate());
  }

  /**
   * Test {@link Keyword#validate()}.
   *
   * <ul>
   *   <li>Given {@link CashTag#CashTag(Element, int)} with parent is {@link Bold#Bold(Element)} and
   *       entityIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link Keyword#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Keyword.validate()"})
  public void testValidate_givenCashTagWithParentIsBoldAndEntityIndexIsOne()
      throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    assertThrows(InvalidInputException.class, () -> new CashTag(parent, 1).validate());
  }

  /**
   * Test {@link Keyword#validate()}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Keyword#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Keyword.validate()"})
  public void testValidate_thenDoesNotThrow() throws InvalidInputException {
    // Arrange
    Bold parent = new Bold(new BulletList(null));

    // Act and Assert
    new CashTag(parent, 1, "42").validate();
  }

  /**
   * Test {@link Keyword#getTag()}.
   *
   * <p>Method under test: {@link Keyword#getTag()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Keyword.getTag()"})
  public void testGetTag() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertNull(new CashTag(parent2, 1).getTag());
  }

  /**
   * Test {@link Keyword#getEntityIdPrefix()}.
   *
   * <p>Method under test: {@link Keyword#getEntityIdPrefix()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Keyword.getEntityIdPrefix()"})
  public void testGetEntityIdPrefix() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertEquals("keyword", new CashTag(parent2, 1).getEntityIdPrefix());
  }

  /**
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Keyword.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    CashTag cashTag = new CashTag(parent2, 1);
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    cashTag.asPresentationML(xmlPrintStream, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(62L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Keyword.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() {
    // Arrange
    Bold parent = new Bold(mock(Element.class));
    CashTag cashTag = new CashTag(parent, CashTag.PREFIX, "42");
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    cashTag.asPresentationML(xmlPrintStream, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(45L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Keyword.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() {
    // Arrange
    Bold parent = new Bold(mock(Element.class));
    CashTag cashTag = new CashTag(parent, CashTag.PREFIX, "<");
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    cashTag.asPresentationML(xmlPrintStream, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(47L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Keyword.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML4() {
    // Arrange
    Bold parent = new Bold(mock(Element.class));
    CashTag cashTag = new CashTag(parent, CashTag.PREFIX, "=\"");
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    cashTag.asPresentationML(xmlPrintStream, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(50L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Keyword.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML5() {
    // Arrange
    Bold parent = new Bold(mock(Element.class));
    CashTag cashTag = new CashTag(parent, CashTag.PREFIX, ">");
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream());

    // Act
    cashTag.asPresentationML(xmlPrintStream, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(47L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Keyword.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML6() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    CashTag cashTag = new CashTag(parent2, 1);

    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream());
    xmlPrintStream.setPrintOffsets(true);

    // Act
    cashTag.asPresentationML(xmlPrintStream, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(62L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Keyword.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML7() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    CashTag cashTag = new CashTag(parent2, 1);

    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream());
    xmlPrintStream.setNoIndent(true);

    // Act
    cashTag.asPresentationML(xmlPrintStream, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(61L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   *
   * <p>Method under test: {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Keyword.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML8() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);
    CashTag cashTag = new CashTag(parent2, 1);

    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream());
    xmlPrintStream.setNoNl(true);

    // Act
    cashTag.asPresentationML(xmlPrintStream, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(60L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link Keyword#getEntityValue()}.
   *
   * <p>Method under test: {@link Keyword#getEntityValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Keyword.getEntityValue()"})
  public void testGetEntityValue() {
    // Arrange
    BulletList parent = new BulletList(mock(Element.class));
    Bold parent2 = new Bold(parent);

    // Act and Assert
    assertNull(new CashTag(parent2, 1).getEntityValue());
  }
}
