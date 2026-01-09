package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class StructuredObjectDiffblueTest {
  /**
   * Test {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext)}.
   *
   * <ul>
   *   <li>Given {@link ObjectNode} {@link ObjectNode#get(String)} return valueOf ten.
   *   <li>Then return Type is {@code 10.0}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredObject.<init>(IEntityJsonInstanceContext)"})
  public void testNewStructuredObject_givenObjectNodeGetReturnValueOfTen_thenReturnTypeIs100() {
    // Arrange
    ObjectNode objectNode = mock(ObjectNode.class);
    when(objectNode.get(Mockito.<String>any())).thenReturn(DoubleNode.valueOf(10.0d));

    EntityJsonContext context = mock(EntityJsonContext.class);
    when(context.getInstanceJsonNode()).thenReturn(objectNode);
    when(context.getInstanceSource()).thenReturn("Instance Source");

    // Act
    StructuredObject actualStructuredObject = new StructuredObject(context);

    // Assert
    verify(objectNode, atLeast(1)).get(Mockito.<String>any());
    verify(context).getInstanceJsonNode();
    verify(context).getInstanceSource();
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
   *   <li>Given {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is withExactBigDecimals
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredObject.<init>(IEntityJsonInstanceContext)"})
  public void testNewStructuredObject_givenObjectNodeWithNcIsWithExactBigDecimalsTrue() {
    // Arrange
    EntityJsonContext context = mock(EntityJsonContext.class);
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    when(context.getInstanceJsonNode()).thenReturn(new ObjectNode(nc));
    when(context.getInstanceSource()).thenReturn("Instance Source");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new StructuredObject(context));
    verify(context).getInstanceJsonNode();
    verify(context).getInstanceSource();
  }

  /**
   * Test {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext)}.
   *
   * <ul>
   *   <li>Then calls {@link ArrayNode#asText()}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredObject.<init>(IEntityJsonInstanceContext)"})
  public void testNewStructuredObject_thenCallsAsText() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asText()).thenThrow(new IllegalArgumentException());

    ObjectNode objectNode = mock(ObjectNode.class);
    when(objectNode.get(Mockito.<String>any())).thenReturn(arrayNode);

    EntityJsonContext context = mock(EntityJsonContext.class);
    when(context.getInstanceJsonNode()).thenReturn(objectNode);
    when(context.getInstanceSource()).thenReturn("Instance Source");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new StructuredObject(context));
    verify(arrayNode).asText();
    verify(objectNode, atLeast(1)).get(Mockito.<String>any());
    verify(context).getInstanceJsonNode();
    verify(context).getInstanceSource();
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
    EntityJsonContext context = new EntityJsonContext();
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
  public void testNewStructuredObject_thenReturnTypeIsEmptyString() {
    // Arrange
    EntityJsonContext context = new EntityJsonContext();
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

  /**
   * Test {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext, Object, ObjectNode)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
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
  public void testNewStructuredObject_thenThrowIllegalArgumentException() {
    // Arrange
    EntityJsonContext context = new EntityJsonContext();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode jsonNode = new ObjectNode(nc);
    jsonNode.put("type", DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new StructuredObject(context, "Instance Source", jsonNode));
  }

  /**
   * Test {@link StructuredObject#StructuredObject(IEntityJsonInstanceContext, Object, ObjectNode)}.
   *
   * <ul>
   *   <li>When {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is withExactBigDecimals
   *       {@code true}.
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
  public void testNewStructuredObject_whenObjectNodeWithNcIsWithExactBigDecimalsTrue() {
    // Arrange
    EntityJsonContext context = new EntityJsonContext();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode jsonNode = new ObjectNode(nc);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new StructuredObject(context, "Instance Source", jsonNode));
  }
}
