interface Observer {
    fun notify(oldText: String, newText: String)
}

class TextViewSubscriber(
    private val id: Int,
) : Observer {
    override fun notify(oldText: String, newText: String) {
        println("Subscriber($id):\tText is changed $oldText -> $newText")
    }
}