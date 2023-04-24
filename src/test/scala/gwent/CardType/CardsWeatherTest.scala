package cl.uchile.dcc
package gwent.CardType

import munit.FunSuite

class CardsWeatherTest extends FunSuite {
  val name: String = "Climate"
  val type1: String = "Weak"
  var type2: String = "Strong"

  var troop1: CardsUnit = _
  var troop2: CardsUnit = _

  override def beforeEach(context: BeforeEach): Unit = {
    troop1 = new CardsUnit(name, type1)
    troop2 = new CardsUnit(name, type2)
  }

  test("A Card needs a name") {
    assertEquals(troop1.CardName, name)
  }

  test("A card needs a classification") {
    assertEquals(troop1.Classify, type1)
    assertEquals(troop2.Classify, type2)
  }
}
