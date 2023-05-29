package cl.uchile.dcc
package gwent

import gwent.CardType.Cards

import java.util.Objects

import gwent.Board

/** A Player that extends AbstractPlayer and takes cards from the deck to the hand.
 *
 * @param name The name of the player.
 * @param gemCounter The amount of lives the player has.
 * @param _deck The amount of cards the player has on the deck.
 * @param _hand The amount of cards the player has on the hand.
 *
 * @constructor Creates a new player with the specified information.
 *
 * @author Leonardo Rikhardsson
 * @since 1.0.1
 * @version 1.0.0
 */

class User(val name: String, var gemCounter: Int, private var _deck: List[Cards],
           private var _hand: List[Cards], var board: Board) extends Equals {

  /** Accessor method for the player's deck */
  def deck: List[Cards] = _deck

  /** Accessor method for the player's hand */
  def hand: List[Cards] = _hand

  /** Draws a card from the deck and adds it to the hand.
   *
   * The top card from the deck is removed and added to the player's hand.
   * This method also returns the drawn card.
   *
   * Note: as lists are immutable, when we "remove" a card from the deck or "add" one to
   * the hand, what we're actually doing is creating a new list with the desired contents
   * and reassigning the _deck or _hand variable to this new list.
   *
   * @return The card that was drawn from the deck.
   */
  def DrawCard(): Cards = {
    val card = deck.head
    _deck = deck.tail
    _hand = card :: hand
    card
  }

  /** Shuffles the player's deck.
   *
   * The order of cards in the player's deck is randomized.
   * This is achieved by creating a new, shuffled list and reassigning _deck to it, rather
   * than by modifying the original list.
   */
  def ShuffleDeck(): Unit = {
    _deck = scala.util.Random.shuffle(_deck)
  }

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[User]
  }

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[User]
      name == other.name && gemCounter == other.gemCounter && deck == other.deck && hand == other.hand
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[User], name, gemCounter, deck, hand)
  }


  /** Removes a card from the player's hand
   *
   * Removes the desired card from the player's hand
   * This is achieved by filtering the hand to get the card that needs to be removed.
   */
  private def removeFromHand(card: Cards): Boolean = {
    if (hand.contains(card)) {
      _hand = _hand.filterNot(_ == card)
      true
    } else {
      false
    }
  }

  def playCard(card: Cards): Boolean = {
    if (removeFromHand(card)) {
      board.playCard(card)
      true
    } else {
      false
    }
  }

}
