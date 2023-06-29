package cl.uchile.dcc
package gwent.Effects.UnitCardEffect

import gwent.Effects.Effect
import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard}

abstract class AbstractUnitEffects(val EffectName: String) extends Effect {
  def CloseCombatEffect(list: List[CloseCombatCard]): Unit = {
    // Do nothing
  }

  def RangedUnitEffect(list: List[RangedCombatCard]): Unit = {
    // Do nothing
  }

  def SiegeUnitEffect(list: List[SiegeCombatCard]): Unit = {
    // Do nothing
  }
}