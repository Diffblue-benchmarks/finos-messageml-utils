package org.symphonyoss.symphony.entityjson;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class StructuredObjectIdDiffblueTest {
  /**
   * Test {@link StructuredObjectId#StructuredObjectId(JsonNode)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@link ArrayNode} {@link ArrayNode#get(String)} return Instance.
   * </ul>
   *
   * <p>Method under test: {@link StructuredObjectId#StructuredObjectId(JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredObjectId.<init>(JsonNode)"})
  public void testNewStructuredObjectId_givenInstance_whenArrayNodeGetReturnInstance() {
    // Arrange
    ArrayNode node = mock(ArrayNode.class);
    when(node.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());

    // Act
    new StructuredObjectId(node);

    // Assert
    verify(node, atLeast(1)).get(Mockito.<String>any());
  }

  /**
   * Test {@link StructuredObjectId#StructuredObjectId(JsonNode)}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   *   <li>When {@link ArrayNode} {@link ArrayNode#get(String)} return valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link StructuredObjectId#StructuredObjectId(JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredObjectId.<init>(JsonNode)"})
  public void testNewStructuredObjectId_givenValueOfTen_whenArrayNodeGetReturnValueOfTen() {
    // Arrange
    ArrayNode node = mock(ArrayNode.class);
    when(node.get(Mockito.<String>any())).thenReturn(DoubleNode.valueOf(10.0d));

    // Act
    new StructuredObjectId(node);

    // Assert
    verify(node, atLeast(1)).get(Mockito.<String>any());
  }
}
