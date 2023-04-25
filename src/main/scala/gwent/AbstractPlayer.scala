package cl.uchile.dcc
package gwent

import gwent.CardType.Cards

/** An abstract class representing a Player with a name, it's position on the board, hit points, the number of cards on
 * the deck, the number of cards on the hand.
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

abstract class AbstractPlayer(val name: String, val pos: String, var gems: Int, var deck: List[Cards], var hand: List[Cards])
  extends Player with Equals {


  /**
   * Takes the first card from the deck and adds it to the hand
   */
  override def TakeCard(): Unit = {
    // If the list is not empty
    if (deck != null) {
      // Take the first card from the deck
      val First = deck.head
      // Adds it to the hand
      hand = hand :+ First
      // Makes a new deck without the first card
      deck = deck.tail
    }
    //deck -= card
    //hand += card
  }
}