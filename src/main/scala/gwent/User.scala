package cl.uchile.dcc
package gwent

import gwent.CardType.Cards

import gwent.Tablero.Board

import gwent.Observadores.AbstractSubject

import java.util.Objects

/** Class representing a player in the Gwen't game.
 *
 * Each player has a name, a gem counter, a deck of cards, a hand of cards and their zone in the board.
 * The deck and hand are private variables, but can be accessed via their corresponding
 * getter methods.
 * We use immutable lists instead of mutable ones to represent the deck and the hand.
 * This is a common practice in functional programming and in Scala in particular.
 * By using immutable data structures, we can avoid potential side effects caused by
 * mutable state and make our code safer and easier to reason about.
 *
 * @constructor Create a new player with a name, gem counter, deck, hand and board.
 * @param name The name of the player.
 * @param gemCounter The amount of lives the player has.
 * @param _deck The amount of cards the player has on the deck.
 * @param _hand The amount of cards the player has on the hand.
 * @param board The board represented in the game.
 *
 * @author Leonardo Rikhardsson
 * @since 1.0.1
 * @version 1.3.0
 */

class User(val name: String, var gemCounter: Int, private var _deck: List[Cards],
           private var _hand: List[Cards], var board: Board) extends AbstractSubject[WinCondition] with Equals {

  def LoseHealth(): Unit = {
    gemCounter -= 1
    if (gemCounter <= 0) {
      notifyObservers(new WinCondition("being low on health"))
    }
  }

  /** Throws an [[InvalidGem]] with a message about an invalid gemCounter.
   *
   * @throws InvalidGem always.
   */
  def NegativeGems(): Unit = {
    if (gemCounter < 0) {
      throw new InvalidGem("No puede iniciar con vidas negativas")
    }
  }

  /** Accessor method for the player's deck */
  def deck: List[Cards] = _deck

  /** Accessor method for the player's hand */
  def hand: List[Cards] = _hand

  /** Setter method for the player's deck */
  def deckSet(decks: List[Cards]): Unit = {
    _deck = decks
  }

  /** Setter method for the player's hand */
  def handSet(hands: List[Cards]): Unit = {
    _hand = hands
  }

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

  /** Plays a card from the player's hand
   *
   * Removes the desired card from the player's hand and then plays it on the board
   * This is achieved by filtering the hand to get the card that needs to be removed and calling another function
   * to play the card.
   */
  def playCard(card: Cards): Boolean = {
    if (removeFromHand(card)) {
      card.playOnBoard(board)
      true
    } else {
      false
    }
  }

  /** Returns the player's board */
  def getBoard: Board = board
}