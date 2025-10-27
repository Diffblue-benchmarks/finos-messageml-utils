package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class ElementDiffblueTest {
  /**
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
    assertTrue(bold.getChildren().isEmpty());
  }

  /**
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML15() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    Bold child = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = bold.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof Bold);
    assertEquals(20L, out.getOffset());
    assertSame(child, getResult);
  }

  /**
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML16() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    Checkbox child = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    bold.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = bold.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof Checkbox);
    assertEquals(53L, out.getOffset());
    assertSame(child, getResult);
  }

  /**
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML17() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    Button child = new Button(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    bold.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = bold.getChildren();
    assertEquals(1, children.size());
    assertEquals(44L, out.getOffset());
    assertSame(child, children.get(0));
  }

  /**
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML18() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    Card child = new Card(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    bold.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = bold.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof Card);
    assertEquals(37L, out.getOffset());
    assertSame(child, getResult);
  }

  /**
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML19() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    CardBody child = new CardBody(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);

    bold.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = bold.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof CardBody);
    assertEquals(41L, out.getOffset());
    assertSame(child, getResult);
  }

  /**
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML20() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    Code child = new Code(new Bold(mock(Element.class)), "en");

    bold.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = bold.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof Code);
    assertEquals(45L, out.getOffset());
    assertSame(child, getResult);
  }

  /**
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML21() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    CashTag child = new CashTag(new Bold(new BulletList(mock(Element.class))), 1);

    bold.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = bold.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof CashTag);
    assertEquals(73L, out.getOffset());
    assertSame(child, getResult);
  }

  /**
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML22() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(9L, out.getOffset());
    assertTrue(bold.getChildren().isEmpty());
  }

  /**
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML23() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(9L, out.getOffset());
    assertTrue(bold.getChildren().isEmpty());
  }

  /**
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML24() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(7L, out.getOffset());
    assertTrue(bold.getChildren().isEmpty());
  }

  /**
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML25() {
    // Arrange
    Checkbox child = new Checkbox(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = bold.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof Checkbox);
    assertSame(child, getResult);
  }

  /**
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML26() {
    // Arrange
    Button child = new Button(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML);
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = bold.getChildren();
    assertEquals(1, children.size());
    assertEquals(57L, out.getOffset());
    assertSame(child, children.get(0));
  }

  /**
   * Method under test:
   * {@link Element#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML27() {
    // Arrange
    Code child = new Code(new Bold(mock(Element.class)), "en");
    child.addChild(new Bold(new BulletList(mock(Element.class))));

    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(child);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    bold.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    List<Element> children = bold.getChildren();
    assertEquals(1, children.size());
    Element getResult = children.get(0);
    assertTrue(getResult instanceof Code);
    assertEquals(58L, out.getOffset());
    assertSame(child, getResult);
  }

  /**
   * Method under test: {@link Element#asText()}
   */
  @Test
  public void testAsText() {
    // Arrange, Act and Assert
    assertEquals("", (new Bold(new BulletList(mock(Element.class)))).asText());
    assertEquals("", (new Bold(new BulletList(mock(Element.class)))).asText());
  }

  /**
   * Method under test: {@link Element#asText()}
   */
  @Test
  public void testAsText2() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertEquals("", bold.asText());
  }

  /**
   * Method under test: {@link Element#asText()}
   */
  @Test
  public void testAsText3() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));

    // Act and Assert
    assertEquals("$null", bold.asText());
  }

  /**
   * Method under test: {@link Element#asText()}
   */
  @Test
  public void testAsText4() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new Bold(new BulletList(mock(Element.class))));

    // Act and Assert
    assertEquals("", bold.asText());
  }

  /**
   * Method under test: {@link Element#asText()}
   */
  @Test
  public void testAsText5() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(Element.class)));
    bold.addChild(new CashTag(new Bold(new BulletList(mock(Element.class))), 1));

    // Act and Assert
    assertEquals("$null", bold.asText());
  }

  /**
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
   * Method under test: {@link Element#areNestedElementsAllowed()}
   */
  @Test
  public void testAreNestedElementsAllowed() {
    // Arrange, Act and Assert
    assertTrue((new Bold(new BulletList(mock(Element.class)))).areNestedElementsAllowed());
    assertTrue((new Bold(new BulletList(mock(Element.class)))).areNestedElementsAllowed());
  }

  /**
   * Method under test: {@link Element#addChild(Element)}
   */
  @Test
  public void testAddChild() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(BulletList.class)));
    Bold child = new Bold(new BulletList(null));

    // Act
    bold.addChild(child);

    // Assert
    List<Element> children = bold.getChildren();
    assertEquals(1, children.size());
    assertEquals(1, bold.size());
    assertSame(child, children.get(0));
  }

  /**
   * Method under test: {@link Element#addChild(Element)}
   */
  @Test
  public void testAddChild2() {
    // Arrange
    Bold bold = new Bold(new BulletList(mock(BulletList.class)));
    Bold child = new Bold(new BulletList(null));

    // Act
    bold.addChild(child);

    // Assert
    List<Element> children = bold.getChildren();
    assertEquals(1, children.size());
    assertEquals(1, bold.size());
    assertSame(child, children.get(0));
  }
}
