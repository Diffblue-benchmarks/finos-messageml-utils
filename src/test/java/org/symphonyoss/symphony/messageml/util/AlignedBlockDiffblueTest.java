package org.symphonyoss.symphony.messageml.util;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyChar;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class AlignedBlockDiffblueTest {
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
    IndentedPrintStream out = mock(IndentedPrintStream.class);
    doNothing().when(out).print(anyChar());
    doNothing().when(out).print(Mockito.<String>any());
    doNothing().when(out).println(Mockito.<String>any());

    AlignedBlock alignedBlock = new AlignedBlock(out);
    alignedBlock.align("42", "42");

    // Act
    alignedBlock.print("Separator", "Terminator");

    // Assert
    verify(out, atLeast(1)).print(' ');
    verify(out, atLeast(1)).print("42");
    verify(out).println("Terminator");
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
    IndentedPrintStream out = mock(IndentedPrintStream.class);
    doNothing().when(out).print(anyChar());
    doNothing().when(out).print(Mockito.<String>any());
    doNothing().when(out).println(Mockito.<String>any());

    AlignedBlock alignedBlock = new AlignedBlock(out);
    alignedBlock.align(null, "42");

    // Act
    alignedBlock.print("Separator", "Terminator");

    // Assert
    verify(out, atLeast(1)).print(' ');
    verify(out, atLeast(1)).print(Mockito.<String>any());
    verify(out).println("Terminator");
  }

  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>Given {@link AlignedBlock#AlignedBlock(IndentedPrintStream)} with out is {@link
   *       IndentedPrintStream} align {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print(String, String)"})
  public void testPrintWithStringString_givenAlignedBlockWithOutIsIndentedPrintStreamAlign42() {
    // Arrange
    IndentedPrintStream out = mock(IndentedPrintStream.class);
    doNothing().when(out).print(Mockito.<String>any());
    doNothing().when(out).println(Mockito.<String>any());

    AlignedBlock alignedBlock = new AlignedBlock(out);
    alignedBlock.align("42");

    // Act
    alignedBlock.print("Separator", "Terminator");

    // Assert
    verify(out).print("42");
    verify(out).println("Terminator");
  }

  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>Then calls {@link IndentedPrintStream#println()}.
   * </ul>
   *
   * <p>Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print(String, String)"})
  public void testPrintWithStringString_thenCallsPrintln() {
    // Arrange
    IndentedPrintStream out = mock(IndentedPrintStream.class);
    doNothing().when(out).println();
    doNothing().when(out).print(anyChar());
    doNothing().when(out).print(Mockito.<String>any());

    AlignedBlock alignedBlock = new AlignedBlock(out);
    alignedBlock.align("42", "42");

    // Act
    alignedBlock.print("Separator", null);

    // Assert
    verify(out, atLeast(1)).print(' ');
    verify(out, atLeast(1)).print("42");
    verify(out).println();
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
    IndentedPrintStream out = mock(IndentedPrintStream.class);
    doNothing().when(out).print(anyChar());
    doNothing().when(out).print(Mockito.<String>any());
    doNothing().when(out).println(Mockito.<String>any());

    AlignedBlock alignedBlock = new AlignedBlock(out);
    alignedBlock.align("42", "42");

    // Act
    alignedBlock.print(null, "Terminator");

    // Assert
    verify(out, atLeast(1)).print(' ');
    verify(out, atLeast(1)).print("42");
    verify(out).println("Terminator");
  }

  /**
   * Test {@link AlignedBlock#print()}.
   *
   * <ul>
   *   <li>Given {@link AlignedBlock#AlignedBlock(IndentedPrintStream)} with out is {@link
   *       IndentedPrintStream} align {@code 42} and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AlignedBlock#print()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print()"})
  public void testPrint_givenAlignedBlockWithOutIsIndentedPrintStreamAlign42And42() {
    // Arrange
    IndentedPrintStream out = mock(IndentedPrintStream.class);
    doNothing().when(out).print(anyChar());
    when(out.append(Mockito.<CharSequence>any()))
        .thenReturn(new PrintStream(new ByteArrayOutputStream()));
    doNothing().when(out).print(Mockito.<String>any());
    doNothing().when(out).println();
    out.append(ShortID.DEFAULT_ALPHABET);

    AlignedBlock alignedBlock = new AlignedBlock(out);
    alignedBlock.align("42", "42");

    // Act
    alignedBlock.print();

    // Assert
    verify(out).append(isA(CharSequence.class));
    verify(out, atLeast(1)).print(' ');
    verify(out, atLeast(1)).print("42");
    verify(out).println();
  }

  /**
   * Test {@link AlignedBlock#print()}.
   *
   * <ul>
   *   <li>Given {@link AlignedBlock#AlignedBlock(IndentedPrintStream)} with out is {@link
   *       IndentedPrintStream} align {@code 42}.
   *   <li>Then calls {@link IndentedPrintStream#append(CharSequence)}.
   * </ul>
   *
   * <p>Method under test: {@link AlignedBlock#print()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print()"})
  public void testPrint_givenAlignedBlockWithOutIsIndentedPrintStreamAlign42_thenCallsAppend() {
    // Arrange
    IndentedPrintStream out = mock(IndentedPrintStream.class);
    when(out.append(Mockito.<CharSequence>any()))
        .thenReturn(new PrintStream(new ByteArrayOutputStream()));
    doNothing().when(out).print(Mockito.<String>any());
    doNothing().when(out).println();
    out.append(ShortID.DEFAULT_ALPHABET);

    AlignedBlock alignedBlock = new AlignedBlock(out);
    alignedBlock.align("42");

    // Act
    alignedBlock.print();

    // Assert
    verify(out).append(isA(CharSequence.class));
    verify(out).print("42");
    verify(out).println();
  }

  /**
   * Test {@link AlignedBlock#print()}.
   *
   * <ul>
   *   <li>Given {@link AlignedBlock#AlignedBlock(IndentedPrintStream)} with out is {@link
   *       IndentedPrintStream} align {@code null} and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AlignedBlock#print()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlignedBlock.print()"})
  public void testPrint_givenAlignedBlockWithOutIsIndentedPrintStreamAlignNullAnd42() {
    // Arrange
    IndentedPrintStream out = mock(IndentedPrintStream.class);
    doNothing().when(out).print(anyChar());
    when(out.append(Mockito.<CharSequence>any()))
        .thenReturn(new PrintStream(new ByteArrayOutputStream()));
    doNothing().when(out).print(Mockito.<String>any());
    doNothing().when(out).println();
    out.append(ShortID.DEFAULT_ALPHABET);

    AlignedBlock alignedBlock = new AlignedBlock(out);
    alignedBlock.align(null, "42");

    // Act
    alignedBlock.print();

    // Assert
    verify(out).append(isA(CharSequence.class));
    verify(out, atLeast(1)).print(' ');
    verify(out, atLeast(1)).print(Mockito.<String>any());
    verify(out).println();
  }
}
