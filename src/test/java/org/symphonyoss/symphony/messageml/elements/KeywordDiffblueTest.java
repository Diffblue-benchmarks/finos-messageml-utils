package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class KeywordDiffblueTest {
  /**
   * Test {@link Keyword#validate()}.
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Keyword#validate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Keyword.validate()"})
  public void testValidate_thenThrowInvalidInputException() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).validate());
  }

  /**
   * Test {@link Keyword#getTag()}.
   * <p>
   * Method under test: {@link Keyword#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Keyword.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertNull((new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).getTag());
  }

  /**
   * Test {@link Keyword#getEntityIdPrefix()}.
   * <p>
   * Method under test: {@link Keyword#getEntityIdPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Keyword.getEntityIdPrefix()"})
  public void testGetEntityIdPrefix() {
    // Arrange, Act and Assert
    assertEquals("keyword", (new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).getEntityIdPrefix());
  }

  /**
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Keyword.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML() {
    // Arrange
    CashTag cashTag = new CashTag(new Bold(new BulletList(mock(Element.class))), 1);
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cashTag.asPresentationML(xmlPrintStream, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(62L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Keyword.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML2() {
    // Arrange
    CashTag cashTag = new CashTag(new Bold(mock(Element.class)), CashTag.PREFIX, "42");
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cashTag.asPresentationML(xmlPrintStream, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(45L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Keyword.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML3() {
    // Arrange
    CashTag cashTag = new CashTag(new Bold(mock(Element.class)), CashTag.PREFIX, "<");
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cashTag.asPresentationML(xmlPrintStream, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(47L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Keyword.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML4() {
    // Arrange
    CashTag cashTag = new CashTag(new Bold(mock(Element.class)), CashTag.PREFIX, "=\"");
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cashTag.asPresentationML(xmlPrintStream, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(50L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Keyword.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML5() {
    // Arrange
    CashTag cashTag = new CashTag(new Bold(mock(Element.class)), CashTag.PREFIX, ">");
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    cashTag.asPresentationML(xmlPrintStream, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(47L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Keyword.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML6() {
    // Arrange
    CashTag cashTag = new CashTag(new Bold(new BulletList(mock(Element.class))), 1);

    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.setPrintOffsets(true);

    // Act
    cashTag.asPresentationML(xmlPrintStream, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(62L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Keyword.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML7() {
    // Arrange
    CashTag cashTag = new CashTag(new Bold(new BulletList(mock(Element.class))), 1);

    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.setNoIndent(true);

    // Act
    cashTag.asPresentationML(xmlPrintStream, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(61L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test: {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Keyword.asPresentationML(XmlPrintStream, MessageMLContext)"})
  public void testAsPresentationML8() {
    // Arrange
    CashTag cashTag = new CashTag(new Bold(new BulletList(mock(Element.class))), 1);

    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.setNoNl(true);

    // Act
    cashTag.asPresentationML(xmlPrintStream, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(60L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link Keyword#getEntityValue()}.
   * <p>
   * Method under test: {@link Keyword#getEntityValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Keyword.getEntityValue()"})
  public void testGetEntityValue() {
    // Arrange, Act and Assert
    assertNull((new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).getEntityValue());
  }

  /**
   * Test {@link Keyword#toString()}.
   * <p>
   * Method under test: {@link Keyword#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Keyword.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("CashTag(null)", (new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).toString());
  }
}
