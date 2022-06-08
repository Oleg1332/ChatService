import org.junit.Test

import org.junit.Assert.*

class ChatsServiceTest {

    @Test
    fun getChats() {
        val chatService = ChatsService()
        val addMessage = chatService.addMessage(1, "Чел, да ты нудный какой то..")
        val addMessage3 = chatService.addMessage(1, "Чел, да ты нудный какой то..")
        val addMessage2 = chatService.addMessage(3, "Чел, ты ..")
        val result = chatService.getChats(false)

        assertEquals(
            "Список чатов с непрочитанными сообщениями:\n" +
                    "Всего 2 чатов", result
        )

    }


    @Test
    fun deleteChat() {
        val chatService = ChatsService()
        val addMessage = chatService.addMessage(1, "Чел, да ты нудный какой то..")
        val addMessage3 = chatService.addMessage(1, "Чел, да ты нудный какой то..")
        val addMessage2 = chatService.addMessage(3, "Чел, ты ..")
        val result = chatService.deleteChat(3)

        assertEquals("Чат с Сергей Иванов успешно удален", result)
    }

    @Test
    fun getName() {
        val chatService = ChatsService()
        val names: MutableList<Name> = mutableListOf(
            Name(1, "Вася Пупкин"),
            Name(2, "Иван Сидоров")
        )
        val result = chatService.getName(2)

        assertEquals("Иван Сидоров", result)
    }

    @Test
    fun addMessage() {
        val chatService = ChatsService()
        val addMessage = chatService.addMessage(1, "Чел, да ты нудный какой то..")
        val addMessage3 = chatService.addMessage(1, "Чел, да ты нудный какой то..")
        val addMessage2 = chatService.addMessage(3, "Чел, ты ..")
        assertEquals("К чату с пользователем Вася Пупкин добавлно сообщение с идентификатором 1", addMessage3)
    }

    @Test
    fun deleteMessage() {
        val chatService = ChatsService()
        val addMessage = chatService.addMessage(1, "Чел, да ты нудный какой то..")
        val addMessage3 = chatService.addMessage(1, "Чел, да ты нудный какой то..")
        val addMessage2 = chatService.addMessage(3, "Чел, ты ..")
        val result = chatService.deleteMessage(1, 1)
        assertEquals("Сообщение чата с Вася Пупкин с номером 1 успешно удалено", result)
    }

    @Test
    fun getMessage() {
        val chatService = ChatsService()
        val addMessage = chatService.addMessage(1, "Чел, да ты нудный какой то..")
        val addMessage3 = chatService.addMessage(1, "Чел.")
        val addMessage2 = chatService.addMessage(3, "Чел, ты ..")
        val getMes1 = chatService.getMessage(3, 0, 1)


        assertNotNull(getMes1)
    }

}