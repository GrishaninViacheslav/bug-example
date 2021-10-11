package io.github.grishaninvyacheslav.bugexample.master

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MasterView: MvpView {
    fun showCount(count: Int)
}