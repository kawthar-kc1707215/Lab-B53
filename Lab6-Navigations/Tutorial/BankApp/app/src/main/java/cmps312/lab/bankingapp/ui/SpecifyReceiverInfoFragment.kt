package cmps312.lab.bankingapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import cmps312.lab.bankingapp.R
import kotlinx.android.synthetic.main.fragment_specify_receiver_info.view.*


class SpecifyReceiverInfoFragment : Fragment() {

    private val args : SpecifyReceiverInfoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView =  inflater.inflate(R.layout.fragment_specify_receiver_info, container, false)

        val transaction = args.transaction

        rootView.apply {

            val action = SpecifyReceiverInfoFragmentDirections
                .actionSpecifyReceiverInfoFragmentToConfirmationFragment(transaction)

            nextBtn.setOnClickListener {
                transaction.receiverName  = recieverNameEdt.text.toString()
                transaction.receiverAccountNo = recieverAccountNoEdt.text.toString()
                Navigation.findNavController(rootView).navigate(action)
            }

            cancelBtn.setOnClickListener {
                activity?.onBackPressed()
            }
        }


        return rootView
    }

}