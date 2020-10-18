package com.gzeinnumer.androidjetpackroomkt.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.gzeinnumer.androidjetpackroomkt.model.SampleTable

@Dao
interface SampleTableDao {
    @Query("SELECT * FROM sample_table")
    fun getAll(): List<SampleTable>

    @Insert
    fun insertAll(vararg sampleTables: SampleTable)

    @Delete
    fun delete(sampleTable: SampleTable)
}