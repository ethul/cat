package cat
package kleisli

import scalaz._
import Scalaz._

object Reader {
  type Env = Map[String,String]

  def foo(a: String): Env => Option[String] = e => {
    e.get("foo").map(_ + a)
  }

  def bar(a: Int): Env => Option[Int] = e => {
    e.get("bar").map(_.toInt + a)
  }

  def baz(a: String): Env => Option[String] = e => {
    e.get("baz").map(_ + a + a)
  }

  def snaz =
    for {
      a <- Kleisli(foo("abc"))
      b <- Kleisli(bar(5))
      c <- Kleisli(baz("xyz"))
    } yield (a,b,c)

  // scala> run(Map("foo" -> "foo", "bar" -> "10", "baz" -> "baz"))
  // res2: Option[java.lang.String] = Some(fooabcwhoa)
  def run = {
    snaz >==> {
      case (x,y,z) => Some(x + "whoa")
    }
  }
}
