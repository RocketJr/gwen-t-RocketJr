package cl.uchile.dcc
package gwent.CardType

import munit.FunSuite

import gwent.Effects.Effect
import gwent.Effects.WeatherCardEffect.{ClimaDespejado, EscarchaMordiente, LluviaTorrencial,
  NieblaImpenetrable, NullWeatherEffect}

class WeatherCardTest extends FunSuite {
  val name: String = "Climate"
  val type1: String = "Weak"
  var type2: String = "Strong"
  val Effect: Effect = NullWeatherEffect

  var troop1: WeatherCard = _
  var troop2: WeatherCard= _

  override def beforeEach(context: BeforeEach): Unit = {
    troop1 = new WeatherCard(name, type1, Effect)
    troop2 = new WeatherCard(name, type2, Effect)
  }

  test("A Card needs a name") {
    assertEquals(troop1.CardName, name)
  }

  test("A card needs a classification") {
    assertEquals(troop1.Classify, type1)
    assertEquals(troop2.Classify, type2)
  }

  test("A card needs an Effect") {
    assertEquals(troop1.Efecto, Effect)
    assertEquals(troop2.Efecto, Effect)
  }

  test("A CardUnit can be created with all the necessary data") {
    assertEquals(new WeatherCard(name, type1, Effect), troop1)
    assertNotEquals(troop1, troop2)
  }

  test("A CardUnit has to be different from Another") {
    assert(!troop1.equals("Another"))
  }

  test("The hash code of a CardUnit is consistent with equals") {
    assertEquals(new WeatherCard(name, type1, Effect).##, troop1.##)
  }
}
