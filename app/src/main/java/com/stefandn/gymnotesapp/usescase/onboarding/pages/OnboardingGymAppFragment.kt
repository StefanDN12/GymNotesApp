package com.stefandn.gymnotesapp.usescase.onboarding.pages

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.stefandn.gymnotesapp.model.Onboarding
import com.stefandn.gymnotesapp.databinding.FragmentOnboardingGymAppBinding


class OnboardingGymAppFragment : Fragment() {

    companion object{
        private const val PAGE = "PAGE"

        @JvmStatic
        fun fragment(page: Onboarding) =
            OnboardingGymAppFragment().apply {
                arguments = Bundle().apply {
                    putString(PAGE, Gson().toJson(page))
                }
            }
    }

    private var _binding: FragmentOnboardingGymAppBinding? = null
    private val binding get() = _binding!!

    private var page:Onboarding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOnboardingGymAppBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { arguments->
            page = Gson().fromJson(arguments.getString(PAGE), Onboarding::class.java)
        }

        page?.let { page->
            setup(page)
        }
    }

    fun setup(pages: Onboarding){

        context?.let { context ->


           /* val face: Typeface = Typeface.createFromAsset()

            binding.txtTitleOnboarding.typeface
            */


            binding.imgVOnboarding.setImageResource(pages.image)
            binding.txtTitleOnboarding.text = context.getString(pages.title)
            binding.txtBodyOnboarding.text = context.getString(pages.body)
        }


    }
}