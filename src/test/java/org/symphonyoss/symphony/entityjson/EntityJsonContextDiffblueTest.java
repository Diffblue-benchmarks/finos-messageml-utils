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

  @Mock private ObjectNode objectNode;

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
    // Arrange and Act
    IEntityJsonSchemaContext actualWithSchemaResult =
        entityJsonContext.withSchema("Schema Source", objectNode);

    // Assert
    assertEquals("Schema Source", entityJsonContext.getSchemaSource());
    assertSame(objectNode, entityJsonContext.getSchemaJsonNode());
    assertSame(entityJsonContext, actualWithSchemaResult);
  }

  /**
   * Test {@link EntityJsonContext#withInstance(Object, ObjectNode)}.
   *
   * <p>Method under test: {@link EntityJsonContext#withInstance(Object, ObjectNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IEntityJsonInstanceContext EntityJsonContext.withInstance(Object, ObjectNode)"
  })
  public void testWithInstance() {
    // Arrange and Act
    IEntityJsonInstanceContext actualWithInstanceResult =
        entityJsonContext.withInstance("Instance Source", objectNode);

    // Assert
    assertEquals("Instance Source", entityJsonContext.getInstanceSource());
    assertSame(entityJsonContext, actualWithInstanceResult);
  }

  /**
   * Test {@link EntityJsonContext#toString()}.
   *
   * <p>Method under test: {@link EntityJsonContext#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EntityJsonContext.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("EntityJsonContext instanceSource=\"object\"", entityJsonContext.toString());
  }
}
