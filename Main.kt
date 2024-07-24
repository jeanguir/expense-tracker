package org.example

import kotlin.math.exp

data class Expense(var cost: Int, var category: String, var name: String)

fun main() {
    val expenses = ArrayList<Expense>()
    lateinit var a: String

    while (true) {
        print("Cost: ")
        a = readln()

        val cost: Int
        if (a != "q") {
             cost = a.toInt()
        }
        else {
            break
        }


        print("Category: ")
        a = readln()
        val category: String

        if (a != "q") {
            category = a
        }
        else {
            break
        }


        print("Name: ")
        a = readln()
        val name: String

        if (a != "q") {
            name = a
        }
        else {
            break
        }

        println()
        expenses.add(Expense(cost, category, name))
    }

    println()

    for (expense in expenses) {

        print(expense.name)

        var l: Int = 12 - expense.name.length
        for (i in 1..l)
            print(" ")

        print("|| " + expense.category)

        l = 12 - expense.category.length
        for (i in 1..l)
            print(" ")

        println("|| " + expense.cost + " ₸")
    }
}
