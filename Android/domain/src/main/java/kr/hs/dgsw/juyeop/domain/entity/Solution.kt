package kr.hs.dgsw.juyeop.domain.entity

data class Solution(
    val idx: Int,
    val user_id: String,
    val question_idx: String,
    val solution_text: String?,
    val solution_audio: String?,
    val solution_video: String?,
    val solution_at: String
)