package cl.uchile.dcc
package gwent.Effects.WeatherCardEffect

import gwent.Effects.Effect
import gwent.Tablero.Board
import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

object NullWeatherEffect extends Effect {
  override def apply(self: Cards, target: Board): Unit = {
    // Do nothing
  }

}