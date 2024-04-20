package uz.gita.pictureeditor

import android.os.Bundle
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import uz.gita.pictureeditor.databinding.ActivityMainBinding
import uz.gita.pictureeditor.screens.EditScreen
import uz.gita.pictureeditor.screens.PhotoScreen

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            if (uri != null) {
                supportFragmentManager.beginTransaction()
                    .addToBackStack(EditScreen::class.java.toString())
                    .replace(R.id.container, EditScreen::class.java, bundleOf(Pair("URI", uri.toString())))
                    .commit()
            }
        }

        binding.openCamera.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .addToBackStack(PhotoScreen::class.java.toString())
                .replace(R.id.container, PhotoScreen::class.java, bundleOf())
                .commit()
        }

        binding.openGallery.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
    }
}

