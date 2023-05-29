package cl.uchile.dcc
package gwent

import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

import munit.FunSuite

class UserTest extends FunSuite {
  val name: String = "Player 1"
  val gems: Int = 3
  var Card1 = new CloseCombatCard("Card 1", "Close Combat", 10)
  var Card2 = new RangedCombatCard("Card 2", "Ranged Combat", 8)
  var Card3 = new SiegeCombatCard("Card 3", "Siege Combat", 12)
  var Card4 = new WeatherCard("Card 4", "Weather")
  var Card5 = new CloseCombatCard("Card 5", "Close Combat", 123)
  var Card6 = new WeatherCard("Card 6", "Weather")
  val deck1: List[Cards] = List(Card1, Card5)
  val deck2: List[Cards] = List(Card3, Card5, Card1, Card2)
  val hand: List[Cards] = List(Card4, Card3, Card2, Card6)
  val deck3: List[Cards] = List.empty

  var board = new Board()

  var user1: User = _
  var user2: User = _

  override  def beforeEach(context: BeforeEach): Unit = {
    user1 = new User(name, gems, deck1, hand, board)
    user2 = new User(name, gems, deck2, hand, board)
  }

  test("A player needs a name") {
    assertEquals(user1.name, name)
    assertEquals(user2.name, name)
  }

  test("A player needs lives") {
    assertEquals(user1.gemCounter, gems)
    assertEquals(user2.gemCounter, gems)
  }

  test("A player needs cards on the deck") {
    assertEquals(user1.deck, deck1)
    assertEquals(user2.deck, deck2)
  }

  test("A player needs cards on the hand") {
    assertEquals(user1.hand, hand)
    assertEquals(user2.hand, hand)
  }

  test("A deck should have the same cards after shuffling, not necessarily on the same order") {
    assertEquals(user2.deck, deck2)
    val expected: List[Cards] = List(Card5, Card2, Card3, Card1)
    scala.util.Random.setSeed(57L)
    user2.ShuffleDeck()
    assertEquals(user2.deck, expected)
  }

  test("A deck and hand needs to be changed when a card is pulled from the deck, and " +
    "be able to play a card which should be seen") {
    assertEquals(user1.deck, deck1)
    assertEquals(user1.hand, hand)
    user1.DrawCard()
    assertEquals(user1.deck, List(Card5))
    assertEquals(user1.hand, List(Card1, Card4, Card3, Card2, Card6))
    user1.DrawCard()
    assertEquals(user1.deck, List())
    assertEquals(user1.hand, List(Card5, Card1, Card4, Card3, Card2, Card6))

    user1.playCard(Card1)
    assertEquals(user1.hand, List(Card5, Card4, Card3, Card2, Card6))
    assertEquals(board.getCloseCombatZone, List(Card1))

    user1.playCard(Card3)
    assertEquals(user1.hand, List(Card5, Card4, Card2, Card6))
    assertEquals(board.getCloseCombatZone, List(Card1))
    assertEquals(board.getSiegeCombatZone, List(Card3))

    user1.playCard(Card2)
    user1.playCard(Card5)
    user1.playCard(Card4)
    assertEquals(user1.hand, List(Card6))
    assertEquals(board.getRangedCombatZone, List(Card2))
    assertEquals(board.getCloseCombatZone, List(Card5, Card1))
    assertEquals(board.getWeatherZone, Option(Card4))

    user1.playCard(Card5)
    assertEquals(user1.hand, List(Card6))
    assertEquals(board.getCloseCombatZone, List(Card5, Card1))

    user1.playCard(Card6)
    assertEquals(user1.hand, List())
    assertEquals(board.getWeatherZone, Option(Card6))
  }

  test("A computer and a card can be created with all the necessary data") {
    assertEquals(new User(name, gems, deck2, hand, board), user2)
    assertNotEquals(user1, user2)
    assertEquals(new CloseCombatCard("Card 1", "Close Combat", 10), Card1)
  }

  test("A User and a card has to be different from Another") {
    assert(!user1.equals(Card1))
    assert(!Card1.equals(user1))
  }

  test("The hash code of a User is consistent with equals") {
    assertEquals(new User(name, gems, deck1, hand, board).##, user1.##)
  }

}
