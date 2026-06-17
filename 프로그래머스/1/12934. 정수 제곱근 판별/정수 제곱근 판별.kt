import kotlin.math.*

class Solution {
    fun solution(n: Long): Long {
        var answer: Long = -1
        
        val sqrtN = sqrt(n.toDouble()).toLong()
        
        if (sqrtN * sqrtN == n) {
            return (sqrtN + 1) * (sqrtN + 1)
        } 
        
        return answer
    }
}