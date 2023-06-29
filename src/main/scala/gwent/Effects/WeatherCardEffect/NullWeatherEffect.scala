package cl.uchile.dcc
package gwent.Effects.WeatherCardEffect

import gwent.CardType.Cards

class NullWeatherEffect extends AbstractWeatherEffects("Null") {
  override def apply(self: Cards, target: Cards): Unit = {
    // Do nothing
  }

}