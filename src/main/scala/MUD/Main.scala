package MUD

import io.StdIn._

object Main {
  def main(args: Array[String]): Unit = {
    //val player1 = new Player("Joe Biden", 0, List[Item](new Item("Medal", "A medal for being the best V.P of the United States"), new Item("Gun", "An ex V.P. always carries a gun")))
    println("What is your name?")
    var name = readLine
    val player = new Player(name, 0, List[Item](new Item("Map", "A map of the Soviet Union in 1972. This is of no use to you.")))
    var input = ""
    println("")
    Room.printRoom(0)
    do {
      input = readLine.toLowerCase
      player.processCommand(input)
    } while(input.toLowerCase != "exit")
  }
}
