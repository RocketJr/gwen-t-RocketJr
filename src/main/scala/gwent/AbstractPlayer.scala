package cl.uchile.dcc
package gwent

abstract class AbstractPlayer(val name: String, val pos: String, var gems: Int, var deck: Int, var hand: Int) extends Player with Equals {

}
