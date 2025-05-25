package com.zerobase.css.service

import com.zerobase.css.dto.LoanRequestDto
import com.zerobase.css.dto.LoanResultDto
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class LoanReviewService {
    fun loanReview(loanRequestDto: LoanRequestDto.RequestInputDto): LoanResultDto.ResponseDto {
        // 실제 CB사에서 이렇게 단순하게 주지는 않음. 리턴값을 주기 위한 예시.
        if (loanRequestDto.userIncomeAmount < 0) throw RuntimeException("Invalid userIncomeAmount Param")
        if (loanRequestDto.userIncomeAmount < 10000000) return LoanResultDto.ResponseDto(loanRequestDto.userKey, 0.0, 10000000)
        if (loanRequestDto.userIncomeAmount < 20000000) return LoanResultDto.ResponseDto(loanRequestDto.userKey, 10.0, 20000000)
        if (loanRequestDto.userIncomeAmount < 30000000) return LoanResultDto.ResponseDto(loanRequestDto.userKey, 9.0, 30000000)
        if (loanRequestDto.userIncomeAmount < 40000000) return LoanResultDto.ResponseDto(loanRequestDto.userKey, 8.0, 40000000)
        if (loanRequestDto.userIncomeAmount < 50000000) return LoanResultDto.ResponseDto(loanRequestDto.userKey, 7.0, 50000000)
        if (loanRequestDto.userIncomeAmount >= 50000000) return LoanResultDto.ResponseDto(loanRequestDto.userKey, 6.0, 60000000)
        throw RuntimeException("Invalid userIncomeAmount Param")
    }
}