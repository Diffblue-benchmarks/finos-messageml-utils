package org.symphonyoss.symphony.messageml.util;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.Test;

public class CountedOutputStreamDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CountedOutputStream#CountedOutputStream(OutputStream)}
   *   <li>{@link CountedOutputStream#beginUncounted()}
   *   <li>{@link CountedOutputStream#endUncounted()}
   *   <li>{@link CountedOutputStream#getOffset()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CountedOutputStream actualCountedOutputStream = new CountedOutputStream(new ByteArrayOutputStream(1));
    actualCountedOutputStream.beginUncounted();
    actualCountedOutputStream.endUncounted();

    // Assert that nothing has changed
    assertEquals(0L, actualCountedOutputStream.getOffset());
  }

  /**
   * Method under test: {@link CountedOutputStream#write(int)}
   */
  @Test
  public void testWrite() throws IOException {
    // Arrange
    CountedOutputStream countedOutputStream = new CountedOutputStream(new ByteArrayOutputStream(1));

    // Act
    countedOutputStream.write(19088743);

    // Assert
    assertEquals(1L, countedOutputStream.getOffset());
  }

  /**
   * Method under test: {@link CountedOutputStream#write(int)}
   */
  @Test
  public void testWrite2() throws IOException {
    // Arrange
    CountedOutputStream countedOutputStream = new CountedOutputStream(
        new CountedOutputStream(new ByteArrayOutputStream(1)));

    // Act
    countedOutputStream.write(19088743);

    // Assert
    assertEquals(1L, countedOutputStream.getOffset());
  }

  /**
   * Method under test: {@link CountedOutputStream#write(byte[])}
   */
  @Test
  public void testWrite3() throws IOException {
    // Arrange
    CountedOutputStream countedOutputStream = new CountedOutputStream(new ByteArrayOutputStream(1));

    // Act
    countedOutputStream.write("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(8L, countedOutputStream.getOffset());
  }

  /**
   * Method under test: {@link CountedOutputStream#write(byte[], int, int)}
   */
  @Test
  public void testWrite4() throws IOException {
    // Arrange
    CountedOutputStream countedOutputStream = new CountedOutputStream(new ByteArrayOutputStream(1));

    // Act
    countedOutputStream.write("AXAXAXAX".getBytes("UTF-8"), 1, 3);

    // Assert
    assertEquals(3L, countedOutputStream.getOffset());
  }
}
