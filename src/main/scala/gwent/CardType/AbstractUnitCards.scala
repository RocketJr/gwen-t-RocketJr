package cl.uchile.dcc
package gwent.CardType

import gwent.User

import gwent.Tablero.Board

/** Abstract class representing a unit card in the Gwen't game.
 *
 * An `AbstractUnitCard` is a type of [[Cards]] that has a power value which contributes to
 * the player's total power in the game.
 * Each unit card starts with its current power equal to its base power.
 *
 * @constructor Creates a new `AbstractUnitCard` with a specified name, classification, and
 *              power.
 * @param CardName The name of the Card.
 * @param Classify The class of the Card.
 * @param Power The power of the Card.
 * @author Leonardo Rikhardsson
 * @since 1.0.1
 * @version 1.3.0
 */

abstract class AbstractUnitCards protected(val CardName: String, val Classify: String, val Power: Int)
  extends Cards {

  /** The current power of the card, which may be affected by various conditions during
   * gameplay.
   * Initially set to the base [[Power]] of the card.
   */
  var currentPower: Int = Power

  /** Method to play the card on the board. */
  override def playOnBoard(board: Board): Unit
}
