import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.File
import java.io.IOException
import java.lang.NullPointerException

class StrangeJapaneseConverter {
    private lateinit var rJson: String
    private var stMap: HashMap<String, String> = HashMap()

    init {
        try {
            this.rJson = File("src/main/resources/StrangeTable.json").readText()
        } catch (e: IOException) {
            e.stackTrace
        }

        jacksonObjectMapper().readValue(rJson, ArrayList<HashMap<String, String>>().javaClass)?.forEach { it ->
            this.stMap[it["before"] ?: ""] = it["after"] ?: ""
        }

    }

    fun convert(str: String): String {
        val buffer = StringBuffer()

        for (c in str) {
            val match = this.stMap[c.toString()]
            if (match != null) {
                buffer.append(match)
            } else {
                buffer.append(c)
            }
        }

        return buffer.toString()
    }
}