package cl.uchile.dcc
package gwent.States

import gwent.GameController

class EndTurnState(context: GameController) extends GameState(context) {
  /** Transition the game state from [[EndTurnState]] to [[StartTurnState]].
   */
  override def ToStartTurn(): Unit = {
    context.state = new StartTurnState(context)
  }

  /** Transition the game state from [[EndTurnState]] to [[GameOverState]].
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