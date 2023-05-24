package cl.uchile.dcc
package gwent.CardType

import gwent.Tablero.Zone

import gwent.User

/** A trait representing a Cards with a name, it's class, and power.
 *
 * @author Leonardo Rikhardsson
 *
 * @since 1.0.1
 * @version 1.2.3
 */

trait Cards {
  /** The name of the Card. */
  val CardName: String
  /** The Type of the Card. */
  val Classify: String

  //def playInZone(user: User, zone: Int): Unit

  /** Method to play the card on a specific zone. */
  def play(user: User, zone: Zone): Unit
}
