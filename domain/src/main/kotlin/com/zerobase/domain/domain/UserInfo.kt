package com.zerobase.domain.domain

import javax.persistence.*

@Entity
@Table(name = "USR_INFO")
class UserInfo (
    @Column(name = "usr_key")
    val userKey: String,

    // 주민등록번호
    @Column(name = "usr_reg_num")
    val userRegistrationNumber: String,

    // 유저명
    @Column(name = "usr_nm")
    val userName: String,

    // 유저의 소득금액
    @Column(name = "usr_icm_amt")
    val userIncomeAmount: Long
)
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null

}