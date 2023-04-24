package cl.uchile.dcc
package gwent

import munit.FunSuite

class UserTest extends FunSuite {
  val name: String = "Player 1"
  val pos1: String = "Bottom"
  val pos2: String = "Top"
  val gems: Int = 3
  val deck: Int = 40
  val hand: Int = 10

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
    user1.TakeCard(3)
    assertEquals(user1.deck, 37)
    assertEquals(user1.hand, 13)
  }

  test("A deck and hand needs to be changed when a card is pulled played from the hand") {
    assertEquals(user1.hand, hand)
    user1.PlayCard(3)
    assertEquals(user1.hand, 7)
  }

  test("The hash code of a User is consistent with equals") {
    assertEquals(new User(name, pos1, gems, deck, hand).##, user1.##)
  }
}
