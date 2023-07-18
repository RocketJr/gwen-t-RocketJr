package cl.uchile.dcc
package gwent.Observadores

/** A trait representing an observer that can receive updates from a subject. */
trait Observer[T] {
  /** Receives and update from the subject.
   */
  def update(observable: Subject[T], value: T): Unit
}