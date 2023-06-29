package cl.uchile.dcc
package gwent.Effects

import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

trait Effect {
  val EffectName: String

  def apply(self: Cards, target: Cards): Unit
}
