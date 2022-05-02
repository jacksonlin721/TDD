package com.example.tddtest1;

public class TestMain {
    public int input = 2;
    public int result;
    ITest test;

    public TestMain(ITest test) {
        this.test = test;
    }

    public void handleNumber(int input) {

        test.testCallback(2, new OnCallback() {
            @Override
            public void onEvenCall(int output) {
                handleEvenNumber(output);
            }

            @Override
            public void onOddCall(int output) {
                handleOddNumber(output);
            }
        });
    }

    public void handleNumber(int input, OnCallback onCallback) {
        if (input % 2 == 0) {
            int input1 = input * 2;
            onCallback.onEvenCall(input1);
        } else {
            int input1 = input * -2;
            onCallback.onOddCall(input1);
        }
    }

    public void handleNumber2(int input, OnCallback onCallback) {
        if (input % 2 == 0) {
            handleEvenNumber(input);
        } else {
            handleOddNumber(input);
        }
    }

    public void handleEvenNumber(int input) {
        result = input * 2;
    }

    public void handleOddNumber(int input) {
        result = input * -2;
    }
}
