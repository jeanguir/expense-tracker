package org.example

import kotlin.math.exp

data class Expense(var cost: Int, var category: String, var name: String)

fun main() {
    val expenses = mutableListOf<Expense>()

    while (true) {
        val name = readExpenseDetail("Name: ") ?: break
        val category = readExpenseDetail("Category: ") ?: break
        val cost = readExpenseDetail("Cost: ") ?: break
        
        expenses.add(Expense(cost.toInt(), category, name))
        println()
    }

    println()

    for (expense in expenses) {

        print("${expense.name.padEnd(12)} || ")
        print("${expense.category.padEnd(12)} || ")
        println("${expense.cost} ₸")
    }
}

fun readExpenseDetail(field: String): String? {
    print(field)
    val input = readln()
    return if (input != "q") input else return null
}
