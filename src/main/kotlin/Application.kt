import lists.DoublyLinkedList

fun main(args: Array<String>) {
    val myList = DoublyLinkedList<Int>(null, null).apply {
        add(10)
        add(20)
        addFirst(30)
        add(5)
        add(34)
    }
    println(myList.toString())
    println(myList.length())
    println(myList.first())
    println(myList.last())
    myList.remove(e=15)
    myList.remove(e=10)
    println("After removing 15 and 10: $myList")
    myList.remove(e=30)
    println("Head after removing 30: ${myList.first()}")
    myList.remove(e=34)
    println("Tail after removing 34: ${myList.last()}")
    myList.run {
        addFirst(20)
        addFirst(10)
        add(34)
    }
    println("After trying to re-add: $myList")
    myList.remove(i=3)
    println("After deleting by position $myList")
    println("List contains 15? ${myList.contains(15)}")
    println("List contains 10? ${myList.contains(34)}")
}