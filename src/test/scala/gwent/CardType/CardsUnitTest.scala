package cl.uchile.dcc
package gwent.CardType

import munit.FunSuite

class CardsUnitTest extends FunSuite {
  val name: String = "Troop"
  val class1: String = "cuerpo a cuerpo"
  var class2: String =  "a distancia"
  var class3: String = "de asedio"
  var Empowered1: Int = 10
  var Empowered2: Int = 2

  var troop1: CardsUnit = _
  var troop2: CardsUnit = _
  var troop3: CardsUnit = _
  var troop4: CardsUnit = _

  override  def beforeEach(context: BeforeEach): Unit = {
    troop1 = new CardsUnit(name, class1, Empowered1)
    troop2 = new CardsUnit(name, class2, Empowered1)
    troop3 = new CardsUnit(name, class3, Empowered2)
    troop4 = new CardsUnit(name, class1, Empowered2)
  }

  test("A Card needs a name") {
    assertEquals(troop1.CardName, name)
  }

  test("A card needs a classification") {
    assertEquals(troop1.Classify, class1)
    assertEquals(troop2.Classify, class2)
  }

  test("A card needs power") {
    assertEquals(troop1.Empowered, Empowered1)
    assertEquals(troop3.Empowered, Empowered2)
  }

  test("A CardUnit can be created with all the necessary data") {
    assertEquals(troop1, troop4)
    assertNotEquals(troop1, troop2)
  }

  test("A CardUnit has to be different from Another") {
    assert(!troop1.equals("Another"))
  }

  test("The hash code of a CardUnit is consistent with equals") {
    assertEquals(new CardsUnit(name, class1, Empowered1).##, troop1.##)
  }
}
