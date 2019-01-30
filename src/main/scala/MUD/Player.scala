package MUD

class Player(
  name: String,
  private var loc: Room,
  private var inventory: List[Item]) {
  val help = "Possible commands:\n\n\tDirections (varies by room)\n\t\tNorth(n)\n\t\tSouth(s)\n\t\tEast(e)\n\t\tWest(w)\n\t\tUp(u)\n\t\tDown(d)\n\n\tLook: Reprints the description of the room.\n\tGet \"Item\": Allows you to pick up an item in the room and add it to your inventory.\n\tDrop \"Item\": Allows you to remove an item from your inventory and drop it into the current room.\n\tInventory(inv): Lists the items in your inventory."
  def processCommand(input: String): Unit = {
    if (input == "help" || input == "h") {
      println(help)
    } else if (input == "north" || input == "n") {
      if (loc.getExits(0) == None) {
        println("That is not a valid direction. Please try again.")
      } else {
        move("north")
      }
    } else if (input == "south" || input == "s") {
      if (loc.getExits(1) == None) {
        println("That is not a valid direction. Please try again.")
      } else {
        move("south")
      }
    } else if (input == "east" || input == "e") {
      if (loc.getExits(2) == None) {
        println("That is not a valid direction. Please try again.")
      } else {
        move("east")
      }
    } else if (input == "west" || input == "w") {
      if (loc.getExits(3) == None) {
        println("That is not a valid direction. Please try again.")
      } else {
        move("west")
      }
    } else if (input == "up" || input == "u") {
      if (loc.getExits(4) == None) {
        println("That is not a valid direction. Please try again.")
      } else {
        move("up")
      }
    } else if (input == "down" || input == "d") {
      if (loc.getExits(5) == None) {
        println("That is not a valid direction. Please try again.")
      } else {
        move("down")
      }
    } else if (input == "look") {
      loc.printRoom
    } else if (input.startsWith("get")) {
      val getItem = input.splitAt(3)
      val itemName = getItem._2.trim
      var itemFromRoom = loc.getItem(itemName)
      itemFromRoom match {
        case None => println("That is not an item in this room.")
        case Some(item) => addToInventory(item)
      }
    } else if (input.startsWith("drop")) {
      val getItem = input.splitAt(4)
      val itemName = getItem._2.trim
      var itemFromInv = getFromInventory(itemName)
      itemFromInv match {
        case None => println("That is not an item that you have in your inventory")
        case Some(item) => loc.dropItem(item)
      }
    } else if (input == "inventory" || input == "inv") {
      println(printInv)
    } else println("That is not a valid command. Type \"help\" for a list of valid commands.")
  }
  def getFromInventory(itemName: String): Option[Item] = {
    val item = inventory.find(_.name == itemName)
    item match {
      case None => None
      case Some(i) => {
        inventory = inventory.dropWhile(_.name == itemName)
      }
    }
    item
  }
  def addToInventory(item: Item): Unit = {
    inventory = item :: inventory
  }

  def move(dir: String): Unit = {
    if (dir == "north") {
      loc = loc.getExits(0).get
    } else if (dir == "south") {
      loc = loc.getExits(1).get
    } else if (dir == "east") {
      loc = loc.getExits(2).get
    } else if (dir == "west") {
      loc = loc.getExits(3).get
    } else if (dir == "up") {
      loc = loc.getExits(4).get
    } else if (dir == "down") {
      loc = loc.getExits(5).get
    }
    loc.printRoom
  }
  def printInv(): String = {
    var i = 0
    var inv = "Inventory:\n\t"
    if (inventory.isEmpty) inv += "Empty"
    while (i < inventory.length) {
      inv = inv + (inventory(i).name + "- " + inventory(i).desc + "\n\t")
      i += 1
    }
    inv
  }
}