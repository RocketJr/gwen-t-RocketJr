package cl.uchile.dcc
package gwent

import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

import gwent.Effects.Effect
import gwent.Effects.UnitCardEffect.{NullUnitEffect, RefuerzoMoral, VinculoEstrecho}
import gwent.Effects.WeatherCardEffect.{ClimaDespejado, EscarchaMordiente, LluviaTorrencial,
  NieblaImpenetrable, NullWeatherEffect}

import gwent.Tablero.Board
import munit.FunSuite

class EffectsTest extends FunSuite {
  val name: String = "Player 1"
  val gems: Int = 3
  var Card0 = new CloseCombatCard("Card 0", "Close Combat", 10, NullUnitEffect)
  var Card1 = new CloseCombatCard("Card 1", "Close Combat", 10, RefuerzoMoral)
  var Card2 = new RangedCombatCard("Card 2", "Ranged Combat", 8, NullUnitEffect)
  var Card3 = new SiegeCombatCard("Card 3", "Siege Combat", 12, NullUnitEffect)
  val Card4 = new WeatherCard("Card 4", "Weather", ClimaDespejado)
  var Card5 = new CloseCombatCard("Card 5", "Close Combat", 123, NullUnitEffect)
  val Card6 = new WeatherCard("Card 6", "Weather", EscarchaMordiente)
  val Card7 = new WeatherCard("Card 7", "Weather", NieblaImpenetrable)
  val Card8 = new WeatherCard("Card 8", "Weather", LluviaTorrencial)
  var Card9 = new CloseCombatCard("Card 0", "Close Combat", 20, VinculoEstrecho)
  var Card10 = new SiegeCombatCard("Card 10", "Siege Combat", 2983018, NullUnitEffect)
  val Card11 = new WeatherCard("Card 11", "Weather", NullWeatherEffect)


  val deck1: List[Cards] = List(Card1)
  val deck2: List[Cards] = List(Card3, Card2)
  val hand1: List[Cards] = List(Card1, Card4, Card3, Card5, Card6, Card2, Card7, Card8, Card11)
  val hand2: List[Cards] = List(Card0, Card9, Card10)

  var board1 = new Board()
  var board2 = new Board()
  //val game = new GameInterface()
  //val game: List[Board] = List(board1,board2)

  var user1: User = _
  var user2: User = _

  override def beforeEach(context: BeforeEach): Unit = {
    user1 = new User(name, gems, deck1, hand1, board1)
    user2 = new User(name, gems, deck2, hand2, board2)
  }
  test("El poder de las cartas Close Combat debe ser 1 cuando se juegue una carta clima con Escarcha mordiente") {

    user1.playCard(Card5)
    assertEquals(user1.hand, List(Card1, Card4, Card3, Card6, Card2, Card7, Card8, Card11))
    assertEquals(board1.getCloseCombatZone, List(Card5))

    user2.playCard(Card0)
    assertEquals(user2.hand, List(Card9, Card10))
    assertEquals(board2.getCloseCombatZone, List(Card0))

    user2.playCard(Card9)
    assertEquals(user2.hand, List(Card10))
    assertEquals(board2.getCloseCombatZone, List(Card9, Card0))

    user2.playCard(Card10)
    assertEquals(user2.hand, List())
    assertEquals(board2.getSiegeCombatZone, List(Card10))

    assertEquals(Card0.currentPower, Card1.originalPower * 2)
    assertEquals(Card9.currentPower, Card9.originalPower * 2)

    user1.playCard(Card1)
    assertEquals(user1.hand, List(Card4, Card3, Card6, Card2, Card7, Card8, Card11))
    assertEquals(board1.getCloseCombatZone, List(Card1, Card5))

    assertEquals(Card1.currentPower, Card1.originalPower)
    assertEquals(Card5.currentPower, Card5.originalPower + 1)

    user1.playCard(Card2)
    assertEquals(user1.hand, List(Card4, Card3, Card6, Card7, Card8, Card11))
    assertEquals(board1.getRangedCombatZone, List(Card2))

    user1.playCard(Card3)
    assertEquals(user1.hand, List(Card4, Card6, Card7, Card8, Card11))
    assertEquals(board1.getSiegeCombatZone, List(Card3))

    user1.playCard(Card6)
    assertEquals(user1.hand, List(Card4, Card7, Card8, Card11))
    assertEquals(board1.getWeatherZone, Option(Card6))

    board1.getCloseCombatZone.foreach(card => assertEquals(card.currentPower, 1))
    board1.getRangedCombatZone.foreach(card => assertEquals(card.currentPower, card.originalPower))
    board1.getSiegeCombatZone.foreach(card => assertEquals(card.currentPower, card.originalPower))
    //board2.getSiegeCombatZone.foreach(card => assertEquals(card.currentPower, card.originalPower))

    user1.playCard(Card11)
    assertEquals(user1.hand, List(Card4, Card7, Card8))
    assertEquals(board1.getWeatherZone, Option(Card11))

    board1.getCloseCombatZone.foreach(card => assertEquals(card.currentPower, 1))
    board1.getRangedCombatZone.foreach(card => assertEquals(card.currentPower, card.originalPower))
    board1.getSiegeCombatZone.foreach(card => assertEquals(card.currentPower, card.originalPower))

    user1.playCard(Card7)
    assertEquals(user1.hand, List(Card4, Card8))
    assertEquals(board1.getWeatherZone, Option(Card7))

    board1.getCloseCombatZone.foreach(card => assertEquals(card.currentPower, 1))
    board1.getRangedCombatZone.foreach(card => assertEquals(card.currentPower, 1))
    board1.getSiegeCombatZone.foreach(card => assertEquals(card.currentPower, card.originalPower))
    //board2.getSiegeCombatZone.foreach(card => assertEquals(card.currentPower, card.originalPower))

    user1.playCard(Card8)
    assertEquals(user1.hand, List(Card4))
    assertEquals(board1.getWeatherZone, Option(Card8))

    board1.getCloseCombatZone.foreach(card => assertEquals(card.currentPower, 1))
    board1.getRangedCombatZone.foreach(card => assertEquals(card.currentPower, 1))
    board1.getSiegeCombatZone.foreach(card => assertEquals(card.currentPower, 1))
    //board2.getSiegeCombatZone.foreach(card => assertEquals(card.currentPower, card.originalPower))

    user1.playCard(Card4)
    assertEquals(user1.hand, List())
    assertEquals(board1.getWeatherZone, Option(Card4))
    board1.getSiegeCombatZone.foreach(card => assertEquals(card.currentPower, card.originalPower))
    board1.getSiegeCombatZone.foreach(card => assertEquals(card.currentPower, card.originalPower))
    //board2.getSiegeCombatZone.foreach(card => assertEquals(card.currentPower, card.originalPower))
  }
}