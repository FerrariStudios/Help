package com.example.HackTJ_Help;

import android.content.Context;
import android.graphics.*;
import android.inputmethodservice.Keyboard;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Matthew Ferrari on 5/21/2016.
 */
public class DrawView extends View {
    int x=0;
    int a=255;
    float y=20;
    float j=20;
    float m=20;
    float z=20;
    int wait=0;
    int eX=-1;
    int eY=-1;
    int sX=-1;
    int sY=-1;
    int mX=-1;
    int mY=-1;
    int jX=-1;
    int jY=-1;
    boolean app =true;
    private Bitmap logoBmp;
    private Bitmap homeBmp;
    private Bitmap ambulanceBmp;
    private Bitmap fireAlertBmp;
    private Bitmap helpfireBmp;
    private Bitmap helphospitalsBmp;
    private Bitmap helppoliceBmp;
    private Bitmap helpstandardBmp;
    private Bitmap alertBmp;
    boolean firefight=true;
    boolean pol=true;
    boolean amb=true;
    private Bitmap PoliceAlertBmp;
    private Bitmap fireBmp;
    private Bitmap policeBmp;
    boolean homeScreen=true;
    boolean loadDone=false;
    private Bitmap nmfire;
    private Bitmap nmpolice;
    private Bitmap nmhospital;
    private Bitmap introBmp;
    private Bitmap hospitalalertBmp;

