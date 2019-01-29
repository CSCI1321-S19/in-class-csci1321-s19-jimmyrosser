package MUD

import io.StdIn._

object Main {
  def main(args: Array[String]): Unit = {
    val player1 = new Player("Joe Biden", 0, List[Item](new Item("Medal", "A medal for being the best V.P of the United States"), new Item("Gun", "An ex V.P. always carries a gun")))
    
    var input = ""
    do {
      input = readLine.toLowerCase
      player1.processCommand(input)
    } while(input.toLowerCase != "exit")
  }
}
