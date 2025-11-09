package org.programingscala.chapter28

sealed abstract class Food(val name: String) { override def toString = name }
case object Apple extends Food("Apple")
case object Orange extends Food("Orange")
case object Cream  extends Food("Cream")
case object Sugar  extends Food("Sugar")

case class Recipe(name: String, ingredients: List[Food], instructions: String)

object Samples {
  val fruitSalad1 = Recipe("fruit salad", List(Apple, Orange, Cream, Sugar), "Mix.")
  val fruitSalad2 = Recipe("fruit salad", List(Apple, Orange, Cream, Sugar), "Mix.")
  val orangeCream = Recipe("orange cream", List(Orange, Cream), "Stir.")
}

class PlainRecipe(val name: String, val ingredients: List[Food], val instructions: String) {
  override def toString: String = s"PlainRecipe($name)"
}

object PlainSamples {
  val p1 = new PlainRecipe("fruit salad", List(Apple, Orange, Cream, Sugar), "Mix.")
  val p2 = new PlainRecipe("fruit salad", List(Apple, Orange, Cream, Sugar), "Mix.")
}

object EqualityDemos {
  import Samples._
  import PlainSamples._

  def caseClassEquality(): Unit = {
    println("== Case class equality ==")
    println(s"fruitSalad1 == fruitSalad2 ? ${fruitSalad1 == fruitSalad2}")
    val s = Set(fruitSalad1, fruitSalad2)
    println(s"Set(fruitSalad1, fruitSalad2).size = ${s.size}")
  }

  def plainClassEquality(): Unit = {
    println("== Plain class equality ==")
    println(s"p1 == p2 ? ${p1 == p2}")
    val s = Set(p1, p2)
    println(s"Set(p1, p2).size = ${s.size}")
  }

  final class ProperRecipe(val name: String, val ingredients: List[Food], val instructions: String) {
    override def toString: String = s"ProperRecipe($name)"
    override def equals(other: Any): Boolean = other match {
      case that: ProperRecipe =>
        (this.name == that.name) && (this.ingredients == that.ingredients) && (this.instructions == that.instructions)
      case _ => false
    }
    override def hashCode(): Int = {
      val state = Seq(name, ingredients, instructions)
      state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
    }
  }

  def properClassEquality(): Unit = {
    println("== Proper non-case class equality ==")
    val a = new ProperRecipe("fruit salad", List(Apple, Orange, Cream, Sugar), "Mix.")
    val b = new ProperRecipe("fruit salad", List(Apple, Orange, Cream, Sugar), "Mix.")
    println(s"a == b ? ${a == b}")
    val s = Set(a, b)
    println(s"Set(a, b).size = ${s.size}")
  }
}

trait Database {
  def allFoods: List[Food]
  def allRecipes: List[Recipe]
  def foodNamed(name: String): Option[Food] = allFoods.find(_.name == name)
}

trait Browser {
  val database: Database
  def recipesUsing(food: Food): List[Recipe] =
    database.allRecipes.filter(_.ingredients.contains(food))
}

object SimpleDatabase extends Database {
  import Samples._
  def allFoods = List(Apple, Orange, Cream, Sugar)
  def allRecipes = List(fruitSalad1, fruitSalad2, orangeCream)
}

object SimpleBrowser extends Browser { val database: Database = SimpleDatabase }

object Ch28Demo {
  def main(args: Array[String]): Unit = {
    import EqualityDemos._
    caseClassEquality()
    plainClassEquality()
    properClassEquality()

    println("== Using Browser with case-class recipes ==")
    val apple = SimpleDatabase.foodNamed("Apple").get
    val found = SimpleBrowser.recipesUsing(apple)
    println("Recipes using Apple (raw):")
    found.foreach(r => println("  * " + r))
    println(s"Unique recipes (Set): ${found.toSet.size} item(s)")
    println("Done.")
  }
}