    public DrawView(Context context)
    {
        super(context);
        logoBmp = BitmapFactory.decodeResource(getResources(), R.drawable.helplogo);
        homeBmp = BitmapFactory.decodeResource(getResources(), R.drawable.home);
        fireBmp = BitmapFactory.decodeResource(getResources(), R.drawable.fire);
        policeBmp = BitmapFactory.decodeResource(getResources(), R.drawable.police);
        ambulanceBmp = BitmapFactory.decodeResource(getResources(), R.drawable.ambulance);
        fireAlertBmp = BitmapFactory.decodeResource(getResources(), R.drawable.firealert);
        PoliceAlertBmp = BitmapFactory.decodeResource(getResources(), R.drawable.policealert);
        alertBmp = BitmapFactory.decodeResource(getResources(), R.drawable.alert);
        helpfireBmp = BitmapFactory.decodeResource(getResources(), R.drawable.helpfire);
        helppoliceBmp = BitmapFactory.decodeResource(getResources(), R.drawable.helppolice);
        helphospitalsBmp = BitmapFactory.decodeResource(getResources(), R.drawable.helphospitals);
        helpstandardBmp = BitmapFactory.decodeResource(getResources(), R.drawable.helpstandard);
        nmfire = BitmapFactory.decodeResource(getResources(), R.drawable.nmfire);
        nmpolice = BitmapFactory.decodeResource(getResources(), R.drawable.nmpolice);
        nmhospital = BitmapFactory.decodeResource(getResources(), R.drawable.nmhospital);
        introBmp = BitmapFactory.decodeResource(getResources(), R.drawable.intro);
        hospitalalertBmp = BitmapFactory.decodeResource(getResources(), R.drawable.hospitalalert);


    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(Color.WHITE);
        load(canvas);
        RectF alertrect = Draw.createRectF(0, 0, 100, 22, canvas);
        RectF home = Draw.createRectF(85, 90, 100, 100, canvas);
        RectF logo = Draw.createRectF(24, 19, 76, 56, canvas);
        Paint cool = new Paint();
        Paint blue = new Paint();
        RectF introdesc = Draw.createRectF(5, 60, 95, 73, canvas);
        blue.setColor(Color.rgb(7, 30, 165));

        if (wait > 560) {
            RectF fire = Draw.createRectF(0, 75, 33, 100, canvas);
            RectF police = Draw.createRectF(34, 75, 67, 100, canvas);
            RectF ambulance = Draw.createRectF(68, 75, 100, 100, canvas);
            RectF alert = Draw.createRectF(2, 65, 98, 100, canvas);
            RectF nmap = Draw.createRectF(0, 0, 100, 64, canvas);

            if (app) {
                if (homeScreen) {
                    canvas.drawBitmap(fireBmp, null, fire, null);
                    canvas.drawBitmap(policeBmp, null, police, null);
                    canvas.drawBitmap(ambulanceBmp, null, ambulance, null);

                    RectF mapstandard = Draw.createRectF(0, 0, 100, 75, canvas);
                    canvas.drawBitmap(helpstandardBmp, null, mapstandard, null);
                }
                if (fire.contains(eX, eY) && firefight) {
                    pol = false;
                    amb = false;
                    homeScreen = false;
                    RectF mapfire = Draw.createRectF(0, 22, 100, 100, canvas);
                    canvas.drawBitmap(helpfireBmp, null, mapfire, null);
                    canvas.drawBitmap(alertBmp, null, alertrect, null);

                }

                if (alertrect.contains(eX, eY) && firefight) {
                    RectF bar = Draw.createRectF(10, 10, j, 15, canvas);

                        if (j < 20)
                        {
                            canvas.drawRoundRect(bar, 8, 8, blue);
                            j += .5;
                            canvas.drawBitmap(logoBmp, null, logo, cool);
                            canvas.drawBitmap(introBmp, null, introdesc, blue);
                            invalidate();
                        }
                        else if (j < 22)
                        {
                            canvas.drawRoundRect(bar, 8, 8, blue);
                            j += .05;
                            canvas.drawBitmap(logoBmp, null, logo, cool);
                            canvas.drawBitmap(introBmp, null, introdesc, blue);
                            invalidate();
                        }
                        else if (j < 40)
                        {
                            canvas.drawRoundRect(bar, 8, 8, blue);
                            j += 1;
                            canvas.drawBitmap(introBmp, null, introdesc, blue);
                            canvas.drawBitmap(logoBmp, null, logo, cool);
                            invalidate();
                        }
                        else if (j < 60)
                        {
                            canvas.drawRoundRect(bar, 8, 8, blue);
                            j += 2;
                            canvas.drawBitmap(introBmp, null, introdesc, blue);
                            canvas.drawBitmap(logoBmp, null, logo, cool);
                            invalidate();
                        }
                        else if (j < 90)
                        {
                            canvas.drawRoundRect(bar, 8, 8, blue);
                            j += .5;
                            canvas.drawBitmap(introBmp, null, introdesc, blue);
                            canvas.drawBitmap(logoBmp, null, logo, cool);
                            invalidate();
                        }
                        else {
                            canvas.drawBitmap(fireAlertBmp, null, alert, null);
                            canvas.drawBitmap(homeBmp, null, home, null);
                            canvas.drawBitmap(nmfire, null, nmap, null);
                        }
                }
                if (police.contains(eX, eY) && pol) {
                    firefight = false;
                    amb = false;
                    homeScreen = false;
                    RectF mappolice = Draw.createRectF(0, 22, 100, 100, canvas);
                    canvas.drawBitmap(helppoliceBmp, null, mappolice, null);
                    canvas.drawBitmap(alertBmp, null, alertrect, null);
                }
                if (alertrect.contains(eX, eY) && pol) {
                    RectF bar = Draw.createRectF(10, 10, m, 15, canvas);

                    if (m < 20) {
                        canvas.drawRoundRect(bar, 8, 8, blue);
                        m += .5;
                        canvas.drawBitmap(logoBmp, null, logo, cool);
                        canvas.drawBitmap(introBmp, null, introdesc, blue);
                        invalidate();
                    } else if (m < 22) {
                        canvas.drawRoundRect(bar, 8, 8, blue);
                        m += .05;
                        canvas.drawBitmap(logoBmp, null, logo, cool);
                        canvas.drawBitmap(introBmp, null, introdesc, blue);
                        invalidate();
                    } else if (m < 40) {
                        canvas.drawRoundRect(bar, 8, 8, blue);
                        m += 1;
                        canvas.drawBitmap(introBmp, null, introdesc, blue);
                        canvas.drawBitmap(logoBmp, null, logo, cool);
                        invalidate();
                    } else if (m < 60) {
                        canvas.drawRoundRect(bar, 8, 8, blue);
                        m += 2;
                        canvas.drawBitmap(introBmp, null, introdesc, blue);
                        canvas.drawBitmap(logoBmp, null, logo, cool);
                        invalidate();
                    } else if (m < 90) {
                        canvas.drawRoundRect(bar, 8, 8, blue);
                        m += .5;
                        canvas.drawBitmap(introBmp, null, introdesc, blue);
                        canvas.drawBitmap(logoBmp, null, logo, cool);
                        invalidate();
                    } else {
                        canvas.drawBitmap(PoliceAlertBmp, null, alert, null);
                        canvas.drawBitmap(homeBmp, null, home, null);
                        canvas.drawBitmap(nmpolice, null, nmap, null);


                    }
                }
                if (ambulance.contains(eX, eY) && amb) {
                    pol = false;
                    firefight = false;
                    homeScreen = false;
                    RectF maphospital = Draw.createRectF(0, 22, 100, 100, canvas);
                    canvas.drawBitmap(helphospitalsBmp, null, maphospital, null);
                    canvas.drawBitmap(alertBmp, null, alertrect, null);

                }
                if (alertrect.contains(eX, eY) && amb) {
                    RectF bar = Draw.createRectF(10, 10, z, 15, canvas);

                    if (z< 20) {
                        canvas.drawRoundRect(bar, 8, 8, blue);
                        z += .5;
                        canvas.drawBitmap(logoBmp, null, logo, cool);
                        canvas.drawBitmap(introBmp, null, introdesc, blue);
                        invalidate();
                    } else if (z < 22) {
                        canvas.drawRoundRect(bar, 8, 8, blue);
                        z += .05;
                        canvas.drawBitmap(logoBmp, null, logo, cool);
                        canvas.drawBitmap(introBmp, null, introdesc, blue);
                        invalidate();
                    } else if (z < 40) {
                        canvas.drawRoundRect(bar, 8, 8, blue);
                        z += 1;
                        canvas.drawBitmap(introBmp, null, introdesc, blue);
                        canvas.drawBitmap(logoBmp, null, logo, cool);
                        invalidate();
                    } else if (z < 60) {
                        canvas.drawRoundRect(bar, 8, 8, blue);
                        z += 2;
                        canvas.drawBitmap(introBmp, null, introdesc, blue);
                        canvas.drawBitmap(logoBmp, null, logo, cool);
                        invalidate();
                    } else if (z < 90) {
                        canvas.drawRoundRect(bar, 8, 8, blue);
                        z += .5;
                        canvas.drawBitmap(introBmp, null, introdesc, blue);
                        canvas.drawBitmap(logoBmp, null, logo, cool);
                        invalidate();
                    } else {
                        canvas.drawBitmap(hospitalalertBmp, null, alert, null);
                        canvas.drawBitmap(homeBmp, null, home, null);
                        canvas.drawBitmap(nmhospital, null, nmap, null);


                    }
                }
                if (home.contains(eX, eY)) {
                    j=20;
                    m=20;
                    z=20;
                    eX=-1;
                    eY=-1;
                    sX=-1;
                    sY=-1;
                    mX=-1;
                    mY=-1;
                    jX=-1;
                    jY=-1;
                    app=false;
                    app =true;
                    firefight=true;
                    pol=true;
                    amb=true;
                    homeScreen=true;
                    loadDone=false;

                }
                invalidate();
            }


        }
    }

