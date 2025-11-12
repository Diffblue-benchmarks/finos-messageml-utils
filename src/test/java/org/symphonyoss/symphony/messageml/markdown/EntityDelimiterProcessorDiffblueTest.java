package org.symphonyoss.symphony.messageml.markdown;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.commonmark.internal.Delimiter;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterRun;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.symphonyoss.symphony.messageml.markdown.nodes.EmojiNode;

public class EntityDelimiterProcessorDiffblueTest {
  /**
   * Test {@link EntityDelimiterProcessor#getOpeningCharacter()}.
   *
   * <p>Method under test: {@link EntityDelimiterProcessor#getOpeningCharacter()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"char EntityDelimiterProcessor.getOpeningCharacter()"})
  public void testGetOpeningCharacter() {
    // Arrange, Act and Assert
    assertEquals(
        EntityDelimiterProcessor.ENTITY_DELIMITER,
        new EntityDelimiterProcessor().getOpeningCharacter());
  }

  /**
   * Test {@link EntityDelimiterProcessor#getClosingCharacter()}.
   *
   * <p>Method under test: {@link EntityDelimiterProcessor#getClosingCharacter()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"char EntityDelimiterProcessor.getClosingCharacter()"})
  public void testGetClosingCharacter() {
    // Arrange, Act and Assert
    assertEquals(
        EntityDelimiterProcessor.ENTITY_DELIMITER,
        new EntityDelimiterProcessor().getClosingCharacter());
  }

  /**
   * Test {@link EntityDelimiterProcessor#getDelimiterUse(DelimiterRun, DelimiterRun)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link EntityDelimiterProcessor#getDelimiterUse(DelimiterRun,
   * DelimiterRun)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityDelimiterProcessor.getDelimiterUse(DelimiterRun, DelimiterRun)"})
  public void testGetDelimiterUse_thenReturnOne() {
    // Arrange
    EntityDelimiterProcessor entityDelimiterProcessor = new EntityDelimiterProcessor();
    Delimiter opener = new Delimiter(new Text(), 'A', true, true, mock(Delimiter.class));
    Delimiter closer = new Delimiter(new Text(), 'A', true, true, mock(Delimiter.class));

    // Act and Assert
    assertEquals(1, entityDelimiterProcessor.getDelimiterUse(opener, closer));
  }

  /**
   * Test {@link EntityDelimiterProcessor#process(Text, Text, int)}.
   *
   * <ul>
   *   <li>Given {@link EmojiNode#EmojiNode()}.
   *   <li>When {@link Text} {@link Text#getNext()} return {@link EmojiNode#EmojiNode()}.
   *   <li>Then calls {@link Text#getNext()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDelimiterProcessor#process(Text, Text, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityDelimiterProcessor.process(Text, Text, int)"})
  public void testProcess_givenEmojiNode_whenTextGetNextReturnEmojiNode_thenCallsGetNext() {
    // Arrange
    EntityDelimiterProcessor entityDelimiterProcessor = new EntityDelimiterProcessor();

    Text opener = mock(Text.class);
    when(opener.getNext()).thenReturn(new EmojiNode());

    // Act
    entityDelimiterProcessor.process(opener, new Text(), 1);

    // Assert
    verify(opener).getNext();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityDelimiterProcessor}
   *   <li>{@link EntityDelimiterProcessor#getMinLength()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDelimiterProcessor.<init>()",
    "int EntityDelimiterProcessor.getMinLength()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, new EntityDelimiterProcessor().getMinLength());
  }
}
