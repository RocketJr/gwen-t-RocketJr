package cl.uchile.dcc
package gwent.Observadores

/** Abstract class representing a Subject in the Gwen't game.
 */
abstract class AbstractSubject[T] extends Subject[T] {
  private var observers: List[Observer[T]] = Nil

  /** Adds and observer to the subject.
   */
  override def addObserver(observer: Observer[T]): Unit = {
    observers = observer :: observers
  }

  /** Notifies all observers from an update.
   */
  override def notifyObservers(value: T): Unit = {
    for (observer <- observers) {
      observer.update(this, value)
    }
  }
}
