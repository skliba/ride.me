package co.skliba.rideme.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.design.widget.BaseTransientBottomBar.LENGTH_SHORT
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import co.skliba.rideme.R
import co.skliba.rideme.data.types.SnackbarType
import co.skliba.rideme.data.types.SnackbarType.ERROR
import co.skliba.rideme.data.types.SnackbarType.NORMAL
import co.skliba.rideme.extensions.getColorCompat
import co.skliba.rideme.extensions.hide
import co.skliba.rideme.extensions.visible
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity(), BaseView {

    @get:LayoutRes protected abstract val layoutResourceId: Int
    private lateinit var presenter: BasePresenter<BaseView>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutResourceId)
        presenter = providePresenter()
    }

    abstract fun providePresenter(): BasePresenter<BaseView>

    override fun showProgress() {
        findViewById<View>(R.id.loadingIndicator).visible()
    }

    override fun hideProgress() {
        findViewById<View>(R.id.loadingIndicator).hide()
    }

    override fun showError(text: String) {
        showSnackbar(text, type = ERROR)
    }

    private fun showSnackbar(text: String, type: SnackbarType = NORMAL, @StringRes actionText: Int? = null, callback: (() -> Unit)? = null,
        actionCallback: (() -> Unit)? = null) {

        val content: View = findViewById(R.id.coordinator) ?: findViewById(android.R.id.content)
        val snackbar = Snackbar.make(content, text, LENGTH_SHORT)

        if (callback != null) {
            val snackCallback = object : Snackbar.Callback() {
                override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                    if (!isFinishing)
                        callback()
                }
            }
            snackbar.addCallback(snackCallback)
        }

        if (actionCallback != null && actionText != null)
            snackbar.setAction(actionText, {
                if (!isFinishing)
                    actionCallback()
            })

        if (type == ERROR) {
            snackbar.view.setBackgroundColor(getColorCompat(R.color.red))
        }

        if (type == SnackbarType.NORMAL) {
            snackbar.view.setBackgroundColor(getColorCompat(R.color.white))
            val snackbarText = snackbar.view.findViewById<TextView>(R.id.snackbar_text)
            snackbarText.setTextColor(getColorCompat(R.color.colorAccent))
            snackbarText.text = text
        }

        snackbar.show()
    }
}
