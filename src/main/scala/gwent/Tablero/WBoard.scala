package cl.uchile.dcc
package gwent.Tablero

import gwent.CardType.Cards

class WBoard {
  private var WC: List[Cards] = List.empty

  def addCard(w: Cards): Unit = {
    WC = w :: WC
  }

  def getCards: List[Cards] = WC
}
