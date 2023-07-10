package cl.uchile.dcc
package gwent.Effects.UnitCardEffect

import gwent.Effects.Effect
import gwent.Tablero.Board
import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

object VinculoEstrecho extends Effect {
  override def apply(self: Cards, target: Board): Unit = {
    val Fila = self match {
      case _: CloseCombatCard => target.getCloseCombatZone
      case _: RangedCombatCard => target.getRangedCombatZone
      case _: SiegeCombatCard => target.getSiegeCombatZone
    }
    val selfName = self.CardName
    Fila.foreach { card =>
      if (card.CardName == selfName) {
        card.currentPower *= 2
      }
    }
  }
}