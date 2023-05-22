package cl.uchile.dcc
package gwent.Tablero

trait Zone {
  def jugarCarta(carta: Carta, tablero: Tablero): Unit
}
