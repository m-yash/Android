package com.example.yashmistryassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.yashmistryassignment1.databinding.ActivityMainBinding;

import com.example.yashmistryassignment1.models.BeverageCost;
import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener, View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    // Variable initialization

    String beverageType;
    String beverageSize;
    double beverageCost = 0;


    double milkCost = 0;
    double sugarCost = 0;

    double beverageSizeCost = 0;

    String addedFlavouring;
    double addedFlavouringCost = 0;

    String item ;
    String selectRegion;
    Object selectStore;
    double totalCost = 0;

    // object initialization
    ActivityMainBinding binding;

    DatePickerDialog datePicker;

    BeverageCost bCost;

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

        // Array Adapter to fetch the items from coffee array
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

    // displaying selected item and setting flavour cost
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        item  = binding.spnAddedFlavour.getItemAtPosition(i).toString();
        if (item.equals("Lemon")){
            addedFlavouringCost = 0.25;
        } else if (item.equals("Ginger")){
            addedFlavouringCost = 0.75;
        } else if (item.equals("Pumpkin Spice")){
            addedFlavouringCost = 0.50;
        } else if (item.equals("Chocolate")){
            addedFlavouringCost = 0.75;
        } else {
            addedFlavouringCost = 0;
        }
        Log.d("AddedFlavours", "Added Flavours: " + addedFlavouringCost);

        selectStore  = binding.spnStore.getItemAtPosition(i);
        if (selectStore != null){
            selectStore = selectStore.toString();
            Log.d("SelectedStore", "Selected Store: " + selectStore);
        } else {
            selectStore = "error";
        }

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

        binding.edtDate.setOnClickListener(this);
        binding.btnSubmit.setOnClickListener(this);
    }

    // region (auto-complete)
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectRegion =parent.getItemAtPosition (position). toString();
        Toast.makeText (getApplicationContext(), selectRegion, Toast. LENGTH_LONG) .show();

        if (selectRegion.equals("Waterloo")){
            ArrayAdapter<CharSequence> adapterSelectStore = ArrayAdapter.createFromResource(this,R.array.waterloo_region_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
            binding.spnStore.setAdapter(adapterSelectStore);
        } else if (selectRegion.equals("London")) {
            ArrayAdapter<CharSequence> adapterSelectStore = ArrayAdapter.createFromResource(this,R.array.london_region_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
            binding.spnStore.setAdapter(adapterSelectStore);
        } else if (selectRegion.equals("Milton")) {
            ArrayAdapter<CharSequence> adapterSelectStore = ArrayAdapter.createFromResource(this,R.array.milton_region_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
            binding.spnStore.setAdapter(adapterSelectStore);
        } else {
            ArrayAdapter<CharSequence> adapterSelectStore = ArrayAdapter.createFromResource(this,R.array.mississauga_region_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
            binding.spnStore.setAdapter(adapterSelectStore);
        }
        Log.d("SelectedRegion", "Select Region: " + selectRegion);
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

            // disabling future dates
            datePicker.getDatePicker().setMaxDate(cal.getTimeInMillis());

            datePicker.show();
        } else if (v.getId() == R.id.btnSubmit){
            // validating required fields
            if (formValidated()){
                // displaying result
                bCost = new BeverageCost(binding.edtName.getText().toString(), binding.edtEmail.getText().toString(), binding.edtPhoneNo.getText().toString(), selectRegion, binding.edtDate.getText().toString(), beverageType, binding.spnAddedFlavour.getSelectedItem().toString(), addedFlavouringCost, binding.spnStore.getSelectedItem().toString(), milkCost, sugarCost, beverageSizeCost, beverageSize);

                String result = bCost.getBeverageCost();

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
        Log.d("Additionals", "Additionals: " + milkCost + " " + sugarCost);
    }

    // type of beverage (radio-button)
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        // for Coffee/Tea radio-button
        if (binding.rgTypeOfBeverage.getCheckedRadioButtonId() == R.id.rdCoffee) {
            beverageCost = 0;
            beverageType = "Coffee";

            // binding adapter to added flavouring spinner
            ArrayAdapter<CharSequence> coffeeAdapterSpace = ArrayAdapter.createFromResource(this, R.array.coffee_flavouring_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
            binding.spnAddedFlavour.setAdapter(coffeeAdapterSpace);

        } else {
            beverageCost = 0;
            beverageType = "Tea";

            // binding tea array to added flavour spinner
            ArrayAdapter<CharSequence> teaAdapterSpace = ArrayAdapter.createFromResource(this, R.array.tea_flavouring_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
            binding.spnAddedFlavour.setAdapter(teaAdapterSpace);
        }
        // setting beverage size prices - small, medium, large
        if (binding.rgSizeOfBeverage.getCheckedRadioButtonId() == R.id.rdSmall) {
            beverageSize = "Small";
            if (binding.rgTypeOfBeverage.getCheckedRadioButtonId() == R.id.rdCoffee){
                beverageSizeCost = 1.75;

            } else {
                beverageSizeCost = 1.50;
            }
        } else if (binding.rgSizeOfBeverage.getCheckedRadioButtonId() == R.id.rdMedium) {
            beverageSize = "Medium";
            if (binding.rgTypeOfBeverage.getCheckedRadioButtonId() == R.id.rdCoffee){
                beverageSizeCost = 2.75;
            } else {
                beverageSizeCost = 2.50;
            }
        } else if (binding.rgSizeOfBeverage.getCheckedRadioButtonId() == R.id.rdLarge) {
            beverageSize = "Large";
            if (binding.rgTypeOfBeverage.getCheckedRadioButtonId() == R.id.rdCoffee){
                beverageSizeCost = 3.75;
            } else {
                beverageSizeCost = 3.25;
            }
        } else {
            beverageCost = 0;
        }
        Log.d("BeverageCost", "Beverage Size Cost: " + beverageSizeCost);
    }

    // Form validation
    private  boolean formValidated(){
        // name
        if (binding.edtName.length() == 0){
            binding.edtName.setError("This field is required");
            return false;
        }
        // email
        if (!binding.edtEmail.getText().toString().contains("@")){
            binding.edtEmail.setError("Enter valid email");
            return false;
        }
        // phone number
        if (binding.edtPhoneNo.length() < 10 ){
            binding.edtPhoneNo.setError("Enter valid phone number");
            return false;
        }
        // radio button
        if (!binding.rdSmall.isChecked() && !binding.rdMedium.isChecked() && !binding.rdLarge.isChecked()){
            Toast.makeText(getApplicationContext(), "Select beverage size", Toast.LENGTH_LONG).show();
            binding.rdSmall.setError("Select at least one");
            binding.rdMedium.setError("Select at least one");
            binding.rdLarge.setError("Select at least one");
            return false;
        }  else {
            // clearing error when at least one radio button is checked
            binding.rdSmall.setError(null);
            binding.rdMedium.setError(null);
            binding.rdLarge.setError(null);
        }
        // region
        if (binding.acSelectRegion.length() == 0){
            binding.acSelectRegion.setError("This field is required");
            return false;
        }
        // date
        if (binding.edtDate.length() == 0){
            binding.edtDate.setError("This field is required");
            return false;
        } else {
            binding.edtDate.setError(null);
        }
        return true;
    }
}