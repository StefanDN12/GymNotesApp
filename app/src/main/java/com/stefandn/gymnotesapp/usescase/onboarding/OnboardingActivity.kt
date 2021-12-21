package com.stefandn.gymnotesapp.usescase.onboarding

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.stefandn.gymnotesapp.R
import com.stefandn.gymnotesapp.databinding.ActivityOnboardingBinding
import com.stefandn.gymnotesapp.usescase.home.HomeActivity
import com.stefandn.gymnotesapp.usescase.onboarding.pages.OnboardingAdapter


class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    private lateinit var viewModel: OnboardingViewModel

    private var selection = 0
    private var dots: Array<TextView?> = arrayOfNulls(0)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ViewModel
        viewModel = ViewModelProvider(this).get(OnboardingViewModel::class.java)

        localize()
        setup()
    }

    private fun localize(){
        binding.btnSiguiente.text = getText(viewModel.nextText)
        //binding.btnAnterior.text = getText(viewModel.previousText)
    }

    private fun setup() {

        // Adapter
        slider()

        //Dots
        dots(0)

        //Buttons

//        binding.btnAnterior.setOnClickListener {
//            if (selection != (viewModel.dots-1)){
//                selection--
//                dots(selection)
//            }
//        }

        binding.btnSiguiente.setOnClickListener {
            val act = Intent(this, HomeActivity::class.java)
            startActivity(act)
            finish()
        }

    }

    private fun slider(){
        binding.vwPagerOnboarding.adapter = OnboardingAdapter(this, viewModel.data)

        binding.vwPagerOnboarding.registerOnPageChangeCallback(object: OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                dots(position)

                selection = position

                //binding.btnAnterior.visibility = if(position == 0)  View.INVISIBLE else View.VISIBLE
                binding.txtDesliza.visibility = if (position == viewModel.dots-1) View.INVISIBLE else View.VISIBLE
                binding.btnSiguiente.visibility = if (position == viewModel.dots-1) View.VISIBLE else View.INVISIBLE
                binding.btnSiguiente.text = getText(if(position == viewModel.dots -1)  viewModel.understoodText else viewModel.nextText)
            }

        })
    }

    private fun dots(position: Int) {
        dots = arrayOfNulls(viewModel.dots)
        binding.linearDots.removeAllViews()

        for(index in dots.indices){
            dots[index]= TextView(this)
            dots[index]?.text = Html.fromHtml("•")
            dots[index]?.textSize = 35f
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                dots[index]?.setTextColor(getColor(if (index == position) R.color.white else R.color.black))
            }
            binding.linearDots.addView(dots[index])
        }
    }
}