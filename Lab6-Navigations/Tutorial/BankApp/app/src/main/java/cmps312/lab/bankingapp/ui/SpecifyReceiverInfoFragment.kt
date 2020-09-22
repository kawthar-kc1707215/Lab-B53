package cmps312.lab.bankingapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import cmps312.lab.bankingapp.R
import kotlinx.android.synthetic.main.fragment_specify_sender_info.view.*

class SpecifyReceiverInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView =  inflater.inflate(R.layout.fragment_specify_receiver_information, container, false)

        rootView.apply {
            nextBtn.setOnClickListener {
                Navigation.findNavController(rootView)
                    .navigate(R.id.action_specifyReceiverInfoFragment_to_confirmationFragment)
            }

            cancelBtn.setOnClickListener {

            }
        }


        return rootView
    }

}