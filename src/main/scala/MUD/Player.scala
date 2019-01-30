package MUD

class Player(
    _name: String,
    private var loc: Int,
    private var inventory: List[Item]) {
  val help = "Possible commands:\n\n\tDirections (varies by room)\n\t\tNorth(n)\n\t\tSouth(s)\n\t\tEast(e)\n\t\tWest(w)\n\t\tUp(u)\n\t\tDown(d)\n\n\tLook: Reprints the description of the room.\n\tGet \"Item\": Allows you to pick up an item in the room and add it to your inventory.\n\tDrop \"Item\": Allows you to remove an item from your inventory and drop it into the current room.\n\tInventory(inv): Lists the items in your inventory."
  def processCommand(input: String): Unit = {
      if(input == "help" || input == "h") {
        println(help)
      }
      else if(input == "north" || input == "n") {
        if(Room.rooms(loc).getExits(0) == None) {
        println("That is not a valid direction. Please try again.")
        }
        else {
          move("north")
        }
      }
      else if(input == "south" || input == "s") {
        if(Room.rooms(loc).getExits(1) == None) {
        println("That is not a valid direction. Please try again.")
        }
        else {
          move("south")
        }
      }
      else if(input == "east" || input == "e") {
        if(Room.rooms(loc).getExits(2) == None) {
        println("That is not a valid direction. Please try again.")
        }
        else {
          move("east")
        }
      }
      else if(input == "west" || input == "w") {
        if(Room.rooms(loc).getExits(3) == None) {
        println("That is not a valid direction. Please try again.")
        }
        else {
          move("west")
        }
      }
      else if(input == "up" || input == "u") {
        if(Room.rooms(loc).getExits(4) == None) {
        println("That is not a valid direction. Please try again.")
        }
        else {
          move("up")
        }
      }
      else if(input == "down" || input == "d") {
        if(Room.rooms(loc).getExits(5) == None) {
        println("That is not a valid direction. Please try again.")
        }
        else {
          move("down")
        }
      }
      else if(input == "look") {
        println(Room.rooms(loc).getRoomDesc())
      }
      else if(input.startsWith("get")) {
        val getItem = input.splitAt(3)
        val itemName = getItem._2
        var itemFromRoom = Room.rooms(loc).getItem(itemName)
        itemFromRoom match {
          case None => println("That is not an item in this room.")
          case Some(item) => addToInventory(item)
        }
      }
      else if(input.startsWith("drop")) {
        val getItem = input.splitAt(3)
        val itemName = getItem._2
        var itemFromInv = getFromInventory(itemName)
          itemFromInv match {
          case None => println("That is not an item that you have in your inventory")
          case Some(item) => Room.rooms(loc)
          }
      }
      else if(input == "inventory" || input == "inv") {
        println(printInv)
      }
      else println("That is not a valid command. Type \"help\" for a list of valid commands.")
  }
  def getFromInventory(itemName: String): Option[Item] = {
    //if (inventory.find(Item.name(itemName)))
    //item match {
    //}
    ???
  }
  def addToInventory(item: Item): Unit = {
    item :: inventory
  }
  
  def move(dir: String):Unit = {
     if(dir == "north") {
       //loc = Room.rooms(loc).
       ???
     }
     else if(dir == "south") {
       ???
     }
     else if(dir == "east") {
       ???
     }
     else if(dir == "west") {
       ???
     }
     else if(dir == "up") {
       ???
     }
     else if(dir == "down") {
       ???
     }
  }
  def printInv(): String = {
    var i = 0
    var inv = "Inventory:\n\t"
    if(inventory.isEmpty) inv += "Empty"
    while(i < inventory.length) {
      inv = inv + (inventory(i).name + "- " + inventory(i).desc + "\n\t")
      i += 1
    }
    inv
  }
}