package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jsonschema.core.report.ListProcessingReport;
import java.io.Reader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EntityJsonParserDiffblueTest {
  /**
   * Test {@link EntityJsonParser#parseEntityJson(Object, Reader)} with {@code instanceSource},
   * {@code instanceReader}.
   *
   * <p>Method under test: {@link EntityJsonParser#parseEntityJson(Object, Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.entityjson.EntityJson EntityJsonParser.parseEntityJson(Object, Reader)"
  })
  public void testParseEntityJsonWithInstanceSourceInstanceReader()
      throws InvalidInstanceException, SchemaValidationException {
    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);

    // Act and Assert
    assertThrows(
        InvalidInstanceException.class,
        () -> entityJsonParser.parseEntityJson("Instance Source", new StringReader("foo")));
  }

  /**
   * Test {@link EntityJsonParser#parseEntityJson(Object, Reader)} with {@code instanceSource},
   * {@code instanceReader}.
   *
   * <p>Method under test: {@link EntityJsonParser#parseEntityJson(Object, Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.entityjson.EntityJson EntityJsonParser.parseEntityJson(Object, Reader)"
  })
  public void testParseEntityJsonWithInstanceSourceInstanceReader2()
      throws InvalidInstanceException, SchemaValidationException {
    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(false);

    // Act and Assert
    assertThrows(
        InvalidInstanceException.class,
        () -> entityJsonParser.parseEntityJson("Instance Source", new StringReader("foo")));
  }

  /**
   * Test {@link EntityJsonParser#parseEntityJson(URL)} with {@code instanceUrl}.
   *
   * <p>Method under test: {@link EntityJsonParser#parseEntityJson(URL)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.entityjson.EntityJson EntityJsonParser.parseEntityJson(URL)"
  })
  public void testParseEntityJsonWithInstanceUrl()
      throws MalformedURLException, InvalidInstanceException, SchemaValidationException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInstanceException.class,
        () ->
            new EntityJsonParser(true)
                .parseEntityJson(
                    Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Test {@link EntityJsonParser#parseEntityJson(URL)} with {@code instanceUrl}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toUri toURL.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonParser#parseEntityJson(URL)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.entityjson.EntityJson EntityJsonParser.parseEntityJson(URL)"
  })
  public void testParseEntityJsonWithInstanceUrl_whenPropertyIsJavaIoTmpdirIsTestTxtToUriToURL()
      throws MalformedURLException, InvalidInstanceException, SchemaValidationException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInstanceException.class,
        () ->
            new EntityJsonParser(true)
                .parseEntityJson(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Test {@link EntityJsonParser#parseStructuredObject(Object, Reader)} with {@code
   * instanceSource}, {@code instanceReader}.
   *
   * <p>Method under test: {@link EntityJsonParser#parseStructuredObject(Object, Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.entityjson.StructuredObject EntityJsonParser.parseStructuredObject(Object, Reader)"
  })
  public void testParseStructuredObjectWithInstanceSourceInstanceReader()
      throws InvalidInstanceException, SchemaValidationException {
    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);

    // Act and Assert
    assertThrows(
        InvalidInstanceException.class,
        () -> entityJsonParser.parseStructuredObject("Instance Source", new StringReader("foo")));
  }

  /**
   * Test {@link EntityJsonParser#parseStructuredObject(URL)} with {@code instanceUrl}.
   *
   * <p>Method under test: {@link EntityJsonParser#parseStructuredObject(URL)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.entityjson.StructuredObject EntityJsonParser.parseStructuredObject(URL)"
  })
  public void testParseStructuredObjectWithInstanceUrl()
      throws MalformedURLException, InvalidInstanceException, SchemaValidationException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInstanceException.class,
        () ->
            new EntityJsonParser(true)
                .parseStructuredObject(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Test {@link EntityJsonParser#parseStructuredObject(URL)} with {@code instanceUrl}.
   *
   * <p>Method under test: {@link EntityJsonParser#parseStructuredObject(URL)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.symphonyoss.symphony.entityjson.StructuredObject EntityJsonParser.parseStructuredObject(URL)"
  })
  public void testParseStructuredObjectWithInstanceUrl2()
      throws MalformedURLException, InvalidInstanceException, SchemaValidationException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidInstanceException.class,
        () ->
            new EntityJsonParser(true)
                .parseStructuredObject(
                    Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Test {@link EntityJsonParser#validate(Object, ObjectNode, Object, ObjectNode)} with {@code
   * schemaSource}, {@code schema}, {@code instanceSource}, {@code instance}.
   *
   * <p>Method under test: {@link EntityJsonParser#validate(Object, ObjectNode, Object, ObjectNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IEntityJsonSchemaContext EntityJsonParser.validate(Object, ObjectNode, Object, ObjectNode)"
  })
  public void testValidateWithSchemaSourceSchemaInstanceSourceInstance()
      throws SchemaValidationException {
    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode schema = new ObjectNode(nc);
    JsonNodeFactory nc2 = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode instance = new ObjectNode(nc2);

    // Act
    IEntityJsonSchemaContext actualValidateResult =
        entityJsonParser.validate("Schema Source", schema, "Instance Source", instance);

    // Assert
    assertTrue(actualValidateResult.getValidationResult() instanceof ListProcessingReport);
    assertTrue(actualValidateResult instanceof EntityJsonContext);
    assertEquals("Instance Source", actualValidateResult.getInstanceSource());
    assertEquals("Schema Source", actualValidateResult.getSchemaSource());
    assertSame(instance, actualValidateResult.getInstanceJsonNode());
    assertSame(schema, actualValidateResult.getSchemaJsonNode());
  }

  /**
   * Test {@link EntityJsonParser#validate(URL, Object, ObjectNode)} with {@code schemaUrl}, {@code
   * instanceSource}, {@code instance}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidSchemaException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonParser#validate(URL, Object, ObjectNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IEntityJsonSchemaContext EntityJsonParser.validate(URL, Object, ObjectNode)"})
  public void testValidateWithSchemaUrlInstanceSourceInstance_thenThrowInvalidSchemaException()
      throws MalformedURLException,
          InvalidSchemaException,
          NoSchemaException,
          SchemaValidationException {
    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);
    URL schemaUrl = Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    // Act and Assert
    assertThrows(
        InvalidSchemaException.class,
        () -> entityJsonParser.validate(schemaUrl, "Instance Source", new ObjectNode(nc)));
  }

  /**
   * Test {@link EntityJsonParser#validate(URL, Object, ObjectNode)} with {@code schemaUrl}, {@code
   * instanceSource}, {@code instance}.
   *
   * <ul>
   *   <li>Then throw {@link NoSchemaException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonParser#validate(URL, Object, ObjectNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IEntityJsonSchemaContext EntityJsonParser.validate(URL, Object, ObjectNode)"})
  public void testValidateWithSchemaUrlInstanceSourceInstance_thenThrowNoSchemaException()
      throws MalformedURLException,
          InvalidSchemaException,
          NoSchemaException,
          SchemaValidationException {
    // Arrange
    EntityJsonParser entityJsonParser = new EntityJsonParser(true);
    URL schemaUrl = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    // Act and Assert
    assertThrows(
        NoSchemaException.class,
        () -> entityJsonParser.validate(schemaUrl, "Instance Source", new ObjectNode(nc)));
  }
}
