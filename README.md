# AndroidJetpackRoom
 Room database like SQLLite

- [Room](https://developer.android.com/training/data-storage/room)
- [Kapt](https://github.com/gzeinnumer/KaptExample)

Start Room
- Add dependencies
```gradle
def room_version = "2.2.5"
implementation "android.arch.persistence.room:runtime:$room_version"
annotationProcessor "android.arch.persistence.room:compiler:$room_version"
```

- SampleTable
```kotlin
@Entity(tableName = "sample_table")
class SampleTable(
    @field:PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String
)
```

- SampleTableDao
```kotlin
@Dao
interface SampleTableDao {
    @Query("SELECT * FROM sample_table")
    fun getAll(): List<SampleTable>

    @Insert
    fun insertAll(vararg sampleTables: SampleTable)

    @Delete
    fun delete(sampleTable: SampleTable)
}
```

- AppDatabase
```kotlin
@Database(entities = [SampleTable::class], version = 3)
abstract class AppDatabase : RoomDatabase() {

    abstract fun sampleTableDao(): SampleTableDao

    companion object {

        private val TAG = "AppDatabase"
        private val dbName = "ExternalBase64Md5ToZip.db"

        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java,dbName)
                .setJournalMode(JournalMode.TRUNCATE)
                .allowMainThreadQueries()
                .build()
        }
    }
}
```

---

```
Copyright 2020 M. Fadli Zein
```


