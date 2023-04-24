package cl.uchile.dcc
package gwent

import java.util.Objects

/** A Computer that extends AbstractPlayer and takes cards from the deck to the hand, and plays cards from the hand.
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

class Computer(name: String,pos: String,gems: Int,deck: Int,hand: Int) extends
  AbstractPlayer(name, pos, gems, deck, hand){

  override def TakeCard(card: Int): Unit = {
    deck -= card
    hand += card
  }

  override def PlayCard(card: Int): Unit = {
    hand -= card
  }

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[Computer]
  }

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Computer]
      name == other.name && gems == other.gems && deck == other.deck && hand == other.hand
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[Computer], name, pos, gems, deck, hand)
  }
}
