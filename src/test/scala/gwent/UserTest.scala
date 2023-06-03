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
  val Card4 = new WeatherCard("Card 4", "Weather")
  var Card5 = new CloseCombatCard("Card 5", "Close Combat", 123)
  val Card6 = new WeatherCard("Card 6", "Weather")

  val deck: List[Cards] = List.empty
  val hand: List[Cards] = List.empty
  //val deck1: List[Cards] = List(Card1, Card5)
  //val deck2: List[Cards] = List(Card5, Card3, Card1, Card2)
  //val hand: List[Cards] = List(Card4, Card3, Card2, Card6)

  //val zone1: WeatherZone = WeatherZone.getInstance()
  //val zone2: WeatherZone = WeatherZone.getInstance()

  var board1 = new Board()
  var board2 = new Board()

  var user1: User = _
  var user2: User = _

  override  def beforeEach(context: BeforeEach): Unit = {
    user1 = new User(name, gems, deck, hand, board1)
    user2 = new User(name, gems, deck, hand, board2)
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
    user1.deckSet(List(Card1, Card5))
    user2.deckSet(List(Card5, Card3, Card1, Card2))
    assertEquals(user1.deck, List(Card1, Card5))
    assertEquals(user2.deck, List(Card5, Card3, Card1, Card2))
  }

  test("A player needs cards on the hand") {
    user1.handSet(List(Card4, Card3, Card2, Card6))
    user2.handSet(List(Card4, Card3, Card2, Card6))
    assertEquals(user1.hand, List(Card4, Card3, Card2, Card6))
    assertEquals(user2.hand, List(Card4, Card3, Card2, Card6))
  }

  test("A deck should have the same cards after shuffling, not necessarily on the same order") {
    user2.deckSet(List(Card5, Card3, Card1, Card2))
    assertEquals(user2.deck, List(Card5, Card3, Card1, Card2))
    val expected: List[Cards] = List(Card3, Card2, Card5, Card1)
    scala.util.Random.setSeed(57L)
    user2.ShuffleDeck()
    assertEquals(user2.deck, expected)
  }

  test("A deck and hand needs to be changed when a card is pulled from the deck, and " +
    "be able to play a card which should be seen") {
    assertEquals(user1.deck, deck)
    assertEquals(user1.hand, hand)

    user1.deckSet(List(Card1, Card5))
    user1.handSet(List(Card4, Card3, Card2, Card6))

    user2.deckSet(List(Card5, Card3, Card1, Card2))
    user2.handSet(List(Card4, Card3, Card2, Card6))

    user1.DrawCard()
    assertEquals(user1.deck, List(Card5))
    assertEquals(user1.hand, List(Card1, Card4, Card3, Card2, Card6))
    user1.DrawCard()
    assertEquals(user1.deck, List())
    assertEquals(user1.hand, List(Card5, Card1, Card4, Card3, Card2, Card6))

    user1.playCard(Card1)
    assertEquals(user1.hand, List(Card5, Card4, Card3, Card2, Card6))
    assertEquals(board1.getCloseCombatZone, List(Card1))

    user1.playCard(Card3)
    assertEquals(user1.hand, List(Card5, Card4, Card2, Card6))
    assertEquals(board1.getCloseCombatZone, List(Card1))
    assertEquals(board1.getSiegeCombatZone, List(Card3))

    user1.playCard(Card2)
    user1.playCard(Card5)
    user1.playCard(Card4)
    assertEquals(user1.hand, List(Card6))
    assertEquals(board1.getRangedCombatZone, List(Card2))
    assertEquals(board1.getCloseCombatZone, List(Card5, Card1))
    assertEquals(board1.getWeatherZone, Option(Card4))

    user1.playCard(Card5)
    assertEquals(user1.hand, List(Card6))
    assertEquals(board1.getCloseCombatZone, List(Card5, Card1))

    user1.playCard(Card6)
    assertEquals(user1.hand, List())
    assertEquals(board1.getWeatherZone, Option(Card6))

    user2.DrawCard()
    assertEquals(user2.deck, List(Card3, Card1, Card2))
    assertEquals(user2.hand, List(Card5, Card4, Card3, Card2, Card6))

    user2.playCard(Card4)
    // Son iguales como la zona es la misma
    assertEquals(board2.getWeatherZone, Option(Card4))
    assertEquals(board1.getWeatherZone, Option(Card4))
    assertEquals(user2.hand, List(Card5, Card3, Card2, Card6))

    user2.playCard(Card5)
    assertEquals(board2.getCloseCombatZone, List(Card5))
    assertEquals(user2.hand, List(Card3, Card2, Card6))
  }

  test("Two Boards Should be different from each other when created but the same for the same player") {
    // The boards should be different from each other but the same if it is the same value board
    assertNotEquals(user1.getBoard, board2)
    assertEquals(user2.getBoard, board2)
  }

  test("When using a setter, the cards should change and be the same for both Weather boards") {
    val TestCardW = new WeatherCard("T1", "Weather")
    val newWeatherCard = Some(TestCardW)

    assertEquals(board1.getWeatherZone, Option(Card4))
    board1.setWeatherZone(newWeatherCard)

    assertEquals(board1.getWeatherZone, Option(TestCardW))
    assertEquals(board2.getWeatherZone, Option(TestCardW))

    assertEquals(board1.getWeatherZone, board2.getWeatherZone)
  }
  test("When using a setter for the unit cards, the cards should change and be different for both zones") {
    val TestCardC1 = new CloseCombatCard("T1C", "Close Combat", 10)
    val TestCardC2 = new CloseCombatCard("T2C", "Close Combat", 32)
    val TestCardR = new RangedCombatCard("T3", "Ranged Combat", 8)
    val TestCardS = new SiegeCombatCard("T4", "Siege Combat", 6)
    val newCloseCombatZone = List(TestCardC1, TestCardC2)
    val newRangedCombatZone = List(TestCardR)
    val newSiegeCombatZone = List(TestCardS)

    assertEquals(board1.getCloseCombatZone, List(Card5, Card1))
    board1.setCloseCombatZone(newCloseCombatZone)
    assertEquals(board1.getCloseCombatZone, List(TestCardC1, TestCardC2))

    assertEquals(board2.getRangedCombatZone, List())
    board2.setRangedCombatZone(newRangedCombatZone)
    assertEquals(board2.getRangedCombatZone, List(TestCardR))

    assertEquals(board2.getSiegeCombatZone, List())
    board2.setSiegeCombatZone(newSiegeCombatZone)
    assertEquals(board2.getSiegeCombatZone, List(TestCardS))

    assertNotEquals(board1.getCloseCombatZone, board2.getCloseCombatZone)
    assertNotEquals(board1.getRangedCombatZone, board2.getRangedCombatZone)
    assertNotEquals(board1.getSiegeCombatZone, board2.getSiegeCombatZone)
  }

  test("A computer and a card can be created with all the necessary data") {
    assertEquals(new User(name, gems, deck, hand, board2), user2)
    assertEquals(new CloseCombatCard("Card 1", "Close Combat", 10), Card1)
  }

  test("A User and a card has to be different from Another") {
    assert(!user1.equals(Card1))
    assert(!Card1.equals(user1))
  }

  test("The hash code of a User is consistent with equals") {
    assertEquals(new User(name, gems, deck, hand, board1).##, user1.##)
  }

}