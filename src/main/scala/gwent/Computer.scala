package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.CardType.Cards

import java.util.Objects

/** A Computer that extends AbstractPlayer and takes cards from the deck to the hand.
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

class Computer(name: String,pos: String,gems: Int,deck: List[Cards],hand: List[Cards]) extends
  AbstractPlayer(name, pos, gems, deck, hand) {

  override def canEqual(that: Any): Boolean =
    that.isInstanceOf[Computer]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Computer]
      name == other.name && pos == other.pos
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[Computer], name, pos, gems, deck, hand)
  }
}
