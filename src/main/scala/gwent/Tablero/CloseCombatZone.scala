package cl.uchile.dcc
package gwent.Tablero

class CloseCombatZone {
  override def jugarCarta(carta: Carta, tablero: Tablero): Unit = {
    tablero.jugarCartaEnZona(carta, this)
  }
}
