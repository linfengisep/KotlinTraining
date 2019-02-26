package coding.linfeng.diceroller

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import coding.linfeng.diceroller.databinding.ActivityProfileBinding

class Profile: AppCompatActivity(){
    private lateinit var binding: ActivityProfileBinding
    private var name = MyName("Lee")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_profile)
        binding.myName = name
        binding.finishBtn.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View){
        binding.apply {
            name.nickName = editNickname.text.toString()
            invalidateAll()
            editNickname.visibility = View.GONE
            displayNickname.visibility = View.VISIBLE
            finishBtn.visibility = View.GONE
        }
        //hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}