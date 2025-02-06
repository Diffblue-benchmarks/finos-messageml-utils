package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayOutputStream;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.MessageMLParser;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;
import org.w3c.dom.Node;

public class KeywordDiffblueTest {
  /**
   * Test {@link Keyword#buildAttribute(MessageMLParser, Node)}.
   * <ul>
   *   <li>Given {@link BulletList#BulletList(Element)} with parent is
   * {@link Element}.</li>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Keyword#buildAttribute(MessageMLParser, Node)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAttribute_givenBulletListWithParentIsElement_whenIIOMetadataNodeWithFoo()
      throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.symphonyoss.symphony.messageml.exceptions.InvalidInputException: Attribute "foo" is not allowed in "cash"
    //       at org.symphonyoss.symphony.messageml.elements.Element.throwInvalidInputException(Element.java:1071)
    //       at org.symphonyoss.symphony.messageml.elements.Entity.buildAttribute(Entity.java:59)
    //       at org.symphonyoss.symphony.messageml.elements.Keyword.buildAttribute(Keyword.java:48)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    CashTag cashTag = new CashTag(new Bold(new BulletList(mock(Element.class))), 1);
    MessageMLParser parser = mock(MessageMLParser.class);

    // Act
    cashTag.buildAttribute(parser, new IIOMetadataNode("foo"));
  }

  /**
   * Test {@link Keyword#validate()}.
   * <ul>
   *   <li>Then throw {@link InvalidInputException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Keyword#validate()}
   */
  @Test
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
  public void testGetEntityIdPrefix() {
    // Arrange, Act and Assert
    assertEquals("keyword", (new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).getEntityIdPrefix());
  }

  /**
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
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
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
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
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
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
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
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
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
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
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
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
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
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
   * Test {@link Keyword#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
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
   * Test {@link Keyword#getEntityValue()}.
   * <p>
   * Method under test: {@link Keyword#getEntityValue()}
   */
  @Test
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
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("CashTag(null)", (new CashTag(new Bold(new BulletList(mock(Element.class))), 1)).toString());
  }
}
