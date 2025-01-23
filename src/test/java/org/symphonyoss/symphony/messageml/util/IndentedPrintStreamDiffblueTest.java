package org.symphonyoss.symphony.messageml.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;

public class IndentedPrintStreamDiffblueTest {
  /**
   * Test {@link IndentedPrintStream#IndentedPrintStream(OutputStream)}.
   * <ul>
   *   <li>When {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndentedPrintStream#IndentedPrintStream(OutputStream)}
   */
  @Test
  public void testNewIndentedPrintStream_whenByteArrayOutputStreamWithOne() {
    // Arrange and Act
    IndentedPrintStream actualIndentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Assert
    assertNull(actualIndentedPrintStream.getLinePrefix());
    assertEquals(0L, actualIndentedPrintStream.getOffset());
    assertFalse(actualIndentedPrintStream.getPrintOffsets());
    assertFalse(actualIndentedPrintStream.isNoIndent());
    assertFalse(actualIndentedPrintStream.isNoNl());
    assertTrue(actualIndentedPrintStream.isRemoveNl());
  }

  /**
   * Test {@link IndentedPrintStream#IndentedPrintStream(OutputStream)}.
   * <ul>
   *   <li>When {@link CountedOutputStream#CountedOutputStream(OutputStream)} with
   * out is {@link ByteArrayOutputStream#ByteArrayOutputStream(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IndentedPrintStream#IndentedPrintStream(OutputStream)}
   */
  @Test
  public void testNewIndentedPrintStream_whenCountedOutputStreamWithOutIsByteArrayOutputStream() {
    // Arrange and Act
    IndentedPrintStream actualIndentedPrintStream = new IndentedPrintStream(
        new CountedOutputStream(new ByteArrayOutputStream(1)));

    // Assert
    assertNull(actualIndentedPrintStream.getLinePrefix());
    assertEquals(0L, actualIndentedPrintStream.getOffset());
    assertFalse(actualIndentedPrintStream.getPrintOffsets());
    assertFalse(actualIndentedPrintStream.isNoIndent());
    assertFalse(actualIndentedPrintStream.isNoNl());
    assertTrue(actualIndentedPrintStream.isRemoveNl());
  }

  /**
   * Test {@link IndentedPrintStream#setLinePrefix(String)}.
   * <p>
   * Method under test: {@link IndentedPrintStream#setLinePrefix(String)}
   */
  @Test
  public void testSetLinePrefix() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.setLinePrefix("Line Prefix");

