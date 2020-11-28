import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.File
import java.io.IOException
import kotlin.IllegalStateException

/**
 * 怪しい日本語変換のキモ
 *
 * 辞書としてJSONを読み込み、convert()で変換できます。
 *
 * JSON例
 * [
 *   {"before":"し", "after":"レ"},
 *   {"before":"語", "after":"语"}
 * ]
 */
class StrangeJapaneseConverter: Throwable() {
    private lateinit var rJson: String //変換前のJSONテキストを入れる
    private var stMap: HashMap<String, String> = HashMap() //変換のリスト

    init {
        /*ファイルを読み込む*/
        try {
            this.rJson = File("src/main/resources/StrangeTable.json").readText()
        } catch (e: IOException) {//ファイルが読めないときこれが呼ばれる
            System.err.println(e.stackTrace)
        }

        /*JSONのパース*/
        jacksonObjectMapper().readValue(rJson, ArrayList<HashMap<String, String>>().javaClass)?.forEach {
            val isException = IllegalStateException("不正なStrangeTable")
            val before = it["before"] ?: throw isException
            val after = it["after"] ?: throw isException

            this.stMap[before] = after
        }
    }

    /**
     * 入力文を怪しい日本語に変換します。
     *
     * @param str: String 変換元の文
     * @return String 変換後の文
     *
     */
    fun convert(str: String): String {
        val buffer = StringBuffer()

        str.toMutableList().forEach {
            buffer.append(stMap[it.toString()] ?: it)
        }

        return buffer.toString()
    }
}