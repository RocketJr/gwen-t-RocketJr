package cl.uchile.dcc
package gwent.CardType

trait Cards {
  /** The name of the Card. */
  val CardName: String
  /** The Type of the Card. */
  val Classify: String
  /** The Power of the Card. */
  val Empowered: Int
}
