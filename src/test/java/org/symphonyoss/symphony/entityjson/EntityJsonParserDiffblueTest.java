package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jsonschema.core.report.ListProcessingReport;
import com.github.fge.jsonschema.core.report.LogLevel;
import java.io.Reader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import org.junit.Test;

public class EntityJsonParserDiffblueTest {
  /**
   * Method under test: {@link EntityJsonParser#parseEntityJson(Object, Reader)}
   */
  @Test
  public void testParseEntityJson() throws InvalidInstanceException, SchemaValidationException {
    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);

    // Act and Assert
    assertThrows(InvalidInstanceException.class,
        () -> entityJsonParser.parseEntityJson("Instance Source", new StringReader("foo")));
  }

  /**
   * Method under test: {@link EntityJsonParser#parseEntityJson(URL)}
   */
  @Test
  public void testParseEntityJson2() throws MalformedURLException, InvalidInstanceException, SchemaValidationException {
    // Arrange, Act and Assert
    assertThrows(InvalidInstanceException.class, () -> (new EntityJsonParser(true))
        .parseEntityJson(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Method under test: {@link EntityJsonParser#parseEntityJson(URL)}
   */
  @Test
  public void testParseEntityJson3() throws MalformedURLException, InvalidInstanceException, SchemaValidationException {
    // Arrange, Act and Assert
    assertThrows(InvalidInstanceException.class, () -> (new EntityJsonParser(true))
        .parseEntityJson(Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Method under test:
   * {@link EntityJsonParser#parseStructuredObject(Object, Reader)}
   */
  @Test
  public void testParseStructuredObject() throws InvalidInstanceException, SchemaValidationException {
    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);

    // Act and Assert
    assertThrows(InvalidInstanceException.class,
        () -> entityJsonParser.parseStructuredObject("Instance Source", new StringReader("foo")));
  }

  /**
   * Method under test: {@link EntityJsonParser#parseStructuredObject(URL)}
   */
  @Test
  public void testParseStructuredObject2()
      throws MalformedURLException, InvalidInstanceException, SchemaValidationException {
    // Arrange, Act and Assert
    assertThrows(InvalidInstanceException.class, () -> (new EntityJsonParser(true))
        .parseStructuredObject(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Method under test: {@link EntityJsonParser#parseStructuredObject(URL)}
   */
  @Test
  public void testParseStructuredObject3()
      throws MalformedURLException, InvalidInstanceException, SchemaValidationException {
    // Arrange, Act and Assert
    assertThrows(InvalidInstanceException.class, () -> (new EntityJsonParser(true))
        .parseStructuredObject(Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Method under test:
   * {@link EntityJsonParser#validate(Object, ObjectNode, Object, ObjectNode)}
   */
  @Test
  public void testValidate() throws SchemaValidationException {
    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);
    ObjectNode schema = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));
    ObjectNode instance = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    IEntityJsonSchemaContext actualValidateResult = entityJsonParser.validate(1, schema, "Instance Source", instance);

    // Assert
    Object validationResult = actualValidateResult.getValidationResult();
    assertTrue(validationResult instanceof ListProcessingReport);
    assertTrue(actualValidateResult instanceof EntityJsonContext);
    assertEquals("Instance Source", actualValidateResult.getInstanceSource());
    assertEquals(LogLevel.FATAL, ((ListProcessingReport) validationResult).getExceptionThreshold());
    assertEquals(LogLevel.INFO, ((ListProcessingReport) validationResult).getLogLevel());
    assertSame(instance, actualValidateResult.getInstanceJsonNode());
    assertSame(schema, actualValidateResult.getSchemaJsonNode());
  }

  /**
   * Method under test: {@link EntityJsonParser#validate(URL, Object, ObjectNode)}
   */
  @Test
  public void testValidate2()
      throws MalformedURLException, InvalidSchemaException, NoSchemaException, SchemaValidationException {
    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);
    URL schemaUrl = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    // Act and Assert
    assertThrows(NoSchemaException.class, () -> entityJsonParser.validate(schemaUrl, "Instance Source",
        new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))));
  }

  /**
   * Method under test: {@link EntityJsonParser#validate(URL, Object, ObjectNode)}
   */
  @Test
  public void testValidate3()
      throws MalformedURLException, InvalidSchemaException, NoSchemaException, SchemaValidationException {
    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);
    URL schemaUrl = Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL();

    // Act and Assert
    assertThrows(InvalidSchemaException.class, () -> entityJsonParser.validate(schemaUrl, "Instance Source",
        new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))));
  }

  /**
   * Method under test: {@link EntityJsonParser#validate(URL, Object, Reader)}
   */
  @Test
  public void testValidate4()
      throws InvalidInstanceException, InvalidSchemaException, NoSchemaException, SchemaValidationException {
    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);

    // Act and Assert
    assertThrows(InvalidInstanceException.class, () -> entityJsonParser.validate(EntityJsonParser.BOND_RFQ_EXAMPLE_URL,
        "Instance Source", new StringReader("foo")));
  }

  /**
   * Method under test: {@link EntityJsonParser#validate(URL, URL)}
   */
  @Test
  public void testValidate5() throws MalformedURLException, InvalidInstanceException, InvalidSchemaException,
      NoSchemaException, SchemaValidationException {
    // Arrange, Act and Assert
    assertThrows(InvalidInstanceException.class,
        () -> (new EntityJsonParser(true)).validate(EntityJsonParser.BOND_RFQ_EXAMPLE_URL,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Method under test: {@link EntityJsonParser#validate(URL, URL)}
   */
  @Test
  public void testValidate6() throws MalformedURLException, InvalidInstanceException, InvalidSchemaException,
      NoSchemaException, SchemaValidationException {
    // Arrange, Act and Assert
    assertThrows(InvalidInstanceException.class,
        () -> (new EntityJsonParser(true)).validate(EntityJsonParser.BOND_RFQ_EXAMPLE_URL,
            Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }
}
