package cl.uchile.dcc
package gwent.CardType

import java.util.Objects

import gwent.User

import gwent.Board

/** Class representing a weather card in the Gwen't game.
 *
 * A `WeatherCard` is a type of [[Cards]] that can be placed in the weather zone.
 * These cards have the ability to affect the battlefield and provide advantages or
 * disadvantages to players, depending on the type of weather that has been chosen.
 *
 * @constructor Creates a new `WeatherCard` with a specified name and classification.
 * @param CardName The name of the Card.
 * @param Classify The classification of the card.
 *
 * @author Leonardo Rikhardsson
 * @since 1.0.0
 * @version 1.3.0
 */

class WeatherCard(val CardName: String, val Classify: String) extends Cards with Equals {

  override def canEqual(that: Any): Boolean =
    that.isInstanceOf[WeatherCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[WeatherCard]
      CardName == other.CardName && Classify == other.Classify
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[WeatherCard], CardName, Classify)
  }


  /** Plays a WeatherCard on the specific board
   *
   * Plays a Card on the board and calls the WeatherCard function to later play on that zone
   * This is achieved by using double dispatch, to filter the necessary Card Type
   */
  override def playOnBoard(board: Board): Unit = {
    board.playWeatherCard(this)
  }

}
