package org.symphonyoss.symphony.messageml.util;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.Ignore;
import org.junit.Test;

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
  public void testWriteWithByte() throws IOException {
    // Arrange
    CountedOutputStream countedOutputStream = new CountedOutputStream(new ByteArrayOutputStream(1));

    // Act
    countedOutputStream.write("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(8L, countedOutputStream.getOffset());
  }

  /**
   * Test {@link CountedOutputStream#write(byte[], int, int)} with {@code byte[]},
   * {@code int}, {@code int}.
   * <p>
   * Method under test: {@link CountedOutputStream#write(byte[], int, int)}
   */
  @Test
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
   *   <li>Then {@link CountedOutputStream#CountedOutputStream(OutputStream)} with
   * out is {@link CountedOutputStream#CountedOutputStream(OutputStream)} Offset
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountedOutputStream#write(int)}
   */
  @Test
  public void testWriteWithInt_thenCountedOutputStreamWithOutIsCountedOutputStreamOffsetIsOne() throws IOException {
    // Arrange
    CountedOutputStream countedOutputStream = new CountedOutputStream(
        new CountedOutputStream(new ByteArrayOutputStream(1)));

    // Act
    countedOutputStream.write(19088743);

    // Assert
    assertEquals(1L, countedOutputStream.getOffset());
  }

  /**
   * Test {@link CountedOutputStream#close()}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountedOutputStream#close()}
   */
  @Test
  public void testClose_givenByteArrayOutputStreamWithOne() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new CountedOutputStream(new ByteArrayOutputStream(1))).close();
  }

  /**
   * Test {@link CountedOutputStream#close()}.
   * <ul>
   *   <li>Given {@link CountedOutputStream#CountedOutputStream(OutputStream)} with
   * out is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountedOutputStream#close()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClose_givenCountedOutputStreamWithOutIsNull() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.symphonyoss.symphony.messageml.util.CountedOutputStream.close(CountedOutputStream.java:72)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new CountedOutputStream(null)).close();
  }

  /**
   * Test {@link CountedOutputStream#flush()}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountedOutputStream#flush()}
   */
  @Test
  public void testFlush_givenByteArrayOutputStreamWithOne() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new CountedOutputStream(new ByteArrayOutputStream(1))).flush();
  }

  /**
   * Test {@link CountedOutputStream#flush()}.
   * <ul>
   *   <li>Given {@link CountedOutputStream#CountedOutputStream(OutputStream)} with
   * out is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountedOutputStream#flush()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFlush_givenCountedOutputStreamWithOutIsNull() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.symphonyoss.symphony.messageml.util.CountedOutputStream.flush(CountedOutputStream.java:77)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new CountedOutputStream(null)).flush();
  }
}
