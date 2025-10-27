package org.symphonyoss.symphony.messageml.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;

public class XmlPrintStreamDiffblueTest {
  /**
   * Method under test: {@link XmlPrintStream#openElement(String)}
   */
  @Test
  public void testOpenElement() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.openElement("Name");

    // Assert
    assertEquals(7L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String)}
   */
  @Test
  public void testOpenElement2() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new PipedOutputStream());

    // Act
    xmlPrintStream.openElement("Name");

    // Assert
    assertEquals(6L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String)}
   */
  @Test
  public void testOpenElement3() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.openElement("Name");

    // Assert
    assertEquals(71L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String)}
   */
  @Test
  public void testOpenElement4() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.setNoNl(true);
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.openElement("Name");

    // Assert
    assertEquals(70L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElement5() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.openElement("Name", new HashMap<>());

    // Assert
    assertEquals(7L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElement6() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new PipedOutputStream());

    // Act
    xmlPrintStream.openElement("Name", new HashMap<>());

    // Assert
    assertEquals(5L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElement7() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("42", "42");

    // Act
    xmlPrintStream.openElement("Name", attributes);

    // Assert
    assertEquals(15L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElement8() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.computeIfPresent("42", mock(BiFunction.class));
    attributes.put("42", "42");

    // Act
    xmlPrintStream.openElement("Name", attributes);

    // Assert
    assertEquals(15L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElement9() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("", "42");

    // Act
    xmlPrintStream.openElement("Name", attributes);

    // Assert
    assertEquals(13L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElement10() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("42", "<");

    // Act
    xmlPrintStream.openElement("Name", attributes);

    // Assert
    assertEquals(17L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElement11() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("42", null);

    // Act
    xmlPrintStream.openElement("Name", attributes);

    // Assert
    assertEquals(11L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElement12() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("42", XMLAttribute.of("<", XMLAttribute.Format.STANDARD));

    // Act
    xmlPrintStream.openElement("Name", attributes);

    // Assert
    assertEquals(17L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElement13() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("42", "=\"");

    // Act
    xmlPrintStream.openElement("Name", attributes);

    // Assert
    assertEquals(20L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElement14() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("42", ">");

    // Act
    xmlPrintStream.openElement("Name", attributes);

    // Assert
    assertEquals(17L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String, Object[])}
   */
  @Test
  public void testOpenElement15() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.openElement("Name", "Attributes");

    // Assert
    assertEquals(22L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String, Object[])}
   */
  @Test
  public void testOpenElement16() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new PipedOutputStream());

    // Act
    xmlPrintStream.openElement("Name", "Attributes");

    // Assert
    assertEquals(5L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String, Object[])}
   */
  @Test
  public void testOpenElement17() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.openElement("Name", "Attributes");

    // Assert
    assertEquals(86L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String, Object[])}
   */
  @Test
  public void testOpenElement18() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.setPrintOffsets(true);
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.openElement("Name", "Attributes");

    // Assert
    assertEquals(86L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String, Object[])}
   */
  @Test
  public void testOpenElement19() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.setNoIndent(true);
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.openElement("Name", "Attributes");

    // Assert
    assertEquals(84L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String, Object[])}
   */
  @Test
  public void testOpenElement20() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.setNoNl(true);
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.openElement("Name", "Attributes");

    // Assert
    assertEquals(83L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#openElement(String, Object[])}
   */
  @Test
  public void testOpenElement21() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.openElement("Name", "Attributes", "Attributes");

    // Assert
    assertEquals(33L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String)}
   */
  @Test
  public void testPrintElement() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Name");

    // Assert
    assertEquals(8L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String)}
   */
  @Test
  public void testPrintElement2() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new PipedOutputStream());

    // Act
    xmlPrintStream.printElement("Name");

    // Assert
    assertEquals(7L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String)}
   */
  @Test
  public void testPrintElement3() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.printElement("Name");

    // Assert
    assertEquals(72L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String)}
   */
  @Test
  public void testPrintElement4() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.setNoNl(true);
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.printElement("Name");

    // Assert
    assertEquals(71L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, Object)}
   */
  @Test
  public void testPrintElement5() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Element Name", "Value");

    // Assert
    assertEquals(35L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, Object)}
   */
  @Test
  public void testPrintElement6() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new PipedOutputStream());

    // Act
    xmlPrintStream.printElement("Element Name", "Value");

    // Assert
    assertEquals(34L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, Object)}
   */
  @Test
  public void testPrintElement7() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.printElement("Element Name", "Value");

    // Assert
    assertEquals(99L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, Object)}
   */
  @Test
  public void testPrintElement8() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.setNoNl(true);
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.printElement("Element Name", "Value");

    // Assert
    assertEquals(98L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, Object)}
   */
  @Test
  public void testPrintElement9() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Element Name", "<");

    // Assert
    assertEquals(34L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, Object)}
   */
  @Test
  public void testPrintElement10() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Element Name", ">");

    // Assert
    assertEquals(34L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, Object)}
   */
  @Test
  public void testPrintElement11() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Element Name", (Object) null);

    // Assert
    assertEquals(30L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElement12() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Element Name", "42", new HashMap<>());

    // Assert
    assertEquals(32L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElement13() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new PipedOutputStream());

    // Act
    xmlPrintStream.printElement("Element Name", "42", new HashMap<>());

    // Assert
    assertEquals(13L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElement14() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Element Name", "<", new HashMap<>());

    // Assert
    assertEquals(34L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElement15() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Element Name", ">", new HashMap<>());

    // Assert
    assertEquals(34L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElement16() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Element Name", null, new HashMap<>());

    // Assert
    assertEquals(16L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElement17() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("42", "42");

    // Act
    xmlPrintStream.printElement("Element Name", "42", attributes);

    // Assert
    assertEquals(40L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElement18() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.computeIfPresent("42", mock(BiFunction.class));
    attributes.put("42", "42");

    // Act
    xmlPrintStream.printElement("Element Name", "42", attributes);

    // Assert
    assertEquals(40L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElement19() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("", "42");

    // Act
    xmlPrintStream.printElement("Element Name", "42", attributes);

    // Assert
    assertEquals(38L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElement20() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("42", null);

    // Act
    xmlPrintStream.printElement("Element Name", "42", attributes);

    // Assert
    assertEquals(36L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElement21() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("42", XMLAttribute.of("<", XMLAttribute.Format.STANDARD));

    // Act
    xmlPrintStream.printElement("Element Name", "42", attributes);

    // Assert
    assertEquals(42L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElement22() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("42", "=\"");

    // Act
    xmlPrintStream.printElement("Element Name", "42", attributes);

    // Assert
    assertEquals(45L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElement23() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Name", "42", "Attributes");

    // Assert
    assertEquals(31L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElement24() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new PipedOutputStream());

    // Act
    xmlPrintStream.printElement("Name", "42", "Attributes");

    // Assert
    assertEquals(5L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElement25() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.printElement("Name", "42", "Attributes");

    // Assert
    assertEquals(95L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElement26() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.setPrintOffsets(true);
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.printElement("Name", "42", "Attributes");

    // Assert
    assertEquals(95L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElement27() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.setNoIndent(true);
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.printElement("Name", "42", "Attributes");

    // Assert
    assertEquals(93L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElement28() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.setNoNl(true);
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.printElement("Name", "42", "Attributes");

    // Assert
    assertEquals(92L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElement29() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Name", "<", "Attributes");

    // Assert
    assertEquals(33L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElement30() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Name", ">", "Attributes");

    // Assert
    assertEquals(33L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElement31() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Name", null, "Attributes");

    // Assert
    assertEquals(23L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElement32() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Name", "42", "Attributes", "Attributes");

    // Assert
    assertEquals(42L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElement33() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Element Name", (Map<?, ?>) new HashMap<>());

    // Assert
    assertEquals(16L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElement34() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new PipedOutputStream());

    // Act
    xmlPrintStream.printElement("Element Name", (Map<?, ?>) new HashMap<>());

    // Assert
    assertEquals(13L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElement35() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("42", "42");

    // Act
    xmlPrintStream.printElement("Element Name", (Map<?, ?>) attributes);

    // Assert
    assertEquals(24L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElement36() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.computeIfPresent("42", mock(BiFunction.class));
    attributes.put("42", "42");

    // Act
    xmlPrintStream.printElement("Element Name", (Map<?, ?>) attributes);

    // Assert
    assertEquals(24L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElement37() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("", "42");

    // Act
    xmlPrintStream.printElement("Element Name", (Map<?, ?>) attributes);

    // Assert
    assertEquals(22L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElement38() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("42", "<");

    // Act
    xmlPrintStream.printElement("Element Name", (Map<?, ?>) attributes);

    // Assert
    assertEquals(26L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElement39() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("42", null);

    // Act
    xmlPrintStream.printElement("Element Name", (Map<?, ?>) attributes);

    // Assert
    assertEquals(20L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElement40() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("42", XMLAttribute.of("<", XMLAttribute.Format.STANDARD));

    // Act
    xmlPrintStream.printElement("Element Name", (Map<?, ?>) attributes);

    // Assert
    assertEquals(26L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElement41() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("42", "=\"");

    // Act
    xmlPrintStream.printElement("Element Name", (Map<?, ?>) attributes);

    // Assert
    assertEquals(29L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElement42() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    HashMap<Object, Object> attributes = new HashMap<>();
    attributes.put("42", "/>");

    // Act
    xmlPrintStream.printElement("Element Name", (Map<?, ?>) attributes);

    // Assert
    assertEquals(27L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printComment(String)}
   */
  @Test
  public void testPrintComment() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printComment("Comment");

    // Assert
    assertEquals(17L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printComment(String)}
   */
  @Test
  public void testPrintComment2() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new PipedOutputStream());

    // Act
    xmlPrintStream.printComment("Comment");

    // Assert
    assertEquals(16L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printComment(String)}
   */
  @Test
  public void testPrintComment3() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.printComment("Comment");

    // Assert
    assertEquals(81L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#printComment(String)}
   */
  @Test
  public void testPrintComment4() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.setNoNl(true);
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.printComment("Comment");

    // Assert
    assertEquals(80L, xmlPrintStream.getOffset());
  }

  /**
   * Method under test: {@link XmlPrintStream#escape(String)}
   */
  @Test
  public void testEscape() {
    // Arrange, Act and Assert
    assertEquals("In", (new XmlPrintStream(new ByteArrayOutputStream(1))).escape("In"));
    assertEquals("/&gt;", (new XmlPrintStream(new ByteArrayOutputStream(1))).escape("/>"));
    assertEquals("In", (new XmlPrintStream(new ByteArrayOutputStream(1))).escape("In", XMLAttribute.Format.STANDARD));
    assertEquals("/&gt;",
        (new XmlPrintStream(new ByteArrayOutputStream(1))).escape("/>", XMLAttribute.Format.STANDARD));
  }

  /**
   * Method under test: {@link XmlPrintStream#removeNewLines(String)}
   */
  @Test
  public void testRemoveNewLines() {
    // Arrange, Act and Assert
    assertEquals("Not all who wander are lost", XmlPrintStream.removeNewLines("Not all who wander are lost"));
    assertEquals("", XmlPrintStream.removeNewLines(null));
  }

  /**
   * Method under test: {@link XmlPrintStream#XmlPrintStream(OutputStream)}
   */
  @Test
  public void testNewXmlPrintStream() {
    // Arrange and Act
    XmlPrintStream actualXmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Assert
    assertNull(actualXmlPrintStream.getLinePrefix());
    assertEquals(0L, actualXmlPrintStream.getOffset());
    assertFalse(actualXmlPrintStream.getPrintOffsets());
    assertFalse(actualXmlPrintStream.isNoIndent());
    assertFalse(actualXmlPrintStream.isNoNl());
    assertTrue(actualXmlPrintStream.isRemoveNl());
  }

  /**
   * Method under test: {@link XmlPrintStream#XmlPrintStream(OutputStream)}
   */
  @Test
  public void testNewXmlPrintStream2() {
    // Arrange and Act
    XmlPrintStream actualXmlPrintStream = new XmlPrintStream(new CountedOutputStream(new ByteArrayOutputStream(1)));

    // Assert
    assertNull(actualXmlPrintStream.getLinePrefix());
    assertEquals(0L, actualXmlPrintStream.getOffset());
    assertFalse(actualXmlPrintStream.getPrintOffsets());
    assertFalse(actualXmlPrintStream.isNoIndent());
    assertFalse(actualXmlPrintStream.isNoNl());
    assertTrue(actualXmlPrintStream.isRemoveNl());
  }
}
