package org.symphonyoss.symphony.messageml.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IndentedPrintStreamDiffblueTest {
  /**
   * Test {@link IndentedPrintStream#IndentedPrintStream(OutputStream)}.
   *
   * <ul>
   *   <li>When {@link ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link IndentedPrintStream#IndentedPrintStream(OutputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.<init>(OutputStream)"})
  public void testNewIndentedPrintStream_whenByteArrayOutputStream() {
    // Arrange and Act
    IndentedPrintStream actualIndentedPrintStream =
        new IndentedPrintStream(new ByteArrayOutputStream());

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
   *
   * <ul>
   *   <li>When {@link CountedOutputStream#CountedOutputStream(OutputStream)} with out is {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link IndentedPrintStream#IndentedPrintStream(OutputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.<init>(OutputStream)"})
  public void testNewIndentedPrintStream_whenCountedOutputStreamWithOutIsByteArrayOutputStream() {
    // Arrange and Act
    IndentedPrintStream actualIndentedPrintStream =
        new IndentedPrintStream(new CountedOutputStream(new ByteArrayOutputStream()));

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
   *
   * <p>Method under test: {@link IndentedPrintStream#setLinePrefix(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.setLinePrefix(String)"})
  public void testSetLinePrefix() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.setLinePrefix("Line Prefix");

    // Assert
    assertEquals("Line Prefix", indentedPrintStream.getLinePrefix());
  }

  /**
   * Test {@link IndentedPrintStream#setLinePrefix(String)}.
   *
   * <p>Method under test: {@link IndentedPrintStream#setLinePrefix(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.setLinePrefix(String)"})
  public void testSetLinePrefix2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.setLinePrefix(null);

    // Assert that nothing has changed
    assertNull(indentedPrintStream.getLinePrefix());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String IndentedPrintStream.getLinePrefix()",
    "boolean IndentedPrintStream.getPrintOffsets()",
    "void IndentedPrintStream.indent()",
    "boolean IndentedPrintStream.isNoIndent()",
    "boolean IndentedPrintStream.isNoNl()",
    "boolean IndentedPrintStream.isRemoveNl()",
    "void IndentedPrintStream.outdent()",
    "void IndentedPrintStream.setNoIndent(boolean)",
    "void IndentedPrintStream.setNoNl(boolean)",
    "void IndentedPrintStream.setPrintOffsets(boolean)",
    "void IndentedPrintStream.setRemoveNl(boolean)",
    "void IndentedPrintStream.setoNlCr(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

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
   *
   * <p>Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.printAlignedBlock()"})
  public void testPrintAlignedBlock() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.printAlignedBlock();

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printAlignedBlock()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.printAlignedBlock()"})
  public void testPrintAlignedBlock2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.align("42");

    // Act
    indentedPrintStream.printAlignedBlock();

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printAlignedBlock()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.printAlignedBlock()"})
  public void testPrintAlignedBlock3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.align();

    // Act
    indentedPrintStream.printAlignedBlock();

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printAlignedBlock()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.printAlignedBlock()"})
  public void testPrintAlignedBlock4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.align("42", "42");

    // Act
    indentedPrintStream.printAlignedBlock();

    // Assert
    assertEquals(11L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printAlignedBlock()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.printAlignedBlock()"})
  public void testPrintAlignedBlock5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);
    indentedPrintStream.align("42", "42");

    // Act
    indentedPrintStream.printAlignedBlock();

    // Assert
    assertEquals(11L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printAlignedBlock()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.printAlignedBlock()"})
  public void testPrintAlignedBlock6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);
    indentedPrintStream.align("42", "42");

    // Act
    indentedPrintStream.printAlignedBlock();

    // Assert
    assertEquals(11L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printAlignedBlock()}.
   *
   * <ul>
   *   <li>Given array of {@link Object} with empty string.
   * </ul>
   *
   * <p>Method under test: {@link IndentedPrintStream#printAlignedBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.printAlignedBlock()"})
  public void testPrintAlignedBlock_givenArrayOfObjectWithEmptyString() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.align("");

    // Act
    indentedPrintStream.printAlignedBlock();

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#openBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.openBlock()"})
  public void testOpenBlock() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.openBlock();

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#openBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.openBlock()"})
  public void testOpenBlock2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.openBlock();

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#openBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.openBlock()"})
  public void testOpenBlock3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.openBlock();

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#openBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.openBlock()"})
  public void testOpenBlock4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.openBlock();

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#openBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.openBlock()"})
  public void testOpenBlock5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.openBlock();

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#openBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.openBlock()"})
  public void testOpenBlock6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.openBlock();

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.openBlock(String)"})
  public void testOpenBlockWithString() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.openBlock("foo");

    // Assert
    assertEquals(6L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.openBlock(String)"})
  public void testOpenBlockWithString2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.openBlock("foo");

    // Assert
    assertEquals(70L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.openBlock(String)"})
  public void testOpenBlockWithString3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.openBlock("foo");

    // Assert
    assertEquals(70L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.openBlock(String)"})
  public void testOpenBlockWithString4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.openBlock("foo");

    // Assert
    assertEquals(70L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.openBlock(String)"})
  public void testOpenBlockWithString5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.openBlock("foo");

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.openBlock(String)"})
  public void testOpenBlockWithString6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.openBlock("");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.openBlock(String)"})
  public void testOpenBlockWithString7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.openBlock("");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.openBlock(String)"})
  public void testOpenBlockWithString8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.openBlock("foo");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.openBlock(String)"})
  public void testOpenBlockWithString9() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.openBlock("foo");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#openBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.openBlock(String)"})
  public void testOpenBlockWithString10() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.openBlock("foo");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock()}.
   *
   * <ul>
   *   <li>Given {@link IndentedPrintStream#IndentedPrintStream(OutputStream)} with outputStream is
   *       {@link ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link IndentedPrintStream#openBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.openBlock()"})
  public void testOpenBlock_givenIndentedPrintStreamWithOutputStreamIsByteArrayOutputStream() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.openBlock();

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#openBlock()}.
   *
   * <ul>
   *   <li>Given {@link IndentedPrintStream#IndentedPrintStream(OutputStream)} with outputStream is
   *       {@link PipedOutputStream#PipedOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link IndentedPrintStream#openBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.openBlock()"})
  public void testOpenBlock_givenIndentedPrintStreamWithOutputStreamIsPipedOutputStream() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.openBlock();

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#closeBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.closeBlock()"})
  public void testCloseBlock() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.closeBlock();

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#closeBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.closeBlock()"})
  public void testCloseBlock2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.closeBlock();

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#closeBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.closeBlock()"})
  public void testCloseBlock3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.closeBlock();

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#closeBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.closeBlock()"})
  public void testCloseBlock4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.closeBlock();

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#closeBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.closeBlock()"})
  public void testCloseBlock5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.closeBlock();

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#closeBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.closeBlock()"})
  public void testCloseBlock6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.closeBlock();

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#closeBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.closeBlock(String)"})
  public void testCloseBlockWithString() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.closeBlock("foo");

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#closeBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.closeBlock(String)"})
  public void testCloseBlockWithString2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.closeBlock("foo");

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#closeBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.closeBlock(String)"})
  public void testCloseBlockWithString3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.closeBlock("foo");

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#closeBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.closeBlock(String)"})
  public void testCloseBlockWithString4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.closeBlock("foo");

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#closeBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.closeBlock(String)"})
  public void testCloseBlockWithString5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.closeBlock("foo");

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#closeBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.closeBlock(String)"})
  public void testCloseBlockWithString6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.closeBlock("foo");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#closeBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.closeBlock(String)"})
  public void testCloseBlockWithString7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.closeBlock("foo");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#closeBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.closeBlock(String)"})
  public void testCloseBlockWithString8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.closeBlock("foo");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock()}.
   *
   * <ul>
   *   <li>Given {@link IndentedPrintStream#IndentedPrintStream(OutputStream)} with outputStream is
   *       {@link ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link IndentedPrintStream#closeBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.closeBlock()"})
  public void testCloseBlock_givenIndentedPrintStreamWithOutputStreamIsByteArrayOutputStream() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.closeBlock();

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#closeBlock()}.
   *
   * <ul>
   *   <li>Given {@link IndentedPrintStream#IndentedPrintStream(OutputStream)} with outputStream is
   *       {@link PipedOutputStream#PipedOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link IndentedPrintStream#closeBlock()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.closeBlock()"})
  public void testCloseBlock_givenIndentedPrintStreamWithOutputStreamIsPipedOutputStream() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.closeBlock();

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#continueBlock(String)}.
   *
   * <p>Method under test: {@link IndentedPrintStream#continueBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.continueBlock(String)"})
  public void testContinueBlock() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.continueBlock("foo");

    // Assert
    assertEquals(8L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#continueBlock(String)}.
   *
   * <p>Method under test: {@link IndentedPrintStream#continueBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.continueBlock(String)"})
  public void testContinueBlock2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.continueBlock("foo");

    // Assert
    assertEquals(72L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#continueBlock(String)}.
   *
   * <p>Method under test: {@link IndentedPrintStream#continueBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.continueBlock(String)"})
  public void testContinueBlock3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.continueBlock("foo");

    // Assert
    assertEquals(72L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#continueBlock(String)}.
   *
   * <p>Method under test: {@link IndentedPrintStream#continueBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.continueBlock(String)"})
  public void testContinueBlock4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.continueBlock("foo");

    // Assert
    assertEquals(72L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#continueBlock(String)}.
   *
   * <p>Method under test: {@link IndentedPrintStream#continueBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.continueBlock(String)"})
  public void testContinueBlock5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.continueBlock("foo");

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#continueBlock(String)}.
   *
   * <p>Method under test: {@link IndentedPrintStream#continueBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.continueBlock(String)"})
  public void testContinueBlock6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.continueBlock("");

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#continueBlock(String)}.
   *
   * <p>Method under test: {@link IndentedPrintStream#continueBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.continueBlock(String)"})
  public void testContinueBlock7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.continueBlock("");

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#continueBlock(String)}.
   *
   * <p>Method under test: {@link IndentedPrintStream#continueBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.continueBlock(String)"})
  public void testContinueBlock8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.continueBlock("foo");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#continueBlock(String)}.
   *
   * <p>Method under test: {@link IndentedPrintStream#continueBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.continueBlock(String)"})
  public void testContinueBlock9() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.continueBlock("foo");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#continueBlock(String)}.
   *
   * <ul>
   *   <li>Given {@link IndentedPrintStream#IndentedPrintStream(OutputStream)} with outputStream is
   *       {@link PipedOutputStream#PipedOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link IndentedPrintStream#continueBlock(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.continueBlock(String)"})
  public void testContinueBlock_givenIndentedPrintStreamWithOutputStreamIsPipedOutputStream() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.continueBlock("foo");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(boolean)"})
  public void testPrintWithBoolean() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(true);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(boolean)"})
  public void testPrintWithBoolean2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(true);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(boolean)"})
  public void testPrintWithBoolean3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(true);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(boolean)"})
  public void testPrintWithBoolean4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(true);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(boolean)"})
  public void testPrintWithBoolean5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(true);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(boolean)"})
  public void testPrintWithBoolean6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(true);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char)} with {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(char)"})
  public void testPrintWithChar() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print('A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char)} with {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(char)"})
  public void testPrintWithChar2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print('A');

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char)} with {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(char)"})
  public void testPrintWithChar3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print('A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char)} with {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(char)"})
  public void testPrintWithChar4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print('A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char)} with {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(char)"})
  public void testPrintWithChar5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print('A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char)} with {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(char)"})
  public void testPrintWithChar6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print('A');

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char[])} with {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(char[])"})
  public void testPrintWithChar7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print("AZAZ".toCharArray());

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char[])} with {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(char[])"})
  public void testPrintWithChar8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print("AZAZ".toCharArray());

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char[])} with {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(char[])"})
  public void testPrintWithChar9() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print("AZAZ".toCharArray());

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char[])} with {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(char[])"})
  public void testPrintWithChar10() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print("AZAZ".toCharArray());

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char[])} with {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(char[])"})
  public void testPrintWithChar11() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(new char[] {});

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char[])} with {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(char[])"})
  public void testPrintWithChar12() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print("AZAZ".toCharArray());

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(char[])} with {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(char[])"})
  public void testPrintWithChar13() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print("AZAZ".toCharArray());

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(double)} with {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(double)"})
  public void testPrintWithDouble() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(10.0d);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(double)} with {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(double)"})
  public void testPrintWithDouble2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(10.0d);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(double)} with {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(double)"})
  public void testPrintWithDouble3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(10.0d);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(double)} with {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(double)"})
  public void testPrintWithDouble4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(10.0d);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(double)} with {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(double)"})
  public void testPrintWithDouble5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(10.0d);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(double)} with {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(double)"})
  public void testPrintWithDouble6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(10.0d);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(float)} with {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(float)"})
  public void testPrintWithFloat() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(10.0f);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(float)} with {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(float)"})
  public void testPrintWithFloat2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(10.0f);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(float)} with {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(float)"})
  public void testPrintWithFloat3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(10.0f);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(float)} with {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(float)"})
  public void testPrintWithFloat4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(10.0f);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(float)} with {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(float)"})
  public void testPrintWithFloat5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(10.0f);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(float)} with {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(float)"})
  public void testPrintWithFloat6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(10.0f);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int)} with {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int)"})
  public void testPrintWithInt() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int)} with {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int)"})
  public void testPrintWithInt2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int)} with {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int)"})
  public void testPrintWithInt3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(1);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int)} with {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int)"})
  public void testPrintWithInt4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int)} with {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int)"})
  public void testPrintWithInt5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, boolean)"})
  public void testPrintWithIntBoolean() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(1, true);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, boolean)"})
  public void testPrintWithIntBoolean2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, true);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, boolean)"})
  public void testPrintWithIntBoolean3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, true);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, boolean)"})
  public void testPrintWithIntBoolean4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(1, true);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, boolean)"})
  public void testPrintWithIntBoolean5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, true);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, boolean)"})
  public void testPrintWithIntBoolean6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, true);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char)} with {@code int}, {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, char)"})
  public void testPrintWithIntChar() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(1, 'A');

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char)} with {@code int}, {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, char)"})
  public void testPrintWithIntChar2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, 'A');

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char)} with {@code int}, {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, char)"})
  public void testPrintWithIntChar3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, 'A');

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char)} with {@code int}, {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, char)"})
  public void testPrintWithIntChar4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(1, 'A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char)} with {@code int}, {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, char)"})
  public void testPrintWithIntChar5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, 'A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char)} with {@code int}, {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, char)"})
  public void testPrintWithIntChar6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, 'A');

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char[])} with {@code int}, {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, char[])"})
  public void testPrintWithIntChar7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char[])} with {@code int}, {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, char[])"})
  public void testPrintWithIntChar8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char[])} with {@code int}, {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, char[])"})
  public void testPrintWithIntChar9() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char[])} with {@code int}, {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, char[])"})
  public void testPrintWithIntChar10() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char[])} with {@code int}, {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, char[])"})
  public void testPrintWithIntChar11() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(1, new char[] {});

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char[])} with {@code int}, {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, char[])"})
  public void testPrintWithIntChar12() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, char[])} with {@code int}, {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, char[])"})
  public void testPrintWithIntChar13() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, "AZAZ".toCharArray());

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, double)} with {@code int}, {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, double)"})
  public void testPrintWithIntDouble() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(1, 10.0d);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, double)} with {@code int}, {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, double)"})
  public void testPrintWithIntDouble2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, 10.0d);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, double)} with {@code int}, {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, double)"})
  public void testPrintWithIntDouble3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, 10.0d);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, double)} with {@code int}, {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, double)"})
  public void testPrintWithIntDouble4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(1, 10.0d);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, double)} with {@code int}, {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, double)"})
  public void testPrintWithIntDouble5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, 10.0d);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, double)} with {@code int}, {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, double)"})
  public void testPrintWithIntDouble6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, 10.0d);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, float)} with {@code int}, {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, float)"})
  public void testPrintWithIntFloat() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(1, 10.0f);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, float)} with {@code int}, {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, float)"})
  public void testPrintWithIntFloat2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, 10.0f);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, float)} with {@code int}, {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, float)"})
  public void testPrintWithIntFloat3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, 10.0f);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, float)} with {@code int}, {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, float)"})
  public void testPrintWithIntFloat4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(1, 10.0f);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, float)} with {@code int}, {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, float)"})
  public void testPrintWithIntFloat5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, 10.0f);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, float)} with {@code int}, {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, float)"})
  public void testPrintWithIntFloat6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, 10.0f);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, int)} with {@code int}, {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, int)"})
  public void testPrintWithIntInt() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(1, 1);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, int)} with {@code int}, {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, int)"})
  public void testPrintWithIntInt2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, 1);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, int)} with {@code int}, {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, int)"})
  public void testPrintWithIntInt3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, 1);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, int)} with {@code int}, {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, int)"})
  public void testPrintWithIntInt4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(1, 1);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, int)} with {@code int}, {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, int)"})
  public void testPrintWithIntInt5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, 1);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, int)} with {@code int}, {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, int)"})
  public void testPrintWithIntInt6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, 1);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, long)} with {@code int}, {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, long)"})
  public void testPrintWithIntLong() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(1, 1L);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, long)} with {@code int}, {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, long)"})
  public void testPrintWithIntLong2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, 1L);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, long)} with {@code int}, {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, long)"})
  public void testPrintWithIntLong3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, 1L);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, long)} with {@code int}, {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, long)"})
  public void testPrintWithIntLong4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(1, 1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, long)} with {@code int}, {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, long)"})
  public void testPrintWithIntLong5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, 1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, long)} with {@code int}, {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, long)"})
  public void testPrintWithIntLong6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, 1L);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, Object)} with {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, Object)"})
  public void testPrintWithIntObject() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(1, (Object) "Obj");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, Object)} with {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, Object)"})
  public void testPrintWithIntObject2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, (Object) "Obj");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, Object)} with {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, Object)"})
  public void testPrintWithIntObject3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, (Object) "Obj");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, Object)} with {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, Object)"})
  public void testPrintWithIntObject4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(1, (Object) "Obj");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, Object)} with {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, Object)"})
  public void testPrintWithIntObject5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(1, (Object) "");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, Object)} with {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, Object)"})
  public void testPrintWithIntObject6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, (Object) "Obj");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, Object)} with {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, Object)"})
  public void testPrintWithIntObject7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, (Object) "Obj");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, String)"})
  public void testPrintWithIntString() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(1, "foo");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, String)"})
  public void testPrintWithIntString2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, "foo");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, String)"})
  public void testPrintWithIntString3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, "foo");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, String)"})
  public void testPrintWithIntString4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(1, "foo");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, String)"})
  public void testPrintWithIntString5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(1, "");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, String)"})
  public void testPrintWithIntString6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, "foo");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, String)"})
  public void testPrintWithIntString7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, "foo");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String, Object[])} with {@code int}, {@code String},
   * {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, String, Object[])"})
  public void testPrintWithIntStringObject() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(1, "Pattern", "Arguments");

    // Assert
    assertEquals(8L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String, Object[])} with {@code int}, {@code String},
   * {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, String, Object[])"})
  public void testPrintWithIntStringObject2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1, "Pattern", "Arguments");

    // Assert
    assertEquals(71L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String, Object[])} with {@code int}, {@code String},
   * {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, String, Object[])"})
  public void testPrintWithIntStringObject3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, "Pattern", "Arguments");

    // Assert
    assertEquals(8L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String, Object[])} with {@code int}, {@code String},
   * {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, String, Object[])"})
  public void testPrintWithIntStringObject4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(1, "Pattern", "Arguments");

    // Assert
    assertEquals(7L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String, Object[])} with {@code int}, {@code String},
   * {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, String, Object[])"})
  public void testPrintWithIntStringObject5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(1, "", "Arguments");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String, Object[])} with {@code int}, {@code String},
   * {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, String, Object[])"})
  public void testPrintWithIntStringObject6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1, "Pattern", "Arguments");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int, String, Object[])} with {@code int}, {@code String},
   * {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int, String, Object[])"})
  public void testPrintWithIntStringObject7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1, "Pattern", "Arguments");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(int)} with {@code int}.
   *
   * <ul>
   *   <li>Given {@link IndentedPrintStream#IndentedPrintStream(OutputStream)} with outputStream is
   *       {@link ByteArrayOutputStream#ByteArrayOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link IndentedPrintStream#print(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(int)"})
  public void testPrintWithInt_givenIndentedPrintStreamWithOutputStreamIsByteArrayOutputStream() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(1);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(long)} with {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(long)"})
  public void testPrintWithLong() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print(1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(long)} with {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(long)"})
  public void testPrintWithLong2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print(1L);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(long)} with {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(long)"})
  public void testPrintWithLong3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(long)} with {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(long)"})
  public void testPrintWithLong4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print(1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(long)} with {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(long)"})
  public void testPrintWithLong5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print(1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(long)} with {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(long)"})
  public void testPrintWithLong6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print(1L);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(Object)"})
  public void testPrintWithObject() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print((Object) "Obj");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(Object)"})
  public void testPrintWithObject2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print((Object) "Obj");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(Object)"})
  public void testPrintWithObject3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print((Object) "Obj");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(Object)"})
  public void testPrintWithObject4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print((Object) "Obj");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(Object)"})
  public void testPrintWithObject5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print((Object) "");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(Object)"})
  public void testPrintWithObject6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print((Object) "Obj");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(Object)"})
  public void testPrintWithObject7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print((Object) "Obj");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(String)"})
  public void testPrintWithString() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print("foo");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(String)"})
  public void testPrintWithString2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print("foo");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(String)"})
  public void testPrintWithString3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print("foo");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(String)"})
  public void testPrintWithString4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print("foo");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(String)"})
  public void testPrintWithString5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print("");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(String)"})
  public void testPrintWithString6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print("foo");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(String)"})
  public void testPrintWithString7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print("foo");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String, Object[])} with {@code String}, {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(String, Object[])"})
  public void testPrintWithStringObject() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print("Pattern", "Arguments");

    // Assert
    assertEquals(7L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String, Object[])} with {@code String}, {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(String, Object[])"})
  public void testPrintWithStringObject2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.print("Pattern", "Arguments");

    // Assert
    assertEquals(71L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String, Object[])} with {@code String}, {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(String, Object[])"})
  public void testPrintWithStringObject3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print("Pattern", "Arguments");

    // Assert
    assertEquals(7L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String, Object[])} with {@code String}, {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(String, Object[])"})
  public void testPrintWithStringObject4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.print("Pattern", "Arguments");

    // Assert
    assertEquals(7L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String, Object[])} with {@code String}, {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(String, Object[])"})
  public void testPrintWithStringObject5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.print("", "Arguments");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String, Object[])} with {@code String}, {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(String, Object[])"})
  public void testPrintWithStringObject6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.print("Pattern", "Arguments");

    // Assert
    assertEquals(7L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#print(String, Object[])} with {@code String}, {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#print(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.print(String, Object[])"})
  public void testPrintWithStringObject7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.print("Pattern", "Arguments");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println()"})
  public void testPrintln() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println();

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println()"})
  public void testPrintln2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println();

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println()"})
  public void testPrintln3() {
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
   *
   * <p>Method under test: {@link IndentedPrintStream#println(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(boolean)"})
  public void testPrintlnWithBoolean() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(true);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(boolean)"})
  public void testPrintlnWithBoolean2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(true);

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(boolean)"})
  public void testPrintlnWithBoolean3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(true);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(boolean)"})
  public void testPrintlnWithBoolean4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(true);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(boolean)"})
  public void testPrintlnWithBoolean5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println(true);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(boolean)"})
  public void testPrintlnWithBoolean6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(true);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(boolean)"})
  public void testPrintlnWithBoolean7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(true);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(boolean)"})
  public void testPrintlnWithBoolean8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println(true);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char)} with {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(char)"})
  public void testPrintlnWithChar() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println('A');

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char)} with {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(char)"})
  public void testPrintlnWithChar2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println('A');

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char)} with {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(char)"})
  public void testPrintlnWithChar3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println('A');

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char)} with {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(char)"})
  public void testPrintlnWithChar4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println('A');

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char)} with {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(char)"})
  public void testPrintlnWithChar5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println('A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char)} with {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(char)"})
  public void testPrintlnWithChar6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println('A');

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char[])} with {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(char[])"})
  public void testPrintlnWithChar7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println("AZAZ".toCharArray());

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char[])} with {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(char[])"})
  public void testPrintlnWithChar8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println("AZAZ".toCharArray());

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char[])} with {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(char[])"})
  public void testPrintlnWithChar9() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println("AZAZ".toCharArray());

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char[])} with {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(char[])"})
  public void testPrintlnWithChar10() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println("AZAZ".toCharArray());

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char[])} with {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(char[])"})
  public void testPrintlnWithChar11() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(new char[] {});

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char[])} with {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(char[])"})
  public void testPrintlnWithChar12() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println("AZAZ".toCharArray());

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(char[])} with {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(char[])"})
  public void testPrintlnWithChar13() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println("AZAZ".toCharArray());

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Collection)} with {@code Collection}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(Collection)"})
  public void testPrintlnWithCollection() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    ArrayList<String> str = new ArrayList<>();
    str.add("");

    // Act
    indentedPrintStream.println((Collection<String>) str);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Collection)} with {@code Collection}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(Collection)"})
  public void testPrintlnWithCollection2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    ArrayList<String> str = new ArrayList<>();
    str.add("");

    // Act
    indentedPrintStream.println((Collection<String>) str);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Collection)} with {@code Collection}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(Collection)"})
  public void testPrintlnWithCollection3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    ArrayList<String> str = new ArrayList<>();
    str.add("");

    // Act
    indentedPrintStream.println((Collection<String>) str);

    // Assert that nothing has changed
    assertEquals(64L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Collection)} with {@code Collection}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(Collection)"})
  public void testPrintlnWithCollection4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    ArrayList<String> str = new ArrayList<>();
    str.add("42");
    str.add("");

    // Act
    indentedPrintStream.println((Collection<String>) str);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Collection)} with {@code Collection}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(Collection)"})
  public void testPrintlnWithCollection5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    ArrayList<String> str = new ArrayList<>();
    str.add("");

    // Act
    indentedPrintStream.println((Collection<String>) str);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Collection)} with {@code Collection}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(Collection)"})
  public void testPrintlnWithCollection6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    ArrayList<String> str = new ArrayList<>();
    str.add("");

    // Act
    indentedPrintStream.println((Collection<String>) str);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Collection)} with {@code Collection}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(Collection)"})
  public void testPrintlnWithCollection7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    ArrayList<String> str = new ArrayList<>();
    str.add("42");
    str.add("");

    // Act
    indentedPrintStream.println((Collection<String>) str);

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@code Str}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Str}.
   * </ul>
   *
   * <p>Method under test: {@link IndentedPrintStream#println(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(Collection)"})
  public void testPrintlnWithCollection_givenStr_whenLinkedHashSetAddStr() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    LinkedHashSet<String> str = new LinkedHashSet<>();
    str.add("Str");

    // Act
    indentedPrintStream.println((Collection<String>) str);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(double)} with {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(double)"})
  public void testPrintlnWithDouble() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(2.0d);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(double)} with {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(double)"})
  public void testPrintlnWithDouble2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(2.0d);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(double)} with {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(double)"})
  public void testPrintlnWithDouble3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(2.0d);

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(double)} with {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(double)"})
  public void testPrintlnWithDouble4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(2.0d);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(double)} with {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(double)"})
  public void testPrintlnWithDouble5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println(2.0d);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(double)} with {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(double)"})
  public void testPrintlnWithDouble6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(2.0d);

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(double)} with {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(double)"})
  public void testPrintlnWithDouble7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(2.0d);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(double)} with {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(double)"})
  public void testPrintlnWithDouble8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println(2.0d);

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(float)} with {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(float)"})
  public void testPrintlnWithFloat() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(10.0f);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(float)} with {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(float)"})
  public void testPrintlnWithFloat2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(10.0f);

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(float)} with {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(float)"})
  public void testPrintlnWithFloat3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(10.0f);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(float)} with {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(float)"})
  public void testPrintlnWithFloat4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(10.0f);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(float)} with {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(float)"})
  public void testPrintlnWithFloat5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println(10.0f);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(float)} with {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(float)"})
  public void testPrintlnWithFloat6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(10.0f);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(float)} with {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(float)"})
  public void testPrintlnWithFloat7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println(10.0f);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(float)} with {@code float}.
   *
   * <ul>
   *   <li>Given {@link IndentedPrintStream#IndentedPrintStream(OutputStream)} with outputStream is
   *       {@link PipedOutputStream#PipedOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link IndentedPrintStream#println(float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(float)"})
  public void testPrintlnWithFloat_givenIndentedPrintStreamWithOutputStreamIsPipedOutputStream() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(10.0f);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int)} with {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int)"})
  public void testPrintlnWithInt() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(2);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int)} with {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int)"})
  public void testPrintlnWithInt2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(2);

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int)} with {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int)"})
  public void testPrintlnWithInt3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(2);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int)} with {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int)"})
  public void testPrintlnWithInt4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(2);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int)} with {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int)"})
  public void testPrintlnWithInt5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println(2);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int)} with {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int)"})
  public void testPrintlnWithInt6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(2);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int)} with {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int)"})
  public void testPrintlnWithInt7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println(2);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, boolean)"})
  public void testPrintlnWithIntBoolean() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(1, true);

    // Assert
    assertEquals(6L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, boolean)"})
  public void testPrintlnWithIntBoolean2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, true);

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, boolean)"})
  public void testPrintlnWithIntBoolean3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, true);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, boolean)"})
  public void testPrintlnWithIntBoolean4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, true);

    // Assert
    assertEquals(6L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, boolean)"})
  public void testPrintlnWithIntBoolean5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println(1, true);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, boolean)"})
  public void testPrintlnWithIntBoolean6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, true);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, boolean)"})
  public void testPrintlnWithIntBoolean7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, true);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, boolean)"})
  public void testPrintlnWithIntBoolean8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println(1, true);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char)} with {@code int}, {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, char)"})
  public void testPrintlnWithIntChar() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(1, 'A');

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char)} with {@code int}, {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, char)"})
  public void testPrintlnWithIntChar2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 'A');

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char)} with {@code int}, {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, char)"})
  public void testPrintlnWithIntChar3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, 'A');

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char)} with {@code int}, {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, char)"})
  public void testPrintlnWithIntChar4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println(1, 'A');

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char)} with {@code int}, {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, char)"})
  public void testPrintlnWithIntChar5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, 'A');

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char)} with {@code int}, {@code char}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, char)"})
  public void testPrintlnWithIntChar6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, 'A');

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char[])} with {@code int}, {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, char[])"})
  public void testPrintlnWithIntChar7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(6L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char[])} with {@code int}, {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, char[])"})
  public void testPrintlnWithIntChar8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char[])} with {@code int}, {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, char[])"})
  public void testPrintlnWithIntChar9() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(6L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char[])} with {@code int}, {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, char[])"})
  public void testPrintlnWithIntChar10() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char[])} with {@code int}, {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, char[])"})
  public void testPrintlnWithIntChar11() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(1, new char[] {});

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char[])} with {@code int}, {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, char[])"})
  public void testPrintlnWithIntChar12() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, "AZAZ".toCharArray());

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, char[])} with {@code int}, {@code char[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, char[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, char[])"})
  public void testPrintlnWithIntChar13() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, "AZAZ".toCharArray());

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, double)} with {@code int}, {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, double)"})
  public void testPrintlnWithIntDouble() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(1, 2.0d);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, double)} with {@code int}, {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, double)"})
  public void testPrintlnWithIntDouble2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 2.0d);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, double)} with {@code int}, {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, double)"})
  public void testPrintlnWithIntDouble3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 2.0d);

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, double)} with {@code int}, {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, double)"})
  public void testPrintlnWithIntDouble4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, 2.0d);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, double)} with {@code int}, {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, double)"})
  public void testPrintlnWithIntDouble5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println(1, 2.0d);

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, double)} with {@code int}, {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, double)"})
  public void testPrintlnWithIntDouble6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, 2.0d);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, double)} with {@code int}, {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, double)"})
  public void testPrintlnWithIntDouble7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, 2.0d);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, double)} with {@code int}, {@code double}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, double)"})
  public void testPrintlnWithIntDouble8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println(1, 2.0d);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, float)} with {@code int}, {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, float)"})
  public void testPrintlnWithIntFloat() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(1, 10.0f);

    // Assert
    assertEquals(6L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, float)} with {@code int}, {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, float)"})
  public void testPrintlnWithIntFloat2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 10.0f);

    // Assert
    assertEquals(69L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, float)} with {@code int}, {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, float)"})
  public void testPrintlnWithIntFloat3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 10.0f);

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, float)} with {@code int}, {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, float)"})
  public void testPrintlnWithIntFloat4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, 10.0f);

    // Assert
    assertEquals(6L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, float)} with {@code int}, {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, float)"})
  public void testPrintlnWithIntFloat5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println(1, 10.0f);

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, float)} with {@code int}, {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, float)"})
  public void testPrintlnWithIntFloat6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, 10.0f);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, float)} with {@code int}, {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, float)"})
  public void testPrintlnWithIntFloat7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, 10.0f);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, float)} with {@code int}, {@code float}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, float)"})
  public void testPrintlnWithIntFloat8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println(1, 10.0f);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, int)} with {@code int}, {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, int)"})
  public void testPrintlnWithIntInt() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(1, 2);

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, int)} with {@code int}, {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, int)"})
  public void testPrintlnWithIntInt2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 2);

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, int)} with {@code int}, {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, int)"})
  public void testPrintlnWithIntInt3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 2);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, int)} with {@code int}, {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, int)"})
  public void testPrintlnWithIntInt4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, 2);

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, int)} with {@code int}, {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, int)"})
  public void testPrintlnWithIntInt5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println(1, 2);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, int)} with {@code int}, {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, int)"})
  public void testPrintlnWithIntInt6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, 2);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, int)} with {@code int}, {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, int)"})
  public void testPrintlnWithIntInt7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, 2);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, int)} with {@code int}, {@code int}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, int)"})
  public void testPrintlnWithIntInt8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println(1, 2);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, long)} with {@code int}, {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, long)"})
  public void testPrintlnWithIntLong() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(1, 1L);

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, long)} with {@code int}, {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, long)"})
  public void testPrintlnWithIntLong2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 1L);

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, long)} with {@code int}, {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, long)"})
  public void testPrintlnWithIntLong3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, 1L);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, long)} with {@code int}, {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, long)"})
  public void testPrintlnWithIntLong4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, 1L);

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, long)} with {@code int}, {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, long)"})
  public void testPrintlnWithIntLong5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println(1, 1L);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, long)} with {@code int}, {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, long)"})
  public void testPrintlnWithIntLong6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, 1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, long)} with {@code int}, {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, long)"})
  public void testPrintlnWithIntLong7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, 1L);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, long)} with {@code int}, {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, long)"})
  public void testPrintlnWithIntLong8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println(1, 1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, Object)} with {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, Object)"})
  public void testPrintlnWithIntObject() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(1, (Object) "42");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, Object)} with {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, Object)"})
  public void testPrintlnWithIntObject2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, (Object) "42");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, Object)} with {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, Object)"})
  public void testPrintlnWithIntObject3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, (Object) "42");

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, Object)} with {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, Object)"})
  public void testPrintlnWithIntObject4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, (Object) "42");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, Object)} with {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, Object)"})
  public void testPrintlnWithIntObject5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println(1, (Object) "42");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, Object)} with {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, Object)"})
  public void testPrintlnWithIntObject6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(1, (Object) "");

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, Object)} with {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, Object)"})
  public void testPrintlnWithIntObject7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println(1, (Object) "");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, Object)} with {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, Object)"})
  public void testPrintlnWithIntObject8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, (Object) "42");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, Object)} with {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, Object)"})
  public void testPrintlnWithIntObject9() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, (Object) "42");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, Object)} with {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, Object)"})
  public void testPrintlnWithIntObject10() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println(1, (Object) "42");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String)"})
  public void testPrintlnWithIntString() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(1, "foo");

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String)"})
  public void testPrintlnWithIntString2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, "foo");

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String)"})
  public void testPrintlnWithIntString3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, "foo");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String)"})
  public void testPrintlnWithIntString4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, "foo");

    // Assert
    assertEquals(5L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String)"})
  public void testPrintlnWithIntString5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println(1, "foo");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String)"})
  public void testPrintlnWithIntString6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(1, "");

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String)"})
  public void testPrintlnWithIntString7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println(1, "");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String)"})
  public void testPrintlnWithIntString8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, "foo");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String)"})
  public void testPrintlnWithIntString9() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, "foo");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String)"})
  public void testPrintlnWithIntString10() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println(1, "foo");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String, Object[])} with {@code int}, {@code
   * String}, {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String, Object[])"})
  public void testPrintlnWithIntStringObject() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(1, "Pattern", "Arguments");

    // Assert
    assertEquals(9L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String, Object[])} with {@code int}, {@code
   * String}, {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String, Object[])"})
  public void testPrintlnWithIntStringObject2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, "Pattern", "Arguments");

    // Assert
    assertEquals(72L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String, Object[])} with {@code int}, {@code
   * String}, {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String, Object[])"})
  public void testPrintlnWithIntStringObject3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1, "Pattern", "Arguments");

    // Assert
    assertEquals(71L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String, Object[])} with {@code int}, {@code
   * String}, {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String, Object[])"})
  public void testPrintlnWithIntStringObject4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, "Pattern", "Arguments");

    // Assert
    assertEquals(9L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String, Object[])} with {@code int}, {@code
   * String}, {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String, Object[])"})
  public void testPrintlnWithIntStringObject5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println(1, "Pattern", "Arguments");

    // Assert
    assertEquals(8L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String, Object[])} with {@code int}, {@code
   * String}, {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String, Object[])"})
  public void testPrintlnWithIntStringObject6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(1, "", "Arguments");

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String, Object[])} with {@code int}, {@code
   * String}, {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String, Object[])"})
  public void testPrintlnWithIntStringObject7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println(1, "", "Arguments");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String, Object[])} with {@code int}, {@code
   * String}, {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String, Object[])"})
  public void testPrintlnWithIntStringObject8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1, "Pattern", "Arguments");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String, Object[])} with {@code int}, {@code
   * String}, {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String, Object[])"})
  public void testPrintlnWithIntStringObject9() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1, "Pattern", "Arguments");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int, String, Object[])} with {@code int}, {@code
   * String}, {@code Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int, String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int, String, Object[])"})
  public void testPrintlnWithIntStringObject10() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println(1, "Pattern", "Arguments");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(int)} with {@code int}.
   *
   * <ul>
   *   <li>Given {@link IndentedPrintStream#IndentedPrintStream(OutputStream)} with outputStream is
   *       {@link PipedOutputStream#PipedOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link IndentedPrintStream#println(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(int)"})
  public void testPrintlnWithInt_givenIndentedPrintStreamWithOutputStreamIsPipedOutputStream() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(2);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(long)} with {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(long)"})
  public void testPrintlnWithLong() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println(1L);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(long)} with {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(long)"})
  public void testPrintlnWithLong2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1L);

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(long)} with {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(long)"})
  public void testPrintlnWithLong3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println(1L);

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(long)} with {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(long)"})
  public void testPrintlnWithLong4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1L);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(long)} with {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(long)"})
  public void testPrintlnWithLong5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println(1L);

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(long)} with {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(long)"})
  public void testPrintlnWithLong6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println(1L);

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(long)} with {@code long}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(long)"})
  public void testPrintlnWithLong7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println(1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(long)} with {@code long}.
   *
   * <ul>
   *   <li>Given {@link IndentedPrintStream#IndentedPrintStream(OutputStream)} with outputStream is
   *       {@link PipedOutputStream#PipedOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link IndentedPrintStream#println(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(long)"})
  public void testPrintlnWithLong_givenIndentedPrintStreamWithOutputStreamIsPipedOutputStream() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println(1L);

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(Object)"})
  public void testPrintlnWithObject() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println((Object) "42");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(Object)"})
  public void testPrintlnWithObject2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println((Object) "42");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(Object)"})
  public void testPrintlnWithObject3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println((Object) "42");

    // Assert
    assertEquals(66L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(Object)"})
  public void testPrintlnWithObject4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println((Object) "42");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(Object)"})
  public void testPrintlnWithObject5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println((Object) "42");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(Object)"})
  public void testPrintlnWithObject6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println((Object) "");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(Object)"})
  public void testPrintlnWithObject7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println((Object) "");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(Object)"})
  public void testPrintlnWithObject8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println((Object) "42");

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(Object)"})
  public void testPrintlnWithObject9() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println((Object) "42");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(Object)"})
  public void testPrintlnWithObject10() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println((Object) "42");

    // Assert
    assertEquals(2L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String)"})
  public void testPrintlnWithString() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println("foo");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String)"})
  public void testPrintlnWithString2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println("foo");

    // Assert
    assertEquals(68L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String)"})
  public void testPrintlnWithString3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println("foo");

    // Assert
    assertEquals(67L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String)"})
  public void testPrintlnWithString4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println("foo");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String)"})
  public void testPrintlnWithString5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println("foo");

    // Assert
    assertEquals(4L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String)"})
  public void testPrintlnWithString6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println("");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String)"})
  public void testPrintlnWithString7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println("");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String)"})
  public void testPrintlnWithString8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println("foo");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String)"})
  public void testPrintlnWithString9() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println("foo");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String)} with {@code String}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String)"})
  public void testPrintlnWithString10() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println("foo");

    // Assert
    assertEquals(3L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String, Object[])} with {@code String}, {@code
   * Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String, Object[])"})
  public void testPrintlnWithStringObject() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println("Pattern", "Arguments");

    // Assert
    assertEquals(8L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String, Object[])} with {@code String}, {@code
   * Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String, Object[])"})
  public void testPrintlnWithStringObject2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println("Pattern", "Arguments");

    // Assert
    assertEquals(72L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String, Object[])} with {@code String}, {@code
   * Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String, Object[])"})
  public void testPrintlnWithStringObject3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.println("Pattern", "Arguments");

    // Assert
    assertEquals(71L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String, Object[])} with {@code String}, {@code
   * Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String, Object[])"})
  public void testPrintlnWithStringObject4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println("Pattern", "Arguments");

    // Assert
    assertEquals(8L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String, Object[])} with {@code String}, {@code
   * Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String, Object[])"})
  public void testPrintlnWithStringObject5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.println("Pattern", "Arguments");

    // Assert
    assertEquals(8L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String, Object[])} with {@code String}, {@code
   * Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String, Object[])"})
  public void testPrintlnWithStringObject6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.println("", "Arguments");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String, Object[])} with {@code String}, {@code
   * Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String, Object[])"})
  public void testPrintlnWithStringObject7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println("", "Arguments");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String, Object[])} with {@code String}, {@code
   * Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String, Object[])"})
  public void testPrintlnWithStringObject8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.println("Pattern", "Arguments");

    // Assert
    assertEquals(7L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String, Object[])} with {@code String}, {@code
   * Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String, Object[])"})
  public void testPrintlnWithStringObject9() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.println("Pattern", "Arguments");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#println(String, Object[])} with {@code String}, {@code
   * Object[]}.
   *
   * <p>Method under test: {@link IndentedPrintStream#println(String, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.println(String, Object[])"})
  public void testPrintlnWithStringObject10() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.println("Pattern", "Arguments");

    // Assert
    assertEquals(7L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printlines(String[])}.
   *
   * <p>Method under test: {@link IndentedPrintStream#printlines(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.printlines(String[])"})
  public void testPrintlines() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.printlines("Strings");

    // Assert
    assertEquals(8L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printlines(String[])}.
   *
   * <p>Method under test: {@link IndentedPrintStream#printlines(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.printlines(String[])"})
  public void testPrintlines2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.printlines("Strings");

    // Assert
    assertEquals(72L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printlines(String[])}.
   *
   * <p>Method under test: {@link IndentedPrintStream#printlines(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.printlines(String[])"})
  public void testPrintlines3() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.printlines("Strings");

    // Assert
    assertEquals(71L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printlines(String[])}.
   *
   * <p>Method under test: {@link IndentedPrintStream#printlines(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.printlines(String[])"})
  public void testPrintlines4() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.printlines("Strings");

    // Assert
    assertEquals(8L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printlines(String[])}.
   *
   * <p>Method under test: {@link IndentedPrintStream#printlines(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.printlines(String[])"})
  public void testPrintlines5() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoIndent(true);

    // Act
    indentedPrintStream.printlines("Strings");

    // Assert
    assertEquals(8L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printlines(String[])}.
   *
   * <p>Method under test: {@link IndentedPrintStream#printlines(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.printlines(String[])"})
  public void testPrintlines6() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.printlines("");

    // Assert
    assertEquals(1L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printlines(String[])}.
   *
   * <p>Method under test: {@link IndentedPrintStream#printlines(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.printlines(String[])"})
  public void testPrintlines7() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.printlines("");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printlines(String[])}.
   *
   * <p>Method under test: {@link IndentedPrintStream#printlines(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.printlines(String[])"})
  public void testPrintlines8() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setPrintOffsets(true);

    // Act
    indentedPrintStream.printlines("Strings");

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printlines(String[])}.
   *
   * <p>Method under test: {@link IndentedPrintStream#printlines(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.printlines(String[])"})
  public void testPrintlines9() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());
    indentedPrintStream.setNoNl(true);

    // Act
    indentedPrintStream.printlines("Strings");

    // Assert
    assertEquals(7L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#printlines(String[])}.
   *
   * <ul>
   *   <li>Given {@link IndentedPrintStream#IndentedPrintStream(OutputStream)} with outputStream is
   *       {@link PipedOutputStream#PipedOutputStream()}.
   * </ul>
   *
   * <p>Method under test: {@link IndentedPrintStream#printlines(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.printlines(String[])"})
  public void testPrintlines_givenIndentedPrintStreamWithOutputStreamIsPipedOutputStream() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new PipedOutputStream());

    // Act
    indentedPrintStream.printlines("Strings");

    // Assert
    assertEquals(7L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#forceNewLine()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#forceNewLine()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.forceNewLine()"})
  public void testForceNewLine() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    indentedPrintStream.forceNewLine();

    // Assert that nothing has changed
    assertEquals(0L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#forceNewLine()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#forceNewLine()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.forceNewLine()"})
  public void testForceNewLine2() {
    // Arrange
    IndentedPrintStream indentedPrintStream = new IndentedPrintStream(new ByteArrayOutputStream());
    indentedPrintStream.append(ShortID.DEFAULT_ALPHABET);

    // Act
    indentedPrintStream.forceNewLine();

    // Assert
    assertEquals(65L, indentedPrintStream.getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#forceNewLine()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#forceNewLine()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndentedPrintStream.forceNewLine()"})
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
   *
   * <p>Method under test: {@link IndentedPrintStream#getOffset()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long IndentedPrintStream.getOffset()"})
  public void testGetOffset() {
    // Arrange, Act and Assert
    assertEquals(0L, new IndentedPrintStream(new ByteArrayOutputStream()).getOffset());
  }

  /**
   * Test {@link IndentedPrintStream#isoNlCr()}.
   *
   * <p>Method under test: {@link IndentedPrintStream#isoNlCr()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndentedPrintStream.isoNlCr()"})
  public void testIsoNlCr() {
    // Arrange, Act and Assert
    assertFalse(new IndentedPrintStream(new ByteArrayOutputStream()).isoNlCr());
  }
}
