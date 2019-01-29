package MUD

class Player(
    _name: String,
    private var _loc: Int,
    private var inventory: List[Item])
    {
  def getName(): String = {
    val name = _name
    name
  }
  def getLoc(): Int = {
    val location = _loc
    location
  }
  def getInv(): String = {
    //prints the inventory in a specific format
    ???
  }
  def processCommand(cmd: String): Unit = {
  
  }
  def getFromInventory(itemName: String): Option[Item] = {
    //pull item out of inv(if exists) and return it
    ???
  }
  def addToInventory(item: Item): Unit = {
    //Add item to inv
    ???
  }
  
  def move(dir: String):Unit = {
   if(dir == "north") {
     //_loc = Room.room(this.getLoc).getExits(0)
     ???
   }
  }
}