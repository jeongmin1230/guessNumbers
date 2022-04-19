package com.example.guessnumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//컴퓨터는 0~100사이의 랜덤값을 지정하고 1~100 사이의 값을 사용자가 입력하면
//그것에 대한 결과를 알려준다.
//컴퓨터가 생각한 값과 사용자의 입력값이 같으면 시도한 횟수를 함께 출력한다.
public class MainActivity extends AppCompatActivity {

    // 1~100사이의 랜덤 값 발생시키기
    int computerRandom = (int)(Math.random() * 101);

    // 사용자가 입력한 EditText 값 가져오기 위해 선언
    EditText etEnterNumber;
    // 컴퓨터가 지정한 랜덤값과 사용자 입력 값 비교, 시도 횟수, 입력 숫자, 코멘트 출력 하기 위해 선언
    TextView tvComputerSays, tvTryCount, tvInputNumber, tvCompareComments;

    int count = 1; // 시도 횟수를 출력하기 위해 count 변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("jeongmin", "computerRandom : " + computerRandom); // 랜덤 수 잘 나오는 지 로그로 출력하여 확인
    }

    public void onClickDecide(View view) {
        etEnterNumber = (EditText) findViewById(R.id.etEnterNumber);
        tvComputerSays = (TextView) findViewById(R.id.tvComputerSays);
        tvTryCount = (TextView) findViewById(R.id.tvTryCount);
        tvInputNumber = (TextView) findViewById(R.id.tvInputNumber);
        tvCompareComments = (TextView) findViewById(R.id.tvCompareComments);

        int comparison = Integer.parseInt(etEnterNumber.getText().toString()); // etEnterNumber 를 toString 으로 문자열로 받아 다시 정수로 변환

        if(comparison == computerRandom) {
            tvComputerSays.setText("정답입니다.");
            Log.i("jeongmin", "정답");
            tvTryCount.setText("시도 횟수 : " + count + "회");
            tvInputNumber.append(etEnterNumber.getText().toString() + "\n");
            tvCompareComments.append("정답입니다.");
            etEnterNumber.setText("");
        } else if(comparison < computerRandom) {
            tvComputerSays.setText("더 큰 수를 입력하세요.");
            Log.i("jeongmin", "더 큰 수 입력");
            tvInputNumber.append(etEnterNumber.getText().toString() + "\n");
            tvCompareComments.append("더 큰 수를 입력하세요.\n");
            etEnterNumber.setText("");
        } else if(comparison > computerRandom) {
            tvComputerSays.setText("더 작은 수를 입력하세요.\n");
            Log.i("jeongmin", "더 작은 수 입력");
            tvInputNumber.append(etEnterNumber.getText().toString() + "\n");
            tvCompareComments.append("더 작은 수를 입력하세요.\n");
            etEnterNumber.setText("");
        }
        ++count; // 시도 할 때마다 count 수 증가
    }
}