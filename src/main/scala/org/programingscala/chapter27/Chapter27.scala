package org.programingscala.chapter27

abstract class Food(val name: String) { override def toString: String = name }
object Apple extends Food("Apple")
object Orange extends Food("Orange")
object Cream  extends Food("Cream")
object Sugar  extends Food("Sugar")

class Recipe(val name: String, val ingredients: List[Food], val instructions: String) {
  override def toString: String = name
}

object FruitSaladBasic extends Recipe(
  "fruit salad",
  List(Apple, Orange, Cream, Sugar),
  "Stir it all together."
)

// --- Shared category type
case class FoodCategory(name: String, foods: List[Food])

trait FoodCategories {
  def allCategories: List[FoodCategory]
}

abstract class Database extends FoodCategories {
  def allFoods: List[Food]
  def allRecipes: List[Recipe]
  def foodNamed(name: String): Option[Food] = allFoods.find(_.name == name)
}

abstract class Browser {
  val database: Database
  def recipesUsing(food: Food): List[Recipe] =
    database.allRecipes.filter(_.ingredients.contains(food))

  def displayCategory(category: FoodCategory): Unit = {
    println(s"Category: ${category.name}")
    category.foods.foreach(f => println(s"  - $f"))
  }
}

object BasicSimpleDatabase extends Database {
  def allFoods: List[Food] = List(Apple, Orange, Cream, Sugar)
  def allRecipes: List[Recipe] = List(FruitSaladBasic)
  def allCategories: List[FoodCategory] = List(
    FoodCategory("fruits", List(Apple, Orange)),
    FoodCategory("misc",   List(Cream, Sugar))
  )
}

object BasicSimpleBrowser extends Browser { val database: Database = BasicSimpleDatabase }

object StudentDatabase extends Database {
  object FrozenFood extends Food("FrozenFood")
  object HeatItUp   extends Recipe("heat it up", List(FrozenFood), "Microwave for 10 minutes.")
  def allFoods: List[Food] = List(FrozenFood)
  def allRecipes: List[Recipe] = List(HeatItUp)
  def allCategories: List[FoodCategory] = List(FoodCategory("edible", List(FrozenFood)))
}

object StudentBrowser extends Browser { val database: Database = StudentDatabase }

trait SimpleFoods extends Database {
  object Pear extends Food("Pear")
  override def allFoods: List[Food] = List(Apple, Pear)
  override def allCategories: List[FoodCategory] = Nil
  def allRecipes: List[Recipe]
}

trait SimpleRecipes { this: SimpleFoods =>
  object FruitSaladPear extends Recipe("fruit salad (pear)", List(Apple, Pear), "Mix together.")
  def allRecipes: List[Recipe] = List(FruitSaladPear)
}

object TraitBasedDatabase extends Database with SimpleFoods with SimpleRecipes
object TraitBasedBrowser extends Browser { val database: Database = TraitBasedDatabase }

object GotApples {
  def main(args: Array[String]): Unit = {
    val db: Database =
      if (args.nonEmpty && args(0) == "student") StudentDatabase
      else if (args.nonEmpty && args(0) == "trait") TraitBasedDatabase
      else BasicSimpleDatabase

    object browser extends Browser { val database: Database = db }

    println("== Database: " + db.getClass.getSimpleName.replace("$", ""))

    db.foodNamed("Apple") match {
      case Some(apple) =>
        println("Recipes using Apple:")
        browser.recipesUsing(apple).foreach(r => println("  * " + r.name))
      case None =>
        println("No Apple in this database.")
        println("Foods:")
        db.allFoods.foreach(f => println("  - " + f.name))
    }

    if (db.allCategories.nonEmpty) {
      println("Categories:")
      db.allCategories.foreach(cat => browser.displayCategory(cat))
    }
  }
}
