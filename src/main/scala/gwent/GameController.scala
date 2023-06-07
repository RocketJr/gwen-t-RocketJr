package cl.uchile.dcc
package gwent

import gwent.States.{GameState, StartGameState}

import gwent.CardType.Cards
import gwent.Tablero.Board

import gwent.User

class GameController {
  // Los jugadores de la partida
  private var players: List[User] = List.empty
  private var currentPlayer: Option[User] = None
  // Estado actual del juego
  var state: GameState = new StartGameState(this)

  // Iniciar la partida
  def startGame(): Unit = {
    //players.foreach(addPlayer(playerName, 0, List.empty, List.empty, new Board()))

    if (players.length < 2) {
      throw new RuntimeException("Se requieren al menos dos jugadores para iniciar la partida.")
    }

    // Seleccionar un jugador aleatorio para empezar
    val startingPlayer = players(scala.util.Random.nextInt(players.length))
    currentPlayer = Some(startingPlayer)

    // Cambiar al estado de juego activo
    state = new StartGameState(this)

    // Imprimir el jugador que empieza
    println(s"¡La partida ha comenzado! ${startingPlayer.name} es el primer jugador.")
  }

  // Agregar un jugador a la partida
  def addPlayer(name: String, gemCounter: Int, _deck: List[Cards], _hand: List[Cards], board: Board): Unit = {
    val player = new User(name, gemCounter, _deck, _hand, board)
    players = player :: players
  }

}
