package cl.uchile.dcc
package gwent

import gwent.GameController
import gwent.CardType.Cards
import gwent.Tablero.Board
import gwent.User

import munit.FunSuite

class ObserverTest extends munit.FunSuite {
  var controller: GameController = _
  var user1: User = _
  var user2: User = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new GameController(List.empty)
    user1 = new User("Jugador1", 2, List.empty, List.empty, new Board())
    user2 = new User("Jugador2", 2, List.empty, List.empty, new Board())
  }

  test("Una partida debe empezar") {
    //val gameController = new GameController()

    // Agregar jugadores
    controller.addPlayer(user1)
    controller.addPlayer(user2)

    // Iniciar el juego con los jugadores agregados
    controller.startGame()
  }

  test("Si se llega a perder las vidas, hay un ganador") {
    val winCondition = new WinCondition("prizes")

    // Simular juego
    controller.addPlayer(user1)
    controller.addPlayer(user2)
    controller.startGame()
    user1.LoseHealth()
    assertEquals(user1.gemCounter, 1)

    user2.LoseHealth()
    assertEquals(user2.gemCounter, 1)

    user1.LoseHealth()
    assertEquals(user1.gemCounter, 0)
    //controller.update(user1, winCondition)
    //assertEquals(user1.notifyObservers())
    //assertEquals(controller.update(user1, new WinCondition("Low on Health")))
  }
}
