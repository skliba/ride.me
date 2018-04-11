package co.skliba.rideme.ui.splash

import dagger.Binds
import dagger.Module

@Module
abstract class SplashModule {

    @Binds
    abstract fun bindView(view: SplashActivity): SplashView
}