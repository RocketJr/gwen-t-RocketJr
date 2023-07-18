package cl.uchile.dcc
package gwent

import gwent.States.{GameState, InvalidPlayerAmount, StartGameState}
import gwent.CardType.Cards
import gwent.Tablero.Board
import gwent.User
import gwent.Observadores.{Observer,Subject}

/** A game controller for managing the players, states, and cards in a game.
 *
 * This class is the core of the game and handles the transition of states, battles,
 * player turns, as well as the creation and card management
 * of items using item factories.
 *
 * It maintains a list of players.
 * It also manages the current state of the game.
 *
 * @param players The number of players that will be playing the game.
 * @constructor Creates a new GameController with an empty currentPlayer list, observers,
 *              and an initial state of StartGameState.
 *
 * @author Leonardo Rikhardsson
 * @since 3.0.0
 * @version 1.0.2
 */

class GameController(private var players: List[User]) extends Observer[WinCondition] {
  for (player <- players) {
    player.addObserver(this)
  }

  /** Updates the Game Controller when the state of a player changes.
   *
   * @param subject The subject triggering the update.
   * @param value The value for the WindCondition.
   */
  override def update(
                       subject: Subject[WinCondition],
                       value: WinCondition
                     ): Unit = {
    val winCondition = value.asInstanceOf[WinCondition]
    println(s"Player $subject has lost the game from ${winCondition.name}")
  }

  //private var players: List[User] = List.empty
  /** The current GameCharacter whose turn it is to perform an action. */
  private var currentPlayer: Option[User] = None
  /** Current state of the game, initially set to an instance of StartGameState. */
  var state: GameState = new StartGameState(this)

  /** Starts a new game with the specified players.
   *
   * This method initializes the game by checking if the current players are less than 2 players, and then choosing
   * the first player to play randomly.
   * The state of the game is then set to [[StartGameState]].
   * Prints the player who will be playing first.
   *
   */
  def startGame(): Unit = {
    //players.foreach(addPlayer(playerName, 0, List.empty, List.empty, new Board()))

    if (players.length < 2) {
      throw new InvalidPlayerAmount("Se requieren al menos dos jugadores para iniciar la partida.")
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
  //def addPlayer(player: User): Unit = {
    //val player = new User(name, gemCounter, _deck, _hand, board)
    //players = player :: players
  //}

}
