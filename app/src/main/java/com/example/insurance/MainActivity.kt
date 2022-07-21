package com.example.insurance
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.insurance.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    //TODO2 : Create an instance of view binding
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO3: initialize the view binding
        binding =   ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener{
           val age = binding.spinnerAge.selectedItemPosition
            val gender = binding.radioGroupGender.checkedRadioButtonId
            val smoker = binding.checkBoxSmoker.isChecked


            var premium = 0

            premium = when(age){
                0->60
                1->70
                2->90
                3->120
                else -> 150
            }

           /* <item>Less than 17</item>
            <item>17-25</item>
            <item>26-30</item>
            <item>31-40</item>
            <item>41-55</item>
            <item>More than 55</item>*/

            if(gender == binding.radioButtonMale.id)
            {
               premium += when(age) {
                   0 -> 0
                   1 -> 50
                   2 -> 100
                   3 -> 150
                   else -> 200
               }



                /*if (age==0)
                {
                    premium == 60
                }

                else if (age == 1)
                {
                    premium == 70 + 50
                }

                else if (age == 2)
                {
                    premium == 90 + 100
                }

                else if (age == 3)
                {
                    premium == 120 + 150
                }

                else {
                    premium == 150 + 200
                }
*/


            }

            if(smoker)
            {
                premium += when(age) {
                    0 -> 0
                    1 -> 100
                    2 -> 150
                    3 -> 200
                    4 -> 250
                    else-> 300
                }
                /*
                if (age == 0)
                 premium = 0

                else if (age == 1)
                {
                    premium == 70+100
                }

                else if (age == 2)
                {
                    premium == 90 + 150
                }

                else if (age == 3)
                {
                    premium == 120 + 200
                }

                else {
                    premium == 150 + 250
                }*/

            }

            val output_premium = NumberFormat.getCurrencyInstance().format(premium)
            binding.textViewPremium.text= output_premium
        }

        binding.buttonReset.setOnClickListener{
         binding.spinnerAge.setSelection(0)
            binding.radioGroupGender.clearCheck()
            binding.checkBoxSmoker.isChecked= false
            binding.textViewPremium.text = null
        }



    }
}