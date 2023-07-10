package cl.uchile.dcc
package gwent.Observadores

trait Observer[T] {
  def update(observable: Subject[T], value: T): Unit
}