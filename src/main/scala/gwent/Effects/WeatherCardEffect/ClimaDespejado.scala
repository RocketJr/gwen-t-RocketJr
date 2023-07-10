package cl.uchile.dcc
package gwent.Effects.WeatherCardEffect

import gwent.Effects.Effect
import gwent.Tablero.Board
import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

object ClimaDespejado extends Effect {
  override def apply(self: Cards, target: Board): Unit = {
    val closeCombatZone = target.getCloseCombatZone
    closeCombatZone.foreach(card => card.currentPower = card.originalPower)
    val rangedCombatZone = target.getRangedCombatZone
    rangedCombatZone.foreach(card => card.currentPower = card.originalPower)
    val siegeCombatZone = target.getSiegeCombatZone
    siegeCombatZone.foreach(card => card.currentPower = card.originalPower)
  }
}