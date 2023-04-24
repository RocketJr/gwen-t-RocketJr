package cl.uchile.dcc
package gwent

trait Player {
  /** The name of the Player. */
  val name: String
  /** The Position the player will be starting. */
  val pos: String
  /** The hit points of the Player. */
  var gems: Int
  /** The cards the player has on the deck. */
  var deck: Int
  /** The cards the player has on the hand. */
  var hand: Int

  def TakeCard(card: Int): Unit

  def PlayCard(card: Int): Unit
}
