

struct Printer<T> {
    /**
     *    Name: printArray
     *    Print each element of the generic array on a new line. Do not return anything.
     *    @param A generic array
     **/
    
    func printArray(array: [T]) {
        for obj in array {
            print("\(obj)")
        }
    }
}


