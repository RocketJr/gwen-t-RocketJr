package cl.uchile.dcc
package gwent.Effects.UnitCardEffect

import gwent.Effects.Effect
import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard}

abstract class AbstractUnitEffects(val CardName: String) extends Effect {
  def getName: String = CardName

  def CloseCombatEffect(list: List[CloseCombatCard]): Unit = println("Do Nothing")

  def RangedUnitEffect(list: List[RangedCombatCard]): Unit = println("Do Nothing")

  def SiegeUnitEffect(list: List[SiegeCombatCard]): Unit = println("Do Nothing")
}
