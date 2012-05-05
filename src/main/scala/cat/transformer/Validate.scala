package cat
package transformer

import scalaz._, Scalaz._, scalaz.effect._

object Validate {
  def foo(a: Int): Validation[String,Int] = {
    if (a > 10) a.success else "Failed".fail
  }

  def bar(a: String): IO[Validation[String,String]] = {
    IO.putStr(a).map { _ =>
      if (a.toInt > 10) a.success else "Failed bar".fail
    }
  }

  /**
   * 1427  Kleisli((a:String) => IO(a.some))
   * 1432  res31.lift[Option]
   * 1434  res36.run("aa")
   * 1435  res31.liftMK[OptionT]
   * 1436  res39.run("aa")
   * 1440  res39.flatMapK((a:Option[String]) => OptionT(IO("a".some)))
   */
  def run(x: Int) = {
    for {
      a <- ValidationT(IO(foo(x)))
      b <- ValidationT(bar(a.toString))
    } yield b + "baz"
  }
}
