package examples.classes

class Customer

class Contact(val id: Int, var email: String)


fun main() {
    val contact = Contact(1, "baggio110@mail.ru")
    val id = contact.id
    val email = contact.email
    println("Id: $id, email: $email")
    contact.email = "baggio1103@gmail.com"
    println("Id: $id, email: $email")
}