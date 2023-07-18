package cl.uchile.dcc
package gwent.States

import gwent.CardType.Cards

import gwent.GameController

/** Represents a state in the game, as a part of the State Design Pattern implementation.
 *
 * This class is a complete, yet fundamental representation of a game state.
 * It provides a default behaviour for a state within the game, and should be extended
 * by other more specific states.
 * The `context` parameter is used to transition between states.
 *
 * The constructor is protected, which prevents direct instantiation of this class, but allows
 * its use as a base class for other game states.
 *
 * @param context The [[GameController]] which controls state transitions.
 * @constructor Creates a new game state with a given context.
 * @author Leonardo Rikhardsson
 * @since 3.0.0
 * @version 1.0.2
 */

class GameState protected(val context: GameController) {
  context.state = this

  /** Transition the game state to [[IdleState]].
   *
   * This method should be overridden by subclasses that allow this transition.
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def ToIdleState(): Unit = {
    transitionError("IdleState")
  }

  /** Transition the game state to [[PlayerTurnState]].
   *
   * This method should be overridden by subclasses that allow this transition.
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def ToPlayerTurn(): Unit = {
    transitionError("PlayerTurnState")
  }

  /** Transition the game state to [[NextPlayerTurnState]].
   *
   * This method should be overridden by subclasses that allow this transition.
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def playCard(): Unit = {
    transitionError("NextPlayerTurnState")
  }

  /** Transition the game state to [[NextPlayerTurnState]].
   *
   * This method should be overridden by subclasses that allow this transition.
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def passTurn(): Unit = {
    transitionError("NextPlayerTurnState")
  }

  //def ToNextPlayerTurn(): Unit = {
  //  transitionError("NextPlayerTurnState")
  //}

  /** Transition the game state to [[EndTurnState]].
   *
   * This method should be overridden by subclasses that allow this transition.
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def ToEndTurn(): Unit = {
    transitionError("EndTurnState")
  }

  /** Transition the game state to [[StartTurnState]].
   *
   * This method should be overridden by subclasses that allow this transition.
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def ToStartTurn(): Unit = {
    transitionError("StartTurnState")
  }

  /** Transition the game state to [[GameOverState]].
   *
   * This method should be overridden by subclasses that allow this transition.
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def ToGameOver(): Unit = {
    transitionError("GameOverState")
  }

  /** Throws an [[InvalidTransitionException]] with a message about an invalid transition.
   *
   * Notice that this uses [[getClass]] to print the name of the current class.
   * This is one of the few use cases of [[getClass]] that is not considered bad practice, since it
   * is used to print the name of the current class, and not to check the type of an object.
   *
   * @param targetState The name of the state that was attempted to transition to.
   * @throws InvalidTransitionException always.
   */
  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
      s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }
}