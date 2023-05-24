package cl.uchile.dcc
package gwent.Tablero

import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

import gwent.User

/** An abstract class representing the zone where you can play and display cards.
 *
 *
 * @author Leonardo Rikhardsson
 *
 * @since 1.0.1
 * @version 1.2.3
 */

abstract class AbstractZone extends Zone {

  override def addCard(card: Cards): Unit

  override def getCards: List[Cards]
}
