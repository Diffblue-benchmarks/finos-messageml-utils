package org.symphonyoss.symphony.messageml.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AlignedBlockDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlignedBlock#AlignedBlock(IndentedPrintStream)}
   *   <li>{@link AlignedBlock#getMaxColumnLength()}
   *   <li>{@link AlignedBlock#getOut()}
   *   <li>{@link AlignedBlock#getRows()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlignedBlock.<init>(IndentedPrintStream)",
    "ArrayList AlignedBlock.getMaxColumnLength()",
    "IndentedPrintStream AlignedBlock.getOut()",
    "ArrayList AlignedBlock.getRows()"
  })
  public void testGettersAndSetters() {
    // Arrange
    IndentedPrintStream out = new IndentedPrintStream(new ByteArrayOutputStream());

    // Act
    AlignedBlock actualAlignedBlock = new AlignedBlock(out);
    ArrayList<Integer> actualMaxColumnLength = actualAlignedBlock.getMaxColumnLength();
    IndentedPrintStream actualOut = actualAlignedBlock.getOut();
    ArrayList<String[]> actualRows = actualAlignedBlock.getRows();

    // Assert
    assertTrue(actualMaxColumnLength.isEmpty());
    assertTrue(actualRows.isEmpty());
    assertSame(out, actualOut);
  }

  /**
   * Test {@link AlignedBlock#align(Object[])}.
   *
   * <p>Method under test: {@link AlignedBlock#align(Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.align(Object[])"})
  public void testAlign() {
    // Arrange
    AlignedBlock alignedBlock =
        new AlignedBlock(new IndentedPrintStream(new ByteArrayOutputStream()));

    // Act
    alignedBlock.align("42");

    // Assert
    ArrayList<Integer> maxColumnLength = alignedBlock.getMaxColumnLength();
    assertEquals(1, maxColumnLength.size());
    ArrayList<String[]> rows = alignedBlock.getRows();
    assertEquals(1, rows.size());
    assertEquals(2, maxColumnLength.get(0).intValue());
    assertArrayEquals(new String[] {"42"}, rows.get(0));
  }

  /**
   * Test {@link AlignedBlock#align(Object[])}.
   *
   * <ul>
   *   <li>Then array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link AlignedBlock#align(Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.align(Object[])"})
  public void testAlign_thenArrayLengthIsZero() {
    // Arrange
    AlignedBlock alignedBlock =
        new AlignedBlock(new IndentedPrintStream(new ByteArrayOutputStream()));

    // Act
    alignedBlock.align();

    // Assert
    ArrayList<String[]> rows = alignedBlock.getRows();
    assertEquals(1, rows.size());
    assertEquals(0, rows.get(0).length);
    assertTrue(alignedBlock.getMaxColumnLength().isEmpty());
  }

  /**
   * Test {@link AlignedBlock#print()}.
   *
   * <p>Method under test: {@link AlignedBlock#print()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print()"})
  public void testPrint() {
    // Arrange
    IndentedPrintStream out = new IndentedPrintStream(new ByteArrayOutputStream());
    out.setPrintOffsets(true);

    AlignedBlock alignedBlock = new AlignedBlock(out);
    alignedBlock.align("42");

    // Act
    alignedBlock.print();

    // Assert
    ArrayList<Integer> maxColumnLength = alignedBlock.getMaxColumnLength();
    assertEquals(1, maxColumnLength.size());
    assertEquals(3L, alignedBlock.getOut().getOffset());
    assertEquals(8, maxColumnLength.get(0).intValue());
  }

  /**
   * Test {@link AlignedBlock#print()}.
   *
   * <p>Method under test: {@link AlignedBlock#print()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print()"})
  public void testPrint2() {
    // Arrange
    IndentedPrintStream out = new IndentedPrintStream(new ByteArrayOutputStream());
    out.setNoIndent(true);

    AlignedBlock alignedBlock = new AlignedBlock(out);
    alignedBlock.align("42");

    // Act
    alignedBlock.print();

    // Assert
    ArrayList<Integer> maxColumnLength = alignedBlock.getMaxColumnLength();
    assertEquals(1, maxColumnLength.size());
    assertEquals(3L, alignedBlock.getOut().getOffset());
    assertEquals(8, maxColumnLength.get(0).intValue());
  }

  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String}, {@code String}.
   *
   * <p>Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print(String, String)"})
  public void testPrintWithStringString() {
    // Arrange
    AlignedBlock alignedBlock =
        new AlignedBlock(new IndentedPrintStream(new ByteArrayOutputStream()));

    // Act
    alignedBlock.print("Separator", "Terminator");

    // Assert that nothing has changed
    assertEquals(0L, alignedBlock.getOut().getOffset());
  }

  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String}, {@code String}.
   *
   * <p>Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print(String, String)"})
  public void testPrintWithStringString2() {
    // Arrange
    AlignedBlock alignedBlock =
        new AlignedBlock(new IndentedPrintStream(new ByteArrayOutputStream()));
    alignedBlock.align("42");

    // Act
    alignedBlock.print("Separator", "Terminator");

    // Assert
    ArrayList<Integer> maxColumnLength = alignedBlock.getMaxColumnLength();
    assertEquals(1, maxColumnLength.size());
    assertEquals(13L, alignedBlock.getOut().getOffset());
    assertEquals(8, maxColumnLength.get(0).intValue());
  }

  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String}, {@code String}.
   *
   * <p>Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print(String, String)"})
  public void testPrintWithStringString3() {
    // Arrange
    AlignedBlock alignedBlock =
        new AlignedBlock(new IndentedPrintStream(new ByteArrayOutputStream()));
    alignedBlock.align();

    // Act
    alignedBlock.print("Separator", "Terminator");

    // Assert
    assertEquals(11L, alignedBlock.getOut().getOffset());
  }

  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String}, {@code String}.
   *
   * <p>Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print(String, String)"})
  public void testPrintWithStringString4() {
    // Arrange
    AlignedBlock alignedBlock =
        new AlignedBlock(new IndentedPrintStream(new ByteArrayOutputStream()));
    alignedBlock.align("42", "42");

    // Act
    alignedBlock.print("Separator", "Terminator");

    // Assert
    ArrayList<Integer> maxColumnLength = alignedBlock.getMaxColumnLength();
    assertEquals(2, maxColumnLength.size());
    assertEquals(21L, alignedBlock.getOut().getOffset());
    assertEquals(8, maxColumnLength.get(0).intValue());
    assertEquals(8, maxColumnLength.get(1).intValue());
  }

  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String}, {@code String}.
   *
   * <p>Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print(String, String)"})
  public void testPrintWithStringString5() {
    // Arrange
    IndentedPrintStream out = new IndentedPrintStream(new ByteArrayOutputStream());
    out.setPrintOffsets(true);

    AlignedBlock alignedBlock = new AlignedBlock(out);
    alignedBlock.align("42");

    // Act
    alignedBlock.print("Separator", "Terminator");

    // Assert
    ArrayList<Integer> maxColumnLength = alignedBlock.getMaxColumnLength();
    assertEquals(1, maxColumnLength.size());
    assertEquals(13L, alignedBlock.getOut().getOffset());
    assertEquals(8, maxColumnLength.get(0).intValue());
  }

  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String}, {@code String}.
   *
   * <p>Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print(String, String)"})
  public void testPrintWithStringString6() {
    // Arrange
    IndentedPrintStream out = new IndentedPrintStream(new ByteArrayOutputStream());
    out.setNoIndent(true);

    AlignedBlock alignedBlock = new AlignedBlock(out);
    alignedBlock.align("42");

    // Act
    alignedBlock.print("Separator", "Terminator");

    // Assert
    ArrayList<Integer> maxColumnLength = alignedBlock.getMaxColumnLength();
    assertEquals(1, maxColumnLength.size());
    assertEquals(13L, alignedBlock.getOut().getOffset());
    assertEquals(8, maxColumnLength.get(0).intValue());
  }

  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String}, {@code String}.
   *
   * <p>Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print(String, String)"})
  public void testPrintWithStringString7() {
    // Arrange
    IndentedPrintStream out = new IndentedPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    AlignedBlock alignedBlock = new AlignedBlock(out);
    alignedBlock.align("42");

    // Act
    alignedBlock.print("Separator", "Terminator");

    // Assert
    ArrayList<Integer> maxColumnLength = alignedBlock.getMaxColumnLength();
    assertEquals(1, maxColumnLength.size());
    assertEquals(12L, alignedBlock.getOut().getOffset());
    assertEquals(8, maxColumnLength.get(0).intValue());
  }

  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String}, {@code String}.
   *
   * <p>Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print(String, String)"})
  public void testPrintWithStringString8() {
    // Arrange
    AlignedBlock alignedBlock =
        new AlignedBlock(new IndentedPrintStream(new ByteArrayOutputStream()));
    alignedBlock.align("42");

    // Act
    alignedBlock.print("Separator", null);

    // Assert
    ArrayList<Integer> maxColumnLength = alignedBlock.getMaxColumnLength();
    assertEquals(1, maxColumnLength.size());
    assertEquals(3L, alignedBlock.getOut().getOffset());
    assertEquals(8, maxColumnLength.get(0).intValue());
  }

  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String}, {@code String}.
   *
   * <p>Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print(String, String)"})
  public void testPrintWithStringString9() {
    // Arrange
    AlignedBlock alignedBlock =
        new AlignedBlock(new IndentedPrintStream(new ByteArrayOutputStream()));
    alignedBlock.align("42");

    // Act
    alignedBlock.print("Separator", "");

    // Assert
    ArrayList<Integer> maxColumnLength = alignedBlock.getMaxColumnLength();
    assertEquals(1, maxColumnLength.size());
    assertEquals(3L, alignedBlock.getOut().getOffset());
    assertEquals(8, maxColumnLength.get(0).intValue());
  }

  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String}, {@code String}.
   *
   * <p>Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print(String, String)"})
  public void testPrintWithStringString10() {
    // Arrange
    IndentedPrintStream out = new IndentedPrintStream(new ByteArrayOutputStream());
    out.setNoNl(true);

    AlignedBlock alignedBlock = new AlignedBlock(out);
    alignedBlock.align("42");

    // Act
    alignedBlock.print("Separator", "");

    // Assert
    ArrayList<Integer> maxColumnLength = alignedBlock.getMaxColumnLength();
    assertEquals(1, maxColumnLength.size());
    assertEquals(2L, alignedBlock.getOut().getOffset());
    assertEquals(8, maxColumnLength.get(0).intValue());
  }

  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String}, {@code String}.
   *
   * <p>Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print(String, String)"})
  public void testPrintWithStringString11() {
    // Arrange
    AlignedBlock alignedBlock =
        new AlignedBlock(new IndentedPrintStream(new ByteArrayOutputStream()));
    alignedBlock.align(null, "42");

    // Act
    alignedBlock.print("Separator", "Terminator");

    // Assert
    ArrayList<Integer> maxColumnLength = alignedBlock.getMaxColumnLength();
    assertEquals(2, maxColumnLength.size());
    assertEquals(25L, alignedBlock.getOut().getOffset());
    assertEquals(8, maxColumnLength.get(0).intValue());
    assertEquals(8, maxColumnLength.get(1).intValue());
  }

  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print(String, String)"})
  public void testPrintWithStringString_whenNull() {
    // Arrange
    AlignedBlock alignedBlock =
        new AlignedBlock(new IndentedPrintStream(new ByteArrayOutputStream()));
    alignedBlock.align("42");

    // Act
    alignedBlock.print(null, "Terminator");

    // Assert
    ArrayList<Integer> maxColumnLength = alignedBlock.getMaxColumnLength();
    assertEquals(1, maxColumnLength.size());
    assertEquals(13L, alignedBlock.getOut().getOffset());
    assertEquals(8, maxColumnLength.get(0).intValue());
  }

  /**
   * Test {@link AlignedBlock#print()}.
   *
   * <ul>
   *   <li>Then {@link AlignedBlock#AlignedBlock(IndentedPrintStream)} with out is {@link
   *       IndentedPrintStream#IndentedPrintStream(OutputStream)} Out Offset is eleven.
   * </ul>
   *
   * <p>Method under test: {@link AlignedBlock#print()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print()"})
  public void testPrint_thenAlignedBlockWithOutIsIndentedPrintStreamOutOffsetIsEleven() {
    // Arrange
    AlignedBlock alignedBlock =
        new AlignedBlock(new IndentedPrintStream(new ByteArrayOutputStream()));
    alignedBlock.align("42", "42");

    // Act
    alignedBlock.print();

    // Assert
    assertEquals(11L, alignedBlock.getOut().getOffset());
    ArrayList<Integer> maxColumnLength = alignedBlock.getMaxColumnLength();
    assertEquals(2, maxColumnLength.size());
    assertEquals(8, maxColumnLength.get(0).intValue());
    assertEquals(8, maxColumnLength.get(1).intValue());
  }

  /**
   * Test {@link AlignedBlock#print()}.
   *
   * <ul>
   *   <li>Then {@link AlignedBlock#AlignedBlock(IndentedPrintStream)} with out is {@link
   *       IndentedPrintStream#IndentedPrintStream(OutputStream)} Out Offset is fifteen.
   * </ul>
   *
   * <p>Method under test: {@link AlignedBlock#print()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print()"})
  public void testPrint_thenAlignedBlockWithOutIsIndentedPrintStreamOutOffsetIsFifteen() {
    // Arrange
    AlignedBlock alignedBlock =
        new AlignedBlock(new IndentedPrintStream(new ByteArrayOutputStream()));
    alignedBlock.align(null, "42");

    // Act
    alignedBlock.print();

    // Assert
    assertEquals(15L, alignedBlock.getOut().getOffset());
    ArrayList<Integer> maxColumnLength = alignedBlock.getMaxColumnLength();
    assertEquals(2, maxColumnLength.size());
    assertEquals(8, maxColumnLength.get(0).intValue());
    assertEquals(8, maxColumnLength.get(1).intValue());
  }

  /**
   * Test {@link AlignedBlock#print()}.
   *
   * <ul>
   *   <li>Then {@link AlignedBlock#AlignedBlock(IndentedPrintStream)} with out is {@link
   *       IndentedPrintStream#IndentedPrintStream(OutputStream)} Out Offset is one.
   * </ul>
   *
   * <p>Method under test: {@link AlignedBlock#print()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print()"})
  public void testPrint_thenAlignedBlockWithOutIsIndentedPrintStreamOutOffsetIsOne() {
    // Arrange
    AlignedBlock alignedBlock =
        new AlignedBlock(new IndentedPrintStream(new ByteArrayOutputStream()));
    alignedBlock.align("");

    // Act
    alignedBlock.print();

    // Assert
    ArrayList<Integer> maxColumnLength = alignedBlock.getMaxColumnLength();
    assertEquals(1, maxColumnLength.size());
    assertEquals(1L, alignedBlock.getOut().getOffset());
    assertEquals(8, maxColumnLength.get(0).intValue());
  }

  /**
   * Test {@link AlignedBlock#print()}.
   *
   * <ul>
   *   <li>Then {@link AlignedBlock#AlignedBlock(IndentedPrintStream)} with out is {@link
   *       IndentedPrintStream#IndentedPrintStream(OutputStream)} Out Offset is sixty-seven.
   * </ul>
   *
   * <p>Method under test: {@link AlignedBlock#print()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print()"})
  public void testPrint_thenAlignedBlockWithOutIsIndentedPrintStreamOutOffsetIsSixtySeven() {
    // Arrange
    IndentedPrintStream out = new IndentedPrintStream(new ByteArrayOutputStream());
    out.append(ShortID.DEFAULT_ALPHABET);

    AlignedBlock alignedBlock = new AlignedBlock(out);
    alignedBlock.align("42");

    // Act
    alignedBlock.print();

    // Assert
    ArrayList<Integer> maxColumnLength = alignedBlock.getMaxColumnLength();
    assertEquals(1, maxColumnLength.size());
    assertEquals(67L, alignedBlock.getOut().getOffset());
    assertEquals(8, maxColumnLength.get(0).intValue());
  }

  /**
   * Test {@link AlignedBlock#print()}.
   *
   * <ul>
   *   <li>Then {@link AlignedBlock#AlignedBlock(IndentedPrintStream)} with out is {@link
   *       IndentedPrintStream#IndentedPrintStream(OutputStream)} Out Offset is three.
   * </ul>
   *
   * <p>Method under test: {@link AlignedBlock#print()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print()"})
  public void testPrint_thenAlignedBlockWithOutIsIndentedPrintStreamOutOffsetIsThree() {
    // Arrange
    AlignedBlock alignedBlock =
        new AlignedBlock(new IndentedPrintStream(new ByteArrayOutputStream()));
    alignedBlock.align("42");

    // Act
    alignedBlock.print();

    // Assert
    ArrayList<Integer> maxColumnLength = alignedBlock.getMaxColumnLength();
    assertEquals(1, maxColumnLength.size());
    assertEquals(3L, alignedBlock.getOut().getOffset());
    assertEquals(8, maxColumnLength.get(0).intValue());
  }

  /**
   * Test {@link AlignedBlock#print()}.
   *
   * <ul>
   *   <li>Then {@link AlignedBlock#AlignedBlock(IndentedPrintStream)} with out is {@link
   *       IndentedPrintStream#IndentedPrintStream(OutputStream)} Out Offset is zero.
   * </ul>
   *
   * <p>Method under test: {@link AlignedBlock#print()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print()"})
  public void testPrint_thenAlignedBlockWithOutIsIndentedPrintStreamOutOffsetIsZero() {
    // Arrange
    AlignedBlock alignedBlock =
        new AlignedBlock(new IndentedPrintStream(new ByteArrayOutputStream()));

    // Act
    alignedBlock.print();

    // Assert that nothing has changed
    assertEquals(0L, alignedBlock.getOut().getOffset());
  }
}
