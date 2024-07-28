package org.example

data class Expense(var cost: Int, var name: String, var listIndex: Int)

fun main() {
    val lists = mutableListOf<String>()
    val expenses = mutableListOf<Expense>()

    while (true) {
        printLists(lists)
        val input = readln()

        if (input == "a" || input == "ф") {
            print("Name new list: ")
            lists.add(readln())
        } else if (input == "e" || input == "у") {
            print("List index: ")
            val a = readln().toInt()

            while (true) {
                println("\n-- ${lists[a - 1]} --")
                for (expense in expenses) {
                    if (expense.listIndex == a) {
                        println(expense.name.padEnd(16) + expense.cost)
                    }
                }

                print("\nAdd element [Name, Cost] (q - to quit): ")
                val choice = readln()

                if (choice == "q" || choice == "й")
                    break
                else {
                    try {
                        val str = choice.split(", ")
                        addExpense(expenses, str[0], str[1].toInt(), a)
                    } catch(e: Exception) {
                        println("Error")
                    }
                }
            }
        }
    }
}

fun addExpense(expenses: MutableList<Expense>, name: String, cost: Int, listIndex: Int) {
    expenses.add(Expense(cost, name, listIndex))
}

fun printLists(lists: MutableList<String>) {
    println("-- Lists --")

    var i = 1
    for (list in lists) {
        println("${i++}. $list")
    }

    println("---------------")
    println("[A] ADD NEW LIST")
    println("[E] EDIT LIST")
}
