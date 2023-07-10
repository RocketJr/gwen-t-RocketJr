package cl.uchile.dcc
package gwent.Effects.UnitCardEffect

import gwent.Effects.Effect
import gwent.Tablero.Board
import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

object RefuerzoMoral extends Effect {
  override def apply(self: Cards, target: Board): Unit = {
    val zone = self match {
      case e: CloseCombatCard => target.getCloseCombatZone
      case e: RangedCombatCard => target.getRangedCombatZone
      case e: SiegeCombatCard => target.getSiegeCombatZone
    }
    zone.foreach { card =>
      if (card != self) {
        card.currentPower += 1
      }
    }
  }
}