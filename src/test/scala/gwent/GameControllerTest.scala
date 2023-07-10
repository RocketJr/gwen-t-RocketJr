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
  var user1: User = _
  var user2: User = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new GameController(List.empty)
    user1 = new User("Jugador1", 3, List.empty, List.empty, new Board())
    user2 = new User("Jugador2", 3, List.empty, List.empty, new Board())
  }

  test("Una partida debe empezar") {
    //val gameController = new GameController()

    // Agregar jugadores
    controller.addPlayer(user1)
    controller.addPlayer(user2)

    // Iniciar el juego con los jugadores agregados
    controller.startGame()
  }

  test("No puede iniciar con solo 1 jugador") {
    val exception = intercept[InvalidPlayerAmount] {
      val gameControllerTest = new GameController(List.empty)
      gameControllerTest.addPlayer(user1)
      controller.startGame()
    }
    assert(exception.getMessage == "Se requieren al menos dos jugadores para iniciar la partida.")
  }

  test("No puede pasar de un estado a otro que no sea el que debe") {
    val exception1 = intercept[InvalidTransitionException] {
      controller.state.ToPlayerTurn()
    }
    assert(exception1.getMessage == "Cannot transition from StartGameState to PlayerTurnState")

    val exception2 = intercept[InvalidTransitionException] {
      controller.state.playCard()
    }
    assert(exception2.getMessage == "Cannot transition from StartGameState to NextPlayerTurnState")

    val exception3 = intercept[InvalidTransitionException] {
      controller.state.passTurn()
    }
    assert(exception3.getMessage == "Cannot transition from StartGameState to NextPlayerTurnState")

    val exception4 = intercept[InvalidTransitionException] {
      controller.state.ToEndTurn()
    }
    assert(exception4.getMessage == "Cannot transition from StartGameState to EndTurnState")

    val exception5 = intercept[InvalidTransitionException] {
      controller.state.ToStartTurn()
    }
    assert(exception5.getMessage == "Cannot transition from StartGameState to StartTurnState")

    val exception6 = intercept[InvalidTransitionException] {
      controller.state.ToGameOver()
    }
    assert(exception6.getMessage == "Cannot transition from StartGameState to GameOverState")

    val exception7 = intercept[InvalidTransitionException] {
      controller.state.ToGameOver()
    }
    assert(exception7.getMessage == "Cannot transition from StartGameState to GameOverState")
  }

  test("No puede pasar PlayerTurnState a IdleState") {
    val exception = intercept[InvalidTransitionException] {
      controller.state.ToIdleState()
      controller.state.ToPlayerTurn()
      controller.state.ToIdleState()
    }
    assert(exception.getMessage == "Cannot transition from PlayerTurnState to IdleState")
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
