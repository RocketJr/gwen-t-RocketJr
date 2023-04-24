package cl.uchile.dcc
package gwent

import munit.FunSuite

class ComputerTest extends FunSuite {
  val name: String = "Player 2"
  val pos1: String = "Bottom"
  val pos2: String = "Top"
  val gems: Int = 3
  val deck: Int = 40
  val hand: Int = 10

  var PC: User = _


  override  def beforeEach(context: BeforeEach): Unit = {
    PC = new User(name, pos1, gems, deck, hand)
  }

  test("A player needs a name") {
    assertEquals(PC.name, name)
  }

  test("A player needs to start in a position") {
    assertEquals(PC.pos, pos1)
  }

  test("A player needs lives") {
    assertEquals(PC.gems, gems)
  }

  test("A player needs cards on the deck") {
    assertEquals(PC.deck, deck)
  }

  test("A player needs cards on the hand") {
    assertEquals(PC.hand, hand)
  }

  test("A deck and hand needs to be changed when a card is pulled from the deck") {
    assertEquals(PC.deck, deck)
    assertEquals(PC.hand, hand)
    PC.TakeCard(3)
    assertEquals(PC.deck, 17)
    assertEquals(PC.hand, 7)
  }
}
