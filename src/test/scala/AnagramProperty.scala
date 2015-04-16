import org.scalacheck.Gen
import org.scalatest.ShouldMatchers
import org.scalatest.prop.PropertyChecks

/**
 * User: sbendiola
 * Date: 4/15/15
 * Time: 8:45 PM
 */

class AnagramProperty extends PropertyChecks with ShouldMatchers {
  val words = Gen.oneOf(List("pool", "loco", "cool", "stain", "satin", "pretty", "nice", "loop", "cat", "dog", "god", "tac"))
  val inputs = for {
    s <- Gen.chooseNum(0, 12)
    n <- Gen.listOfN(s, words)
  } yield n
  
  forAll(inputs) {
    words =>
      val result = anagrams.apply(words).toList
      1 should be (2)
      whenever(result.nonEmpty) {

        result.foreach(anagram => words.indexOf(anagram) should be <= (result.indexOf(anagram)))
      }
  }
}
