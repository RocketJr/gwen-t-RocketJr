package cl.uchile.dcc
package gwent

import java.util.Objects

/** A Trait representing a Player with a name, it's position on the board, hit points, the number of cards on
 * the deck, the number of cards on the hand. Where you can add cards on your hand and play cards from your hand.
 *
 * @param name The name of the player.
 * @param pos The position the player is in.
 * @param gems The amount of lives the player has.
 * @param deck The amount of cards the player has on the deck.
 * @param hand The amount of cards the player has on the hand.
 *
 * @constructor Creates a new player with the specified information.
 *
 * @author Leonardo Rikhardsson
 * @since 1.0.1
 * @version 1.0.0
 */

trait Player {
  /** The name of the Player. */
  val name: String
  /** The Position the player will be starting. */
  val pos: String
  /** The hit points of the Player. */
  var gems: Int
  /** The cards the player has on the deck. */
  var deck: Int
  /** The cards the player has on the hand. */
  var hand: Int

  def TakeCard(card: Int): Unit

  def PlayCard(card: Int): Unit
}
