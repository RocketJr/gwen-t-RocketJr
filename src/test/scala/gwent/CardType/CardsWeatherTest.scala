package cl.uchile.dcc
package gwent.CardType

import munit.FunSuite

class CardsWeatherTest extends FunSuite {
  val name: String = "Climate"
  val type1: String = "Weak"
  var type2: String = "Strong"

  var troop1: CardsWeather = _
  var troop2: CardsWeather= _

  override def beforeEach(context: BeforeEach): Unit = {
    troop1 = new CardsWeather(name, type1)
    troop2 = new CardsWeather(name, type2)
  }

  test("A Card needs a name") {
    assertEquals(troop1.CardName, name)
  }

  test("A card needs a classification") {
    assertEquals(troop1.Classify, type1)
    assertEquals(troop2.Classify, type2)
  }
}
