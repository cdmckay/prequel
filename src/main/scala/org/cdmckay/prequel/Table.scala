package org.cdmckay.prequel

import scala.collection.JavaConverters._

class Table(private val schema: Array[Class[_]]) {

  type R = Array[Any]

  private val rows = new java.util.LinkedList[R]()

  def insert(row: Any*): Unit = {
    if (doesConformToSchema(row)) {
      println("1 row inserted")
      rows.add(row.toArray)
    }
  }

  def selectAll(): Unit = rows.asScala.foreach(r => println(convertRowToString(r)))

  def selectWhereEq(i: Int, value: Any): Unit =
    rows.asScala.foreach { r =>
      if (r(i) == value) {
        println(convertRowToString(r))
      }
    }

  private def doesConformToSchema(row: Seq[Any]): Boolean = {
    if (row.length != schema.length) {
      println("row has different number of columns than schema")
      return false
    }
    val columnMismatches = (schema zip row).filterNot { case (s, r) => s == r.getClass }
    if (columnMismatches.nonEmpty) {
      println("row does not match schema: ")
      columnMismatches.foreach { case (s, r) => println(s"  $r is a ${r.getClass} but needs to be a $s")}
      return false
    }
    true
  }

  private def convertRowToString(row: R): String = row.mkString(", ")

}
