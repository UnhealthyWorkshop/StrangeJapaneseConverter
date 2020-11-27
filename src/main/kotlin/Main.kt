import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File

class Main {
    companion object {
        lateinit var rJson: String
        lateinit var stMap: HashMap<String, String>

        @JvmStatic
        fun main(args: Array<String>){
            rJson = File("./src/main/resources/StrangeTable.json").readText()

            //println(convert(args[0]))
            println(convert("怪しい"))
        }

        fun convert(str: String): String {
            val buffer = StringBuffer()

            stMap = jacksonObjectMapper().readValue<StrangeTable>(rJson).list

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
}

data class StrangeTable(val list: HashMap<String, String>)