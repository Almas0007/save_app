package kz.iitu.umutpa.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import kz.iitu.umutpa.R
import kz.iitu.umutpa.dashboard.Attempt_Quiz_Section.Create_Test.CreateTestActivity
import kz.iitu.umutpa.dashboard.Attempt_Quiz_Section.TestsActivity
import kz.iitu.umutpa.dashboard.appointment.AppointmentActivity
import kz.iitu.umutpa.dashboard.identify.IdentifyActivity
import kz.iitu.umutpa.dashboard.locations.LocationActivity
import kz.iitu.umutpa.dashboard.medicine.MedicineActivity
import kz.iitu.umutpa.dashboard.result.ResultActivity
import kz.iitu.umutpa.dashboard.support.SupportActivity
import kz.iitu.umutpa.dashboard.todo.TodoActivity


class DashbaordFragment : Fragment() {

    private var user = FirebaseAuth.getInstance().currentUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_dashbaord, container, false)

        //IdentifyPeople :: 1st Card
        rootView.findViewById<CardView>(R.id.card_identify).setOnClickListener {
            startActivity(Intent(activity, IdentifyActivity::class.java))
        }

        //ImportantLocations :: 2nd Card
        rootView.findViewById<CardView>(R.id.card_location).setOnClickListener {
            startActivity(Intent(activity, LocationActivity::class.java))
        }

        //ToDos :: 3rd Card
        rootView.findViewById<CardView>(R.id.card_todo).setOnClickListener {
            startActivity(Intent(activity, TodoActivity::class.java))
        }

        //AttemptTest :: 4th Card
        rootView.findViewById<CardView>(R.id.card_training).setOnClickListener {
            startActivity(Intent(activity, TestsActivity::class.java))
        }
        //Medicines :: 5th Card
        rootView.findViewById<CardView>(R.id.card_medicine).setOnClickListener {
            startActivity(Intent(activity, MedicineActivity::class.java))
        }

        //AppointmentView :: 6th Card
        rootView.findViewById<CardView>(R.id.card_appointment).setOnClickListener {
            startActivity(Intent(activity, AppointmentActivity::class.java))
        }

        //ResultAnalysis :: 7th Card
        rootView.findViewById<CardView>(R.id.card_result).setOnClickListener {
            startActivity(Intent(activity, ResultActivity::class.java))
        }

        //SupportAndAddData :: 8th Card
        rootView.findViewById<CardView>(R.id.card_support).setOnClickListener {
            startActivity(Intent(activity, SupportActivity::class.java))
        }

        //making only one admin
        if (user?.email.equals("skishan781@gmail.com")) {
            rootView.findViewById<ExtendedFloatingActionButton>(R.id.addTest).visibility =
                View.VISIBLE
        }
        //Creating Test
        rootView.findViewById<ExtendedFloatingActionButton>(R.id.addTest).setOnClickListener {
            startActivity(Intent(activity, CreateTestActivity::class.java))
        }
        return rootView
    }

}