package cl.uchile.dcc
package gwent.CardType

import java.util.Objects

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


  /** Plays a RangedCombatCard on the specific board
   *
   * Plays a Card on the board and calls the RangedCombatCard function to later play on that zone
   * This is achieved by using double dispatch, to filter the necessary Card Type
   */
  override def playOnBoard(board: Board): Unit = {
    board.playRangedCombatCard(this)
  }

}