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

}
