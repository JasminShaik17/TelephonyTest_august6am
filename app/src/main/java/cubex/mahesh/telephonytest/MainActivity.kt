package cubex.mahesh.telephonytest

import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        send_sms.setOnClickListener {

            var sintent = Intent(this@MainActivity,
                                SendActivity::class.java)
            var dintent = Intent(this@MainActivity,
                    DeliverActivity::class.java)
            var psintent = PendingIntent.getActivity(
                    this@MainActivity,0,
                    sintent,0)
            var pdintent = PendingIntent.getActivity(
                    this@MainActivity,0,
                    dintent,0)
            var list = et1.text.toString().split(",")
            for(num in list) {
                var sManager = SmsManager.getDefault()
                sManager.sendTextMessage(num, null,
                        et2.text.toString(), psintent, pdintent)
            }

        }

        call.setOnClickListener {

            var i = Intent()
            i.action = Intent.ACTION_CALL
            i.data = Uri.parse("tel:"+et1.text.toString())
            startActivity(i)

        }

    }
}
