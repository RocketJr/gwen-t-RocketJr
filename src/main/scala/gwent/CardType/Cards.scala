package cl.uchile.dcc
package gwent.CardType

/** A trait representing a Cards with a name, it's class, and power.
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
}
