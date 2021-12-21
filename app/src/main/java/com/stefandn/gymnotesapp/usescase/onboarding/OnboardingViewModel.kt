package com.stefandn.gymnotesapp.usescase.onboarding

import androidx.lifecycle.ViewModel
import com.stefandn.gymnotesapp.R
import com.stefandn.gymnotesapp.model.Onboarding

class OnboardingViewModel: ViewModel() {

    val data = listOf(
        Onboarding(1,R.drawable.icon_gym_app,R.string.onboarding_page0_title,R.string.onboarding_page0_text),
        Onboarding(2, R.drawable.registrado, R.string.onboarding_page1_title,R.string.onboarding_page1_text),
        Onboarding(3, R.drawable.linea_grafica, R.string.onboarding_page2_title,R.string.onboarding_page2_text),
        Onboarding(4, R.drawable.fitness, R.string.onboarding_page3_title,R.string.onboarding_page3_text)
    )
    val dots = data.size


    val understoodText = R.string.btn_onboarding_entedido
    val previousText = R.string.btn_onboarding_anterior
    val nextText = R.string.btn_onboarding_siguiente

}