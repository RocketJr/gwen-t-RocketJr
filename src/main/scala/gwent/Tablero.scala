package cl.uchile.dcc
package gwent

import gwent.CardType.Cards
import gwent.CardType.WeatherCard
import gwent.Tablero.Zone

class Tablero (private val rows: Int = 3, private var zonaClima: Option[WeatherCard],
               private var zonaCuerpoACuerpo: List[Cards], private var zonaDistancia: List[Cards],
               private var zonaAsedio: List[Cards]){

  def placeUnitCard(card: Cards, CardName: String, zone: Zone)

}