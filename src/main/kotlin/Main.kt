
fun main(args: Array<String>) {
    //println("Hello World!")
    // Try adding program arguments at Run/Debug configuration
    //println("Program arguments: ${args.joinToString()}")

    println("1.String template")
    val number1 = 2
    val number2= 3
    exercise1(number1,number2)

    println("\n2.Immutable list")
    val list=listOf<String>("Monday","Tuesday","Wednesday","Thursday","Friday", "Saturday","Sunday");
    exercise2(list)

    println("\n3.number is prime or not")
    var a=1
    var b=20
    for (i in a..b) {
        print("$i ${isprime(i)}   ")
    }

    println("\n\n4. encode and decode ")
    var str="alma"
    println("the string: $str")
    str=myEncode(str)
    println("myendocde: $str")
    str=myDecode(str)
    println("mydecode: $str")
    str=messageCoding(str,::myEncode)
    println("messageCodinging with higher-order function (encode): $str")
    str=messageCoding(str,::myDecode)
    println("messageCodinging with higher-order function (dencode): $str")

    println("\n5.  even numbers from a list ")
    val list2= listOf<Int>(1,5,8,7,4,6,9,5,2,3)
    println(list2)
    println(filterlist(list2))

    println("\n6.Using map ")
    exercise6(list2,list)

    println("\n7.mutable list ")
    exercise7(list)

    println("\n\n8.Arrays")
    exercise8()

}
fun exercise1(a: Int , b: Int){
    println("$a + $b = ${a+b}")
}
fun exercise2(list: List<String>){
    println("The list:")
    for (day in list){
        print("$day ")
    }

    println("\n\ndays starting with letter ‘T’")
    list.filter{ it.startsWith("T") }.forEach { println(it) }

    println("\ndays containing the letter ‘e’")
    list.filter{ it.contains("e") }.forEach { println(it) }

    println("\ndays of length 6 (e.g. Friday)")
    list.filter{ it.length==6}.forEach { println(it) }

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

fun myEncode(str : String):String{
    var newstr=""
    for (s in str){
        newstr+=s+1
    }
    return newstr
}

fun myDecode(str : String):String{
    var newstr=""
    for (s in str){
        newstr+=s-1
    }
    return newstr
}

fun messageCoding(msg: String, func: (String) -> String): String{
    return func(msg)
}

//5
fun filterlist(list: List<Int>):List<Int> = list.filter{ x -> x % 2 ==1}


fun exercise6(list : List<Int>,list2 : List <String>){
    println("Double the elements of a list of integers and print it.")
    println(list)
    list.map{it*2}.forEach{print("$it ")}

    println("\n\nPrint the days of week capitalized ")
    list2.map{it.uppercase()}.forEach{print("$it ")}

    println("\n\nPrint the first character of each day capitalized ")
    list2.map{it.first()}.forEach{print("$it ")}

    println("\n\nPrint the length of days")
    list2.map{it.length}.forEach{print("$it ")}

    println("\n\nCompute the average length of days ")
    val avglength = list2.map{ it.length}.average()
    println(avglength)
}

fun exercise7(list: List<String>) {
    println("Remove all days containing the letter ‘n’")
    var mlist=list.toMutableList();
    mlist.removeAll(list.filter{ it.contains("n") })
    println("$mlist")

    println("\nPrint each element of the list in a new line together with the index of the elemen")
    for ( (index,element) in mlist.withIndex() ){
        println("Item at $index is $element")
    }

    println("\nThe sorted list:")
    mlist.sorted().forEach({print("$it ")});
}

fun exercise8(){
    println("the random numbers")
    var alist =Array<Int>(10){(0..100).random()}
    alist.forEach{print("$it ")}

    println("\n\nthe sorted array")
    alist.sorted().forEach{(print("$it "))}

    println("\narray contains any even number?")
    println(alist.any() { i : Int -> i % 2 == 0})

    println("\nall the numbers are even?")
    println(alist.all() { i : Int -> i % 2 == 0})

    println("\naverage of generated numbers and print it")
    print(alist.average())

}