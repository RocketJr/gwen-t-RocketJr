package cl.uchile.dcc
package gwent.States

import gwent.GameController

class StartTurnState(context: GameController) extends GameState(context) {
  /** Transition the game state from [[StartTurnState]] to [[IdleState]].
   */
  override def ToIdleState(): Unit = {
    // Agregar drawCards
    context.state = new IdleState(context)
  }
}