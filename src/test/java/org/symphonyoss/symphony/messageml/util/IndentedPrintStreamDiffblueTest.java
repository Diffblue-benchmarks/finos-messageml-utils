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
   * Method under test: {@link IndentedPrintStream#setLinePrefix(String)}
   */
  @Test
  public void testSetLinePrefix2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.setLinePrefix(null);

    // Assert
    assertNull(indentedPrintStream.getLinePrefix());
  }

  /**
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
   * Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  public void testPrintAlignedBlock4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.align("");

    // Act
    indentedPrintStream.printAlignedBlock();

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  public void testPrintAlignedBlock5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.align();

    // Act
    indentedPrintStream.printAlignedBlock();

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  public void testPrintAlignedBlock6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.align("42", "42");

    // Act
    indentedPrintStream.printAlignedBlock();

    // Assert
    assertEquals(11L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  public void testPrintAlignedBlock7() {
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
   * Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  public void testPrintAlignedBlock8() {
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
   * Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  public void testOpenBlock5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.openBlock("foo");

    // Assert
    assertEquals(6L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  public void testOpenBlock6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.openBlock("foo");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  public void testOpenBlock7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.openBlock("foo");

    // Assert
    assertEquals(70L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  public void testOpenBlock8() {
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
   * Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  public void testOpenBlock9() {
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
   * Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  public void testOpenBlock10() {
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
   * Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  public void testOpenBlock11() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.openBlock("");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
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
   * Method under test: {@link IndentedPrintStream#closeBlock(String)}
   */
  @Test
  public void testCloseBlock5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.closeBlock("foo");

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#closeBlock(String)}
   */
  @Test
  public void testCloseBlock6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.closeBlock("foo");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#closeBlock(String)}
   */
  @Test
  public void testCloseBlock7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.closeBlock("foo");

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#closeBlock(String)}
   */
  @Test
  public void testCloseBlock8() {
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
   * Method under test: {@link IndentedPrintStream#print(char)}
   */
  @Test
  public void testPrint() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print('A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(char)}
   */
  @Test
  public void testPrint2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print('A');

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(char)}
   */
  @Test
  public void testPrint3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print('A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(char)}
   */
  @Test
  public void testPrint4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print('A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(double)}
   */
  @Test
  public void testPrint5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(10.0d);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(double)}
   */
  @Test
  public void testPrint6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(10.0d);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(float)}
   */
  @Test
  public void testPrint7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(10.0f);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(float)}
   */
  @Test
  public void testPrint8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(10.0f);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int)}
   */
  @Test
  public void testPrint9() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int)}
   */
  @Test
  public void testPrint10() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int)}
   */
  @Test
  public void testPrint11() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int)}
   */
  @Test
  public void testPrint12() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(1);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, char)}
   */
  @Test
  public void testPrint13() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, 'A');

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, char)}
   */
  @Test
  public void testPrint14() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, 'A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, char)}
   */
  @Test
  public void testPrint15() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, 'A');

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, double)}
   */
  @Test
  public void testPrint16() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, 10.0d);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, double)}
   */
  @Test
  public void testPrint17() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, 10.0d);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, double)}
   */
  @Test
  public void testPrint18() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, 10.0d);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, float)}
   */
  @Test
  public void testPrint19() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, 10.0f);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, float)}
   */
  @Test
  public void testPrint20() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, 10.0f);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, float)}
   */
  @Test
  public void testPrint21() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, 10.0f);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, int)}
   */
  @Test
  public void testPrint22() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, 1);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, int)}
   */
  @Test
  public void testPrint23() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, 1);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, int)}
   */
  @Test
  public void testPrint24() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, 1);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, long)}
   */
  @Test
  public void testPrint25() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, 1L);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, long)}
   */
  @Test
  public void testPrint26() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, 1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, long)}
   */
  @Test
  public void testPrint27() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, 1L);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, Object)}
   */
  @Test
  public void testPrint28() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, (Object) "Obj");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, Object)}
   */
  @Test
  public void testPrint29() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, (Object) "Obj");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, Object)}
   */
  @Test
  public void testPrint30() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, (Object) "Obj");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, Object)}
   */
  @Test
  public void testPrint31() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, (Object) "");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, String)}
   */
  @Test
  public void testPrint32() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, "foo");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, String)}
   */
  @Test
  public void testPrint33() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, "foo");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, String)}
   */
  @Test
  public void testPrint34() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, "foo");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, String)}
   */
  @Test
  public void testPrint35() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, "");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, String, Object[])}
   */
  @Test
  public void testPrint36() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, "Pattern", "Arguments");

    // Assert
    assertEquals(8L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, String, Object[])}
   */
  @Test
  public void testPrint37() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, "Pattern", "Arguments");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, String, Object[])}
   */
  @Test
  public void testPrint38() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, "Pattern", "Arguments");

    // Assert
    assertEquals(71L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, String, Object[])}
   */
  @Test
  public void testPrint39() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, "", "Arguments");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, boolean)}
   */
  @Test
  public void testPrint40() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, true);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, boolean)}
   */
  @Test
  public void testPrint41() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, true);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, boolean)}
   */
  @Test
  public void testPrint42() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, true);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, char[])}
   */
  @Test
  public void testPrint43() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, char[])}
   */
  @Test
  public void testPrint44() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, char[])}
   */
  @Test
  public void testPrint45() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(int, char[])}
   */
  @Test
  public void testPrint46() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1, new char[]{});

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(long)}
   */
  @Test
  public void testPrint47() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(long)}
   */
  @Test
  public void testPrint48() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1L);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(long)}
   */
  @Test
  public void testPrint49() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(long)}
   */
  @Test
  public void testPrint50() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(Object)}
   */
  @Test
  public void testPrint51() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print((Object) "Obj");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(Object)}
   */
  @Test
  public void testPrint52() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print((Object) "Obj");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(Object)}
   */
  @Test
  public void testPrint53() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print((Object) "");

    // Assert
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(String)}
   */
  @Test
  public void testPrint54() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print("foo");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(String)}
   */
  @Test
  public void testPrint55() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print("foo");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(String)}
   */
  @Test
  public void testPrint56() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print("");

    // Assert
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(String, Object[])}
   */
  @Test
  public void testPrint57() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print("Pattern", "Arguments");

    // Assert
    assertEquals(7L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(String, Object[])}
   */
  @Test
  public void testPrint58() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print("Pattern", "Arguments");

    // Assert
    assertEquals(71L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(String, Object[])}
   */
  @Test
  public void testPrint59() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print("", "Arguments");

    // Assert
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(boolean)}
   */
  @Test
  public void testPrint60() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(true);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(boolean)}
   */
  @Test
  public void testPrint61() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(true);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(char[])}
   */
  @Test
  public void testPrint62() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print("AZAZ".toCharArray());

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(char[])}
   */
  @Test
  public void testPrint63() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print("AZAZ".toCharArray());

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#print(char[])}
   */
  @Test
  public void testPrint64() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.print(new char[]{});

    // Assert
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
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
   * Method under test: {@link IndentedPrintStream#println(char)}
   */
  @Test
  public void testPrintln2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println('A');

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(char)}
   */
  @Test
  public void testPrintln3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println('A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(char)}
   */
  @Test
  public void testPrintln4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println('A');

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(double)}
   */
  @Test
  public void testPrintln5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(2.0d);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(double)}
   */
  @Test
  public void testPrintln6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(2.0d);

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(double)}
   */
  @Test
  public void testPrintln7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(2.0d);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(double)}
   */
  @Test
  public void testPrintln8() {
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
   * Method under test: {@link IndentedPrintStream#println(float)}
   */
  @Test
  public void testPrintln9() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(10.0f);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(float)}
   */
  @Test
  public void testPrintln10() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(10.0f);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(float)}
   */
  @Test
  public void testPrintln11() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(10.0f);

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(float)}
   */
  @Test
  public void testPrintln12() {
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
   * Method under test: {@link IndentedPrintStream#println(int)}
   */
  @Test
  public void testPrintln13() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(2);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int)}
   */
  @Test
  public void testPrintln14() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(2);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int)}
   */
  @Test
  public void testPrintln15() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(2);

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int)}
   */
  @Test
  public void testPrintln16() {
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
   * Method under test: {@link IndentedPrintStream#println(int, char)}
   */
  @Test
  public void testPrintln17() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, 'A');

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, char)}
   */
  @Test
  public void testPrintln18() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, 'A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, char)}
   */
  @Test
  public void testPrintln19() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 'A');

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, double)}
   */
  @Test
  public void testPrintln20() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, 2.0d);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, double)}
   */
  @Test
  public void testPrintln21() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, 2.0d);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, double)}
   */
  @Test
  public void testPrintln22() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 2.0d);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, double)}
   */
  @Test
  public void testPrintln23() {
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
   * Method under test: {@link IndentedPrintStream#println(int, float)}
   */
  @Test
  public void testPrintln24() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, 10.0f);

    // Assert
    assertEquals(6L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, float)}
   */
  @Test
  public void testPrintln25() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, 10.0f);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, float)}
   */
  @Test
  public void testPrintln26() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 10.0f);

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, float)}
   */
  @Test
  public void testPrintln27() {
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
   * Method under test: {@link IndentedPrintStream#println(int, int)}
   */
  @Test
  public void testPrintln28() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, 2);

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, int)}
   */
  @Test
  public void testPrintln29() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, 2);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, int)}
   */
  @Test
  public void testPrintln30() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 2);

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, int)}
   */
  @Test
  public void testPrintln31() {
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
   * Method under test: {@link IndentedPrintStream#println(int, long)}
   */
  @Test
  public void testPrintln32() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, 1L);

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, long)}
   */
  @Test
  public void testPrintln33() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, 1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, long)}
   */
  @Test
  public void testPrintln34() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 1L);

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, long)}
   */
  @Test
  public void testPrintln35() {
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
   * Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  public void testPrintln36() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, (Object) "42");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  public void testPrintln37() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, (Object) "42");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  public void testPrintln38() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, (Object) "42");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  public void testPrintln39() {
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
   * Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  public void testPrintln40() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, (Object) "");

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  public void testPrintln41() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, "foo");

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  public void testPrintln42() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, "foo");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  public void testPrintln43() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, "foo");

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  public void testPrintln44() {
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
   * Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  public void testPrintln45() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, "");

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  public void testPrintln46() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, "Pattern", "Arguments");

    // Assert
    assertEquals(9L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  public void testPrintln47() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, "Pattern", "Arguments");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  public void testPrintln48() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, "Pattern", "Arguments");

    // Assert
    assertEquals(72L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  public void testPrintln49() {
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
   * Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  public void testPrintln50() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, "", "Arguments");

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, boolean)}
   */
  @Test
  public void testPrintln51() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, true);

    // Assert
    assertEquals(6L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, boolean)}
   */
  @Test
  public void testPrintln52() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, true);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, boolean)}
   */
  @Test
  public void testPrintln53() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, true);

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, boolean)}
   */
  @Test
  public void testPrintln54() {
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
   * Method under test: {@link IndentedPrintStream#println(int, char[])}
   */
  @Test
  public void testPrintln55() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(6L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, char[])}
   */
  @Test
  public void testPrintln56() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, char[])}
   */
  @Test
  public void testPrintln57() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(int, char[])}
   */
  @Test
  public void testPrintln58() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1, new char[]{});

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(long)}
   */
  @Test
  public void testPrintln59() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(1L);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(long)}
   */
  @Test
  public void testPrintln60() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(long)}
   */
  @Test
  public void testPrintln61() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1L);

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(long)}
   */
  @Test
  public void testPrintln62() {
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
   * Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  public void testPrintln63() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println((Object) "42");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  public void testPrintln64() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println((Object) "42");

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  public void testPrintln65() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println((Object) "42");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  public void testPrintln66() {
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
   * Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  public void testPrintln67() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println((Object) "");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  public void testPrintln68() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println("foo");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  public void testPrintln69() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println("foo");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  public void testPrintln70() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println("foo");

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  public void testPrintln71() {
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
   * Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  public void testPrintln72() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println("");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  public void testPrintln73() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println("Pattern", "Arguments");

    // Assert
    assertEquals(8L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  public void testPrintln74() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println("Pattern", "Arguments");

    // Assert
    assertEquals(7L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  public void testPrintln75() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println("Pattern", "Arguments");

    // Assert
    assertEquals(72L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  public void testPrintln76() {
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
   * Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  public void testPrintln77() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println("", "Arguments");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  public void testPrintln78() {
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
   * Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  public void testPrintln79() {
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
   * Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  public void testPrintln80() {
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
   * Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  public void testPrintln81() {
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
   * Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  public void testPrintln82() {
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
   * Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  public void testPrintln83() {
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
   * Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  public void testPrintln84() {
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
   * Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  public void testPrintln85() {
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
   * Method under test: {@link IndentedPrintStream#println(boolean)}
   */
  @Test
  public void testPrintln86() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(true);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(boolean)}
   */
  @Test
  public void testPrintln87() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(true);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(boolean)}
   */
  @Test
  public void testPrintln88() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(true);

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(boolean)}
   */
  @Test
  public void testPrintln89() {
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
   * Method under test: {@link IndentedPrintStream#println(char[])}
   */
  @Test
  public void testPrintln90() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println("AZAZ".toCharArray());

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(char[])}
   */
  @Test
  public void testPrintln91() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println("AZAZ".toCharArray());

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(char[])}
   */
  @Test
  public void testPrintln92() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println("AZAZ".toCharArray());

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#println(char[])}
   */
  @Test
  public void testPrintln93() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream(1));

    // Act
    indentedPrintStream.println(new char[]{});

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
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
   * Method under test: {@link IndentedPrintStream#getOffset()}
   */
  @Test
  public void testGetOffset() {
    // Arrange, Act and Assert
    assertEquals(0L, (new IndentedPrintStream(new ByteArrayOutputStream(1))).getOffset());
  }

  /**
   * Method under test: {@link IndentedPrintStream#isoNlCr()}
   */
  @Test
  public void testIsoNlCr() {
    // Arrange, Act and Assert
    assertFalse((new IndentedPrintStream(new ByteArrayOutputStream(1))).isoNlCr());
  }

  /**
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
    indentedPrintStream.getLinePrefix();
    boolean actualPrintOffsets = indentedPrintStream.getPrintOffsets();
    boolean actualIsNoIndentResult = indentedPrintStream.isNoIndent();
    boolean actualIsNoNlResult = indentedPrintStream.isNoNl();

    // Assert that nothing has changed
    assertTrue(actualPrintOffsets);
    assertTrue(actualIsNoIndentResult);
    assertTrue(actualIsNoNlResult);
    assertTrue(indentedPrintStream.isRemoveNl());
  }

  /**
   * Method under test:
   * {@link IndentedPrintStream#IndentedPrintStream(OutputStream)}
   */
  @Test
  public void testNewIndentedPrintStream() {
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
   * Method under test:
   * {@link IndentedPrintStream#IndentedPrintStream(OutputStream)}
   */
  @Test
  public void testNewIndentedPrintStream2() {
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
}
