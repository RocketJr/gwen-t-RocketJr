package cl.uchile.dcc
package gwent.Tablero

import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

import gwent.User

/** A trait representing the board zone.
 *
 * @author Leonardo Rikhardsson
 *
 * @since 1.2.3
 * @version 1.2.3
 */

trait Zone {

  def addCard(card: Cards): Unit

  def getCards: List[Cards]
}
