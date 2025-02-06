package org.symphonyoss.symphony.messageml.util;

import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class NullErrorHandlerDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NullErrorHandler}
   *   <li>{@link NullErrorHandler#error(SAXParseException)}
   *   <li>{@link NullErrorHandler#fatalError(SAXParseException)}
   *   <li>{@link NullErrorHandler#warning(SAXParseException)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws SAXException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    NullErrorHandler actualNullErrorHandler = new NullErrorHandler();
    actualNullErrorHandler.error(new SAXParseException("foo", "foo", "foo", 1, 1));
    actualNullErrorHandler.fatalError(new SAXParseException("foo", "foo", "foo", 1, 1));
    actualNullErrorHandler.warning(new SAXParseException("foo", "foo", "foo", 1, 1));
  }
}
