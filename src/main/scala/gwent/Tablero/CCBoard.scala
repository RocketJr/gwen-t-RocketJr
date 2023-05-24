package cl.uchile.dcc
package gwent.Tablero

import gwent.CardType.Cards

/**
 * @constructor Creates a new zone with an empty list.
 * @author Leonardo Rikhardsson
 * @since 1.2.3
 * @version 1.2.3
 */

class CCBoard extends AbstractZone {
  private var CC: List[Cards] = List.empty

  override def addCard(c: Cards): Unit = {
    CC = c :: CC
  }

  override def getCards: List[Cards] = CC
}
