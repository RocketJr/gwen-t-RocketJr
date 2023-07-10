package cl.uchile.dcc
package gwent.Effects.UnitCardEffect

import gwent.Effects.Effect
import gwent.Tablero.Board
import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

object NullUnitEffect extends Effect {
  override def apply(self: Cards, target: Board): Unit = {
    // Do nothing
  }
}