package io.github.grishaninvyacheslav.bugexample.master

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import io.github.grishaninvyacheslav.bugexample.BackButtonListener
import io.github.grishaninvyacheslav.bugexample.databinding.FragmentMasterBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MasterFragment : MvpAppCompatFragment(), MasterView, BackButtonListener {
    private val view: FragmentMasterBinding by viewBinding(createMethod = CreateMethod.INFLATE)

    private val presenter: MasterPresenter by moxyPresenter {
        MasterPresenter()
    }

    companion object {
        fun newInstance() = MasterFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = view.apply {
        incrementCounterButton.setOnClickListener{ presenter.incrementCounter() }
        showDetailsButton.setOnClickListener{ presenter.openDetails() }
    }.root

    override fun showCount(count: Int) {
        view.counterTextView.text = "НАЖАТИЙ: $count"
        // Если вернуться на этот экран(router.exit()), то при обновлении свойств(вьюшек) FragmentMasterBinding не будет обновлять то, что отображается на экране
        Log.d("[MasterFragment]", "view.counterTextView.text: ${view.counterTextView.text}")
        Toast.makeText(context, "view.counterTextView.text: ${view.counterTextView.text}", Toast.LENGTH_LONG).show()
    }

    override fun backPressed() = presenter.backPressed()
}