package cl.uchile.dcc
package gwent.Effects.UnitCardEffect

import gwent.Effects.Effect
import gwent.Tablero.Board
import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

/** Effect representing a Close Bond that doubles the power of the card with the same name as itself */

object VinculoEstrecho extends Effect {

  /** Applies the Close Bond Effect to the target card on the same zone.
   */
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
        // Hay que modificar el poder original, porque cuando por ejemplo un efecto unidad este en campo y usemos una
        // carta clima que modifique el poder a 1, y luego usemos clima despejado para remover ese efecto clima, se
        // debe llegar al valor al que estaba cuando tenia el efecto unidad.
        card.originalAfterEffect *= 2
      }
    }
  }
}