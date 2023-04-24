package cl.uchile.dcc
package gwent

import java.util.Objects


class User(name: String,pos: String,gems: Int,deck: Int,hand: Int) extends
  AbstractPlayer(name, pos, gems, deck, hand){

  override def TakeCard(card: Int): Unit = {
    deck -= card
    hand += card
  }

  override def PlayCard(card: Int): Unit = {
    hand -= card
  }

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[User]
  }

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[User]
      name == other.name && gems == other.gems
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[User], name, pos, gems, deck, hand)
  }
}
