class Solution {
    fun zeroFilledSubarray(nums: IntArray): Long {
        val zeroSubarrays = mutableListOf<Long>()
        var count: Long = 0
        nums.forEach {
            if(it == 0){
                count += 1
            }
            else{
                if(count != 0L){
                    zeroSubarrays.add(count)
                    count = 0
                }
            }
        }
        if(count != 0L){
            zeroSubarrays.add(count)
        }

        return zeroSubarrays.fold(0L) {acc, i -> acc + i*(i+1)/2}
    }
}