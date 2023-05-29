package cl.uchile.dcc
package gwent.CardType

import java.util.Objects

import gwent.Tablero.{Zone, CCBoard, RCBoard, SCBoard, WBoard}

import gwent.User

import gwent.Board

/**
 * @param CardName The name of the Card.
 * @param Classify The classification of the card.
 * @param Power The power of the Card.
 * @constructor Creates a new card with a given name and classification.
 * @author Leonardo Rikhardsson
 * @since 1.1.0
 * @version 1.2.3
 */

class RangedCombatCard (CardName: String, Classify: String, Power: Int)
  extends AbstractUnitCards(CardName, Classify, Power) with Equals {

  override def canEqual(that: Any): Boolean =
    that.isInstanceOf[RangedCombatCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[RangedCombatCard]
      CardName == other.CardName && Classify == other.Classify && Power == other.Power
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[RangedCombatCard], CardName, Classify, Power)
  }


  /** Plays a RangedCombatCard and removes it from the player's hand
   *
   * Removes the desired card from the player's hand so it can be played on the RangedCombat Board
   * This is achieved by filtering the hand to get the card that needs to be removed, and only it is done so
   * if the card belongs to the RangedCombat Board. If not then it will print Invalid plays.
   */
  override def playOnBoard(board: Board): Unit = {
    board.playRangedCombatCard(this)
  }

}