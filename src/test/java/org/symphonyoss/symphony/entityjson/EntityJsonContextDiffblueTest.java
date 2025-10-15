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

public class EntityJsonContextDiffblueTest {
  /**
   * Test {@link EntityJsonContext#newInstance()}.
   *
   * <ul>
   *   <li>Then return {@link EntityJsonContext}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJsonContext#newInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IEntityJsonContext EntityJsonContext.newInstance()"})
  public void testNewInstance_thenReturnEntityJsonContext() {
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
}
