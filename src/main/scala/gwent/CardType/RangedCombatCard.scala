package cl.uchile.dcc
package gwent.CardType

import java.util.Objects
import gwent.User
import gwent.Tablero.Board

import gwent.Effects.Effect

/** Class representing a ranged combat unit card in the Gwen't game.
 *
 * A `RangedCombatCard` is a type of [[AbstractUnitCards]].
 * These cards represent troops that engage in range combat on the battlefield.
 * As per the game's rules, these cards can only be placed in the ranged combat zone.
 *
 * @constructor Creates a new `AbstractUnitCard` with a specified name, classification, and
 *              power.
 * @param CardName The name of the Card.
 * @param Classify The classification of the card.
 * @param Power The power of the Card.
 *              
 * @author Leonardo Rikhardsson
 * @since 1.1.0
 * @version 3.1.0
 */

class RangedCombatCard (CardName: String, Classify: String, Power: Int, Efecto: Effect)
  extends AbstractUnitCards(CardName, Classify, Power, Efecto) with Equals {

  override def canEqual(that: Any): Boolean =
    that.isInstanceOf[RangedCombatCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[RangedCombatCard]
      CardName == other.CardName && Classify == other.Classify && Power == other.Power && Efecto == other.Efecto
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[RangedCombatCard], CardName, Classify, Power, Efecto)
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