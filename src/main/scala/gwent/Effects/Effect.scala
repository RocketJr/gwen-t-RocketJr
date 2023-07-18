package cl.uchile.dcc
package gwent.Effects

import gwent.Tablero.Board
import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

/** Trait representing an effect in the Gwen't game.
 * @author Leonardo Rikhardsson
 * @since 1.0.1
 * @version 3.1.0
 */

trait Effect {
  def apply(self: Cards, target: Board): Unit
}
