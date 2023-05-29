package cl.uchile.dcc
package gwent

import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

import gwent.User

class Board {
  private var closeCombatZone: List[CloseCombatCard] = List.empty
  private var rangedCombatZone: List[RangedCombatCard] = List.empty
  private var siegeCombatZone: List[SiegeCombatCard] = List.empty
  private var weatherZone: Option[WeatherCard] = None

  def playCard(card: Cards): Unit = {
    card.playOnBoard(this)
  }

  def playCloseCombatCard(card: CloseCombatCard): Unit = {
    closeCombatZone = card :: closeCombatZone
  }

  def playRangedCombatCard(card: RangedCombatCard): Unit = {
    rangedCombatZone = card :: rangedCombatZone
  }

  def playSiegeCombatCard(card: SiegeCombatCard): Unit = {
    siegeCombatZone = card :: siegeCombatZone
  }

  def playWeatherCard(card: WeatherCard): Unit = {
    weatherZone = Some(card)
  }

  def getCloseCombatZone: List[CloseCombatCard] = closeCombatZone

  def getRangedCombatZone: List[RangedCombatCard] = rangedCombatZone

  def getSiegeCombatZone: List[SiegeCombatCard] = siegeCombatZone

  def getWeatherZone: Option[WeatherCard] = weatherZone
}