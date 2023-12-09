package model.user

class User(
    var name: String,
    var password: String
) {
    override fun toString(): String {
        return "SzypkiKomp@$name"
    }
}
