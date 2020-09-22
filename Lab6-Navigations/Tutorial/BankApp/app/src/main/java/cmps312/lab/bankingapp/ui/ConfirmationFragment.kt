package cmps312.lab.bankingapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import cmps312.lab.bankingapp.R
import kotlinx.android.synthetic.main.fragment_confirmation.view.*


class ConfirmationFragment : Fragment() {

    val args: ConfirmationFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview = inflater.inflate(R.layout.fragment_confirmation, container, false)

        val transaction = args.transaction

        rootview.apply {
            senderNameTv.text = transaction.senderName
            senderAccountNoTv.text = transaction.senderAccountNo
            amountTv.text = transaction.amount.toString()

            receiverNameTv.text = transaction.receiverName
            receiverAccountNoTv.text = transaction.receiverAccountNo

        }
        return rootview
    }

}