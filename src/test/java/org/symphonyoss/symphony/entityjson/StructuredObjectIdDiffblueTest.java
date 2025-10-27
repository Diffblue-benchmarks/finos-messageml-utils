package org.symphonyoss.symphony.entityjson;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.Test;
import org.mockito.Mockito;

public class StructuredObjectIdDiffblueTest {
  /**
   * Method under test: {@link StructuredObjectId#StructuredObjectId(JsonNode)}
   */
  @Test
  public void testNewStructuredObjectId() {
    // Arrange
    ArrayNode node = mock(ArrayNode.class);
    when(node.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());

    // Act
    new StructuredObjectId(node);

    // Assert
    verify(node, atLeast(1)).get(Mockito.<String>any());
  }

  /**
   * Method under test: {@link StructuredObjectId#StructuredObjectId(JsonNode)}
   */
  @Test
  public void testNewStructuredObjectId2() {
    // Arrange
    ArrayNode node = mock(ArrayNode.class);
    when(node.get(Mockito.<String>any())).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act
    new StructuredObjectId(node);

    // Assert
    verify(node, atLeast(1)).get(Mockito.<String>any());
  }
}
