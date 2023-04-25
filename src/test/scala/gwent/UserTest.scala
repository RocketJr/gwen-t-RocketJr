package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.CardType.{Cards, CardsUnit}
import munit.FunSuite

class UserTest extends FunSuite {
  val name: String = "Player 1"
  val pos1: String = "Bottom"
  val pos2: String = "Top"
  val gems: Int = 3
  var Card1 = new CardsUnit("Sad man", "Melee", 10)
  var Card2 = new CardsUnit("Happy man", "Ranged", 2)
  val deck: List[Cards] = List(Card1, Card2)
  val hand: List[Cards] = List()

  var user1: User = _
  var user2: User = _

  override  def beforeEach(context: BeforeEach): Unit = {
    user1 = new User(name, pos1, gems, deck, hand)
    user2 = new User(name, pos2, gems, deck, hand)
  }

  test("A player needs a name") {
    assertEquals(user1.name, name)
    assertEquals(user2.name, name)
  }

  test("A player needs to start in a position") {
    assertEquals(user1.pos, pos1)
    assertEquals(user2.pos, pos2)
  }

  test("A player needs lives") {
    assertEquals(user1.gems, gems)
    assertEquals(user2.gems, gems)
  }

  test("A player needs cards on the deck") {
    assertEquals(user1.deck, deck)
    assertEquals(user2.deck, deck)
  }

  test("A player needs cards on the hand") {
    assertEquals(user1.hand, hand)
    assertEquals(user2.hand, hand)
  }

  test("A deck and hand needs to be changed when a card is pulled from the deck") {
    assertEquals(user1.deck, deck)
    assertEquals(user1.hand, hand)
    user1.TakeCard()
    assertEquals(user1.deck, List(Card2))
    assertEquals(user1.hand, List(Card1))
  }

  test("A computer and a card can be created with all the necessary data") {
    assertEquals(new User(name, pos2, gems, deck, hand), user2)
    assertNotEquals(user1, user2)
    assertEquals(new CardsUnit("Sad man", "Melee", 10), Card1)
  }

  test("A User and a card has to be different from Another") {
    assert(!user1.equals("Another"))
    assert(!Card1.equals("Another"))
  }

  test("The hash code of a User is consistent with equals") {
    assertEquals(new User(name, pos1, gems, deck, hand).##, user1.##)
  }
}
