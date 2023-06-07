package cl.uchile.dcc
package gwent.States

import gwent.GameController

class IdleState(context: GameController) extends GameState(context) {
  override def ToPlayerTurn(): Unit = {
    context.state = new PlayerTurnState(context)
  }

  override def ToEndTurn(): Unit = {
    context.state = new EndTurnState(context)
  }
}
