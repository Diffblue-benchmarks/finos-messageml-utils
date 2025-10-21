package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TableBodyDiffblueTest {
  /**
   * Test {@link TableBody#TableBody(Element)}.
   * <p>
   * Method under test: {@link TableBody#TableBody(Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TableBody.<init>(Element)"})
  public void testNewTableBody() {
    // Arrange
    Bold parent = new Bold(new BulletList(mock(Element.class)));

    // Act
    TableBody actualTableBody = new TableBody(parent);

    // Assert
    assertEquals(0, actualTableBody.size());
    assertEquals(FormatEnum.PRESENTATIONML, actualTableBody.getFormat());
    assertTrue(actualTableBody.getChildren().isEmpty());
    assertTrue(actualTableBody.getAttributes().isEmpty());
    assertEquals(TableBody.MESSAGEML_TAG, actualTableBody.getMessageMLTag());
    assertEquals(TableBody.MESSAGEML_TAG, actualTableBody.getPresentationMLTag());
    assertSame(parent, actualTableBody.getParent());
  }

  /**
   * Test {@link TableBody#toString()}.
   * <p>
   * Method under test: {@link TableBody#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TableBody.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Body", (new TableBody(new Bold(new BulletList(null)))).toString());
  }
}
