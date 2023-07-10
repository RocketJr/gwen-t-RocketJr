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
    user1 = new User("Jugador1", 2, List.empty, List.empty, new Board())
    user2 = new User("Jugador2", 2, List.empty, List.empty, new Board())
    controller = new GameController(List(user1, user2))
  }

  test("Una partida debe empezar") {
    // Iniciar el juego con los jugadores agregados
    controller.startGame()
  }

  test("Si se llega a perder las vidas, hay un ganador") {
    controller.startGame()
    user1.LoseHealth()
    assertEquals(user1.gemCounter, 1)

    user2.LoseHealth()
    assertEquals(user2.gemCounter, 1)

    user1.LoseHealth()
    assertEquals(user1.gemCounter, 0)
  }
}
