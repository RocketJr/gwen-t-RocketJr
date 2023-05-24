package cl.uchile.dcc
package gwent.CardType

import gwent.Tablero.Zone

import gwent.User

/** An abstract class representing a Cards with a name, it's class, and power.
 *
 * @param CardName The name of the Card.
 * @param Classify The class of the Card.
 * @param Power The power of the Card.
 *
 * @author Leonardo Rikhardsson
 *
 * @since 1.0.1
 * @version 1.2.3
 */

abstract class AbstractUnitCards protected(val CardName: String, val Classify: String, val Power: Int)
  extends Cards {

  /** The current power of the card, which may be affected by various conditions during
   * gameplay.
   * Initially set to the base [[Power]] of the card.
   */
  var currentPower: Int = Power

  /** Method to play the card on a specific zone. */
  def play(user: User, zone: Zone): Unit
}
