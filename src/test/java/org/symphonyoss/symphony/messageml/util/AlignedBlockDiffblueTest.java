package org.symphonyoss.symphony.messageml.util;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyChar;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.mockito.Mockito;

public class AlignedBlockDiffblueTest {
  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String},
   * {@code String}.
   * <p>
   * Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
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
    verify(out, atLeast(1)).print(eq(' '));
    verify(out, atLeast(1)).print(eq("42"));
    verify(out).println(eq("Terminator"));
  }

  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String},
   * {@code String}.
   * <p>
   * Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
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
    verify(out, atLeast(1)).print(eq(' '));
    verify(out, atLeast(1)).print(Mockito.<String>any());
    verify(out).println(eq("Terminator"));
  }

  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String},
   * {@code String}.
   * <ul>
   *   <li>Given {@link AlignedBlock#AlignedBlock(IndentedPrintStream)} with out is
   * {@link IndentedPrintStream} align {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
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
    verify(out).print(eq("42"));
    verify(out).println(eq("Terminator"));
  }

  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String},
   * {@code String}.
   * <ul>
   *   <li>Then calls {@link IndentedPrintStream#println()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
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
    verify(out, atLeast(1)).print(eq(' '));
    verify(out, atLeast(1)).print(eq("42"));
    verify(out).println();
  }

  /**
   * Test {@link AlignedBlock#print(String, String)} with {@code String},
   * {@code String}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
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
    verify(out, atLeast(1)).print(eq(' '));
    verify(out, atLeast(1)).print(eq("42"));
    verify(out).println(eq("Terminator"));
  }

  /**
   * Test {@link AlignedBlock#print()}.
   * <ul>
   *   <li>Given {@link AlignedBlock#AlignedBlock(IndentedPrintStream)} with out is
   * {@link IndentedPrintStream} align {@code 42} and {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlignedBlock#print()}
   */
  @Test
  public void testPrint_givenAlignedBlockWithOutIsIndentedPrintStreamAlign42And42() {
    // Arrange
    IndentedPrintStream out = mock(IndentedPrintStream.class);
    doNothing().when(out).print(anyChar());
    doNothing().when(out).print(Mockito.<String>any());
    doNothing().when(out).println();

    AlignedBlock alignedBlock = new AlignedBlock(out);
    alignedBlock.align("42", "42");

    // Act
    alignedBlock.print();

    // Assert
    verify(out, atLeast(1)).print(eq(' '));
    verify(out, atLeast(1)).print(eq("42"));
    verify(out).println();
  }

  /**
   * Test {@link AlignedBlock#print()}.
   * <ul>
   *   <li>Given {@link AlignedBlock#AlignedBlock(IndentedPrintStream)} with out is
   * {@link IndentedPrintStream} align {@code 42}.</li>
   *   <li>Then calls {@link IndentedPrintStream#print(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlignedBlock#print()}
   */
  @Test
  public void testPrint_givenAlignedBlockWithOutIsIndentedPrintStreamAlign42_thenCallsPrint() {
    // Arrange
    IndentedPrintStream out = mock(IndentedPrintStream.class);
    doNothing().when(out).print(Mockito.<String>any());
    doNothing().when(out).println();

    AlignedBlock alignedBlock = new AlignedBlock(out);
    alignedBlock.align("42");

    // Act
    alignedBlock.print();

    // Assert
    verify(out).print(eq("42"));
    verify(out).println();
  }

  /**
   * Test {@link AlignedBlock#print()}.
   * <ul>
   *   <li>Given {@link AlignedBlock#AlignedBlock(IndentedPrintStream)} with out is
   * {@link IndentedPrintStream} align {@code null} and {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlignedBlock#print()}
   */
  @Test
  public void testPrint_givenAlignedBlockWithOutIsIndentedPrintStreamAlignNullAnd42() {
    // Arrange
    IndentedPrintStream out = mock(IndentedPrintStream.class);
    doNothing().when(out).print(anyChar());
    doNothing().when(out).print(Mockito.<String>any());
    doNothing().when(out).println();

    AlignedBlock alignedBlock = new AlignedBlock(out);
    alignedBlock.align(null, "42");

    // Act
    alignedBlock.print();

    // Assert
    verify(out, atLeast(1)).print(eq(' '));
    verify(out, atLeast(1)).print(Mockito.<String>any());
    verify(out).println();
  }
}
