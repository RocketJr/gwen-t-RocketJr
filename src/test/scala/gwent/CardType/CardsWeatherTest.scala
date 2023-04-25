package cl.uchile.dcc
package gwent.CardType

import munit.FunSuite

class CardsWeatherTest extends FunSuite {
  val name: String = "Climate"
  val type1: String = "Weak"
  var type2: String = "Strong"
  var Power: Int = 0

  var troop1: CardsWeather = _
  var troop2: CardsWeather= _

  override def beforeEach(context: BeforeEach): Unit = {
    troop1 = new CardsWeather(name, type1, Power)
    troop2 = new CardsWeather(name, type2, Power)
  }

  test("A Card needs a name") {
    assertEquals(troop1.CardName, name)
  }

  test("A card needs a classification") {
    assertEquals(troop1.Classify, type1)
    assertEquals(troop2.Classify, type2)
  }

  test("A card needs power") {
    assertEquals(troop1.Empowered, Power)
    assertEquals(troop2.Empowered, Power)
  }

  test("A CardUnit can be created with all the necessary data") {
    assertEquals(new CardsWeather(name, type1, Power), troop1)
    assertNotEquals(troop1, troop2)
  }

  test("A CardUnit has to be different from Another") {
    assert(!troop1.equals("Another"))
  }

  test("The hash code of a CardUnit is consistent with equals") {
    assertEquals(new CardsWeather(name, type1, Power).##, troop1.##)
  }
}
