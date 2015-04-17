import org.scalacheck.Gen
import org.scalatest.{PropSpec, FunSuite, ShouldMatchers}
import org.scalatest.prop.PropertyChecks

/**
 * User: sbendiola
 * Date: 4/15/15
 * Time: 8:45 PM
 */

class AnagramProperty extends PropSpec with PropertyChecks with ShouldMatchers {
  val words = Gen.oneOf(List("pool", "loco", "cool", "stain", "satin", "pretty", "nice", "loop", "cat", "dog", "god", "tac"))
  val inputs = for {
    s <- Gen.chooseNum(0, 12)
    n <- Gen.listOfN(s, words)
  } yield n

  property("anagram order") {
    forAll(inputs) {
      words =>
        val result = anagrams.apply(words).toList
        result.foreach(anagram =>
          withClue(s"input: $words result: $result anagram: $anagram") {
            words.indexOf(anagram) should be >= (result.indexOf(anagram))
          })
    }
  }

  property("no duplicates") {
    forAll(inputs) {
      words =>
        val result = anagrams.apply(words).toList
        result.size should be (result.toSet.size)
    }
  }
}
