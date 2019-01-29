package MUD

import io.StdIn._

object Main {
  def main(args: Array[String]): Unit = {
    val player1 = new Player("Joe Biden", 0, List[Item](new Item("Medal", "A medal for being the best V.P of the United States"), new Item("Gun", "An ex V.P. always carries a gun")))
    val help = "Possible commands:\n\n\tDirections (varies by room)\n\t\tNorth(n)\n\t\tSouth(s)\n\t\tEast(e)\n\t\tWest(w)\n\t\tUp(u)\n\t\tDown(d)\n\n\tLook: Reprints the description of the room.\n\tGet \"Item\": Allows you to pick up an item in the room and add it to your inventory.\n\tDrop \"Item\": Allows you to remove an item from your inventory and drop it into the current room.\n\tInventory(inv): Lists the items in your inventory."
    var input = readLine.toLowerCase
    do {
      if(input == "help" || input == "h") {
        println(help)
      }
      else if(input == "north" || input == "n") {
        if(Room.rooms(player1.getLoc).getExits(0) == None) {
        println("That is not a valid direction. Please try again.")
        input = readLine
        }
        else {
          player1.move("north")
        }
      }
      else if(input == "south" || input == "s") {
        if(Room.rooms(player1.getLoc).getExits(1) == None) {
        println("That is not a valid direction. Please try again.")
        input = readLine
        }
        else {
          player1.move("south")
        }
      }
      else if(input == "east" || input == "e") {
        if(Room.rooms(player1.getLoc).getExits(2) == None) {
        println("That is not a valid direction. Please try again.")
        input = readLine
        }
        else {
          player1.move("east")
        }
      }
      else if(input == "west" || input == "w") {
        if(Room.rooms(player1.getLoc).getExits(3) == None) {
        println("That is not a valid direction. Please try again.")
        input = readLine
        }
        else {
          player1.move("west")
        }
      }
      else if(input == "up" || input == "u") {
        if(Room.rooms(player1.getLoc).getExits(0) == None) {
        println("That is not a valid direction. Please try again.")
        input = readLine
        }
        else {
          player1.move("up")
        }
      }
      else if(input == "down" || input == "d") {
        if(Room.rooms(player1.getLoc).getExits(0) == None) {
        println("That is not a valid direction. Please try again.")
        input = readLine
        }
        else {
          player1.move("down")
        }
      }
      else if(input == "look") {
        println(Room.rooms(player1.getLoc).description)
      }
      //HELP WITH OPTION
      else if(input.startsWith("get")) {
        val getItem = input.splitAt(3)
        val itemName = getItem._2
        var item = Room.rooms(player1.getLoc).getItem(itemName)
        //item match {
          //case None => println("That is not an item in this room.")
          //case Some(_) => Room.rooms(player1.getLoc).dropItem(Item)
        }
      //}
      //HELP WITH OPTION
      else if(input.startsWith("drop")) {
        val getItem = input.splitAt(3)
        val itemName = getItem._2
        var item = player1.getFromInventory(itemName)
        //item match {
          //case None => println("That is not an item that you have in your inventory")
          //case Some(_) => Room.rooms(player1.getLoc).dropItem(Item)
        }
      //}
      else if(input == "inventory" || input == "inv") {
        println(player1.getInv) 
      }
        
      
    /*
    val rooms = Array[Room](new Room("Bedroom", "A bedroom", List[Item](new Item("Toy", "cool toy"), new Item("Gun", "cool gun")), Array[Int](1, -1, -1, -1, -1, -1)), 
      new Room("Bathroom", "A bathroom", List[Item](new Item("Soap", "cool soap"), new Item("Shower", "cool shower")), Array[Int](-1, 1, -1, -1, -1, -1)))
    rooms(0).getExits(3)
    
    Room.rooms(0).get  
    */
    
    }while(input.toLowerCase != "exit")
  }
}
