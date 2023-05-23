package cl.uchile.dcc
package gwent.Tablero

import gwent.CardType.{CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

import gwent.User
import gwent.CardType.Cards

trait Zone {
  def addCard(card: Cards): Unit

  def getCards: List[Cards]
}
