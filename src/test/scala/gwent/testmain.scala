package cl.uchile.dcc
package gwent

import munit.FunSuite

class testmain extends munit.FunSuite{
  val name = "main"
  var carta: main = _
  override def beforeEach(context: BeforeEach): Unit = {
    carta = new main(name)
  }
  test("A main can be created with a name") {
    assertEquals(carta.name, name)
  }
}