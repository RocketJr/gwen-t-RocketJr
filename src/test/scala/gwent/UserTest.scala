package cl.uchile.dcc
package gwent

import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}
import gwent.Tablero.{Zone, CCBoard, RCBoard, SCBoard, WBoard}
import munit.FunSuite

class UserTest extends FunSuite {
  val name: String = "Player 1"
  val gems: Int = 3
  //var Card1 = new CloseCombatCard("Sad man", "Melee", 10)
  //var Card2 = new CloseCombatCard("Happy man", "Ranged", 2)
  var Card1 = new CloseCombatCard("Card 1", "Close Combat", 10)
  var Card2 = new RangedCombatCard("Card 2", "Ranged Combat", 8)
  var Card3 = new SiegeCombatCard("Card 3", "Siege Combat", 12)
  var Card4 = new WeatherCard("Card 4", "Weather")
  val deck1: List[Cards] = List(Card1, Card2)
  val deck2: List[Cards] = List(Card3)
  val hand: List[Cards] = List(Card4)
  val deck3: List[Cards] = List.empty

  var closeCombatZone = new CCBoard()
  var rangedCombatZone = new RCBoard()
  var siegeCombatZone = new SCBoard()
  var weatherZone = new WBoard()

  var user1: User = _
  var user2: User = _

  override  def beforeEach(context: BeforeEach): Unit = {
    user1 = new User(name, gems, deck1, hand)
    user2 = new User(name, gems, deck2, hand)
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

  test("A deck and hand needs to be changed when a card is pulled from the deck, and " +
    "be able to play a card which should be seen") {
    assertEquals(user1.deck, deck1)
    assertEquals(user1.hand, hand)
    user1.DrawCard()
    assertEquals(user1.deck, List(Card2))
    assertEquals(user1.hand, List(Card1, Card4))
    user1.DrawCard()
    assertEquals(user1.deck, List())
    assertEquals(user1.hand, List(Card2, Card1, Card4))

    Card1.play(user1, closeCombatZone)
    assertEquals(user1.hand, List(Card2, Card4))
    assertEquals(closeCombatZone.getCards, List(Card1))
  }

  test("A computer and a card can be created with all the necessary data") {
    assertEquals(new User(name, gems, deck2, hand), user2)
    assertNotEquals(user1, user2)
    assertEquals(new CloseCombatCard("Card 1", "Close Combat", 10), Card1)
  }

  test("A User and a card has to be different from Another") {
    assert(!user1.equals(Card1))
    assert(!Card1.equals(user1))
  }

  test("The hash code of a User is consistent with equals") {
    assertEquals(new User(name, gems, deck1, hand).##, user1.##)
  }

}
