package cl.uchile.dcc
package gwent.Effects

import gwent.Tablero.Board
import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

trait Effect {
  def apply(self: Cards, target: Board): Unit
}
