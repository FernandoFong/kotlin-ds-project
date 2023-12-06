package lists

class DoublyLinkedList<T : Comparable<T>> (private var head : Node<T>?, private var tail : Node<T>?, private var length: Int = 0) {

    class Node<T> (var elem : T, var prev : Node<T>? = null, var next : Node<T>? = null)

    fun first() : T? {
        return head.let { head?.elem }
    }
    fun last() : T? {
        tail.let { return tail?.elem }
    }

    fun get(i : Int): T? {
        var it = this.head
        var count = 0
        while (count < i) {
            it = it?.next
            count++
        }
        return it?.elem
    }

    fun add(e : T) {
        this.addLast(e)
    }

    fun addFirst(e : T) {
        val n = Node(e)
        when (this.head) {
            null -> {
                this.head = n
                this.tail = n
            }
            else -> {
                this.head?.prev = n
                n.next = this.head
                this.head = n
            }
        }
        length++
    }

    fun addLast(e : T) {
        auxAdd(Node(e))
    }

    private fun auxAdd(n : Node<T>) {
        when(this.head) {
            null -> {
                head = n
                tail = n
            }
            else -> {
                tail?.next = n
                n.prev = tail
                tail = n
            }
        }
        length++
    }

    fun remove(e : T) {
        var deleted = false
        if (this.head?.elem?.compareTo(e) == 0) {
            this.head = this.head?.next
            this.head?.prev = null
            deleted = true
        } else if(this.tail?.elem?.compareTo(e) == 0) {
            this.tail = this.tail?.prev
            this.tail?.next = null
            deleted = true
        } else {
            var it = this.head
            while (it != null) {
                if (it.elem.compareTo(e) == 0) {
                    it.prev?.next = it.next
                    it.next?.prev = it.prev
                    deleted = true
                    break
                }
                it = it.next
            }
        }
        length = if (deleted) {
            length-1
        } else {
            length
        }
    }

    fun remove(i: Int) : Boolean {
        if (i < 0 || i > length) {
            return false
        }
        var c = 0
        var it = this.head
        while(c < i) {
            it = it?.next
            c++
        }
        it?.next?.prev = it?.prev
        it?.prev?.next = it?.next
        length--
        return true
    }

    fun contains(e : T) : Boolean {
        var it = this.head
        while (it != null) {
            if (it.elem.compareTo(e) == 0) {
                return true
            }
            it = it.next
        }
        return false
    }

    fun length () : Int {
        return this.length
    }

    override fun toString() : String {
        var s = "["
        var it = head
        while(it != null) {
            s += it.elem.toString()
            s += if (it != tail)
                ","
            else
                ""
            it = it.next
        }
        return "$s]"
    }
}