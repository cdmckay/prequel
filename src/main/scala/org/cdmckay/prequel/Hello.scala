package org.cdmckay.prequel

object Hello extends App {

  val table = new Table(Array(classOf[Integer], classOf[String]))
  table.insert(1, "one", 3)
  table.insert("one", 1)

  table.insert(1, "one")
  table.insert(2, "one")
  table.insert(3, "three")

  table.selectAll()

  table.selectWhereEq(1, "one")

}
