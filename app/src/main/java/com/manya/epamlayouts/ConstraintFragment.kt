package com.manya.epamlayouts

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment1.view.*

class ConstraintFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<Flight>(DEPART_KEY)?.apply {
            with(view) {
                departDateTextView.text = date
                departSeatsTextView.text =
                    String.format(getString(R.string.freeSeats), freeSeats)
                departCostTextView.text =
                    String.format(getString(R.string.currencyBY), price)
                departTakeOffTextView.text = takeOffCity
                departLandTextView.text = landCity
                departTakeOffTimeTextView.text = takeOffTime
                departLandTimeTextView.text = landTime
                departFlightTimeTextView.text = duration
            }

            arguments?.getParcelable<Flight>(RETURN_KEY)?.apply {
                with(view) {
                    returnDateTextView.text = date
                    returnSeatsTextView.text =
                        String.format(getString(R.string.freeSeats), freeSeats)
                    returnCostTextView.text =
                        String.format(getString(R.string.currencyBY), price)
                    returnTakeOffTextView.text = takeOffCity
                    returnLandTextView.text = landCity
                    returnTakeOffTimeTextView.text = takeOffTime
                    returnLandTimeTextView.text = landTime
                    returnFlightTimeTextView.text = duration
                }

                view.doneButton.setOnClickListener {
                    Toast.makeText(
                        context,
                        "Constraint fragment",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        }
    }


    companion object {
        fun newInstance(departData: Flight, returnData : Flight) = ConstraintFragment().apply{
            arguments = Bundle().apply {
                putParcelable(DEPART_KEY,departData)
                putParcelable(RETURN_KEY, returnData)
            }
        }
        private const val DEPART_KEY = "DEPART"
        private const val RETURN_KEY = "RETURN"
    }
}