package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EntityJsonContextDiffblueTest {
  @InjectMocks private EntityJsonContext entityJsonContext;

  @Mock private Object object;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityJsonContext}
   *   <li>{@link EntityJsonContext#withValidationResult(Object)}
   *   <li>{@link EntityJsonContext#getInstanceJsonNode()}
   *   <li>{@link EntityJsonContext#getInstanceSource()}
   *   <li>{@link EntityJsonContext#getSchemaJsonNode()}
   *   <li>{@link EntityJsonContext#getSchemaSource()}
   *   <li>{@link EntityJsonContext#getValidationResult()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityJsonContext.<init>()",
    "ObjectNode EntityJsonContext.getInstanceJsonNode()",
    "Object EntityJsonContext.getInstanceSource()",
    "ObjectNode EntityJsonContext.getSchemaJsonNode()",
    "Object EntityJsonContext.getSchemaSource()",
    "Object EntityJsonContext.getValidationResult()",
    "IEntityJsonSchemaContext EntityJsonContext.withValidationResult(Object)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityJsonContext actualEntityJsonContext = new EntityJsonContext();
    IEntityJsonSchemaContext actualWithValidationResultResult =
        actualEntityJsonContext.withValidationResult("Validation Result");
    ObjectNode actualInstanceJsonNode = actualEntityJsonContext.getInstanceJsonNode();
    Object actualInstanceSource = actualEntityJsonContext.getInstanceSource();
    ObjectNode actualSchemaJsonNode = actualEntityJsonContext.getSchemaJsonNode();
    Object actualSchemaSource = actualEntityJsonContext.getSchemaSource();

    // Assert
    assertEquals("Validation Result", actualEntityJsonContext.getValidationResult());
    assertNull(actualInstanceJsonNode);
    assertNull(actualSchemaJsonNode);
    assertNull(actualInstanceSource);
    assertNull(actualSchemaSource);
    assertSame(actualEntityJsonContext, actualWithValidationResultResult);
  }

  /**
   * Test {@link EntityJsonContext#newInstance()}.
   *
   * <p>Method under test: {@link EntityJsonContext#newInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IEntityJsonContext EntityJsonContext.newInstance()"})
  public void testNewInstance() {
    // Arrange and Act
    IEntityJsonContext actualNewInstanceResult = EntityJsonContext.newInstance();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode objectNode = new ObjectNode(nc);
    IEntityJsonInstanceContext actualWithInstanceResult =
        actualNewInstanceResult.withInstance("42", objectNode);

    // Assert
    assertTrue(actualNewInstanceResult instanceof EntityJsonContext);
    assertEquals("42", ((EntityJsonContext) actualNewInstanceResult).getInstanceSource());
    assertNull(((EntityJsonContext) actualNewInstanceResult).getSchemaJsonNode());
    assertNull(((EntityJsonContext) actualNewInstanceResult).getSchemaSource());
    assertNull(((EntityJsonContext) actualNewInstanceResult).getValidationResult());
    assertSame(objectNode, ((EntityJsonContext) actualNewInstanceResult).getInstanceJsonNode());
    assertSame(actualNewInstanceResult, actualWithInstanceResult);
  }

  /**
   * Test {@link EntityJsonContext#withSchema(Object, ObjectNode)}.
   *
   * <p>Method under test: {@link EntityJsonContext#withSchema(Object, ObjectNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IEntityJsonSchemaContext EntityJsonContext.withSchema(Object, ObjectNode)"})
  public void testWithSchema() {
    // Arrange
    EntityJsonContext entityJsonContext = new EntityJsonContext();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode schemaJsonNode = new ObjectNode(nc);

    // Act
    IEntityJsonSchemaContext actualWithSchemaResult =
        entityJsonContext.withSchema("Schema Source", schemaJsonNode);

    // Assert
    assertEquals("Schema Source", entityJsonContext.getSchemaSource());
    assertSame(schemaJsonNode, entityJsonContext.getSchemaJsonNode());
    assertSame(entityJsonContext, actualWithSchemaResult);
  }

  /**
   * Test {@link EntityJsonContext#toString()}.
   *
   * <ul>
   *   <li>Given {@link EntityJsonContext} (default constructor).
   *   <li>Then return {@code EntityJsonContext}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonContext#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EntityJsonContext.toString()"})
  public void testToString_givenEntityJsonContext_thenReturnEntityJsonContext() {
    // Arrange, Act and Assert
    assertEquals("EntityJsonContext", new EntityJsonContext().toString());
  }

  /**
   * Test {@link EntityJsonContext#toString()}.
   *
   * <ul>
   *   <li>Given {@link Object}.
   *   <li>Then return {@code EntityJsonContext instanceSource="object"}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonContext#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EntityJsonContext.toString()"})
  public void testToString_givenObject_thenReturnEntityJsonContextInstanceSourceObject() {
    // Arrange, Act and Assert
    assertEquals("EntityJsonContext instanceSource=\"object\"", entityJsonContext.toString());
  }

  /**
   * Test {@link EntityJsonContext#toString()}.
   *
   * <ul>
   *   <li>Then return {@code EntityJsonContext validationResult="Validation Result"}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonContext#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EntityJsonContext.toString()"})
  public void testToString_thenReturnEntityJsonContextValidationResultValidationResult() {
    // Arrange
    EntityJsonContext entityJsonContext = new EntityJsonContext();
    entityJsonContext.withValidationResult("Validation Result");

    // Act and Assert
    assertEquals(
        "EntityJsonContext validationResult=\"Validation Result\"", entityJsonContext.toString());
  }
}
