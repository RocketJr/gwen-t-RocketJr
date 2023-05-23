package cl.uchile.dcc
package gwent.CardType

import java.util.Objects

import gwent.Tablero.{Zone, CCBoard, RCBoard, SCBoard, WBoard}

import gwent.User

/**
 * @param CardName The name of the Card.
 * @param Classify The classification of the card.
 * @param Power The power of the Card.
 * @constructor Creates a new card with a given name and classification.
 * @author Leonardo Rikhardsson
 * @since 1.0.0
 * @version 1.1.0
 */

class CloseCombatCard(CardName: String, Classify: String, Power: Int)
  extends AbstractUnitCards(CardName, Classify, Power) with Equals {

  override def canEqual(that: Any): Boolean =
    that.isInstanceOf[CloseCombatCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CloseCombatCard]
      CardName == other.CardName && Classify == other.Classify && Power == other.Power
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[CloseCombatCard], CardName, Classify, Power)
  }

  def play(user: User, zone: Zone): Unit = {
    if (zone.isInstanceOf[CCBoard]) {
      zone.addCard(this)
      user.removeFromHand(this)
    } else {
      println("Invalid play! This card can only be played in Close Combat Zone.")
    }
  }
}
