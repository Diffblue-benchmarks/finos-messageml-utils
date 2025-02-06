package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jsonschema.core.report.ListProcessingReport;
import java.io.Reader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import org.junit.Ignore;
import org.junit.Test;

public class EntityJsonParserDiffblueTest {
  /**
   * Test {@link EntityJsonParser#EntityJsonParser(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonParser#EntityJsonParser(boolean)}
   */
  @Test
  public void testNewEntityJsonParser_whenTrue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     EntityJsonParser.factory_

    // Arrange and Act
    new EntityJsonParser(true);
  }

  /**
   * Test {@link EntityJsonParser#parseEntityJson(Object, ObjectNode)} with
   * {@code instanceSource}, {@code instance}.
   * <p>
   * Method under test:
   * {@link EntityJsonParser#parseEntityJson(Object, ObjectNode)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testParseEntityJsonWithInstanceSourceInstance()
      throws InvalidInstanceException, SchemaValidationException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);

    // Act
    entityJsonParser.parseEntityJson("Instance Source", new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));
  }

  /**
   * Test {@link EntityJsonParser#parseEntityJson(Object, Reader)} with
   * {@code instanceSource}, {@code instanceReader}.
   * <p>
   * Method under test: {@link EntityJsonParser#parseEntityJson(Object, Reader)}
   */
  @Test
  public void testParseEntityJsonWithInstanceSourceInstanceReader()
      throws InvalidInstanceException, SchemaValidationException {
    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);

    // Act and Assert
    assertThrows(InvalidInstanceException.class,
        () -> entityJsonParser.parseEntityJson("Instance Source", new StringReader("foo")));
  }

  /**
   * Test {@link EntityJsonParser#parseEntityJson(URL)} with {@code instanceUrl}.
   * <p>
   * Method under test: {@link EntityJsonParser#parseEntityJson(URL)}
   */
  @Test
  public void testParseEntityJsonWithInstanceUrl()
      throws MalformedURLException, InvalidInstanceException, SchemaValidationException {
    // Arrange, Act and Assert
    assertThrows(InvalidInstanceException.class, () -> (new EntityJsonParser(true))
        .parseEntityJson(Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Test {@link EntityJsonParser#parseEntityJson(URL)} with {@code instanceUrl}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toUri
   * toURL.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonParser#parseEntityJson(URL)}
   */
  @Test
  public void testParseEntityJsonWithInstanceUrl_whenPropertyIsJavaIoTmpdirIsTestTxtToUriToURL()
      throws MalformedURLException, InvalidInstanceException, SchemaValidationException {
    // Arrange, Act and Assert
    assertThrows(InvalidInstanceException.class, () -> (new EntityJsonParser(true))
        .parseEntityJson(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Test {@link EntityJsonParser#parseStructuredObject(Object, ObjectNode)} with
   * {@code instanceSource}, {@code instance}.
   * <p>
   * Method under test:
   * {@link EntityJsonParser#parseStructuredObject(Object, ObjectNode)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testParseStructuredObjectWithInstanceSourceInstance() throws SchemaValidationException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Sandboxing policy violation.
    //   Diffblue Cover ran code in your project that tried
    //     to access the network.
    //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
    //   your code from damaging your system environment.
    //   See https://diff.blue/R011 to resolve this issue.

    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);

    // Act
    entityJsonParser.parseStructuredObject("Instance Source",
        new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));
  }

  /**
   * Test {@link EntityJsonParser#parseStructuredObject(Object, Reader)} with
   * {@code instanceSource}, {@code instanceReader}.
   * <p>
   * Method under test:
   * {@link EntityJsonParser#parseStructuredObject(Object, Reader)}
   */
  @Test
  public void testParseStructuredObjectWithInstanceSourceInstanceReader()
      throws InvalidInstanceException, SchemaValidationException {
    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);

    // Act and Assert
    assertThrows(InvalidInstanceException.class,
        () -> entityJsonParser.parseStructuredObject("Instance Source", new StringReader("foo")));
  }

  /**
   * Test {@link EntityJsonParser#parseStructuredObject(URL)} with
   * {@code instanceUrl}.
   * <p>
   * Method under test: {@link EntityJsonParser#parseStructuredObject(URL)}
   */
  @Test
  public void testParseStructuredObjectWithInstanceUrl()
      throws MalformedURLException, InvalidInstanceException, SchemaValidationException {
    // Arrange, Act and Assert
    assertThrows(InvalidInstanceException.class, () -> (new EntityJsonParser(true))
        .parseStructuredObject(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
    assertThrows(InvalidInstanceException.class, () -> (new EntityJsonParser(true))
        .parseStructuredObject(Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Test
   * {@link EntityJsonParser#validate(Object, ObjectNode, Object, ObjectNode)}
   * with {@code schemaSource}, {@code schema}, {@code instanceSource},
   * {@code instance}.
   * <p>
   * Method under test:
   * {@link EntityJsonParser#validate(Object, ObjectNode, Object, ObjectNode)}
   */
  @Test
  public void testValidateWithSchemaSourceSchemaInstanceSourceInstance() throws SchemaValidationException {
    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);
    ObjectNode schema = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));
    ObjectNode instance = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    IEntityJsonSchemaContext actualValidateResult = entityJsonParser.validate("Schema Source", schema,
        "Instance Source", instance);

    // Assert
    assertTrue(actualValidateResult.getValidationResult() instanceof ListProcessingReport);
    assertTrue(actualValidateResult instanceof EntityJsonContext);
    assertEquals("Instance Source", actualValidateResult.getInstanceSource());
    assertEquals("Schema Source", actualValidateResult.getSchemaSource());
    assertSame(instance, actualValidateResult.getInstanceJsonNode());
    assertSame(schema, actualValidateResult.getSchemaJsonNode());
  }

  /**
   * Test {@link EntityJsonParser#validate(URL, Object, Reader)} with
   * {@code schemaUrl}, {@code instanceSource}, {@code in}.
   * <ul>
   *   <li>Then throw {@link InvalidInstanceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonParser#validate(URL, Object, Reader)}
   */
  @Test
  public void testValidateWithSchemaUrlInstanceSourceIn_thenThrowInvalidInstanceException()
      throws InvalidInstanceException, InvalidSchemaException, NoSchemaException, SchemaValidationException {
    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);

    // Act and Assert
    assertThrows(InvalidInstanceException.class, () -> entityJsonParser.validate(EntityJsonParser.BOND_RFQ_EXAMPLE_URL,
        "Instance Source", new StringReader("foo")));
  }

  /**
   * Test {@link EntityJsonParser#validate(URL, Object, ObjectNode)} with
   * {@code schemaUrl}, {@code instanceSource}, {@code instance}.
   * <ul>
   *   <li>Then throw {@link InvalidSchemaException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonParser#validate(URL, Object, ObjectNode)}
   */
  @Test
  public void testValidateWithSchemaUrlInstanceSourceInstance_thenThrowInvalidSchemaException()
      throws MalformedURLException, InvalidSchemaException, NoSchemaException, SchemaValidationException {
    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);
    URL schemaUrl = Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL();

    // Act and Assert
    assertThrows(InvalidSchemaException.class, () -> entityJsonParser.validate(schemaUrl, "Instance Source",
        new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))));
  }

  /**
   * Test {@link EntityJsonParser#validate(URL, Object, ObjectNode)} with
   * {@code schemaUrl}, {@code instanceSource}, {@code instance}.
   * <ul>
   *   <li>Then throw {@link NoSchemaException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonParser#validate(URL, Object, ObjectNode)}
   */
  @Test
  public void testValidateWithSchemaUrlInstanceSourceInstance_thenThrowNoSchemaException()
      throws MalformedURLException, InvalidSchemaException, NoSchemaException, SchemaValidationException {
    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);
    URL schemaUrl = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    // Act and Assert
    assertThrows(NoSchemaException.class, () -> entityJsonParser.validate(schemaUrl, "Instance Source",
        new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))));
  }

  /**
   * Test {@link EntityJsonParser#validate(URL, URL)} with {@code schemaUrl},
   * {@code instanceUrl}.
   * <p>
   * Method under test: {@link EntityJsonParser#validate(URL, URL)}
   */
  @Test
  public void testValidateWithSchemaUrlInstanceUrl() throws MalformedURLException, InvalidInstanceException,
      InvalidSchemaException, NoSchemaException, SchemaValidationException {
    // Arrange, Act and Assert
    assertThrows(InvalidInstanceException.class,
        () -> (new EntityJsonParser(true)).validate(EntityJsonParser.BOND_RFQ_EXAMPLE_URL,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
    assertThrows(InvalidInstanceException.class,
        () -> (new EntityJsonParser(true)).validate(EntityJsonParser.BOND_RFQ_EXAMPLE_URL,
            Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }
}
