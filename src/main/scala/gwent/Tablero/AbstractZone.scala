package cl.uchile.dcc
package gwent.Tablero

abstract class AbstractZone extends Zone {
  override def jugarCarta(carta: Carta, tablero: Tablero): Unit
}
