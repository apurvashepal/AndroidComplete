
package com.example.cartapplication.UI.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;


import com.example.cartapplication.R;
import com.example.cartapplication.UI.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static androidx.core.content.ContextCompat.checkSelfPermission;


public class RegisterFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    public static final String RTAG = "Registration";
    public static final int PERMISSION_READ_STATE=1;
    private Toolbar mToolbar;
    private View mView;
    private Spinner mCountry, mState;
    private Button mRegister;
    private TelephonyManager tel;
    EditText Imei1, Imei2;
    private List<String> countryList = new ArrayList<>();
    private List<String> stateList1 = new ArrayList<>();
    private List<String> stateList2 = new ArrayList<>();
    private ArrayAdapter<String> adapterState;
    ArrayAdapter adapter;
    EditText mName, mAge, mContact, mpassword, mAadhar, IMEI1, IMEI2;

    @Nullable

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.registration, container, false);

        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar = mView.findViewById(R.id.toolbar);
        mName =  mView.findViewById(R.id.r_name);
        mAge = mView.findViewById(R.id.r_age);
        mpassword=mView.findViewById(R.id.r_password);
        mContact = mView.findViewById(R.id.r_contact);
        mRegister = mView.findViewById(R.id.btn_Register);
        mCountry = mView.findViewById(R.id.r_country);
        mState = mView.findViewById(R.id.r_state);
        IMEI1=mView.findViewById(R.id.r_imei1);
        mAadhar=mView.findViewById(R.id.r_aadhar_number);
        addListenerOnSpinnerItemSelection();
        setimei();
        mRegister.setOnClickListener(this);




    }

    private void setimei() {
        //Code for IMEI Fetching

        //CheckPermission for Reading the Phone State.
        //Dangerous Permission are restricted by Android and USer can revoke the Permission so generating run time Permission .
        if (checkSelfPermission(this.getActivity(), Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            // We do not have this permission. Let's ask the user
            ActivityCompat.requestPermissions(this.getActivity(), new String[]{Manifest.permission.READ_PHONE_STATE}, PERMISSION_READ_STATE);
        }
        TelephonyManager telephonyManager = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();  //Storing the IMEI Number.
        IMEI1.setText(imei);

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_READ_STATE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted!
                    // you may now do the action that requires this permission
                } else {
                    // permission denied
                }
                return;
            }
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Register:
                if (isValid()) {
                    Toast.makeText(getActivity(), "Done!", Toast.LENGTH_LONG).show();
                }
                else
                    Utils.AlertBox(getActivity(), getString(R.string.d_title), getString(R.string.d_message));
                break;


            default:
        }
    }







    private boolean isValid() {
        String name,age,password,contact, aadhar;
        name=mName.getText().toString();
        age= mAge.getText().toString();
        aadhar =mAadhar.getText().toString();
        password= mpassword.getText().toString();
        contact= mContact.getText().toString();
            if (name.isEmpty()) {
                Utils.AlertBox(getActivity(), getString(R.string.d_title), getString(R.string.d_message));
            }
        if (age.isEmpty())
            Utils.AlertBox(getActivity(), getString(R.string.d_title), getString(R.string.d_message));
        if (aadhar.isEmpty())
            Utils.AlertBox(getActivity(), getString(R.string.d_title), getString(R.string.d_message));
        if (password.isEmpty())
            Utils.AlertBox(getActivity(), getString(R.string.d_title), getString(R.string.d_message));
        if (contact.isEmpty())
            Utils.AlertBox(getActivity(), getString(R.string.d_title), getString(R.string.d_message));
        else
            return false;
        return true;
    }


    private void addListenerOnSpinnerItemSelection() {

        countryList = Arrays.asList(getResources().getStringArray(R.array.country_array));
        adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item,countryList);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mCountry.setAdapter(adapter);

        mCountry.setOnItemSelectedListener(this);
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String country = adapter.getItem(i).toString();
        if (country.equals("India")) {
            stateList1 = Arrays.asList(getResources().getStringArray(R.array.state_array_India));
            adapterState = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, stateList1);
            adapterState.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            mState.setAdapter(adapterState);
        }
        if (country.equals("ShriLanka")) {
            stateList2 = Arrays.asList(getResources().getStringArray(R.array.state_array_ShriLanka));
            adapterState = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, stateList2);
            adapterState.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            mState.setAdapter(adapterState);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}

