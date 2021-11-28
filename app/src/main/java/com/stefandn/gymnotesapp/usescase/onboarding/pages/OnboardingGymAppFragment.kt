package com.stefandn.gymnotesapp.usescase.onboarding.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stefandn.gymnotesapp.R
/**
 * A simple [Fragment] subclass.
 * Use the [OnboardingGymAppFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OnboardingGymAppFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding_gym_app, container, false)
    }
}