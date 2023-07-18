package cl.uchile.dcc
package gwent.States

import gwent.GameController

/** Represents the Next player's turn in the game, as part of the State Design Pattern implementation.
 *
 * It provides a specific implementation of the [[GameState]] for when the game is in the Next Player's Turn.
 *
 * The `context` parameter is used to transition between states.
 *
 * @param context The [[GameController]] which controls state transitions.
 * @constructor Creates a new Next Player Turn State with a given context.
 *
 * @author Leonardo Rikhardsson
 * @since 3.0.0
 * @version 1.0.2
 */

class NextPlayerTurnState(context: GameController) extends GameState(context){
  /** Transition the game state from [[NextPlayerTurnState]] to [[IdleState]].
   *
   * This method changes the game state to `IdleState` via the `context`.
   */
  override def ToIdleState(): Unit = {
    context.state = new IdleState(context)
  }
}