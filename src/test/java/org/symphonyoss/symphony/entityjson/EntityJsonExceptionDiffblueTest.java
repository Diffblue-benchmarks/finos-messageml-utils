package org.symphonyoss.symphony.entityjson;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import org.mockito.Mockito;

public class EntityJsonExceptionDiffblueTest {
  /**
   * Method under test: {@link EntityJsonException#getContext()}
   */
  @Test
  public void testGetContext() {
    // Arrange
    IEntityJsonContext context = mock(IEntityJsonContext.class);
    when(context.withInstance(Mockito.<Object>any(), Mockito.<ObjectNode>any()))
        .thenReturn(mock(IEntityJsonInstanceContext.class));

    // Act
    IEntityJsonContext actualContext = (new InvalidInstanceException(context)).getContext();
    actualContext.withInstance("42", new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Assert
    verify(context).withInstance(isA(Object.class), isA(ObjectNode.class));
  }
}
