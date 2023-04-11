package cl.uchile.dcc
package gwent

import munit.FunSuite

class testplayer extends munit.FunSuite{
  var playerOne: player = _
  var playerTwo: player = _

  override def beforeEach(context: BeforeEach): Unit = {
    playerOne = new player("Alejandro", "top", 3, 20, 4)
    playerTwo = new player("Dex", "bottom", 2, 20, 4)
  }

  test("A player needs a name") {
    assertEquals(playerOne.name, "Alejandro")
    assertEquals(playerTwo.name, "Dex")
  }

  test("A player needs to start in a position") {
    assertEquals(playerOne.pos, "top")
    assertEquals(playerTwo.pos, "bottom")
  }

  test("A player needs lives") {
    assertEquals(playerOne.gems, 3)
    assertEquals(playerTwo.gems, 2)
  }

  test("A player needs cards on the deck") {
    assertEquals(playerOne.deck, 20)
    assertEquals(playerTwo.deck, 20)
  }

  test("A player needs cards on the hand") {
    assertEquals(playerOne.hand, 4)
    assertEquals(playerTwo.hand, 4)
  }

  test("A deck and hand needs to be changed when a card is pulled from the deck") {
    assertEquals(playerOne.deck, 20)
    assertEquals(playerOne.hand, 4)
    playerOne.TakeCard(3)
    assertEquals(playerOne.deck, 17)
    assertEquals(playerOne.hand, 7)
  }

  test("A hand has to change when a card is played") {
    assertEquals(playerTwo.hand, 4)
    playerTwo.PlayCard(2)
    assertEquals(playerTwo.hand, 2)
  }
}
