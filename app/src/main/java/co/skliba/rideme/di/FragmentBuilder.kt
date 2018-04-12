package co.skliba.rideme.di

import co.skliba.rideme.ui.dashboard.current_ride.CurrentRideFragment
import co.skliba.rideme.ui.dashboard.current_ride.CurrentRideModule
import co.skliba.rideme.ui.dashboard.previous_rides.PreviousRidesFragment
import co.skliba.rideme.ui.dashboard.previous_rides.PreviousRidesModule
import co.skliba.rideme.ui.dashboard.settings.SettingsFragment
import co.skliba.rideme.ui.dashboard.settings.SettingsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = arrayOf(CurrentRideModule::class))
    abstract fun provideCurrentRideFragment(): CurrentRideFragment

    @ContributesAndroidInjector(modules = arrayOf(PreviousRidesModule::class))
    abstract fun providePreviousRidesFragment(): PreviousRidesFragment

    @ContributesAndroidInjector(modules = arrayOf(SettingsModule::class))
    abstract fun provideSettingsFragment(): SettingsFragment
}