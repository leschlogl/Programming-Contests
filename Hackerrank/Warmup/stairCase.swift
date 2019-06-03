import Foundation

// Complete the staircase function below.
func staircase(n: Int) -> Void {
    for i in 1..<n+1 {
        let str = String(repeating: " ", count: n-i) + String(repeating: "#", count: i)
        print(str)
    }
}

guard let n = Int((readLine()?.trimmingCharacters(in: .whitespacesAndNewlines))!)
    else { fatalError("Bad input") }

staircase(n: n)

