import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.File
import java.io.IOException

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            val sjConverter = StrangeJapaneseConverter()
            //println(convert(args[0]))
            println(sjConverter.convert("怪しい"))
        }

    }
}