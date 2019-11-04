package com.android.AndroidVideoPlayer;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


public class AndroidVideoPlayer extends Activity  {

	MediaPlayer mediaPlayer;
	SurfaceView surfaceView;
	SurfaceHolder surfaceHolder;
	MediaController mediac;
	boolean pausing = false;;
	private quizLib mquiz= new quizLib();

	private TextView mScoreView;
	private TextView mQuestionView;
	private Button mChoice1;
	private Button mchoice2;
	private Button mchoice3;

	private String mAnswer;
	private int mScore=0;
	private int mQuestioNumber=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        getWindow().setFormat(PixelFormat.UNKNOWN);

                mediac = new MediaController(this);

                 VideoView mVideoView = (VideoView) findViewById(R.id.videoview);



                String uriPath = "android.resource://com.android.AndroidVideoPlayer/" + R.raw.my_video12;
                Uri uri = Uri.parse(uriPath);
                mVideoView.setVideoURI(uri);
                mVideoView.requestFocus();
                mVideoView.start();
                mediac.setAnchorView(mVideoView);
                mVideoView.setMediaController(mediac);

        mScoreView =(TextView)findViewById(R.id.score);
        mQuestionView =(TextView)findViewById(R.id.question);
        mChoice1 =(Button) findViewById(R.id.choice1);
        mchoice2 =(Button) findViewById(R.id.choice2);
        mchoice3 =(Button)findViewById(R.id.choice3);
        updatequest();
        mChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mChoice1.getText()==mAnswer){
                    mScore =mScore+1;
                    updateScore(mScore);
                    updatequest();
                    Toast.makeText(AndroidVideoPlayer.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AndroidVideoPlayer.this,"Wrong",Toast.LENGTH_SHORT).show();
                }
            }


        });

        mchoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mchoice2.getText()==mAnswer){
                    mScore =mScore+1;
                    updateScore(mScore);
                    updatequest();
                    Toast.makeText(AndroidVideoPlayer.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AndroidVideoPlayer.this,"Wrong",Toast.LENGTH_SHORT).show();
                }
            }


        });


        mchoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mchoice3.getText()==mAnswer){
                    mScore =mScore+1;

                    updateScore(mScore);
                    updatequest();
                    Toast.makeText(AndroidVideoPlayer.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AndroidVideoPlayer.this,"Wrong",Toast.LENGTH_SHORT).show();
                }
            }


        });
    }

    private void updatequest(){
        mQuestionView.setText(mquiz.getQuestion(mQuestioNumber));
        mChoice1.setText(mquiz.getchoice1(mQuestioNumber));
        mchoice2.setText(mquiz.getchoice2(mQuestioNumber));
        mchoice3.setText(mquiz.getchoice3(mQuestioNumber));

        mAnswer= mquiz.getcorrectanswer(mQuestioNumber);
        mQuestioNumber++;

    }
    private void updateScore(int point) {
        mScoreView.setText(""+mScore);

    }
}
