package org.symphonyoss.symphony.entityjson;

import org.junit.Test;

public class EntityJsonParserBuilderDiffblueTest {
  /**
   * Test {@link EntityJsonParserBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityJsonParserBuilder#build()}
   *   <li>default or parameterless constructor of {@link EntityJsonParserBuilder}
   *   <li>{@link EntityJsonParserBuilder#withUnrestrictedSchemaLoad(boolean)}
   * </ul>
   */
  @Test
  public void testBuild() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     EntityJsonParserBuilder.unrestrictedSchemaLoad_

    // Arrange and Act
    (new EntityJsonParserBuilder()).withUnrestrictedSchemaLoad(true).build();
  }
}
