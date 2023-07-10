package cl.uchile.dcc
package gwent.CardType

import java.util.Objects
import gwent.User
import gwent.Tablero.Board

import gwent.Effects.Effect

/** Class representing a close combat unit card in the Gwen't game.
 *
 * A `CloseCombatCard` is a type of [[AbstractUnitCards]].
 * These cards represent troops that engage in close combat on the battlefield.
 * As per the game's rules, these cards can only be placed in the close combat zone.
 *
 * @constructor Creates a new `AbstractUnitCard` with a specified name, classification, and
 *              power.
 * @param CardName The name of the Card.
 * @param Classify The classification of the card.
 * @param Power The power of the Card.
 * @author Leonardo Rikhardsson
 * @since 1.0.0
 * @version 1.3.0
 */

class CloseCombatCard (CardName: String, Classify: String, Power: Int, Efecto: Effect)
  extends AbstractUnitCards(CardName, Classify, Power, Efecto) with Equals {

  override def canEqual(that: Any): Boolean =
    that.isInstanceOf[CloseCombatCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CloseCombatCard]
      CardName == other.CardName && Classify == other.Classify && Power == other.Power && Efecto == other.Efecto
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[CloseCombatCard], CardName, Classify, Power, Efecto)
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
