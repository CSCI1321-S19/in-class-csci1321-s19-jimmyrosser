package MUD

class Room(
  roomName: String,
  description: String,
  private var inventory: List[Item],
  exits: Array[Int]) {

  def getRoomName(): String = {
    roomName
  }
  def getRoomDesc(): String = {
    description
  }
  def getExits(dir: Int): Option[Room] = {
    if (exits(dir) == -1) None else Some(Room.rooms(exits(dir)))
  }
  def getItem(itemName: String): Option[Item] = {
    val item = inventory.find(_.name.toLowerCase == itemName)
    item match {
      case None => None
      case Some(i) => inventory = inventory.dropWhile(_.name == itemName)
    }
    item
  }
  def dropItem(item: Item): Unit = {
    inventory = item :: inventory
  }
  def printExits(): List[String] = {
    var exitList = List[String]()
    if (exits(0) != -1) {
      exitList = "North" :: exitList
    }

    if (exits(1) != -1) {
      exitList = "South" :: exitList
    }

    if (exits(2) != -1) {
      exitList = "East" :: exitList
    }

    if (exits(3) != -1) {
      exitList = "West" :: exitList
    }

    if (exits(4) != -1) {
      exitList = "Up" :: exitList
    }

    if (exits(5) != -1) {
      exitList = "Down" :: exitList
    }

    exitList
  }
  def printRoom(): Unit = {
    println(getRoomName)
    println(getRoomDesc)
    println("")
    println("Possible Exits:\n\t" + printExits.mkString(", "))
    println("")
    println(printItems)

  }
  def printItems(): String = {
    var i = 0
    var inv = "Items in room:\n\t"
    if (inventory.isEmpty) inv += "Empty"
    while (i < inventory.length) {
      inv = inv + (inventory(i).name + "- " + inventory(i).desc + "\n\t")
      i += 1
    }
    inv
  }
}

object Room {
  val rooms = readRooms()

  def readRooms(): Array[Room] = {
    val source = scala.io.Source.fromFile("map.txt")
    val lines = source.getLines()
    val rooms = Array.fill(lines.next.trim.toInt)(readRoom(lines))
    source.close()
    rooms
  }
  def readRoom(lines: Iterator[String]): Room = {
    val name = lines.next
    val desc = lines.next
    val items = List.fill(lines.next.trim.toInt) {
      Item(lines.next, lines.next)
    }
    val exits = lines.next.split(",").map(_.trim.toInt)
    new Room(name, desc, items, exits)
  }
}