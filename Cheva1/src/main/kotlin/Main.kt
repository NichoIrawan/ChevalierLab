fun main() {
    var i = -1

    while (i != 0) {
        i = menu()
    }
}

fun menu (): Int {
    println("============= Menu ============")
    println("-------------------------------")
    println("1. Celsius para Fahrenheit")
    println("2. Fahrenheit para Celsius")
    println("3. Celsius para Kelvin")
    println("4. Kelvin para Celsius")
    println("0. Exit")
    println("-------------------------------")
    print("Input: ")
    val input = readln()
    println("-------------------------------")

    when (input) {
        "1" -> println("Fahrenheit: " + celcToFahrenheit())
        "2" -> println("Celcius: " + fahrenheitToCelsius())
        "3" -> println("Kelvin: " + celcToKelvin())
        "4" -> println("Celcius: " + kelvinToCelsius())
        "0" -> println("Terima kasih")
        else -> println("Invalid input")
    }

    return input.toInt()
}

fun celcToFahrenheit() : Double {
    print("Input derajat: ")
    val temp = readln().toDouble()
    return temp * 9 / 5 + 32
}

fun fahrenheitToCelsius() : Double {
    print("Input derajat: ")
    val temp = readln().toDouble()
    return (temp - 32) * 5 / 9
}

fun celcToKelvin() : Double {
    print("Input derajat: ")
    val temp = readln().toDouble()
    return temp + 273.15
}

fun kelvinToCelsius() : Double {
    print("Input derajat: ")
    val temp = readln().toDouble()
    return temp - 273.15
}