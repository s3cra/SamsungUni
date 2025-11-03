package com.example.ilearncomposehere

data class Person(
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val phoneNumber: String,
    val address: String
){
    override fun toString() : String{
        return "Имя: $firstName\n" +
                "Отчество: $middleName\n" +
                "Фамилия: $lastName\n" +
                "Мобильный телефон: $phoneNumber\n" +
                "Адрес: $address"
    }
}