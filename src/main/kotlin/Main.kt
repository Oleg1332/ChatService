fun main() {
    val chatService = ChatsService()

    println(chatService.addMessage(1,"Чел, да ты нудный какой то.."))
    println(chatService.addMessage(2,"Моя первая реплика другому товарищю"))
    println("\nБеседа с собеседником ${chatService.getName(1)} :\n  ${chatService.getMessage(1,0,100)}")

    println("\n ${chatService.getChats(false)}")

    println("\n ${chatService.getChats(true)}")

    println("\n ${chatService.deleteMessage(1,1)}")
    println("\nБеседа с собеседником ${chatService.getName(1)} :\n  ${chatService.getMessage(1,333,100)}")

    println("\n ${chatService.deleteChat(1)}")
    println("\nБеседа с собеседником ${chatService.getName(1)} :\n  ${chatService.getMessage(1,0,100)}")

}