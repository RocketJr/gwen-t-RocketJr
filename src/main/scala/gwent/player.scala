package cl.uchile.dcc
package gwent

/**
 * @param name The name of the player
 * @param pos The position the player is in
 * @param gems The amount of lives the player has
 * @param deck The amount of cards the player has on the deck
 * @param hand The amount of cards the player has on the hand
 *
 * @example
 * {{{
 * var playerOne = new player("Alejandro", "top", 3, 20, 4)
 * playerOne.TakeCard(3)
 * }}}
 *
 * @constructor Creates a new player with the specified information
 *
 * @author Leonardo Rikhardsson
 * @since 1.0.0
 * @version 1.0.0
 */

class player(val name: String, val pos: String, var gems: Int, var deck: Int, var hand: Int) {
  def TakeCard(card: Int): Unit = {
    deck -= card
    hand += card
  }

  def PlayCard(card: Int): Unit = {
    hand -= card
  }
}
