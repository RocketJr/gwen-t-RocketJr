package cl.uchile.dcc
package gwent.Tablero

import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

import gwent.User

trait Zone {

  def addCard(card: Cards): Unit

  def getCards: List[Cards]
}
