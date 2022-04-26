object MyClass {

    def main(args: Array[String]) {
        val checksum = luhnAlgorithm("79927398713")
        println(s"$checksum")
    }
    
    def luhnAlgorithm(idNumber: String): Boolean = {
        var sum = 0
        var isSecond = false
        for (i <- 0 to idNumber.length - 1) {
          var digit = idNumber.charAt(i).getNumericValue
          if (isSecond) { 
            digit = digit * 2
            if (digit > 9) {
              digit = digit - 9 
            }
          }
          sum += digit
          isSecond = !isSecond
        }
        sum % 10 == 0
  }    
}
