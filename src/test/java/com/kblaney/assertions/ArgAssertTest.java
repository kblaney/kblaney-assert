package com.kblaney.assertions;

import static org.junit.Assert.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public final class ArgAssertTest
{
  @Test
  public void assertTrue_True()
  {
    ArgAssert.assertTrue(true, "conditionName");
  }

  @Test
  public void assertTrue_False()
  {
    try
    {
      ArgAssert.assertTrue(false, "conditionName");
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertEquals("conditionName is false", e.getMessage());
    }
  }

  @Test
  public void assertNotEmpty_EmptyCollection()
  {
    final List<String> arg = Lists.newArrayList();
    try
    {
      ArgAssert.assertNotEmpty(arg, "argName");
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertEquals("argName is empty", e.getMessage());
    }
  }

  @Test
  public void assertNotEmpty_NonEmptyCollection()
  {
    final List<String> arg = Lists.newArrayList("A");
    assertEquals(arg, ArgAssert.assertNotEmpty(arg, "argName"));
  }

  @Test
  public void assertNotEmpty_EmptyMap()
  {
    final Map<String, Integer> arg = Maps.newHashMap();
    try
    {
      ArgAssert.assertNotEmpty(arg, "argName");
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertEquals("argName is empty", e.getMessage());
    }
  }

  @Test
  public void assertNotEmpty_NonEmptyString()
  {
    final String arg = "This string is not empty";
    assertEquals(arg, ArgAssert.assertNotEmpty(arg, "argName"));
  }

  @Test
  public void assertNotEmpty_EmptyString()
  {
    final String arg = "";
    try
    {
      ArgAssert.assertNotEmpty(arg, "argName");
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertEquals("argName is empty", e.getMessage());
    }
  }

  @Test
  public void assertNotNull_NotNull()
  {
    ArgAssert.assertNotNull("A", "argName");
  }

  @Test
  public void assertNotNull_Null()
  {
    try
    {
      ArgAssert.assertNotNull(null, "argName");
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertEquals("argName is null", e.getMessage());
    }
  }

  @Test
  public void assertLessThan_LessThan()
  {
    final int arg = 3;
    final int max = 4;
    ArgAssert.assertLessThan(arg, max, "argName");
  }

  @Test
  public void assertLessThan_Equal()
  {
    final int arg = 3;
    final int max = 3;
    try
    {
      ArgAssert.assertLessThan(arg, max, "argName");
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertEquals("argName (3) is not less than 3", e.getMessage());
    }
  }

  @Test
  public void assertLessThan_GreaterThan()
  {
    final int arg = 4;
    final int max = 3;
    try
    {
      ArgAssert.assertLessThan(arg, max, "argName");
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertEquals("argName (4) is not less than 3", e.getMessage());
    }
  }

  @Test
  public void assertGreaterThan_GreaterThan()
  {
    final int arg = 4;
    final int min = 3;
    ArgAssert.assertGreaterThan(arg, min, "argName");
  }

  @Test
  public void assertGreaterThan_Equal()
  {
    final int arg = 3;
    final int min = 3;
    try
    {
      ArgAssert.assertGreaterThan(arg, min, "argName");
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertEquals("argName (3) is not greater than 3", e.getMessage());
    }
  }

  @Test
  public void assertGreaterThan_LessThan()
  {
    final int arg = 4;
    final int min = 5;
    try
    {
      ArgAssert.assertGreaterThan(arg, min, "argName");
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertEquals("argName (4) is not greater than 5", e.getMessage());
    }
  }

  @Test
  public void assertLessThanOrEqual_LessThan()
  {
    final int arg = 3;
    final int max = 4;
    ArgAssert.assertLessThanOrEqual(arg, max, "argName");
  }

  @Test
  public void assertLessThanOrEqual_Equal()
  {
    final int arg = 5;
    final int max = 5;
    ArgAssert.assertLessThanOrEqual(arg, max, "argName");
  }

  @Test
  public void assertLessThanOrEqual_GreaterThan()
  {
    final int arg = 4;
    final int max = 3;
    try
    {
      ArgAssert.assertLessThanOrEqual(arg, max, "argName");
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertEquals("argName (4) is greater than 3", e.getMessage());
    }
  }

  @Test
  public void assertGreaterThanOrEqual_GreaterThan()
  {
    final int arg = 4;
    final int min = 3;
    ArgAssert.assertGreaterThanOrEqual(arg, min, "argName");
  }

  @Test
  public void assertGreaterThanOrEqual_Equal()
  {
    final int arg = 7;
    final int min = 7;
    ArgAssert.assertGreaterThanOrEqual(arg, min, "argName");
  }

  @Test
  public void assertGreaterThanOrEqual_LessThan()
  {
    final int arg = 4;
    final int min = 5;
    try
    {
      ArgAssert.assertGreaterThanOrEqual(arg, min, "argName");
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertEquals("argName (4) is less than 5", e.getMessage());
    }
  }

  @Test
  public void assertNotNegative_Negative()
  {
    try
    {
      ArgAssert.assertNotNegative(-7, "argName");
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertEquals("argName (-7) is less than 0", e.getMessage());
    }
  }

  @Test
  public void assertNotNegative_Zero()
  {
    assertEquals(0, ArgAssert.assertNotNegative(0, "argName"));
  }

  @Test
  public void assertNotNegative_Positive()
  {
    assertEquals(7, ArgAssert.assertNotNegative(7, "argName"));
  }
}
