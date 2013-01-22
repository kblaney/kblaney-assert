package com.kblaney.assertions;

import java.util.Collection;
import java.util.Map;

/**
 * Provides static methods that make assertions about arguments. When assertions fail, methods throw an
 * {@code IllegalArgumentException}.
 */
public final class ArgAssert
{
  private ArgAssert()
  {
  }

  /**
   * Asserts that a specified condition is true. If the condition is false, this method throws an
   * {@code IllegalArgumentException}.
   * 
   * @param condition the condition
   * @param conditionName the name of the condition to include in the {@code IllegalArgumentException} that is throw if
   * the condition is false
   */
  public static void assertTrue(final boolean condition, final String conditionName)
  {
    if (!condition)
    {
      throw new IllegalArgumentException(conditionName + " is false");
    }
  }

  /**
   * Asserts that a specified collection argument is not empty. If the collection is empty, this method throws an
   * {@code IllegalArgumentException}. If the collection is non-empty, the collection is returned.
   * 
   * @param <T> the type of the elements in the collection
   * @param arg the collection to check
   * @param argName the name to include in the {@code IllegalArgumentException} that is thrown if {@code arg} is empty
   * 
   * @return the non-empty collection
   */
  public static <T> Collection<T> assertNotEmpty(final Collection<T> arg, final String argName)
  {
    assertNotNull(arg, argName);

    if (arg.isEmpty())
    {
      throw new IllegalArgumentException(argName + " is empty");
    }
    return arg;
  }

  /**
   * Asserts that a specified map argument is not empty. If the map is empty, this method throws an
   * {@code IllegalArgumentException}. If the map is non-empty, the collection is returned.
   * 
   * @param <K> the type of keys in the map
   * @param <V> the type of values in the map
   * @param arg the map to check
   * @param argName the name to include in the {@code IllegalArgumentException} that is thrown if {@code arg} is empty
   * 
   * @return the non-empty map
   */
  public static <K, V> Map<K, V> assertNotEmpty(final Map<K, V> arg, final String argName)
  {
    assertNotNull(arg, argName);

    if (arg.isEmpty())
    {
      throw new IllegalArgumentException(argName + " is empty");
    }
    return arg;
  }

  /**
   * Asserts that a specified string argument is not empty. If the string is empty, this method throws an
   * {@code IllegalArgumentException}. If the string is non-empty, it is returned.
   * 
   * @param arg the string to check
   * @param argName the name to include in the {@code IllegalArgumentException} that is thrown if {@code arg} is empty
   * 
   * @return the non-empty string
   */
  public static String assertNotEmpty(final String arg, final String argName)
  {
    assertNotNull(arg, argName);

    if (arg.isEmpty())
    {
      throw new IllegalArgumentException(argName + " is empty");
    }
    return arg;
  }

  /**
   * Asserts that a specified argument is not null. If the argument is null, this method throws an
   * {@code IllegalArgumentException}. If the argument is not null, this method returns it.
   * 
   * @param <T> the type of the argument to check
   * @param arg the argument to check
   * @param argName the name to include in the {@code IllegalArgumentException} that is thrown if {@code arg} is null
   * 
   * @return the non-null argument
   */
  public static <T> T assertNotNull(final T arg, final String argName)
  {
    if (arg == null)
    {
      throw new IllegalArgumentException(argName + " is null");
    }
    return arg;
  }

  /**
   * Asserts that a specified argument is less than a specified maximum. If the argument equals or exceeds the maximum,
   * this method throws an {@code IllegalArgumentException}. If the argument is not too large, this method returns it.
   * 
   * @param arg the double to check
   * @param max the maximum value
   * @param argName the name to include in the {@code IllegalArgumentException} that is thrown if {@code arg} is exceeds
   * {@code max}
   * 
   * @return the argument
   */
  public static int assertLessThan(final int arg, final int max, final String argName)
  {
    if (arg < max)
    {
      return arg;
    }
    throw new IllegalArgumentException(argName + " (" + arg + ") is not less than " + max);
  }

  /**
   * Asserts that a specified argument is less than or equal to a specified maximum. If the argument exceeds the
   * maximum, this method throws an {@code IllegalArgumentException}. If the argument is less than or equal to the
   * maximum, this method returns it.
   * 
   * @param arg the double to check
   * @param max the maximum value
   * @param argName the name to include in the {@code IllegalArgumentException} that is thrown if {@code arg} is exceeds
   * {@code max}
   * 
   * @return the argument
   */
  public static int assertLessThanOrEqual(final int arg, final int max, final String argName)
  {
    if (arg <= max)
    {
      return arg;
    }
    throw new IllegalArgumentException(argName + " (" + arg + ") is greater than " + max);
  }

  /**
   * Asserts that a specified argument is greater than a specified minimum. If the argument equals or is less than the
   * minimum, this method throws an {@code IllegalArgumentException}. If the argument is greater than the maximum, this
   * method returns it.
   * 
   * @param arg the argument to check
   * @param min the minimum value
   * @param argName the name to include in the {@code IllegalArgumentException} that is thrown if {@code arg} is smaller
   * than {@code min}
   * 
   * @return the argument
   */
  public static int assertGreaterThan(final int arg, final int min, final String argName)
  {
    if (arg > min)
    {
      return arg;
    }
    throw new IllegalArgumentException(argName + " (" + arg + ") is not greater than " + min);
  }

  /**
   * Asserts that a specified argument is greater than or equal to a specified minimum. If the argument is less than the
   * maximum, this method throws an {@code IllegalArgumentException}. If the argument is greater than or equal to the
   * maximum, this method returns it.
   * 
   * @param arg the argument to check
   * @param min the minimum value
   * @param argName the name to include in the {@code IllegalArgumentException} that is thrown if {@code arg} is smaller
   * than {@code min}
   * 
   * @return the argument
   */
  public static int assertGreaterThanOrEqual(final int arg, final int min, final String argName)
  {
    if (arg >= min)
    {
      return arg;
    }
    throw new IllegalArgumentException(argName + " (" + arg + ") is less than " + min);
  }

  /**
   * Asserts that a specified argument is not negative (in other words, greater than or equal to zero). If the argument
   * is negative, this method throws an {@code IllegalArgumentException}. If the argument is zero or positive, this
   * method returns it.
   * 
   * @param arg the argument to check
   * @param argName the name to include in the {@code IllegalArgumentException} that is thrown if {@code arg} is
   * negative
   * 
   * @return the argument
   */
  public static int assertNotNegative(final int arg, final String argName)
  {
    final int min = 0;
    return assertGreaterThanOrEqual(arg, min, argName);
  }
}
