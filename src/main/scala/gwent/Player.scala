package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.CardType.Cards

import java.util.Objects

/** A Trait representing a Player with a name, it's position on the board, hit points, the number of cards on
 * the deck, the number of cards on the hand. Where you can add cards on your hand and play cards from your hand.
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
  var deck: List[Cards]
  /** The cards the player has on the hand. */
  var hand: List[Cards]

  def TakeCard(): Unit
}
