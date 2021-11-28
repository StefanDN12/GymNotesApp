package com.stefandn.gymnotesapp.usescase.onboarding.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.stefandn.gymnotesapp.R
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding_gym_app, container, false)
    }
}