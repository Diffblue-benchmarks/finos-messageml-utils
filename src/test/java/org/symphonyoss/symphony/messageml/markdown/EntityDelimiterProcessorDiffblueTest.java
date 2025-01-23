package org.symphonyoss.symphony.messageml.markdown;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.commonmark.internal.Delimiter;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterRun;
import org.junit.Test;
import org.symphonyoss.symphony.messageml.markdown.nodes.EmojiNode;

public class EntityDelimiterProcessorDiffblueTest {
  /**
   * Test {@link EntityDelimiterProcessor#getOpeningCharacter()}.
   * <p>
   * Method under test: {@link EntityDelimiterProcessor#getOpeningCharacter()}
   */
  @Test
  public void testGetOpeningCharacter() {
    // Arrange, Act and Assert
    assertEquals(EntityDelimiterProcessor.ENTITY_DELIMITER, (new EntityDelimiterProcessor()).getOpeningCharacter());
  }

  /**
   * Test {@link EntityDelimiterProcessor#getClosingCharacter()}.
   * <p>
   * Method under test: {@link EntityDelimiterProcessor#getClosingCharacter()}
   */
  @Test
  public void testGetClosingCharacter() {
    // Arrange, Act and Assert
    assertEquals(EntityDelimiterProcessor.ENTITY_DELIMITER, (new EntityDelimiterProcessor()).getClosingCharacter());
  }

  /**
   * Test
   * {@link EntityDelimiterProcessor#getDelimiterUse(DelimiterRun, DelimiterRun)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDelimiterProcessor#getDelimiterUse(DelimiterRun, DelimiterRun)}
   */
  @Test
  public void testGetDelimiterUse_thenReturnOne() {
    // Arrange
    EntityDelimiterProcessor entityDelimiterProcessor = new EntityDelimiterProcessor();
    Delimiter opener = new Delimiter(new Text("Literal"), 'A', true, true, mock(Delimiter.class));

    // Act and Assert
    assertEquals(1, entityDelimiterProcessor.getDelimiterUse(opener,
        new Delimiter(new Text("Literal"), 'A', true, true, mock(Delimiter.class))));
  }

  /**
   * Test {@link EntityDelimiterProcessor#process(Text, Text, int)}.
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.</li>
   *   <li>When {@link Text} {@link Node#getNext()} return
   * {@link EmojiNode#EmojiNode()}.</li>
   *   <li>Then calls {@link Node#getNext()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDelimiterProcessor#process(Text, Text, int)}
   */
  @Test
  public void testProcess_givenEmojiNode_whenTextGetNextReturnEmojiNode_thenCallsGetNext() {
    // Arrange
    EntityDelimiterProcessor entityDelimiterProcessor = new EntityDelimiterProcessor();
    Text opener = mock(Text.class);
    when(opener.getNext()).thenReturn(new EmojiNode());

    // Act
    entityDelimiterProcessor.process(opener, new Text("Literal"), 1);

    // Assert
    verify(opener).getNext();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityDelimiterProcessor}
   *   <li>{@link EntityDelimiterProcessor#getMinLength()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new EntityDelimiterProcessor()).getMinLength());
  }
}
