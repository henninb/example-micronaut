package com.example.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class TodoEntry(@Id @GeneratedValue var id: Long = 0, var text: String = "")