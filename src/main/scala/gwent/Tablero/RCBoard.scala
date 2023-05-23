package cl.uchile.dcc
package gwent.Tablero

import gwent.CardType.{Cards, RangedCombatCard}

class RCBoard extends AbstractZone {
  private var RC: List[Cards] = List.empty

  override def addCard(r: Cards): Unit = {
    RC = r :: RC
  }

  override def getCards: List[Cards] = RC
}