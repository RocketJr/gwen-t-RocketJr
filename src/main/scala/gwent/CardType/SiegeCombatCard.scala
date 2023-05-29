package cl.uchile.dcc
package gwent.CardType

import java.util.Objects

import gwent.User

import gwent.Board

/** Class representing a siege combat unit card in the Gwen't game.
 *
 * A `SiegeCombatCard` is a type of [[AbstractUnitCards]].
 * These cards represent siege machinery used on the battlefield.
 * As per the game's rules, these cards can only be placed in the siege combat zone.
 *
 * @constructor create a new siege combat card with name, classification, and power.
 * @param CardName The name of the Card.
 * @param Classify The classification of the card.
 * @param Power The power of the Card.
 *              
 * @author Leonardo Rikhardsson
 * @since 1.1.0
 * @version 1.3.0
 */

class SiegeCombatCard (CardName: String, Classify: String, Power: Int)
  extends AbstractUnitCards(CardName, Classify, Power) with Equals {

  override def canEqual(that: Any): Boolean =
    that.isInstanceOf[SiegeCombatCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[SiegeCombatCard]
      CardName == other.CardName && Classify == other.Classify && Power == other.Power
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[SiegeCombatCard], CardName, Classify, Power)
  }


  /** Plays a SiegeCombatCard on the specific board
   *
   * Plays a Card on the board and calls the SiegeCombatCard function to later play on that zone
   * This is achieved by using double dispatch, to filter the necessary Card Type
   */
  override def playOnBoard(board: Board): Unit = {
    board.playSiegeCombatCard(this)
  }

}