class Employee(val name: String, val age: Int, val department: Department?) {
    fun departmentName() = department?.name ?: "Unknown"
}

class Department(val name: String)

fun main(args: Array<String>) {
    val john = Employee("john", 30, null)
    print(john.name)
    print(john.age)
    print(john.departmentName())
}