package com.rameshcodeworks.recyclerviewwithmultipleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Employee> employeeArrayList;

    private static int TYPE_CALL = 1;
    private static int TYPE_EMAIL = 2;

    public EmployeeAdapter(Context context, ArrayList<Employee> employeeArrayList) {
        this.context = context;
        this.employeeArrayList = employeeArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view;
        if (viewType == TYPE_CALL) { // for CALL Layout

            view = LayoutInflater.from(context).inflate(R.layout.item_call, viewGroup, false);

            return new CallViewHolder(view);
        } else {
            // for Email Layout
            view = LayoutInflater.from(context).inflate(R.layout.item_email, viewGroup, false);
            return new EmailViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        if (getItemViewType(position) == TYPE_CALL) {
            ((CallViewHolder)viewHolder).setCallDetails(employeeArrayList.get(position));
        } else {
            ((EmailViewHolder)viewHolder).setEmailDetails(employeeArrayList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {

        if (TextUtils.isEmpty(employeeArrayList.get(position).getEmail())) {
            return TYPE_CALL;

        } else {
            return TYPE_EMAIL;
        }
    }

    class CallViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtAddress;

        public CallViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
        }

        private void setCallDetails(Employee employee) {
            txtName.setText(employee.getPhone());
            txtAddress.setText(employee.getEmail());
        }
    }

    class EmailViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtAddress;

        public EmailViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
        }

        private void setEmailDetails(Employee employee) {

            txtName.setText(employee.getPhone());
            txtAddress.setText(employee.getEmail());
        }
    }
}
