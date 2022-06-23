package kg.geektech.homework6g45

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.geektech.homework6g45.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count = 0
    private var switch = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            when (switch) {
                true -> {
                    if (count != 10) {
                        count++
                        binding.count.text = count.toString()
                    } else {
                        switch = false
                        count--
                        binding.count.text = count.toString()
                    }
                }
                false -> {
                    if (count != 0) {
                        count--
                        binding.count.text = count.toString()
                    } else {
                        val intent = Intent(this, SecondActivity::class.java)
                        startActivity(intent)
                    }
                    if (count == 0 && !switch) binding.button.text = "Open Second Activity"
                }
            }
        }


    }
}