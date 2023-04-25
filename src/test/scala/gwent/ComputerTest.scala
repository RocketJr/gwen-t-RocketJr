package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.CardType.{Cards, CardsUnit}
import munit.FunSuite

class ComputerTest extends FunSuite {
  val name: String = "Player 2"
  val name2: String = "Player 3"
  val pos1: String = "Bottom"
  val pos2: String = "Top"
  val gems: Int = 3
  var Card1 = new CardsUnit("Sad man", "Melee", 10)
  var Card2 = new CardsUnit("Happy man", "Ranged", 2)
  val deck: List[Cards] = List(Card1,Card2)
  val hand: List[Cards] = List()

  var PC: Computer = _


  override  def beforeEach(context: BeforeEach): Unit = {
    PC = new Computer(name, pos1, gems, deck, hand)
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
    PC.TakeCard()
    assertEquals(PC.deck, List(Card2))
    assertEquals(PC.hand, List(Card1))
  }

  test("A computer and a card can be created with all the necessary data") {
    assertEquals(new Computer(name, pos1, gems, deck, hand), PC)
    assertNotEquals(new Computer(name, pos2, gems, deck, hand), PC)
    assertEquals(new CardsUnit("Sad man", "Melee", 10), Card1)
  }

  test("A computer and a card has to be different from Another") {
    assert(!PC.equals("Another"))
    assert(!Card1.equals("Another"))
  }

  test("The hash code of a computer is consistent with equals") {
    assertEquals(new Computer(name, pos1, gems, deck, hand).##, PC.##)
  }
}
