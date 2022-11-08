package xyz.myachin.yaf.tools.file

import android.net.Uri
import androidx.core.net.toUri
import xyz.myachin.yaf.core.os.TOs
import java.io.File
import java.security.MessageDigest
import java.util.*
import kotlin.random.Random

/** Класс для взаимодействия с файлами */
class TFile {
    private fun ByteArray.toHex(): String = joinToString("") { bt -> "%02x".format(bt) }

    /** Создаёт файл размера [size] в байтах. Имя генерируется из текущего таймстампа с добавлением [ext]
     * @return [Uri] созданного файла */
    fun createWithSize(size: Int, ext: String = ".tmp"): Uri {
        TOs.TAppContext.contentResolver.let { resolver ->
            val outFile = File(TOs.TAppContext.externalCacheDir, "${Date().time}$ext").toUri()
            resolver.openOutputStream(outFile)?.use { os ->
                val bytes = Random.Default.nextBytes(ByteArray(size))
                os.write(bytes)
                return outFile
            }
        }
        throw AssertionError("Fail to create file")
    }

    /** Расчёт SHA-256 хеша для файла по заданному [uri]
     * @return hex хеша в текстовом представлении */
    fun getFileSha256(uri: Uri): String {
        val sha256 = MessageDigest.getInstance("SHA-256")

        TOs.TAppContext.contentResolver.let { cr ->
            cr.openInputStream(uri)?.use { inputStream -> // лучше упаду тут
                sha256.update(inputStream.readBytes())
                return sha256.digest().toHex()
            }
        }
        throw AssertionError("Cannot calculate hash for URI")
    }
}