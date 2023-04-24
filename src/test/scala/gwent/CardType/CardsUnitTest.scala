package cl.uchile.dcc
package gwent.CardType

import munit.FunSuite

class CardsUnitTest extends FunSuite {
  val name: String = "Troop"
  val class1: String = "cuerpo a cuerpo"
  var class2: String =  "a distancia"
  var class3: String = "de asedio"

  var troop1: CardsUnit = _
  var troop2: CardsUnit = _
  var troop3: CardsUnit = _

  override  def beforeEach(context: BeforeEach): Unit = {
    troop1 = new CardsUnit(name, class1)
    troop2 = new CardsUnit(name, class2)
    troop3 = new CardsUnit(name, class3)
  }

  test("A Card needs a name") {
    assertEquals(troop1.CardName, name)
  }

  test("A card needs a classification") {
    assertEquals(troop1.Classify, class1)
    assertEquals(troop2.Classify, class2)
  }
}
