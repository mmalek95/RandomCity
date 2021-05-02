package com.malek.data.models.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RandomCityEntity(
    @ColumnInfo val name: String?,
    @ColumnInfo val color: String?,
    @ColumnInfo val creationTimeStampInMillis: Long,
    @PrimaryKey(autoGenerate = true) val dbId: Long
)