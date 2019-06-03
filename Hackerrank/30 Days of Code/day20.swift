import Foundation

// read the integer n
let n = Int(readLine()!)!

// read the array
var arr = readLine()!.components(separatedBy: " ").map{ Int($0)! }

var swaps = 0
var sortedAboveIndex = arr.count
repeat {
    var lastSwapIndex = 0
    
    for i in 1..<sortedAboveIndex {
        if (arr[i - 1]) > (arr[i]) {
            arr.swapAt(i, i-1)
            lastSwapIndex = i
            swaps += 1
        }
    }
    
    sortedAboveIndex = lastSwapIndex
    
} while (sortedAboveIndex != 0)
print("Array is sorted in \(swaps) swaps.")
print("First Element: \(arr[0])")
print("Last Element: \(arr[arr.count-1])")
