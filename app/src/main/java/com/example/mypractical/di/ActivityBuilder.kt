package com.example.mypractical.di

import com.example.mypractical.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Helps to generate an {@link AndroidInjector} for all activities
 * */
@Suppress("unused")
@Module
abstract class ActivityBuilder {

    /**
     * fun to bind Main Activity, making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun bindCurrencyListActivity() : MainActivity


//    /**
//     * fun to bind Details Activity, making Injection enable
//     **/
//    @ContributesAndroidInjector()
//    abstract fun bindDetails() : DetailsActivity

}