

// Start of class Calculator
class Calculator {
    // Start of function power
    func power(n: Int, p: Int) throws -> Int {
        // Add your code here
        if n < 0 || p < 0 {
            throw RangeError.NotInRange("n and p should be non-negative")
        }
        return Int(pow(Double(n), Double(p)))
    } // End of function power
} // End of class Calculator