    // Assert
    assertEquals("Line Prefix", indentedPrintStream.getLinePrefix());
  }

  /**
   * Test {@link IndentedPrintStream#setLinePrefix(String)}.
   * <p>
   * Method under test: {@link IndentedPrintStream#setLinePrefix(String)}
   */
  @Test
  public void testSetLinePrefix2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.setLinePrefix(null);

    // Assert that nothing has changed
    assertNull(indentedPrintStream.getLinePrefix());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IndentedPrintStream#setNoIndent(boolean)}
   *   <li>{@link IndentedPrintStream#setNoNl(boolean)}
   *   <li>{@link IndentedPrintStream#setPrintOffsets(boolean)}
   *   <li>{@link IndentedPrintStream#setRemoveNl(boolean)}
   *   <li>{@link IndentedPrintStream#indent()}
   *   <li>{@link IndentedPrintStream#outdent()}
   *   <li>{@link IndentedPrintStream#setoNlCr(boolean)}
   *   <li>{@link IndentedPrintStream#getLinePrefix()}
   *   <li>{@link IndentedPrintStream#getPrintOffsets()}
   *   <li>{@link IndentedPrintStream#isNoIndent()}
   *   <li>{@link IndentedPrintStream#isNoNl()}
   *   <li>{@link IndentedPrintStream#isRemoveNl()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.setNoIndent(true);
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.setPrintOffsets(true);
    indentedPrintStream.setRemoveNl(true);
    indentedPrintStream.indent();
    indentedPrintStream.outdent();
    indentedPrintStream.setoNlCr(true);
    String actualLinePrefix = indentedPrintStream.getLinePrefix();
    boolean actualPrintOffsets = indentedPrintStream.getPrintOffsets();
    boolean actualIsNoIndentResult = indentedPrintStream.isNoIndent();
    boolean actualIsNoNlResult = indentedPrintStream.isNoNl();

    // Assert
    assertNull(actualLinePrefix);
    assertTrue(actualPrintOffsets);
    assertTrue(actualIsNoIndentResult);
    assertTrue(actualIsNoNlResult);
    assertTrue(indentedPrintStream.isRemoveNl());
  }

  /**
   * Test {@link IndentedPrintStream#printAlignedBlock()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  public void testPrintAlignedBlock() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.printAlignedBlock();

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printAlignedBlock()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  public void testPrintAlignedBlock2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.align("42");

    // Act
    indentedPrintStream.printAlignedBlock();

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printAlignedBlock()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  public void testPrintAlignedBlock3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);
    indentedPrintStream.align("42");

    // Act
    indentedPrintStream.printAlignedBlock();

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printAlignedBlock()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  public void testPrintAlignedBlock4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.align();

    // Act
    indentedPrintStream.printAlignedBlock();

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printAlignedBlock()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  public void testPrintAlignedBlock5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.align("42", "42");

    // Act
    indentedPrintStream.printAlignedBlock();

    // Assert
    assertEquals(11L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printAlignedBlock()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  public void testPrintAlignedBlock6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setPrintOffsets(true);
    indentedPrintStream.align("42");

    // Act
    indentedPrintStream.printAlignedBlock();

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printAlignedBlock()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  public void testPrintAlignedBlock7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoIndent(true);
    indentedPrintStream.align("42");

    // Act
    indentedPrintStream.printAlignedBlock();

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printAlignedBlock()}.
   * <ul>
   *   <li>Given array of {@link Object} with empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  public void testPrintAlignedBlock_givenArrayOfObjectWithEmptyString() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.align("");

    // Act
    indentedPrintStream.printAlignedBlock();

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#openBlock()}
   */
  @Test
  public void testOpenBlock() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.openBlock();

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#openBlock()}
   */
  @Test
  public void testOpenBlock2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.openBlock();

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#openBlock()}
   */
  @Test
  public void testOpenBlock3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.openBlock();

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#openBlock()}
   */
  @Test
  public void testOpenBlock4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.openBlock();

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  public void testOpenBlockWithString() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.openBlock("foo");

    // Assert
    assertEquals(6L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  public void testOpenBlockWithString2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.openBlock("foo");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  public void testOpenBlockWithString3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.openBlock("foo");

    // Assert
    assertEquals(70L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  public void testOpenBlockWithString4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setPrintOffsets(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.openBlock("foo");

    // Assert
    assertEquals(70L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  public void testOpenBlockWithString5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoIndent(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.openBlock("foo");

    // Assert
    assertEquals(70L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  public void testOpenBlockWithString6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.openBlock("foo");

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  public void testOpenBlockWithString7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.openBlock("");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#closeBlock()}
   */
  @Test
  public void testCloseBlock() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.closeBlock();

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#closeBlock()}
   */
  @Test
  public void testCloseBlock2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.closeBlock();

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#closeBlock()}
   */
  @Test
  public void testCloseBlock3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.closeBlock();

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#closeBlock()}
   */
  @Test
  public void testCloseBlock4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.closeBlock();

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#closeBlock(String)}
   */
  @Test
  public void testCloseBlockWithString() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.closeBlock("foo");

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#closeBlock(String)}
   */
  @Test
  public void testCloseBlockWithString2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.closeBlock("foo");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#closeBlock(String)}
   */
  @Test
  public void testCloseBlockWithString3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.closeBlock("foo");

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#closeBlock(String)}
   */
  @Test
  public void testCloseBlockWithString4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.closeBlock("foo");

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#continueBlock(String)}.
   * <p>
   * Method under test: {@link IndentedPrintStream#continueBlock(String)}
   */
  @Test
  public void testContinueBlock() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.continueBlock("foo");

    // Assert
    assertEquals(8L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#continueBlock(String)}.
   * <p>
   * Method under test: {@link IndentedPrintStream#continueBlock(String)}
   */
  @Test
  public void testContinueBlock2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.continueBlock("foo");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#continueBlock(String)}.
   * <p>
   * Method under test: {@link IndentedPrintStream#continueBlock(String)}
   */
  @Test
  public void testContinueBlock3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.continueBlock("foo");

    // Assert
    assertEquals(72L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#continueBlock(String)}.
   * <p>
   * Method under test: {@link IndentedPrintStream#continueBlock(String)}
   */
  @Test
  public void testContinueBlock4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setPrintOffsets(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.continueBlock("foo");

    // Assert
    assertEquals(72L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#continueBlock(String)}.
   * <p>
   * Method under test: {@link IndentedPrintStream#continueBlock(String)}
   */
  @Test
  public void testContinueBlock5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoIndent(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.continueBlock("foo");

    // Assert
    assertEquals(72L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#continueBlock(String)}.
   * <p>
   * Method under test: {@link IndentedPrintStream#continueBlock(String)}
   */
  @Test
  public void testContinueBlock6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.continueBlock("foo");

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#continueBlock(String)}.
   * <p>
   * Method under test: {@link IndentedPrintStream#continueBlock(String)}
   */
  @Test
  public void testContinueBlock7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.continueBlock("");

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(boolean)}
   */
  @Test
  public void testPrintWithBoolean() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(true);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(boolean)}
   */
  @Test
  public void testPrintWithBoolean2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(true);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char)} with {@code char}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(char)}
   */
  @Test
  public void testPrintWithChar() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print('A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char)} with {@code char}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(char)}
   */
  @Test
  public void testPrintWithChar2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print('A');

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char)} with {@code char}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(char)}
   */
  @Test
  public void testPrintWithChar3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print('A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char)} with {@code char}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(char)}
   */
  @Test
  public void testPrintWithChar4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print('A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char[])} with {@code char[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(char[])}
   */
  @Test
  public void testPrintWithChar5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print("AZAZ".toCharArray());

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char[])} with {@code char[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(char[])}
   */
  @Test
  public void testPrintWithChar6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print("AZAZ".toCharArray());

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char[])} with {@code char[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(char[])}
   */
  @Test
  public void testPrintWithChar7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(new char[]{});

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(double)} with {@code double}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(double)}
   */
  @Test
  public void testPrintWithDouble() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(10.0d);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(double)} with {@code double}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(double)}
   */
  @Test
  public void testPrintWithDouble2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(10.0d);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(float)} with {@code float}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(float)}
   */
  @Test
  public void testPrintWithFloat() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(10.0f);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(float)} with {@code float}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(float)}
   */
  @Test
  public void testPrintWithFloat2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(10.0f);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int)} with {@code int}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int)}
   */
  @Test
  public void testPrintWithInt() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int)} with {@code int}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int)}
   */
  @Test
  public void testPrintWithInt2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int)} with {@code int}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int)}
   */
  @Test
  public void testPrintWithInt3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(1);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, boolean)} with {@code int},
   * {@code boolean}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, boolean)}
   */
  @Test
  public void testPrintWithIntBoolean() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, true);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, boolean)} with {@code int},
   * {@code boolean}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, boolean)}
   */
  @Test
  public void testPrintWithIntBoolean2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, true);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, boolean)} with {@code int},
   * {@code boolean}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, boolean)}
   */
  @Test
  public void testPrintWithIntBoolean3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, true);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char)} with {@code int},
   * {@code char}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, char)}
   */
  @Test
  public void testPrintWithIntChar() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, 'A');

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char)} with {@code int},
   * {@code char}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, char)}
   */
  @Test
  public void testPrintWithIntChar2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, 'A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char)} with {@code int},
   * {@code char}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, char)}
   */
  @Test
  public void testPrintWithIntChar3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, 'A');

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char[])} with {@code int},
   * {@code char[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, char[])}
   */
  @Test
  public void testPrintWithIntChar4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char[])} with {@code int},
   * {@code char[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, char[])}
   */
  @Test
  public void testPrintWithIntChar5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char[])} with {@code int},
   * {@code char[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, char[])}
   */
  @Test
  public void testPrintWithIntChar6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char[])} with {@code int},
   * {@code char[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, char[])}
   */
  @Test
  public void testPrintWithIntChar7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, new char[]{});

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, double)} with {@code int},
   * {@code double}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, double)}
   */
  @Test
  public void testPrintWithIntDouble() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, 10.0d);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, double)} with {@code int},
   * {@code double}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, double)}
   */
  @Test
  public void testPrintWithIntDouble2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, 10.0d);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, double)} with {@code int},
   * {@code double}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, double)}
   */
  @Test
  public void testPrintWithIntDouble3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, 10.0d);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, float)} with {@code int},
   * {@code float}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, float)}
   */
  @Test
  public void testPrintWithIntFloat() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, 10.0f);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, float)} with {@code int},
   * {@code float}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, float)}
   */
  @Test
  public void testPrintWithIntFloat2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, 10.0f);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, float)} with {@code int},
   * {@code float}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, float)}
   */
  @Test
  public void testPrintWithIntFloat3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, 10.0f);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, int)} with {@code int},
   * {@code int}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, int)}
   */
  @Test
  public void testPrintWithIntInt() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, 1);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, int)} with {@code int},
   * {@code int}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, int)}
   */
  @Test
  public void testPrintWithIntInt2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, 1);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, int)} with {@code int},
   * {@code int}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, int)}
   */
  @Test
  public void testPrintWithIntInt3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, 1);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, long)} with {@code int},
   * {@code long}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, long)}
   */
  @Test
  public void testPrintWithIntLong() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, 1L);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, long)} with {@code int},
   * {@code long}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, long)}
   */
  @Test
  public void testPrintWithIntLong2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, 1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, long)} with {@code int},
   * {@code long}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, long)}
   */
  @Test
  public void testPrintWithIntLong3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, 1L);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, Object)} with {@code int},
   * {@code Object}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, Object)}
   */
  @Test
  public void testPrintWithIntObject() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, (Object) "Obj");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, Object)} with {@code int},
   * {@code Object}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, Object)}
   */
  @Test
  public void testPrintWithIntObject2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, (Object) "Obj");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, Object)} with {@code int},
   * {@code Object}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, Object)}
   */
  @Test
  public void testPrintWithIntObject3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, (Object) "Obj");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, Object)} with {@code int},
   * {@code Object}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, Object)}
   */
  @Test
  public void testPrintWithIntObject4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, (Object) "");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String)} with {@code int},
   * {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, String)}
   */
  @Test
  public void testPrintWithIntString() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, "foo");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String)} with {@code int},
   * {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, String)}
   */
  @Test
  public void testPrintWithIntString2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, "foo");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String)} with {@code int},
   * {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, String)}
   */
  @Test
  public void testPrintWithIntString3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, "foo");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String)} with {@code int},
   * {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, String)}
   */
  @Test
  public void testPrintWithIntString4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, "");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String, Object[])} with
   * {@code int}, {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, String, Object[])}
   */
  @Test
  public void testPrintWithIntStringObject() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, "Pattern", "Arguments");

    // Assert
    assertEquals(8L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String, Object[])} with
   * {@code int}, {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, String, Object[])}
   */
  @Test
  public void testPrintWithIntStringObject2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, "Pattern", "Arguments");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String, Object[])} with
   * {@code int}, {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, String, Object[])}
   */
  @Test
  public void testPrintWithIntStringObject3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, "Pattern", "Arguments");

    // Assert
    assertEquals(71L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String, Object[])} with
   * {@code int}, {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int, String, Object[])}
   */
  @Test
  public void testPrintWithIntStringObject4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, "", "Arguments");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int)} with {@code int}.
   * <ul>
   *   <li>Given {@link IndentedPrintStream#IndentedPrintStream(OutputStream)} with
   * outputStream is
   * {@link ByteArrayOutputStream#ByteArrayOutputStream(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndentedPrintStream#print(int)}
   */
  @Test
  public void testPrintWithInt_givenIndentedPrintStreamWithOutputStreamIsByteArrayOutputStream() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(long)} with {@code long}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(long)}
   */
  @Test
  public void testPrintWithLong() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(long)} with {@code long}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(long)}
   */
  @Test
  public void testPrintWithLong2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1L);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(long)} with {@code long}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(long)}
   */
  @Test
  public void testPrintWithLong3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(long)} with {@code long}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(long)}
   */
  @Test
  public void testPrintWithLong4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(Object)} with {@code Object}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(Object)}
   */
  @Test
  public void testPrintWithObject() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print((Object) "Obj");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(Object)} with {@code Object}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(Object)}
   */
  @Test
  public void testPrintWithObject2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print((Object) "Obj");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(Object)} with {@code Object}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(Object)}
   */
  @Test
  public void testPrintWithObject3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print((Object) "");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(String)}
   */
  @Test
  public void testPrintWithString() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print("foo");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(String)}
   */
  @Test
  public void testPrintWithString2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print("foo");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(String)}
   */
  @Test
  public void testPrintWithString3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print("");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String, Object[])} with {@code String},
   * {@code Object[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(String, Object[])}
   */
  @Test
  public void testPrintWithStringObject() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print("Pattern", "Arguments");

    // Assert
    assertEquals(7L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String, Object[])} with {@code String},
   * {@code Object[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(String, Object[])}
   */
  @Test
  public void testPrintWithStringObject2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print("Pattern", "Arguments");

    // Assert
    assertEquals(71L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String, Object[])} with {@code String},
   * {@code Object[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#print(String, Object[])}
   */
  @Test
  public void testPrintWithStringObject3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print("", "Arguments");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println()}
   */
  @Test
  public void testPrintln() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println();

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println()}
   */
  @Test
  public void testPrintln2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println();

    // Assert that nothing has changed
    assertEquals(64L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(boolean)}
   */
  @Test
  public void testPrintlnWithBoolean() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(true);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(boolean)}
   */
  @Test
  public void testPrintlnWithBoolean2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(true);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(boolean)}
   */
  @Test
  public void testPrintlnWithBoolean3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(true);

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(boolean)}
   */
  @Test
  public void testPrintlnWithBoolean4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(true);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char)} with {@code char}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(char)}
   */
  @Test
  public void testPrintlnWithChar() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println('A');

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char)} with {@code char}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(char)}
   */
  @Test
  public void testPrintlnWithChar2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println('A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char)} with {@code char}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(char)}
   */
  @Test
  public void testPrintlnWithChar3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println('A');

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char[])} with {@code char[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(char[])}
   */
  @Test
  public void testPrintlnWithChar4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println("AZAZ".toCharArray());

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char[])} with {@code char[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(char[])}
   */
  @Test
  public void testPrintlnWithChar5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println("AZAZ".toCharArray());

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char[])} with {@code char[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(char[])}
   */
  @Test
  public void testPrintlnWithChar6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println("AZAZ".toCharArray());

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char[])} with {@code char[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(char[])}
   */
  @Test
  public void testPrintlnWithChar7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(new char[]{});

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Collection)} with {@code Collection}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  public void testPrintlnWithCollection() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    ArrayList<String> str = new ArrayList<>();
    str.add("foo");

    // Act
    indentedPrintStream.println((Collection<String>) str);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Collection)} with {@code Collection}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  public void testPrintlnWithCollection2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    ArrayList<String> str = new ArrayList<>();
    str.add("42");
    str.add("foo");

    // Act
    indentedPrintStream.println((Collection<String>) str);

    // Assert
    assertEquals(7L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Collection)} with {@code Collection}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  public void testPrintlnWithCollection3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    ArrayList<String> str = new ArrayList<>();
    str.add("");

    // Act
    indentedPrintStream.println((Collection<String>) str);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Collection)} with {@code Collection}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  public void testPrintlnWithCollection4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    ArrayList<String> str = new ArrayList<>();
    str.add("foo");

    // Act
    indentedPrintStream.println((Collection<String>) str);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Collection)} with {@code Collection}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  public void testPrintlnWithCollection5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    ArrayList<String> str = new ArrayList<>();
    str.add("foo");

    // Act
    indentedPrintStream.println((Collection<String>) str);

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Collection)} with {@code Collection}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  public void testPrintlnWithCollection6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setPrintOffsets(true);

    ArrayList<String> str = new ArrayList<>();
    str.add("foo");

    // Act
    indentedPrintStream.println((Collection<String>) str);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Collection)} with {@code Collection}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  public void testPrintlnWithCollection7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoIndent(true);

    ArrayList<String> str = new ArrayList<>();
    str.add("foo");

    // Act
    indentedPrintStream.println((Collection<String>) str);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Collection)} with {@code Collection}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  public void testPrintlnWithCollection8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    ArrayList<String> str = new ArrayList<>();
    str.add("");
    str.add("foo");

    // Act
    indentedPrintStream.println((Collection<String>) str);

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(double)} with {@code double}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(double)}
   */
  @Test
  public void testPrintlnWithDouble() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(2.0d);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(double)} with {@code double}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(double)}
   */
  @Test
  public void testPrintlnWithDouble2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(2.0d);

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(double)} with {@code double}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(double)}
   */
  @Test
  public void testPrintlnWithDouble3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(2.0d);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(double)} with {@code double}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(double)}
   */
  @Test
  public void testPrintlnWithDouble4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(2.0d);

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(float)} with {@code float}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(float)}
   */
  @Test
  public void testPrintlnWithFloat() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(10.0f);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(float)} with {@code float}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(float)}
   */
  @Test
  public void testPrintlnWithFloat2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(10.0f);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(float)} with {@code float}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(float)}
   */
  @Test
  public void testPrintlnWithFloat3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(10.0f);

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(float)} with {@code float}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(float)}
   */
  @Test
  public void testPrintlnWithFloat4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(10.0f);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int)} with {@code int}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int)}
   */
  @Test
  public void testPrintlnWithInt() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(2);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int)} with {@code int}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int)}
   */
  @Test
  public void testPrintlnWithInt2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(2);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int)} with {@code int}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int)}
   */
  @Test
  public void testPrintlnWithInt3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(2);

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int)} with {@code int}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int)}
   */
  @Test
  public void testPrintlnWithInt4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(2);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, boolean)} with {@code int},
   * {@code boolean}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, boolean)}
   */
  @Test
  public void testPrintlnWithIntBoolean() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, true);

    // Assert
    assertEquals(6L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, boolean)} with {@code int},
   * {@code boolean}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, boolean)}
   */
  @Test
  public void testPrintlnWithIntBoolean2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, true);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, boolean)} with {@code int},
   * {@code boolean}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, boolean)}
   */
  @Test
  public void testPrintlnWithIntBoolean3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, true);

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, boolean)} with {@code int},
   * {@code boolean}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, boolean)}
   */
  @Test
  public void testPrintlnWithIntBoolean4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, true);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char)} with {@code int},
   * {@code char}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, char)}
   */
  @Test
  public void testPrintlnWithIntChar() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, 'A');

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char)} with {@code int},
   * {@code char}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, char)}
   */
  @Test
  public void testPrintlnWithIntChar2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, 'A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char)} with {@code int},
   * {@code char}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, char)}
   */
  @Test
  public void testPrintlnWithIntChar3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 'A');

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char[])} with {@code int},
   * {@code char[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, char[])}
   */
  @Test
  public void testPrintlnWithIntChar4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(6L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char[])} with {@code int},
   * {@code char[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, char[])}
   */
  @Test
  public void testPrintlnWithIntChar5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char[])} with {@code int},
   * {@code char[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, char[])}
   */
  @Test
  public void testPrintlnWithIntChar6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char[])} with {@code int},
   * {@code char[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, char[])}
   */
  @Test
  public void testPrintlnWithIntChar7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, new char[]{});

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, double)} with {@code int},
   * {@code double}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, double)}
   */
  @Test
  public void testPrintlnWithIntDouble() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, 2.0d);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, double)} with {@code int},
   * {@code double}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, double)}
   */
  @Test
  public void testPrintlnWithIntDouble2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, 2.0d);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, double)} with {@code int},
   * {@code double}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, double)}
   */
  @Test
  public void testPrintlnWithIntDouble3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 2.0d);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, double)} with {@code int},
   * {@code double}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, double)}
   */
  @Test
  public void testPrintlnWithIntDouble4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 2.0d);

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, float)} with {@code int},
   * {@code float}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, float)}
   */
  @Test
  public void testPrintlnWithIntFloat() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, 10.0f);

    // Assert
    assertEquals(6L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, float)} with {@code int},
   * {@code float}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, float)}
   */
  @Test
  public void testPrintlnWithIntFloat2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, 10.0f);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, float)} with {@code int},
   * {@code float}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, float)}
   */
  @Test
  public void testPrintlnWithIntFloat3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 10.0f);

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, float)} with {@code int},
   * {@code float}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, float)}
   */
  @Test
  public void testPrintlnWithIntFloat4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 10.0f);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, int)} with {@code int},
   * {@code int}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, int)}
   */
  @Test
  public void testPrintlnWithIntInt() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, 2);

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, int)} with {@code int},
   * {@code int}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, int)}
   */
  @Test
  public void testPrintlnWithIntInt2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, 2);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, int)} with {@code int},
   * {@code int}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, int)}
   */
  @Test
  public void testPrintlnWithIntInt3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 2);

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, int)} with {@code int},
   * {@code int}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, int)}
   */
  @Test
  public void testPrintlnWithIntInt4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 2);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, long)} with {@code int},
   * {@code long}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, long)}
   */
  @Test
  public void testPrintlnWithIntLong() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, 1L);

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, long)} with {@code int},
   * {@code long}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, long)}
   */
  @Test
  public void testPrintlnWithIntLong2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, 1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, long)} with {@code int},
   * {@code long}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, long)}
   */
  @Test
  public void testPrintlnWithIntLong3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 1L);

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, long)} with {@code int},
   * {@code long}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, long)}
   */
  @Test
  public void testPrintlnWithIntLong4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 1L);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, Object)} with {@code int},
   * {@code Object}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  public void testPrintlnWithIntObject() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, (Object) "42");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, Object)} with {@code int},
   * {@code Object}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  public void testPrintlnWithIntObject2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, (Object) "42");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, Object)} with {@code int},
   * {@code Object}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  public void testPrintlnWithIntObject3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, (Object) "42");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, Object)} with {@code int},
   * {@code Object}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  public void testPrintlnWithIntObject4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, (Object) "42");

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, Object)} with {@code int},
   * {@code Object}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  public void testPrintlnWithIntObject5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, (Object) "");

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String)} with {@code int},
   * {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  public void testPrintlnWithIntString() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, "foo");

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String)} with {@code int},
   * {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  public void testPrintlnWithIntString2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, "foo");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String)} with {@code int},
   * {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  public void testPrintlnWithIntString3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, "foo");

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String)} with {@code int},
   * {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  public void testPrintlnWithIntString4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, "foo");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String)} with {@code int},
   * {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  public void testPrintlnWithIntString5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, "");

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String, Object[])} with
   * {@code int}, {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  public void testPrintlnWithIntStringObject() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, "Pattern", "Arguments");

    // Assert
    assertEquals(9L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String, Object[])} with
   * {@code int}, {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  public void testPrintlnWithIntStringObject2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, "Pattern", "Arguments");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String, Object[])} with
   * {@code int}, {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  public void testPrintlnWithIntStringObject3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, "Pattern", "Arguments");

    // Assert
    assertEquals(72L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String, Object[])} with
   * {@code int}, {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  public void testPrintlnWithIntStringObject4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, "Pattern", "Arguments");

    // Assert
    assertEquals(71L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String, Object[])} with
   * {@code int}, {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  public void testPrintlnWithIntStringObject5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, "", "Arguments");

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(long)} with {@code long}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(long)}
   */
  @Test
  public void testPrintlnWithLong() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1L);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(long)} with {@code long}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(long)}
   */
  @Test
  public void testPrintlnWithLong2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(long)} with {@code long}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(long)}
   */
  @Test
  public void testPrintlnWithLong3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1L);

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(long)} with {@code long}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(long)}
   */
  @Test
  public void testPrintlnWithLong4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1L);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Object)} with {@code Object}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  public void testPrintlnWithObject() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println((Object) "42");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Object)} with {@code Object}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  public void testPrintlnWithObject2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println((Object) "42");

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Object)} with {@code Object}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  public void testPrintlnWithObject3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println((Object) "42");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Object)} with {@code Object}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  public void testPrintlnWithObject4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println((Object) "42");

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Object)} with {@code Object}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  public void testPrintlnWithObject5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println((Object) "");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  public void testPrintlnWithString() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println("foo");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  public void testPrintlnWithString2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println("foo");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  public void testPrintlnWithString3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println("foo");

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  public void testPrintlnWithString4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println("foo");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String)} with {@code String}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  public void testPrintlnWithString5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println("");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String, Object[])} with
   * {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  public void testPrintlnWithStringObject() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println("Pattern", "Arguments");

    // Assert
    assertEquals(8L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String, Object[])} with
   * {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  public void testPrintlnWithStringObject2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println("Pattern", "Arguments");

    // Assert
    assertEquals(7L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String, Object[])} with
   * {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  public void testPrintlnWithStringObject3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println("Pattern", "Arguments");

    // Assert
    assertEquals(72L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String, Object[])} with
   * {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  public void testPrintlnWithStringObject4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println("Pattern", "Arguments");

    // Assert
    assertEquals(71L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String, Object[])} with
   * {@code String}, {@code Object[]}.
   * <p>
   * Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  public void testPrintlnWithStringObject5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println("", "Arguments");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printlines(String[])}.
   * <p>
   * Method under test: {@link IndentedPrintStream#printlines(String[])}
   */
  @Test
  public void testPrintlines() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.printlines("Strings");

    // Assert
    assertEquals(8L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printlines(String[])}.
   * <p>
   * Method under test: {@link IndentedPrintStream#printlines(String[])}
   */
  @Test
  public void testPrintlines2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.printlines("Strings");

    // Assert
    assertEquals(7L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printlines(String[])}.
   * <p>
   * Method under test: {@link IndentedPrintStream#printlines(String[])}
   */
  @Test
  public void testPrintlines3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.printlines("Strings");

    // Assert
    assertEquals(72L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printlines(String[])}.
   * <p>
   * Method under test: {@link IndentedPrintStream#printlines(String[])}
   */
  @Test
  public void testPrintlines4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.printlines("Strings");

    // Assert
    assertEquals(71L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printlines(String[])}.
   * <p>
   * Method under test: {@link IndentedPrintStream#printlines(String[])}
   */
  @Test
  public void testPrintlines5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.printlines("");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#forceNewLine()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#forceNewLine()}
   */
  @Test
  public void testForceNewLine() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.forceNewLine();

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#forceNewLine()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#forceNewLine()}
   */
  @Test
  public void testForceNewLine2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.forceNewLine();

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#forceNewLine()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#forceNewLine()}
   */
  @Test
  public void testForceNewLine3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.forceNewLine();

    // Assert that nothing has changed
    assertEquals(64L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#getOffset()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#getOffset()}
   */
  @Test
  public void testGetOffset() {
    // Arrange, Act and Assert
    assertEquals(0L, (new IndentedPrintStream(new ByteArrayOutputStream(1))).getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#isoNlCr()}.
   * <p>
   * Method under test: {@link IndentedPrintStream#isoNlCr()}
   */
  @Test
  public void testIsoNlCr() {
    // Arrange, Act and Assert
    assertFalse((new IndentedPrintStream(new ByteArrayOutputStream(1))).isoNlCr());
  }
}
