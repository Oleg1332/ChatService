class ChatsService() {

    var chats: MutableList<Chat> = mutableListOf()

    fun deleteChat(chatId: Int?): String {
        if (chatId == null) return "Не указан id чата"
        return if (chats.removeIf { it.id == chatId }) {
            "Чат с ${getName(chatId)} успешно удален"
        } else {
            "Не найден чат с ${
                getName(
                    chatId
                )
            }"
        }

    }

    fun getName(nameId: Int): String? {
        return names.findLast { it.id == nameId }?.name
    }

     private fun findChat(chatId: Int?): Chat? {
        return chats.findLast { it.id == chatId }
    }

    fun addMessage(id: Int?, message: String): String {
        if (id == null) return "Не указан id чата"
        var chat = findChat(id)
        if (chat == null) {
            chat = Chat(id, ArrayList())
            chats.add(chat)
        }
        val mesId = chat.add(Message(0, message, false, del = false))
        return "К чату с пользователем ${getName(id)} добавлно сообщение с идентификатором $mesId"
    }

    fun deleteMessage(id: Int?, mesId: Int?): String {
        if (id == null) return "Не указан id чата"
        if (mesId == null) return "Не указан id сообщения"
        val chat = findChat(id) ?: return "Не найден чат с id=$id"
        return if (!chat.messages.removeIf { it.id == mesId }) "Не найдено сообщение с id=$mesId" else {
            if (chat.messages.isEmpty()) chats.removeIf { it.id == id }
            "Сообщение чата с ${getName(id)} с номером $mesId успешно удалено"
        }
    }

    fun getMessage(chatId: Int?, mesId: Int?, count: Int?): String {
        if (chatId == null || mesId == null || count == null) return "Указаны неверные параметры"
        val chat = findChat(chatId) ?: return "Чат $chatId не существует"
        return chat.get(mesId, count)
    }
    //sequence used
    private fun getUnreadChats(): String {
        val chats: List<Chat> = chats.filter { chat -> chat.messages.any { !it.read } }
        if (chats.isEmpty()) return "Нет непрочитанных сообщений"
        return ("Список чатов с непрочитанными сообщениями:\n" + getListChats(chats))
    }
    //sequence used
    fun getChats(read: Boolean): String {
        if (!read) return getUnreadChats()
        val chats: List<Chat> = chats.filter { it.messages.isNotEmpty() }
        return ("Список всех чатов:\n" + getListChats(chats))
    }

    private fun getListChats(chats: List<Chat>): String {
        var retValue = ""
        for (chat in chats) retValue += "${getName(chat.id)}  \n"
        retValue += "Всего ${chats.count()} чатов"
        return retValue
    }
}