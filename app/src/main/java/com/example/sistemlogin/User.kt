package com.example.sistemlogin

class User(
    private var nama: String = "",
    private var email: String = "",
    private var noHP: String = "",
    private var username: String = "",
    private var password: String = ""
) {
//    constructor() : this("", "")
    public fun getNama() = nama
    public fun getEmail() = email
    public fun getnoHP() = noHP
    public fun getUsername() = username
    public fun getPassword() = password
}