package cl.uchile.dcc
package gwent.CardType

import munit.FunSuite

import gwent.Effects.Effect
import gwent.Effects.UnitCardEffect.{NullUnitEffect, RefuerzoMoral, VinculoEstrecho}

class RangedCombatCardTest extends FunSuite {
  val name: String = "Troop"
  val class1: String = "cuerpo a cuerpo"
  var class2: String =  "a distancia"
  var class3: String = "de asedio"
  var Empowered1: Int = 10
  var Empowered2: Int = 2
  val Effect: Effect = NullUnitEffect

  var troop1: RangedCombatCard = _
  var troop2: RangedCombatCard = _
  var troop3: RangedCombatCard = _
  var troop4: RangedCombatCard = _

  override  def beforeEach(context: BeforeEach): Unit = {
    troop1 = new RangedCombatCard(name, class1, Empowered1, Effect)
    troop2 = new RangedCombatCard(name, class2, Empowered1, Effect)
    troop3 = new RangedCombatCard(name, class3, Empowered2, Effect)
    troop4 = new RangedCombatCard(name, class1, Empowered1, Effect)
  }

  test("A Card needs a name") {
    assertEquals(troop1.CardName, name)
  }

  test("A card needs a classification") {
    assertEquals(troop1.Classify, class1)
    assertEquals(troop2.Classify, class2)
  }

  test("A card needs power") {
    assertEquals(troop1.Power, Empowered1)
    assertEquals(troop3.Power, Empowered2)
  }

  test("A card needs an Effect") {
    assertEquals(troop1.Efecto, Effect)
    assertEquals(troop3.Efecto, Effect)
  }

  test("A CardUnit can be created with all the necessary data") {
    assertEquals(troop1, troop4)
    assertNotEquals(troop1, troop2)
  }

  test("A CardUnit has to be different from Another") {
    assert(!troop1.equals("Another"))
  }

  test("The hash code of a CardUnit is consistent with equals") {
    assertEquals(new RangedCombatCard(name, class1, Empowered1, Effect).##, troop1.##)
  }
}