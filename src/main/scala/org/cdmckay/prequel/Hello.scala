package org.cdmckay.prequel

object Hello extends App {

  val table = new Table[(Int, String)]
  table.insert(1, "one")
  table.selectAll()

}
