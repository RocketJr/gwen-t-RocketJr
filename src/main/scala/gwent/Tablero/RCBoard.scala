package cl.uchile.dcc
package gwent.Tablero

import gwent.CardType.Cards

/**
 * @constructor Creates a new zone with an empty list.
 * @author Leonardo Rikhardsson
 * @since 1.2.3
 * @version 1.2.3
 */

class RCBoard extends AbstractZone {
  private var RC: List[Cards] = List.empty

  override def addCard(r: Cards): Unit = {
    RC = r :: RC
  }

  override def getCards: List[Cards] = RC
}