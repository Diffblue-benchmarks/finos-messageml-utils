package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.RawValue;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StructuredObjectDiffblueTest {
  /**
   * Test {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext)}.
   *
   * <p>Method under test: {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredObject.<init>(IEntityJsonInstanceContext)"})
  public void testNewStructuredObject() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode objectNode = new ObjectNode(nc);
    objectNode.put("version", DoubleNode.valueOf(10.0d));
    objectNode.putRawValue("type", new RawValue("type"));
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    objectNode.put("id", new ArrayNode(nf));

    IEntityJsonInstanceContext context = mock(IEntityJsonInstanceContext.class);
    when(context.getInstanceJsonNode()).thenReturn(objectNode);
    when(context.getInstanceSource()).thenReturn("Instance Source");

    // Act
    StructuredObject actualStructuredObject = new StructuredObject(context);

    // Assert
    verify(context).getInstanceJsonNode();
    verify(context).getInstanceSource();
    assertEquals("10.0", actualStructuredObject.getVersion());
    assertEquals(
        "StructuredObject(\"[RawValue of type `java.lang.String`] v10.0\")",
        actualStructuredObject.toString());
    assertEquals("[RawValue of type `java.lang.String`]", actualStructuredObject.getType());
    assertEquals(0, actualStructuredObject.getMinorVersion());
    assertEquals(10, actualStructuredObject.getMajorVersion());
    assertTrue(actualStructuredObject.getIdList().isEmpty());
    assertSame(context, actualStructuredObject.getContext());
  }

  /**
   * Test {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext)}.
   *
   * <ul>
   *   <li>Then return toString is {@code StructuredObject("null v10.0")}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredObject.<init>(IEntityJsonInstanceContext)"})
  public void testNewStructuredObject_thenReturnToStringIsStructuredObjectNullV100() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode objectNode = new ObjectNode(nc);
    objectNode.put("version", DoubleNode.valueOf(10.0d));
    objectNode.putRawValue("type", null);
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    objectNode.put("id", new ArrayNode(nf));

    IEntityJsonInstanceContext context = mock(IEntityJsonInstanceContext.class);
    when(context.getInstanceJsonNode()).thenReturn(objectNode);
    when(context.getInstanceSource()).thenReturn("Instance Source");

    // Act
    StructuredObject actualStructuredObject = new StructuredObject(context);

    // Assert
    verify(context).getInstanceJsonNode();
    verify(context).getInstanceSource();
    assertEquals("10.0", actualStructuredObject.getVersion());
    assertEquals("StructuredObject(\"null v10.0\")", actualStructuredObject.toString());
    assertEquals("null", actualStructuredObject.getType());
    assertEquals(0, actualStructuredObject.getMinorVersion());
    assertEquals(10, actualStructuredObject.getMajorVersion());
    assertTrue(actualStructuredObject.getIdList().isEmpty());
    assertSame(context, actualStructuredObject.getContext());
  }

  /**
   * Test {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext, Object, ObjectNode)}.
   *
   * <ul>
   *   <li>Then return Type is {@code 10.0}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext,
   * Object, ObjectNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredObject.<init>(IEntityJsonInstanceContext, Object, ObjectNode)"
  })
  public void testNewStructuredObject_thenReturnTypeIs100() {
    // Arrange
    IEntityJsonInstanceContext context = mock(IEntityJsonInstanceContext.class);
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode jsonNode = new ObjectNode(nc);
    jsonNode.put("version", DoubleNode.valueOf(10.0d));
    jsonNode.put("type", DoubleNode.valueOf(10.0d));

    // Act
    StructuredObject actualStructuredObject =
        new StructuredObject(context, "Instance Source", jsonNode);

    // Assert
    assertEquals("10.0", actualStructuredObject.getType());
    assertEquals("10.0", actualStructuredObject.getVersion());
    assertEquals("StructuredObject(\"10.0 v10.0\")", actualStructuredObject.toString());
    assertEquals(0, actualStructuredObject.getMinorVersion());
    assertEquals(10, actualStructuredObject.getMajorVersion());
    assertTrue(actualStructuredObject.getIdList().isEmpty());
    assertSame(context, actualStructuredObject.getContext());
  }

  /**
   * Test {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext)}.
   *
   * <ul>
   *   <li>Then return Type is empty string.
   * </ul>
   *
   * <p>Method under test: {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredObject.<init>(IEntityJsonInstanceContext)"})
  public void testNewStructuredObject_thenReturnTypeIsEmptyString() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode objectNode = new ObjectNode(nc);
    objectNode.put("version", DoubleNode.valueOf(10.0d));
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
    assertEquals("10.0", actualStructuredObject.getVersion());
    assertEquals("StructuredObject(\" v10.0\")", actualStructuredObject.toString());
    assertEquals(0, actualStructuredObject.getMinorVersion());
    assertEquals(10, actualStructuredObject.getMajorVersion());
    assertTrue(actualStructuredObject.getIdList().isEmpty());
    assertSame(context, actualStructuredObject.getContext());
  }

  /**
   * Test {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext, Object, ObjectNode)}.
   *
   * <ul>
   *   <li>Then return Type is empty string.
   * </ul>
   *
   * <p>Method under test: {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext,
   * Object, ObjectNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredObject.<init>(IEntityJsonInstanceContext, Object, ObjectNode)"
  })
  public void testNewStructuredObject_thenReturnTypeIsEmptyString2() {
    // Arrange
    IEntityJsonInstanceContext context = mock(IEntityJsonInstanceContext.class);
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode jsonNode = new ObjectNode(nc);
    jsonNode.put("version", DoubleNode.valueOf(10.0d));
    jsonNode.put("type", MissingNode.getInstance());

    // Act
    StructuredObject actualStructuredObject =
        new StructuredObject(context, "Instance Source", jsonNode);

    // Assert
    assertEquals("", actualStructuredObject.getType());
    assertEquals("10.0", actualStructuredObject.getVersion());
    assertEquals("StructuredObject(\" v10.0\")", actualStructuredObject.toString());
    assertEquals(0, actualStructuredObject.getMinorVersion());
    assertEquals(10, actualStructuredObject.getMajorVersion());
    assertTrue(actualStructuredObject.getIdList().isEmpty());
    assertSame(context, actualStructuredObject.getContext());
  }
}
