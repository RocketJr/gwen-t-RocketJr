package cl.uchile.dcc
package gwent.Effects.WeatherCardEffect

import gwent.Effects.Effect
import gwent.Tablero.Board
import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

object NieblaImpenetrable extends Effect {
  override def apply(self: Cards, target: Board): Unit = {
    val rangedCombatZone = target.getRangedCombatZone
    rangedCombatZone.foreach(card => card.currentPower = 1)
  }
}