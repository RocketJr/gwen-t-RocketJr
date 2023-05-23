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
 * @version 1.0.0
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

  def play(user: User, zone: Zone): Unit = {
    if (zone.isInstanceOf[WBoard]) {
      zone.addCard(this)
      user.removeFromHand(this)
    } else {
      println("Invalid play! This card can only be played in Weather Zone.")
    }
  }
}
