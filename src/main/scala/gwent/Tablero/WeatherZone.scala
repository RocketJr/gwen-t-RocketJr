package cl.uchile.dcc
package gwent.Tablero

class WeatherZone {
  override def jugarCarta(carta: Carta, tablero: Tablero): Unit = {
    tablero.jugarCartaEnZona(carta, this)
}
