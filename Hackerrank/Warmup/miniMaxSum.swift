import Foundation

// Complete the miniMaxSum function below.
func miniMaxSum(arr: [Int]) -> Void {
    var min = Int.max
    var max = Int.min
    
    for i in 0..<arr.count {
        let sum = arr.reduce(0, +) - arr[i]
        min = Swift.min(sum, min)
        max = Swift.max(sum, max)
    }
    print("\(min) \(max)")
}

guard let arrTemp = readLine() else { fatalError("Bad input") }
let arr: [Int] = arrTemp.split(separator: " ").map {
    if let arrItem = Int($0.trimmingCharacters(in: .whitespacesAndNewlines)) {
        return arrItem
    } else { fatalError("Bad input") }
}

guard arr.count == 5 else { fatalError("Bad input") }

miniMaxSum(arr: arr)

