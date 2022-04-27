object MyClass {

    def main(args: Array[String]) {
        val isValid = luhnAlgorithm("2001014800087")
        println(s"$isValid")
    }
    
    def luhnAlgorithm(idNumber: String): Boolean = {
        var sum = 0
        val checksum = idNumber.substring(idNumber.length - 1).toInt
        val withoutChecksum = idNumber.substring(0, idNumber.length - 1)
        var isSecond = false
        for (i <- 0 until withoutChecksum.length) {
          var digit = withoutChecksum.charAt(i).getNumericValue
          if (isSecond) { 
            digit = digit * 2
            if (digit > 9) {
              digit = digit - 9 
            }
          }
          sum += digit
          isSecond = !isSecond
        }
        (10 - (sum % 10)) % 10 == checksum
  }    
}
