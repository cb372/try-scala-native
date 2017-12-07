import cats.kernel._
import cats.kernel.instances.either._

object Main {
  def main(args: Array[String]): Unit = {
    implicit val addition: Semigroup[Int] = new Semigroup[Int] {
      def combine(x: Int, y: Int): Int = x + y
    }
    val either1: Either[String, Int] = Right(5)
    val either2: Either[String, Int] = Right(3)
    val S = implicitly[Semigroup[Either[String, Int]]]
    val sum = S.combine(either1, either2)
    println(s"$either1 + $either2 = $sum")
  }
}
