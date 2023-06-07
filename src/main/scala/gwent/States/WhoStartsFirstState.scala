package cl.uchile.dcc
package gwent.States

import gwent.GameController

class WhoStartsFirstState(context: GameController) extends GameState(context) {
  override def ToIdleState(): Unit = {
    // Add the new decks
    // Shuffle the decks
    context.state = new IdleState(context)
  }
}