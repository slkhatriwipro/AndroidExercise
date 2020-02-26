package com.app.androidexercise.di

import com.app.androidexercise.feeds.ui.FeedsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeFeedsFragment(): FeedsFragment
}
