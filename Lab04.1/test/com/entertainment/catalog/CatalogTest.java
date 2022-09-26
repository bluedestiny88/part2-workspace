/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.Map;
import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {
  
  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */
  @Test
  public void testFindByBrandNoMatches() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  @Test
  public void testFindByBrandWithMatches()  {
    Collection<Television> tvs = Catalog.findByBrand("Sony");
    assertNotNull(tvs);
    assertFalse(tvs.isEmpty());
    assertEquals(7, tvs.size());
  }

  @Test
  public void testFindByBrandsNoBrands()  {
    Map<String,Collection<Television>> catalogSelections = Catalog.findByBrands();
    assertNotNull(catalogSelections);
    assertTrue(catalogSelections.isEmpty());
  }

  @Test
  public void testFindByBrandsSomeBrands()  {
    var catalogSelections = Catalog.findByBrands("Sony", "Zenith", "NO-MATCHES");
    assertNotNull(catalogSelections);
    assertFalse(catalogSelections.isEmpty());
    assertEquals(3, catalogSelections.size());
    assertEquals(7, catalogSelections.get("Sony").size());
    assertEquals(9, catalogSelections.get("Zenith").size());
    assertTrue(catalogSelections.get("NO_MATCHES").isEmpty());




  }


}