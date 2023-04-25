package cl.uchile.dcc
package gwent.CardType

/** An abstract class representing a Cards with a name, it's class, and power.
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

abstract class AbstractCards(val CardName: String, val Classify: String, val Empowered: Int)
  extends Cards
