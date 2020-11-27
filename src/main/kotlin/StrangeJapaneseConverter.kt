import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.File
import java.io.IOException

class StrangeJapaneseConverter {
    private lateinit var rJson: String
    private var stMap: HashMap<String, Any>

    init {
        try {
            this.rJson = File("src/main/resources/StrangeTable.json").readText()
        } catch (e: IOException) {
            e.stackTrace
        }

        this.stMap = jacksonObjectMapper().readValue(rJson, HashMap<String, Any>().javaClass)

    }

    fun convert(str: String): String {
        val buffer = StringBuffer()

        for (c in str) {
            val match = stMap[c.toString()]
            if (match != null) {
                buffer.append(match)
            } else {
                buffer.append(c)
            }
        }

        return buffer.toString()
    }
}