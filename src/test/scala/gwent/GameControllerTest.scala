package cl.uchile.dcc
package gwent

import gwent.States.{GameState, StartGameState}

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

  test("A player needs a name") {
    //val gameController = new GameController()

    // Agregar jugadores
    controller.addPlayer("Jugador1", 0, List.empty, List.empty, new Board())
    controller.addPlayer("Jugador2", 0, List.empty, List.empty, new Board())

    // Iniciar el juego con los jugadores agregados
    controller.startGame()
  }
}
