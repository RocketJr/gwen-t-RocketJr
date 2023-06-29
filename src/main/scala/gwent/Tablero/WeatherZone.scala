package cl.uchile.dcc
package gwent.Tablero

import gwent.CardType.WeatherCard

/** Class representing The Weather Zone in the Gwen't game.
 *
 * The WeatherZone is the space where a single WeatherCard will be played by both players.
 *
 * @constructor Create a new Zone for the WeatherCards.
 *
 * @author Leonardo Rikhardsson
 * @since 1.3.0
 * @version 1.0.0
 */

class WeatherZone {
  /** The Zone for Weather Cards.
   *
   * This variable stores the WeatherCards played in an Option.
   */
  private var weatherZone: Option[WeatherCard] = None

  /** Plays the player's card on the WeatherZone.
   *
   * The card played from the "playCard" Function and used on the "playOnBoard" Function.
   * This is achieved by using double dispatch, to filter the options depending on the zone it is being played.
   */
  def addWeatherCard(card: WeatherCard): Unit = {
    weatherZone = Some(card)
  }

  /** Shows the single card in the WeatherZone.
   *
   * Displays a single card from the WeatherZone which where played with playWeatherCard
   * This is achieved by showing the Option of the card.
   */
  def getWeatherCard: Option[WeatherCard] = weatherZone

  /** Sets the card in the WeatherZone.
   *
   * Sets the card in the Weather Zone of the board. The provided `Option` of `WeatherCard`
   * replaces the current card in the zone.
   */
  def setWeatherCard(card: Option[WeatherCard]): Unit = {
    weatherZone = card
  }
}

object WeatherZone {
  private var zoneInstance: Option[WeatherZone] = None

  def getInstance(): WeatherZone = {
    if (zoneInstance.isEmpty) zoneInstance = Some(new WeatherZone)
    zoneInstance.get
  }
}