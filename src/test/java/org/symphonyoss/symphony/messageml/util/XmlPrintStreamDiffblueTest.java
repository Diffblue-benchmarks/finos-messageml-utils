package org.symphonyoss.symphony.messageml.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.junit.Ignore;
import org.junit.Test;

public class XmlPrintStreamDiffblueTest {
  /**
   * Test {@link XmlPrintStream#XmlPrintStream(OutputStream)}.
   * <ul>
   *   <li>When {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlPrintStream#XmlPrintStream(OutputStream)}
   */
  @Test
  public void testNewXmlPrintStream_whenByteArrayOutputStreamWithOne() {
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
   * Test {@link XmlPrintStream#XmlPrintStream(OutputStream)}.
   * <ul>
   *   <li>When {@link CountedOutputStream#CountedOutputStream(OutputStream)} with
   * out is {@link ByteArrayOutputStream#ByteArrayOutputStream(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlPrintStream#XmlPrintStream(OutputStream)}
   */
  @Test
  public void testNewXmlPrintStream_whenCountedOutputStreamWithOutIsByteArrayOutputStream() {
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

  /**
   * Test {@link XmlPrintStream#openElement(String)} with {@code String}.
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String)}
   */
  @Test
  public void testOpenElementWithString() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.openElement("Name");

    // Assert
    assertEquals(7L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#openElement(String)} with {@code String}.
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String)}
   */
  @Test
  public void testOpenElementWithString2() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new PipedOutputStream());

    // Act
    xmlPrintStream.openElement("Name");

    // Assert
    assertEquals(6L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#openElement(String)} with {@code String}.
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String)}
   */
  @Test
  public void testOpenElementWithString3() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.openElement("Name");

    // Assert
    assertEquals(71L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#openElement(String)} with {@code String}.
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String)}
   */
  @Test
  public void testOpenElementWithString4() {
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
   * Test {@link XmlPrintStream#openElement(String, Map)} with {@code String},
   * {@code Map}.
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElementWithStringMap() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.openElement("Name", new HashMap<>());

    // Assert
    assertEquals(7L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#openElement(String, Map)} with {@code String},
   * {@code Map}.
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElementWithStringMap2() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new PipedOutputStream());

    // Act
    xmlPrintStream.openElement("Name", new HashMap<>());

    // Assert
    assertEquals(5L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#openElement(String, Map)} with {@code String},
   * {@code Map}.
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElementWithStringMap3() {
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
   * Test {@link XmlPrintStream#openElement(String, Map)} with {@code String},
   * {@code Map}.
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElementWithStringMap4() {
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
   * Test {@link XmlPrintStream#openElement(String, Map)} with {@code String},
   * {@code Map}.
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElementWithStringMap5() {
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
   * Test {@link XmlPrintStream#openElement(String, Map)} with {@code String},
   * {@code Map}.
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElementWithStringMap6() {
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
   * Test {@link XmlPrintStream#openElement(String, Map)} with {@code String},
   * {@code Map}.
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElementWithStringMap7() {
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
   * Test {@link XmlPrintStream#openElement(String, Map)} with {@code String},
   * {@code Map}.
   * <ul>
   *   <li>Given {@code >}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code >}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElementWithStringMap_givenGreaterThanSign_whenHashMap42IsGreaterThanSign() {
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
   * Test {@link XmlPrintStream#openElement(String, Map)} with {@code String},
   * {@code Map}.
   * <ul>
   *   <li>Given {@code <}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code <}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String, Map)}
   */
  @Test
  public void testOpenElementWithStringMap_givenLessThanSign_whenHashMap42IsLessThanSign() {
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
   * Test {@link XmlPrintStream#openElement(String, Object[])} with
   * {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String, Object[])}
   */
  @Test
  public void testOpenElementWithStringObject() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.openElement("Name", "Attributes");

    // Assert
    assertEquals(22L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#openElement(String, Object[])} with
   * {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String, Object[])}
   */
  @Test
  public void testOpenElementWithStringObject2() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new PipedOutputStream());

    // Act
    xmlPrintStream.openElement("Name", "Attributes");

    // Assert
    assertEquals(5L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#openElement(String, Object[])} with
   * {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String, Object[])}
   */
  @Test
  public void testOpenElementWithStringObject3() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.openElement("Name", "Attributes");

    // Assert
    assertEquals(86L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#openElement(String, Object[])} with
   * {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String, Object[])}
   */
  @Test
  public void testOpenElementWithStringObject4() {
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
   * Test {@link XmlPrintStream#openElement(String, Object[])} with
   * {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String, Object[])}
   */
  @Test
  public void testOpenElementWithStringObject5() {
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
   * Test {@link XmlPrintStream#openElement(String, Object[])} with
   * {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String, Object[])}
   */
  @Test
  public void testOpenElementWithStringObject6() {
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
   * Test {@link XmlPrintStream#openElement(String, Object[])} with
   * {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link XmlPrintStream#openElement(String, Object[])}
   */
  @Test
  public void testOpenElementWithStringObject7() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.openElement("Name", "Attributes", "Attributes");

    // Assert
    assertEquals(33L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#closeElement()}.
   * <ul>
   *   <li>Given {@link XmlPrintStream#XmlPrintStream(OutputStream)} with
   * outputStream is
   * {@link ByteArrayOutputStream#ByteArrayOutputStream(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlPrintStream#closeElement()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCloseElement_givenXmlPrintStreamWithOutputStreamIsByteArrayOutputStream() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.util.NoSuchElementException
    //       at java.base/java.util.LinkedList.removeFirst(LinkedList.java:274)
    //       at java.base/java.util.LinkedList.pop(LinkedList.java:805)
    //       at org.symphonyoss.symphony.messageml.util.XmlPrintStream.closeElement(XmlPrintStream.java:106)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new XmlPrintStream(new ByteArrayOutputStream(1))).closeElement();
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, Map)} with
   * {@code elementName}, {@code attributes}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameAttributes() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Element Name", (Map<?, ?>) new HashMap<>());

    // Assert
    assertEquals(16L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, Map)} with
   * {@code elementName}, {@code attributes}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameAttributes2() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new PipedOutputStream());

    // Act
    xmlPrintStream.printElement("Element Name", (Map<?, ?>) new HashMap<>());

    // Assert
    assertEquals(13L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, Map)} with
   * {@code elementName}, {@code attributes}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameAttributes3() {
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
   * Test {@link XmlPrintStream#printElement(String, Map)} with
   * {@code elementName}, {@code attributes}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameAttributes4() {
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
   * Test {@link XmlPrintStream#printElement(String, Map)} with
   * {@code elementName}, {@code attributes}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameAttributes5() {
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
   * Test {@link XmlPrintStream#printElement(String, Map)} with
   * {@code elementName}, {@code attributes}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameAttributes6() {
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
   * Test {@link XmlPrintStream#printElement(String, Map)} with
   * {@code elementName}, {@code attributes}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameAttributes7() {
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
   * Test {@link XmlPrintStream#printElement(String, Map)} with
   * {@code elementName}, {@code attributes}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameAttributes8() {
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
   * Test {@link XmlPrintStream#printElement(String, Map)} with
   * {@code elementName}, {@code attributes}.
   * <ul>
   *   <li>Given {@code <}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameAttributes_givenLessThanSign() {
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
   * Test {@link XmlPrintStream#printElement(String, Object)} with
   * {@code elementName}, {@code value}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, Object)}
   */
  @Test
  public void testPrintElementWithElementNameValue() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Element Name", "Value");

    // Assert
    assertEquals(35L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, Object)} with
   * {@code elementName}, {@code value}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, Object)}
   */
  @Test
  public void testPrintElementWithElementNameValue2() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new PipedOutputStream());

    // Act
    xmlPrintStream.printElement("Element Name", "Value");

    // Assert
    assertEquals(34L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, Object)} with
   * {@code elementName}, {@code value}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, Object)}
   */
  @Test
  public void testPrintElementWithElementNameValue3() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.printElement("Element Name", "Value");

    // Assert
    assertEquals(99L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, Object)} with
   * {@code elementName}, {@code value}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, Object)}
   */
  @Test
  public void testPrintElementWithElementNameValue4() {
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
   * Test {@link XmlPrintStream#printElement(String, Object)} with
   * {@code elementName}, {@code value}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, Object)}
   */
  @Test
  public void testPrintElementWithElementNameValue5() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Element Name", (Object) null);

    // Assert
    assertEquals(30L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, String, Map)} with
   * {@code elementName}, {@code value}, {@code attributes}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameValueAttributes() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Element Name", "42", new HashMap<>());

    // Assert
    assertEquals(32L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, String, Map)} with
   * {@code elementName}, {@code value}, {@code attributes}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameValueAttributes2() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new PipedOutputStream());

    // Act
    xmlPrintStream.printElement("Element Name", "42", new HashMap<>());

    // Assert
    assertEquals(13L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, String, Map)} with
   * {@code elementName}, {@code value}, {@code attributes}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameValueAttributes3() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Element Name", null, new HashMap<>());

    // Assert
    assertEquals(16L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, String, Map)} with
   * {@code elementName}, {@code value}, {@code attributes}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameValueAttributes4() {
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
   * Test {@link XmlPrintStream#printElement(String, String, Map)} with
   * {@code elementName}, {@code value}, {@code attributes}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameValueAttributes5() {
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
   * Test {@link XmlPrintStream#printElement(String, String, Map)} with
   * {@code elementName}, {@code value}, {@code attributes}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameValueAttributes6() {
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
   * Test {@link XmlPrintStream#printElement(String, String, Map)} with
   * {@code elementName}, {@code value}, {@code attributes}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameValueAttributes7() {
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
   * Test {@link XmlPrintStream#printElement(String, String, Map)} with
   * {@code elementName}, {@code value}, {@code attributes}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameValueAttributes8() {
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
   * Test {@link XmlPrintStream#printElement(String, String, Map)} with
   * {@code elementName}, {@code value}, {@code attributes}.
   * <ul>
   *   <li>When {@code >}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameValueAttributes_whenGreaterThanSign() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Element Name", ">", new HashMap<>());

    // Assert
    assertEquals(34L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, String, Map)} with
   * {@code elementName}, {@code value}, {@code attributes}.
   * <ul>
   *   <li>When {@code <}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, String, Map)}
   */
  @Test
  public void testPrintElementWithElementNameValueAttributes_whenLessThanSign() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Element Name", "<", new HashMap<>());

    // Assert
    assertEquals(34L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, Object)} with
   * {@code elementName}, {@code value}.
   * <ul>
   *   <li>When {@code >}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, Object)}
   */
  @Test
  public void testPrintElementWithElementNameValue_whenGreaterThanSign() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Element Name", ">");

    // Assert
    assertEquals(34L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, Object)} with
   * {@code elementName}, {@code value}.
   * <ul>
   *   <li>When {@code <}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String, Object)}
   */
  @Test
  public void testPrintElementWithElementNameValue_whenLessThanSign() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Element Name", "<");

    // Assert
    assertEquals(34L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String)} with {@code name}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String)}
   */
  @Test
  public void testPrintElementWithName() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Name");

    // Assert
    assertEquals(8L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String)} with {@code name}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String)}
   */
  @Test
  public void testPrintElementWithName2() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new PipedOutputStream());

    // Act
    xmlPrintStream.printElement("Name");

    // Assert
    assertEquals(7L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String)} with {@code name}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String)}
   */
  @Test
  public void testPrintElementWithName3() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.printElement("Name");

    // Assert
    assertEquals(72L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String)} with {@code name}.
   * <p>
   * Method under test: {@link XmlPrintStream#printElement(String)}
   */
  @Test
  public void testPrintElementWithName4() {
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
   * Test {@link XmlPrintStream#printElement(String, String, Object[])} with
   * {@code name}, {@code value}, {@code attributes}.
   * <p>
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElementWithNameValueAttributes() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Name", "42", "Attributes");

    // Assert
    assertEquals(31L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, String, Object[])} with
   * {@code name}, {@code value}, {@code attributes}.
   * <p>
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElementWithNameValueAttributes2() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new PipedOutputStream());

    // Act
    xmlPrintStream.printElement("Name", "42", "Attributes");

    // Assert
    assertEquals(5L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, String, Object[])} with
   * {@code name}, {@code value}, {@code attributes}.
   * <p>
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElementWithNameValueAttributes3() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));
    xmlPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    xmlPrintStream.printElement("Name", "42", "Attributes");

