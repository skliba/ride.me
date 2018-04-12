package co.skliba.rideme.di

import co.skliba.rideme.ui.dashboard.DashboardActivity
import co.skliba.rideme.ui.dashboard.DashboardModule
import co.skliba.rideme.ui.splash.SplashActivity
import co.skliba.rideme.ui.splash.SplashModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(SplashModule::class))
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = arrayOf(DashboardModule::class))
    abstract fun bindDAshboardActivity(): DashboardActivity
}