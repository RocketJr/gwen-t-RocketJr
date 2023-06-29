package cl.uchile.dcc
package gwent.States

import gwent.GameController

class StartGameState(context: GameController) extends GameState(context) {
  /** Transition the game state from [[StartGameState]] to [[IdleState]].
   */
  override def ToIdleState(): Unit = {
    context.state = new IdleState(context)
  }
}