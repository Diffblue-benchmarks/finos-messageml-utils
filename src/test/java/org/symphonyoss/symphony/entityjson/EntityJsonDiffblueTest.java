package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EntityJsonDiffblueTest {
  /**
   * Test {@link EntityJson#EntityJson(IEntityJsonInstanceContext)}.
   *
   * <ul>
   *   <li>When {@link EntityJsonContext} (default constructor).
   *   <li>Then throw {@link InvalidInstanceException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJson#EntityJson(IEntityJsonInstanceContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityJson.<init>(IEntityJsonInstanceContext)"})
  public void testNewEntityJson_whenEntityJsonContext_thenThrowInvalidInstanceException()
      throws InvalidInstanceException {
    // Arrange, Act and Assert
    assertThrows(InvalidInstanceException.class, () -> new EntityJson(new EntityJsonContext()));
  }

  /**
   * Test {@link EntityJson#EntityJson(IEntityJsonInstanceContext)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJson#EntityJson(IEntityJsonInstanceContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityJson.<init>(IEntityJsonInstanceContext)"})
  public void testNewEntityJson_whenNull_thenThrowIllegalArgumentException()
      throws InvalidInstanceException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new EntityJson(null));
  }

  /**
   * Test {@link EntityJson#iterator()}.
   *
   * <ul>
   *   <li>Then return not hasNext.
   * </ul>
   *
   * <p>Method under test: {@link EntityJson#iterator()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator EntityJson.iterator()"})
  public void testIterator_thenReturnNotHasNext() throws InvalidInstanceException {
    // Arrange
    EntityJsonContext context = mock(EntityJsonContext.class);
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    when(context.getInstanceJsonNode()).thenReturn(new ObjectNode(nc));

    // Act
    Iterator<StructuredObject> actualIteratorResult = new EntityJson(context).iterator();

    // Assert
    verify(context).getInstanceJsonNode();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link EntityJson#get(String)} with {@code name}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJson#get(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StructuredObject EntityJson.get(String)"})
  public void testGetWithName_thenReturnNull() throws InvalidInstanceException {
    // Arrange
    EntityJsonContext context = mock(EntityJsonContext.class);
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    when(context.getInstanceJsonNode()).thenReturn(new ObjectNode(nc));

    // Act
    StructuredObject actualGetResult = new EntityJson(context).get("Name");

    // Assert
    verify(context).getInstanceJsonNode();
    assertNull(actualGetResult);
  }

  /**
   * Test {@link EntityJson#size()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link EntityJson#size()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityJson.size()"})
  public void testSize_thenReturnZero() throws InvalidInstanceException {
    // Arrange
    EntityJsonContext context = mock(EntityJsonContext.class);
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    when(context.getInstanceJsonNode()).thenReturn(new ObjectNode(nc));

    // Act
    int actualSizeResult = new EntityJson(context).size();

    // Assert
    verify(context).getInstanceJsonNode();
    assertEquals(0, actualSizeResult);
  }

  /**
   * Test {@link EntityJson#isEmpty()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityJson#isEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityJson.isEmpty()"})
  public void testIsEmpty_thenReturnTrue() throws InvalidInstanceException {
    // Arrange
    EntityJsonContext context = mock(EntityJsonContext.class);
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    when(context.getInstanceJsonNode()).thenReturn(new ObjectNode(nc));

    // Act
    boolean actualIsEmptyResult = new EntityJson(context).isEmpty();

    // Assert
    verify(context).getInstanceJsonNode();
    assertTrue(actualIsEmptyResult);
  }
}
