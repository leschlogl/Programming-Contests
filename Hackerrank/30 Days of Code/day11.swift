import Foundation

let arr: [[Int]] = AnyIterator{ readLine() }.prefix(6).map {
    let arrRow: [Int] = $0.split(separator: " ").map {
        if let arrItem = Int($0.trimmingCharacters(in: .whitespacesAndNewlines)) {
            return arrItem
        } else { fatalError("Bad input") }
    }
    
    guard arrRow.count == 6 else { fatalError("Bad input") }
    
    return arrRow
}

guard arr.count == 6 else { fatalError("Bad input") }

var maxSum = -10000
var i = 0
var j = 0

while i < 4 {
    while j < 4 {
        let a = arr[i][j]
        let b = arr[i][j+1]
        let c = arr[i][j+2]
        let d = arr[i+1][j+1]
        let e = arr[i+2][j]
        let f = arr[i+2][j+1]
        let g = arr[i+2][j+2]
        
        let sum = a+b+c+d+e+f+g
        if sum>maxSum {
            maxSum = sum
        }
        j+=1
    }
    j=0
    i+=1
}
print(maxSum)
