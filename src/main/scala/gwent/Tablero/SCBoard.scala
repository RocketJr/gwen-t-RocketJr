package cl.uchile.dcc
package gwent.Tablero

import gwent.CardType.Cards

class SCBoard extends AbstractZone {
  private var SC: List[Cards] = List.empty

  override def addCard(s: Cards): Unit = {
    SC = s :: SC
  }

  override def getCards: List[Cards] = SC
}
