package cl.uchile.dcc
package gwent.States

import gwent.GameController

class StartGameState(context: GameController) extends GameState(context) {
  override def ToWhoStarts(): Unit = {
    context.state = new WhoStartsFirstState(context)
  }
}