package jp.ac.asojuku.st.myminislot

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GameActivity : AppCompatActivity() {

    val pref=null;
    var MYCOIN = 0;
    var KCOIN = 0;
    var wc = 0;

    val imageArray:Array<Int> = arrayOf(
            R.drawable.s_banana,
            R.drawable.s_bar,
            R.drawable.s_bigwin,
            R.drawable.s_cherry,
            R.drawable.s_grape,
            R.drawable.s_lemon,
            R.drawable.s_orange,
            R.drawable.s_seven,
            R.drawable.s_waltermelon
    );

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val pref = PreferenceManager.getDefaultSharedPreferences(this)

        back.setOnClickListener{finish()}

        MYCOIN = intent.getIntExtra("MY_COIN",0);
        KCOIN = intent.getIntExtra("K_COIN",0);
        MYCOIN = MYCOIN-KCOIN
        myCoin.setText((MYCOIN).toString());
        betCoin.setText((KCOIN).toString());

        Go_btn.setOnClickListener {
            val a = (Math.random()*9).toInt();
            val b = (Math.random()*9).toInt();
            val c = (Math.random()*9).toInt();

            hatena1.setImageResource(imageArray[a]);
            hatena2.setImageResource(imageArray[b]);
            hatena3.setImageResource(imageArray[c]);
            val editor = pref.edit()
            if (a==b && b==c){
                when (a){
                    0->{
                        wc = KCOIN*2
                        MYCOIN = MYCOIN + wc;
                        editor.putInt("MY_COIN",MYCOIN).apply()
                        myCoin.setText((MYCOIN).toString())
                    }
                    1->{
                        wc = KCOIN*5
                        MYCOIN = MYCOIN + wc;
                        editor.putInt("MY_COIN",MYCOIN).apply()
                        myCoin.setText((MYCOIN).toString())
                    }
                    2-> {
                        wc = KCOIN * 10
                        MYCOIN = MYCOIN + wc;
                        editor.putInt("MY_COIN", MYCOIN).apply()
                        myCoin.setText((MYCOIN).toString())
                    }
                    3->{
                        wc = KCOIN*2
                        MYCOIN = MYCOIN + wc;
                        editor.putInt("MY_COIN",MYCOIN).apply()
                        myCoin.setText((MYCOIN).toString())
                    }
                    4->{
                        wc = KCOIN*2
                        MYCOIN = MYCOIN + wc;
                        editor.putInt("MY_COIN",MYCOIN).apply()
                        myCoin.setText((MYCOIN).toString())
                    }
                    5->{
                        wc = KCOIN*2
                        MYCOIN = MYCOIN + wc;
                        editor.putInt("MY_COIN",MYCOIN).apply()
                        myCoin.setText((MYCOIN).toString())
                    }
                    6->{
                        wc = KCOIN*20
                        MYCOIN = MYCOIN + wc;
                        editor.putInt("MY_COIN",MYCOIN).apply()
                        myCoin.setText((MYCOIN).toString())
                    }
                    7->{
                        wc = KCOIN*2
                        MYCOIN = MYCOIN + wc;
                        editor.putInt("MY_COIN",MYCOIN).apply()
                        myCoin.setText((MYCOIN).toString())
                    }
                    8->{
                        wc = KCOIN*2
                        MYCOIN = MYCOIN + wc;
                        editor.putInt("MY_COIN",MYCOIN).apply()
                        myCoin.setText((MYCOIN).toString())
                    }

                }
            }
            else if(a==b||a==c||b==c){

                when(a or b){
                    0,1,2,3,4,5,6,8->{
                        wc = KCOIN*1
                        MYCOIN = MYCOIN + wc;
                        editor.putInt("MY_COIN",MYCOIN).apply()
                        myCoin.setText((MYCOIN).toString())
                    }
                    7->{
                        wc = KCOIN*3
                        MYCOIN = MYCOIN + wc;
                        editor.putInt("MY_COIN",MYCOIN).apply()
                        myCoin.setText((MYCOIN).toString())
                    }
                }
            }
            else if(a != b || a != c || b != c) {

                if(a ==8 || b==8 || c ==8){
                  1111  wc = KCOIN * 1
                    MYCOIN = MYCOIN + wc;
                    editor.putInt("MY_COIN", MYCOIN).apply()
                    myCoin.setText((MYCOIN).toString())
                }
                else{
                    MYCOIN = MYCOIN - KCOIN
                    editor.putInt("MY_COIN", MYCOIN).apply()
                    myCoin.setText((MYCOIN).toString())
                }
            }
            else if (a == 4 && b == 3 && c ==5){
                wc = KCOIN * 30
                MYCOIN = MYCOIN + wc;
                editor.putInt("MY_COIN", MYCOIN).apply()
                myCoin.setText((MYCOIN).toString())

            }
             else if (a == 8 && b == 0 && c == 4){
                wc = KCOIN * 10
                MYCOIN = MYCOIN + wc;
                editor.putInt("MY_COIN", MYCOIN).apply()
                myCoin.setText((MYCOIN).toString())

            }

        }


    }
    /*
    fun onbackButtonTapped(view: View?){
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("MY_COIN",MYCOIN).putExtra("K_COIN",KCOIN)
        startActivity(intent)
    }
    */


}