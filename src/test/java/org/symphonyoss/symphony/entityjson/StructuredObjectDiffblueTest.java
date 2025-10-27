package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

public class StructuredObjectDiffblueTest {
  /**
   * Method under test:
   * {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext)}
   */
  @Test
  public void testNewStructuredObject() {
    // Arrange
    ObjectNode objectNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));
    objectNode.put("version", 0.5f);
    objectNode.put("type", MissingNode.getInstance());
    IEntityJsonInstanceContext context = mock(IEntityJsonInstanceContext.class);
    when(context.getInstanceJsonNode()).thenReturn(objectNode);
    when(context.getInstanceSource()).thenReturn("Instance Source");

    // Act
    StructuredObject actualStructuredObject = new StructuredObject(context);

    // Assert
    verify(context).getInstanceJsonNode();
    verify(context).getInstanceSource();
    assertEquals("", actualStructuredObject.getType());
    assertEquals("0.5", actualStructuredObject.getVersion());
    assertEquals("StructuredObject(\" v0.5\")", actualStructuredObject.toString());
    assertEquals(0, actualStructuredObject.getMajorVersion());
    assertEquals(5, actualStructuredObject.getMinorVersion());
    assertTrue(actualStructuredObject.getIdList().isEmpty());
    assertSame(context, actualStructuredObject.getContext());
  }

  /**
   * Method under test:
   * {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext, Object, ObjectNode)}
   */
  @Test
  public void testNewStructuredObject2() {
    // Arrange
    IEntityJsonInstanceContext context = mock(IEntityJsonInstanceContext.class);

    ObjectNode jsonNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));
    jsonNode.put("version", 0.5f);
    jsonNode.put("type", MissingNode.getInstance());

    // Act
    StructuredObject actualStructuredObject = new StructuredObject(context, "Instance Source", jsonNode);

    // Assert
    assertEquals("", actualStructuredObject.getType());
    assertEquals("0.5", actualStructuredObject.getVersion());
    assertEquals("StructuredObject(\" v0.5\")", actualStructuredObject.toString());
    assertEquals(0, actualStructuredObject.getMajorVersion());
    assertEquals(5, actualStructuredObject.getMinorVersion());
    assertTrue(actualStructuredObject.getIdList().isEmpty());
    assertSame(context, actualStructuredObject.getContext());
  }
}
