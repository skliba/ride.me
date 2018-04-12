package co.skliba.rideme

import android.app.Activity
import android.os.StrictMode
import android.support.multidex.MultiDexApplication
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatDelegate
import co.skliba.rideme.di.AppComponent
import co.skliba.rideme.di.DaggerAppComponent
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject

class RideMeApp : MultiDexApplication(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>
    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var appInstance: RideMeApp
    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this

        initVectorGraphics()
        initThreeTen()
        initDagger()
        initPolicies()
        initTimber()
    }

    private fun initVectorGraphics() = AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    private fun initThreeTen() = AndroidThreeTen.init(this)

    private fun initDagger() {
        appComponent = DaggerAppComponent
            .builder()
            .context(this)
            .build()
        appComponent.inject(this)
    }

    private fun initPolicies() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build())
            StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .detectActivityLeaks()
                .detectLeakedRegistrationObjects()
                .penaltyLog()
                .build())
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            //Timber.plant(CrashReportingTree())
        }
    }
}