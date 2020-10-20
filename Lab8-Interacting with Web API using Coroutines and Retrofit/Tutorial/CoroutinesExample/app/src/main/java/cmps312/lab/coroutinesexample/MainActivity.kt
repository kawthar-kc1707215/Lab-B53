package cmps312.lab.coroutinesexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //you have created a small worker that is not on the main thread

          CoroutineScope(Dispatchers.Default).launch {
                    repeat(10000) {
                        val imgeId = resources.getIdentifier("jump${it % 12 + 1}", "drawable", packageName)
                        jumpImg.setImageResource(imgeId)
                        Log.d(TAG, "jump: ")
                    }

          }
    }

    override fun onPause() {
        finish()
        super.onPause()
    }

    suspend fun jump3() {
        repeat(10000) {
            val imgeId = resources.getIdentifier("jump${it % 12 + 1}", "drawable", packageName)
            jumpImg.setImageResource(imgeId)
            Log.d(TAG, "jump: ")
        }
    }

    //they can change context
    suspend fun jump()= withContext(Dispatchers.Default) {
        repeat(1000) {
            val imgeId = resources.getIdentifier("jump${it % 12 + 1}", "drawable", packageName)

            jumpImg.setImageResource(imgeId)

            Log.d(TAG, "jump: ")

        }
    }

    suspend fun run() = withContext(Dispatchers.IO) {
        repeat(1000) {
            val imgeId = resources.getIdentifier("run${it % 8 + 1}", "drawable", packageName)
            //UI update
            withContext(Dispatchers.Main) {
                runImg.setImageResource(imgeId)
            }
//            delay(100)
            Log.d(TAG, "run: ")
        }
    }

    suspend fun playDead() = withContext(Dispatchers.IO) {
        repeat(1000) {
            val imgeId = resources.getIdentifier("dead${it % 8 + 1}", "drawable", packageName)
            //UI update
            withContext(Dispatchers.Main) {
                deadImg.setImageResource(imgeId)
            }
            Log.d(TAG, "playDead: ")
        }
    }
}


/*
 val imageID = resources.getIdentifier("nameOfImage", "drawable", packageName)
 */