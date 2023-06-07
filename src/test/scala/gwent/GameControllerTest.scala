package cl.uchile.dcc
package gwent

import gwent.States.{GameState, InvalidPlayerAmount, InvalidTransitionException, StartGameState}
import gwent.GameController
import gwent.CardType.Cards
import gwent.Tablero.Board
import gwent.User

import munit.FunSuite

class GameControllerTest extends munit.FunSuite {
  var controller: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new GameController()
  }

  test("Una partida debe empezar") {
    //val gameController = new GameController()

    // Agregar jugadores
    controller.addPlayer("Jugador1", 0, List.empty, List.empty, new Board())
    controller.addPlayer("Jugador2", 0, List.empty, List.empty, new Board())

    // Iniciar el juego con los jugadores agregados
    controller.startGame()
  }

  test("No puede iniciar con solo 1 jugador") {
    val exception = intercept[InvalidPlayerAmount] {
      val gameControllerTest = new GameController()
      gameControllerTest.addPlayer("Player 1", 0, List.empty, List.empty, new Board())
      controller.startGame()
    }
    assert(exception.getMessage == "Se requieren al menos dos jugadores para iniciar la partida.")
  }

  test("No puede pasar de un estado a otro que no sea el que debe") {
    val exception = intercept[InvalidTransitionException] {
      controller.state.ToGameOver()
    }
    assert(exception.getMessage == "Cannot transition from StartGameState to GameOverState")
  }

  test("Una partida normal debe poder pasar por todos los estados") {
    controller.state.ToIdleState()
    controller.state.ToPlayerTurn()
    controller.state.playCard()

    controller.state.ToIdleState()
    controller.state.ToPlayerTurn()
    controller.state.passTurn()

    controller.state.ToIdleState()
    controller.state.ToEndTurn()
    controller.state.ToStartTurn()

    controller.state.ToIdleState()
    controller.state.ToEndTurn()
    controller.state.ToGameOver()
  }

}
