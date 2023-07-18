package cl.uchile.dcc
package gwent.Effects.UnitCardEffect

import gwent.Effects.Effect
import gwent.Tablero.Board
import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

/** Effect representing a Morale Boost that increases the power of allied units from the same zone */

object RefuerzoMoral extends Effect {

  /** Applies the Morale Boost Effect to the target cards on the same zone.
   */
  override def apply(self: Cards, target: Board): Unit = {
    val zone = self match {
      case e: CloseCombatCard => target.getCloseCombatZone
      case e: RangedCombatCard => target.getRangedCombatZone
      case e: SiegeCombatCard => target.getSiegeCombatZone
    }
    zone.foreach { card =>
      if (card != self) {
        card.currentPower += 1
        // Hay que modificar el poder original, porque cuando por ejemplo un efecto unidad este en campo y usemos una
        // carta clima que modifique el poder a 1, y luego usemos clima despejado para remover ese efecto clima, se
        // debe llegar al valor al que estaba cuando tenia el efecto unidad.
        card.originalAfterEffect += 1
      }
    }
  }
}