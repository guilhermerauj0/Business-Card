package com.araujo.businesscard.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.IDN

@Entity
data class BusinessCard(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val enterprise: String,
    val phone: String,
    val email: String,
    val background: String
)
