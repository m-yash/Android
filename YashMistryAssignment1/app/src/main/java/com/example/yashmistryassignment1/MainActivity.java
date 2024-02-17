//package com.example.yashmistryassignment1;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.DatePickerDialog;
//import android.os.Bundle;
//import android.text.InputType;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.DatePicker;
//import android.widget.RadioGroup;
//import android.widget.Toast;
//
//import com.google.android.material.snackbar.Snackbar;
//
//import java.util.Calendar;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}

package com.example.yashmistryassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.yashmistryassignment1.databinding.ActivityMainBinding;

import com.example.yashmistryassignment1.models.HostingCost;
import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener, View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    // Variable initialization
    double beverageCost = 0;

    double additionalCost = 0;
    double milkCost = 0;
    double sugarCost = 0;

    double beverageSizeCost = 0;

    String addedFlavouring;
    double addedFlavouringCost = 0;

    double totalCost = 0;

    double planCost = 0;
//    double additionalCost = 0;
    double dbCost = 0;
    double stagingCost = 0;
    String webSpace;
//    double webSpaceCost = 0;
    String province;
//    double totalCost = 0;

    // object initialization
    ActivityMainBinding binding;

    DatePickerDialog datePicker;

    HostingCost hCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // types of beverage radio-button default value
        binding.rdCoffee.setChecked(true);
        binding.rdTea.setChecked(false);

        // size of beverage radio-button default value
        binding.rdSmall.setChecked(false);
        binding.rdMedium.setChecked(false);
        binding.rdLarge.setChecked(false);

        // Array Adapter to fetch the items from an coffee and tea array
        ArrayAdapter<CharSequence> coffeeAdapterSpace = ArrayAdapter.createFromResource(this, R.array.coffee_flavouring_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        // binding adapter to added flavouring spinner
        binding.spnAddedFlavour.setAdapter(coffeeAdapterSpace);

        // select region
        binding.acSelectRegion.setThreshold(2);
        ArrayAdapter<CharSequence> adapterSelectRegion = ArrayAdapter.createFromResource(this,R.array.region_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        binding.acSelectRegion.setAdapter(adapterSelectRegion);

        // disabling keyboard
        binding.edtDate.setInputType(InputType.TYPE_NULL);

        setListeners();
    }

    // web space (spinner)
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        addedFlavouring =binding.spnAddedFlavour.getItemAtPosition(i).toString();
        Toast.makeText (getApplicationContext(),addedFlavouring, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    // Events
    private void setListeners() {
        // type of beverage radio
        binding.rgSizeOfBeverage.setOnCheckedChangeListener(this);

        // Additionals radio
        binding.chkMilk.setOnClickListener(this);
        binding.chkSugar.setOnClickListener(this);

        // size of beverage radio
        binding.rgTypeOfBeverage.setOnCheckedChangeListener(this);

        // added flavour spinner
        binding.spnAddedFlavour.setOnItemSelectedListener(this);

        // Select region auto-complete
        binding.acSelectRegion.setOnItemClickListener(this);

        // Store spinner
        binding.spnStore.setOnItemSelectedListener(this);



//        binding.rgHostingPlan.setOnCheckedChangeListener(this);




        binding.edtDate.setOnClickListener(this);
        binding.btnSubmit.setOnClickListener(this);
    }

    // region (auto-complete)
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        addedFlavouring=parent.getItemAtPosition (position). toString();
        Toast.makeText (getApplicationContext(), addedFlavouring, Toast. LENGTH_LONG) .show();
    }

    @Override
    public void onClick(View v) {
        // Additional milk/sugar (check-box)
        if(v.getId() == binding.chkMilk.getId()){
            if(binding.chkMilk.isChecked()) {
                milkCost = 1.25;
            }
            else{
                milkCost = 0;
            }
        } else if (v.getId() == R.id.chkSugar) {
            if (binding.chkSugar.isChecked()) {
                sugarCost = 1;
            } else {
                sugarCost = 0;
            }
        } else if (v.getId() == R.id.edtDate) {
            // date picker
            Calendar cal = Calendar.getInstance();
            int dayofSales= cal.get(Calendar.DAY_OF_MONTH);
            int monthofSales =cal.get(Calendar.MONTH);
            int yearofSales = cal.get(Calendar. YEAR);
            datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                // formatting date
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    binding.edtDate.setText(day+"/"+(month+1)+"/"+year);
                }
            }, yearofSales, monthofSales, dayofSales);
            datePicker.show();
        } else if (v.getId() == R.id.btnSubmit){
            // validating required fields
//            if (formValidated()){
//                // displaying result
//                hCost = new HostingCost(binding.edtName.getText().toString(), province, webSpace, binding.edtDate.getText().toString(), dbCost, stagingCost, planCost);
//                String result = hCost.getHostingCost();
//
//                // Snackbar
//                Snackbar.make(binding.ltHost, result, Snackbar.LENGTH_INDEFINITE)
//                        .setAction("Okay", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                Toast.makeText(getApplicationContext(), "Thanks you for using this application", Toast.LENGTH_LONG).show();
//                            }
//                        }).show();
//            }

            // displaying result
//            hCost = new HostingCost(binding.edtName.getText().toString(), province, webSpace, binding.edtDate.getText().toString(), dbCost, stagingCost, planCost);

            hCost = new HostingCost(binding.edtName.getText().toString(), province, webSpace, binding.edtDate.getText().toString(), dbCost, stagingCost, planCost);
            String result = hCost.getHostingCost();

            // Snackbar
            Snackbar.make(binding.ltHost, result, Snackbar.LENGTH_INDEFINITE)
                    .setAction("Okay", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(), "Thanks you for using this application", Toast.LENGTH_LONG).show();
                        }
                    }).show();

        }
    }

    // type of beverage (radio-button)
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        // for Coffee/Tea radio-button
        if (binding.rgTypeOfBeverage.getCheckedRadioButtonId() == R.id.rdCoffee) {
            beverageCost = 0;

            // binding adapter to added flavouring spinner
            ArrayAdapter<CharSequence> coffeeAdapterSpace = ArrayAdapter.createFromResource(this, R.array.coffee_flavouring_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
            binding.spnAddedFlavour.setAdapter(coffeeAdapterSpace);

        } else if (binding.rgTypeOfBeverage.getCheckedRadioButtonId() == R.id.rdTea) {
            beverageCost = 0;

            // binding tea array to added flavour spinner
            ArrayAdapter<CharSequence> teaAdapterSpace = ArrayAdapter.createFromResource(this, R.array.tea_flavouring_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
            binding.spnAddedFlavour.setAdapter(teaAdapterSpace);
        }
        // setting beverage size prices - small, medium, large
        else if (binding.rgSizeOfBeverage.getCheckedRadioButtonId() == R.id.rdSmall) {
            if (binding.rgTypeOfBeverage.getCheckedRadioButtonId() == R.id.rdCoffee){
                beverageSizeCost = 1.75;
            } else {
                beverageSizeCost = 1.50;
            }
        } else if (binding.rgSizeOfBeverage.getCheckedRadioButtonId() == R.id.rdMedium) {
            if (binding.rgTypeOfBeverage.getCheckedRadioButtonId() == R.id.rdCoffee){
                beverageSizeCost = 2.75;
            } else {
                beverageSizeCost = 2.50;
            }
        } else if (binding.rgSizeOfBeverage.getCheckedRadioButtonId() == R.id.rdLarge) {
            if (binding.rgTypeOfBeverage.getCheckedRadioButtonId() == R.id.rdCoffee){
                beverageSizeCost = 3.75;
            } else {
                beverageSizeCost = 3.25;
            }
        } else {
            beverageCost = 0;
        }
    }

    // Form validation
//    private  boolean formValidated(){
//        if (binding.edtName.length() == 0){
//            binding.edtName.setError("This field is required");
//            return false;
//        }
//        if (!binding.rdStartUp.isChecked() && !binding.rdGrowBig.isChecked() && !binding.rdPremium.isChecked()){
//            Toast.makeText(getApplicationContext(), "Select a hosting plan", Toast.LENGTH_LONG).show();
//            binding.rdStartUp.setError("Select at least one");
//            binding.rdGrowBig.setError("Select at least one");
//            binding.rdPremium.setError("Select at least one");
//            return false;
//        }  else {
//            // clearing error when at least one radio button is checked
//            binding.rdStartUp.setError(null);
//            binding.rdGrowBig.setError(null);
//            binding.rdPremium.setError(null);
//        }
//        if (binding.acProvince.length() == 0){
//            binding.acProvince.setError("This field is required");
//            return false;
//        }
//        if (binding.edtDate.length() == 0){
//            binding.edtDate.setError("This field is required");
//            return false;
//        } else {
//            binding.edtDate.setError(null);
//        }
//
//        return true;
//    }
}