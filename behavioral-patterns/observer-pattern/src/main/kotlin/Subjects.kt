import kotlin.properties.Delegates

interface Subject {
    fun registerObserver(observer: Observer)
    fun unregisterObserver(observer: Observer)
}

class TextView : Subject {

    var text: String by Delegates.observable("<empty>") { _, old, new ->
        subscribers.forEach { it.notify(old, new) }
    }
    val subscribers = mutableListOf<Observer>()

    override fun registerObserver(observer: Observer) {
        subscribers.add(observer)
    }

    override fun unregisterObserver(observer: Observer) {
        subscribers.remove(observer)
    }
}