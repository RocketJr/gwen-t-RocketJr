package cl.uchile.dcc
package gwent.Effects.UnitCardEffect

import gwent.CardType.Cards

class NullUnitEffect extends AbstractUnitEffects("Null") {
  override def apply(self: Cards, target: Cards): Unit = {
    // Do nothing
  }
}