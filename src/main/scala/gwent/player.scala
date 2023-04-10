package cl.uchile.dcc
package gwent

class player(val name: String, val pos: String, var gems: Int, var deck: Int, var hand: Int) {
  def TakeCard(card: Int): Unit = {
    deck -= card
    hand += card
  }

  def PlayCard(card: Int): Unit = {
    hand -= card
  }
}
