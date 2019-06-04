import Foundation

// Complete the hourglassSum function below.
func hourglassSum(arr: [[Int]]) -> Int {
    var maxValue = Int.min
    for i in 1..<5 {
        for j in 1..<5 {
            let sum = getHourGlassSum(arr: arr,
                                      centerX: i,
                                      centerY:j
            )
            maxValue = max(maxValue, sum)
        }
    }
    return maxValue
}

func getHourGlassSum(arr: [[Int]], centerX: Int, centerY: Int) -> Int {
    let x = centerX
    let y = centerY
    return arr[x-1][y-1] + arr[x-1][y] + arr[x-1][y+1] +
        arr[x][y] +
        arr[x+1][y-1] + arr[x+1][y] + arr[x+1][y+1]
    
}

let stdout = ProcessInfo.processInfo.environment["OUTPUT_PATH"]!
FileManager.default.createFile(atPath: stdout, contents: nil, attributes: nil)
let fileHandle = FileHandle(forWritingAtPath: stdout)!

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

let result = hourglassSum(arr: arr)

fileHandle.write(String(result).data(using: .utf8)!)
fileHandle.write("\n".data(using: .utf8)!)
