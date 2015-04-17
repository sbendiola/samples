package puzzles

import org.scalatest.{FlatSpec, ShouldMatchers}

/**
 * User: sbendiola
 * Date: 4/15/15
 * Time: 8:37 PM
 */
class AnagramsSpec extends FlatSpec with ShouldMatchers {
  "correct result" should "be returned" in {
    anagrams.apply(List("pool", "loco", "cool", "stain", "satin", "pretty", "nice", "loop")) should be
      (List("pool", "loco", "cool", "stain", "satin", "loop"))
  }
}
