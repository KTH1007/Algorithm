class Solution {
    fun solution(n: Int): Int {
        var answer = 0

        answer = n.toString().sumOf { it.digitToInt() }
        return answer
    }
}