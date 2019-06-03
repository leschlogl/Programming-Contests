
// Write your code here
init(a: [Int]) {
    self.elements = a
    self.maximumDifference = 0
}
func computeDifference() {
    maximumDifference = 0
    for i in 0..<elements.count {
        for j in 1..<elements.count {
            let diff = abs(elements[i]-elements[j])
            if diff > maximumDifference {
                maximumDifference = diff
            }
        }
    }
}

