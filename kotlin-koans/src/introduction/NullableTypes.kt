package introduction

fun sendMessageToClient(
    client: Client?, message: String?, mailer: Mailer
) {
    if (client == null || message == null) return
    client.personalInfo?.let { personalInfo ->
        personalInfo.let {
            it.email?.let { email ->
                mailer.sendMessage(email, message)
            }
        }
    }
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?) {
    override fun toString(): String {
        return "PersonalInfo{email: $email}"
    }
}

interface Mailer {
    fun sendMessage(email: String, message: String)
}

fun main() {
    val mailer = object : Mailer {
        override fun sendMessage(email: String, message: String) {
            println("$message to $email")
        }
    }
    sendMessageToClient(Client(PersonalInfo("baggio@mail.ru")), "Hello world", mailer)

}