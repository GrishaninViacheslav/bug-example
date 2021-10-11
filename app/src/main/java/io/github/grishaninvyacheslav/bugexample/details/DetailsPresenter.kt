package io.github.grishaninvyacheslav.bugexample.details

import com.github.terrakok.cicerone.Router
import io.github.grishaninvyacheslav.bugexample.App
import io.github.grishaninvyacheslav.bugexample.master.MasterView
import moxy.MvpPresenter

class DetailsPresenter(private val router: Router = App.instance.router) : MvpPresenter<MasterView>() {
    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}