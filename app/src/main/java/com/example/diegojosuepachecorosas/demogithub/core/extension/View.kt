package com.example.diegojosuepachecorosas.demogithub.core.extension

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(@LayoutRes res:Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(res,this,attachToRoot)
}
