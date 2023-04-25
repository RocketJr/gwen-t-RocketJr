package cl.uchile.dcc
package gwent.CardType

import java.util.Objects

/**
 * @param CardName The name of the Card.
 * @param Classify The classification of the card.
 * @param Empowered The power of the Card.                  
 *
 * @constructor Creates a new card with a given name and type.
 *
 * @author Leonardo Rikhardsson
 * @since 1.0.0
 * @version 1.0.0
 */

class CardsWeather(CardName: String, Classify: String, Empowered: Int)
  extends AbstractCards(CardName, Classify, 0) with Equals {

  override def canEqual(that: Any): Boolean =
    that.isInstanceOf[CardsWeather]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CardsWeather]
      CardName == other.CardName && Classify == other.Classify
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[CardsWeather], CardName, Classify, Empowered)
  }

}
