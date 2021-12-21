package com.stefandn.gymnotesapp.usescase.base

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

interface BaseRouter {

    fun intent(activity:Context): Intent
    fun activity(activity: Context) = activity.startActivity(intent(activity))
}

interface BaseFragmenRouter{

    //Fragment

    fun fragment(): Fragment

    fun add(manager: FragmentManager, containerId: Int, tag:String) = manager.beginTransaction().add(containerId,fragment(),tag).commitAllowingStateLoss()

    fun replace(manager: FragmentManager, containerId: Int) = manager.beginTransaction().replace(containerId,fragment()).commit()

    fun show(manager: FragmentManager) = manager.beginTransaction().show(fragment()).commitAllowingStateLoss()

    fun hide(manager: FragmentManager) = manager.beginTransaction().hide(fragment()).commitAllowingStateLoss()

    fun remove(manager: FragmentManager) = manager.beginTransaction().remove(fragment()).commitAllowingStateLoss()

}