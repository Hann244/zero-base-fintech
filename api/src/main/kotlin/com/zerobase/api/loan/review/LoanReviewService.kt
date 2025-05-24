package com.zerobase.api.loan.review

import com.zerobase.domain.domain.LoanReview

interface LoanReviewService {
    fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewResponseDto
    
    // 대출 결과를 가지고 옴
    fun getLoanResult(userKey: String) : LoanReview?
}