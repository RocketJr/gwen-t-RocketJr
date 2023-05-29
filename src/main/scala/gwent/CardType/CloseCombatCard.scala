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
 * @since 1.0.0
 * @version 1.2.3
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


  /** Plays a CloseCombatCard on the specific board
   * 
   * Plays a Card on the board and calls the CloseCombatCard function to later play on that zone
   * This is achieved by using double dispatch, to filter the necessary Card Type
   */
  override def playOnBoard(board: Board): Unit = {
    board.playCloseCombatCard(this)
  }

}
