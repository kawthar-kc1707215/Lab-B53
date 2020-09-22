package cmps312.lab.bankingapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import cmps312.lab.bankingapp.R
import cmps312.lab.bankingapp.model.Transaction


import kotlinx.android.synthetic.main.fragment_specify_sender_info.view.*
import kotlinx.android.synthetic.main.fragment_specify_sender_info.view.cancelBtn
import kotlinx.android.synthetic.main.fragment_specify_sender_info.view.nextBtn
import kotlinx.android.synthetic.main.fragment_specify_sender_info.view.senderNameEdt

//itemView

class SpecifySenderInfoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val rootView =  inflater.inflate(R.layout.fragment_specify_sender_info, container, false)


        rootView.apply {

            nextBtn.setOnClickListener {
                val transaction = Transaction()
                transaction.senderName  = senderNameEdt.text.toString()
                transaction.senderAccountNo = senderAccountNoEdt.text.toString()
                transaction.amount = amountEdt.text.toString().toDouble()

                val action = SpecifySenderInfoFragmentDirections
                    .actionSpecifySenderInfoFragmentToSpecifyReceiverInfoFragment(transaction)
                Navigation.findNavController(rootView).navigate(action)
            }

            cancelBtn.setOnClickListener {
                activity?.onBackPressed()
            }
        }

        return rootView
    }
}