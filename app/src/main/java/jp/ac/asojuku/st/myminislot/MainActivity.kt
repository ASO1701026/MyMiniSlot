package jp.ac.asojuku.st.myminislot

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatViewInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity() {

    var MYCOIN = 0;
    var KCOIN = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onResume() {
        super.onResume()

        // 共有プリファレンス
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        MYCOIN = pref.getInt("MY_COIN",1000);
        KCOIN = pref.getInt("K_COIN",10);

        my_money.setText(Integer.toString(MYCOIN))
        kcoin.setText(Integer.toString(KCOIN))

        // Upボタン押された
        Up.setOnClickListener{onUpButtonTapped()}
        // Downボタン押された
        Down.setOnClickListener{onDownButtonTapped()}

        Start_btn.setOnClickListener{onStart_btnButtonTapped(it)}

        Reset.setOnClickListener{onResetButtonTapped()}
    }

    fun onUpButtonTapped(){
        KCOIN=KCOIN+10;
        kcoin.setText(Integer.toString(KCOIN))
    }
    fun onDownButtonTapped(){
        KCOIN=KCOIN-10;
        kcoin.setText(Integer.toString(KCOIN))
    }


    fun onStart_btnButtonTapped(view: View?){
        val intent = Intent(this,GameActivity::class.java)
        intent.putExtra("MY_COIN",MYCOIN).putExtra("K_COIN",KCOIN)
        startActivity(intent)
    }

    fun onResetButtonTapped(){
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor.clear().apply()
        MYCOIN = 1000;
        my_money.setText(Integer.toString(1000))
    }

}
