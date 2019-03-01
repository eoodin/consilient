package guitest

import org.opencv.core.CvType
import org.opencv.core.Mat


class App {
    companion object Factory {
        init {
            nu.pattern.OpenCV.loadShared();
        }
    }

    val greeting: String
        get() {
            val mat = Mat.eye(3, 3, CvType.CV_8UC1)
            println("mat = " + mat.dump())
            return "Hello world."
        }
}

fun main(args: Array<String>) {
    println(App().greeting)
}
