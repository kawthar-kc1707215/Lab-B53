package cmps312.lab.beneficiaryreview.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cmps312.lab.beneficiaryreview.R

class BeneficiaryListFragment : Fragment(R.layout.fragment_beneficiary_list) {

    override fun onCreateView( view: View, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beneficiary_list, container, false)
    }
    }