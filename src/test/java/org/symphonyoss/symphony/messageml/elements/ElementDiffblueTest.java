package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Ignore;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class ElementDiffblueTest {
  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(9L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(20L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(53L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new Button(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(44L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML5() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(37L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML6() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(41L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML7() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new Code(new Bold(mock(Element.class)), "en"));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(45L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML8() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(73L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML9() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(9L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML10() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(9L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML11() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(7L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML12() {
    // Arrange
    Button child = new Button(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(57L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML13() {
    // Arrange
    Code child = new Code(new Bold(mock(Element.class)), "en");
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(58L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML14() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(9L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML15() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new Bold(new BulletList(mock(Element.class))));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(20L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML16() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(53L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML17() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(37L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML18() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(41L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML19() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new Code(new Bold(mock(Element.class)), "en"));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(45L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML20() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(73L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML21() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(9L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML22() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(9L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML23() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(7L, out.getOffset());
  }

  /**
   * Test {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}.
   * <p>
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML24() {
    // Arrange
    Code child = new Code(new Bold(mock(Element.class)), "en");
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(58L, out.getOffset());
  }

  /**
   * Test {@link Element#asText()}.
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is
   * {@link BulletList#BulletList(Element)} addChild {@link Bold#Bold(Element)}
   * with parent is {@link BulletList#BulletList(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#asText()}
   */
  @Test
  public void testAsText_givenBoldWithParentIsBulletListAddChildBoldWithParentIsBulletList() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertEquals("", bold.asText());
  }

  /**
   * Test {@link Element#asText()}.
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is
   * {@link BulletList#BulletList(Element)} addChild {@link Bold#Bold(Element)}
   * with parent is {@link BulletList#BulletList(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#asText()}
   */
  @Test
  public void testAsText_givenBoldWithParentIsBulletListAddChildBoldWithParentIsBulletList2() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertEquals("", bold.asText());
  }

  /**
   * Test {@link Element#asText()}.
   * <ul>
   *   <li>Given {@link Bold#Bold(Element)} with parent is
   * {@link BulletList#BulletList(Element)}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#asText()}
   */
  @Test
  public void testAsText_givenBoldWithParentIsBulletList_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new Bold(new BulletList(mock(Element.class)))).asText());
    assertEquals("", (new Bold(new BulletList(mock(Element.class)))).asText());
  }

  /**
   * Test {@link Element#asText()}.
   * <ul>
   *   <li>Then return {@code $null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#asText()}
   */
  @Test
  public void testAsText_thenReturnNull() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));

    // Act and Assert
    assertEquals("$null", bold.asText());
  }

  /**
   * Test {@link Element#asText()}.
   * <ul>
   *   <li>Then return {@code $null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#asText()}
   */
  @Test
  public void testAsText_thenReturnNull2() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));

    // Act and Assert
    assertEquals("$null", bold.asText());
  }

  /**
   * Test {@link Element#asEntityJson(ObjectNode)}.
   * <p>
   * Method under test: {@link Element#asEntityJson(ObjectNode)}
   */
  @Test
  public void testAsEntityJson() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));

    // Act and Assert
    assertNull(bold.asEntityJson(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))));
  }

  /**
   * Test {@link Element#asEntityJson(ObjectNode)}.
   * <p>
   * Method under test: {@link Element#asEntityJson(ObjectNode)}
   */
  @Test
  public void testAsEntityJson2() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));

    // Act and Assert
    assertNull(bold.asEntityJson(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))));
  }

  /**
   * Test {@link Element#assertAttributeValue(String, Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#assertAttributeValue(String, Collection)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAssertAttributeValue_whenArrayList() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertAttributeValue(Element.java:551)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));

    // Act
    bold.assertAttributeValue("Attribute Name", new ArrayList<>());
  }

  /**
   * Test {@link Element#assertAttributeValue(String, Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#assertAttributeValue(String, Collection)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAssertAttributeValue_whenArrayList2() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertAttributeValue(Element.java:551)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));

    // Act
    bold.assertAttributeValue("Attribute Name", new ArrayList<>());
  }

  /**
   * Test {@link Element#assertAttributeIsBoolean(String)}.
   * <p>
   * Method under test: {@link Element#assertAttributeIsBoolean(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAssertAttributeIsBoolean() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertAttributeValue(Element.java:551)
    //       at org.symphonyoss.symphony.messageml.elements.Element.assertAttributeIsBoolean(Element.java:566)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new Bold(new BulletList(mock(Element.class)))).assertAttributeIsBoolean("Attribute Name");
    (new Bold(new BulletList(mock(Element.class)))).assertAttributeIsBoolean("Attribute Name");
  }

  /**
   * Test {@link Element#assertAttributeNotBlank(String)}.
   * <p>
   * Method under test: {@link Element#assertAttributeNotBlank(String)}
   */
  @Test
  public void testAssertAttributeNotBlank() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> (new Bold(new BulletList(mock(Element.class)))).assertAttributeNotBlank("Attribute Name"));
    assertThrows(InvalidInputException.class,
        () -> (new Bold(new BulletList(mock(Element.class)))).assertAttributeNotBlank("Attribute Name"));
  }

  /**
   * Test {@link Element#assertAttributeMaxLength(String, int)}.
   * <p>
   * Method under test: {@link Element#assertAttributeMaxLength(String, int)}
   */
  @Test
  public void testAssertAttributeMaxLength() throws InvalidInputException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new Bold(new BulletList(mock(Element.class)))).assertAttributeMaxLength("Attribute Name", 3);
    (new Bold(new BulletList(mock(Element.class)))).assertAttributeMaxLength("Attribute Name", 3);
  }

  /**
   * Test {@link Element#areNestedElementsAllowed()}.
   * <p>
   * Method under test: {@link Element#areNestedElementsAllowed()}
   */
  @Test
  public void testAreNestedElementsAllowed() {
    // Arrange, Act and Assert
    assertTrue((new Bold(new BulletList(mock(Element.class)))).areNestedElementsAllowed());
    assertTrue((new Bold(new BulletList(mock(Element.class)))).areNestedElementsAllowed());
  }

  /**
   * Test {@link Element#addChild(Element)}.
   * <p>
   * Method under test: {@link Element#addChild(Element)}
   */
  @Test
  public void testAddChild() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));

    // Act
    bold.addChild(new Bold(new BulletList(mock(Element.class))));
  }

  /**
   * Test {@link Element#addChild(Element)}.
   * <p>
   * Method under test: {@link Element#addChild(Element)}
   */
  @Test
  public void testAddChild2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));

    // Act
    bold.addChild(new Bold(new BulletList(mock(Element.class))));
  }
}
