package org.symphonyoss.symphony.messageml.markdown.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MentionNodeDiffblueTest {
  /**
   * Test {@link MentionNode#MentionNode(long)}.
   * <p>
   * Method under test: {@link MentionNode#MentionNode(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MentionNode.<init>(long)"})
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
   * Test {@link MentionNode#MentionNode(long, String, String, String)}.
   * <p>
   * Method under test: {@link MentionNode#MentionNode(long, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MentionNode.<init>(long, String, String, String)"})
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

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MentionNode#getEmail()}
   *   <li>{@link MentionNode#getPrettyName()}
   *   <li>{@link MentionNode#getScreenName()}
   *   <li>{@link MentionNode#getUid()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MentionNode.getEmail()", "String MentionNode.getPrettyName()",
      "String MentionNode.getScreenName()", "long MentionNode.getUid()"})
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
   * Test {@link MentionNode#getText()}.
   * <ul>
   *   <li>Given {@link MentionNode#MentionNode(long)} with uid is one.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MentionNode#getText()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MentionNode.getText()"})
  public void testGetText_givenMentionNodeWithUidIsOne_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new MentionNode(1L)).getText());
  }

  /**
   * Test {@link MentionNode#getText()}.
   * <ul>
   *   <li>Then return {@code @Pretty Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MentionNode#getText()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MentionNode.getText()"})
  public void testGetText_thenReturnPrettyName() {
    // Arrange, Act and Assert
    assertEquals("@Pretty Name", (new MentionNode(1L, "Pretty Name", "Screen Name", "jane.doe@example.org")).getText());
  }
}
