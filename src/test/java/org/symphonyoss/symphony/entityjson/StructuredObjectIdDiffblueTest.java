package org.symphonyoss.symphony.entityjson;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StructuredObjectIdDiffblueTest {
  /**
   * Test {@link StructuredObjectId#StructuredObjectId(JsonNode)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredObjectId#StructuredObjectId(JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredObjectId.<init>(JsonNode)"})
  public void testNewStructuredObjectId_whenValueOfTen_thenThrowIllegalArgumentException() {
    // Arrange
    DoubleNode node = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new StructuredObjectId(node));
  }
}
