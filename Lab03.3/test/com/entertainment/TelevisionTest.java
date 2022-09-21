package com.entertainment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TelevisionTest {

  private static int TELEVISION_VOLUME_LEGAL = 50;
  private static int TELEVISION_VOLUME_ILLEGAL = 101;
  private static int TELEVISION_CHANNEL_LEGAL = 499;
  private static int TELEVISION_CHANNEL_ILLEGAL = 0;
  private static String TELEVISION_BRAND_A = "Sony";
  private static String TELEVISION_BRAND_B = "Samsung";

  private Television tv1;
  private Television tv2;

  @Before
  public void setUp() {
    tv1 = new Television(TELEVISION_BRAND_A);
    tv2 = new Television(TELEVISION_BRAND_B);
  }
  @Test
  public void testSetVolume() {
    tv1.setVolume(TELEVISION_VOLUME_LEGAL);
    assertEquals(TELEVISION_VOLUME_LEGAL, tv1.getVolume(), 0.001);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testThrowsSetVolume() {
    tv1.setVolume(TELEVISION_VOLUME_ILLEGAL);
  }

  @Test
  public void testChangeChannel() throws InvalidChannelException {
    tv1.changeChannel(TELEVISION_CHANNEL_LEGAL);
    assertEquals(TELEVISION_CHANNEL_LEGAL, tv1.getCurrentChannel(), 0.001);
  }

  @Test(expected = InvalidChannelException.class)
  public void testThrowsChangeChannel() throws InvalidChannelException {
    tv1.changeChannel(TELEVISION_CHANNEL_ILLEGAL);
  }

  @Test
  public void testCompareTo() {
    assertTrue(tv1.compareTo(tv2) != 0);
  }

  @Test
  public void testNotEqualsCompareTo() {
    assertNotEquals(1, tv1.compareTo(tv2));
  }

  @Test
  public void testHashCode() {
    tv2.setVolume(0);
    tv2.setDisplay(DisplayType.OLED);
    Television tv3 = new Television("Samsung", 0, DisplayType.OLED);
    assertEquals(tv2.hashCode(), tv3.hashCode());
  }

  @Test
  public void testEquals() {
    // TODO: 9/21/2022 Do a assertEquals 
    assertNotEquals(tv1, tv2);
  }
}