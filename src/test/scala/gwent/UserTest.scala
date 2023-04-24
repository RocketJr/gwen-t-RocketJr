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

}
