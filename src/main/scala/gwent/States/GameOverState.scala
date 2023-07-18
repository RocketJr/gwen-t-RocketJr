package cl.uchile.dcc
package gwent.States

import gwent.GameController

/** Represents the End of a Game state in the game, as part of the State Design Pattern implementation.
 *
 * It provides a specific implementation of the [[GameState]] for when the game is Over.
 *
 * The `context` parameter is used to transition between states.
 *
 * @param context The [[GameController]] which controls state transitions.
 * @constructor Creates a new Game Over state with a given context.
 *
 * @author Leonardo Rikhardsson
 * @since 3.0.0
 * @version 1.0.2
 */

class GameOverState(context: GameController) extends GameState(context) {

}