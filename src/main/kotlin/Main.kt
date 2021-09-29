
fun main(args: Array<String>) {
    //println("Hello World!")

    // Try adding program arguments at Run/Debug configuration
    println("Program arguments: ${args.joinToString()}")

    println("1.String template")
    val number1 = 2
    val number2= 3
    exercise1(number1,number2)

    println("2.Immutable list")
    val list=listOf<String>("Monday","Tuesday","Wednesday","Thursday","Friday", "Saturday","Sunday");
    exercise2(list)

    println("\n3.number is prime or not")
    var a=1
    var b=20
    for (i in a..b) {
        print("$i ${isprime(i)}   ")
    }

    println("\n\n4. encode and decode ")
    val str="alma"
    println("endocde: ${myEncode(str)}")
    println("decode: ${myDecode(str)}")
    //println("messageCoding: ${messageCoding(str,myEncode())}")

    println("5.  even numbers from a list ")
    val list2= listOf<Int>(1,5,8,7,4,6,9,5,2,3)
    println(filterlist(list2))

    println("6.Using map ")
    exercise6(list2,list)

    println("\n7.mutable list ")
    exercise7(list)

    println("\n8.Arrays")
    exercise8()

}
fun exercise1(a: Int , b: Int){
    println("$a + $b = ${a+b}")
}
fun exercise2(list: List<String>){
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

    println("\n\narray contains any even number?")
    var t =false
    for (i in alist){
        if (i % 2 == 0 ){
            t=true
        }
    }
    println(t)

    println("\n\nall the numbers are even?")
    var t2 =true
    for (i in alist){
        if (i % 2 == 1 ){
            t2=false
        }
    }
    println(t)


    println("\naverage of generated numbers and print it")
    print(alist.average())

}