package cl.uchile.dcc
package gwent.CardType

import munit.FunSuite

class SiegeCombatCardTest extends FunSuite {
  val name: String = "Troop"
  val class1: String = "cuerpo a cuerpo"
  var class2: String =  "a distancia"
  var class3: String = "de asedio"
  var Empowered1: Int = 10
  var Empowered2: Int = 2

  var troop1: SiegeCombatCard = _
  var troop2: SiegeCombatCard = _
  var troop3: SiegeCombatCard = _
  var troop4: SiegeCombatCard = _

  override  def beforeEach(context: BeforeEach): Unit = {
    troop1 = new SiegeCombatCard(name, class1, Empowered1)
    troop2 = new SiegeCombatCard(name, class2, Empowered1)
    troop3 = new SiegeCombatCard(name, class3, Empowered2)
    troop4 = new SiegeCombatCard(name, class1, Empowered1)
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

  test("A CardUnit can be created with all the necessary data") {
    assertEquals(troop1, troop4)
    assertNotEquals(troop1, troop2)
  }

  test("A CardUnit has to be different from Another") {
    assert(!troop1.equals("Another"))
  }

  test("The hash code of a CardUnit is consistent with equals") {
    assertEquals(new SiegeCombatCard(name, class1, Empowered1).##, troop1.##)
  }
}