package cl.uchile.dcc
package gwent

import gwent.CardType.{Cards, CloseCombatCard, RangedCombatCard, SiegeCombatCard, WeatherCard}

/** Class representing a board in the Gwen't game.
 *
 * The board is the space where the cards will be played. Each Card type has it designated Zone on the board.
 *
 * @constructor Create a new board with the different zones.
 *
 * @author Leonardo Rikhardsson
 * @since 1.3.0
 * @version 1.0.0
 */

class Board {
  private val sharedWeatherZone: WeatherZone = WeatherZone.getInstance()
  /** The Zone for Close Combat Cards.
   *
   * This variable stores the CloseCombatCards played in a List.
   */
  private var closeCombatZone: List[CloseCombatCard] = List.empty

  /** The Zone for Ranged Combat Cards.
   *
   * This variable stores the RangedCombatCards played in a List.
   */
  private var rangedCombatZone: List[RangedCombatCard] = List.empty

  /** The Zone for Siege Combat Cards.
   *
   * This variable stores the SiegeCombatCards played in a List.
   */
  private var siegeCombatZone: List[SiegeCombatCard] = List.empty


  /** Plays the player's card on the CloseCombatZone.
   *
   * The card played from the "playCard" Function and used on the "playOnBoard" Function.
   * This is achieved by using double dispatch, to filter the options depending on the zone it is being played.
   */
  def playCloseCombatCard(card: CloseCombatCard): Unit = {
    closeCombatZone = card :: closeCombatZone
  }

  /** Plays the player's card on the RangedCombatZone.
   *
   * The card played from the "playCard" Function and used on the "playOnBoard" Function.
   * This is achieved by using double dispatch, to filter the options depending on the zone it is being played.
   */
  def playRangedCombatCard(card: RangedCombatCard): Unit = {
    rangedCombatZone = card :: rangedCombatZone
  }

  /** Plays the player's card on the SiegeCombatZone.
   *
   * The card played from the "playCard" Function and used on the "playOnBoard" Function.
   * This is achieved by using double dispatch, to filter the options depending on the zone it is being played.
   */
  def playSiegeCombatCard(card: SiegeCombatCard): Unit = {
    siegeCombatZone = card :: siegeCombatZone
  }

  /** Plays the player's card on the WeatherZone.
   *
   * The card played from the "playCard" Function and used on the "playOnBoard" Function.
   * This is achieved by using double dispatch, to filter the options depending on the zone it is being played.
   */
  def playWeatherCard(card: WeatherCard): Unit = {
    sharedWeatherZone.addWeatherCard(card)
  }

  /** Shows the cards in the CloseCombatZone.
   *
   * Displays the cards in the CloseCombatZone which where played with playCloseCombatCard
   * This is achieved by showing the List of cards of the variable.
   */
  def getCloseCombatZone: List[CloseCombatCard] = closeCombatZone

  /** Shows the cards in the RangedCombatZone.
   *
   * Displays the cards in the RangedCombatZone which where played with playRangedCombatCard
   * This is achieved by showing the List of cards of the variable.
   */
  def getRangedCombatZone: List[RangedCombatCard] = rangedCombatZone

  /** Shows the cards in the SiegeCombatZone.
   *
   * Displays the cards in the SiegeCombatZone which where played with playSiegeCombatCard
   * This is achieved by showing the List of cards of the variable.
   */
  def getSiegeCombatZone: List[SiegeCombatCard] = siegeCombatZone

  /** Shows the single card in the WeatherZone.
   *
   * Displays a single card from the WeatherZone which where played with playWeatherCard
   * This is achieved by showing the Option of the card.
   */
  def getWeatherZone: Option[WeatherCard] = sharedWeatherZone.getWeatherCard

  /** Sets the cards in the CloseCombatZone.
   *
   * Sets the cards in the Siege Combat Zone of the board. The provided list of `CloseCombatCard`
   * replaces the current cards in the zone.
   */
  def setCloseCombatZone(cards: List[CloseCombatCard]): Unit = {
    closeCombatZone = cards
  }

  /** Sets the card in the RangedCombatZone.
   *
   * Sets the cards in the Siege Combat Zone of the board. The provided list of `RangedCombatCard`
   * replaces the current cards in the zone.
   */
  def setRangedCombatZone(cards: List[RangedCombatCard]): Unit = {
    rangedCombatZone = cards
  }

  /** Sets the card in the SiegeCombatZone.
   *
   * Sets the cards in the Siege Combat Zone of the board. The provided list of `SiegeCombatCard`
   * replaces the current cards in the zone.
   */
  def setSiegeCombatZone(cards: List[SiegeCombatCard]): Unit = {
    siegeCombatZone = cards
  }

  /** Sets the card in the WeatherZone.
   *
   * Sets the card in the Weather Zone of the board. The provided `Option` of `WeatherCard`
   * replaces the current card in the zone.
   */
  def setWeatherZone(card: Option[WeatherCard]): Unit = {
    sharedWeatherZone.setWeatherCard(card)
  }
}