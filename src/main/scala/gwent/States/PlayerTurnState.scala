package cl.uchile.dcc
package gwent.States

import gwent.GameController

import gwent.CardType.Cards

/** Represents the player's turn in the game, as part of the State Design Pattern implementation.
 *
 * It provides a specific implementation of the [[GameState]] for when the game is in the Player's Turn.
 *
 * The `context` parameter is used to transition between states.
 *
 * @param context The [[GameController]] which controls state transitions.
 * @constructor Creates a new Player Turn State with a given context.
 *
 * @author Leonardo Rikhardsson
 * @since 3.0.0
 * @version 1.0.2
 */

class PlayerTurnState(context: GameController) extends GameState(context) {
  /** Transition the game state from [[PlayerTurnState]] to [[NextPlayerTurnState]].
   *
   * This method changes the game state to `NextPlayerTurnState` via the `context`.
   */
  override def playCard(): Unit = {
    context.state = new NextPlayerTurnState(context)
  }

  /** Transition the game state from [[PlayerTurnState]] to [[NextPlayerTurnState]].
   *
   * This method changes the game state to `NextPlayerTurnState` via the `context`.
   */
  override def passTurn(): Unit = {
    context.state = new NextPlayerTurnState(context)
  }
}