package cl.uchile.dcc
package gwent.Tablero

import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

import gwent.User

abstract class AbstractZone extends Zone {

  override def addCard(card: Cards): Unit

  override def getCards: List[Cards]
}
