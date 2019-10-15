package com.example.gangssam_ex_project;

public class inter_test{
    private  TestCallback callback;

    public void setCallback(TestCallback callback) {
        this.callback = callback;
    }
    public interface  TestCallback{
        void onComplate();
    }
}
