class Solution {
    fun latestTimeCatchTheBus(buses: IntArray, passengers: IntArray, capacity: Int): Int {
        buses.sort()
        passengers.sort()
        var max = 0
        var count = 0
        var lastCount = 0
        
        for (bus in buses) {
            for(index in count..(count + capacity - 1)) {        
                try {
                    if(passengers.get(index) <= bus) {
                        if(bus == buses.last())
                            lastCount++
                        count++
                    }
                    else
                        break
                } catch (e: Exception) {
                    return findAndMakeUnique(buses.last(), passengers)
                }
            }
        }
        
        
        if(lastCount < capacity)
            max = buses.last()
        else
            max = passengers.get(count - 1) - 1
        
        return findAndMakeUnique(max, passengers)
    }
    
    fun findAndMakeUnique(value: Int, list: IntArray): Int {
        var finder = list.indexOf(value)
        if(finder == -1)
            return value
        else
            return makeUnique(value - 1, list, finder - 1)
    }
    
    fun makeUnique(value: Int, list: IntArray, baseIndex: Int): Int {
        var minus = 0
        while(baseIndex - minus >= 0) {
            if(value - minus != list.get(baseIndex - minus))
                return value - minus
            minus++
        }
        return value - minus
    }
}