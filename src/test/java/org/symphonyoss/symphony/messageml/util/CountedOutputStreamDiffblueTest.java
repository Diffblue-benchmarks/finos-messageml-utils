package org.symphonyoss.symphony.messageml.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CountedOutputStreamDiffblueTest {
  @InjectMocks private CountedOutputStream countedOutputStream;

  @Mock private OutputStream outputStream;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CountedOutputStream#CountedOutputStream(OutputStream)}
   *   <li>{@link CountedOutputStream#beginUncounted()}
   *   <li>{@link CountedOutputStream#endUncounted()}
   *   <li>{@link CountedOutputStream#getOffset()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CountedOutputStream.<init>(OutputStream)",
    "void CountedOutputStream.beginUncounted()",
    "void CountedOutputStream.endUncounted()",
    "long CountedOutputStream.getOffset()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CountedOutputStream actualCountedOutputStream =
        new CountedOutputStream(new ByteArrayOutputStream());
    actualCountedOutputStream.beginUncounted();
    actualCountedOutputStream.endUncounted();

    // Assert
    assertEquals(0L, actualCountedOutputStream.getOffset());
  }

  /**
   * Test {@link CountedOutputStream#write(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link CountedOutputStream#write(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CountedOutputStream.write(byte[])"})
  public void testWriteWithByte() throws IOException {
    // Arrange
    CountedOutputStream countedOutputStream = new CountedOutputStream(new ByteArrayOutputStream());

    // Act
    countedOutputStream.write("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(8L, countedOutputStream.getOffset());
  }

  /**
   * Test {@link CountedOutputStream#write(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link CountedOutputStream#write(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CountedOutputStream.write(byte[])"})
  public void testWriteWithByte2() throws IOException {
    // Arrange
    CountedOutputStream countedOutputStream =
        new CountedOutputStream(new CountedOutputStream(new ByteArrayOutputStream()));

    // Act
    countedOutputStream.write("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(8L, countedOutputStream.getOffset());
  }

  /**
   * Test {@link CountedOutputStream#write(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <p>Method under test: {@link CountedOutputStream#write(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CountedOutputStream.write(byte[], int, int)"})
  public void testWriteWithByteIntInt() throws IOException {
    // Arrange
    CountedOutputStream countedOutputStream = new CountedOutputStream(new ByteArrayOutputStream());

    // Act
    countedOutputStream.write("AXAXAXAX".getBytes("UTF-8"), 1, 3);

    // Assert
    assertEquals(3L, countedOutputStream.getOffset());
  }

  /**
   * Test {@link CountedOutputStream#write(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <p>Method under test: {@link CountedOutputStream#write(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CountedOutputStream.write(byte[], int, int)"})
  public void testWriteWithByteIntInt2() throws IOException {
    // Arrange
    CountedOutputStream countedOutputStream =
        new CountedOutputStream(new CountedOutputStream(new ByteArrayOutputStream()));

    // Act
    countedOutputStream.write("AXAXAXAX".getBytes("UTF-8"), 1, 3);

    // Assert
    assertEquals(3L, countedOutputStream.getOffset());
  }

  /**
   * Test {@link CountedOutputStream#write(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CountedOutputStream#write(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CountedOutputStream.write(byte[], int, int)"})
  public void testWriteWithByteIntInt_thenThrowIOException() throws IOException {
    // Arrange
    doThrow(new IOException()).when(outputStream).write(Mockito.<byte[]>any(), anyInt(), anyInt());

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> countedOutputStream.write("AXAXAXAX".getBytes("UTF-8"), 19088743, 3));
    verify(outputStream).write(isA(byte[].class), eq(19088743), eq(3));
  }

  /**
   * Test {@link CountedOutputStream#write(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>Given {@link OutputStream} {@link OutputStream#write(byte[])} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CountedOutputStream#write(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CountedOutputStream.write(byte[])"})
  public void testWriteWithByte_givenOutputStreamWriteThrowIOException_thenThrowIOException()
      throws IOException {
    // Arrange
    doThrow(new IOException()).when(outputStream).write(Mockito.<byte[]>any());

    // Act and Assert
    assertThrows(IOException.class, () -> countedOutputStream.write("AXAXAXAX".getBytes("UTF-8")));
    verify(outputStream).write(isA(byte[].class));
  }

  /**
   * Test {@link CountedOutputStream#write(int)} with {@code int}.
   *
   * <p>Method under test: {@link CountedOutputStream#write(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CountedOutputStream.write(int)"})
  public void testWriteWithInt() throws IOException {
    // Arrange
    CountedOutputStream countedOutputStream = new CountedOutputStream(new ByteArrayOutputStream());

    // Act
    countedOutputStream.write(19088743);

    // Assert
    assertEquals(1L, countedOutputStream.getOffset());
  }

  /**
   * Test {@link CountedOutputStream#write(int)} with {@code int}.
   *
   * <ul>
   *   <li>Given {@link OutputStream} {@link OutputStream#write(int)} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CountedOutputStream#write(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CountedOutputStream.write(int)"})
  public void testWriteWithInt_givenOutputStreamWriteThrowIOException_thenThrowIOException()
      throws IOException {
    // Arrange
    doThrow(new IOException()).when(outputStream).write(anyInt());

    // Act and Assert
    assertThrows(IOException.class, () -> countedOutputStream.write(19088743));
    verify(outputStream).write(19088743);
  }

  /**
   * Test {@link CountedOutputStream#write(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link CountedOutputStream#CountedOutputStream(OutputStream)} with out is {@link
   *       CountedOutputStream#CountedOutputStream(OutputStream)} Offset is one.
   * </ul>
   *
   * <p>Method under test: {@link CountedOutputStream#write(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CountedOutputStream.write(int)"})
  public void testWriteWithInt_thenCountedOutputStreamWithOutIsCountedOutputStreamOffsetIsOne()
      throws IOException {
    // Arrange
    CountedOutputStream countedOutputStream =
        new CountedOutputStream(new CountedOutputStream(new ByteArrayOutputStream()));

    // Act
    countedOutputStream.write(19088743);

    // Assert
    assertEquals(1L, countedOutputStream.getOffset());
  }

  /**
   * Test {@link CountedOutputStream#close()}.
   *
   * <ul>
   *   <li>Given {@link OutputStream} {@link OutputStream#close()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link CountedOutputStream#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CountedOutputStream.close()"})
  public void testClose_givenOutputStreamCloseDoesNothing() throws IOException {
    // Arrange
    doNothing().when(outputStream).close();

    // Act
    countedOutputStream.close();

    // Assert
    verify(outputStream).close();
  }

  /**
   * Test {@link CountedOutputStream#close()}.
   *
   * <ul>
   *   <li>Given {@link OutputStream} {@link OutputStream#close()} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CountedOutputStream#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CountedOutputStream.close()"})
  public void testClose_givenOutputStreamCloseThrowIOException_thenThrowIOException()
      throws IOException {
    // Arrange
    doThrow(new IOException()).when(outputStream).close();

    // Act and Assert
    assertThrows(IOException.class, () -> countedOutputStream.close());
    verify(outputStream).close();
  }

  /**
   * Test {@link CountedOutputStream#flush()}.
   *
   * <ul>
   *   <li>Given {@link OutputStream} {@link OutputStream#flush()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link CountedOutputStream#flush()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CountedOutputStream.flush()"})
  public void testFlush_givenOutputStreamFlushDoesNothing() throws IOException {
    // Arrange
    doNothing().when(outputStream).flush();

    // Act
    countedOutputStream.flush();

    // Assert
    verify(outputStream).flush();
  }

  /**
   * Test {@link CountedOutputStream#flush()}.
   *
   * <ul>
   *   <li>Given {@link OutputStream} {@link OutputStream#flush()} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CountedOutputStream#flush()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CountedOutputStream.flush()"})
  public void testFlush_givenOutputStreamFlushThrowIOException_thenThrowIOException()
      throws IOException {
    // Arrange
    doThrow(new IOException()).when(outputStream).flush();

    // Act and Assert
    assertThrows(IOException.class, () -> countedOutputStream.flush());
    verify(outputStream).flush();
  }
}
