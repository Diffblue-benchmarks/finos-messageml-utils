package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.bi.BiContext;
import org.symphonyoss.symphony.messageml.bi.BiItem;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.util.NoOpDataProvider;
import org.symphonyoss.symphony.messageml.util.XmlPrintStream;

public class ChimeDiffblueTest {
  /**
   * Method under test:
   * {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);
    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    chime.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(85L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML2() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setPrintOffsets(true);

    // Act
    chime.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(85L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML3() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoIndent(true);

    // Act
    chime.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(84L, out.getOffset());
  }

  /**
   * Method under test:
   * {@link Chime#asPresentationML(XmlPrintStream, MessageMLContext)}
   */
  @Test
  public void testAsPresentationML4() throws InvalidInputException {
    // Arrange
    Chime chime = new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML);

    XmlPrintStream out = new XmlPrintStream(new ByteArrayOutputStream(1));
    out.setNoNl(true);

    // Act
    chime.asPresentationML(out, new MessageMLContext(new NoOpDataProvider()));

    // Assert
    assertEquals(83L, out.getOffset());
  }

  /**
   * Method under test: {@link Chime#asText()}
   */
  @Test
  public void testAsText() throws InvalidInputException {
    // Arrange, Act and Assert
    assertEquals("", (new Chime(new MessageML(FormatEnum.MESSAGEML, "1.0.2"), FormatEnum.MESSAGEML)).asText());
  }

  /**
   * Method under test: {@link Chime#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext() throws InvalidInputException {
    // Arrange
    MessageML parent = new MessageML(FormatEnum.MESSAGEML, "1.0.2");

    Chime chime = new Chime(parent, FormatEnum.MESSAGEML);
    BiContext context = new BiContext();

    // Act
    chime.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    BiItem getResult = items.get(0);
    assertEquals("chimes", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(parent, chime.getParent());
  }

  /**
   * Method under test: {@link Chime#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext2() throws InvalidInputException {
    // Arrange
    MessageML parent = new MessageML(FormatEnum.MESSAGEML, "1.0.2");

    Chime chime = new Chime(parent, FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    chime.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(1);
    assertEquals("chimes", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(parent, chime.getParent());
  }

  /**
   * Method under test: {@link Chime#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext3() throws InvalidInputException {
    // Arrange
    MessageML parent = new MessageML(FormatEnum.MESSAGEML, "1.0.2");

    Chime chime = new Chime(parent, FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);
    BiItem item2 = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item2);

    // Act
    chime.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(3, items.size());
    BiItem getResult = items.get(2);
    assertEquals("chimes", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(0));
    assertSame(item2, items.get(1));
    assertSame(parent, chime.getParent());
  }

  /**
   * Method under test: {@link Chime#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext4() throws InvalidInputException {
    // Arrange
    MessageML parent = new MessageML(FormatEnum.MESSAGEML, "1.0.2");

    Chime chime = new Chime(parent, FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItemWithValue("chimes", "Item Value");
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    chime.updateBiContext(context);

    // Assert that nothing has changed
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(0);
    assertEquals("chimes", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(parent, chime.getParent());
  }

  /**
   * Method under test: {@link Chime#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext5() throws InvalidInputException {
    // Arrange
    MessageML parent = new MessageML(FormatEnum.MESSAGEML, "1.0.2");

    Chime chime = new Chime(parent, FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    BiItem item = new BiItem("chimes", Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    chime.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(1, items.size());
    assertSame(item, items.get(0));
    assertSame(parent, chime.getParent());
  }

  /**
   * Method under test: {@link Chime#updateBiContext(BiContext)}
   */
  @Test
  public void testUpdateBiContext6() throws InvalidInputException {
    // Arrange
    MessageML parent = new MessageML(FormatEnum.MESSAGEML, "1.0.2");

    Chime chime = new Chime(parent, FormatEnum.MESSAGEML);

    BiContext context = new BiContext();
    context.addItemWithValue("chimes", new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR));
    BiItem item = new BiItem(Element.STYLE_ATTR, Element.STYLE_ATTR);

    context.addItem(item);

    // Act
    chime.updateBiContext(context);

    // Assert
    List<BiItem> items = context.getItems();
    assertEquals(2, items.size());
    BiItem getResult = items.get(0);
    assertEquals("chimes", getResult.getName());
    Map<String, Object> attributes = getResult.getAttributes();
    assertEquals(1, attributes.size());
    assertTrue(attributes.containsKey("count"));
    assertSame(item, items.get(1));
    assertSame(parent, chime.getParent());
  }

  /**
   * Method under test: {@link Chime#Chime(Element, FormatEnum)}
   */
  @Test
  public void testNewChime() throws InvalidInputException {
    // Arrange, Act and Assert
    assertThrows(InvalidInputException.class,
        () -> new Chime(new Bold(new BulletList(mock(Element.class))), FormatEnum.MESSAGEML));

  }

  /**
   * Method under test: {@link Chime#Chime(Element, FormatEnum)}
   */
  @Test
  public void testNewChime2() throws InvalidInputException {
    // Arrange
    MessageML parent = new MessageML(FormatEnum.MESSAGEML, "1.0.2");

    // Act
    Chime actualChime = new Chime(parent, FormatEnum.MESSAGEML);

    // Assert
    assertEquals(0, actualChime.size());
    assertEquals(FormatEnum.MESSAGEML, actualChime.getFormat());
    assertTrue(actualChime.getChildren().isEmpty());
    assertTrue(actualChime.getAttributes().isEmpty());
    assertTrue(parent.isChime());
    assertEquals(Chime.MESSAGEML_TAG, actualChime.getMessageMLTag());
    assertEquals(Chime.PRESENTATIONML_TAG, actualChime.getPresentationMLTag());
    assertSame(parent, actualChime.getParent());
  }
}
