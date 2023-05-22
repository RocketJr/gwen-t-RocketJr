package cl.uchile.dcc
package gwent.Tablero

class SiegeCombatZone {
  override def jugarCarta(carta: Carta, tablero: Tablero): Unit = {
    tablero.jugarCartaEnZona(carta, this)
  }
}
