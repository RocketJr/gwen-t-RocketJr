package cl.uchile.dcc
package gwent.Observadores

/** A trait representing a subject that can be observed by observers. */
trait Subject[T] {
  /** Adds and observer to the subject.
   */
  def addObserver(observer: Observer[T]): Unit

  /** Notifies all observers from an update.
   */
  def notifyObservers(value: T): Unit
}
