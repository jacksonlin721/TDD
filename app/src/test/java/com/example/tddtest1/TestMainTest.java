package com.example.tddtest1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TestMainTest {

    TestMain sut;
    @Mock
    OnCallback mockOnCallback;
    @Mock
    ITest mockTest;
    @Captor
    ArgumentCaptor<OnCallback> onCallbackArgumentCaptor;
    @Captor
    ArgumentCaptor<Integer> integerArgumentCaptor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        sut = new TestMain(mockTest);
    }

    @Test
    public void testCallback_noReturned() {
        int input = 2;

        sut.handleNumber(input, mockOnCallback);
        verify(mockOnCallback).onEvenCall(integerArgumentCaptor.capture());
        System.out.print("[testCallback_noReturned] ac2 value= "+integerArgumentCaptor.getValue());
        int expect = 4;
        int result = integerArgumentCaptor.getValue();
        assertEquals(expect, result);
    }

    @Test
    public void testAnswer() {
        MockitoAnnotations.openMocks(this);

        OnCallback onCallback = new OnCallback() {
            @Override
            public void onEvenCall(int output) {
                System.out.print("[testAnswer] output value= "+output);
                assertEquals(6, output);
            }

            @Override
            public void onOddCall(int output) {

            }
        };

        ArgumentCaptor<Integer> ac2 = ArgumentCaptor.forClass(Integer.class);
        TestMain mockTest = mock(TestMain.class);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                OnCallback mOnCallback = (OnCallback) invocation.getArguments()[1];
                mOnCallback.onEvenCall(2 * 3);
                return null;
            }
        }).when(mockTest).handleNumber2(anyInt(), any(OnCallback.class));


        sut.handleNumber2(2, onCallback);
        /*System.out.print("[testCallback_noReturned] ac2 value= "+ac2.getValue());
        int expect = 4;
        int result = ac2.getValue();
        assertEquals(expect, result);*/
    }
}