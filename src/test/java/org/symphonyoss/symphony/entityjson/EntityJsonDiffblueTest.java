package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import org.junit.Ignore;
import org.junit.Test;

public class EntityJsonDiffblueTest {
  /**
   * Test {@link EntityJson#EntityJson(IEntityJsonInstanceContext)}.
   * <ul>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJson#EntityJson(IEntityJsonInstanceContext)}
   */
  @Test
  public void testNewEntityJson_thenReturnSizeIsZero() throws InvalidInstanceException {
    // Arrange
    IEntityJsonInstanceContext context = mock(IEntityJsonInstanceContext.class);
    when(context.getInstanceJsonNode()).thenReturn(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act
    EntityJson actualEntityJson = new EntityJson(context);

    // Assert
    verify(context).getInstanceJsonNode();
    assertEquals(0, actualEntityJson.size());
    assertFalse(actualEntityJson.iterator().hasNext());
    assertTrue(actualEntityJson.getChildren().isEmpty());
    assertTrue(actualEntityJson.isEmpty());
    assertSame(context, actualEntityJson.getContext());
  }

  /**
   * Test {@link EntityJson#iterator()}.
   * <ul>
   *   <li>Then return not hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJson#iterator()}
   */
  @Test
  public void testIterator_thenReturnNotHasNext() throws InvalidInstanceException {
    // Arrange
    IEntityJsonInstanceContext context = mock(IEntityJsonInstanceContext.class);
    when(context.getInstanceJsonNode()).thenReturn(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act
    Iterator<StructuredObject> actualIteratorResult = (new EntityJson(context)).iterator();

    // Assert
    verify(context).getInstanceJsonNode();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link EntityJson#get(int)} with {@code index}.
   * <p>
   * Method under test: {@link EntityJson#get(int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetWithIndex() throws InvalidInstanceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.symphonyoss.symphony.entityjson.EntityJson.<init>(EntityJson.java:78)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new EntityJson(mock(IEntityJsonInstanceContext.class))).get(1);
  }

  /**
   * Test {@link EntityJson#get(String)} with {@code name}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJson#get(String)}
   */
  @Test
  public void testGetWithName_thenReturnNull() throws InvalidInstanceException {
    // Arrange
    IEntityJsonInstanceContext context = mock(IEntityJsonInstanceContext.class);
    when(context.getInstanceJsonNode()).thenReturn(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act
    StructuredObject actualGetResult = (new EntityJson(context)).get("Name");

    // Assert
    verify(context).getInstanceJsonNode();
    assertNull(actualGetResult);
  }

  /**
   * Test {@link EntityJson#size()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJson#size()}
   */
  @Test
  public void testSize_thenReturnZero() throws InvalidInstanceException {
    // Arrange
    IEntityJsonInstanceContext context = mock(IEntityJsonInstanceContext.class);
    when(context.getInstanceJsonNode()).thenReturn(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act
    int actualSizeResult = (new EntityJson(context)).size();

    // Assert
    verify(context).getInstanceJsonNode();
    assertEquals(0, actualSizeResult);
  }

  /**
   * Test {@link EntityJson#isEmpty()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJson#isEmpty()}
   */
  @Test
  public void testIsEmpty_thenReturnTrue() throws InvalidInstanceException {
    // Arrange
    IEntityJsonInstanceContext context = mock(IEntityJsonInstanceContext.class);
    when(context.getInstanceJsonNode()).thenReturn(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act
    boolean actualIsEmptyResult = (new EntityJson(context)).isEmpty();

    // Assert
    verify(context).getInstanceJsonNode();
    assertTrue(actualIsEmptyResult);
  }

  /**
   * Test {@link EntityJson#contains(StructuredObject)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJson#contains(StructuredObject)}
   */
  @Test
  public void testContains_thenReturnFalse() throws InvalidInstanceException {
    // Arrange
    IEntityJsonInstanceContext context = mock(IEntityJsonInstanceContext.class);
    when(context.getInstanceJsonNode()).thenReturn(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act
    boolean actualContainsResult = (new EntityJson(context)).contains(null);

    // Assert
    verify(context).getInstanceJsonNode();
    assertFalse(actualContainsResult);
  }
}
