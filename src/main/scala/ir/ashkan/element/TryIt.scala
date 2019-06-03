package ir.ashkan.element

object TryIt extends App {

  abstract class B

  class B1 extends B

  class B2 extends B

  abstract class A[-T <: B] {
    def say(): Unit
  }

  trait LowPriority {
    implicit object ab extends A[B] {
      def say(): Unit = println("A[B]")
    }
  }

  object HighPriority extends LowPriority {
    implicit object ab2 extends A[B2] {
      def say(): Unit = println("A[B2]")
    }
  }

  import HighPriority._


//  implicitly[A[B] <:< A[B2]]
  implicitly[A[B1]].say()
  implicitly[A[B2]].say()
}
