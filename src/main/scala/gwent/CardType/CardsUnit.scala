package cl.uchile.dcc
package gwent.CardType

import java.util.Objects

/**
 * @param CardName The name of the Card.
 * @param Classify The classification of the card.
 *
 * @constructor Creates a new card with a given name and classification.
 *
 * @author Leonardo Rikhardsson
 * @since 1.0.0
 * @version 1.0.0
 */

class CardsUnit(CardName: String, Classify: String, Empowered: Int)
  extends AbstractCards(CardName, Classify, Empowered) with Equals {

  override def canEqual(that: Any): Boolean =
    that.isInstanceOf[CardsUnit]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CardsUnit]
      CardName == other.CardName && Classify == other.Classify
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[CardsUnit], CardName, Classify, Empowered)
  }

}
