package org.symphonyoss.symphony.messageml.util;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CountedOutputStreamDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CountedOutputStream#CountedOutputStream(OutputStream)}
   *   <li>{@link CountedOutputStream#beginUncounted()}
   *   <li>{@link CountedOutputStream#endUncounted()}
   *   <li>{@link CountedOutputStream#getOffset()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CountedOutputStream.<init>(OutputStream)", "void CountedOutputStream.beginUncounted()",
      "void CountedOutputStream.endUncounted()", "long CountedOutputStream.getOffset()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    CountedOutputStream actualCountedOutputStream = new CountedOutputStream(new ByteArrayOutputStream(1));
    actualCountedOutputStream.beginUncounted();
    actualCountedOutputStream.endUncounted();

    // Assert
    assertEquals(0L, actualCountedOutputStream.getOffset());
  }

  /**
   * Test {@link CountedOutputStream#write(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link CountedOutputStream#write(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CountedOutputStream.write(byte[])"})
  public void testWriteWithByte() throws IOException {
    // Arrange
    CountedOutputStream countedOutputStream = new CountedOutputStream(new ByteArrayOutputStream(1));

    // Act
    countedOutputStream.write("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(8L, countedOutputStream.getOffset());
  }

  /**
   * Test {@link CountedOutputStream#write(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <p>
   * Method under test: {@link CountedOutputStream#write(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CountedOutputStream.write(byte[], int, int)"})
  public void testWriteWithByteIntInt() throws IOException {
    // Arrange
    CountedOutputStream countedOutputStream = new CountedOutputStream(new ByteArrayOutputStream(1));

    // Act
    countedOutputStream.write("AXAXAXAX".getBytes("UTF-8"), 1, 3);

    // Assert
    assertEquals(3L, countedOutputStream.getOffset());
  }

  /**
   * Test {@link CountedOutputStream#write(int)} with {@code int}.
   * <p>
   * Method under test: {@link CountedOutputStream#write(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CountedOutputStream.write(int)"})
  public void testWriteWithInt() throws IOException {
    // Arrange
    CountedOutputStream countedOutputStream = new CountedOutputStream(new ByteArrayOutputStream(1));

    // Act
    countedOutputStream.write(19088743);

    // Assert
    assertEquals(1L, countedOutputStream.getOffset());
  }

  /**
   * Test {@link CountedOutputStream#write(int)} with {@code int}.
   * <ul>
   *   <li>Then {@link CountedOutputStream#CountedOutputStream(OutputStream)} with out is {@link CountedOutputStream#CountedOutputStream(OutputStream)} Offset is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountedOutputStream#write(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CountedOutputStream.write(int)"})
  public void testWriteWithInt_thenCountedOutputStreamWithOutIsCountedOutputStreamOffsetIsOne() throws IOException {
    // Arrange
    CountedOutputStream countedOutputStream = new CountedOutputStream(
        new CountedOutputStream(new ByteArrayOutputStream(1)));

    // Act
    countedOutputStream.write(19088743);

    // Assert
    assertEquals(1L, countedOutputStream.getOffset());
  }
}
