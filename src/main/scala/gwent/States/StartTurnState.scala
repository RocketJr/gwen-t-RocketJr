package cl.uchile.dcc
package gwent.States

import gwent.GameController

/** Represents the Start Turn state in the game, as part of the State Design Pattern implementation.
 *
 * It provides a specific implementation of the [[GameState]] for when the turn is Starting.
 *
 * The `context` parameter is used to transition between states.
 *
 * @param context The [[GameController]] which controls state transitions.
 * @constructor Creates a new Start Turn State with a given context.
 *
 * @author Leonardo Rikhardsson
 * @since 3.0.0
 * @version 1.0.2
 */

class StartTurnState(context: GameController) extends GameState(context) {
  /** Transition the game state from [[StartTurnState]] to [[IdleState]].
   *
   * This method changes the game state to `IdleState` via the `context`.
   */
  override def ToIdleState(): Unit = {
    // Agregar drawCards
    context.state = new IdleState(context)
  }
}