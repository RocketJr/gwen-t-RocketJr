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
 * @constructor Creates a new player with the specified information.
 * @author Leonardo Rikhardsson
 * @since 1.0.1
 * @version 1.0.0
 */

abstract class AbstractPlayer(val name: String, val pos: String, var gems: Int, var deck: List[Cards], var hand: List[Cards])
  extends Player with Equals {

  override def TakeCard(): Unit = {
    if (deck != null) {
      val First = deck.head
      hand = hand :+ First
      deck = deck.tail
    }
    //deck -= card
    //hand += card
  }

  //override def PlayCard(card: Cards): Unit = {
    //if (deck != null) {
      //hand.filter(_ != card)
    //}
    //hand -= card
  //}

}