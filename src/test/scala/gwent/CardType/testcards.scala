package cl.uchile.dcc
package gwent.CardType

import gwent.cards

import munit.FunSuite

class testcards extends munit.FunSuite{
  var Unit: cards = _
  var Weather: cards = _

  override def beforeEach(context: BeforeEach): Unit = {
    Unit = new cards("Mario the Jhin", "range")
    Weather = new cards("The Doom")
  }

  test("A Card needs a name") {
    assertEquals(Unit.CardName, "Mario the Jhin")
    assertEquals(Weather.CardName, "The Doom")
  }

  test("A card needs a classification") {
    assertEquals(Unit.Classify, "range")
    assertEquals(Weather.Classify, null)
  }
}