    public void load(Canvas canvas) {
        RectF logo = Draw.createRectF(24, 19, 76, 56, canvas);
        Paint cool = new Paint();
        Paint blue = new Paint();
        RectF introdesc = Draw.createRectF(5, 60, 95, 73, canvas);



        blue.setTextSize(100);
        blue.setColor(Color.rgb(7, 30, 165));
        if (x <= 255)
        {
            cool.setAlpha(x);
            canvas.drawBitmap(logoBmp, null, logo, cool);
            x += 1.0;
            canvas.drawBitmap(introBmp, null, introdesc, blue);
            invalidate();
        }


        RectF bar = Draw.createRectF(10, 75, y, 78, canvas);
        if (x >= 255)
        {
            if (y < 42)
            {
                canvas.drawRoundRect(bar, 8, 8, blue);
                y += .5;
                canvas.drawBitmap(logoBmp, null, logo, cool);
                canvas.drawBitmap(introBmp, null, introdesc, blue);
                invalidate();
            }
            else if (y < 44)
            {
                canvas.drawRoundRect(bar, 8, 8, blue);
                y += .05;
                canvas.drawBitmap(logoBmp, null, logo, cool);
                canvas.drawBitmap(introBmp, null, introdesc, blue);
                invalidate();
            }
            else if (y < 90)
            {
                canvas.drawRoundRect(bar, 8, 8, blue);
                y += .5;
                canvas.drawBitmap(introBmp, null, introdesc, blue);
                canvas.drawBitmap(logoBmp, null, logo, cool);
                invalidate();
            }
        }

        if(y>89)
        {
            loadDone = true;
        }
        RectF baring = Draw.createRectF(10, 75, 90, 78, canvas);
        if(a>2&&loadDone)
        {
            a-=2;
            blue.setAlpha(a);
            canvas.drawBitmap(logoBmp, null, logo, blue);
            canvas.drawRoundRect(baring, 8, 8, blue);
            canvas.drawBitmap(introBmp, null, introdesc, blue);

        }
        wait++;
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        invalidate();
        if (action == MotionEvent.ACTION_UP) {
            eX = -1;
            eY = -1;
            sX = -1;
            sY = -1;
            mX = -1;
            mY = -1;
            jX = -1;
            jY = -1;

            invalidate();
        }


        if (action == MotionEvent.ACTION_DOWN) {


            jX = (int) event.getX();
            jY = (int) event.getX();

            eX = (int) event.getX();
            eY = (int) event.getY();

            sX = (int) event.getX();
            sY = (int) event.getY();


            mX = (int) event.getX();
            mY = (int) event.getY();
            invalidate();
        }
        return false;
    }
}
