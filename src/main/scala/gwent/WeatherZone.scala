package cl.uchile.dcc
package gwent

import gwent.CardType.WeatherCard

class WeatherZone {
  /** The Zone for Weather Cards.
   *
   * This variable stores the WeatherCards played in an Option.
   */
  private var instance: Option[WeatherCard] = None

  /** Plays the player's card on the WeatherZone.
   *
   * The card played from the "playCard" Function and used on the "playOnBoard" Function.
   * This is achieved by using double dispatch, to filter the options depending on the zone it is being played.
   */
  def addWeatherCard(card: WeatherCard): Unit = {
    instance = Some(card)
  }

  /** Shows the single card in the WeatherZone.
   *
   * Displays a single card from the WeatherZone which where played with playWeatherCard
   * This is achieved by showing the Option of the card.
   */
  def getWeatherCard: Option[WeatherCard] = instance

  // Setter
  def setWeatherCard(card: Option[WeatherCard]): Unit = {
    instance = card
  }
}

object WeatherZone {
  private var zoneInstance: Option[WeatherZone] = None

  def getInstance(): WeatherZone = {
    if (zoneInstance.isEmpty) zoneInstance = Some(new WeatherZone)
    zoneInstance.get
  }
}