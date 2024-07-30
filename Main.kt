package org.example

data class Expense(var cost: Int, var name: String, var listIndex: Int)

class ExpenseTracker
{
    private val lists = mutableListOf<String>()
    private val expenses = mutableListOf<Expense>()

    fun start() {
        while (true) {
            printLists()
            val input = readln()

            when(input.lowercase()) {
                "a", "ф" -> addNewList()
                "e", "у" -> editList()
                "q", "й" -> break
            }
        }
    }

    private fun editList() {
        println()
        print("List index: ")
        val a = readln().toInt()

        while (true) {
            var total = 0

            println("\n-- ${lists[a - 1]} --")
            for (expense in expenses) {
                if (expense.listIndex == a) {
                    println(expense.name.padEnd(16) + expense.cost)
                    total += expense.cost
                }
            }
            println("--------------")
            println("Total: $total")
            println()

            print("Add element [Name, Cost] (q - to quit): ")
            val choice = readln()

            if (choice == "q" || choice == "й")
                break
            else {
                try {
                    val str = choice.split(", ")
                    addExpense(str[0], str[1].toInt(), a)
                } catch(e: Exception) {
                    val str = choice.split(" ")
                    addExpense(str[0], str[1].toInt(), a)
                }
            }
        }
    }

    private fun addNewList() {
        println()
        print("Name new list: ")
        lists.add(readln())
    }

    private fun addExpense(name: String, cost: Int, listIndex: Int) {
        expenses.add(Expense(cost, name, listIndex))
    }

    private fun printLists() {
        println()
        println("-- Lists --")

        var i = 1
        for (list in lists) {
            println("${i++}. $list")
        }

        println("---------------")
        println("[A] ADD NEW LIST")
        println("[E] EDIT LIST")
        println("[Q] QUIT")
    }
}

fun main() {
    val expenseTracker = ExpenseTracker()
    expenseTracker.start()
}
