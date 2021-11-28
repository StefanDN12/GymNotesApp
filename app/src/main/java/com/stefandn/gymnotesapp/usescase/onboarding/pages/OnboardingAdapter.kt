package com.stefandn.gymnotesapp.usescase.onboarding.pages

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.stefandn.gymnotesapp.model.Onboarding

class OnboardingAdapter(val context: AppCompatActivity, var pages: List<Onboarding>): FragmentStateAdapter(context) {


    override fun getItemCount(): Int = pages.size

    override fun createFragment(position: Int):Fragment {
        val page = pages[position]
        return OnboardingGymAppFragment.fragment(page)
    }
}