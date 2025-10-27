package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayOutputStream;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class KeywordDiffblueTest {
  /**
   * Method under test: {@link Keyword#validate()}
   */
  @Test
  public void testValidate() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).validate());
  }

  /**
   * Method under test: {@link Keyword#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertNull((new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).getTag());
  }

  /**
   * Method under test: {@link Keyword#getEntityIdPrefix()}
   */
  @Test
  public void testGetEntityIdPrefix() {
    // Arrange, Act and Assert
    assertEquals("keyword", (new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).getEntityIdPrefix());
  }

  /**
   * Method under test:
   * {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
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
   * Method under test:
   * {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
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
   * Method under test:
   * {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
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
   * Method under test:
   * {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
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
   * Method under test:
   * {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
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
   * Method under test:
   * {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
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
   * Method under test:
   * {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
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
   * Method under test:
   * {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
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
   * Method under test: {@link Keyword#getEntityValue()}
   */
  @Test
  public void testGetEntityValue() {
    // Arrange, Act and Assert
    assertNull((new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).getEntityValue());
  }

  /**
   * Method under test: {@link Keyword#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("CashTag(null)", (new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).toString());
  }
}
