class Solution {
    fun bestHand(ranks: IntArray, suits: CharArray): String {
        if(suits.toSet().size == 1){
            return "Flush"
        }

        val countRanksMap: MutableMap<Int, Int> = mutableMapOf()
        ranks.forEach{
                rank -> countRanksMap.put(rank, countRanksMap.getOrDefault(rank, 0) + 1)
        }

        return mapOf(
            2 to "Pair",
            3 to "Three of a Kind",
            4 to "Three of a Kind"
        ).getOrDefault(countRanksMap.values.max() ?: 0, "High Card")
        // LeetCode가 maxOrNull 함수를 인식하지 못해서 deprecated된 max 함수 사용
        // ).getOrDefault(countRanksMap.values.maxOrNull() ?: 0, "High Card")
    }
}