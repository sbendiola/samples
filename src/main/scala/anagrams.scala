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

    @tailrec
    def solve(words: List[String], byChars: Map[Set[Char], List[String]] = Map.empty, acc: List[String] = Nil): List[String] = {
      words match {
        case Nil =>
          acc

        case word :: rest =>
          val key: Set[Char] = word.toSet
          byChars.getOrElse(key, Nil) match {
            case Nil =>
              solve(rest, byChars.updated(key, word :: Nil), acc)
            case items =>
              //add all items not already added
              solve(rest, byChars.updated(key, word :: Nil), items.reverse.filterNot(acc.contains) ++ acc)
          }
      }
    }
    solve(words.toList)
  }
}