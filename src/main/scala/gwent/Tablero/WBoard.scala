package cl.uchile.dcc
package gwent.Tablero

import gwent.CardType.Cards

/**
 * @constructor Creates a new zone with an empty list.
 * @author Leonardo Rikhardsson
 * @since 1.2.3
 * @version 1.2.3
 */

class WBoard extends AbstractZone {
  private var WC: List[Cards] = List.empty

  def addCard(w: Cards): Unit = {
    WC = w :: WC
  }

  def getCards: List[Cards] = WC
}
