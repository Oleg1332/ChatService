import kotlin.collections.MutableList
import kotlin.math.min
val names: MutableList<Name> = mutableListOf(
    Name(1,"Вася Пупкин"),
    Name(2,"Иван Сидоров"),
    Name(3,"Сергей Иванов"),
    Name(4,"Марфа Василева"),
    Name(5,"Мария Петровна"))
open class Name (val id: Int, val name: String){}

open class Chat (val id: Int,
            var messages: MutableList<Message>) {

    fun add(message: Message): Int {
        message.id = this.messages.size
        this.messages.add(message)
        return this.messages.last().id
    }

    fun get(id: Int,count:Int): String {
        val size = this.messages.size
        if (id >= size) return ""
        val idLast = min((id + count),size)
        val messages = this.messages.subList(id,idLast)
        var retValue = ""
        for (message in messages){
            if (! message.del) retValue += ("собеседник:") + " ${message.message} \n"
        }
        return retValue
    }
}