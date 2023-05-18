package cl.uchile.dcc
package gwent.CardType

import munit.FunSuite

class WeatherCardTest extends FunSuite {
  val name: String = "Climate"
  val type1: String = "Weak"
  var type2: String = "Strong"

  var troop1: WeatherCard = _
  var troop2: WeatherCard= _

  override def beforeEach(context: BeforeEach): Unit = {
    troop1 = new WeatherCard(name, type1)
    troop2 = new WeatherCard(name, type2)
  }

  test("A Card needs a name") {
    assertEquals(troop1.CardName, name)
  }

  test("A card needs a classification") {
    assertEquals(troop1.Classify, type1)
    assertEquals(troop2.Classify, type2)
  }

  test("A CardUnit can be created with all the necessary data") {
    assertEquals(new WeatherCard(name, type1), troop1)
    assertNotEquals(troop1, troop2)
  }

  test("A CardUnit has to be different from Another") {
    assert(!troop1.equals("Another"))
  }

  test("The hash code of a CardUnit is consistent with equals") {
    assertEquals(new WeatherCard(name, type1).##, troop1.##)
  }
}
