package com.amrita.affirmaionsapp.data

import com.amrita.affirmaionsapp.R
import com.amrita.affirmaionsapp.model.Affirmations

class DataSource {
    fun loadAffirmations():List<Affirmations>{
        return listOf<Affirmations>(
            Affirmations(R.string.affirmation1 ,R.drawable.image1),
            Affirmations(R.string.affirmation2,R.drawable.image2),
            Affirmations(R.string.affirmation3,R.drawable.image3),
            Affirmations(R.string.affirmation4,R.drawable.image4),
            Affirmations(R.string.affirmation5,R.drawable.image5),
            Affirmations(R.string.affirmation6,R.drawable.image6),
            Affirmations(R.string.affirmation7,R.drawable.image7),
            Affirmations(R.string.affirmation8,R.drawable.image8),
            Affirmations(R.string.affirmation9,R.drawable.image9),
            Affirmations(R.string.affirmation10,R.drawable.image10)
        )
    }
}