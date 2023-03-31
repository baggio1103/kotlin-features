package classes.extension


enum class ContactType {

    TELEGRAM,

    INSTAGRAM

}

data class Contact(val value: String, val contactType: ContactType)

private fun print() {

}

fun main() {
    val contacts = listOf(Contact("baggio1103", ContactType.INSTAGRAM),
        Contact("baggio1103", ContactType.TELEGRAM), Contact("baggio", ContactType.INSTAGRAM))
    println(contacts)
    println(contacts.associateBy { it.contactType }.values.toList())

}