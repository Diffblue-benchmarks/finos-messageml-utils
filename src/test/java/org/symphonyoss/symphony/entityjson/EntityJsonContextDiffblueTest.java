package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

public class EntityJsonContextDiffblueTest {
  /**
   * Test {@link EntityJsonContext#newInstance()}.
   * <ul>
   *   <li>Then return {@link EntityJsonContext}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJsonContext#newInstance()}
   */
  @Test
  public void testNewInstance_thenReturnEntityJsonContext() {
    // Arrange and Act
    IEntityJsonContext actualNewInstanceResult = EntityJsonContext.newInstance();
    ObjectNode objectNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));
    IEntityJsonInstanceContext actualWithInstanceResult = actualNewInstanceResult.withInstance("42", objectNode);

    // Assert
    assertTrue(actualNewInstanceResult instanceof EntityJsonContext);
    assertEquals("42", ((EntityJsonContext) actualNewInstanceResult).getInstanceSource());
    assertNull(((EntityJsonContext) actualNewInstanceResult).getSchemaJsonNode());
    assertNull(((EntityJsonContext) actualNewInstanceResult).getSchemaSource());
    assertNull(((EntityJsonContext) actualNewInstanceResult).getValidationResult());
    assertSame(objectNode, ((EntityJsonContext) actualNewInstanceResult).getInstanceJsonNode());
    assertSame(actualNewInstanceResult, actualWithInstanceResult);
  }
}
