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
   * Method under test: {@link AlignedBlock#print()}
   */
  @Test
  public void testPrint() {
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
   * Method under test: {@link AlignedBlock#print()}
   */
  @Test
  public void testPrint2() {
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
   * Method under test: {@link AlignedBlock#print()}
   */
  @Test
  public void testPrint3() {
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

  /**
   * Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  public void testPrint4() {
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
   * Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  public void testPrint5() {
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
   * Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  public void testPrint6() {
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
   * Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  public void testPrint7() {
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
   * Method under test: {@link AlignedBlock#print(String, String)}
   */
  @Test
  public void testPrint8() {
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
}
