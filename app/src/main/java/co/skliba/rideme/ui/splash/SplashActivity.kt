package co.skliba.rideme.ui.splash

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import co.skliba.rideme.R
import co.skliba.rideme.extensions.startActivity
import co.skliba.rideme.ui.base.BaseActivity
import co.skliba.rideme.ui.base.BasePresenter
import co.skliba.rideme.ui.base.BaseView
import co.skliba.rideme.ui.dashboard.DashboardActivity
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashView {

    override fun providePresenter(): BasePresenter<BaseView> = presenter
    override val layoutResourceId: Int = R.layout.activity_splash

    @Inject lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUi()
    }

    private fun initUi() {
        logoImage.pathAnimator.duration(this.resources.getInteger(R.integer.animation_duration)).start()
        appNameText.animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_from_bottom)
        appNameText.animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {
                // Nothing here
            }

            override fun onAnimationEnd(p0: Animation?) {
                presenter.onAnimationEnd()
            }

            override fun onAnimationStart(p0: Animation?) {
                // Nothing here
            }
        })
    }

    override fun navigateToDashboard() {
        startActivity<DashboardActivity>(null)
        supportFinishAfterTransition()
    }
}