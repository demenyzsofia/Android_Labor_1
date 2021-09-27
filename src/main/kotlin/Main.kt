
fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments at Run/Debug configuration
    println("Program arguments: ${args.joinToString()}")

    println("1.String template")
    val number1 = 2
    val number2= 3
    exercize1(number1,number2)

    println("2.Immutable list")
    val list=listOf<String>("Monday","Tuesday","Wednesday","Thursday","Friday", "Saturday","Sunday");
    exercize2(list)

    println("3.number is prime or not")
    var a=1
    var b=20
    for (i in a..b) {
        println("$i ${isprime(i)}")
    }

    println("4. encode and decode ")


}
fun exercize1(a: Int , b: Int){
    println("$a + $b = ${a+b}")
}
fun exercize2(list: List<String>){
    //prints the list to the standard outpu
    for (day in list){
        print("$day ")
    }
    println()

    // filter to print the days starting with letter ‘T’
    list.filter{ it.startsWith("T") }.forEach { println(it) }
    println()

    //to print the days containing the letter ‘e’
    list.filter{ it.contains("e") }.forEach { println(it) }
    println()

    // print all the days of length 6 (e.g. Friday)
    list.filter{ it.length==6}.forEach { println(it) }
    println()
}

fun isprime(n :Int ): Boolean{
    if (n == 2 || n == 3){
        return true
    }

    if (n <= 1 || n % 2 == 0 || n % 3 == 0) {
        return false
    }
    var i=5
    while ( i*i < n){
        if (n % i == 0 || n % (i + 2) == 0) {
            return false
        }
        i=i+6
    }

    return true
}

//fun messageCoding(msg: String, func: (String) -> String): String{
//
//}