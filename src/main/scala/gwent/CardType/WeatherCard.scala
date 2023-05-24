package cl.uchile.dcc
package gwent.CardType

import java.util.Objects

import gwent.Tablero.{Zone, CCBoard, RCBoard, SCBoard, WBoard}

import gwent.User

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


  /** Plays a WeatherCard and removes it from the player's hand
   *
   * Removes the desired card from the player's hand so it can be played on the Weather Board
   * This is achieved by filtering the hand to get the card that needs to be removed, and only it is done so
   * if the card belongs to the Weather Board. If not then it will print Invalid plays.
   */
  def play(user: User, zone: Zone): Unit = {
    if (zone.isInstanceOf[WBoard]) {
      if (user.removeFromHand(this)) {
        zone.addCard(this)
      } else {
        println("Invalid play! The card is not in the player's hand.")
      }
    } else {
      println("Invalid play! This card can only be played in Weather Zone.")
    }
  }
}
