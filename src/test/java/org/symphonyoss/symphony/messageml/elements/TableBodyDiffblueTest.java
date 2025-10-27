package org.symphonyoss.symphony.messageml.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class TableBodyDiffblueTest {
  /**
   * Method under test: {@link TableBody#TableBody(Element)}
   */
  @Test
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
   * Method under test: {@link TableBody#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Body", (new TableBody(new Bold(new BulletList(null)))).toString());
  }
}