    // Assert
    assertEquals(95L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, String, Object[])} with
   * {@code name}, {@code value}, {@code attributes}.
   * <p>
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElementWithNameValueAttributes4() {
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
   * Test {@link XmlPrintStream#printElement(String, String, Object[])} with
   * {@code name}, {@code value}, {@code attributes}.
   * <p>
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElementWithNameValueAttributes5() {
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
   * Test {@link XmlPrintStream#printElement(String, String, Object[])} with
   * {@code name}, {@code value}, {@code attributes}.
   * <p>
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElementWithNameValueAttributes6() {
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
   * Test {@link XmlPrintStream#printElement(String, String, Object[])} with
   * {@code name}, {@code value}, {@code attributes}.
   * <p>
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElementWithNameValueAttributes7() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Name", null, "Attributes");

    // Assert
    assertEquals(23L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, String, Object[])} with
   * {@code name}, {@code value}, {@code attributes}.
   * <p>
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElementWithNameValueAttributes8() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Name", "42", "Attributes", "Attributes");

    // Assert
    assertEquals(42L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, String, Object[])} with
   * {@code name}, {@code value}, {@code attributes}.
   * <ul>
   *   <li>When {@code >}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElementWithNameValueAttributes_whenGreaterThanSign() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Name", ">", "Attributes");

    // Assert
    assertEquals(33L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printElement(String, String, Object[])} with
   * {@code name}, {@code value}, {@code attributes}.
   * <ul>
   *   <li>When {@code <}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link XmlPrintStream#printElement(String, String, Object[])}
   */
  @Test
  public void testPrintElementWithNameValueAttributes_whenLessThanSign() {
    // Arrange
    XmlPrintStream xmlPrintStream = new XmlPrintStream(new ByteArrayOutputStream(1));

    // Act
    xmlPrintStream.printElement("Name", "<", "Attributes");

    // Assert
    assertEquals(33L, xmlPrintStream.getOffset());
  }

  /**
   * Test {@link XmlPrintStream#printComment(String)}.
   * <p>
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
   * Test {@link XmlPrintStream#printComment(String)}.
   * <p>
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
   * Test {@link XmlPrintStream#printComment(String)}.
   * <p>
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
   * Test {@link XmlPrintStream#printComment(String)}.
   * <p>
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
   * Test {@link XmlPrintStream#escape(String, Format)} with {@code in},
   * {@code format}.
   * <ul>
   *   <li>When {@code In}.</li>
   *   <li>Then return {@code In}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlPrintStream#escape(String, XMLAttribute.Format)}
   */
  @Test
  public void testEscapeWithInFormat_whenIn_thenReturnIn() {
    // Arrange, Act and Assert
    assertEquals("In", (new XmlPrintStream(new ByteArrayOutputStream(1))).escape("In", XMLAttribute.Format.STANDARD));
  }

  /**
   * Test {@link XmlPrintStream#escape(String, Format)} with {@code in},
   * {@code format}.
   * <ul>
   *   <li>When {@code />}.</li>
   *   <li>Then return {@code /&gt;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlPrintStream#escape(String, XMLAttribute.Format)}
   */
  @Test
  public void testEscapeWithInFormat_whenSlashGreaterThanSign_thenReturnGt() {
    // Arrange, Act and Assert
    assertEquals("/&gt;",
        (new XmlPrintStream(new ByteArrayOutputStream(1))).escape("/>", XMLAttribute.Format.STANDARD));
  }

  /**
   * Test {@link XmlPrintStream#escape(String)} with {@code in}.
   * <ul>
   *   <li>When {@code In}.</li>
   *   <li>Then return {@code In}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlPrintStream#escape(String)}
   */
  @Test
  public void testEscapeWithIn_whenIn_thenReturnIn() {
    // Arrange, Act and Assert
    assertEquals("In", (new XmlPrintStream(new ByteArrayOutputStream(1))).escape("In"));
  }

  /**
   * Test {@link XmlPrintStream#escape(String)} with {@code in}.
   * <ul>
   *   <li>When {@code />}.</li>
   *   <li>Then return {@code /&gt;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlPrintStream#escape(String)}
   */
  @Test
  public void testEscapeWithIn_whenSlashGreaterThanSign_thenReturnGt() {
    // Arrange, Act and Assert
    assertEquals("/&gt;", (new XmlPrintStream(new ByteArrayOutputStream(1))).escape("/>"));
  }

  /**
   * Test {@link XmlPrintStream#removeNewLines(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlPrintStream#removeNewLines(String)}
   */
  @Test
  public void testRemoveNewLines_whenNotAllWhoWanderAreLost_thenReturnNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertEquals("Not all who wander are lost", XmlPrintStream.removeNewLines("Not all who wander are lost"));
  }

  /**
   * Test {@link XmlPrintStream#removeNewLines(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlPrintStream#removeNewLines(String)}
   */
  @Test
  public void testRemoveNewLines_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", XmlPrintStream.removeNewLines(null));
  }
}
