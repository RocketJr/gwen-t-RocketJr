package cl.uchile.dcc
package gwent.States

import gwent.GameController

/** Represents the End Turn state in the game, as part of the State Design Pattern implementation.
 *
 * It provides a specific implementation of the [[GameState]] for when the game is Ending a Turn.
 *
 * The `context` parameter is used to transition between states.
 *
 * @param context The [[GameController]] which controls state transitions.
 * @constructor Creates a new End Turn State with a given context.
 *
 * @author Leonardo Rikhardsson
 * @since 3.0.0
 * @version 1.0.2
 */

class EndTurnState(context: GameController) extends GameState(context) {
  /** Transition the game state from [[EndTurnState]] to [[StartTurnState]].
   *
   * This method changes the game state to `StartTurnState`.
   */
  override def ToStartTurn(): Unit = {
    context.state = new StartTurnState(context)
  }

  /** Transition the game state from [[EndTurnState]] to [[GameOverState]].
   *
   * This method changes the game state to `GameOverState` via the `context`.
   */
  override def ToGameOver(): Unit = {
    context.state = new GameOverState(context)
  }
  //override def endTurn(): Unit = {
    // Lógica específica para el estado EndTurnState

    // Realiza acciones al final del turno

    // Cambia el jugador actual al primer jugador de la lista
   // context.currentPlayer = context.players.head

   // context.state = new PlayerDecisionState(context)
 // }
}