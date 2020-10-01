package com.example.madlevel3task1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_rating.*

class RatingFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rating, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_rate.setOnClickListener {
            navigateToSummary()
        }

        showRandomGame()
    }

    // Setup arguments Bundle to be sent to SummaryFragment using navController
    private fun navigateToSummary() {
        val args = Bundle()
        args.putFloat(ARG_GAME_RATING, ratingBar.rating)
        args.putString(ARG_GAME_NAME, txtRandomGame.text.toString())

        findNavController().navigate(R.id.action_RatingFragment_to_SummaryFragment, args)
    }

    // Set the random game title
    private fun showRandomGame() {
        var randomGame =  listOf("Red Dead Redemption 2", "Rocket League",
            "Shadow of the Tombraider").random()

        txtRandomGame.text = randomGame
    }
}