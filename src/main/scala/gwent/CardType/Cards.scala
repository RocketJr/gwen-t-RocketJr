package cl.uchile.dcc
package gwent.CardType

/** A trait representing a Cards with a name, it's class, and power.
 *
 * @param CardName The name of the Card.
 * @param Classify The class of the Card.
 * @param Empowered The power of the Card.
 *
 * @author Leonardo Rikhardsson
 *
 * @since 1.0.1
 * @version 1.0.0
 */

trait Cards {
  /** The name of the Card. */
  val CardName: String
  /** The Type of the Card. */
  val Classify: String
  /** The Power of the Card. */
  val Empowered: Int
}
