import scala.annotation.tailrec

package object anagrams {
  //  from http://nafiulis.me/the-deceptive-anagram-question.html
  //
  //  Given a list of words L, find all the anagrams in L in the order in which they appear in L.
  //    Given the input
  //
  //    ["pool", "loco", "cool", "stain", "satin", "pretty", "nice", "loop"]
  //  The desired output would be
  //
  //    ["pool", "loco", "cool", "stain", "satin", "loop"]

  def apply(words: Iterable[String]): Iterable[String] = {
    val wordList = words.toList
    val byChars = wordList.groupBy(_.toSet)
    var anagrams = Set[String]()
    for {
      (_, group) <- byChars if group.size > 1
      w <- group if !anagrams.contains(w)
    } anagrams += w
    anagrams.toList.sortBy(wordList.indexOf)
  }
}