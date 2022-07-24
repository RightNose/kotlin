import java.util.*

class NumberContainers() {
    val m = mutableMapOf<Int, Int>()
    val mr = mutableMapOf<Int, TreeSet<Int>>()

    fun change(index: Int, number: Int) {
        // index가 이미 있으면 mr에서 기존 키 set에서 삭제, 새로운 key set에 추가
        // index가 없으면 mr에서 새로운 key set에 추가
        if(m.containsKey(index)){
            mr[m[index]]?.remove(index)
            if(mr[m[index]]?.size == 0){
                mr.remove(m[index])
            }
        }
        mr.putIfAbsent(number, sortedSetOf(index))
        mr[number]?.add(index)
        m.put(index, number)
    }

    fun find(number: Int): Int {
        return mr.get(number)?.first() ?: -1
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * var obj = NumberContainers()
 * obj.change(index,number)
 * var param_2 = obj.find(number)
 */