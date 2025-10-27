package org.symphonyoss.symphony.messageml.markdown.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class MentionNodeDiffblueTest {
  /**
   * Method under test: {@link MentionNode#getText()}
   */
  @Test
  public void testGetText() {
    // Arrange, Act and Assert
    assertEquals("", (new MentionNode(1L)).getText());
    assertEquals("@Pretty Name", (new MentionNode(1L, "Pretty Name", "Screen Name", "jane.doe@example.org")).getText());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MentionNode#getEmail()}
   *   <li>{@link MentionNode#getPrettyName()}
   *   <li>{@link MentionNode#getScreenName()}
   *   <li>{@link MentionNode#getUid()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    MentionNode mentionNode = new MentionNode(1L);

    // Act
    String actualEmail = mentionNode.getEmail();
    String actualPrettyName = mentionNode.getPrettyName();
    String actualScreenName = mentionNode.getScreenName();

    // Assert
    assertNull(actualEmail);
    assertNull(actualPrettyName);
    assertNull(actualScreenName);
    assertEquals(1L, mentionNode.getUid());
  }

  /**
   * Method under test: {@link MentionNode#MentionNode(long)}
   */
  @Test
  public void testNewMentionNode() {
    // Arrange and Act
    MentionNode actualMentionNode = new MentionNode(1L);

    // Assert
    assertEquals("", actualMentionNode.getText());
    assertNull(actualMentionNode.getEmail());
    assertNull(actualMentionNode.getPrettyName());
    assertNull(actualMentionNode.getScreenName());
    assertNull(actualMentionNode.getFirstChild());
    assertNull(actualMentionNode.getLastChild());
    assertNull(actualMentionNode.getNext());
    assertNull(actualMentionNode.getParent());
    assertNull(actualMentionNode.getPrevious());
    assertEquals(1L, actualMentionNode.getUid());
  }

  /**
   * Method under test:
   * {@link MentionNode#MentionNode(long, String, String, String)}
   */
  @Test
  public void testNewMentionNode2() {
    // Arrange and Act
    MentionNode actualMentionNode = new MentionNode(1L, "Pretty Name", "Screen Name", "jane.doe@example.org");

    // Assert
    assertEquals("@Pretty Name", actualMentionNode.getText());
    assertEquals("Pretty Name", actualMentionNode.getPrettyName());
    assertEquals("Screen Name", actualMentionNode.getScreenName());
    assertEquals("jane.doe@example.org", actualMentionNode.getEmail());
    assertNull(actualMentionNode.getFirstChild());
    assertNull(actualMentionNode.getLastChild());
    assertNull(actualMentionNode.getNext());
    assertNull(actualMentionNode.getParent());
    assertNull(actualMentionNode.getPrevious());
    assertEquals(1L, actualMentionNode.getUid());
  }
}
