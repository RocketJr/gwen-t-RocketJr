package cl.uchile.dcc
package gwent.Tablero

import gwent.CardType.Cards

/**
 * @constructor Creates a new zone with an empty list.
 * @author Leonardo Rikhardsson
 * @since 1.2.3
 * @version 1.2.3
 */

class SCBoard extends AbstractZone {
  private var SC: List[Cards] = List.empty

  override def addCard(s: Cards): Unit = {
    SC = s :: SC
  }

  override def getCards: List[Cards] = SC
}
