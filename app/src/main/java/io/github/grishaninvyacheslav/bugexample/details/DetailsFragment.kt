package io.github.grishaninvyacheslav.bugexample.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import io.github.grishaninvyacheslav.bugexample.BackButtonListener
import io.github.grishaninvyacheslav.bugexample.databinding.FragmentDetailsBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class DetailsFragment : MvpAppCompatFragment(), DetailsView, BackButtonListener {
    private val view: FragmentDetailsBinding by viewBinding(createMethod = CreateMethod.INFLATE)

    private val presenter: DetailsPresenter by moxyPresenter {
        DetailsPresenter()
    }

    companion object {
        fun newInstance() = DetailsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = view.apply {
        backButton.setOnClickListener { presenter.backPressed() }
    }.root

    override fun backPressed() = presenter.backPressed()
}