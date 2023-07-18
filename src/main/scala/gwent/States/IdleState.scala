package cl.uchile.dcc
package gwent.States

import gwent.GameController

/** Represents the idle state in the game, as part of the State Design Pattern implementation.
 *
 * It provides a specific implementation of the [[GameState]] for when the game is idle.
 *
 * The `context` parameter is used to transition between states.
 *
 * @param context The [[GameController]] which controls state transitions.
 * @constructor Creates a new idle game state with a given context.
 *
 * @author Leonardo Rikhardsson
 * @since 3.0.0
 * @version 1.0.2
 */

class IdleState(context: GameController) extends GameState(context) {
  /** Transition the game state from [[IdleState]] to [[PlayerTurnState]].
   *
   * This method changes the game state to `PlayerTurnState` via the `context`.
   */
  override def ToPlayerTurn(): Unit = {
    context.state = new PlayerTurnState(context)
  }

  /** Transition the game state from [[IdleState]] to [[EndTurnState]].
   *
   * This method changes the game state to `EndTurnState` via the `context`.
   */
  override def ToEndTurn(): Unit = {
    context.state = new EndTurnState(context)
  }
}