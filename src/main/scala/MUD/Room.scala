package MUD

class Room(
    number: Int,
    roomName: String,
    description: String,
    private var inventory: List[Item],
    exits: Array[Int]) {

  def getRoomName(): String = {
    roomName
  }
  def getRoomNum(): Int = {
    number
  }
  def getRoomDesc(): String = {
    description
  }
  def getExits(dir: Int): Option[Room] = {
    if(exits(dir) == -1) None else Some(Room.rooms(exits(dir)))
  }
  def getItem(itemName: String): Option[Item] = {
    ???
  }
  def dropItem(item: Item): Unit = {
    ???
  }
  def printExits(): List[String] = {
    var exitList = List[String]()
    if(exits(0) != -1) {
      "North" :: exitList 
    }
    else {
      Nil :: exitList
    }
    if(exits(1) != -1) {
      "South" :: exitList 
    }
    else {
      Nil :: exitList
    }
    if(exits(2) != -1) 
    {
      "East" :: exitList 
    }
    else {
      Nil :: exitList
    }
    if(exits(3) != -1) {
      "West" :: exitList
    }
    else {
      Nil :: exitList
    }
    if(exits(4) != -1) {
      "Up" :: exitList 
    }
    else {
      Nil :: exitList
    }
    if(exits(5) != -1) {
      "Down" :: exitList 
    }
    else {
      Nil :: exitList
    }
    exitList
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
    val number = lines.next.toInt
    val name = lines.next
    val desc = lines.next
    val items = List.fill(lines.next.trim.toInt) {
      Item(lines.next, lines.next)
    }
    val exits = lines.next.split(",").map(_.trim.toInt)
    new Room(number, name, desc, items, exits)
  }
  def printRoom(roomNum: Int): Unit = {
    println(Room.rooms(roomNum).getRoomName)
    println(Room.rooms(roomNum).getRoomDesc)
    println(Room.rooms(roomNum).printExits.mkString(", "))
  }
}