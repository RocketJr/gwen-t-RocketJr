package cl.uchile.dcc
package gwent.CardType

import java.util.Objects

import gwent.User

import gwent.Board

/**
 * @param CardName The name of the Card.
 * @param Classify The classification of the card.
 * @constructor Creates a new card with a given name and type.
 * @author Leonardo Rikhardsson
 * @since 1.0.0
 * @version 1.2.3
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
