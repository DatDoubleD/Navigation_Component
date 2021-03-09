package com.doanducdat.nvgcomponent

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_deep_link.*


class DeepLinkFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_deep_link, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // nhận data từ thẻ "argument có defauvalue =doanducdat" trong nav_graph
        val bundle: Bundle? = arguments
        txtNhan.text = bundle?.getString("argDeepLink") //name của thẻ argument

        //click push notifi
        btnPushNotificaiton.setOnClickListener {
            //đặt trùngtên bundle -> KHI MỞ APP -> LOAD BUNDLE CỦA THẺ ARGUMENT , KHI NHẤN NOTIFI SẼ LOAD BUNDLE CỦA PUSH NOTIFILE NÀY
            val bundlePush: Bundle = bundleOf("argDeepLink" to edtPush.text.toString())
            pushNotification(bundlePush)
        }
    }

    private fun pushNotification(bundlePush: Bundle) {
        val CHANNEL_ID:String = "DeepLink"
        val notificationManager = context?.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        // Create the NotificationChannel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(
                NotificationChannel(CHANNEL_ID, "Deep links", NotificationManager.IMPORTANCE_HIGH)
            )
        }

        //pending intent for notificaiton
        val pendingIntent = findNavController().createDeepLink().setGraph(R.navigation.nav_graph)
            .setDestination(R.id.deepLinkFragment)
            .setArguments(bundlePush)
            .createPendingIntent()

        //create notification config
        val builder = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setContentTitle("Navigation")
            .setContentText("Deel link navigation component")
            .setSmallIcon(R.drawable.ic_notificaiton)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        notificationManager.notify(0, builder.build())
    }
}