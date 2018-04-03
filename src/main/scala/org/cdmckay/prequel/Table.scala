package org.cdmckay.prequel

import scala.collection.JavaConverters._

class Table[A] {

  private val rows = new java.util.LinkedList[A]()

  def insert(row: A): Unit = rows.add(row)

  def selectAll(): Unit = rows.asScala.foreach(println)

}
