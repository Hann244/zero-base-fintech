package com.zerobase.com.zerobase.consumer.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = ["com.zerobase.domain"])
class JpaAuditingConfiguration