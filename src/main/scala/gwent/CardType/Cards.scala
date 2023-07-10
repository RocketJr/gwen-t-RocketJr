package cl.uchile.dcc
package gwent.CardType

import gwent.User
import gwent.Tablero.Board

import gwent.Effects.Effect

/** Trait representing a card in the Gwen't game.
 *
 * A card is characterized by its [[name]] and [[description]].
 * This trait serves as a common interface for all card types and ensures that every card,
 * regardless of its specific subtype, will have these basic properties.
 *
 * The ``val`` keyword in the property declarations indicates that these properties are
 * immutable -- once a card has been created with a certain name and description, these
 * cannot be changed.
 * This reflects the real-world behaviour of game cards, which have fixed names and
 * descriptions printed on them.
 *
 * The actual content of these properties, as well as any additional properties or
 * behaviours, are to be defined in the concrete classes that extend this trait.
 *
 * @author Leonardo Rikhardsson
 * @since 1.0.1
 * @version 1.3.0
 */

trait Cards {
  /** The name of the Card. */
  val CardName: String
  /** The Type of the Card. */
  val Classify: String
  /** The Type of effect of the Card. */
  val Efecto: Effect

  //def playInZone(user: User, zone: Int): Unit

  /** Method to play the card on the board. */
  def playOnBoard(board: Board): Unit
}
