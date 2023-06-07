package cl.uchile.dcc
package gwent.States

import gwent.GameController

class NextPlayerTurnState(context: GameController) extends GameState(context){
  override def ToIdleState(): Unit = {
    context.state = new IdleState(context)
  }
}