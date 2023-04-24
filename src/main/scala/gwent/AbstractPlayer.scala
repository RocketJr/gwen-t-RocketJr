package cl.uchile.dcc
package gwent

abstract class AbstractPlayer(val name: String, val pos: String, var gems: Int, var deck: Int, var hand: Int) extends Player with Equals {

  override def TakeCard(card: Int): Unit = {
    deck -= card
    hand += card
  }

  override def PlayCard(card: Int): Unit = {
    hand -= card
  }


}
