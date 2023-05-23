package cl.uchile.dcc
package gwent.Tablero

import gwent.CardType.Cards

class CCBoard extends AbstractZone {
  private var CC: List[Cards] = List.empty

  override def addCard(c: Cards): Unit = {
    CC = c :: CC
  }

  override def getCards: List[Cards] = CC
}
