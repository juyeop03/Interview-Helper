package kr.hs.dgsw.juyeop.interview.controller

import kr.hs.dgsw.juyeop.interview.model.response.JsonResponse
import kr.hs.dgsw.juyeop.interview.repository.QuestionRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/question")
class QuestionController(val questionRepository: QuestionRepository) {

    @GetMapping
    fun getAllQuestion(): HashMap<String, Any> {
        return JsonResponse().returnJsonResponse("200", "전체 면접 질문 조회를 정상적으로 수행하였습니다.", questionRepository.findAll())
    }

    @RequestMapping(path = ["/{idx}"], method = [RequestMethod.GET])
    fun getQuestionByIdx(@PathVariable("idx") questionIdx: Int): HashMap<String, Any> {
        try {
            val target = questionRepository.findById(questionIdx).get()
            return JsonResponse().returnJsonResponse("200", "특정 면접 질문 조회를 정상적으로 수행하였습니다.", target)
        } catch (e : NoSuchElementException) {
            return JsonResponse().returnJsonResponse("404", "존재하지 않는 면접 질문입니다.", Unit)
        }
    }
}