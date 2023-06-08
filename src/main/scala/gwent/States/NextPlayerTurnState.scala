package cl.uchile.dcc
package gwent.States

import gwent.GameController

class NextPlayerTurnState(context: GameController) extends GameState(context){
  /** Transition the game state from [[NextPlayerTurnState]] to [[IdleState]].
   */
  override def ToIdleState(): Unit = {
    context.state = new IdleState(context)
  }
}