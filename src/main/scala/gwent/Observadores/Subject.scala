package cl.uchile.dcc
package gwent.Observadores

trait Subject[T] {

  def addObserver(observer: Observer[T]): Unit

  def notifyObservers(value: T): Unit
}
