package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StructuredObjectDiffblueTest {
  /**
   * Test {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext, Object, ObjectNode)}.
   * <ul>
   *   <li>Given {@code 0.5}.</li>
   *   <li>Then return Type is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext, Object, ObjectNode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredObject.<init>(IEntityJsonInstanceContext, Object, ObjectNode)"})
  public void testNewStructuredObject_given05_thenReturnTypeIsEmptyString() {
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

  /**
   * Test {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext)}.
   * <ul>
   *   <li>Then return Type is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StructuredObject.<init>(IEntityJsonInstanceContext)"})
  public void testNewStructuredObject_thenReturnTypeIsEmptyString() {
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
}
